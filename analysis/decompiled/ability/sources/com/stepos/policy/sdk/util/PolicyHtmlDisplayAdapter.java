package com.stepos.policy.sdk.util;

import D7.K;
import android.content.Context;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ability.R;
import com.stepos.agentframework.adapter.bff.BffConstant;
import j9.InterfaceC1616j;
import j9.l;
import j9.m;
import j9.t;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u0007J#\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0007J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0007J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\"\u0010\u0007J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0007J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0007J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0007J\u001f\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0014J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b0\u0010/J\u0017\u00101\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b1\u0010/R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00104R\u0014\u00107\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00104R\u0014\u00108\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00104R\u0014\u00109\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00104R\u0014\u0010:\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00104R\u0014\u0010;\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00104R\u0014\u0010<\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00104R\u0014\u0010>\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00104R\u0014\u0010?\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00104R\u0014\u0010@\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00104R\u0014\u0010A\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u00104R\u0014\u0010B\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00104R\u0014\u0010C\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00104R\u0014\u0010D\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00104¨\u0006E"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyHtmlDisplayAdapter;", "", AppAgent.CONSTRUCT, "()V", "", "html", "extractTitle", "(Ljava/lang/String;)Ljava/lang/String;", "", "raw", "normalizeVisibleText", "(Ljava/lang/CharSequence;)Ljava/lang/String;", BffConstant.Type.Url, "fallbackTitleFromUrl", "linkText", "resolveNavigationTitle", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "htmlTitle", "intentTitle", "resolveDisplayTitle", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "decodeHtmlText", "text", "stripLinkTitleMarks", "Landroid/content/Context;", "context", "", "isDarkMode", "(Landroid/content/Context;)Z", "darkMode", "prepareHtml", "(Ljava/lang/String;Z)Ljava/lang/String;", "shouldNormalizeForTextView", "(Ljava/lang/String;)Z", "normalizeForTextView", "extractDisplayContent", "extractBodyContent", "stripMetadataTagsForDisplay", "sourceHtml", "emphasizeParagraphs", "Landroid/text/Spannable;", "spannable", "LC7/r;", "clearColorSpans", "(Landroid/text/Spannable;)V", "", "textColor", "(Landroid/content/Context;)I", "viewerBackgroundColor", "linkColor", "Lkotlin/text/Regex;", "INLINE_COLOR_STYLE", "Lkotlin/text/Regex;", "INLINE_BG_COLOR_STYLE", "FONT_COLOR_ATTR", "BG_COLOR_ATTR", "LIGHT_TABLE_BORDER", "STYLE_BLOCK", "SCRIPT_BLOCK", "DOCTYPE", "HTML_BODY", "PARAGRAPH_BLOCK", "MAIN_SECTION", "SUB_SECTION", "NUMBERED_LIST_ITEM", "RICH_HTML_MARKUP", "TITLE_TAG", "HTML_TAG", "WHITESPACE", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyHtmlDisplayAdapter {
    public static final PolicyHtmlDisplayAdapter INSTANCE = new PolicyHtmlDisplayAdapter();
    private static final Regex INLINE_COLOR_STYLE = new Regex("(?i)color\\s*:\\s*[^;\"']+;?");
    private static final Regex INLINE_BG_COLOR_STYLE = new Regex("(?i)background-color\\s*:\\s*[^;\"']+;?");
    private static final Regex FONT_COLOR_ATTR = new Regex("(?i)\\s+color\\s*=\\s*[\"'][^\"']*[\"']");
    private static final Regex BG_COLOR_ATTR = new Regex("(?i)\\s+bgcolor\\s*=\\s*[\"'][^\"']*[\"']");
    private static final Regex LIGHT_TABLE_BORDER = new Regex("(?i)#d9d9d9");
    private static final Regex STYLE_BLOCK = new Regex("(?is)<style[^>]*>.*?</style>");
    private static final Regex SCRIPT_BLOCK = new Regex("(?is)<script[^>]*>.*?</script>");
    private static final Regex DOCTYPE = new Regex("(?i)<!doctype[^>]*>");
    private static final Regex HTML_BODY = new Regex("(?is)<body[^>]*>(.*)</body>");
    private static final Regex PARAGRAPH_BLOCK = new Regex("(?is)<p([^>]*)>(.*?)</p>");
    private static final Regex MAIN_SECTION = new Regex("^[一二三四五六七八九十百]+、.{1,24}$");
    private static final Regex SUB_SECTION = new Regex("^（[一二三四五六七八九十]+）.{1,40}：$");
    private static final Regex NUMBERED_LIST_ITEM = new Regex("^（\\d+）");
    private static final Regex RICH_HTML_MARKUP = new Regex("(?i)<table\\b|<h[1-6]\\b|<b\\b");
    private static final Regex TITLE_TAG = new Regex("(?is)<title[^>]*>(.*?)</title>");
    private static final Regex HTML_TAG = new Regex("<[^>]+>");
    private static final Regex WHITESPACE = new Regex("\\s+");

    private PolicyHtmlDisplayAdapter() {
    }

    public static final void clearColorSpans(Spannable spannable) {
        k.f(spannable, "spannable");
        Object[] spans = spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
        k.e(spans, "spannable.getSpans(0, sp…undColorSpan::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan((ForegroundColorSpan) obj);
        }
        Object[] spans2 = spannable.getSpans(0, spannable.length(), BackgroundColorSpan.class);
        k.e(spans2, "spannable.getSpans(0, sp…undColorSpan::class.java)");
        for (Object obj2 : spans2) {
            spannable.removeSpan((BackgroundColorSpan) obj2);
        }
    }

    private final String decodeHtmlText(String raw) {
        return m.R0(WHITESPACE.f(t.c0(t.c0(t.c0(t.c0(t.c0(t.c0(HTML_TAG.f(raw, ""), "&nbsp;", " "), "&amp;", "&"), "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&#39;", "'"), " ")).toString();
    }

    private final String emphasizeParagraphs(String html, String sourceHtml) {
        final boolean z10 = STYLE_BLOCK.a(sourceHtml) || !RICH_HTML_MARKUP.a(sourceHtml);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        return PARAGRAPH_BLOCK.e(new S7.k() { // from class: com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter.emphasizeParagraphs.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final CharSequence invoke(InterfaceC1616j match) {
                k.f(match, "match");
                l lVar = (l) match;
                String str = (String) ((K) lVar.a()).get(1);
                String string = m.R0((String) ((K) lVar.a()).get(2)).toString();
                if (string.length() == 0 || m.h0(string, "<b", true)) {
                    return lVar.c();
                }
                String string2 = m.R0(new Regex("<[^>]+>").f(string, "")).toString();
                if (t.e0(string2, "【", false) || PolicyHtmlDisplayAdapter.MAIN_SECTION.d(string2) || PolicyHtmlDisplayAdapter.SUB_SECTION.d(string2) || string2.equals("导言") || t.e0(string2, "版本发布", false)) {
                    string = B7.a.m("<b>", string, "</b>");
                } else if (z10 && !ref$BooleanRef.f4916a && m.s0(str) && string2.length() <= 16 && !m.h0(string2, "。", false) && !PolicyHtmlDisplayAdapter.NUMBERED_LIST_ITEM.a(string2)) {
                    ref$BooleanRef.f4916a = true;
                    string = B7.a.m("<b>", string, "</b>");
                }
                return "<p" + str + '>' + string + "</p>";
            }
        }, html);
    }

    private final String extractBodyContent(String html) {
        String str;
        l lVarB = HTML_BODY.b(html);
        return (lVarB == null || (str = (String) ((K) lVarB.a()).get(1)) == null) ? html : str;
    }

    private final String extractDisplayContent(String html) {
        return HTML_BODY.a(html) ? extractBodyContent(html) : html;
    }

    public static final String extractTitle(String html) {
        String str;
        k.f(html, "html");
        if (!m.s0(html)) {
            l lVarB = TITLE_TAG.b(html);
            String string = (lVarB == null || (str = (String) ((K) lVarB.a()).get(1)) == null) ? null : m.R0(str).toString();
            if (string == null) {
                string = "";
            }
            if (string.length() != 0) {
                String strDecodeHtmlText = INSTANCE.decodeHtmlText(string);
                if (strDecodeHtmlText.length() > 0) {
                    return strDecodeHtmlText;
                }
            }
        }
        return null;
    }

    public static final String fallbackTitleFromUrl(String url) {
        k.f(url, "url");
        if (!m.s0(url)) {
            try {
                String path = new URI(url).getPath();
                if (path != null) {
                    if (m.s0(path)) {
                        path = null;
                    }
                    if (path != null) {
                        String strI0 = m.I0(JsonPointer.SEPARATOR, path, path);
                        if (!m.s0(strI0)) {
                            int iV0 = m.v0(strI0, '.', 0, 6);
                            if (iV0 != -1) {
                                strI0 = strI0.substring(0, iV0);
                                k.e(strI0, "substring(...)");
                            }
                            if (!m.s0(strI0)) {
                                return strI0;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final boolean isDarkMode(Context context) {
        k.f(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    @ColorInt
    public static final int linkColor(Context context) {
        k.f(context, "context");
        return ContextCompat.getColor(context, R.color.policy_sdk_html_link);
    }

    public static final String normalizeForTextView(String html) {
        k.f(html, "html");
        PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
        return new Regex("(?i)</h[1-6]>\\s*<p").f(new Regex("(?i)</p>\\s*<h[1-6]").f(new Regex("(?i)</p>\\s*<p").f(policyHtmlDisplayAdapter.emphasizeParagraphs(policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(html)), html), "</p><br/><p"), "</p><br/><h"), "</h1><br/><p");
    }

    public static final String normalizeVisibleText(CharSequence raw) {
        if (raw != null && !m.s0(raw)) {
            PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
            String strStripLinkTitleMarks = policyHtmlDisplayAdapter.stripLinkTitleMarks(policyHtmlDisplayAdapter.decodeHtmlText(raw.toString()));
            if (strStripLinkTitleMarks.length() > 0) {
                return strStripLinkTitleMarks;
            }
        }
        return null;
    }

    public static final String prepareHtml(String html, boolean darkMode) {
        String strStripMetadataTagsForDisplay;
        k.f(html, "html");
        if (m.s0(html)) {
            return html;
        }
        if (shouldNormalizeForTextView(html)) {
            strStripMetadataTagsForDisplay = normalizeForTextView(html);
        } else {
            PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
            strStripMetadataTagsForDisplay = policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(html));
        }
        if (!darkMode) {
            return strStripMetadataTagsForDisplay;
        }
        return LIGHT_TABLE_BORDER.f(BG_COLOR_ATTR.f(FONT_COLOR_ATTR.f(INLINE_BG_COLOR_STYLE.f(INLINE_COLOR_STYLE.f(strStripMetadataTagsForDisplay, ""), ""), ""), ""), "#33FFFFFF");
    }

    public static final String resolveDisplayTitle(String htmlTitle, String intentTitle) {
        if (htmlTitle != null) {
            if (m.s0(htmlTitle)) {
                htmlTitle = null;
            }
            if (htmlTitle != null) {
                return htmlTitle;
            }
        }
        if (intentTitle == null || m.s0(intentTitle)) {
            return null;
        }
        return intentTitle;
    }

    public static final String resolveNavigationTitle(CharSequence linkText, String url) {
        k.f(url, "url");
        String strNormalizeVisibleText = normalizeVisibleText(linkText);
        return strNormalizeVisibleText == null ? fallbackTitleFromUrl(url) : strNormalizeVisibleText;
    }

    public static final boolean shouldNormalizeForTextView(String html) {
        k.f(html, "html");
        if (STYLE_BLOCK.a(html)) {
            return !RICH_HTML_MARKUP.a(html);
        }
        return false;
    }

    private final String stripLinkTitleMarks(String text) {
        return m.R0(t.c0(t.c0(text, "《", ""), "》", "")).toString();
    }

    private final String stripMetadataTagsForDisplay(String html) {
        return m.R0(new Regex("(?i)</?body[^>]*>").f(new Regex("(?i)</?head[^>]*>").f(new Regex("(?i)</?html[^>]*>").f(new Regex("(?i)<meta[^>]*/?>").f(TITLE_TAG.f(SCRIPT_BLOCK.f(STYLE_BLOCK.f(DOCTYPE.f(html, ""), ""), ""), ""), ""), ""), ""), "")).toString();
    }

    @ColorInt
    public static final int textColor(Context context) {
        k.f(context, "context");
        return ContextCompat.getColor(context, R.color.policy_sdk_html_text);
    }

    @ColorInt
    public static final int viewerBackgroundColor(Context context) {
        k.f(context, "context");
        return ContextCompat.getColor(context, R.color.policy_sdk_html_viewer_bg);
    }
}
