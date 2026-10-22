package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;

/* JADX INFO: loaded from: classes8.dex */
public final class g6 extends mk1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f113544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomAuthStatus.Style f113545b;

    @Override // mk1.b
    public final mk1.a a() {
        int r100 = this.f113544a;
        String r101 = null;
        if (r100 != 0) goto L5;
        RoomAuthStatus.Style r102 = this.f113545b;
        if (r102 == null) goto L29;
        r101 = r102.getContent();
    L29:
        return new mk1.a(0, r101, this.f113545b);
    L5:
        if (r100 != 1) goto L7;
        RoomAuthStatus.Style r103 = this.f113545b;
        if (r103 == null) goto L33;
        r101 = r103.getContent();
    L33:
        return new mk1.a(1, r101, this.f113545b);
    L7:
        if (r100 == 2) goto L12;
        RoomAuthStatus.Style r104 = this.f113545b;
        if (r104 == null) goto L30;
        r101 = r104.getContent();
    L30:
        return new mk1.a(0, r101, this.f113545b);
    L12:
        RoomAuthStatus.Style r105 = this.f113545b;
        if (r105 != null) goto L15;
    L17:
        RoomAuthStatus.Style r106 = this.f113545b;
        if (r106 == null) goto L32;
        r101 = r106.getContent();
    L32:
        return new mk1.a(2, r101, this.f113545b);
    L15:
        if (r105.getUnableStyle() != 1) goto L17;
        return new mk1.a(3, this.f113545b.getContent(), this.f113545b);
    }

    @Override // mk1.b
    public final mk1.c b() {
        mk1.c r100 = mk1.c.f514296b;
        return mk1.c.f514297c;
    }

    public g6(boolean r100, RoomAuthStatus.Style r101) {
        if (r100 == false) goto L4;
        long r102 = 0;
    L5:
        this((int) r102, r101);
        return;
    L4:
        r102 = 2;
        goto L5
    }

    public g6(int r100, RoomAuthStatus.Style r101) {
        this.f113544a = r100;
        this.f113545b = r101;
    }
}
