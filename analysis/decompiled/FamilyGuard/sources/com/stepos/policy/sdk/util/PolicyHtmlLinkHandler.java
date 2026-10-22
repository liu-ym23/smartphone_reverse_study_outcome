package com.stepos.policy.sdk.util;

import V3.m;
import V3.r;
import V3.v;
import W3.C0403n;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.stepos.policy.sdk.bean.CloudPolicyUrlInfo;
import i4.InterfaceC0772l;
import i4.p;
import j4.k;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import r4.C1031n;

/* loaded from: classes.dex */
public final class PolicyHtmlLinkHandler {
    public static final String CLOUD_POLICY_URL_PREFIX = "https://static.stepaos.com/cloudPolicy";
    public static final PolicyHtmlLinkHandler INSTANCE = new PolicyHtmlLinkHandler();
    private static final String[] CLOUD_POLICY_URL_PREFIXES = {"https://static.stepaos.com/cloudpolicy", "http://static.stepaos.com/cloudpolicy", "https://static.stepos.com/cloudpolicy", "http://static.stepos.com/cloudpolicy"};

    private PolicyHtmlLinkHandler() {
    }

    public static final String extractCategoryFromCloudPolicyUrl(String str) {
        k.g(str, "url");
        return resolveCategoryForCloudPolicyUrl(str);
    }

    private final String extractCloudPolicyFileName(String str) {
        try {
            String path = new URI(C1031n.i0(str).toString()).getPath();
            if (path == null) {
                return null;
            }
            String strF0 = C1031n.f0(path, '/', null, 2, null);
            if (C1031n.E(strF0)) {
                return null;
            }
            return strF0;
        } catch (Exception e6) {
            PolicySdkLogUtils.Companion.e("PolicyHtmlLinkHandler", "extractCloudPolicyFileName failed: " + e6.getMessage());
            return null;
        }
    }

    public static final boolean isCloudPolicyUrl(String str) {
        k.g(str, "url");
        String lowerCase = C1031n.i0(str).toString().toLowerCase(Locale.ROOT);
        k.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        for (String str2 : CLOUD_POLICY_URL_PREFIXES) {
            if (C1031n.q(lowerCase, str2, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public static final CloudPolicyUrlInfo parseCloudPolicyUrl(String str) {
        String strExtractCloudPolicyFileName;
        k.g(str, "url");
        if (!isCloudPolicyUrl(str) || (strExtractCloudPolicyFileName = INSTANCE.extractCloudPolicyFileName(str)) == null || !C1031n.l(strExtractCloudPolicyFileName, ".html", true)) {
            return null;
        }
        String strSubstring = strExtractCloudPolicyFileName.substring(0, strExtractCloudPolicyFileName.length() - 5);
        k.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        List listX = C1031n.X(strSubstring, new char[]{'_'}, false, 0, 6, null);
        if (listX.size() < 2) {
            return null;
        }
        if (listX.size() >= 3) {
            Long lJ = C1031n.j((String) listX.get(listX.size() - 2));
            Object objK = C0403n.K(listX);
            if (C1031n.E((String) objK)) {
                objK = null;
            }
            String str2 = (String) objK;
            if (lJ != null && str2 != null) {
                String strI = C0403n.I(C0403n.z(listX, 2), "_", null, null, 0, null, null, 62, null);
                if (!C1031n.E(strI)) {
                    return new CloudPolicyUrlInfo(strI, lJ.longValue(), str2);
                }
            }
        }
        Long lJ2 = C1031n.j((String) C0403n.K(listX));
        if (lJ2 == null) {
            return null;
        }
        long jLongValue = lJ2.longValue();
        String strI2 = C0403n.I(C0403n.z(listX, 1), "_", null, null, 0, null, null, 62, null);
        if (C1031n.E(strI2)) {
            return null;
        }
        return new CloudPolicyUrlInfo(strI2, jLongValue, null);
    }

    public static final String resolveCategoryForCloudPolicyUrl(String str) {
        k.g(str, "url");
        CloudPolicyUrlInfo cloudPolicyUrl = parseCloudPolicyUrl(str);
        if (cloudPolicyUrl == null) {
            return null;
        }
        String category = cloudPolicyUrl.getCategory();
        if (category != null) {
            String str2 = C1031n.E(category) ? null : category;
            if (str2 != null) {
                return str2;
            }
        }
        return PolicyCloudPolicyIndex.getCategory(cloudPolicyUrl.getPolicyUid());
    }

    public static final InPageCloudPolicyTarget resolveInPageCloudPolicyTarget(String str, InterfaceC0772l<? super String, Boolean> interfaceC0772l, boolean z5) {
        k.g(str, "url");
        k.g(interfaceC0772l, "hasLocalCategory");
        return z5 ? InPageCloudPolicyTarget.IN_APP_CDN : resolveLocalCategoryForInPageLink(str, interfaceC0772l) != null ? InPageCloudPolicyTarget.LOCAL : InPageCloudPolicyTarget.BROWSER;
    }

    public static final String resolveLocalCategoryForInPageLink(String str, InterfaceC0772l<? super String, Boolean> interfaceC0772l) {
        String category;
        k.g(str, "url");
        k.g(interfaceC0772l, "hasLocalCategory");
        CloudPolicyUrlInfo cloudPolicyUrl = parseCloudPolicyUrl(str);
        if (cloudPolicyUrl == null || (category = PolicyCloudPolicyIndex.getCategory(cloudPolicyUrl.getPolicyUid())) == null || !interfaceC0772l.invoke(category).booleanValue()) {
            return null;
        }
        return category;
    }

    public static final m<String, String> resolvePolicyLinkNavigation(String str, CharSequence charSequence, String str2) {
        k.g(str, "rawUrl");
        if (C1031n.q(str, "#", false, 2, null)) {
            return null;
        }
        String strResolveUrl = resolveUrl(str, str2);
        if (shouldOpenInApp(strResolveUrl)) {
            return r.a(strResolveUrl, PolicyHtmlDisplayAdapter.resolveNavigationTitle(charSequence, strResolveUrl));
        }
        return null;
    }

    public static final String resolveUrl(String str, String str2) {
        k.g(str, "link");
        if (!C1031n.E(str) && !C1031n.q(str, "#", false, 2, null) && !C1031n.u(str, "://", false, 2, null) && !C1031n.q(str, "//", false, 2, null) && str2 != null) {
            if (C1031n.E(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                try {
                    String string = new URI(str2).resolve(str).toString();
                    k.f(string, "{\n            URI(base).…ink).toString()\n        }");
                    return string;
                } catch (Exception e6) {
                    PolicySdkLogUtils.Companion.e("PolicyHtmlLinkHandler", "resolveUrl failed: " + e6.getMessage());
                }
            }
        }
        return str;
    }

    public static final boolean shouldOpenInApp(String str) {
        k.g(str, "url");
        if (C1031n.E(str) || C1031n.q(str, "#", false, 2, null)) {
            return false;
        }
        return isCloudPolicyUrl(str);
    }

    public final void bindHtmlLinks(TextView textView, String str, String str2, boolean z5, int i5, p<? super String, ? super String, v> pVar, InterfaceC0772l<? super String, v> interfaceC0772l) {
        k.g(textView, "textView");
        k.g(str, "html");
        k.g(pVar, "onOpenPolicy");
        k.g(interfaceC0772l, "onOpenExternal");
        Spanned spannedA = androidx.core.text.b.a(str, 63);
        k.f(spannedA, "fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)");
        Spannable spannableString = spannedA instanceof Spannable ? (Spannable) spannedA : new SpannableString(spannedA);
        if (z5) {
            PolicyHtmlDisplayAdapter.clearColorSpans(spannableString);
        }
        replaceUrlSpans$policysdk_release(spannableString, str2, i5, pVar, interfaceC0772l);
        Context context = textView.getContext();
        k.f(context, "textView.context");
        textView.setTextColor(PolicyHtmlDisplayAdapter.textColor(context));
        textView.setText(spannableString);
        textView.setMovementMethod(PolicyLinkMovementMethod.Companion.getInstance());
        textView.setFocusable(false);
        textView.setFocusableInTouchMode(false);
    }

    public final void replaceUrlSpans$policysdk_release(Spannable spannable, final String str, final int i5, p<? super String, ? super String, v> pVar, InterfaceC0772l<? super String, v> interfaceC0772l) {
        k.g(spannable, "spannable");
        final p<? super String, ? super String, v> pVar2 = pVar;
        k.g(pVar2, "onOpenPolicy");
        final InterfaceC0772l<? super String, v> interfaceC0772l2 = interfaceC0772l;
        k.g(interfaceC0772l2, "onOpenExternal");
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        k.f(uRLSpanArr, "urlSpans");
        int length = uRLSpanArr.length;
        int i6 = 0;
        while (i6 < length) {
            URLSpan uRLSpan = uRLSpanArr[i6];
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            int spanFlags = spannable.getSpanFlags(uRLSpan);
            final String url = uRLSpan.getURL();
            final CharSequence charSequenceSubSequence = spannable.subSequence(spanStart, spanEnd);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicyHtmlLinkHandler$replaceUrlSpans$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    v vVar;
                    k.g(view, "widget");
                    String str2 = url;
                    k.f(str2, "rawUrl");
                    m<String, String> mVarResolvePolicyLinkNavigation = PolicyHtmlLinkHandler.resolvePolicyLinkNavigation(str2, charSequenceSubSequence, str);
                    if (mVarResolvePolicyLinkNavigation != null) {
                        pVar2.invoke(mVarResolvePolicyLinkNavigation.a(), mVarResolvePolicyLinkNavigation.b());
                        vVar = v.f5542a;
                    } else {
                        vVar = null;
                    }
                    if (vVar == null) {
                        String str3 = url;
                        String str4 = str;
                        InterfaceC0772l<String, v> interfaceC0772l3 = interfaceC0772l2;
                        k.f(str3, "rawUrl");
                        interfaceC0772l3.invoke(PolicyHtmlLinkHandler.resolveUrl(str3, str4));
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    k.g(textPaint, "ds");
                    super.updateDrawState(textPaint);
                    textPaint.setColor(i5);
                    textPaint.setUnderlineText(true);
                }
            }, spanStart, spanEnd, spanFlags);
            i6++;
            pVar2 = pVar;
            interfaceC0772l2 = interfaceC0772l;
        }
    }
}
