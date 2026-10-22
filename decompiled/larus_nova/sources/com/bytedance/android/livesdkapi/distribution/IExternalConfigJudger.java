package com.bytedance.android.livesdkapi.distribution;

import com.bytedance.android.livesdkapi.distribution.externalinjectcomponent.IExternalInjectComponentProvider;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H&J\u001c\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J&\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H&J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010 H&J\u0016\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000eH&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H&J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0010H&J\u0012\u0010*\u001a\u00020%2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H&¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/IExternalConfigJudger;", "", "canUse", "", "type", "Lcom/bytedance/android/livesdkapi/distribution/EXTERNAL_CONFIG_TYPE;", "action", "", "defaultValue", "disable", "disableEndPage", "disableUserLeave", "enableFsOpt", "getCommonParams", "", "getCurIndex", "", "getCurRoomId", "getExternalScene", "Lcom/bytedance/android/livesdkapi/distribution/LiveExternalScene;", "getFirstRoomId", "getInteractionViewConfig", "Lcom/bytedance/android/livesdkapi/distribution/ViewConfig;", "isPortrait", "roomId", "getNormalComponentProviders", "Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IExternalInjectComponentProvider;", "getPlayerScene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "getRoomExitConfig", "Lcom/bytedance/android/livesdkapi/distribution/RoomExitConfig;", "getShowInClearTagList", "", "getTemplateComponentProviders", "isEnableRepeatLeaveCheck", "isInExternalMode", "setConfig", "", "config", "Lcom/bytedance/android/livesdkapi/distribution/LiveExternalConfig;", "updateIndex", "index", "updateRoomId", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalConfigJudger {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ Map getNormalComponentProviders$default(IExternalConfigJudger r100, String r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.getNormalComponentProviders(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNormalComponentProviders");
        }

        public static /* synthetic */ boolean disable$default(IExternalConfigJudger r100, EXTERNAL_CONFIG_TYPE r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.disable(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disable");
        }

        public static /* synthetic */ ViewConfig getInteractionViewConfig$default(IExternalConfigJudger r100, boolean r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.getInteractionViewConfig(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInteractionViewConfig");
        }

        public static /* synthetic */ boolean canUse$default(IExternalConfigJudger r100, EXTERNAL_CONFIG_TYPE r101, String r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L10;
            r103 = true;
        L10:
            return r100.canUse(r101, r102, r103);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canUse");
        }

        public static /* synthetic */ boolean disable$default(IExternalConfigJudger r100, EXTERNAL_CONFIG_TYPE r101, String r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L10;
            r103 = false;
        L10:
            return r100.disable(r101, r102, r103);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disable");
        }
    }

    boolean canUse(EXTERNAL_CONFIG_TYPE r100, String r101, boolean r102);

    boolean disable(EXTERNAL_CONFIG_TYPE r100, String r101);

    boolean disable(EXTERNAL_CONFIG_TYPE r100, String r101, boolean r102);

    boolean disableEndPage();

    boolean disableUserLeave();

    boolean enableFsOpt();

    Map<String, String> getCommonParams();

    int getCurIndex();

    String getCurRoomId();

    LiveExternalScene getExternalScene();

    String getFirstRoomId();

    ViewConfig getInteractionViewConfig(boolean r100, String r101);

    Map<String, IExternalInjectComponentProvider> getNormalComponentProviders(String r100);

    ILivePlayerScene getPlayerScene();

    RoomExitConfig getRoomExitConfig();

    List<String> getShowInClearTagList();

    Map<String, IExternalInjectComponentProvider> getTemplateComponentProviders();

    boolean isEnableRepeatLeaveCheck();

    boolean isInExternalMode();

    void setConfig(LiveExternalConfig r100);

    void updateIndex(int r100);

    void updateRoomId(String r100);
}
