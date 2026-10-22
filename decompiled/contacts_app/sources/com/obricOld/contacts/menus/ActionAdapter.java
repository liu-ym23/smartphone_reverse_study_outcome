package com.obricOld.contacts.menus;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.android.contacts.bytedanceosquickcontact.Action;

/* JADX INFO: loaded from: classes4.dex */
class ActionAdapter implements Action {
    /* JADX INFO: renamed from: collapseWith, reason: avoid collision after fix types in other method */
    public boolean collapseWith2(Action r1) {
        return false;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getAlternateIntent() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public CharSequence getBody() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public String getData() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public long getDataId() {
        return 0;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Uri getDataUri() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getIntent() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public String getMimeType() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public long getRawGroupId() {
        return 0;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Intent getStarIntent() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public CharSequence getSubtitle() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public Boolean isStarred() {
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.Action
    public void setDataAction(Context r1, String r2, long r3, Cursor r5) {
    }

    /* JADX INFO: renamed from: shouldCollapseWith, reason: avoid collision after fix types in other method */
    public boolean shouldCollapseWith2(Action r1) {
        return false;
    }

    ActionAdapter() {
    }

    @Override // com.android.contacts.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean collapseWith(Action r1) {
        return collapseWith2(r1);
    }

    @Override // com.android.contacts.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean shouldCollapseWith(Action r1) {
        return shouldCollapseWith2(r1);
    }
}
