package com.tonyodev.fetch2;

import android.net.Uri;
import android.os.Parcelable;
import com.tonyodev.fetch2core.Extras;
import java.io.Serializable;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface Download extends Parcelable, Serializable {
    Download copy();

    int getAutoRetryAttempts();

    int getAutoRetryMaxAttempts();

    long getCreated();

    boolean getDownloadOnEnqueue();

    long getDownloaded();

    long getDownloadedBytesPerSecond();

    EnqueueAction getEnqueueAction();

    Error getError();

    long getEtaInMilliSeconds();

    Extras getExtras();

    String getFile();

    Uri getFileUri();

    int getGroup();

    Map<String, String> getHeaders();

    int getId();

    long getIdentifier();

    String getNamespace();

    NetworkType getNetworkType();

    Priority getPriority();

    int getProgress();

    Request getRequest();

    Status getStatus();

    String getTag();

    long getTotal();

    String getUrl();
}
