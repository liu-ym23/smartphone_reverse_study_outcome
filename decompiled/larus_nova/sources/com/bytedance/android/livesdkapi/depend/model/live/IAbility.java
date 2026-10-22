package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eRB\u0010 \u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IAbility;", "Lvh7/c;", "", "getType", "()J", "setType", "(J)V", "getType$annotations", "()V", "type", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getText$annotations", "text", "getSchema", "setSchema", "getSchema$annotations", "schema", "getName", "setName", "getName$annotations", "name", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "getParams$annotations", "params", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IAbility extends c<IAbility> {
    public static final Companion Companion = null;
    public static final long TYPE_REQUEST = 2;
    public static final long TYPE_SCHEMA = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IAbility$Companion;", "", "()V", "TYPE_REQUEST", "", "TYPE_SCHEMA", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final long TYPE_REQUEST = 2;
        public static final long TYPE_SCHEMA = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "name")
        public static /* synthetic */ void getName$annotations() {
        }

        @FieldName(name = "params")
        public static /* synthetic */ void getParams$annotations() {
        }

        @FieldName(name = "schema")
        public static /* synthetic */ void getSchema$annotations() {
        }

        @FieldName(name = "text")
        public static /* synthetic */ void getText$annotations() {
        }

        @FieldName(name = "type")
        public static /* synthetic */ void getType$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "params")
    Map<String, String> getParams();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "type")
    long getType();

    @FieldName(name = "name#setter")
    void setName(String r100);

    @FieldName(name = "params#setter")
    void setParams(Map<String, String> r100);

    @FieldName(name = "schema#setter")
    void setSchema(String r100);

    @FieldName(name = "text#setter")
    void setText(String r100);

    @FieldName(name = "type#setter")
    void setType(long r100);
}
