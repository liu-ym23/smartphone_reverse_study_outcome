package com.bytedance.android.livehostapi.business.castscreen.interfaces;

import android.app.Dialog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J#\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastMatchRoomLandScapeAnimCallback;", "", "dismissDialog", "", "showDialog", "width", "", "dialog", "Landroid/app/Dialog;", "(Ljava/lang/Integer;Landroid/app/Dialog;)V", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCastMatchRoomLandScapeAnimCallback {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastMatchRoomLandScapeAnimCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void showDialog$default(ILiveCastMatchRoomLandScapeAnimCallback r100, Integer r101, Dialog r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            r100.showDialog(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void showDialog$default(ILiveCastMatchRoomLandScapeAnimCallback r100, Integer r101, Dialog r102, int r103, Object r104) {
            CC.showDialog$default(r100, r101, r102, r103, r104);
        }
    }

    void dismissDialog();

    void showDialog(Integer r100, Dialog r101);
}
