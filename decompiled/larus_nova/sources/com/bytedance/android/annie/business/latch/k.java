package com.bytedance.android.annie.business.latch;

import android.view.View;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.bullet.service.base.p;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxView f39040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KitType f39041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f39042d;

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void b(String r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void c() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void f(byte[] r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templateArray");
        Intrinsics.checkNotNullParameter(r101, "baseUrl");
        Intrinsics.checkNotNullParameter(r102, "data");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void g() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final String getViewTag() {
        return "fakeKitViewService";
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final boolean k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        return true;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void m() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void onHide() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void onShow() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "globalprops");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public q26.j getContext() {
        return this.f39042d;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final KitType getKitType() {
        return this.f39041c;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final String getSessionId() {
        return this.f39039a;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final SccConfig.SccLevel i() {
        return SccConfig.SccLevel.SAFE;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final View realView() {
        return this.f39040b;
    }

    public k(String r100, LynxView r101) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        Intrinsics.checkNotNullParameter(r101, "lynxView");
        this.f39039a = r100;
        this.f39040b = r101;
        this.f39041c = KitType.LYNX;
        this.f39042d = new j();
    }
}
