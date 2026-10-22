package com.android.contacts.quickcontact;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.android.contacts.Collapser;

/* JADX INFO: loaded from: classes2.dex */
public interface Action extends Collapser.Collapsible<Action> {
    Drawable getAlternateIcon();

    String getAlternateIconDescription();

    Intent getAlternateIntent();

    CharSequence getBody();

    long getDataId();

    Uri getDataUri();

    Intent getIntent();

    String getMimeType();

    int getPresence();

    CharSequence getSubtitle();

    Boolean isPrimary();
}
