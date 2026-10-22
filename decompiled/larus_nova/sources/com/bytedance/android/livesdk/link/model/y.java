package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\u0017\u0018\u0019R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/y;", "Lvh7/c;", "", "getTeamTaskStatus", "()I", "getTeamTaskStatus$annotations", "()V", "teamTaskStatus", "Lcom/bytedance/android/livesdk/link/model/y$c;", "getDeliveryTeamTaskInfo", "()Lcom/bytedance/android/livesdk/link/model/y$c;", "getDeliveryTeamTaskInfo$annotations", "deliveryTeamTaskInfo", "Lcom/bytedance/android/livesdk/link/model/y$a;", "getBattleOpenTeamTaskInfo", "()Lcom/bytedance/android/livesdk/link/model/y$a;", "getBattleOpenTeamTaskInfo$annotations", "battleOpenTeamTaskInfo", "", "getUiResource", "()Ljava/lang/String;", "getUiResource$annotations", "uiResource", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "d", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y extends vh7.c<y> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001e\u0010\u0016\u001a\u00060\u0011j\u0002`\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/y$a;", "Lvh7/c;", "", "getAnchorId", "()Ljava/lang/String;", "getAnchorId$annotations", "()V", "anchorId", "getRoomId", "getRoomId$annotations", "roomId", "getUserId", "getUserId$annotations", "userId", "getNickname", "getNickname$annotations", InstantPlayContext.NICKNAME, "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getUserAvatar", "()Lpy/k;", "getUserAvatar$annotations", "userAvatar", "getAnchorOpenId", "getAnchorOpenId$annotations", "anchorOpenId", "getUserOpenId", "getUserOpenId$annotations", "userOpenId", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.c<a> {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.link.model.y$a$a, reason: collision with other inner class name */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C2291a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "anchor_id")
        String getAnchorId();

        @FieldName(name = "anchor_open_id")
        String getAnchorOpenId();

        @FieldName(name = InstantPlayContext.NICKNAME)
        String getNickname();

        @FieldName(name = "room_id")
        String getRoomId();

        @FieldName(name = "user_avatar")
        py.k getUserAvatar();

        @FieldName(name = "user_id")
        String getUserId();

        @FieldName(name = "user_open_id")
        String getUserOpenId();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\"\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b#\u0010\u0004R\u001a\u0010(\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0006\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/y$c;", "Lvh7/c;", "", "getAnchorId", "()Ljava/lang/String;", "getAnchorId$annotations", "()V", "anchorId", "getRoomId", "getRoomId$annotations", "roomId", "getUserId", "getUserId$annotations", "userId", "", "Lcom/bytedance/android/livesdk/link/model/y$d;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPopupAnchorInfo", "()Ljava/util/List;", "getPopupAnchorInfo$annotations", "popupAnchorInfo", "getPopupTitle", "getPopupTitle$annotations", "popupTitle", "getPopupDesc", "getPopupDesc$annotations", "popupDesc", "getPopupSubDesc", "getPopupSubDesc$annotations", "popupSubDesc", "", "getScoreGap", "()I", "getScoreGap$annotations", "scoreGap", "getAnchorOpenId", "getAnchorOpenId$annotations", "anchorOpenId", "getUserOpenId", "getUserOpenId$annotations", "userOpenId", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "anchor_id")
        String getAnchorId();

        @FieldName(name = "anchor_open_id")
        String getAnchorOpenId();

        @FieldName(name = "popup_anchor_info")
        List<d> getPopupAnchorInfo();

        @FieldName(name = "popup_desc")
        String getPopupDesc();

        @FieldName(name = "popup_sub_desc")
        String getPopupSubDesc();

        @FieldName(name = "popup_title")
        String getPopupTitle();

        @FieldName(name = "room_id")
        String getRoomId();

        @FieldName(name = "score_gap")
        int getScoreGap();

        @FieldName(name = "user_id")
        String getUserId();

        @FieldName(name = "user_open_id")
        String getUserOpenId();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001e\u0010\u0010\u001a\u00060\u000bj\u0002`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/y$d;", "Lvh7/c;", "", "getAnchorId", "()Ljava/lang/String;", "getAnchorId$annotations", "()V", "anchorId", "getRoomId", "getRoomId$annotations", "roomId", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAnchorAvatar", "()Lpy/k;", "getAnchorAvatar$annotations", "anchorAvatar", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface d extends vh7.c<d> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "anchor_avatar")
        py.k getAnchorAvatar();

        @FieldName(name = "anchor_id")
        String getAnchorId();

        @FieldName(name = "room_id")
        String getRoomId();
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_open_team_task_info")
    a getBattleOpenTeamTaskInfo();

    @FieldName(name = "delivery_team_task_info")
    c getDeliveryTeamTaskInfo();

    @FieldName(name = "team_task_status")
    int getTeamTaskStatus();

    @FieldName(name = "ui_resource")
    String getUiResource();
}
