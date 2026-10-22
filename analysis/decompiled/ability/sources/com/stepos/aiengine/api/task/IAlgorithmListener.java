package com.stepos.aiengine.api.task;

import android.os.Bundle;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/api/task/IAlgorithmListener;", "", "", "identity", "Landroid/os/Bundle;", SettingsConfig.KEY_DATA, "LC7/r;", "onPrepared", "(JLandroid/os/Bundle;)V", "", "status", "progress", "onUpdate", "(JII)V", "reasonCode", "", "message", "onFailed", "(JILjava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAlgorithmListener {
    void onFailed(long identity, int reasonCode, String message);

    void onPrepared(long identity, Bundle data);

    void onUpdate(long identity, int status, int progress);
}
