package com.bytedance.android.livesdkapi.depend.model.live.link;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessSelectGuestsContent;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfo;", "getGuestInfos", "()Ljava/util/List;", "getGuestInfos$annotations", "()V", "guestInfos", "", "getMaxMember", "()Ljava/lang/String;", "getMaxMember$annotations", "maxMember", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomBattleProcessSelectGuestsContent extends c<IRoomBattleProcessSelectGuestsContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "guest_infos")
        public static /* synthetic */ void getGuestInfos$annotations() {
        }

        @FieldName(name = "max_member")
        public static /* synthetic */ void getMaxMember$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "guest_infos")
    List<LinkRoomFightReplyGuestInfo> getGuestInfos();

    @FieldName(name = "max_member")
    String getMaxMember();
}
