package com.stepos.cloud.securedata;

import c7.r;
import kotlin.Metadata;
import q7.k;
import xa.a;
import xa.b;
import xa.c;
import xa.d;
import xa.f;
import xa.h;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/cloud/securedata/SecureDataJson;", "", "Lxa/c;", "a", "Lxa/c;", "getCodec", "()Lxa/c;", "codec", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SecureDataJson {
    public static final SecureDataJson INSTANCE = new SecureDataJson();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final c codec;

    static {
        b bVar = c.f11331d;
        k.e(bVar, "from");
        d dVar = new d();
        f fVar = bVar.f11332a;
        dVar.f11335a = fVar.f11338a;
        boolean z4 = fVar.f11341d;
        dVar.f11336b = fVar.f11339b;
        dVar.f11337c = fVar.f11340c;
        String str = fVar.f11342e;
        String str2 = fVar.f11343f;
        a aVar = fVar.f11345h;
        boolean z10 = fVar.f11344g;
        w4.a aVar2 = bVar.f11333b;
        a(dVar);
        if (!k.a(str, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        f fVar2 = new f(dVar.f11335a, dVar.f11336b, dVar.f11337c, z4, str, str2, z10, aVar);
        k.e(aVar2, "module");
        h hVar = new h(fVar2, aVar2);
        if (!aVar2.equals(za.a.f12494a)) {
            a aVar3 = a.f11329f;
        }
        codec = hVar;
    }

    public static final r a(d dVar) {
        k.e(dVar, "$this$Json");
        dVar.f11336b = true;
        dVar.f11335a = true;
        dVar.f11337c = true;
        return r.f1986a;
    }

    public final c getCodec() {
        return codec;
    }
}
