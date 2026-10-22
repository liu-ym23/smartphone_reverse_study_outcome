package c2;

import e2.InterfaceC3979f;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* renamed from: c2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1489a implements InterfaceC3979f {

    /* renamed from: c, reason: collision with root package name */
    public static final String f15418c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f15419d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f15420e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set<b2.b> f15421f;

    /* renamed from: g, reason: collision with root package name */
    public static final C1489a f15422g;

    /* renamed from: h, reason: collision with root package name */
    public static final C1489a f15423h;

    /* renamed from: a, reason: collision with root package name */
    public final String f15424a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15425b;

    static {
        String strA = C1493e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f15418c = strA;
        String strA2 = C1493e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f15419d = strA2;
        String strA3 = C1493e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f15420e = strA3;
        f15421f = Collections.unmodifiableSet(new HashSet(Arrays.asList(b2.b.b("proto"), b2.b.b("json"))));
        f15422g = new C1489a(strA, null);
        f15423h = new C1489a(strA2, strA3);
    }

    public C1489a(String str, String str2) {
        this.f15424a = str;
        this.f15425b = str2;
    }

    public static C1489a c(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new C1489a(str2, str3);
    }

    @Override // e2.InterfaceC3979f
    public Set<b2.b> a() {
        return f15421f;
    }

    public byte[] b() {
        String str = this.f15425b;
        if (str == null && this.f15424a == null) {
            return null;
        }
        String str2 = this.f15424a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f15425b;
    }

    public String e() {
        return this.f15424a;
    }

    @Override // e2.InterfaceC3978e
    public byte[] getExtras() {
        return b();
    }

    @Override // e2.InterfaceC3978e
    public String getName() {
        return "cct";
    }
}
