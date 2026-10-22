package G8;

import android.text.style.UnderlineSpan;
import java.util.Arrays;
import java.util.Collection;
import u8.v;

/* loaded from: classes4.dex */
public class m extends C8.m {
    @Override // C8.m
    public void a(u8.m mVar, C8.j jVar, C8.f fVar) {
        if (fVar.c()) {
            C8.m.c(mVar, jVar, fVar.a());
        }
        v.k(mVar.builder(), new UnderlineSpan(), fVar.start(), fVar.end());
    }

    @Override // C8.m
    public Collection<String> b() {
        return Arrays.asList("u", "ins");
    }
}
