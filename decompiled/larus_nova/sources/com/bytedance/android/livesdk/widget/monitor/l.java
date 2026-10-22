package com.bytedance.android.livesdk.widget.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements e80.a, e80.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f161862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f161863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f161864c;

    public l(DataCenter r100) {
        this.f161864c = r100;
        int r101 = a.f161840f;
        boolean r102 = false;
        if (com.bytedance.android.live.core.tetris.widgets.g.a() == false) goto L10;
        i91 r103 = com.bytedance.android.live.core.tetris.widgets.g.c();
        if (r103 == null) goto L7;
        boolean r104 = r103.d();
    L8:
        if (r104 == false) goto L10;
        boolean r105 = true;
    L11:
        c r106 = null;
        if (r105 == false) goto L14;
        a r107 = new a(r100);
    L15:
        this.f161862a = r107;
        int r108 = c.f161850d;
        if (com.bytedance.android.live.core.tetris.widgets.g.a() == false) goto L23;
        i91 r109 = com.bytedance.android.live.core.tetris.widgets.g.c();
        if (r109 == null) goto L20;
        boolean r110 = r109.e();
    L21:
        if (r110 == false) goto L23;
        r102 = true;
        goto L23
    L20:
        r110 = false;
    L23:
        if (r102 == false) goto L25;
        r106 = new c(r100);
    L25:
        this.f161863b = r106;
        if (r100 == null) goto L28;
        r100.observe("cmd_p0_widget_loaded", new d(this));
    L28:
        if (r100 == null) goto L30;
        r100.observe("cmd_p1_widget_loaded", new e(this));
    L30:
        if (r100 == null) goto L32;
        r100.observe("cmd_p2_widget_loaded", new f(this));
    L32:
        if (r100 == null) goto L34;
        r100.observe("cmd_widget_loaded", new g(this));
    L34:
        if (r100 == null) goto L36;
        r100.observe("cmd_p0_widget_loaded_v2", new h(this));
    L36:
        if (r100 == null) goto L38;
        r100.observe("cmd_p1_widget_loaded_v2", new i(this));
    L38:
        if (r100 == null) goto L40;
        r100.observe("cmd_p2_widget_loaded_v2", new j(this));
    L40:
        if (r100 == null) goto L43;
        r100.observe("cmd_widget_loaded_v2", new k(this));
        return;
    L43:
        return;
    L14:
        r107 = null;
        goto L15
    L7:
        r104 = false;
    L10:
        r105 = false;
        goto L11
    }

    @Override // e80.a
    public final void a(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onClear"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void b(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onResume"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void c(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onStop"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.b
    public final void d(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
    L10:
        c r102 = this.f161863b;
        if (r102 != null) goto L13;
        return;
    L13:
        if (r102.b(r100) == false) goto L18;
        r102.c(r100, LiveWidgetMetrics$recordLoadStart$1.INSTANCE);
        return;
    L18:
        return;
    L5:
        if (r100 == null) goto L8;
        String r103 = r100.getWidgetTag();
        if (r103 == null) goto L8;
    L9:
        r101.c(r103.concat("-loadStart"), r100);
    L8:
        r103 = "";
        goto L9
    }

    @Override // e80.a
    public final void e(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onStart"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void f(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        String r103 = r102.concat("-onExitClear");
        Intrinsics.checkNotNullParameter(r103, "msg");
        a.d(r101, r101.f161844d, r103, r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void g(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onInit"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.b
    public final void h(Widget r110) {
        Set<String> r100 = zv2.a.f573689a;
        DataCenter r101 = this.f161864c;
        if (r110 == null) goto L49;
        String r102 = r110.getClass().getSimpleName();
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        if (r103 != null) goto L7;
    L9:
        Set<String> r104 = zv2.a.f573689a;
    L10:
        ALogger.w("FSWidget", "the FSWidget " + r102 + " load finish");
        if (r103 == null) goto L17;
        com.bytedance.live.datacontext.m<Room> r105 = r103.getRoom();
        if (r105 == null) goto L17;
        Room r106 = r105.getValue();
        if (r106 == null) goto L17;
        long r107 = r106.getRoomId();
    L18:
        if (r103 == null) goto L24;
        com.bytedance.live.datacontext.m<Long> r108 = r103.getEnterRoomTimeStamp();
        if (r108 == null) goto L24;
        Long r109 = r108.getValue();
        if (r109 == null) goto L24;
        long r111 = r109.longValue();
    L26:
        if (r104.contains(r102) == false) goto L49;
        if (r107 == 0) goto L49;
        if (r101 == null) goto L32;
        Boolean r112 = (Boolean) r101.get("cmd_widget_is_show", Boolean.FALSE);
    L34:
        if (Intrinsics.areEqual(r112, Boolean.FALSE) == false) goto L36;
        r101.put("cmd_widget_is_show", Boolean.TRUE);
    L36:
        HashMap<Long, Integer> r113 = zv2.a.f573691c;
        Integer r114 = r113.get(Long.valueOf(r107));
        if (r114 != null) goto L39;
        r114 = 0;
    L39:
        r113.put(Long.valueOf(r107), Integer.valueOf(r114.intValue() + 1));
        Integer r115 = r113.get(Long.valueOf(r107));
        int r116 = r104.size();
        if (r115 == null) goto L49;
        if (r115.intValue() != r116) goto L49;
        if (r111 <= 0) goto L47;
        long r117 = System.currentTimeMillis() - r111;
        boolean r118 = fh1.e.f476961a;
        fh1.e.c(r107, String.valueOf(r117));
    L48:
        ALogger.w("FSWidget", "the FSWidget real load :::" + r117 + ' ');
        r113.put(Long.valueOf(r107), 0);
        goto L49
    L47:
        boolean r119 = fh1.e.f476961a;
        r117 = 1;
        fh1.e.c(r107, String.valueOf(1));
        goto L48
    L32:
        r112 = null;
    L24:
        r111 = -1;
    L17:
        r107 = 0;
        goto L18
    L7:
        if (r103.isVSOrMedia() != true) goto L9;
        r104 = zv2.a.f573690b;
    L49:
        a r120 = this.f161862a;
        if (r120 != null) goto L52;
    L57:
        final c r121 = this.f161863b;
        if (r121 != null) goto L60;
        return;
    L60:
        if (r121.b(r110) == false) goto L65;
        r121.c(r110, new LiveWidgetMetrics$recordLoadFinsih$1(r121));
        return;
    L65:
        return;
    L52:
        if (r110 == null) goto L55;
        String r122 = r110.getWidgetTag();
        if (r122 == null) goto L55;
    L56:
        r120.c(r122.concat("-loadFinish"), r110);
    L55:
        r122 = "";
        goto L56
    }

    @Override // e80.a
    public final void i(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onPause"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void j(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onUnLoad"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void k(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        String r103 = r102.concat("-onEnterClear");
        Intrinsics.checkNotNullParameter(r103, "msg");
        a.d(r101, r101.f161844d, r103, r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void l(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onCreate"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void onDestroy(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onDestroy"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // e80.a
    public final void onLoad(Widget r100) {
        a r101 = this.f161862a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        String r102 = r100.getWidgetTag();
        if (r102 == null) goto L8;
    L9:
        r101.b(r102.concat("-onLoad"), r100);
        return;
    L8:
        r102 = "";
        goto L9
    }
}
