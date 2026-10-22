package G1;

import F1.A;
import F1.B;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends A {

    /* renamed from: a, reason: collision with root package name */
    public A f593a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f594b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f595c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ F1.n f596d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TypeToken f597e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f598f;

    public f(g gVar, boolean z4, boolean z5, F1.n nVar, TypeToken typeToken) {
        this.f598f = gVar;
        this.f594b = z4;
        this.f595c = z5;
        this.f596d = nVar;
        this.f597e = typeToken;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        if (this.f594b) {
            jsonReader.skipValue();
            return null;
        }
        A a4 = this.f593a;
        if (a4 == null) {
            F1.n nVar = this.f596d;
            List list = nVar.f442e;
            B b4 = this.f598f;
            if (!list.contains(b4)) {
                b4 = nVar.f441d;
            }
            Iterator it = list.iterator();
            boolean z4 = false;
            while (true) {
                boolean zHasNext = it.hasNext();
                TypeToken typeToken = this.f597e;
                if (!zHasNext) {
                    throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
                }
                B b5 = (B) it.next();
                if (z4) {
                    A a5 = b5.a(nVar, typeToken);
                    if (a5 != null) {
                        this.f593a = a5;
                        a4 = a5;
                        break;
                    }
                } else if (b5 == b4) {
                    z4 = true;
                }
            }
        }
        return a4.b(jsonReader);
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        if (this.f595c) {
            jsonWriter.nullValue();
            return;
        }
        A a4 = this.f593a;
        if (a4 == null) {
            F1.n nVar = this.f596d;
            List list = nVar.f442e;
            B b4 = this.f598f;
            if (!list.contains(b4)) {
                b4 = nVar.f441d;
            }
            Iterator it = list.iterator();
            boolean z4 = false;
            while (true) {
                boolean zHasNext = it.hasNext();
                TypeToken typeToken = this.f597e;
                if (!zHasNext) {
                    throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
                }
                B b5 = (B) it.next();
                if (z4) {
                    A a5 = b5.a(nVar, typeToken);
                    if (a5 != null) {
                        this.f593a = a5;
                        a4 = a5;
                        break;
                    }
                } else if (b5 == b4) {
                    z4 = true;
                }
            }
        }
        a4.c(jsonWriter, obj);
    }
}
