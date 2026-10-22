package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import i0.c;
import i0.r;
import java.util.List;
import n0.d;
import o0.b;

/* JADX INFO: loaded from: classes28.dex */
public final class ShapeStroke implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0.b f24835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<n0.b> f24836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0.a f24837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f24838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0.b f24839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LineCapType f24840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LineJoinType f24841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f24842i;

    public static final enum LineCapType extends Enum<LineCapType> {
        public static final LineCapType Butt = null;
        public static final LineCapType Round = null;
        public static final LineCapType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LineCapType[] f24843a = null;

        static {
            LineCapType r100 = new LineCapType("Butt", 0);
            Butt = r100;
            LineCapType r101 = new LineCapType("Round", 1);
            Round = r101;
            LineCapType r102 = new LineCapType("Unknown", 2);
            Unknown = r102;
            f24843a = new LineCapType[]{r100, r101, r102};
        }

        public static LineCapType[] values() {
            return (LineCapType[]) f24843a.clone();
        }

        public Paint.Cap toPaintCap() {
            int r100 = a.f24845a[ordinal()];
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return Paint.Cap.SQUARE;
        L9:
            return Paint.Cap.ROUND;
        L11:
            return Paint.Cap.BUTT;
        }

        public static LineCapType valueOf(String r100) {
            return (LineCapType) r27.a.a(LineCapType.class, r100);
        }

        public LineCapType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LineJoinType extends Enum<LineJoinType> {
        public static final LineJoinType Bevel = null;
        public static final LineJoinType Miter = null;
        public static final LineJoinType Round = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LineJoinType[] f24844a = null;

        static {
            LineJoinType r100 = new LineJoinType("Miter", 0);
            Miter = r100;
            LineJoinType r101 = new LineJoinType("Round", 1);
            Round = r101;
            LineJoinType r102 = new LineJoinType("Bevel", 2);
            Bevel = r102;
            f24844a = new LineJoinType[]{r100, r101, r102};
        }

        public static LineJoinType[] values() {
            return (LineJoinType[]) f24844a.clone();
        }

        public Paint.Join toPaintJoin() {
            int r100 = a.f24846b[ordinal()];
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return Paint.Join.ROUND;
        L13:
            return Paint.Join.MITER;
        L15:
            return Paint.Join.BEVEL;
        }

        public static LineJoinType valueOf(String r100) {
            return (LineJoinType) r27.a.a(LineJoinType.class, r100);
        }

        public LineJoinType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24845a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24846b = null;

        static {
            int[] r100 = new int[LineJoinType.values().length];
            f24846b = r100;
            r100[LineJoinType.Bevel.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            f24846b[LineJoinType.Miter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            f24846b[LineJoinType.Round.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r101 = new int[LineCapType.values().length];
            f24845a = r101;
            r101[LineCapType.Butt.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            f24845a[LineCapType.Round.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            f24845a[LineCapType.Unknown.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    @Override // o0.b
    public final c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        return new r(r100, r101, this);
    }

    public ShapeStroke(String r100, n0.b r101, List<n0.b> r102, n0.a r103, d r104, n0.b r105, LineCapType r106, LineJoinType r107, float r108) {
        this.f24834a = r100;
        this.f24835b = r101;
        this.f24836c = r102;
        this.f24837d = r103;
        this.f24838e = r104;
        this.f24839f = r105;
        this.f24840g = r106;
        this.f24841h = r107;
        this.f24842i = r108;
    }
}
