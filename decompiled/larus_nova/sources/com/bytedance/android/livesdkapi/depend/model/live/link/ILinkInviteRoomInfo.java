package com.bytedance.android.livesdkapi.depend.model.live.link;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfo;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfoDef;", "", "Lcom/bytedance/android/livesdkapi/message/Text;", "getTags", "()Ljava/util/List;", "getTags$annotations", "()V", PromotionProductPrivilegesStruct.TAGS, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkInviteRoomInfo extends c<ILinkInviteRoomInfo>, ILinkInviteRoomInfoDef {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
        public static /* synthetic */ void getTags$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<? extends Text> getTags();
}
