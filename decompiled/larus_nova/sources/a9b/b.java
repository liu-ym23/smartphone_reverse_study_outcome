package a9b;

import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2305c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C0034b> f2306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ContactMobileBean> f2307b;

    public static final class a {
    }

    /* JADX INFO: renamed from: a9b.b$b, reason: collision with other inner class name */
    public static final class C0034b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContactMobileBean f2308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<a9b.a> f2309b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0034b) == true) goto L8;
            return false;
        L8:
            C0034b r101 = (C0034b) r100;
            if (Intrinsics.areEqual(this.f2308a, r101.f2308a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f2309b, r101.f2309b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f2308a.hashCode() * 31) + this.f2309b.hashCode();
        }

        public final String toString() {
            return "CpFeishuUsers(cp=" + this.f2308a + ", userInfos=" + this.f2309b + ')';
        }

        public C0034b(ContactMobileBean r100, List<a9b.a> r101) {
            Intrinsics.checkNotNullParameter(r100, "cp");
            Intrinsics.checkNotNullParameter(r101, "userInfos");
            this.f2308a = r100;
            this.f2309b = r101;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f2306a, r101.f2306a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2307b, r101.f2307b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f2306a.hashCode() * 31) + this.f2307b.hashCode();
    }

    public final String toString() {
        return "ContactsMobileFeishuInfo(cpFeishuUsers=" + this.f2306a + ", cpNotFeishuUsers=" + this.f2307b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<C0034b> r100, List<? extends ContactMobileBean> r101) {
        Intrinsics.checkNotNullParameter(r100, "cpFeishuUsers");
        Intrinsics.checkNotNullParameter(r101, "cpNotFeishuUsers");
        this.f2306a = r100;
        this.f2307b = r101;
    }
}
