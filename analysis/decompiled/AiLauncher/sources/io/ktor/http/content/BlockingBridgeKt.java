package io.ktor.http.content;

import Ua.C1056g;
import Ua.M;
import Ua.Y;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.lang.reflect.Method;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0005\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a.\u0010\n\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H\u0082@¢\u0006\u0004\b\n\u0010\u0006\"\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/Function1;", "Le9/c;", "LY8/t;", "", "block", "withBlocking", "(Lp9/l;Le9/c;)Ljava/lang/Object;", "", "safeToRunInPlace", "()Z", "withBlockingAndRedispatch", "Ljava/lang/reflect/Method;", "isParkingAllowedFunction$delegate", "LY8/h;", "isParkingAllowedFunction", "()Ljava/lang/reflect/Method;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BlockingBridgeKt {
    private static final Y8.h isParkingAllowedFunction$delegate = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.content.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return BlockingBridgeKt.isParkingAllowedFunction_delegate$lambda$0();
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.http.content.BlockingBridgeKt$withBlockingAndRedispatch$2", f = "BlockingBridge.kt", l = {45}, m = "invokeSuspend")
    /* renamed from: io.ktor.http.content.BlockingBridgeKt$withBlockingAndRedispatch$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super t>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(InterfaceC5074l<? super InterfaceC4014c<? super t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$block = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$block, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC5074l<InterfaceC4014c<? super t>, Object> interfaceC5074l = this.$block;
                this.label = 1;
                if (interfaceC5074l.invoke(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    private static final Method isParkingAllowedFunction() {
        return (Method) isParkingAllowedFunction$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method isParkingAllowedFunction_delegate$lambda$0() {
        try {
            return Class.forName("io.ktor.utils.io.jvm.javaio.PollersKt").getMethod("isParkingAllowed", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final boolean safeToRunInPlace() {
        try {
            Method methodIsParkingAllowedFunction = isParkingAllowedFunction();
            if (methodIsParkingAllowedFunction != null) {
                return kotlin.jvm.internal.p.d(methodIsParkingAllowedFunction.invoke(null, null), Boolean.TRUE);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final Object withBlocking(InterfaceC5074l<? super InterfaceC4014c<? super t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        if (safeToRunInPlace()) {
            Object objInvoke = interfaceC5074l.invoke(interfaceC4014c);
            return objInvoke == C4063a.g() ? objInvoke : t.f7040a;
        }
        Object objWithBlockingAndRedispatch = withBlockingAndRedispatch(interfaceC5074l, interfaceC4014c);
        return objWithBlockingAndRedispatch == C4063a.g() ? objWithBlockingAndRedispatch : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object withBlockingAndRedispatch(InterfaceC5074l<? super InterfaceC4014c<? super t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new AnonymousClass2(interfaceC5074l, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }
}
