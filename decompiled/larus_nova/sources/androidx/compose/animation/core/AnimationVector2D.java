package androidx.compose.animation.core;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u0000H\u0010¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0090\u0002¢\u0006\u0002\b\u0016J\u001e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0003H\u0090\u0002¢\u0006\u0002\b\u0018J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0015H\u0016R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u0015X\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "<init>", "(FF)V", "value", "getV1", "()F", "setV1$animation_core", "(F)V", "getV2", "setV2$animation_core", BasicTestActionHandler.TEST_ACTION_RESET, "", "reset$animation_core", "newVector", "newVector$animation_core", MonitorConstants.CONNECT_TYPE_GET, "index", "", "get$animation_core", "set", "set$animation_core", "size", "getSize$animation_core", "()I", "toString", "", "equals", "", "other", "", "hashCode", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationVector2D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private float f5639v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    private float f5640v2;

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core() {
        this.f5639v1 = 0.0f;
        this.f5640v2 = 0.0f;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f5639v1) * 31) + Float.floatToIntBits(this.f5640v2);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public AnimationVector2D newVector$animation_core() {
        return new AnimationVector2D(0.0f, 0.0f);
    }

    public String toString() {
        return "AnimationVector2D: v1 = " + this.f5639v1 + ", v2 = " + this.f5640v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core() {
        return this.size;
    }

    public final float getV1() {
        return this.f5639v1;
    }

    public final float getV2() {
        return this.f5640v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public /* bridge */ /* synthetic */ AnimationVector newVector$animation_core() {
        return newVector$animation_core();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AnimationVector2D) == false) goto L16;
        AnimationVector2D r101 = (AnimationVector2D) r100;
        if (r101.f5639v1 != this.f5639v1) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (r101.f5640v2 != this.f5640v2) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L18;
        return true;
    L18:
        return false;
    L12:
        r103 = false;
        goto L13
    L7:
        r102 = false;
        goto L8
    L16:
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core(int r100) {
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L10;
        return 0.0f;
    L10:
        return this.f5640v2;
    L8:
        return this.f5639v1;
    }

    public final void setV1$animation_core(float r100) {
        this.f5639v1 = r100;
    }

    public final void setV2$animation_core(float r100) {
        this.f5640v2 = r100;
    }

    public AnimationVector2D(float r100, float r101) {
        super(null);
        this.f5639v1 = r100;
        this.f5640v2 = r101;
        this.size = 2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core(int r100, float r101) {
        if (r100 != 0) goto L4;
        this.f5639v1 = r101;
        return;
    L4:
        if (r100 != 1) goto L10;
        this.f5640v2 = r101;
        return;
    }
}
