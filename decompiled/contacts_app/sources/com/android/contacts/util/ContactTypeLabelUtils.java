package com.android.contacts.util;

import android.content.Context;
import android.text.TextUtils;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ContactTypeLabelUtils {
    public static int getEmailTypeLabelResource(int r1) {
        if (r1 != 1) goto L5;
        return R.string.common_home;
    L5:
        if (r1 != 2) goto L7;
        return R.string.common_work;
    L7:
        if (r1 != 3) goto L9;
        return R.string.common_other;
    L9:
        if (r1 == 4) goto L12;
        return R.string.common_custom;
    L12:
        return R.string.common_mobile;
    }

    public static int getOrganizationTypeLabelResource(int r1) {
        if (r1 != 1) goto L5;
        return R.string.common_work;
    L5:
        if (r1 == 2) goto L8;
        return R.string.common_custom;
    L8:
        return R.string.orgTypeOther;
    }

    public static int getPhoneTypeLabelResource(int r0) {
        switch(r0) {
            case 0: goto L45;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return R.string.common_phone;
    L5:
        return R.string.editor_phone_type_mms;
    L7:
        return R.string.common_assistant;
    L9:
        return R.string.editor_phone_type_work_pager;
    L11:
        return R.string.editor_phone_type_work_mobile;
    L13:
        return R.string.editor_phone_type_tty_tdd;
    L15:
        return R.string.editor_phone_type_telex;
    L17:
        return R.string.editor_phone_type_radio;
    L19:
        return R.string.editor_phone_type_other_fax;
    L21:
        return R.string.editor_phone_type_main;
    L23:
        return R.string.editor_phone_type_isdn;
    L25:
        return R.string.editor_phone_type_company_main;
    L27:
        return R.string.editor_phone_type_car;
    L29:
        return R.string.editor_phone_type_callback;
    L31:
        return R.string.common_other;
    L33:
        return R.string.editor_phone_type_pager;
    L35:
        return R.string.editor_phone_type_fax_home;
    L37:
        return R.string.editor_phone_type_fax_work;
    L39:
        return R.string.common_work;
    L41:
        return R.string.common_mobile;
    L43:
        return R.string.common_home;
    L45:
        return R.string.common_custom;
    }

    public static int getPostalTypeLabelResource(int r1) {
        if (r1 != 1) goto L5;
        return R.string.common_home;
    L5:
        if (r1 != 2) goto L7;
        return R.string.common_work;
    L7:
        if (r1 == 3) goto L10;
        return R.string.common_custom;
    L10:
        return R.string.common_other;
    }

    public static int getRelationTypeLabelResource(int r0) {
        switch(r0) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            case 13: goto L7;
            case 14: goto L5;
            default: goto L3;
        };
    L3:
        return R.string.common_custom;
    L5:
        return R.string.editor_relation_type_spouse;
    L7:
        return R.string.editor_relation_type_sister;
    L9:
        return R.string.editor_relation_type_relative;
    L11:
        return R.string.editor_relation_type_referred_by;
    L13:
        return R.string.editor_relation_type_partner;
    L15:
        return R.string.editor_relation_type_parent;
    L17:
        return R.string.editor_relation_type_mother;
    L19:
        return R.string.editor_relation_type_manager;
    L21:
        return R.string.editor_relation_type_friend;
    L23:
        return R.string.editor_relation_type_father;
    L25:
        return R.string.editor_relation_type_domestic_partner;
    L27:
        return R.string.editor_relation_type_child;
    L29:
        return R.string.editor_relation_type_brother;
    L31:
        return R.string.common_assistant;
    }

    private ContactTypeLabelUtils() {
    }

    public static CharSequence getPhoneTypeLabel(Context r1, Integer r2, CharSequence r3) {
        if (r2 != null) goto L4;
        int r4 = 7;
    L5:
        if (r4 != 0) goto L10;
        if (TextUtils.isEmpty(r3) == true) goto L10;
        return r3;
    L10:
        return r1.getText(getPhoneTypeLabelResource(r4));
    L4:
        r4 = r2.intValue();
        goto L5
    }

    public static CharSequence getEmailTypeLabel(Context r1, Integer r2, CharSequence r3) {
        if (r2 != null) goto L4;
        int r4 = 3;
    L5:
        if (r4 != 0) goto L10;
        if (TextUtils.isEmpty(r3) == true) goto L10;
        return r3;
    L10:
        return r1.getText(getEmailTypeLabelResource(r4));
    L4:
        r4 = r2.intValue();
        goto L5
    }

    public static CharSequence getPostalTypeLabel(Context r1, Integer r2, CharSequence r3) {
        if (r2 != null) goto L4;
        int r4 = 3;
    L5:
        if (r4 != 0) goto L10;
        if (TextUtils.isEmpty(r3) == true) goto L10;
        return r3;
    L10:
        return r1.getText(getPostalTypeLabelResource(r4));
    L4:
        r4 = r2.intValue();
        goto L5
    }

    public static CharSequence getOrganizationTypeLabel(Context r1, Integer r2, CharSequence r3) {
        if (r2 != null) goto L4;
        int r4 = 1;
    L5:
        if (r4 != 0) goto L10;
        if (TextUtils.isEmpty(r3) == true) goto L10;
        return r3;
    L10:
        return r1.getText(getOrganizationTypeLabelResource(r4));
    L4:
        r4 = r2.intValue();
        goto L5
    }

    public static CharSequence getRelationTypeLabel(Context r1, Integer r2, CharSequence r3) {
        if (r2 != null) goto L4;
        int r4 = 0;
    L5:
        if (r4 != 0) goto L10;
        if (TextUtils.isEmpty(r3) == true) goto L10;
        return r3;
    L10:
        return r1.getText(getRelationTypeLabelResource(r4));
    L4:
        r4 = r2.intValue();
        goto L5
    }
}
