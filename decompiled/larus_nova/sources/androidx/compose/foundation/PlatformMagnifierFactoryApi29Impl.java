package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import kotlin.Metadata;
import kotlin.math.MathKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "view", "Landroid/view/View;", "useTextDefault", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "create-nHHXs2Y", "(Landroid/view/View;ZJFFZLandroidx/compose/ui/unit/Density;F)Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "PlatformMagnifierImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final int $stable = 0;
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = null;
    private static final boolean canUpdateZoom = false;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "magnifier", "Landroid/widget/Magnifier;", "<init>", "(Landroid/widget/Magnifier;)V", "update", "", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", GestureAction.zoom, "", "update-Wko1d7g", "(JJF)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public static final int $stable = 8;

        public PlatformMagnifierImpl(Magnifier r100) {
            super(r100);
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* JADX INFO: renamed from: update-Wko1d7g */
        public void mo321updateWko1d7g(long r100, long r101, float r110) {
            if (Float.isNaN(r110) == true) goto L6;
            getMagnifier().setZoom(r110);
        L6:
            if ((9223372034707292159L & r101) == InlineClassHelperKt.UnspecifiedPackedFloats) goto L8;
            boolean r111 = true;
        L10:
            if (r111 == false) goto L12;
            getMagnifier().show(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)));
            return;
        L12:
            getMagnifier().show(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)));
            return;
        L8:
            r111 = false;
            goto L10
        }
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    static {
        INSTANCE = new PlatformMagnifierFactoryApi29Impl();
        canUpdateZoom = true;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: create-nHHXs2Y */
    public PlatformMagnifierImpl mo322createnHHXs2Y(View r100, boolean r101, long r102, float r103, float r104, boolean r105, Density r110, float r111) {
        if (r101 == true) goto L4;
        long r106 = r110.mo372toSizeXkaWNTQ(r102);
        float r107 = r110.mo371toPx0680j_4(r103);
        float r108 = r110.mo371toPx0680j_4(r104);
        Magnifier.Builder r109 = new Magnifier.Builder(r100);
        if (r106 == InlineClassHelperKt.UnspecifiedPackedFloats) goto L8;
        boolean r112 = true;
    L9:
        if (r112 == false) goto L12;
        r109.setSize(MathKt.roundToInt(Float.intBitsToFloat((int) (r106 >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (r106 & BodyPartID.bodyIdMax))));
    L12:
        if (Float.isNaN(r107) == true) goto L15;
        r109.setCornerRadius(r107);
    L15:
        if (Float.isNaN(r108) == true) goto L18;
        r109.setElevation(r108);
    L18:
        if (Float.isNaN(r111) == true) goto L20;
        r109.setInitialZoom(r111);
    L20:
        r109.setClippingEnabled(r105);
        return new PlatformMagnifierImpl(r109.build());
    L8:
        r112 = false;
        goto L9
    L4:
        return new PlatformMagnifierImpl(new Magnifier(r100));
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: create-nHHXs2Y */
    public /* bridge */ /* synthetic */ PlatformMagnifier mo322createnHHXs2Y(View r100, boolean r101, long r102, float r103, float r104, boolean r105, Density r106, float r107) {
        return mo322createnHHXs2Y(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
