package androidx.compose.ui;

import H7.f;
import H7.g;
import H7.h;
import S7.n;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import z2.l;

@Stable
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/MotionDurationScale;", "LH7/f;", "", "getScaleFactor", "()F", "scaleFactor", "LH7/g;", "getKey", "()LH7/g;", "key", "Key", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MotionDurationScale extends f {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(MotionDurationScale motionDurationScale, R r5, n nVar) {
            return (R) l.w(motionDurationScale, r5, nVar);
        }

        public static <E extends f> E get(MotionDurationScale motionDurationScale, g gVar) {
            return (E) l.x(motionDurationScale, gVar);
        }

        public static h minusKey(MotionDurationScale motionDurationScale, g gVar) {
            return l.C(motionDurationScale, gVar);
        }

        public static h plus(MotionDurationScale motionDurationScale, h hVar) {
            return l.H(motionDurationScale, hVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/MotionDurationScale$Key;", "LH7/g;", "Landroidx/compose/ui/MotionDurationScale;", AppAgent.CONSTRUCT, "()V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.MotionDurationScale$Key, reason: from kotlin metadata */
    public static final class Companion implements g {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Override // H7.h
    /* synthetic */ Object fold(Object obj, n nVar);

    @Override // H7.h
    /* synthetic */ f get(g gVar);

    @Override // H7.f
    default g getKey() {
        return INSTANCE;
    }

    float getScaleFactor();

    @Override // H7.h
    /* synthetic */ h minusKey(g gVar);

    @Override // H7.h
    /* synthetic */ h plus(h hVar);
}
