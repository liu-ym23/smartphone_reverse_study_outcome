package com.stepos.policy.sdk.util;

import android.content.Context;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.stepos.policy.sdk.bean.CloudPolicyUrlInfo;
import gc.n;
import gc.o;
import gc.q;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyHtmlLinkHandler {
    public static final String CLOUD_POLICY_URL_PREFIX = "https://static.stepaos.com/cloudPolicy";
    public static final PolicyHtmlLinkHandler INSTANCE = new PolicyHtmlLinkHandler();
    private static final String[] CLOUD_POLICY_URL_PREFIXES = {"https://static.stepaos.com/cloudpolicy", "http://static.stepaos.com/cloudpolicy", "https://static.stepos.com/cloudpolicy", "http://static.stepos.com/cloudpolicy"};

    private PolicyHtmlLinkHandler() {
    }

    public static final String extractCategoryFromCloudPolicyUrl(String url) {
        kotlin.jvm.internal.g.f(url, "url");
        return resolveCategoryForCloudPolicyUrl(url);
    }

    private final String extractCloudPolicyFileName(String str) {
        try {
            String path = new URI(q.L0(str).toString()).getPath();
            if (path != null) {
                String strH0 = q.H0(path, '/', path);
                if (!q.t0(strH0)) {
                    return strH0;
                }
            }
            return null;
        } catch (Exception e10) {
            PolicySdkLogUtils.Companion.e("PolicyHtmlLinkHandler", "extractCloudPolicyFileName failed: " + e10.getMessage());
            return null;
        }
    }

    public static final boolean isCloudPolicyUrl(String url) {
        kotlin.jvm.internal.g.f(url, "url");
        String lowerCase = q.L0(url).toString().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        for (String str : CLOUD_POLICY_URL_PREFIXES) {
            if (o.k0(lowerCase, str, false)) {
                return true;
            }
        }
        return false;
    }

    public static final CloudPolicyUrlInfo parseCloudPolicyUrl(String url) {
        String strExtractCloudPolicyFileName;
        kotlin.jvm.internal.g.f(url, "url");
        if (isCloudPolicyUrl(url) && (strExtractCloudPolicyFileName = INSTANCE.extractCloudPolicyFileName(url)) != null && o.e0(strExtractCloudPolicyFileName, ".html", true)) {
            String strSubstring = strExtractCloudPolicyFileName.substring(0, strExtractCloudPolicyFileName.length() - 5);
            kotlin.jvm.internal.g.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            List listE0 = q.E0(strSubstring, new char[]{'_'});
            if (listE0.size() >= 2) {
                if (listE0.size() >= 3) {
                    Long lD0 = n.d0((String) listE0.get(listE0.size() - 2));
                    Object objA0 = kotlin.collections.a.A0(listE0);
                    if (q.t0((String) objA0)) {
                        objA0 = null;
                    }
                    String str = (String) objA0;
                    if (lD0 != null && str != null) {
                        String strZ0 = kotlin.collections.a.z0(kotlin.collections.a.q0(2, listE0), "_", null, null, null, 62);
                        if (!q.t0(strZ0)) {
                            return new CloudPolicyUrlInfo(strZ0, lD0.longValue(), str);
                        }
                    }
                }
                Long lD02 = n.d0((String) kotlin.collections.a.A0(listE0));
                if (lD02 != null) {
                    long jLongValue = lD02.longValue();
                    String strZ02 = kotlin.collections.a.z0(kotlin.collections.a.q0(1, listE0), "_", null, null, null, 62);
                    if (!q.t0(strZ02)) {
                        return new CloudPolicyUrlInfo(strZ02, jLongValue, null);
                    }
                }
            }
        }
        return null;
    }

    public static final String resolveCategoryForCloudPolicyUrl(String url) {
        kotlin.jvm.internal.g.f(url, "url");
        CloudPolicyUrlInfo cloudPolicyUrl = parseCloudPolicyUrl(url);
        if (cloudPolicyUrl == null) {
            return null;
        }
        String category = cloudPolicyUrl.getCategory();
        if (category != null) {
            String str = q.t0(category) ? null : category;
            if (str != null) {
                return str;
            }
        }
        return PolicyCloudPolicyIndex.getCategory(cloudPolicyUrl.getPolicyUid());
    }

    public static final InPageCloudPolicyTarget resolveInPageCloudPolicyTarget(String url, l<? super String, Boolean> hasLocalCategory, boolean z) {
        kotlin.jvm.internal.g.f(url, "url");
        kotlin.jvm.internal.g.f(hasLocalCategory, "hasLocalCategory");
        return z ? InPageCloudPolicyTarget.IN_APP_CDN : resolveLocalCategoryForInPageLink(url, hasLocalCategory) != null ? InPageCloudPolicyTarget.LOCAL : InPageCloudPolicyTarget.BROWSER;
    }

    public static final String resolveLocalCategoryForInPageLink(String url, l<? super String, Boolean> hasLocalCategory) {
        String category;
        kotlin.jvm.internal.g.f(url, "url");
        kotlin.jvm.internal.g.f(hasLocalCategory, "hasLocalCategory");
        CloudPolicyUrlInfo cloudPolicyUrl = parseCloudPolicyUrl(url);
        if (cloudPolicyUrl == null || (category = PolicyCloudPolicyIndex.getCategory(cloudPolicyUrl.getPolicyUid())) == null || !hasLocalCategory.invoke(category).booleanValue()) {
            return null;
        }
        return category;
    }

    public static final Pair<String, String> resolvePolicyLinkNavigation(String rawUrl, CharSequence charSequence, String str) {
        kotlin.jvm.internal.g.f(rawUrl, "rawUrl");
        if (o.k0(rawUrl, "#", false)) {
            return null;
        }
        String strResolveUrl = resolveUrl(rawUrl, str);
        if (shouldOpenInApp(strResolveUrl)) {
            return new Pair<>(strResolveUrl, PolicyHtmlDisplayAdapter.resolveNavigationTitle(charSequence, strResolveUrl));
        }
        return null;
    }

    public static final String resolveUrl(String link, String str) {
        kotlin.jvm.internal.g.f(link, "link");
        if (!q.t0(link) && !o.k0(link, "#", false) && !q.l0(link, "://", false) && !o.k0(link, "//", false) && str != null) {
            if (q.t0(str)) {
                str = null;
            }
            if (str != null) {
                try {
                    String string = new URI(str).resolve(link).toString();
                    kotlin.jvm.internal.g.e(string, "{\n            URI(base).…ink).toString()\n        }");
                    return string;
                } catch (Exception e10) {
                    PolicySdkLogUtils.Companion.e("PolicyHtmlLinkHandler", "resolveUrl failed: " + e10.getMessage());
                }
            }
        }
        return link;
    }

    public static final boolean shouldOpenInApp(String url) {
        kotlin.jvm.internal.g.f(url, "url");
        if (q.t0(url) || o.k0(url, "#", false)) {
            return false;
        }
        return isCloudPolicyUrl(url);
    }

    public final void bindHtmlLinks(TextView textView, String html, String str, boolean z, int i10, p<? super String, ? super String, lb.n> onOpenPolicy, l<? super String, lb.n> onOpenExternal) {
        kotlin.jvm.internal.g.f(textView, "textView");
        kotlin.jvm.internal.g.f(html, "html");
        kotlin.jvm.internal.g.f(onOpenPolicy, "onOpenPolicy");
        kotlin.jvm.internal.g.f(onOpenExternal, "onOpenExternal");
        Spanned spannedFromHtml = Html.fromHtml(html, 63);
        kotlin.jvm.internal.g.e(spannedFromHtml, "fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)");
        Spannable spannableString = spannedFromHtml instanceof Spannable ? (Spannable) spannedFromHtml : new SpannableString(spannedFromHtml);
        if (z) {
            PolicyHtmlDisplayAdapter.clearColorSpans(spannableString);
        }
        replaceUrlSpans$policysdk_release(spannableString, str, i10, onOpenPolicy, onOpenExternal);
        Context context = textView.getContext();
        kotlin.jvm.internal.g.e(context, "textView.context");
        textView.setTextColor(PolicyHtmlDisplayAdapter.textColor(context));
        textView.setText(spannableString);
        textView.setMovementMethod(PolicyLinkMovementMethod.Companion.getInstance());
        textView.setFocusable(false);
        textView.setFocusableInTouchMode(false);
    }

    public final void replaceUrlSpans$policysdk_release(Spannable spannable, final String str, final int i10, p<? super String, ? super String, lb.n> pVar, l<? super String, lb.n> lVar) {
        kotlin.jvm.internal.g.f(spannable, "spannable");
        final p<? super String, ? super String, lb.n> onOpenPolicy = pVar;
        kotlin.jvm.internal.g.f(onOpenPolicy, "onOpenPolicy");
        final l<? super String, lb.n> onOpenExternal = lVar;
        kotlin.jvm.internal.g.f(onOpenExternal, "onOpenExternal");
        URLSpan[] urlSpans = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        kotlin.jvm.internal.g.e(urlSpans, "urlSpans");
        int length = urlSpans.length;
        int i11 = 0;
        while (i11 < length) {
            URLSpan uRLSpan = urlSpans[i11];
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            int spanFlags = spannable.getSpanFlags(uRLSpan);
            final String url = uRLSpan.getURL();
            final CharSequence charSequenceSubSequence = spannable.subSequence(spanStart, spanEnd);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicyHtmlLinkHandler$replaceUrlSpans$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    lb.n nVar;
                    kotlin.jvm.internal.g.f(widget, "widget");
                    String rawUrl = url;
                    kotlin.jvm.internal.g.e(rawUrl, "rawUrl");
                    Pair<String, String> pairResolvePolicyLinkNavigation = PolicyHtmlLinkHandler.resolvePolicyLinkNavigation(rawUrl, charSequenceSubSequence, str);
                    if (pairResolvePolicyLinkNavigation != null) {
                        onOpenPolicy.invoke(pairResolvePolicyLinkNavigation.f9985a, pairResolvePolicyLinkNavigation.f9986b);
                        nVar = lb.n.f10413a;
                    } else {
                        nVar = null;
                    }
                    if (nVar == null) {
                        String rawUrl2 = url;
                        String str2 = str;
                        l<String, lb.n> lVar2 = onOpenExternal;
                        kotlin.jvm.internal.g.e(rawUrl2, "rawUrl");
                        lVar2.invoke(PolicyHtmlLinkHandler.resolveUrl(rawUrl2, str2));
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    kotlin.jvm.internal.g.f(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setColor(i10);
                    ds.setUnderlineText(true);
                }
            }, spanStart, spanEnd, spanFlags);
            i11++;
            onOpenPolicy = pVar;
            onOpenExternal = lVar;
        }
    }
}
