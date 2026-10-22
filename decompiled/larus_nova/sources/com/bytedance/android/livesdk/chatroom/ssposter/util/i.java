package com.bytedance.android.livesdk.chatroom.ssposter.util;

import com.bytedance.android.livehostapi.business.depend.share.IViewLoadCallback;

/* JADX INFO: loaded from: classes7.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f111606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f111607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f111608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IViewLoadCallback f111609d;

    public final boolean a() {
        if (this.f111606a == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f111607b == true) goto L8;
        return false;
    }

    public final void b() {
        if (this.f111606a == true) goto L8;
        this.f111606a = true;
        IViewLoadCallback r100 = this.f111609d;
        if (r100 == null) goto L9;
        r100.onLoadSuccess();
        return;
    L9:
        return;
    }

    public i(IViewLoadCallback r100) {
        this.f111609d = r100;
    }
}
