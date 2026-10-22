package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class g extends s {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final m1 f139257l;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IBaseUser f() {
        return this.f139257l.getUserInMessage();
    }

    public g(m1 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f139257l = r100;
        this.f133474e = Long.valueOf(r100.getMessageId());
        this.f133475f = r100.getMessageMethod();
        this.f133476g = Long.valueOf(r100.getTimestamp());
    }
}
