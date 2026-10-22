package m5;

import ia.b0;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public JSONObject f6382f;

    /* renamed from: g, reason: collision with root package name */
    public a3.b f6383g;

    /* renamed from: h, reason: collision with root package name */
    public JSONObject f6384h;

    /* renamed from: i, reason: collision with root package name */
    public Iterator f6385i;

    /* renamed from: j, reason: collision with root package name */
    public String f6386j;

    /* renamed from: k, reason: collision with root package name */
    public JSONObject f6387k;

    /* renamed from: l, reason: collision with root package name */
    public String f6388l;

    /* renamed from: m, reason: collision with root package name */
    public JSONObject f6389m;

    /* renamed from: n, reason: collision with root package name */
    public int f6390n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ a3.b f6391o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a3.b bVar, g7.d dVar) {
        super(2, dVar);
        this.f6391o = bVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new c(this.f6391o, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c A[PHI: r2 r6 r7 r8
      0x005c: PHI (r2v4 org.json.JSONObject) = (r2v1 org.json.JSONObject), (r2v2 org.json.JSONObject), (r2v6 org.json.JSONObject) binds: [B:10:0x0045, B:17:0x0095, B:22:0x00d3] A[DONT_GENERATE, DONT_INLINE]
      0x005c: PHI (r6v6 org.json.JSONObject) = (r6v3 org.json.JSONObject), (r6v4 org.json.JSONObject), (r6v8 org.json.JSONObject) binds: [B:10:0x0045, B:17:0x0095, B:22:0x00d3] A[DONT_GENERATE, DONT_INLINE]
      0x005c: PHI (r7v4 java.util.Iterator) = (r7v1 java.util.Iterator), (r7v2 java.util.Iterator), (r7v7 java.util.Iterator) binds: [B:10:0x0045, B:17:0x0095, B:22:0x00d3] A[DONT_GENERATE, DONT_INLINE]
      0x005c: PHI (r8v3 a3.b) = (r8v0 a3.b), (r8v1 a3.b), (r8v5 a3.b) binds: [B:10:0x0045, B:17:0x0095, B:22:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0095 -> B:11:0x005c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00cb -> B:22:0x00d3). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
