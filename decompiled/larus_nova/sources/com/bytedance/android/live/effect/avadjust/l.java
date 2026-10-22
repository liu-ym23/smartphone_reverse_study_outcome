package com.bytedance.android.live.effect.avadjust;

import android.os.Looper;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Sticker> f66848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Sticker> f66849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f66850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.effect.sticker.e f66851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66852e;

    public static final class a {
    }

    public interface b {
        void onError();

        void onSuccess();
    }

    public interface c {
        void onError();

        void onSuccess(List<Sticker> r100);
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f66852e;
    }

    public l(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f66852e = r100;
        this.f66848a = new CopyOnWriteArrayList();
        this.f66849b = new CopyOnWriteArrayList();
        this.f66850c = new CopyOnWriteArrayList();
        this.f66851d = new com.bytedance.android.live.effect.sticker.e("live_adjustment");
    }

    @Deprecated(message = "")
    public final void d(Sticker r210) {
        Intrinsics.checkNotNullParameter(r210, "sticker");
        boolean r100 = y50.c.f566205a;
        long r101 = y50.c.g("av_adjust_updateLocalTagValue");
        List<String> r102 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r103 = LiveEffectContext.a.a(this.f66852e).a();
        List<Sticker> r104 = this.f66849b;
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((CopyOnWriteArrayList) r104).iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        Object r107 = r106.next();
        if (StringUtils.equal(((Sticker) r107).getResourceId(), r210.getResourceId()) == false) goto L4;
        r105.add(r107);
        goto L4
    L8:
        Iterator r108 = r105.iterator();
    L10:
        if (r108.hasNext() == false) goto L20;
        Sticker r110 = (Sticker) r108.next();
        Sticker.ComposerConfig r111 = r110.getSmallItemConfig();
        if (r111 == null) goto L10;
        if (r103.G(r110.getEffectId(), r111.getTag()) != null) goto L10;
        ILiveEffectComposerManager.f.a(r103, "live_adjustment", r110, "LiveSmallItemBeautyHelper_updateLocalTagValue", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), null, 48);
        Float r109 = r103.G(r110.getEffectId(), r111.getTag());
        if (r109 == null) goto L18;
        float r112 = r109.floatValue();
    L19:
        String r113 = r111.getTag();
        ILiveEffectComposerManager.f.d(r103, "live_adjustment", r110, r113, r112, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 16);
        goto L10
    L18:
        r112 = com.bytedance.android.live.effect.q.d(r110, r111.getDefaultValue());
        goto L19
    L20:
        boolean r114 = y50.c.f566205a;
        y50.c.h("av_adjust_updateLocalTagValue", r101);
    }

    public static void b(l r100, LiveColorAdjustFragment.b r110) {
        r100.getClass();
        ALogger.i("ttlive_anchor_effect_LiveColorAdjustHelper", "loadAvAdjustData");
        LiveColorAdjustHelper$loadAvAdjustData$listener$1 r101 = new LiveColorAdjustHelper$loadAvAdjustData$listener$1(r100, r110);
        List<String> r111 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r100.f66852e).b().d().a("live_adjustment", r101, true, true, false, true);
    }

    public static void c(l r100, Sticker r101, boolean r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "sticker");
        LiveColorAdjustHelper$tryDownloadSticker$1 r103 = new LiveColorAdjustHelper$tryDownloadSticker$1(Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())));
        List<String> r104 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(r100.f66852e).b().r().q(r101) == false) goto L10;
        if (r102 == false) goto L6;
        AndroidSchedulers.mainThread().scheduleDirect(new p(r100, r101));
    L6:
        AndroidSchedulers.mainThread().scheduleDirect(new q(null, r101));
        Iterator r105 = ((CopyOnWriteArrayList) r100.f66850c).iterator();
    L8:
        if (r105.hasNext() == false) goto L13;
        b r106 = (b) r105.next();
        AndroidSchedulers.mainThread().scheduleDirect(new o(r106, r101));
        goto L8
    L13:
        return;
    L10:
        LiveEffectContext.a.a(r100.f66852e).b().r().g("live_adjustment", r101, new r(r100, r103, null, r102));
    }

    public static Sticker a(l r100, List r101, Effect r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "stickerList");
        Intrinsics.checkNotNullParameter(r102, "effect");
        Sticker r105 = com.bytedance.android.live.effect.sticker.d.b(r102);
        r105.setParentResId(r104);
        JsonObject r106 = new JsonParser().parse(r102.getExtra()).getAsJsonObject();     // Catch: Throwable -> L14
        JsonElement r107 = r106.get("video_tag");     // Catch: Throwable -> L14
        if (r107 == null) goto L7;
        String r108 = r107.getAsString();     // Catch: Throwable -> L14
        if (r108 == null) goto L7;
    L8:
        String r109 = r106.get("adjustment").getAsString();     // Catch: Throwable -> L14
        JsonArray r110 = new JsonParser().parse(r109).getAsJsonObject().getAsJsonArray("items");     // Catch: Throwable -> L14
        Type r111 = new m().getType();     // Catch: Throwable -> L14
        List<Sticker.ComposerConfig> r112 = (List) GsonHelper.get().fromJson(r110, r111);     // Catch: Throwable -> L14
        r105.setComposerConfigList(r112);     // Catch: Throwable -> L14
        r105.setVideoTag(r108);     // Catch: Throwable -> L14
        Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L14
    L10:
        if (r113.hasNext() == false) goto L12;
        Sticker.ComposerConfig r114 = (Sticker.ComposerConfig) r113.next();     // Catch: Throwable -> L14
        r105.getUpdateKeys().add(r114.getTag());     // Catch: Throwable -> L14
        goto L10
    L12:
        ((CopyOnWriteArrayList) r101).add(r105);     // Catch: Throwable -> L14
        c(r100, r105, r103);     // Catch: Throwable -> L14
    L16:
        return r105;
    L7:
        r108 = "";
    L14:
        th = move-exception;
        ALogger.e("ttlive_anchor_effect_LiveColorAdjustHelper", th);
        goto L16
    }
}
