package com.bytedance.android.ec.core.address;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements wi.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f43706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f43707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f43708c;

    @Override // wi.b
    public final void a(wi.a r100) {
        w r101 = AddressSDK.f43649a;
        w r102 = AddressSDK.f43649a;
        int r103 = r102.f43730g.b().b();
        wi.a r104 = r102.f43733j;
        if (r104 == null) goto L5;
        float r105 = z.a(r104, r100);
    L6:
        AddressSDKLog.a("locate success:distance=" + r105 + " isCacheFirst=" + this.f43706a + " curBtm=" + this.f43707b, false);
        if (r104 != null) goto L9;
    L10:
        AddressSDK.h("location_change", null, false, null, 30);
        r102.f43733j = r100;
    L11:
        w r106 = AddressSDK.f43649a;
        Function1 r107 = this.f43708c;
        if (r107 == null) goto L15;
        Unit r108 = (Unit) r107.invoke(r100);
        return;
    L15:
        return;
    L9:
        if (r105 <= r103) goto L11;
    L5:
        r105 = 0.0f;
        goto L6
    }

    @Override // wi.b
    public final void onFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        w r101 = AddressSDK.f43649a;
        AddressSDKLog.a("locate fail:" + r100.getMessage() + " isCacheFirst=" + this.f43706a + " curBtm=" + this.f43707b, false);
    }

    public m(boolean r100, String r101, Function1 r102) {
        this.f43706a = r100;
        this.f43707b = r101;
        this.f43708c = r102;
    }
}
