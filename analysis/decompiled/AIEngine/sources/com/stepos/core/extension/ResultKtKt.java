package com.stepos.core.extension;

import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ResultKtKt {
    public static final <T> Object complete(Result.a aVar) {
        g.f(aVar, "<this>");
        return Complete.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T getValueOrNull(Object obj) {
        try {
            if (!(obj instanceof Result.Failure)) {
                if ((obj instanceof Result.Failure ? null : obj) instanceof Complete) {
                    return null;
                }
            }
        } catch (ClassCastException unused) {
        }
        if (obj instanceof Result.Failure) {
            return null;
        }
        return obj;
    }

    public static final <T> boolean isComplete(Object obj) {
        boolean z = obj instanceof Result.Failure;
        if (z) {
            return false;
        }
        if (z) {
            obj = null;
        }
        return obj instanceof Complete;
    }

    public static final <T> boolean isCompleteSafe(Object obj) {
        try {
            if (!(obj instanceof Result.Failure)) {
                if (obj instanceof Result.Failure) {
                    obj = null;
                }
                if (obj instanceof Complete) {
                    return true;
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public static final <T> Object onComplete(Object obj, a<n> action) {
        g.f(action, "action");
        try {
            if (!(obj instanceof Result.Failure)) {
                if ((obj instanceof Result.Failure ? null : obj) instanceof Complete) {
                    action.invoke();
                }
            }
        } catch (ClassCastException unused) {
        }
        return obj;
    }
}
