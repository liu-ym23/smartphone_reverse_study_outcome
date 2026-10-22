package v4;

import com.bytedance.frameworks.baselib.network.http.parser.MimeTypeParseException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f25082a;

    public b() {
        this.f25082a = new Hashtable();
    }

    public static boolean b(char r10) {
        if (r10 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r10 >= 127) goto L9;
        if ("()<>@,;:/[]?=\\\"".indexOf(r10) >= 0) goto L9;
        return true;
    }

    public static String d(String r10) {
        int r11 = r10.length();
        int r12 = 0;
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 >= r11) goto L6;
        if (r14 == true) goto L6;
        r14 = !b(r10.charAt(r13));
        r13 = r13 + 1;
    L6:
        if (r14 == false) goto L21;
        StringBuffer r15 = new StringBuffer();
        r15.ensureCapacity((int) (((double) r11) * 1.5d));
        r15.append(TokenParser.DQUOTE);
    L8:
        if (r12 >= r11) goto L14;
        char r16 = r10.charAt(r12);
        if (r16 == '\\') goto L12;
        if (r16 == '\"') goto L12;
    L13:
        r15.append(r16);
        r12 = r12 + 1;
    L12:
        r15.append(TokenParser.ESCAPE);
        goto L13
    L14:
        r15.append(TokenParser.DQUOTE);
        return r15.toString();
    L21:
        return r10;
    }

    public static int g(String r10, int r11) {
        int r12 = r10.length();
    L3:
        if (r11 >= r12) goto L7;
        if (Character.isWhitespace(r10.charAt(r11)) == false) goto L7;
        r11 = r11 + 1;
    L7:
        return r11;
    }

    public static String h(String r10) {
        int r11 = r10.length();
        StringBuffer r12 = new StringBuffer();
        r12.ensureCapacity(r11);
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 >= r11) goto L14;
        char r15 = r10.charAt(r13);
        if (r14 == false) goto L7;
    L9:
        if (r14 == false) goto L11;
        r12.append(r15);
        r14 = false;
    L12:
        r13 = r13 + 1;
        goto L3
    L11:
        r14 = true;
        goto L12
    L7:
        if (r15 == '\\') goto L9;
        r12.append(r15);
        goto L12
    L14:
        return r12.toString();
    }

    public String a(String r10) {
        return (String) this.f25082a.get(r10.trim().toLowerCase(Locale.ENGLISH));
    }

    public void c(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.length();
        if (r11 > 0) goto L7;
        return;
    L7:
        int r12 = g(r10, 0);
    L8:
        if (r12 >= r11) goto L59;
        if (r10.charAt(r12) != ';') goto L59;
        int r13 = g(r10, r12 + 1);
        if (r13 >= r11) goto L13;
        int r14 = r13;
    L15:
        if (r14 >= r11) goto L19;
        if (b(r10.charAt(r14)) == false) goto L19;
        r14 = r14 + 1;
    L19:
        String r15 = r10.substring(r13, r14).toLowerCase(Locale.ENGLISH);
        int r16 = g(r10, r14);
        if (r16 >= r11) goto L58;
        if (r10.charAt(r16) != '=') goto L58;
        int r17 = g(r10, r16 + 1);
        if (r17 >= r11) goto L56;
        char r18 = r10.charAt(r17);
        if (r18 != '\"') goto L45;
        int r19 = r17 + 1;
        if (r19 >= r11) goto L43;
        int r20 = r19;
    L30:
        if (r20 >= r11) goto L38;
        r18 = r10.charAt(r20);
        if (r18 == '\"') goto L38;
        if (r18 != '\\') goto L37;
        r20 = r20 + 1;
    L37:
        r20 = r20 + 1;
    L38:
        if (r18 != '\"') goto L41;
        String r21 = h(r10.substring(r19, r20));
        int r22 = r20 + 1;
    L52:
        this.f25082a.put(r15, r21);
        r12 = g(r10, r22);
        goto L8
    L41:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L43:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L45:
        if (b(r18) == false) goto L54;
        r22 = r17;
    L47:
        if (r22 >= r11) goto L51;
        if (b(r10.charAt(r22)) == false) goto L51;
        r22 = r22 + 1;
    L51:
        r21 = r10.substring(r17, r22);
        goto L52
    L54:
        throw new MimeTypeParseException("Unexpected character encountered at index " + r17);
    L56:
        throw new MimeTypeParseException("Couldn't find a value for parameter named " + r15);
    L58:
        throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
    L13:
        return;
    L59:
        if (r12 < r11) goto L62;
        return;
    L62:
        throw new MimeTypeParseException("More characters encountered in input than expected.");
    }

    public void e(String r10) {
        this.f25082a.remove(r10.trim().toLowerCase(Locale.ENGLISH));
    }

    public void f(String r10, String r11) {
        this.f25082a.put(r10.trim().toLowerCase(Locale.ENGLISH), r11);
    }

    public String toString() {
        StringBuffer r10 = new StringBuffer();
        r10.ensureCapacity(this.f25082a.size() * 16);
        Enumeration r11 = this.f25082a.keys();
    L4:
        if (r11.hasMoreElements() == false) goto L7;
        String r12 = (String) r11.nextElement();
        r10.append("; ");
        r10.append(r12);
        r10.append('=');
        r10.append(d((String) this.f25082a.get(r12)));
        goto L4
    L7:
        return r10.toString();
    }

    public b(String r10) {
        this.f25082a = new Hashtable();
        c(r10);
    }
}
