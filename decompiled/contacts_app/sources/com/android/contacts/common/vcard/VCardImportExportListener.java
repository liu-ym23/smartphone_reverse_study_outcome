package com.android.contacts.common.vcard;

import android.net.Uri;
import com.android.vcard.VCardEntry;

/* JADX INFO: loaded from: classes.dex */
interface VCardImportExportListener {
    void onCancelRequest(CancelRequest r1, int r2);

    void onComplete();

    void onExportFailed(ExportRequest r1);

    void onExportProcessed(ExportRequest r1, int r2);

    void onImportCanceled(ImportRequest r1, int r2);

    void onImportFailed(ImportRequest r1);

    void onImportFinished(ImportRequest r1, int r2, Uri r3);

    void onImportParsed(ImportRequest r1, int r2, VCardEntry r3, int r4, int r5);

    void onImportProcessed(ImportRequest r1, int r2, int r3);
}
