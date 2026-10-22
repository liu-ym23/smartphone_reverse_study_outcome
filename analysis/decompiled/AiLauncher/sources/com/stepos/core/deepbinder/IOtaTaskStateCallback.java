package com.stepos.core.deepbinder;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.deepbinder.annotation.type.Callback;
import kotlin.Metadata;

@Callback
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/core/deepbinder/IOtaTaskStateCallback;", "", "", "otaId", "", VoiceWakeupReceiver.EXTRA_STATE, "progress", "installedVersion", "LY8/t;", "onTaskState", "(Ljava/lang/String;III)V", "onRecycle", "()V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IOtaTaskStateCallback {
    void onRecycle();

    void onTaskState(String otaId, int state, int progress, int installedVersion);
}
