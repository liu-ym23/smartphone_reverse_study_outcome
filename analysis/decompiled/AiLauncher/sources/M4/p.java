package M4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import org.libpag.PAGFile;
import v9.C5685n;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LM4/p;", "", "<init>", "()V", "", Const.JSON_KEY_SPEED, "c", "(F)F", "", Const.INTENT_KEY_PKGNAME, "(F)Z", "", "originalMicros", Const.INTENT_KEY_UMID, "(JF)J", "Lorg/libpag/PAGFile;", "pagFile", "manifestSpeed", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lorg/libpag/PAGFile;F)V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f4640a = new p();

    public final void a(PAGFile pagFile, float manifestSpeed) {
        kotlin.jvm.internal.p.i(pagFile, "pagFile");
        float fC = c(manifestSpeed);
        if (b(fC)) {
            long jDuration = pagFile.duration();
            if (jDuration <= 0) {
                return;
            }
            pagFile.setTimeStretchMode(1);
            pagFile.setDuration(d(jDuration, fC));
        }
    }

    public final boolean b(float speed) {
        return !(c(speed) == 1.0f);
    }

    public final float c(float speed) {
        if (Float.isNaN(speed) || speed <= 0.0f) {
            return 1.0f;
        }
        return C5685n.m(speed, 0.25f, 4.0f);
    }

    public final long d(long originalMicros, float speed) {
        return originalMicros <= 0 ? originalMicros : C5685n.g((long) (originalMicros / c(speed)), 1L);
    }
}
