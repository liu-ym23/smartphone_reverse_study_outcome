package com.bytedance.android.livesdkapi.service.gamecp;

import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/gamecp/ILiveRoomLandScapeService;", "", "dismissDialog", "", "key", "", "showDialog", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "width", "", "(Ljava/lang/String;Landroidx/fragment/app/DialogFragment;Ljava/lang/Integer;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRoomLandScapeService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void showDialog$default(ILiveRoomLandScapeService r100, String r101, DialogFragment r102, Integer r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = -1;
        L6:
            r100.showDialog(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }
    }

    void dismissDialog(String r100);

    void showDialog(String r100, DialogFragment r101, Integer r102);
}
