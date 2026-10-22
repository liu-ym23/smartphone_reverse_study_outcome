package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatui/r2;", "", "<init>", "()V", "", "name", "displayName", "parameter", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "text", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "", "hiddenToolNames", "Ljava/util/Set;", "Lkotlin/text/Regex;", "codeLikeName", "Lkotlin/text/Regex;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class r2 {
    public static final r2 INSTANCE = new r2();
    private static final Set<String> hiddenToolNames = Z8.Y.j("task_create", "task_get", "task_list", "stringtojson", "string_to_json");
    private static final Regex codeLikeName = new Regex("[A-Za-z][A-Za-z0-9_.]*");

    public final boolean a(String text) {
        for (int i10 = 0; i10 < text.length(); i10++) {
            char cCharAt = text.charAt(i10);
            if (19968 <= cCharAt && cCharAt < 40960) {
                return false;
            }
        }
        return codeLikeName.k(text);
    }

    public final boolean b(String name, String displayName, String parameter) {
        kotlin.jvm.internal.p.i(name, "name");
        Set<String> set = hiddenToolNames;
        String lowerCase = La.H.D1(name).toString().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return set.contains(lowerCase) || c(name, displayName, parameter) == null;
    }

    public final String c(String name, String displayName, String parameter) {
        String string;
        kotlin.jvm.internal.p.i(name, "name");
        if (displayName == null || (string = La.H.D1(displayName).toString()) == null || string.length() <= 0 || INSTANCE.a(string)) {
            string = null;
        }
        if (string != null) {
            return string;
        }
        String string2 = La.H.D1(ToolNameMapping.INSTANCE.c(name, parameter)).toString();
        if (string2.length() <= 0 || a(string2)) {
            return null;
        }
        return string2;
    }
}
