package com.android.contacts.common.vcard;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class ExportRequest {
    public final Uri destUri;
    public final String exportType;

    public ExportRequest(Uri r2) {
        this(r2, null);
    }

    public ExportRequest(Uri r1, String r2) {
        this.destUri = r1;
        this.exportType = r2;
    }
}
