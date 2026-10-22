package H1;

import F1.A;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c extends A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f710a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f711b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f712c;

    public c(F1.n nVar, Type type, A a4, G1.p pVar) {
        this.f711b = new u(nVar, a4, type);
        this.f712c = pVar;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        int i4 = this.f710a;
        Object obj = this.f711b;
        Object obj2 = this.f712c;
        switch (i4) {
            case 0:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                Collection collection = (Collection) ((G1.p) obj2).i();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    collection.add(((A) obj).b(jsonReader));
                }
                jsonReader.endArray();
                return collection;
            default:
                Object objB = ((v) obj2).f767c.b(jsonReader);
                if (objB != null) {
                    Class cls = (Class) obj;
                    if (!cls.isInstance(objB)) {
                        throw new F1.q("Expected a " + cls.getName() + " but was " + objB.getClass().getName() + "; at path " + jsonReader.getPreviousPath(), 5);
                    }
                }
                return objB;
        }
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        switch (this.f710a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection != null) {
                    jsonWriter.beginArray();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((A) this.f711b).c(jsonWriter, it.next());
                    }
                    jsonWriter.endArray();
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
            default:
                ((v) this.f712c).f767c.c(jsonWriter, obj);
                break;
        }
    }

    public c(v vVar, Class cls) {
        this.f712c = vVar;
        this.f711b = cls;
    }
}
