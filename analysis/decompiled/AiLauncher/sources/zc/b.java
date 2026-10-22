package zc;

import Mb.C0966d;
import Mb.InterfaceC0967e;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import tb.AbstractC5529B;
import tb.x;
import yc.h;

/* loaded from: classes5.dex */
public final class b<T> implements h<T, AbstractC5529B> {

    /* renamed from: d, reason: collision with root package name */
    public static final x f45472d = x.e("application/json; charset=UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Gson f45473a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f45474b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f45475c;

    public b(Gson gson, TypeAdapter<T> typeAdapter, boolean z10) {
        this.f45473a = gson;
        this.f45474b = typeAdapter;
        this.f45475c = z10;
    }

    public static <T> void b(InterfaceC0967e interfaceC0967e, Gson gson, TypeAdapter<T> typeAdapter, T t10) throws IOException {
        JsonWriter jsonWriterNewJsonWriter = gson.newJsonWriter(new OutputStreamWriter(interfaceC0967e.o1(), StandardCharsets.UTF_8));
        typeAdapter.write(jsonWriterNewJsonWriter, t10);
        jsonWriterNewJsonWriter.close();
    }

    @Override // yc.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC5529B convert(T t10) throws IOException {
        if (this.f45475c) {
            return new d(this.f45473a, this.f45474b, t10);
        }
        C0966d c0966d = new C0966d();
        b(c0966d, this.f45473a, this.f45474b, t10);
        return AbstractC5529B.c(f45472d, c0966d.N0());
    }
}
