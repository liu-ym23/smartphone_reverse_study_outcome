package com.android.contacts.list;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class FavoriteContact implements Comparable<FavoriteContact> {
    public static RuleBasedCollator ruleBasedCollator;
    public String LookKey;
    public long contactid;
    public long id;
    public boolean ischoosed;
    public String label;
    public String name;
    public String nameFirstLetter;
    public String normalized_number;
    public String number;
    public String phone;
    public CharSequence phoneNumType;
    public long photoId;
    public int position;
    public long raw_contactid;
    public int type;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FavoriteContact r1) {
        return compareTo2(r1);
    }

    public FavoriteContact() {
        this.name = "";
        this.nameFirstLetter = "";
        this.phone = "";
        this.type = 0;
        this.label = null;
        this.number = "";
        this.LookKey = "";
        this.normalized_number = "";
        this.contactid = 0;
        this.ischoosed = false;
        this.photoId = -1;
        this.position = 0;
        this.id = 0;
    }

    static {
        ruleBasedCollator = (RuleBasedCollator) Collator.getInstance(Locale.CHINA);
    }

    public String toString() {
        return String.format(" type :%s; \n name :%s;\n  nameFirstLetter :%s;\n  phone :%s;\n  labelres :%s;\n  label :%s;\n  number :%s;\n  lookupkey :%s;\n  normalized_number :%s;\n  raw_contactid :%s;\n  phoneNumType :%s;\n  contactid :%s;\n  ischoosed :%s;\n  photoId :%s;\n  position :%s;\n  id :%s;\n ", new Object[]{Integer.valueOf(this.type), this.name, this.nameFirstLetter, this.phone, Integer.valueOf(this.type), this.label, this.number, this.LookKey, this.normalized_number, Long.valueOf(this.raw_contactid), this.phoneNumType, Long.valueOf(this.contactid), Boolean.valueOf(this.ischoosed), Long.valueOf(this.photoId), Integer.valueOf(this.position), Long.valueOf(this.id)});
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FavoriteContact r1) {
        String r0 = this.nameFirstLetter;
        if (r0 == null) goto L9;
        String r2 = r1.nameFirstLetter;
        if (r2 != null) goto L8;
        return 0;
    L8:
        return r0.compareTo(r2);
    L9:
        return 0;
    }
}
