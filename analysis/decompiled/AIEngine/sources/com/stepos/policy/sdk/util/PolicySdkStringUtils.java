package com.stepos.policy.sdk.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.stepos.aiengine.R;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import d5.i;
import gc.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import lb.n;
import mb.m;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkStringUtils {
    public static final PolicySdkStringUtils INSTANCE = new PolicySdkStringUtils();

    private PolicySdkStringUtils() {
    }

    public final String getAccountCenterUrl(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        return ai.onnxruntime.a.l("https://account.", PolicySdkRetrofitCreator.INSTANCE.resolveHttpHostFromNetEnv(context), "/user/cancel/statement?account_belong=stepos&uc_theme=auto&lang=", PolicySdkToolsUtils.Companion.getLanguage());
    }

    public final List<DeleteInfoBean> getDeleteInfoListFromServiceConfig(Context context, List<PolicyServiceConfigBean> policyServiceConfigList) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(policyServiceConfigList, "policyServiceConfigList");
        ArrayList arrayList = new ArrayList();
        i iVar = new i();
        ArrayList arrayList2 = new ArrayList(m.Z(policyServiceConfigList, 10));
        for (PolicyServiceConfigBean policyServiceConfigBean : policyServiceConfigList) {
            if (kotlin.jvm.internal.g.b(policyServiceConfigBean.getBusinessType(), "phone")) {
                List listH0 = kotlin.collections.a.H0(q.D0(policyServiceConfigBean.getIdType(), new String[]{"&"}, 6));
                int iA0 = v.a0(m.Z(listH0, 10));
                if (iA0 < 16) {
                    iA0 = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
                for (Object obj : listH0) {
                    linkedHashMap.put(obj, "");
                }
                HashMap map = new HashMap();
                map.put("provider", context.getPackageName());
                String extra = iVar.h(map);
                kotlin.jvm.internal.g.e(extra, "extra");
                String keyInfoJson = iVar.h(new KeyInfo("", "-1", "-1", extra));
                String strValueOf = String.valueOf(policyServiceConfigBean.getServiceId());
                String strH = iVar.h(linkedHashMap);
                kotlin.jvm.internal.g.e(strH, "gson.toJson(bindId)");
                kotlin.jvm.internal.g.e(keyInfoJson, "keyInfoJson");
                arrayList.add(new DeleteInfoBean(strValueOf, strH, keyInfoJson));
            }
            arrayList2.add(n.f10413a);
        }
        return arrayList;
    }

    public final CharSequence policyWithdrawCustomTerms(final Context context, String withdrawMsg) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(withdrawMsg, "withdrawMsg");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final String string = context.getString(R.string.policy_sdk_account_pp_title);
        kotlin.jvm.internal.g.e(string, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_message);
        kotlin.jvm.internal.g.e(string2, "context.getString(R.stri…y_sdk_account_pp_message)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        kotlin.jvm.internal.g.e(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        String string4 = context.getString(R.string.policy_sdk_withdraw_text_notify);
        kotlin.jvm.internal.g.e(string4, "context.getString(R.stri…sdk_withdraw_text_notify)");
        String strConcat = withdrawMsg.concat(string4);
        spannableStringBuilder.append((CharSequence) strConcat);
        if (q.l0(strConcat, string2, false)) {
            Iterator<Integer> it = searchAllIndex(strConcat, string2).iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                final String str = "pp";
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        kotlin.jvm.internal.g.f(view, "view");
                        PolicySdk.openPolicyByMethod(context, Boolean.TRUE, string, str);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds) {
                        kotlin.jvm.internal.g.f(ds, "ds");
                        super.updateDrawState(ds);
                        ds.setUnderlineText(false);
                    }
                }, iIntValue, string2.length() + iIntValue, 34);
            }
        }
        if (q.l0(strConcat, string3, false)) {
            int iR0 = q.r0(strConcat, string3, 0, false, 6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    kotlin.jvm.internal.g.f(view, "view");
                    PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
                    Context context2 = context;
                    companion.startBrowser(context2, PolicySdkStringUtils.INSTANCE.getAccountCenterUrl(context2));
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    kotlin.jvm.internal.g.f(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }
            }, iR0, string3.length() + iR0, 34);
        }
        if (q.l0(strConcat, string4, false)) {
            q.r0(strConcat, string4, 0, false, 6);
        }
        return spannableStringBuilder;
    }

    public final List<Integer> searchAllIndex(String str, String chars) {
        kotlin.jvm.internal.g.f(chars, "chars");
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() != 0) {
            int iR0 = q.r0(str, chars, 0, false, 6);
            while (iR0 != -1) {
                arrayList.add(Integer.valueOf(iR0));
                iR0 = q.r0(str, chars, iR0 + 1, false, 4);
            }
        }
        return arrayList;
    }

    public final String withdrawCheckMessage(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_check_message);
        kotlin.jvm.internal.g.e(string, "context.getString(R.stri…k_withdraw_check_message)");
        return string;
    }

    public final String withdrawCheckMessageAccount(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_check_message_account);
        kotlin.jvm.internal.g.e(string, "context.getString(R.stri…aw_check_message_account)");
        return string;
    }

    public final CharSequence withdrawMessage(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_not_basic_not_account);
        kotlin.jvm.internal.g.e(string, "context.getString(R.stri…xt_not_basic_not_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        kotlin.jvm.internal.g.e(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2}, 1)));
    }

    public final CharSequence withdrawMessageAccount(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_not_basic_has_account);
        kotlin.jvm.internal.g.e(string, "context.getString(R.stri…xt_not_basic_has_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        kotlin.jvm.internal.g.e(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        kotlin.jvm.internal.g.e(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2)));
    }

    public final CharSequence withdrawMessageBasic(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_basic_not_account);
        kotlin.jvm.internal.g.e(string, "context.getString(R.stri…w_text_basic_not_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        kotlin.jvm.internal.g.e(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2}, 1)));
    }

    public final CharSequence withdrawMessageBasicAccount(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_basic_account);
        kotlin.jvm.internal.g.e(string, "context.getString(R.stri…hdraw_text_basic_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        kotlin.jvm.internal.g.e(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        kotlin.jvm.internal.g.e(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2)));
    }
}
