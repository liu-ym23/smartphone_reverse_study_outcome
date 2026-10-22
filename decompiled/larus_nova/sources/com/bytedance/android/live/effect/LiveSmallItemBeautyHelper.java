package com.bytedance.android.live.effect;

import android.os.Looper;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyFragment;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveSmallItemBeautyHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Sticker> f66679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Sticker> f66680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f66681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.effect.sticker.e f66682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Sticker> f66683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Sticker> f66684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66685g;

    public static final class a {
    }

    public interface b {
        void a(Sticker r100);

        void onError();
    }

    public interface c {
        void onError();

        void onSuccess(List<Sticker> r100);
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/effect/LiveSmallItemBeautyHelper$d", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d extends TypeToken<List<? extends Sticker.ComposerConfig>> {
        public d() {
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f66686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f66687b;

        public e(b r100, Sticker r101) {
            this.f66686a = r100;
            this.f66687b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f66686a.a(this.f66687b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSmallItemBeautyHelper f66688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f66689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f66690c;

        public f(LiveSmallItemBeautyHelper r100, Sticker r101, boolean r102) {
            this.f66688a = r100;
            this.f66689b = r101;
            this.f66690c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f66688a.h(this.f66689b, this.f66690c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f66691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f66692b;

        public g(b r100, Sticker r101) {
            this.f66691a = r100;
            this.f66692b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f66691a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f66692b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements com.bytedance.android.live.effect.api.k.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSmallItemBeautyHelper f66693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveSmallItemBeautyHelper$tryDownloadSticker$1 f66694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f66695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f66696d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f66697e;

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void Z(String r100, Sticker r101) {
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void O1(String r100, Sticker r101) {
            if (Intrinsics.areEqual(d0.f66759i, r100) == false) goto L12;
            if (r101 != null) goto L6;
        L8:
            this.f66694b.invoke2(this.f66695c, r101);
            Iterator<T> r102 = this.f66693a.f66681c.iterator();
        L10:
            if (r102.hasNext() == false) goto L14;
            b r103 = (b) r102.next();
            this.f66694b.invoke2(r103, r101);
            goto L10
        L14:
            return;
        L6:
            if (this.f66696d == false) goto L8;
            this.f66693a.h(r101, this.f66697e);
            goto L8
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void z0(String r100, Sticker r101, ExceptionResult r102) {
            if (Intrinsics.areEqual(d0.f66759i, r100) == false) goto L8;
            this.f66694b.invoke2(this.f66695c, null);
            Iterator<T> r103 = this.f66693a.f66681c.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            b r104 = (b) r103.next();
            this.f66694b.invoke2(r104, null);
            goto L6
        L10:
            return;
        }

        public h(LiveSmallItemBeautyHelper r100, LiveSmallItemBeautyHelper$tryDownloadSticker$1 r101, b r102, boolean r103, boolean r104) {
            this.f66693a = r100;
            this.f66694b = r101;
            this.f66695c = r102;
            this.f66696d = r103;
            this.f66697e = r104;
        }
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f66685g;
    }

    public LiveSmallItemBeautyHelper(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f66685g = r100;
        this.f66679a = new CopyOnWriteArrayList();
        this.f66680b = new CopyOnWriteArrayList();
        this.f66681c = new CopyOnWriteArrayList();
        this.f66682d = new com.bytedance.android.live.effect.sticker.e("beauty");
        this.f66683e = new ArrayList();
        this.f66684f = new CopyOnWriteArrayList();
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (((CopyOnWriteArrayList) this.f66681c).contains(r100) == true) goto L6;
        ((CopyOnWriteArrayList) this.f66681c).add(r100);
        return;
    }

    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (((CopyOnWriteArrayList) this.f66681c).contains(r100) == false) goto L6;
        ((CopyOnWriteArrayList) this.f66681c).remove(r100);
        return;
    }

    @Deprecated(message = "")
    public final void h(Sticker r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r210, "sticker");
        boolean r100 = y50.c.f566205a;
        long r101 = y50.c.g("beauty_updateLocalTagValue");
        List<String> r102 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r103 = LiveEffectContext.a.a(this.f66685g).a();
        if (r211 == false) goto L5;
        List<Sticker> r104 = this.f66683e;
    L6:
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        if (StringUtils.equal(((Sticker) r107).getResourceId(), r210.getResourceId()) == false) goto L8;
        r105.add(r107);
        goto L8
    L12:
        Iterator r108 = r105.iterator();
    L14:
        if (r108.hasNext() == false) goto L26;
        Sticker r110 = (Sticker) r108.next();
        Sticker.ComposerConfig r111 = r110.getSmallItemConfig();
        if (r111 == null) goto L25;
        if (r103.G(r110.getEffectId(), r111.getTag()) != null) goto L25;
        String r112 = d0.f66759i;
        ILiveEffectComposerManager.f.a(r103, r112, r110, "LiveSmallItemBeautyHelper_updateLocalTagValue", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), null, 48);
        Float r109 = r103.G(r110.getEffectId(), r111.getTag());
        if (r109 == null) goto L22;
        float r113 = r109.floatValue();
    L23:
        ILiveEffectComposerManager.f.d(r103, r112, r110, r111.getTag(), r113, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 16);
        goto L25
    L22:
        r113 = q.d(r110, r111.getDefaultValue());
    L25:
        r108 = r108;
        goto L14
    L26:
        boolean r114 = y50.c.f566205a;
        y50.c.h("beauty_updateLocalTagValue", r101);
        return;
    L5:
        r104 = this.f66680b;
        goto L6
    }

    public static /* synthetic */ void d(LiveSmallItemBeautyHelper r100, LiveSmallItemBeautyFragment.b r101, int r102) {
        String r103 = null;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r103 = d0.f66759i;
    L8:
        r100.c(r101, r103, false);
    }

    public final void c(c r110, String r111, boolean r112) {
        String r100 = d0.f66759i;
        if (Intrinsics.areEqual(r111, r100) == true) goto L5;
    L11:
        System.currentTimeMillis();
        m r101 = new m(this, r110);
        List<String> r113 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f66685g).b().h().c() == false) goto L18;
        com.bytedance.android.live.effect.sticker.presenter.o r102 = LiveEffectContext.a.a(this.f66685g).b().d();
        if (r111 != null) goto L16;
        String r103 = r100;
    L17:
        r102.a(r103, r101, true, true, false, true);
        return;
    L16:
        r103 = r111;
        goto L17
    L18:
        LiveEffectContext.a.a(this.f66685g).b().r().p(r111, r101, true);
        return;
    L5:
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == false) goto L7;
        List<String> r104 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.f66685g).b().l(), "style", this.f66685g, null, 12);
    L7:
        if (r112 == false) goto L11;
        List<String> r114 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.f66685g).b().l(), "beautyclassify", this.f66685g, null, 12);
        if (r110 != null) goto L11;
    }

    public final void f(Sticker r110, boolean r111, b r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "sticker");
        LiveSmallItemBeautyHelper$tryDownloadSticker$1 r100 = new LiveSmallItemBeautyHelper$tryDownloadSticker$1(Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())));
        List<String> r101 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f66685g).b().r().q(r110) == false) goto L11;
        if (r111 == false) goto L6;
        AndroidSchedulers.mainThread().scheduleDirect(new f(this, r110, r113));
    L6:
        AndroidSchedulers.mainThread().scheduleDirect(new g(r112, r110));
        Iterator r114 = ((CopyOnWriteArrayList) this.f66681c).iterator();
    L8:
        if (r114.hasNext() == false) goto L10;
        b r115 = (b) r114.next();
        AndroidSchedulers.mainThread().scheduleDirect(new e(r115, r110));
        goto L8
    L10:
        return;
    L11:
        LiveEffectContext.a.a(this.f66685g).b().r().g(d0.f66759i, r110, new h(this, r100, r112, r111, r113));
    }

    public static /* synthetic */ void g(LiveSmallItemBeautyHelper r100, Sticker r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 8) == 0) goto L5;
        r103 = false;
    L5:
        r100.f(r101, r102, null, r103);
    }

    public final Sticker b(List<Sticker> r100, Effect r101, boolean r102, String r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "stickerList");
        Intrinsics.checkNotNullParameter(r101, "effect");
        Sticker r106 = com.bytedance.android.live.effect.sticker.d.b(r101);
        r106.setParentResId(r103);
        JsonObject r107 = new JsonParser().parse(r101.getExtra()).getAsJsonObject();     // Catch: Throwable -> L32
        JsonElement r108 = r107.get("video_tag");     // Catch: Throwable -> L32
        String r109 = "";
        if (r108 == null) goto L8;
        String r110 = r108.getAsString();     // Catch: Throwable -> L32
        if (r110 == null) goto L8;
    L9:
        JsonElement r111 = r107.get("beautyConfig");     // Catch: Throwable -> L32
        if (r111 == null) goto L16;
        String r112 = r111.getAsString();     // Catch: Throwable -> L32
        if (r112 == null) goto L16;
        r109 = r112;
    L16:
        if (r109.length() != 0) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L21;
        return r106;
    L21:
        JsonArray r114 = new JsonParser().parse(r109).getAsJsonObject().getAsJsonArray("items");     // Catch: Throwable -> L32
        Type r115 = new d().getType();     // Catch: Throwable -> L32
        List<Sticker.ComposerConfig> r116 = (List) GsonHelper.get().fromJson(r114, r115);     // Catch: Throwable -> L32
        r106.setComposerConfigList(r116);     // Catch: Throwable -> L32
        r106.setVideoTag(r110);     // Catch: Throwable -> L32
        Iterator<T> r117 = r116.iterator();     // Catch: Throwable -> L32
    L23:
        if (r117.hasNext() == false) goto L25;
        Sticker.ComposerConfig r118 = (Sticker.ComposerConfig) r117.next();     // Catch: Throwable -> L32
        r106.getUpdateKeys().add(r118.getTag());     // Catch: Throwable -> L32
        goto L23
    L25:
        if (r104 == true) goto L27;
        r100.add(r106);     // Catch: Throwable -> L32
    L30:
        f(r106, r102, null, r105);     // Catch: Throwable -> L32
    L34:
        return r106;
    L27:
        if (r100.contains(r106) == true) goto L30;
        r100.add(r106);     // Catch: Throwable -> L32
        goto L30
    L18:
        r113 = false;
    L8:
        r110 = "";
    L32:
        th = move-exception;
        ALogger.e("LiveSmallItemBeautyDialogFragment", th);
        goto L34
    }
}
