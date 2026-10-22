package com.bytedance.android.live.draggablecomponent;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.InfoBoxBackGround;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveAnchorTeleprompterView extends FrameLayout implements c61.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c61.h f66630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveAnchorTeleprompterView f66631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f66632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f66633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f66634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NestedScrollView f66635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f66636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f66637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HSImageView f66638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HSImageView f66639j;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveAnchorTeleprompterView f66644a;

        public a(LiveAnchorTeleprompterView r100) {
            this.f66644a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveAnchorTeleprompterView.c(this.f66644a, true);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveAnchorTeleprompterView f66645a;

        public b(LiveAnchorTeleprompterView r100) {
            this.f66645a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveAnchorTeleprompterView.c(this.f66645a, false);
        }
    }

    public static final class c {
    }

    static {
    }

    private final LiveAnchorTeleprompterVm getTeleprompterVm() {
        return (LiveAnchorTeleprompterVm) this.f66637h.getValue();
    }

    @Override // c61.f
    public final void b() {
    }

    @Override // c61.f
    public long getIdentity() {
        return 0;
    }

    @Override // c61.f
    public final void onDestroy() {
        Disposable r100 = this.f66636g;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // c61.f
    public c61.h getDraggableConfig() {
        return this.f66630a;
    }

    @Override // c61.f
    public View getMView() {
        return this.f66631b;
    }

    public LiveAnchorTeleprompterView(final Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        Spannable r100 = null;
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        boolean r102 = false;
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r103 = r101.isAnchor();
        if (r103 == null) goto L9;
        if (r103.getValue().booleanValue() != true) goto L9;
        boolean r104 = true;
    L11:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r110, true, r104) == false) goto L13;
        int r105 = s1.w() - UtilityKotlinExtentionsKt.i(52);
        int r106 = UtilityKotlinExtentionsKt.i(128);
    L14:
        this.f66630a = new c61.h(5, r105 - r106, 46);
        this.f66631b = this;
        this.f66637h = LazyKt.lazy(LiveAnchorTeleprompterView$teleprompterVm$2.INSTANCE);
        View r107 = LayoutInflater.from(r110).inflate(R.layout.ttlive_live_anchor_teleprompter_layout, this);
        if ((r107 instanceof ViewGroup) == true) goto L17;
        r107 = null;
    L17:
        ViewGroup r108 = (ViewGroup) r107;
        this.f66632c = r108;
        TextView r109 = (TextView) findViewById(R.id.live_anchor_teleprompter_fold_title);
        TextView r111 = (TextView) findViewById(R.id.live_anchor_teleprompter_title);
        ConstraintLayout r112 = (ConstraintLayout) findViewById(R.id.live_anchor_teleprompter_fold);
        this.f66633d = r112;
        ConstraintLayout r113 = (ConstraintLayout) findViewById(R.id.live_anchor_teleprompter_unfold);
        this.f66634e = r113;
        ImageView r114 = (ImageView) findViewById(R.id.live_anchor_teleprompter_icon_fold);
        ImageView r115 = (ImageView) findViewById(R.id.live_anchor_teleprompter_icon_unfold);
        this.f66635f = (NestedScrollView) findViewById(R.id.live_anchor_teleprompter_content_container);
        TextView r116 = (TextView) findViewById(R.id.live_anchor_teleprompter_content);
        this.f66638i = (HSImageView) findViewById(R.id.live_anchor_teleprompter_fold_bg);
        this.f66639j = (HSImageView) findViewById(R.id.live_anchor_teleprompter_unfold_bg);
        if (r113 == null) goto L20;
        ViewGroup.LayoutParams r117 = r113.getLayoutParams();
    L22:
        if ((r117 instanceof ConstraintLayout.LayoutParams) == true) goto L24;
        r117 = null;
    L24:
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r117;
        int r119 = s1.y();
        if (r118 == null) goto L27;
        ((ViewGroup.MarginLayoutParams) r118).width = (r119 - ((ViewGroup.MarginLayoutParams) r118).leftMargin) - ((ViewGroup.MarginLayoutParams) r118).rightMargin;
    L27:
        if (r113 == null) goto L29;
        r113.setLayoutParams(r118);
    L29:
        LiveAnchorTeleprompterVm r120 = getTeleprompterVm();
        if (r120 == null) goto L39;
        m<Boolean> r121 = r120.getFoldState();
        if (r121 == null) goto L39;
        if (r121.getValue().booleanValue() != true) goto L39;
        if (r113 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r113);
    L37:
        if (r112 == null) goto L43;
        UtilityKotlinExtentionsKt.w(r112);
    L43:
        LiveAnchorTeleprompterVm r122 = getTeleprompterVm();
        if (r122 == null) goto L49;
        m<Boolean> r123 = r122.getFoldState();
        if (r123 == null) goto L49;
        if (r123.getValue().booleanValue() != true) goto L49;
    L50:
        d(r102);
        if (r114 == null) goto L53;
        r114.setOnClickListener(new a(this));
    L53:
        if (r115 == null) goto L55;
        r115.setOnClickListener(new b(this));
    L55:
        if (r108 == null) goto L57;
        r108.setOnLongClickListener(new AnonymousClass4(this, r110));
    L57:
        if (r111 == null) goto L65;
        LiveAnchorTeleprompterVm r124 = getTeleprompterVm();
        if (r124 == null) goto L63;
        n<Spannable> r125 = r124.getTitle();
        if (r125 == null) goto L63;
        Spannable r126 = r125.getValue();
    L64:
        r111.setText(r126);
    L63:
        r126 = null;
    L65:
        if (r109 == null) goto L73;
        LiveAnchorTeleprompterVm r127 = getTeleprompterVm();
        if (r127 == null) goto L71;
        n<Spannable> r128 = r127.getFoldTitle();
        if (r128 == null) goto L71;
        Spannable r129 = r128.getValue();
    L72:
        r109.setText(r129);
    L71:
        r129 = null;
    L73:
        if (r116 == null) goto L80;
        LiveAnchorTeleprompterVm r130 = getTeleprompterVm();
        if (r130 == null) goto L79;
        n<Spannable> r131 = r130.getContent();
        if (r131 == null) goto L79;
        r100 = r131.getValue();
    L79:
        r116.setText(r100);
    L80:
        LiveAnchorTeleprompterVm r132 = getTeleprompterVm();
        if (r132 == null) goto L87;
        n<InfoBoxBackGround> r133 = r132.getBackground();
        if (r133 == null) goto L87;
        InfoBoxBackGround r134 = r133.getValue();
        if (r134 == null) goto L87;
        e(r134);
    L87:
        if (r111 == null) goto L95;
        LiveAnchorTeleprompterVm r135 = getTeleprompterVm();
        if (r135 == null) goto L95;
        n<Spannable> r136 = r135.getTitle();
        if (r136 == null) goto L95;
        Observable<sh6.b<Spannable>> r137 = r136.a();
        if (r137 == null) goto L95;
        r137.subscribe(new g(r111));
    L95:
        if (r109 == null) goto L103;
        LiveAnchorTeleprompterVm r138 = getTeleprompterVm();
        if (r138 == null) goto L103;
        n<Spannable> r139 = r138.getFoldTitle();
        if (r139 == null) goto L103;
        Observable<sh6.b<Spannable>> r140 = r139.a();
        if (r140 == null) goto L103;
        r140.subscribe(new h(r109));
    L103:
        if (r116 == null) goto L111;
        LiveAnchorTeleprompterVm r141 = getTeleprompterVm();
        if (r141 == null) goto L111;
        n<Spannable> r142 = r141.getContent();
        if (r142 == null) goto L111;
        Observable<sh6.b<Spannable>> r143 = r142.a();
        if (r143 == null) goto L111;
        r143.subscribe(new i(r116));
    L111:
        LiveAnchorTeleprompterVm r144 = getTeleprompterVm();
        if (r144 == null) goto L119;
        n<InfoBoxBackGround> r145 = r144.getBackground();
        if (r145 == null) goto L120;
        Observable<sh6.b<InfoBoxBackGround>> r146 = r145.a();
        if (r146 == null) goto L121;
        r146.subscribe(new j(this));
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L49:
        r102 = true;
    L39:
        if (r112 == null) goto L41;
        UtilityKotlinExtentionsKt.t(r112);
    L41:
        if (r113 == null) goto L43;
        UtilityKotlinExtentionsKt.w(r113);
        goto L43
    L20:
        r117 = null;
        goto L22
    L13:
        r105 = (s1.w() - s1.A()) - UtilityKotlinExtentionsKt.i(52);
        r106 = UtilityKotlinExtentionsKt.i(128);
    L9:
        r104 = false;
        goto L11
    }

    public static void d(boolean r100) {
        DraggableWindowContext.Companion.getClass();
        c61.g r101 = DraggableWindowContext.b.a();
        if (r101 == null) goto L12;
        c61.e r102 = r101.monitor();
        if (r102 == null) goto L13;
        c61.b r103 = new c61.b("livesdk_telepromoter_components_show");
        if (r100 == false) goto L9;
        String r104 = "1";
    L10:
        r103.b("status", r104);
        Unit r105 = Unit.INSTANCE;
        r102.a(r103.a());
        return;
    L9:
        r104 = "0";
        goto L10
    L13:
        return;
    }

    public final void e(InfoBoxBackGround r100) {
        if (r100 == null) goto L16;
        String r101 = r100.backgroundColor;
        if (r101 == null) goto L16;
        if ((!TextUtils.isEmpty(r101)) == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L16;
        ConstraintLayout r102 = this.f66633d;
        if (r102 == null) goto L13;
        r102.setBackgroundColor(ColorProtector.parseColor(r101));
    L13:
        ConstraintLayout r103 = this.f66634e;
        if (r103 == null) goto L16;
        r103.setBackgroundColor(ColorProtector.parseColor(r101));
    L16:
        if (r100 == null) goto L25;
        Long r104 = r100.backgroundAlpha;
        if (r104 == null) goto L25;
        long r105 = r104.longValue();
        ConstraintLayout r106 = this.f66633d;
        if (r106 == null) goto L22;
        r106.setAlpha(r105 / 100.0f);
    L22:
        ConstraintLayout r107 = this.f66634e;
        if (r107 == null) goto L25;
        r107.setAlpha(r105 / 100.0f);
    L25:
        if (r100 == null) goto L30;
        ImageModel r108 = r100.backgroundImage;
        if (r108 == null) goto L31;
        ImageLoader.bindImage(this.f66638i, r108);
        ImageLoader.bindImage(this.f66639j, r108);
        return;
    L31:
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public void setDraggableConfig(c61.h r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f66630a = r100;
    }

    public static final void a(LiveAnchorTeleprompterView r100, String r101) {
        r100.getClass();
        DraggableWindowContext.Companion.getClass();
        c61.g r102 = DraggableWindowContext.b.a();
        if (r102 == null) goto L21;
        c61.e r103 = r102.monitor();
        if (r103 == null) goto L22;
        c61.b r104 = new c61.b("livesdk_draggable_close_dialog_click");
        Object r105 = r100.getTag();
        String r106 = null;
        if ((r105 instanceof c61.c) == true) goto L9;
        r105 = null;
    L9:
        c61.c r107 = (c61.c) r105;
        if (r107 == null) goto L12;
        Long r108 = r107.getType();
    L13:
        r104.b("type", r108);
        Object r109 = r100.getTag();
        if ((r109 instanceof c61.c) == true) goto L16;
        r109 = null;
    L16:
        c61.c r110 = (c61.c) r109;
        if (r110 == null) goto L19;
        r106 = r110.f22534b;
    L19:
        r104.b("scene", r106);
        r104.b(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r101);
        Unit r111 = Unit.INSTANCE;
        r103.a(r104.a());
        return;
    L12:
        r108 = null;
        goto L13
    L22:
        return;
    }

    public static final void c(LiveAnchorTeleprompterView r100, boolean r101) {
        if (r101 == false) goto L14;
        LiveAnchorTeleprompterVm r102 = r100.getTeleprompterVm();
        if (r102 == null) goto L8;
        m<Boolean> r103 = r102.getFoldState();
        if (r103 == null) goto L8;
        r103.setValue(Boolean.FALSE);
    L8:
        ConstraintLayout r104 = r100.f66633d;
        if (r104 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r104);
    L11:
        ConstraintLayout r105 = r100.f66634e;
        if (r105 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r105);
    L25:
        r100.getClass();
        d(r101);
        DraggableWindowContext.Companion.getClass();
        c61.g r106 = DraggableWindowContext.b.a();
        if (r106 == null) goto L44;
        c61.e r107 = r106.monitor();
        if (r107 == null) goto L45;
        c61.b r108 = new c61.b("livesdk_draggable_component_click");
        Object r109 = r100.getTag();
        String r110 = null;
        if ((r109 instanceof c61.c) == true) goto L32;
        r109 = null;
    L32:
        c61.c r111 = (c61.c) r109;
        if (r111 == null) goto L35;
        Long r112 = r111.getType();
    L36:
        r108.b("type", r112);
        Object r113 = r100.getTag();
        if ((r113 instanceof c61.c) == true) goto L39;
        r113 = null;
    L39:
        c61.c r114 = (c61.c) r113;
        if (r114 == null) goto L42;
        r110 = r114.f22534b;
    L42:
        r108.b("scene", r110);
        Unit r115 = Unit.INSTANCE;
        r107.a(r108.a());
        return;
    L35:
        r112 = null;
        goto L36
    L45:
        return;
    L44:
        return;
    L14:
        LiveAnchorTeleprompterVm r116 = r100.getTeleprompterVm();
        if (r116 == null) goto L19;
        m<Boolean> r117 = r116.getFoldState();
        if (r117 == null) goto L19;
        r117.setValue(Boolean.TRUE);
    L19:
        ConstraintLayout r118 = r100.f66634e;
        if (r118 == null) goto L22;
        UtilityKotlinExtentionsKt.t(r118);
    L22:
        ConstraintLayout r119 = r100.f66633d;
        if (r119 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r119);
        goto L25
    }
}
