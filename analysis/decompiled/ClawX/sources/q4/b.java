package q4;

import a6.f0;
import b5.a0;
import k4.v;
import k4.z;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JvmStreamsKt;
import p5.p;
import z3.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends h5.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.ktor.utils.io.p f4845a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w4.a f4846b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Json f4847c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(io.ktor.utils.io.p pVar, w4.a aVar, Json json, f5.c cVar) {
        super(2, cVar);
        this.f4845a = pVar;
        this.f4846b = aVar;
        this.f4847c = json;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new b(this.f4845a, this.f4846b, this.f4847c, cVar);
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((f0) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        a.a.c0(obj);
        io.ktor.utils.io.p pVar = this.f4845a;
        kotlin.jvm.internal.p.e(pVar, "<this>");
        l lVar = new l(1, pVar);
        w4.a aVarD = z.d(this.f4846b);
        Json json = this.f4847c;
        return JvmStreamsKt.decodeToSequence$default(json, lVar, v.j0(json.getSerializersModule(), aVarD), null, 4, null);
    }
}
