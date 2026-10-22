package com.bytedance.android.livesdkapi.service;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.model.ChatDialogEvent;
import com.bytedance.android.livesdkapi.model.InviteCallingStatus;
import com.bytedance.android.livesdkapi.shortvideo.IShortVideoBroadcastComponent;
import com.bytedance.android.livesdkapi.shortvideo.IShortVideoGuestComponent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveShortVideoService;", "Lcom/bytedance/android/live/base/IService;", "createBroadcastComponent", "Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoBroadcastComponent;", "bundle", "Landroid/os/Bundle;", "createGuestComponent", "Lcom/bytedance/android/livesdkapi/shortvideo/IShortVideoGuestComponent;", "notifyChatRoomEvent", "", "event", "Lcom/bytedance/android/livesdkapi/model/ChatDialogEvent;", "setInviteCallingStatus", "status", "Lcom/bytedance/android/livesdkapi/model/InviteCallingStatus;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveShortVideoService extends IService {
    IShortVideoBroadcastComponent createBroadcastComponent(Bundle r100);

    IShortVideoGuestComponent createGuestComponent(Bundle r100);

    void notifyChatRoomEvent(ChatDialogEvent r100);

    void setInviteCallingStatus(InviteCallingStatus r100);
}
