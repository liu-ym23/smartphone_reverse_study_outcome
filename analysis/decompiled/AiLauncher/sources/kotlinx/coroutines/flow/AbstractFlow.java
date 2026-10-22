package kotlinx.coroutines.flow;

import Xa.b;
import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000b\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H¦@¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "", "<init>", "()V", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbstractFlow<T> implements b<T> {

    @InterfaceC4112d(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {226}, m = "collect", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.AbstractFlow$collect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f36357a;

        /* renamed from: b, reason: collision with root package name */
        public Object f36358b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f36359c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbstractFlow<T> f36360d;

        /* renamed from: e, reason: collision with root package name */
        public int f36361e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AbstractFlow<T> abstractFlow, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
            this.f36360d = abstractFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f36359c = obj;
            this.f36361e |= Integer.MIN_VALUE;
            return this.f36360d.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Xa.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(Xa.c<? super T> r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.AbstractFlow.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = (kotlinx.coroutines.flow.AbstractFlow.AnonymousClass1) r0
            int r1 = r0.f36361e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36361e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = new kotlinx.coroutines.flow.AbstractFlow$collect$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f36359c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36361e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f36358b
            kotlinx.coroutines.flow.internal.SafeCollector r4 = (kotlinx.coroutines.flow.internal.SafeCollector) r4
            java.lang.Object r5 = r0.f36357a
            Xa.c r5 = (Xa.c) r5
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L31
            goto L59
        L31:
            r5 = move-exception
            goto L61
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            kotlinx.coroutines.flow.internal.SafeCollector r6 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.d r2 = r0.getContext()
            r6.<init>(r5, r2)
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L5f
            r0.f36357a = r5     // Catch: java.lang.Throwable -> L5f
            r0.f36358b = r6     // Catch: java.lang.Throwable -> L5f
            r0.f36361e = r3     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r4 = r4.g(r6, r0)     // Catch: java.lang.Throwable -> L5f
            if (r4 != r1) goto L58
            return r1
        L58:
            r4 = r6
        L59:
            r4.releaseIntercepted()
            Y8.t r4 = Y8.t.f7040a
            return r4
        L5f:
            r5 = move-exception
            r4 = r6
        L61:
            r4.releaseIntercepted()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.AbstractFlow.collect(Xa.c, e9.c):java.lang.Object");
    }

    public abstract Object g(c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c);
}
