package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class ImDataItem extends DataItem {
    private final boolean mCreatedFromEmail;

    @Override // com.android.contacts.common.model.dataitem.DataItem, com.android.contacts.common.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean shouldCollapseWith(DataItem r1, Context r2) {
        return shouldCollapseWith(r1, r2);
    }

    ImDataItem(ContentValues r1) {
        super(r1);
        this.mCreatedFromEmail = false;
    }

    private ImDataItem(ContentValues r1, boolean r2) {
        super(r1);
        this.mCreatedFromEmail = r2;
    }

    public static ImDataItem createFromEmail(EmailDataItem r2) {
        ImDataItem r0 = new ImDataItem(new ContentValues(r2.getContentValues()), true);
        r0.setMimeType("vnd.android.cursor.item/im");
        return r0;
    }

    public String getData() {
        if (this.mCreatedFromEmail == false) goto L7;
        return getContentValues().getAsString("data1");
    L7:
        return getContentValues().getAsString("data1");
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }

    public Integer getProtocol() {
        return getContentValues().getAsInteger("data5");
    }

    public boolean isProtocolValid() {
        if (getProtocol() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String getCustomProtocol() {
        return getContentValues().getAsString("data6");
    }

    public int getChatCapability() {
        Integer r1 = getContentValues().getAsInteger("chat_capability");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.intValue();
    }

    public boolean isCreatedFromEmail() {
        return this.mCreatedFromEmail;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.contacts.common.model.dataitem.DataItem
    public boolean shouldCollapseWith(DataItem r5, Context r6) {
        if ((r5 instanceof ImDataItem) == true) goto L5;
    L39:
        return false;
    L5:
        if (this.mKind == null) goto L39;
        if (r5.getDataKind() == null) goto L39;
        ImDataItem r7 = (ImDataItem) r5;
        if (getData().equals(r7.getData()) == true) goto L13;
        return false;
    L13:
        if (isProtocolValid() == false) goto L27;
        if (r7.isProtocolValid() == false) goto L27;
        if (getProtocol().equals(r7.getProtocol()) == true) goto L21;
        return false;
    L21:
        if (getProtocol().intValue() == (-1)) goto L23;
    L25:
        return true;
    L23:
        if (TextUtils.equals(getCustomProtocol(), r7.getCustomProtocol()) == true) goto L25;
        return false;
    L27:
        if (isProtocolValid() == false) goto L33;
        if (getProtocol().intValue() == (-1)) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (r7.isProtocolValid() == true) goto L35;
        return true;
    L35:
        if (r7.getProtocol().intValue() == (-1)) goto L37;
        return false;
    L37:
        return true;
    }
}
