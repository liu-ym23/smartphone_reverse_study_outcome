package com.bytedance.android.livesdk.gift.platform.core.sticker;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.h;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.j;
import com.bytedance.android.livesdk.gift.platform.core.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.w;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.scope.o;
import com.larus.apm.impl.protector.RunnableProtector;
import com.mammon.audiosdk.SAMICoreCode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class StickerMessageService implements o, com.bytedance.android.livesdk.gift.platform.core.sticker.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f131896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<StickerType, StickerMessageInfo> f131897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f131898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f131899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f131900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f131901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f131902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f131903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f131904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f131905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j f131906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f131907l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.user.a f131908m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f131909n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ha0.a f131910o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.core.sticker.b f131911p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final vy0.b f131912q;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/sticker/StickerMessageService$StickerType;", "", "Normal", "Special", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum StickerType extends Enum<StickerType> {
        public static final StickerType Normal = null;
        public static final StickerType Special = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StickerType[] f131913a = null;

        static {
            StickerType r100 = new StickerType("Normal", 0);
            Normal = r100;
            StickerType r101 = new StickerType("Special", 1);
            Special = r101;
            f131913a = new StickerType[]{r100, r101};
        }

        public static StickerType valueOf(String r100) {
            return (StickerType) r27.a.a(StickerType.class, r100);
        }

        public static StickerType[] values() {
            return (StickerType[]) f131913a.clone();
        }

        public StickerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StickerMessageService f131914a;

        public b(StickerMessageService r100) {
            this.f131914a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            StickerMessageService r101 = this.f131914a;
            r101.getClass();
            switch(r100.what) {
                case 140001: goto L19;
                case 140002: goto L18;
                case 140003: goto L17;
                case 140004: goto L35;
                case 140005: goto L11;
                case 140006: goto L5;
                default: goto L35;
            };
        L5:
            Object r102 = ((LinkedHashMap) r101.f131897b).get(StickerType.Special);
            Intrinsics.checkNotNull(r102);
            StickerMessageInfo r103 = (StickerMessageInfo) r102;
            if (r103.f131894k.hasMessages(140002) == false) goto L8;
            r103.f131894k.removeMessages(140002);
        L8:
            w r104 = r103.f131886c;
            if (r104 == null) goto L28;
            Handler r105 = r103.f131894k;
            r105.sendMessageDelayed(r105.obtainMessage(140002), r104.f130925y);
            return true;
        L28:
            return true;
        L11:
            Object r106 = ((LinkedHashMap) r101.f131897b).get(StickerType.Normal);
            Intrinsics.checkNotNull(r106);
            StickerMessageInfo r107 = (StickerMessageInfo) r106;
            if (r107.f131894k.hasMessages(SAMICoreCode.pubSAMI_PROCESS_RNNOISE_ERROR) == false) goto L14;
            r107.f131894k.removeMessages(SAMICoreCode.pubSAMI_PROCESS_RNNOISE_ERROR);
        L14:
            w r108 = r107.f131886c;
            if (r108 == null) goto L30;
            Handler r109 = r107.f131894k;
            r109.sendMessageDelayed(r109.obtainMessage(SAMICoreCode.pubSAMI_PROCESS_RNNOISE_ERROR), r108.f130925y);
            return true;
        L30:
            return true;
        L17:
            r101.y();
            return true;
        L18:
            Object r110 = ((LinkedHashMap) r101.f131897b).get(StickerType.Special);
            Intrinsics.checkNotNull(r110);
            StickerMessageInfo r111 = (StickerMessageInfo) r110;
            int r112 = e.f131918a;
            e.a(r111, r101.f131909n.getRoomContext());
            r111.f131889f = 0;
            HashMap r113 = new HashMap();
            Intrinsics.checkNotNullParameter(r113, "<set-?>");
            r111.f131888e = r113;
            r101.I();
            return true;
        L19:
            Map<StickerType, StickerMessageInfo> r114 = r101.f131897b;
            StickerType r115 = StickerType.Normal;
            Object r116 = ((LinkedHashMap) r114).get(r115);
            Intrinsics.checkNotNull(r116);
            StickerMessageInfo r117 = (StickerMessageInfo) r116;
            int r118 = e.f131918a;
            Object r119 = ((LinkedHashMap) r101.f131897b).get(r115);
            Intrinsics.checkNotNull(r119);
            e.b((StickerMessageInfo) r119);
            if (r117.f131891h == false) goto L22;
            Object r120 = ((LinkedHashMap) r101.f131897b).get(r115);
            Intrinsics.checkNotNull(r120);
            e.c((StickerMessageInfo) r120, r101.f131909n.getRoomContext());
        L22:
            Object r121 = ((LinkedHashMap) r101.f131897b).get(r115);
            Intrinsics.checkNotNull(r121);
            e.a((StickerMessageInfo) r121, r101.f131909n.getRoomContext());
            r117.f131889f = 0;
            r117.f131886c = null;
            r117.f131885b = false;
            r117.f131891h = false;
            r117.getClass();
            HashMap r122 = new HashMap();
            Intrinsics.checkNotNullParameter(r122, "<set-?>");
            r117.f131888e = r122;
            if (com.bytedance.android.livesdk.gift.platform.business.effect.b.c() <= 0) goto L25;
            r117.f131894k.postDelayed(new f(r101), com.bytedance.android.livesdk.gift.platform.business.effect.b.c());
            return true;
        L25:
            r101.J(r115);
            return true;
        L35:
            return true;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StickerMessageService f131915a;

        public c(StickerMessageService r100) {
            this.f131915a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f131915a.J(StickerType.Special);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final boolean E() {
        return ((Boolean) this.f131899d.getValue()).booleanValue();
    }

    @Override // ca0.b
    public final void a() {
    }

    @Override // ca0.b
    public final void c(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
    }

    @Override // ca0.b
    public final void d(String[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
    }

    @Override // ca0.b
    public final void f(String[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
    }

    @Override // ca0.b
    public final void g() {
    }

    @Override // ca0.b
    public final void h(ca0.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "msgListener");
    }

    @Override // ca0.b
    public final void i(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
    }

    @Override // ca0.b
    public final void j(int r100, int r101, int r102, String r103) {
    }

    @Override // ca0.b
    public final void k(String[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
    }

    @Override // ca0.b
    public final void n(o7 r100) {
        Intrinsics.checkNotNullParameter(r100, "giftMessage");
    }

    @Override // ca0.b
    public final void o(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
    }

    @Override // ca0.b
    public final void q() {
    }

    @Override // ca0.b
    public final void release() {
    }

    @Override // ca0.b
    public final void s(int r100, int r101, int r102, String r103) {
    }

    @Override // ca0.b
    public final void w(String[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
    }

    @Override // ca0.b
    public final void x(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
    }

    public final void I() {
        Map<StickerType, StickerMessageInfo> r100 = this.f131897b;
        StickerType r101 = StickerType.Special;
        Object r102 = ((LinkedHashMap) r100).get(r101);
        Intrinsics.checkNotNull(r102);
        StickerMessageInfo r103 = (StickerMessageInfo) r102;
        e.b(r103);
        if (r103.f131891h == false) goto L5;
        e.c(r103, this.f131909n.getRoomContext());
    L5:
        r103.f131886c = null;
        r103.f131885b = false;
        r103.f131893j = -1;
        long r104 = 0;
        r103.f131890g = r104;
        r103.getClass();
        r103.f131892i = false;
        r103.f131894k.removeMessages(140003);
        r103.f131894k.removeMessages(140002);
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.c() <= r104) goto L8;
        r103.f131894k.postDelayed(new c(this), com.bytedance.android.livesdk.gift.platform.business.effect.b.c());
        return;
    L8:
        J(r101);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f131909n.getRoomContext().getCommonIsAnchor();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131909n.getRoomContext().getCommonIsAnchor();
    }

    @Override // ca0.b
    public final void stopAnimation() {
        Iterator r100 = ((LinkedHashMap) this.f131897b).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        Map.Entry r101 = (Map.Entry) r100.next();
        StickerType r102 = (StickerType) r101.getKey();
        StickerMessageInfo r103 = (StickerMessageInfo) r101.getValue();
        if (r102 != StickerType.Normal) goto L8;
        int r104 = SAMICoreCode.pubSAMI_PROCESS_RNNOISE_ERROR;
    L10:
        if (r103.f131894k.hasMessages(r104) == false) goto L12;
        r103.f131894k.removeMessages(r104);
    L12:
        Handler r105 = r103.f131894k;
        r105.sendMessage(r105.obtainMessage(r104));
        goto L4
    L8:
        r104 = 140002;
        goto L10
    }

    public final void y() {
        Map<StickerType, StickerMessageInfo> r100 = this.f131897b;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        Object r102 = r101.get(StickerType.Special);
        Intrinsics.checkNotNull(r102);
        StickerMessageInfo r103 = (StickerMessageInfo) r102;
        if (r103.f131892i == true) goto L5;
        return;
    L5:
        if (r103.f131893j <= 0) goto L11;
        i97.a r104 = i97.a.f488802a;
        if ((System.currentTimeMillis() - r103.f131890g) <= r103.f131893j) goto L12;
        I();
        return;
    L12:
        return;
    }

    public final h1 A(o7 r100) {
        if (r100.getClientGiftSource() != 1) goto L6;
        return r100.getGift();
    L6:
        return this.f131907l.findGiftById(r100.getGiftId());
    }

    public final w F(o7 r100) {
        if (r100.getMessageId() != 0) goto L5;
    L15:
        return null;
    L5:
        if (r100.getFromUser() == null) goto L15;
        h1 r101 = A(r100);
        if (r101 != null) goto L10;
        return null;
    L10:
        String r102 = this.f131906k.H0(r101.getPrimaryEffectId());
        w r103 = new w();
        r103.f130925y = r101.getDuration();
        Intrinsics.checkNotNullParameter(r100, "$this$getGiftTimeStamp");
        r103.A = r100.getGiftTimeStamp();
        r103.F = r100.getEffectDisplayTs();
        r103.f130875b = r100.getMessageId();
        r103.f130876c = r101.getId();
        r103.f130881h = r101.getPrimaryEffectId();
        r103.f130896w = r101.getDiamondCount();
        r103.f130882i = r102;
        Intrinsics.checkNotNullParameter(r100, "$this$isUrgent");
        r100.isUrgent();
        r103.f130879f = r100.getToUser();
        r103.f130878e = r100.getFromUser();
        r103.f130886m = r100.getSendGiftTime();
        r103.f130877d = r101.getType();
        r103.f130892s = r101.getDescribe();
        r103.f130894u = r100.getTraceId();
        r103.f130883j = r100.getSendTogetherInfo();
        r100.getClientGiftSource();
        r103.f130880g = r100.getGift();
        String r104 = r100.getLogId();
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f130887n = r104;
        return r103;
    }

    public final void J(StickerType r210) {
        StickerMessageInfo r100 = (StickerMessageInfo) ((LinkedHashMap) this.f131897b).get(r210);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f131885b == false) goto L8;
        return;
    L8:
        ed6.b<o7> r101 = r100.f131884a;
        if (r101.f472218b == 0) goto L11;
        o7 r102 = r101.poll();
        r100.f131887d = r102;
        if (r102 != null) goto L19;
        return;
    L19:
        long r103 = r102.getTimeStamp();
        long r110 = 0;
        if (r103 != r110) goto L22;
    L27:
        boolean r104 = false;
    L29:
        if (r104 == false) goto L37;
        long r111 = r102.getGiftId();
        String r105 = r102.getLogId();
        long r106 = r102.getTimeStamp();
        long r107 = 1000 * com.bytedance.android.livesdk.gift.platform.business.effect.b.b();
        i97.a r108 = i97.a.f488802a;
        long r109 = System.currentTimeMillis() - r102.getTimeStamp();
        b0.f130471a.b(r111, r110, r105, r106, r107, r109);
        jy0.b.c("IGiftMessage", "sticker message expired giftId:" + r111 + "，asset_id:0，log_id:" + r105 + "，receive_time_mills:" + r106 + "，expired_time_mills:" + r107 + "，total_spend_time:" + r109, null, 4);
        v12.f.s(r102, "effect_task_dequeue", 1, "message has been expired", null);
        if (E() == true) goto L33;
    L35:
        J(r210);
        return;
    L33:
        if (r210 != StickerType.Normal) goto L35;
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("render_result", "gift_expire");
        com.bytedance.android.livesdk.gift.platform.core.utils.e.c(r112);
        goto L35
    L37:
        r100.f131885b = true;
        w r113 = F(r102);
        if (r113 == null) goto L57;
        v12.f.u(r113, "effect_task_dequeue", 0, null, null);
        StickerMessageInfo r114 = (StickerMessageInfo) ((LinkedHashMap) this.f131897b).get(r210);
        if (r114 == null) goto L62;
        r114.f131886c = r113;
        if (E() == true) goto L45;
    L53:
        StickerMessageInfo r115 = (StickerMessageInfo) ((LinkedHashMap) this.f131897b).get(r210);
        if (r115 == null) goto L63;
        g r116 = new g(this, r115, r210);
        r113.B = com.bytedance.live.kmp.util.e.b();
        this.f131906k.r0(r113.f130881h, r116, 4, null);
        return;
    L63:
        return;
    L45:
        if (r210 != StickerType.Normal) goto L53;
        o7 r117 = r114.f131887d;
        if (r117 == null) goto L53;
        Intrinsics.checkNotNullParameter(r117, "$this$getMaps");
        Map<Integer, Long> r118 = r117.getMaps();
        if (r118 == null) goto L53;
        Long r119 = r118.get(11);
        if (r119 == null) goto L53;
        r113.D = r119.longValue();
        goto L53
    L62:
        return;
    L57:
        r100.f131885b = false;
        v12.f.s(r102, "effect_task_dequeue_error", 1, "getStickerEffectMessage failed", null);
        return;
    L22:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.b() <= 0) goto L27;
        i97.a r120 = i97.a.f488802a;
        if ((r103 + (com.bytedance.android.livesdk.gift.platform.business.effect.b.b() * ((long) 1000))) >= System.currentTimeMillis()) goto L27;
        r104 = true;
        goto L29
    L11:
        if (E() == true) goto L13;
        return;
    L13:
        if (r210 != StickerType.Normal) goto L60;
        LinkedHashMap r121 = new LinkedHashMap();
        r121.put("receive_stick", String.valueOf(this.f131904i));
        this.f131904i = 0;
        com.bytedance.android.livesdk.gift.platform.core.utils.e.c(r121);
        return;
    }

    public StickerMessageService(j r100, h r101, com.bytedance.android.livesdk.revenue.service.user.a r102, com.bytedance.android.livesdk.revenue.service.room.c r103, ha0.a r104, com.bytedance.android.livesdk.gift.platform.core.sticker.b r105, vy0.b r106, l02.c r107) {
        Intrinsics.checkNotNullParameter(r100, "assetsManager");
        Intrinsics.checkNotNullParameter(r101, "giftManager");
        Intrinsics.checkNotNullParameter(r102, "userService");
        Intrinsics.checkNotNullParameter(r103, "roomService");
        Intrinsics.checkNotNullParameter(r104, "effectStatisticsService");
        Intrinsics.checkNotNullParameter(r105, "stickerHandlerProviderService");
        Intrinsics.checkNotNullParameter(r106, "hybridService");
        Intrinsics.checkNotNullParameter(r107, "effectDataService");
        this.f131906k = r100;
        this.f131907l = r101;
        this.f131908m = r102;
        this.f131909n = r103;
        this.f131910o = r104;
        this.f131911p = r105;
        this.f131912q = r106;
        this.f131896a = new b(this);
        LinkedHashMap r108 = new LinkedHashMap();
        StickerType[] r109 = StickerType.values();
        int r110 = r109.length;
        int r111 = 0;
    L3:
        if (r111 >= r110) goto L5;
        r108.put(r109[r111], new StickerMessageInfo(new Handler(this.f131896a)));
        r111 = r111 + 1;
        goto L3
    L5:
        Unit r112 = Unit.INSTANCE;
        this.f131897b = r108;
        this.f131898c = LazyKt.lazy(StickerMessageService$mDurationOpt$2.INSTANCE);
        this.f131899d = LazyKt.lazy(StickerMessageService$mEffectTraceOpt$2.INSTANCE);
        this.f131900e = LazyKt.lazy(StickerMessageService$mEnableCreatePng$2.INSTANCE);
        this.f131901f = LazyKt.lazy(StickerMessageService$mAddReportNpth$2.INSTANCE);
        this.f131902g = LazyKt.lazy(StickerMessageService$giftStickerSettingConfig$2.INSTANCE);
        this.f131903h = LazyKt.lazy(new StickerMessageService$mGiftEffectMsgController$2(this));
        this.f131904i = 0;
        new HashMap();
        this.f131905j = LazyKt.lazy(new StickerMessageService$messageCenterListener$2(this));
    }
}
