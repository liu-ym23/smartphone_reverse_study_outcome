package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000fR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorPointItem;", "Lvh7/c;", "", "getType", "()Ljava/lang/Integer;", "getType$annotations", "()V", "type", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "", "getContent", "()Ljava/lang/String;", "getContent$annotations", "content", "getButtonText", "getButtonText$annotations", "buttonText", "getButtonSchemaUrl", "getButtonSchemaUrl$annotations", "buttonSchemaUrl", "", "getExtra", "()Ljava/util/Map;", "getExtra$annotations", "extra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IAnchorPointItem extends c<IAnchorPointItem> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "button_schema_url")
        public static /* synthetic */ void getButtonSchemaUrl$annotations() {
        }

        @FieldName(name = "button_text")
        public static /* synthetic */ void getButtonText$annotations() {
        }

        @FieldName(name = "content")
        public static /* synthetic */ void getContent$annotations() {
        }

        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "type")
        public static /* synthetic */ void getType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "button_schema_url")
    String getButtonSchemaUrl();

    @FieldName(name = "button_text")
    String getButtonText();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = "type")
    Integer getType();
}
