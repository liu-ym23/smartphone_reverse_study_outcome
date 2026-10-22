package com.android.contacts.setting;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.list.ContactBaseData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class AggregationSuggestionUnit extends ContactBaseData {
    public static final int MATCH_EMAIL = 1;
    public static final int MATCH_NAME = 3;
    public static final int MATCH_NONE = 0;
    public static final int MATCH_NUMBER = 2;
    private boolean checked;
    private long contactId;
    private String displayName;
    private boolean displayOrderPrimary;
    private List<String> emails;
    private String familyName;
    private boolean firstCheckedInGroup;
    private String givenName;
    private String matchedField;
    private long matchedRawContactId;
    private String middleName;
    private String modifiedDisplayName;
    private String modifiedFamilyName;
    private String modifiedGivenName;
    private String modifiedMiddleName;
    private String modifiedPrefix;
    private String modifiedSuffix;
    private List<String> phoneNumbers;
    private String prefix;
    private long rawContactId;
    private long structuredNameDataId;
    private String suffix;

    public AggregationSuggestionUnit(long r4, long r6, boolean r8) {
        this.structuredNameDataId = -1;
        this.modifiedDisplayName = null;
        this.matchedRawContactId = -1;
        this.matchedField = null;
        this.checked = false;
        this.firstCheckedInGroup = false;
        this.rawContactId = r4;
        this.contactId = r6;
        this.displayOrderPrimary = r8;
    }

    public long getRawContactId() {
        return this.rawContactId;
    }

    public long getContactId() {
        return this.contactId;
    }

    public long getStructuredNameDataId() {
        return this.structuredNameDataId;
    }

    public void setStructuredNameDataId(long r1) {
        this.structuredNameDataId = r1;
    }

    public void setDisplayName(String r1) {
        this.displayName = r1;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setSplittedName(String r1, String r2, String r3, String r4, String r5) {
        this.prefix = r1;
        this.givenName = r2;
        this.middleName = r3;
        this.familyName = r4;
        this.suffix = r5;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getModifiedDisplayName() {
        return this.modifiedDisplayName;
    }

    public void setModifiedDisplayName(String r1) {
        this.modifiedDisplayName = r1;
    }

    public String getModifiedPrefix() {
        return this.modifiedPrefix;
    }

    public void setModifiedPrefix(String r1) {
        this.modifiedPrefix = r1;
    }

    public String getModifiedGivenName() {
        return this.modifiedGivenName;
    }

    public void setModifiedGivenName(String r1) {
        this.modifiedGivenName = r1;
    }

    public String getModifiedMiddleName() {
        return this.modifiedMiddleName;
    }

    public void setModifiedMiddleName(String r1) {
        this.modifiedMiddleName = r1;
    }

    public String getModifiedFamilyName() {
        return this.modifiedFamilyName;
    }

    public void setModifiedFamilyName(String r1) {
        this.modifiedFamilyName = r1;
    }

    public String getModifiedSuffix() {
        return this.modifiedSuffix;
    }

    public void setModifiedSuffix(String r1) {
        this.modifiedSuffix = r1;
    }

    public String getModifiedSplittedName() {
        return join(this.modifiedPrefix, this.modifiedFamilyName, this.modifiedMiddleName, this.modifiedGivenName, this.suffix, true, false, false);
    }

    public String getModifiedSplittedNamePrimary() {
        return join(this.modifiedPrefix, this.modifiedGivenName, this.modifiedMiddleName, this.modifiedFamilyName, this.suffix, true, false, false);
    }

    public String getCurrentDisplayName() {
        if (Locale.CHINESE.getLanguage().equals(Locale.getDefault().getLanguage()) == false) goto L8;
        if (TextUtils.isEmpty(this.modifiedDisplayName) == true) goto L18;
        String r0 = this.modifiedDisplayName;
    L24:
        if (isFirstCheckedInGroup() == true) goto L26;
        return r0;
    L26:
        if (TextUtils.isEmpty(r0) == true) goto L28;
        return r0;
    L28:
        return this.displayName;
    L18:
        r0 = null;
        goto L24
    L8:
        if (TextUtils.isEmpty(this.modifiedPrefix) == false) goto L20;
        if (TextUtils.isEmpty(this.modifiedFamilyName) == false) goto L20;
        if (TextUtils.isEmpty(this.modifiedMiddleName) == false) goto L20;
        if (TextUtils.isEmpty(this.modifiedGivenName) == false) goto L20;
        if (TextUtils.isEmpty(this.modifiedSuffix) == true) goto L18;
    L20:
        if (this.displayOrderPrimary == false) goto L22;
        r0 = getModifiedSplittedNamePrimary();
        goto L24
    L22:
        r0 = getModifiedSplittedName();
        goto L24
    }

    public List<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public List<String> getEmails() {
        return this.emails;
    }

    public void addPhoneNumber(String r2) {
        if (this.phoneNumbers != null) goto L5;
        this.phoneNumbers = new ArrayList();
    L5:
        this.phoneNumbers.add(r2);
    }

    public void addEmail(String r2) {
        if (this.emails != null) goto L5;
        this.emails = new ArrayList();
    L5:
        this.emails.add(r2);
    }

    public long getMatchedRawContactId() {
        return this.matchedRawContactId;
    }

    public void setMatchedRawContactId(long r1) {
        this.matchedRawContactId = r1;
    }

    public String getMatchedField() {
        return this.matchedField;
    }

    public void setMatchedField(String r1) {
        this.matchedField = r1;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean r1) {
        this.checked = r1;
    }

    public boolean isFirstCheckedInGroup() {
        return this.firstCheckedInGroup;
    }

    public void setFirstCheckedInGroup(boolean r1) {
        this.firstCheckedInGroup = r1;
    }

    public int match(AggregationSuggestionUnit r8, String[] r9) {
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (TextUtils.isEmpty(this.displayName) == true) goto L12;
        if (this.displayName.equalsIgnoreCase(r8.displayName) == false) goto L12;
        String r7 = this.displayName;
        r9[1] = r7;
        r9[0] = r7;
        return 3;
    L12:
        if (this.phoneNumbers == null) goto L30;
        if (r8.getPhoneNumbers() == null) goto L30;
        Iterator<String> r1 = r8.getPhoneNumbers().iterator();
    L17:
        if (r1.hasNext() == false) goto L30;
        String r3 = r1.next();
        Iterator<String> r4 = this.phoneNumbers.iterator();
    L20:
        if (r4.hasNext() == false) goto L17;
        String r5 = r4.next();
        if (TextUtils.isEmpty(r3) == true) goto L20;
        if (TextUtils.isEmpty(r5) == true) goto L20;
        if (PhoneNumberUtils.compare(r5, r3, false) == false) goto L20;
        r9[0] = r5;
        r9[1] = r3;
        return 2;
    L30:
        if (this.emails != null) goto L32;
    L40:
        return 0;
    L32:
        if (r8.getEmails() == null) goto L40;
        Iterator<String> r10 = r8.getEmails().iterator();
    L35:
        if (r10.hasNext() == false) goto L40;
        String r2 = r10.next();
        if (this.emails.contains(r2) == false) goto L35;
        r9[1] = r2;
        r9[0] = r2;
        return 1;
    }

    private String join(String r8, String r9, String r10, String r11, String r12, boolean r13, boolean r14, boolean r15) {
        String r7 = null;
        if (r8 != null) goto L5;
        String r16 = null;
    L6:
        if (r9 != null) goto L8;
        String r17 = null;
    L9:
        if (r10 != null) goto L11;
        String r18 = null;
    L12:
        if (r11 != null) goto L14;
        String r19 = null;
    L15:
        if (r12 != null) goto L17;
        String r110 = null;
    L18:
        boolean r1 = true;
        boolean r0 = !TextUtils.isEmpty(r16);
        boolean r2 = !TextUtils.isEmpty(r17);
        boolean r3 = !TextUtils.isEmpty(r18);
        boolean r4 = !TextUtils.isEmpty(r19);
        boolean r5 = !TextUtils.isEmpty(r110);
        if (r0 == false) goto L21;
        r7 = r16;
    L21:
        boolean r6 = false;
        if (r2 == false) goto L26;
        if (r7 == null) goto L25;
        r1 = false;
        goto L26
    L25:
        r7 = r17;
    L26:
        if (r3 == false) goto L30;
        if (r7 == null) goto L29;
        r1 = false;
        goto L30
    L29:
        r7 = r18;
    L30:
        if (r4 == false) goto L34;
        if (r7 == null) goto L33;
        r1 = false;
        goto L34
    L33:
        r7 = r19;
    L34:
        if (r5 == false) goto L38;
        if (r7 != null) goto L39;
        r7 = r110;
    L39:
        if (r6 == false) goto L41;
        return r7;
    L41:
        StringBuilder r20 = new StringBuilder();
        if (r0 == false) goto L45;
        r20.append(r16);
    L45:
        if (r2 == false) goto L50;
        if (r0 == false) goto L48;
        r20.append(' ');
    L48:
        r20.append(r17);
    L50:
        if (r3 == false) goto L58;
        if (r0 == true) goto L53;
        if (r2 == true) goto L53;
    L57:
        r20.append(r18);
    L53:
        if (r14 == false) goto L55;
        r20.append(',');
    L55:
        if (r13 == false) goto L57;
        r20.append(' ');
    L58:
        if (r4 == false) goto L65;
        if (r0 == true) goto L62;
        if (r2 == true) goto L62;
        if (r3 == true) goto L62;
    L64:
        r20.append(r19);
    L62:
        if (r13 == false) goto L64;
        r20.append(' ');
    L65:
        if (r5 == false) goto L76;
        if (r0 == true) goto L70;
        if (r2 == true) goto L70;
        if (r3 == true) goto L70;
        if (r4 == true) goto L70;
    L74:
        r20.append(r110);
    L70:
        if (r15 == false) goto L72;
        r20.append(',');
    L72:
        if (r13 == false) goto L74;
        r20.append(' ');
    L76:
        return r20.toString();
    L38:
        r6 = r1;
        goto L39
    L17:
        r110 = r12.trim();
        goto L18
    L14:
        r19 = r11.trim();
        goto L15
    L11:
        r18 = r10.trim();
        goto L12
    L8:
        r17 = r9.trim();
        goto L9
    L5:
        r16 = r8.trim();
        goto L6
    }

    public String toString() {
        return "AggregationSuggestionUnit{displayOrderPrimary=" + this.displayOrderPrimary + ", structuredNameDataId=" + this.structuredNameDataId + ", rawContactId=" + this.rawContactId + ", contactId=" + this.contactId + ", displayName='" + this.displayName + "', prefix='" + this.prefix + "', givenName='" + this.givenName + "', middleName='" + this.middleName + "', familyName='" + this.familyName + "', suffix='" + this.suffix + "', modifiedDisplayName='" + this.modifiedDisplayName + "', modifiedPrefix='" + this.modifiedPrefix + "', modifiedGivenName='" + this.modifiedGivenName + "', modifiedMiddleName='" + this.modifiedMiddleName + "', modifiedFamilyName='" + this.modifiedFamilyName + "', modifiedSuffix='" + this.modifiedSuffix + "', phoneNumbers=" + this.phoneNumbers + ", emails=" + this.emails + ", matchedRawContactId=" + this.matchedRawContactId + ", matchedField='" + this.matchedField + "', checked=" + this.checked + ", firstCheckedInGroup=" + this.firstCheckedInGroup + '}';
    }
}
