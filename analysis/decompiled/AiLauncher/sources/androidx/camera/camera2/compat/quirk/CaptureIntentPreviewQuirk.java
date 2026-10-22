package androidx.camera.camera2.compat.quirk;

import K.s0;
import K.w0;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CaptureIntentPreviewQuirk;", "LK/s0;", "", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CaptureIntentPreviewQuirk extends s0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f9413a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CaptureIntentPreviewQuirk$a;", "", "<init>", "()V", "LK/w0;", "quirks", "", Const.INTENT_KEY_APIKEY, "(LK/w0;)Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.CaptureIntentPreviewQuirk$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f9413a = new Companion();

        public final boolean a(w0 quirks) {
            p.i(quirks, "quirks");
            Iterator it = quirks.c(CaptureIntentPreviewQuirk.class).iterator();
            while (it.hasNext()) {
                if (((CaptureIntentPreviewQuirk) it.next()).b()) {
                    return true;
                }
            }
            return false;
        }
    }

    default boolean b() {
        return true;
    }
}
