package com.android.server.ambientcontext;

import android.app.ambientcontext.AmbientContextEventRequest;
import android.os.RemoteCallback;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
interface RemoteAmbientDetectionService {
    void dump(String r1, PrintWriter r2);

    void queryServiceStatus(int[] r1, String r2, RemoteCallback r3);

    void startDetection(AmbientContextEventRequest r1, String r2, RemoteCallback r3, RemoteCallback r4);

    void stopDetection(String r1);

    void unbind();
}
