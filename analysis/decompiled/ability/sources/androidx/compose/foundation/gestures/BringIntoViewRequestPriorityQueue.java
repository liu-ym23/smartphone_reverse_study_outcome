package androidx.compose.foundation.gestures;

import C7.r;
import S7.k;
import Y7.f;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import m9.InterfaceC1717j;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0003J1\u0010\u0012\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00040\u000bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "", AppAgent.CONSTRUCT, "()V", "", "isEmpty", "()Z", "Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "request", "enqueue", "(Landroidx/compose/foundation/gestures/ContentInViewNode$Request;)Z", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "LC7/r;", "block", "forEachFromSmallest", "(LS7/k;)V", "resumeAndRemoveAll", "resumeAndRemoveWhile", "", "cause", "cancelAndRemoveAll", "(Ljava/lang/Throwable;)V", "Landroidx/compose/runtime/collection/MutableVector;", "requests", "Landroidx/compose/runtime/collection/MutableVector;", "", "getSize", "()I", "size", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BringIntoViewRequestPriorityQueue {
    public static final int $stable = MutableVector.$stable;
    private final MutableVector<ContentInViewNode.Request> requests = new MutableVector<>(new ContentInViewNode.Request[16], 0);

    public final void cancelAndRemoveAll(Throwable cause) {
        MutableVector<ContentInViewNode.Request> mutableVector = this.requests;
        int size = mutableVector.getSize();
        InterfaceC1717j[] interfaceC1717jArr = new InterfaceC1717j[size];
        for (int i = 0; i < size; i++) {
            interfaceC1717jArr[i] = mutableVector.getContent()[i].getContinuation();
        }
        for (int i6 = 0; i6 < size; i6++) {
            interfaceC1717jArr[i6].l(cause);
        }
        if (!this.requests.isEmpty()) {
            throw new IllegalStateException("uncancelled requests present");
        }
    }

    public final boolean enqueue(final ContentInViewNode.Request request) {
        Rect rect = (Rect) request.getCurrentBounds().invoke();
        if (rect == null) {
            request.getContinuation().resumeWith(r.f317a);
            return false;
        }
        request.getContinuation().j(new k() { // from class: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.enqueue.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                BringIntoViewRequestPriorityQueue.this.requests.remove(request);
            }
        });
        int i = new f(0, this.requests.getSize() - 1, 1).b;
        if (i >= 0) {
            while (true) {
                Rect rect2 = (Rect) this.requests.getContent()[i].getCurrentBounds().invoke();
                if (rect2 != null) {
                    Rect rectIntersect = rect.intersect(rect2);
                    if (kotlin.jvm.internal.k.b(rectIntersect, rect)) {
                        this.requests.add(i + 1, request);
                        return true;
                    }
                    if (!kotlin.jvm.internal.k.b(rectIntersect, rect2)) {
                        CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int size = this.requests.getSize() - 1;
                        if (size <= i) {
                            while (true) {
                                this.requests.getContent()[i].getContinuation().l(cancellationException);
                                if (size == i) {
                                    break;
                                }
                                size++;
                            }
                        }
                    }
                }
                if (i == 0) {
                    break;
                }
                i--;
            }
        }
        this.requests.add(0, request);
        return true;
    }

    public final void forEachFromSmallest(k block) {
        MutableVector mutableVector = this.requests;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                block.invoke(((ContentInViewNode.Request) content[i]).getCurrentBounds().invoke());
                i--;
            } while (i >= 0);
        }
    }

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        return this.requests.isEmpty();
    }

    public final void resumeAndRemoveAll() {
        int i = 0;
        int i6 = new f(0, this.requests.getSize() - 1, 1).b;
        if (i6 >= 0) {
            while (true) {
                this.requests.getContent()[i].getContinuation().resumeWith(r.f317a);
                if (i == i6) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this.requests.clear();
    }

    public final void resumeAndRemoveWhile(k block) {
        while (this.requests.isNotEmpty() && ((Boolean) block.invoke(((ContentInViewNode.Request) this.requests.last()).getCurrentBounds().invoke())).booleanValue()) {
            ((ContentInViewNode.Request) this.requests.removeAt(this.requests.getSize() - 1)).getContinuation().resumeWith(r.f317a);
        }
    }
}
