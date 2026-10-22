package com.android.ttcjpaysdk.thirdparty.data;

import android.content.Context;
import android.text.TextUtils;
import com.larus.nova.R;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum CJPayIdType extends Enum<CJPayIdType> {
    private static final /* synthetic */ CJPayIdType[] $VALUES = null;
    public static final CJPayIdType HK_MACAU = null;
    public static final CJPayIdType HK_MACAU_RESIDENCE = null;
    public static final CJPayIdType MAINLAND = null;
    public static final CJPayIdType PASSPORT = null;
    public static final CJPayIdType TAIWAN = null;
    public static final CJPayIdType TAIWAN_RESIDENCE = null;
    public final String key;
    public final String label;
    public final int nameRes;

    private static /* synthetic */ CJPayIdType[] $values() {
        return new CJPayIdType[]{MAINLAND, HK_MACAU, TAIWAN, PASSPORT, HK_MACAU_RESIDENCE, TAIWAN_RESIDENCE};
    }

    static {
        MAINLAND = new CJPayIdType("MAINLAND", 0, "ID_CARD", "ID_CARD", R.string.cj_pay_add_new_bank_card_id_mainland);
        HK_MACAU = new CJPayIdType("HK_MACAU", 1, "HKMPASS", "HKMPASS", R.string.cj_pay_add_new_bank_card_id_hk_macau);
        TAIWAN = new CJPayIdType("TAIWAN", 2, "TAIWANPASS", "TAIWANPASS", R.string.cj_pay_add_new_bank_card_id_taiwan);
        PASSPORT = new CJPayIdType("PASSPORT", 3, "PASSPORT", "PASSPORT", R.string.cj_pay_add_new_bank_card_id_passport);
        HK_MACAU_RESIDENCE = new CJPayIdType("HK_MACAU_RESIDENCE", 4, "HK_MACAU_RESIDENCE", "ID_CARD", R.string.cj_pay_add_new_bank_card_id_hk_macau_residence);
        TAIWAN_RESIDENCE = new CJPayIdType("TAIWAN_RESIDENCE", 5, "TAIWAN_RESIDENCE", "ID_CARD", R.string.cj_pay_add_new_bank_card_id_taiwan_residence);
        $VALUES = $values();
    }

    public static CJPayIdType[] values() {
        return (CJPayIdType[]) $VALUES.clone();
    }

    public static CJPayIdType getTypeFromIdCode(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -632765991: goto L18;
            case 1696501435: goto L14;
            case 1999404050: goto L10;
            default: goto L21;
        };
    L21:
        switch(r101) {
            case 0: goto L29;
            case 1: goto L27;
            case 2: goto L25;
            default: goto L23;
        };
    L23:
        return MAINLAND;
    L25:
        return PASSPORT;
    L27:
        return HK_MACAU;
    L29:
        return TAIWAN;
    L10:
        if (r100.equals("PASSPORT") == false) goto L21;
        r101 = 2;
        goto L21
    L14:
        if (r100.equals("HKMPASS") == false) goto L21;
        r101 = 1;
        goto L21
    L18:
        if (r100.equals("TAIWANPASS") == false) goto L21;
        r101 = 0;
        goto L21
    L5:
        return MAINLAND;
    }

    public static CJPayIdType getTypeFromLabel(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        CJPayIdType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        CJPayIdType r104 = r101[r103];
        if (r104.label.equals(r100) == true) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return r104;
    L13:
        return MAINLAND;
    L5:
        return MAINLAND;
    }

    public static CJPayIdType valueOf(String r100) {
        return (CJPayIdType) a.a(CJPayIdType.class, r100);
    }

    public static String getIdNameFromType(Context r100, CJPayIdType r101) {
        if (r101 == null) goto L6;
        return r100.getString(r101.nameRes);
    L6:
        return r100.getString(MAINLAND.nameRes);
    }

    public static CJPayIdType getTypeFromIdName(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        CJPayIdType[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        CJPayIdType r105 = r102[r104];
        if (r100.getString(r105.nameRes).equals(r101) == true) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        return r105;
    L13:
        return MAINLAND;
    L5:
        return MAINLAND;
    }

    private CJPayIdType(String r100, int r101, String r102, String r103, int r104) {
        super(r100, r101);
        this.label = r102;
        this.key = r103;
        this.nameRes = r104;
    }
}
