package com.stepos.policy.sdk.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.R;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import hc.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jb.v;
import kb.l;
import kb.m;
import kb.x;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkStringUtils {
    public static final String ACCOUNT_CENTER_URL = "https://service.zyql.com/fac.html?source=config";
    public static final PolicySdkStringUtils INSTANCE = new PolicySdkStringUtils();

    private PolicySdkStringUtils() {
    }

    public final List<DeleteInfoBean> getDeleteInfoListFromServiceConfig(Context context, List<PolicyServiceConfigBean> list) {
        context.getClass();
        list.getClass();
        ArrayList arrayList = new ArrayList();
        m7.e eVar = new m7.e();
        ArrayList arrayList2 = new ArrayList(m.m0(list, 10));
        for (PolicyServiceConfigBean policyServiceConfigBean : list) {
            if (k.a(policyServiceConfigBean.getBusinessType(), "phone")) {
                List listH0 = l.H0(h.o0(policyServiceConfigBean.getIdType(), new String[]{"&"}));
                int iL = x.L(m.m0(listH0, 10));
                if (iL < 16) {
                    iL = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
                for (Object obj : listH0) {
                    linkedHashMap.put(obj, "");
                }
                HashMap map = new HashMap();
                map.put("provider", context.getPackageName());
                arrayList.add(new DeleteInfoBean(String.valueOf(policyServiceConfigBean.getServiceId()), eVar.e(linkedHashMap), eVar.e(new KeyInfo("", "-1", "-1", eVar.e(map)))));
            }
            arrayList2.add(v.f6774a);
        }
        return arrayList;
    }

    public final CharSequence policyWithdrawCustomTerms(final Context context, String str) {
        context.getClass();
        str.getClass();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final String string = context.getString(R.string.policy_sdk_account_pp_title);
        string.getClass();
        String string2 = context.getString(R.string.policy_sdk_account_pp_message);
        string2.getClass();
        String string3 = context.getString(R.string.policy_sdk_account_center);
        string3.getClass();
        String string4 = context.getString(R.string.policy_sdk_withdraw_text_notify);
        string4.getClass();
        String strConcat = str.concat(string4);
        spannableStringBuilder.append((CharSequence) strConcat);
        if (h.X(strConcat, string2, false)) {
            Iterator<Integer> it = searchAllIndex(strConcat, string2).iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                final String str2 = "pp";
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        view.getClass();
                        PolicySdk.openPolicyByMethod(context, Boolean.TRUE, string, str2);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.getClass();
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }
                }, iIntValue, string2.length() + iIntValue, 34);
            }
        }
        if (h.X(strConcat, string3, false)) {
            int iE0 = h.e0(strConcat, string3, 0, false, 6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    view.getClass();
                    PolicySdkToolsUtils.Companion.startBrowser(context, PolicySdkStringUtils.ACCOUNT_CENTER_URL);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.getClass();
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            }, iE0, string3.length() + iE0, 34);
        }
        if (h.X(strConcat, string4, false)) {
            h.e0(strConcat, string4, 0, false, 6);
        }
        return spannableStringBuilder;
    }

    public final List<Integer> searchAllIndex(String str, String str2) {
        str2.getClass();
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() != 0) {
            int iE0 = h.e0(str, str2, 0, false, 6);
            while (iE0 != -1) {
                arrayList.add(Integer.valueOf(iE0));
                iE0 = h.e0(str, str2, iE0 + 1, false, 4);
            }
        }
        return arrayList;
    }

    public final String withdrawCheckMessage(Context context) {
        context.getClass();
        String string = context.getString(R.string.policy_sdk_withdraw_check_message);
        string.getClass();
        return string;
    }

    public final String withdrawCheckMessageAccount(Context context) {
        context.getClass();
        String string = context.getString(R.string.policy_sdk_withdraw_check_message_account);
        string.getClass();
        return string;
    }

    public final CharSequence withdrawMessage(Context context) {
        context.getClass();
        String string = context.getString(R.string.policy_sdk_withdraw_text_not_basic_not_account);
        string.getClass();
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        string2.getClass();
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2}, 1)));
    }

    public final CharSequence withdrawMessageAccount(Context context) {
        context.getClass();
        String string = context.getString(R.string.policy_sdk_withdraw_text_not_basic_has_account);
        string.getClass();
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        string2.getClass();
        String string3 = context.getString(R.string.policy_sdk_account_center);
        string3.getClass();
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2)));
    }

    public final CharSequence withdrawMessageBasic(Context context) {
        context.getClass();
        String string = context.getString(R.string.policy_sdk_withdraw_text_basic_not_account);
        string.getClass();
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        string2.getClass();
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2}, 1)));
    }

    public final CharSequence withdrawMessageBasicAccount(Context context) {
        context.getClass();
        String string = context.getString(R.string.policy_sdk_withdraw_text_basic_account);
        string.getClass();
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        string2.getClass();
        String string3 = context.getString(R.string.policy_sdk_account_center);
        string3.getClass();
        return policyWithdrawCustomTerms(context, String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2)));
    }
}
