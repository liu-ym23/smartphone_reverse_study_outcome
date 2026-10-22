package com.bytedance.android.annie.xbridge.mix;

import android.view.View;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.m0;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    public static final class a implements com.bytedance.ies.web.jsbridge2.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f40158a;

        public a(com.bytedance.ies.bullet.service.base.o r100) {
            this.f40158a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.h
        public final <T> void a(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            this.f40158a.sendEvent(r100, r101);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.xbridge.mix.b$b, reason: collision with other inner class name */
    public static final class C0753b implements com.bytedance.ies.web.jsbridge2.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ue7.c f40159a;

        public C0753b(ue7.c r100) {
            this.f40159a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.h
        public final <T> void a(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            this.f40159a.sendEvent(r100, r101);
        }
    }

    public static final CallContext a(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        h16.e r101 = (h16.e) r100.c(h16.e.class);
        ue7.c r102 = (ue7.c) r100.c(ue7.c.class);
        if (r101 == null) goto L11;
        CallContext r103 = new CallContext();
        com.bytedance.ies.bullet.service.base.o r104 = r101.getKitView();
        if (r104 == null) goto L7;
        r103.f249269d = r104.realView();
        r103.f249273h = new a(r104);
    L7:
        BulletContext r105 = r101.getBulletContext();
        if (r105 == null) goto L10;
        r103.f249266a = r105.getContext();
    L10:
        r103.f249272g = "webcast";
        r103.f249267b = String.valueOf(r101.getCurrentUri());
    L17:
        r103.f249271f = true;
        r100.d(CallContext.class, r103);
        Set<String> r106 = SecurityContextUtils.f269807a;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        com.bytedance.sdk.xbridge.cn.auth.h r107 = (com.bytedance.sdk.xbridge.cn.auth.h) r100.c(com.bytedance.sdk.xbridge.cn.auth.h.class);
        if (r107 == null) goto L21;
        m0 r108 = r103.f249274i;
        r108.f249391a = r107.a();
        r108.f249392b = r107.b();
        r107.getAppId();
        r107.getAppVersion();
        r107.getChannel();
        r108.f249393c = r107.getContainerType();
        r107.getMethodName();
    L21:
        return r103;
    L11:
        if (r102 == null) goto L16;
        CallContext r109 = new CallContext();
        View r110 = r102.i();
        if (r110 == null) goto L15;
        r109.f249269d = r110;
        r109.f249273h = new C0753b(r102);
        r109.f249266a = r102.context();
    L15:
        r109.f249272g = "webcast";
        r109.f249267b = r102.a().toString();
        r103 = r109;
        goto L17
    L16:
        r103 = new CallContext();
        goto L17
    }
}
