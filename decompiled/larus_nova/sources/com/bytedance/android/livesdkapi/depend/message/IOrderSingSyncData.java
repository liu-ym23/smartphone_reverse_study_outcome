package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/IOrderSingSyncData;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IOrderSingMVInfo;", "getMvInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/IOrderSingMVInfo;", "getMvInfo$annotations", "()V", "mvInfo", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IOrderSingSyncData extends c<IOrderSingSyncData> {
    public static final Companion Companion = null;
    public static final String SYNC_KEY = "OrderSingSyncData";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/IOrderSingSyncData$Companion;", "", "()V", "SYNC_KEY", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String SYNC_KEY = "OrderSingSyncData";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "mv_info")
        public static /* synthetic */ void getMvInfo$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "mv_info")
    IOrderSingMVInfo getMvInfo();
}
