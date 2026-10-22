package com.bytedance.android.live.soloktv.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.soloktv.viewmodel.PracticeSongViewModel;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\nH\u0002R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/FragmentSelectView;", "Landroid/widget/FrameLayout;", "", "getSelectStartIndex", "getSelectEndIndex", "", "getSelectStartTime", "getSelectEndTime", "Lcom/bytedance/android/live/soloktv/view/SegmentSelectResult;", "getSelectResult", "", "getLastLineBottom", "Lkotlin/Function0;", "", "s", "Lkotlin/jvm/functions/Function0;", "getSegmentChangeCallback", "()Lkotlin/jvm/functions/Function0;", "setSegmentChangeCallback", "(Lkotlin/jvm/functions/Function0;)V", "segmentChangeCallback", "Lfd2/l;", "t", "Lkotlin/Lazy;", "getLyricService", "()Lfd2/l;", "lyricService", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FragmentSelectView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f101671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f101672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f101673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f101674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f101675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f101676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NotInterceptMoveNestedScrollView f101677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f101678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f101679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f101680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f101681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f101682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ScrollLyricConfigV2 f101683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f101684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SimpleDateFormat f101685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f101686p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f101687q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f101688r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function0<Unit> f101689s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f101690t;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f101691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f101692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentSelectView f101693c;

        public a(FragmentSelectView r100) {
            this.f101693c = r100;
            this.f101692b = new RectF();
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            Intrinsics.checkNotNullParameter(r101, "event");
            int r102 = r101.getAction() & 255;
            if (r102 != 0) goto L5;
            cb1.a.N("choose_end_time");
            this.f101691a = r101.getY();
        L66:
            return true;
        L5:
            if (r102 != 1) goto L7;
        L41:
            FragmentSelectView r103 = this.f101693c;
            RectF r104 = r103.f101686p;
            float r105 = r103.f101680j;
            float r106 = r103.f101682l;
            r104.top = r105 * r106;
            r104.bottom = r103.f101681k * r106;
            float r107 = r104.height();
            FragmentSelectView r108 = this.f101693c;
            float r109 = r108.f101682l;
            if (r107 >= r109) goto L44;
            r108.f101686p.top -= r109 - r107;
        L44:
            FragmentSelectView.c(r108);
            FragmentSelectView r110 = this.f101693c;
            NotInterceptMoveNestedScrollView r111 = r110.f101677g;
            if (r111 == null) goto L47;
            int r112 = r111.getmScrollY();
        L48:
            NotInterceptMoveNestedScrollView r113 = r110.f101677g;
            if (r113 == null) goto L51;
            int r114 = r113.getPaddingTop();
        L52:
            float r115 = r114;
            float r116 = r112;
            float r117 = ((r110.f101686p.bottom + r110.f101684n) + r115) - r116;
            if (r117 < r110.getHeight()) goto L57;
            float r118 = r117 - r110.getHeight();
            NotInterceptMoveNestedScrollView r119 = r110.f101677g;
            if (r119 == null) goto L57;
            r119.smoothScrollBy(0, (int) r118);
        L57:
            float r120 = ((r110.f101686p.bottom - r110.f101684n) + r115) - r116;
            if (r120 >= 0) goto L62;
            NotInterceptMoveNestedScrollView r121 = r110.f101677g;
            if (r121 == null) goto L62;
            r121.smoothScrollBy(0, (int) r120);
        L62:
            Function0<Unit> r122 = this.f101693c.getSegmentChangeCallback();
            if (r122 == null) goto L66;
            Unit r123 = r122.invoke();
            goto L66
        L51:
            r114 = 0;
            goto L52
        L47:
            r112 = 0;
            goto L48
        L7:
            if (r102 != 2) goto L9;
            float r124 = r101.getY() - this.f101691a;
            this.f101692b.set(this.f101693c.f101686p);
            float r125 = this.f101692b.bottom;
            if ((r124 + r125) > FragmentSelectView.a(this.f101693c)) goto L66;
            RectF r126 = this.f101692b;
            r126.bottom = r124 + r126.bottom;
            float r127 = r126.height();
            FragmentSelectView r128 = this.f101693c;
            float r129 = r128.f101682l;
            if (r127 >= r129) goto L18;
            RectF r130 = this.f101692b;
            float r131 = r130.top - (r129 - r127);
            r130.top = r131;
            if (r131 < 0) goto L19;
            r128.f101686p.set(r130);
            FragmentSelectView.c(this.f101693c);
        L19:
            FragmentSelectView r132 = this.f101693c;
            float r133 = r132.f101686p.bottom;
            NotInterceptMoveNestedScrollView r134 = r132.f101677g;
            if (r134 == null) goto L22;
            int r135 = r134.getmScrollY();
        L23:
            NotInterceptMoveNestedScrollView r136 = r132.f101677g;
            if (r136 == null) goto L26;
            int r137 = r136.getPaddingTop();
        L27:
            float r138 = r132.f101684n;
            float r139 = r137;
            float r140 = (r133 + r138) + r139;
            float r141 = (r133 - r138) + r139;
            if (r133 <= r125) goto L35;
            float r142 = r140 - r135;
            if (r142 < r132.getHeight()) goto L35;
            float r143 = r142 - r132.getHeight();
            NotInterceptMoveNestedScrollView r144 = r132.f101677g;
            if (r144 == null) goto L66;
            r144.smoothScrollBy(0, (int) r143);
        L35:
            if (r133 >= r125) goto L66;
            float r145 = r141 - r135;
            if (r145 >= 0) goto L66;
            NotInterceptMoveNestedScrollView r146 = r132.f101677g;
            if (r146 == null) goto L66;
            r146.smoothScrollBy(0, (int) r145);
            goto L66
        L26:
            r137 = 0;
            goto L27
        L22:
            r135 = 0;
            goto L23
        L18:
            r128.f101686p.set(this.f101692b);
            FragmentSelectView.c(this.f101693c);
            goto L19
        L9:
            if (r102 == 3) goto L41;
            goto L41
        }
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f101694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f101695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentSelectView f101696c;

        public b(FragmentSelectView r100) {
            this.f101696c = r100;
            this.f101695b = new RectF();
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            int r101 = r110.getAction() & 255;
            if (r101 != 0) goto L5;
            this.f101694a = r110.getY();
            cb1.a.N("choose_start_time");
        L66:
            return true;
        L5:
            if (r101 != 1) goto L7;
        L41:
            FragmentSelectView r102 = this.f101696c;
            RectF r111 = r102.f101686p;
            float r103 = r102.f101680j;
            float r104 = r102.f101682l;
            r111.top = r103 * r104;
            r111.bottom = r102.f101681k * r104;
            float r105 = r111.height();
            FragmentSelectView r112 = this.f101696c;
            float r106 = r112.f101682l;
            if (r105 >= r106) goto L44;
            RectF r107 = r112.f101686p;
            r107.bottom = (r107.bottom + r106) - r105;
        L44:
            FragmentSelectView.c(r112);
            FragmentSelectView r108 = this.f101696c;
            NotInterceptMoveNestedScrollView r113 = r108.f101677g;
            if (r113 == null) goto L47;
            int r114 = r113.getmScrollY();
        L48:
            NotInterceptMoveNestedScrollView r109 = r108.f101677g;
            if (r109 == null) goto L51;
            int r115 = r109.getPaddingTop();
        L52:
            float r116 = r115;
            float r117 = r114;
            float r118 = ((r108.f101686p.top + r108.f101684n) + r116) - r117;
            if (r118 < r108.getHeight()) goto L57;
            float r119 = r118 - r108.getHeight();
            NotInterceptMoveNestedScrollView r120 = r108.f101677g;
            if (r120 == null) goto L57;
            r120.smoothScrollBy(0, (int) r119);
        L57:
            float r121 = ((r108.f101686p.top - r108.f101684n) + r116) - r117;
            if (r121 >= 0) goto L62;
            NotInterceptMoveNestedScrollView r122 = r108.f101677g;
            if (r122 == null) goto L62;
            r122.smoothScrollBy(0, (int) r121);
        L62:
            Function0<Unit> r123 = this.f101696c.getSegmentChangeCallback();
            if (r123 == null) goto L66;
            Unit r124 = r123.invoke();
            goto L66
        L51:
            r115 = 0;
            goto L52
        L47:
            r114 = 0;
            goto L48
        L7:
            if (r101 != 2) goto L9;
            float r125 = r110.getY() - this.f101694a;
            this.f101695b.set(this.f101696c.f101686p);
            RectF r126 = this.f101695b;
            float r127 = r126.top;
            float r128 = r125 + r127;
            float r129 = 0;
            if (r128 < r129) goto L66;
            r126.top = r128;
            float r130 = r126.height();
            FragmentSelectView r131 = this.f101696c;
            float r132 = r131.f101682l;
            if (r130 >= r132) goto L18;
            RectF r133 = this.f101695b;
            float r134 = (r133.bottom + r132) - r130;
            r133.bottom = r134;
            if (r134 > FragmentSelectView.a(r131)) goto L19;
            this.f101696c.f101686p.set(this.f101695b);
            FragmentSelectView.c(this.f101696c);
        L19:
            FragmentSelectView r135 = this.f101696c;
            float r136 = r135.f101686p.top;
            NotInterceptMoveNestedScrollView r137 = r135.f101677g;
            if (r137 == null) goto L22;
            int r138 = r137.getmScrollY();
        L23:
            NotInterceptMoveNestedScrollView r139 = r135.f101677g;
            if (r139 == null) goto L26;
            int r140 = r139.getPaddingTop();
        L27:
            float r141 = r140;
            float r142 = (r135.f101684n + r136) + r141;
            if (r136 <= r127) goto L34;
            float r143 = r142 - r138;
            if (r143 < r135.getHeight()) goto L34;
            float r144 = r143 - r135.getHeight();
            NotInterceptMoveNestedScrollView r145 = r135.f101677g;
            if (r145 == null) goto L34;
            r145.smoothScrollBy(0, (int) r144);
        L34:
            float r146 = (r136 - r135.f101684n) + r141;
            if (r136 >= r127) goto L66;
            float r147 = r146 - r138;
            if (r147 >= r129) goto L66;
            NotInterceptMoveNestedScrollView r148 = r135.f101677g;
            if (r148 == null) goto L66;
            r148.smoothScrollBy(0, (int) r147);
            goto L66
        L26:
            r140 = 0;
            goto L27
        L22:
            r138 = 0;
            goto L23
        L18:
            r131.f101686p.set(this.f101695b);
            FragmentSelectView.c(this.f101696c);
            goto L19
        L9:
            if (r101 == 3) goto L41;
            goto L41
        }
    }

    private final fd2.l getLyricService() {
        return (fd2.l) this.f101690t.getValue();
    }

    private final float getLastLineBottom() {
        fd2.l r100 = getLyricService();
        if (r100 == null) goto L5;
        int r101 = r100.h();
    L7:
        return r101 * this.f101682l;
    L5:
        r101 = 0;
        goto L7
    }

    public final SegmentSelectResult getSelectResult() {
        long r100 = getSelectStartTime();
        long r101 = getSelectEndTime();
        if (this.f101688r == false) goto L8;
        long r102 = r101 - r100;
        PracticeSongViewModel.b r103 = PracticeSongViewModel.Companion;
        r103.getClass();
        if (r102 <= PracticeSongViewModel.access$getDANGEROUS_COPYRIGHT_SONG_DURATION$cp()) goto L8;
        r103.getClass();
        r101 = ((long) PracticeSongViewModel.access$getDANGEROUS_COPYRIGHT_SONG_DURATION$cp()) + r100;
    L8:
        return new SegmentSelectResult(getSelectStartIndex(), getSelectEndIndex(), r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fd2.l r100 = getLyricService();
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    public final Function0<Unit> getSegmentChangeCallback() {
        return this.f101689s;
    }

    public final int getSelectEndIndex() {
        return this.f101681k;
    }

    public final long getSelectEndTime() {
        return this.f101679i;
    }

    public final int getSelectStartIndex() {
        return this.f101680j;
    }

    public final long getSelectStartTime() {
        return this.f101678h;
    }

    public FragmentSelectView(Context r100) {
        this(r100, null);
    }

    public static final /* synthetic */ float a(FragmentSelectView r100) {
        return r100.getLastLineBottom();
    }

    public static final /* synthetic */ fd2.l b(FragmentSelectView r100) {
        return r100.getLyricService();
    }

    public static final void c(FragmentSelectView r100) {
        RectF r101 = r100.f101686p;
        float r102 = r101.top;
        float r103 = r100.f101684n;
        float r104 = r102 - r103;
        float r105 = r101.bottom - r103;
        View r106 = r100.f101671a;
        if (r106 == null) goto L5;
        a1.o(r106, (int) r104);
    L5:
        View r107 = r100.f101672b;
        if (r107 == null) goto L8;
        a1.o(r107, (int) r105);
    L8:
        RectF r108 = r100.f101686p;
        float r109 = r108.top;
        float r110 = r100.f101682l;
        int r111 = (int) (r109 / r110);
        r100.f101680j = r111;
        float r112 = r110 / 2.0f;
        if ((r109 % r110) <= r112) goto L11;
        r100.f101680j = r111 + 1;
    L11:
        float r113 = r108.bottom;
        int r114 = (int) (r113 / r110);
        r100.f101681k = r114;
        if ((r113 % r110) <= r112) goto L14;
        r100.f101681k = r114 + 1;
    L14:
        fd2.l r115 = r100.getLyricService();
        long r116 = 0;
        if (r115 == null) goto L17;
        long r117 = r115.l(r100.f101680j);
    L18:
        r100.f101678h = r117;
        fd2.l r118 = r100.getLyricService();
        if (r118 == null) goto L21;
        r116 = r118.b(r100.f101681k - 1);
    L21:
        r100.f101679i = r116;
        r100.post(new l(r100));
        fd2.l r119 = r100.getLyricService();
        if (r119 == null) goto L25;
        r119.o(r100.f101686p, r100.f101687q);
        return;
    L25:
        return;
    L17:
        r117 = 0;
        goto L18
    }

    public final void setSegmentChangeCallback(Function0<Unit> r100) {
        this.f101689s = r100;
    }

    public FragmentSelectView(final Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        this.f101682l = UtilityKotlinExtentionsKt.h(44);
        ScrollLyricConfigV2 r112 = new ScrollLyricConfigV2();
        r112.a();
        Unit r100 = Unit.INSTANCE;
        this.f101683m = r112;
        this.f101685o = new SimpleDateFormat("mm:ss", Locale.US);
        this.f101686p = new RectF();
        this.f101687q = ColorProtector.parseColor("#19ffffff");
        b r113 = new b(this);
        a r101 = new a(this);
        this.f101690t = LazyKt.lazy(new FragmentSelectView$lyricService$2(this, r110));
        LayoutInflater.from(r110).inflate(R.layout.ttlive_solo_ktv_frag_select_view, this);
        float r114 = getResources().getDimension(R.dimen.ttlive_solo_ktv_segment_select_index_view_height) / 2.0f;
        this.f101684n = r114;
        View r102 = findViewById(R.id.start_index_content);
        this.f101671a = r102;
        View r103 = findViewById(R.id.end_index_content);
        this.f101672b = r103;
        this.f101673c = (TextView) findViewById(R.id.start_index_txt);
        this.f101674d = (TextView) findViewById(R.id.end_index_txt);
        this.f101675e = (ViewGroup) findViewById(R.id.lyrics_content);
        this.f101676f = findViewById(R.id.select_area_touch_view);
        NotInterceptMoveNestedScrollView r104 = (NotInterceptMoveNestedScrollView) findViewById(R.id.scroll_view);
        this.f101677g = r104;
        if (r104 == null) goto L5;
        int r105 = (int) r114;
        ((ArrayList) r104.f101752a).add(new NotInterceptMoveNestedScrollView.a(R.id.start_index_content, r105, r105));
    L5:
        if (r104 == null) goto L7;
        int r115 = (int) r114;
        ((ArrayList) r104.f101752a).add(new NotInterceptMoveNestedScrollView.a(R.id.end_index_content, r115, r115));
    L7:
        if (r102 == null) goto L9;
        r102.setOnTouchListener(r113);
    L9:
        if (r103 == null) goto L12;
        r103.setOnTouchListener(r101);
        return;
    }
}
