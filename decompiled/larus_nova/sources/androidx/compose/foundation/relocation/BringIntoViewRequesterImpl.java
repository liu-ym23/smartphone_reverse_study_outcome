package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.relocation.BringIntoViewModifierNodeKt;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "<init>", "()V", "nodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "getNodes", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    private final MutableVector<BringIntoViewRequesterNode> nodes;

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewRequesterImpl", f = "BringIntoViewRequester.kt", i = {0, 0, 0, 0}, l = {102}, m = "bringIntoView", n = {SVGRenderEngine.RECT, "content$iv", "i$iv", "size$iv"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BringIntoViewRequesterImpl this$0;

        public AnonymousClass1(BringIntoViewRequesterImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.bringIntoView(null, this);
        }
    }

    public static /* synthetic */ Rect a(Rect r100) {
        return bringIntoView$lambda$1$lambda$0(r100);
    }

    private static final Rect bringIntoView$lambda$1$lambda$0(Rect r100) {
        return r100;
    }

    public BringIntoViewRequesterImpl() {
        this.nodes = new MutableVector(new BringIntoViewRequesterNode[16], 0);
    }

    public final MutableVector<BringIntoViewRequesterNode> getNodes() {
        return this.nodes;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0068 -> B:19:0x006b). Please report as a decompilation issue!!! */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    public Object bringIntoView(Rect r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r101 = (AnonymousClass1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r101.I$1;
        int r106 = r101.I$0;
        Object[] r107 = (Object[]) r101.L$1;
        Rect r108 = (Rect) r101.L$0;
        ResultKt.throwOnFailure(r111);
        final Rect r112 = r108;
    L19:
        r106 = r106 + 1;
    L15:
        if (r106 >= r105) goto L21;
        BringIntoViewRequesterNode r109 = (BringIntoViewRequesterNode) r107[r106];
        Function0 r113 = new a(r112);
        r101.L$0 = r112;
        r101.L$1 = r107;
        r101.I$0 = r106;
        r101.I$1 = r105;
        r101.label = 1;
        if (BringIntoViewModifierNodeKt.bringIntoView(r109, r113, r101) != r103) goto L19;
        return r103;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        MutableVector<BringIntoViewRequesterNode> r114 = this.nodes;
        BringIntoViewRequesterNode[] r115 = r114.content;
        int r116 = r114.getSize();
        r107 = r115;
        r106 = 0;
        r112 = r100;
        r105 = r116;
    L7:
        r101 = new AnonymousClass1(this, r110);
        goto L8
    }
}
