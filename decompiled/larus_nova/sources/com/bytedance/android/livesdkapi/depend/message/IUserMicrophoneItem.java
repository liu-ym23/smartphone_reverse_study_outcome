package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/IUserMicrophoneItem;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOrderUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOrderUser$annotations", "()V", "orderUser", "", "Lcom/bytedance/android/livesdkapi/depend/message/IMicrophoneItem;", "getMicrophoneList", "()Ljava/util/List;", "getMicrophoneList$annotations", "microphoneList", "", "isSinging", "()Z", "isSinging$annotations", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IUserMicrophoneItem extends c<IUserMicrophoneItem> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "microphone_list")
        public static /* synthetic */ void getMicrophoneList$annotations() {
        }

        @FieldName(name = "order_user")
        public static /* synthetic */ void getOrderUser$annotations() {
        }

        @FieldName(name = "is_singing")
        public static /* synthetic */ void isSinging$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "microphone_list")
    List<IMicrophoneItem> getMicrophoneList();

    @FieldName(name = "order_user")
    IBaseUser getOrderUser();

    @FieldName(name = "is_singing")
    boolean isSinging();
}
