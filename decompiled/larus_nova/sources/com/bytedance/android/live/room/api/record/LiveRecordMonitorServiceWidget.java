package com.bytedance.android.live.room.api.record;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.experience.record.FromType;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/record/LiveRecordMonitorServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecordMonitorServiceWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f99082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public dv1.a f99083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f99084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f99085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject<String> f99086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f99087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f99088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f99089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f99090i;

    public static final class a implements dv1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRecordMonitorServiceWidget f99091a;

        public a(LiveRecordMonitorServiceWidget r100) {
            this.f99091a = r100;
        }

        @Override // dv1.c
        public final void a(FromType r100) {
            Intrinsics.checkNotNullParameter(r100, "from");
            LiveRecordMonitorContext r101 = this.f99091a.wq();
            if (r101 == null) goto L5;
            r101.markRecordStared(true);
        L5:
            LiveRecordMonitorServiceWidget r102 = this.f99091a;
            r102.f99088g = p6.b();
            LiveRecordMonitorContext r103 = this.f99091a.wq();
            if (r103 == null) goto L12;
            DataCenter r104 = this.f99091a.dataCenter;
            if (r104 == null) goto L10;
            Boolean r105 = (Boolean) r104.get("cmd_playfragment_visible", Boolean.TRUE);
        L11:
            r103.ignoreThisRecord(true ^ Intrinsics.areEqual(r105, Boolean.TRUE));
            goto L12
        L10:
            r105 = null;
        L12:
            ALogger.i(this.f99091a.f99082a, "screen record monitor, onScreenRecordStarted");
            LiveScreenRecordGuideConfig.f99094c.getClass();
            if (LiveScreenRecordGuideConfig.a.b().a() == false) goto L16;
            UtilityKotlinExtentionsKt.s(0, false, false, LiveRecordMonitorServiceWidget$callback$1$onScreenRecordStarted$1.INSTANCE, 7);
            return;
        }

        @Override // dv1.c
        public final void b(FromType r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "from");
            LiveScreenRecordGuideConfig.f99094c.getClass();
            if (LiveScreenRecordGuideConfig.a.b().a() == false) goto L5;
            UtilityKotlinExtentionsKt.s(0, false, false, LiveRecordMonitorServiceWidget$callback$1$onScreenRecordStopped$1.INSTANCE, 7);
        L5:
            ALogger.i(this.f99091a.f99082a, "screen record monitor stop, the path is " + r101 + ", has startCallback is " + r102);
            if (r101 != null) goto L9;
            return;
        L9:
            if (FileUtils.isFileEmpty(r101) == false) goto L12;
            ALogger.i(this.f99091a.f99082a, "screen record monitor stop, video file is empty");
            return;
        L12:
            LiveRecordMonitorContext r103 = this.f99091a.wq();
            if (r103 != null) goto L15;
        L17:
            boolean r104 = false;
        L19:
            if (LiveScreenRecordGuideConfig.a.b().f() == false) goto L23;
            if (r104 == true) goto L23;
            ALogger.i(this.f99091a.f99082a, "screen record monitor stop, not recieve start event");
            return;
        L23:
            LiveRecordMonitorContext r105 = this.f99091a.wq();
            if (r105 != null) goto L26;
        L29:
            this.f99091a.f99089h = p6.b();
            this.f99091a.f99086e.onNext(r101);
            return;
        L26:
            if (r105.isIgnoreThisRecord() != true) goto L29;
            ALogger.i(this.f99091a.f99082a, "screen record monitor stop, ignore this record");
            return;
        L15:
            if (r103.isRecordStared() != true) goto L17;
            r104 = true;
            goto L19
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        dv1.a r100 = this.f99083b;
        if (r100 != null) goto L24;
    L22:
        this.f99087f.clear();
        return;
    L24:
        Handler r101 = r100.f470138c;     // Catch: Exception -> L20
        if (r101 == null) goto L8;
        r101.removeCallbacksAndMessages(null);     // Catch: Exception -> L20
    L8:
        PthreadHandlerThreadV2 r102 = r100.f470137b;     // Catch: Exception -> L20
        if (r102 == null) goto L11;
        r102.quit();     // Catch: Exception -> L20
    L11:
        dv1.b r103 = r100.f470136a;     // Catch: Exception -> L20
        if (r103 == null) goto L18;
        Context r104 = r100.f470141f.get();     // Catch: Exception -> L20
        if (r104 == null) goto L18;
        ContentResolver r105 = r104.getContentResolver();     // Catch: Exception -> L20
        if (r105 == null) goto L18;
        r105.unregisterContentObserver(r103);     // Catch: Exception -> L20
    L18:
        ALogger.d("ScreenRecordMonitorService", "ContentObserver unregistered");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ALogger.e("ScreenRecordMonitorService", "Failed to unregister ContentObserver: " + e.getMessage());
        goto L22
    }

    public final LiveRecordMonitorContext wq() {
        MiddlewareRoomContext r100 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.dataCenter, 0, 2);
        ViewModel r101 = null;
        if (r100 == null) goto L5;
        j<ViewModel> r102 = r100.getRecordMonitorViewModel();
    L6:
        if (r102 != null) goto L8;
    L9:
        LiveRecordMonitorContext r103 = new LiveRecordMonitorContext();
        if (r102 == null) goto L12;
        r102.d(r103);
    L12:
        if (r102 == null) goto L14;
        ViewModel r104 = r102.getValue();
    L16:
        if ((r104 instanceof LiveRecordMonitorContext) == false) goto L20;
        r101 = r104;
    L20:
        return (LiveRecordMonitorContext) r101;
    L14:
        r104 = null;
        goto L16
    L8:
        if (r102.getValue() != null) goto L12;
    L5:
        r102 = null;
        goto L6
    }

    public LiveRecordMonitorServiceWidget() {
        this.f99082a = "LiveRecordMonitorServiceWidget";
        this.f99084c = LazyKt.lazy(new LiveRecordMonitorServiceWidget$isPortrait$2(this));
        this.f99085d = LazyKt.lazy(new LiveRecordMonitorServiceWidget$isMiddlewareMediaRoom$2(this));
        this.f99086e = PublishSubject.create();
        this.f99087f = new CompositeDisposable();
        this.f99090i = new a(this);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(KVData r100) {
        KVData r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "kvData");
        String r102 = r101.getKey();
        if (r102.hashCode() == 1046302364) goto L6;
        return;
    L6:
        if (r102.equals("cmd_playfragment_visible") == false) goto L16;
        ALogger.i(this.f99082a, "当前直播间不可见，停止录屏监听");
        if ((!Intrinsics.areEqual((Boolean) r101.getData(), Boolean.FALSE)) == true) goto L17;
        LiveScreenRecordGuideConfig.f99094c.getClass();
        if (LiveScreenRecordGuideConfig.a.b().a() == false) goto L12;
        f2.c("当前直播间不可见，停止录屏监听", 0);
    L12:
        LiveRecordMonitorContext r103 = wq();
        if (r103 == null) goto L18;
        r103.ignoreThisRecord(true);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        if (((Boolean) this.f99084c.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (((Boolean) this.f99085d.getValue()).booleanValue() == true) goto L22;
        wq();
        h r101 = q.g();
        if (r101 == null) goto L12;
        j<Boolean> r102 = r101.getHighlightEnable();
        if (r102 == null) goto L12;
        Boolean r103 = r102.getValue();
    L13:
        final boolean r104 = Intrinsics.areEqual(r103, Boolean.TRUE);
        h r105 = q.g();
        if (r105 == null) goto L20;
        j<Boolean> r106 = r105.getHighlightEnable();
        if (r106 == null) goto L21;
        r106.c(new AnonymousClass1(this, r104));
        return;
    L21:
        return;
    L20:
        return;
    L12:
        r103 = null;
        goto L13
    }
}
