package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<Integer> f116217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<ToolbarComponentCheckInterface> f116218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<NewToolbarButtonConstants, Runnable> f116219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f116220d;

    public y() {
        this.f116217a = new HashSet();
        this.f116218b = new SparseArray();
        this.f116219c = new HashMap();
        this.f116220d = "NewToolbarLog";
    }

    public final void a(s r100, Function0<Unit> r101, Function1<? super String, Unit> r102) {
        ToolbarComponentCheckInterface r103 = this.f116218b.get(r100.f116191a);
        if (r103 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r103.checkThenLoad(r100, r101, r102));
    L6:
        Boolean r105 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r104, r105)) == false) goto L10;
        r101.invoke();
    L10:
        if (Intrinsics.areEqual(r104, r105) == false) goto L13;
        ALogger.i(this.f116220d, "component handle! - " + r100);
        return;
    L13:
        if (Intrinsics.areEqual(r104, Boolean.FALSE) == false) goto L15;
        ALogger.i(this.f116220d, "component don't handle! - " + r100);
        return;
    L15:
        if (r104 != null) goto L20;
        ALogger.i(this.f116220d, "no component filter - " + r100);
        return;
    L20:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
