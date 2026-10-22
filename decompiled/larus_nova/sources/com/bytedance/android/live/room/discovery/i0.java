package com.bytedance.android.live.room.discovery;

import android.content.DialogInterface;
import android.net.Uri;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class i0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSceneWidget f99526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b1 f99527b;

    public i0(LiveSceneWidget r100, b1 r101) {
        this.f99526a = r100;
        this.f99527b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f99526a.wq("live");
        ita.l r102 = new ita.l(this.f99527b.getSchemaUrl());
        r102.c("title", this.f99527b.getTitle());
        Uri r103 = UriProtector.parse(r102.d());
        ((ILiveActionHandler) jc1.k.n(ILiveActionHandler.class)).handle(this.f99526a.context, r103);
        r100.dismiss();
    }
}
