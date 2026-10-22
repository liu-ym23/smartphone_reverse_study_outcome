package com.stepos.policy.sdk.util;

import La.D;
import La.H;
import La.m;
import android.content.Context;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.policy.sdk.R$color;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u0007J#\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0007J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0007J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\"\u0010\u0007J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0007J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0007J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0007J\u001f\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0014J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b0\u0010/J\u0017\u00101\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b1\u0010/R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00104R\u0014\u00107\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00104R\u0014\u00108\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00104R\u0014\u00109\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00104R\u0014\u0010:\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00104R\u0014\u0010;\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00104R\u0014\u0010<\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00104R\u0014\u0010>\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00104R\u0014\u0010?\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00104R\u0014\u0010@\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00104R\u0014\u0010A\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u00104R\u0014\u0010B\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00104R\u0014\u0010C\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00104R\u0014\u0010D\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00104¨\u0006E"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyHtmlDisplayAdapter;", "", "<init>", "()V", "", "html", "extractTitle", "(Ljava/lang/String;)Ljava/lang/String;", "", "raw", "normalizeVisibleText", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "url", "fallbackTitleFromUrl", "linkText", "resolveNavigationTitle", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "htmlTitle", "intentTitle", "resolveDisplayTitle", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "decodeHtmlText", "text", "stripLinkTitleMarks", "Landroid/content/Context;", "context", "", "isDarkMode", "(Landroid/content/Context;)Z", "darkMode", "prepareHtml", "(Ljava/lang/String;Z)Ljava/lang/String;", "shouldNormalizeForTextView", "(Ljava/lang/String;)Z", "normalizeForTextView", "extractDisplayContent", "extractBodyContent", "stripMetadataTagsForDisplay", "sourceHtml", "emphasizeParagraphs", "Landroid/text/Spannable;", "spannable", "LY8/t;", "clearColorSpans", "(Landroid/text/Spannable;)V", "", "textColor", "(Landroid/content/Context;)I", "viewerBackgroundColor", "linkColor", "Lkotlin/text/Regex;", "INLINE_COLOR_STYLE", "Lkotlin/text/Regex;", "INLINE_BG_COLOR_STYLE", "FONT_COLOR_ATTR", "BG_COLOR_ATTR", "LIGHT_TABLE_BORDER", "STYLE_BLOCK", "SCRIPT_BLOCK", "DOCTYPE", "HTML_BODY", "PARAGRAPH_BLOCK", "MAIN_SECTION", "SUB_SECTION", "NUMBERED_LIST_ITEM", "RICH_HTML_MARKUP", "TITLE_TAG", "HTML_TAG", "WHITESPACE", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
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
        p.i(spannable, "spannable");
        Object[] spans = spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
        p.h(spans, "spannable.getSpans(0, sp…undColorSpan::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan((ForegroundColorSpan) obj);
        }
        Object[] spans2 = spannable.getSpans(0, spannable.length(), BackgroundColorSpan.class);
        p.h(spans2, "spannable.getSpans(0, sp…undColorSpan::class.java)");
        for (Object obj2 : spans2) {
            spannable.removeSpan((BackgroundColorSpan) obj2);
        }
    }

    private final String decodeHtmlText(String raw) {
        return H.D1(WHITESPACE.l(D.T(D.T(D.T(D.T(D.T(D.T(HTML_TAG.l(raw, ""), "&nbsp;", " ", false, 4, null), "&amp;", Const.STR_MART_ADD, false, 4, null), "&lt;", "<", false, 4, null), "&gt;", ">", false, 4, null), "&quot;", "\"", false, 4, null), "&#39;", "'", false, 4, null), " ")).toString();
    }

    private final String emphasizeParagraphs(String html, String sourceHtml) {
        final boolean z10 = STYLE_BLOCK.b(sourceHtml) || !RICH_HTML_MARKUP.b(sourceHtml);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        return PARAGRAPH_BLOCK.m(html, new InterfaceC5074l<m, CharSequence>() { // from class: com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter.emphasizeParagraphs.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p9.InterfaceC5074l
            public final CharSequence invoke(m match) {
                p.i(match, "match");
                String str = match.c().get(1);
                String string = H.D1(match.c().get(2)).toString();
                if (string.length() == 0 || H.e0(string, "<b", true)) {
                    return match.getValue();
                }
                String string2 = H.D1(new Regex("<[^>]+>").l(string, "")).toString();
                if (D.X(string2, "【", false, 2, null)) {
                    string = "<b>" + string + "</b>";
                } else if (PolicyHtmlDisplayAdapter.MAIN_SECTION.k(string2)) {
                    string = "<b>" + string + "</b>";
                } else if (PolicyHtmlDisplayAdapter.SUB_SECTION.k(string2)) {
                    string = "<b>" + string + "</b>";
                } else if (p.d(string2, "导言") || D.X(string2, "版本发布", false, 2, null)) {
                    string = "<b>" + string + "</b>";
                } else if (z10 && !ref$BooleanRef.f34815a && H.x0(str) && string2.length() <= 16 && !H.g0(string2, "。", false, 2, null) && !PolicyHtmlDisplayAdapter.NUMBERED_LIST_ITEM.b(string2)) {
                    ref$BooleanRef.f34815a = true;
                    string = "<b>" + string + "</b>";
                }
                return "<p" + str + '>' + string + "</p>";
            }
        });
    }

    private final String extractBodyContent(String html) {
        List<String> listC;
        String str;
        m mVarD = Regex.d(HTML_BODY, html, 0, 2, null);
        return (mVarD == null || (listC = mVarD.c()) == null || (str = listC.get(1)) == null) ? html : str;
    }

    private final String extractDisplayContent(String html) {
        return HTML_BODY.b(html) ? extractBodyContent(html) : html;
    }

    public static final String extractTitle(String html) {
        List<String> listC;
        String str;
        p.i(html, "html");
        if (H.x0(html)) {
            return null;
        }
        m mVarD = Regex.d(TITLE_TAG, html, 0, 2, null);
        String string = (mVarD == null || (listC = mVarD.c()) == null || (str = listC.get(1)) == null) ? null : H.D1(str).toString();
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return null;
        }
        String strDecodeHtmlText = INSTANCE.decodeHtmlText(string);
        if (strDecodeHtmlText.length() > 0) {
            return strDecodeHtmlText;
        }
        return null;
    }

    public static final String fallbackTitleFromUrl(String url) {
        p.i(url, "url");
        if (H.x0(url)) {
            return null;
        }
        try {
            String path = new URI(url).getPath();
            if (path != null) {
                if (H.x0(path)) {
                    path = null;
                }
                if (path != null) {
                    String strS1 = H.s1(path, JsonPointer.SEPARATOR, null, 2, null);
                    if (H.x0(strS1)) {
                        return null;
                    }
                    String strA1 = H.A1(strS1, '.', null, 2, null);
                    if (!H.x0(strA1)) {
                        return strA1;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final boolean isDarkMode(Context context) {
        p.i(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final int linkColor(Context context) {
        p.i(context, "context");
        return androidx.core.content.a.c(context, R$color.policy_sdk_html_link);
    }

    public static final String normalizeForTextView(String html) {
        p.i(html, "html");
        PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
        return new Regex("(?i)</h[1-6]>\\s*<p").l(new Regex("(?i)</p>\\s*<h[1-6]").l(new Regex("(?i)</p>\\s*<p").l(policyHtmlDisplayAdapter.emphasizeParagraphs(policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(html)), html), "</p><br/><p"), "</p><br/><h"), "</h1><br/><p");
    }

    public static final String normalizeVisibleText(CharSequence raw) {
        if (raw != null && !H.x0(raw)) {
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
        p.i(html, "html");
        if (H.x0(html)) {
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
        return LIGHT_TABLE_BORDER.l(BG_COLOR_ATTR.l(FONT_COLOR_ATTR.l(INLINE_BG_COLOR_STYLE.l(INLINE_COLOR_STYLE.l(strStripMetadataTagsForDisplay, ""), ""), ""), ""), "#33FFFFFF");
    }

    public static final String resolveDisplayTitle(String htmlTitle, String intentTitle) {
        if (htmlTitle != null) {
            if (H.x0(htmlTitle)) {
                htmlTitle = null;
            }
            if (htmlTitle != null) {
                return htmlTitle;
            }
        }
        if (intentTitle == null || H.x0(intentTitle)) {
            return null;
        }
        return intentTitle;
    }

    public static final String resolveNavigationTitle(CharSequence linkText, String url) {
        p.i(url, "url");
        String strNormalizeVisibleText = normalizeVisibleText(linkText);
        return strNormalizeVisibleText == null ? fallbackTitleFromUrl(url) : strNormalizeVisibleText;
    }

    public static final boolean shouldNormalizeForTextView(String html) {
        p.i(html, "html");
        if (STYLE_BLOCK.b(html)) {
            return !RICH_HTML_MARKUP.b(html);
        }
        return false;
    }

    private final String stripLinkTitleMarks(String text) {
        return H.D1(D.T(D.T(text, "《", "", false, 4, null), "》", "", false, 4, null)).toString();
    }

    private final String stripMetadataTagsForDisplay(String html) {
        return H.D1(new Regex("(?i)</?body[^>]*>").l(new Regex("(?i)</?head[^>]*>").l(new Regex("(?i)</?html[^>]*>").l(new Regex("(?i)<meta[^>]*/?>").l(TITLE_TAG.l(SCRIPT_BLOCK.l(STYLE_BLOCK.l(DOCTYPE.l(html, ""), ""), ""), ""), ""), ""), ""), "")).toString();
    }

    public static final int textColor(Context context) {
        p.i(context, "context");
        return androidx.core.content.a.c(context, R$color.policy_sdk_html_text);
    }

    public static final int viewerBackgroundColor(Context context) {
        p.i(context, "context");
        return androidx.core.content.a.c(context, R$color.policy_sdk_html_viewer_bg);
    }
}
