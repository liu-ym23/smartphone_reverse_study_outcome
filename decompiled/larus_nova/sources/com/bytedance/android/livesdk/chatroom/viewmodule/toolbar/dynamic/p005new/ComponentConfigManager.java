package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ComponentConfigManager implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<a0> f116134a;

    public final void b() {
        int r100 = this.f116134a.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.f116134a.valueAt(r101).p();
        r101 = r101 + 1;
        goto L3
    L5:
        this.f116134a.clear();
    }

    public ComponentConfigManager() {
        this.f116134a = new SparseArray();
    }

    public final void c(String r100) {
        ALogger.i(a.f116165b.getTAG(), "config: " + r100);
    }

    public final void d(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        int r101 = ((NewToolbarButtonConstants) r100.f115964b.getValue()).getId();
        ALogger.i(a.f116165b.getTAG(), "register config id: " + r101);
        this.f116134a.put(r101, r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final a0 getToolbarConfig(int r100) {
        return this.f116134a.get(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final void register(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        d(r100);
    }

    public final boolean a(final s r100, boolean r101, boolean r102, final DataCenter r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r104 = r100.f116191a;
        a0 r105 = this.f116134a.get(r104);
        Function1<String, Unit> r106 = new ComponentConfigManager$canLoad$errorReport$1(r100, r103);
        if (r105 != null) goto L7;
        HashMap<String, String> r107 = q.f116173a;
        q.a(r104, ToolbarReasonTag.CONFIG_ERROR, " can't find config");
        c(r100 + " can't find config");
        a r108 = a.f116165b;
        r108.g(r100.f116191a, r108.e(), "NotFoundConfig");
        r106.invoke(ErrorReason.NOT_FOUND_CONFIG.getValue());
        return false;
    L7:
        if (r105.l(r101, false) != null) goto L11;
        c(" button is null.");
        HashMap<String, String> r109 = q.f116173a;
        q.a(r104, ToolbarReasonTag.CONFIG_ERROR, " local button is null");
        r106.invoke(ErrorReason.LOCAL_BUTTON_IS_NULL.getValue());
        return false;
    L11:
        if (r105.c(r100, r102, r101) == true) goto L14;
        c("behavior is null");
        HashMap<String, String> r110 = q.f116173a;
        q.a(r104, ToolbarReasonTag.CONFIG_ERROR, " behavior is null");
        r106.invoke(ErrorReason.BEHAVIOR_IS_NULL.getValue());
        return false;
    L14:
        return true;
    }
}
