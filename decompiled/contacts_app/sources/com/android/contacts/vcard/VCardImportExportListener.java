package com.android.contacts.vcard;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.android.vcard.VCardEntry;

/* JADX INFO: loaded from: classes2.dex */
interface VCardImportExportListener {
    void onCancelRequest(CancelRequest r1, int r2);

    void onComplete();

    void onExportCanceled(int r1, String r2);

    void onExportFailed(ExportRequest r1);

    void onExportFinished(int r1, String r2, String r3, PendingIntent r4);

    void onExportFinished(int r1, String r2, String r3, Intent r4);

    void onExportParsed(String r1, String r2, int r3, String r4, int r5, int r6);

    void onExportProcessed(ExportRequest r1, int r2);

    void onImportCanceled(ImportRequest r1, int r2);

    void onImportFailed(ImportRequest r1);

    void onImportFinished(ImportRequest r1, int r2, Uri r3);

    void onImportParsed(ImportRequest r1, int r2, VCardEntry r3, int r4, int r5);

    void onImportProcessed(ImportRequest r1, int r2, int r3, int r4);
}
