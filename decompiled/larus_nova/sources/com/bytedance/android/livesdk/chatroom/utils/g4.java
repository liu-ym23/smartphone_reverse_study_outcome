package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g4 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f114481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g4 f114482b = null;

    public g4() {
    }

    static {
        f114482b = new g4();
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.h
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        h r101 = f114481a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.h
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        h r101 = f114481a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
