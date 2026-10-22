package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002/0B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010,B#\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010-\u001a\u00020\u0019¢\u0006\u0004\b(\u0010.R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000eR*\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010 \u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00198\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010$¨\u00061"}, d2 = {"Lcom/bytedance/android/gamecp/common/ui/CornerHoleHSImageView;", "Lcom/bytedance/android/gamecp/common/ui/HSImageView;", "Landroid/graphics/Path;", "b", "Lkotlin/Lazy;", "getDstPath", "()Landroid/graphics/Path;", "dstPath", "c", "getSrcPath", "srcPath", "Landroid/graphics/Paint;", "d", "getPathPaint", "()Landroid/graphics/Paint;", "pathPaint", "", "value", "e", FaceService.girlLabel, "getRadius", "()F", "setRadius", "(F)V", "radius", "", "f", "I", "getDirection", "()I", "setDirection", "(I)V", "direction", "Landroid/graphics/PorterDuffXfermode;", ce.f26395j, "getXFerMode", "()Landroid/graphics/PorterDuffXfermode;", "xFerMode", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Direction", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CornerHoleHSImageView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f56883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f56884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f56885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f56886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f56887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f56889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f56890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f56891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f56892j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/gamecp/common/ui/CornerHoleHSImageView$Direction;", "", UserProfileEvent.POSITION_NONE, "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Direction extends Enum<Direction> {
        public static final Direction BOTTOM_LEFT = null;
        public static final Direction BOTTOM_RIGHT = null;
        public static final Direction NONE = null;
        public static final Direction TOP_LEFT = null;
        public static final Direction TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f56893a = null;

        static {
            Direction r100 = new Direction(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Direction r101 = new Direction("TOP_LEFT", 1);
            TOP_LEFT = r101;
            Direction r102 = new Direction("TOP_RIGHT", 2);
            TOP_RIGHT = r102;
            Direction r103 = new Direction("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r103;
            Direction r104 = new Direction("BOTTOM_RIGHT", 4);
            BOTTOM_RIGHT = r104;
            f56893a = new Direction[]{r100, r101, r102, r103, r104};
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        public static Direction[] values() {
            return (Direction[]) f56893a.clone();
        }

        public Direction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.gamecp.common.ui.CornerHoleHSImageView$a$a, reason: collision with other inner class name */
        public static final class C0915a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int f56894a = 0;

            static {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int f56895a = 0;

            static {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int f56896a = 0;

            static {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int f56897a = 0;

            static {
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int f56898a = 0;

            static {
            }
        }
    }

    private final Path getDstPath() {
        return (Path) this.f56884b.getValue();
    }

    private final Paint getPathPaint() {
        return (Paint) this.f56886d.getValue();
    }

    private final Path getSrcPath() {
        return (Path) this.f56885c.getValue();
    }

    private final PorterDuffXfermode getXFerMode() {
        return (PorterDuffXfermode) this.f56892j.getValue();
    }

    public final void k() {
        setRadius(0.0f);
        setDirection(Direction.NONE.ordinal());
        postInvalidate();
    }

    public final int getDirection() {
        return this.f56888f;
    }

    public final float getRadius() {
        return this.f56887e;
    }

    public CornerHoleHSImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f56884b = LazyKt.lazy(CornerHoleHSImageView$dstPath$2.INSTANCE);
        this.f56885c = LazyKt.lazy(CornerHoleHSImageView$srcPath$2.INSTANCE);
        this.f56886d = LazyKt.lazy(CornerHoleHSImageView$pathPaint$2.INSTANCE);
        this.f56888f = Direction.NONE.ordinal();
        int r101 = a.c.f56896a;
        this.f56889g = 0;
        this.f56892j = LazyKt.lazy(CornerHoleHSImageView$xFerMode$2.INSTANCE);
    }

    public final void j(AttributeSet r100) {
        if (r100 == null) goto L5;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.align, R.attr.holeCenterXOffset, R.attr.holeCenterYOffset, R.attr.holeDirection, R.attr.holeRadius});
        setDirection(r101.getInt(3, Direction.NONE.ordinal()));
        int r102 = a.c.f56896a;
        this.f56889g = r101.getInt(0, 0);
        this.f56890h = r101.getDimension(1, 0.0f);
        this.f56891i = r101.getDimension(2, 0.0f);
        setRadius(r101.getDimension(4, 0.0f));
        r101.recycle();
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f56888f != Direction.NONE.ordinal()) goto L5;
    L12:
        super.onDraw(r100);
        return;
    L5:
        if (this.f56887e == 0.0f) goto L12;
        RectF r101 = this.f56883a;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rectF");
    L10:
        int r102 = r100.saveLayer(r101, getPathPaint());
        super.onDraw(r100);
        getPathPaint().setXfermode(getXFerMode());
        getSrcPath().op(getDstPath(), Path.Op.INTERSECT);
        r100.drawPath(getSrcPath(), getPathPaint());
        getPathPaint().setXfermode(null);
        r100.restoreToCount(r102);
    }

    public final void setDirection(int r100) {
        if (r100 >= Direction.NONE.ordinal()) goto L5;
        return;
    L5:
        if (r100 > Direction.BOTTOM_RIGHT.ordinal()) goto L10;
        this.f56888f = r100;
        f(getMeasuredWidth(), getMeasuredHeight());
        postInvalidate();
        return;
    }

    public final void setRadius(float r100) {
        this.f56887e = r100;
        f(getMeasuredWidth(), getMeasuredHeight());
        postInvalidate();
    }

    public CornerHoleHSImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f56884b = LazyKt.lazy(CornerHoleHSImageView$dstPath$2.INSTANCE);
        this.f56885c = LazyKt.lazy(CornerHoleHSImageView$srcPath$2.INSTANCE);
        this.f56886d = LazyKt.lazy(CornerHoleHSImageView$pathPaint$2.INSTANCE);
        this.f56888f = Direction.NONE.ordinal();
        int r102 = a.c.f56896a;
        this.f56889g = 0;
        this.f56892j = LazyKt.lazy(CornerHoleHSImageView$xFerMode$2.INSTANCE);
        j(r101);
    }

    public final void f(int r100, int r101) {
        if (this.f56887e != 0.0f) goto L5;
        return;
    L5:
        if (this.f56888f == Direction.NONE.ordinal()) goto L54;
        int r102 = this.f56889g;
        int r103 = this.f56888f;
        if (r103 != Direction.TOP_LEFT.ordinal()) goto L19;
        int r104 = a.e.f56898a;
        if ((r102 & 2) <= 0) goto L12;
        float r105 = this.f56887e + 0.0f;
    L13:
        int r106 = a.b.f56895a;
        if ((r102 & 1) <= 0) goto L17;
        float r107 = this.f56887e;
    L16:
        float r108 = r107 + 0.0f;
    L45:
        float r109 = this.f56890h;
        if (r109 == 0.0f) goto L48;
        r108 = r108 + r109;
    L48:
        float r110 = this.f56891i;
        if (r110 == 0.0f) goto L51;
        r105 = r105 + r110;
    L51:
        getDstPath().addCircle(r108, r105, this.f56887e, Path.Direction.CW);
        return;
    L17:
        r108 = 0.0f;
        goto L45
    L12:
        r105 = 0.0f;
        goto L13
    L19:
        if (r103 != Direction.TOP_RIGHT.ordinal()) goto L28;
        r108 = r100;
        int r111 = a.e.f56898a;
        if ((r102 & 2) <= 0) goto L23;
        r105 = this.f56887e + 0.0f;
    L24:
        int r112 = a.d.f56897a;
        if ((r102 & 4) <= 0) goto L45;
        r108 = r108 - this.f56887e;
        goto L45
    L23:
        r105 = 0.0f;
        goto L24
    L28:
        if (r103 != Direction.BOTTOM_LEFT.ordinal()) goto L36;
        r105 = r101;
        int r113 = a.C0915a.f56894a;
        if ((r102 & 8) <= 0) goto L32;
        r105 = r105 - this.f56887e;
    L32:
        int r114 = a.b.f56895a;
        if ((r102 & 1) <= 0) goto L17;
        r107 = this.f56887e;
        goto L16
    L36:
        if (r103 != Direction.BOTTOM_RIGHT.ordinal()) goto L44;
        float r115 = r100;
        float r116 = r101;
        int r117 = a.C0915a.f56894a;
        if ((r102 & 8) <= 0) goto L40;
        r116 = r116 - this.f56887e;
    L40:
        int r118 = a.d.f56897a;
        if ((r102 & 4) <= 0) goto L43;
        r115 = r115 - this.f56887e;
    L43:
        float r119 = r116;
        r108 = r115;
        r105 = r119;
        goto L45
    L44:
        r105 = 0.0f;
        goto L17
    }

    public CornerHoleHSImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f56884b = LazyKt.lazy(CornerHoleHSImageView$dstPath$2.INSTANCE);
        this.f56885c = LazyKt.lazy(CornerHoleHSImageView$srcPath$2.INSTANCE);
        this.f56886d = LazyKt.lazy(CornerHoleHSImageView$pathPaint$2.INSTANCE);
        this.f56888f = Direction.NONE.ordinal();
        int r103 = a.c.f56896a;
        this.f56889g = 0;
        this.f56892j = LazyKt.lazy(CornerHoleHSImageView$xFerMode$2.INSTANCE);
        j(r101);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f56883a = new RectF(0.0f, 0.0f, r100, r101);
        getDstPath().reset();
        f(r100, r101);
        getSrcPath().reset();
        Path r104 = getSrcPath();
        RectF r105 = this.f56883a;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rectF");
    L5:
        r104.addRect(r105, Path.Direction.CW);
    }
}
