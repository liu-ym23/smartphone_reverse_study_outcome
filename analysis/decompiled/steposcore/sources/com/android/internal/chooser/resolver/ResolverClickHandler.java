package com.android.internal.chooser.resolver;

import android.app.Activity;
import android.app.ActivityThread;
import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentExt;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.PatternMatcher;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.internal.app.ResolverActivity;
import com.android.internal.chooser.ShareStrategy;
import com.android.internal.chooser.base.OnTargetClickHandler;
import com.android.internal.chooser.utils.LogUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class ResolverClickHandler implements OnTargetClickHandler {
    private static final String TAG = "ResolverClickHandler";
    private final ContentResolver mContentResolver;
    private final boolean mIsSetLastChosen;
    private final String mLaunchedFromPackage;
    private final int mLaunchedFromUid;
    private final boolean mSafeForwardingMode;

    public ResolverClickHandler(boolean safeForwardingMode, int launchedFromUid, String launchedFromPackage, boolean isSetLastChosen, Activity activity) {
        this.mSafeForwardingMode = safeForwardingMode;
        this.mLaunchedFromUid = launchedFromUid;
        this.mLaunchedFromPackage = launchedFromPackage;
        this.mIsSetLastChosen = isSetLastChosen;
        this.mContentResolver = activity.getContentResolver();
    }

    @Override // com.android.internal.chooser.base.OnTargetClickHandler
    public void handleClick(Activity activity, Intent intent, ResolveInfo ri, List<ResolveInfo> resolveList, boolean isChecked, boolean quickLook, ShareStrategy shareStrategy) throws IntentFilter.MalformedMimeTypeException {
        Intent filterIntent;
        IntentFilter filter;
        String mimeType;
        if (activity != null && !activity.isFinishing()) {
            IntentFilter filter2 = new IntentFilter();
            if (intent.getSelector() != null) {
                filterIntent = intent.getSelector();
            } else {
                filterIntent = intent;
            }
            String action = filterIntent.getAction();
            if (action != null) {
                filter2.addAction(action);
            }
            Set<String> categories = filterIntent.getCategories();
            if (categories != null) {
                Iterator<String> it = categories.iterator();
                while (it.hasNext()) {
                    filter2.addCategory(it.next());
                }
            }
            filter2.addCategory("android.intent.category.DEFAULT");
            int cat = ri.match & 268369920;
            Uri data = filterIntent.getData();
            if (cat == 6291456 && (mimeType = filterIntent.resolveType(activity)) != null) {
                try {
                    filter2.addDataType(mimeType);
                    filter = filter2;
                } catch (IntentFilter.MalformedMimeTypeException e) {
                    LogUtils.w(e);
                    filter = null;
                }
            } else {
                filter = filter2;
            }
            if (data != null && data.getScheme() != null && (cat != 6291456 || (!"file".equals(data.getScheme()) && !"content".equals(data.getScheme())))) {
                filter.addDataScheme(data.getScheme());
                Iterator<PatternMatcher> pIt = ri.filter.schemeSpecificPartsIterator();
                if (pIt != null) {
                    String ssp = data.getSchemeSpecificPart();
                    while (true) {
                        if (ssp == null || !pIt.hasNext()) {
                            break;
                        }
                        PatternMatcher p = pIt.next();
                        if (p.match(ssp)) {
                            filter.addDataSchemeSpecificPart(p.getPath(), p.getType());
                            break;
                        }
                    }
                }
                Iterator<IntentFilter.AuthorityEntry> aIt = ri.filter.authoritiesIterator();
                if (aIt != null) {
                    while (true) {
                        if (!aIt.hasNext()) {
                            break;
                        }
                        IntentFilter.AuthorityEntry a = aIt.next();
                        if (a.match(data) >= 0) {
                            int port = a.getPort();
                            filter.addDataAuthority(a.getHost(), port >= 0 ? Integer.toString(port) : null);
                        }
                    }
                }
                Iterator<PatternMatcher> pIt2 = ri.filter.pathsIterator();
                if (pIt2 != null) {
                    String path = data.getPath();
                    while (true) {
                        if (path == null || !pIt2.hasNext()) {
                            break;
                        }
                        PatternMatcher p2 = pIt2.next();
                        if (p2.match(path)) {
                            filter.addDataPath(p2.getPath(), p2.getType());
                            break;
                        }
                    }
                }
            }
            if (filter != null && resolveList != null) {
                int N = resolveList.size();
                ComponentName[] set = new ComponentName[N];
                int i = 0;
                int bestMatch = 0;
                while (i < N) {
                    ResolveInfo r = resolveList.get(i);
                    int N2 = N;
                    set[i] = new ComponentName(r.activityInfo.packageName, r.activityInfo.name);
                    if (r.match > bestMatch) {
                        bestMatch = r.match;
                    }
                    i++;
                    N = N2;
                }
                if (isChecked) {
                    Intent tempIntent = new Intent(intent);
                    tempIntent.setComponent(null);
                    ResolveInfo old = activity.getPackageManager().resolveActivity(tempIntent, IntentExt.STEPOS_FLAG_SPLIT_MODE);
                    if (old != null && old.activityInfo != null && !TextUtils.isEmpty(old.activityInfo.packageName) && !"android".equals(old.activityInfo.packageName) && !TextUtils.isEmpty(old.activityInfo.name) && !ResolverActivity.class.getName().equals(old.activityInfo.name)) {
                        try {
                            AppGlobals.getPackageManager().clearPackagePersistentPreferredActivities(old.activityInfo.packageName, UserHandle.myUserId());
                            AppGlobals.getPackageManager().clearPackagePreferredActivities(old.activityInfo.packageName);
                        } catch (RemoteException e2) {
                            LogUtils.e("clearPackagePersistentPreferredActivities error pkg = " + old.activityInfo.packageName);
                        }
                    }
                    try {
                        AppGlobals.getPackageManager().addPersistentPreferredActivity(filter, intent.getComponent(), UserHandle.myUserId());
                    } catch (RemoteException e3) {
                        LogUtils.e("addPersistentPreferredActivity error activity = " + intent.getComponent(), e3);
                    }
                }
                if (this.mIsSetLastChosen) {
                    try {
                    } catch (Exception e4) {
                        e = e4;
                    }
                    try {
                        AppGlobals.getPackageManager().setLastChosenActivity(intent, intent.resolveTypeIfNeeded(activity.getContentResolver()), IntentExt.STEPOS_FLAG_SPLIT_MODE, filter, bestMatch, intent.getComponent());
                    } catch (Exception e5) {
                        e = e5;
                        LogUtils.e("Error calling setLastChosenActivity\n" + e);
                        safelyStartActivity(activity, intent);
                    }
                }
            }
            safelyStartActivity(activity, intent);
        }
    }

    private void safelyStartActivity(Activity activity, Intent intent) {
        StrictMode.disableDeathOnFileUriExposure();
        try {
            safelyStartActivityInternal(activity, intent);
        } finally {
            StrictMode.enableDeathOnFileUriExposure();
        }
    }

    private void safelyStartActivityInternal(Activity activity, Intent intent) {
        if (!this.mSafeForwardingMode) {
            LogUtils.e("safelyStartActivityInternal " + activity.getLocalClassName());
            activity.startActivityAsUser(intent, null, UserHandle.of(UserHandle.myUserId()));
        } else {
            try {
                activity.startActivityAsCaller(intent, null, false, UserHandle.of(UserHandle.myUserId()).getIdentifier());
            } catch (RuntimeException e) {
                LogUtils.e("Unable to launch as uid " + this.mLaunchedFromUid + " package " + this.mLaunchedFromPackage + ", while running in " + ActivityThread.currentProcessName(), e);
            }
        }
    }
}
