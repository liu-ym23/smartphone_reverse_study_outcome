package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u0012\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001c\u0010\u0019R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\u001e\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Landroidx/compose/ui/graphics/Shadow;", "", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "", "blurRadius", AppAgent.CONSTRUCT, "(JJFLkotlin/jvm/internal/e;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "copy-qcb84PM", "(JJF)Landroidx/compose/ui/graphics/Shadow;", "copy", "J", "getColor-0d7_KjU", "()J", "getColor-0d7_KjU$annotations", "()V", "getOffset-F1C5BW0", "getOffset-F1C5BW0$annotations", "F", "getBlurRadius", "()F", "getBlurRadius$annotations", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Shadow {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Shadow None = new Shadow(0, 0, 0.0f, 7, null);
    private final float blurRadius;
    private final long color;
    private final long offset;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/Shadow$Companion;", "", AppAgent.CONSTRUCT, "()V", "None", "Landroidx/compose/ui/graphics/Shadow;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/graphics/Shadow;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        public final Shadow getNone() {
            return Shadow.None;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Shadow(long j5, long j6, float f, e eVar) {
        this(j5, j6, f);
    }

    /* renamed from: copy-qcb84PM$default, reason: not valid java name */
    public static /* synthetic */ Shadow m4474copyqcb84PM$default(Shadow shadow, long j5, long j6, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = shadow.color;
        }
        long j10 = j5;
        if ((i & 2) != 0) {
            j6 = shadow.offset;
        }
        long j11 = j6;
        if ((i & 4) != 0) {
            f = shadow.blurRadius;
        }
        return shadow.m4477copyqcb84PM(j10, j11, f);
    }

    @Stable
    public static /* synthetic */ void getBlurRadius$annotations() {
    }

    @Stable
    /* renamed from: getColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m4475getColor0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getOffset-F1C5BW0$annotations, reason: not valid java name */
    public static /* synthetic */ void m4476getOffsetF1C5BW0$annotations() {
    }

    /* renamed from: copy-qcb84PM, reason: not valid java name */
    public final Shadow m4477copyqcb84PM(long color, long offset, float blurRadius) {
        return new Shadow(color, offset, blurRadius, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) other;
        return Color.m4140equalsimpl0(this.color, shadow.color) && Offset.m3892equalsimpl0(this.offset, shadow.offset) && this.blurRadius == shadow.blurRadius;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* renamed from: getOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getOffset() {
        return this.offset;
    }

    public int hashCode() {
        return Float.hashCode(this.blurRadius) + ((Offset.m3897hashCodeimpl(this.offset) + (Color.m4146hashCodeimpl(this.color) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Shadow(color=");
        androidx.compose.foundation.b.z(this.color, ", offset=", sb);
        sb.append((Object) Offset.m3903toStringimpl(this.offset));
        sb.append(", blurRadius=");
        return androidx.appfunctions.metadata.a.n(sb, this.blurRadius, ')');
    }

    private Shadow(long j5, long j6, float f) {
        this.color = j5;
        this.offset = j6;
        this.blurRadius = f;
    }

    public /* synthetic */ Shadow(long j5, long j6, float f, int i, e eVar) {
        this((i & 1) != 0 ? ColorKt.Color(4278190080L) : j5, (i & 2) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j6, (i & 4) != 0 ? 0.0f : f, null);
    }
}
