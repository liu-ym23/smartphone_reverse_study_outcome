package com.stepos.policy.sdk.util;

import C7.r;
import D7.v;
import D7.w;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.google.gson.Gson;
import com.stepos.ability.R;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import j9.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkStringUtils;", "", "()V", "ACCOUNT_CENTER_URL", "", "getDeleteInfoListFromServiceConfig", "", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "context", "Landroid/content/Context;", "policyServiceConfigList", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigBean;", "policyWithdrawCustomTerms", "", "withdrawMsg", "searchAllIndex", "", "", "content", "chars", "withdrawCheckMessage", "withdrawCheckMessageAccount", "withdrawMessage", "withdrawMessageAccount", "withdrawMessageBasic", "withdrawMessageBasicAccount", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicySdkStringUtils {
    public static final String ACCOUNT_CENTER_URL = "https://service.zyql.com/fac.html?source=config";
    public static final PolicySdkStringUtils INSTANCE = new PolicySdkStringUtils();

    private PolicySdkStringUtils() {
    }

    public final List<DeleteInfoBean> getDeleteInfoListFromServiceConfig(Context context, List<PolicyServiceConfigBean> policyServiceConfigList) {
        k.f(context, "context");
        k.f(policyServiceConfigList, "policyServiceConfigList");
        ArrayList arrayList = new ArrayList();
        Gson gson = new Gson();
        List<PolicyServiceConfigBean> list = policyServiceConfigList;
        ArrayList arrayList2 = new ArrayList(w.c0(list, 10));
        for (PolicyServiceConfigBean policyServiceConfigBean : list) {
            if (k.b(policyServiceConfigBean.getBusinessType(), "phone")) {
                List listY0 = v.Y0(m.D0(policyServiceConfigBean.getIdType(), new String[]{"&"}, 6));
                int iP = kotlin.collections.a.P(w.c0(listY0, 10));
                if (iP < 16) {
                    iP = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
                for (Object obj : listY0) {
                    linkedHashMap.put(obj, "");
                }
                HashMap map = new HashMap();
                map.put("provider", context.getPackageName());
                String extra = gson.toJson(map);
                k.e(extra, "extra");
                String keyInfoJson = gson.toJson(new KeyInfo("", "-1", "-1", extra));
                String strValueOf = String.valueOf(policyServiceConfigBean.getServiceId());
                String json = gson.toJson(linkedHashMap);
                k.e(json, "gson.toJson(bindId)");
                k.e(keyInfoJson, "keyInfoJson");
                arrayList.add(new DeleteInfoBean(strValueOf, json, keyInfoJson));
            }
            arrayList2.add(r.f317a);
        }
        return arrayList;
    }

    public final CharSequence policyWithdrawCustomTerms(final Context context, String withdrawMsg) {
        k.f(context, "context");
        k.f(withdrawMsg, "withdrawMsg");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final String string = context.getString(R.string.policy_sdk_account_pp_title);
        k.e(string, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_message);
        k.e(string2, "context.getString(R.stri…y_sdk_account_pp_message)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        k.e(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        String string4 = context.getString(R.string.policy_sdk_withdraw_text_notify);
        k.e(string4, "context.getString(R.stri…sdk_withdraw_text_notify)");
        String strConcat = withdrawMsg.concat(string4);
        spannableStringBuilder.append((CharSequence) strConcat);
        if (m.h0(strConcat, string2, false)) {
            Iterator<Integer> it = searchAllIndex(strConcat, string2).iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                final String str = "pp";
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        k.f(view, "view");
                        PolicySdk.openPolicyByMethod(context, Boolean.TRUE, string, str);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds) {
                        k.f(ds, "ds");
                        super.updateDrawState(ds);
                        ds.setUnderlineText(false);
                    }
                }, iIntValue, string2.length() + iIntValue, 34);
            }
        }
        if (m.h0(strConcat, string3, false)) {
            int iQ0 = m.q0(strConcat, string3, 0, false, 6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    k.f(view, "view");
                    PolicySdkToolsUtils.INSTANCE.startBrowser(context, PolicySdkStringUtils.ACCOUNT_CENTER_URL);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    k.f(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }
            }, iQ0, string3.length() + iQ0, 34);
        }
        if (m.h0(strConcat, string4, false)) {
            m.q0(strConcat, string4, 0, false, 6);
        }
        return spannableStringBuilder;
    }

    public final List<Integer> searchAllIndex(String content, String chars) {
        k.f(chars, "chars");
        ArrayList arrayList = new ArrayList();
        if (content != null && content.length() != 0) {
            int iQ0 = m.q0(content, chars, 0, false, 6);
            while (iQ0 != -1) {
                arrayList.add(Integer.valueOf(iQ0));
                iQ0 = m.q0(content, chars, iQ0 + 1, false, 4);
            }
        }
        return arrayList;
    }

    public final String withdrawCheckMessage(Context context) {
        k.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_check_message);
        k.e(string, "context.getString(R.stri…k_withdraw_check_message)");
        return string;
    }

    public final String withdrawCheckMessageAccount(Context context) {
        k.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_check_message_account);
        k.e(string, "context.getString(R.stri…aw_check_message_account)");
        return string;
    }

    public final CharSequence withdrawMessage(Context context) {
        k.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_not_basic_not_account);
        k.e(string, "context.getString(R.stri…xt_not_basic_not_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        k.e(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2}, 1)));
    }

    public final CharSequence withdrawMessageAccount(Context context) {
        k.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_not_basic_has_account);
        k.e(string, "context.getString(R.stri…xt_not_basic_has_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        k.e(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        k.e(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2)));
    }

    public final CharSequence withdrawMessageBasic(Context context) {
        k.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_basic_not_account);
        k.e(string, "context.getString(R.stri…w_text_basic_not_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        k.e(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2}, 1)));
    }

    public final CharSequence withdrawMessageBasicAccount(Context context) {
        k.f(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_basic_account);
        k.e(string, "context.getString(R.stri…hdraw_text_basic_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        k.e(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        k.e(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2)));
    }
}
