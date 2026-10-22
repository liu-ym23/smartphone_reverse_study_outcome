package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__TransformKt {
    public static final Flow a(final Flow r10) {
        return new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1(r10);
    }

    public static final Flow b(final Flow r10, final Function2 r11) {
        return new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r10, r11);
    }
}
