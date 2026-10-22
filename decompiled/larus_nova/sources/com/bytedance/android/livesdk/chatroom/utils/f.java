package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Deprecated;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated(message = "资料卡已迁移，profile目录中代码废弃")
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f114457a = 0;

    public f() {
    }

    static {
    }

    public static e a(Function0 r100, Function0 r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L9;
        r101 = null;
    L9:
        return new e(false, r100, r101);
    }
}
