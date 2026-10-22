package com.bytedance.android.livesdk.chatroom.vsplayer.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.vs.player.VSPlayerServiceImpl")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/IVSPlayerService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/progress/service/IPlayerProgressService;", "provideVSProgressService", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/b;", "provideVSPlayerTipService", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/c;", "provideVSPlayerViewControlService", "", "releaseService", "Companion", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSPlayerService extends IService {
    public static final Companion Companion = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f118389a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f118390b = null;

        static {
            f118389a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Companion.class, "inst", "getInst()Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/IVSPlayerService;", 0))};
            f118390b = new Companion();
            Intrinsics.checkNotNullParameter(IVSPlayerService$Companion$inst$2.INSTANCE, "getValue");
        }

        public Companion() {
        }
    }

    static {
        Companion = Companion.f118390b;
    }

    b provideVSPlayerTipService(DataCenter r100);

    c provideVSPlayerViewControlService(DataCenter r100);

    IPlayerProgressService provideVSProgressService(DataCenter r100);

    void releaseService(DataCenter r100);
}
