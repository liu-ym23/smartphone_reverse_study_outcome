package O6;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"LO6/f;", "", "<init>", "()V", "", "text", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/text/Regex;", "EXTRA_BLOCK", "Lkotlin/text/Regex;", "TRAILING_BLANK_LINES", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    public static final f INSTANCE = new f();
    private static final Regex EXTRA_BLOCK = new Regex("<extra\\s*>[\\s\\S]*?</extra\\s*>", RegexOption.IGNORE_CASE);
    private static final Regex TRAILING_BLANK_LINES = new Regex("\\n{3,}");

    public final boolean a(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        return H.e0(text, "<extra", true);
    }

    public final String b(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (text.length() == 0 || !a(text)) {
            return text;
        }
        return H.D1(TRAILING_BLANK_LINES.l(EXTRA_BLOCK.l(text, ""), "\n\n")).toString();
    }
}
