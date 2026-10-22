package com.bytedance.ai.bridge.method.log;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.music.applet.MusicAppletPage;
import d3.a0;
import e3.d;
import java.util.HashMap;
import java.util.Map;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f35533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsReportAppLogMethodIDL.a f35534b;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.log.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0689a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35535a = null;

        static {
            int[] r100 = new int[ContainerType.values().length];
            r100[ContainerType.WORKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ContainerType.PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f35535a = r100;
        }
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        a0 r101 = this.f35533a.getContainerContext();
        HashMap<String, Object> r102 = null;
        if (r101 == null) goto L5;
        ContainerType r103 = r101.getContainerType();
    L6:
        if (r103 != null) goto L8;
        int r104 = -1;
    L10:
        if (r104 != 1) goto L12;
        r100.m(AppletMonitorableEvent.EventOrigin.MainJS);
        AppletRuntime r105 = (AppletRuntime) this.f35533a.d(AppletRuntime.class);
        if (r105 == null) goto L47;
        r102 = r105.f36721j;
    L47:
        if (r105 == null) goto L54;
        Applet r106 = r105.f36719h;
        if (r106 == null) goto L54;
        String r107 = r106.N;
        if (r107 == null) goto L54;
        if (r102 == null) goto L54;
        int r108 = ReportAppLogMethod.f35531b;
        r102.put("bot_id", r107);
    L54:
        if (r102 == null) goto L56;
        r100.h(r102);
    L56:
        AppletRuntimeManager.INSTANCE.getClass();
        r100.d(LocationMonitorConst.IS_BACKGROUND, AppletRuntimeManager.f36751f ? 1 : 0);
        Map<String, ? extends Object> r109 = this.f35534b.getParams();
        if (r109 == null) goto L60;
        r100.h(r109);
        return;
    L60:
        return;
    L12:
        if (r104 != 2) goto L14;
        r100.m(AppletMonitorableEvent.EventOrigin.UI);
        WidgetContainer r110 = (WidgetContainer) this.f35533a.d(WidgetContainer.class);
        if (r110 == null) goto L34;
        r102 = r110.f38008a;
    L34:
        if (r110 == null) goto L39;
        String r111 = r110.l();
        if (r111 == null) goto L39;
        if (r102 == null) goto L39;
        int r112 = ReportAppLogMethod.f35531b;
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r111);
    L39:
        if (r110 == null) goto L54;
        String r113 = r110.getBotId();
        if (r113 == null) goto L54;
        if (r102 == null) goto L54;
        int r114 = ReportAppLogMethod.f35531b;
        r102.put("bot_id", r113);
        goto L54
    L14:
        if (r104 != 3) goto L54;
        r100.m(AppletMonitorableEvent.EventOrigin.UI);
        k2.j r115 = (k2.j) this.f35533a.d(k2.j.class);
        if (r115 == null) goto L19;
        r102 = r115.getEventCommonParams();
    L19:
        if (r115 == null) goto L24;
        String r116 = r115.getBotId();
        if (r116 == null) goto L24;
        if (r102 == null) goto L24;
        int r117 = ReportAppLogMethod.f35531b;
        r102.put("bot_id", r116);
    L24:
        if (r115 == null) goto L54;
        PageInfo r118 = r115.getPageInfo();
        if (r118 == null) goto L54;
        String r119 = r118.getMessageId();
        if (r119 == null) goto L54;
        if (r102 == null) goto L54;
        int r120 = ReportAppLogMethod.f35531b;
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r119);
        goto L54
    L8:
        r104 = C0689a.f35535a[r103.ordinal()];
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public a(d r100, AbsReportAppLogMethodIDL.a r101) {
        this.f35533a = r100;
        this.f35534b = r101;
    }
}
