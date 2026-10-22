package android.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class StepOSStringSecure {
    private static final Pattern PHONE_NUM = Pattern.compile("(?<!\\d)(?:(?:1[3456789]\\d{9})|(?:861[3456789]\\d{9}))(?!\\d)");

    public static String securePhoneNum(String orginMsg) {
        if (orginMsg == null) {
            return null;
        }
        String result = orginMsg;
        Matcher matcher = PHONE_NUM.matcher(result);
        while (matcher.find()) {
            result = result.replace(matcher.group(), matcher.group().substring(0, 5) + "******");
        }
        return result;
    }
}
