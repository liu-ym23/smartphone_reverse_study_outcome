package androidx.compose.animation.core;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0000H\u0010¢\u0006\u0002\b\u0015J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0090\u0002¢\u0006\u0002\b\u0019J\u001e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0003H\u0090\u0002¢\u0006\u0002\b\u001bJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u0018H\u0016R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0014\u0010\u001c\u001a\u00020\u0018X\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Landroidx/compose/animation/core/AnimationVector3D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "v3", "<init>", "(FFF)V", "value", "getV1", "()F", "setV1$animation_core", "(F)V", "getV2", "setV2$animation_core", "getV3", "setV3$animation_core", BasicTestActionHandler.TEST_ACTION_RESET, "", "reset$animation_core", "newVector", "newVector$animation_core", MonitorConstants.CONNECT_TYPE_GET, "index", "", "get$animation_core", "set", "set$animation_core", "size", "getSize$animation_core", "()I", "toString", "", "equals", "", "other", "", "hashCode", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationVector3D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private float f5641v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    private float f5642v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    private float f5643v3;

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core() {
        this.f5641v1 = 0.0f;
        this.f5642v2 = 0.0f;
        this.f5643v3 = 0.0f;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f5641v1) * 31) + Float.floatToIntBits(this.f5642v2)) * 31) + Float.floatToIntBits(this.f5643v3);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public AnimationVector3D newVector$animation_core() {
        return new AnimationVector3D(0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "AnimationVector3D: v1 = " + this.f5641v1 + ", v2 = " + this.f5642v2 + ", v3 = " + this.f5643v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core() {
        return this.size;
    }

    public final float getV1() {
        return this.f5641v1;
    }

    public final float getV2() {
        return this.f5642v2;
    }

    public final float getV3() {
        return this.f5643v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public /* bridge */ /* synthetic */ AnimationVector newVector$animation_core() {
        return newVector$animation_core();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AnimationVector3D) == false) goto L21;
        AnimationVector3D r101 = (AnimationVector3D) r100;
        if (r101.f5641v1 != this.f5641v1) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (r101.f5642v2 != this.f5642v2) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        return false;
    L15:
        if (r101.f5643v3 != this.f5643v3) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L24;
        return true;
    L24:
        return false;
    L17:
        r104 = false;
        goto L18
    L12:
        r103 = false;
        goto L13
    L7:
        r102 = false;
        goto L8
    L21:
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core(int r100) {
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L13;
        return 0.0f;
    L13:
        return this.f5643v3;
    L14:
        return this.f5642v2;
    L11:
        return this.f5641v1;
    }

    public final void setV1$animation_core(float r100) {
        this.f5641v1 = r100;
    }

    public final void setV2$animation_core(float r100) {
        this.f5642v2 = r100;
    }

    public final void setV3$animation_core(float r100) {
        this.f5643v3 = r100;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core(int r100, float r101) {
        if (r100 != 0) goto L4;
        this.f5641v1 = r101;
        return;
    L4:
        if (r100 != 1) goto L6;
        this.f5642v2 = r101;
        return;
    L6:
        if (r100 != 2) goto L14;
        this.f5643v3 = r101;
        return;
    }

    public AnimationVector3D(float r100, float r101, float r102) {
        super(null);
        this.f5641v1 = r100;
        this.f5642v2 = r101;
        this.f5643v3 = r102;
        this.size = 3;
    }
}
