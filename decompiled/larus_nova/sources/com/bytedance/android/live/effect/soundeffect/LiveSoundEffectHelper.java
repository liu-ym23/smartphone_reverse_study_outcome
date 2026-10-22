package com.bytedance.android.live.effect.soundeffect;

import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.config.fv;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveSoundEffectHelper implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f68110h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Sticker> f68111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f68112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Sticker f68114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SoundRepelContext f68115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakHandler f68116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68117g;

    public static final class a {
    }

    public interface b {
        void a(Sticker r100);

        void onError();

        void x1(int r100, LiveSoundAdapter.ViewHolder r101);
    }

    public interface c {
        void onError();

        void onSuccess(List<Sticker> r100);
    }

    static {
    }

    public final void d() {
        if (this.f68113c >= 0) goto L6;
        this.f68113c = 0;
    L6:
        if (this.f68113c != 0) goto L21;
        Sticker r100 = this.f68114d;
        if (r100 == null) goto L16;
        SoundRepelContext r101 = this.f68115e;
        if (r101 == null) goto L14;
        m<SoundRepelContext.SoundEffectState> r102 = r101.getSoundEffectState();
        if (r102 == null) goto L14;
        r102.setValue(SoundRepelContext.SoundEffectState.USING);
    L14:
        WeakHandler r103 = this.f68116f;
        Map<String, Long> r104 = h.f68136a;
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r103, "mHandler");
        h.f68137b.put(r100.getEffectId(), Long.valueOf(System.currentTimeMillis()));
        Message r105 = new Message();
        r105.obj = r100;
        r105.what = 0;
        r103.sendMessageDelayed(r105, fv.f120233a.getValue().longValue() * 1000);
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "add Sound Sticker, id = " + r100.getId() + ",path = " + r100.getUnzipPath());
        return;
    L16:
        SoundRepelContext r106 = this.f68115e;
        if (r106 == null) goto L28;
        m<SoundRepelContext.SoundEffectState> r107 = r106.getSoundEffectState();
        if (r107 == null) goto L29;
        r107.setValue(SoundRepelContext.SoundEffectState.ENABLE);
        return;
    L29:
        return;
    L28:
        return;
    L21:
        SoundRepelContext.SoundEffectState r108 = SoundRepelContext.SoundEffectState.DISABLE_CAUSE_SOUNDSTICKER;
        SoundRepelContext r109 = this.f68115e;
        if (r109 == null) goto L26;
        m<SoundRepelContext.SoundEffectState> r110 = r109.getSoundEffectState();
        if (r110 == null) goto L26;
        r110.setValue(r108);
    L26:
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "remove All Sound Sticker ,audio Resources now null");
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f68117g;
    }

    public LiveSoundEffectHelper(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f68117g = r100;
        new AtomicBoolean(true);
        this.f68111a = new ArrayList();
        this.f68112b = new ArrayList();
        this.f68116f = new WeakHandler(this);
        DataContext r101 = com.bytedance.live.datacontext.d.d(SoundRepelContext.TAG);
        if ((r101 instanceof SoundRepelContext) == true) goto L5;
        r101 = null;
    L5:
        SoundRepelContext r102 = (SoundRepelContext) r101;
        this.f68115e = r102;
        if (r102 == null) goto L13;
        m<Boolean> r103 = r102.getEffectGameState();
        if (r103 == null) goto L14;
        Observable<Boolean> r104 = r103.a();
        if (r104 == null) goto L15;
        RxUtilKt.n(r104, new AnonymousClass1(this));
        return;
    L15:
        return;
    L14:
        return;
    }

    public static boolean a(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        return JSONObjectProtectorUtils.getBoolean(new JSONObject(r100.getExtra()), "Original");
    L6:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 0) goto L13;
        Object r101 = r100.obj;
        if (r101 == null) goto L10;
        Sticker r102 = (Sticker) r101;
        Map<String, Long> r103 = h.f68136a;
        LiveEffectContextFactoryDelegate$Type r104 = this.f68117g;
        Intrinsics.checkNotNullParameter(r102, "sticker");
        Intrinsics.checkNotNullParameter(r104, "type");
        h.c(r102, "livesdk_live_take_voice_effective_use", r104);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.Sticker");
    }

    public final void b(Sticker r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "sticker");
        if (r111 == false) goto L20;
        if (r112 == false) goto L7;
        m90.b.f512567y.e(this.f68117g, Long.valueOf(r110.getId()));
    L7:
        if (a(r110) == false) goto L15;
        SoundRepelContext.SoundEffectState r113 = SoundRepelContext.SoundEffectState.ENABLE;
        SoundRepelContext r114 = this.f68115e;
        if (r114 == null) goto L13;
        m<SoundRepelContext.SoundEffectState> r115 = r114.getSoundEffectState();
        if (r115 == null) goto L13;
        r115.setValue(r113);
    L13:
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "remove All Sound Sticker ,audio Resources now null");
        this.f68114d = null;
        return;
    L15:
        this.f68114d = r110;
        if (r110.isDownloaded() == true) goto L18;
        r110.setDownloaded(true);
    L18:
        d();
        return;
    L20:
        if (a(r110) == true) goto L26;
        WeakHandler r116 = this.f68116f;
        LiveEffectContextFactoryDelegate$Type r117 = this.f68117g;
        Map<String, Long> r100 = h.f68136a;
        Intrinsics.checkNotNullParameter(r110, "sticker");
        Intrinsics.checkNotNullParameter(r116, "mHandler");
        Intrinsics.checkNotNullParameter(r117, "type");
        r116.removeMessages(0);
        long r101 = System.currentTimeMillis();
        Map<String, Long> r118 = h.f68137b;
        Long r102 = (Long) ((LinkedHashMap) r118).get(r110.getEffectId());
        if (r102 == null) goto L24;
        long r103 = r102.longValue();
    L25:
        Map<String, Long> r104 = h.f68136a;
        h.b(r110, "live_voice_use_time", r117, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("use_time", String.valueOf((r101 - r103) / ((long) 1000)))}));
        r118.put(r110.getEffectId(), 0L);
        goto L26
    L24:
        r103 = 0;
    L26:
        SoundRepelContext.SoundEffectState r119 = SoundRepelContext.SoundEffectState.ENABLE;
        SoundRepelContext r120 = this.f68115e;
        if (r120 == null) goto L31;
        m<SoundRepelContext.SoundEffectState> r121 = r120.getSoundEffectState();
        if (r121 == null) goto L31;
        r121.setValue(r119);
    L31:
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "remove All Sound Sticker ,audio Resources now null");
    }

    public static void c(LiveSoundEffectHelper r100, Sticker r101, b r102, LiveSoundAdapter.ViewHolder r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "sticker");
        List<String> r105 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(r100.f68117g).b().r().q(r101) == false) goto L17;
        r101.setDownloaded(true);
        if (r102 == null) goto L13;
        r102.a(r101);
    L13:
        Iterator<b> r106 = r100.f68112b.iterator();
    L15:
        if (r106.hasNext() == false) goto L20;
        r106.next().a(r101);
        goto L15
    L20:
        return;
    L17:
        LiveEffectContext.a.a(r100.f68117g).b().r().g("livesoundeffect", r101, new g(r100, r102, r103));
    }
}
