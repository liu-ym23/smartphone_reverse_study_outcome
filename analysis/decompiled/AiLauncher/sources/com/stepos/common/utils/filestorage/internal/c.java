package com.stepos.common.utils.filestorage.internal;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;
import qb.C5174d;
import qb.v;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lqb/a;", "FsJson", "Lqb/a;", "c", "()Lqb/a;", "utils_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private static final AbstractC5171a FsJson = v.b(null, new InterfaceC5074l() { // from class: com.stepos.common.utils.filestorage.internal.b
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return c.b((C5174d) obj);
        }
    }, 1, null);

    public static final t b(C5174d Json) {
        p.i(Json, "$this$Json");
        Json.g(true);
        Json.e(false);
        Json.d(true);
        Json.h(true);
        Json.f(false);
        return t.f7040a;
    }

    public static final AbstractC5171a c() {
        return FsJson;
    }
}
