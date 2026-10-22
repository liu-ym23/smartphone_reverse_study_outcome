package N5;

import android.graphics.Bitmap;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nR(\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"LN5/u;", "", "<init>", "()V", "Landroid/graphics/Bitmap;", "bitmap", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/Bitmap;)V", Const.INTENT_KEY_PKGNAME, "()Landroid/graphics/Bitmap;", UxipConstants.f30680s, "snapshot", "Landroid/graphics/Bitmap;", "getSnapshot", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    public static final u INSTANCE = new u();
    private static volatile Bitmap snapshot;

    public final void a(Bitmap bitmap) {
        Bitmap bitmap2 = snapshot;
        snapshot = bitmap;
        if (bitmap2 == null || bitmap2 == bitmap || bitmap2.isRecycled()) {
            return;
        }
        bitmap2.recycle();
    }

    public final Bitmap b() {
        Bitmap bitmap = snapshot;
        snapshot = null;
        return bitmap;
    }
}
