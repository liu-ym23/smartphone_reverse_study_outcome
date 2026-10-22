package com.bytedance.applet.impl;

import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.larus.im.bean.message.GuiContext;
import com.larus.im.bean.message.GuiView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements dw8.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppletChatInputController.b f191942a;

    @Override // dw8.p
    public final boolean c() {
        return false;
    }

    @Override // dw8.p
    public final Map<String, String> getLogExtra() {
        return null;
    }

    @Override // dw8.p
    public final String getPageName() {
        return null;
    }

    @Override // dw8.p
    public final String m() {
        return null;
    }

    @Override // dw8.p
    public final String b() {
        return this.f191942a.b();
    }

    @Override // dw8.p
    public final Map<String, String> getExtra() {
        return this.f191942a.getExtra();
    }

    @Override // dw8.p
    public final Integer getSource() {
        return this.f191942a.getSource();
    }

    public h(AppletModelContextProvider r100) {
        this.f191942a = r100;
    }

    @Override // dw8.p
    public final GuiContext a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        AppletChatInputController.e r101 = this.f191942a.c();
        GuiView r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        String r103 = r101.f34538a;
        String r104 = r101.f34539b;
        AppletChatInputController.f r105 = r101.f34540c;
        if (r105 == null) goto L9;
        r102 = new GuiView(r105.f34541a);
    L9:
        return new GuiContext(r103, r104, r102);
    }
}
