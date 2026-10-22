package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.chatroom.utils.a1;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements a1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q72.b f133970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d f133971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r22.a.b f133972c;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a1.b
    public final void a(Bitmap r100) {
        q72.b r101 = this.f133970a;
        if (r101 == null) goto L5;
        r101.f531925c = true;
    L5:
        if (r101 == null) goto L8;
        r101.f531924b = r100;
    L8:
        if (this.f133971b.isSelfSendFake() == false) goto L15;
        q72.b r102 = this.f133970a;
        if (r102 == null) goto L12;
        Bitmap r103 = r102.f531923a;
    L13:
        if (r103 == null) goto L17;
        this.f133972c.a(this.f133971b);
        return;
    L17:
        return;
    L12:
        r103 = null;
        goto L13
    L15:
        this.f133972c.a(this.f133971b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a1.b
    public final void onFail(Exception r100) {
        q72.b r101 = this.f133970a;
        if (r101 == null) goto L6;
        r101.f531925c = true;
    L6:
        if (this.f133971b.isSelfSendFake() == false) goto L13;
        q72.b r102 = this.f133970a;
        if (r102 == null) goto L10;
        Bitmap r103 = r102.f531923a;
    L11:
        if (r103 == null) goto L15;
        this.f133972c.a(this.f133971b);
        return;
    L15:
        return;
    L10:
        r103 = null;
        goto L11
    L13:
        this.f133972c.a(this.f133971b);
    }

    public c(q72.b r100, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r101, r22.a.b r102) {
        this.f133970a = r100;
        this.f133971b = r101;
        this.f133972c = r102;
    }
}
