package com.bytedance.android.live.broadcastgame.xplay.container;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.api.xplay.k;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.g;
import com.bytedance.android.live.broadcastgame.xplay.g0;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.ot;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f62048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f62049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f62050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f62051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f62052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f62053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f62054h;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f62055a;

        public a(e r100) {
            this.f62055a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if (r101.longValue() > 0) goto L10;
            View r102 = this.f62055a.f62050d;
            if (r102 == null) goto L7;
            r102.setVisibility(8);
        L7:
            TextView r103 = this.f62055a.f62051e;
            if (r103 == null) goto L20;
            r103.setVisibility(8);
            return;
        L20:
            return;
        L10:
            View r104 = this.f62055a.f62050d;
            if (r104 == null) goto L13;
            r104.setVisibility(0);
        L13:
            TextView r105 = this.f62055a.f62051e;
            if (r105 == null) goto L16;
            r105.setVisibility(0);
        L16:
            TextView r106 = this.f62055a.f62051e;
            if (r106 == null) goto L22;
            StringCompanionObject r107 = StringCompanionObject.INSTANCE;
            r106.setText(String.format("%sms", Arrays.copyOf(new Object[]{String.valueOf(r101.longValue())}, 1)));
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public final ViewGroup getAnchorPreviewContainer() {
        return this.f62049c;
    }

    public final boolean getBlockTouchEvents() {
        return this.f62052f;
    }

    public final ViewGroup getXplayContainer() {
        return this.f62048b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f62052f == false) goto L9;
        if (r100.getAction() != 0) goto L9;
        int r101 = XplayLog.f61931a;
        XplayLog.a("InteractPlayView", "blocked touch event " + r100);
        return false;
    L9:
        if (this.f62053g == false) goto L25;
        int r102 = r100.getAction();
        if (r102 == 0) goto L21;
        if (r102 != 1) goto L14;
    L18:
        ViewParent r103 = getParent();
        if (r103 == null) goto L25;
        r103.requestDisallowInterceptTouchEvent(false);
        goto L25
    L14:
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L18;
    L21:
        ViewParent r104 = getParent();
        if (r104 == null) goto L25;
        r104.requestDisallowInterceptTouchEvent(true);
    L25:
        return super.dispatchTouchEvent(r100);
    }

    public final void setBlockTouchEvents(boolean r100) {
        this.f62052f = r100;
    }

    public final void setParentDisallowInterceptTouchEvent(boolean r100) {
        this.f62053g = r100;
    }

    public e(Context r100, g r101, g0 r102, XplayInternalContext r103, p r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "xplayToolbarService");
        Intrinsics.checkNotNullParameter(r102, "xplayLogService");
        Intrinsics.checkNotNullParameter(r103, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r104, "newEnv");
        super(r100);
        this.f62054h = r101;
        FrameLayout.inflate(r100, R.layout.ttlive_interact_play_view, this);
        setBackgroundColor(-16777216);
        FrameLayout r105 = (FrameLayout) findViewById(R.id.anchor_preview_container);
        this.f62049c = r105;
        this.f62048b = (FrameLayout) findViewById(R.id.xplay_container);
        View r106 = findViewById(R.id.ic_sei_delay);
        this.f62050d = r106;
        TextView r107 = (TextView) findViewById(R.id.tv_sei_delay);
        this.f62051e = r107;
        if (r103.getCurrentScene().getValue() != XplayScene.RevenueLink) goto L6;
        if (r105 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r105);
    L9:
        if (r104.f59504d == true) goto L14;
        ImageView r108 = (ImageView) findViewById(R.id.iv_clear_screen);
        TextView r109 = (TextView) findViewById(R.id.tv_clear_screen);
        IInteractService r110 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r110 == null) goto L14;
        r110.changeExitCleanScreenStyle(r108, r109);
    L14:
        if (r104.f59512l == false) goto L48;
        if (ot.f120930a.getValue().booleanValue() == false) goto L48;
        r103.getSeiDelay().a().subscribe(new a(this));
        IInteractService r111 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r111 != null) goto L20;
        return;
    L20:
        if (r111.isXplayFullScreenMode() == true) goto L22;
        return;
    L22:
        if (r104.f59504d == false) goto L24;
    L26:
        int r112 = 0;
    L27:
        ViewGroup.LayoutParams r113 = null;
        if (r106 == null) goto L30;
        ViewGroup.LayoutParams r114 = r106.getLayoutParams();
    L32:
        if ((r114 instanceof FrameLayout.LayoutParams) == true) goto L34;
        r114 = null;
    L34:
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114;
        if (r115 == null) goto L37;
        r115.topMargin = s1.f(45.0f) + r112;
    L37:
        if (r107 == null) goto L39;
        ViewGroup.LayoutParams r116 = r107.getLayoutParams();
    L41:
        if ((r116 instanceof FrameLayout.LayoutParams) == false) goto L44;
        r113 = r116;
    L44:
        FrameLayout.LayoutParams r117 = (FrameLayout.LayoutParams) r113;
        if (r117 == null) goto L55;
        r117.topMargin = s1.f(46.0f) + r112;
        return;
    L55:
        return;
    L39:
        r116 = null;
        goto L41
    L30:
        r114 = null;
        goto L32
    L24:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L26;
        r112 = StatusBarUtil.getStatusBarHeight(r100);
    L48:
        if (r106 == null) goto L50;
        r106.setVisibility(8);
    L50:
        if (r107 == null) goto L57;
        r107.setVisibility(8);
        return;
    L57:
        return;
    L6:
        if (r105 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r105);
        goto L9
    }
}
