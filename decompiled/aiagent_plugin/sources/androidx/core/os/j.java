package androidx.core.os;

import com.ss.android.socialbase.downloader.segment.Segment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: LocaleListCompatWrapper.java */
/* JADX INFO: loaded from: classes.dex */
final class j implements k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Locale[] f1272c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Locale f1273d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Locale f1274e = null;
    private static final Locale f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Locale[] f1275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1276b;

    @Override // androidx.core.os.k
    public Object a() {
        return null;
    }

    static {
        f1272c = new Locale[0];
        f1273d = new Locale(Segment.JsonKey.END, "XA");
        f1274e = new Locale("ar", "XB");
        f = i.b("en-Latn");
    }

    @Override // androidx.core.os.k
    public Locale a(int r2) {
        if (r2 < 0) goto L6;
        Locale[] r1 = this.f1275a;
        if (r2 >= r1.length) goto L6;
        return r1[r2];
    L6:
        return null;
    }

    @Override // androidx.core.os.k
    public boolean b() {
        if (this.f1275a.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.os.k
    public int c() {
        return this.f1275a.length;
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, j.class) == true) goto L8;
        return false;
    L8:
        Locale[] r7 = ((j) ZeusTransformUtils.preCheckCast(r6, j.class, "com.obric.aiagent.plugin")).f1275a;
        if (this.f1275a.length == r7.length) goto L11;
        return false;
    L11:
        int r0 = 0;
    L12:
        Locale[] r2 = this.f1275a;
        if (r0 >= r2.length) goto L18;
        if (r2[r0].equals(r7[r0]) == false) goto L16;
        r0 = r0 + 1;
        goto L12
    L16:
        return false;
    L18:
        return true;
    }

    public int hashCode() {
        Locale[] r4 = this.f1275a;
        int r0 = r4.length;
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = (r1 * 31) + r4[r2].hashCode();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        int r1 = 0;
    L3:
        Locale[] r2 = this.f1275a;
        if (r1 >= r2.length) goto L9;
        r0.append(r2[r1]);
        if (r1 >= (this.f1275a.length - 1)) goto L8;
        r0.append(',');
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        r0.append("]");
        return r0.toString();
    }

    @Override // androidx.core.os.k
    public String d() {
        return this.f1276b;
    }

    j(Locale... r9) {
        if (r9.length != 0) goto L5;
        this.f1275a = f1272c;
        this.f1276b = "";
        return;
    L5:
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        StringBuilder r2 = new StringBuilder();
        int r4 = 0;
    L7:
        if (r4 >= r9.length) goto L19;
        Locale r5 = r9[r4];
        if (r5 == null) goto L18;
        if (r1.contains(r5) == true) goto L16;
        Locale r6 = (Locale) ZeusTransformUtils.preCheckCast(r5.clone(), Locale.class, "com.obric.aiagent.plugin");
        r0.add(r6);
        a(r2, r6);
        if (r4 >= (r9.length - 1)) goto L15;
        r2.append(',');
    L15:
        r1.add(r6);
    L16:
        r4 = r4 + 1;
        goto L7
    L18:
        throw new NullPointerException("list[" + r4 + "] is null");
    L19:
        this.f1275a = (Locale[]) ZeusTransformUtils.preCheckCast(r0.toArray(new Locale[0]), Locale[].class, "com.obric.aiagent.plugin");
        this.f1276b = r2.toString();
    }

    static void a(StringBuilder r1, Locale r2) {
        r1.append(r2.getLanguage());
        String r0 = r2.getCountry();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L9;
        r1.append('-');
        r1.append(r2.getCountry());
        return;
    }
}
