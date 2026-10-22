package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import am2.b0;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.metrics.ReplayUILatch;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.room.error.IEndReason;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import fq1.j;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mq1.x;
import nic.p;
import org.json.JSONException;
import org.json.JSONObject;
import vr1.a0;

/* JADX INFO: loaded from: classes8.dex */
public final class ReplayVideoMetrics implements jm1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f118074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f118075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wr1.c f118076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.log.g f118077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wr1.d f118078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f118079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f118080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f118081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f118082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f118083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f118084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.session.video.h f118085l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ReplayEventHub f118086m;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayVideoMetrics$10, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/ReplayVideoMetrics$Behavior;", "Lkotlin/ParameterName;", "name", "behavior", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<Behavior, Unit> {
        public AnonymousClass10(ReplayVideoMetrics r100) {
            super(1, r100, ReplayVideoMetrics.class, "handleBackgroundBehavior", "handleBackgroundBehavior(Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/ReplayVideoMetrics$Behavior;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Behavior r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ReplayVideoMetrics r101 = (ReplayVideoMetrics) this.receiver;
            r101.getClass();
            int r102 = com.bytedance.android.livesdk.chatroom.vs_base.session.video.d.f118122a[r100.ordinal()];
            if (r102 != 1) goto L5;
            r101.f118084k = true;
            return;
        L5:
            if (r102 != 2) goto L11;
            r101.f118084k = false;
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Behavior r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/ReplayVideoMetrics$Behavior;", "", "BACKGROUND", "RESET", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Behavior extends Enum<Behavior> {
        public static final Behavior BACKGROUND = null;
        public static final Behavior RESET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Behavior[] f118087a = null;

        static {
            Behavior r100 = new Behavior("BACKGROUND", 0);
            BACKGROUND = r100;
            Behavior r101 = new Behavior("RESET", 1);
            RESET = r101;
            f118087a = new Behavior[]{r100, r101};
        }

        public static Behavior valueOf(String r100) {
            return (Behavior) r27.a.a(Behavior.class, r100);
        }

        public static Behavior[] values() {
            return (Behavior[]) f118087a.clone();
        }

        public Behavior(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoMetrics f118088a;

        public a(ReplayVideoMetrics r100) {
            this.f118088a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 == null) goto L11;
            r101.booleanValue();
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L12;
            ReplayVideoMetrics r102 = this.f118088a;
            r102.f118078e.b(r102.f118074a);
            r102.f118074a.remove("previous_page");
            com.bytedance.android.livesdk.chatroom.vs_base.log.g r103 = r102.f118077d;
            r103.f118018e = false;
            long r104 = SystemClock.elapsedRealtime();
            r103.f118024k = r104;
            if (r103.f118026m == false) goto L9;
            r103.f118025l = r104;
        L9:
            r103.f118022i = true;
            r103.f118014a.post(r103.f118027n);
            r102.f118078e.a(r102.f118085l.f118137k);
            ReplayUILatch.MAIN_UI.setStartTime(Long.valueOf(this.f118088a.f118074a.getLong(VSConstants.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, -1)));
            this.f118088a.f118078e.f();
            return;
        L12:
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoMetrics f118089a;

        public b(ReplayVideoMetrics r100) {
            this.f118089a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Map r101 = (Map) r100;
            this.f118089a.f118075b.h();
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoMetrics f118090a;

        public c(ReplayVideoMetrics r100) {
            this.f118090a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 == null) goto L15;
            r101.booleanValue();
            String r102 = this.f118090a.f118086m.f118051e.getValue();
            if (r102 != null) goto L7;
        L13:
            ReplayVideoMetrics r103 = this.f118090a;
            r103.f118075b.c(104, r103.f118086m.f118051e.getValue(), this.f118090a.f118085l.f118149w);
            return;
        L7:
            if (StringsKt.isBlank(r102) != true) goto L13;
            if (Intrinsics.areEqual(this.f118090a.f118086m.f118052f.getValue(), Boolean.TRUE) == true) goto L17;
            ReplayVideoMetrics r104 = this.f118090a;
            r104.f118075b.g(r104.f118085l.f118149w);
            this.f118090a.f118075b.c(j.a().j0(), "room cancel", this.f118090a.f118085l.f118149w);
            return;
        L17:
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoMetrics f118091a;

        public d(ReplayVideoMetrics r100) {
            this.f118091a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (((Boolean) r101.getFirst()).booleanValue() != true) goto L13;
            r.o().onModuleStart(VSConstants.PERFORMANCE_MANAGER_MODULE_REPLAY, null);
            this.f118091a.f118078e.d(j.a().j(), ((Number) r101.getSecond()).longValue());
            this.f118091a.f118078e.d(j.a().getPlaying(), ((Number) r101.getSecond()).longValue());
            ReplayVideoMetrics r102 = this.f118091a;
            r102.f118081h = true;
            r102.c(true, false);
            wr1.c r103 = this.f118091a.f118076c;
            r103.f(false);
            r103.b();
            r103.e(j.a().K());
            r103.e(j.a().i());
            r103.d();
            r103.c();
            com.bytedance.android.livesdk.chatroom.vs_base.log.g r104 = this.f118091a.f118077d;
            if (r104.f118019f == true) goto L14;
            r104.f118019f = true;
            r104.f118024k = SystemClock.elapsedRealtime();
            return;
        L14:
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoMetrics f118092a;

        public e(ReplayVideoMetrics r100) {
            this.f118092a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (r101 == null) goto L10;
            this.f118092a.f118078e.cancelTrace();
            Type r102 = new com.bytedance.android.livesdk.chatroom.vs_base.session.video.c().getType();
            String r103 = (String) ((Map) GsonProtectorUtils.fromJson(new Gson(), r101, r102)).get("error_code");
            if (r103 == null) goto L9;
            this.f118092a.f118075b.d(CastIntegerProtector.valueOf(r103).intValue(), r101, this.f118092a.f118085l.f118149w);
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoMetrics f118093a;

        public f(ReplayVideoMetrics r100) {
            this.f118093a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            Episode r100 = (Episode) r110;
            fq1.r.a().d("ttlive_room_exit", "startInteraction real cause show interaction; id" + this.f118093a.f118085l.f118149w);
            rq1.a.C7516a r101 = rq1.a.f538922a;
            com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r102 = this.f118093a.f118085l;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            JSONObject r103 = new JSONObject();
            boolean r104 = true;
            com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r105 = r102.f118129c;     // Catch: JSONException -> L42
            r103.putOpt(VSConstants.EXTRA_VS_ENTER_METHOD, r105.f118101e);     // Catch: JSONException -> L42
            r103.putOpt(VSConstants.EXTRA_LOG_ACTION_TYPE, r105.f118097a);     // Catch: JSONException -> L42
            r103.putOpt(VSConstants.EXTRA_VS_REQUEST_ID, r105.f118102f);     // Catch: JSONException -> L42
            r103.putOpt("room_id", String.valueOf(r102.f118149w));     // Catch: JSONException -> L42
            Episode r111 = r102.f118132f;     // Catch: JSONException -> L42
            if (r111 == null) goto L6;
            String r112 = EpisodeExtKt.getOwnerIdString(r111);     // Catch: JSONException -> L42
        L7:
            r103.putOpt("anchor_id", r112);     // Catch: JSONException -> L42
            Serializable r106 = r102.A.getSerializable(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP);     // Catch: JSONException -> L42
            if ((r106 instanceof Map) == true) goto L10;
            r106 = null;
        L10:
            Map r107 = (Map) r106;     // Catch: JSONException -> L42
            if (r107 != null) goto L13;
            r107 = MapsKt.emptyMap();     // Catch: JSONException -> L42
        L13:
            String r113 = "";
            if ((!r107.isEmpty()) == false) goto L16;
            r113 = com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD;
        L25:
            Object r114 = r107.get("value");     // Catch: JSONException -> L42
            if ((r114 instanceof String) == true) goto L28;
            r114 = null;
        L28:
            String r115 = (String) r114;     // Catch: JSONException -> L42
            Object r116 = r107.get("log_extra");     // Catch: JSONException -> L42
            if ((r116 instanceof String) == true) goto L31;
            r116 = null;
        L31:
            String r117 = (String) r116;     // Catch: JSONException -> L42
            Object r118 = r107.get("ad_id");     // Catch: JSONException -> L42
            if ((r118 instanceof String) == true) goto L34;
            r118 = null;
        L34:
            String r119 = (String) r118;     // Catch: JSONException -> L42
            String r120 = VSConstants.EXTRA_VS_ENTER_FROM_MERGE;     // Catch: JSONException -> L42
            com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r121 = r102.f118129c;     // Catch: JSONException -> L42
            String r108 = r121.f118099c;     // Catch: JSONException -> L42
            String r122 = r121.f118100d;     // Catch: JSONException -> L42
            if (TextUtils.isEmpty(r122) == true) goto L37;
            r108 = r122;
        L37:
            r103.putOpt(r120, r108);     // Catch: JSONException -> L42
            String r109 = r102.A.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_AWEME_ID);     // Catch: JSONException -> L42
            Object r123 = r107.get("direct_live_ad");     // Catch: JSONException -> L42
            if ((r123 instanceof String) == true) goto L40;
            r123 = null;
        L40:
            rq1.b.a(r103, "direct_live_ad", (String) r123);     // Catch: JSONException -> L42
            rq1.b.a(r103, "is_other_channel", r113);     // Catch: JSONException -> L42
            rq1.b.a(r103, "video_id", r109);     // Catch: JSONException -> L42
            rq1.b.a(r103, "value", r115);     // Catch: JSONException -> L42
            rq1.b.a(r103, "creative_id", r115);     // Catch: JSONException -> L42
            rq1.b.a(r103, "log_extra", r117);     // Catch: JSONException -> L42
            rq1.b.a(r103, "ad_id", r119);     // Catch: JSONException -> L42
        L45:
            if (r102.f118136j != 1) goto L47;
            String r124 = "0";
        L48:
            r103.putOpt("screen_type", r124);
            if (r102.f118136j == 1) goto L52;
            r104 = false;
        L52:
            r103.putOpt(IPerformanceManager.Params.is_portrait, Boolean.valueOf(r104));
            Context r125 = this.f118093a.f118085l.getContext();
            if ((r125 instanceof FragmentActivity) == true) goto L55;
            Context r126 = null;
        L56:
            FragmentActivity r127 = (FragmentActivity) r126;
            if (r127 == null) goto L66;
            j.a().Y(r127, r103.toString());
            DataCenter r128 = this.f118093a.f118085l.f118151y;
            if (r128 == null) goto L65;
            r128.put("log_enter_params", r103.toString());
            return;
        L65:
            return;
        L66:
            return;
        L55:
            r126 = r125;
            goto L56
        L47:
            r124 = "1";
            goto L48
        L16:
            Serializable r129 = r102.A.getSerializable("live_douplus_log_extra");     // Catch: JSONException -> L42
            if ((r129 instanceof Map) == true) goto L19;
            r129 = null;
        L19:
            r107 = (Map) r129;     // Catch: JSONException -> L42
            if (r107 != null) goto L23;
            r107 = MapsKt.emptyMap();     // Catch: JSONException -> L42
        L23:
            if ((!r107.isEmpty()) == false) goto L25;
            r113 = IPerformanceManager.SCENE_CLICK_DOU_PLUS;
            goto L25
        L6:
            r112 = null;
        L42:
            e = move-exception;
            ALogger.d("VSRoomSessionAdInfoProvider", String.valueOf(e.getMessage()));
            goto L45
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f118094a = null;

        static {
            f118094a = new g();
        }

        public g() {
        }

        @Override // androidx.lifecycle.Observer
        public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoMetrics f118095a;

        public h(ReplayVideoMetrics r100) {
            this.f118095a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
            this.f118095a.f118076c.a(j.a().R());
            return;
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayVideoMetrics f118096a;

        public i(ReplayVideoMetrics r100) {
            this.f118096a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (((Boolean) r101.getFirst()).booleanValue() != true) goto L9;
            this.f118096a.f118078e.d(j.a().e0(), ((Number) r101.getSecond()).longValue());
            return;
        }
    }

    public final void b() {
        com.bytedance.android.livesdk.chatroom.vs_base.log.g r100 = this.f118077d;
        r100.f118018e = true;
        r100.f118024k = -1;
        r100.f118025l = -1;
        r100.f118026m = false;
        r100.f118021h = false;
        r100.f118019f = false;
        r100.f118022i = true;
        r100.f118023j = 0;
        r100.f118016c = false;
        r100.f118015b = false;
        r100.f118017d = false;
        r100.f118014a.removeCallbacksAndMessages(null);
        this.f118076c.reset();
    }

    public final void a(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        o r101 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f118085l.f118151y).c(b0.class);
        if (r101 != null) goto L7;
        return;
    L7:
        String r102 = this.f118080g;
        String r103 = this.f118079f;
        r101.remove("request_id");
        if (r.d().g(r100) == true) goto L10;
        r101.remove("live_window_mode");
    L10:
        r101.remove("log_pb");
        r101.remove("starlight_rank");
        if (TextUtils.isEmpty(r102) == false) goto L13;
        r102 = r100.getString(VSConstants.EXTRA_ENTER_LOG_PB);
    L13:
        r101.c("log_pb", r102);
        if (TextUtils.isEmpty(r103) == false) goto L16;
        r103 = r100.getString(VSConstants.EXTRA_ENTER_REQUEST_ID);
    L16:
        r101.c("request_id", r103);
        if (TextUtils.isEmpty(r103) == true) goto L20;
        ((ar1.c) r101).f16001b.put("request_id", r103);
    L20:
        if (TextUtils.isEmpty(r102) == true) goto L22;
        ((ar1.c) r101).f16001b.put("log_pb", r102);
    L22:
        int r104 = this.f118085l.getContext().getSharedPreferences("feed_live_span", 0).getInt("span_count", 0);
        if (r104 <= 0) goto L28;
        if (r104 <= 1) goto L26;
        String r105 = "live_small_picture";
    L27:
        r101.c("live_window_mode", r105);
        goto L28
    L26:
        r105 = "live_big_picture";
    L28:
        r101.remove("card_id");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION);
        String r106 = r100.getString("card_id");
        String r107 = null;
        if (r106 != null) goto L31;
    L36:
        String r108 = r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION);
        if (r108 != null) goto L39;
        return;
    L39:
        if ((!StringsKt.isBlank(r108)) == false) goto L41;
        r107 = r108;
    L41:
        if (r107 == null) goto L45;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION, r107);
        return;
    L45:
        return;
    L31:
        if ((!StringsKt.isBlank(r106)) == true) goto L34;
        r106 = null;
    L34:
        if (r106 == null) goto L36;
        r101.c("card_id", r106);
        goto L36
    }

    @Override // jm1.b
    public final void m00(Episode r100) {
        Intrinsics.checkNotNullParameter(r100, "episode");
        this.f118075b.b();
        this.f118076c.e(j.a().R());
    }

    public ReplayVideoMetrics(com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r100, ReplayEventHub r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "hub");
        this.f118085l = r100;
        this.f118086m = r101;
        Bundle r102 = r100.A;
        this.f118074a = r102;
        a0 r103 = j.a().N();
        this.f118075b = r103;
        this.f118076c = j.a().n();
        wr1.d r104 = j.a().E(r102);
        this.f118078e = r104;
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r105 = r100.f118129c;
        this.f118079f = r105.f118102f;
        this.f118080g = r105.f118103g;
        Bundle r106 = r102.getBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        this.f118077d = new com.bytedance.android.livesdk.chatroom.vs_base.log.g(r100.f118151y);
        r103.a(j.a().d());
        a(r106);
        r101.f118054h.observeForever(new a(this));
        r104.f();
        r101.f118058l.observeForever(new b(this));
        r101.f118070x.observeForever(new c(this));
        r101.f118049c.observeForever(new d(this));
        r101.f118051e.observeForever(new e(this));
        r101.f118063q.observeForever(new f(this));
        r101.f118066t.observeForever(g.f118094a);
        r101.f118071y.observeForever(new h(this));
        r101.A.observeForever(new i(this));
        r101.B = new AnonymousClass10(this);
        LifecycleOwner r107 = r100.f118152z;
        if (r107 == null) goto L7;
        r101.f118072z.observe(r107, new com.bytedance.android.livesdk.chatroom.vs_base.session.video.e(this));
        r101.f118052f.observe(r107, new com.bytedance.android.livesdk.chatroom.vs_base.session.video.f(this));
        return;
    }

    public final void c(boolean r110, boolean r111) {
        if (r110 == false) goto L5;
        this.f118082i = r110;
    L5:
        if (r111 == false) goto L8;
        this.f118083j = r111;
    L8:
        if (this.f118082i == true) goto L10;
        return;
    L10:
        if (this.f118083j == true) goto L12;
        return;
    L12:
        if (this.f118081h == false) goto L151;
        Pair[] r100 = new Pair[1];
        if (this.f118084k == false) goto L16;
        Object r101 = "1";
    L17:
        r100[0] = TuplesKt.to("is_from_background", r101);
        Map<String, String> r102 = MapsKt.mutableMapOf(r100);
        x r103 = q.d();
        if (r103 == null) goto L25;
        lm1.c r104 = r103.a();
        if (r104 == null) goto L25;
        if (r104.a(this.f118085l.f118149w) != true) goto L25;
        r102.put("hit_show_preload_cache", "1");
    L25:
        if (this.f118085l.f118138l == false) goto L27;
        r102.put("is_video_player_prepared", "1");
    L27:
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r105 = this.f118085l;
        if (r105.f118140n == false) goto L30;
    L31:
        r102.put("is_preload", "1");
        this.f118085l.A.remove(VSConstants.EXTRA_VS_HIT_CACHE_WHEN_PREPARE);
    L33:
        if (this.f118085l.f118141o == false) goto L35;
        r102.put("is_vs_video_pre_play", "1");
    L35:
        ReplayDataContext.a r106 = ReplayDataContext.Companion;
        DataCenter r107 = this.f118085l.f118151y;
        r106.getClass();
        ReplayDataContext r108 = ReplayDataContext.a.b(r107);
        if (r108 == null) goto L42;
        m<Boolean> r109 = r108.getHasSwitched();
        if (r109 == null) goto L42;
        if (r109.getValue().booleanValue() != true) goto L42;
        r102.put("play_scene", "switch");
    L44:
        if (((Number) this.f118085l.f118151y.get("replay_enter_api_duration", -1L)).longValue() <= 0) goto L46;
        r102.put("enter_api_duration", String.valueOf(((Number) this.f118085l.f118151y.get("replay_enter_api_duration", -1L)).longValue()));
    L46:
        r102.put("replay_schema_pre_request_status", this.f118085l.f118129c.f118106j);
        VideoContext r112 = VideoContext.n0(this.f118085l.getContext());
        if (r112 == null) goto L141;
        p r113 = r112.p0();
        if (r113 == null) goto L141;
        VideoInfo r114 = r113.b();
        if (r114 == null) goto L56;
        Resolution r115 = r114.getResolution();
        if (r115 == null) goto L56;
        String r116 = r115.toString(VideoRef.TYPE_VIDEO);
        if (r116 == null) goto L56;
    L57:
        r102.put("vs_resolution", r116);
        if (this.f118085l.f118137k == false) goto L60;
        r102.put("start_position", String.valueOf(r113.getCurrentPosition() / 1000));
    L61:
        ReplayDataContext r117 = ReplayDataContext.a.b(this.f118085l.f118151y);
        o r118 = null;
        if (r117 == null) goto L66;
        m<Integer> r119 = r117.getSeekType();
        if (r119 == null) goto L66;
        Integer r120 = r119.getValue();
    L67:
        if (r120 != null) goto L70;
    L71:
        if (r120 != null) goto L74;
    L102:
        VideoEngineInfos r121 = r113.c(VideoEngineInfos.USING_FIRST_FRAME_SPLIT_INFOS);
        if (r121 == null) goto L141;
        Object r122 = r121.getObject();
        if (r122 == null) goto L141;
        if ((r122 instanceof JSONObject) == false) goto L141;
        JSONObject r123 = (JSONObject) r122;
        r123.put("try_play", this.f118078e.g(j.a().e0()));
        r123.put("on_render_start", this.f118078e.g(j.a().j()));
        int r124 = com.bytedance.android.livesdk.chatroom.vs_base.session.video.b.f118112j;
        Intrinsics.checkNotNullParameter(r123, "jsonObject");
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.b r125 = new com.bytedance.android.livesdk.chatroom.vs_base.session.video.b();
        r125.f118113a = r123.optLong("try_play");
        r125.f118114b = r123.optLong("format_open_input");
        r125.f118115c = r123.optLong("tran_connect");
        r125.f118116d = r123.optLong("http_response");
        r125.f118117e = r123.optLong("receive_first_video_frame");
        r125.f118118f = r123.optLong("decode_first_video_frame");
        r125.f118119g = r123.optLong("render_first_video_frame");
        r125.f118120h = r123.optLong("prepared");
        r125.f118121i = r123.optLong("on_render_start");
        Intrinsics.checkNotNullParameter(r102, "map");
        long r126 = r125.f118114b;
        long r127 = r126 - r125.f118113a;
        if (r127 < 0) goto L111;
        int r128 = (int) r127;
    L112:
        long r129 = r125.f118115c;
        long r130 = r129 - r126;
        if (r130 < 0) goto L115;
        int r131 = (int) r130;
    L116:
        long r132 = r125.f118116d;
        long r133 = r132 - r129;
        if (r133 < 0) goto L119;
        int r134 = (int) r133;
    L120:
        long r135 = r125.f118117e;
        long r136 = r135 - r132;
        if (r136 < 0) goto L123;
        int r137 = (int) r136;
    L124:
        long r138 = r125.f118118f;
        long r139 = r138 - r135;
        if (r139 < 0) goto L127;
        int r140 = (int) r139;
    L128:
        long r141 = r125.f118119g;
        long r142 = r141 - r138;
        if (r142 < 0) goto L131;
        int r143 = (int) r142;
    L132:
        long r144 = r125.f118120h - r126;
        if (r144 < 0) goto L135;
        int r145 = (int) r144;
    L136:
        long r146 = r125.f118121i - r141;
        if (r146 < 0) goto L139;
        int r147 = (int) r146;
    L140:
        r102.put("try_play_to_open", String.valueOf(r128));
        r102.put("open_to_tcp_cnt", String.valueOf(r131));
        r102.put("tcp_cnt_to_http_res", String.valueOf(r134));
        r102.put("http_res_to_rev_ff", String.valueOf(r137));
        r102.put("rev_ff_to_decode_ff", String.valueOf(r140));
        r102.put("decode_ff_to_render_ff", String.valueOf(r143));
        r102.put("open_to_prepared", String.valueOf(r145));
        r102.put("render_ff_to_render_start", String.valueOf(r147));
    L142:
        this.f118078e.e(r102);
        this.f118084k = false;
        this.f118081h = false;
        return;
    L139:
        r147 = -1;
        goto L140
    L135:
        r145 = -1;
        goto L136
    L131:
        r143 = -1;
        goto L132
    L127:
        r140 = -1;
        goto L128
    L123:
        r137 = -1;
        goto L124
    L119:
        r134 = -1;
        goto L120
    L115:
        r131 = -1;
        goto L116
    L111:
        r128 = -1;
        goto L112
    L74:
        if (r120.intValue() != 1) goto L102;
    L75:
        VideoInfo r148 = r113.b();
        if (r148 == null) goto L78;
        HashMap<Double, Long> r149 = r148.mPacketOffset;
    L80:
        if (r149 != null) goto L82;
    L85:
        r102.put("highlight_match", "0");
        long r150 = r113.d() / ((long) 1000);
        JSONObject r151 = new JSONObject();
        r151.put("scene", "enter");     // Catch: JSONException -> L144
        r151.put("enter_from_merge", this.f118085l.f118129c.f118099c);     // Catch: JSONException -> L144
        r151.put("enter_method", this.f118085l.f118129c.f118101e);     // Catch: JSONException -> L144
        r151.put("highlight_location", r150);     // Catch: JSONException -> L144
        r151.put("pkt_offset", String.valueOf(r149));     // Catch: JSONException -> L144
        o r152 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f118085l.f118151y).c(am2.a0.class);     // Catch: JSONException -> L144
        if ((r152 instanceof ar1.b) == false) goto L90;
        r118 = r152;
    L90:
        ar1.b r153 = (ar1.b) r118;     // Catch: JSONException -> L144
        if (r153 == null) goto L101;
        Map<String, String> r154 = r153.f16001b;     // Catch: JSONException -> L144
        if (r154 == null) goto L101;
        Set<Map.Entry<String, String>> r155 = r154.entrySet();     // Catch: JSONException -> L144
        if (r155 == null) goto L101;
        Iterator<T> r156 = r155.iterator();     // Catch: JSONException -> L144
    L98:
        if (r156.hasNext() == false) goto L101;
        Map.Entry r157 = (Map.Entry) r156.next();     // Catch: JSONException -> L144
        r151.put((String) r157.getKey(), r157.getValue());     // Catch: JSONException -> L144
    L101:
        LiveSlardarMonitor.monitorStatus("ttlive_vs_video_highlight_preload_error", 1, r151);
        goto L102
    L82:
        if (r149.containsKey(Double.valueOf(r113.d() / ((long) 1000))) == false) goto L85;
        r102.put("highlight_match", "1");
        goto L102
    L78:
        r149 = null;
        goto L80
    L70:
        if (r120.intValue() == 2) goto L75;
    L66:
        r120 = null;
        goto L67
    L60:
        r102.put("start_position", String.valueOf(r113.d() / ((long) 1000)));
    L56:
        r116 = "";
    L141:
        r102 = r102;
    L42:
        r102.put("play_scene", "enter");
        goto L44
    L30:
        if (r105.A.getBoolean(VSConstants.EXTRA_VS_HIT_CACHE_WHEN_PREPARE, false) == false) goto L33;
    L16:
        r101 = "0";
        goto L17
    }

    @Override // jm1.b
    public final void fX(long r100, String r101, boolean r102, Episode r110, ls2.e r111) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r111, "error");
        this.f118084k = false;
        IEndReason r103 = r111.getReasonV2Ext();
        fq1.q r104 = fq1.r.a();
        StringBuilder r105 = new StringBuilder();
        if (r103 == null) goto L5;
        String r106 = r103.toString();
    L6:
        r105.append(r106);
        r105.append(" cause to room exit; id");
        r105.append(r100);
        r104.d("ttlive_room_exit", r105.toString());
        if (Intrinsics.areEqual(r103, EndReason.PLAYER_ERROR.INSTANCE) == false) goto L10;
        this.f118081h = false;
        j.a().k("player error", 207, j.a().d());
        this.f118075b.f(r100);
        this.f118075b.c(j.a().a(), "ttplayer init failed", r100);
        this.f118078e.cancelTrace();
        TimeCostUtil.Tag r107 = TimeCostUtil.Tag.StartLivePlay;
        TimeCostUtil.a("error", "ttplayer init failed");
        TimeCostUtil.Tag r108 = TimeCostUtil.Tag.ScrollWatchLivePlay;
        TimeCostUtil.a("error", "ttplayer init failed");
        com.bytedance.android.live.core.performance.a r109 = com.bytedance.android.live.core.performance.a.f65108a;
        r107.name();
        r109.getClass();
        r108.name();
        return;
    L10:
        if (Intrinsics.areEqual(r103, EndReason.ENTER_FAILED.INSTANCE) == false) goto L21;
        int r112 = r111.getRoomErrorCodeV2();
        if (r112 != 203) goto L14;
        String r113 = "rd_info_by_user_failed";
    L18:
        if (r113 == null) goto L63;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f118085l.f118151y).d(r113, null, new Object[0]);
        return;
    L63:
        return;
    L14:
        if (r112 == 205) goto L16;
        r113 = null;
        goto L18
    L16:
        r113 = "rd_enter_room_failed";
        goto L18
    L21:
        if ((r103 instanceof EndReason.LIVE_END) == false) goto L27;
        if (r102 == false) goto L24;
        this.f118075b.c(j.a().A(), "leave for profile", r100);
    L25:
        b();
        return;
    L24:
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f118085l.f118151y).d("rd_enter_room_live_end", null, new Object[0]);
        this.f118075b.c(j.a().c(), "frame_fail", r100);
        j.a().k("room finish", 201, j.a().d());
        goto L25
    L27:
        if ((r103 instanceof EndReason.FETCH_FAILED) == false) goto L32;
        if (r102 == false) goto L30;
        this.f118075b.c(j.a().A(), "leave for profile", r100);
        return;
    L30:
        this.f118075b.e(j.a().I(), new JSONObject(), r100);
        j.a().k("pull url invalid", 204, j.a().d());
        return;
    L32:
        if (Intrinsics.areEqual(r103, EndReason.EMPTY_URL.INSTANCE) == false) goto L35;
        this.f118075b.c(j.a().X(), "empty url", r100);
        return;
    L35:
        if (Intrinsics.areEqual(r103, EndReason.PING_KICK_OUT.INSTANCE) == false) goto L38;
        this.f118075b.c(j.a().f0(), "ping kick out", r100);
        b();
        return;
    L38:
        if (Intrinsics.areEqual(r103, EndReason.PING_LOST_FOCUS.INSTANCE) == false) goto L41;
        this.f118075b.c(j.a().f(), "isn't resumed and lost audio", r100);
        return;
    L41:
        if (Intrinsics.areEqual(r103, EndReason.MEDIA_END.INSTANCE) == false) goto L44;
        b();
        return;
    L44:
        if (Intrinsics.areEqual(r103, EndReason.USER_CLOSE.INSTANCE) == false) goto L47;
        this.f118075b.c(j.a().S(), "user close", r100);
        b();
        return;
    L47:
        if (Intrinsics.areEqual(r103, EndReason.USER_KICK_OUT.INSTANCE) == false) goto L50;
        this.f118075b.c(j.a().x(), "this user is kicked out by other device", r100);
        b();
        return;
    L50:
        if (Intrinsics.areEqual(r103, EndReason.WATCHER_KIT_OUT.INSTANCE) == false) goto L53;
        new Handler(Looper.getMainLooper()).postDelayed(new com.bytedance.android.livesdk.chatroom.vs_base.session.video.g(this, r100), 2500);
        return;
    L53:
        if (Intrinsics.areEqual(r103, EndReason.JUMP_TO_OTHER.INSTANCE) == false) goto L56;
        b();
        this.f118075b.c(j.a().s(), "jump to other room", r100);
        return;
    L56:
        if (Intrinsics.areEqual(r103, EndReason.JUMP_TO_OTHER_MIX_ROOM.INSTANCE) == false) goto L59;
        b();
        this.f118075b.c(j.a().h(), "jump to other mix room", r100);
        return;
    L59:
        if (Intrinsics.areEqual(r103, EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE) == false) goto L77;
        b();
        this.f118075b.c(j.a().y(), "change page", r100);
        return;
    L77:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
