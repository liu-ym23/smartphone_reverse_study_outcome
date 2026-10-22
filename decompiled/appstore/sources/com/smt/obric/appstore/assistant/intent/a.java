package com.smt.obric.appstore.assistant.intent;

import java.util.Locale;
import kotlin.jvm.internal.q;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final String a(String r10) {
        q.g(r10, "appName");
        String r11 = new Regex("[ :\\-_.()!\u3000：－＿．（）！·]").replace(r10, "").toLowerCase(Locale.ROOT);
        q.f(r11, "toLowerCase(...)");
        return r11;
    }
}
