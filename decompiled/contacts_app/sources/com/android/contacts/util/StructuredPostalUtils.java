package com.android.contacts.util;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class StructuredPostalUtils {
    private StructuredPostalUtils() {
    }

    public static Intent getViewPostalAddressIntent(String r2) {
        return new Intent("android.intent.action.VIEW", getPostalAddressUri(r2));
    }

    public static Uri getPostalAddressUri(String r2) {
        return Uri.parse("geo:0,0?q=" + Uri.encode(r2));
    }
}
