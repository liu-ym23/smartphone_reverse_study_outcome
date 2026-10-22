package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.browser.jsbridge.base.LiveGetInteractToolInfoResultModel;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.a30;
import com.bytedance.android.livesdk.config.b30;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.getInteractToolInfo")
public final class c6 extends w20.u2<w20.ra, LiveGetInteractToolInfoResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f63334a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f63335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f63336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f63337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f63338d;

        public a() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f63335a, r101.f63335a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f63336b, r101.f63336b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f63337c, r101.f63337c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f63338d, r101.f63338d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f63335a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f63336b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f63337c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f63338d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "StatusInfo(useStatus=" + this.f63335a + ", repelStatus=" + this.f63336b + ", isVideoMerge=" + this.f63337c + ", countLimit=" + this.f63338d + ")";
        }

        public a(String r100, String r101, String r102, Integer r103) {
            this.f63335a = r100;
            this.f63336b = r101;
            this.f63337c = r102;
            this.f63338d = r103;
        }
    }

    public c6() {
        this.f63334a = CollectionsKt.listOf(new Integer[]{Integer.valueOf(InteractID.InteractLoki.getValue()), Integer.valueOf(InteractID.InteractMiniApp.getValue()), Integer.valueOf(InteractID.InteractGamePlus.getValue())});
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.ra r100 = (w20.ra) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r101 = r100.b();
        String r102 = r100.a();
        if (r101 == null) goto L176;
        if (r102 == null) goto L176;
        if (CollectionsKt.contains(this.f63334a, r100.b()) == false) goto L176;
        LiveGetInteractToolInfoResultModel r103 = new LiveGetInteractToolInfoResultModel();
        r103.a(LiveGetInteractToolInfoResultModel.Code.Success);
        LiveGetInteractToolInfoResultModel.a r104 = new LiveGetInteractToolInfoResultModel.a();
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r105 = ILiveWrappedEffectSDKService.a.a();
        String r106 = "";
        if (r105 == null) goto L12;
        String r107 = r105.getSdkVersion();
        if (r107 == null) goto L12;
    L13:
        r104.a(r107);
        Unit r108 = Unit.INSTANCE;
        r103.b(r104);
        LiveGetInteractToolInfoResultModel.b r109 = new LiveGetInteractToolInfoResultModel.b();
        Integer r112 = null;
        RoomContext r113 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r113 == null) goto L18;
        com.bytedance.live.datacontext.n<String> r114 = r113.getDownLoadingInteractEffectId();
        if (r114 == null) goto L18;
        String r115 = r114.getValue();
    L19:
        r109.b(r115);
        int r116 = r101.intValue();
        boolean r117 = true;
        boolean r118 = false;
        String r119 = "open";
        if (r116 != InteractID.InteractLoki.getValue()) goto L35;
        List<String> r120 = LiveEffectContext.f66734h;
        List<Sticker> r121 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.f66754d);
        Iterator<Sticker> r122 = r121.iterator();
    L23:
        if (r122.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(String.valueOf(r122.next().getId()), r102) == false) goto L23;
        r118 = true;
    L28:
        List<String> r123 = LiveEffectContext.f66734h;
        boolean r124 = !LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.f66753c).isEmpty();
        if ((!r121.isEmpty()) == false) goto L31;
        if (r118 == true) goto L31;
    L32:
        r106 = "effect";
    L33:
        a r125 = new a(r119, r106, null, null);
    L175:
        r109.d(r125.f63335a);
        r109.c(r125.f63336b);
        r109.e(r125.f63337c);
        r109.a(r125.f63338d);
        Unit r126 = Unit.INSTANCE;
        r103.c(r109);
        finishWithResult(r103);
        return;
    L31:
        if (r124 == false) goto L33;
    L27:
        r119 = "close";
        goto L28
    L35:
        if (r116 != InteractID.InteractMiniApp.getValue()) goto L91;
        if (b30.f119839a.getValue().booleanValue() == false) goto L45;
        IBroadcastService r127 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r127 == null) goto L45;
        Set<String> r128 = r127.getRunningInteractPlugins();
        if (r128 == null) goto L45;
        if ((!r128.isEmpty()) != true) goto L45;
    L56:
        boolean r129 = true;
    L58:
        IBroadcastService r130 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r130 == null) goto L65;
        List<String> r131 = r130.getRunningInteractPluginIds();
        if (r131 == null) goto L65;
        if (r131.isEmpty() == true) goto L65;
        boolean r132 = true;
    L66:
        if (r129 == true) goto L70;
        if (r132 == true) goto L70;
        boolean r133 = false;
    L71:
        IBroadcastService r134 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r134 == null) goto L78;
        List<String> r135 = r134.getRunningInteractPluginIds();
        if (r135 == null) goto L78;
        if (r135.contains(r102) != true) goto L78;
    L79:
        if (r118 == false) goto L81;
        r106 = "repel_effect";
    L81:
        IBroadcastService r136 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r136 == null) goto L88;
        List<String> r137 = r136.getRunningInteractPluginIds();
        if (r137 == null) goto L88;
        if (r137.contains(r102) != true) goto L88;
    L89:
        r125 = new a(r119, r106, null, null);
    L88:
        r119 = "close";
    L78:
        r118 = r133;
    L70:
        r133 = true;
    L65:
        r132 = false;
    L45:
        boolean r138 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        fa0.c r139 = (fa0.c) com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r139 == null) goto L57;
        fa0.a r140 = r139.o0();
        if (r140 == null) goto L57;
        if (r140.f475994a == false) goto L57;
        Integer r141 = r140.getType();
        if (r141 == null) goto L57;
        if (r141.intValue() == 7) goto L56;
    L57:
        r129 = false;
        goto L58
    L91:
        if (r116 == InteractID.InteractGamePlus.getValue()) goto L93;
        r125 = new a(null, null, null, null);
        goto L175
    L93:
        if (b30.f119839a.getValue().booleanValue() == false) goto L125;
        IBroadcastService r142 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r142 == null) goto L99;
        Set<String> r143 = r142.getRunningInteractPlugins();
        if (r143 == null) goto L99;
        int r144 = r143.size();
    L100:
        IBroadcastService r145 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r145 == null) goto L103;
        boolean r146 = r145.isPluginRunning(r102);
    L104:
        boolean r147 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        fa0.c r148 = (fa0.c) com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r148 == null) goto L123;
        fa0.a r149 = r148.o0();
        if (r149 == null) goto L123;
        if (r146 == true) goto L115;
        String r150 = r149.f475996c;
        if (r150 == null) goto L115;
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L113
        r146 = Intrinsics.areEqual(LiveSeiUtil.c(r150).optString("MiniAppID"), r102);     // Catch: Exception -> L113
    L115:
        if (r149.f475994a == false) goto L123;
        Integer r151 = r149.getType();
        if (r151 == null) goto L123;
        if (r151.intValue() != 7) goto L123;
        r144 = r144 + 1;
    L123:
        if (r144 >= a30.f119761a.getValue().intValue()) goto L143;
    L144:
        boolean r152 = false;
    L146:
        IBroadcastService r153 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r153 == null) goto L153;
        List<String> r154 = r153.getRunningInteractPluginIds();
        if (r154 == null) goto L153;
        if (r154.isEmpty() == true) goto L153;
        boolean r155 = true;
    L154:
        if (r155 == true) goto L159;
        if (r152 == true) goto L159;
        r117 = false;
    L159:
        if (r146 == true) goto L162;
        r119 = "close";
    L162:
        if (r117 == false) goto L164;
        r106 = CloudControlInf.PLUGIN;
    L164:
        b30 r156 = b30.f119839a;
        if (r156.getValue().booleanValue() == false) goto L167;
        String r157 = "1";
    L169:
        if (r156.getValue().booleanValue() == false) goto L173;
        if (r152 == false) goto L173;
        if (r146 == true) goto L173;
        r112 = a30.f119761a.getValue();
    L173:
        r125 = new a(r119, r106, r157, r112);
        goto L175
    L167:
        r157 = null;
    L153:
        r155 = false;
    L143:
        r152 = true;
        goto L146
    L103:
        r146 = false;
    L99:
        r144 = 0;
        goto L100
    L125:
        boolean r158 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        fa0.c r159 = (fa0.c) com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r159 == null) goto L145;
        fa0.a r160 = r159.o0();
        if (r160 == null) goto L145;
        String r161 = r160.f475996c;
        if (r161 != null) goto L180;
        r146 = false;
    L137:
        if (r160.f475994a == false) goto L144;
        Integer r162 = r160.getType();
        if (r162 == null) goto L144;
        if (r162.intValue() != 7) goto L144;
    L180:
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L133
        boolean r163 = Intrinsics.areEqual(LiveSeiUtil.c(r161).optString("MiniAppID"), r102);     // Catch: Exception -> L133
    L134:
        r146 = r163;
    L133:
        r163 = false;
    L145:
        r152 = false;
        r146 = false;
    L18:
        r115 = null;
    L12:
        r107 = "";
    L176:
        finishWithFailure();
    }
}
