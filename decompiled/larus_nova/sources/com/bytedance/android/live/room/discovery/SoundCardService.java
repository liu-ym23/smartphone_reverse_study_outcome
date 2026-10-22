package com.bytedance.android.live.room.discovery;

import android.content.SharedPreferences;
import com.bytedance.android.live.room.api.ISoundCardService;
import com.bytedance.android.live.room.discovery.presenter.SoundCardModeManager;
import com.bytedance.android.livesdk.config.bi;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/discovery/SoundCardService;", "Lcom/bytedance/android/live/room/api/ISoundCardService;", "()V", "closeSoundCardMode", "", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class SoundCardService implements ISoundCardService {
    public SoundCardService() {
    }

    @Override // com.bytedance.android.live.room.api.ISoundCardService
    public void closeSoundCardMode() {
        if (bi.f119870a.getValue().a() == false) goto L6;
        SharedPreferences r100 = SoundCardModeManager.f99578a;
        SoundCardModeManager.c();
        return;
    }
}
