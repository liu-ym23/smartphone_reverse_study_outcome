package com.bytedance.android.livesdk.chatroom.replay.paid;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.view.BlurImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/paid/ReplayLVideoTheaterBlockView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/chatroom/replay/paid/b;", "", "f", "Z", "getAdaptLargeFont", "()Z", "adaptLargeFont", "", "getLogTag", "()Ljava/lang/String;", "logTag", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayLVideoTheaterBlockView extends ConstraintLayout implements com.bytedance.android.livesdk.chatroom.replay.paid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f109323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f109324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f109325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f109326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BlurImageView f109327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f109328f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLVideoTheaterBlockView f109329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f109330b;

        public b(ReplayLVideoTheaterBlockView r100, Function0 r101) {
            this.f109329a = r100;
            this.f109330b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ALogger.i(ReplayLVideoTheaterBlockView.R5(this.f109329a), "block view click");
            this.f109330b.invoke();
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLVideoTheaterBlockView f109331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f109332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f109333c;

        public c(ReplayLVideoTheaterBlockView r100, Bitmap r101, int r102) {
            this.f109331a = r100;
            this.f109332b = r101;
            this.f109333c = r102;
        }

        public final void a() {
            ALogger.i(ReplayLVideoTheaterBlockView.R5(this.f109331a), "blur size: width " + this.f109331a.getWidth() + ", height " + this.f109331a.getHeight());
            BlurImageView r100 = this.f109331a.f109327e;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.getWidth();
        L6:
            if (r102 <= 0) goto L14;
            BlurImageView r103 = this.f109331a.f109327e;
            if (r103 == null) goto L10;
            r101 = r103.getHeight();
        L10:
            if (r101 <= 0) goto L14;
            BlurImageView r104 = this.f109331a.f109327e;
            if (r104 == null) goto L24;
            r104.setBackground(this.f109332b);
            return;
        L24:
            return;
        L14:
            int r105 = this.f109333c;
            if (r105 <= 3) goto L17;
            r105 = 3;
        L17:
            if (r105 > 0) goto L19;
            return;
        L19:
            BlurImageView r106 = this.f109331a.f109327e;
            if (r106 == null) goto L22;
            r106.requestLayout();
        L22:
            this.f109331a.l4(this.f109332b, r105 - 1);
            return;
        L5:
            r102 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLVideoTheaterBlockView f109334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f109335b;

        public d(ReplayLVideoTheaterBlockView r100, Function0 r101) {
            this.f109334a = r100;
            this.f109335b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ALogger.i(ReplayLVideoTheaterBlockView.R5(this.f109334a), "delivery view click");
            this.f109335b.invoke();
        }
    }

    static {
    }

    public ReplayLVideoTheaterBlockView(Context r100) {
        this(r100, null, 0, false, 14);
    }

    public ReplayLVideoTheaterBlockView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, false, 12);
    }

    public ReplayLVideoTheaterBlockView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, false, 8);
    }

    private final String getLogTag() {
        return "PaidReplayLogTag ReplayLVideoTheaterBlockView" + hashCode();
    }

    public final void S5() {
        if (this.f109328f == true) goto L5;
        return;
    L5:
        TextView r100 = this.f109323a;
        if (r100 == null) goto L8;
        r100.setTextSize(2, 15.0f);
    L8:
        TextView r101 = this.f109324b;
        if (r101 == null) goto L11;
        r101.setTextSize(2, 12.0f);
    L11:
        TextView r102 = this.f109326d;
        if (r102 == null) goto L14;
        r102.setTextSize(2, 16.0f);
    L14:
        TextView r103 = this.f109325c;
        if (r103 == null) goto L18;
        r103.setTextSize(2, 14.0f);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.b
    public final void hide() {
        ALogger.i(getLogTag(), "hiding view");
        BlurImageView r100 = this.f109327e;
        if (r100 == null) goto L5;
        r100.setBackground(null);
    L5:
        UtilityKotlinExtentionsKt.h(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.b
    public final boolean isShowing() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.b
    public final void release() {
        ALogger.i(getLogTag(), "remove from container");
        ViewGroup r100 = UtilityKotlinExtentionsKt.f(this);
        if (r100 == null) goto L6;
        r100.removeView(this);
        return;
    }

    public final boolean getAdaptLargeFont() {
        return this.f109328f;
    }

    public static final /* synthetic */ String R5(ReplayLVideoTheaterBlockView r100) {
        return r100.getLogTag();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.b
    public final void N(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        ALogger.i(getLogTag(), "add view to container");
        ViewGroup r101 = UtilityKotlinExtentionsKt.f(this);
        if (r101 == null) goto L5;
        r101.removeView(this);
    L5:
        S5();
        r100.addView(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.b
    public final void B1(Function0<Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onShowAction");
        Intrinsics.checkNotNullParameter(r101, "onClickAction");
        ALogger.i(getLogTag(), "showing delivery view");
        UtilityKotlinExtentionsKt.j(this);
        TextView r102 = this.f109324b;
        if (r102 == null) goto L5;
        UtilityKotlinExtentionsKt.h(r102);
    L5:
        TextView r103 = this.f109323a;
        if (r103 == null) goto L8;
        r103.setText(s1.B(R.string.ttlive_replay_has_buy_ticket));
    L8:
        TextView r104 = this.f109325c;
        if (r104 == null) goto L11;
        UtilityKotlinExtentionsKt.h(r104);
    L11:
        TextView r105 = this.f109326d;
        if (r105 == null) goto L14;
        UtilityKotlinExtentionsKt.j(r105);
    L14:
        TextView r106 = this.f109326d;
        if (r106 == null) goto L17;
        r106.setOnClickListener(new d(this, r101));
    L17:
        r100.invoke();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.b
    public final void l4(Bitmap r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        BlurImageView r102 = this.f109327e;
        if (r102 == null) goto L6;
        r102.post(new c(this, r100, r101));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.b
    public final void x1(Function0<Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onShowAction");
        Intrinsics.checkNotNullParameter(r101, "onClickAction");
        ALogger.i(getLogTag(), "showing block view");
        UtilityKotlinExtentionsKt.j(this);
        TextView r102 = this.f109324b;
        if (r102 == null) goto L5;
        UtilityKotlinExtentionsKt.j(r102);
    L5:
        TextView r103 = this.f109323a;
        if (r103 == null) goto L8;
        r103.setText(s1.B(R.string.ttlive_replay_buy_ticket_title));
    L8:
        TextView r104 = this.f109325c;
        if (r104 == null) goto L11;
        UtilityKotlinExtentionsKt.j(r104);
    L11:
        TextView r105 = this.f109326d;
        if (r105 == null) goto L14;
        UtilityKotlinExtentionsKt.h(r105);
    L14:
        setOnClickListener(new b(this, r101));
        r100.invoke();
    }

    public ReplayLVideoTheaterBlockView(Context r100, AttributeSet r101, int r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f109328f = r103;
        View.inflate(r100, R.layout.ttlive_replay_lvideo_theater_paid_block_view, this);
        this.f109323a = (TextView) findViewById(R.id.replay_paid_block_title);
        this.f109324b = (TextView) findViewById(R.id.replay_paid_sub_title);
        this.f109325c = (TextView) findViewById(R.id.replay_buy_btn);
        this.f109326d = (TextView) findViewById(R.id.delivery_btn);
        this.f109327e = (BlurImageView) findViewById(R.id.replay_blur_background);
        UtilityKotlinExtentionsKt.h(this);
        S5();
    }
}
