package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import android.content.Context;
import com.android.contacts.common.model.account.AccountType;
import com.google.common.collect.Iterators;
import java.text.SimpleDateFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DataKind {
    public static final String PSEUDO_COLUMN_PHONETIC_NAME = "#phoneticName";
    public static final String PSEUDO_MIME_TYPE_DISPLAY_NAME = "#displayName";
    public static final String PSEUDO_MIME_TYPE_PHONETIC_NAME = "#phoneticName";
    public AccountType.StringInflater actionAltHeader;
    public AccountType.StringInflater actionBody;
    public AccountType.StringInflater actionHeader;
    public SimpleDateFormat dateFormatWithYear;
    public SimpleDateFormat dateFormatWithoutYear;
    public ContentValues defaultValues;
    public boolean editable;
    public List<AccountType.EditField> fieldList;
    public int iconAltDescriptionRes;
    public int iconAltRes;
    public int maxLinesForDisplay;
    public String mimeType;
    public String resourcePackageName;
    public int titleRes;
    public String typeColumn;
    public List<AccountType.EditType> typeList;
    public int typeOverallMax;
    public int weight;

    public DataKind() {
        this.maxLinesForDisplay = 1;
    }

    public DataKind(String r1, int r2, int r3, boolean r4) {
        this.mimeType = r1;
        this.titleRes = r2;
        this.weight = r3;
        this.editable = r4;
        this.typeOverallMax = -1;
        this.maxLinesForDisplay = 1;
    }

    public String getKindString(Context r2) {
        int r1 = this.titleRes;
        if (r1 == (-1)) goto L7;
        if (r1 == 0) goto L7;
        return r2.getString(r1);
    L7:
        return "";
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("DataKind: resPackageName=");
        r0.append(this.resourcePackageName);
        r0.append(" mimeType=").append(this.mimeType);
        r0.append(" titleRes=").append(this.titleRes);
        r0.append(" iconAltRes=").append(this.iconAltRes);
        r0.append(" iconAltDescriptionRes=").append(this.iconAltDescriptionRes);
        r0.append(" weight=").append(this.weight);
        r0.append(" editable=").append(this.editable);
        r0.append(" actionHeader=").append(this.actionHeader);
        r0.append(" actionAltHeader=").append(this.actionAltHeader);
        r0.append(" actionBody=").append(this.actionBody);
        r0.append(" typeColumn=").append(this.typeColumn);
        r0.append(" typeOverallMax=").append(this.typeOverallMax);
        r0.append(" typeList=").append(toString(this.typeList));
        r0.append(" fieldList=").append(toString(this.fieldList));
        r0.append(" defaultValues=").append(this.defaultValues);
        r0.append(" dateFormatWithoutYear=").append(toString(this.dateFormatWithoutYear));
        r0.append(" dateFormatWithYear=").append(toString(this.dateFormatWithYear));
        return r0.toString();
    }

    public static String toString(SimpleDateFormat r0) {
        if (r0 != null) goto L5;
        return "(null)";
    L5:
        return r0.toPattern();
    }

    public static String toString(Iterable<?> r0) {
        if (r0 != null) goto L6;
        return "(null)";
    L6:
        return Iterators.toString(r0.iterator());
    }
}
