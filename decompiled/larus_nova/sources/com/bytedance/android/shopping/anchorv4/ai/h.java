package com.bytedance.android.shopping.anchorv4.ai;

import android.view.ViewGroup;
import com.bytedance.android.ec.base.api.ai.AIChatComponentHandle;
import com.bytedance.android.ec.base.api.ai.FloatChatWindowState;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f165657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PdpAIRuntime f165658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f165659c;

    @Override // com.bytedance.android.shopping.anchorv4.ai.g
    public final void B1() {
        PdpAIRuntime r100 = this.f165658b;
        if (((Boolean) r100.f165632g.getValue()).booleanValue() == false) goto L13;
        AIChatComponentHandle r101 = r100.f165627b;
        if (r101 == null) goto L11;
        xe.d r102 = r101.getController();
        if (r102 == null) goto L12;
        r102.B1();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.g
    public final void C1() {
        this.f165658b.b();
        this.f165659c.removeView(this.f165657a);
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.g
    public final boolean handleBackPressed() {
        PdpAIRuntime r100 = this.f165658b;
        AIChatComponentHandle r101 = r100.f165627b;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r100.f165629d != FloatChatWindowState.EXPANDED) goto L11;
        r101.getController().D3();
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.g
    public final void D1(float r100) {
        this.f165657a.setTranslationY(r100);
    }

    public h(e r100, PdpAIRuntime r101, ViewGroup r102) {
        this.f165657a = r100;
        this.f165658b = r101;
        this.f165659c = r102;
    }
}
