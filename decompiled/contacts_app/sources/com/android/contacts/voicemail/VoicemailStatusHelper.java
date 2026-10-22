package com.android.contacts.voicemail;

import android.database.Cursor;
import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface VoicemailStatusHelper {

    public static class StatusMessage {
        public final int actionMessageId;
        public final Uri actionUri;
        public final int callDetailsMessageId;
        public final int callLogMessageId;
        public final String sourcePackage;

        public StatusMessage(String r1, int r2, int r3, int r4, Uri r5) {
            this.sourcePackage = r1;
            this.callLogMessageId = r2;
            this.callDetailsMessageId = r3;
            this.actionMessageId = r4;
            this.actionUri = r5;
        }

        public boolean showInCallLog() {
            if (this.callLogMessageId == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean showInCallDetails() {
            if (this.callDetailsMessageId == (-1)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    int getNumberActivityVoicemailSources(Cursor r1);

    List<StatusMessage> getStatusMessages(Cursor r1);
}
