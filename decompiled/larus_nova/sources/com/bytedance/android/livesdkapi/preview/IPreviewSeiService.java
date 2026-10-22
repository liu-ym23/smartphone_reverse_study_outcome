package com.bytedance.android.livesdkapi.preview;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.backupsei.IBackupListenerWrapper;
import com.bytedance.android.livesdkapi.backupsei.IBackupSeiGuestManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.MessageHub;
import kotlin.Metadata;
import md0.a;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.service.LivePreviewSeiService")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J0\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/preview/IPreviewSeiService;", "Lcom/bytedance/android/live/base/IService;", "Lmd0/a$a;", "callback", "Lmd0/a$b;", "ktvRoomCallback", "Lmd0/a$c;", "voiceRoomCallback", "Lmd0/a;", "createLiveSeiHelper", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "", "feedType", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "Lcom/bytedance/android/livesdkapi/service/MessageHub;", "messageHub", "Lcom/bytedance/android/livesdkapi/backupsei/IBackupListenerWrapper;", "listener", "Lcom/bytedance/android/livesdkapi/backupsei/IBackupSeiGuestManager;", "createBackupSeiGuestManager", "", "isAnchor", "isEnableLiveBackupSei", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewSeiService extends IService {
    IBackupSeiGuestManager createBackupSeiGuestManager(IRoom r100, int r101, ILivePlayerClient r102, MessageHub r103, IBackupListenerWrapper r104);

    a createLiveSeiHelper(a.InterfaceC6802a r100, a.b r101, a.c r102);

    boolean isEnableLiveBackupSei(IRoom r100, boolean r101);
}
