package com.obric.capabilitykit;

import android.os.Bundle;
import com.obric.capabilitykit.version.PersonalContextData;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f32246a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile PersonalContextData f32247b;

    static {
        f32246a = new u();
    }

    private u() {
    }

    private final PersonalContextData b() {
        Bundle r1 = EntityProvider.INSTANCE.queryPersonalContextData$capabilitykit_release();
        if (r1 == null) goto L5;
        PersonalContextData r2 = PersonalContextData.Companion.createFromBundle(r1);
        f32247b = r2;
        return r2;
    L5:
        return null;
    }

    public final PersonalContextData a() {
        PersonalContextData r0 = f32247b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return b();
    }
}
