package com.stepos.policy.sdk.util;

import C7.r;
import D7.v;
import S7.n;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.text.HtmlCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.policy.sdk.bean.CloudPolicyUrlInfo;
import j9.m;
import j9.t;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0019\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0018Ji\u0010&\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00102\b\b\u0001\u0010 \u001a\u00020\u001f2\u001a\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\"0!2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0$¢\u0006\u0004\b&\u0010'J[\u0010,\u001a\u00020\"2\u0006\u0010)\u001a\u00020(2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010 \u001a\u00020\u001f2\u001a\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\"0!2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0$H\u0000¢\u0006\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00100\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010.¨\u00061"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyHtmlLinkHandler;", "", AppAgent.CONSTRUCT, "()V", "", "rawUrl", "", "linkText", "baseUri", "Lkotlin/Pair;", "resolvePolicyLinkNavigation", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;)Lkotlin/Pair;", "link", "resolveUrl", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", BffConstant.Type.Url, "", "shouldOpenInApp", "(Ljava/lang/String;)Z", "isCloudPolicyUrl", "Lcom/stepos/policy/sdk/bean/CloudPolicyUrlInfo;", "parseCloudPolicyUrl", "(Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/CloudPolicyUrlInfo;", "resolveCategoryForCloudPolicyUrl", "(Ljava/lang/String;)Ljava/lang/String;", "extractCategoryFromCloudPolicyUrl", "extractCloudPolicyFileName", "Landroid/widget/TextView;", "textView", "html", "darkMode", "", "linkColor", "Lkotlin/Function2;", "LC7/r;", "onOpenPolicy", "Lkotlin/Function1;", "onOpenExternal", "bindHtmlLinks", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;ZILS7/n;LS7/k;)V", "Landroid/text/Spannable;", "spannable", "replaceUrlSpans$policysdk_release", "(Landroid/text/Spannable;Ljava/lang/String;ILS7/n;LS7/k;)V", "replaceUrlSpans", "CLOUD_POLICY_HTTPS_PREFIX", "Ljava/lang/String;", "CLOUD_POLICY_HTTP_PREFIX", "CLOUD_POLICY_URL_PREFIX", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyHtmlLinkHandler {
    private static final String CLOUD_POLICY_HTTPS_PREFIX = "https://static.stepos.com/cloudpolicy";
    private static final String CLOUD_POLICY_HTTP_PREFIX = "http://static.stepos.com/cloudpolicy";
    public static final String CLOUD_POLICY_URL_PREFIX = "https://static.stepos.com/cloudPolicy";
    public static final PolicyHtmlLinkHandler INSTANCE = new PolicyHtmlLinkHandler();

    private PolicyHtmlLinkHandler() {
    }

    @C7.c
    public static final String extractCategoryFromCloudPolicyUrl(String url) {
        k.f(url, "url");
        return resolveCategoryForCloudPolicyUrl(url);
    }

    private final String extractCloudPolicyFileName(String url) {
        try {
            String path = new URI(m.R0(url).toString()).getPath();
            if (path != null) {
                String strI0 = m.I0(JsonPointer.SEPARATOR, path, path);
                if (!m.s0(strI0)) {
                    return strI0;
                }
            }
            return null;
        } catch (Exception e) {
            PolicySdkLogUtils.INSTANCE.e("PolicyHtmlLinkHandler", "extractCloudPolicyFileName failed: " + e.getMessage());
            return null;
        }
    }

    public static final boolean isCloudPolicyUrl(String url) {
        k.f(url, "url");
        String lowerCase = m.R0(url).toString().toLowerCase(Locale.ROOT);
        k.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return t.e0(lowerCase, CLOUD_POLICY_HTTPS_PREFIX, false) || t.e0(lowerCase, CLOUD_POLICY_HTTP_PREFIX, false);
    }

    public static final CloudPolicyUrlInfo parseCloudPolicyUrl(String url) {
        String strExtractCloudPolicyFileName;
        k.f(url, "url");
        if (isCloudPolicyUrl(url) && (strExtractCloudPolicyFileName = INSTANCE.extractCloudPolicyFileName(url)) != null && t.W(strExtractCloudPolicyFileName, ".html", true)) {
            String strSubstring = strExtractCloudPolicyFileName.substring(0, strExtractCloudPolicyFileName.length() - 5);
            k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            List listE0 = m.E0(strSubstring, new char[]{'_'});
            if (listE0.size() >= 2) {
                if (listE0.size() >= 3) {
                    Long lG0 = t.g0((String) listE0.get(listE0.size() - 2));
                    Object objK0 = v.K0(listE0);
                    if (m.s0((String) objK0)) {
                        objK0 = null;
                    }
                    String str = (String) objK0;
                    if (lG0 != null && str != null) {
                        String strI0 = v.I0(v.x0(2, listE0), "_", null, null, null, 62);
                        if (!m.s0(strI0)) {
                            return new CloudPolicyUrlInfo(strI0, lG0.longValue(), str);
                        }
                    }
                }
                Long lG02 = t.g0((String) v.K0(listE0));
                if (lG02 != null) {
                    long jLongValue = lG02.longValue();
                    String strI02 = v.I0(v.x0(1, listE0), "_", null, null, null, 62);
                    if (!m.s0(strI02)) {
                        return new CloudPolicyUrlInfo(strI02, jLongValue, null);
                    }
                }
            }
        }
        return null;
    }

    public static final String resolveCategoryForCloudPolicyUrl(String url) {
        k.f(url, "url");
        CloudPolicyUrlInfo cloudPolicyUrl = parseCloudPolicyUrl(url);
        if (cloudPolicyUrl == null) {
            return null;
        }
        String category = cloudPolicyUrl.getCategory();
        if (category != null) {
            String str = m.s0(category) ? null : category;
            if (str != null) {
                return str;
            }
        }
        return PolicyCloudPolicyIndex.getCategory(cloudPolicyUrl.getPolicyUid());
    }

    public static final Pair<String, String> resolvePolicyLinkNavigation(String rawUrl, CharSequence linkText, String baseUri) {
        k.f(rawUrl, "rawUrl");
        if (t.e0(rawUrl, "#", false)) {
            return null;
        }
        String strResolveUrl = resolveUrl(rawUrl, baseUri);
        if (shouldOpenInApp(strResolveUrl)) {
            return new Pair<>(strResolveUrl, PolicyHtmlDisplayAdapter.resolveNavigationTitle(linkText, strResolveUrl));
        }
        return null;
    }

    public static final String resolveUrl(String link, String baseUri) {
        k.f(link, "link");
        if (!m.s0(link) && !t.e0(link, "#", false) && !m.h0(link, "://", false) && !t.e0(link, "//", false) && baseUri != null) {
            if (m.s0(baseUri)) {
                baseUri = null;
            }
            if (baseUri != null) {
                try {
                    String string = new URI(baseUri).resolve(link).toString();
                    k.e(string, "{\n            URI(base).…ink).toString()\n        }");
                    return string;
                } catch (Exception e) {
                    PolicySdkLogUtils.INSTANCE.e("PolicyHtmlLinkHandler", "resolveUrl failed: " + e.getMessage());
                }
            }
        }
        return link;
    }

    public static final boolean shouldOpenInApp(String url) {
        k.f(url, "url");
        if (m.s0(url) || t.e0(url, "#", false)) {
            return false;
        }
        return isCloudPolicyUrl(url);
    }

    public final void bindHtmlLinks(TextView textView, String html, String baseUri, boolean darkMode, @ColorInt int linkColor, n onOpenPolicy, S7.k onOpenExternal) {
        k.f(textView, "textView");
        k.f(html, "html");
        k.f(onOpenPolicy, "onOpenPolicy");
        k.f(onOpenExternal, "onOpenExternal");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(html, 63);
        k.e(spannedFromHtml, "fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)");
        Spannable spannableString = spannedFromHtml instanceof Spannable ? (Spannable) spannedFromHtml : new SpannableString(spannedFromHtml);
        if (darkMode) {
            PolicyHtmlDisplayAdapter.clearColorSpans(spannableString);
        }
        replaceUrlSpans$policysdk_release(spannableString, baseUri, linkColor, onOpenPolicy, onOpenExternal);
        Context context = textView.getContext();
        k.e(context, "textView.context");
        textView.setTextColor(PolicyHtmlDisplayAdapter.textColor(context));
        textView.setText(spannableString);
        textView.setMovementMethod(PolicyLinkMovementMethod.INSTANCE.getInstance());
        textView.setFocusable(false);
        textView.setFocusableInTouchMode(false);
    }

    public final void replaceUrlSpans$policysdk_release(Spannable spannable, final String baseUri, @ColorInt final int linkColor, n onOpenPolicy, S7.k onOpenExternal) {
        k.f(spannable, "spannable");
        final n onOpenPolicy2 = onOpenPolicy;
        k.f(onOpenPolicy2, "onOpenPolicy");
        final S7.k onOpenExternal2 = onOpenExternal;
        k.f(onOpenExternal2, "onOpenExternal");
        URLSpan[] urlSpans = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        k.e(urlSpans, "urlSpans");
        int length = urlSpans.length;
        int i = 0;
        while (i < length) {
            URLSpan uRLSpan = urlSpans[i];
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            int spanFlags = spannable.getSpanFlags(uRLSpan);
            final String url = uRLSpan.getURL();
            final CharSequence charSequenceSubSequence = spannable.subSequence(spanStart, spanEnd);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicyHtmlLinkHandler$replaceUrlSpans$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    r rVar;
                    k.f(widget, "widget");
                    String rawUrl = url;
                    k.e(rawUrl, "rawUrl");
                    Pair<String, String> pairResolvePolicyLinkNavigation = PolicyHtmlLinkHandler.resolvePolicyLinkNavigation(rawUrl, charSequenceSubSequence, baseUri);
                    if (pairResolvePolicyLinkNavigation != null) {
                        onOpenPolicy2.invoke((String) pairResolvePolicyLinkNavigation.f4886a, (String) pairResolvePolicyLinkNavigation.b);
                        rVar = r.f317a;
                    } else {
                        rVar = null;
                    }
                    if (rVar == null) {
                        String rawUrl2 = url;
                        String str = baseUri;
                        S7.k kVar = onOpenExternal2;
                        k.e(rawUrl2, "rawUrl");
                        kVar.invoke(PolicyHtmlLinkHandler.resolveUrl(rawUrl2, str));
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    k.f(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setColor(linkColor);
                    ds.setUnderlineText(true);
                }
            }, spanStart, spanEnd, spanFlags);
            i++;
            onOpenPolicy2 = onOpenPolicy;
            onOpenExternal2 = onOpenExternal;
        }
    }
}
