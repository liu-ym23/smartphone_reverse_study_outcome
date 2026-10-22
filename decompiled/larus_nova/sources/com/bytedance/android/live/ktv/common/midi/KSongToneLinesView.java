package com.bytedance.android.live.ktv.common.midi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\tB'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/KSongToneLinesView;", "Landroid/view/View;", "Landroid/graphics/Paint;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getLinePaint", "()Landroid/graphics/Paint;", "linePaint", "Landroid/graphics/Path;", "b", "getLinePath", "()Landroid/graphics/Path;", "linePath", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KSongToneLinesView extends View {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f69730r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f69731s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f69732t = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f69733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f69734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Path, Paint> f69735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f69736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f69737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f69738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f69739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f69740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f69741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f69742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f69743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f69744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f69745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f69746n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Pair<String, String> f69747o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f69748p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f69749q;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f69750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69751b;

        public b() {
        }
    }

    public KSongToneLinesView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KSongToneLinesView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getLinePaint() {
        return (Paint) this.f69733a.getValue();
    }

    private final Path getLinePath() {
        return (Path) this.f69734b.getValue();
    }

    static {
        f69730r = ColorProtector.parseColor("#FF4BE8");
        f69731s = ColorProtector.parseColor("#FF386B");
        f69732t = s1.f(4.0f);
    }

    public final void b() {
        if ((!((LinkedHashMap) this.f69735c).keySet().isEmpty()) == false) goto L11;
        Iterator r100 = ((LinkedHashMap) this.f69735c).keySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((Path) r100.next()).reset();
        goto L6
    L8:
        ((LinkedHashMap) this.f69735c).clear();
        return;
    }

    public final void a() {
        getLinePath().reset();
        b();
        setWillNotDraw(false);
        requestLayout();
    }

    public final int f(int r100) {
        int r101 = this.f69740h;
        if (r100 >= r101) goto L12;
        int r102 = this.f69739g;
        if (r100 != r102) goto L9;
        int r103 = this.f69748p;
        int r104 = this.f69746n;
    L13:
        return r103 + r104;
    L9:
        if (r100 < r102) goto L14;
        r103 = (int) (this.f69745m * (r101 - r100));
        r104 = this.f69748p;
        goto L13
    L14:
        return this.f69749q;
    L12:
        return this.f69748p;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawPath(getLinePath(), getLinePaint());
        if ((!this.f69735c.isEmpty()) == false) goto L8;
        Iterator r101 = ((LinkedHashMap) this.f69735c).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Map.Entry r102 = (Map.Entry) r101.next();
        r100.drawPath((Path) r102.getKey(), (Paint) r102.getValue());
        goto L6
    L10:
        return;
    }

    public final void c(cb0.a r110, long r111) {
        b r100 = this.f69743k;
        Long r101 = Long.valueOf(r110.f22988a - r111);
        boolean r102 = true;
        int r103 = 0;
        if (r101.longValue() <= 0) goto L5;
        boolean r104 = true;
    L6:
        Long r105 = null;
        if (r104 == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L12;
        int r106 = (int) (r101.longValue() * this.f69744l);
    L13:
        r100.f69750a = r106;
        b r107 = this.f69743k;
        Long r112 = Long.valueOf(r110.f22989b - r111);
        if (r112.longValue() > 0) goto L17;
        r102 = false;
    L17:
        if (r102 == false) goto L19;
        r105 = r112;
    L19:
        if (r105 == null) goto L21;
        r103 = (int) (r105.longValue() * this.f69744l);
    L21:
        r107.f69751b = r103;
        return;
    L12:
        r106 = 0;
        goto L13
    L5:
        r104 = false;
        goto L6
    }

    public final void d(long r110, List<cb0.c> r111) {
        Intrinsics.checkNotNullParameter(r111, "list");
        if (this.f69742j <= 0) goto L48;
        long r100 = r110 - this.f69741i;
        getLinePath().reset();
        b();
        Iterator<cb0.c> r101 = r111.iterator();
    L7:
        if (r101.hasNext() == false) goto L48;
        cb0.c r102 = r101.next();
        c(r102.f22991a, r100);
        int r103 = f(r102.f22992b);
        b r104 = this.f69743k;
        if (r104.f69750a >= r104.f69751b) goto L12;
        float r105 = r103;
        getLinePath().moveTo(this.f69743k.f69750a, r105);
        getLinePath().lineTo(this.f69743k.f69751b, r105);
    L12:
        if (r102.f22991a.f22988a > (r110 - ((long) this.f69738f))) goto L7;
        List<cb0.a> r106 = r102.f22993c;
        if (r106 == null) goto L7;
        Path r107 = new Path();
        Iterator<T> r108 = r106.iterator();
        float r109 = 0.0f;
        float r112 = 0.0f;
    L18:
        if (r108.hasNext() == false) goto L25;
        c((cb0.a) r108.next(), r100);
        if (r109 != 0.0f) goto L22;
        r109 = this.f69743k.f69750a;
    L22:
        r112 = Math.max(this.f69743k.f69751b, r112);
        b r113 = this.f69743k;
        int r114 = r113.f69750a;
        if (r114 >= r113.f69751b) goto L18;
        float r115 = r114;
        float r116 = r103;
        r107.moveTo(r115, r116);
        r107.lineTo(this.f69743k.f69751b, r116);
        goto L18
    L25:
        Map<Path, Paint> r117 = this.f69735c;
        float r118 = r103;
        Paint r119 = new Paint(1);
        r119.setStyle(Paint.Style.STROKE);
        r119.setStrokeCap(Paint.Cap.ROUND);
        r119.setStrokeWidth(s1.f(4.0f));
        Pair<String, String> r120 = this.f69747o;
        String r121 = null;
        if (r120 == null) goto L28;
        String r122 = r120.getFirst();
    L30:
        if (TextUtils.isEmpty(r122) == true) goto L35;
        Pair<String, String> r123 = this.f69747o;
        if (r123 == null) goto L34;
        String r124 = r123.getFirst();
    L36:
        int r125 = ColorProtector.parseColor(r124);
        Pair<String, String> r126 = this.f69747o;
        if (r126 == null) goto L39;
        String r127 = r126.getSecond();
    L41:
        if (TextUtils.isEmpty(r127) == true) goto L46;
        Pair<String, String> r128 = this.f69747o;
        if (r128 == null) goto L45;
        r121 = r128.getSecond();
    L45:
        int r129 = ColorProtector.parseColor(r121);
    L47:
        r119.setShader(new LinearGradient(r109, r118, r112, r118, r125, r129, Shader.TileMode.CLAMP));
        r117.put(r107, r119);
        goto L7
    L46:
        r129 = ColorProtector.parseColor("#FF386B");
        goto L47
    L39:
        r127 = null;
        goto L41
    L34:
        r124 = null;
        goto L36
    L35:
        r124 = "#FF4BE8";
        goto L36
    L28:
        r122 = null;
    L48:
        postInvalidate();
    }

    public final void e(long r100, long r101) {
        this.f69741i = r100;
        long r102 = r100 + r101;
        this.f69742j = r102;
        float r103 = this.f69736d / r102;
        this.f69744l = r103;
        this.f69738f = (int) (this.f69737e / r103);
    }

    public KSongToneLinesView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f69733a = InfraKotlinExtsKt.mainThreadLazy(KSongToneLinesView$linePaint$2.INSTANCE);
        this.f69734b = InfraKotlinExtsKt.mainThreadLazy(KSongToneLinesView$linePath$2.INSTANCE);
        this.f69735c = new LinkedHashMap();
        this.f69736d = s1.y();
        this.f69737e = s1.f(7.0f);
        this.f69739g = 58;
        this.f69740h = 90;
        this.f69741i = 1180;
        this.f69742j = 5900;
        this.f69743k = new b();
        this.f69746n = s1.f(40.0f);
        new Pair(Integer.valueOf(f69730r), Integer.valueOf(f69731s));
        this.f69748p = s1.f(5.0f);
        this.f69749q = this.f69746n + s1.f(5.0f);
    }

    public /* synthetic */ KSongToneLinesView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
