package com.bytedance.android.live.liveinteract.revenue.fight.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multiscene.j;
import com.bytedance.android.live.liveinteract.utils.r1;
import com.bytedance.android.livesdk.chatroom.model.interact.v0;
import com.bytedance.android.livesdk.chatroom.view.NoPaddingTextView;
import com.bytedance.android.livesdk.model.h0;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0015\u0004B\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/view/TeamFightPKProgressLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/view/TeamFightProgressBar$a;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMIsAnchor", "()Z", "setMIsAnchor", "(Z)V", "mIsAnchor", "", "getTotalWidth", "()I", "totalWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "AnimationState", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightPKProgressLayout extends FrameLayout implements TeamFightProgressBar.a {
    public static final /* synthetic */ int F = 0;
    public final HSImageView A;
    public final HSImageView B;
    public Disposable C;
    public Disposable D;
    public com.bytedance.android.live.liveinteract.multiscene.a E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f78211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f78215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimationState f78216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f78217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f78218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f78219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h0 f78220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f78221k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f78222l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final NoPaddingTextView f78223m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final NoPaddingTextView f78224n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HSImageView f78225o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final NoPaddingTextView f78226p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final NoPaddingTextView f78227q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HSImageView f78228r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final NoPaddingTextView f78229s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final NoPaddingTextView f78230t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f78231u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextView f78232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ViewGroup f78233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ViewGroup f78234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TeamFightProgressBar f78235y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CompactTailView f78236z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/view/TeamFightPKProgressLayout$AnimationState;", "", "MIDDLE", "WEAK", "STRONG", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AnimationState extends Enum<AnimationState> {
        public static final AnimationState MIDDLE = null;
        public static final AnimationState STRONG = null;
        public static final AnimationState WEAK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimationState[] f78237a = null;

        static {
            AnimationState r100 = new AnimationState("MIDDLE", 0);
            MIDDLE = r100;
            AnimationState r101 = new AnimationState("WEAK", 1);
            WEAK = r101;
            AnimationState r102 = new AnimationState("STRONG", 2);
            STRONG = r102;
            f78237a = new AnimationState[]{r100, r101, r102};
        }

        public static AnimationState valueOf(String r100) {
            return (AnimationState) r27.a.a(AnimationState.class, r100);
        }

        public static AnimationState[] values() {
            return (AnimationState[]) f78237a.clone();
        }

        public AnimationState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TeamFightPKProgressLayout f78238a;

        public b(TeamFightPKProgressLayout r100) {
            this.f78238a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            UtilityKotlinExtentionsKt.t(this.f78238a.f78231u);
            this.f78238a.f78235y.b(0);
            com.bytedance.android.live.liveinteract.multiscene.a r100 = this.f78238a.E;
            if (r100 == null) goto L11;
            j r101 = li0.d.i(r100);
            if (r101 == null) goto L12;
            TeamFightPKProgressLayout r102 = this.f78238a;
            int r103 = (int) r101.getScore();
            String r104 = r101.getScoreFuzzy();
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            r102.h(r103, r104, r101.getBonusScore());
            return;
        L12:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TeamFightPKProgressLayout f78239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v0 f78240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.multiscene.a f78241c;

        public c(TeamFightPKProgressLayout r100, v0 r101, com.bytedance.android.live.liveinteract.multiscene.a r102) {
            this.f78239a = r100;
            this.f78240b = r101;
            this.f78241c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f78239a.f78231u.setText("X" + this.f78240b.getCoefficient() + " | " + ((Long) r100) + 's');
            UtilityKotlinExtentionsKt.w(this.f78239a.f78231u);
            int r101 = (li0.d.h(this.f78239a.f78233w) + a1.f(this.f78239a.f78233w)) + a1.g(this.f78239a.f78233w);
            if (this.f78239a.f78235y.f78261l == (s1.f(9.0f) + r101)) goto L13;
            this.f78239a.f78235y.b(r101 + s1.f(9.0f));
            com.bytedance.android.live.liveinteract.multiscene.a r102 = this.f78241c;
            if (r102 == null) goto L14;
            j r103 = li0.d.i(r102);
            if (r103 == null) goto L15;
            TeamFightPKProgressLayout r104 = this.f78239a;
            int r105 = (int) r103.getScore();
            String r106 = r103.getScoreFuzzy();
            if (r106 != null) goto L11;
            r106 = "";
        L11:
            r104.h(r105, r106, r103.getBonusScore());
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f78242a = null;

        static {
            f78242a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = TeamFightPKProgressLayout.F;
            ALogger.e("TeamFightPKProgressLayout", (Throwable) r100);
        }
    }

    public static final class e implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TeamFightPKProgressLayout f78243a;

        public e(TeamFightPKProgressLayout r100) {
            this.f78243a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            UtilityKotlinExtentionsKt.t(this.f78243a.f78232v);
            this.f78243a.f78235y.c(0);
            com.bytedance.android.live.liveinteract.multiscene.a r100 = this.f78243a.E;
            if (r100 == null) goto L11;
            j r101 = li0.d.a(r100);
            if (r101 == null) goto L12;
            TeamFightPKProgressLayout r102 = this.f78243a;
            int r103 = (int) r101.getScore();
            String r104 = r101.getScoreFuzzy();
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            r102.i(r103, r104, r101.getBonusScore());
            return;
        L12:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TeamFightPKProgressLayout f78244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v0 f78245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.multiscene.a f78246c;

        public f(TeamFightPKProgressLayout r100, v0 r101, com.bytedance.android.live.liveinteract.multiscene.a r102) {
            this.f78244a = r100;
            this.f78245b = r101;
            this.f78246c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f78244a.f78232v.setText("X" + this.f78245b.getCoefficient() + " | " + ((Long) r100) + 's');
            UtilityKotlinExtentionsKt.w(this.f78244a.f78232v);
            int r101 = (li0.d.h(this.f78244a.f78234x) + a1.f(this.f78244a.f78234x)) + a1.g(this.f78244a.f78234x);
            if (this.f78244a.f78235y.f78262m == (s1.f(9.0f) + r101)) goto L13;
            this.f78244a.f78235y.c(r101 + s1.f(9.0f));
            com.bytedance.android.live.liveinteract.multiscene.a r102 = this.f78246c;
            if (r102 == null) goto L14;
            j r103 = li0.d.a(r102);
            if (r103 == null) goto L15;
            TeamFightPKProgressLayout r104 = this.f78244a;
            int r105 = (int) r103.getScore();
            String r106 = r103.getScoreFuzzy();
            if (r106 != null) goto L11;
            r106 = "";
        L11:
            r104.i(r105, r106, r103.getBonusScore());
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f78247a = null;

        static {
            f78247a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = TeamFightPKProgressLayout.F;
            ALogger.e("TeamFightPKProgressLayout", (Throwable) r100);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightProgressBar.a
    public final void onProgressChange() {
    }

    public static boolean c() {
        IInteractService r100 = (IInteractService) k.f(IInteractService.class);
        if (r100 == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.performance.a r101 = r100.getMultiLinkPerfAbilityManager(true);
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.a("multilink_base_degrade");
    L8:
        return true;
    }

    public final void b() {
        String r100 = this.f78222l;
        if (r100 == null) goto L9;
        IInteractService r101 = (IInteractService) k.f(IInteractService.class);
        if (r101 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r102 = r101.getMultiLinkPerfAbilityManager(false);
        if (r102 == null) goto L9;
        r102.c("multilink_base_degrade", r100);
    L9:
        this.f78222l = null;
    }

    public final void f() {
        this.A.setVisibility(0);
        this.B.setVisibility(8);
        this.f78229s.setVisibility(8);
        this.f78230t.setVisibility(8);
        this.f78217g = false;
        this.f78216f = AnimationState.MIDDLE;
        this.f78223m.setVisibility(0);
        a1.m(this.f78223m, s1.j(R.dimen.ttlive_team_fight_progress_bar_score_text_margin));
        this.f78223m.setText("0");
        this.f78226p.setVisibility(0);
        a1.n(this.f78226p, s1.j(R.dimen.ttlive_team_fight_progress_bar_score_text_margin));
        this.f78226p.setText("0");
        this.A.setVisibility(0);
        r1.a(this.A, this.f78220j.c(), Boolean.valueOf(c()));
        TeamFightProgressBar r100 = this.f78235y;
        r100.f78252c = 0;
        r100.f78253d = 0;
        r100.f78250a = 0.5f;
        r100.f78265p = true;
        r100.f78260k = s1.f(30.0f);
        r100.invalidate();
        this.f78225o.setVisibility(8);
        this.f78228r.setVisibility(8);
        Disposable r101 = this.C;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Disposable r102 = this.D;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        UtilityKotlinExtentionsKt.t(this.f78231u);
        UtilityKotlinExtentionsKt.t(this.f78232v);
        this.f78218h = false;
        UtilityKotlinExtentionsKt.t(this.f78224n);
        UtilityKotlinExtentionsKt.t(this.f78227q);
        UtilityKotlinExtentionsKt.t(this.f78236z);
        this.f78235y.setEnlarge(false);
    }

    private final int getTotalWidth() {
        if (getWidth() <= 0) goto L6;
        return getWidth();
    L6:
        return s1.y();
    }

    public final boolean getMIsAnchor() {
        return this.f78211a;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightProgressBar.a
    public final void a(float r100) {
        TeamFightProgressBar r101 = this.f78235y;
        int r102 = r101.f78260k;
        int r103 = r101.f78261l;
        int r104 = r101.f78262m;
        float r105 = (r100 * (getTotalWidth() - (r102 * 2))) + r102;
        float r106 = 0;
        if (r105 <= r106) goto L8;
        float r107 = r103;
        if (r105 >= r107) goto L8;
        r105 = r107;
    L8:
        if ((getTotalWidth() - r105) > r106) goto L10;
    L12:
        a1.m(this.B, (int) ((r105 - this.f78212b) + s1.f(8.5f)));
        if (this.f78211a == false) goto L15;
    L39:
        this.f78223m.setVisibility(0);
        this.f78226p.setVisibility(0);
        this.f78229s.setVisibility(8);
        this.f78230t.setVisibility(8);
        return;
    L15:
        if (this.f78217g == false) goto L39;
        CharSequence r108 = this.f78229s.getText();
        if (r108 != null) goto L19;
    L23:
        CharSequence r109 = this.f78230t.getText();
        if (r109 == null) goto L39;
        if (r109.length() <= 0) goto L28;
        boolean r110 = true;
    L29:
        if (r110 != true) goto L39;
    L30:
        this.f78223m.setVisibility(8);
        this.f78226p.setVisibility(8);
        CharSequence r111 = this.f78229s.getText();
        if (r111 != null) goto L33;
    L38:
        this.f78229s.setVisibility(8);
        this.f78230t.setVisibility(0);
        return;
    L33:
        if (r111.length() <= 0) goto L35;
        boolean r112 = true;
    L36:
        if (r112 != true) goto L38;
        this.f78229s.setVisibility(0);
        this.f78230t.setVisibility(8);
        return;
    L35:
        r112 = false;
        goto L36
    L28:
        r110 = false;
        goto L29
    L19:
        if (r108.length() <= 0) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == true) goto L30;
    L21:
        r113 = false;
        goto L22
    L10:
        if ((getTotalWidth() - r105) >= r104) goto L12;
        r105 = getTotalWidth() - r104;
        goto L12
    }

    public final void e(boolean r100) {
        this.f78211a = r100;
        String r101 = this.f78222l;
        if (r101 != null) goto L10;
        IInteractService r102 = (IInteractService) k.f(IInteractService.class);
        if (r102 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r103 = r102.getMultiLinkPerfAbilityManager(true);
        if (r103 == null) goto L9;
        r101 = r103.b("multilink_base_degrade", new TeamFightPKProgressLayout$handlePerfInit$1(this));
    L9:
        r101 = null;
    L10:
        this.f78222l = r101;
    }

    public final void setMIsAnchor(boolean r100) {
        this.f78211a = r100;
    }

    public TeamFightPKProgressLayout(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        this.f78212b = s1.j(R.dimen.ttlive_team_fight_progress_anim_width);
        this.f78213c = s1.j(R.dimen.ttlive_team_fight_result_score_margin_to_screen);
        this.f78216f = AnimationState.MIDDLE;
        h0 r112 = (h0) vm2.d.f555984u7.getValue(null, vm2.d.f555776a[433(0x1b1, float:6.07E-43)]);
        this.f78220j = r112;
        this.f78221k = new CompositeDisposable();
        LayoutInflater.from(r110).inflate(R.layout.ttlive_team_fight_progressbar, this);
        NoPaddingTextView r100 = (NoPaddingTextView) findViewById(R.id.left_text);
        this.f78223m = r100;
        this.f78224n = (NoPaddingTextView) findViewById(R.id.left_delta_score);
        HSImageView r101 = (HSImageView) findViewById(R.id.left_emoji_anim);
        this.f78225o = r101;
        NoPaddingTextView r102 = (NoPaddingTextView) findViewById(R.id.right_text);
        this.f78226p = r102;
        this.f78227q = (NoPaddingTextView) findViewById(R.id.right_delta_score);
        HSImageView r103 = (HSImageView) findViewById(R.id.right_emoji_anim);
        this.f78228r = r103;
        NoPaddingTextView r104 = (NoPaddingTextView) findViewById(R.id.tv_score_relative);
        this.f78229s = r104;
        NoPaddingTextView r105 = (NoPaddingTextView) findViewById(R.id.tv_score_relative_right);
        this.f78230t = r105;
        this.f78231u = (TextView) findViewById(R.id.ttlive_team_pk_bar_left_coefficient);
        this.f78232v = (TextView) findViewById(R.id.ttlive_team_pk_bar_right_coefficient);
        this.f78233w = (ViewGroup) findViewById(R.id.left_score_container);
        this.f78234x = (ViewGroup) findViewById(R.id.right_score_container);
        TeamFightProgressBar r106 = (TeamFightProgressBar) findViewById(R.id.pk_progressbar);
        this.f78235y = r106;
        CompactTailView r107 = (CompactTailView) findViewById(R.id.wave_tail);
        this.f78236z = r107;
        HSImageView r108 = (HSImageView) findViewById(R.id.middle_anim);
        this.A = r108;
        this.B = (HSImageView) findViewById(R.id.pk_progressbar_anim);
        HSImageView r109 = (HSImageView) findViewById(R.id.left_gift_icon);
        HSImageView r113 = (HSImageView) findViewById(R.id.right_gift_icon);
        a1.l(r100, s1.f(0.5f));
        a1.l(r102, s1.f(0.5f));
        r106.setOnProgressChangeListener(this);
        int r114 = s1.h(R.color.ttlive_interact_pk_progress_bar_color_left);
        int r115 = s1.h(R.color.ttlive_interact_pk_progress_bar_color_left);
        int r116 = s1.h(R.color.ttlive_interact_pk_progress_bar_color_right);
        int r117 = s1.h(R.color.ttlive_interact_pk_progress_bar_color_right);
        r106.f78256g = r114;
        r106.f78257h = r115;
        r106.f78258i = r116;
        r106.f78259j = r117;
        r108.setVisibility(0);
        r1.a(r108, r112.c(), Boolean.valueOf(c()));
        Typeface r118 = Typeface.createFromAsset(r110.getAssets(), "fonts/clarity_mono_bold.otf");
        r100.setTypeface(r118);
        r102.setTypeface(r118);
        r104.setTypeface(r118);
        r104.setVisibility(8);
        r105.setTypeface(r118);
        r105.setVisibility(8);
        r101.setVisibility(8);
        r103.setVisibility(8);
        a1.k(r107, TeamFightProgressBar.f78249s);
        r107.setCircleRadius(24.0f);
    }

    public static Observable d(long r100, TimeUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        return Observable.interval(1, r101).map(new com.bytedance.android.live.liveinteract.revenue.fight.view.a(r100)).takeUntil(com.bytedance.android.live.liveinteract.revenue.fight.view.b.f78276a).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(AndroidSchedulers.mainThread());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(com.bytedance.android.live.liveinteract.multiscene.a r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r210, "teamFightInfo");
        this.E = r210;
        j r100 = li0.d.i(r210);
        j r101 = li0.d.a(r210);
        Intrinsics.checkNotNullParameter(r210, "teamFightInfo");
        if (gh0.a.d() == true) goto L29;
        Intrinsics.checkNotNullParameter(r210, "$this$useRelativePkBar");
        if (r210.getPkBarStyle() != 2) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L29;
        String r103 = je0.d.b0();
        j r104 = li0.d.i(r210);
        if (r104 == null) goto L19;
        com.bytedance.android.live.liveinteract.multiscene.f.b r110 = r104.getContributors();
        if (r110 == null) goto L19;
        if (r110.contains(r103) != true) goto L19;
        if (r104.isScoreFuzzy() == true) goto L29;
    L19:
        j r105 = li0.d.a(r210);
        if (r105 == null) goto L28;
        com.bytedance.android.live.liveinteract.multiscene.f.b r111 = r105.getContributors();
        if (r111 == null) goto L28;
        if (r111.contains(r103) != true) goto L28;
        if (r105.isScoreFuzzy() == true) goto L29;
    L28:
        boolean r106 = true;
    L30:
        if (r106 == false) goto L80;
        j r112 = li0.d.i(r210);
        j r113 = li0.d.a(r210);
        if (r211 == false) goto L48;
        Long r114 = r210.getWinTeamId();
        long r107 = 2;
        if (r114 != null) goto L37;
    L43:
        if (r112 == null) goto L46;
        String r108 = r112.getScoreFuzzy();
        if (r108 == null) goto L46;
    L47:
        Pair r109 = TuplesKt.to(1, r108);
    L65:
        int r115 = ((Number) r109.component1()).intValue();
        String r116 = (String) r109.component2();
        this.f78217g = true;
        if (r115 != 2) goto L68;
        v0 r117 = null;
        this.f78229s.setText(null);
        this.f78230t.setText(r116);
    L69:
        if (r211 == true) goto L81;
        if (r100 == null) goto L75;
        if (r101 == null) goto L75;
        if (r100.getScore() >= r101.getScore()) goto L75;
        boolean r118 = true;
    L77:
        if (r118 == false) goto L79;
        this.f78229s.setVisibility(8);
        this.f78230t.setVisibility(0);
        a1.n(this.f78230t, s1.j(R.dimen.ttlive_team_fight_progress_bar_score_text_margin));
        goto L81
    L79:
        this.f78229s.setVisibility(0);
        this.f78230t.setVisibility(8);
        a1.m(this.f78229s, s1.j(R.dimen.ttlive_team_fight_progress_bar_score_text_margin));
    L75:
        r118 = false;
    L81:
        StringBuilder r119 = new StringBuilder("setTeamFightInfo red=");
        if (r100 == null) goto L84;
        Object r120 = Long.valueOf(r100.getScore());
    L85:
        r119.append(r120);
        r119.append(" blue=");
        if (r101 == null) goto L88;
        Object r121 = Long.valueOf(r101.getScore());
    L89:
        r119.append(r121);
        r119.append(" useRelativeScore=");
        r119.append(r106);
        r119.append(" isPunish=");
        r119.append(r211);
        ALogger.w("TeamFightPKProgressLayout", r119.toString());
        String r122 = "";
        if (r100 == null) goto L99;
        String r123 = r100.getScoreStr();
        if (r123 != null) goto L94;
        r123 = r100.getScoreFuzzy();
    L94:
        if (r123 != null) goto L96;
        r123 = "";
    L96:
        h((int) r100.getScore(), r123, r100.getBonusScore());
        if (this.f78231u.getVisibility() != 0) goto L99;
        this.f78235y.b(((li0.d.h(this.f78233w) + a1.f(this.f78233w)) + a1.g(this.f78233w)) + s1.f(9.0f));
    L99:
        if (r101 == null) goto L109;
        String r124 = r101.getScoreStr();
        if (r124 != null) goto L103;
        r124 = r101.getScoreFuzzy();
    L103:
        if (r124 == null) goto L106;
        r122 = r124;
    L106:
        i((int) r101.getScore(), r122, r101.getBonusScore());
        if (this.f78232v.getVisibility() != 0) goto L109;
        this.f78235y.c(((li0.d.h(this.f78234x) + a1.f(this.f78234x)) + a1.g(this.f78234x)) + s1.f(9.0f));
    L109:
        if (r211 == true) goto L175;
        long r125 = r210.getCurrentTime();
        if (r100 == null) goto L113;
        v0 r126 = r100.getBonusInfo();
    L114:
        if (r101 == null) goto L116;
        v0 r127 = r101.getBonusInfo();
    L117:
        if (r126 == null) goto L119;
        Long r128 = Long.valueOf(r126.getDuration());
    L120:
        long r129 = 0;
        if (r126 == null) goto L123;
        long r130 = (r125 / ((long) 1000)) - r126.getStartTime();
    L124:
        StringBuilder r131 = new StringBuilder("red team duration ");
        r131.append(r128);
        r131.append(", start time ");
        if (r126 == null) goto L127;
        Object r132 = Long.valueOf(r126.getStartTime());
    L128:
        r131.append(r132);
        r131.append(" current time ");
        r131.append(r125);
        r131.append(" diff ");
        r131.append(r130);
        ALogger.i("TeamFightPKProgressLayout", r131.toString());
        if (r126 != null) goto L131;
    L147:
        boolean r212 = r106;
    L148:
        if (r127 == null) goto L150;
        Long r133 = Long.valueOf(r127.getDuration());
    L151:
        if (r127 == null) goto L153;
        long r134 = (r125 / ((long) 1000)) - r127.getStartTime();
    L154:
        StringBuilder r135 = new StringBuilder("blue team duration ");
        r135.append(r133);
        r135.append(", start time ");
        if (r127 == null) goto L157;
        Long r136 = Long.valueOf(r127.getStartTime());
    L158:
        r135.append(r136);
        r135.append(" current time ");
        r135.append(r125);
        r135.append(" diff ");
        r135.append(r134);
        ALogger.i("TeamFightPKProgressLayout", r135.toString());
        if (r127 != null) goto L161;
    L174:
        com.bytedance.android.live.liveinteract.multiscene.a r137 = r210;
    L176:
        if (r211 == false) goto L290;
        j r138 = li0.d.i(r210);
        if (r138 == null) goto L180;
        com.bytedance.android.live.liveinteract.multiscene.k.b(r138);
    L180:
        String r139 = this.f78220j.f();
        Intrinsics.checkNotNullParameter(r137, "$this$isTeamFightInfo");
        if (r210.getFightType() != 1) goto L183;
        boolean r140 = true;
    L184:
        long r141 = -1;
        if (r140 == false) goto L199;
        Long r142 = r210.getWinTeamId();
        if (r142 != null) goto L190;
    L192:
        long r143 = 2;
        if (r142 != null) goto L196;
    L198:
        r139 = this.f78220j.f();
    L220:
        String r144 = this.f78220j.f();
        Intrinsics.checkNotNullParameter(r137, "$this$isTeamFightInfo");
        boolean r145 = true;
        if (r210.getFightType() != 1) goto L223;
        boolean r146 = true;
    L224:
        if (r146 == false) goto L238;
        Long r147 = r210.getWinTeamId();
        if (r147 != null) goto L229;
    L231:
        long r148 = 2;
        if (r147 != null) goto L235;
    L237:
        r144 = this.f78220j.f();
    L258:
        this.f78225o.setVisibility(0);
        this.f78228r.setVisibility(0);
        r1.b(this.f78225o, r139);
        r1.b(this.f78228r, r144);
        if (r212 == false) goto L268;
        TeamFightProgressBar r149 = this.f78235y;
        r149.f78260k = this.f78213c;
        r149.invalidate();
        Long r150 = r210.getWinTeamId();
        long r151 = 2;
        if (r150 != null) goto L264;
    L266:
        this.f78229s.setVisibility(0);
        int r152 = 8;
        this.f78230t.setVisibility(8);
        a1.m(this.f78229s, this.f78213c + s1.f(2.0f));
    L267:
        this.f78223m.setVisibility(r152);
        this.f78226p.setVisibility(r152);
    L283:
        Disposable r153 = this.D;
        if (r153 == null) goto L286;
        r153.dispose();
    L286:
        Disposable r154 = this.C;
        if (r154 == null) goto L291;
        r154.dispose();
        return;
    L291:
        return;
    L264:
        if (r150.longValue() != r151) goto L266;
        this.f78229s.setVisibility(8);
        this.f78230t.setVisibility(0);
        a1.n(this.f78230t, this.f78213c + s1.f(2.0f));
        r152 = 8;
        goto L267
    L268:
        Long r155 = r210.getWinTeamId();
        if (r155 != null) goto L272;
    L274:
        long r156 = 2;
        if (r155 != null) goto L278;
    L281:
        int r157 = this.f78213c;
    L282:
        TeamFightProgressBar r158 = this.f78235y;
        r158.f78260k = r157;
        r158.invalidate();
        a1.m(this.f78223m, this.f78213c);
        a1.n(this.f78226p, this.f78213c);
        this.f78223m.setVisibility(0);
        this.f78226p.setVisibility(0);
        this.f78229s.setVisibility(8);
        this.f78230t.setVisibility(8);
        goto L283
    L278:
        if (r155.longValue() != r156) goto L281;
        int r159 = this.f78213c + li0.d.h(this.f78223m);
        int r160 = s1.f(9.0f);
    L280:
        r157 = r159 + r160;
        goto L282
    L272:
        if (r155.longValue() != 1) goto L274;
        r159 = this.f78213c + li0.d.h(this.f78226p);
        r160 = s1.f(9.0f);
        goto L280
    L235:
        if (r147.longValue() != r148) goto L237;
        r144 = this.f78220j.g();
        goto L258
    L229:
        if (r147.longValue() != 1) goto L231;
        r144 = this.f78220j.b();
        goto L258
    L238:
        Intrinsics.checkNotNullParameter(r137, "$this$isLinkRoomFightInfo");
        if (r210.getFightType() == 2) goto L242;
        r145 = false;
    L242:
        if (r145 == false) goto L258;
        j r161 = li0.d.a(r210);
        if (r161 == null) goto L246;
        r141 = r161.getTeamId();
    L246:
        Long r162 = r210.getWinTeamId();
        long r163 = je0.d.a0();
        if (r162 != null) goto L250;
    L252:
        if (r162 != null) goto L255;
    L257:
        r144 = this.f78220j.f();
        goto L258
    L255:
        if (r162.longValue() != r141) goto L257;
        r144 = this.f78220j.g();
        goto L258
    L250:
        if (r162.longValue() != r163) goto L252;
        r144 = this.f78220j.b();
        goto L258
    L223:
        r146 = false;
        goto L224
    L196:
        if (r142.longValue() != r143) goto L198;
        r139 = this.f78220j.b();
        goto L220
    L190:
        if (r142.longValue() != 1) goto L192;
        r139 = this.f78220j.g();
        goto L220
    L199:
        Intrinsics.checkNotNullParameter(r137, "$this$isLinkRoomFightInfo");
        if (r210.getFightType() != 2) goto L202;
        boolean r164 = true;
    L203:
        if (r164 == false) goto L220;
        j r165 = li0.d.a(r210);
        if (r165 == null) goto L207;
        long r166 = r165.getTeamId();
    L208:
        Long r167 = r210.getWinTeamId();
        long r168 = je0.d.a0();
        if (r167 != null) goto L212;
    L214:
        if (r167 != null) goto L217;
    L219:
        r139 = this.f78220j.f();
        goto L220
    L217:
        if (r167.longValue() != r166) goto L219;
        r139 = this.f78220j.b();
        goto L220
    L212:
        if (r167.longValue() != r168) goto L214;
        r139 = this.f78220j.g();
        goto L220
    L207:
        r166 = -1;
        goto L208
    L202:
        r164 = false;
        goto L203
    L183:
        r140 = false;
        goto L184
    L290:
        return;
    L161:
        if (r134 < 0) goto L174;
        if (r133 == null) goto L164;
        long r169 = r133.longValue();
    L166:
        if (r134 > r169) goto L174;
        Disposable r170 = this.D;
        if (r170 != null) goto L170;
    L171:
        if (r133 == null) goto L173;
        r129 = r133.longValue();
    L173:
        r137 = r210;
        this.D = d(r129 - r134, TimeUnit.SECONDS).doFinally(new e(this)).subscribe(new f(this, r127, r137), g.f78247a);
        goto L176
    L170:
        if (r170.isDisposed() != true) goto L174;
    L164:
        r169 = 0;
        goto L166
    L157:
        r136 = null;
        goto L158
    L153:
        r134 = 0;
        goto L154
    L150:
        r133 = null;
        goto L151
    L131:
        if (r130 < 0) goto L147;
        if (r128 == 0) goto L134;
        long r213 = r128.longValue();
    L136:
        if (r130 > r213) goto L147;
        Disposable r171 = this.C;
        if (r171 == null) goto L142;
        r212 = r106;
        if (r171.isDisposed() != true) goto L148;
    L143:
        if (r128 == 0) goto L145;
        long r214 = r128.longValue();
    L146:
        this.C = d(r214 - r130, TimeUnit.SECONDS).doFinally(new b(this)).subscribe(new c(this, r126, r210), d.f78242a);
        goto L148
    L145:
        r214 = 0;
        goto L146
    L142:
        r212 = r106;
        goto L143
    L134:
        r213 = 0;
        goto L136
    L127:
        r132 = null;
        goto L128
    L123:
        r130 = 0;
        goto L124
    L119:
        r128 = r117;
        goto L120
    L116:
        r127 = r117;
        goto L117
    L113:
        r126 = r117;
        goto L114
    L175:
        r212 = r106;
        r137 = r210;
        goto L176
    L88:
        r121 = r117;
        goto L89
    L84:
        r120 = r117;
        goto L85
    L68:
        r117 = null;
        this.f78229s.setText(r116);
        this.f78230t.setText(null);
    L46:
        r108 = this.f78229s.getText().toString();
        goto L47
    L37:
        if (r114.longValue() != r107) goto L43;
        if (r113 == null) goto L41;
        String r172 = r113.getScoreFuzzy();
        if (r172 == null) goto L41;
    L42:
        r109 = TuplesKt.to(2, r172);
    L41:
        r172 = this.f78230t.getText().toString();
        goto L42
    L48:
        if (r112 == null) goto L53;
        if (r113 == null) goto L53;
        if (r112.getScore() >= r113.getScore()) goto L53;
        boolean r173 = true;
    L54:
        if (r173 == false) goto L60;
        if (r113 == null) goto L58;
        String r174 = r113.getScoreFuzzy();
        if (r174 == null) goto L58;
    L59:
        r109 = TuplesKt.to(2, r174);
    L58:
        r174 = this.f78230t.getText().toString();
        goto L59
    L60:
        if (r112 == null) goto L63;
        String r175 = r112.getScoreFuzzy();
        if (r175 == null) goto L63;
    L64:
        r109 = TuplesKt.to(1, r175);
    L63:
        r175 = this.f78229s.getText().toString();
    L53:
        r173 = false;
        goto L54
    L80:
        r117 = null;
        this.f78217g = false;
        goto L81
    L7:
        r102 = false;
    L29:
        r106 = false;
        goto L30
    }

    public final void g(int r100, int r101, boolean r102) {
        if (r100 != 0) goto L5;
        if (r101 != 0) goto L5;
        return;
    L5:
        this.A.setVisibility(8);
        this.B.setVisibility(0);
        if ((r100 / (r100 + r101)) <= 0.65f) goto L15;
        AnimationState r103 = this.f78216f;
        AnimationState r104 = AnimationState.STRONG;
        if (r103 != r104) goto L11;
        if (r102 == true) goto L11;
    L23:
        this.f78214d = r100;
        this.f78215e = r101;
        return;
    L11:
        if (this.f78218h == false) goto L13;
        r1.a(this.B, this.f78220j.e(), Boolean.valueOf(c()));
    L14:
        this.f78216f = r104;
        goto L23
    L13:
        r1.a(this.B, li0.c.b(), Boolean.valueOf(c()));
        goto L14
    L15:
        AnimationState r105 = this.f78216f;
        AnimationState r106 = AnimationState.WEAK;
        if (r105 != r106) goto L19;
        if (r102 == false) goto L23;
    L19:
        if (this.f78218h == false) goto L21;
        r1.a(this.B, this.f78220j.e(), Boolean.valueOf(c()));
    L22:
        this.f78216f = r106;
        goto L23
    L21:
        r1.a(this.B, li0.c.b(), Boolean.valueOf(c()));
        goto L22
    }

    public final void h(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "fuzzyValue");
        boolean r103 = false;
        g(r100, this.f78235y.getRightValue(), false);
        k(true, r101, r102);
        if (this.f78235y.getLeftValue() == r100) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L18:
        this.f78235y.setLeftValue(r100);
        return;
    L8:
        if (this.f78218h == false) goto L18;
        if (this.f78219i == true) goto L18;
        com.bytedance.android.live.liveinteract.multiscene.a r105 = this.E;
        if (r105 == null) goto L18;
        Intrinsics.checkNotNullParameter(r105, "$this$isTeamFightInfo");
        if (r105.getFightType() != 1) goto L16;
        r103 = true;
    L16:
        if (r103 == true) goto L18;
        this.f78219i = true;
        UtilityKotlinExtentionsKt.w(this.f78236z);
        a1.p(this.f78236z, RangesKt.coerceAtMost(s1.y() - this.f78235y.f78262m, (int) (s1.y() * this.f78235y.getProgress())));
        this.f78236z.setTranslationX(this.B.getRight() - a1.i(this.f78236z));
        r1.a(this.f78236z, this.f78220j.d(), Boolean.valueOf(c()));
        this.f78221k.add(Observable.timer(3, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.revenue.fight.view.c(this)));
        goto L18
    L5:
        r104 = false;
        goto L6
    }

    public final void i(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "fuzzyValue");
        g(this.f78235y.getLeftValue(), r100, false);
        k(false, r101, r102);
        this.f78235y.setRightValue(r100);
    }

    public final void k(boolean r100, String r101, String r102) {
        if (r100 == false) goto L17;
        this.f78223m.setText(r101);
        this.f78223m.setVisibility(0);
        if (r102 != null) goto L7;
    L16:
        UtilityKotlinExtentionsKt.t(this.f78224n);
        this.f78235y.b(0);
        return;
    L7:
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L16;
        UtilityKotlinExtentionsKt.w(this.f78224n);
        this.f78224n.setText(r102);
        if (this.f78218h == false) goto L14;
        int r104 = UtilityKotlinExtentionsKt.i(36);
    L15:
        this.f78235y.b((li0.d.h(this.f78223m) + li0.d.h(this.f78224n)) + r104);
        return;
    L14:
        r104 = UtilityKotlinExtentionsKt.i(28);
        goto L15
    L9:
        r103 = false;
        goto L10
    L17:
        this.f78226p.setText(r101);
        this.f78226p.setVisibility(0);
        if (r102 != null) goto L20;
    L25:
        UtilityKotlinExtentionsKt.t(this.f78227q);
        this.f78235y.c(0);
        return;
    L20:
        if (r102.length() <= 0) goto L22;
        boolean r105 = true;
    L23:
        if (r105 != true) goto L25;
        UtilityKotlinExtentionsKt.w(this.f78227q);
        this.f78227q.setText(r102);
        this.f78235y.c((li0.d.h(this.f78226p) + li0.d.h(this.f78227q)) + UtilityKotlinExtentionsKt.i(28));
        return;
    L22:
        r105 = false;
        goto L23
    }
}
