package coil.fetch;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", l = {224}, m = "executeNetworkRequest")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpUriFetcher$executeNetworkRequest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f15668a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HttpUriFetcher f15669b;

    /* renamed from: c, reason: collision with root package name */
    public int f15670c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpUriFetcher$executeNetworkRequest$1(HttpUriFetcher httpUriFetcher, InterfaceC4014c<? super HttpUriFetcher$executeNetworkRequest$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15669b = httpUriFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15668a = obj;
        this.f15670c |= Integer.MIN_VALUE;
        return this.f15669b.c(null, this);
    }
}
