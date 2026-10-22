package com.android.contacts.bytedanceosquickcontact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.android.contacts.Collapser;

/* JADX INFO: loaded from: classes.dex */
public interface Action extends Collapser.Collapsible<Action> {
    Intent getAlternateIntent();

    CharSequence getBody();

    String getData();

    long getDataId();

    Uri getDataUri();

    Intent getIntent();

    String getMimeType();

    long getRawGroupId();

    Intent getStarIntent();

    CharSequence getSubtitle();

    Boolean isStarred();

    void setDataAction(Context r1, String r2, long r3, Cursor r5);
}
