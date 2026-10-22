package com.bytedance.android.livesdk.link.model.main;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.link.model.bridge.o;
import com.bytedance.android.livesdk.link.model.t0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\n\u000bR\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/main/b;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/o;", "Lcom/bytedance/android/livesdk/link/model/t0;", "Lcom/bytedance/android/livesdk/link/model/main/b$c;", "getUpdateContent", "()Lcom/bytedance/android/livesdk/link/model/main/b$c;", "getUpdateContent$annotations", "()V", "updateContent", "b", "c", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface b extends e<o>, t0 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.link.model.main.b$b, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/main/b$b;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/t0$a;", "", "getNoNeedUpdateScore", "()Z", "getNoNeedUpdateScore$annotations", "()V", "noNeedUpdateScore", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public interface InterfaceC2288b extends e<t0.a>, t0.a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.link.model.main.b$b$a */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // com.bytedance.android.livesdk.link.model.t0.a, vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // com.bytedance.android.livesdk.link.model.t0.a, vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = "anchor_score")
        /* synthetic */ String getAnchorScore();

        @FieldName(name = "anchor_score_int")
        /* synthetic */ long getAnchorScoreInt();

        @FieldName(name = "auxiliary_img")
        /* synthetic */ k getAuxiliaryImg();

        @FieldName(name = "auxiliary_type")
        /* synthetic */ long getAuxiliaryType();

        @Override // vh7.e
        /* synthetic */ Object getFlexInstance();

        @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
        /* synthetic */ long getGiftId();

        @FieldName(name = "index")
        /* synthetic */ long getIndex();

        @FieldName(name = "no_need_update_score")
        boolean getNoNeedUpdateScore();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R>\u0010\u000b\u001a&\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005`\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/main/b$c;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/UserId;", "Lcom/bytedance/android/livesdk/link/model/t0$a;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getAuxiliaryScoreInfo", "()Ljava/util/Map;", "getAuxiliaryScoreInfo$annotations", "()V", "auxiliaryScoreInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = "auxiliary_score_infos")
        Map<Long, t0.a> getAuxiliaryScoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.t0, com.bytedance.android.livesdk.link.model.bridge.o, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.t0, com.bytedance.android.livesdk.link.model.bridge.o, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.t0
    @FieldName(name = "close_content")
    /* synthetic */ t0.b getCloseContent();

    @Override // com.bytedance.android.livesdk.link.model.t0, com.bytedance.android.livesdk.link.model.bridge.o, yh6.c
    /* synthetic */ m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @Override // com.bytedance.android.livesdk.link.model.t0
    @FieldName(name = "invite_content")
    /* synthetic */ t0.d getInviteContent();

    @Override // com.bytedance.android.livesdk.link.model.t0
    @FieldName(name = "reject_content")
    /* synthetic */ t0.e getRejectContent();

    @Override // com.bytedance.android.livesdk.link.model.t0
    @FieldName(name = "reply_content")
    /* synthetic */ t0.f getReplyContent();

    @Override // com.bytedance.android.livesdk.link.model.t0
    @FieldName(name = "switch_content")
    /* synthetic */ t0.g getSwitchContent();

    @Override // com.bytedance.android.livesdk.link.model.t0
    @FieldName(name = "type")
    /* synthetic */ int getType();

    @FieldName(name = "update_content")
    c getUpdateContent();

    @Override // com.bytedance.android.livesdk.link.model.t0, com.bytedance.android.livesdk.link.model.bridge.o
    /* synthetic */ void setCommonData(m0 r100);
}
