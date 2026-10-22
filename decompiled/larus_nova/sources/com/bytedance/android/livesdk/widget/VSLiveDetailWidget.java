package com.bytedance.android.livesdk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.media.impl.ParentTouchScrollView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/widget/VSLiveDetailWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/room/a0$b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLiveDetailWidget extends LiveWidget implements com.bytedance.android.live.room.a0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetectorCompat f161378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f161379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f161380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f161381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ParentTouchScrollView f161382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f161383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f161384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f161385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f161386i;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f161387a;

        public a(Function0<Unit> r100) {
            this.f161387a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            Function0<Unit> r101 = this.f161387a;
            if (r101 == null) goto L7;
            r101.invoke();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            Function0<Unit> r104 = this.f161387a;
            if (r104 == null) goto L7;
            r104.invoke();
            return true;
        L7:
            return true;
        }
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSLiveDetailWidget f161388a;

        public b(VSLiveDetailWidget r100) {
            this.f161388a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101 != null) goto L4;
        L6:
            this.f161388a.f161378a.onTouchEvent(r101);
            return true;
        L4:
            if (r101.getAction() != 0) goto L6;
            xs2.b.a().post(new zg1.d0());
            goto L6
        }
    }

    @Override // com.bytedance.android.live.room.a0.b
    public final void C4() {
        View r100 = this.contentView;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.room.a0.b
    public final boolean isShowing() {
        View r100 = this.contentView;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.room.a0.b
    public final void y2() {
        this.contentView.setVisibility(0);
        ParentTouchScrollView r100 = this.f161382e;
        if (r100 == null) goto L5;
        r100.scrollTo(0, 0);
    L5:
        com.bytedance.android.livesdk.log.u.l().d("livesdk_live_intro_title_click", new Object[]{Room.class, am2.x.class});
        com.bytedance.android.livesdk.log.u.l().d("livesdk_live_intro_panel_show", new Object[]{Room.class, am2.x.class});
    }

    public VSLiveDetailWidget() {
        this.f161378a = new GestureDetectorCompat(this.context, new a(VSLiveDetailWidget$gesture$1.INSTANCE));
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
        return R.layout.ttlive_vs_live_detail_layout_pad;
    L5:
        return R.layout.ttlive_vs_live_detail_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.live.room.a0.b r100 = com.bytedance.android.live.room.a0.f98863a;
        Intrinsics.checkNotNullParameter(this, "view");
        com.bytedance.android.live.room.a0.f98863a = this;
        int r101 = 8;
        this.contentView.setVisibility(8);
        this.contentView.setOnTouchListener(new b(this));
        this.f161379b = (ViewGroup) this.contentView.findViewById(R.id.user_info_container);
        this.f161380c = (ViewGroup) this.contentView.findViewById(R.id.title_container);
        this.f161381d = (ViewGroup) this.contentView.findViewById(R.id.user_list_container);
        ParentTouchScrollView r102 = (ParentTouchScrollView) this.contentView.findViewById(R.id.vs_live_detail_content);
        this.f161382e = r102;
        if (r102 == null) goto L5;
        r102.setTopFading(0.5f);
    L5:
        this.f161385h = this.contentView.findViewById(R.id.ll_content);
        this.f161383f = (TextView) this.contentView.findViewById(R.id.vs_live_detail_title);
        this.f161384g = (TextView) this.contentView.findViewById(R.id.vs_live_detail_introduction);
        this.f161386i = this.contentView.findViewById(R.id.vs_first_live_hint);
        String r103 = null;
        Room r104 = (Room) this.dataCenter.get("data_room", null);
        if (r104 == null) goto L10;
        String r105 = r104.getIntroduction();
        if (r105 == null) goto L10;
        r103 = StringsKt.replace$default(r105, "\n", "\n\n", false, 4, null);
    L10:
        TextView r106 = this.f161384g;
        if (r106 == null) goto L13;
        r106.setText(r103);
    L13:
        TextView r107 = this.f161384g;
        if (r107 == null) goto L16;
        r107.post(new t2(this));
    L16:
        View r108 = this.f161386i;
        if (r108 == null) goto L25;
        RoomContext r109 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r109 != null) goto L21;
    L23:
        r108.setVisibility(r101);
        return;
    L21:
        if (r109.isVSFirstShow() != true) goto L23;
        r101 = 0;
        goto L23
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.room.a0.b r100 = com.bytedance.android.live.room.a0.f98863a;
        com.bytedance.android.live.room.a0.f98863a = null;
        com.bytedance.android.live.room.a0.f98864b.clear();
        com.bytedance.android.live.room.a0.f98865c = null;
        com.bytedance.android.live.room.a0.f98866d = null;
        com.bytedance.android.live.room.a0.f98867e = null;
        com.bytedance.android.live.room.a0.f98868f = null;
        com.bytedance.android.live.room.a0.f98869g = null;
        com.bytedance.android.live.room.a0.f98870h = null;
        com.bytedance.android.live.room.a0.f98871i = null;
        com.bytedance.android.live.room.a0.f98872j = null;
        com.bytedance.android.live.room.a0.f98873k = null;
        com.bytedance.android.live.room.a0.f98874l = null;
        com.bytedance.android.live.room.a0.f98875m = null;
        com.bytedance.android.live.room.a0.f98876n = null;
    }

    @Override // com.bytedance.android.live.room.a0.b
    public final ViewGroup B2() {
        return this.f161381d;
    }

    @Override // com.bytedance.android.live.room.a0.b
    public final ViewGroup J4() {
        return this.f161380c;
    }

    @Override // com.bytedance.android.live.room.a0.b
    public final TextView Jp() {
        return this.f161383f;
    }

    @Override // com.bytedance.android.live.room.a0.b
    public final ViewGroup r3() {
        return this.f161379b;
    }
}
