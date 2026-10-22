package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class w implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomChatChannelCreator f133016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f133017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f133018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Long f133019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Long f133020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Long f133021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Long f133022g;

    public w(RoomChatChannelCreator r100, long r101, Long r102, Long r103, Long r104, Long r105, Long r106) {
        this.f133016a = r100;
        this.f133017b = r101;
        this.f133018c = r102;
        this.f133019d = r103;
        this.f133020e = r104;
        this.f133021f = r105;
        this.f133022g = r106;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        RoomChatChannelCreator r102 = this.f133016a;
        r102.f132946c = Long.valueOf(this.f133017b);
        RoomChatChannelCreator r103 = this.f133016a;
        r103.f132947d = this.f133018c;
        r103.f132948e = this.f133019d;
        r103.f132949f = this.f133020e;
        r103.f132950g = this.f133021f;
        r103.f132951h = this.f133022g;
        s22.e r104 = r103.b();
        if (r104 == null) goto L5;
        r104.quitChannel(this.f133017b);
    L5:
        r100.dismiss();
    }
}
