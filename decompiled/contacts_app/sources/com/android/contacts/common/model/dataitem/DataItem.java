package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import android.content.Context;
import com.android.contacts.common.Collapser;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.model.RawContactModifier;
import com.android.contacts.group.GroupSelectionActivity;

/* JADX INFO: loaded from: classes.dex */
public class DataItem implements Collapser.Collapsible<DataItem> {
    private final ContentValues mContentValues;
    protected DataKind mKind;

    @Override // com.android.contacts.common.Collapser.Collapsible
    public /* bridge */ /* synthetic */ void collapseWith(DataItem r1) {
        collapseWith2(r1);
    }

    @Override // com.android.contacts.common.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean shouldCollapseWith(DataItem r1, Context r2) {
        return shouldCollapseWith2(r1, r2);
    }

    protected DataItem(ContentValues r1) {
        this.mContentValues = r1;
    }

    public static DataItem createFrom(ContentValues r2) {
        String r0 = r2.getAsString("mimetype");
        if ("vnd.android.cursor.item/group_membership".equals(r0) == false) goto L7;
        return new GroupMembershipDataItem(r2);
    L7:
        if ("vnd.android.cursor.item/name".equals(r0) == false) goto L11;
        return new StructuredNameDataItem(r2);
    L11:
        if ("vnd.android.cursor.item/phone_v2".equals(r0) == false) goto L15;
        return new PhoneDataItem(r2);
    L15:
        if ("vnd.android.cursor.item/email_v2".equals(r0) == false) goto L19;
        return new EmailDataItem(r2);
    L19:
        if ("vnd.android.cursor.item/postal-address_v2".equals(r0) == false) goto L23;
        return new StructuredPostalDataItem(r2);
    L23:
        if ("vnd.android.cursor.item/im".equals(r0) == false) goto L27;
        return new ImDataItem(r2);
    L27:
        if ("vnd.android.cursor.item/organization".equals(r0) == false) goto L31;
        return new OrganizationDataItem(r2);
    L31:
        if ("vnd.android.cursor.item/nickname".equals(r0) == false) goto L35;
        return new NicknameDataItem(r2);
    L35:
        if ("vnd.android.cursor.item/note".equals(r0) == false) goto L39;
        return new NoteDataItem(r2);
    L39:
        if ("vnd.android.cursor.item/website".equals(r0) == false) goto L43;
        return new WebsiteDataItem(r2);
    L43:
        if ("vnd.android.cursor.item/sip_address".equals(r0) == false) goto L47;
        return new SipAddressDataItem(r2);
    L47:
        if ("vnd.android.cursor.item/contact_event".equals(r0) == false) goto L51;
        return new EventDataItem(r2);
    L51:
        if ("vnd.android.cursor.item/relation".equals(r0) == false) goto L55;
        return new RelationDataItem(r2);
    L55:
        if ("vnd.android.cursor.item/identity".equals(r0) == false) goto L59;
        return new IdentityDataItem(r2);
    L59:
        if ("vnd.android.cursor.item/photo".equals(r0) == false) goto L63;
        return new PhotoDataItem(r2);
    L63:
        if ("vnd.android.cursor.item/card_id".equals(r0) == false) goto L67;
        return new CardIdDataItem(r2);
    L67:
        if ("vnd.android.cursor.item/gender".equals(r0) == false) goto L71;
        return new GenderDataItem(r2);
    L71:
        return new DataItem(r2);
    }

    public ContentValues getContentValues() {
        return this.mContentValues;
    }

    public void setRawContactId(long r2) {
        this.mContentValues.put(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r2));
    }

    public Long getRawContactId() {
        return this.mContentValues.getAsLong(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID);
    }

    public long getId() {
        return this.mContentValues.getAsLong("_id").longValue();
    }

    public String getMimeType() {
        return this.mContentValues.getAsString("mimetype");
    }

    public void setMimeType(String r2) {
        this.mContentValues.put("mimetype", r2);
    }

    public boolean isPrimary() {
        Integer r1 = this.mContentValues.getAsInteger("is_primary");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() == 0) goto L7;
        return true;
    }

    public boolean isSuperPrimary() {
        Integer r1 = this.mContentValues.getAsInteger("is_super_primary");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() == 0) goto L7;
        return true;
    }

    public boolean hasKindTypeColumn(DataKind r2) {
        String r3 = r2.typeColumn;
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mContentValues.containsKey(r3) == false) goto L9;
        if (this.mContentValues.getAsInteger(r3) == null) goto L9;
        return true;
    }

    public int getKindTypeColumn(DataKind r1) {
        String r2 = r1.typeColumn;
        return this.mContentValues.getAsInteger(r2).intValue();
    }

    public int getCarrierPresence() {
        if (hasCarrierPresence() == true) goto L5;
        return 0;
    L5:
        return this.mContentValues.getAsInteger("carrier_presence").intValue();
    }

    private boolean hasCarrierPresence() {
        if (this.mContentValues.containsKey("carrier_presence") == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mContentValues.getAsInteger("carrier_presence") == null) goto L7;
        return true;
    }

    public String buildDataString(Context r3, DataKind r4) {
        if (r4.actionBody != null) goto L5;
        return null;
    L5:
        CharSequence r2 = r4.actionBody.inflateUsing(r3, this.mContentValues);
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.toString();
    }

    public String buildDataStringForDisplay(Context r1, DataKind r2) {
        return buildDataString(r1, r2);
    }

    public void setDataKind(DataKind r1) {
        this.mKind = r1;
    }

    public DataKind getDataKind() {
        return this.mKind;
    }

    public Integer getTimesUsed() {
        return this.mContentValues.getAsInteger("times_used");
    }

    public Long getLastTimeUsed() {
        return this.mContentValues.getAsLong("last_time_used");
    }

    /* JADX INFO: renamed from: collapseWith, reason: avoid collision after fix types in other method */
    public void collapseWith2(DataItem r7) {
        DataKind r0 = getDataKind();
        DataKind r1 = r7.getDataKind();
        if (hasKindTypeColumn(r0) == true) goto L7;
        if (r7.hasKindTypeColumn(r1) == false) goto L7;
    L10:
        this.mContentValues.put(r1.typeColumn, Integer.valueOf(r7.getKindTypeColumn(r1)));
        this.mKind = r1;
    L11:
        this.mKind.maxLinesForDisplay = Math.max(r0.maxLinesForDisplay, r1.maxLinesForDisplay);
        if (isSuperPrimary() == false) goto L14;
    L15:
        this.mContentValues.put("is_super_primary", 1);
        this.mContentValues.put("is_primary", 1);
    L17:
        if (isPrimary() == false) goto L19;
    L20:
        this.mContentValues.put("is_primary", 1);
    L21:
        ContentValues r2 = this.mContentValues;
        int r3 = 0;
        if (getTimesUsed() != null) goto L24;
        int r4 = 0;
    L26:
        if (r7.getTimesUsed() == null) goto L29;
        r3 = r7.getTimesUsed().intValue();
    L29:
        r2.put("times_used", Integer.valueOf(r4 + r3));
        ContentValues r5 = this.mContentValues;
        long r6 = 0;
        if (getLastTimeUsed() != null) goto L32;
        long r8 = 0;
    L34:
        if (r7.getLastTimeUsed() == null) goto L37;
        r6 = r7.getLastTimeUsed().longValue();
    L37:
        r5.put("last_time_used", Long.valueOf(Math.max(r8, r6)));
        return;
    L32:
        r8 = getLastTimeUsed().longValue();
        goto L34
    L24:
        r4 = getTimesUsed().intValue();
        goto L26
    L19:
        if (r7.isPrimary() == false) goto L21;
    L14:
        if (r7.isSuperPrimary() == false) goto L17;
    L7:
        if (r7.hasKindTypeColumn(r1) == false) goto L11;
        if (RawContactModifier.getTypePrecedence(r0, getKindTypeColumn(r0)) <= RawContactModifier.getTypePrecedence(r1, r7.getKindTypeColumn(r1))) goto L11;
        goto L10
    }

    /* JADX INFO: renamed from: shouldCollapseWith, reason: avoid collision after fix types in other method */
    public boolean shouldCollapseWith2(DataItem r4, Context r5) {
        if (this.mKind != null) goto L5;
        return false;
    L5:
        if (r4.getDataKind() != null) goto L8;
        return false;
    L8:
        return MoreContactUtils.shouldCollapse(getMimeType(), buildDataString(r5, this.mKind), r4.getMimeType(), r4.buildDataString(r5, r4.getDataKind()));
    }
}
