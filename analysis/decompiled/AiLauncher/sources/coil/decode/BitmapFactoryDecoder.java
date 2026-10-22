package coil.decode;

import A1.k;
import B1.Size;
import Mb.AbstractC0974l;
import Mb.C0966d;
import Mb.I;
import Mb.InterfaceC0968f;
import Mb.u;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import coil.decode.c;
import coil.decode.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import eb.j;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import r9.C5227b;
import u1.C5569b;
import v9.C5685n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0003\u0015\u0019\rB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\f*\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u0014*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u0014*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/c;", "Lcoil/decode/e;", "source", "LA1/k;", "options", "Leb/g;", "parallelismLock", "Lcoil/decode/ExifOrientationPolicy;", "exifOrientationPolicy", "<init>", "(Lcoil/decode/e;LA1/k;Leb/g;Lcoil/decode/ExifOrientationPolicy;)V", "Lu1/b;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "Landroid/graphics/BitmapFactory$Options;", "e", "(Landroid/graphics/BitmapFactory$Options;)Lu1/b;", "Lu1/d;", "exifData", "LY8/t;", "c", "(Landroid/graphics/BitmapFactory$Options;Lu1/d;)V", Const.INTENT_KEY_UMID, "Lcoil/decode/e;", Const.INTENT_KEY_PKGNAME, "LA1/k;", "Leb/g;", "Lcoil/decode/ExifOrientationPolicy;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BitmapFactoryDecoder implements coil.decode.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final e source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final k options;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final eb.g parallelismLock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final ExifOrientationPolicy exifOrientationPolicy;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR4\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r2\u000e\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$b;", "LMb/l;", "LMb/I;", "delegate", "<init>", "(LMb/I;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "Ljava/lang/Exception;", "Lkotlin/Exception;", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "Ljava/lang/Exception;", "e", "()Ljava/lang/Exception;", "exception", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends AbstractC0974l {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public Exception exception;

        public b(I i10) {
            super(i10);
        }

        /* renamed from: e, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        @Override // Mb.AbstractC0974l, Mb.I
        public long u0(C0966d sink, long byteCount) throws Exception {
            try {
                return super.u0(sink, byteCount);
            } catch (Exception e10) {
                this.exception = e10;
                throw e10;
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$c;", "Lcoil/decode/c$a;", "", "maxParallelism", "Lcoil/decode/ExifOrientationPolicy;", "exifOrientationPolicy", "<init>", "(ILcoil/decode/ExifOrientationPolicy;)V", "Lw1/c;", "result", "LA1/k;", "options", "Lcoil/c;", "imageLoader", "Lcoil/decode/c;", Const.INTENT_KEY_APIKEY, "(Lw1/c;LA1/k;Lcoil/c;)Lcoil/decode/c;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lcoil/decode/ExifOrientationPolicy;", "Leb/g;", Const.INTENT_KEY_PKGNAME, "Leb/g;", "parallelismLock", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements c.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final ExifOrientationPolicy exifOrientationPolicy;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final eb.g parallelismLock;

        public c(int i10, ExifOrientationPolicy exifOrientationPolicy) {
            this.exifOrientationPolicy = exifOrientationPolicy;
            this.parallelismLock = j.b(i10, 0, 2, null);
        }

        @Override // coil.decode.c.a
        public coil.decode.c a(w1.c result, k options, coil.c imageLoader) {
            return new BitmapFactoryDecoder(result.getSource(), options, this.parallelismLock, this.exifOrientationPolicy);
        }

        public boolean equals(Object other) {
            return other instanceof c;
        }

        public int hashCode() {
            return c.class.hashCode();
        }
    }

    public BitmapFactoryDecoder(e eVar, k kVar, eb.g gVar, ExifOrientationPolicy exifOrientationPolicy) {
        this.source = eVar;
        this.options = kVar;
        this.parallelismLock = gVar;
        this.exifOrientationPolicy = exifOrientationPolicy;
    }

    public static final C5569b f(BitmapFactoryDecoder bitmapFactoryDecoder) {
        return bitmapFactoryDecoder.e(new BitmapFactory.Options());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil.decode.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(e9.InterfaceC4014c<? super u1.C5569b> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof coil.decode.BitmapFactoryDecoder$decode$1
            if (r0 == 0) goto L13
            r0 = r7
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = (coil.decode.BitmapFactoryDecoder$decode$1) r0
            int r1 = r0.f15582e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15582e = r1
            goto L18
        L13:
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = new coil.decode.BitmapFactoryDecoder$decode$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f15580c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f15582e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f15578a
            eb.g r6 = (eb.g) r6
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L30
            goto L70
        L30:
            r7 = move-exception
            goto L7a
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.lang.Object r6 = r0.f15579b
            eb.g r6 = (eb.g) r6
            java.lang.Object r2 = r0.f15578a
            coil.decode.BitmapFactoryDecoder r2 = (coil.decode.BitmapFactoryDecoder) r2
            kotlin.C4849c.b(r7)
            r7 = r6
            r6 = r2
            goto L5a
        L48:
            kotlin.C4849c.b(r7)
            eb.g r7 = r6.parallelismLock
            r0.f15578a = r6
            r0.f15579b = r7
            r0.f15582e = r4
            java.lang.Object r2 = r7.c(r0)
            if (r2 != r1) goto L5a
            goto L6c
        L5a:
            u1.a r2 = new u1.a     // Catch: java.lang.Throwable -> L76
            r2.<init>()     // Catch: java.lang.Throwable -> L76
            r0.f15578a = r7     // Catch: java.lang.Throwable -> L76
            r6 = 0
            r0.f15579b = r6     // Catch: java.lang.Throwable -> L76
            r0.f15582e = r3     // Catch: java.lang.Throwable -> L76
            java.lang.Object r6 = kotlinx.coroutines.InterruptibleKt.c(r6, r2, r0, r4, r6)     // Catch: java.lang.Throwable -> L76
            if (r6 != r1) goto L6d
        L6c:
            return r1
        L6d:
            r5 = r7
            r7 = r6
            r6 = r5
        L70:
            u1.b r7 = (u1.C5569b) r7     // Catch: java.lang.Throwable -> L30
            r6.release()
            return r7
        L76:
            r6 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L7a:
            r6.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.a(e9.c):java.lang.Object");
    }

    public final void c(BitmapFactory.Options options, u1.d dVar) {
        Bitmap.Config config = this.options.getConfig();
        if (dVar.getIsFlipped() || u1.g.a(dVar)) {
            config = F1.a.e(config);
        }
        if (this.options.getAllowRgb565() && config == Bitmap.Config.ARGB_8888 && p.d(options.outMimeType, "image/jpeg")) {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap.Config config2 = options.outConfig;
        Bitmap.Config config3 = Bitmap.Config.RGBA_F16;
        if (config2 == config3 && config != Bitmap.Config.HARDWARE) {
            config = config3;
        }
        options.inPreferredConfig = config;
    }

    public final void d(BitmapFactory.Options options, u1.d dVar) {
        e.a aVarB = this.source.b();
        if ((aVarB instanceof g) && B1.b.a(this.options.getSize())) {
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((g) aVarB).getDensity();
            options.inTargetDensity = this.options.getContext().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i10 = u1.g.b(dVar) ? options.outHeight : options.outWidth;
        int i11 = u1.g.b(dVar) ? options.outWidth : options.outHeight;
        Size size = this.options.getSize();
        int iA = B1.b.a(size) ? i10 : F1.j.A(size.d(), this.options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String());
        Size size2 = this.options.getSize();
        int iA2 = B1.b.a(size2) ? i11 : F1.j.A(size2.c(), this.options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String());
        int iA3 = u1.c.a(i10, i11, iA, iA2, this.options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String());
        options.inSampleSize = iA3;
        double dB = u1.c.b(i10 / iA3, i11 / iA3, iA, iA2, this.options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String());
        if (this.options.getAllowInexactSize()) {
            dB = C5685n.h(dB, 1.0d);
        }
        boolean z10 = dB == 1.0d;
        options.inScaled = !z10;
        if (z10) {
            return;
        }
        if (dB > 1.0d) {
            options.inDensity = C5227b.a(Integer.MAX_VALUE / dB);
            options.inTargetDensity = Integer.MAX_VALUE;
        } else {
            options.inDensity = Integer.MAX_VALUE;
            options.inTargetDensity = C5227b.a(Integer.MAX_VALUE * dB);
        }
    }

    public final C5569b e(BitmapFactory.Options options) throws Exception {
        b bVar = new b(this.source.e());
        InterfaceC0968f interfaceC0968fC = u.c(bVar);
        boolean z10 = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(interfaceC0968fC.peek().r1(), null, options);
        Exception exception = bVar.getException();
        if (exception != null) {
            throw exception;
        }
        options.inJustDecodeBounds = false;
        u1.f fVar = u1.f.f42411a;
        u1.d dVarA = fVar.a(options.outMimeType, interfaceC0968fC, this.exifOrientationPolicy);
        Exception exception2 = bVar.getException();
        if (exception2 != null) {
            throw exception2;
        }
        options.inMutable = false;
        if (this.options.getColorSpace() != null) {
            options.inPreferredColorSpace = this.options.getColorSpace();
        }
        options.inPremultiplied = this.options.getPremultipliedAlpha();
        c(options, dVarA);
        d(options, dVarA);
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(interfaceC0968fC.r1(), null, options);
            l9.b.a(interfaceC0968fC, null);
            Exception exception3 = bVar.getException();
            if (exception3 != null) {
                throw exception3;
            }
            if (bitmapDecodeStream == null) {
                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
            }
            bitmapDecodeStream.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.options.getContext().getResources(), fVar.b(bitmapDecodeStream, dVarA));
            if (options.inSampleSize <= 1 && !options.inScaled) {
                z10 = false;
            }
            return new C5569b(bitmapDrawable, z10);
        } finally {
        }
    }
}
