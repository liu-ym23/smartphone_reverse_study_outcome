package androidx.room;

import Ua.M;
import Z8.Y;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Arrays;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1", f = "MultiInstanceInvalidationClient.android.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f14484a;

    /* renamed from: b, reason: collision with root package name */
    public int f14485b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String[] f14486c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f14487d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(String[] strArr, MultiInstanceInvalidationClient multiInstanceInvalidationClient, InterfaceC4014c<? super MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14486c = strArr;
        this.f14487d = multiInstanceInvalidationClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(this.f14486c, this.f14487d, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Set<String> set;
        Object objG = C4063a.g();
        int i10 = this.f14485b;
        if (i10 == 0) {
            C4849c.b(obj);
            String[] strArr = this.f14486c;
            Set<String> setJ = Y.j(Arrays.copyOf(strArr, strArr.length));
            Xa.j jVar = this.f14487d.invalidatedTables;
            this.f14484a = setJ;
            this.f14485b = 1;
            if (jVar.emit(setJ, this) == objG) {
                return objG;
            }
            set = setJ;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            set = (Set) this.f14484a;
            C4849c.b(obj);
        }
        this.f14487d.getInvalidationTracker().q(set);
        return Y8.t.f7040a;
    }
}
