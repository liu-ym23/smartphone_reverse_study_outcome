package com.bytedance.android.sdk.bdticketguard.init;

import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Class<? extends d>> f163779d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f163780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f163781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f163782c;

    public static final class a {
    }

    static {
        f163779d = SetsKt.setOf(new Class[]{com.bytedance.android.sdk.bdticketguard.init.a.class, TeeInitThread.class, ReeInitThread.class});
    }

    public d(Function0 r100, Function0 r101, String r102) {
        this.f163780a = r100;
        this.f163781b = r101;
        this.f163782c = r102;
    }
}
