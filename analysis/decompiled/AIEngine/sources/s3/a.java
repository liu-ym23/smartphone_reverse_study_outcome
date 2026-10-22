package s3;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    static {
        Pattern.compile("\\s*|\t|\r|\n");
    }

    public static boolean a(String str) {
        return str == null || "".equals(str);
    }
}
