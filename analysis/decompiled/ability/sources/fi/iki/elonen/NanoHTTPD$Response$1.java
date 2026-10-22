package fi.iki.elonen;

import java.util.HashMap;

/* loaded from: classes2.dex */
class NanoHTTPD$Response$1 extends HashMap<String, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f4450a;

    public NanoHTTPD$Response$1(a aVar) {
        this.f4450a = aVar;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        this.f4450a.f.put(str == null ? str : str.toLowerCase(), str2);
        return (String) super.put(str, str2);
    }
}
