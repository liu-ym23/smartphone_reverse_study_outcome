package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f59994c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f59995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OpenPlatformBaseDebugger f59996b;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.broadcastgame.opengame.i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f59997a;

        @Override // com.bytedance.android.live.broadcastgame.opengame.i.a
        public final void onInitSuccess() {
            d.b(this.f59997a);
        }

        public b(d r100) {
            this.f59997a = r100;
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.i.a
        public final void a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            d.a(this.f59997a, r100);
        }
    }

    static {
    }

    public d() {
    }

    public static final void b(d r100) {
        r100.f59995a = true;
        int r101 = q.f60744a;
        StringBuilder r102 = new StringBuilder("debugger 初始化成功，类型：");
        OpenPlatformBaseDebugger r103 = r100.f59996b;
        if (r103 == null) goto L5;
        String r104 = r103.getClass().getName();
    L6:
        r102.append(r104);
        q.g(r102.toString(), "OP_Debugger_Provider");
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final void a(d r100, Throwable r101) {
        r100.f59995a = false;
        OpenPlatformBaseDebugger r102 = r100.f59996b;
        if (r102 == null) goto L6;
        r102.releaseDebug();
    L6:
        if ((!Intrinsics.areEqual(r101.getMessage(), "OpenPlatformMiniAppDebugger 初始化失败。原因：小程序观众端不需要 debugger")) == false) goto L9;
        q.j(r101, "OP_Debugger_Provider", 4);
        return;
    }

    public final void c(PluginType r100, Context r110, DataCenter r111, ViewGroup r112, com.bytedance.android.live.broadcastgame.api.openplatform.b r113, Map<String, ? extends Object> r114) {
        Intrinsics.checkNotNullParameter(r100, "pluginType");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "dataCenter");
        Intrinsics.checkNotNullParameter(r112, "containerView");
        Intrinsics.checkNotNullParameter(r113, "gameManager");
        Intrinsics.checkNotNullParameter(r114, "extraParams");
        OpenPlatformBaseDebugger r101 = this.f59996b;
        if (r101 == null) goto L5;
        r101.releaseDebug();
    L5:
        OpenPlatformBaseDebugger r102 = null;
        this.f59996b = null;
        this.f59995a = false;
        int r103 = e.f60005a[r100.ordinal()];
        if (r103 != 1) goto L8;
    L13:
        r102 = new OpenPlatformLiveGameDebugManager();
    L14:
        OpenPlatformBaseDebugger r104 = r102;
        this.f59996b = r104;
        if (r104 == null) goto L17;
        r104.initDebug(r110, r111, r112, r113, r114, new b(this));
        return;
    L17:
        int r105 = q.f60744a;
        q.j(new Throwable("开平 debugger 创建失败，原因：没有适配的 debugger。"), "OP_Debugger_Provider", 4);
        return;
    L8:
        if (r103 == 2) goto L13;
        if (r103 != 3) goto L14;
        OpenPlatformMiniAppDebugger r106 = new OpenPlatformMiniAppDebugger();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r106.f59986f = r100;
        Unit r107 = Unit.INSTANCE;
        r102 = r106;
        goto L14
    }
}
