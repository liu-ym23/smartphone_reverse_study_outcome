package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import com.android.contacts.R;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AccountType {
    private static final String TAG = "AccountType";
    private static Comparator<DataKind> sWeightComparator;
    public String accountType;
    public String dataSet;
    public int iconRes;
    protected boolean mIsInitialized;
    private ArrayList<DataKind> mKinds;
    private HashMap<String, DataKind> mMimeKinds;
    public String resPackageName;
    public String summaryResPackageName;
    public int titleRes;

    protected static class DefinitionException extends Exception {
        public DefinitionException(String r1) {
            super(r1);
        }

        public DefinitionException(String r1, Exception r2) {
            super(r1, r2);
        }
    }

    public static class DisplayLabelComparator implements Comparator<AccountType> {
        private final Collator mCollator;
        private final Context mContext;

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(AccountType r1, AccountType r2) {
            return compare2(r1, r2);
        }

        public DisplayLabelComparator(Context r2) {
            this.mCollator = Collator.getInstance();
            this.mContext = r2;
        }

        private String getDisplayLabel(AccountType r1) {
            CharSequence r0 = r1.getDisplayLabel(this.mContext);
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0.toString();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(AccountType r2, AccountType r3) {
            return this.mCollator.compare(getDisplayLabel(r2), getDisplayLabel(r3));
        }
    }

    public static final class EditField {
        public String column;
        public int inputType;
        public boolean longForm;
        public int minLines;
        public boolean optional;
        public boolean shortForm;
        public int titleRes;

        public EditField(String r1, int r2) {
            this.column = r1;
            this.titleRes = r2;
        }

        public EditField(String r1, int r2, int r3) {
            this(r1, r2);
            this.inputType = r3;
        }

        public EditField setOptional(boolean r1) {
            this.optional = r1;
            return this;
        }

        public EditField setShortForm(boolean r1) {
            this.shortForm = r1;
            return this;
        }

        public EditField setLongForm(boolean r1) {
            this.longForm = r1;
            return this;
        }

        public EditField setMinLines(int r1) {
            this.minLines = r1;
            return this;
        }

        public boolean isMultiLine() {
            if ((this.inputType & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return getClass().getSimpleName() + ": column=" + this.column + " titleRes=" + this.titleRes + " inputType=" + this.inputType + " minLines=" + this.minLines + " optional=" + this.optional + " shortForm=" + this.shortForm + " longForm=" + this.longForm;
        }
    }

    public static class EditType {
        public String customColumn;
        public boolean disappearWhenUserAdd;
        public int labelRes;
        public int rawValue;
        public boolean secondary;
        public int specificMax;

        public EditType(int r2, int r3) {
            this.disappearWhenUserAdd = false;
            this.rawValue = r2;
            this.labelRes = r3;
            this.specificMax = -1;
        }

        public EditType setSecondary(boolean r1) {
            this.secondary = r1;
            return this;
        }

        public EditType setSpecificMax(int r1) {
            this.specificMax = r1;
            return this;
        }

        public EditType setCustomColumn(String r1) {
            this.customColumn = r1;
            return this;
        }

        public EditType setDisappearWhenUserAdd(boolean r1) {
            this.disappearWhenUserAdd = r1;
            return this;
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof EditType) == true) goto L5;
            return false;
        L5:
            if (((EditType) r3).rawValue != this.rawValue) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.rawValue;
        }

        public String toString() {
            return getClass().getSimpleName() + " rawValue=" + this.rawValue + " labelRes=" + this.labelRes + " secondary=" + this.secondary + " specificMax=" + this.specificMax + " customColumn=" + this.customColumn;
        }
    }

    public static class EventEditType extends EditType {
        private boolean mYearOptional;

        public EventEditType(int r1, int r2) {
            super(r1, r2);
        }

        public boolean isYearOptional() {
            return this.mYearOptional;
        }

        public EventEditType setYearOptional(boolean r1) {
            this.mYearOptional = r1;
            return this;
        }

        @Override // com.android.contacts.model.AccountType.EditType
        public String toString() {
            return super.toString() + " mYearOptional=" + this.mYearOptional;
        }
    }

    public interface StringInflater {
        CharSequence inflateUsing(Context r1, ContentValues r2);

        CharSequence inflateUsing(Context r1, Cursor r2);
    }

    public abstract boolean areContactsWritable();

    public String getCreateContactActivityClassName() {
        return null;
    }

    public String getEditContactActivityClassName() {
        return null;
    }

    protected int getInviteContactActionResId() {
        return -1;
    }

    public String getInviteContactActivityClassName() {
        return null;
    }

    public String getViewContactNotifyServiceClassName() {
        return null;
    }

    public String getViewGroupActivity() {
        return null;
    }

    protected int getViewGroupLabelResId() {
        return -1;
    }

    public String getViewStreamItemActivity() {
        return null;
    }

    public String getViewStreamItemPhotoActivity() {
        return null;
    }

    public boolean isEmbedded() {
        return true;
    }

    public boolean isExtension() {
        return false;
    }

    public abstract boolean isGroupMembershipEditable();

    public AccountType() {
        this.accountType = null;
        this.dataSet = null;
        this.mKinds = Lists.newArrayList();
        this.mMimeKinds = Maps.newHashMap();
    }

    public final boolean isInitialized() {
        return this.mIsInitialized;
    }

    public CharSequence getDisplayLabel(Context r3) {
        return getResourceText(r3, this.summaryResPackageName, this.titleRes, this.accountType);
    }

    public AccountTypeWithDataSet getAccountTypeAndDataSet() {
        return AccountTypeWithDataSet.get(this.accountType, this.dataSet);
    }

    public List<String> getExtensionPackageNames() {
        return new ArrayList();
    }

    public CharSequence getInviteContactActionLabel(Context r3) {
        return getResourceText(r3, this.summaryResPackageName, getInviteContactActionResId(), "");
    }

    public CharSequence getViewGroupLabel(Context r3) {
        CharSequence r2 = getResourceText(r3, this.summaryResPackageName, getViewGroupLabelResId(), null);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return r3.getText(R.string.view_updates_from_group);
    }

    static CharSequence getResourceText(Context r1, String r2, int r3, String r4) {
        if (r3 == (-1)) goto L7;
        if (r2 == null) goto L7;
        return r1.getPackageManager().getText(r2, r3, null);
    L7:
        if (r3 != (-1)) goto L9;
        return r4;
    L9:
        return r1.getText(r3);
    }

    public Drawable getDisplayIcon(Context r5) {
        int r0 = this.titleRes;
        if (r0 != (-1)) goto L5;
    L8:
        if (r0 != (-1)) goto L10;
        return null;
    L10:
        return r5.getResources().getDrawable(this.iconRes);
    L5:
        if (this.summaryResPackageName == null) goto L8;
        return r5.getPackageManager().getDrawable(this.summaryResPackageName, this.iconRes, null);
    }

    static {
        sWeightComparator = new AnonymousClass1();
    }

    public ArrayList<DataKind> getSortedDataKinds() {
        return this.mKinds;
    }

    public DataKind getKindForMimetype(String r1) {
        return this.mMimeKinds.get(r1);
    }

    public DataKind addKind(DataKind r3) throws DefinitionException {
        if (r3.mimeType == null) goto L11;
        if (this.mMimeKinds.get(r3.mimeType) != null) goto L9;
        r3.resPackageName = this.resPackageName;
        this.mKinds.add(r3);
        this.mMimeKinds.put(r3.mimeType, r3);
        return r3;
    L9:
        throw new DefinitionException("mime type '" + r3.mimeType + "' is already registered");
    L11:
        throw new DefinitionException("null is not a valid mime type");
    }
}
