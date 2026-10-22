package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0015R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w4;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/model/s8;", "", "Lcom/bytedance/android/livesdk/link/model/w4$b;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUserArmiesList", "()Ljava/util/List;", "getUserArmiesList$annotations", "()V", "userArmiesList", "Lcom/bytedance/android/livesdk/link/model/y0;", "getRankListV2", "()Lcom/bytedance/android/livesdk/link/model/y0;", "getRankListV2$annotations", "rankListV2", "", "getTopShowText", "()Ljava/lang/String;", "getTopShowText$annotations", "topShowText", "b", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w4 extends vh7.e<com.bytedance.android.livesdk.message.model.s8>, com.bytedance.android.livesdk.message.model.s8 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fR2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w4$b;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/w4$b$b;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUserArmies", "()Ljava/util/List;", "setUserArmies", "(Ljava/util/List;)V", "getUserArmies$annotations", "()V", "userArmies", "b", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.link.model.w4$b$b, reason: collision with other inner class name */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\u000e\u001a\u00020\b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\u0011R*\u0010\u001b\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w4$b$b;", "Lvh7/c;", "", "getUserId", "()Ljava/lang/String;", "getUserId$annotations", "()V", "userId", "", "getScore", "()J", "setScore", "(J)V", "getScore$annotations", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getNickname", "setNickname", "(Ljava/lang/String;)V", "getNickname$annotations", InstantPlayContext.NICKNAME, "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "getAvatar$annotations", "avatar", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
        public interface InterfaceC2290b extends vh7.c<InterfaceC2290b> {

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.link.model.w4$b$b$a */
            @JsonAdapter(FlexModelJsonAdapter.class)
            @Metadata(k = 3, mv = {1, 5, 1})
            public static final class a {
            }

            @Override // vh7.c
            /* synthetic */ vh7.e castTo(Class r100);

            @Override // vh7.c
            /* synthetic */ vh7.e castToOrNull(Class r100);

            @FieldName(name = "avatar_thumb")
            py.k getAvatar();

            @FieldName(name = InstantPlayContext.NICKNAME)
            String getNickname();

            @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCORE)
            long getScore();

            @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
            String getUserId();

            @FieldName(name = "avatar_thumb#setter")
            void setAvatar(py.k r100);

            @FieldName(name = "nickname#setter")
            void setNickname(String r100);

            @FieldName(name = "score#setter")
            void setScore(long r100);
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "user_armies")
        List<InterfaceC2290b> getUserArmies();

        @FieldName(name = "user_armies#setter")
        void setUserArmies(List<? extends InterfaceC2290b> r100);
    }

    @Override // com.bytedance.android.livesdk.message.model.s8, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.message.model.s8, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "rank_list_v2")
    y0 getRankListV2();

    @FieldName(name = "top_show_text")
    String getTopShowText();

    @FieldName(name = "user_armies_list")
    List<b> getUserArmiesList();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
