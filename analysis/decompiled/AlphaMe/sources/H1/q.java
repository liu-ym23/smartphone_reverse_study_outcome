package H1;

import com.google.gson.stream.JsonReader;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class q extends p {

    /* renamed from: b, reason: collision with root package name */
    public final G1.p f751b;

    public q(G1.p pVar, LinkedHashMap linkedHashMap) {
        super(linkedHashMap);
        this.f751b = pVar;
    }

    @Override // H1.p
    public final Object d() {
        return this.f751b.i();
    }

    @Override // H1.p
    public final Object e(Object obj) {
        return obj;
    }

    @Override // H1.p
    public final void f(Object obj, JsonReader jsonReader, o oVar) throws IllegalAccessException, IllegalArgumentException {
        Object objB = oVar.f745i.b(jsonReader);
        if (objB == null && oVar.f748l) {
            return;
        }
        boolean z4 = oVar.f742f;
        Field field = oVar.f738b;
        if (z4) {
            s.b(obj, field);
        } else if (oVar.f749m) {
            throw new F1.q(B0.g.m("Cannot set value of 'static final' ", J1.c.d(field, false)), 5);
        }
        field.set(obj, objB);
    }
}
