package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection", f = "WindowInsetsConnection.android.kt", i = {0, 0, 1, 1, 2}, l = {301, 327, 352}, m = "fling-huYlsQE", n = {"available", "flingAmount", "endVelocity", "available", "available"}, s = {"J$0", "F$0", "L$0", "J$0", "J$0"})
public final class WindowInsetsNestedScrollConnection$fling$1 extends ContinuationImpl {
    float F$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    public WindowInsetsNestedScrollConnection$fling$1(WindowInsetsNestedScrollConnection r100, Continuation<? super WindowInsetsNestedScrollConnection$fling$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return WindowInsetsNestedScrollConnection.m805access$flinghuYlsQE(this.this$0, 0, 0.0f, false, this);
    }
}
