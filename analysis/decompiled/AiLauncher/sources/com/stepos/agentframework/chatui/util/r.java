package com.stepos.agentframework.chatui.util;

import La.H;
import Z8.X;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatui/util/r;", "", "<init>", "()V", "", "text", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/text/Regex;", "REFERENCE_DETAILS_PATTERN", "Lkotlin/text/Regex;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class r {
    public static final r INSTANCE = new r();
    private static final Regex REFERENCE_DETAILS_PATTERN = new Regex("<details[^>]*>\\s*<summary>[^<]*引用来源[^<]*</summary>[\\s\\S]*?</details>", (Set<? extends RegexOption>) X.d(RegexOption.IGNORE_CASE));

    public final String a(String text) {
        String strL;
        kotlin.jvm.internal.p.i(text, "text");
        return (text.length() != 0 && H.e0(text, "<details", true) && H.g0(text, "引用来源", false, 2, null) && (strL = REFERENCE_DETAILS_PATTERN.l(text, "")) != text) ? H.F1(strL).toString() : text;
    }
}
