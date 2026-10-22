package kotlinx.coroutines.flow;

import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import p9.p;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aG\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "", "count", Const.INTENT_KEY_APIKEY, "(LXa/b;I)LXa/b;", "Lkotlin/Function2;", "Le9/c;", "", "", "predicate", Const.INTENT_KEY_PKGNAME, "(LXa/b;Lp9/p;)LXa/b;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__LimitKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$a", "LXa/b;", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Xa.b f36469a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f36470b;

        public a(Xa.b bVar, int i10) {
            this.f36469a = bVar;
            this.f36470b = i10;
        }

        @Override // Xa.b
        public Object collect(c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objCollect = this.f36469a.collect(new FlowKt__LimitKt$drop$2$1(new Ref$IntRef(), this.f36470b, cVar), interfaceC4014c);
            return objCollect == C4063a.g() ? objCollect : t.f7040a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$b", "LXa/b;", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements Xa.b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Xa.b f36471a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f36472b;

        public b(Xa.b bVar, p pVar) {
            this.f36471a = bVar;
            this.f36472b = pVar;
        }

        @Override // Xa.b
        public Object collect(c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objCollect = this.f36471a.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref$BooleanRef(), cVar, this.f36472b), interfaceC4014c);
            return objCollect == C4063a.g() ? objCollect : t.f7040a;
        }
    }

    public static final <T> Xa.b<T> a(Xa.b<? extends T> bVar, int i10) {
        if (i10 >= 0) {
            return new a(bVar, i10);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i10).toString());
    }

    public static final <T> Xa.b<T> b(Xa.b<? extends T> bVar, p<? super T, ? super InterfaceC4014c<? super Boolean>, ? extends Object> pVar) {
        return new b(bVar, pVar);
    }
}
