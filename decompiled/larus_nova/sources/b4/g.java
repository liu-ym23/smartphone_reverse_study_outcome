package b4;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f17455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17456c;

    public static final class a {
        public static String a(String r100, String r101) {
            if (r101 != null) goto L5;
            r100 = URLEncoder.encode(r100, "ISO_8859_1");     // Catch: UnsupportedEncodingException -> L10
        L8:
            Intrinsics.checkNotNull(r100);     // Catch: UnsupportedEncodingException -> L10
            return r100;
        L5:
            if (Intrinsics.areEqual(r101, "null_encoding") == true) goto L8;
            r100 = URLEncoder.encode(r100, r101);     // Catch: UnsupportedEncodingException -> L10
        L10:
            e = move-exception;
            throw new IllegalArgumentException(e);
        }
    }

    static {
    }

    public final String a() {
        if (this.f17455b.isEmpty() == true) goto L5;
        HashMap<String, String> r100 = this.f17455b;
        String r101 = this.f17456c;
        StringBuilder r102 = new StringBuilder();
        Set<String> r103 = r100.keySet();
        boolean r104 = false;
        String r105 = "";
        if (r103.isEmpty() == true) goto L26;
        Iterator<String> r106 = r103.iterator();
    L11:
        if (r106.hasNext() == false) goto L24;
        String r107 = r106.next();
        String r108 = a.a(r107, r101);
        String r109 = r100.get(r107);
        if (r109 == null) goto L16;
        String r110 = a.a(r109, r101);
        if (r110 == null) goto L16;
    L18:
        if (r102.length() <= 0) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L23;
        r102.append("&");
    L23:
        r102.append(r108);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r110);
        goto L11
    L20:
        r111 = false;
    L16:
        r110 = "";
        goto L18
    L24:
        r105 = r102.toString();
    L26:
        if (this.f17454a.length() != 0) goto L28;
        r104 = true;
    L28:
        if (r104 == false) goto L31;
        return r105;
    L31:
        if (StringsKt.indexOf$default(this.f17454a, '?', 0, false, 6, null) < 0) goto L34;
        return this.f17454a + Typography.amp + r105;
    L34:
        return this.f17454a + '?' + r105;
    L5:
        return this.f17454a;
    }

    public final String toString() {
        return a();
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f17454a = r100;
        this.f17455b = new HashMap();
        this.f17456c = "UTF-8";
    }
}
