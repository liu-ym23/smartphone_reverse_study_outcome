package com.bytedance.applet.debugger;

import com.bytedance.ai.api.DebuggerMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f191759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DebuggerMode f191760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f191761d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f191758a, r101.f191758a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f191759b, r101.f191759b) == true) goto L15;
        return false;
    L15:
        if (this.f191760c == r101.f191760c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f191761d, r101.f191761d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f191758a.hashCode() * 31) + this.f191759b.hashCode()) * 31) + this.f191760c.hashCode()) * 31) + this.f191761d.hashCode();
    }

    public final String toString() {
        return "DebuggerConversationCreateRequest(botId=" + this.f191758a + ", sourceConversationId=" + this.f191759b + ", mode=" + this.f191760c + ", entryFrom=" + this.f191761d + ')';
    }

    public w(String r100, String r101, DebuggerMode r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r102, "mode");
        Intrinsics.checkNotNullParameter(r103, "entryFrom");
        this.f191758a = r100;
        this.f191759b = r101;
        this.f191760c = r102;
        this.f191761d = r103;
    }
}
