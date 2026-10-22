package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/ColorFilter;", "", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", AppAgent.CONSTRUCT, "(Landroid/graphics/ColorFilter;)V", "getNativeColorFilter$ui_graphics_release", "()Landroid/graphics/ColorFilter;", "Landroid/graphics/ColorFilter;", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class ColorFilter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final android.graphics.ColorFilter nativeColorFilter;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/ColorFilter$Companion;", "", AppAgent.CONSTRUCT, "()V", "tint", "Landroidx/compose/ui/graphics/ColorFilter;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "tint-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorMatrix-jHG-Opc", "([F)Landroidx/compose/ui/graphics/ColorFilter;", "lighting", "multiply", "add", "lighting--OWjLjI", "(JJ)Landroidx/compose/ui/graphics/ColorFilter;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: tint-xETnrds$default, reason: not valid java name */
        public static /* synthetic */ ColorFilter m4180tintxETnrds$default(Companion companion, long j5, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i = BlendMode.INSTANCE.m4078getSrcIn0nO6VwU();
            }
            return companion.m4183tintxETnrds(j5, i);
        }

        @Stable
        /* renamed from: colorMatrix-jHG-Opc, reason: not valid java name */
        public final ColorFilter m4181colorMatrixjHGOpc(float[] colorMatrix) {
            return new ColorMatrixColorFilter(colorMatrix, (e) null);
        }

        @Stable
        /* renamed from: lighting--OWjLjI, reason: not valid java name */
        public final ColorFilter m4182lightingOWjLjI(long multiply, long add) {
            return new LightingColorFilter(multiply, add, (e) null);
        }

        @Stable
        /* renamed from: tint-xETnrds, reason: not valid java name */
        public final ColorFilter m4183tintxETnrds(long color, int blendMode) {
            return new BlendModeColorFilter(color, blendMode, (e) null);
        }

        private Companion() {
        }
    }

    public ColorFilter(android.graphics.ColorFilter colorFilter) {
        this.nativeColorFilter = colorFilter;
    }

    /* renamed from: getNativeColorFilter$ui_graphics_release, reason: from getter */
    public final android.graphics.ColorFilter getNativeColorFilter() {
        return this.nativeColorFilter;
    }
}
