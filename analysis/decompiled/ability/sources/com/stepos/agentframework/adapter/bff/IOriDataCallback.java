package com.stepos.agentframework.adapter.bff;

import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0005\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/IOriDataCallback;", "Lcom/stepos/agentframework/adapter/bff/IConnectCallback;", "", SettingsConfig.KEY_DATA, "LC7/r;", "onDataReceived", "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IOriDataCallback extends IConnectCallback {
    void onDataReceived(String data);

    void onDataReceived(ByteBuffer data);
}
