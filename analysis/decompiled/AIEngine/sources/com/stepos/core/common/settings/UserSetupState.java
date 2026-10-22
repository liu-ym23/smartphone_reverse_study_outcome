package com.stepos.core.common.settings;

import android.content.Context;
import android.provider.Settings;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UserSetupState {
    public static final UserSetupState INSTANCE = new UserSetupState();
    public static final String KEY_USER_SETUP_COMPLETE = "user_setup_complete";

    private UserSetupState() {
    }

    public final boolean isSetupComplete(Context context) {
        Object objA;
        g.f(context, "context");
        try {
            objA = Boolean.valueOf(g.b(Settings.Secure.getString(context.getContentResolver(), KEY_USER_SETUP_COMPLETE), "1"));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }
}
