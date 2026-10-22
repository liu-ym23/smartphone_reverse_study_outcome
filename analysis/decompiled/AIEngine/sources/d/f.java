package d;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends b<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8252a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8253b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e.a<Object, Object> f8254c;

    public f(d dVar, String str, e.a<Object, Object> aVar) {
        this.f8252a = dVar;
        this.f8253b = str;
        this.f8254c = aVar;
    }

    @Override // d.b
    public final void a(Object obj) {
        d dVar = this.f8252a;
        ArrayList arrayList = dVar.f8241d;
        LinkedHashMap linkedHashMap = dVar.f8239b;
        String str = this.f8253b;
        Object obj2 = linkedHashMap.get(str);
        e.a<Object, Object> aVar = this.f8254c;
        if (obj2 == null) {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
        int iIntValue = ((Number) obj2).intValue();
        arrayList.add(str);
        try {
            dVar.b(iIntValue, aVar, obj);
        } catch (Exception e10) {
            arrayList.remove(str);
            throw e10;
        }
    }

    public final void b() {
        this.f8252a.f(this.f8253b);
    }
}
