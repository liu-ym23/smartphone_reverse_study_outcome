package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class MediaType {
    private static final Pattern PARAMETER = null;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = null;

    @Nullable
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    static {
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private MediaType(String r1, String r2, String r3, @Nullable String r4) {
        this.mediaType = r1;
        this.type = r2;
        this.subtype = r3;
        this.charset = r4;
    }

    public static MediaType get(String r11) {
        Matcher r0 = TYPE_SUBTYPE.matcher(r11);
        if (r0.lookingAt() == false) goto L37;
        String r3 = r0.group(1).toLowerCase(Locale.US);
        String r5 = r0.group(2).toLowerCase(Locale.US);
        Matcher r6 = PARAMETER.matcher(r11);
        int r1 = r0.end();
        String r7 = null;
    L6:
        if (r1 >= r11.length()) goto L35;
        r6.region(r1, r11.length());
        if (r6.lookingAt() == false) goto L33;
        String r2 = r6.group(1);
        if (r2 == null) goto L31;
        if (r2.equalsIgnoreCase("charset") == false) goto L31;
        String r4 = r6.group(2);
        if (r4 != null) goto L17;
        r4 = r6.group(3);
    L24:
        if (r7 != null) goto L26;
    L30:
        r7 = r4;
        goto L31
    L26:
        if (r4.equalsIgnoreCase(r7) == true) goto L30;
        throw new IllegalArgumentException("Multiple charsets defined: \"" + r7 + "\" and: \"" + r4 + "\" for: \"" + r11 + Typography.quote);
    L17:
        if (r4.startsWith("'") == false) goto L24;
        if (r4.endsWith("'") == false) goto L24;
        if (r4.length() <= 2) goto L24;
        r4 = r4.substring(1, r4.length() - 1);
    L31:
        r1 = r6.end();
        goto L6
    L33:
        throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + r11.substring(r1) + "\" for: \"" + r11 + Typography.quote);
    L35:
        return new MediaType(r11, r3, r5, r7);
    L37:
        throw new IllegalArgumentException("No subtype found for: \"" + r11 + Typography.quote);
    }

    @Nullable
    public static MediaType parse(String r0) {
        return get(r0);
    L4:
        return null;
    }

    public String type() {
        return this.type;
    }

    public String subtype() {
        return this.subtype;
    }

    @Nullable
    public Charset charset() {
        return charset(null);
    }

    @Nullable
    public Charset charset(@Nullable Charset r1) {
        String r0 = this.charset;     // Catch: IllegalArgumentException -> L6
        if (r0 == null) goto L9;
        return Charset.forName(r0);
    L9:
        return r1;
    L10:
        return r1;
    }

    public String toString() {
        return this.mediaType;
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof MediaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (((MediaType) r2).mediaType.equals(this.mediaType) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }
}
