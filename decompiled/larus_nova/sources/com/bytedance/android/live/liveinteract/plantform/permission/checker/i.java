package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.app.Activity;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements qh0.a<rh0.a>, qh0.d<rh0.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TokenCert f77371d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qh0.d<rh0.a> f77372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qh0.f.c f77373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qh0.a<rh0.a> f77374c;

    public static final class a {
    }

    static {
        f77371d = TokenCert.Companion.with("bpea-androidpermissionchecker_request_permission");
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f77372a = r100;
        qh0.a<rh0.a> r101 = this.f77374c;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        qh0.d<rh0.a> r101 = this.f77372a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }

    public final void c(rh0.a r110) {
        TokenCert r111 = f77371d;
        Activity r100 = ContextUtil.contextToActivity(this.f77373b.getContext());
        if (r100 != null) goto L8;
        qh0.d<rh0.a> r112 = this.f77372a;
        if (r112 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L7:
        qh0.f.c r101 = this.f77373b;
        r112.b(new BaseCheckException(r101.f532896c, r101.f532895b, BaseCheckException.CheckType.AndroidPermission, "context is not Activity", null, 16, null));
        return;
    L8:
        SettingKey<Boolean> r102 = m60.i.f512260a;
        m60.i.b r103 = new m60.i.b(r100);
        r103.f512265d = new j(r100, r111);
        k r104 = new k(this, r111);
        l r105 = new l(this, r111);
        boolean r106 = true;
        if (this.f77373b.f532896c == 1) goto L11;
    L13:
        r106 = false;
    L14:
        ArrayList r107 = new ArrayList();
        r107.add("android.permission.RECORD_AUDIO");
        if (r106 == false) goto L17;
        r107.add("android.permission.CAMERA");
    L17:
        Object[] r108 = r107.toArray(new String[0]);
        if (r108 == null) goto L22;
        String[] r109 = (String[]) r108;
        r103.b(r104, r105, r111, (String[]) Arrays.copyOf(r109, r109.length));
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L11:
        if (((Boolean) vm2.g.f556080f.getValue(null, vm2.g.f556075a[4])).booleanValue() == false) goto L13;
        goto L13
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r100) {
        c(r100);
    }

    public i(qh0.f.c r100, qh0.a<rh0.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f77373b = r100;
        this.f77374c = r101;
    }
}
