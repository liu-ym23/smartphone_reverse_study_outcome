package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.h2;
import com.bytedance.android.live.core.setting.i2;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p extends f {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f115578t;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f115579a;

        public a(p r100) {
            this.f115579a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wo1.i(this.f115579a);
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f115580a;

        public b(p r100) {
            this.f115580a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wo1.h(this.f115580a);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final void i() {
        super.i();
        vo1.i r100 = this.f115542e;
        if (r100 == null) goto L5;
        r100.registerMethod("loadShortTouch", new a(this));
    L5:
        DataCenter r101 = this.f115555r;
        String r102 = null;
        if (r101 == null) goto L8;
        IRoom r103 = (IRoom) r101.get("data_room", null);
    L9:
        if (r103 == null) goto L15;
        ShortTermIndicatorConfig r104 = r103.getShortTermIndicatorConfig();
        if (r104 == null) goto L15;
        Map<Integer, ShortTermIndicatorConfig.BigCardDisplayStrategy> r105 = r104.getBigCardDisplayStrategy();
        if (r105 == null) goto L15;
        ShortTermIndicatorConfig.BigCardDisplayStrategy r106 = r105.get(Integer.valueOf(this.f115554q.type));
    L16:
        if (r106 == null) goto L18;
        Boolean r107 = r106.getAllowRepeatDisplay();
    L20:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L27;
        if (h2.f65313a.getValue().booleanValue() == false) goto L27;
        vo1.i r108 = this.f115542e;
        if (r108 == null) goto L27;
        r108.registerMethod("live.loadShortTouchBigCard", new b(this));
    L27:
        if (i2.f65322a.getValue().booleanValue() == false) goto L33;
        j0.l().sendLog("livesdk_short_touch_jsb_registe", MapsKt.mapOf(TuplesKt.to("time_millisecond", String.valueOf(System.currentTimeMillis()))), new Object[]{Room.class, x.class});
        StringBuilder r109 = new StringBuilder("loadShortTouch ");
        com.bytedance.android.live.base.model.q r110 = this.f115554q.shortTouchInfo;
        if (r110 == null) goto L31;
        r102 = r110.loadUrl;
    L31:
        r109.append(r102);
        r109.append(" time_millisecond = ");
        r109.append(System.currentTimeMillis());
        ALogger.i("DynamicCommonIconModel", r109.toString());
        return;
    L33:
        return;
    L18:
        r107 = null;
    L15:
        r106 = null;
        goto L16
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final CommonIconTemplate f(int r100) {
        if (this.f115544g != null) goto L5;
        this.f115544g = d();
    L5:
        if (r100 == 0) goto L7;
        return null;
    L7:
        return this.f115544g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f, com.bytedance.android.livesdkapi.sti.framework.IIconModel
    public final /* bridge */ /* synthetic */ IconTemplate getViewForState(Object r100) {
        return f(((Number) r100).intValue());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final void k(com.bytedance.android.live.base.model.n r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        super.k(r100);
        DataCenter r101 = this.f115555r;
        Boolean r102 = null;
        if (r101 == null) goto L5;
        IRoom r103 = (IRoom) r101.get("data_room", null);
    L6:
        if (r103 == null) goto L12;
        ShortTermIndicatorConfig r104 = r103.getShortTermIndicatorConfig();
        if (r104 == null) goto L12;
        Map<Integer, ShortTermIndicatorConfig.BigCardDisplayStrategy> r105 = r104.getBigCardDisplayStrategy();
        if (r105 == null) goto L12;
        ShortTermIndicatorConfig.BigCardDisplayStrategy r106 = r105.get(Integer.valueOf(r100.type));
    L13:
        if (r106 == null) goto L16;
        r102 = r106.getAllowRepeatDisplay();
    L16:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == true) goto L18;
        return;
    L18:
        if (h2.f65313a.getValue().booleanValue() == false) goto L22;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f115554q = r100;
        return;
    L22:
        return;
    L12:
        r106 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public p(com.bytedance.android.live.base.model.n r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100, r101, 1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f
    public final void g(int r100, String r101, String r102, f.d r103) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "fallbackUrl");
        Intrinsics.checkNotNullParameter(r103, "callback");
        super.g(r100, r101, r102, r103);
        if (i2.f65322a.getValue().booleanValue() == false) goto L10;
        j0.l().sendLog("livesdk_short_touch_start_load", MapsKt.mapOf(TuplesKt.to("time_millisecond", String.valueOf(System.currentTimeMillis()))), new Object[]{Room.class, x.class});
        StringBuilder r104 = new StringBuilder("loadShortTouch ");
        com.bytedance.android.live.base.model.q r105 = this.f115554q.shortTouchInfo;
        if (r105 == null) goto L7;
        String r106 = r105.loadUrl;
    L8:
        r104.append(r106);
        r104.append(" time_millisecond = ");
        r104.append(System.currentTimeMillis());
        ALogger.i("DynamicCommonIconModel", r104.toString());
        return;
    L7:
        r106 = null;
        goto L8
    }
}
