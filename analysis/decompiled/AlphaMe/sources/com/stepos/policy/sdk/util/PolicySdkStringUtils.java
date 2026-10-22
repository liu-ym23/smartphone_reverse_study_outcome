package com.stepos.policy.sdk.util;

import F1.n;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkStringUtils;", "", "()V", "ACCOUNT_CENTER_URL", "", "getDeleteInfoListFromServiceConfig", "", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "policyServiceConfigList", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigBean;", "policyWithdrawCustomTerms", "", "withdrawMsg", "searchAllIndex", "", "", "content", "chars", "withdrawCheckMessage", "withdrawCheckMessageAccount", "withdrawMessage", "withdrawMessageAccount", "withdrawMessageBasic", "withdrawMessageBasicAccount", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPolicySdkStringUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicySdkStringUtils.kt\ncom/stepos/policy/sdk/util/PolicySdkStringUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,234:1\n1549#2:235\n1620#2,2:236\n1271#2,2:238\n1285#2,4:240\n1622#2:245\n1#3:244\n*S KotlinDebug\n*F\n+ 1 PolicySdkStringUtils.kt\ncom/stepos/policy/sdk/util/PolicySdkStringUtils\n*L\n26#1:235\n26#1:236,2\n29#1:238,2\n29#1:240,4\n26#1:245\n*E\n"})
/* loaded from: classes.dex */
public final class PolicySdkStringUtils {

    @NotNull
    public static final String ACCOUNT_CENTER_URL = "https://service.zyql.com/fac.html?source=config";

    @NotNull
    public static final PolicySdkStringUtils INSTANCE = new PolicySdkStringUtils();

    private PolicySdkStringUtils() {
    }

    @NotNull
    public final List<DeleteInfoBean> getDeleteInfoListFromServiceConfig(@NotNull Context context, @NotNull List<PolicyServiceConfigBean> policyServiceConfigList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(policyServiceConfigList, "policyServiceConfigList");
        ArrayList arrayList = new ArrayList();
        n nVar = new n();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.e(policyServiceConfigList));
        for (PolicyServiceConfigBean policyServiceConfigBean : policyServiceConfigList) {
            if (Intrinsics.areEqual(policyServiceConfigBean.getBusinessType(), "phone")) {
                List listSorted = CollectionsKt.sorted(StringsKt__StringsKt.split$default(policyServiceConfigBean.getIdType(), new String[]{"&"}, false, 0, 6, (Object) null));
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.e(listSorted)), 16));
                for (Object obj : listSorted) {
                    linkedHashMap.put(obj, "");
                }
                HashMap map = new HashMap();
                map.put("provider", context.getPackageName());
                String extra = nVar.g(map);
                Intrinsics.checkNotNullExpressionValue(extra, "extra");
                String keyInfoJson = nVar.g(new KeyInfo("", "-1", "-1", extra));
                String strValueOf = String.valueOf(policyServiceConfigBean.getServiceId());
                String strG = nVar.g(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(strG, "gson.toJson(bindId)");
                Intrinsics.checkNotNullExpressionValue(keyInfoJson, "keyInfoJson");
                arrayList.add(new DeleteInfoBean(strValueOf, strG, keyInfoJson));
            }
            arrayList2.add(Unit.INSTANCE);
        }
        return arrayList;
    }

    @NotNull
    public final CharSequence policyWithdrawCustomTerms(@NotNull final Context context, @NotNull String withdrawMsg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(withdrawMsg, "withdrawMsg");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final String string = context.getString(R.string.policy_sdk_account_pp_title);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_message);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…y_sdk_account_pp_message)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        String string4 = context.getString(R.string.policy_sdk_withdraw_text_notify);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…sdk_withdraw_text_notify)");
        String str = withdrawMsg + string4;
        spannableStringBuilder.append((CharSequence) str);
        if (StringsKt.c(str, string2)) {
            Iterator<Integer> it = searchAllIndex(str, string2).iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                final String str2 = "pp";
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        PolicySdk.openPolicyByMethod(context, Boolean.TRUE, string, str2);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NotNull TextPaint ds) {
                        Intrinsics.checkNotNullParameter(ds, "ds");
                        super.updateDrawState(ds);
                        ds.setUnderlineText(false);
                    }
                }, iIntValue, string2.length() + iIntValue, 34);
            }
        }
        if (StringsKt.c(str, string3)) {
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default(str, string3, 0, false, 6, (Object) null);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.stepos.policy.sdk.util.PolicySdkStringUtils.policyWithdrawCustomTerms.2
                @Override // android.text.style.ClickableSpan
                public void onClick(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    PolicySdkToolsUtils.INSTANCE.startBrowser(context, PolicySdkStringUtils.ACCOUNT_CENTER_URL);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NotNull TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }
            }, iIndexOf$default, string3.length() + iIndexOf$default, 34);
        }
        if (StringsKt.c(str, string4)) {
            StringsKt__StringsKt.indexOf$default(str, string4, 0, false, 6, (Object) null);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final List<Integer> searchAllIndex(@Nullable String content, @NotNull String chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        ArrayList arrayList = new ArrayList();
        if (content != null && content.length() != 0) {
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default(content, chars, 0, false, 6, (Object) null);
            while (iIndexOf$default != -1) {
                arrayList.add(Integer.valueOf(iIndexOf$default));
                iIndexOf$default = StringsKt__StringsKt.indexOf$default(content, chars, iIndexOf$default + 1, false, 4, (Object) null);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String withdrawCheckMessage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_check_message);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…k_withdraw_check_message)");
        return string;
    }

    @NotNull
    public final String withdrawCheckMessageAccount(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_check_message_account);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…aw_check_message_account)");
        return string;
    }

    @NotNull
    public final CharSequence withdrawMessage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_not_basic_not_account);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…xt_not_basic_not_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    @NotNull
    public final CharSequence withdrawMessageAccount(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_not_basic_has_account);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…xt_not_basic_has_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    @NotNull
    public final CharSequence withdrawMessageBasic(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_basic_not_account);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…w_text_basic_not_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }

    @NotNull
    public final CharSequence withdrawMessageBasicAccount(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.policy_sdk_withdraw_text_basic_account);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…hdraw_text_basic_account)");
        String string2 = context.getString(R.string.policy_sdk_account_pp_title);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…icy_sdk_account_pp_title)");
        String string3 = context.getString(R.string.policy_sdk_account_center);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…olicy_sdk_account_center)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(string, Arrays.copyOf(new Object[]{string2, string3}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return policyWithdrawCustomTerms(context, str);
    }
}
