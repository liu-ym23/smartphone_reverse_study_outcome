package com.android.internal.chooser.resolver;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.android.internal.chooser.base.ChooserTargetsFinder;
import com.android.internal.chooser.bean.ChooserTargets;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ResolverFinder implements ChooserTargetsFinder {
    private final Comparator<DisplayResolveInfo> mComparator;
    private final Context mContext;
    private final boolean mFilterPriority;
    private final int mLaunchedFromUid;
    private final PackageManager mPackageManager;
    private final boolean mShowAllApp;

    public ResolverFinder(Context context, boolean showAllApp, boolean filterPriority, int launchedFromUid, Comparator<DisplayResolveInfo> comparator) {
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mShowAllApp = showAllApp;
        this.mFilterPriority = filterPriority;
        this.mLaunchedFromUid = launchedFromUid;
        this.mComparator = comparator;
    }

    @Override // com.android.internal.chooser.base.ChooserTargetsFinder
    public ChooserTargets loadResolveInfo(Context context, Intent target, Intent[] initIntents, List<ResolveInfo> rList) {
        List<DisplayResolveInfo> infoList = new ArrayList<>();
        List<ResolveInfo> originList = this.mPackageManager.queryIntentActivities(target, 65600);
        List<ResolveInfo> resolveInfoList = new ArrayList<>();
        if (rList != null) {
            resolveInfoList.addAll(rList);
        }
        resolveInfoList.addAll(originList);
        LogUtils.dumpResolverInfo("queryIntentActivities", resolveInfoList);
        if (!resolveInfoList.isEmpty()) {
            List<ResolveInfo> tmpList = new ArrayList<>(resolveInfoList);
            Utils.isOnlyShowStepOSSystemApp(target, this.mShowAllApp);
            removeUnusedItems(resolveInfoList, false, this.mFilterPriority);
            for (ResolveInfo resolveInfo : resolveInfoList) {
                infoList.add(new DisplayResolveInfo(resolveInfo, (Intent) null));
            }
            if (infoList.isEmpty()) {
                removeUnusedItems(tmpList, false, this.mFilterPriority);
                for (ResolveInfo resolveInfo2 : tmpList) {
                    infoList.add(new DisplayResolveInfo(resolveInfo2, (Intent) null));
                }
            }
        }
        return new ChooserTargets(Collections.emptyList(), infoList, originList);
    }

    @Override // com.android.internal.chooser.base.ChooserTargetsFinder
    public ChooserTargets sortAndLoadDisplayInfo(ChooserTargets target) {
        for (DisplayResolveInfo resolveInfo : target.getInitTarget()) {
            fillDisplayInfo(resolveInfo);
        }
        for (DisplayResolveInfo resolveInfo2 : target.getQueryTarget()) {
            fillDisplayInfo(resolveInfo2);
        }
        target.getQueryTarget().sort(this.mComparator);
        return target;
    }

    private void fillDisplayInfo(DisplayResolveInfo info) {
        info.activityLabel = info.resolveInfo.loadLabel(this.mPackageManager).toString().replace("\n", "");
        info.appLabel = info.resolveInfo.activityInfo.applicationInfo.loadLabel(this.mPackageManager).toString().replace("\n", "");
        info.isSystem = Utils.isSystemApp(info.resolveInfo);
        info.isFavorite = true;
        info.isRecommend = RecommendApp.isRecommendApp(info.resolveInfo);
    }

    private void removeUnusedItems(List<ResolveInfo> list, boolean systemAppOnly, boolean filterPriority) {
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
            if (filterPriority && base != null && (base.priority != resolveInfo.priority || base.isDefault != resolveInfo.isDefault)) {
                if (!TextUtils.equals("com.android.documentsui.picker.PickActivity", resolveInfo.activityInfo.name) && !TextUtils.equals("com.stepos.media.gallery.AlbumManagerActivity", resolveInfo.activityInfo.name)) {
                    iterable.remove();
                    LogUtils.d(String.format(Locale.getDefault(), "removePriority: base.priority=%d, current.priority=%d, base.isDefault=%b, current.isDefault=%b, %s", Integer.valueOf(base.priority), Integer.valueOf(resolveInfo.priority), Boolean.valueOf(base.isDefault), Boolean.valueOf(resolveInfo.isDefault), resolveInfo));
                }
            } else {
                ActivityInfo ai = resolveInfo.activityInfo;
                int granted = ActivityManager.checkComponentPermission(ai.permission, this.mLaunchedFromUid, ai.applicationInfo.uid, ai.exported);
                if (granted != 0) {
                    iterable.remove();
                    LogUtils.d("removePermission: " + resolveInfo);
                } else if (systemAppOnly && !Utils.isSystemApp(resolveInfo)) {
                    iterable.remove();
                    LogUtils.d("removeNonSystemApp: " + resolveInfo);
                } else {
                    String key = resolveInfo.activityInfo.packageName + resolveInfo.activityInfo.name;
                    if (map.contains(key)) {
                        iterable.remove();
                        LogUtils.d("removeSame: " + resolveInfo);
                    } else {
                        map.add(key);
                    }
                }
            }
        }
    }
}
