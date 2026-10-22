package com.bytedance.ai.core.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f36140e;

    @Override // com.bytedance.ai.core.base.i
    public final boolean a() {
        if (this.f36140e == false) goto L5;
    L8:
        return true;
    L5:
        if (super.a() == true) goto L8;
        return false;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        super(r100, SessionType.CHATUI);
        this.f36140e = true;
    }

    public final void b(boolean r100) {
        this.f36140e = r100;
        com.bytedance.ai.utils.g.f37637a.d("Session", "Session(" + this.f36153a + ") is Active --> " + this.f36140e);
    }
}
