package d5;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.reflect.TypeToken;
import g5.n;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final f5.e f8368a = f5.e.f8742c;

    /* renamed from: b, reason: collision with root package name */
    public final LongSerializationPolicy f8369b = LongSerializationPolicy.f5427a;

    /* renamed from: c, reason: collision with root package name */
    public final b f8370c = FieldNamingPolicy.f5425a;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f8371d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f8372e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f8373f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final int f8374g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f8375i;

    /* renamed from: j, reason: collision with root package name */
    public final c f8376j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f8377k;

    /* renamed from: l, reason: collision with root package name */
    public final t f8378l;

    /* renamed from: m, reason: collision with root package name */
    public final t f8379m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayDeque<ReflectionAccessFilter> f8380n;

    public j() {
        c cVar = i.f8354k;
        this.f8374g = 2;
        this.h = 2;
        this.f8375i = true;
        this.f8376j = i.f8354k;
        this.f8377k = true;
        this.f8378l = i.f8356m;
        this.f8379m = i.f8357n;
        this.f8380n = new ArrayDeque<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Class cls, n nVar) {
        if (cls == Object.class || o.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Cannot override built-in adapter for " + cls);
        }
        if (nVar instanceof k) {
            this.f8371d.put(cls, (k) nVar);
        }
        TypeToken<?> typeToken = TypeToken.get((Type) cls);
        n.b bVar = new n.b(nVar, typeToken, typeToken.getType() == typeToken.getRawType());
        ArrayList arrayList = this.f8372e;
        arrayList.add(bVar);
        if (nVar instanceof u) {
            g5.r rVar = g5.p.f9035a;
            arrayList.add(new g5.q(TypeToken.get((Type) cls), (u) nVar));
        }
    }
}
