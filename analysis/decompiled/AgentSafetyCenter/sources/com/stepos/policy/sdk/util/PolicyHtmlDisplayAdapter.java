package com.stepos.policy.sdk.util;

import android.content.Context;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.policy.sdk.R;
import h5.t;
import hc.f;
import hc.g;
import hc.h;
import hc.o;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import yb.l;
import yb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyHtmlDisplayAdapter {
    public static final PolicyHtmlDisplayAdapter INSTANCE = new PolicyHtmlDisplayAdapter();
    private static final g INLINE_COLOR_STYLE = new g("(?i)color\\s*:\\s*[^;\"']+;?");
    private static final g INLINE_BG_COLOR_STYLE = new g("(?i)background-color\\s*:\\s*[^;\"']+;?");
    private static final g FONT_COLOR_ATTR = new g("(?i)\\s+color\\s*=\\s*[\"'][^\"']*[\"']");
    private static final g BG_COLOR_ATTR = new g("(?i)\\s+bgcolor\\s*=\\s*[\"'][^\"']*[\"']");
    private static final g LIGHT_TABLE_BORDER = new g("(?i)#d9d9d9");
    private static final g STYLE_BLOCK = new g("(?is)<style[^>]*>.*?</style>");
    private static final g SCRIPT_BLOCK = new g("(?is)<script[^>]*>.*?</script>");
    private static final g DOCTYPE = new g("(?i)<!doctype[^>]*>");
    private static final g HTML_BODY = new g("(?is)<body[^>]*>(.*)</body>");
    private static final g PARAGRAPH_BLOCK = new g("(?is)<p([^>]*)>(.*?)</p>");
    private static final g MAIN_SECTION = new g("^[一二三四五六七八九十百]+、.{1,24}$");
    private static final g SUB_SECTION = new g("^（[一二三四五六七八九十]+）.{1,40}：$");
    private static final g NUMBERED_LIST_ITEM = new g("^（\\d+）");
    private static final g RICH_HTML_MARKUP = new g("(?i)<table\\b|<h[1-6]\\b|<b\\b");
    private static final g TITLE_TAG = new g("(?is)<title[^>]*>(.*?)</title>");
    private static final g HTML_TAG = new g("<[^>]+>");
    private static final g WHITESPACE = new g("\\s+");

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter$emphasizeParagraphs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends l implements xb.l {
        final /* synthetic */ boolean $plainParagraphPolicy;
        final /* synthetic */ q $titleApplied;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, q qVar) {
            super(1);
            this.$plainParagraphPolicy = z10;
            this.$titleApplied = qVar;
        }

        @Override // xb.l
        public final CharSequence invoke(hc.d dVar) {
            dVar.getClass();
            f fVar = (f) dVar;
            String str = (String) ((hc.e) fVar.a()).get(1);
            String string = h.w0((String) ((hc.e) fVar.a()).get(2)).toString();
            if (string.length() == 0 || h.X(string, "<b", true)) {
                String strGroup = fVar.f5461a.group();
                strGroup.getClass();
                return strGroup;
            }
            Pattern patternCompile = Pattern.compile("<[^>]+>");
            patternCompile.getClass();
            String strReplaceAll = patternCompile.matcher(string).replaceAll("");
            strReplaceAll.getClass();
            String string2 = h.w0(strReplaceAll).toString();
            if (o.U(string2, "【", false) || PolicyHtmlDisplayAdapter.MAIN_SECTION.c(string2) || PolicyHtmlDisplayAdapter.SUB_SECTION.c(string2) || string2.equals("导言") || o.U(string2, "版本发布", false)) {
                string = k0.a.C("<b>", string, "</b>");
            } else if (this.$plainParagraphPolicy && !this.$titleApplied.f16094c && h.g0(str) && string2.length() <= 16 && !h.X(string2, "。", false) && !PolicyHtmlDisplayAdapter.NUMBERED_LIST_ITEM.a(string2)) {
                this.$titleApplied.f16094c = true;
                string = k0.a.C("<b>", string, "</b>");
            }
            return "<p" + str + '>' + string + "</p>";
        }
    }

    private PolicyHtmlDisplayAdapter() {
    }

    public static final void clearColorSpans(Spannable spannable) {
        spannable.getClass();
        Object[] spans = spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
        spans.getClass();
        for (Object obj : spans) {
            spannable.removeSpan((ForegroundColorSpan) obj);
        }
        Object[] spans2 = spannable.getSpans(0, spannable.length(), BackgroundColorSpan.class);
        spans2.getClass();
        for (Object obj2 : spans2) {
            spannable.removeSpan((BackgroundColorSpan) obj2);
        }
    }

    private final String decodeHtmlText(String str) {
        return h.w0(WHITESPACE.d(o.S(o.S(o.S(o.S(o.S(o.S(HTML_TAG.d(str, ""), "&nbsp;", " "), "&amp;", "&"), "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&#39;", "'"), " ")).toString();
    }

    private final String emphasizeParagraphs(String str, String str2) {
        boolean z10 = STYLE_BLOCK.a(str2) || !RICH_HTML_MARKUP.a(str2);
        q qVar = new q();
        g gVar = PARAGRAPH_BLOCK;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(z10, qVar);
        gVar.getClass();
        str.getClass();
        f fVarB = g.b(gVar, str);
        if (fVarB == null) {
            return str.toString();
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i = 0;
        do {
            Matcher matcher = fVarB.f5461a;
            sb2.append((CharSequence) str, i, p5.f.O(matcher.start(), matcher.end()).f3758c);
            sb2.append((CharSequence) anonymousClass1.invoke((Object) fVarB));
            i = p5.f.O(matcher.start(), matcher.end()).f3759f + 1;
            CharSequence charSequence = fVarB.f5462b;
            int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
            if (iEnd <= charSequence.length()) {
                Matcher matcher2 = matcher.pattern().matcher(charSequence);
                matcher2.getClass();
                fVarB = t.h(matcher2, iEnd, charSequence);
            } else {
                fVarB = null;
            }
            if (i >= length) {
                break;
            }
        } while (fVarB != null);
        if (i < length) {
            sb2.append((CharSequence) str, i, length);
        }
        return sb2.toString();
    }

    private final String extractBodyContent(String str) {
        String str2;
        f fVarB = g.b(HTML_BODY, str);
        return (fVarB == null || (str2 = (String) ((hc.e) fVarB.a()).get(1)) == null) ? str : str2;
    }

    private final String extractDisplayContent(String str) {
        return HTML_BODY.a(str) ? extractBodyContent(str) : str;
    }

    public static final String extractTitle(String str) {
        String str2;
        str.getClass();
        if (!h.g0(str)) {
            f fVarB = g.b(TITLE_TAG, str);
            String string = (fVarB == null || (str2 = (String) ((hc.e) fVarB.a()).get(1)) == null) ? null : h.w0(str2).toString();
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

    public static final String fallbackTitleFromUrl(String str) {
        str.getClass();
        if (!h.g0(str)) {
            try {
                String path = new URI(str).getPath();
                if (path != null) {
                    if (h.g0(path)) {
                        path = null;
                    }
                    if (path != null) {
                        String strR0 = h.r0(path, JsonPointer.SEPARATOR, path);
                        if (!h.g0(strR0)) {
                            int iH0 = h.h0(strR0, '.', 0, 6);
                            if (iH0 != -1) {
                                strR0 = strR0.substring(0, iH0);
                            }
                            if (!h.g0(strR0)) {
                                return strR0;
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
        context.getClass();
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final int linkColor(Context context) {
        context.getClass();
        return context.getColor(R.color.policy_sdk_html_link);
    }

    public static final String normalizeForTextView(String str) {
        str.getClass();
        PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
        String strEmphasizeParagraphs = policyHtmlDisplayAdapter.emphasizeParagraphs(policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(str)), str);
        Pattern patternCompile = Pattern.compile("(?i)</p>\\s*<p");
        patternCompile.getClass();
        strEmphasizeParagraphs.getClass();
        String strReplaceAll = patternCompile.matcher(strEmphasizeParagraphs).replaceAll("</p><br/><p");
        strReplaceAll.getClass();
        Pattern patternCompile2 = Pattern.compile("(?i)</p>\\s*<h[1-6]");
        patternCompile2.getClass();
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("</p><br/><h");
        strReplaceAll2.getClass();
        Pattern patternCompile3 = Pattern.compile("(?i)</h[1-6]>\\s*<p");
        patternCompile3.getClass();
        String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll("</h1><br/><p");
        strReplaceAll3.getClass();
        return strReplaceAll3;
    }

    public static final String normalizeVisibleText(CharSequence charSequence) {
        if (charSequence != null && !h.g0(charSequence)) {
            PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
            String strStripLinkTitleMarks = policyHtmlDisplayAdapter.stripLinkTitleMarks(policyHtmlDisplayAdapter.decodeHtmlText(charSequence.toString()));
            if (strStripLinkTitleMarks.length() > 0) {
                return strStripLinkTitleMarks;
            }
        }
        return null;
    }

    public static final String prepareHtml(String str, boolean z10) {
        String strStripMetadataTagsForDisplay;
        str.getClass();
        if (h.g0(str)) {
            return str;
        }
        if (shouldNormalizeForTextView(str)) {
            strStripMetadataTagsForDisplay = normalizeForTextView(str);
        } else {
            PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
            strStripMetadataTagsForDisplay = policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(str));
        }
        if (!z10) {
            return strStripMetadataTagsForDisplay;
        }
        return LIGHT_TABLE_BORDER.d(BG_COLOR_ATTR.d(FONT_COLOR_ATTR.d(INLINE_BG_COLOR_STYLE.d(INLINE_COLOR_STYLE.d(strStripMetadataTagsForDisplay, ""), ""), ""), ""), "#33FFFFFF");
    }

    public static final String resolveDisplayTitle(String str, String str2) {
        if (str != null) {
            if (h.g0(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        if (str2 == null || h.g0(str2)) {
            return null;
        }
        return str2;
    }

    public static final String resolveNavigationTitle(CharSequence charSequence, String str) {
        str.getClass();
        String strNormalizeVisibleText = normalizeVisibleText(charSequence);
        return strNormalizeVisibleText == null ? fallbackTitleFromUrl(str) : strNormalizeVisibleText;
    }

    public static final boolean shouldNormalizeForTextView(String str) {
        str.getClass();
        if (STYLE_BLOCK.a(str)) {
            return !RICH_HTML_MARKUP.a(str);
        }
        return false;
    }

    private final String stripLinkTitleMarks(String str) {
        return h.w0(o.S(o.S(str, "《", ""), "》", "")).toString();
    }

    private final String stripMetadataTagsForDisplay(String str) {
        String strD = TITLE_TAG.d(SCRIPT_BLOCK.d(STYLE_BLOCK.d(DOCTYPE.d(str, ""), ""), ""), "");
        Pattern patternCompile = Pattern.compile("(?i)<meta[^>]*/?>");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strD).replaceAll("");
        strReplaceAll.getClass();
        Pattern patternCompile2 = Pattern.compile("(?i)</?html[^>]*>");
        patternCompile2.getClass();
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("");
        strReplaceAll2.getClass();
        Pattern patternCompile3 = Pattern.compile("(?i)</?head[^>]*>");
        patternCompile3.getClass();
        String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll("");
        strReplaceAll3.getClass();
        Pattern patternCompile4 = Pattern.compile("(?i)</?body[^>]*>");
        patternCompile4.getClass();
        String strReplaceAll4 = patternCompile4.matcher(strReplaceAll3).replaceAll("");
        strReplaceAll4.getClass();
        return h.w0(strReplaceAll4).toString();
    }

    public static final int textColor(Context context) {
        context.getClass();
        return context.getColor(R.color.policy_sdk_html_text);
    }

    public static final int viewerBackgroundColor(Context context) {
        context.getClass();
        return context.getColor(R.color.policy_sdk_html_viewer_bg);
    }
}
