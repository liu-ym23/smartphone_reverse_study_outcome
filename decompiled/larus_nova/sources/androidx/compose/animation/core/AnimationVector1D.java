package androidx.compose.animation.core;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\n\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\u0000H\u0010¢\u0006\u0002\b\u000eJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0090\u0002¢\u0006\u0002\b\u0012J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0003H\u0090\u0002¢\u0006\u0002\b\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0016R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u0014\u0010\u0015\u001a\u00020\u0011X\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/AnimationVector;", "initVal", "", "<init>", "(F)V", "value", "getValue", "()F", "setValue$animation_core", BasicTestActionHandler.TEST_ACTION_RESET, "", "reset$animation_core", "newVector", "newVector$animation_core", MonitorConstants.CONNECT_TYPE_GET, "index", "", "get$animation_core", "set", "set$animation_core", "size", "getSize$animation_core", "()I", "toString", "", "equals", "", "other", "", "hashCode", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationVector1D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;
    private float value;

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core() {
        this.value = 0.0f;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public AnimationVector1D newVector$animation_core() {
        return new AnimationVector1D(0.0f);
    }

    public String toString() {
        return "AnimationVector1D: value = " + this.value;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core() {
        return this.size;
    }

    public final float getValue() {
        return this.value;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public /* bridge */ /* synthetic */ AnimationVector newVector$animation_core() {
        return newVector$animation_core();
    }

    public AnimationVector1D(float r100) {
        super(null);
        this.value = r100;
        this.size = 1;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AnimationVector1D) == true) goto L5;
        return false;
    L5:
        if (((AnimationVector1D) r100).value != this.value) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core(int r100) {
        if (r100 == 0) goto L4;
        return 0.0f;
    L4:
        return this.value;
    }

    public final void setValue$animation_core(float r100) {
        this.value = r100;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core(int r100, float r101) {
        if (r100 != 0) goto L5;
        this.value = r101;
        return;
    }
}
