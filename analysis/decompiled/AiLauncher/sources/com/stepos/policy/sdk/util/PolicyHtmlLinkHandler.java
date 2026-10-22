package com.stepos.policy.sdk.util;

import La.C;
import La.D;
import La.H;
import Y8.t;
import Z8.F;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.policy.sdk.bean.CloudPolicyUrlInfo;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u00172\u0006\u0010\u001b\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010 J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010 Ji\u0010-\u001a\u00020*2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u00102\b\b\u0001\u0010(\u001a\u00020'2\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020*0)2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020*0\u0017¢\u0006\u0004\b-\u0010.J[\u00103\u001a\u00020*2\u0006\u00100\u001a\u00020/2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010(\u001a\u00020'2\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020*0)2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020*0\u0017H\u0000¢\u0006\u0004\b1\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0004048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyHtmlLinkHandler;", "", "<init>", "()V", "", "rawUrl", "", "linkText", "baseUri", "Lkotlin/Pair;", "resolvePolicyLinkNavigation", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;)Lkotlin/Pair;", "link", "resolveUrl", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "url", "", "shouldOpenInApp", "(Ljava/lang/String;)Z", "isCloudPolicyUrl", "Lcom/stepos/policy/sdk/bean/CloudPolicyUrlInfo;", "parseCloudPolicyUrl", "(Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/CloudPolicyUrlInfo;", "Lkotlin/Function1;", "hasLocalCategory", "resolveLocalCategoryForInPageLink", "(Ljava/lang/String;Lp9/l;)Ljava/lang/String;", "sdkCanUseNetwork", "Lcom/stepos/policy/sdk/util/InPageCloudPolicyTarget;", "resolveInPageCloudPolicyTarget", "(Ljava/lang/String;Lp9/l;Z)Lcom/stepos/policy/sdk/util/InPageCloudPolicyTarget;", "resolveCategoryForCloudPolicyUrl", "(Ljava/lang/String;)Ljava/lang/String;", "extractCategoryFromCloudPolicyUrl", "extractCloudPolicyFileName", "Landroid/widget/TextView;", "textView", "html", "darkMode", "", "linkColor", "Lkotlin/Function2;", "LY8/t;", "onOpenPolicy", "onOpenExternal", "bindHtmlLinks", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;ZILp9/p;Lp9/l;)V", "Landroid/text/Spannable;", "spannable", "replaceUrlSpans$policysdk_release", "(Landroid/text/Spannable;Ljava/lang/String;ILp9/p;Lp9/l;)V", "replaceUrlSpans", "", "CLOUD_POLICY_URL_PREFIXES", "[Ljava/lang/String;", "CLOUD_POLICY_URL_PREFIX", "Ljava/lang/String;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyHtmlLinkHandler {
    public static final String CLOUD_POLICY_URL_PREFIX = "https://static.stepaos.com/cloudPolicy";
    public static final PolicyHtmlLinkHandler INSTANCE = new PolicyHtmlLinkHandler();
    private static final String[] CLOUD_POLICY_URL_PREFIXES = {"https://static.stepaos.com/cloudpolicy", "http://static.stepaos.com/cloudpolicy", "https://static.stepos.com/cloudpolicy", "http://static.stepos.com/cloudpolicy"};

    private PolicyHtmlLinkHandler() {
    }

    public static final String extractCategoryFromCloudPolicyUrl(String url) {
        p.i(url, "url");
        return resolveCategoryForCloudPolicyUrl(url);
    }

    private final String extractCloudPolicyFileName(String url) {
        try {
            String path = new URI(H.D1(url).toString()).getPath();
            if (path == null) {
                return null;
            }
            String strS1 = H.s1(path, JsonPointer.SEPARATOR, null, 2, null);
            if (H.x0(strS1)) {
                return null;
            }
            return strS1;
        } catch (Exception e10) {
            PolicySdkLogUtils.INSTANCE.e("PolicyHtmlLinkHandler", "extractCloudPolicyFileName failed: " + e10.getMessage());
            return null;
        }
    }

    public static final boolean isCloudPolicyUrl(String url) {
        p.i(url, "url");
        String lowerCase = H.D1(url).toString().toLowerCase(Locale.ROOT);
        p.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        for (String str : CLOUD_POLICY_URL_PREFIXES) {
            if (D.X(lowerCase, str, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public static final CloudPolicyUrlInfo parseCloudPolicyUrl(String url) {
        String strExtractCloudPolicyFileName;
        p.i(url, "url");
        if (!isCloudPolicyUrl(url) || (strExtractCloudPolicyFileName = INSTANCE.extractCloudPolicyFileName(url)) == null || !D.J(strExtractCloudPolicyFileName, ".html", true)) {
            return null;
        }
        String strSubstring = strExtractCloudPolicyFileName.substring(0, strExtractCloudPolicyFileName.length() - 5);
        p.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        List listA1 = H.a1(strSubstring, new char[]{'_'}, false, 0, 6, null);
        if (listA1.size() < 2) {
            return null;
        }
        if (listA1.size() >= 3) {
            Long lY = C.y((String) listA1.get(listA1.size() - 2));
            Object objC0 = F.C0(listA1);
            if (H.x0((String) objC0)) {
                objC0 = null;
            }
            String str = (String) objC0;
            if (lY != null && str != null) {
                String strA0 = F.A0(F.i0(listA1, 2), "_", null, null, 0, null, null, 62, null);
                if (!H.x0(strA0)) {
                    return new CloudPolicyUrlInfo(strA0, lY.longValue(), str);
                }
            }
        }
        Long lY2 = C.y((String) F.C0(listA1));
        if (lY2 == null) {
            return null;
        }
        long jLongValue = lY2.longValue();
        String strA02 = F.A0(F.i0(listA1, 1), "_", null, null, 0, null, null, 62, null);
        if (H.x0(strA02)) {
            return null;
        }
        return new CloudPolicyUrlInfo(strA02, jLongValue, null);
    }

    public static final String resolveCategoryForCloudPolicyUrl(String url) {
        p.i(url, "url");
        CloudPolicyUrlInfo cloudPolicyUrl = parseCloudPolicyUrl(url);
        if (cloudPolicyUrl == null) {
            return null;
        }
        String category = cloudPolicyUrl.getCategory();
        if (category != null) {
            String str = H.x0(category) ? null : category;
            if (str != null) {
                return str;
            }
        }
        return PolicyCloudPolicyIndex.getCategory(cloudPolicyUrl.getPolicyUid());
    }

    public static final InPageCloudPolicyTarget resolveInPageCloudPolicyTarget(String url, InterfaceC5074l<? super String, Boolean> hasLocalCategory, boolean sdkCanUseNetwork) {
        p.i(url, "url");
        p.i(hasLocalCategory, "hasLocalCategory");
        return sdkCanUseNetwork ? InPageCloudPolicyTarget.IN_APP_CDN : resolveLocalCategoryForInPageLink(url, hasLocalCategory) != null ? InPageCloudPolicyTarget.LOCAL : InPageCloudPolicyTarget.BROWSER;
    }

    public static final String resolveLocalCategoryForInPageLink(String url, InterfaceC5074l<? super String, Boolean> hasLocalCategory) {
        String category;
        p.i(url, "url");
        p.i(hasLocalCategory, "hasLocalCategory");
        CloudPolicyUrlInfo cloudPolicyUrl = parseCloudPolicyUrl(url);
        if (cloudPolicyUrl == null || (category = PolicyCloudPolicyIndex.getCategory(cloudPolicyUrl.getPolicyUid())) == null || !hasLocalCategory.invoke(category).booleanValue()) {
            return null;
        }
        return category;
    }

    public static final Pair<String, String> resolvePolicyLinkNavigation(String rawUrl, CharSequence linkText, String baseUri) {
        p.i(rawUrl, "rawUrl");
        if (D.X(rawUrl, Const.STR_MART_WELL, false, 2, null)) {
            return null;
        }
        String strResolveUrl = resolveUrl(rawUrl, baseUri);
        if (shouldOpenInApp(strResolveUrl)) {
            return Y8.j.a(strResolveUrl, PolicyHtmlDisplayAdapter.resolveNavigationTitle(linkText, strResolveUrl));
        }
        return null;
    }

    public static final String resolveUrl(String link, String baseUri) {
        p.i(link, "link");
        if (!H.x0(link) && !D.X(link, Const.STR_MART_WELL, false, 2, null) && !H.g0(link, "://", false, 2, null) && !D.X(link, "//", false, 2, null) && baseUri != null) {
            if (H.x0(baseUri)) {
                baseUri = null;
            }
            if (baseUri != null) {
                try {
                    String string = new URI(baseUri).resolve(link).toString();
                    p.h(string, "{\n            URI(base).…ink).toString()\n        }");
                    return string;
                } catch (Exception e10) {
                    PolicySdkLogUtils.INSTANCE.e("PolicyHtmlLinkHandler", "resolveUrl failed: " + e10.getMessage());
                }
            }
        }
        return link;
    }

    public static final boolean shouldOpenInApp(String url) {
        p.i(url, "url");
        if (H.x0(url) || D.X(url, Const.STR_MART_WELL, false, 2, null)) {
            return false;
        }
        return isCloudPolicyUrl(url);
    }

    public final void bindHtmlLinks(TextView textView, String html, String baseUri, boolean darkMode, int linkColor, p9.p<? super String, ? super String, t> onOpenPolicy, InterfaceC5074l<? super String, t> onOpenExternal) {
        p.i(textView, "textView");
        p.i(html, "html");
        p.i(onOpenPolicy, "onOpenPolicy");
        p.i(onOpenExternal, "onOpenExternal");
        Spanned spannedA = z0.b.a(html, 63);
        p.h(spannedA, "fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)");
        Spannable spannableString = spannedA instanceof Spannable ? (Spannable) spannedA : new SpannableString(spannedA);
        if (darkMode) {
            PolicyHtmlDisplayAdapter.clearColorSpans(spannableString);
        }
        replaceUrlSpans$policysdk_release(spannableString, baseUri, linkColor, onOpenPolicy, onOpenExternal);
        Context context = textView.getContext();
        p.h(context, "textView.context");
        textView.setTextColor(PolicyHtmlDisplayAdapter.textColor(context));
        textView.setText(spannableString);
        textView.setMovementMethod(PolicyLinkMovementMethod.INSTANCE.getInstance());
        textView.setFocusable(false);
        textView.setFocusableInTouchMode(false);
    }

    public final void replaceUrlSpans$policysdk_release(Spannable spannable, final String baseUri, final int linkColor, p9.p<? super String, ? super String, t> onOpenPolicy, InterfaceC5074l<? super String, t> onOpenExternal) {
        p.i(spannable, "spannable");
        final p9.p<? super String, ? super String, t> onOpenPolicy2 = onOpenPolicy;
        p.i(onOpenPolicy2, "onOpenPolicy");
        final InterfaceC5074l<? super String, t> onOpenExternal2 = onOpenExternal;
        p.i(onOpenExternal2, "onOpenExternal");
        URLSpan[] urlSpans = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        p.h(urlSpans, "urlSpans");
        int length = urlSpans.length;
        int i10 = 0;
        while (i10 < length) {
            URLSpan uRLSpan = urlSpans[i10];
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            int spanFlags = spannable.getSpanFlags(uRLSpan);
            final String url = uRLSpan.getURL();
            final CharSequence charSequenceSubSequence = spannable.subSequence(spanStart, spanEnd);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicyHtmlLinkHandler$replaceUrlSpans$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    t tVar;
                    p.i(widget, "widget");
                    String rawUrl = url;
                    p.h(rawUrl, "rawUrl");
                    Pair<String, String> pairResolvePolicyLinkNavigation = PolicyHtmlLinkHandler.resolvePolicyLinkNavigation(rawUrl, charSequenceSubSequence, baseUri);
                    if (pairResolvePolicyLinkNavigation != null) {
                        onOpenPolicy2.invoke(pairResolvePolicyLinkNavigation.a(), pairResolvePolicyLinkNavigation.b());
                        tVar = t.f7040a;
                    } else {
                        tVar = null;
                    }
                    if (tVar == null) {
                        String rawUrl2 = url;
                        String str = baseUri;
                        InterfaceC5074l<String, t> interfaceC5074l = onOpenExternal2;
                        p.h(rawUrl2, "rawUrl");
                        interfaceC5074l.invoke(PolicyHtmlLinkHandler.resolveUrl(rawUrl2, str));
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    p.i(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setColor(linkColor);
                    ds.setUnderlineText(true);
                }
            }, spanStart, spanEnd, spanFlags);
            i10++;
            onOpenPolicy2 = onOpenPolicy;
            onOpenExternal2 = onOpenExternal;
        }
    }
}
