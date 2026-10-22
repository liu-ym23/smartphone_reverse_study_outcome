package com.stepos.policy.sdk.util;

import android.content.Context;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import hc.h;
import hc.o;
import java.net.URI;
import java.util.Locale;
import jb.g;
import jb.v;
import xb.l;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyHtmlLinkHandler {
    private static final String CLOUD_POLICY_HTTPS_PREFIX = "https://static.stepos.com/cloudpolicy";
    private static final String CLOUD_POLICY_HTTP_PREFIX = "http://static.stepos.com/cloudpolicy";
    public static final String CLOUD_POLICY_URL_PREFIX = "https://static.stepos.com/cloudPolicy";
    public static final PolicyHtmlLinkHandler INSTANCE = new PolicyHtmlLinkHandler();

    private PolicyHtmlLinkHandler() {
    }

    public static final boolean isCloudPolicyUrl(String str) {
        str.getClass();
        String lowerCase = h.w0(str).toString().toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return o.U(lowerCase, CLOUD_POLICY_HTTPS_PREFIX, false) || o.U(lowerCase, CLOUD_POLICY_HTTP_PREFIX, false);
    }

    public static final g resolvePolicyLinkNavigation(String str, CharSequence charSequence, String str2) {
        str.getClass();
        if (o.U(str, "#", false)) {
            return null;
        }
        String strResolveUrl = resolveUrl(str, str2);
        if (shouldOpenInApp(strResolveUrl)) {
            return new g(strResolveUrl, PolicyHtmlDisplayAdapter.resolveNavigationTitle(charSequence, strResolveUrl));
        }
        return null;
    }

    public static final String resolveUrl(String str, String str2) {
        str.getClass();
        if (!h.g0(str) && !o.U(str, "#", false) && !h.X(str, "://", false) && !o.U(str, "//", false) && str2 != null) {
            if (h.g0(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                try {
                    String string = new URI(str2).resolve(str).toString();
                    string.getClass();
                    return string;
                } catch (Exception e10) {
                    PolicySdkLogUtils.Companion.e("PolicyHtmlLinkHandler", "resolveUrl failed: " + e10.getMessage());
                }
            }
        }
        return str;
    }

    public static final boolean shouldOpenInApp(String str) {
        str.getClass();
        if (h.g0(str) || o.U(str, "#", false)) {
            return false;
        }
        return isCloudPolicyUrl(str);
    }

    public final void bindHtmlLinks(TextView textView, String str, String str2, boolean z10, int i, p pVar, l lVar) {
        textView.getClass();
        str.getClass();
        pVar.getClass();
        lVar.getClass();
        Spanned spannedFromHtml = Html.fromHtml(str, 63);
        spannedFromHtml.getClass();
        Spannable spannableString = spannedFromHtml instanceof Spannable ? (Spannable) spannedFromHtml : new SpannableString(spannedFromHtml);
        if (z10) {
            PolicyHtmlDisplayAdapter.clearColorSpans(spannableString);
        }
        replaceUrlSpans$policysdk_release(spannableString, str2, i, pVar, lVar);
        Context context = textView.getContext();
        context.getClass();
        textView.setTextColor(PolicyHtmlDisplayAdapter.textColor(context));
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void replaceUrlSpans$policysdk_release(Spannable spannable, final String str, final int i, final p pVar, final l lVar) {
        spannable.getClass();
        pVar.getClass();
        lVar.getClass();
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        uRLSpanArr.getClass();
        for (URLSpan uRLSpan : uRLSpanArr) {
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
                    view.getClass();
                    String str2 = url;
                    str2.getClass();
                    g gVarResolvePolicyLinkNavigation = PolicyHtmlLinkHandler.resolvePolicyLinkNavigation(str2, charSequenceSubSequence, str);
                    if (gVarResolvePolicyLinkNavigation != null) {
                        pVar.invoke((String) gVarResolvePolicyLinkNavigation.f6759c, (String) gVarResolvePolicyLinkNavigation.f6760f);
                        vVar = v.f6774a;
                    } else {
                        vVar = null;
                    }
                    if (vVar == null) {
                        String str3 = url;
                        String str4 = str;
                        l lVar2 = lVar;
                        str3.getClass();
                        lVar2.invoke(PolicyHtmlLinkHandler.resolveUrl(str3, str4));
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.getClass();
                    super.updateDrawState(textPaint);
                    textPaint.setColor(i);
                    textPaint.setUnderlineText(true);
                }
            }, spanStart, spanEnd, spanFlags);
        }
    }
}
