package com.bytedance.android.anniex.ability;

import android.view.View;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c implements b36.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q26.j f40201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KitType f40202b;

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void b(String r100, com.bytedance.ies.bullet.service.base.p r101) {
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
    public String getSessionId() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public String getViewTag() {
        return "anniex-web";
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void m() {
    }

    @Override // v06.a
    public final void n(String r100, com.bytedance.ies.bullet.core.q r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "lifeCycle");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public void onHide() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public void onShow() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public View realView() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void reload() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public void sendEvent(String r100, Object r101) {
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

    @Override // b36.e, v06.a, com.bytedance.ies.bullet.service.base.o
    public q26.j getContext() {
        return this.f40201a;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final KitType getKitType() {
        return this.f40202b;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final SccConfig.SccLevel i() {
        return SccConfig.SccLevel.SAFE;
    }

    public c(q26.j r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f40201a = r100;
        this.f40202b = KitType.WEB;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final boolean k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        return true;
    }
}
