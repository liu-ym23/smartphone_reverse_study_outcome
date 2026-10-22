package androidx.compose.ui.graphics;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/PathEffect;", "", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PathEffect {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J-\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/PathEffect$Companion;", "", "<init>", "()V", "cornerPathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "radius", "", "dashPathEffect", "intervals", "", "phase", "chainPathEffect", RNParamRegisterEventHandler.SRC_OUTER, RNParamRegisterEventHandler.SRC_INNER, "stampedPathEffect", "shape", "Landroidx/compose/ui/graphics/Path;", "advance", "style", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "stampedPathEffect-7aD1DOk", "(Landroidx/compose/ui/graphics/Path;FFI)Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final PathEffect cornerPathEffect(float r100) {
            return AndroidPathEffect_androidKt.actualCornerPathEffect(r100);
        }

        public final PathEffect chainPathEffect(PathEffect r100, PathEffect r101) {
            return AndroidPathEffect_androidKt.actualChainPathEffect(r100, r101);
        }

        public final PathEffect dashPathEffect(float[] r100, float r101) {
            return AndroidPathEffect_androidKt.actualDashPathEffect(r100, r101);
        }

        /* JADX INFO: renamed from: stampedPathEffect-7aD1DOk, reason: not valid java name */
        public final PathEffect m5122stampedPathEffect7aD1DOk(Path r100, float r101, float r102, int r103) {
            return AndroidPathEffect_androidKt.m4721actualStampedPathEffect7aD1DOk(r100, r101, r102, r103);
        }

        public static /* synthetic */ PathEffect dashPathEffect$default(Companion r100, float[] r101, float r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = 0.0f;
        L6:
            return r100.dashPathEffect(r101, r102);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
