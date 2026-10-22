package a48;

import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1790a;

    /* JADX INFO: renamed from: a48.a$a, reason: collision with other inner class name */
    public static final class C0012a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z38.a f1792c;

        public final int hashCode() {
            return (this.f1791b.hashCode() * 31) + this.f1792c.hashCode();
        }

        public final String toString() {
            return "TokenInvalid(token=" + this.f1791b + ", message=" + this.f1792c + ')';
        }

        @Override // a48.a
        public final String a() {
            return this.f1791b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0012a) == true) goto L8;
            return false;
        L8:
            C0012a r101 = (C0012a) r100;
            if (Intrinsics.areEqual(this.f1791b, r101.f1791b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f1792c, r101.f1792c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public C0012a(String r100, z38.a r101) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "message");
            super(r100);
            this.f1791b = r100;
            this.f1792c = r101;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MfaMessage f1794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f1795d;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            int r100 = ((this.f1793b.hashCode() * 31) + this.f1794c.hashCode()) * 31;
            boolean r101 = this.f1795d;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return r100 + r102;
        }

        public final String toString() {
            return "TokenReceive(token=" + this.f1793b + ", message=" + this.f1794c + ", isDeeplink=" + this.f1795d + ')';
        }

        @Override // a48.a
        public final String a() {
            return this.f1793b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f1793b, r101.f1793b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f1794c, r101.f1794c) == true) goto L15;
            return false;
        L15:
            if (this.f1795d == r101.f1795d) goto L17;
            return false;
        L17:
            return true;
        }

        public b(String r100, MfaMessage r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "message");
            super(r100);
            this.f1793b = r100;
            this.f1794c = r101;
            this.f1795d = r102;
        }
    }

    public String a() {
        return this.f1790a;
    }

    public a(String r100) {
        this.f1790a = r100;
    }
}
