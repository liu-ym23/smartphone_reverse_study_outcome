package com.bytedance.android.live.livepkaudience.rtc;

import android.os.Handler;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.g;
import com.bytedance.android.live.liveinteract.plantform.core.u;
import com.bytedance.android.live.liveinteract.plantform.core.v;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.utils.j1;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager;
import com.bytedance.android.live.pushstream.IEffectPerfToolsHelper;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.jn0;
import com.bytedance.android.livesdk.config.ma1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import dl0.n;
import gy.h;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements ii6.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f82176x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ei6.a f82177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f82178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v0 f82179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f82180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f82181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f82182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f82183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f82184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public u f82185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f82186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<ui6.a> f82187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f82188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<String> f82189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Long> f82190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Long> f82191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ii6.a f82192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public v0 f82193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final gy.a f82194r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, Object> f82195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashSet<String> f82196t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f82197u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f82198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Room f82199w;

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.rtc.a$a, reason: collision with other inner class name */
    public static final class C1254a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f82200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f82201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MultiChannelInfo f82202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f82203d;

        public b() {
            this(null, null, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f82200a == r101.f82200a) goto L8;
            return false;
        L8:
            if (this.f82201b == r101.f82201b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f82202c, r101.f82202c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f82203d, r101.f82203d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            boolean r100 = this.f82200a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f82201b;
            if (r104 == true) goto L9;
            r101 = r104;
        L9:
            int r105 = (r103 + r101) * 31;
            MultiChannelInfo r106 = this.f82202c;
            int r107 = 0;
            if (r106 == null) goto L12;
            int r108 = r106.hashCode();
        L13:
            int r109 = (r105 + r108) * 31;
            String r110 = this.f82203d;
            if (r110 == null) goto L17;
            r107 = r110.hashCode();
        L17:
            return r109 + r107;
        L12:
            r108 = 0;
            goto L13
        }

        public final String toString() {
            return "StartEngineParams(needPushStream=" + this.f82200a + ", enableAllRemoteRender=" + this.f82201b + ", multiChannelInfo=" + this.f82202c + ", channelId=" + this.f82203d + ")";
        }

        public b(MultiChannelInfo r100, String r101, int r102) {
            boolean r103 = false;
            if ((r102 & 1) == 0) goto L5;
            boolean r104 = true;
        L7:
            if ((r102 & 2) == 0) goto L10;
            r103 = true;
        L10:
            if ((r102 & 4) == 0) goto L13;
            r100 = null;
        L13:
            if ((r102 & 8) == 0) goto L15;
            r101 = "";
        L15:
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.Notification.CHANNEL_ID);
            this.f82200a = r104;
            this.f82201b = r103;
            this.f82202c = r100;
            this.f82203d = r101;
            return;
        L5:
            r104 = false;
            goto L7
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f82204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f82205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f82206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Exception f82207d;

        public c(a r100, int r101, long r102, Exception r103) {
            this.f82204a = r100;
            this.f82205b = r101;
            this.f82206c = r102;
            this.f82207d = r103;
        }

        public final void a() {
            int r100 = this.f82205b;
            String r101 = null;
            if (r100 != (-1)) goto L22;
            Disposable r102 = this.f82204a.f82182f;
            if (r102 == null) goto L7;
            r102.dispose();
        L7:
            gy.a r103 = this.f82204a.f82194r;
            if (r103 == null) goto L17;
            long r104 = this.f82206c;
            Exception r105 = this.f82207d;
            if (r105 == null) goto L12;
            r101 = r105.getMessage();
        L12:
            h r106 = r103.f483307f;
            LiveTracingMonitor.EventModule r107 = LiveTracingMonitor.b(0);
            int r110 = (int) r104;
            if (r101 != null) goto L15;
            String r111 = "";
        L16:
            r106.n(r107, "start_error", "", r103.a(), r110, r111);
            goto L17
        L15:
            r111 = r101;
        L17:
            v r108 = this.f82204a.f82180d;
            if (r108 == null) goto L20;
            r108.R(this.f82206c, this.f82207d);
        L20:
            this.f82204a.f("onStartFailed");
            return;
        L22:
            if (r100 != (-2)) goto L31;
            Disposable r109 = this.f82204a.f82183g;
            if (r109 == null) goto L26;
            r109.dispose();
        L26:
            v r112 = this.f82204a.f82180d;
            if (r112 == null) goto L29;
            r112.G9(this.f82206c, this.f82207d);
        L29:
            this.f82204a.getClass();
            return;
        L31:
            if (r100 != (-3)) goto L45;
            gy.a r113 = this.f82204a.f82194r;
            long r114 = this.f82206c;
            Exception r115 = this.f82207d;
            if (r115 == null) goto L35;
            r101 = r115.getMessage();
        L35:
            h r116 = r113.f483307f;
            LiveTracingMonitor.EventModule r117 = LiveTracingMonitor.b(0);
            int r118 = (int) r114;
            if (r101 != null) goto L38;
            String r119 = "";
        L39:
            r116.n(r117, "did_occur_error", "", r113.a(), r118, r119);
            v r120 = this.f82204a.f82180d;
            if (r120 == null) goto L46;
            r120.f0(this.f82206c, this.f82207d);
            return;
        L46:
            return;
        L38:
            r119 = r101;
            goto L39
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f82208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f82209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f82210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object[] f82211d;

        public d(a r100, int r101, long r102, Object[] r103) {
            this.f82208a = r100;
            this.f82209b = r101;
            this.f82210c = r102;
            this.f82211d = r103;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            int r100 = this.f82209b;
            if (r100 != 1) goto L5;
            v r101 = this.f82208a.f82180d;
            if (r101 == null) goto L325;
            r101.o0(this.f82210c);
            return;
        L325:
            return;
        L5:
            if (r100 == 2) goto L273;
            Object r102 = null;
            Object r103 = null;
            Object r104 = null;
            Object r105 = null;
            Object r106 = null;
            Object r107 = null;
            Object r108 = null;
            Object r109 = null;
            Object r110 = null;
            String r111 = null;
            Object r112 = null;
            if (r100 != 19) goto L9;
            Object[] r113 = this.f82211d;
            Object r114 = r113[0];
            if ((r114 instanceof String) == false) goto L260;
            r102 = r114;
        L260:
            String r115 = (String) r102;
            if (r115 == null) goto L320;
            Object r116 = r113[1];
            if (r116 == null) goto L272;
            int r117 = ((Integer) r116).intValue();
            Object r118 = this.f82211d[2];
            if (r118 == null) goto L270;
            int r119 = ((Integer) r118).intValue();
            v r120 = this.f82208a.f82180d;
            if (r120 == null) goto L321;
            r120.S(r115, r117, r119);
            return;
        L321:
            return;
        L270:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L272:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L320:
            return;
        L9:
            switch(r100) {
                case 4: goto L149;
                case 5: goto L138;
                case 6: goto L131;
                case 7: goto L119;
                case 8: goto L98;
                case 9: goto L85;
                case 10: goto L75;
                case 11: goto L14;
                default: goto L10;
            };
        L10:
            switch(r100) {
                case 14: goto L179;
                case 15: goto L167;
                case 16: goto L155;
                default: goto L12;
            };
        L155:
            Object[] r121 = this.f82211d;
            Object r122 = r121[0];
            if ((r122 instanceof String) == true) goto L158;
            r122 = null;
        L158:
            String r123 = (String) r122;
            if (r123 == null) goto L305;
            v r124 = this.f82208a.f82180d;
            if (r124 == null) goto L306;
            Object r125 = r121[1];
            if ((r125 instanceof Boolean) == false) goto L166;
            r103 = r125;
        L166:
            r124.g(r123, (Boolean) r103);
            return;
        L306:
            return;
        L305:
            return;
        L167:
            Object[] r126 = this.f82211d;
            Object r127 = r126[0];
            if ((r127 instanceof String) == true) goto L170;
            r127 = null;
        L170:
            String r128 = (String) r127;
            if (r128 == null) goto L308;
            v r129 = this.f82208a.f82180d;
            if (r129 == null) goto L309;
            Object r130 = r126[1];
            if ((r130 instanceof Boolean) == false) goto L178;
            r104 = r130;
        L178:
            r129.A(r128, (Boolean) r104);
            return;
        L309:
            return;
        L308:
            return;
        L179:
            Object r131 = this.f82211d[0];
            if (r131 == null) goto L185;
            gy.a r132 = this.f82208a.f82194r;
            if (r132 == null) goto L184;
            String r133 = r131.toString();
            long r134 = this.f82208a.f82188l;
            Intrinsics.checkNotNullParameter(r133, "linkId");
            r132.f483306e = System.currentTimeMillis();
            h.o(r132.f483307f, LiveTracingMonitor.b(0), "first_remote_video_frame_render", r133, r132.a(), 0, 48);
            ALogger.i(r132.f483302a, "onFirstVideoFrameRender " + r133);
        L184:
            this.f82208a.f82188l = 0;
        L185:
            Object[] r135 = this.f82211d;
            if (r135.length <= 5) goto L196;
            Object r136 = r135[4];
            if (r136 == null) goto L195;
            int r137 = ((Integer) r136).intValue();
            Object r138 = this.f82211d[5];
            if (r138 == null) goto L193;
            int r139 = ((Integer) r138).intValue();
        L197:
            Object[] r140 = this.f82211d;
            Object r141 = r140[1];
            boolean r142 = r141 instanceof SurfaceView;
            if (r142 == false) goto L209;
            v r143 = this.f82208a.f82180d;
            if (r143 == null) goto L311;
            Object r144 = r140[0];
            if ((r144 instanceof String) == true) goto L204;
            r144 = null;
        L204:
            String r145 = (String) r144;
            if (r142 == false) goto L208;
            r105 = r141;
        L208:
            r143.y0(r145, (SurfaceView) r105, r137, r139);
            return;
        L311:
            return;
        L209:
            boolean r146 = r141 instanceof TextureView;
            if (r146 == false) goto L221;
            v r147 = this.f82208a.f82180d;
            if (r147 == null) goto L313;
            Object r148 = r140[0];
            if ((r148 instanceof String) == true) goto L216;
            r148 = null;
        L216:
            String r149 = (String) r148;
            if (r146 == false) goto L220;
            r106 = r141;
        L220:
            r147.j0(r149, (TextureView) r106, r137, r139);
            return;
        L313:
            return;
        L221:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r150 = ILiveWrappedLivePusher.a.b();
            if (r150 == null) goto L224;
            z.a r151 = r150.buildLayerControlLayer(this.f82211d[1]);
        L225:
            v r152 = this.f82208a.f82180d;
            if (r152 == null) goto L315;
            Object r153 = this.f82211d[0];
            if ((r153 instanceof String) == false) goto L231;
            r107 = r153;
        L231:
            r152.V4((String) r107, r151);
            return;
        L315:
            return;
        L224:
            r151 = null;
            goto L225
        L193:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L195:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L196:
            r137 = 0;
            r139 = 0;
            goto L197
        L12:
            switch(r100) {
                case 301: goto L248;
                case 302: goto L240;
                case 303: goto L232;
                default: goto L326;
            };
        L232:
            this.f82208a.getClass();
            this.f82208a.getClass();
            gy.a r154 = this.f82208a.f82194r;
            if (r154 == null) goto L239;
            Object r155 = this.f82211d[0];
            if (r155 == null) goto L238;
            int r156 = ((LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError) r155).value();
            String r157 = String.valueOf(this.f82211d[1]);
            Intrinsics.checkNotNullParameter(r157, "roomId");
            HashMap<String, Object> r158 = r154.a();
            r158.put("target_room_id", r157);
            ALogger.e(r154.f483302a, "onForwardStreamFailed " + r156 + ' ' + r157);
            h.o(r154.f483307f, LiveTracingMonitor.b(0), "start_forward_stream_failed", "", r158, r156, 32);
            goto L239
        L238:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError");
        L239:
            int r159 = a.f82176x;
            ALogger.i("GuestRtcManager", "GuestRtcManager on cross room rtc info failed " + this.f82211d[0] + ' ' + this.f82211d[1]);
            return;
        L240:
            this.f82208a.getClass();
            gy.a r160 = this.f82208a.f82194r;
            if (r160 == null) goto L247;
            Object r161 = this.f82211d[0];
            if (r161 == null) goto L246;
            int r162 = ((LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError) r161).value();
            String r163 = String.valueOf(this.f82211d[1]);
            Intrinsics.checkNotNullParameter(r163, "roomId");
            HashMap<String, Object> r164 = r160.a();
            r164.put("target_room_id", r163);
            ALogger.e(r160.f483302a, "onForwardStreamSuccess " + r162 + ' ' + r163);
            h.o(r160.f483307f, LiveTracingMonitor.b(0), "start_forward_stream_success", "", r164, r162, 32);
            goto L247
        L246:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError");
        L247:
            int r165 = a.f82176x;
            ALogger.i("GuestRtcManager", "GuestRtcManager on cross room rtc info success " + this.f82211d[0] + ' ' + this.f82211d[1]);
            return;
        L248:
            this.f82208a.getClass();
            gy.a r166 = this.f82208a.f82194r;
            if (r166 == null) goto L255;
            Object r167 = this.f82211d[0];
            if (r167 == null) goto L254;
            int r168 = ((LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError) r167).value();
            String r169 = String.valueOf(this.f82211d[1]);
            Intrinsics.checkNotNullParameter(r169, "roomId");
            HashMap<String, Object> r170 = r166.a();
            r170.put("target_room_id", r169);
            ALogger.e(r166.f483302a, "onForwardStreamStop " + r168 + ' ' + r169);
            h.o(r166.f483307f, LiveTracingMonitor.b(0), "stop_forward_stream", "", r170, r168, 32);
            goto L255
        L254:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError");
        L255:
            int r171 = a.f82176x;
            ALogger.i("GuestRtcManager", "GuestRtcManager on cross room rtc info idle " + this.f82211d[0] + ' ' + this.f82211d[1]);
            return;
        L326:
            return;
        L14:
            int r172 = a.f82176x;
            ALogger.i("GuestRtcManager", "MSG_INFO_FIRST_REMOTE_VIDEO, linkId: " + this.f82211d[0]);
            Object r173 = this.f82211d[0];
            if (r173 == null) goto L20;
            this.f82208a.f82190n.put(r173.toString(), Long.valueOf(System.currentTimeMillis()));
            gy.a r174 = this.f82208a.f82194r;
            if (r174 == null) goto L19;
            String r175 = r173.toString();
            long r176 = this.f82208a.f82188l;
            Intrinsics.checkNotNullParameter(r175, "linkId");
            r174.f483305d = System.currentTimeMillis();
            h.o(r174.f483307f, LiveTracingMonitor.b(0), "first_remote_video_decoded_of_uid", r175, r174.a(), 0, 48);
            ALogger.w(r174.f483302a, "onFirstVideoFrame " + r175);
        L19:
            this.f82208a.f82188l = 0;
        L20:
            Object[] r177 = this.f82211d;
            if (r177.length <= 4) goto L31;
            Object r178 = r177[3];
            if (r178 == null) goto L30;
            int r179 = ((Integer) r178).intValue();
            Object r180 = this.f82211d[4];
            if (r180 == null) goto L28;
            int r181 = ((Integer) r180).intValue();
        L32:
            Object[] r182 = this.f82211d;
            Object r183 = r182[1];
            if (r183 == null) goto L39;
            Map<String, Object> r184 = this.f82208a.f82195s;
            Object r185 = r182[0];
            if (r185 == null) goto L38;
            r184.put((String) r185, r183);
            goto L39
        L38:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L39:
            Object[] r186 = this.f82211d;
            Object r187 = r186[1];
            boolean r188 = r187 instanceof SurfaceView;
            if (r188 == false) goto L51;
            v r189 = this.f82208a.f82180d;
            if (r189 == null) goto L284;
            Object r190 = r186[0];
            if ((r190 instanceof String) == true) goto L46;
            r190 = null;
        L46:
            String r191 = (String) r190;
            if (r188 == false) goto L50;
            r108 = r187;
        L50:
            r189.h1(r191, (SurfaceView) r108, r179, r181);
            return;
        L284:
            return;
        L51:
            boolean r192 = r187 instanceof TextureView;
            if (r192 == false) goto L63;
            v r193 = this.f82208a.f82180d;
            if (r193 == null) goto L286;
            Object r194 = r186[0];
            if ((r194 instanceof String) == true) goto L58;
            r194 = null;
        L58:
            String r195 = (String) r194;
            if (r192 == false) goto L62;
            r109 = r187;
        L62:
            r193.L0(r195, (TextureView) r109, r179, r181);
            return;
        L286:
            return;
        L63:
            if (r187 == null) goto L288;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r196 = ILiveWrappedLivePusher.a.b();
            if (r196 == null) goto L67;
            z.a r197 = r196.buildLayerControlLayer(this.f82211d[1]);
        L68:
            v r198 = this.f82208a.f82180d;
            if (r198 == null) goto L289;
            Object r199 = this.f82211d[0];
            if ((r199 instanceof String) == false) goto L74;
            r110 = r199;
        L74:
            r198.b4((String) r110, r197, r179, r181);
            return;
        L289:
            return;
        L67:
            r197 = null;
            goto L68
        L288:
            return;
        L28:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L31:
            r179 = 0;
            r181 = 0;
            goto L32
        L75:
            Object r200 = this.f82211d[0];
            if (r200 == null) goto L78;
            r111 = r200.toString();
        L78:
            if (r111 == null) goto L291;
            gy.a r201 = this.f82208a.f82194r;
            if (r201 == null) goto L82;
            Intrinsics.checkNotNullParameter(r111, "linkId");
            h.o(r201.f483307f, LiveTracingMonitor.b(0), "first_remote_audio_of_uid", r111, r201.a(), 0, 48);
        L82:
            a r202 = this.f82208a;
            r202.f82188l = 0;
            v r203 = r202.f82180d;
            if (r203 == null) goto L292;
            r203.L(r111);
            return;
        L292:
            return;
        L291:
            return;
        L85:
            v r204 = this.f82208a.f82180d;
            if (r204 == null) goto L294;
            Object[] r205 = this.f82211d;
            Object r206 = r205[0];
            if ((r206 instanceof String[]) == true) goto L90;
            r206 = null;
        L90:
            String[] r207 = (String[]) r206;
            Object r208 = r205[1];
            if ((r208 instanceof boolean[]) == true) goto L93;
            r208 = null;
        L93:
            boolean[] r209 = (boolean[]) r208;
            Object r210 = r205[2];
            if ((r210 instanceof int[]) == false) goto L97;
            r112 = r210;
        L97:
            r204.J(r207, r209, (int[]) r112);
            return;
        L294:
            return;
        L98:
            Object r211 = this.f82211d[0];
            if (r211 == null) goto L103;
            this.f82208a.f82189m.remove(r211.toString());
            gy.a r212 = this.f82208a.f82194r;
            if (r212 == null) goto L103;
            String r213 = r211.toString();
            Intrinsics.checkNotNullParameter(r213, "linkId");
            h.o(r212.f483307f, LiveTracingMonitor.b(0), "did_offline_of_uid", r213, r212.a(), 0, 48);
            ALogger.w(r212.f483302a, "onUserLeave " + r213);
        L103:
            Map<String, Object> r214 = this.f82208a.f82195s;
            Object r215 = this.f82211d[0];
            if (r215 == null) goto L118;
            r214.remove((String) r215);
            v r216 = this.f82208a.f82180d;
            if (r216 == null) goto L112;
            Object r217 = this.f82211d[0];
            if (r217 == null) goto L111;
            r216.e1((String) r217, this.f82210c);
            goto L112
        L111:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L112:
            HashSet<String> r218 = this.f82208a.f82196t;
            Object r219 = this.f82211d[0];
            if (r219 == null) goto L116;
            r218.remove((String) r219);
            return;
        L116:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L118:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L119:
            Object r220 = this.f82211d[0];
            if (r220 == null) goto L124;
            this.f82208a.f82189m.add(r220.toString());
            this.f82208a.f82191o.put(r220.toString(), Long.valueOf(System.currentTimeMillis()));
            gy.a r221 = this.f82208a.f82194r;
            if (r221 == null) goto L124;
            String r222 = r220.toString();
            Intrinsics.checkNotNullParameter(r222, "linkId");
            h.o(r221.f483307f, LiveTracingMonitor.b(0), "did_user_join", r222, r221.a(), 0, 48);
            ALogger.w(r221.f483302a, "onUserJoin " + r222);
        L124:
            v r223 = this.f82208a.f82180d;
            if (r223 == null) goto L297;
            Object r224 = this.f82211d[0];
            if (r224 == null) goto L130;
            r223.onUserJoined((String) r224);
            return;
        L130:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L297:
            return;
        L131:
            v r225 = this.f82208a.f82180d;
            if (r225 == null) goto L299;
            Object r226 = this.f82211d[0];
            if (r226 == null) goto L137;
            r225.wk((String) r226);
            return;
        L137:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L299:
            return;
        L138:
            ei6.a r227 = this.f82208a.f82177a;
            if (r227 == null) goto L143;
            gi6.e r228 = r227.getEventManager();
            if (r228 == null) goto L143;
            r228.b(null);
        L143:
            a r229 = this.f82208a;
            r229.f82177a = null;
            r229.getClass();
            this.f82208a.getClass();
            Disposable r230 = this.f82208a.f82183g;
            if (r230 == null) goto L146;
            r230.dispose();
        L146:
            v r231 = this.f82208a.f82180d;
            if (r231 == null) goto L301;
            r231.M1();
            return;
        L301:
            return;
        L149:
            a r232 = this.f82208a;
            gy.a r233 = r232.f82194r;
            long r234 = r232.f82188l;
            r233.getClass();
            r233.f483303b = System.currentTimeMillis();
            h.o(r233.f483307f, LiveTracingMonitor.b(0), "did_join_channel", "", r233.a(), 0, 48);
            ALogger.w(r233.f483302a, "onRtcStartSuccess cost " + (System.currentTimeMillis() - r234) + "ms");
            Disposable r235 = this.f82208a.f82182f;
            if (r235 == null) goto L152;
            r235.dispose();
        L152:
            v r236 = this.f82208a.f82180d;
            if (r236 == null) goto L303;
            r236.o();
            return;
        L303:
            return;
        L273:
            v r237 = this.f82208a.f82180d;
            if (r237 == null) goto L323;
            long r238 = this.f82210c;
            Object r239 = this.f82211d[0];
            if (r239 == null) goto L279;
            r237.f1(r238, ((Integer) r239).intValue());
            return;
        L279:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f82212a = null;

        static {
            f82212a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            tc0.c r102 = tc0.c.h();
            int r103 = x.f77572a;
            Intrinsics.checkNotNullParameter(r102, "dataHolder");
            HashMap r104 = new HashMap();
            x.a(r104);
            g.n("rtc_stop_time_out", r104, r102, true);
        }
    }

    static {
    }

    public final String a() {
        ei6.a r100 = this.f82177a;
        if (r100 == null) goto L7;
        si6.b r101 = r100.b();
        if (r101 == null) goto L7;
        String r102 = r101.m();
    L9:
        return String.valueOf(r102);
    L7:
        r102 = null;
        goto L9
    }

    public a(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        this.f82199w = r100;
        this.f82181e = new CompositeDisposable();
        this.f82184h = new Handler();
        this.f82187k = new ArrayList();
        this.f82189m = new LinkedHashSet();
        this.f82190n = new LinkedHashMap();
        this.f82191o = new LinkedHashMap();
        this.f82192p = (ii6.a) WeakReferenceWrapper.wrap(this);
        this.f82194r = new gy.a(this.f82199w);
        this.f82195s = new LinkedHashMap();
        this.f82196t = new HashSet();
        this.f82198v = "";
    }

    public final void d(boolean r100) {
        HashSet<String> r101 = this.f82196t;
        if (r101 == null) goto L5;
        r101.clear();
    L5:
        this.f82186j = false;
        this.f82189m.clear();
        if (r100 == true) goto L13;
        ei6.a r102 = this.f82177a;
        if (r102 == null) goto L12;
        si6.b r103 = r102.b();
        if (r103 == null) goto L12;
        si6.a.b(r103, false, "GuestRtcManager onDestroy", 3);
    L12:
        this.f82195s.clear();
    L13:
        this.f82181e.dispose();
        Disposable r104 = this.f82182f;
        if (r104 == null) goto L16;
        r104.dispose();
    L16:
        Disposable r105 = this.f82183g;
        if (r105 == null) goto L19;
        r105.dispose();
    L19:
        this.f82184h.removeCallbacksAndMessages(null);
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reqFrom");
        this.f82186j = false;
        this.f82189m.clear();
        gy.a r101 = this.f82194r;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "reqSrc");
        HashMap<String, Object> r102 = r101.a();
        r102.put("req_src", r100);
        h r103 = r101.f483307f;
        LiveTracingMonitor.EventModule r104 = LiveTracingMonitor.b(0);
        int r105 = h.f483311d;
        r103.m(r104, "stop_interact_streaming", r102, false);
    L5:
        u r106 = this.f82185i;
        if (r106 == null) goto L9;
        r106.l8();
    L9:
        if (this.f82177a != null) goto L13;
        gy.a r107 = this.f82194r;
        if (r107 == null) goto L13;
        r107.c("guestStopEngine " + r100);
    L13:
        ei6.a r108 = this.f82177a;
        if (r108 == null) goto L18;
        ui6.b r109 = r108.h();
        if (r109 == null) goto L18;
        r109.a(a());
    L18:
        ei6.a r110 = this.f82177a;
        if (r110 == null) goto L23;
        si6.b r111 = r110.b();
        if (r111 == null) goto L23;
        si6.a.b(r111, false, "GuestRtcManager stopEngine", 3);
    L23:
        System.currentTimeMillis();
        Disposable r112 = this.f82183g;
        if (r112 == null) goto L26;
        r112.dispose();
    L26:
        this.f82183g = Observable.timer(10, TimeUnit.SECONDS).subscribe(e.f82212a);
        ei6.a r113 = this.f82177a;
        if (r113 == null) goto L31;
        ri6.b r114 = r113.r();
        if (r114 == null) goto L31;
        r114.s1();
    L31:
        Disposable r115 = this.f82182f;
        if (r115 == null) goto L34;
        r115.dispose();
    L34:
        this.f82195s.clear();
        HashSet<String> r116 = this.f82196t;
        if (r116 == null) goto L38;
        r116.clear();
        return;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        this.f82187k.clear();
        if (this.f82186j == false) goto L12;
        gy.a r101 = this.f82194r;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        HashMap<String, Object> r102 = r101.a();
        r102.put("stop_forward_req", r100);
        h r103 = r101.f483307f;
        LiveTracingMonitor.EventModule r104 = LiveTracingMonitor.b(0);
        int r105 = h.f483311d;
        r103.m(r104, "stop_forward_stream", r102, false);
    L8:
        if (this.f82177a != null) goto L12;
        gy.a r106 = this.f82194r;
        if (r106 == null) goto L12;
        r106.c("guestStopForwardStreamToRooms");
    L12:
        ei6.a r107 = this.f82177a;
        if (r107 == null) goto L18;
        ui6.b r108 = r107.h();
        if (r108 == null) goto L19;
        r108.a(a());
        return;
    L19:
        return;
    }

    public static void i(a r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.length() <= 0) goto L6;
        boolean r102 = true;
    L7:
        Integer r103 = null;
        if (r102 == false) goto L10;
        String r104 = r101;
    L11:
        if (r104 == null) goto L39;
        d0 r105 = r100.f82178b;
        if (r105 == null) goto L17;
        d0.a r106 = r105.getBuilder();
        if (r106 == null) goto L17;
        r103 = Integer.valueOf(r106.f0());
    L17:
        ALogger.w("GuestRtcManager", "GuestRtcManager updateLiveCoreExtInfo ".concat(r101));
        gy.a r107 = r100.f82194r;
        HashMap<String, Object> r108 = r107.a();
        r108.put("liveCore", r101);
        h r109 = r107.f483307f;
        LiveTracingMonitor.EventModule r110 = LiveTracingMonitor.b(0);
        int r111 = h.f483311d;
        r109.m(r110, "update_live_core", r108, false);
        if (((IEffectPerfToolsHelper) k.n(IEffectPerfToolsHelper.class)).checkDebug() == false) goto L20;
        ((IEffectPerfToolsHelper) k.n(IEffectPerfToolsHelper.class)).setPerfToolsNormalData("data_chatroom_livecore_extra", r101);
    L20:
        ei6.a r112 = r100.f82177a;
        if (r112 == null) goto L25;
        si6.b r113 = r112.b();
        if (r113 == null) goto L25;
        r113.f(r101);
    L25:
        d0 r114 = r100.f82178b;
        if (r114 == null) goto L28;
        r114.A();
    L28:
        if (r103 == null) goto L43;
        d0 r115 = r100.f82178b;
        if (r115 == null) goto L40;
        d0.a r116 = r115.getBuilder();
        if (r116 != null) goto L35;
        return;
    L35:
        if (r103.intValue() == r116.f0()) goto L42;
        r100.f82197u = r103;
        return;
    L42:
        return;
    L40:
        return;
    L43:
        return;
    L39:
        return;
    L10:
        r104 = null;
        goto L11
    L6:
        r102 = false;
        goto L7
    }

    public static void j(a r100, String r101) {
        Intrinsics.checkNotNullParameter("", "src");
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        String r103 = r101;
    L11:
        if (r103 == null) goto L19;
        ALogger.w("GuestRtcManager", "GuestRtcManager updateRtcExtInfo ".concat(r101));
        r100.f82198v = r101;
        LinkSecurityManager.f("switch_resolution");
        gy.a r104 = r100.f82194r;
        HashMap<String, Object> r105 = r104.a();
        r105.put("rtc_params", r101);
        h r106 = r104.f483307f;
        LiveTracingMonitor.EventModule r107 = LiveTracingMonitor.b(0);
        int r108 = h.f483311d;
        r106.m(r107, "update_rtc_params", r105, false);
        ei6.a r109 = r100.f82177a;
        if (r109 == null) goto L20;
        si6.b r110 = r109.b();
        if (r110 == null) goto L21;
        r110.c(r101);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r103 = null;
        goto L11
    L7:
        r102 = false;
        goto L8
    }

    public final ei6.a b(v0 r100, String r101) {
        this.f82193q = r100;
        Intrinsics.checkNotNullParameter(r101, "rtcExtInfo");
        fi6.a r102 = new fi6.a();
        r102.h(TTMiddlewareLiveSDK.getContext());
        Intrinsics.checkNotNullParameter(r101, "info");
        r102.f477406v = r101;
        r102.S = 5;
        String r103 = s1.B(R.string.ttlive_stream_project_key);
        Intrinsics.checkNotNullParameter(r103, "key");
        r102.f477407w = r103;
        String r104 = ((IHostContext) k.n(IHostContext.class)).getChannel();
        Intrinsics.checkNotNullParameter(r104, "channel");
        r102.f477409y = r104;
        r102.c(String.valueOf(((IHostContext) k.n(IHostContext.class)).appId()));
        r102.e(((IHostContext) k.n(IHostContext.class)).getVersionCode());
        r102.d(String.valueOf(((IHostContext) k.n(IHostContext.class)).getUpdateVersionCode()));
        if (((IHostContext) k.n(IHostContext.class)).isBoe() == false) goto L6;
        r102.l(Env.ENV_BOE);
    L6:
        if (jn0.f120539a.getValue().booleanValue() == true) goto L8;
    L10:
        boolean r105 = true;
        if (ma1.f120740a.getValue().booleanValue() == false) goto L13;
        r102.f477390j = 1;
    L13:
        r102.k(j1.a());
        if (n.b() == false) goto L16;
        r102.Z = true;
        x.O(true);
    L17:
        v r106 = this.f82180d;
        if (r106 == null) goto L21;
        r106.p2(r102);
    L21:
        if (r101.length() == 0) goto L24;
        r105 = false;
    L24:
        if (r105 == false) goto L26;
        ALogger.e("GuestRtcManager", "GuestRtcManager initEngine rtcInfo is empty");
    L26:
        if (r100 != null) goto L30;
        return null;
    L30:
        return r100.create();
    L16:
        x.O(false);
        goto L17
    L8:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        r102.l(Env.ENV_TEST);
        goto L10
    }

    public final void c(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        ei6.a r102 = this.f82177a;
        if (r102 == null) goto L7;
        ri6.b r103 = r102.r();
        if (r103 == null) goto L7;
        r103.l(a(), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r100, r101, LiveCommonConstants.REASON_REVENUE_SILENCE);
    L7:
        if (r101 == false) goto L9;
        this.f82196t.add(r100);
        return;
    L9:
        this.f82196t.remove(r100);
    }

    public final void h(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        ei6.a r102 = this.f82177a;
        if (r102 == null) goto L7;
        ri6.b r103 = r102.r();
        if (r103 == null) goto L7;
        r103.s(a(), !r100);
    L7:
        d0 r104 = this.f82178b;
        if (r104 == null) goto L10;
        r104.k();
    L10:
        gy.a r105 = this.f82194r;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r101, "reason");
        HashMap<String, Object> r106 = r105.a();
        r106.put("enable", String.valueOf(r100));
        r106.put("reason", r101);
        h r107 = r105.f483307f;
        LiveTracingMonitor.EventModule r108 = LiveTracingMonitor.b(0);
        int r109 = h.f483311d;
        r107.m(r108, "switch_audio", r106, false);
    }

    public final Integer e(Map<Long, String> r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r111, "source");
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.Notification.CHANNEL_ID);
        ArrayList r100 = new ArrayList();
        Iterator<Map.Entry<Long, String>> r101 = r110.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<Long, String> r102 = r101.next();
        if (r102.getKey().longValue() == this.f82199w.f162599id) goto L4;
        r100.add(new ui6.a(String.valueOf(r102.getKey().longValue()), r102.getValue()));
        goto L4
    L8:
        this.f82187k.clear();
        this.f82187k.addAll(r100);
        gy.a r103 = this.f82194r;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r100, "forwardRoomList");
        Intrinsics.checkNotNullParameter(r111, "reqFrom");
        String r113 = Arrays.toString(CollectionsKt.toLongArray(r110.keySet()));
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r105 = r100.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(((ui6.a) r105.next()).f550209a);
        goto L10
    L12:
        String r106 = r104.toString();
        HashMap<String, Object> r107 = r103.a();
        r107.put("rtc_map_keys", r113);
        r107.put("forward_rooms", r106);
        r107.put("req_from", r111);
        h r114 = r103.f483307f;
        LiveTracingMonitor.EventModule r108 = LiveTracingMonitor.b(0);
        int r109 = h.f483311d;
        r114.m(r108, "start_forward_stream", r107, false);
        ei6.a r115 = this.f82177a;
        if (r115 == null) goto L17;
        ui6.b r116 = r115.h();
        if (r116 == null) goto L17;
        r116.d(a(), r100, r112);
        return 0;
    L17:
        return null;
    }

    @Override // ii6.a
    public final void H(ei6.a r100, int r101, long r110, Exception r111) {
        this.f82184h.post(new c(this, r101, r110, r111));
    }

    @Override // ii6.a
    public final void M(ei6.a r100, int r101, long r110, Object... r111) {
        Intrinsics.checkNotNullParameter(r111, "params");
        this.f82184h.post(new d(this, r101, r110, r111));
    }
}
