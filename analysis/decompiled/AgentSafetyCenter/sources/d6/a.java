package d6;

import ad.s;
import id.k;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3268c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ b f3269f;

    public /* synthetic */ a(int i) {
        this.f3268c = i;
    }

    @Override // xb.a
    public final Object invoke() {
        int i = this.f3268c;
        b bVar = this.f3269f;
        switch (i) {
            case 0:
                ad.c cVar = ad.c.f439n;
                return a.a.N(bVar.f3275f);
            default:
                String strA = bVar.f3275f.a(HttpHeaders.CONTENT_TYPE);
                if (strA == null) {
                    return null;
                }
                Pattern pattern = s.f568d;
                try {
                    return k.t(strA);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
        }
    }
}
