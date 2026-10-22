package h4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a implements g4.a {
    @Override // g4.a
    public final List<String> a(String str) {
        if (s3.a.a(str)) {
            return Collections.EMPTY_LIST;
        }
        androidx.lifecycle.b bVar = b.f9293a;
        bVar.getClass();
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        if (s3.a.a(str) ? true : s3.a.a(s3.a.a(str) ? str : str.trim())) {
            return Collections.singletonList(str);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (char c9 : str.toCharArray()) {
            if (c9 < 19968 || c9 > 40869) {
                sb3.append(c9);
                bVar.d(sb2, arrayList);
            } else {
                sb2.append(c9);
                androidx.lifecycle.b.e(sb3, arrayList);
            }
        }
        bVar.d(sb2, arrayList);
        androidx.lifecycle.b.e(sb3, arrayList);
        return arrayList;
    }
}
