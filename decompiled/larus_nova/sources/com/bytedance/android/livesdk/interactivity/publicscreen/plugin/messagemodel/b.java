package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b extends s {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.message.j f139243l;

    public b(com.bytedance.android.live.base.model.message.j r100) {
        this.f139243l = r100;
        Long r101 = null;
        if (r100 == null) goto L5;
        Long r102 = Long.valueOf(r100.getMessageId());
    L6:
        this.f133474e = r102;
        if (r100 == null) goto L9;
        String r103 = r100.getMessageMethod();
    L10:
        this.f133475f = r103;
        if (r100 == null) goto L13;
        r101 = Long.valueOf(r100.getTimestamp());
    L13:
        this.f133476g = r101;
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
