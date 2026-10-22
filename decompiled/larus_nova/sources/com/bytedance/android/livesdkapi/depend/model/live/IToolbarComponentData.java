package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\b\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\"\u0010%\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\b\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010\u0006R\"\u0010)\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\b\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010\u0006¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IToolbarComponentData;", "Lvh7/c;", "", "getId", "()I", "setId", "(I)V", "getId$annotations", "()V", "id", "getOperate", "setOperate", "getOperate$annotations", "operate", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getName$annotations", "name", "getScheme", "setScheme", "getScheme$annotations", "scheme", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "getExtraData", "setExtraData", "getExtraData$annotations", ControlRule.KEY_EXTRA_DATA, "getGroupId", "setGroupId", "getGroupId$annotations", "groupId", "getShowType", "setShowType", "getShowType$annotations", "showType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IToolbarComponentData extends c<IToolbarComponentData> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "extra")
        public static /* synthetic */ void getExtraData$annotations() {
        }

        @FieldName(name = "group_id")
        public static /* synthetic */ void getGroupId$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "component_type")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "text")
        public static /* synthetic */ void getName$annotations() {
        }

        @FieldName(name = "op_type")
        public static /* synthetic */ void getOperate$annotations() {
        }

        @FieldName(name = a.KEY_SCHEMA_URL)
        public static /* synthetic */ void getScheme$annotations() {
        }

        @FieldName(name = "show_type")
        public static /* synthetic */ void getShowType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "extra")
    String getExtraData();

    @FieldName(name = "group_id")
    int getGroupId();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = "component_type")
    int getId();

    @FieldName(name = "text")
    String getName();

    @FieldName(name = "op_type")
    int getOperate();

    @FieldName(name = a.KEY_SCHEMA_URL)
    String getScheme();

    @FieldName(name = "show_type")
    int getShowType();

    @FieldName(name = "extra#setter")
    void setExtraData(String r100);

    @FieldName(name = "group_id#setter")
    void setGroupId(int r100);

    @FieldName(name = "component_type#setter")
    void setId(int r100);

    @FieldName(name = "text#setter")
    void setName(String r100);

    @FieldName(name = "op_type#setter")
    void setOperate(int r100);

    @FieldName(name = "schema_url#setter")
    void setScheme(String r100);

    @FieldName(name = "show_type#setter")
    void setShowType(int r100);
}
