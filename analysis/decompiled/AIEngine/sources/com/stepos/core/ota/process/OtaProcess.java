package com.stepos.core.ota.process;

import android.app.Application;
import android.content.Context;
import gc.o;
import kotlin.Result;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaProcess {
    public static final OtaProcess INSTANCE = new OtaProcess();
    public static final String PROCESS_SUFFIX = ":ota";
    private static volatile Boolean cached;

    private OtaProcess() {
    }

    private final String currentProcessName(Context context) {
        Object objA;
        try {
            objA = Application.getProcessName();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (String) objA;
    }

    public final boolean isOtaProcess(Context context) {
        g.f(context, "context");
        Boolean bool = cached;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strCurrentProcessName = currentProcessName(context);
        boolean z = false;
        if (strCurrentProcessName != null && o.e0(strCurrentProcessName, PROCESS_SUFFIX, false)) {
            z = true;
        }
        cached = Boolean.valueOf(z);
        return z;
    }
}
