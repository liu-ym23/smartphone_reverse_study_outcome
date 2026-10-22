package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {
    public static final /* synthetic */ d.l.j a(MatchResult r2) {
        return b((MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, MatchResult.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ d.l.j a(MatchResult r2, int r3) {
        return b((MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, MatchResult.class, "com.obric.aiagent.plugin"), r3);
    }

    public static final /* synthetic */ i a(Matcher r2, int r3, CharSequence r4) {
        return b(r2, r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ i a(Matcher r2, CharSequence r3) {
        return b(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private static final i b(Matcher r2, int r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2.find(r3) == true) goto L6;
        return null;
    L6:
        return (i) ZeusTransformUtils.preCheckCast(new j(r2, r5), i.class, "com.obric.aiagent.plugin");
    }

    private static final i b(Matcher r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2.matches() == true) goto L6;
        return null;
    L6:
        return (i) ZeusTransformUtils.preCheckCast(new j(r2, r4), i.class, "com.obric.aiagent.plugin");
    }

    private static final d.l.j b(MatchResult r2) {
        MatchResult r3 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, MatchResult.class, "com.obric.aiagent.plugin");
        return d.l.n.b(r3.start(), r3.end());
    }

    private static final d.l.j b(MatchResult r2, int r3) {
        MatchResult r4 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, MatchResult.class, "com.obric.aiagent.plugin");
        return d.l.n.b(r4.start(r3), r4.end(r3));
    }
}
