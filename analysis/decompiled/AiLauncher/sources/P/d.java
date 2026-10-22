package P;

import D.C0761b0;
import android.media.MediaCodec;
import android.util.Range;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.l;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f*\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u000e*\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u000e*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"LP/d;", "", "<init>", "()V", "", "Landroidx/camera/core/impl/SessionConfig$f;", "outputConfigs", "Landroidx/camera/core/impl/l$a;", "repeatingConfigBuilder", "LY8/t;", "e", "(Ljava/util/Collection;Landroidx/camera/core/impl/l$a;)V", "Landroid/util/Range;", "", "", "c", "(Landroid/util/Range;)Z", "f", "(Landroid/util/Range;)Landroid/util/Range;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Collection;)Z", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/l$a;)Z", "Landroidx/camera/core/impl/DeferrableSurface;", Const.INTENT_KEY_UMID, "(Landroidx/camera/core/impl/DeferrableSurface;)Z", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {
    public final boolean a(l.a aVar) {
        Set<DeferrableSurface> setK = aVar.k();
        p.h(setK, "getSurfaces(...)");
        Set<DeferrableSurface> set = setK;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (DeferrableSurface deferrableSurface : set) {
            p.f(deferrableSurface);
            if (d(deferrableSurface)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(Collection<? extends SessionConfig.f> collection) {
        Collection<? extends SessionConfig.f> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            DeferrableSurface deferrableSurfaceF = ((SessionConfig.f) it.next()).f();
            p.h(deferrableSurfaceF, "getSurface(...)");
            if (d(deferrableSurfaceF)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(Range<Integer> range) {
        return ((Number) range.getUpper()).intValue() >= 120 && p.d(range.getLower(), range.getUpper());
    }

    public final boolean d(DeferrableSurface deferrableSurface) {
        return p.d(deferrableSurface.g(), MediaCodec.class);
    }

    public final void e(Collection<? extends SessionConfig.f> outputConfigs, l.a repeatingConfigBuilder) {
        Range<Integer> rangeJ;
        p.i(outputConfigs, "outputConfigs");
        p.i(repeatingConfigBuilder, "repeatingConfigBuilder");
        if (outputConfigs.size() != 2 || !b(outputConfigs) || a(repeatingConfigBuilder) || (rangeJ = repeatingConfigBuilder.j()) == null) {
            return;
        }
        if (!c(rangeJ)) {
            rangeJ = null;
        }
        if (rangeJ != null) {
            repeatingConfigBuilder.m(f(rangeJ));
        }
    }

    public final Range<Integer> f(Range<Integer> range) {
        Range<Integer> range2 = new Range<>(30, range.getUpper());
        C0761b0.a("HighSpeedFpsModifier", "Modified high-speed FPS range from " + range + " to " + range2);
        return range2;
    }
}
