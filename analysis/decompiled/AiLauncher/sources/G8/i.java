package G8;

import android.text.style.StrikethroughSpan;
import java.util.Arrays;
import java.util.Collection;
import u8.u;
import u8.v;

/* loaded from: classes4.dex */
public class i extends C8.m {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f2866a = true;

    public static Object d(u8.m mVar) {
        u8.g gVarZ = mVar.z();
        u uVar = gVarZ.e().get(Pb.a.class);
        if (uVar == null) {
            return null;
        }
        return uVar.a(gVarZ, mVar.r());
    }

    @Override // C8.m
    public void a(u8.m mVar, C8.j jVar, C8.f fVar) {
        if (fVar.c()) {
            C8.m.c(mVar, jVar, fVar.a());
        }
        v.k(mVar.builder(), f2866a ? d(mVar) : new StrikethroughSpan(), fVar.start(), fVar.end());
    }

    @Override // C8.m
    public Collection<String> b() {
        return Arrays.asList("s", "del");
    }
}
