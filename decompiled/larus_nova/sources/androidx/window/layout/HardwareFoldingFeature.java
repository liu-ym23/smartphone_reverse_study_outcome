package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 #2\u00020\u0001:\u0002#$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature;", "Landroidx/window/layout/FoldingFeature;", "featureBounds", "Landroidx/window/core/Bounds;", "type", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "state", "Landroidx/window/layout/FoldingFeature$State;", "(Landroidx/window/core/Bounds;Landroidx/window/layout/HardwareFoldingFeature$Type;Landroidx/window/layout/FoldingFeature$State;)V", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "isSeparating", "", "()Z", "occlusionType", "Landroidx/window/layout/FoldingFeature$OcclusionType;", "getOcclusionType", "()Landroidx/window/layout/FoldingFeature$OcclusionType;", "orientation", "Landroidx/window/layout/FoldingFeature$Orientation;", "getOrientation", "()Landroidx/window/layout/FoldingFeature$Orientation;", "getState", "()Landroidx/window/layout/FoldingFeature$State;", "getType$window_release", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "Type", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HardwareFoldingFeature implements FoldingFeature {
    public static final Companion Companion = null;
    private final Bounds featureBounds;
    private final FoldingFeature.State state;
    private final Type type;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Companion;", "", "()V", "validateFeatureBounds", "", "bounds", "Landroidx/window/core/Bounds;", "validateFeatureBounds$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void validateFeatureBounds$window_release(Bounds r100) {
            Intrinsics.checkNotNullParameter(r100, "bounds");
            boolean r101 = false;
            if (r100.getWidth() == 0) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L20;
            if (r100.getLeft() != 0) goto L13;
        L14:
            r101 = true;
        L15:
            if (r101 == false) goto L18;
            return;
        L18:
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
        L13:
            if (r100.getTop() != 0) goto L15;
        L20:
            throw new IllegalArgumentException("Bounds must be non zero".toString());
        L5:
            if (r100.getHeight() != 0) goto L8;
            r102 = false;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type;", "", "description", "", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Type {
        public static final Companion Companion = null;
        private static final Type FOLD = null;
        private static final Type HINGE = null;
        private final String description;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type$Companion;", "", "()V", "FOLD", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "getFOLD", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "HINGE", "getHINGE", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final Type getFOLD() {
                return Type.access$getFOLD$cp();
            }

            public final Type getHINGE() {
                return Type.access$getHINGE$cp();
            }
        }

        static {
            Companion = new Companion(null);
            FOLD = new Type("FOLD");
            HINGE = new Type("HINGE");
        }

        public static final /* synthetic */ Type access$getFOLD$cp() {
            return FOLD;
        }

        public static final /* synthetic */ Type access$getHINGE$cp() {
            return HINGE;
        }

        public String toString() {
            return this.description;
        }

        private Type(String r100) {
            this.description = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.window.layout.DisplayFeature
    public Rect getBounds() {
        return this.featureBounds.toRect();
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.OcclusionType getOcclusionType() {
        if (this.featureBounds.getWidth() == 0) goto L9;
        if (this.featureBounds.getHeight() == 0) goto L9;
        return FoldingFeature.OcclusionType.FULL;
    L9:
        return FoldingFeature.OcclusionType.NONE;
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.Orientation getOrientation() {
        if (this.featureBounds.getWidth() <= this.featureBounds.getHeight()) goto L6;
        return FoldingFeature.Orientation.HORIZONTAL;
    L6:
        return FoldingFeature.Orientation.VERTICAL;
    }

    public int hashCode() {
        return (((this.featureBounds.hashCode() * 31) + this.type.hashCode()) * 31) + getState().hashCode();
    }

    @Override // androidx.window.layout.FoldingFeature
    public boolean isSeparating() {
        Type r100 = this.type;
        Type.Companion r101 = Type.Companion;
        if (Intrinsics.areEqual(r100, r101.getHINGE()) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(this.type, r101.getFOLD()) == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(getState(), FoldingFeature.State.HALF_OPENED) == false) goto L10;
        return true;
    }

    public String toString() {
        return "HardwareFoldingFeature { " + this.featureBounds + ", type=" + this.type + ", state=" + getState() + " }";
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.State getState() {
        return this.state;
    }

    public final Type getType$window_release() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(HardwareFoldingFeature.class, r101) == true) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        HardwareFoldingFeature r102 = (HardwareFoldingFeature) r100;
        if (Intrinsics.areEqual(this.featureBounds, r102.featureBounds) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.type, r102.type) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(getState(), r102.getState()) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
    L8:
        r101 = null;
        goto L10
    }

    public HardwareFoldingFeature(Bounds r100, Type r101, FoldingFeature.State r102) {
        Intrinsics.checkNotNullParameter(r100, "featureBounds");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "state");
        this.featureBounds = r100;
        this.type = r101;
        this.state = r102;
        Companion.validateFeatureBounds$window_release(r100);
    }
}
