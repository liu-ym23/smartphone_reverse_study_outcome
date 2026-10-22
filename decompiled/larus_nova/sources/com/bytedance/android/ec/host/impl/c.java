package com.bytedance.android.ec.host.impl;

import com.bytedance.android.ec.base.api.ai.AIChatComponentParam;
import com.larus.im.bean.message.GuiContext;
import com.larus.im.bean.message.GuiView;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements dw8.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xe.c f46200a;

    @Override // dw8.p
    public final String b() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder(" getBizTaskId():");
        xe.c r102 = this.f46200a;
        if (r102 == null) goto L5;
        String r103 = r102.b();
    L6:
        r101.append(r103);
        r100.e("zhaoruolei_biz", r101.toString());
        xe.c r104 = this.f46200a;
        if (r104 != null) goto L9;
        return null;
    L9:
        return r104.b();
    L5:
        r103 = null;
        goto L6
    }

    @Override // dw8.p
    public final boolean c() {
        xe.c r100 = this.f46200a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    @Override // dw8.p
    public final Map<String, String> getExtra() {
        xe.c r100 = this.f46200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getExtra();
    }

    @Override // dw8.p
    public final Map<String, String> getLogExtra() {
        xe.c r100 = this.f46200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLogExtra();
    }

    @Override // dw8.p
    public final String getPageName() {
        xe.c r100 = this.f46200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPageName();
    }

    @Override // dw8.p
    public final Integer getSource() {
        xe.c r100 = this.f46200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSource();
    }

    @Override // dw8.p
    public final String m() {
        xe.c r100 = this.f46200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.m();
    }

    @Override // dw8.p
    public final GuiContext a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        xe.c r101 = this.f46200a;
        GuiView r102 = null;
        if (r101 == null) goto L11;
        com.bytedance.android.ec.base.api.ai.GuiContext r103 = r101.a(r100);
        if (r103 == null) goto L12;
        String r104 = r103.getArtifactType();
        com.bytedance.android.ec.base.api.ai.GuiView r105 = r103.getView();
        if (r105 == null) goto L10;
        r102 = new GuiView(r105.getBizPayload());
    L10:
        return new GuiContext(r104, null, r102, 2, null);
    L12:
        return null;
    L11:
        return null;
    }

    public c(AIChatComponentParam r100, xe.c r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f46200a = r101;
    }
}
