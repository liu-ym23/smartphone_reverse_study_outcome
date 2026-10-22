package com.bytedance.android.livesdkapi.hybridapi;

import android.app.Activity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/hybridapi/ILiveHybridContainer;", "", "close", "", "getContainerId", "", "getCurrentActivity", "Landroid/app/Activity;", "setHybridTitle", "title", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveHybridContainer {
    void close();

    String getContainerId();

    Activity getCurrentActivity();

    void setHybridTitle(String r100);
}
