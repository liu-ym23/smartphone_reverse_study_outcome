package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerChangeMediaInfoContentDef;", "", "linkmicMediaParam", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkmicMediaParam;", "getLinkmicMediaParam$annotations", "()V", "getLinkmicMediaParam", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkmicMediaParam;", "playModeList", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPlayModeList$annotations", "getPlayModeList", "()Ljava/util/List;", "sceneList", "getSceneList$annotations", "getSceneList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerChangeMediaInfoContentDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "linkmic_media_param")
        public static /* synthetic */ void getLinkmicMediaParam$annotations() {
        }

        @FieldName(name = "play_mode_list")
        public static /* synthetic */ void getPlayModeList$annotations() {
        }

        @FieldName(name = "scene_list")
        public static /* synthetic */ void getSceneList$annotations() {
        }
    }

    ILinkmicMediaParam getLinkmicMediaParam();

    List<Integer> getPlayModeList();

    List<Integer> getSceneList();
}
