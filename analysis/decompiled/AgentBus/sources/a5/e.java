package a5;

import c7.r;
import ia.b0;
import org.json.JSONException;
import p7.n;

/* loaded from: classes.dex */
public final class e extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ f f218f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f219g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f220h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f221i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f222j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f223k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f224l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f225m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f226n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, String str, String str2, String str3, String str4, String str5, String str6, boolean z4, String str7, g7.d dVar) {
        super(2, dVar);
        this.f218f = fVar;
        this.f219g = str;
        this.f220h = str2;
        this.f221i = str3;
        this.f222j = str4;
        this.f223k = str5;
        this.f224l = str6;
        this.f225m = z4;
        this.f226n = str7;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new e(this.f218f, this.f219g, this.f220h, this.f221i, this.f222j, this.f223k, this.f224l, this.f225m, this.f226n, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        e eVar = (e) create((b0) obj, (g7.d) obj2);
        r rVar = r.f1986a;
        eVar.invokeSuspend(rVar);
        return rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c4  */
    /* JADX WARN: Type inference failed for: r1v0, types: [a5.e] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [z5.c] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [ab.v] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
