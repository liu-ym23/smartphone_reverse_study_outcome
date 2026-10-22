package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.ILinkerDetailKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f92303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IRoomLinkExt f92304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f92305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f92306d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f92303a, r101.f92303a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92304b, r101.f92304b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92305c, r101.f92305c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f92306d, r101.f92306d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Map<String, Long> r100 = this.f92303a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IRoomLinkExt r104 = this.f92304b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        u r107 = this.f92305c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        r r110 = this.f92306d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("EnterRoomLinkInfo{");
        r100.append("linkMap=" + this.f92303a);
        IRoomLinkExt r101 = this.f92304b;
        if (r101 == null) goto L8;
        z5 r102 = IRoomKt_androidKt.getLinkerDetailKt(r101);
        if (r102 == null) goto L8;
        r100.append(",playModes=" + ILinkerDetailKt.getPlayModesEx(r102));
    L8:
        if (this.f92305c == null) goto L10;
        r100.append("," + this.f92305c);
    L32:
        return r100.toString();
    L10:
        Map<String, Long> r103 = this.f92303a;
        if (r103 == null) goto L32;
        if (r103.containsKey(String.valueOf(1)) != true) goto L32;
        if (this.f92304b == null) goto L30;
        StringBuilder r104 = new StringBuilder(", ");
        String r105 = null;
        if (this.f92304b.getLinkMicInfo() == null) goto L22;
        a9 r106 = this.f92304b.getLinkMicInfo();
        if (r106 == null) goto L21;
        String r107 = ef2.a.c(r106);
    L23:
        r104.append(r107);
        r100.append(r104.toString());
        StringBuilder r108 = new StringBuilder(", ");
        if (IRoomKt_androidKt.getLinkerDetailKt(this.f92304b) == null) goto L28;
        z5 r109 = IRoomKt_androidKt.getLinkerDetailKt(this.f92304b);
        if (r109 == null) goto L29;
        r105 = ef2.a.c(r109);
    L29:
        r108.append(r105);
        r100.append(r108.toString());
        goto L32
    L28:
        r105 = "linker_detail=null";
        goto L29
    L21:
        r107 = null;
        goto L23
    L22:
        r107 = "link_mic=null";
        goto L23
    L30:
        r100.append(", linkRoom is null");
        goto L32
    }

    public c(Map<String, Long> r100, IRoomLinkExt r101, u r102, r r103) {
        this.f92303a = r100;
        this.f92304b = r101;
        this.f92305c = r102;
        this.f92306d = r103;
    }
}
