package coil.fetch;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", l = {77, 106}, m = "fetch")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpUriFetcher$fetch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15671a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15672b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15673c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f15674d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpUriFetcher f15675e;

    /* renamed from: f, reason: collision with root package name */
    public int f15676f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpUriFetcher$fetch$1(HttpUriFetcher httpUriFetcher, InterfaceC4014c<? super HttpUriFetcher$fetch$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15675e = httpUriFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15674d = obj;
        this.f15676f |= Integer.MIN_VALUE;
        return this.f15675e.a(this);
    }
}
