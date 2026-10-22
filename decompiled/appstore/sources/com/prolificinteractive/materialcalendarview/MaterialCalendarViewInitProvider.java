package com.prolificinteractive.materialcalendarview;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes4.dex */
public final class MaterialCalendarViewInitProvider extends ContentProvider {
    public MaterialCalendarViewInitProvider() {
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r10, ProviderInfo r11) {
        if (r11 == null) goto L10;
        if ("com.prolificinteractive.materialcalendarview.materialcalendarviewinitprovider".equals(r11.authority) == true) goto L8;
        super.attachInfo(r10, r11);
        return;
    L8:
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    L10:
        throw new NullPointerException("MaterialCalendarViewInitProvider ProviderInfo cannot be null.");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        n9.a.a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        return 0;
    }
}
