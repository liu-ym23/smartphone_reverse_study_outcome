package e2;

import com.google.android.datatransport.Priority;
import e2.m;
import java.util.Arrays;

/* renamed from: e2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3976c extends m {

    /* renamed from: a, reason: collision with root package name */
    public final String f32250a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f32251b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f32252c;

    /* renamed from: e2.c$b */
    public static final class b extends m.a {

        /* renamed from: a, reason: collision with root package name */
        public String f32253a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f32254b;

        /* renamed from: c, reason: collision with root package name */
        public Priority f32255c;

        @Override // e2.m.a
        public m a() {
            String str = "";
            if (this.f32253a == null) {
                str = " backendName";
            }
            if (this.f32255c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new C3976c(this.f32253a, this.f32254b, this.f32255c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e2.m.a
        public m.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f32253a = str;
            return this;
        }

        @Override // e2.m.a
        public m.a c(byte[] bArr) {
            this.f32254b = bArr;
            return this;
        }

        @Override // e2.m.a
        public m.a d(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f32255c = priority;
            return this;
        }
    }

    @Override // e2.m
    public String b() {
        return this.f32250a;
    }

    @Override // e2.m
    public byte[] c() {
        return this.f32251b;
    }

    @Override // e2.m
    public Priority d() {
        return this.f32252c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.f32250a.equals(mVar.b())) {
                if (Arrays.equals(this.f32251b, mVar instanceof C3976c ? ((C3976c) mVar).f32251b : mVar.c()) && this.f32252c.equals(mVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f32252c.hashCode() ^ ((((this.f32250a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f32251b)) * 1000003);
    }

    public C3976c(String str, byte[] bArr, Priority priority) {
        this.f32250a = str;
        this.f32251b = bArr;
        this.f32252c = priority;
    }
}
