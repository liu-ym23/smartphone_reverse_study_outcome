package com.bytedance.android.livesdk.interactivity.api;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeDialog;
import com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeLandscapeDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz.z;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J6\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016J0\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/RoomNoticeService;", "Lcom/bytedance/android/livesdk/interactivity/api/IRoomNoticeService;", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "userId", "enterType", "Lnz/z;", "iDialogDismissListener", "", "openRoomNoticeDialog", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "openLandscapeRoomNoticeDialog", "", "length", "getNoticeLengthTip", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomNoticeService implements IRoomNoticeService {
    public RoomNoticeService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomNoticeService
    public String getNoticeLengthTip(int r100) {
        int r101 = ya2.d.f567017a;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append('/');
        r102.append(ya2.d.a());
        return r102.toString();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomNoticeService
    public void openLandscapeRoomNoticeDialog(FragmentActivity r100, Room r101, String r102, String r103) {
        int r104 = RoomNoticeLandscapeDialog.f140761h;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "room");
        RoomNoticeLandscapeDialog r105 = new RoomNoticeLandscapeDialog();
        r105.f140754e = r101;
        FragmentManager r106 = r100.getSupportFragmentManager();
        LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, "RoomNoticeLandscapeDialog", r107);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r105, r107) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r105.show(r106, "RoomNoticeLandscapeDialog");
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomNoticeService
    public void openRoomNoticeDialog(FragmentActivity r100, String r101, String r102, z<String> r103) {
        RoomNoticeDialog.a r104 = RoomNoticeDialog.f140759j;
        Intrinsics.checkNotNull(r100);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        RoomNoticeDialog r105 = new RoomNoticeDialog();
        FragmentManager r106 = r100.getSupportFragmentManager();
        LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, "RoomNoticeDialog", r107);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r105, r107) == true) goto L8;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L6:
        r105.show(r106, "RoomNoticeDialog");
    L8:
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        RoomNoticeDialog.f140757h = r101;
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        RoomNoticeDialog.f140758i = r102;
    }
}
