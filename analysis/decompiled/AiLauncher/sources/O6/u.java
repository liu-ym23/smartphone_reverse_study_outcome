package O6;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.LruCache;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import i9.C4180c;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"LO6/u;", "", "<init>", "()V", "", "left", "top", "right", "bottom", "smoothness", "radius", "", "useNativeRoundCornerWhileParamsInvalid", "Landroid/graphics/Path;", Const.INTENT_KEY_APIKEY, "(FFFFFFZ)Landroid/graphics/Path;", "widthFloat", "heightFloat", "e", "(FFF)F", "sizeFloat", Const.INTENT_KEY_UMID, "(FF)F", "DefaultSmoothness", "F", "Landroid/util/LruCache;", "LO6/u$b;", "pathCache", "Landroid/util/LruCache;", "Landroid/graphics/Paint;", "clearBitmapPaint", "Landroid/graphics/Paint;", "c", "()Landroid/graphics/Paint;", Const.INTENT_KEY_PKGNAME, "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    public static final float DefaultSmoothness = 0.2f;
    private static final Paint clearBitmapPaint;
    public static final u INSTANCE = new u();
    private static final LruCache<SmoothPathParams, Path> pathCache = new c(100);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"LO6/u$a;", "", "<init>", "()V", "", "dx", "dy", "LY8/t;", "c", "(FF)V", Const.INTENT_KEY_UMID, "Landroid/graphics/Path;", "path", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/Path;)V", "", "points", "[F", Const.INTENT_KEY_PKGNAME, "()[F", "setPoints", "([F)V", "Companion", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private float[] points;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"LO6/u$a$a;", "", "<init>", "()V", "", "radius", "smoothness", "LO6/u$a;", Const.INTENT_KEY_APIKEY, "(FF)LO6/u$a;", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: O6.u$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final a a(float radius, float smoothness) {
                a aVar = new a(null);
                aVar.getPoints()[0] = 0.0f;
                aVar.getPoints()[1] = (smoothness * radius) + radius;
                aVar.getPoints()[2] = 0.0f;
                double d10 = radius;
                aVar.getPoints()[3] = (float) (((-Math.tan(0.2617993877991494d)) * d10) + d10);
                double dCos = Math.cos(0.7853981633974483d) * d10;
                double dCos2 = Math.cos(0.7853981633974483d) * Math.tan(0.24434609527920614d) * d10;
                aVar.getPoints()[4] = (float) ((-(dCos2 + dCos)) + d10);
                aVar.getPoints()[5] = (float) ((-(dCos - dCos2)) + d10);
                double d11 = -radius;
                aVar.getPoints()[6] = (float) ((Math.cos(0.7853981633974483d) * d11) + d10);
                aVar.getPoints()[7] = (float) ((d11 * Math.sin(0.7853981633974483d)) + d10);
                aVar.getPoints()[8] = aVar.getPoints()[5];
                aVar.getPoints()[9] = aVar.getPoints()[4];
                aVar.getPoints()[10] = aVar.getPoints()[3];
                aVar.getPoints()[11] = aVar.getPoints()[2];
                aVar.getPoints()[12] = aVar.getPoints()[1];
                aVar.getPoints()[13] = aVar.getPoints()[0];
                return aVar;
            }

            public Companion() {
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Path path) {
            kotlin.jvm.internal.p.i(path, "path");
            float[] fArr = this.points;
            path.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
            float[] fArr2 = this.points;
            path.cubicTo(fArr2[8], fArr2[9], fArr2[10], fArr2[11], fArr2[12], fArr2[13]);
        }

        /* renamed from: b, reason: from getter */
        public final float[] getPoints() {
            return this.points;
        }

        public final void c(float dx, float dy) {
            int i10 = 0;
            int iC = C4180c.c(0, this.points.length - 1, 2);
            if (iC < 0) {
                return;
            }
            while (true) {
                float[] fArr = this.points;
                fArr[i10] = fArr[i10] + dx;
                int i11 = i10 + 1;
                fArr[i11] = fArr[i11] + dy;
                if (i10 == iC) {
                    return;
                } else {
                    i10 += 2;
                }
            }
        }

        public final void d() {
            float[] fArr = this.points;
            float f10 = fArr[0];
            float f11 = fArr[1];
            fArr[0] = fArr[12];
            fArr[1] = fArr[13];
            fArr[12] = f10;
            fArr[13] = f11;
            float f12 = fArr[2];
            float f13 = fArr[3];
            fArr[2] = fArr[10];
            fArr[3] = fArr[11];
            fArr[10] = f12;
            fArr[11] = f13;
            float f14 = fArr[4];
            float f15 = fArr[5];
            fArr[4] = fArr[8];
            fArr[5] = fArr[9];
            fArr[8] = f14;
            fArr[9] = f15;
        }

        public a() {
            this.points = new float[14];
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"LO6/u$b;", "", "", "left", "top", "right", "bottom", "smoothness", "radius", "", "useNativeRoundCornerWhileParamsInvalid", "<init>", "(FFFFFFZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "F", "getLeft", "()F", "getTop", "getRight", "getBottom", "getSmoothness", "getRadius", "Z", "getUseNativeRoundCornerWhileParamsInvalid", "()Z", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: O6.u$b, reason: from toString */
    public static final /* data */ class SmoothPathParams {
        private final float bottom;
        private final float left;
        private final float radius;
        private final float right;
        private final float smoothness;
        private final float top;
        private final boolean useNativeRoundCornerWhileParamsInvalid;

        public SmoothPathParams(float f10, float f11, float f12, float f13, float f14, float f15, boolean z10) {
            this.left = f10;
            this.top = f11;
            this.right = f12;
            this.bottom = f13;
            this.smoothness = f14;
            this.radius = f15;
            this.useNativeRoundCornerWhileParamsInvalid = z10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SmoothPathParams)) {
                return false;
            }
            SmoothPathParams smoothPathParams = (SmoothPathParams) other;
            return Float.compare(this.left, smoothPathParams.left) == 0 && Float.compare(this.top, smoothPathParams.top) == 0 && Float.compare(this.right, smoothPathParams.right) == 0 && Float.compare(this.bottom, smoothPathParams.bottom) == 0 && Float.compare(this.smoothness, smoothPathParams.smoothness) == 0 && Float.compare(this.radius, smoothPathParams.radius) == 0 && this.useNativeRoundCornerWhileParamsInvalid == smoothPathParams.useNativeRoundCornerWhileParamsInvalid;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = ((((((((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + Float.hashCode(this.smoothness)) * 31) + Float.hashCode(this.radius)) * 31;
            boolean z10 = this.useNativeRoundCornerWhileParamsInvalid;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return iHashCode + i10;
        }

        public String toString() {
            return "SmoothPathParams(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", smoothness=" + this.smoothness + ", radius=" + this.radius + ", useNativeRoundCornerWhileParamsInvalid=" + this.useNativeRoundCornerWhileParamsInvalid + ')';
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"O6/u$c", "Landroid/util/LruCache;", "key", UxipConstants.f30680s, "", "sizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "create", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "evicted", "oldValue", "newValue", "LY8/t;", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends LruCache<SmoothPathParams, Path> {
        public c(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        public Path create(SmoothPathParams key) {
            return null;
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean evicted, SmoothPathParams key, Path oldValue, Path newValue) {
        }

        @Override // android.util.LruCache
        public int sizeOf(SmoothPathParams key, Path value) {
            return 1;
        }
    }

    static {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setAntiAlias(true);
        clearBitmapPaint = paint;
    }

    public static final Path a(float left, float top, float right, float bottom, float smoothness, float radius, boolean useNativeRoundCornerWhileParamsInvalid) {
        Path path = new Path();
        SmoothPathParams smoothPathParams = new SmoothPathParams(left, top, right, bottom, smoothness, radius, useNativeRoundCornerWhileParamsInvalid);
        LruCache<SmoothPathParams, Path> lruCache = pathCache;
        Path path2 = lruCache.get(smoothPathParams);
        if (path2 != null) {
            path.addPath(path2);
            return path;
        }
        lruCache.put(smoothPathParams, path);
        float f10 = right - left;
        float f11 = bottom - top;
        if (f10 <= 0.0f || f11 <= 0.0f) {
            path.addRect(left, top, right, bottom, Path.Direction.CW);
            return new Path(path);
        }
        if (useNativeRoundCornerWhileParamsInvalid && radius > INSTANCE.e(f10, f11, smoothness)) {
            path.addRoundRect(left, top, right, bottom, radius, radius, Path.Direction.CW);
            return new Path(path);
        }
        float f12 = (right + left) / 2.0f;
        float f13 = (bottom + top) / 2.0f;
        a aVarA = a.INSTANCE.a(radius, smoothness);
        aVarA.c(left, top);
        path.moveTo(aVarA.getPoints()[0], aVarA.getPoints()[1]);
        aVarA.a(path);
        Matrix matrix = new Matrix();
        float f14 = -f12;
        float f15 = -f13;
        matrix.postTranslate(f14, f15);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f12, f13);
        matrix.mapPoints(aVarA.getPoints());
        aVarA.d();
        path.lineTo(aVarA.getPoints()[0], aVarA.getPoints()[1]);
        aVarA.a(path);
        aVarA.d();
        matrix.reset();
        matrix.postTranslate(f14, f15);
        matrix.postScale(1.0f, -1.0f);
        matrix.postTranslate(f12, f13);
        matrix.mapPoints(aVarA.getPoints());
        path.lineTo(aVarA.getPoints()[0], aVarA.getPoints()[1]);
        aVarA.a(path);
        matrix.reset();
        matrix.postTranslate(f14, f15);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f12, f13);
        matrix.mapPoints(aVarA.getPoints());
        aVarA.d();
        path.lineTo(aVarA.getPoints()[0], aVarA.getPoints()[1]);
        aVarA.a(path);
        path.close();
        return new Path(path);
    }

    public static /* synthetic */ Path b(float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, int i10, Object obj) {
        if ((i10 & 64) != 0) {
            z10 = false;
        }
        return a(f10, f11, f12, f13, f14, f15, z10);
    }

    public final Paint c() {
        return clearBitmapPaint;
    }

    public final float d(float sizeFloat, float smoothness) {
        return C5685n.i(sizeFloat, (sizeFloat / 2.0f) / (smoothness + 1.0f));
    }

    public final float e(float widthFloat, float heightFloat, float smoothness) {
        return d(Math.min(widthFloat, heightFloat), smoothness);
    }
}
