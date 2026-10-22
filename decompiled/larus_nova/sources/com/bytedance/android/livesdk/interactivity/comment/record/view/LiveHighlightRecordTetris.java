package com.bytedance.android.livesdk.interactivity.comment.record.view;

import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragContainer;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragParentView;
import com.bytedance.android.livesdk.interactivity.comment.record.event.HighlightRecordEvent;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.RecordGuideContext;
import com.bytedance.android.livesdk.interactivity.comment.record.viewmodel.HighlightRecordContext;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import t70.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/view/LiveHighlightRecordTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "StopType", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHighlightRecordTetris extends LiveTetris<d90.d> implements WeakHandler.IHandler, Observer<KVData> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f136200o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CompositeDisposable f136201p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RecordDragParentView f136202q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LiveHighlightRecordController f136203r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f136204s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f136205t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f136206u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f136207v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WeakHandler f136208w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.record.guide.b f136209x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/view/LiveHighlightRecordTetris$StopType;", "", "OverTime", "UserClick", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StopType extends Enum<StopType> {
        public static final StopType OverTime = null;
        public static final StopType UserClick = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StopType[] f136210a = null;

        static {
            StopType r100 = new StopType("OverTime", 0);
            OverTime = r100;
            StopType r101 = new StopType("UserClick", 1);
            UserClick = r101;
            f136210a = new StopType[]{r100, r101};
        }

        public static StopType valueOf(String r100) {
            return (StopType) r27.a.a(StopType.class, r100);
        }

        public static StopType[] values() {
            return (StopType[]) f136210a.clone();
        }

        public StopType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HighlightRecordContext V() {
        HighlightRecordContext.b r100 = HighlightRecordContext.Companion;
        MiddlewareRoomContext r101 = ((d90.d) K()).f467477e;
        DataCenter r102 = ((d90.d) K()).f467480h;
        r100.getClass();
        return HighlightRecordContext.b.a(r101, r102);
    }

    public final void W() {
        LiveHighlightRecordController r100 = this.f136203r;
        if (r100 == null) goto L8;
        r100.a();
        RecordDragParentView r101 = r100.f136198l;
        View r102 = r101.f115395a;
        if (r102 == null) goto L7;
        r101.removeView(r102);
    L7:
        r101.f115395a = null;
        UtilityKotlinExtentionsKt.t(r100.f136198l);
        r100.f136188b = 0;
    L8:
        this.f136204s = 0;
        WeakHandler r103 = this.f136208w;
        if (r103 == null) goto L11;
        r103.removeMessages(this.f136207v);
    L11:
        WeakHandler r104 = this.f136208w;
        if (r104 == null) goto L15;
        r104.removeMessages(this.f136206u);
        return;
    }

    public final void Z() {
        if (this.f136204s >= this.f136205t) goto L6;
        f2.c("最少录制" + this.f136205t + 31186, 0);
        return;
    L6:
        W();
        HighlightRecordContext r100 = V();
        if (r100 == null) goto L10;
        r100.reqRecord(false);
        return;
    }

    public LiveHighlightRecordTetris() {
        this.f136200o = "LiveHighlightRecordTetris";
        this.f136201p = new CompositeDisposable();
        LiveScreenRecordGuideConfig.f99094c.getClass();
        this.f136205t = LiveScreenRecordGuideConfig.a.b().e();
        this.f136206u = 1;
        this.f136207v = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onCreate() {
        super.onCreate();
        DataCenter r100 = ((d90.d) K()).f467480h;
        if (r100 == null) goto L5;
        r100.observe("cmd_playfragment_visible", this);
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(xs2.b.a().b(HighlightRecordEvent.class)).subscribe(new e(this)), this.f136201p);
        HighlightRecordContext r101 = V();
        if (r101 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(r101.getRecordReqStart()).subscribe(new a(this)), this.f136201p);
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(r101.getRecordReqStop()).subscribe(new b(this)), this.f136201p);
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(r101.getClickRecordStopBtn()).subscribe(new c(this)), this.f136201p);
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(r101.getCancelRecord()).subscribe(new d(this)), this.f136201p);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        WeakHandler r100 = this.f136208w;
        if (r100 == null) goto L5;
        r100.removeMessages(this.f136207v);
    L5:
        WeakHandler r101 = this.f136208w;
        if (r101 == null) goto L8;
        r101.removeMessages(this.f136206u);
    L8:
        this.f136201p.clear();
        HighlightRecordContext r102 = V();
        if (r102 == null) goto L11;
        r102.release();
    L11:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.b r103 = this.f136209x;
        if (r103 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.d r104 = r103.f136127a;
        if (r104 == null) goto L18;
        RecordGuideContext r105 = r104.B();
        if (r105 == null) goto L18;
        r105.release();
    L18:
        this.f136209x = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_view_tetris_highlight_record);
        MiddlewareRoomContext r102 = ((d90.d) K()).f467477e;
        if (r102 == null) goto L7;
        j<ViewModel> r103 = r102.getHighlightRecordContext();
        if (r103 == null) goto L7;
        r103.e(new LiveHighlightRecordTetris$initView$1(this));
    L7:
        this.f136202q = (RecordDragParentView) r101.findViewById(R.id.drag_parent_view);
        View r104 = LayoutInflater.from(((d90.d) K()).getContext()).inflate(R.layout.ttlive_view_highlight_record_timer, this.f136202q, false);
        if ((r104 instanceof RecordDragContainer) == true) goto L10;
        r104 = null;
    L10:
        RecordDragContainer r105 = (RecordDragContainer) r104;
        RecordDragParentView r106 = this.f136202q;
        if (r106 == null) goto L14;
        if (r105 == null) goto L14;
        this.f136203r = new LiveHighlightRecordController(V(), r106, r105);
    L14:
        this.f136208w = new WeakHandler(this);
        return r101;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r110) {
        String r100 = null;
        if (r110 == null) goto L5;
        Integer r101 = Integer.valueOf(r110.what);
    L6:
        int r102 = this.f136206u;
        if (r101 != null) goto L10;
    L19:
        int r103 = this.f136207v;
        if (r101 != null) goto L23;
        return;
    L23:
        if (r101.intValue() != r103) goto L58;
        long r104 = SystemClock.uptimeMillis();
        Object r105 = r110.obj;
        if (r105 == null) goto L56;
        long r106 = r104 - ((Long) r105).longValue();
        Object r111 = r110.obj;
        if (r111 == null) goto L54;
        long r107 = ((Long) r111).longValue();
        long r108 = r106 / ((long) 1000);
        int r112 = (int) r108;
        this.f136204s = r112;
        long r109 = r112;
        HighlightRecordContext r113 = V();
        if (r113 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r114 = r113.getRecordResponse();
        if (r114 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.comment.highlight.c r115 = r114.b();
        if (r115 == null) goto L37;
        Long r116 = r115.a();
        if (r116 == null) goto L37;
        long r117 = r116.longValue();
    L39:
        if (r109 < r117) goto L43;
        WeakHandler r118 = this.f136208w;
        if (r118 == null) goto L43;
        r118.sendEmptyMessage(this.f136206u);
    L43:
        long r119 = 60;
        long r120 = r108 / r119;
        long r121 = r108 % r119;
        LiveHighlightRecordController r122 = this.f136203r;
        if (r122 == null) goto L46;
        StringBuilder r123 = new StringBuilder();
        StringCompanionObject r124 = StringCompanionObject.INSTANCE;
        r123.append(String.format(Locale.getDefault(), "%02d", Arrays.copyOf(new Object[]{Long.valueOf(r120)}, 1)));
        r123.append(String.format(Locale.getDefault(), ":%02d ", Arrays.copyOf(new Object[]{Long.valueOf(r121)}, 1)));
        String r125 = r123.toString();
        Intrinsics.checkNotNullParameter(r125, "time");
        r122.f136191e.setText(r125);
    L46:
        WeakHandler r126 = this.f136208w;
        if (r126 == null) goto L59;
        Message r127 = r126.obtainMessage(this.f136207v, Long.valueOf(r107));
        if (r127 == null) goto L60;
        WeakHandler r128 = this.f136208w;
        if (r128 == null) goto L61;
        r128.sendMessageDelayed(r127, 300);
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L37:
        r117 = 180;
        goto L39
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L56:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L58:
        return;
    L10:
        if (r101.intValue() != r102) goto L19;
        StopType r129 = StopType.OverTime;
        Z();
        HighlightRecordContext r130 = V();
        if (r130 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r131 = r130.getRecordResponse();
        if (r131 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.comment.highlight.c r132 = r131.b();
        if (r132 == null) goto L18;
        r100 = r132.b();
    L18:
        f2.c(r100, 0);
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(KVData r100) {
        KVData r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "kvData");
        String r102 = r101.getKey();
        if (r102.hashCode() == 1046302364) goto L6;
        return;
    L6:
        if (r102.equals("cmd_playfragment_visible") == true) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual((Boolean) r101.getData(), Boolean.FALSE)) == true) goto L14;
        ALogger.i(this.f136200o, "当前直播间不可见，停止录屏");
        HighlightRecordContext r103 = V();
        if (r103 == null) goto L15;
        r103.tryCancelRecord();
        return;
    L15:
        return;
    }
}
