package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000fH&J\b\u0010\u0014\u001a\u00020\u0003H&J%\u0010\u0015\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H&J5\u0010\u001c\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\nJ\u001a\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000fH&J\u001c\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IVideoEffectControl;", "", "appendComposerNodes", "", "nodePaths", "", "", PromotionProductPrivilegesStruct.TAGS, "composerResult", "Lcom/bytedance/android/livesdkapi/roomplayer/ComposerResult;", "([Ljava/lang/String;[Ljava/lang/String;Lcom/bytedance/android/livesdkapi/roomplayer/ComposerResult;)V", "getComposerNodePaths", "()[Ljava/lang/String;", "getEffectTrackData", "dataType", "", "isEffectInited", "", "isEffectUsed", "type", "releaseEffect", "removeComposerNodes", "([Ljava/lang/String;Lcom/bytedance/android/livesdkapi/roomplayer/ComposerResult;)V", "sendMessage", RemoteMessageConst.MSGID, "param1", "param2", "param3", "setComposerNodes", "setEnable", "isEnable", "setRenderCacheStringValue", "key", "value", "setupWithConfig", "config", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfig;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVideoEffectControl {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean isEffectUsed$default(IVideoEffectControl r100, int r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = 1;
        L7:
            return r100.isEffectUsed(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isEffectUsed");
        }

        public static /* synthetic */ void setEnable$default(IVideoEffectControl r100, boolean r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = 1;
        L6:
            r100.setEnable(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEnable");
        }
    }

    void appendComposerNodes(String[] r100, String[] r101, ComposerResult r102);

    String[] getComposerNodePaths();

    String getEffectTrackData(int r100);

    boolean isEffectInited();

    boolean isEffectUsed(int r100);

    void releaseEffect();

    void removeComposerNodes(String[] r100, ComposerResult r101);

    void sendMessage(int r100, int r101, int r102, String r103);

    void setComposerNodes(String[] r100, String[] r101, ComposerResult r102);

    void setEnable(boolean r100, int r101);

    void setRenderCacheStringValue(String r100, String r101);

    void setupWithConfig(VideoEffectInitConfig r100);
}
