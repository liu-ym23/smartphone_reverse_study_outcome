package com.stepos.policy.sdk.util;

import android.content.Context;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.stepos.policy.sdk.n;
import i4.InterfaceC0772l;
import j4.k;
import j4.l;
import j4.s;
import java.net.URI;
import java.util.List;
import org.libpag.BuildConfig;
import r4.C1028k;
import r4.C1031n;
import r4.InterfaceC1025h;

/* loaded from: classes.dex */
public final class PolicyHtmlDisplayAdapter {
    public static final PolicyHtmlDisplayAdapter INSTANCE = new PolicyHtmlDisplayAdapter();
    private static final C1028k INLINE_COLOR_STYLE = new C1028k("(?i)color\\s*:\\s*[^;\"']+;?");
    private static final C1028k INLINE_BG_COLOR_STYLE = new C1028k("(?i)background-color\\s*:\\s*[^;\"']+;?");
    private static final C1028k FONT_COLOR_ATTR = new C1028k("(?i)\\s+color\\s*=\\s*[\"'][^\"']*[\"']");
    private static final C1028k BG_COLOR_ATTR = new C1028k("(?i)\\s+bgcolor\\s*=\\s*[\"'][^\"']*[\"']");
    private static final C1028k LIGHT_TABLE_BORDER = new C1028k("(?i)#d9d9d9");
    private static final C1028k STYLE_BLOCK = new C1028k("(?is)<style[^>]*>.*?</style>");
    private static final C1028k SCRIPT_BLOCK = new C1028k("(?is)<script[^>]*>.*?</script>");
    private static final C1028k DOCTYPE = new C1028k("(?i)<!doctype[^>]*>");
    private static final C1028k HTML_BODY = new C1028k("(?is)<body[^>]*>(.*)</body>");
    private static final C1028k PARAGRAPH_BLOCK = new C1028k("(?is)<p([^>]*)>(.*?)</p>");
    private static final C1028k MAIN_SECTION = new C1028k("^[一二三四五六七八九十百]+、.{1,24}$");
    private static final C1028k SUB_SECTION = new C1028k("^（[一二三四五六七八九十]+）.{1,40}：$");
    private static final C1028k NUMBERED_LIST_ITEM = new C1028k("^（\\d+）");
    private static final C1028k RICH_HTML_MARKUP = new C1028k("(?i)<table\\b|<h[1-6]\\b|<b\\b");
    private static final C1028k TITLE_TAG = new C1028k("(?is)<title[^>]*>(.*?)</title>");
    private static final C1028k HTML_TAG = new C1028k("<[^>]+>");
    private static final C1028k WHITESPACE = new C1028k("\\s+");

    /* renamed from: com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter$emphasizeParagraphs$1, reason: invalid class name */
    static final class AnonymousClass1 extends l implements InterfaceC0772l<InterfaceC1025h, CharSequence> {
        final /* synthetic */ boolean $plainParagraphPolicy;
        final /* synthetic */ s $titleApplied;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z5, s sVar) {
            super(1);
            this.$plainParagraphPolicy = z5;
            this.$titleApplied = sVar;
        }

        @Override // i4.InterfaceC0772l
        public final CharSequence invoke(InterfaceC1025h interfaceC1025h) {
            k.g(interfaceC1025h, "match");
            String str = interfaceC1025h.a().get(1);
            String string = C1031n.i0(interfaceC1025h.a().get(2)).toString();
            if (string.length() == 0 || C1031n.t(string, "<b", true)) {
                return interfaceC1025h.getValue();
            }
            String string2 = C1031n.i0(new C1028k("<[^>]+>").f(string, BuildConfig.FLAVOR)).toString();
            if (C1031n.q(string2, "【", false, 2, null)) {
                string = "<b>" + string + "</b>";
            } else if (PolicyHtmlDisplayAdapter.MAIN_SECTION.d(string2)) {
                string = "<b>" + string + "</b>";
            } else if (PolicyHtmlDisplayAdapter.SUB_SECTION.d(string2)) {
                string = "<b>" + string + "</b>";
            } else if (k.b(string2, "导言") || C1031n.q(string2, "版本发布", false, 2, null)) {
                string = "<b>" + string + "</b>";
            } else if (this.$plainParagraphPolicy && !this.$titleApplied.f17833a && C1031n.E(str) && string2.length() <= 16 && !C1031n.u(string2, "。", false, 2, null) && !PolicyHtmlDisplayAdapter.NUMBERED_LIST_ITEM.a(string2)) {
                this.$titleApplied.f17833a = true;
                string = "<b>" + string + "</b>";
            }
            return "<p" + str + '>' + string + "</p>";
        }
    }

    private PolicyHtmlDisplayAdapter() {
    }

    public static final void clearColorSpans(Spannable spannable) {
        k.g(spannable, "spannable");
        Object[] spans = spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
        k.f(spans, "spannable.getSpans(0, sp…undColorSpan::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan((ForegroundColorSpan) obj);
        }
        Object[] spans2 = spannable.getSpans(0, spannable.length(), BackgroundColorSpan.class);
        k.f(spans2, "spannable.getSpans(0, sp…undColorSpan::class.java)");
        for (Object obj2 : spans2) {
            spannable.removeSpan((BackgroundColorSpan) obj2);
        }
    }

    private final String decodeHtmlText(String str) {
        return C1031n.i0(WHITESPACE.f(C1031n.o(C1031n.o(C1031n.o(C1031n.o(C1031n.o(C1031n.o(HTML_TAG.f(str, BuildConfig.FLAVOR), "&nbsp;", " ", false, 4, null), "&amp;", "&", false, 4, null), "&lt;", "<", false, 4, null), "&gt;", ">", false, 4, null), "&quot;", "\"", false, 4, null), "&#39;", "'", false, 4, null), " ")).toString();
    }

    private final String emphasizeParagraphs(String str, String str2) {
        return PARAGRAPH_BLOCK.e(str, new AnonymousClass1(STYLE_BLOCK.a(str2) || !RICH_HTML_MARKUP.a(str2), new s()));
    }

    private final String extractBodyContent(String str) {
        List<String> listA;
        String str2;
        InterfaceC1025h interfaceC1025hC = C1028k.c(HTML_BODY, str, 0, 2, null);
        return (interfaceC1025hC == null || (listA = interfaceC1025hC.a()) == null || (str2 = listA.get(1)) == null) ? str : str2;
    }

    private final String extractDisplayContent(String str) {
        return HTML_BODY.a(str) ? extractBodyContent(str) : str;
    }

    public static final String extractTitle(String str) {
        List<String> listA;
        String str2;
        k.g(str, "html");
        if (C1031n.E(str)) {
            return null;
        }
        InterfaceC1025h interfaceC1025hC = C1028k.c(TITLE_TAG, str, 0, 2, null);
        String string = (interfaceC1025hC == null || (listA = interfaceC1025hC.a()) == null || (str2 = listA.get(1)) == null) ? null : C1031n.i0(str2).toString();
        if (string == null) {
            string = BuildConfig.FLAVOR;
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

    public static final String fallbackTitleFromUrl(String str) {
        k.g(str, "url");
        if (C1031n.E(str)) {
            return null;
        }
        try {
            String path = new URI(str).getPath();
            if (path != null) {
                if (C1031n.E(path)) {
                    path = null;
                }
                if (path != null) {
                    String strF0 = C1031n.f0(path, '/', null, 2, null);
                    if (C1031n.E(strF0)) {
                        return null;
                    }
                    String strH0 = C1031n.h0(strF0, '.', null, 2, null);
                    if (!C1031n.E(strH0)) {
                        return strH0;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final boolean isDarkMode(Context context) {
        k.g(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final int linkColor(Context context) {
        k.g(context, "context");
        return androidx.core.content.a.c(context, n.f15791a);
    }

    public static final String normalizeForTextView(String str) {
        k.g(str, "html");
        PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
        return new C1028k("(?i)</h[1-6]>\\s*<p").f(new C1028k("(?i)</p>\\s*<h[1-6]").f(new C1028k("(?i)</p>\\s*<p").f(policyHtmlDisplayAdapter.emphasizeParagraphs(policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(str)), str), "</p><br/><p"), "</p><br/><h"), "</h1><br/><p");
    }

    public static final String normalizeVisibleText(CharSequence charSequence) {
        if (charSequence != null && !C1031n.E(charSequence)) {
            PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
            String strStripLinkTitleMarks = policyHtmlDisplayAdapter.stripLinkTitleMarks(policyHtmlDisplayAdapter.decodeHtmlText(charSequence.toString()));
            if (strStripLinkTitleMarks.length() > 0) {
                return strStripLinkTitleMarks;
            }
        }
        return null;
    }

    public static final String prepareHtml(String str, boolean z5) {
        String strStripMetadataTagsForDisplay;
        k.g(str, "html");
        if (C1031n.E(str)) {
            return str;
        }
        if (shouldNormalizeForTextView(str)) {
            strStripMetadataTagsForDisplay = normalizeForTextView(str);
        } else {
            PolicyHtmlDisplayAdapter policyHtmlDisplayAdapter = INSTANCE;
            strStripMetadataTagsForDisplay = policyHtmlDisplayAdapter.stripMetadataTagsForDisplay(policyHtmlDisplayAdapter.extractDisplayContent(str));
        }
        if (!z5) {
            return strStripMetadataTagsForDisplay;
        }
        return LIGHT_TABLE_BORDER.f(BG_COLOR_ATTR.f(FONT_COLOR_ATTR.f(INLINE_BG_COLOR_STYLE.f(INLINE_COLOR_STYLE.f(strStripMetadataTagsForDisplay, BuildConfig.FLAVOR), BuildConfig.FLAVOR), BuildConfig.FLAVOR), BuildConfig.FLAVOR), "#33FFFFFF");
    }

    public static final String resolveDisplayTitle(String str, String str2) {
        if (str != null) {
            if (C1031n.E(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        if (str2 == null || C1031n.E(str2)) {
            return null;
        }
        return str2;
    }

    public static final String resolveNavigationTitle(CharSequence charSequence, String str) {
        k.g(str, "url");
        String strNormalizeVisibleText = normalizeVisibleText(charSequence);
        return strNormalizeVisibleText == null ? fallbackTitleFromUrl(str) : strNormalizeVisibleText;
    }

    public static final boolean shouldNormalizeForTextView(String str) {
        k.g(str, "html");
        if (STYLE_BLOCK.a(str)) {
            return !RICH_HTML_MARKUP.a(str);
        }
        return false;
    }

    private final String stripLinkTitleMarks(String str) {
        return C1031n.i0(C1031n.o(C1031n.o(str, "《", BuildConfig.FLAVOR, false, 4, null), "》", BuildConfig.FLAVOR, false, 4, null)).toString();
    }

    private final String stripMetadataTagsForDisplay(String str) {
        return C1031n.i0(new C1028k("(?i)</?body[^>]*>").f(new C1028k("(?i)</?head[^>]*>").f(new C1028k("(?i)</?html[^>]*>").f(new C1028k("(?i)<meta[^>]*/?>").f(TITLE_TAG.f(SCRIPT_BLOCK.f(STYLE_BLOCK.f(DOCTYPE.f(str, BuildConfig.FLAVOR), BuildConfig.FLAVOR), BuildConfig.FLAVOR), BuildConfig.FLAVOR), BuildConfig.FLAVOR), BuildConfig.FLAVOR), BuildConfig.FLAVOR), BuildConfig.FLAVOR)).toString();
    }

    public static final int textColor(Context context) {
        k.g(context, "context");
        return androidx.core.content.a.c(context, n.f15792b);
    }

    public static final int viewerBackgroundColor(Context context) {
        k.g(context, "context");
        return androidx.core.content.a.c(context, n.f15793c);
    }
}
