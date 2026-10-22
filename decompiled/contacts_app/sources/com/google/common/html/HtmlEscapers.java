package com.google.common.html;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class HtmlEscapers {
    private static final Escaper HTML_ESCAPER = null;

    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }

    static {
        HTML_ESCAPER = Escapers.builder().addEscape(Typography.quote, "&quot;").addEscape('\'', "&#39;").addEscape(Typography.amp, "&amp;").addEscape('<', "&lt;").addEscape('>', "&gt;").build();
    }

    private HtmlEscapers() {
    }
}
