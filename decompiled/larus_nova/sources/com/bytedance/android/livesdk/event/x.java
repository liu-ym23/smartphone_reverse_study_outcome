package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class x implements ISendCommentEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f123374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ISendCommentEvent.Sender f123375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f123376c;

    public final int hashCode() {
        String r100 = this.f123374a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ISendCommentEvent.Sender r104 = this.f123375b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f123376c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SendAudioEvent(filePath=" + this.f123374a + ", sender=" + this.f123375b + ", args=" + this.f123376c + ")";
    }

    @Override // com.bytedance.android.livesdk.event.ISendCommentEvent
    public final Map<String, Object> a() {
        return this.f123376c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L12;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f123374a, r101.f123374a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f123375b, r101.f123375b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f123376c, r101.f123376c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public x(String r100, ISendCommentEvent.Sender r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, "sender");
        Intrinsics.checkNotNullParameter(r102, "args");
        this.f123374a = r100;
        this.f123375b = r101;
        this.f123376c = r102;
    }
}
