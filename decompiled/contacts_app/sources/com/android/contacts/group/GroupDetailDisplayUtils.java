package com.android.contacts.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;

/* JADX INFO: loaded from: classes2.dex */
public class GroupDetailDisplayUtils {
    private GroupDetailDisplayUtils() {
    }

    public static View getNewGroupSourceView(Context r2) {
        return ((LayoutInflater) r2.getSystemService("layout_inflater")).inflate(R.layout.group_source_button, null);
    }

    public static void bindGroupSourceView(Context r1, View r2, String r3, String r4) {
        AccountType r5 = AccountTypeManager.getInstance(r1).getAccountType(r3, r4);
        TextView r6 = (TextView) r2.findViewById(android.R.id.title);
        if (r6 == null) goto L11;
        r6.setText(r5.getViewGroupLabel(r1));
        ImageView r7 = (ImageView) r2.findViewById(android.R.id.icon);
        if (r7 == null) goto L9;
        r7.setImageDrawable(r5.getDisplayIcon(r1));
        return;
    L9:
        throw new IllegalStateException("Group source view must contain an ImageView with idandroid.R.id.icon");
    L11:
        throw new IllegalStateException("Group source view must contain a TextView with idandroid.R.id.label");
    }
}
