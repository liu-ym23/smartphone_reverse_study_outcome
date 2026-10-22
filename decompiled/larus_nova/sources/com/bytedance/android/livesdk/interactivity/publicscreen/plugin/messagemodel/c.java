package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.message.model.z6;

/* JADX INFO: loaded from: classes9.dex */
public abstract class c extends s {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z6 f139244l;

    public abstract boolean o();

    public abstract tb2.d p();

    public abstract void q();

    public c(z6 r100) {
        this.f139244l = r100;
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
