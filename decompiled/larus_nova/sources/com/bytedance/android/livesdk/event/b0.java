package com.bytedance.android.livesdk.event;

import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 implements ISendCommentEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f123320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f123321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ISendCommentEvent.Sender f123322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f123323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f123324e;

    public final int hashCode() {
        long r100 = this.f123320a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f123321b) * 31;
        ISendCommentEvent.Sender r102 = this.f123322c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        Map<String, Object> r106 = this.f123323d;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        Object r109 = this.f123324e;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        return r108 + r103;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "SendOGCFixedEmojiEvent(emojiId=" + this.f123320a + ", type=" + this.f123321b + ", sender=" + this.f123322c + ", args=" + this.f123323d + ", commentFlowContext=" + this.f123324e + ")";
    }

    @Override // com.bytedance.android.livesdk.event.ISendCommentEvent
    public final Map<String, Object> a() {
        return this.f123323d;
    }

    public final int getType() {
        return this.f123321b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L16;
        b0 r101 = (b0) r100;
        if (this.f123320a == r101.f123320a) goto L8;
        return false;
    L8:
        if (this.f123321b == r101.f123321b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f123322c, r101.f123322c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f123323d, r101.f123323d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f123324e, r101.f123324e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public b0(long r100, ISendCommentEvent.Sender r101, Map r102, CommentFlowContext r103) {
        Intrinsics.checkNotNullParameter(r101, "sender");
        Intrinsics.checkNotNullParameter(r102, "args");
        this.f123320a = r100;
        this.f123321b = 3;
        this.f123322c = r101;
        this.f123323d = r102;
        this.f123324e = r103;
    }
}
