package c19;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c19.b f22075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f22078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f22079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f22080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f22082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C0388c f22083i;

    public static final class a {
        public static int b(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "hex");
            String r102 = StringsKt.removePrefix(r100, "#");
            int r103 = CastIntegerProtector.parseInt(r102.substring(0, 2), CharsKt.checkRadix(16));
            int r104 = CastIntegerProtector.parseInt(r102.substring(2, 4), CharsKt.checkRadix(16));
            int r105 = CastIntegerProtector.parseInt(r102.substring(4, 6), CharsKt.checkRadix(16));
            return Color.argb((int) (RangesKt.coerceIn(r101, 0.0f, 1.0f) * 255.0f), r103, r104, r105);
        }

        public static float[] a(float[] r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "m");
            if (r100.length != 6) goto L6;
            return new float[]{((r100[0] * r101) + (r100[2] * r102)) + r100[4], ((r100[1] * r101) + (r100[3] * r102)) + r100[5]};
        L6:
            return new float[]{r101, r102};
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f22084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f22085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Path> f22086c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Path r100, Paint r101, List<? extends Path> r102) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, "paint");
            Intrinsics.checkNotNullParameter(r102, "clips");
            this.f22084a = r100;
            this.f22085b = r101;
            this.f22086c = r102;
        }
    }

    /* JADX INFO: renamed from: c19.c$c, reason: collision with other inner class name */
    public static final class C0388c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f22087a;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            c r100 = this.f22087a;
            return new c(r100.f22075a, r100.f22076b, r100.f22077c, r100.f22078d);
        }

        public C0388c(c r100) {
            this.f22087a = r100;
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        b r100 = (b) CollectionsKt.firstOrNull(this.f22079e);
        if (r100 == null) goto L7;
        Paint r101 = r100.f22085b;
        if (r101 == null) goto L7;
        return r101.getColorFilter();
    L7:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f22081g;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f22083i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f22077c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f22077c;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f22082h;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Rect r101 = getBounds();
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        int r102 = r100.save();
        r100.translate(r101.left, r101.top);
        r100.scale(r101.width() / 24.0f, r101.height() / 24.0f);
        if (this.f22082h == false) goto L18;
        boolean r103 = true;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        if (getLayoutDirection() == 1) goto L16;
    L15:
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        r100.translate(24.0f, 0.0f);
        r100.scale(-1.0f, 1.0f);
        goto L18
    L13:
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L15;
    L18:
        Iterator r104 = ((ArrayList) this.f22079e).iterator();
    L20:
        if (r104.hasNext() == false) goto L29;
        b r105 = (b) r104.next();
        if (r105.f22086c.isEmpty() == true) goto L23;
        int r106 = r100.save();
        Iterator<Path> r107 = r105.f22086c.iterator();
    L26:
        if (r107.hasNext() == false) goto L28;
        r100.clipPath(r107.next());
        goto L26
    L28:
        r100.drawPath(r105.f22084a, r105.f22085b);
        r100.restoreToCount(r106);
        goto L20
    L23:
        r100.drawPath(r105.f22084a, r105.f22085b);
        goto L20
    L29:
        r100.restoreToCount(r102);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int r100) {
        return this.f22082h;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        int r101 = 0;
        int r102 = RangesKt.coerceIn(r100, 0, 255);
        if (r102 != this.f22081g) goto L5;
        return;
    L5:
        this.f22081g = r102;
        int r103 = this.f22079e.size();
    L6:
        if (r101 >= r103) goto L8;
        ((b) ListProtector.get(this.f22079e, r101)).f22085b.setAlpha((this.f22080f[r101] * r102) / 255);
        r101 = r101 + 1;
        goto L6
    L8:
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L8:
        if (r101 != this.f22082h) goto L10;
        return;
    L10:
        this.f22082h = r101;
        invalidateSelf();
        return;
    L4:
        if (this.f22078d == false) goto L6;
        r101 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        Iterator r101 = ((ArrayList) this.f22079e).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).f22085b.setColorFilter(r100);
        goto L4
    L6:
        invalidateSelf();
    }

    public c(c19.b r210, int r211, int r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, SocialConstants.PARAM_APP_DESC);
        this.f22075a = r210;
        this.f22076b = r211;
        this.f22077c = r212;
        this.f22078d = r213;
        List<h> r100 = r210.f22074a;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        int r103 = 0;
        if (r102.hasNext() == false) goto L39;
        h r104 = (h) r102.next();
        ArrayList r105 = new ArrayList(2);
        d r106 = r104.f22103b;
        if (r106 == null) goto L38;
        Path r107 = r104.f22102a;
        int r110 = this.f22076b;
        Intrinsics.checkNotNullParameter(r106, LynxVideoManagerLite.FILL);
        Paint r111 = new Paint(1);
        r111.setStyle(Paint.Style.FILL);
        Intrinsics.checkNotNullParameter(r111, "paint");
        Intrinsics.checkNotNullParameter(r106, LynxVideoManagerLite.FILL);
        if ((r106 instanceof d.C0389d) == false) goto L11;
        r111.setColor(Color.argb((int) (Color.alpha(r110) * RangesKt.coerceIn(((d.C0389d) r106).f22097a, 0.0f, 1.0f)), Color.red(r110), Color.green(r110), Color.blue(r110)));
    L31:
        r105.add(new b(r107, r111, r104.f22104c));
        goto L38
    L11:
        if ((r106 instanceof d.c) == false) goto L14;
        d.c r108 = (d.c) r106;
        r111.setColor(a.b(r108.f22095a, r108.f22096b));
        goto L31
    L14:
        if ((r106 instanceof d.a) == false) goto L33;
        d.a r109 = (d.a) r106;
        if (r109.f22093f.size() >= 2) goto L22;
        List<j> r112 = r109.f22093f;
        float r113 = r109.f22094g;
        Intrinsics.checkNotNullParameter(r112, "stops");
        if (r112.isEmpty() == true) goto L21;
        r110 = a.b(((j) ListProtector.get(r112, 0)).f22106b, ((j) ListProtector.get(r112, 0)).f22107c * r113);
    L21:
        r111.setColor(r110);
        goto L31
    L22:
        float[] r114 = a.a(r109.f22092e, r109.f22088a, r109.f22089b);
        float[] r115 = a.a(r109.f22092e, r109.f22090c, r109.f22091d);
        float r116 = r114[0];
        float r117 = r114[1];
        float r118 = r115[0];
        float r119 = r115[1];
        List<j> r120 = r109.f22093f;
        float r121 = r109.f22094g;
        Intrinsics.checkNotNullParameter(r120, "stops");
        List<j> r122 = r120;
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator<T> r124 = r122.iterator();
    L24:
        if (r124.hasNext() == false) goto L26;
        j r125 = (j) r124.next();
        r123.add(Integer.valueOf(a.b(r125.f22106b, r125.f22107c * r121)));
        goto L24
    L26:
        int[] r214 = CollectionsKt.toIntArray(r123);
        List<j> r126 = r109.f22093f;
        Intrinsics.checkNotNullParameter(r126, "stops");
        List<j> r127 = r126;
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator<T> r129 = r127.iterator();
    L28:
        if (r129.hasNext() == false) goto L30;
        r128.add(Float.valueOf(((j) r129.next()).f22105a));
        goto L28
    L30:
        r111.setShader(new LinearGradient(r116, r117, r118, r119, r214, CollectionsKt.toFloatArray(r128), Shader.TileMode.CLAMP));
        goto L31
    L33:
        if ((r106 instanceof d.b) == false) goto L37;
        d.b r130 = (d.b) r106;
        throw null;
    L37:
        throw new NoWhenBranchMatchedException();
    L38:
        CollectionsKt.addAll(r101, r105);
        goto L3
    L39:
        this.f22079e = r101;
        int r131 = r101.size();
        int[] r132 = new int[r131];
    L40:
        if (r103 >= r131) goto L42;
        r132[r103] = ((b) ListProtector.get(this.f22079e, r103)).f22085b.getAlpha();
        r103 = r103 + 1;
        goto L40
    L42:
        this.f22080f = r132;
        this.f22081g = 255;
        this.f22082h = this.f22078d;
        this.f22083i = new C0388c(this);
    }
}
