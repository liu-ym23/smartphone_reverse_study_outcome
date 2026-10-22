package com.stepos.agentframework.chatui.util;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/chatui/util/a;", "", "<init>", "()V", "", "agentId", "text", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/text/Regex;", "CITATION_TAG_PATTERN", "Lkotlin/text/Regex;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final Regex CITATION_TAG_PATTERN = new Regex("\\[citation:\\d+]", RegexOption.IGNORE_CASE);

    public final String a(String agentId, String text) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(text, "text");
        return (com.stepos.agentframework.adapter.agentbus.bff.j.b(agentId) && text.length() != 0 && H.e0(text, "[citation:", true)) ? CITATION_TAG_PATTERN.l(text, "") : text;
    }
}
