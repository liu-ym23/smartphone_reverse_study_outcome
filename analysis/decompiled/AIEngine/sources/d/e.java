package d;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends b<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8249a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8250b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e.a<Object, Object> f8251c;

    public e(d dVar, String str, e.a<Object, Object> aVar) {
        this.f8249a = dVar;
        this.f8250b = str;
        this.f8251c = aVar;
    }

    @Override // d.b
    public final void a(Object obj) throws Exception {
        d dVar = this.f8249a;
        ArrayList arrayList = dVar.f8241d;
        LinkedHashMap linkedHashMap = dVar.f8239b;
        String str = this.f8250b;
        Object obj2 = linkedHashMap.get(str);
        e.a<Object, Object> aVar = this.f8251c;
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
}
