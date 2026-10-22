package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f116173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f116174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f116175c;

    static {
        f116173a = new HashMap();
        f116175c = -1;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        int r101 = f116175c;
        if (r101 == (-1)) goto L6;
        f116173a.put(String.valueOf(r101), ToolbarReasonTag.COMPONENT.getTag() + r100);
        return;
    }

    public static String c(int r100) {
        String r101 = f116173a.get(String.valueOf(r100));
        if (r101 != null) goto L6;
        r101 = "UnKnown";
    L6:
        if (f116174b == true) goto L8;
        return r101;
    L8:
        return r101.concat(" after unload");
    }

    public static void a(int r100, ToolbarReasonTag r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "reason");
        String r103 = String.valueOf(r100);
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "reason");
        f116173a.put(r103, r101.getTag() + r102);
    }
}
