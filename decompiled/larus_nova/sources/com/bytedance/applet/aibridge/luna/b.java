package com.bytedance.applet.aibridge.luna;

import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import f3.h;
import tx9.v1;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h<AbsJumpToLunaMethodIDL.b> f191193a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        v1.a("member", "unknown", 0, "user_cancel", 48);
        FLogger.f375446a.i("JumpToLunaMethod", "member fail, errorMsg: user_cancel");
        h.a.a(this.f191193a, "user_cancel", null, null, 14);
    }

    public b(h<AbsJumpToLunaMethodIDL.b> r100) {
        this.f191193a = r100;
    }
}
