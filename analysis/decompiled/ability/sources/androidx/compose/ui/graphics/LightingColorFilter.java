package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/LightingColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/Color;", "multiply", "add", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "nativeColorFilter", AppAgent.CONSTRUCT, "(JJLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/e;)V", "(JJLkotlin/jvm/internal/e;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getMultiply-0d7_KjU", "()J", "getAdd-0d7_KjU", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LightingColorFilter extends ColorFilter {
    private final long add;
    private final long multiply;

    public /* synthetic */ LightingColorFilter(long j5, long j6, android.graphics.ColorFilter colorFilter, e eVar) {
        this(j5, j6, colorFilter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LightingColorFilter)) {
            return false;
        }
        LightingColorFilter lightingColorFilter = (LightingColorFilter) other;
        return Color.m4140equalsimpl0(this.multiply, lightingColorFilter.multiply) && Color.m4140equalsimpl0(this.add, lightingColorFilter.add);
    }

    /* renamed from: getAdd-0d7_KjU, reason: not valid java name and from getter */
    public final long getAdd() {
        return this.add;
    }

    /* renamed from: getMultiply-0d7_KjU, reason: not valid java name and from getter */
    public final long getMultiply() {
        return this.multiply;
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.add) + (Color.m4146hashCodeimpl(this.multiply) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LightingColorFilter(multiply=");
        androidx.compose.foundation.b.z(this.multiply, ", add=", sb);
        sb.append((Object) Color.m4147toStringimpl(this.add));
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ LightingColorFilter(long j5, long j6, e eVar) {
        this(j5, j6);
    }

    private LightingColorFilter(long j5, long j6, android.graphics.ColorFilter colorFilter) {
        super(colorFilter);
        this.multiply = j5;
        this.add = j6;
    }

    private LightingColorFilter(long j5, long j6) {
        this(j5, j6, AndroidColorFilter_androidKt.m4001actualLightingColorFilterOWjLjI(j5, j6), null);
    }
}
