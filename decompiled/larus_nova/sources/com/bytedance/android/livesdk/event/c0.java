package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c0 implements ISendCommentEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f123328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f123329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f123330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f123331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ISendCommentEvent.Sender f123332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f123333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f123334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f123335h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        long r100 = this.f123328a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f123329b) * 31) + this.f123330c) * 31;
        boolean r102 = this.f123331d;
        ?? r103 = r102;
        if (r102 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r101 + r103) * 31;
        ISendCommentEvent.Sender r105 = this.f123332e;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        Map<String, Object> r109 = this.f123333f;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        Object r112 = this.f123334g;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        Map<String, String> r115 = this.f123335h;
        if (r115 == null) goto L21;
        r106 = r115.hashCode();
    L21:
        return r114 + r106;
    L16:
        r113 = 0;
        goto L17
    L12:
        r110 = 0;
        goto L13
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        return "SendSubscribeEmojiEvent(emojiId=" + this.f123328a + ", type=" + this.f123329b + ", ratioType=" + this.f123330c + ", isNew=" + this.f123331d + ", sender=" + this.f123332e + ", args=" + this.f123333f + ", commentFlowContext=" + this.f123334g + ", extraLogMap=" + this.f123335h + ")";
    }

    @Override // com.bytedance.android.livesdk.event.ISendCommentEvent
    public final Map<String, Object> a() {
        return this.f123333f;
    }

    public final int getType() {
        return this.f123329b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L22;
        c0 r101 = (c0) r100;
        if (this.f123328a == r101.f123328a) goto L8;
        return false;
    L8:
        if (this.f123329b == r101.f123329b) goto L10;
        return false;
    L10:
        if (this.f123330c == r101.f123330c) goto L12;
        return false;
    L12:
        if (this.f123331d == r101.f123331d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f123332e, r101.f123332e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f123333f, r101.f123333f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f123334g, r101.f123334g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f123335h, r101.f123335h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public c0(long r100, int r101, boolean r102, ISendCommentEvent.Sender r103, Map r104, Object r105, Map r106) {
        Intrinsics.checkNotNullParameter(r103, "sender");
        Intrinsics.checkNotNullParameter(r104, "args");
        this.f123328a = r100;
        this.f123329b = 3;
        this.f123330c = r101;
        this.f123331d = r102;
        this.f123332e = r103;
        this.f123333f = r104;
        this.f123334g = r105;
        this.f123335h = r106;
    }
}
