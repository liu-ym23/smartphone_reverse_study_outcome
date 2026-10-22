package F1;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/* loaded from: classes.dex */
public final class m extends H1.t {

    /* renamed from: a, reason: collision with root package name */
    public A f437a;

    @Override // F1.A
    public final Object b(JsonReader jsonReader) {
        A a4 = this.f437a;
        if (a4 != null) {
            return a4.b(jsonReader);
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) {
        A a4 = this.f437a;
        if (a4 == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        a4.c(jsonWriter, obj);
    }
}
