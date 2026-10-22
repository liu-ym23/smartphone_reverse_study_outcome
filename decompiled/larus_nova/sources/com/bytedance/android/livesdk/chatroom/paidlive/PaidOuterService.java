package com.bytedance.android.livesdk.chatroom.paidlive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vs.video.PaidPrivilegeFullPageActivity;
import com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/paidlive/PaidOuterService;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/IPaidOuterService;", "()V", "openPanelInRoom", "", "panelType", "", "(Ljava/lang/Integer;)V", "startPaidPrivilegeFullPage", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PaidOuterService implements IPaidOuterService {
    public PaidOuterService() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService
    public void openPanelInRoom(Integer r100) {
        if (r100 == null) goto L10;
        r100.intValue();
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L6;
        r101.getOpenPanelInRoom().setValue(r100);
        return;
    L6:
        lm1.b r102 = pm1.f.d(null);
        if (r102 == null) goto L12;
        r102.getOpenPanelInReplay().setValue(r100);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService
    public void startPaidPrivilegeFullPage(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        int r102 = PaidPrivilegeFullPageActivity.f117785c;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        Intent r103 = new Intent(r100, PaidPrivilegeFullPageActivity.class);
        r103.putExtra("paid_privilege_arguments", r101);
        r100.startActivity(r103);
    }
}
