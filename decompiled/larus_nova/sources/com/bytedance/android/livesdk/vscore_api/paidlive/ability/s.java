package com.bytedance.android.livesdk.vscore_api.paidlive.ability;

import android.os.Bundle;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f159427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f159428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f159429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f159430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f159431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f159432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f159433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f159434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f159435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Map<String, String>, Unit> f159436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f159437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super Bundle, Unit> f159438l;

    public static final class a {
    }

    static {
    }

    public s() {
        this.f159427a = 1;
        this.f159430d = new String[0];
        this.f159433g = true;
        this.f159435i = true;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof s) == false) goto L14;
        s r101 = (s) r100;
        if (this.f159427a == r101.f159427a) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.f159431e, r101.f159431e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f159432f, r101.f159432f) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.f159434h, r101.f159434h) == false) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }
}
