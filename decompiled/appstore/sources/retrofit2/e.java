package retrofit2;

import com.google.common.net.HttpHeaders;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    public class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f24040a;

        public a(e r10) {
            this.f24040a = r10;
        }

        @Override // retrofit2.e
        public /* bridge */ /* synthetic */ void a(retrofit2.g r10, Object r11) {
            d(r10, (Iterable) r11);
        }

        public void d(retrofit2.g r10, Iterable r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L8;
            Object r13 = r12.next();
            this.f24040a.a(r10, r13);
            goto L6
        }
    }

    public class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f24041a;

        public b(e r10) {
            this.f24041a = r10;
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            int r12 = Array.getLength(r11);
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L7;
            this.f24041a.a(r10, Array.get(r11, r13));
            r13 = r13 + 1;
            goto L5
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f24042a;

        public c(Converter r10) {
            this.f24042a = r10;
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            if (r11 == null) goto L10;
            r10.j((RequestBody) this.f24042a.convert(r11));
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to RequestBody", e);
        L10:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f24044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f24045c;

        public d(String r10, Converter r11, boolean r12) {
            this.f24043a = (String) retrofit2.i.b(r10, "name == null");
            this.f24044b = r11;
            this.f24045c = r12;
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            String r12 = (String) this.f24044b.convert(r11);
            if (r12 != null) goto L7;
            return;
        L7:
            r10.a(this.f24043a, r12, this.f24045c);
        }
    }

    /* JADX INFO: renamed from: retrofit2.e$e, reason: collision with other inner class name */
    public static final class C0359e extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f24046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f24047b;

        public C0359e(Converter r10, boolean r11) {
            this.f24046a = r10;
            this.f24047b = r11;
        }

        @Override // retrofit2.e
        public /* bridge */ /* synthetic */ void a(retrofit2.g r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(retrofit2.g r10, Map r11) {
            if (r11 == null) goto L21;
            Iterator r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L19;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L18;
            Object r15 = r13.getValue();
            if (r15 == null) goto L16;
            String r16 = (String) this.f24046a.convert(r15);
            if (r16 == null) goto L14;
            r10.a(r14, r16, this.f24047b);
            goto L5
        L14:
            throw new IllegalArgumentException("Field map value '" + r15 + "' converted to null by " + this.f24046a.getClass().getName() + " for key '" + r14 + "'.");
        L16:
            throw new IllegalArgumentException("Field map contained null value for key '" + r14 + "'.");
        L18:
            throw new IllegalArgumentException("Field map contained null key.");
        L19:
            return;
        L21:
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    public static final class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f24049b;

        public f(String r10, Converter r11) {
            this.f24048a = (String) retrofit2.i.b(r10, "name == null");
            this.f24049b = r11;
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            String r12 = (String) this.f24049b.convert(r11);
            if (r12 != null) goto L7;
            return;
        L7:
            r10.b(this.f24048a, r12);
        }
    }

    public static final class g extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f24050a;

        public g(Converter r10) {
            this.f24050a = r10;
        }

        @Override // retrofit2.e
        public /* bridge */ /* synthetic */ void a(retrofit2.g r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(retrofit2.g r10, Map r11) {
            if (r11 == null) goto L17;
            Iterator r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L15;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L14;
            Object r15 = r13.getValue();
            if (r15 == null) goto L12;
            r10.b(r14, (String) this.f24050a.convert(r15));
            goto L5
        L12:
            throw new IllegalArgumentException("Header map contained null value for key '" + r14 + "'.");
        L14:
            throw new IllegalArgumentException("Header map contained null key.");
        L15:
            return;
        L17:
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    public static final class h extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Headers f24051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f24052b;

        public h(Headers r10, Converter r11) {
            this.f24051a = r10;
            this.f24052b = r11;
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            if (r11 != null) goto L10;
            return;
        L10:
            r10.c(this.f24051a, (RequestBody) this.f24052b.convert(r11));
            return;
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to RequestBody", e);
        }
    }

    public static final class i extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f24053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f24054b;

        public i(Converter r10, String r11) {
            this.f24053a = r10;
            this.f24054b = r11;
        }

        @Override // retrofit2.e
        public /* bridge */ /* synthetic */ void a(retrofit2.g r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(retrofit2.g r10, Map r11) {
            if (r11 == null) goto L17;
            Iterator r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L15;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L14;
            Object r15 = r13.getValue();
            if (r15 == null) goto L12;
            r10.c(Headers.g(new String[]{HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + r14 + "\"", "Content-Transfer-Encoding", this.f24054b}), (RequestBody) this.f24053a.convert(r15));
            goto L5
        L12:
            throw new IllegalArgumentException("Part map contained null value for key '" + r14 + "'.");
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            return;
        L17:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    public static final class j extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f24056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f24057c;

        public j(String r10, Converter r11, boolean r12) {
            this.f24055a = (String) retrofit2.i.b(r10, "name == null");
            this.f24056b = r11;
            this.f24057c = r12;
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            if (r11 == null) goto L6;
            r10.e(this.f24055a, (String) this.f24056b.convert(r11), this.f24057c);
            return;
        L6:
            throw new IllegalArgumentException("Path parameter \"" + this.f24055a + "\" value must not be null.");
        }
    }

    public static final class k extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f24059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f24060c;

        public k(String r10, Converter r11, boolean r12) {
            this.f24058a = (String) retrofit2.i.b(r10, "name == null");
            this.f24059b = r11;
            this.f24060c = r12;
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            String r12 = (String) this.f24059b.convert(r11);
            if (r12 != null) goto L7;
            return;
        L7:
            r10.f(this.f24058a, r12, this.f24060c);
        }
    }

    public static final class l extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f24061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f24062b;

        public l(Converter r10, boolean r11) {
            this.f24061a = r10;
            this.f24062b = r11;
        }

        @Override // retrofit2.e
        public /* bridge */ /* synthetic */ void a(retrofit2.g r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(retrofit2.g r10, Map r11) {
            if (r11 == null) goto L21;
            Iterator r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L19;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L18;
            Object r15 = r13.getValue();
            if (r15 == null) goto L16;
            String r16 = (String) this.f24061a.convert(r15);
            if (r16 == null) goto L14;
            r10.f(r14, r16, this.f24062b);
            goto L5
        L14:
            throw new IllegalArgumentException("Query map value '" + r15 + "' converted to null by " + this.f24061a.getClass().getName() + " for key '" + r14 + "'.");
        L16:
            throw new IllegalArgumentException("Query map contained null value for key '" + r14 + "'.");
        L18:
            throw new IllegalArgumentException("Query map contained null key.");
        L19:
            return;
        L21:
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    public static final class m extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f24063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f24064b;

        public m(Converter r10, boolean r11) {
            this.f24063a = r10;
            this.f24064b = r11;
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            r10.f((String) this.f24063a.convert(r11), null, this.f24064b);
        }
    }

    public static final class n extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f24065a = null;

        static {
            f24065a = new n();
        }

        public n() {
        }

        @Override // retrofit2.e
        public /* bridge */ /* synthetic */ void a(retrofit2.g r10, Object r11) {
            d(r10, (okhttp3.h.b) r11);
        }

        public void d(retrofit2.g r10, okhttp3.h.b r11) {
            if (r11 == null) goto L5;
            r10.d(r11);
            return;
        }
    }

    public static final class o extends e {
        public o() {
        }

        @Override // retrofit2.e
        public void a(retrofit2.g r10, Object r11) {
            retrofit2.i.b(r11, "@Url parameter is null.");
            r10.k(r11);
        }
    }

    public e() {
    }

    public abstract void a(retrofit2.g r10, Object r11);

    public final e b() {
        return new b(this);
    }

    public final e c() {
        return new a(this);
    }
}
