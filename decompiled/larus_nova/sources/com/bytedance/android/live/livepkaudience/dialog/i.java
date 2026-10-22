package com.bytedance.android.live.livepkaudience.dialog;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkApplyPermissionSwitchDialog f81821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f81822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f81823c;

    public i(PkApplyPermissionSwitchDialog r100, Ref.ObjectRef r101, boolean r102) {
        this.f81821a = r100;
        this.f81822b = r101;
        this.f81823c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        if (this.f81821a.f81652e != 1) goto L6;
        ALogger.i("ttlive_pk", "pk update_setting " + ((HashMap) this.f81822b.element));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.c.f158307t1;
        Boolean r103 = Boolean.valueOf(this.f81823c);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        xs2.b.a().post(new jd0.m(this.f81823c));
    L6:
        PkApplyPermissionSwitchDialog r104 = this.f81821a;
        r104.f81650c = this.f81823c;
        r104.O0();
    }
}
