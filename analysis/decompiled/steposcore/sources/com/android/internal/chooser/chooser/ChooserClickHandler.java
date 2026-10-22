package com.android.internal.chooser.chooser;

import android.app.Activity;
import android.app.ActivityThread;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.internal.chooser.ShareStrategy;
import com.android.internal.chooser.base.OnTargetClickHandler;
import com.android.internal.chooser.utils.LogUtils;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ChooserClickHandler implements OnTargetClickHandler {
    private static final String KEY_START_SPACE_MODE = "start_spacemode";
    private static final String KEY_START_WINDOW_MODE = "start_windowmode";
    private static final int START_WINDOW_MODE_NEW_TASK = 256;
    private final String mLaunchedFromPackage;
    private final int mLaunchedFromUid;
    private final boolean mSafeForwardingMode;

    public ChooserClickHandler(boolean safeForwardingMode, int launchedFromUid, String launchedFromPackage) {
        this.mSafeForwardingMode = safeForwardingMode;
        this.mLaunchedFromUid = launchedFromUid;
        this.mLaunchedFromPackage = launchedFromPackage;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0089. Please report as an issue. */
    @Override // com.android.internal.chooser.base.OnTargetClickHandler
    public void handleClick(Activity activity, Intent intent, ResolveInfo resolveInfo, List<ResolveInfo> resolveList, boolean isChecked, boolean quickLook, ShareStrategy shareStrategy) throws Resources.NotFoundException {
        String targetPkg;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (!this.mSafeForwardingMode) {
            activity.startActivityAsUser(intent, null, UserHandle.of(UserHandle.myUserId()));
            return;
        }
        Bundle options = null;
        if (quickLook) {
            options = new Bundle();
            options.putInt(KEY_START_WINDOW_MODE, 256);
            String[] values = activity.getResources().getStringArray(17236312);
            List<String> mPackageListForWindowModeSpace = Arrays.asList(values);
            if (TextUtils.isEmpty(intent.getPackage())) {
                targetPkg = intent.getOriginalIntent() != null ? intent.getOriginalIntent().getPackage() : "";
            } else {
                targetPkg = intent.getPackage();
            }
            if (TextUtils.isEmpty(targetPkg) && intent.getComponent() != null) {
                targetPkg = intent.getComponent().getPackageName();
            }
            if (!TextUtils.isEmpty(targetPkg) && mPackageListForWindowModeSpace.contains(targetPkg)) {
                options.putBoolean(KEY_START_SPACE_MODE, true);
            }
        }
        switch (shareStrategy) {
        }
        try {
            activity.startActivityAsCaller(intent, options, false, UserHandle.of(UserHandle.myUserId()).getIdentifier());
        } catch (RuntimeException e) {
            LogUtils.e("Unable to launch as uid " + this.mLaunchedFromUid + " package " + this.mLaunchedFromPackage + ", while running in " + ActivityThread.currentProcessName(), e);
        }
    }
}
