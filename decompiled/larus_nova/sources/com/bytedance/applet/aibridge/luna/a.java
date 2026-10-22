package com.bytedance.applet.aibridge.luna;

import com.larus.common_ui.dialog.p0;
import e3.d;
import f3.h;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JumpToLunaMethod f191189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f191190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbsJumpToLunaMethodIDL.a f191191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h<AbsJumpToLunaMethodIDL.b> f191192d;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        final JumpToLunaMethod r100 = this.f191189a;
        final d r101 = this.f191190b;
        final AbsJumpToLunaMethodIDL.a r102 = this.f191191c;
        final h<AbsJumpToLunaMethodIDL.b> r103 = this.f191192d;
        com.obric.assistant.spi.keyguard.a.a(new qv3.a(r100, r101, r102, r103), new qv3.b(r103), null, false, 28);
    }

    public a(JumpToLunaMethod r100, d r101, AbsJumpToLunaMethodIDL.a r102, h<AbsJumpToLunaMethodIDL.b> r103) {
        this.f191189a = r100;
        this.f191190b = r101;
        this.f191191c = r102;
        this.f191192d = r103;
    }
}
