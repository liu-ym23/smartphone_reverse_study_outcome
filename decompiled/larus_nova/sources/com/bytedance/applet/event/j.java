package com.bytedance.applet.event;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class j implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IMAppAction f191825a;

    public /* synthetic */ j(IMAppAction r100) {
        this.f191825a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r210) {
        IMAppAction r100 = this.f191825a;
        String r101 = (String) r210;
        jw3.c r102 = jw3.c.f500706a;
        jw3.a r103 = jw3.c.a();
        if (r103 == null) goto L5;
        r103.i(r100.getMessageId());
    L5:
        ConcurrentHashMap r104 = (ConcurrentHashMap) EventDispatcher.f191776c;
        if (r104.containsKey(r100.getMessageId()) == true) goto L8;
        boolean r105 = false;
    L42:
        return Boolean.valueOf(r105);
    L8:
        r104.remove(r100.getMessageId());
        LocalPluginService r106 = LocalPluginService.f191791a;
        Integer r107 = null;
        AppAction r110 = new AppAction(r107, new IMAppAction(null, r100.getMessageId(), r100.getQuestionId(), null, r101, 2, null, 73, null), 1, null == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(r110, "appAction");
        IMAppAction r108 = r110.getAction();
        if (r108 == null) goto L11;
        Long r109 = r108.getMessageId();
    L12:
        jw3.e r111 = jw3.c.f500709d.get();
        if (r111 == null) goto L15;
        com.bytedance.ai.utils.j.a r112 = r111.h(r109);
    L16:
        LocalPluginService.f191805o.set(true);
        BuildersKt.launch$default(LocalPluginService.f191801k, LocalPluginService.f191803m, null, new LocalPluginService$singleRun$1(new LocalPluginService$sendAppAction$1(r110, r112, r111, r109, null), null), 2, null);
        jw3.a r113 = jw3.c.a();
        if (r113 == null) goto L40;
        Long r114 = r100.getQuestionId();
        String r115 = "";
        if (r114 == null) goto L22;
        String r116 = r114.toString();
        if (r116 == null) goto L22;
    L23:
        IMAppAction.b r117 = r100.getMpParam();
        if (r117 == null) goto L27;
        String r118 = r117.c();
        if (r118 == null) goto L27;
    L28:
        IMAppAction.b r119 = r100.getMpParam();
        if (r119 == null) goto L32;
        String r120 = r119.d();
        if (r120 == null) goto L32;
    L33:
        IMAppAction.b r121 = r100.getMpParam();
        if (r121 == null) goto L39;
        String r122 = r121.h();
        if (r122 == null) goto L39;
        r115 = r122;
    L39:
        r113.j(r116, r118, r120, r115);
    L32:
        r120 = "";
    L27:
        r118 = "";
    L22:
        r116 = "";
    L40:
        r105 = true;
        goto L42
    L15:
        r112 = null;
        goto L16
    L11:
        r109 = null;
        goto L12
    }
}
