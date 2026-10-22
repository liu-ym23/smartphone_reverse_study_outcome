package C;

import C.o;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import s.C5423E;
import w.C5693E;
import w.P;
import w9.InterfaceC5745d;
import x.C5825l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010*\u001a\u00020&8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\u00020&8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b,\u0010)¨\u0006/"}, d2 = {"LC/b;", "LC/o;", "Landroid/media/ImageWriter$OnImageReleasedListener;", "Landroid/media/ImageWriter;", "imageWriter", "Lw/E;", "inputStreamId", "<init>", "(Landroid/media/ImageWriter;I)V", "LC/n;", "image", "", "K0", "(LC/n;)Z", "writer", "LY8/t;", "onImageReleased", "(Landroid/media/ImageWriter;)V", "close", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/media/ImageWriter;", Const.INTENT_KEY_PKGNAME, "I", "LOa/e;", "LC/o$a;", "c", "LOa/e;", "onImageReleasedListener", "", Const.INTENT_KEY_UMID, "getMaxImages", "()I", "maxImages", "e", "getFormat", "format", "f", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b implements o, ImageWriter.OnImageReleasedListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ImageWriter imageWriter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int inputStreamId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<o.a> onImageReleasedListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int maxImages;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int format;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LC/b$a;", "", "<init>", "()V", "Landroid/view/Surface;", "surface", "Lw/E;", "inputStreamId", "", "maxImages", "Lw/P;", "format", "Landroid/os/Handler;", "handler", "LC/o;", Const.INTENT_KEY_APIKEY, "(Landroid/view/Surface;IILw/P;Landroid/os/Handler;)LC/o;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: C.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final o a(Surface surface, int inputStreamId, int maxImages, P format, Handler handler) {
            ImageWriter imageWriterNewInstance;
            kotlin.jvm.internal.p.i(surface, "surface");
            kotlin.jvm.internal.p.i(handler, "handler");
            if (maxImages <= 0) {
                throw new IllegalArgumentException(("Max images (" + maxImages + ") must be > 0").toString());
            }
            if (maxImages > 54) {
                throw new IllegalArgumentException("Max images for ImageWriters is restricted to 54 to prevent overloading downstream consumer components.");
            }
            int i10 = Build.VERSION.SDK_INT;
            if (format != null) {
                imageWriterNewInstance = C5825l.a(surface, maxImages, format.getValue());
            } else {
                if (format != null && z.k.f44508a.d()) {
                    Log.w("CXCP", "Ignoring format (" + ((Object) P.i(format.getValue())) + ") for " + ((Object) C5693E.b(inputStreamId)) + ". Android " + i10 + " does not support creating ImageWriters with formats. This may lead to unexpected behaviors.");
                }
                imageWriterNewInstance = ImageWriter.newInstance(surface, maxImages);
                kotlin.jvm.internal.p.f(imageWriterNewInstance);
            }
            b bVar = new b(imageWriterNewInstance, inputStreamId, null);
            imageWriterNewInstance.setOnImageReleasedListener(bVar, handler);
            return bVar;
        }

        public Companion() {
        }
    }

    public /* synthetic */ b(ImageWriter imageWriter, int i10, kotlin.jvm.internal.i iVar) {
        this(imageWriter, i10);
    }

    @Override // C.o
    public boolean K0(n image) throws Exception {
        kotlin.jvm.internal.p.i(image, "image");
        try {
            Image image2 = (Image) image.R0(t.b(Image.class));
            if (image2 != null) {
                this.imageWriter.queueInputImage(image2);
                return true;
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to unwrap image wrapper " + image);
            }
            return false;
        } catch (Throwable th) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to queue image to " + this + " due to error " + th.getMessage() + ". Ignoring failure and closing " + image);
            }
            C5423E.a(image);
            return false;
        }
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, t.b(ImageWriter.class))) {
            return (T) this.imageWriter;
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.imageWriter.close();
    }

    @Override // android.media.ImageWriter.OnImageReleasedListener
    public void onImageReleased(ImageWriter writer) {
        o.a aVarC = this.onImageReleasedListener.c();
        if (aVarC != null) {
            aVarC.a(this.inputStreamId);
        }
    }

    public String toString() {
        return "ImageWriter-" + P.g(P.d(this.imageWriter.getFormat())) + '-' + ((Object) C5693E.b(this.inputStreamId));
    }

    public b(ImageWriter imageWriter, int i10) {
        this.imageWriter = imageWriter;
        this.inputStreamId = i10;
        this.onImageReleasedListener = Oa.b.g(null);
        this.maxImages = imageWriter.getMaxImages();
        this.format = imageWriter.getFormat();
    }
}
