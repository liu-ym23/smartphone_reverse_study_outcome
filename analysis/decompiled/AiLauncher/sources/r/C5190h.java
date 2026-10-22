package r;

import android.util.Size;
import androidx.camera.camera2.compat.quirk.SmallDisplaySizeQuirk;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0013\u0010\n\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lr/h;", "", "<init>", "()V", "Landroidx/camera/camera2/compat/quirk/SmallDisplaySizeQuirk;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/compat/quirk/SmallDisplaySizeQuirk;", "smallDisplaySizeQuirk", "Landroid/util/Size;", "()Landroid/util/Size;", "displaySize", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5190h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SmallDisplaySizeQuirk smallDisplaySizeQuirk = (SmallDisplaySizeQuirk) q.f.f38470a.c(SmallDisplaySizeQuirk.class);

    public final Size a() {
        SmallDisplaySizeQuirk smallDisplaySizeQuirk = this.smallDisplaySizeQuirk;
        if (smallDisplaySizeQuirk != null) {
            return smallDisplaySizeQuirk.d();
        }
        return null;
    }
}
