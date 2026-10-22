package com.bytedance.android.live.ktv.common.karaokestation.model;

import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.AddMusicControlNode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f69568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.music.control.b f69569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f69570c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L12;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f69568a, r101.f69568a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f69569b, r101.f69569b) == true) goto L10;
        return false;
    L10:
        if (this.f69570c == r101.f69570c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Context r100 = this.f69568a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.live.ktv.common.music.control.b r104 = this.f69569b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f69570c;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSongRequest(context=" + this.f69568a + ", node=" + this.f69569b + ", fromOutSide=" + this.f69570c + ")";
    }

    public final Context getContext() {
        return this.f69568a;
    }

    public v(Context r100, AddMusicControlNode r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "node");
        this.f69568a = r100;
        this.f69569b = r101;
        this.f69570c = true;
    }
}
