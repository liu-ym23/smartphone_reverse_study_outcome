package coil.decode;

import A1.k;
import B1.Size;
import Mb.InterfaceC0968f;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import coil.decode.c;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.caverock.androidsvg.RenderOptions;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import e9.InterfaceC4014c;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.InterruptibleKt;
import p9.InterfaceC5063a;
import r9.C5227b;
import u1.C5569b;
import u1.j;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0002\u0016\u000bB#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcoil/decode/i;", "Lcoil/decode/c;", "Lcoil/decode/e;", "source", "LA1/k;", "options", "", "useViewBoundsAsIntrinsicSize", "<init>", "(Lcoil/decode/e;LA1/k;Z)V", "Lu1/b;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "", "srcWidth", "srcHeight", "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "Lkotlin/Pair;", Const.INTENT_KEY_UMID, "(FFLcoil/size/Scale;)Lkotlin/Pair;", "Lcoil/decode/e;", Const.INTENT_KEY_PKGNAME, "LA1/k;", "c", "Z", "getUseViewBoundsAsIntrinsicSize", "()Z", "coil-svg_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final e source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final k options;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean useViewBoundsAsIntrinsicSize;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcoil/decode/i$b;", "Lcoil/decode/c$a;", "", "useViewBoundsAsIntrinsicSize", "<init>", "(Z)V", "Lw1/c;", "result", "LA1/k;", "options", "Lcoil/c;", "imageLoader", "Lcoil/decode/c;", Const.INTENT_KEY_APIKEY, "(Lw1/c;LA1/k;Lcoil/c;)Lcoil/decode/c;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_PKGNAME, "(Lw1/c;)Z", "Z", "getUseViewBoundsAsIntrinsicSize", "()Z", "coil-svg_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements c.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final boolean useViewBoundsAsIntrinsicSize;

        public b() {
            this(false, 1, null);
        }

        @Override // coil.decode.c.a
        public c a(w1.c result, k options, coil.c imageLoader) {
            if (b(result)) {
                return new i(result.getSource(), options, this.useViewBoundsAsIntrinsicSize);
            }
            return null;
        }

        public final boolean b(w1.c result) {
            return p.d(result.getMimeType(), "image/svg+xml") || j.a(u1.c.f42403a, result.getSource().e());
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof b) && this.useViewBoundsAsIntrinsicSize == ((b) other).useViewBoundsAsIntrinsicSize;
        }

        public int hashCode() {
            return Boolean.hashCode(this.useViewBoundsAsIntrinsicSize);
        }

        public b(boolean z10) {
            this.useViewBoundsAsIntrinsicSize = z10;
        }

        public /* synthetic */ b(boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? true : z10);
        }
    }

    public i(e eVar, k kVar, boolean z10) {
        this.source = eVar;
        this.options = kVar;
        this.useViewBoundsAsIntrinsicSize = z10;
    }

    public static final C5569b c(i iVar) throws IOException, SVGParseException {
        float documentWidth;
        float documentHeight;
        int iB;
        int iB2;
        InterfaceC0968f interfaceC0968fE = iVar.source.e();
        try {
            SVG fromInputStream = SVG.getFromInputStream(interfaceC0968fE.r1());
            l9.b.a(interfaceC0968fE, null);
            RectF documentViewBox = fromInputStream.getDocumentViewBox();
            if (!iVar.useViewBoundsAsIntrinsicSize || documentViewBox == null) {
                documentWidth = fromInputStream.getDocumentWidth();
                documentHeight = fromInputStream.getDocumentHeight();
            } else {
                documentWidth = documentViewBox.width();
                documentHeight = documentViewBox.height();
            }
            Pair<Float, Float> pairD = iVar.d(documentWidth, documentHeight, iVar.options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String());
            float fFloatValue = pairD.a().floatValue();
            float fFloatValue2 = pairD.b().floatValue();
            if (documentWidth <= 0.0f || documentHeight <= 0.0f) {
                iB = C5227b.b(fFloatValue);
                iB2 = C5227b.b(fFloatValue2);
            } else {
                float fD = u1.c.d(documentWidth, documentHeight, fFloatValue, fFloatValue2, iVar.options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String());
                iB = (int) (fD * documentWidth);
                iB2 = (int) (fD * documentHeight);
            }
            if (documentViewBox == null && documentWidth > 0.0f && documentHeight > 0.0f) {
                fromInputStream.setDocumentViewBox(0.0f, 0.0f, documentWidth, documentHeight);
            }
            fromInputStream.setDocumentWidth("100%");
            fromInputStream.setDocumentHeight("100%");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iB, iB2, F1.i.d(iVar.options.getConfig()));
            String strA = A1.p.a(iVar.options.getParameters());
            fromInputStream.renderToCanvas(new Canvas(bitmapCreateBitmap), strA != null ? new RenderOptions().css(strA) : null);
            return new C5569b(new BitmapDrawable(iVar.options.getContext().getResources(), bitmapCreateBitmap), true);
        } finally {
        }
    }

    @Override // coil.decode.c
    public Object a(InterfaceC4014c<? super C5569b> interfaceC4014c) {
        return InterruptibleKt.c(null, new InterfaceC5063a() { // from class: u1.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return coil.decode.i.c(this.f42419a);
            }
        }, interfaceC4014c, 1, null);
    }

    public final Pair<Float, Float> d(float srcWidth, float srcHeight, Scale scale) {
        if (!B1.b.a(this.options.getSize())) {
            Size size = this.options.getSize();
            return Y8.j.a(Float.valueOf(F1.i.c(size.getWidth(), scale)), Float.valueOf(F1.i.c(size.getHeight(), scale)));
        }
        if (srcWidth <= 0.0f) {
            srcWidth = 512.0f;
        }
        if (srcHeight <= 0.0f) {
            srcHeight = 512.0f;
        }
        return Y8.j.a(Float.valueOf(srcWidth), Float.valueOf(srcHeight));
    }
}
