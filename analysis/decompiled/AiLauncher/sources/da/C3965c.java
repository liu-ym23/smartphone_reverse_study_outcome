package da;

import Y8.j;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* renamed from: da.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3965c {
    public static final Pair<ProtoBuf$PackageFragment, C3963a> a(InputStream inputStream) throws IOException {
        ProtoBuf$PackageFragment protoBuf$PackageFragmentW;
        p.i(inputStream, "<this>");
        try {
            C3963a c3963aA = C3963a.f32146g.a(inputStream);
            if (c3963aA.h()) {
                d dVarD = d.d();
                C3964b.a(dVarD);
                protoBuf$PackageFragmentW = ProtoBuf$PackageFragment.W(inputStream, dVarD);
            } else {
                protoBuf$PackageFragmentW = null;
            }
            Pair<ProtoBuf$PackageFragment, C3963a> pairA = j.a(protoBuf$PackageFragmentW, c3963aA);
            l9.b.a(inputStream, null);
            return pairA;
        } finally {
        }
    }
}
