package com.bytedance.android.livesdkapi.depend.message.crossroom;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001RB\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tRB\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfo;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdkapi/depend/message/crossroom/UserInfo;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getUserInfos", "()Ljava/util/Map;", "setUserInfos", "(Ljava/util/Map;)V", "getUserInfos$annotations", "()V", "userInfos", "", "getOpenUserInfos", "setOpenUserInfos", "getOpenUserInfos$annotations", "openUserInfos", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface CrossRoomLinkmicUIInfo extends c<CrossRoomLinkmicUIInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "open_user_infos")
        public static /* synthetic */ void getOpenUserInfos$annotations() {
        }

        @FieldName(name = "user_infos")
        public static /* synthetic */ void getUserInfos$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "open_user_infos")
    Map<String, UserInfo> getOpenUserInfos();

    @FieldName(name = "user_infos")
    Map<Long, UserInfo> getUserInfos();

    @FieldName(name = "open_user_infos#setter")
    void setOpenUserInfos(Map<String, ? extends UserInfo> r100);

    @FieldName(name = "user_infos#setter")
    void setUserInfos(Map<Long, ? extends UserInfo> r100);
}
