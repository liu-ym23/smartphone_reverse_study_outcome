package com.android.contacts.list;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public interface OnContactBrowserActionListener {
    void onAddToFavoritesAction(Uri r1);

    void onCallContactAction(Uri r1);

    void onCreateNewContactAction();

    void onDeleteContactAction(Uri r1);

    void onEditContactAction(Uri r1);

    void onFinishAction();

    void onInvalidSelection();

    void onRemoveFromFavoritesAction(Uri r1);

    void onSelectionChange();

    void onSmsContactAction(Uri r1);

    void onViewContactAction(Uri r1);
}
