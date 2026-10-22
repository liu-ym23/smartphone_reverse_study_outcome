package com.android.contacts.model;

import android.content.ContentValues;
import com.android.contacts.R;
import com.google.common.collect.Iterators;
import java.text.SimpleDateFormat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DataKind {
    public static final String PSEUDO_COLUMN_PHONETIC_NAME = "#phoneticName";
    public static final String PSEUDO_MIME_TYPE_DISPLAY_NAME = "#displayName";
    public static final String PSEUDO_MIME_TYPE_PHONETIC_NAME = "#phoneticName";
    public AccountType.StringInflater actionAltHeader;
    public AccountType.StringInflater actionBody;
    public boolean actionBodySocial;
    public AccountType.StringInflater actionHeader;
    public SimpleDateFormat dateFormatWithYear;
    public SimpleDateFormat dateFormatWithoutYear;
    public ContentValues defaultValues;
    public boolean editable;
    public final int editorLayoutResourceId;
    public List<AccountType.EditField> fieldList;
    public int iconAltDescriptionRes;
    public int iconAltRes;
    public String mimeType;
    public String resPackageName;
    public int titleRes;
    public String typeColumn;
    public List<AccountType.EditType> typeList;
    public int typeOverallMax;
    public int weight;

    public DataKind() {
        this.actionBodySocial = false;
        this.editorLayoutResourceId = R.layout.text_fields_editor_view;
    }

    public DataKind(String r2, int r3, int r4, boolean r5, int r6) {
        this.actionBodySocial = false;
        this.mimeType = r2;
        this.titleRes = r3;
        this.weight = r4;
        this.editable = r5;
        this.typeOverallMax = -1;
        this.editorLayoutResourceId = r6;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("DataKind: resPackageName=");
        r0.append(this.resPackageName);
        r0.append(" mimeType=").append(this.mimeType);
        r0.append(" titleRes=").append(this.titleRes);
        r0.append(" iconAltRes=").append(this.iconAltRes);
        r0.append(" iconAltDescriptionRes=").append(this.iconAltDescriptionRes);
        r0.append(" weight=").append(this.weight);
        r0.append(" editable=").append(this.editable);
        r0.append(" actionHeader=").append(this.actionHeader);
        r0.append(" actionAltHeader=").append(this.actionAltHeader);
        r0.append(" actionBody=").append(this.actionBody);
        r0.append(" actionBodySocial=").append(this.actionBodySocial);
        r0.append(" typeColumn=").append(this.typeColumn);
        r0.append(" typeOverallMax=").append(this.typeOverallMax);
        r0.append(" typeList=").append(toString(this.typeList));
        r0.append(" fieldList=").append(toString(this.fieldList));
        r0.append(" defaultValues=").append(this.defaultValues);
        r0.append(" editorLayoutResourceId=").append(this.editorLayoutResourceId);
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
