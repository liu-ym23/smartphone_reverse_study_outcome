package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f149433e;

    public i() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        si2.b0 r101 = null;
        if ((r100 instanceof si2.b0) == true) goto L5;
        r100 = null;
    L5:
        si2.b0 r102 = (si2.b0) r100;
        if (r102 != null) goto L8;
    L22:
        return false;
    L8:
        if (r102.msgType == 2) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L15;
        r101 = r102;
    L15:
        if (r101 == null) goto L22;
        Context r104 = getContext();
        if (r104 == null) goto L21;
        ECV2PopupInfo r105 = r101.flashPopupInfo;
        if (r105 == null) goto L21;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.b.a(r104, r105);
    L21:
        return true;
    L10:
        if (this.f149433e == false) goto L12;
        r103 = true;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r100, boolean r101) {
        this.f149433e = r101;
    }
}
