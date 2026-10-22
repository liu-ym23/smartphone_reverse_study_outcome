package C;

import android.media.Image;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.util.date.GMTDateParser;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import w.P;
import w9.InterfaceC5745d;
import x.C5823k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\"\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001a\u0010'\u001a\u00020#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b \u0010&¨\u0006("}, d2 = {"LC/a;", "LC/n;", "Landroid/media/Image;", "image", "<init>", "(Landroid/media/Image;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "Landroid/media/Image;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "lock", "", "c", "I", "getFormat", "()I", "format", Const.INTENT_KEY_UMID, "getWidth", "width", "e", "getHeight", "height", "", "f", "J", "()J", "timestamp", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Image image;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int format;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final long timestamp;

    public a(Image image) {
        kotlin.jvm.internal.p.i(image, "image");
        this.image = image;
        this.lock = new Object();
        this.format = image.getFormat();
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.timestamp = image.getTimestamp();
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (!kotlin.jvm.internal.p.d(type, t.b(Image.class))) {
            return (T) C5823k.l(this.image, type);
        }
        T t10 = (T) this.image;
        kotlin.jvm.internal.p.g(t10, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.media.AndroidImage.unwrapAs");
        return t10;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.image.close();
    }

    /* renamed from: e, reason: from getter */
    public long getTimestamp() {
        return this.timestamp;
    }

    public int getFormat() {
        return this.format;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "Image-" + P.g(P.d(getFormat())) + "-w" + getWidth() + GMTDateParser.HOURS + getHeight() + "-t" + getTimestamp();
    }
}
