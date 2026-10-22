package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.s51;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ec2.u0;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pa2.a;
import ra2.m;
import ra2.n;
import ra2.r;
import ra2.s;
import ra2.t;
import ra2.u;
import ra2.v;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u000204¢\u0006\u0004\bX\u0010YJ\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR$\u0010,\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u00100\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00109\u001a\u0002048\u0006X\u0086D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u0010<\u001a\u0002048\u0006X\u0086D¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R\"\u0010@\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010?R\"\u0010C\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00106\u001a\u0004\bA\u00108\"\u0004\bB\u0010?R\u0017\u0010F\u001a\u0002048\u0006¢\u0006\f\n\u0004\bD\u00106\u001a\u0004\bE\u00108R\u0017\u0010I\u001a\u0002048\u0006¢\u0006\f\n\u0004\bG\u00106\u001a\u0004\bH\u00108R\u0017\u0010L\u001a\u0002048\u0006¢\u0006\f\n\u0004\bJ\u00106\u001a\u0004\bK\u00108R\u0017\u0010O\u001a\u0002048\u0006¢\u0006\f\n\u0004\bM\u00106\u001a\u0004\bN\u00108R\u0017\u0010R\u001a\u0002048\u0006¢\u0006\f\n\u0004\bP\u00106\u001a\u0004\bQ\u00108¨\u0006Z"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/MatchHotMsgView;", "Landroid/widget/FrameLayout;", "Lra2/m;", "Ljava/util/concurrent/PriorityBlockingQueue;", "Lcom/bytedance/android/live/base/model/message/g3;", "getQueue", "Lpa2/a;", "c", "", "setManagerCallBack", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "J", "getIconIndex", "()J", "setIconIndex", "(J)V", "iconIndex", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/android/live/base/model/message/g3;", "getCurShowMsg", "()Lcom/bytedance/android/live/base/model/message/g3;", "setCurShowMsg", "(Lcom/bytedance/android/live/base/model/message/g3;)V", "curShowMsg", "Landroid/animation/AnimatorSet;", "B", "Landroid/animation/AnimatorSet;", "getEnterInAnimSet", "()Landroid/animation/AnimatorSet;", "setEnterInAnimSet", "(Landroid/animation/AnimatorSet;)V", "enterInAnimSet", "C", "getScaleAnimatorSets", "setScaleAnimatorSets", "scaleAnimatorSets", "D", "getExitAnimatorSets", "setExitAnimatorSets", "exitAnimatorSets", ExifInterface.LONGITUDE_EAST, "getComboAnimSet", "setComboAnimSet", "comboAnimSet", "", FaceService.girlLabel, "Z", "isRunning", "()Z", "setRunning", "(Z)V", "", "G", "I", "getUnInit", "()I", "UnInit", FaceService.neutralLabel, "getNeedExit", "NeedExit", "getStatus", "setStatus", "(I)V", "status", "getImgLoadCount", "setImgLoadCount", "imgLoadCount", "K", "getContentPartMarginLeft", "contentPartMarginLeft", "L", "getComboPartMarginLeft", "comboPartMarginLeft", "M", "getComboCountMarginLeft", "comboCountMarginLeft", "N", "getComboPartMarginRight", "comboPartMarginRight", "O", "getSpreadBgOverlapWidth", "spreadBgOverlapWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchHotMsgView extends FrameLayout implements m {
    public static final /* synthetic */ int P = 0;
    public g3 A;
    public AnimatorSet B;
    public AnimatorSet C;
    public AnimatorSet D;
    public AnimatorSet E;
    public boolean F;
    public final int G;
    public final int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f140118J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f140119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f140120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f140121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f140122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f140123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f140124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f140125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f140126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f140127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f140128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f140129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s f140130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public r f140131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t f140132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public u f140133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public v f140134p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnimatedDrawable2 f140135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AnimatedDrawable2 f140136r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f140137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f140138t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f140139u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f140140v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f140141w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f140142x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f140143y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PriorityBlockingQueue<g3> f140144z;

    private final PriorityBlockingQueue<g3> getQueue() {
        PriorityBlockingQueue<g3> r100 = this.f140144z;
        if (r100 != null) goto L6;
        PriorityBlockingQueue<g3> r101 = new PriorityBlockingQueue(11, n.f536826a);
        this.f140144z = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // ra2.m
    public final boolean a() {
        s51 r100 = u0.f472061a.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.c() != true) goto L7;
        return true;
    }

    public final AnimatorSet getComboAnimSet() {
        return this.E;
    }

    public final int getComboCountMarginLeft() {
        return this.M;
    }

    public final int getComboPartMarginLeft() {
        return this.L;
    }

    public final int getComboPartMarginRight() {
        return this.N;
    }

    public final int getContentPartMarginLeft() {
        return this.K;
    }

    public final g3 getCurShowMsg() {
        return this.A;
    }

    public final AnimatorSet getEnterInAnimSet() {
        return this.B;
    }

    public final AnimatorSet getExitAnimatorSets() {
        return this.D;
    }

    public final long getIconIndex() {
        return this.f140119a;
    }

    public final int getImgLoadCount() {
        return this.f140118J;
    }

    public final int getNeedExit() {
        return this.H;
    }

    public final AnimatorSet getScaleAnimatorSets() {
        return this.C;
    }

    public final int getSpreadBgOverlapWidth() {
        return this.O;
    }

    public final int getStatus() {
        return this.I;
    }

    public final int getUnInit() {
        return this.G;
    }

    public static void b(AnimatorSet r100) {
        if (r100 == null) goto L4;
        r100.removeAllListeners();
    L4:
        if (r100 == null) goto L7;
        r100.cancel();
        return;
    }

    public final void c(g3 r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        getQueue().add(r100);
    }

    public final void d(g3 r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        long r101 = r100.getTriggerTimestamp();
        g3 r102 = this.A;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 != r102.getTriggerTimestamp()) goto L9;
        getQueue().add(r100);
        return;
    }

    public final void setComboAnimSet(AnimatorSet r100) {
        this.E = r100;
    }

    public final void setCurShowMsg(g3 r100) {
        this.A = r100;
    }

    public final void setEnterInAnimSet(AnimatorSet r100) {
        this.B = r100;
    }

    public final void setExitAnimatorSets(AnimatorSet r100) {
        this.D = r100;
    }

    public final void setIconIndex(long r100) {
        this.f140119a = r100;
    }

    public final void setImgLoadCount(int r100) {
        this.f140118J = r100;
    }

    public void setManagerCallBack(a r100) {
        Intrinsics.checkNotNullParameter(r100, "c");
        this.f140126h = r100;
    }

    public final void setRunning(boolean r100) {
        this.F = r100;
    }

    public final void setScaleAnimatorSets(AnimatorSet r100) {
        this.C = r100;
    }

    public final void setStatus(int r100) {
        this.I = r100;
    }

    public MatchHotMsgView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f140137s = 50;
        this.f140138t = 50;
        this.f140141w = 5000;
        this.f140142x = 500;
        this.G = -1;
        this.H = 2;
        this.I = -1;
        this.K = s1.j(R.dimen.ttlive_match_hot_content_part_margin_left);
        this.L = s1.j(R.dimen.ttlive_match_hot_combo_part_margin_left);
        this.M = s1.j(R.dimen.ttlive_match_hot_combo_count_in_combo_part_margin_left);
        this.N = s1.j(R.dimen.ttlive_match_hot_combo_part_margin_right);
        this.O = s1.j(R.dimen.ttlive_match_hot_view_overlap);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_match_hot_msg_view, this);
        this.f140120b = (HSImageView) findViewById(R.id.iv_webp_spread_bg);
        this.f140121c = (HSImageView) findViewById(R.id.match_hot_msg_applause_webp);
        this.f140122d = (ViewGroup) findViewById(R.id.match_hot_view_container);
        this.f140123e = (ViewGroup) findViewById(R.id.text_container);
        this.f140124f = (ImageView) findViewById(R.id.text_container_bg);
        this.f140125g = (ViewGroup) findViewById(R.id.combo_container);
        this.f140127i = (TextView) findViewById(R.id.hot_msg_combo_count);
        this.f140128j = (TextView) findViewById(R.id.hot_msg_combo_count_x);
        this.f140129k = (TextView) findViewById(R.id.hot_msg_content);
        this.f140131m = new r(this);
        this.f140130l = new s(this);
        this.f140132n = new t(this);
        this.f140133o = new u(this);
        this.f140134p = new v(this);
    }
}
