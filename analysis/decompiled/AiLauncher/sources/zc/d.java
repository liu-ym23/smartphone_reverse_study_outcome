package zc;

import Mb.InterfaceC0967e;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import tb.AbstractC5529B;
import tb.x;

/* loaded from: classes5.dex */
public final class d<T> extends AbstractC5529B {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f45478a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f45479b;

    /* renamed from: c, reason: collision with root package name */
    public final T f45480c;

    public d(Gson gson, TypeAdapter<T> typeAdapter, T t10) {
        this.f45478a = gson;
        this.f45479b = typeAdapter;
        this.f45480c = t10;
    }

    @Override // tb.AbstractC5529B
    /* renamed from: b */
    public x getContentType() {
        return b.f45472d;
    }

    @Override // tb.AbstractC5529B
    public void g(InterfaceC0967e interfaceC0967e) throws IOException {
        b.b(interfaceC0967e, this.f45478a, this.f45479b, this.f45480c);
    }
}
