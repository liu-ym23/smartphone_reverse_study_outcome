package com.bytedance.android.livesdk.interactivity;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityService;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.TextMessageAdjuster;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/InteractivityService;", "Lcom/bytedance/android/livesdk/interactivity/api/IInteractivityService;", "", "registerInteractivityMessages", "init", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomDataContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/e;", "iInteractUIContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/i;", "publicScreenContainer", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/h;", "createPublicScreenAdjuster", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "roomContext", "Lcom/bytedance/android/livesdk/interactivity/api/f;", "createInteractivityContext", "createInteractivityContextForPreview", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InteractivityService implements IInteractivityService {
    public InteractivityService() {
        init();
    }

    private final void registerInteractivityMessages() {
        ExternalMessageInject r100 = ExternalMessageInject.getInstance();
        InteractivityMessageType.Companion.getClass();
        r100.inject(InteractivityMessageType.access$getInjectInfoList$cp());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityService
    public final void init() {
        registerInteractivityMessages();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityService
    public com.bytedance.android.livesdk.interactivity.api.f createInteractivityContext(Context r100, RoomContext r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        InteractivityContext r103 = new InteractivityContext();
        r103.initContext(r100, r101, r102);
        return r103;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityService
    public com.bytedance.android.livesdk.interactivity.api.f createInteractivityContextForPreview(Context r100, RoomContext r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        InteractivityContext r103 = new InteractivityContext();
        r103.initContextForPreview(r100, r101, r102);
        return r103;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.h createPublicScreenAdjuster(DataCenter r100, RoomContext r101, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r102, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.i r103) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "roomDataContext");
        Intrinsics.checkNotNullParameter(r102, "iInteractUIContext");
        Intrinsics.checkNotNullParameter(r103, "publicScreenContainer");
        return new TextMessageAdjuster(r100, r101, r102, r103);
    }
}
