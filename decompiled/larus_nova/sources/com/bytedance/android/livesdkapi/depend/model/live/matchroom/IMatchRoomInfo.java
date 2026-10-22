package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0007R$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\t\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\t\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\t\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\t\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfoEx;", "", "getMatchHashTag", "()Ljava/lang/String;", "setMatchHashTag", "(Ljava/lang/String;)V", "getMatchHashTag$annotations", "()V", "matchHashTag", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomImInfo;", "getImInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomImInfo;", "setImInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomImInfo;)V", "getImInfo$annotations", "imInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchShareBackground;", "getMatchShareBackground", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchShareBackground;", "setMatchShareBackground", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchShareBackground;)V", "getMatchShareBackground$annotations", "matchShareBackground", "getThemeId", "setThemeId", "getThemeId$annotations", "themeId", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchData;", "getMatchData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchData;", "setMatchData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchData;)V", "getMatchData$annotations", "matchData", "Lpy/k;", "getShareIcon", "()Lpy/k;", "setShareIcon", "(Lpy/k;)V", "getShareIcon$annotations", BdpAwemeConstant.KEY_SHARE_ICON, "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTabFrame;", "getMatchTabFrame", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTabFrame;", "setMatchTabFrame", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTabFrame;)V", "getMatchTabFrame$annotations", "matchTabFrame", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTitle;", "getMatchTitle", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTitle;", "setMatchTitle", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTitle;)V", "getMatchTitle$annotations", "matchTitle", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMatchRoomInfo extends c<IMatchRoomInfo>, IMatchRoomInfoEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "im_info")
        public static /* synthetic */ void getImInfo$annotations() {
        }

        @FieldName(name = "match_data")
        public static /* synthetic */ void getMatchData$annotations() {
        }

        @FieldName(name = "match_hash_tag")
        public static /* synthetic */ void getMatchHashTag$annotations() {
        }

        @FieldName(name = "match_share_background")
        public static /* synthetic */ void getMatchShareBackground$annotations() {
        }

        @FieldName(name = "match_tab_frame")
        public static /* synthetic */ void getMatchTabFrame$annotations() {
        }

        @FieldName(name = "match_title")
        public static /* synthetic */ void getMatchTitle$annotations() {
        }

        @FieldName(name = "share_icon")
        public static /* synthetic */ void getShareIcon$annotations() {
        }

        @FieldName(name = "theme_id")
        public static /* synthetic */ void getThemeId$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "im_info")
    IMatchRoomImInfo getImInfo();

    @FieldName(name = "match_data")
    IMatchData getMatchData();

    @FieldName(name = "match_hash_tag")
    String getMatchHashTag();

    @FieldName(name = "match_share_background")
    IMatchShareBackground getMatchShareBackground();

    @FieldName(name = "match_tab_frame")
    IMatchTabFrame getMatchTabFrame();

    @FieldName(name = "match_title")
    IMatchTitle getMatchTitle();

    @FieldName(name = "share_icon")
    k getShareIcon();

    @FieldName(name = "theme_id")
    String getThemeId();

    @FieldName(name = "im_info#setter")
    void setImInfo(IMatchRoomImInfo r100);

    @FieldName(name = "match_data#setter")
    void setMatchData(IMatchData r100);

    @FieldName(name = "match_hash_tag#setter")
    void setMatchHashTag(String r100);

    @FieldName(name = "match_share_background#setter")
    void setMatchShareBackground(IMatchShareBackground r100);

    @FieldName(name = "match_tab_frame#setter")
    void setMatchTabFrame(IMatchTabFrame r100);

    @FieldName(name = "match_title#setter")
    void setMatchTitle(IMatchTitle r100);

    @FieldName(name = "share_icon#setter")
    void setShareIcon(k r100);

    @FieldName(name = "theme_id#setter")
    void setThemeId(String r100);
}
