package com.bytedance.android.annie.param;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f39705b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f39706a;

    static {
        f39705b = new j();
    }

    public final k a() {
        this.f39706a.getClass();
        k r100 = i.f39704b;
        if (r100 == null) goto L5;
        Gson r101 = new Gson();
        return (k) GsonProtectorUtils.fromJson(r101, GsonProtectorUtils.toJson(r101, r100), k.class);
    L5:
        return null;
    }

    public final boolean b() {
        this.f39706a.getClass();
        k r100 = i.f39704b;
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f(), "") == true) goto L13;
        k r101 = i.f39704b;
        if (r101 == null) goto L9;
        String r102 = r101.A();
    L11:
        if (Intrinsics.areEqual(r102, "0") == true) goto L13;
        return true;
    L9:
        r102 = null;
        goto L11
    }

    public j() {
        this.f39706a = i.f39703a;
    }
}
