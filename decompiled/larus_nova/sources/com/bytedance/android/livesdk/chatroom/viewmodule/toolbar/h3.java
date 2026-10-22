package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f116321a = null;

    static {
        f116321a = com.bytedance.android.livesdk.sharedpref.b.f158193p0.getValue();
    }

    @JvmStatic
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return f116321a.contains(r100);
    }

    @JvmStatic
    public static final void b(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Set<String> r102 = f116321a;
        r102.add(r101);
        com.bytedance.android.livesdk.sharedpref.e<Set<String>> r103 = com.bytedance.android.livesdk.sharedpref.b.f158193p0;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, r102);
        y3.m(r100).b(ToolbarButton.INTERACT_GAME, new pp1.e());
    }
}
