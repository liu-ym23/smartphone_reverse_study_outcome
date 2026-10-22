package c09;

import android.content.Context;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.larus.account.base.impl.n;
import com.larus.account.base.model.LoginPlatform;
import com.larus.utils.logger.FLogger;
import com.ss.android.account.d;
import com.ss.bduploader.BDVideoUploaderBase;
import kotlin.jvm.internal.Intrinsics;
import n38.h;

/* JADX INFO: loaded from: classes27.dex */
public final class a extends PlatformLoginAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f21963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginPlatform f21964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f21965c;

    @Override // com.bytedance.sdk.account.platform.IPlatformLoginAdapter
    public final void onLoginError(ua7.h r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        FLogger.f375446a.i("WeixinLogin", "onLoginError:" + r110);
        h.a.a(this.f21963a, this.f21964b, r110.f549253g, r110.f549255i, this.f21965c, r110.f549288y, null, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
    }

    @Override // com.bytedance.sdk.account.platform.IPlatformLoginAdapter
    public final void onLoginSuccess(ua7.h r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        d r101 = r100.f549279p;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f541366g != true) goto L7;
    L8:
        this.f21963a.b(this.f21964b, this.f21965c, Boolean.valueOf(r102));
        return;
    L7:
        r102 = false;
        goto L8
    }

    public a(n r100, LoginPlatform r101, String r102, Context r103) {
        this.f21963a = r100;
        this.f21964b = r101;
        this.f21965c = r102;
        super(r103, "15210", "weixin");
    }
}
