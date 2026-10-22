package androidx.core.net;

import android.net.Uri;
import androidx.core.util.Preconditions;
import com.alipay.sdk.m.n.a;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes17.dex */
public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders;

    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    public String getBody() {
        return this.mHeaders.get("body");
    }

    public String getCc() {
        return this.mHeaders.get(CC);
    }

    public String getSubject() {
        return this.mHeaders.get("subject");
    }

    public String getTo() {
        return this.mHeaders.get("to");
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("mailto:?");
        Iterator<Map.Entry<String, String>> r101 = this.mHeaders.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<String, String> r102 = r101.next();
        r100.append(Uri.encode(r102.getKey()));
        r100.append(a.f25612h);
        r100.append(Uri.encode(r102.getValue()));
        r100.append(Typography.amp);
        goto L4
    L7:
        return r100.toString();
    }

    private MailTo() {
        this.mHeaders = new HashMap();
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public static boolean isMailTo(Uri r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (MAILTO.equals(r100.getScheme()) == false) goto L6;
        return true;
    }

    public static MailTo parse(String r110) throws ParseException {
        Preconditions.checkNotNull(r110);
        if (isMailTo(r110) == false) goto L30;
        int r100 = r110.indexOf(35);
        if (r100 == (-1)) goto L7;
        r110 = r110.substring(0, r100);
    L7:
        int r101 = r110.indexOf(63);
        if (r101 != (-1)) goto L10;
        String r102 = Uri.decode(r110.substring(7));
        String r111 = null;
    L11:
        MailTo r103 = new MailTo();
        if (r111 == null) goto L24;
        String[] r112 = r111.split("&");
        int r104 = r112.length;
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L24;
        String[] r106 = r112[r105].split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
        if (r106.length == 0) goto L23;
        String r107 = Uri.decode(r106[0]).toLowerCase(Locale.ROOT);
        if (r106.length <= 1) goto L21;
        String r108 = Uri.decode(r106[1]);
    L22:
        r103.mHeaders.put(r107, r108);
        goto L23
    L21:
        r108 = null;
    L23:
        r105 = r105 + 1;
    L24:
        String r113 = r103.getTo();
        if (r113 == null) goto L27;
        r102 = r102 + ", " + r113;
    L27:
        r103.mHeaders.put("to", r102);
        return r103;
    L10:
        r102 = Uri.decode(r110.substring(7, r101));
        r111 = r110.substring(r101 + 1);
        goto L11
    L30:
        throw new ParseException("Not a mailto scheme");
    }

    public static boolean isMailTo(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.startsWith(MAILTO_SCHEME) == false) goto L6;
        return true;
    }

    public static MailTo parse(Uri r100) throws ParseException {
        return parse(r100.toString());
    }
}
