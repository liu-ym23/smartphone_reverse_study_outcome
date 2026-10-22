package b3;

import b3.e;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class d extends e.a implements Iterable<d> {
    public Iterator<d> c() {
        return com.fasterxml.jackson.databind.util.a.f4531c;
    }

    public Iterator<Map.Entry<String, d>> d() {
        return com.fasterxml.jackson.databind.util.a.f4531c;
    }

    public float e() {
        return 0.0f;
    }

    public d f(String str) {
        return null;
    }

    public abstract JsonNodeType g();

    @Override // java.lang.Iterable
    public final Iterator<d> iterator() {
        return c();
    }
}
