package com.obric.aiagent.executionengine.scheduler.api;

import android.net.Uri;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;

/* JADX INFO: compiled from: IUriFileAccessApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IUriFileAccessApi {
    void requestCloseFile(Uri r1, String r2);

    boolean requestOpenFile(IUriFileReceiver r1, Uri r2, String r3, int r4);
}
