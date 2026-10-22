package com.bytedance.android.livesdk.widget;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.utils.t5;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/widget/CountdownTaskWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountdownTaskWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f160797j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f160798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f160799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f160800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f160801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f160802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f160803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f160804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f160805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f160806i;

    public static final class a {
    }

    static {
    }

    public final void clear() {
        this.f160798a = false;
        this.f160806i = false;
        this.f160799b = null;
        this.f160801d = null;
        this.f160802e = null;
        this.f160803f = null;
        this.f160804g = null;
        RoomContext r100 = getRoomContext();
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.m<Long> r101 = r100.getCountdownDuration();
        if (r101 == null) goto L9;
        r101.setValue(-1L);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final void xq() {
        if (this.f160798a == true) goto L5;
        return;
    L5:
        if (this.f160805h == true) goto L7;
        return;
    L7:
        if (this.f160806i == true) goto L37;
        boolean r100 = false;
        if (pm1.f.d(this.dataCenter) == null) goto L12;
        boolean r101 = true;
    L13:
        Boolean r102 = null;
        if (r101 == false) goto L22;
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L29;
        IVideoEventHub r104 = (IVideoEventHub) r103.get("zygote_event_hub", null);
        if (r104 == null) goto L29;
        MutableLiveData<Boolean> r105 = r104.getFirstFrame();
        if (r105 == null) goto L29;
        r102 = r105.getValue();
    L29:
        if (r102 == null) goto L31;
        r100 = r102.booleanValue();
    L31:
        if (r100 == false) goto L36;
        this.f160806i = true;
        long r106 = wq();
        ALogger.i("CountdownTaskWidget", "start countdown. duration=" + r106);
        this.f160804g = RxUtilKt.d(r106 * 1000, 1000).subscribe(new f(new CountdownTaskWidget$startCountDown$1(this)), new f(new CountdownTaskWidget$startCountDown$2(this)), new e(new CountdownTaskWidget$startCountDown$3(this)));
        return;
    L36:
        return;
    L22:
        ILivePlayerClient r107 = LivePlatformPlayerManager.f();
        if (r107 == null) goto L29;
        IRoomEventHub r108 = r107.getEventHub();
        if (r108 == null) goto L29;
        MutableLiveData<Boolean> r109 = r108.getFirstFrame();
        if (r109 == null) goto L29;
        r102 = r109.getValue();
        goto L29
    L12:
        r101 = false;
        goto L13
    }

    public CountdownTaskWidget() {
        this.f160800c = -1;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onStart() {
        super.onStart();
        this.f160805h = true;
        xq();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onStop() {
        super.onStop();
        this.f160805h = false;
        Disposable r100 = this.f160804g;
        if (r100 == null) goto L5;
        this.f160804g = null;
        r100.dispose();
    L5:
        this.f160806i = false;
        if (this.f160798a == false) goto L9;
        ALogger.i("CountdownTaskWidget", "stop countdown. duration=" + wq());
        return;
    }

    public final long wq() {
        RoomContext r100 = getRoomContext();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.m<Long> r101 = r100.getCountdownDuration();
        if (r101 == null) goto L7;
        Long r102 = r101.getValue();
    L8:
        if (r102 == null) goto L13;
        if (r102.longValue() <= 0) goto L13;
        return r102.longValue();
    L13:
        return this.f160800c;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        clear();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        DataCenter r100 = this.dataCenter;
        MutableLiveData<Boolean> r101 = null;
        if (r100 == null) goto L7;
        HashMap r102 = t5.a(r100);
        if (r102 == null) goto L8;
        String r103 = (String) r102.get("countdown_task");
    L9:
        boolean r104 = true;
        if (r103 == null) goto L37;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r106 = new JSONObject(r103);     // Catch: Throwable -> L14
        ALogger.i("CountdownTaskWidget", "params=" + r106);     // Catch: Throwable -> L14
        this.f160799b = r106.optString("token");     // Catch: Throwable -> L14
        this.f160800c = r106.optLong("duration", -1);     // Catch: Throwable -> L14
        this.f160801d = r106.optString("success_msg");     // Catch: Throwable -> L14
        this.f160802e = r106.optString("extra");     // Catch: Throwable -> L14
        this.f160803f = r106.optJSONObject("params");     // Catch: Throwable -> L14
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L17:
        if (Result.m9456isSuccessimpl(r111) == false) goto L33;
        Unit r107 = (Unit) r111;
        if (this.f160800c <= 0) goto L29;
        String r108 = this.f160799b;
        if (r108 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == true) goto L29;
        boolean r112 = true;
    L30:
        this.f160798a = r112;
        if (r112 == true) goto L33;
        clear();
        goto L33
    L23:
        if (r108.length() == 0) goto L26;
        r109 = false;
    L29:
        r112 = false;
    L33:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r111);
        if (r113 == null) goto L37;
        clear();
        ALogger.e("CountdownTaskWidget", "parse failed. params=".concat(r103), r113);
    L14:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L37:
        if (this.f160798a == true) goto L40;
        return;
    L40:
        if (pm1.f.d(this.dataCenter) == null) goto L42;
        boolean r115 = true;
    L43:
        if (r115 == false) goto L49;
        DataCenter r116 = this.dataCenter;
        if (r116 == null) goto L54;
        IVideoEventHub r117 = (IVideoEventHub) r116.get("zygote_event_hub", null);
        if (r117 == null) goto L54;
        r101 = r117.getFirstFrame();
    L54:
        if (r101 == null) goto L57;
        r101.observe(this, new g(this));
        return;
    L57:
        if (pm1.f.d(this.dataCenter) != null) goto L60;
        r104 = false;
    L60:
        if (r104 == false) goto L62;
        String r118 = "replay";
    L63:
        ALogger.e("CountdownTaskWidget", "firstFrame is null in " + r118 + " room. cannot start countdown");
        return;
    L62:
        r118 = "normal";
        goto L63
    L49:
        ILivePlayerClient r119 = LivePlatformPlayerManager.f();
        if (r119 == null) goto L54;
        IRoomEventHub r120 = r119.getEventHub();
        if (r120 == null) goto L54;
        r101 = r120.getFirstFrame();
        goto L54
    L42:
        r115 = false;
    L8:
        r103 = null;
        goto L9
    L7:
        WeakHashMap<Context, Long> r121 = t5.f159172a;
        goto L8
    }
}
