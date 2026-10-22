package com.bytedance.android.livesdk.interactivity.seek.v2;

import im2.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements com.ss.ugc.live.sdk.msg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f140829a;

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void onInit() {
        List<vlc.b> r100 = this.f140829a.f140825z;
        if (r100 == null) goto L14;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if ((r103 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        Iterator r104 = r101.iterator();
    L12:
        if (r104.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.message.interceptor.h) r104.next()).getClass();
        goto L12
    L21:
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void onRelease() {
        n r100 = this.f140829a.f140803d;
        if ((r100 instanceof n) == true) goto L5;
        r100 = null;
    L5:
        if (r100 == null) goto L7;
        r100.a();
    L7:
        List<vlc.b> r101 = this.f140829a.f140825z;
        if (r101 == null) goto L19;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if ((r104 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L11;
        r102.add(r104);
        goto L11
    L15:
        Iterator r105 = r102.iterator();
    L17:
        if (r105.hasNext() == false) goto L19;
        ((com.bytedance.android.livesdk.message.interceptor.h) r105.next()).onRelease();
    L19:
        this.f140829a.f140802c.d("seek_message");
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void onResume() {
        List<vlc.b> r100 = this.f140829a.f140825z;
        if (r100 == null) goto L14;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if ((r103 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        Iterator r104 = r101.iterator();
    L12:
        if (r104.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.message.interceptor.h) r104.next()).getClass();
        goto L12
    L21:
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void onStart() {
        List<vlc.b> r100 = this.f140829a.f140825z;
        if (r100 == null) goto L14;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if ((r103 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        Iterator r104 = r101.iterator();
    L12:
        if (r104.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.message.interceptor.h) r104.next()).getClass();
        goto L12
    L21:
        return;
    }

    public e(b r100) {
        this.f140829a = r100;
    }

    @Override // com.ss.ugc.live.sdk.msg.b
    public final void a(boolean r100) {
        List<vlc.b> r101 = this.f140829a.f140825z;
        if (r101 == null) goto L14;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        if ((r104 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        Iterator r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.message.interceptor.h) r105.next()).getClass();
        goto L12
    L21:
        return;
    }
}
