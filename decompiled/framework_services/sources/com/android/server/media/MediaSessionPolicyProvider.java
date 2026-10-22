package com.android.server.media;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediaSessionPolicyProvider {
    static final int SESSION_POLICY_IGNORE_BUTTON_RECEIVER = 1;
    static final int SESSION_POLICY_IGNORE_BUTTON_SESSION = 2;

    @Retention(RetentionPolicy.SOURCE)
    @interface SessionPolicy {
    }

    public MediaSessionPolicyProvider(Context context) {
    }

    int getSessionPoliciesForApplication(int uid, String packageName) {
        return 0;
    }
}
