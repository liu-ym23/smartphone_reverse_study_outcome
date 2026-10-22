package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import com.alipay.sdk.m.x.d;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTab;", "Lvh7/c;", "", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "getId$annotations", "()V", "id", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getTitle$annotations", "title", "getSchema", "setSchema", "getSchema$annotations", "schema", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMatchTab extends c<IMatchTab> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "id")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "schema")
        public static /* synthetic */ void getSchema$annotations() {
        }

        @FieldName(name = "title")
        public static /* synthetic */ void getTitle$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "id")
    Long getId();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "id#setter")
    void setId(Long r100);

    @FieldName(name = "schema#setter")
    void setSchema(String r100);

    @FieldName(name = "title#setter")
    void setTitle(String r100);
}
