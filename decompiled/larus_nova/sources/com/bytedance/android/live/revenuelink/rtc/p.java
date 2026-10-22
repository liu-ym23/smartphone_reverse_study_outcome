package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.android.live.core.log.ALogger;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<o> f91969a;

    public final List<String> c() {
        CopyOnWriteArrayList<o> r100 = this.f91969a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((o) r102.next()).f91956b);
        goto L4
    L6:
        return r101;
    }

    public final vc0.c d() {
        HashMap r100 = new HashMap();
        Iterator<o> r101 = this.f91969a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        o r102 = r101.next();
        Object r103 = r102.f91957c;
        if (r103 == null) goto L4;
        r100.put(r102.f91956b, r103);
        goto L4
    L9:
        return new vc0.c(r100);
    }

    public final List<o> l() {
        return CollectionsKt.toList(this.f91969a);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("RtcUserList{cnt=");
        r100.append(this.f91969a.size());
        r100.append(",");
        CopyOnWriteArrayList<o> r101 = this.f91969a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((o) r103.next()).toString());
        goto L4
    L6:
        r100.append(r102);
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    }

    public p() {
        this.f91969a = new CopyOnWriteArrayList();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        this.f91969a.add(new o(r100, null, false, 8190));
        int r101 = w51.a.f558315a;
        String r102 = "add " + r100 + ", current=" + this.f91969a;
        Intrinsics.checkNotNullParameter("ttlive_anchor_link_rtc_user", "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        ALogger.w("ttlive_anchor_link_rtc_user", r102);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        int r101 = w51.a.f558315a;
        w51.a.C8068a.b("ttlive_anchor_link_rtc_user", "clear rtc users " + r100);
        this.f91969a.clear();
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        boolean r101 = this.f91969a.remove(k(r100));
        int r102 = w51.a.f558315a;
        String r103 = "remove " + r100 + ' ' + r101 + ", current=" + this.f91969a;
        Intrinsics.checkNotNullParameter("ttlive_anchor_link_rtc_user", "tag");
        Intrinsics.checkNotNullParameter(r103, "msg");
        ALogger.w("ttlive_anchor_link_rtc_user", r103);
    }

    public final o k(String r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<T> r102 = this.f91969a.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((o) r103).f91956b, r100) == false) goto L7;
        r101 = r103;
    L12:
        return (o) r101;
    }

    public final void g(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        o r102 = k(r100);
        if (r102 == null) goto L6;
        r102.f91960f = r101;
        return;
    }

    public final void h(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        o r102 = k(r100);
        if (r102 == null) goto L6;
        r102.f91959e = r101;
        return;
    }

    public final void i(String r100, Pair<Integer, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r101, QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE);
        o r102 = k(r100);
        if (r102 == null) goto L6;
        r102.f91963i = r101;
        return;
    }

    public final void e(String r100, Object r101, Pair<Integer, Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r102, QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE);
        if (k(r100) != null) goto L5;
        a(r100);
    L5:
        o r103 = k(r100);
        if (r103 == null) goto L9;
        r103.f91957c = r101;
        r103.f91963i = r102;
        return;
    }

    public final void f(String r100, Object r101, Pair<Integer, Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r102, QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE);
        if (k(r100) != null) goto L5;
        a(r100);
    L5:
        o r103 = k(r100);
        if (r103 == null) goto L11;
        r103.f91958d = true;
        if ((true ^ Intrinsics.areEqual(r103.f91957c, r101)) == false) goto L12;
        r103.f91957c = r101;
        r103.f91963i = r102;
        return;
    L12:
        return;
    }
}
