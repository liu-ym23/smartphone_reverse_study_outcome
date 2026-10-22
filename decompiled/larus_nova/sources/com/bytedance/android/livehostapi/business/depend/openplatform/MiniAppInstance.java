package com.bytedance.android.livehostapi.business.depend.openplatform;

import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "", "appId", "", "getAppId", "()Ljava/lang/String;", "schema", "getSchema", "executeCommand", "Landroid/os/Bundle;", "command", "params", "registerEventListener", "", "event", "listener", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/IEventListener;", "unregisterEventListener", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiniAppInstance {
    Bundle executeCommand(String r100, Bundle r101);

    String getAppId();

    String getSchema();

    void registerEventListener(String r100, IEventListener r101);

    void unregisterEventListener(String r100);
}
