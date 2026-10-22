package com.android.contacts.list;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public interface OnContactPickerActionListener {
    void onCreateNewContactAction();

    void onEditContactAction(Uri r1);

    void onPickContactAction(Uri r1);

    void onShortcutIntentCreated(Intent r1);
}
