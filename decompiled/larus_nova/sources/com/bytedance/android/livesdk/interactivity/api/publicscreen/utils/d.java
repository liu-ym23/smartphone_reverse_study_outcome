package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$AnimType;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements jg1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClearScreenConst$InteractType f133633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f133634b = null;

    public d() {
    }

    @Override // jg1.a
    public final boolean a() {
        return false;
    }

    @Override // jg1.a
    public final boolean b() {
        return false;
    }

    @Override // jg1.a
    public final void c() {
    }

    @Override // jg1.a
    public final long d() {
        return 300;
    }

    @Override // jg1.a
    public final boolean e(jg1.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return true;
    }

    @Override // jg1.a
    public final void f() {
    }

    static {
        f133634b = new d();
        f133633a = ClearScreenConst$InteractType.AUDIENCE_PS_CONFIG_DIALOG_SHOW;
    }

    @Override // jg1.a
    public final ClearScreenConst$AnimType g() {
        return ClearScreenConst$AnimType.TRANS;
    }

    @Override // jg1.a
    public final ClearScreenConst$InteractType getInteractType() {
        return f133633a;
    }
}
