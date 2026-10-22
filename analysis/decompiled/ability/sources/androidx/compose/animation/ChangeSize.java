package androidx.compose.animation;

import S7.k;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014JJ\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u000eR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010\u0012R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010\u0014¨\u0006("}, d2 = {"Landroidx/compose/animation/ChangeSize;", "", "Landroidx/compose/ui/Alignment;", "alignment", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "size", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "", "clip", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/Alignment;LS7/k;Landroidx/compose/animation/core/FiniteAnimationSpec;Z)V", "component1", "()Landroidx/compose/ui/Alignment;", "component2", "()LS7/k;", "component3", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "component4", "()Z", "copy", "(Landroidx/compose/ui/Alignment;LS7/k;Landroidx/compose/animation/core/FiniteAnimationSpec;Z)Landroidx/compose/animation/ChangeSize;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/Alignment;", "getAlignment", "LS7/k;", "getSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAnimationSpec", "Z", "getClip", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ChangeSize {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final FiniteAnimationSpec<IntSize> animationSpec;
    private final boolean clip;
    private final k size;

    public ChangeSize(Alignment alignment, k kVar, FiniteAnimationSpec<IntSize> finiteAnimationSpec, boolean z10) {
        this.alignment = alignment;
        this.size = kVar;
        this.animationSpec = finiteAnimationSpec;
        this.clip = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangeSize copy$default(ChangeSize changeSize, Alignment alignment, k kVar, FiniteAnimationSpec finiteAnimationSpec, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = changeSize.alignment;
        }
        if ((i & 2) != 0) {
            kVar = changeSize.size;
        }
        if ((i & 4) != 0) {
            finiteAnimationSpec = changeSize.animationSpec;
        }
        if ((i & 8) != 0) {
            z10 = changeSize.clip;
        }
        return changeSize.copy(alignment, kVar, finiteAnimationSpec, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: component2, reason: from getter */
    public final k getSize() {
        return this.size;
    }

    public final FiniteAnimationSpec<IntSize> component3() {
        return this.animationSpec;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getClip() {
        return this.clip;
    }

    public final ChangeSize copy(Alignment alignment, k size, FiniteAnimationSpec<IntSize> animationSpec, boolean clip) {
        return new ChangeSize(alignment, size, animationSpec, clip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangeSize)) {
            return false;
        }
        ChangeSize changeSize = (ChangeSize) other;
        return kotlin.jvm.internal.k.b(this.alignment, changeSize.alignment) && kotlin.jvm.internal.k.b(this.size, changeSize.size) && kotlin.jvm.internal.k.b(this.animationSpec, changeSize.animationSpec) && this.clip == changeSize.clip;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final FiniteAnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final k getSize() {
        return this.size;
    }

    public int hashCode() {
        return Boolean.hashCode(this.clip) + ((this.animationSpec.hashCode() + ((this.size.hashCode() + (this.alignment.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChangeSize(alignment=");
        sb.append(this.alignment);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", animationSpec=");
        sb.append(this.animationSpec);
        sb.append(", clip=");
        return androidx.appfunctions.metadata.a.r(sb, this.clip, ')');
    }

    public /* synthetic */ ChangeSize(Alignment alignment, k kVar, FiniteAnimationSpec finiteAnimationSpec, boolean z10, int i, e eVar) {
        this(alignment, (i & 2) != 0 ? new k() { // from class: androidx.compose.animation.ChangeSize.1
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m7007boximpl(m68invokemzRDjE0(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m68invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(0, 0);
            }
        } : kVar, finiteAnimationSpec, (i & 8) != 0 ? true : z10);
    }
}
