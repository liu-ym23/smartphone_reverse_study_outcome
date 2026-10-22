package kotlinx.coroutines.selects;

import com.stepos.launcher.assistant.slidepanel.MinusOneTransitionSpec;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {MinusOneTransitionSpec.OVERLAY_CLOSE_DURATION_MS, 453}, m = "doSelectSuspend", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectImplementation$doSelectSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f36815a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectImplementation<R> f36816b;

    /* renamed from: c, reason: collision with root package name */
    public int f36817c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$doSelectSuspend$1(SelectImplementation<R> selectImplementation, InterfaceC4014c<? super SelectImplementation$doSelectSuspend$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36816b = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36815a = obj;
        this.f36817c |= Integer.MIN_VALUE;
        return this.f36816b.q(this);
    }
}
