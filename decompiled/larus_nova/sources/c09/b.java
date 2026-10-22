package c09;

import com.larus.account.base.impl.s;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.weixin.WeixinLogin;
import com.ss.android.account.d;
import kotlin.jvm.internal.Intrinsics;
import sa7.h;

/* JADX INFO: loaded from: classes27.dex */
public final class b extends h<ua7.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.h f21966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WeixinLogin f21967b;

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        ua7.h r101 = (ua7.h) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        d r102 = r101.f549279p;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.f541366g != true) goto L7;
    L8:
        n38.h r104 = this.f21966a;
        this.f21967b.getClass();
        r104.b(LoginPlatform.WEIXIN, "WeixinLogin", Boolean.valueOf(r103));
        return;
    L7:
        r103 = false;
        goto L8
    }

    public b(s r100, WeixinLogin r101) {
        this.f21966a = r100;
        this.f21967b = r101;
    }

    @Override // sa7.h
    public final void onError(ua7.b r110, int r111) {
        ua7.h r112 = (ua7.h) r110;
        n38.h r100 = this.f21966a;
        this.f21967b.getClass();
        LoginPlatform r101 = LoginPlatform.WEIXIN;
        if (r112 == null) goto L6;
        String r113 = r112.f549255i;
        if (r113 == null) goto L6;
    L7:
        n38.h.a.a(r100, r101, r111, r113, "WeixinLogin", null, null, null, null, 480);
        return;
    L6:
        r113 = "";
        goto L7
    }
}
