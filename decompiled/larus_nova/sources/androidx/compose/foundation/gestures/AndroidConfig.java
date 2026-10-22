package androidx.compose.foundation.gestures;

import android.os.Build;
import android.view.ViewConfiguration;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00020\t*\u00020\nH\u0001¢\u0006\u0002\b\u000bJ\u0011\u0010\f\u001a\u00020\t*\u00020\nH\u0001¢\u0006\u0002\b\rJ#\u0010\u000e\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/gestures/AndroidConfig;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "viewConfiguration", "Landroid/view/ViewConfiguration;", "<init>", "(Landroid/view/ViewConfiguration;)V", "getViewConfiguration", "()Landroid/view/ViewConfiguration;", "getVerticalScrollFactor", "", "Landroidx/compose/ui/unit/Density;", "getVerticalScrollFactor$foundation_release", "getHorizontalScrollFactor", "getHorizontalScrollFactor$foundation_release", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidConfig implements ScrollConfig {
    public static final int $stable = 8;
    private final ViewConfiguration viewConfiguration;

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    public final /* synthetic */ boolean isPreciseWheelScroll(PointerEvent r100) {
        return ScrollConfig.CC.$default$isPreciseWheelScroll(this, r100);
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    public final /* synthetic */ boolean isSmoothScrollingEnabled() {
        return ScrollConfig.CC.$default$isSmoothScrollingEnabled(this);
    }

    public final ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public AndroidConfig(ViewConfiguration r100) {
        this.viewConfiguration = r100;
    }

    public final float getHorizontalScrollFactor$foundation_release(Density r100) {
        if (Build.VERSION.SDK_INT <= 26) goto L6;
        return ViewConfigurationApi26Impl.INSTANCE.getHorizontalScrollFactor(this.viewConfiguration);
    L6:
        return r100.mo371toPx0680j_4(Dp.m7544constructorimpl(64));
    }

    public final float getVerticalScrollFactor$foundation_release(Density r100) {
        if (Build.VERSION.SDK_INT <= 26) goto L6;
        return ViewConfigurationApi26Impl.INSTANCE.getVerticalScrollFactor(this.viewConfiguration);
    L6:
        return r100.mo371toPx0680j_4(Dp.m7544constructorimpl(64));
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* JADX INFO: renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long mo392calculateMouseWheelScroll8xgXZGE(Density r100, PointerEvent r101, long r110) {
        float r111 = -getVerticalScrollFactor$foundation_release(r100);
        float r102 = -getHorizontalScrollFactor$foundation_release(r100);
        List<PointerInputChange> r103 = r101.getChanges();
        Offset r112 = Offset.m4571boximpl(Offset.Companion.m4598getZeroF1C5BW0());
        int r104 = r103.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r112 = Offset.m4571boximpl(Offset.m4587plusMKHz9U(r112.m4592unboximpl(), ((PointerInputChange) ListProtector.get(r103, r105)).m6128getScrollDeltaF1C5BW0()));
        r105 = r105 + 1;
        goto L3
    L5:
        long r106 = r112.m4592unboximpl();
        float r113 = Float.intBitsToFloat((int) (r106 >> 32)) * r102;
        float r107 = Float.intBitsToFloat((int) (r106 & BodyPartID.bodyIdMax)) * r111;
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r113) << 32) | (Float.floatToRawIntBits(r107) & BodyPartID.bodyIdMax));
    }
}
