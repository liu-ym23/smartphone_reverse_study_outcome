package com.android.server;

import android.content.pm.UserInfo;
import android.os.UserManager;
import com.android.server.am.ActivityManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.utils.Slogf;
import com.android.server.utils.TimingsTraceAndSlog;

/* JADX INFO: loaded from: classes.dex */
public class CommunalProfileInitializer {
    private static final String TAG = null;
    private final ActivityManagerService mAms;
    private UserManagerInternal mUmi;

    static {
        TAG = CommunalProfileInitializer.class.getSimpleName();
    }

    public CommunalProfileInitializer(ActivityManagerService ams) {
        this.mUmi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mAms = ams;
    }

    public void init(TimingsTraceAndSlog t) {
        Slogf.i(TAG, "init())");
        t.traceBegin("createCommunalProfileIfNeeded");
        createCommunalProfileIfNeeded();
        t.traceEnd();
    }

    private void createCommunalProfileIfNeeded() {
        int communalProfile = this.mUmi.getCommunalProfileId();
        if (communalProfile == (-10000)) goto L6;
        Slogf.d(TAG, "Found existing Communal Profile, userId=%d", new Object[]{Integer.valueOf(communalProfile)});
        return;
    L6:
        Slogf.d(TAG, "Creating a new Communal Profile");
        UserInfo newProfile = this.mUmi.createUserEvenWhenDisallowed(null, "android.os.usertype.profile.COMMUNAL", 0, null, null);     // Catch: UserManager.CheckedUserOperationException -> L9
        Slogf.i(TAG, "Successfully created Communal Profile, userId=%d", new Object[]{Integer.valueOf(newProfile.id)});     // Catch: UserManager.CheckedUserOperationException -> L9
        return;
    L9:
        e = move-exception;
        Slogf.wtf(TAG, "Communal Profile creation failed", e);
    }

    static void removeCommunalProfileIfPresent() {
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        int communalProfile = umi.getCommunalProfileId();
        if (communalProfile != (-10000)) goto L5;
        return;
    L5:
        Slogf.d(TAG, "Removing existing Communal Profile, userId=%d", new Object[]{Integer.valueOf(communalProfile)});
        boolean removeSucceeded = umi.removeUserEvenWhenDisallowed(communalProfile);
        if (removeSucceeded == true) goto L9;
        Slogf.e(TAG, "Failed to remove Communal Profile, userId=%d", new Object[]{Integer.valueOf(communalProfile)});
        return;
    }
}
