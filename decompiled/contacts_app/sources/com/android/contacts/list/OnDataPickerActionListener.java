package com.android.contacts.list;

import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface OnDataPickerActionListener {
    void onHomeInActionBarSelected();

    void onPickDataAction(Uri r1);

    void onPickDatasAction(Uri r1, ArrayList<Long> r2);

    void onPickNumberArray(String[] r1);

    void onPickunStarredNumsAction(ArrayList<String> r1);

    void onShortcutIntentCreated(Intent r1);
}
