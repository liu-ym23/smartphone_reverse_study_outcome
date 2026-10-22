package com.bytedance.android.livesdkapi.room.handler.toolbar;

import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import py.e;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\bH&J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0015\u001a\u00020\rH&J\b\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\rH&J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\rH&J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/ToolbarMatchInterface;", "", "", "getComponentExtra", "extra", "", "updateExtraData", "getComponentName", "", "getComponentId", "getComponentGroupId", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/ResKeyEnum;", "key", "", "isPortrait", "Lpy/e;", "findResource", "getSource", "extraObj", "setExtraDataAfterCheck", "isInMore", "isFromMsg", "isQuickPreload", "isPreloadScene", VideoEventOneOutSync.END_TYPE_FINISH, "changeBizCheckFinish", "compInfo", "isBizCheckFinish", "()Z", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ToolbarMatchInterface {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String compInfo(ToolbarMatchInterface r100) {
            return r100.getComponentId() + '-' + r100.getComponentName();
        }
    }

    void changeBizCheckFinish(boolean r100);

    String compInfo();

    e findResource(ResKeyEnum r100, boolean r101);

    String getComponentExtra();

    int getComponentGroupId();

    int getComponentId();

    String getComponentName();

    int getSource();

    boolean isBizCheckFinish();

    boolean isFromMsg();

    boolean isInMore();

    boolean isPreloadScene();

    boolean isQuickPreload();

    void setExtraDataAfterCheck(Object r100);

    void updateExtraData(String r100);
}
