package ao5;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f15784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TemplateV4> f15786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f15787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, TemplateV4> f15789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<Integer, List<TemplateV4>> f15790g;

    /* JADX INFO: renamed from: ao5.a$a, reason: collision with other inner class name */
    public static final class C0203a {
    }

    static {
    }

    public a() {
        this(null, false, null, 0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f15784a, r101.f15784a) == true) goto L12;
        return false;
    L12:
        if (this.f15785b == r101.f15785b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f15786c, r101.f15786c) == true) goto L18;
        return false;
    L18:
        if (this.f15787d == r101.f15787d) goto L21;
        return false;
    L21:
        if (this.f15788e == r101.f15788e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f15789f, r101.f15789f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f15790g, r101.f15790g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f15784a.hashCode() * 31;
        int r101 = 1231;
        if (this.f15785b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f15786c.hashCode()) * 31;
        long r104 = this.f15787d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.f15788e == true) goto L11;
        r101 = 1237;
    L11:
        return ((((r105 + r101) * 31) + this.f15789f.hashCode()) * 31) + this.f15790g.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "Category(name=" + this.f15784a + ", hasMore=" + this.f15785b + ", templates=" + this.f15786c + ", categoryId=" + this.f15787d + ", loadFirstTab=" + this.f15788e + ", templateMap=" + this.f15789f + ", categoryPage=" + this.f15790g + ')';
    }

    public final List<e> a() {
        ArrayList r100 = new ArrayList();
        r100.add(new d(this.f15784a));
        if (this.f15786c.isEmpty() == false) goto L5;
        r100.add(new c());
    L6:
        return r100;
    L5:
        r100.addAll(this.f15786c);
        goto L6
    }

    public a(CharSequence r100, boolean r101, List r102, long r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        r100 = "";
    L5:
        boolean r105 = false;
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new ArrayList();
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = -1;
    L15:
        if ((r104 & 16) == 0) goto L17;
        r105 = true;
    L17:
        HashMap<Integer, List<TemplateV4>> r106 = null;
        if ((r104 & 32) == 0) goto L20;
        HashMap<String, TemplateV4> r107 = new HashMap();
    L22:
        if ((r104 & 64) == 0) goto L24;
        r106 = new HashMap();
    L24:
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "templates");
        Intrinsics.checkNotNullParameter(r107, "templateMap");
        Intrinsics.checkNotNullParameter(r106, "categoryPage");
        this.f15784a = r100;
        this.f15785b = r101;
        this.f15786c = r102;
        this.f15787d = r103;
        this.f15788e = r105;
        this.f15789f = r107;
        this.f15790g = r106;
        return;
    L20:
        r107 = null;
        goto L22
    }
}
