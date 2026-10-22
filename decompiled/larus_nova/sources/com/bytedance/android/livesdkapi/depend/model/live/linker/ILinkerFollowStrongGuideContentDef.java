package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerFollowStrongGuideContentDef;", "", "fromUserType", "", "getFromUserType$annotations", "()V", "getFromUserType", "()I", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getUser$annotations", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerFollowStrongGuideContentDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = ILiveRoomPlayFragmentConstant.AUTO_LINK_MIC_FROM_TYPE)
        public static /* synthetic */ void getFromUserType$annotations() {
        }

        @FieldName(name = "from_user")
        public static /* synthetic */ void getUser$annotations() {
        }
    }

    int getFromUserType();

    IBaseUser getUser();
}
