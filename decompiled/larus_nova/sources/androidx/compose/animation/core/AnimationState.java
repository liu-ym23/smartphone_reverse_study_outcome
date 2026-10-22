package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004BM\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010+\u001a\u00020,H\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u0001@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R$\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010&\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b*\u0010\u0015¨\u0006-"}, d2 = {"Landroidx/compose/animation/core/AnimationState;", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "", "<init>", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue$animation_core", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core", "(Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationVector;", "getLastFrameTimeNanos", "()J", "setLastFrameTimeNanos$animation_core", "(J)V", "getFinishedTimeNanos", "setFinishedTimeNanos$animation_core", "()Z", "setRunning$animation_core", "(Z)V", "velocity", "getVelocity", "toString", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationState<T, V extends AnimationVector> implements State<T> {
    public static final int $stable = 0;
    private long finishedTimeNanos;
    private boolean isRunning;
    private long lastFrameTimeNanos;
    private final TwoWayConverter<T, V> typeConverter;
    private final MutableState value$delegate;
    private V velocityVector;

    @Override // androidx.compose.runtime.State
    public T getValue() {
        return this.value$delegate.getValue();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public String toString() {
        return "AnimationState(value=" + getValue() + ", velocity=" + getVelocity() + ", isRunning=" + this.isRunning + ", lastFrameTimeNanos=" + this.lastFrameTimeNanos + ", finishedTimeNanos=" + this.finishedTimeNanos + ')';
    }

    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final V getVelocityVector() {
        return this.velocityVector;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final void setFinishedTimeNanos$animation_core(long r100) {
        this.finishedTimeNanos = r100;
    }

    public final void setLastFrameTimeNanos$animation_core(long r100) {
        this.lastFrameTimeNanos = r100;
    }

    public final void setRunning$animation_core(boolean r100) {
        this.isRunning = r100;
    }

    public void setValue$animation_core(T r100) {
        this.value$delegate.setValue(r100);
    }

    public final void setVelocityVector$animation_core(V r100) {
        this.velocityVector = r100;
    }

    public AnimationState(TwoWayConverter<T, V> r100, T r101, V r102, long r103, long r104, boolean r110) {
        this.typeConverter = r100;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(r101, null, 2, null);
        if (r102 == null) goto L6;
        V r105 = (V) AnimationVectorsKt.copy(r102);
        if (r105 == null) goto L6;
    L7:
        this.velocityVector = r105;
        this.lastFrameTimeNanos = r103;
        this.finishedTimeNanos = r104;
        this.isRunning = r110;
        return;
    L6:
        r105 = (V) AnimationStateKt.createZeroVectorFrom(r100, r101);
        goto L7
    }

    public /* synthetic */ AnimationState(TwoWayConverter r110, Object r111, AnimationVector r112, long r113, long r114, boolean r115, int r116, DefaultConstructorMarker r210) {
        if ((r116 & 4) == 0) goto L5;
        AnimationVector r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        long r101 = Long.MIN_VALUE;
    L11:
        if ((r116 & 16) == 0) goto L13;
        long r102 = Long.MIN_VALUE;
    L15:
        if ((r116 & 32) == 0) goto L17;
        boolean r103 = false;
    L18:
        this(r110, r111, r100, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
