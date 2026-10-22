package androidx.compose.material3;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Integer> {
    public static final InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1 INSTANCE = null;

    static {
        INSTANCE = new InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1();
    }

    public InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1() {
        super(2, MathKt.class, BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "min(II)I", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Integer r100, Integer r101) {
        return invoke(r100.intValue(), r101.intValue());
    }

    public final Integer invoke(int r100, int r101) {
        return Integer.valueOf(Math.min(r100, r101));
    }
}
