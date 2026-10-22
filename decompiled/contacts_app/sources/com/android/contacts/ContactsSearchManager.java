package com.android.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.android.contacts.list.ContactsRequest;
import obric.api.ContactsContractSmt;

/* JADX INFO: loaded from: classes.dex */
public class ContactsSearchManager {
    public static final String ORIGINAL_REQUEST_KEY = "originalRequest";

    public ContactsSearchManager() {
    }

    public static void startSearch(Activity r1, String r2) {
        r1.startActivity(buildIntent(r1, r2, null));
    }

    public static void startSearchForResult(Activity r0, String r1, int r2, ContactsRequest r3) {
        r0.startActivityForResult(buildIntent(r0, r1, r3), r2);
    }

    public static void startSearch(Activity r0, String r1, ContactsRequest r2) {
        r0.startActivity(buildIntent(r0, r1, r2));
    }

    private static Intent buildIntent(Activity r2, String r3, ContactsRequest r4) {
        Intent r0 = new Intent();
        r0.setData(ContactsContract.Contacts.CONTENT_URI);
        r0.setAction(ContactsContractSmt.get_UI_FILTER_CONTACTS_ACTION());
        Bundle r5 = r2.getIntent().getExtras();
        if (r5 == null) goto L5;
        r0.putExtras(r5);
    L5:
        r0.putExtra(ContactsContractSmt.get_UI_FILTER_TEXT_EXTRA_KEY(), r3);
        if (r4 == null) goto L8;
        r0.putExtra(ORIGINAL_REQUEST_KEY, r4);
    L8:
        return r0;
    }
}
