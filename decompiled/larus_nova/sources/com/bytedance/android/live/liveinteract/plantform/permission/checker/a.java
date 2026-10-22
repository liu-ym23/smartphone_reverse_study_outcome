package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.app.Activity;
import android.os.Build;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements qh0.a<rh0.a>, qh0.d<rh0.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TokenCert f77351d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qh0.d<rh0.a> f77352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qh0.f.a f77353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qh0.a<rh0.a> f77354c;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.permission.checker.a$a, reason: collision with other inner class name */
    public static final class C1197a {
    }

    static {
        f77351d = TokenCert.Companion.with("bpea-androidpermissionchecker_request_permission");
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f77352a = r100;
        qh0.a<rh0.a> r101 = this.f77354c;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        qh0.d<rh0.a> r101 = this.f77352a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }

    public final void c(rh0.a r100) {
        if (vm2.e.o() == true) goto L5;
    L20:
        qh0.d<rh0.a> r101 = this.f77352a;
        if (r101 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L23:
        r101.onResult(null);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L20;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.c.f158290o;
        if (r102.getValue().booleanValue() == true) goto L20;
        TokenCert r103 = f77351d;
        Activity r104 = ContextUtil.contextToActivity(this.f77353b.getContext());
        if (r104 == null) goto L15;
        SettingKey<Boolean> r105 = m60.i.f512260a;
        m60.i.b r106 = new m60.i.b(r104);
        r106.f512265d = new b(r104, r103);
        c r107 = new c(this, r103);
        d r108 = new d(this, r103);
        ArrayList r109 = new ArrayList();
        r109.add("android.permission.BLUETOOTH_CONNECT");
        Object[] r110 = r109.toArray(new String[0]);
        if (r110 == null) goto L14;
        String[] r111 = (String[]) r110;
        r106.b(r107, r108, r103, (String[]) Arrays.copyOf(r111, r111.length));
    L19:
        com.bytedance.android.livesdk.sharedpref.f.d(r102, Boolean.TRUE);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L15:
        qh0.d<rh0.a> r112 = this.f77352a;
        if (r112 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L18:
        r112.onResult(null);
        goto L19
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r100) {
        c(r100);
    }

    public a(qh0.f.a r100, qh0.a<rh0.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f77353b = r100;
        this.f77354c = r101;
    }
}
