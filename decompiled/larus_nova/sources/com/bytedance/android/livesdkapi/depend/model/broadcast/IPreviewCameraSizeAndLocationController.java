package com.bytedance.android.livesdkapi.depend.model.broadcast;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H&J2\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IPreviewCameraSizeAndLocationController;", "", BasicTestActionHandler.TEST_ACTION_RESET, "", "jumpToLive", "setPreviewSizeAndLocation", "width", "", "height", "left", "top", "isVerticalLandScape", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewCameraSizeAndLocationController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean reset$default(IPreviewCameraSizeAndLocationController r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = false;
        L7:
            return r100.reset(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reset");
        }

        public static /* synthetic */ boolean setPreviewSizeAndLocation$default(IPreviewCameraSizeAndLocationController r100, int r101, int r102, int r103, int r110, boolean r111, int r112, Object r113) {
            if (r113 != null) goto L10;
            if ((r112 & 16) == 0) goto L6;
            boolean r104 = false;
        L8:
            return r100.setPreviewSizeAndLocation(r101, r102, r103, r110, r104);
        L6:
            r104 = r111;
            goto L8
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPreviewSizeAndLocation");
        }
    }

    boolean reset(boolean r100);

    boolean setPreviewSizeAndLocation(int r100, int r101, int r102, int r103, boolean r104);
}
