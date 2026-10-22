package com.stepos.policy.sdk.util;

import V3.v;
import W3.C0403n;
import W3.E;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import com.stepos.policy.sdk.s;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import j4.k;
import j4.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ranges.l;
import org.libpag.BuildConfig;
import r4.C1031n;

/* loaded from: classes.dex */
public final class PolicySdkStringUtils {
    public static final PolicySdkStringUtils INSTANCE = new PolicySdkStringUtils();

    private PolicySdkStringUtils() {
    }

    public final String getAccountCenterUrl(Context context) {
        k.g(context, "context");
        return "https://account." + PolicySdkRetrofitCreator.INSTANCE.resolveHttpHostFromNetEnv(context) + "/user/cancel/statement?account_belong=stepos&uc_theme=auto&lang=" + PolicySdkToolsUtils.Companion.getLanguage();
    }

    public final List<DeleteInfoBean> getDeleteInfoListFromServiceConfig(Context context, List<PolicyServiceConfigBean> list) {
        k.g(context, "context");
        k.g(list, "policyServiceConfigList");
        ArrayList arrayList = new ArrayList();
        A1.e eVar = new A1.e();
        ArrayList arrayList2 = new ArrayList(C0403n.r(list, 10));
        for (PolicyServiceConfigBean policyServiceConfigBean : list) {
            if (k.b(policyServiceConfigBean.getBusinessType(), "phone")) {
                List listQ = C0403n.Q(C1031n.Y(policyServiceConfigBean.getIdType(), new String[]{"&"}, false, 0, 6, null));
                LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(E.a(C0403n.r(listQ, 10)), 16));
                for (Object obj : listQ) {
                    linkedHashMap.put(obj, BuildConfig.FLAVOR);
                }
                HashMap map = new HashMap();
                map.put("provider", context.getPackageName());
                String strR = eVar.r(map);
                k.f(strR, "extra");
                String strR2 = eVar.r(new KeyInfo(BuildConfig.FLAVOR, "-1", "-1", strR));
                String strValueOf = String.valueOf(policyServiceConfigBean.getServiceId());
                String strR3 = eVar.r(linkedHashMap);
                k.f(strR3, "gson.toJson(bindId)");
                k.f(strR2, "keyInfoJson");
                arrayList.add(new DeleteInfoBean(strValueOf, strR3, strR2));
            }
            arrayList2.add(v.f5542a);
        }
        return arrayList;
    }

    public final CharSequence policyWithdrawCustomTerms(final Context context, String str) {
        k.g(context, "context");
        k.g(str, "withdrawMsg");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final String string = context.getString(s.f15825c);
        k.f(string, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string2 = context.getString(s.f15824b);
        k.f(string2, "context.getString(R.stri…y_sdk_account_pp_message)");
        String string3 = context.getString(s.f15823a);
        k.f(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        String string4 = context.getString(s.f15821C);
        k.f(string4, "context.getString(R.stri…sdk_withdraw_text_notify)");
        String str2 = str + string4;
        spannableStringBuilder.append((CharSequence) str2);
        if (C1031n.u(str2, string2, false, 2, null)) {
            Iterator<Integer> it = searchAllIndex(str2, string2).iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                final String str3 = "pp";
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        k.g(view, "view");
                        PolicySdk.openPolicyByMethod(context, Boolean.TRUE, string, str3);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        k.g(textPaint, "ds");
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }
                }, iIntValue, string2.length() + iIntValue, 34);
            }
        }
        if (C1031n.u(str2, string3, false, 2, null)) {
            int iC = C1031n.C(str2, string3, 0, false, 6, null);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    k.g(view, "view");
                    PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
                    Context context2 = context;
                    companion.startBrowser(context2, PolicySdkStringUtils.INSTANCE.getAccountCenterUrl(context2));
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    k.g(textPaint, "ds");
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            }, iC, string3.length() + iC, 34);
        }
        if (C1031n.u(str2, string4, false, 2, null)) {
            C1031n.C(str2, string4, 0, false, 6, null);
        }
        return spannableStringBuilder;
    }

    public final List<Integer> searchAllIndex(String str, String str2) {
        k.g(str2, "chars");
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() != 0) {
            int iC = C1031n.C(str, str2, 0, false, 6, null);
            while (iC != -1) {
                arrayList.add(Integer.valueOf(iC));
                iC = C1031n.C(str, str2, iC + 1, false, 4, null);
            }
        }
        return arrayList;
    }

    public final String withdrawCheckMessage(Context context) {
        k.g(context, "context");
        String string = context.getString(s.f15843u);
        k.f(string, "context.getString(R.stri…k_withdraw_check_message)");
        return string;
    }

    public final String withdrawCheckMessageAccount(Context context) {
        k.g(context, "context");
        String string = context.getString(s.f15844v);
        k.f(string, "context.getString(R.stri…aw_check_message_account)");
        return string;
    }

    public final CharSequence withdrawMessage(Context context) {
        k.g(context, "context");
        String string = context.getString(s.f15820B);
        k.f(string, "context.getString(R.stri…xt_not_basic_not_account)");
        String string2 = context.getString(s.f15825c);
        k.f(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        y yVar = y.f17839a;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2}, 1));
        k.f(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    public final CharSequence withdrawMessageAccount(Context context) {
        k.g(context, "context");
        String string = context.getString(s.f15819A);
        k.f(string, "context.getString(R.stri…xt_not_basic_has_account)");
        String string2 = context.getString(s.f15825c);
        k.f(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(s.f15823a);
        k.f(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        y yVar = y.f17839a;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2));
        k.f(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    public final CharSequence withdrawMessageBasic(Context context) {
        k.g(context, "context");
        String string = context.getString(s.f15846x);
        k.f(string, "context.getString(R.stri…w_text_basic_not_account)");
        String string2 = context.getString(s.f15825c);
        k.f(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        y yVar = y.f17839a;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2}, 1));
        k.f(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    public final CharSequence withdrawMessageBasicAccount(Context context) {
        k.g(context, "context");
        String string = context.getString(s.f15845w);
        k.f(string, "context.getString(R.stri…hdraw_text_basic_account)");
        String string2 = context.getString(s.f15825c);
        k.f(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(s.f15823a);
        k.f(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        y yVar = y.f17839a;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2));
        k.f(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }
}
