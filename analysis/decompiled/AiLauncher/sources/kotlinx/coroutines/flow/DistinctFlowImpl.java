package kotlinx.coroutines.flow;

import Xa.b;
import Xa.c;
import Y8.t;
import Ya.k;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R*\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/DistinctFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "upstream", "Lkotlin/Function1;", "", "keySelector", "Lkotlin/Function2;", "", "areEquivalent", "<init>", "(LXa/b;Lp9/l;Lp9/p;)V", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "LXa/b;", Const.INTENT_KEY_PKGNAME, "Lp9/l;", "c", "Lp9/p;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DistinctFlowImpl<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b<T> upstream;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<T, Object> keySelector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final p<Object, Object, Boolean> areEquivalent;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DistinctFlowImpl<T> f36370a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<Object> f36371b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c<T> f36372c;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(DistinctFlowImpl<T> distinctFlowImpl, Ref$ObjectRef<Object> ref$ObjectRef, c<? super T> cVar) {
            this.f36370a = distinctFlowImpl;
            this.f36371b = ref$ObjectRef;
            this.f36372c = cVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
                if (r0 == 0) goto L13
                r0 = r7
                kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
                int r1 = r0.f36377e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f36377e = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f36375c
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.f36377e
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.C4849c.b(r7)
                goto L73
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.C4849c.b(r7)
                kotlinx.coroutines.flow.DistinctFlowImpl<T> r7 = r5.f36370a
                p9.l<T, java.lang.Object> r7 = r7.keySelector
                java.lang.Object r7 = r7.invoke(r6)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f36371b
                T r2 = r2.f34820a
                Za.C r4 = Ya.k.f7051a
                if (r2 == r4) goto L58
                kotlinx.coroutines.flow.DistinctFlowImpl<T> r4 = r5.f36370a
                p9.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.areEquivalent
                java.lang.Object r2 = r4.invoke(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L55
                goto L58
            L55:
                Y8.t r5 = Y8.t.f7040a
                return r5
            L58:
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f36371b
                r2.f34820a = r7
                Xa.c<T> r5 = r5.f36372c
                java.lang.Object r2 = g9.h.a(r6)
                r0.f36373a = r2
                java.lang.Object r7 = g9.h.a(r7)
                r0.f36374b = r7
                r0.f36377e = r3
                java.lang.Object r5 = r5.emit(r6, r0)
                if (r5 != r1) goto L73
                return r1
            L73:
                Y8.t r5 = Y8.t.f7040a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(b<? extends T> bVar, InterfaceC5074l<? super T, ? extends Object> interfaceC5074l, p<Object, Object, Boolean> pVar) {
        this.upstream = bVar;
        this.keySelector = interfaceC5074l;
        this.areEquivalent = pVar;
    }

    @Override // Xa.b
    public Object collect(c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f34820a = (T) k.f7051a;
        Object objCollect = this.upstream.collect(new AnonymousClass2(this, ref$ObjectRef, cVar), interfaceC4014c);
        return objCollect == C4063a.g() ? objCollect : t.f7040a;
    }
}
