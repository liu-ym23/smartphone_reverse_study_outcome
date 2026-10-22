package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r52.f4;

/* JADX INFO: loaded from: classes9.dex */
public final class TextMessageTracer implements s42.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f133629a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TextMessageTracer f133630b = null;

    public TextMessageTracer() {
    }

    @Override // s42.c
    public final void c() {
    }

    @Override // s42.c
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
    }

    @Override // s42.c
    public final void i() {
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
    }

    static {
        f133630b = new TextMessageTracer();
        f133629a = f4.f536180a.getValue().booleanValue();
    }

    public static void A(String r100) {
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a149.a999").addArg("info", r100), "TextMessageTracer");
    }

    public static final String u(com.bytedance.android.livesdk.interactivity.api.entity.f r100) {
        T r101 = r100.f133141b;
        if (r101 == 0) goto L6;
        String r102 = r101.getMessageMethod();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "UNKNOWN_PUBLIC_SCREEN_MESSAGE_TYPE";
    }

    public static final String v(tlc.d r100) {
        if ((r100 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.live.base.model.message.t r101 = (com.bytedance.android.live.base.model.message.t) r100;
        if (r101 == null) goto L9;
        String r102 = r101.getMessageMethod();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return "UNKNOWN_MESSAGE_TYPE";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String w(IWidget r100) {
        if (r100 == 0) goto L16;
        Widget r101 = (Widget) r100;
        ViewGroup r102 = r101.containerView;
        if (r102 != null) goto L6;
        return "";
    L6:
        if (r102.getLayoutParams() == null) goto L18;
        ViewGroup.LayoutParams r103 = r101.containerView.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        StringBuilder r104 = new StringBuilder("height: ");
        r104.append(r103.height);
        r104.append(", width: ");
        r104.append(r103.width);
        r104.append(", margin: (");
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r103;
        r104.append(r105.leftMargin);
        r104.append('-');
        r104.append(r105.topMargin);
        r104.append('-');
        r104.append(r105.rightMargin);
        r104.append('-');
        r104.append(r105.bottomMargin);
        r104.append(')');
        return r104.toString();
    L12:
        return "height: " + r103.height + ", width: " + r103.width;
    L18:
        return "";
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.Widget");
    }

    public static long x(com.bytedance.android.livesdk.interactivity.api.entity.f r100) {
        T r101 = r100.f133141b;
        if (r101 != 0) goto L7;
        return 0;
    L7:
        return r101.getMessageId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String y(IWidget r100) {
        if (r100 == 0) goto L14;
        Widget r101 = (Widget) r100;
        ViewGroup r102 = r101.containerView;
        int r103 = -1;
        if (r102 != null) goto L6;
        int r104 = -1;
    L7:
        View r105 = r101.contentView;
        if (r105 == null) goto L12;
        r103 = r105.getVisibility();
    L12:
        return "container state: " + r104 + ", content state: " + r103;
    L6:
        r104 = r102.getVisibility();
        goto L7
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.Widget");
    }

    public static void z(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
        return;
    L5:
        ALogger.i("TextMessageTracer", (String) r100.invoke());
    }

    @Override // s42.c
    public final void b(int r100) {
        A("unknown message view type: " + r100);
    }

    @Override // s42.c
    public final void d(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        B(x(r100), new TextMessageTracer$onMessageDiscardedByInterceptor$1$1(r100));
    }

    @Override // s42.c
    public final void e(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        if (r100 == null) goto L5;
        B(x(r100), new TextMessageTracer$onMessageDiscardedByOverTime$1$1(r100));
        return;
    }

    @Override // s42.c
    public final void f(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        if (r100 == null) goto L5;
        B(x(r100), new TextMessageTracer$onMessageDiscardedByFoldStrategy$1$1(r100));
        return;
    }

    @Override // s42.c
    public final void h(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        if (r100 == null) goto L5;
        B(x(r100), new TextMessageTracer$onMessageDiscardedByScore$1$1(r100));
        return;
    }

    @Override // s42.c
    public final void k(final tlc.d r100) {
        if (r100 == null) goto L5;
        B(r100.getMessageId(), new TextMessageTracer$onLiveMessageDiscardedByConverter$1$1(r100));
        return;
    }

    @Override // s42.c
    public final void l(final tlc.d r100) {
        if (r100 == null) goto L5;
        B(r100.getMessageId(), new TextMessageTracer$onLiveMessageReceived$1$1(r100));
        return;
    }

    @Override // s42.c
    public final void n(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        if (r100 == null) goto L5;
        B(x(r100), new TextMessageTracer$onMessageShowedInList$1$1(r100));
        return;
    }

    @Override // s42.c
    public final void o(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        B(x(r100), new TextMessageTracer$onMessageShowInFold$1$1(r100));
    }

    @Override // s42.c
    public final void p(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        B(x(r100), new TextMessageTracer$onMessageAddToPublicScreen$1$1(r100));
    }

    @Override // s42.c
    public final void q(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        if (r100 == null) goto L5;
        B(x(r100), new TextMessageTracer$onMessageDiscardedByBufferLimit$1$1(r100));
        return;
    }

    @Override // s42.c
    public final void t(final tlc.d r100) {
        if (r100 == null) goto L5;
        B(r100.getMessageId(), new TextMessageTracer$onLiveMessageDiscardedByPrimaryFilter$1$1(r100));
        return;
    }

    public static void B(long r100, Function0 r101) {
        if (f133629a == true) goto L5;
        return;
    L5:
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a149.a100").businessId(String.valueOf(r100)).addArg("info", r101.invoke()), "TextMessageTracer");
    }

    public static void C(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cause");
        Intrinsics.checkNotNullParameter(r101, "result");
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a149.a999").addArg("info", "widget visible state changed, cause by: " + r100 + ", changed to " + r101), "TextMessageTracer");
    }

    @Override // s42.c
    public final void j(IWidget r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "cause");
        A("widget visible state changed, cause by: " + r101 + ", " + y(r100));
    }

    @Override // s42.c
    public final void s(IWidget r100, IRoom r101, s42.c.b r102) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "room");
        StringBuilder r103 = new StringBuilder("widget unloaded, roomId: ");
        r103.append(r101.getId());
        r103.append(", ");
        r103.append(y(r100));
        r103.append(", ");
        r103.append(w(r100));
        r103.append(", ");
        Context r104 = r100.getContext();
        if (r104 == null) goto L7;
        ContentResolver r105 = r104.getContentResolver();
        if (r105 == null) goto L7;
        String r106 = "animationScale: " + Settings.Global.getFloat(r105, "animator_duration_scale", 1.0f);
    L8:
        r103.append(r106);
        A(r103.toString());
        return;
    L7:
        r106 = "null";
        goto L8
    }

    @Override // s42.c
    public final void a(TextMessageWidget r100, IRoom r101, boolean r102, boolean r103, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r104) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r104, "publicScreenData");
        A("widget loaded, roomId: " + r101.getId() + ", isPortrait: " + r103 + ", " + y(r100) + ", " + w(r100));
        ViewGroup r105 = r100.containerView;
        if (r105 == null) goto L7;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L7;
        int r107 = r106.height;
    L9:
        if (r107 != 0) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == false) goto L25;
        LiveTracingMonitor.EventModule r109 = LiveTracingMonitor.EventModule.TEXT_MESSAGE;
        JSONObject r110 = new JSONObject();
        r110.put("category_1", "component_load");     // Catch: JSONException -> L19
    L23:
        r110.put("category_2", "");     // Catch: JSONException -> L20
    L17:
        LiveMonitor r111 = new LiveMonitor();
        r111.mCategory = r110;
        r111.mEventModule = r109;
        r111.mServiceName = "ttlive_text_message_height_zero_error";
        r111.mExtraLog = null;
        r111.mMetrics = null;
        LiveMonitor.access$002(r111, false);
        LiveMonitor.access$102(r111, false);
        LiveMonitor.access$202(r111, true);
        LiveMonitor.access$302(r111, false);
        LiveMonitor.access$402(r111, false);
        r111.report();
        return;
    L25:
        return;
    L11:
        r108 = false;
    L7:
        r107 = Integer.MIN_VALUE;
        goto L9
    }
}
