package com.stepos.policy.sdk.util;

import android.content.Context;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.stepos.aiengine.R;
import gc.h;
import gc.i;
import gc.o;
import gc.q;
import java.net.URI;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.text.Regex;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
        kotlin.jvm.internal.g.f(spannable, "spannable");
        Object[] spans = spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
        kotlin.jvm.internal.g.e(spans, "spannable.getSpans(0, sp…undColorSpan::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan((ForegroundColorSpan) obj);
        }
        Object[] spans2 = spannable.getSpans(0, spannable.length(), BackgroundColorSpan.class);
        kotlin.jvm.internal.g.e(spans2, "spannable.getSpans(0, sp…undColorSpan::class.java)");
        for (Object obj2 : spans2) {
            spannable.removeSpan((BackgroundColorSpan) obj2);
        }
    }

    private final String decodeHtmlText(String str) {
        return q.L0(WHITESPACE.d(o.i0(o.i0(o.i0(o.i0(o.i0(o.i0(HTML_TAG.d(str, ""), "&nbsp;", " "), "&amp;", "&"), "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&#39;", "'"), " ")).toString();
    }

    private final String emphasizeParagraphs(String str, String str2) {
        final boolean z = STYLE_BLOCK.a(str2) || !RICH_HTML_MARKUP.a(str2);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        return PARAGRAPH_BLOCK.e(str, new l<h, CharSequence>() { // from class: com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter.emphasizeParagraphs.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // zb.l
            public final CharSequence invoke(h match) {
                kotlin.jvm.internal.g.f(match, "match");
                String str3 = match.a().get(1);
                String string = q.L0(match.a().get(2)).toString();
                if (string.length() == 0 || q.l0(string, "<b", true)) {
                    return match.getValue();
                }
                String string2 = q.L0(new Regex("<[^>]+>").d(string, "")).toString();
                if (o.k0(string2, "【", false) || PolicyHtmlDisplayAdapter.MAIN_SECTION.c(string2) || PolicyHtmlDisplayAdapter.SUB_SECTION.c(string2) || string2.equals("导言") || o.k0(string2, "版本发布", false)) {
                    string = a0.a.k("<b>", string, "</b>");
                } else if (z && !ref$BooleanRef.f10073a && q.t0(str3) && string2.length() <= 16 && !q.l0(string2, "。", false) && !PolicyHtmlDisplayAdapter.NUMBERED_LIST_ITEM.a(string2)) {
                    ref$BooleanRef.f10073a = true;
                    string = a0.a.k("<b>", string, "</b>");
                }
                return "<p" + str3 + '>' + string + "</p>";
            }
        });
    }

    private final String extractBodyContent(String str) {
        String str2;
        i iVarB = HTML_BODY.b(str, 0);
        return (iVarB == null || (str2 = (String) ((i.a) iVarB.a()).get(1)) == null) ? str : str2;
    }

    private final String extractDisplayContent(String str) {
        return HTML_BODY.a(str) ? extractBodyContent(str) : str;
    }

    public static final String extractTitle(String html) {
        String str;
        kotlin.jvm.internal.g.f(html, "html");
        if (!q.t0(html)) {
            i iVarB = TITLE_TAG.b(html, 0);
            String string = (iVarB == null || (str = (String) ((i.a) iVarB.a()).get(1)) == null) ? null : q.L0(str).toString();
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
        kotlin.jvm.internal.g.f(url, "url");
        if (!q.t0(url)) {
            try {
                String path = new URI(url).getPath();
                if (path != null) {
                    if (q.t0(path)) {
                        path = null;
                    }
                    if (path != null) {
                        String strH0 = q.H0(path, '/', path);
                        if (!q.t0(strH0)) {
                            int iV0 = q.v0(strH0, '.', 0, 6);
                            if (iV0 != -1) {
                                strH0 = strH0.substring(0, iV0);
                                kotlin.jvm.internal.g.e(strH0, "substring(...)");
                            }
                            if (!q.t0(strH0)) {
                                return strH0;
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
        kotlin.jvm.internal.g.f(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final int linkColor(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        return context.getColor(R.color.policy_sdk_html_link);
    }

    public static final String normalizeForTextView(String html) {
        kotlin.jvm.internal.g.f(html, "html");
        PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
        return new Regex("(?i)</h[1-6]>\\s*<p").d(new Regex("(?i)</p>\\s*<h[1-6]").d(new Regex("(?i)</p>\\s*<p").d(policyHtmlDisplayAdapter.emphasizeParagraphs(policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(html)), html), "</p><br/><p"), "</p><br/><h"), "</h1><br/><p");
    }

    public static final String normalizeVisibleText(CharSequence charSequence) {
        if (charSequence != null && !q.t0(charSequence)) {
            PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
            String strStripLinkTitleMarks = policyHtmlDisplayAdapter.stripLinkTitleMarks(policyHtmlDisplayAdapter.decodeHtmlText(charSequence.toString()));
            if (strStripLinkTitleMarks.length() > 0) {
                return strStripLinkTitleMarks;
            }
        }
        return null;
    }

    public static final String prepareHtml(String html, boolean z) {
        String strStripMetadataTagsForDisplay;
        kotlin.jvm.internal.g.f(html, "html");
        if (q.t0(html)) {
            return html;
        }
        if (shouldNormalizeForTextView(html)) {
            strStripMetadataTagsForDisplay = normalizeForTextView(html);
        } else {
            PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
            strStripMetadataTagsForDisplay = policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(html));
        }
        if (!z) {
            return strStripMetadataTagsForDisplay;
        }
        return LIGHT_TABLE_BORDER.d(BG_COLOR_ATTR.d(FONT_COLOR_ATTR.d(INLINE_BG_COLOR_STYLE.d(INLINE_COLOR_STYLE.d(strStripMetadataTagsForDisplay, ""), ""), ""), ""), "#33FFFFFF");
    }

    public static final String resolveDisplayTitle(String str, String str2) {
        if (str != null) {
            if (q.t0(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        if (str2 == null || q.t0(str2)) {
            return null;
        }
        return str2;
    }

    public static final String resolveNavigationTitle(CharSequence charSequence, String url) {
        kotlin.jvm.internal.g.f(url, "url");
        String strNormalizeVisibleText = normalizeVisibleText(charSequence);
        return strNormalizeVisibleText == null ? fallbackTitleFromUrl(url) : strNormalizeVisibleText;
    }

    public static final boolean shouldNormalizeForTextView(String html) {
        kotlin.jvm.internal.g.f(html, "html");
        if (STYLE_BLOCK.a(html)) {
            return !RICH_HTML_MARKUP.a(html);
        }
        return false;
    }

    private final String stripLinkTitleMarks(String str) {
        return q.L0(o.i0(o.i0(o.i0(o.i0(o.i0(o.i0(o.i0(o.i0(str, "《", ""), "》", ""), "\"", ""), "“", ""), "”", ""), "'", ""), "‘", ""), "’", "")).toString();
    }

    private final String stripMetadataTagsForDisplay(String str) {
        return q.L0(new Regex("(?i)</?body[^>]*>").d(new Regex("(?i)</?head[^>]*>").d(new Regex("(?i)</?html[^>]*>").d(new Regex("(?i)<meta[^>]*/?>").d(TITLE_TAG.d(SCRIPT_BLOCK.d(STYLE_BLOCK.d(DOCTYPE.d(str, ""), ""), ""), ""), ""), ""), ""), "")).toString();
    }

    public static final int textColor(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        return context.getColor(R.color.policy_sdk_html_text);
    }

    public static final int viewerBackgroundColor(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        return context.getColor(R.color.policy_sdk_html_viewer_bg);
    }
}
