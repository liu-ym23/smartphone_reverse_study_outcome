package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/base/model/message/w2;", "Lvh7/c;", "", "getMvOperate", "()I", "getMvOperate$annotations", "()V", "mvOperate", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IOrderSingMVInfo;", "getMvInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/IOrderSingMVInfo;", "getMvInfo$annotations", "mvInfo", "", "getOpToast", "()Ljava/lang/String;", "getOpToast$annotations", "opToast", "getItemId", "getItemId$annotations", "itemId", "getOpSource", "getOpSource$annotations", "opSource", "getSingerId", "singerId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w2 extends vh7.c<w2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "item_id")
    String getItemId();

    @FieldName(name = "mv_info")
    IOrderSingMVInfo getMvInfo();

    @FieldName(name = "mv_op")
    int getMvOperate();

    @FieldName(name = "op_source")
    String getOpSource();

    @FieldName(name = "op_toast")
    String getOpToast();

    String getSingerId();
}
