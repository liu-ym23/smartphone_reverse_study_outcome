package a7;

import a.AbstractC0291a;
import com.volcengine.tos.TosClientException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: a7.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0307c {

    /* renamed from: a, reason: collision with root package name */
    public static final List f1649a = Arrays.asList(".", "..", "%2e", "%2e.", ".%2e", "%2e%2e");

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new TosClientException("empty ".concat(str), null);
        }
    }

    public static void b(String str) {
        if (AbstractC0291a.x(str) || str.length() < 3 || str.length() > 63) {
            throw new TosClientException("invalid bucket name, the length must be [3, 63]", null);
        }
        if (str.startsWith("-") || str.endsWith("-")) {
            throw new TosClientException("invalid bucket name, the bucket name can be neither starting with '-' nor ending with '-'", null);
        }
        if (!str.matches("^[a-z0-9][a-z0-9-]{1,61}[a-z0-9]$")) {
            throw new TosClientException("invalid bucket name, the character set is illegal", null);
        }
    }

    public static void c(String str) {
        if (AbstractC0291a.x(str)) {
            throw new TosClientException("invalid object name, the length must be larger than 0", null);
        }
        Iterator it = f1649a.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equalsIgnoreCase(str)) {
                throw new TosClientException("object key should not be . or ..", null);
            }
        }
    }

    public static ArrayList d(String str) {
        if (AbstractC0291a.x(str)) {
            throw new TosClientException("empty endpoint", null);
        }
        a(str, "endpoint");
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length == 3 && strArrSplit[0].startsWith("tos-s3")) {
            throw new TosClientException("invalid endpoint, please use TOS endpoint rather than S3 endpoint.", null);
        }
        ArrayList arrayList = new ArrayList(2);
        String str2 = "https";
        if (str.startsWith("https://")) {
            str = str.substring(8);
        } else if (str.startsWith("http")) {
            str = str.substring(7);
            str2 = "http";
        }
        arrayList.add(str2);
        arrayList.add(str);
        return arrayList;
    }
}
