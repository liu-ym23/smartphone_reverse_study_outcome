package F1;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/* loaded from: classes.dex */
public abstract class A {
    public final l a() {
        return new l(this, 2);
    }

    public abstract Object b(JsonReader jsonReader);

    public abstract void c(JsonWriter jsonWriter, Object obj);
}
