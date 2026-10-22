package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0011\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u001a\u0010\fR\"\u0010 \u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\b\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSToolbarConfigData;", "Lvh7/c;", "", "getToolbarType", "()I", "setToolbarType", "(I)V", "getToolbarType$annotations", "()V", "toolbarType", "Lpy/k;", "getVerticalIcon", "()Lpy/k;", "setVerticalIcon", "(Lpy/k;)V", "getVerticalIcon$annotations", "verticalIcon", "getIcon", "getIcon$annotations", "icon", "getBottomIcon", "getBottomIcon$annotations", "bottomIcon", "getDynamicBottomIcon", "getDynamicBottomIcon$annotations", "dynamicBottomIcon", "getDynamicIcon", "getDynamicIcon$annotations", "dynamicIcon", "getDisplayType", "setDisplayType", "getDisplayType$annotations", "displayType", "", "getSchema", "()Ljava/lang/String;", "getSchema$annotations", "schema", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVSToolbarConfigData extends c<IVSToolbarConfigData> {
    public static final Companion Companion = null;
    public static final int TYPE_GIFT = 5;
    public static final int TYPE_VS_TOPIC = 8;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSToolbarConfigData$Companion;", "", "()V", "TYPE_GIFT", "", "TYPE_VS_TOPIC", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int TYPE_GIFT = 5;
        public static final int TYPE_VS_TOPIC = 8;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "bottom_icon")
        public static /* synthetic */ void getBottomIcon$annotations() {
        }

        @FieldName(name = "display_type")
        public static /* synthetic */ void getDisplayType$annotations() {
        }

        @FieldName(name = "dynamic_bottom_icon")
        public static /* synthetic */ void getDynamicBottomIcon$annotations() {
        }

        @FieldName(name = "dynamic_icon")
        public static /* synthetic */ void getDynamicIcon$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "jump_schema")
        public static /* synthetic */ void getSchema$annotations() {
        }

        @FieldName(name = "toolbar_type")
        public static /* synthetic */ void getToolbarType$annotations() {
        }

        @FieldName(name = "icon_vertical")
        public static /* synthetic */ void getVerticalIcon$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "bottom_icon")
    k getBottomIcon();

    @FieldName(name = "display_type")
    int getDisplayType();

    @FieldName(name = "dynamic_bottom_icon")
    k getDynamicBottomIcon();

    @FieldName(name = "dynamic_icon")
    k getDynamicIcon();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = "jump_schema")
    String getSchema();

    @FieldName(name = "toolbar_type")
    int getToolbarType();

    @FieldName(name = "icon_vertical")
    k getVerticalIcon();

    @FieldName(name = "display_type#setter")
    void setDisplayType(int r100);

    @FieldName(name = "toolbar_type#setter")
    void setToolbarType(int r100);

    @FieldName(name = "icon_vertical#setter")
    void setVerticalIcon(k r100);
}
