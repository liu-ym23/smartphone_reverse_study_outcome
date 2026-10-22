package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/model/ICommunityRoom;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "", "getLabels", "()Ljava/lang/String;", "setLabels", "(Ljava/lang/String;)V", "getLabels$annotations", "()V", "labels", "Lcom/bytedance/android/livesdk/interactivity/service/model/a;", "getCommentConfig", "()Lcom/bytedance/android/livesdk/interactivity/service/model/a;", "setCommentConfig", "(Lcom/bytedance/android/livesdk/interactivity/service/model/a;)V", "getCommentConfig$annotations", "commentConfig", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICommunityRoom extends vh7.e<IRoom>, IRoom {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "comment_box")
    com.bytedance.android.livesdk.interactivity.service.model.a getCommentConfig();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom
    @FieldName(name = "common_label_list")
    String getLabels();

    @FieldName(name = "comment_box#setter")
    void setCommentConfig(com.bytedance.android.livesdk.interactivity.service.model.a r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom
    @FieldName(name = "common_label_list#setter")
    void setLabels(String r100);
}
