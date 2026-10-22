package androidx.room;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.ObservedTableVersions", f = "InvalidationTracker.kt", l = {638}, m = "collect")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ObservedTableVersions$collect$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f14500a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObservedTableVersions f14501b;

    /* renamed from: c, reason: collision with root package name */
    public int f14502c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservedTableVersions$collect$1(ObservedTableVersions observedTableVersions, InterfaceC4014c<? super ObservedTableVersions$collect$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14501b = observedTableVersions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14500a = obj;
        this.f14502c |= Integer.MIN_VALUE;
        return this.f14501b.a(null, this);
    }
}
