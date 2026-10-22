package com.stepos.deepbinder.client.api;

import android.content.ComponentName;
import androidx.annotation.Keep;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "", "Landroid/content/ComponentName;", "componentName", "LC7/r;", "onProviderStart", "(Landroid/content/ComponentName;)V", "onProviderStop", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ProviderStateListener {
    @Keep
    void onProviderStart(ComponentName componentName);

    @Keep
    void onProviderStop(ComponentName componentName);
}
