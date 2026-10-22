package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LiveGiftMenuStickerServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftMenuStickerServiceWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f118521i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f118522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f118523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Sticker> f118524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f118525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f118526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONArray f118527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f118528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f118529h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final zg1.p f118530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f118531b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f118530a, r101.f118530a) == true) goto L8;
            return false;
        L8:
            if (this.f118531b == r101.f118531b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            zg1.p r100 = this.f118530a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f118531b;
            ?? r104 = r103;
            if (r103 == false) goto L10;
            r104 = 1;
        L10:
            return r102 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "ChangeStickerTask(event=" + this.f118530a + ", isRunning=" + this.f118531b + ")";
        }

        public a(zg1.p r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f118530a = r100;
            this.f118531b = false;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGiftMenuStickerServiceWidget f118532a;

        public c(LiveGiftMenuStickerServiceWidget r100) {
            this.f118532a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            LiveGiftMenuStickerServiceWidget r102 = this.f118532a;
            int r103 = LiveGiftMenuStickerServiceWidget.f118521i;
            r102.getClass();
            List<String> r104 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().b("zongyiyouxi", "LiveGiftMenuStickerServiceWidgetclearStickerTimer");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f118526e = 0;
        this.f118529h = false;
        this.f118527f = new JSONArray();
        Disposable r100 = this.f118528g;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f118522a.clear();
        ((ArrayList) this.f118523b).clear();
        ((LinkedHashMap) this.f118524c).clear();
        Disposable r101 = this.f118525d;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public final void zq() {
        a r100 = (a) CollectionsKt.firstOrNull(this.f118523b);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f118531b == false) goto L8;
        return;
    L8:
        r100.f118531b = true;
        zg1.p r101 = r100.f118530a;
        if (r101.f571905c == false) goto L17;
        Map<String, Sticker> r102 = this.f118524c;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        Sticker r104 = (Sticker) r103.get(r101.f571904b);
        if (r104 == null) goto L16;
        xq(r104);
        PthreadHandlerThreadV2 r105 = LiveEffectMonitor.f68860a;
        LiveEffectMonitor.i(true, r100.f118530a.f571904b, true, "");
        zg1.q r106 = r100.f118530a.f571906d;
        if (r106 == null) goto L15;
        zg1.q.a.a(r106, true);
    L15:
        yq(r100);
        return;
    L16:
        List<String> r107 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffect(r100.f118530a.f571904b, new n0(this, r100));
        return;
    L17:
        List<String> r108 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().b("zongyiyouxi", "LiveGiftMenuStickerServiceWidgetdoConsumeEvent");
        PthreadHandlerThreadV2 r109 = LiveEffectMonitor.f68860a;
        LiveEffectMonitor.i(false, "", true, "");
        yq(r100);
    }

    public LiveGiftMenuStickerServiceWidget() {
        this.f118522a = new CompositeDisposable();
        this.f118523b = new ArrayList();
        this.f118524c = new LinkedHashMap();
        this.f118527f = new JSONArray();
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.getGiftMessageChannelStatus();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        boolean r103 = r102.booleanValue();
    L10:
        this.f118529h = r103;
        return;
    L9:
        r103 = false;
        goto L10
    }

    public static final void wq(LiveGiftMenuStickerServiceWidget r100) {
        r100.getClass();
        r100.f118526e = System.currentTimeMillis();
        IBrowserService r101 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r101 == null) goto L5;
        JSONObject r102 = new JSONObject();
        r102.put("data", new JSONArray(r100.f118527f.toString()));
        r101.sendEventToAllJsBridges("live.notifyGiftMessage", r102);
    L5:
        r100.f118527f = new JSONArray();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.getGiftMessageChannelStatus();
        if (r102 == null) goto L11;
        Observable<Boolean> r103 = r102.a();
        if (r103 == null) goto L11;
        Disposable r104 = r103.subscribe(new r0(this));
        if (r104 == null) goto L11;
        RxUtilKt.c(r104, this.f118522a);
    L11:
        IGiftServiceExternal r105 = (IGiftServiceExternal) jc1.k.f(IGiftServiceExternal.class);
        if (r105 == null) goto L18;
        Observable<JSONObject> r106 = r105.observeGiftMsgContent();
        if (r106 == null) goto L18;
        Disposable r107 = r106.subscribe(new q0(this));
        if (r107 == null) goto L18;
        RxUtilKt.c(r107, this.f118522a);
    L18:
        RxUtilKt.c(xs2.b.a().b(zg1.p.class).subscribe(new o0(this)), this.f118522a);
    }

    public final void xq(Sticker r100) {
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContextFactoryDelegate$Type r102 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        LiveEffectContext.a.a(r102).a().b("zongyiyouxi", "LiveGiftMenuStickerServiceWidget");
        LiveEffectContext.a.a(r102).a().a("zongyiyouxi", r100, "LiveGiftMenuStickerServiceWidget");
        Disposable r103 = this.f118525d;
        if (r103 == null) goto L5;
        r103.dispose();
    L5:
        this.f118525d = Observable.timer(LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_STICKER_MAX_DURATION.getValue().longValue(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
    }

    public final void yq(a r100) {
        ((ArrayList) this.f118523b).remove(r100);
        zq();
    }
}
