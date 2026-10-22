package x;

import android.media.ImageWriter;
import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lx/l;", "", "<init>", "()V", "Landroid/view/Surface;", "surface", "", "maxImages", "format", "Landroid/media/ImageWriter;", Const.INTENT_KEY_APIKEY, "(Landroid/view/Surface;II)Landroid/media/ImageWriter;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5825l {

    /* renamed from: a, reason: collision with root package name */
    public static final C5825l f43417a = new C5825l();

    public static final ImageWriter a(Surface surface, int maxImages, int format) {
        kotlin.jvm.internal.p.i(surface, "surface");
        ImageWriter imageWriterNewInstance = ImageWriter.newInstance(surface, maxImages, format);
        kotlin.jvm.internal.p.h(imageWriterNewInstance, "newInstance(...)");
        return imageWriterNewInstance;
    }
}
