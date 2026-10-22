package od;

import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.TextSource;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f22558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f22559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f22560d;

        public a(String r10, String r11, h r12, List r13) {
            q.g(r10, "id");
            q.g(r11, "bindingKey");
            q.g(r13, "properties");
            super(null);
            this.f22557a = r10;
            this.f22558b = r11;
            this.f22559c = r12;
            this.f22560d = r13;
        }

        @Override // od.b
        public String a() {
            return this.f22557a;
        }

        @Override // od.b
        public List b() {
            return this.f22560d;
        }

        public final String c() {
            return this.f22558b;
        }

        public final h d() {
            return this.f22559c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (q.b(a(), r11.a()) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f22558b, r11.f22558b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f22559c, r11.f22559c) == true) goto L18;
            return false;
        L18:
            if (q.b(b(), r11.b()) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r10 = ((a().hashCode() * 31) + this.f22558b.hashCode()) * 31;
            h r11 = this.f22559c;
            if (r11 != null) goto L5;
            int r12 = 0;
        L7:
            return ((r10 + r12) * 31) + b().hashCode();
        L5:
            r12 = r11.hashCode();
            goto L7
        }

        public String toString() {
            return "ExternalView(id=" + a() + ", bindingKey=" + this.f22558b + ", material=" + this.f22559c + ", properties=" + b() + ')';
        }
    }

    /* JADX INFO: renamed from: od.b$b, reason: collision with other inner class name */
    public static final class C0328b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextSource f22562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f22563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BlendSpec f22564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f22565e;

        public /* synthetic */ C0328b(String r10, TextSource r11, e r12, BlendSpec r13, List r14, int r15, DefaultConstructorMarker r16) {
            if ((r15 & 8) == 0) goto L5;
            r13 = BlendSpec.SRC_OVER;
        L5:
            this(r10, r11, r12, r13, r14);
        }

        @Override // od.b
        public String a() {
            return this.f22561a;
        }

        @Override // od.b
        public List b() {
            return this.f22565e;
        }

        public final BlendSpec c() {
            return this.f22564d;
        }

        public final e d() {
            return this.f22563c;
        }

        public final TextSource e() {
            return this.f22562b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0328b) == true) goto L8;
            return false;
        L8:
            C0328b r11 = (C0328b) r10;
            if (q.b(a(), r11.a()) == true) goto L12;
            return false;
        L12:
            if (this.f22562b == r11.f22562b) goto L15;
            return false;
        L15:
            if (q.b(this.f22563c, r11.f22563c) == true) goto L18;
            return false;
        L18:
            if (this.f22564d == r11.f22564d) goto L21;
            return false;
        L21:
            if (q.b(b(), r11.b()) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((a().hashCode() * 31) + this.f22562b.hashCode()) * 31) + this.f22563c.hashCode()) * 31) + this.f22564d.hashCode()) * 31) + b().hashCode();
        }

        public String toString() {
            return "Text(id=" + a() + ", source=" + this.f22562b + ", fill=" + this.f22563c + ", blend=" + this.f22564d + ", properties=" + b() + ')';
        }

        public C0328b(String r10, TextSource r11, e r12, BlendSpec r13, List r14) {
            q.g(r10, "id");
            q.g(r11, "source");
            q.g(r12, "fill");
            q.g(r13, "blend");
            q.g(r14, "properties");
            super(null);
            this.f22561a = r10;
            this.f22562b = r11;
            this.f22563c = r12;
            this.f22564d = r13;
            this.f22565e = r14;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker r10) {
        this();
    }

    public abstract String a();

    public abstract List b();

    public b() {
    }
}
