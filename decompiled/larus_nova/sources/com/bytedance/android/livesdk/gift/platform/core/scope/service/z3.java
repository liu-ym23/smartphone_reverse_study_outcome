package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.interacteffect.api.MessageType;
import com.bytedance.android.live.revenue.platform.interacteffect.api.Scene;
import com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.AtmosphereDataStore;
import com.bytedance.android.livesdk.message.model.l6;
import com.bytedance.android.livesdk.revenue.service.effect.RevStickerPanel;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.effectmanager.MobConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class z3 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f131873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l6 f131874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f131875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.configmodel.a f131876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f131877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yz0.l f131878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.effect.c f131879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final yz0.k f131880h;

    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z3 f131881a;

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q
        public final void error(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        public a(z3 r100) {
            this.f131881a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q
        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "filePath");
            if (this.f131881a.f() == false) goto L11;
            i12.e r102 = i12.o.b();
            if (r102 == null) goto L7;
            Object r103 = com.bytedance.android.scope.m.f163449e.d(r102, com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.f.class);
        L8:
            com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.f r104 = (com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.f) r103;
            if (r104 == null) goto L13;
            this.f131881a.getClass();
            LinkedHashMap r105 = new LinkedHashMap();
            Gson r106 = GsonHelper.getDefault();
            LinkedHashMap r107 = new LinkedHashMap();
            r107.put(r100, r101);
            LinkedHashMap r108 = new LinkedHashMap();
            r108.put("image_url", r107);
            r105.put("arg3", GsonProtectorUtils.toJson(r106, r108));
            r105.put("arg2", 1000004);
            r105.put("arg1", 101);
            r105.put(SeiMessageConst.MSG_TYPE, 40);
            String r109 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r105).toString();
            Intrinsics.checkNotNullParameter(r109, "param");
            r104.K0(new com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.g(r109));
            return;
        L13:
            return;
        L7:
            r103 = null;
            goto L8
        L11:
            ez0.b r110 = (ez0.b) vh6.c.b(ez0.b.class);
            MessageType r111 = MessageType.MSG_TYPE_LIVE_INTERACTION;
            Scene r112 = Scene.ATMOSPHERE;
            Gson r113 = GsonHelper.getDefault();
            this.f131881a.getClass();
            LinkedHashMap r114 = new LinkedHashMap();
            r114.put(r100, r101);
            LinkedHashMap r115 = new LinkedHashMap();
            r115.put("image_url", r114);
            r110.Vf(r111, r112, 1000004, GsonProtectorUtils.toJson(r113, r115));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z3 f131882a;

        public b(z3 r100) {
            this.f131882a = r100;
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
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            l6 r111 = (l6) r110;
            z3 r100 = this.f131882a;
            if (((Boolean) r100.f131880h.getDataCenter().get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L73;
            r100.f131880h.getDataCenter();
            if (com.bytedance.android.livesdk.gift.platform.core.utils.x.b() == true) goto L80;
            boolean r101 = false;
            Disposable r102 = null;
            Object r103 = null;
            r102 = null;
            if (r111.getAction() != 1) goto L24;
            long r104 = r111.getAssetId();
            if (r100.f() == false) goto L17;
            i12.e r112 = i12.o.b();
            if (r112 == null) goto L14;
            r103 = com.bytedance.android.scope.m.f163449e.d(r112, AtmosphereDataStore.class);
        L14:
            AtmosphereDataStore r105 = (AtmosphereDataStore) r103;
            if (r105 == null) goto L74;
            KProperty[] r113 = AtmosphereDataStore.f129158n;
            r105.k(r104, false);
            return;
        L74:
            return;
        L17:
            Iterator<yp2.b> r114 = r100.f131879g.f4(RevStickerPanel.EFFECT_ATMOSPHERE).iterator();
        L19:
            if (r114.hasNext() == false) goto L83;
            yp2.b r106 = r114.next();
            if (r106.getId() != r104) goto L19;
            r100.f131879g.Bn(r106, RevStickerPanel.EFFECT_ATMOSPHERE);
            goto L19
        L83:
            return;
        L24:
            if (r111.getEndTime() > 0) goto L26;
        L28:
            r100.f131874b = r111;
            if (r100.f() == false) goto L46;
            if (r100.f131876d.a() == false) goto L46;
            Disposable r107 = r100.f131877e;
            if (r107 != null) goto L35;
        L36:
            Observable<dq2.e> r108 = r100.f131880h.getAudioTalkSwitchSceneEvent();
            if (r108 == null) goto L41;
            Observable<dq2.e> r109 = r108.subscribeOn(AndroidSchedulers.mainThread());
            if (r109 == null) goto L41;
            r102 = r109.subscribe(new b4(r100), c4.f131490a);
        L41:
            r100.f131877e = r102;
            if (r102 == null) goto L44;
            r100.f131873a.add(r102);
        L44:
            long r115 = r111.getAssetId();
            x3 r116 = new x3(r100, r111);
            r100.f131879g.h2(String.valueOf(r115), new w3(r100, r116));
            return;
        L35:
            if (r107.isDisposed() != true) goto L44;
        L46:
            if (r100.f131876d.c() == true) goto L48;
            return;
        L48:
            if (r100.f131880h.getLiveMode() != LiveMode.VIDEO) goto L50;
            boolean r117 = true;
        L51:
            if (r117 == true) goto L53;
            return;
        L53:
            if (r100.f131880h.isAnchor() == false) goto L82;
            Iterator<yp2.b> r118 = r100.f131879g.f4(RevStickerPanel.EFFECT_ATMOSPHERE).iterator();
        L57:
            if (r118.hasNext() == false) goto L61;
            if (r118.next().getId() != r111.getAssetId()) goto L57;
            r101 = true;
        L61:
            if (r101 == false) goto L63;
            String r119 = z3.c(r111);
            ((ez0.b) vh6.c.b(ez0.b.class)).Vf(MessageType.MSG_TYPE_LIVE_INTERACTION, Scene.ATMOSPHERE, 1000000, r119);
            return;
        L63:
            long r120 = r111.getAssetId();
            y3 r121 = new y3(r100, r111);
            r100.f131879g.h2(String.valueOf(r120), new w3(r100, r121));
            return;
        L82:
            return;
        L50:
            r117 = false;
            goto L51
        L26:
            if (r111.getEndTime() >= (com.bytedance.live.kmp.util.e.b() / ((long) 1000))) goto L28;
            return;
        L80:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f131883a = null;

        static {
            f131883a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).getMessage();
        }
    }

    public final boolean f() {
        if (this.f131880h.isAudioRoom() == true) goto L5;
        return false;
    L5:
        int r100 = ((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).getCurrentScene();
        if (r100 != 5) goto L8;
    L15:
        return true;
    L8:
        if (r100 == 16) goto L15;
        if (r100 == 0) goto L12;
    L14:
        return false;
    L12:
        if (this.f131880h.getRoom().isLiveTypeAudio() == false) goto L14;
        return true;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(((ez0.b) vh6.c.b(ez0.b.class)).observeEffectMessage().observeOn(AndroidSchedulers.mainThread()).subscribe(new a4(this)), this.f131873a);
        yz0.l r100 = this.f131878f;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r100, com.bytedance.android.live.revenue.common.message.b.S, true, 4).subscribe(new b(this), c.f131883a), this.f131873a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131873a.clear();
    }

    public static String c(l6 r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("end_time", Long.valueOf(r100.getEndTime()));
        r101.put(MobConstants.EFFECT_ID, Long.valueOf(r100.getAssetId()));
        r101.put("activity_information", r100.getActivityInformation());
        r101.put("platform", 0);
        return GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r101).toString();
    }

    public z3(yz0.l r100, com.bytedance.android.livesdk.revenue.service.effect.c r101, yz0.k r102) {
        Intrinsics.checkNotNullParameter(r100, "roomMessageService");
        Intrinsics.checkNotNullParameter(r101, "effectService");
        Intrinsics.checkNotNullParameter(r102, "roomDataService");
        this.f131878f = r100;
        this.f131879g = r101;
        this.f131880h = r102;
        this.f131873a = new CompositeDisposable();
        this.f131875c = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.Q.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.f129044a[41])).booleanValue();
        this.f131876d = (com.bytedance.android.livesdk.gift.configmodel.a) nz1.a.f521366y.getValue(null, nz1.a.f521324a[23]);
    }

    public static final void a(z3 r100, long r101, String r102) {
        if (r100.f131875c == false) goto L21;
        List r103 = StringsKt.split$default(r102, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        ListIterator r104 = r103.listIterator(r103.size());
    L6:
        if (r104.hasPrevious() == false) goto L13;
        Object r105 = r104.previous();
        if (((String) r105).length() <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L6;
    L14:
        int r107 = ft1.k.f478773a;
        HashMap r108 = new HashMap();
        r108.put("gift_float_asset", r101 + ',' + ((String) r105));
        Unit r109 = Unit.INSTANCE;
        ft1.k.a(r108);
        return;
    L10:
        r106 = false;
        goto L11
    L13:
        r105 = null;
        goto L14
    }

    public final void d(int r110, int r111, int r112, String r113) {
        if (r110 == 57) goto L5;
    L35:
        if (r110 == 57) goto L37;
        return;
    L37:
        if (r111 == Scene.GIFT.getValue()) goto L39;
        return;
    L39:
        if (r112 != 1000004) goto L62;
        if (r113 == null) goto L63;
        List<String> r114 = ((r) GsonHelper.getDefault().fromJson(r113, r.class)).a();     // Catch: Exception -> L49
        if (r114 == null) goto L64;
        Iterator<T> r115 = r114.iterator();     // Catch: Exception -> L49
    L45:
        if (r115.hasNext() == false) goto L66;
        String r116 = (String) r115.next();     // Catch: Exception -> L49
        ((w) com.bytedance.android.live.revenue.core.util.f.a(w.class)).a(r116, new a(this));     // Catch: Exception -> L49
    L66:
        return;
    L64:
        return;
    L65:
        return;
    L63:
        return;
    L62:
        return;
    L5:
        if (r111 != Scene.GIFT.getValue()) goto L35;
        if (r112 != 1000001) goto L35;
        if (r113 == null) goto L35;
        a0 r100 = (a0) GsonHelper.getDefault().fromJson(r113, a0.class);     // Catch: Exception -> L34
        if (Intrinsics.areEqual(r100.getType(), "destroy_effect") == false) goto L29;
        if (r100.a() <= 0) goto L29;
        if (f() == false) goto L22;
        i12.e r101 = i12.o.b();     // Catch: Exception -> L34
        if (r101 == null) goto L18;
        Object r102 = com.bytedance.android.scope.m.f163449e.d(r101, AtmosphereDataStore.class);     // Catch: Exception -> L34
    L19:
        AtmosphereDataStore r103 = (AtmosphereDataStore) r102;     // Catch: Exception -> L34
        if (r103 == null) goto L29;
        long r104 = r100.a();     // Catch: Exception -> L34
        KProperty[] r105 = AtmosphereDataStore.f129158n;     // Catch: Exception -> L34
        r103.k(r104, false);     // Catch: Exception -> L34
        goto L29
    L18:
        r102 = null;
        goto L19
    L22:
        Iterator<yp2.b> r106 = this.f131879g.f4(RevStickerPanel.EFFECT_ATMOSPHERE).iterator();     // Catch: Exception -> L34
    L24:
        if (r106.hasNext() == false) goto L29;
        yp2.b r107 = r106.next();     // Catch: Exception -> L34
        if (r107.getId() != r100.a()) goto L24;
        this.f131879g.Bn(r107, RevStickerPanel.EFFECT_ATMOSPHERE);     // Catch: Exception -> L34
    L29:
        if (Intrinsics.areEqual(r100.getType(), "effect_apply_succeed") == false) goto L35;
        l6 r108 = this.f131874b;     // Catch: Exception -> L34
        if (r108 == null) goto L35;
        String r109 = c(r108);     // Catch: Exception -> L34
        ((ez0.b) vh6.c.b(ez0.b.class)).Vf(MessageType.MSG_TYPE_LIVE_INTERACTION, Scene.ATMOSPHERE, 1000000, r109);     // Catch: Exception -> L34
        goto L35
    }
}
