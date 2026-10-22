package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.app.Activity;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements qh0.a<rh0.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TokenCert f77361b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qh0.f.b f77362a;

    public static final class a {
    }

    static {
        f77361b = TokenCert.Companion.with("bpea-androidcamerapermissionchecker_request_permission");
    }

    public e(qh0.f.b r100) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f77362a = r100;
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        TokenCert r101 = f77361b;
        Activity r102 = ContextUtil.contextToActivity(this.f77362a.getContext());
        if (r102 == null) goto L6;
        SettingKey<Boolean> r103 = m60.i.f512260a;
        m60.i.b r104 = new m60.i.b(r102);
        r104.f512265d = new f(r102, r100, r101);
        g r105 = new g(this, r100, r101);
        h r106 = new h(this, r100, r101);
        String[] r107 = {"android.permission.CAMERA"};
        r104.b(r105, r106, r101, (String[]) Arrays.copyOf(r107, r107.length));
        return;
    }
}
