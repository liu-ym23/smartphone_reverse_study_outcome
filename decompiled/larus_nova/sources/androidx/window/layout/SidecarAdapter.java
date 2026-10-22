package androidx.window.layout;

import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\f\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0014J\u0018\u0010\u0010\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\bJ\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/SidecarAdapter;", "", "verificationMode", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "(Landroidx/window/core/SpecificationComputer$VerificationMode;)V", "isEqualSidecarDeviceState", "", SoloKtvContext.SOLO_PAGE_FIRST, "Landroidx/window/sidecar/SidecarDeviceState;", "second", "isEqualSidecarDisplayFeature", "Landroidx/window/sidecar/SidecarDisplayFeature;", "isEqualSidecarDisplayFeatures", "", "isEqualSidecarWindowLayoutInfo", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "translate", "Landroidx/window/layout/DisplayFeature;", "feature", "deviceState", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "extensionInfo", "state", "sidecarDisplayFeatures", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SidecarAdapter {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private final SpecificationComputer.VerificationMode verificationMode;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0007J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/SidecarAdapter$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getRawSidecarDevicePosture", "", "sidecarDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "getSidecarDevicePosture", "getSidecarDevicePosture$window_release", "getSidecarDisplayFeatures", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "info", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "setSidecarDevicePosture", "", "posture", "setSidecarDisplayFeatures", "displayFeatures", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final int getRawSidecarDevicePosture(SidecarDeviceState r100) {
            Intrinsics.checkNotNullParameter(r100, "sidecarDeviceState");
            return r100.posture;
        L15:
            Object r101 = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L12
            if (r101 == null) goto L11;
            return ((Integer) r101).intValue();
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L12
        L12:
            return 0;
        }

        public final int getSidecarDevicePosture$window_release(SidecarDeviceState r100) {
            Intrinsics.checkNotNullParameter(r100, "sidecarDeviceState");
            int r101 = getRawSidecarDevicePosture(r100);
            if (r101 >= 0) goto L5;
        L6:
            return 0;
        L5:
            if (r101 > 4) goto L6;
            return r101;
        }

        public final List<SidecarDisplayFeature> getSidecarDisplayFeatures(SidecarWindowLayoutInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            List<SidecarDisplayFeature> r101 = r100.displayFeatures;     // Catch: NoSuchFieldError -> L7
            if (r101 != null) goto L17;
            return CollectionsKt.emptyList();
        L17:
            return r101;
        L7:
            Object r102 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L13
            if (r102 == null) goto L12;
            return (List) r102;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");     // Catch: Throwable -> L13
        L14:
            return CollectionsKt.emptyList();
        }

        public final void setSidecarDevicePosture(SidecarDeviceState r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "sidecarDeviceState");
            r100.posture = r101;     // Catch: NoSuchFieldError -> L5
            return;
        L5:
            SidecarDeviceState.class.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Throwable -> L7
            return;
        }

        public final void setSidecarDisplayFeatures(SidecarWindowLayoutInfo r100, List<SidecarDisplayFeature> r101) {
            Intrinsics.checkNotNullParameter(r100, "info");
            Intrinsics.checkNotNullParameter(r101, "displayFeatures");
            r100.displayFeatures = r101;     // Catch: NoSuchFieldError -> L5
            return;
        L5:
            SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", new Class[]{List.class}).invoke(r100, new Object[]{r101});     // Catch: Throwable -> L7
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SidecarAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    static {
        Companion = new Companion(null);
        TAG = "SidecarAdapter";
    }

    public SidecarAdapter(SpecificationComputer.VerificationMode r100) {
        Intrinsics.checkNotNullParameter(r100, "verificationMode");
        this.verificationMode = r100;
    }

    private final boolean isEqualSidecarDisplayFeature(SidecarDisplayFeature r100, SidecarDisplayFeature r101) {
        if (Intrinsics.areEqual(r100, r101) == false) goto L7;
        return true;
    L7:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (r101 != null) goto L12;
        return false;
    L12:
        if (r100.getType() == r101.getType()) goto L15;
        return false;
    L15:
        return Intrinsics.areEqual(r100.getRect(), r101.getRect());
    }

    private final boolean isEqualSidecarDisplayFeatures(List<SidecarDisplayFeature> r100, List<SidecarDisplayFeature> r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r100.size() == r101.size()) goto L13;
        return false;
    L13:
        int r102 = r100.size();
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L19;
        if (isEqualSidecarDisplayFeature((SidecarDisplayFeature) ListProtector.get(r100, r103), (SidecarDisplayFeature) ListProtector.get(r101, r103)) == false) goto L17;
        r103 = r103 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public final boolean isEqualSidecarDeviceState(SidecarDeviceState r100, SidecarDeviceState r101) {
        if (Intrinsics.areEqual(r100, r101) == false) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r101 != null) goto L10;
        return false;
    L10:
        Companion r102 = Companion;
        if (r102.getSidecarDevicePosture$window_release(r100) == r102.getSidecarDevicePosture$window_release(r101)) goto L15;
        return false;
    L15:
        return true;
    }

    public final boolean isEqualSidecarWindowLayoutInfo(SidecarWindowLayoutInfo r100, SidecarWindowLayoutInfo r101) {
        if (Intrinsics.areEqual(r100, r101) == false) goto L7;
        return true;
    L7:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (r101 != null) goto L11;
        return false;
    L11:
        Companion r102 = Companion;
        return isEqualSidecarDisplayFeatures(r102.getSidecarDisplayFeatures(r100), r102.getSidecarDisplayFeatures(r101));
    }

    public final WindowLayoutInfo translate(SidecarWindowLayoutInfo r100, SidecarDeviceState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        if (r100 == null) goto L5;
        SidecarDeviceState r102 = new SidecarDeviceState();
        Companion r103 = Companion;
        r103.setSidecarDevicePosture(r102, r103.getSidecarDevicePosture$window_release(r101));
        return new WindowLayoutInfo(translate(r103.getSidecarDisplayFeatures(r100), r102));
    L5:
        return new WindowLayoutInfo(CollectionsKt.emptyList());
    }

    public final DisplayFeature translate$window_release(SidecarDisplayFeature r100, SidecarDeviceState r110) {
        Intrinsics.checkNotNullParameter(r100, "feature");
        Intrinsics.checkNotNullParameter(r110, "deviceState");
        SidecarDisplayFeature r101 = (SidecarDisplayFeature) SpecificationComputer.Companion.startSpecification$default(SpecificationComputer.Companion, r100, TAG, this.verificationMode, null, 4, null).require("Type must be either TYPE_FOLD or TYPE_HINGE", SidecarAdapter$translate$checkedFeature$1.INSTANCE).require("Feature bounds must not be 0", SidecarAdapter$translate$checkedFeature$2.INSTANCE).require("TYPE_FOLD must have 0 area", SidecarAdapter$translate$checkedFeature$3.INSTANCE).require("Feature be pinned to either left or top", SidecarAdapter$translate$checkedFeature$4.INSTANCE).compute();
        if (r101 != null) goto L5;
        return null;
    L5:
        int r102 = r101.getType();
        if (r102 == 1) goto L10;
        if (r102 == 2) goto L9;
        return null;
    L9:
        HardwareFoldingFeature.Type r103 = HardwareFoldingFeature.Type.Companion.getHINGE();
    L11:
        int r111 = Companion.getSidecarDevicePosture$window_release(r110);
        if (r111 == 0) goto L24;
        if (r111 == 1) goto L25;
        if (r111 != 2) goto L16;
        FoldingFeature.State r112 = FoldingFeature.State.HALF_OPENED;
    L23:
        return new HardwareFoldingFeature(new Bounds(r100.getRect()), r103, r112);
    L16:
        if (r111 != 3) goto L18;
        r112 = FoldingFeature.State.FLAT;
        goto L23
    L18:
        if (r111 == 4) goto L26;
        r112 = FoldingFeature.State.FLAT;
        goto L23
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L10:
        r103 = HardwareFoldingFeature.Type.Companion.getFOLD();
        goto L11
    }

    public final List<DisplayFeature> translate(List<SidecarDisplayFeature> r100, SidecarDeviceState r101) {
        Intrinsics.checkNotNullParameter(r100, "sidecarDisplayFeatures");
        Intrinsics.checkNotNullParameter(r101, "deviceState");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        DisplayFeature r104 = translate$window_release((SidecarDisplayFeature) r103.next(), r101);
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    public /* synthetic */ SidecarAdapter(SpecificationComputer.VerificationMode r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = SpecificationComputer.VerificationMode.QUIET;
    L5:
        this(r100);
    }
}
