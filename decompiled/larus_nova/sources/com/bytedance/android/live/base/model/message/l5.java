package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H&R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u001c\u0010\u0011R\u001a\u0010!\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\b\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010&\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\b\u001a\u0004\b#\u0010$R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020(0'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u0006."}, d2 = {"Lcom/bytedance/android/live/base/model/message/l5;", "Lvh7/c;", "", "getMsgLogId", "", "getComponentType", "()I", "getComponentType$annotations", "()V", "componentType", "getEventType", "getEventType$annotations", "eventType", "getOpType", "getOpType$annotations", "opType", "getText", "()Ljava/lang/String;", "getText$annotations", "text", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "getSchema", "getSchema$annotations", "schema", "getExtraData", "getExtraData$annotations", ControlRule.KEY_EXTRA_DATA, "getGroupId", "getGroupId$annotations", "groupId", "", "getShowType", "()J", "getShowType$annotations", "showType", "", "Lcom/bytedance/android/live/base/model/message/k5;", "getLowList", "()Ljava/util/List;", "lowList", "getHighList", "highList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l5 extends vh7.c<l5> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "component_type")
    int getComponentType();

    @FieldName(name = "event_type")
    int getEventType();

    @FieldName(name = "extra")
    String getExtraData();

    @FieldName(name = "group_id")
    int getGroupId();

    List<k5> getHighList();

    @FieldName(name = "icon")
    py.k getIcon();

    List<k5> getLowList();

    String getMsgLogId();

    @FieldName(name = "op_type")
    int getOpType();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    String getSchema();

    @FieldName(name = "show_type")
    long getShowType();

    @FieldName(name = "text")
    String getText();
}
