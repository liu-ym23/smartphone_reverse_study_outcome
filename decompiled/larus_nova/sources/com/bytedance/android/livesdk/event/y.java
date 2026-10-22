package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y implements ISendCommentEvent, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f123377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f123378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ISendCommentEvent.Sender f123379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f123380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f123381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f123382f;

    public final int hashCode() {
        String r100 = this.f123377a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f123378b) * 31;
        ISendCommentEvent.Sender r104 = this.f123379c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f123380d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        m r110 = this.f123381e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        q r113 = this.f123382f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "SendBarrageEvent(content=" + this.f123377a + ", style=" + this.f123378b + ", sender=" + this.f123379c + ", args=" + this.f123380d + ", imageRelatedInfo=" + this.f123381e + ", mentionInfo=" + this.f123382f + ")";
    }

    @Override // com.bytedance.android.livesdk.event.ISendCommentEvent
    public final Map<String, Object> a() {
        return this.f123380d;
    }

    @Override // com.bytedance.android.livesdk.event.k
    public final m b() {
        return this.f123381e;
    }

    @Override // com.bytedance.android.livesdk.event.k
    public final q c() {
        return this.f123382f;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L18;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f123377a, r101.f123377a) == true) goto L8;
        return false;
    L8:
        if (this.f123378b == r101.f123378b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f123379c, r101.f123379c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f123380d, r101.f123380d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f123381e, r101.f123381e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f123382f, r101.f123382f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public /* synthetic */ y(String r100, ISendCommentEvent.Sender r101, Map r110) {
        this(r100, 0, r101, r110, null, null);
    }

    public y(String r100, int r101, ISendCommentEvent.Sender r102, Map<String, ? extends Object> r103, m r104, q r105) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r102, "sender");
        Intrinsics.checkNotNullParameter(r103, "args");
        this.f123377a = r100;
        this.f123378b = r101;
        this.f123379c = r102;
        this.f123380d = r103;
        this.f123381e = r104;
        this.f123382f = r105;
    }
}
