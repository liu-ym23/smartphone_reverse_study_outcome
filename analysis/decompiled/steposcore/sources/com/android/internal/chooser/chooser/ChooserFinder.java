package com.android.internal.chooser.chooser;

import android.content.Context;
import android.content.Intent;
import android.content.IntentExt;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.BuildExt;
import android.os.UserHandle;
import com.android.internal.chooser.base.ChooserTargetsFinder;
import com.android.internal.chooser.bean.ChooserTargets;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.db.ChooserItem;
import com.android.internal.chooser.db.ChooserRepository;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes.dex */
public class ChooserFinder implements ChooserTargetsFinder {
    private Context mContext;
    private boolean mIsDisableShareVcard;
    private PackageManager mPackageManager;

    public ChooserFinder(Context context, boolean isDisableXVCard) {
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mIsDisableShareVcard = isDisableXVCard;
    }

    @Override // com.android.internal.chooser.base.ChooserTargetsFinder
    public ChooserTargets loadResolveInfo(Context context, Intent target, Intent[] initIntents, List<ResolveInfo> rList) {
        List<DisplayResolveInfo> initialInfo = buildListFromInitialIntent(initIntents);
        List<DisplayResolveInfo> infoList = new ArrayList<>();
        Intent queryIntent = new Intent(target);
        int currentUserId = this.mContext.getUserId();
        List resolveInfoList = this.mPackageManager.queryIntentActivitiesAsUser(queryIntent, IntentExt.STEPOS_FLAG_SPLIT_MODE, currentUserId);
        if (resolveInfoList == null) {
            resolveInfoList = new ArrayList();
        }
        LogUtils.dumpResolverInfo("queryIntentActivities", resolveInfoList);
        if (resolveInfoList != null && !resolveInfoList.isEmpty()) {
            removeUnusedItems(resolveInfoList, target);
            for (ResolveInfo resolveInfo : resolveInfoList) {
                infoList.add(new DisplayResolveInfo(resolveInfo, (Intent) null));
            }
        }
        return new ChooserTargets(initialInfo, infoList, (List) null);
    }

    @Override // com.android.internal.chooser.base.ChooserTargetsFinder
    public ChooserTargets sortAndLoadDisplayInfo(ChooserTargets target) throws JSONException {
        ChooserRepository repository = ChooserRepository.getInstance(this.mContext);
        boolean customFavorite = repository.useCustomizeFavorite();
        for (DisplayResolveInfo info : target.getInitTarget()) {
            fillDisplayInfo(info, repository, customFavorite);
        }
        for (DisplayResolveInfo info2 : target.getQueryTarget()) {
            fillDisplayInfo(info2, repository, customFavorite);
        }
        ChooserItemComparator comparator = new ChooserItemComparator(this.mContext);
        target.getQueryTarget().sort(comparator);
        return target;
    }

    private void fillDisplayInfo(DisplayResolveInfo info, ChooserRepository repository, boolean customFavorite) throws JSONException {
        info.activityLabel = info.resolveInfo.loadLabel(this.mPackageManager).toString().replace("\n", "");
        info.appLabel = info.resolveInfo.activityInfo.applicationInfo.loadLabel(this.mPackageManager).toString().replace("\n", "");
        ChooserItem chooserItem = repository.getChooserItemInfo(info.resolveInfo);
        info.usageCount = chooserItem.getUsageCount();
        info.isSystem = Utils.isSystemApp(info.resolveInfo);
        info.isDevice = AppInfo.isDevice(info.resolveInfo);
        if (info.isDevice) {
            return;
        }
        if (customFavorite) {
            if (chooserItem.getState() == 1) {
                info.isFavorite = true;
                return;
            }
            if (chooserItem.getState() == 2) {
                info.isFavorite = false;
                return;
            }
            if (AppInfo.isDefaultFavorite(info.resolveInfo) || info.isSystem) {
                info.isFavorite = true;
                chooserItem.setState(1);
                chooserItem.setOrder(repository.getNextOrder());
                repository.updateChooserItemInfo(chooserItem);
                return;
            }
            return;
        }
        if (AppInfo.isDefaultFavorite(info.resolveInfo) || info.isSystem) {
            info.isFavorite = true;
        }
    }

    private List<DisplayResolveInfo> buildListFromInitialIntent(Intent[] list) {
        ActivityInfo ai;
        if (list == null || list.length <= 0) {
            return Collections.emptyList();
        }
        List<DisplayResolveInfo> infoList = new ArrayList<>();
        for (Intent intent : list) {
            if (intent != null && (ai = intent.resolveActivityInfo(this.mPackageManager, 0)) != null && (ai.exported || ai.packageName == null || ai.packageName.equals(this.mContext.getPackageName()))) {
                ResolveInfo ri = new ResolveInfo();
                ri.activityInfo = ai;
                if (intent instanceof LabeledIntent) {
                    LabeledIntent li = (LabeledIntent) intent;
                    ri.resolvePackageName = li.getSourcePackage();
                    ri.labelRes = li.getLabelResource();
                    ri.nonLocalizedLabel = li.getNonLocalizedLabel();
                    ri.icon = li.getIconResource();
                    ri.iconResourceId = li.getIconResource();
                }
                ri.userHandle = UserHandle.of(this.mContext.getUserId());
                infoList.add(new DisplayResolveInfo(ri, intent));
            }
        }
        return infoList;
    }

    private void removeUnusedItems(List<ResolveInfo> list, Intent target) {
        if (list == null) {
            return;
        }
        ResolveInfo base = null;
        if (list.size() >= 1) {
            ResolveInfo base2 = list.get(0);
            base = base2;
        }
        Iterator<ResolveInfo> iterable = list.iterator();
        HashSet<String> map = new HashSet<>();
        while (iterable.hasNext()) {
            ResolveInfo resolveInfo = iterable.next();
            if (base != null && (base.priority != resolveInfo.priority || base.isDefault != resolveInfo.isDefault)) {
                iterable.remove();
                LogUtils.d("removePriority: " + resolveInfo.toString());
            } else if (resolveInfo.targetUserId != -2) {
                iterable.remove();
                LogUtils.d("removeUserId: " + resolveInfo.toString());
            } else {
                ActivityInfo ai = resolveInfo.activityInfo;
                if (!ai.exported) {
                    iterable.remove();
                    LogUtils.d("removeExport: " + resolveInfo.toString());
                } else if (target != null && "text/x-vcard".equals(target.getType()) && "com.sina.weibo".equals(resolveInfo.activityInfo.packageName)) {
                    iterable.remove();
                    LogUtils.d("removeWeiboForVcard: " + resolveInfo.toString());
                } else {
                    String key = resolveInfo.activityInfo.packageName + resolveInfo.activityInfo.name;
                    if (map.contains(key)) {
                        iterable.remove();
                        LogUtils.d("removeSame: " + resolveInfo.toString());
                    } else {
                        map.add(key);
                    }
                    if ("com.stepos.share.BluetoothOppLauncherActivity".equals(resolveInfo.activityInfo.name)) {
                        iterable.remove();
                    }
                    if (BuildExt.isProductInternational() || this.mIsDisableShareVcard) {
                        if ("com.stepos.share.mutual.MutualSendingActivity".equals(resolveInfo.activityInfo.name) && target != null && "text/x-vcard".equals(target.getType())) {
                            iterable.remove();
                        }
                    }
                }
            }
        }
    }
}
