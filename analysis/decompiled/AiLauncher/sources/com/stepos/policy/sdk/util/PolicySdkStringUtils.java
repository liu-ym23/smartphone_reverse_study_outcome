package com.stepos.policy.sdk.util;

import La.H;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.R$string;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import v9.C5685n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u001a"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkStringUtils;", "", "()V", "getAccountCenterUrl", "", "context", "Landroid/content/Context;", "getDeleteInfoListFromServiceConfig", "", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "policyServiceConfigList", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigBean;", "policyWithdrawCustomTerms", "", "withdrawMsg", "searchAllIndex", "", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "chars", "withdrawCheckMessage", "withdrawCheckMessageAccount", "withdrawMessage", "withdrawMessageAccount", "withdrawMessageBasic", "withdrawMessageBasicAccount", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkStringUtils {
    public static final PolicySdkStringUtils INSTANCE = new PolicySdkStringUtils();

    private PolicySdkStringUtils() {
    }

    public final String getAccountCenterUrl(Context context) {
        p.i(context, "context");
        return "https://account." + PolicySdkRetrofitCreator.INSTANCE.resolveHttpHostFromNetEnv(context) + "/user/cancel/statement?account_belong=stepos&uc_theme=auto&lang=" + PolicySdkToolsUtils.INSTANCE.getLanguage();
    }

    public final List<DeleteInfoBean> getDeleteInfoListFromServiceConfig(Context context, List<PolicyServiceConfigBean> policyServiceConfigList) {
        p.i(context, "context");
        p.i(policyServiceConfigList, "policyServiceConfigList");
        ArrayList arrayList = new ArrayList();
        Gson gson = new Gson();
        List<PolicyServiceConfigBean> list = policyServiceConfigList;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
        for (PolicyServiceConfigBean policyServiceConfigBean : list) {
            if (p.d(policyServiceConfigBean.getBusinessType(), "phone")) {
                List listB1 = F.b1(H.b1(policyServiceConfigBean.getIdType(), new String[]{Const.STR_MART_ADD}, false, 0, 6, null));
                LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(listB1, 10)), 16));
                for (Object obj : listB1) {
                    linkedHashMap.put(obj, "");
                }
                HashMap map = new HashMap();
                map.put(Const.JSON_KEY_PROVIDER, context.getPackageName());
                String extra = gson.toJson(map);
                p.h(extra, "extra");
                String keyInfoJson = gson.toJson(new KeyInfo("", Const.INDOOR_LOCATION_TYPE, Const.INDOOR_LOCATION_TYPE, extra));
                String strValueOf = String.valueOf(policyServiceConfigBean.getServiceId());
                String json = gson.toJson(linkedHashMap);
                p.h(json, "gson.toJson(bindId)");
                p.h(keyInfoJson, "keyInfoJson");
                arrayList.add(new DeleteInfoBean(strValueOf, json, keyInfoJson));
            }
            arrayList2.add(t.f7040a);
        }
        return arrayList;
    }

    public final CharSequence policyWithdrawCustomTerms(final Context context, String withdrawMsg) {
        p.i(context, "context");
        p.i(withdrawMsg, "withdrawMsg");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final String string = context.getString(R$string.policy_sdk_account_pp_title);
        p.h(string, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string2 = context.getString(R$string.policy_sdk_account_pp_message);
        p.h(string2, "context.getString(R.stri…y_sdk_account_pp_message)");
        String string3 = context.getString(R$string.policy_sdk_account_center);
        p.h(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        String string4 = context.getString(R$string.policy_sdk_withdraw_text_notify);
        p.h(string4, "context.getString(R.stri…sdk_withdraw_text_notify)");
        String str = withdrawMsg + string4;
        spannableStringBuilder.append((CharSequence) str);
        if (H.g0(str, string2, false, 2, null)) {
            Iterator<Integer> it = searchAllIndex(str, string2).iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                final String str2 = "pp";
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        p.i(view, "view");
                        PolicySdk.openPolicyByMethod(context, Boolean.TRUE, string, str2);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds) {
                        p.i(ds, "ds");
                        super.updateDrawState(ds);
                        ds.setUnderlineText(false);
                    }
                }, iIntValue, string2.length() + iIntValue, 34);
            }
        }
        if (H.g0(str, string3, false, 2, null)) {
            int iU0 = H.u0(str, string3, 0, false, 6, null);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    p.i(view, "view");
                    PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.INSTANCE;
                    Context context2 = context;
                    companion.startBrowser(context2, PolicySdkStringUtils.INSTANCE.getAccountCenterUrl(context2));
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    p.i(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }
            }, iU0, string3.length() + iU0, 34);
        }
        if (H.g0(str, string4, false, 2, null)) {
            H.u0(str, string4, 0, false, 6, null);
        }
        return spannableStringBuilder;
    }

    public final List<Integer> searchAllIndex(String content, String chars) {
        p.i(chars, "chars");
        ArrayList arrayList = new ArrayList();
        if (content != null && content.length() != 0) {
            int iU0 = H.u0(content, chars, 0, false, 6, null);
            while (iU0 != -1) {
                arrayList.add(Integer.valueOf(iU0));
                iU0 = H.u0(content, chars, iU0 + 1, false, 4, null);
            }
        }
        return arrayList;
    }

    public final String withdrawCheckMessage(Context context) {
        p.i(context, "context");
        String string = context.getString(R$string.policy_sdk_withdraw_check_message);
        p.h(string, "context.getString(R.stri…k_withdraw_check_message)");
        return string;
    }

    public final String withdrawCheckMessageAccount(Context context) {
        p.i(context, "context");
        String string = context.getString(R$string.policy_sdk_withdraw_check_message_account);
        p.h(string, "context.getString(R.stri…aw_check_message_account)");
        return string;
    }

    public final CharSequence withdrawMessage(Context context) {
        p.i(context, "context");
        String string = context.getString(R$string.policy_sdk_withdraw_text_not_basic_not_account);
        p.h(string, "context.getString(R.stri…xt_not_basic_not_account)");
        String string2 = context.getString(R$string.policy_sdk_account_pp_title);
        p.h(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        y yVar = y.f34840a;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2}, 1));
        p.h(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    public final CharSequence withdrawMessageAccount(Context context) {
        p.i(context, "context");
        String string = context.getString(R$string.policy_sdk_withdraw_text_not_basic_has_account);
        p.h(string, "context.getString(R.stri…xt_not_basic_has_account)");
        String string2 = context.getString(R$string.policy_sdk_account_pp_title);
        p.h(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(R$string.policy_sdk_account_center);
        p.h(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        y yVar = y.f34840a;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2));
        p.h(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    public final CharSequence withdrawMessageBasic(Context context) {
        p.i(context, "context");
        String string = context.getString(R$string.policy_sdk_withdraw_text_basic_not_account);
        p.h(string, "context.getString(R.stri…w_text_basic_not_account)");
        String string2 = context.getString(R$string.policy_sdk_account_pp_title);
        p.h(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        y yVar = y.f34840a;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2}, 1));
        p.h(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    public final CharSequence withdrawMessageBasicAccount(Context context) {
        p.i(context, "context");
        String string = context.getString(R$string.policy_sdk_withdraw_text_basic_account);
        p.h(string, "context.getString(R.stri…hdraw_text_basic_account)");
        String string2 = context.getString(R$string.policy_sdk_account_pp_title);
        p.h(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(R$string.policy_sdk_account_center);
        p.h(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        y yVar = y.f34840a;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2));
        p.h(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }
}
