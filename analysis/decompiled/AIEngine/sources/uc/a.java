package uc;

import com.tonyodev.fetch2core.server.FileResponse;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.internal.WriteMode;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0150a f13193d = new C0150a(new e(false, false, true, "    ", false, FileResponse.FIELD_TYPE, true, ClassDiscriminatorMode.f10123b), wc.c.f13679a);

    /* renamed from: a, reason: collision with root package name */
    public final e f13194a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.datastore.preferences.protobuf.f f13195b;

    /* renamed from: c, reason: collision with root package name */
    public final vc.f f13196c = new vc.f();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: uc.a$a, reason: collision with other inner class name */
    public static final class C0150a extends a {
    }

    public a(e eVar, androidx.datastore.preferences.protobuf.f fVar) {
        this.f13194a = eVar;
        this.f13195b = fVar;
    }

    public final Object a(String string, pc.a deserializer) {
        kotlin.jvm.internal.g.f(deserializer, "deserializer");
        kotlin.jvm.internal.g.f(string, "string");
        vc.m mVar = new vc.m(string);
        Object objZ = new kotlinx.serialization.json.internal.b(this, WriteMode.f10136c, mVar, deserializer.d()).z(deserializer);
        if (mVar.e() == 10) {
            return objZ;
        }
        vc.m.n(mVar, "Expected EOF after parsing, but had " + mVar.f13519e.charAt(mVar.f13515a - 1) + " instead", 0, 6);
        throw null;
    }
}
