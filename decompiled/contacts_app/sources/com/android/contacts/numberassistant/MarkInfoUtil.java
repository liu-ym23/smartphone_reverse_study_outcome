package com.android.contacts.numberassistant;

import android.content.Context;
import bytedanceos.app.numberassistant.NumberMarkInfo;
import com.android.contacts.ContactsApplication;
import com.android.contacts.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkInfoUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0004J\u0012\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u000102H\u0007J\u0010\u00103\u001a\u0004\u0018\u00010\u001e2\u0006\u00104\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R*\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040,j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/android/contacts/numberassistant/MarkInfoUtil;", "", "()V", "MARK_CLASSIFY_AD_SALES", "", "MARK_CLASSIFY_AD_SALES_OLD", "MARK_CLASSIFY_BLOCKED", "MARK_CLASSIFY_CAR_SERVICE_OLD", "MARK_CLASSIFY_CONTACT", "MARK_CLASSIFY_CRANK_CALL_OLD", "MARK_CLASSIFY_CUSTOMIZE", "MARK_CLASSIFY_DECORATION", "MARK_CLASSIFY_EDUCATION", "MARK_CLASSIFY_EXPRESS", "MARK_CLASSIFY_EXPRESS_OLD", "MARK_CLASSIFY_FRAUD", "MARK_CLASSIFY_HARASSMENT", "MARK_CLASSIFY_HEAD_HUNTER", "MARK_CLASSIFY_HIGH_RISK", "MARK_CLASSIFY_HOUSE_AGENT_OLD", "MARK_CLASSIFY_HOUSE_MARKET", "MARK_CLASSIFY_INSURANCE_FINANCE", "MARK_CLASSIFY_LOAN_PROMOTION", "MARK_CLASSIFY_MEAL_DELIVERY_OLD", "MARK_CLASSIFY_NONE", "MARK_CLASSIFY_OTHER_HIGH_RISK_OLD", "MARK_CLASSIFY_STRANGER", "MARK_CLASSIFY_TAXI", "MARK_CLASSIFY_ZTE_BLACKLIST", "MARK_TYPE_AD_SALES", "", "MARK_TYPE_DECORATION", "MARK_TYPE_EDUCATION", "MARK_TYPE_EXPRESS", "MARK_TYPE_FRAUD", "MARK_TYPE_HARASSMENT", "MARK_TYPE_HEAD_HUNTER", "MARK_TYPE_HIGH_RISK", "MARK_TYPE_HOUSE_MARKET", "MARK_TYPE_INSURANCE_FINANCE", "MARK_TYPE_LOAN_PROMOTION", "MARK_TYPE_TAXI", "TAG", "markClassifyMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getMarkChineseString", "markClassify", "getMarkClassifyChineseString", "numberMarkInfo", "Lbytedanceos/app/numberassistant/NumberMarkInfo;", "getMarkStringType", "markType", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MarkInfoUtil {
    public static final MarkInfoUtil INSTANCE = null;
    public static final int MARK_CLASSIFY_AD_SALES = 2;
    public static final int MARK_CLASSIFY_AD_SALES_OLD = 1;
    public static final int MARK_CLASSIFY_BLOCKED = 67108864;
    public static final int MARK_CLASSIFY_CAR_SERVICE_OLD = 8;
    public static final int MARK_CLASSIFY_CONTACT = 134217728;
    public static final int MARK_CLASSIFY_CRANK_CALL_OLD = 4;
    public static final int MARK_CLASSIFY_CUSTOMIZE = 1073741824;
    public static final int MARK_CLASSIFY_DECORATION = 8192;
    public static final int MARK_CLASSIFY_EDUCATION = 4096;
    public static final int MARK_CLASSIFY_EXPRESS = 8;
    public static final int MARK_CLASSIFY_EXPRESS_OLD = 6;
    public static final int MARK_CLASSIFY_FRAUD = 16;
    public static final int MARK_CLASSIFY_HARASSMENT = 1;
    public static final int MARK_CLASSIFY_HEAD_HUNTER = 32;
    public static final int MARK_CLASSIFY_HIGH_RISK = 128;
    public static final int MARK_CLASSIFY_HOUSE_AGENT_OLD = 5;
    public static final int MARK_CLASSIFY_HOUSE_MARKET = 4;
    public static final int MARK_CLASSIFY_INSURANCE_FINANCE = 256;
    public static final int MARK_CLASSIFY_LOAN_PROMOTION = 512;
    public static final int MARK_CLASSIFY_MEAL_DELIVERY_OLD = 2;
    public static final int MARK_CLASSIFY_NONE = 0;
    public static final int MARK_CLASSIFY_OTHER_HIGH_RISK_OLD = 3;
    public static final int MARK_CLASSIFY_STRANGER = 268435456;
    public static final int MARK_CLASSIFY_TAXI = 64;
    public static final int MARK_CLASSIFY_ZTE_BLACKLIST = 536870912;
    public static final String MARK_TYPE_AD_SALES = "ad_sales";
    public static final String MARK_TYPE_DECORATION = "decoration";
    public static final String MARK_TYPE_EDUCATION = "education";
    public static final String MARK_TYPE_EXPRESS = "express";
    public static final String MARK_TYPE_FRAUD = "fraud";
    public static final String MARK_TYPE_HARASSMENT = "harassment";
    public static final String MARK_TYPE_HEAD_HUNTER = "head_hunter";
    public static final String MARK_TYPE_HIGH_RISK = "high_risk";
    public static final String MARK_TYPE_HOUSE_MARKET = "house_market";
    public static final String MARK_TYPE_INSURANCE_FINANCE = "insurance_finance";
    public static final String MARK_TYPE_LOAN_PROMOTION = "loan_promotion";
    public static final String MARK_TYPE_TAXI = "taxi";
    private static final String TAG = "MarkInfoUtil";
    private static final HashMap<Integer, Integer> markClassifyMap = null;

    public final String getMarkStringType(int r1) {
        if (r1 != 1) goto L5;
        return MARK_TYPE_HARASSMENT;
    L5:
        if (r1 != 2) goto L7;
        return MARK_TYPE_AD_SALES;
    L7:
        if (r1 != 4) goto L9;
        return MARK_TYPE_HOUSE_MARKET;
    L9:
        if (r1 != 8) goto L11;
        return MARK_TYPE_EXPRESS;
    L11:
        if (r1 != 16) goto L13;
        return MARK_TYPE_FRAUD;
    L13:
        if (r1 != 32) goto L15;
        return MARK_TYPE_HEAD_HUNTER;
    L15:
        if (r1 != 64) goto L17;
        return MARK_TYPE_TAXI;
    L17:
        if (r1 != 128) goto L19;
        return MARK_TYPE_HIGH_RISK;
    L19:
        if (r1 != 256) goto L21;
        return MARK_TYPE_INSURANCE_FINANCE;
    L21:
        if (r1 != 512) goto L23;
        return MARK_TYPE_LOAN_PROMOTION;
    L23:
        if (r1 != 4096) goto L25;
        return MARK_TYPE_EDUCATION;
    L25:
        if (r1 == 8192) goto L27;
        return null;
    L27:
        return MARK_TYPE_DECORATION;
    }

    private MarkInfoUtil() {
    }

    static {
        INSTANCE = new MarkInfoUtil();
        HashMap<Integer, Integer> r0 = new HashMap();
        markClassifyMap = r0;
        r0.put(1, Integer.valueOf(R.string.number_mark_classify_harassment));
        r0.put(2, Integer.valueOf(R.string.number_mark_classify_ad_sales));
        r0.put(4, Integer.valueOf(R.string.number_mark_classify_house_market));
        r0.put(8, Integer.valueOf(R.string.number_mark_classify_express));
        r0.put(16, Integer.valueOf(R.string.number_mark_classify_fraud));
        r0.put(32, Integer.valueOf(R.string.number_mark_classify_head_hunter));
        r0.put(64, Integer.valueOf(R.string.number_mark_classify_taxi));
        r0.put(128, Integer.valueOf(R.string.number_mark_classify_high_risk));
        r0.put(256, Integer.valueOf(R.string.number_mark_classify_insurance));
        r0.put(512, Integer.valueOf(R.string.number_mark_classify_loan_promotion));
        r0.put(4096, Integer.valueOf(R.string.number_mark_classify_education));
        r0.put(8192, Integer.valueOf(R.string.number_mark_classify_decoration));
        r0.put(67108864, Integer.valueOf(R.string.number_mark_classify_blocked));
    }

    @JvmStatic
    public static final String getMarkClassifyChineseString(NumberMarkInfo r3) {
        if (r3 == null) goto L17;
        int r1 = r3.getMainMarkClassify();
        if (r1 != 536870912) goto L7;
    L12:
        String r4 = r3.getCustomizeMarkString();
    L13:
        if (r4 != null) goto L16;
        return "";
    L16:
        return r4;
    L7:
        if (r1 == 1073741824) goto L12;
        Integer r5 = markClassifyMap.get(Integer.valueOf(r1));
        if (r5 == null) goto L11;
        Context r2 = ContactsApplication.getInstance().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r5, "it");
        r4 = r2.getString(r5.intValue());
        goto L13
    L11:
        r4 = null;
        goto L13
    L17:
        return "";
    }

    public final String getMarkChineseString(int r1) {
        Integer r0 = markClassifyMap.get(Integer.valueOf(r1));
        if (r0 == null) goto L5;
        String r2 = ContactsApplication.getInstance().getApplicationContext().getString(r0.intValue());
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }
}
