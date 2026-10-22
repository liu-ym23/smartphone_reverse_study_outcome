package com.bytedance.android.livesdkapi.depend.model.live.link;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "Lvh7/c;", "", "getProcessStatus", "()I", "getProcessStatus$annotations", "()V", "processStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessWaitingBattleContent;", "getWaitingBattleContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessWaitingBattleContent;", "getWaitingBattleContent$annotations", "waitingBattleContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessSelectGuestsContent;", "getSelectGuestsContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessSelectGuestsContent;", "getSelectGuestsContent$annotations", "selectGuestsContent", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomBattleProcessInfo extends c<IRoomBattleProcessInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "status")
        public static /* synthetic */ void getProcessStatus$annotations() {
        }

        @FieldName(name = "select_guests_content")
        public static /* synthetic */ void getSelectGuestsContent$annotations() {
        }

        @FieldName(name = "waiting_battle_content")
        public static /* synthetic */ void getWaitingBattleContent$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "status")
    int getProcessStatus();

    @FieldName(name = "select_guests_content")
    IRoomBattleProcessSelectGuestsContent getSelectGuestsContent();

    @FieldName(name = "waiting_battle_content")
    IRoomBattleProcessWaitingBattleContent getWaitingBattleContent();
}
