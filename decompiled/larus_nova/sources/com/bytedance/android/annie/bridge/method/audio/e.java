package com.bytedance.android.annie.bridge.method.audio;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.live.browser.jsbridge.base.StartSpeechRecognitionResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ttnet.TTNetInit;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import w20.df;
import w20.t6;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "startSpeechRecognition")
public final class e extends t6<df, StartSpeechRecognitionResultModel> implements a.InterfaceC0724a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSBridgeManager f38566a;

    public e(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        JSBridgeManager r101 = (JSBridgeManager) r100.c(JSBridgeManager.class);
        if (r101 == null) goto L6;
        this.f38566a = r101;
        return;
    }

    @Override // com.bytedance.android.annie.bridge.method.audio.a.InterfaceC0724a
    public final void d(boolean r100) {
        StartSpeechRecognitionResultModel r101 = new StartSpeechRecognitionResultModel();
        if (r100 == false) goto L5;
        r101.a(StartSpeechRecognitionResultModel.Code.Success);
    L6:
        finishWithResult(r101);
        return;
    L5:
        r101.a(StartSpeechRecognitionResultModel.Code.Failed);
        r101.b("ASR setup failed");
        goto L6
    }

    public e(JSBridgeManager r100) {
        this.f38566a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        df r100 = (df) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        StartSpeechRecognitionResultModel r101 = new StartSpeechRecognitionResultModel();
        Boolean r102 = r100.l();
        Boolean r103 = Boolean.TRUE;
        boolean r104 = false;
        int r105 = 1;
        a r106 = null;
        if (Intrinsics.areEqual(r102, r103) == true) goto L17;
        String r107 = r100.b();
        if (r107 != null) goto L7;
    L10:
        boolean r108 = true;
    L11:
        if (r108 == false) goto L13;
        boolean r109 = false;
    L14:
        if (r109 == true) goto L17;
        r101.a(StartSpeechRecognitionResultModel.Code.InvalidParameter);
        r101.b("invalid appKey");
        finishWithResult(r101);
        return;
    L13:
        b8.a r112 = b8.a.f17992a;
        b8.a.a(new b8.b("StartSpeechRecognitionMethod", LogLevel.INFO, null, "StartSpeechRecognitionMethod: " + r100.b()), true);
        r109 = true;
        goto L14
    L7:
        if (r107.length() == 0) goto L10;
        r108 = false;
    L17:
        if (Intrinsics.areEqual(r100.l(), r103) == true) goto L37;
        if (r100.j() == null) goto L24;
        Integer r113 = r100.j();
        Intrinsics.checkNotNull(r113);
        if (r113.intValue() > 0) goto L24;
    L32:
        boolean r114 = false;
    L34:
        if (r114 == true) goto L37;
        r101.a(StartSpeechRecognitionResultModel.Code.InvalidParameter);
        finishWithResult(r101);
        return;
    L24:
        if (r100.e() == null) goto L29;
        Integer r115 = r100.e();
        Intrinsics.checkNotNull(r115);
        if (r115.intValue() <= 0) goto L32;
    L29:
        if (r100.k() == null) goto L33;
        Integer r116 = r100.k();
        Intrinsics.checkNotNull(r116);
        if (r116.intValue() <= 0) goto L32;
    L33:
        r114 = true;
    L37:
        if (com.bytedance.android.annie.bridge.method.permission.c.a(r111.getContext(), "android.permission.RECORD_AUDIO") == true) goto L40;
        r101.a(StartSpeechRecognitionResultModel.Code.UnauthorizedAccess);
        finishWithResult(r101);
        return;
    L40:
        if (TTNetInit.getEffectiveConnectionType() <= 1) goto L42;
        boolean r117 = true;
    L43:
        if (r117 == true) goto L46;
        r101.a(StartSpeechRecognitionResultModel.Code.NetworkUnreachable);
        r101.b("Network unreachable");
        finishWithResult(r101);
        return;
    L46:
        if (Intrinsics.areEqual(r100.l(), r103) == true) goto L92;
        WeakHashMap<View, a> r118 = a.f38544k;
        JSBridgeManager r119 = this.f38566a;
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "params");
        View r120 = r111.f249269d;
        if (r120 == null) goto L84;
        WeakHashMap<View, a> r121 = a.f38544k;
        a r122 = r121.get(r120);
        if (r122 == null) goto L62;
        r122.f38545a = r119;
        r122.f38546b = this;
        r122.f38547c = r111;
        r122.f38548d = r100.b();
        Integer r123 = r100.k();
        if (r123 == null) goto L54;
        r123.intValue();
    L54:
        r122.getClass();
        Integer r124 = r100.e();
        if (r124 == null) goto L57;
        r124.intValue();
    L57:
        r122.getClass();
        Integer r125 = r100.j();
        if (r125 == null) goto L60;
        r125.intValue();
    L60:
        r122.getClass();
    L80:
        r106 = r121.get(r120);
        goto L84
    L62:
        monitor-enter(a.class);
    L81:
        th = move-exception;
        throw th;
    L64:
        if (r121.get(r120) != null) goto L78;
        String r126 = r100.b();     // Catch: Throwable -> L81
        Integer r127 = r100.k();     // Catch: Throwable -> L81
        if (r127 == null) goto L68;
        int r128 = r127.intValue();     // Catch: Throwable -> L81
    L69:
        Integer r129 = r100.e();     // Catch: Throwable -> L81
        if (r129 == null) goto L72;
        int r130 = r129.intValue();     // Catch: Throwable -> L81
    L73:
        Integer r131 = r100.j();     // Catch: Throwable -> L81
        if (r131 == null) goto L76;
        int r132 = r131.intValue();     // Catch: Throwable -> L81
    L77:
        r121.put(r120, new a(r119, this, r111, r126, r128, r130, r132));     // Catch: Throwable -> L81
        goto L78
    L76:
        r132 = 60000;
        goto L77
    L72:
        r130 = 1500;
        goto L73
    L68:
        r128 = 6000;
    L78:
        Unit r133 = Unit.INSTANCE;     // Catch: Throwable -> L81
        monitor-exit(a.class);
    L84:
        if (r106 != null) goto L86;
        return;
    L86:
        if (r106.f38550f != null) goto L88;
        PthreadHandlerThreadV2 r134 = new PthreadHandlerThreadV2("Audio_Process");
        ThreadMethodProxy.start(r134);
        r106.f38551g = new Handler(r134.getLooper(), r106);
        r106.f38550f = r134;
        Unit r135 = Unit.INSTANCE;
    L88:
        Handler r136 = r106.f38551g;
        if (r136 == null) goto L91;
        r136.sendMessage(r136.obtainMessage(103));
    L91:
        a.a("startAsrAudio");
        return;
    L92:
        Context r137 = r111.getContext().getApplicationContext();
        Intrinsics.checkNotNull(r137, "null cannot be cast to non-null type android.app.Application");
        Application r138 = (Application) r137;
        String r139 = r100.d();
        if (r139 != null) goto L95;
    L98:
        boolean r140 = true;
    L99:
        if (r140 == false) goto L101;
        String r141 = ";key domain can not be empty";
    L102:
        String r142 = r100.f();
        if (r142 != null) goto L105;
    L108:
        boolean r143 = true;
    L109:
        if (r143 == false) goto L111;
        r141 = r141.concat(";key path can not be empty");
    L111:
        String r144 = r100.a();
        if (r144 != null) goto L114;
    L117:
        boolean r145 = true;
    L118:
        if (r145 == false) goto L120;
        r141 = r141 + ";key appId can not be empty";
    L120:
        String r146 = r100.c();
        if (r146 != null) goto L123;
    L126:
        boolean r147 = true;
    L127:
        if (r147 == false) goto L129;
        r141 = r141 + ";key appToken can not be empty";
    L129:
        String r148 = r100.h();
        if (r148 != null) goto L132;
    L135:
        boolean r149 = true;
    L136:
        if (r149 == false) goto L139;
        r141 = r141 + ";key resourceId can not be empty";
    L139:
        if (r141.length() != 0) goto L141;
        r104 = true;
    L141:
        if (r104 == false) goto L143;
        Intrinsics.checkNotNull(r139);
        Intrinsics.checkNotNull(r142);
        Intrinsics.checkNotNull(r144);
        Intrinsics.checkNotNull(r146);
        Intrinsics.checkNotNull(r148);
        a9.a r150 = new a9.a(r139, r142, r144, r146, r148);
    L145:
        if (Intrinsics.areEqual(r100.i(), r103) == false) goto L149;
        if (r150 == null) goto L149;
        r138.getCacheDir().getAbsolutePath();
    L149:
        JsonObject r151 = r100.g();
        if (r151 != null) goto L152;
    L156:
        Pair r152 = new Pair(r150, r141);
        if (r152.getFirst() != null) goto L159;
        r101.a(StartSpeechRecognitionResultModel.Code.InvalidParameter);
        r101.b((String) r152.getSecond());
        finishWithResult(r101);
        return;
    L159:
        new Ref.ObjectRef().element = "";
        AsrState r153 = f7.c.f475743a;
        Context r154 = r111.getContext().getApplicationContext();
        Intrinsics.checkNotNull(r154, "null cannot be cast to non-null type android.app.Application");
        Application r155 = (Application) r154;
        Object r156 = r152.getFirst();
        Intrinsics.checkNotNull(r156);
        a9.a r157 = (a9.a) r156;
        d r158 = new d();
        Intrinsics.checkNotNullParameter(r155, "application");
        Intrinsics.checkNotNullParameter(r157, "settings");
        Intrinsics.checkNotNullParameter(r158, "listener");
        if (f7.c.f475743a != AsrState.NONE) goto L166;
        r105 = 2;
        a9.e r159 = (a9.e) Annie.getService$default(a9.e.class, null, 2, null);
        if (r159 == null) goto L166;
        r159.v(r155, r157, new f7.b(r158));
        r105 = 3;
    L166:
        if (r105 == 0) goto L168;
        r101.a(StartSpeechRecognitionResultModel.Code.Failed);
        r101.b("init or start failed with code " + r105);
        finishWithResult(r101);
        return;
    L168:
        r101.a(StartSpeechRecognitionResultModel.Code.Success);
        r101.b("success");
        finishWithResult(r101);
        return;
    L152:
        if (r151.size() <= 0) goto L156;
        if (r150 == null) goto L156;
        r151.toString();
        goto L156
    L143:
        r150 = null;
        goto L145
    L132:
        if (r148.length() == 0) goto L135;
        r149 = false;
        goto L136
    L123:
        if (r146.length() == 0) goto L126;
        r147 = false;
        goto L127
    L114:
        if (r144.length() == 0) goto L117;
        r145 = false;
        goto L118
    L105:
        if (r142.length() == 0) goto L108;
        r143 = false;
        goto L109
    L101:
        r141 = "";
        goto L102
    L95:
        if (r139.length() == 0) goto L98;
        r140 = false;
        goto L99
    L42:
        r117 = false;
        goto L43
    }
}
