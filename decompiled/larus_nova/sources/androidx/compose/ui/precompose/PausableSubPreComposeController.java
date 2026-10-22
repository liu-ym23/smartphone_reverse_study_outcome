package androidx.compose.ui.precompose;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nJ\u0010\u0010\u0016\u001a\u00020\u0017H\u0080@¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/precompose/PausableSubPreComposeController;", "", "precomposeCount", "", "<init>", "(I)V", "getPrecomposeCount", "()I", "list", "", "Lkotlin/Function0;", "", "Landroidx/compose/ui/precompose/PausableSubPreComposeController$PausableSubPreComposeTask;", "inPausablePreCompose", "", "getInPausablePreCompose", "()Z", "setInPausablePreCompose", "(Z)V", "registerSubPreComposeTask", "Landroidx/compose/ui/precompose/Disposable;", "block", "triggerSubPreCompose", "", "triggerSubPreCompose$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PausableSubPreComposeTask", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PausableSubPreComposeController {
    public static final int $stable = 8;
    private boolean inPausablePreCompose;
    private final List<Function0<List<PausableSubPreComposeTask>>> list;
    private final int precomposeCount;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/precompose/PausableSubPreComposeController$PausableSubPreComposeTask;", "", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PausableSubPreComposeTask {
        Object await(Continuation<? super Unit> r100);
    }

    public PausableSubPreComposeController() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final boolean getInPausablePreCompose() {
        return this.inPausablePreCompose;
    }

    public final int getPrecomposeCount() {
        return this.precomposeCount;
    }

    public PausableSubPreComposeController(int r100) {
        this.precomposeCount = r100;
        this.list = new ArrayList();
        this.inPausablePreCompose = true;
    }

    public static final /* synthetic */ List access$getList$p(PausableSubPreComposeController r100) {
        return r100.list;
    }

    public final Disposable registerSubPreComposeTask(final Function0<? extends List<? extends PausableSubPreComposeTask>> r100) {
        this.list.add(r100);
        return new AnonymousClass1(this, r100);
    }

    public final void setInPausablePreCompose(boolean r100) {
        this.inPausablePreCompose = r100;
    }

    public final Object triggerSubPreCompose$ui_release(Continuation<? super Unit> r100) {
        if ((r100 instanceof PausableSubPreComposeController$triggerSubPreCompose$1) == false) goto L7;
        PausableSubPreComposeController$triggerSubPreCompose$1 r101 = (PausableSubPreComposeController$triggerSubPreCompose$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        Iterator r106 = (Iterator) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        if (r106.hasNext() == false) goto L25;
        PausableSubPreComposeTask r107 = (PausableSubPreComposeTask) r106.next();
        r101.L$0 = r106;
        r101.label = 1;
        if (r107.await(r101) != r104) goto L21;
        return r104;
    L25:
        this.inPausablePreCompose = false;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        List<Function0<List<PausableSubPreComposeTask>>> r108 = this.list;
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L16:
        if (r110.hasNext() == false) goto L18;
        CollectionsKt.addAll(r109, (Iterable) ((Function0) r110.next()).invoke());
        goto L16
    L18:
        this.list.clear();
        r106 = r109.iterator();
    L7:
        r101 = new PausableSubPreComposeController$triggerSubPreCompose$1(this, r100);
        goto L8
    }

    public /* synthetic */ PausableSubPreComposeController(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = -1;
    L5:
        this(r100);
    }
}
