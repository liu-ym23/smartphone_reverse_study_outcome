package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.utils.k1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/LargeImageView;", "Landroid/view/View;", "Ljava/io/InputStream;", "stream", "", "setInputStream", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/m;", "largeImageMoveListener", "setLargeImageMoveListener", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/o;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/o;", "getMDetector", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/o;", "setMDetector", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/o;)V", "mDetector", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LargeImageView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitmapRegionDecoder f168291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f168292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f168293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Rect f168294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f168295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f168296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BitmapFactory.Options f168297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f168298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o f168299i;

    public static final class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LargeImageView f168300a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.p
        public final void b(o r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
        }

        public a(LargeImageView r100) {
            this.f168300a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.p
        public final void a(o r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            PointF r101 = r100.f168333e;
            int r102 = (int) r101.x;
            int r103 = (int) r101.y;
            LargeImageView r104 = this.f168300a;
            if (r104.f168293c <= r104.getWidth()) goto L19;
            this.f168300a.f168294d.offset(-r102, 0);
            LargeImageView r105 = this.f168300a;
            if (r105.f168294d.right <= r105.f168293c) goto L12;
            r105.f168294d.right = r105.f168293c;
            Rect r106 = r105.f168294d;
            if (r105.f168296f == 0.0f) goto L9;
            int r107 = r105.f168293c;
            int r108 = (int) (r105.getWidth() / r105.f168296f);
        L10:
            r106.left = r107 - r108;
            goto L12
        L9:
            r107 = r105.f168293c;
            r108 = r105.getWidth();
        L12:
            if (r105.f168294d.left >= 0) goto L18;
            r105.f168294d.left = 0;
            Rect r109 = r105.f168294d;
            if (r105.f168296f == 0.0f) goto L16;
            int r110 = (int) (r105.getWidth() / r105.f168296f);
        L17:
            r109.right = r110;
            goto L18
        L16:
            r110 = r105.getWidth();
        L18:
            this.f168300a.invalidate();
        L19:
            LargeImageView r111 = this.f168300a;
            if (r111.f168292b <= r111.getHeight()) goto L36;
            this.f168300a.f168294d.offset(0, -r103);
            LargeImageView r112 = this.f168300a;
            if (r112.f168294d.bottom <= r112.f168292b) goto L29;
            r112.f168294d.bottom = r112.f168292b;
            Rect r113 = r112.f168294d;
            if (r112.f168296f == 0.0f) goto L26;
            int r114 = r112.f168292b;
            int r115 = (int) (r112.getHeight() / r112.f168296f);
        L27:
            r113.top = r114 - r115;
            goto L29
        L26:
            r114 = r112.f168292b;
            r115 = r112.getHeight();
        L29:
            if (r112.f168294d.top >= 0) goto L35;
            r112.f168294d.top = 0;
            Rect r116 = r112.f168294d;
            if (r112.f168296f == 0.0f) goto L33;
            int r117 = (int) (r112.getHeight() / r112.f168296f);
        L34:
            r116.bottom = r117;
            goto L35
        L33:
            r117 = r112.getHeight();
        L35:
            this.f168300a.invalidate();
        L36:
            m r118 = this.f168300a.f168298h;
            if (r118 == null) goto L40;
            r118.b();
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.p
        public final void c(o r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            m r101 = this.f168300a.f168298h;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    public LargeImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LargeImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final o getMDetector() {
        return this.f168299i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        BitmapRegionDecoder r101 = this.f168291a;
        if (r101 == null) goto L5;
        Bitmap r102 = r101.decodeRegion(this.f168294d, this.f168297g);
    L6:
        if (r102 == null) goto L9;
        r100.drawBitmap(r102, this.f168295e, null);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setInputStream(InputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "stream");
        ByteArrayInputStream r101 = null;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L28 Exception -> L36
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L28 Exception -> L36
    L4:
        int r104 = r100.read(r103);     // Catch: Throwable -> L28 Exception -> L36
        if (r104 == (-1)) goto L7;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L28 Exception -> L36
        goto L4
    L7:
        r102.flush();     // Catch: Throwable -> L28 Exception -> L36
        ByteArrayInputStream r105 = new ByteArrayInputStream(r102.toByteArray());     // Catch: Throwable -> L28 Exception -> L36
        ByteArrayInputStream r106 = new ByteArrayInputStream(r102.toByteArray());     // Catch: Throwable -> L23 Exception -> L26
        this.f168291a = BitmapRegionDecoder.newInstance(r105, false);     // Catch: Throwable -> L21 Exception -> L44
        BitmapFactory.Options r107 = new BitmapFactory.Options();     // Catch: Throwable -> L21 Exception -> L44
        r107.inJustDecodeBounds = true;     // Catch: Throwable -> L21 Exception -> L44
        BitmapFactory.decodeStream(r106, null, r107);     // Catch: Throwable -> L21 Exception -> L44
        int r108 = r107.outWidth;     // Catch: Throwable -> L21 Exception -> L44
        this.f168293c = r108;     // Catch: Throwable -> L21 Exception -> L44
        this.f168292b = r107.outHeight;     // Catch: Throwable -> L21 Exception -> L44
        if (r108 == 0) goto L12;
        float r109 = k1.m(getContext()) / this.f168293c;     // Catch: Throwable -> L21 Exception -> L44
    L13:
        this.f168296f = r109;     // Catch: Throwable -> L21 Exception -> L44
        this.f168295e.postScale(r109, r109);     // Catch: Throwable -> L21 Exception -> L44
        float r110 = this.f168292b * this.f168296f;     // Catch: Throwable -> L21 Exception -> L44
        float r111 = k1.j(getContext());     // Catch: Throwable -> L21 Exception -> L44
        if (r110 >= r111) goto L16;
        this.f168295e.postTranslate(0.0f, (r111 - r110) / 2);     // Catch: Throwable -> L21 Exception -> L44
    L16:
        requestLayout();     // Catch: Throwable -> L21 Exception -> L44
        invalidate();     // Catch: Throwable -> L21 Exception -> L44
        r105.close();     // Catch: Exception -> L42
    L18:
        r106.close();     // Catch: Exception -> L42
    L19:
        r100.close();     // Catch: Exception -> L42
        return;
        goto L27
    L12:
        r109 = 1.0f;
    L21:
        th = th;
    L25:
        r101 = r105;
    L30:
        if (r101 != null) goto L45;
    L32:
        if (r106 == null) goto L34;
        r106.close();     // Catch: Exception -> L43
    L34:
        r100.close();     // Catch: Exception -> L43
    L35:
        throw th;
    L45:
        r101.close();     // Catch: Exception -> L43
    L27:
        r101 = r105;
    L37:
        if (r101 == null) goto L39;
        r101.close();     // Catch: Exception -> L42
    L39:
        if (r106 == null) goto L19;
    L26:
        r106 = null;
    L23:
        th = th;
        r106 = null;
        goto L25
    L36:
        r106 = null;
    L28:
        th = th;
        r106 = null;
    }

    public final void setLargeImageMoveListener(m r100) {
        Intrinsics.checkNotNullParameter(r100, "largeImageMoveListener");
        this.f168298h = r100;
    }

    public final void setMDetector(o r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f168299i = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        this.f168294d.left = 0;
        this.f168294d.top = 0;
        Rect r104 = this.f168294d;
        if (this.f168296f == 0.0f) goto L5;
        int r105 = this.f168294d.left;
        r102 = (int) (r102 / this.f168296f);
    L6:
        r104.right = r105 + r102;
        Rect r106 = this.f168294d;
        if (this.f168296f == 0.0f) goto L9;
        int r107 = this.f168294d.top;
        r103 = (int) (r103 / this.f168296f);
    L10:
        r106.bottom = r107 + r103;
        return;
    L9:
        r107 = this.f168294d.top;
        goto L10
    L5:
        r105 = this.f168294d.left;
        goto L6
    }

    public LargeImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168294d = new Rect();
        this.f168295e = new Matrix();
        this.f168296f = 1.0f;
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Unit r104 = Unit.INSTANCE;
        this.f168297g = r103;
        setClickable(true);
        this.f168299i = new o(new a(this));
    }

    public /* synthetic */ LargeImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
