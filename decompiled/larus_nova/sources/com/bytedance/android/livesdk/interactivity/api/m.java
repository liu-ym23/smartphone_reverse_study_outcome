package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface m {
    void checkAndRegisterMessageListener(String r100);

    void deleteMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r100);

    List<com.bytedance.android.livesdk.interactivity.api.publicscreen.i> findMessageByType(PublicScreenConfig$MessageModelType r100);

    void insertMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r100);

    void modifyMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r100);
}
