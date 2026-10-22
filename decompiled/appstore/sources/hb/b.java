package hb;

import com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements AnimationValueCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20387a = null;

    static {
        f20387a = new b();
    }

    public b() {
    }

    public Integer a(long r10, int r11, int r12, float r13, AnimationSpec r14) {
        q.g(r14, "spec");
        return (Integer) r14.getValueFromNanos(r10, Integer.valueOf(r11), Integer.valueOf(r12), r13);
    }

    public float b(long r10, int r11, int r12, float r13, AnimationSpec r14) {
        q.g(r14, "spec");
        return r14.getVelocityFromNanos(r10, Integer.valueOf(r11), Integer.valueOf(r12), r13);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public /* bridge */ /* synthetic */ Object getValueFromNanos(long r10, Object r11, Object r12, float r13, AnimationSpec r14) {
        return a(r10, ((Number) r11).intValue(), ((Number) r12).intValue(), r13, r14);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public /* bridge */ /* synthetic */ float getVelocityFromNanos(long r10, Object r11, Object r12, float r13, AnimationSpec r14) {
        return b(r10, ((Number) r11).intValue(), ((Number) r12).intValue(), r13, r14);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public boolean isFinishedFromNanos(long r10, long r11, AnimationSpec r12) {
        q.g(r12, "spec");
        return r12.isFinishedFromNanos(r10, r11);
    }
}
