package com.bytedance.android.livesdk.service;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.backupsei.IBackupListenerWrapper;
import com.bytedance.android.livesdkapi.backupsei.IBackupSeiGuestManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.LiveBackupSeiExperimentUtils;
import com.bytedance.android.livesdkapi.preview.IPreviewSeiService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.MessageHub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J0\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/service/LivePreviewSeiService;", "Lcom/bytedance/android/livesdkapi/preview/IPreviewSeiService;", "Lmd0/a$a;", "callback", "Lmd0/a$b;", "ktvRoomCallback", "Lmd0/a$c;", "voiceRoomCallback", "Lmd0/a;", "createLiveSeiHelper", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "", "isAnchor", "isEnableLiveBackupSei", "", "feedType", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "Lcom/bytedance/android/livesdkapi/service/MessageHub;", "messageHub", "Lcom/bytedance/android/livesdkapi/backupsei/IBackupListenerWrapper;", "listener", "Lcom/bytedance/android/livesdkapi/backupsei/IBackupSeiGuestManager;", "createBackupSeiGuestManager", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LivePreviewSeiService implements IPreviewSeiService {

    public static final class a implements af1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageHub f157966a;

        public a(MessageHub r100) {
            this.f157966a = r100;
        }

        @Override // af1.c
        public final void a(int r100, ye1.e.b r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
            this.f157966a.addMessageListener(r100, r101);
        }

        @Override // af1.c
        public final void b(int r100, ye1.e.b r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
            this.f157966a.removeMessageListener(r100, r101);
        }
    }

    public static final class b implements ye1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBackupListenerWrapper f157967a;

        public b(IBackupListenerWrapper r100) {
            this.f157967a = r100;
        }

        @Override // ye1.c
        public final void onSei(String r100, ye1.a r101) {
            Intrinsics.checkNotNullParameter(r100, "seiStr");
            Intrinsics.checkNotNullParameter(r101, "backupSeiInfo");
            this.f157967a.onSei(r100, r101);
        }
    }

    public LivePreviewSeiService() {
    }

    @Override // com.bytedance.android.livesdkapi.preview.IPreviewSeiService
    public boolean isEnableLiveBackupSei(IRoom r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        return LiveBackupSeiExperimentUtils.INSTANCE.isEnableLiveBackupSei(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.preview.IPreviewSeiService
    public md0.a createLiveSeiHelper(md0.a.InterfaceC6802a r100, md0.a.b r101, md0.a.c r102) {
        IInteractService r103 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.createLiveSeiHelper(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.preview.IPreviewSeiService
    public IBackupSeiGuestManager createBackupSeiGuestManager(IRoom r100, int r101, ILivePlayerClient r102, MessageHub r103, IBackupListenerWrapper r104) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r102, "livePlayerClient");
        Intrinsics.checkNotNullParameter(r103, "messageHub");
        Intrinsics.checkNotNullParameter(r104, "listener");
        return ye1.f.a(r100, r101, r102, new a(r103), new b(r104));
    }
}
