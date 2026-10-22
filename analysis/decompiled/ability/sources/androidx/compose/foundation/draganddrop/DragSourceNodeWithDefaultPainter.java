package androidx.compose.foundation.draganddrop;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatingNode;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B+\u0012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002¢\u0006\u0004\b\b\u0010\tR>\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/draganddrop/DragSourceNodeWithDefaultPainter;", "Landroidx/compose/ui/node/DelegatingNode;", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "LH7/c;", "LC7/r;", "", "dragAndDropSourceHandler", AppAgent.CONSTRUCT, "(LS7/n;)V", "LS7/n;", "getDragAndDropSourceHandler", "()LS7/n;", "setDragAndDropSourceHandler", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DragSourceNodeWithDefaultPainter extends DelegatingNode {
    private n dragAndDropSourceHandler;

    @c(c = "androidx.compose.foundation.draganddrop.DragSourceNodeWithDefaultPainter$2", f = "AndroidDragAndDropSource.android.kt", l = {101}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.draganddrop.DragSourceNodeWithDefaultPainter$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = DragSourceNodeWithDefaultPainter.this.new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(DragAndDropSourceScope dragAndDropSourceScope, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(dragAndDropSourceScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                DragAndDropSourceScope dragAndDropSourceScope = (DragAndDropSourceScope) this.L$0;
                n dragAndDropSourceHandler = DragSourceNodeWithDefaultPainter.this.getDragAndDropSourceHandler();
                this.label = 1;
                if (dragAndDropSourceHandler.invoke(dragAndDropSourceScope, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    public DragSourceNodeWithDefaultPainter(n nVar) {
        this.dragAndDropSourceHandler = nVar;
        final CacheDrawScopeDragShadowCallback cacheDrawScopeDragShadowCallback = new CacheDrawScopeDragShadowCallback();
        delegate(DrawModifierKt.CacheDrawModifierNode(new DragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1(cacheDrawScopeDragShadowCallback)));
        delegate(new DragAndDropSourceNode(new k() { // from class: androidx.compose.foundation.draganddrop.DragSourceNodeWithDefaultPainter.1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return r.f317a;
            }

            public final void invoke(DrawScope drawScope) {
                cacheDrawScopeDragShadowCallback.drawDragShadow(drawScope);
            }
        }, new AnonymousClass2(null)));
    }

    public final n getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final void setDragAndDropSourceHandler(n nVar) {
        this.dragAndDropSourceHandler = nVar;
    }
}
