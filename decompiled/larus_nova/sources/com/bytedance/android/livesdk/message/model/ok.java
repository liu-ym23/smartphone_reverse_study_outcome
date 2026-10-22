package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010#\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u0006R$\u0010'\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ok;", "Lvh7/c;", "", "getId", "()J", "setId", "(J)V", "getId$annotations", "()V", "id", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "getTitle$annotations", "title", "getDescription", "setDescription", "getDescription$annotations", "description", "Lcom/bytedance/android/livesdk/chatroom/model/h3;", "getTitleStyle", "()Lcom/bytedance/android/livesdk/chatroom/model/h3;", "setTitleStyle", "(Lcom/bytedance/android/livesdk/chatroom/model/h3;)V", "getTitleStyle$annotations", "titleStyle", "getDescriptionStyle", "setDescriptionStyle", "getDescriptionStyle$annotations", "descriptionStyle", "getVersion", "setVersion", "getVersion$annotations", "version", "getShowId", "setShowId", "getShowId$annotations", "showId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ok extends vh7.c<ok> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "description")
    String getDescription();

    @FieldName(name = "description_style")
    com.bytedance.android.livesdk.chatroom.model.h3 getDescriptionStyle();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "show_id")
    String getShowId();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "title_style")
    com.bytedance.android.livesdk.chatroom.model.h3 getTitleStyle();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "description#setter")
    void setDescription(String r100);

    @FieldName(name = "description_style#setter")
    void setDescriptionStyle(com.bytedance.android.livesdk.chatroom.model.h3 r100);

    @FieldName(name = "id#setter")
    void setId(long r100);

    @FieldName(name = "show_id#setter")
    void setShowId(String r100);

    @FieldName(name = "title#setter")
    void setTitle(String r100);

    @FieldName(name = "title_style#setter")
    void setTitleStyle(com.bytedance.android.livesdk.chatroom.model.h3 r100);

    @FieldName(name = "version#setter")
    void setVersion(long r100);
}
