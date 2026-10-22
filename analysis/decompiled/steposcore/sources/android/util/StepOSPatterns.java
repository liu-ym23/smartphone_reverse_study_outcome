package android.util;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class StepOSPatterns {
    private static final String LABEL_CHAR = "a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
    private static final String UCS_CHAR = "[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
    private static final String IP_ADDRESS_STRING = "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))";
    private static final Pattern IP_ADDRESS = Pattern.compile(IP_ADDRESS_STRING);
    public static final Pattern PHONE = Pattern.compile("(((?<=[^-\\d－])|^|\\+)\\d{5,15}($|(?=[^-\\d－])))|(((?<=[^-\\d－])|^|\\+)(\\d(( )|(  )|[\\-－]){0,1}){4,14}\\d($|(?=[^-\\d－])))");
    private static Pattern compileIP = Pattern.compile("(([a-zA-Z0-9 -\u2fff\u3040-䷿龦-\ud7ff豈-﷏ﷰ-\ufeff]([a-zA-Z0-9 -\u2fff\u3040-䷿龦-\ud7ff豈-﷏ﷰ-\ufeff\\-]{0,61}[a-zA-Z0-9 -\u2fff\u3040-䷿龦-\ud7ff豈-﷏ﷰ-\ufeff]){0,1}\\.)+[a-zA-Z -\u2fff\u3040-䷿龦-\ud7ff豈-﷏ﷰ-\ufeff]{2,63}|" + IP_ADDRESS + ")");
    private static final String PORT_NUMBER = "\\:\\d{1,5}";
    private static final String PATH_AND_QUERY = "[/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*";
    public static final Pattern WEB_URL_EX = Pattern.compile("(((?:(?i:http|https|rtsp|ftp)://(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + compileIP + ")(?:" + PORT_NUMBER + ")?)(" + PATH_AND_QUERY + ")?)");

    private StepOSPatterns() {
    }
}
