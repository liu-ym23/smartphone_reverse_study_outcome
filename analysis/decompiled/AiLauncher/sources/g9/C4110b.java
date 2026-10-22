package g9;

import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lg9/b;", "Le9/c;", "", "<init>", "()V", "Lkotlin/Result;", "result", "LY8/t;", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/coroutines/d;", "getContext", "()Lkotlin/coroutines/d;", "context", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: g9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4110b implements InterfaceC4014c<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final C4110b f32706a = new C4110b();

    @Override // e9.InterfaceC4014c
    public kotlin.coroutines.d getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // e9.InterfaceC4014c
    public void resumeWith(Object result) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
