package kotlinx.coroutines.flow;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/flow/SharingCommand;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class StartedWhileSubscribed$command$2 extends SuspendLambda implements p<SharingCommand, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36651a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36652b;

    public StartedWhileSubscribed$command$2(InterfaceC4014c<? super StartedWhileSubscribed$command$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        StartedWhileSubscribed$command$2 startedWhileSubscribed$command$2 = new StartedWhileSubscribed$command$2(interfaceC4014c);
        startedWhileSubscribed$command$2.f36652b = obj;
        return startedWhileSubscribed$command$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SharingCommand sharingCommand, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((StartedWhileSubscribed$command$2) create(sharingCommand, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SharingCommand sharingCommand = (SharingCommand) this.f36652b;
        C4063a.g();
        if (this.f36651a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return C4109a.a(sharingCommand != SharingCommand.START);
    }
}
