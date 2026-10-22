package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.RTSJSONObject;
import com.bytedance.rts.foundation.RTSSerializable;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060%j\u0002`&H\u0016J\b\u0010'\u001a\u00020#H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000b¨\u0006("}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusTab;", "Lcom/bytedance/rts/foundation/RTSSerializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", RuleConditionBean.BIZ_DATA_KEY, "getBizData", "()Ljava/lang/String;", "setBizData", "(Ljava/lang/String;)V", "bizMessage", "getBizMessage", "setBizMessage", "bizSchemaUrl", "getBizSchemaUrl", "setBizSchemaUrl", "key", "getKey", "setKey", "name", "getName", "setName", "schemaType", "", "getSchemaType", "()Ljava/lang/Integer;", "setSchemaType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "mapping", "", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "unmapping", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorStatusTab extends RTSSerializable {
    private String bizData;
    private String bizMessage;
    private String bizSchemaUrl;
    private String key;
    private String name;
    private Integer schemaType;
    private String schemaUrl;

    @Override // com.bytedance.rts.foundation.RTSSerializable
    public void unmapping() {
        super.unmapping();
        String r100 = this.key;
        if (r100 == null) goto L5;
        getEncodeData().put("key", r100);
    L5:
        String r101 = this.name;
        if (r101 == null) goto L8;
        getEncodeData().put("name", r101);
    L8:
        Integer r102 = this.schemaType;
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
        getEncodeData().put("schema_type", Integer.valueOf(r103));
    L11:
        String r104 = this.schemaUrl;
        if (r104 == null) goto L14;
        getEncodeData().put(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL, r104);
    L14:
        String r105 = this.bizSchemaUrl;
        if (r105 == null) goto L17;
        getEncodeData().put("biz_schema_url", r105);
    L17:
        String r106 = this.bizData;
        if (r106 == null) goto L20;
        getEncodeData().put("biz_data", r106);
    L20:
        String r107 = this.bizMessage;
        if (r107 == null) goto L24;
        getEncodeData().put("biz_message", r107);
        return;
    }

    public final String getBizData() {
        return this.bizData;
    }

    public final String getBizMessage() {
        return this.bizMessage;
    }

    public final String getBizSchemaUrl() {
        return this.bizSchemaUrl;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSchemaType() {
        return this.schemaType;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    @Override // com.bytedance.rts.foundation.RTSSerializable
    public void mapping(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        super.mapping(r100);
        RTSJSONObject.a r101 = RTSJSONObject.Companion;
        String r102 = RTSJSONObject.a.e(r101, r100, "key");
        if (r102 != null) goto L5;
        r102 = this.key;
    L5:
        this.key = r102;
        String r103 = RTSJSONObject.a.e(r101, r100, "name");
        if (r103 != null) goto L8;
        r103 = this.name;
    L8:
        this.name = r103;
        Integer r104 = RTSJSONObject.a.b(r101, r100, "schema_type");
        if (r104 != null) goto L11;
        r104 = this.schemaType;
    L11:
        this.schemaType = r104;
        String r105 = RTSJSONObject.a.e(r101, r100, com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL);
        if (r105 != null) goto L14;
        r105 = this.schemaUrl;
    L14:
        this.schemaUrl = r105;
        String r106 = RTSJSONObject.a.e(r101, r100, "biz_schema_url");
        if (r106 != null) goto L17;
        r106 = this.bizSchemaUrl;
    L17:
        this.bizSchemaUrl = r106;
        String r107 = RTSJSONObject.a.e(r101, r100, "biz_data");
        if (r107 != null) goto L20;
        r107 = this.bizData;
    L20:
        this.bizData = r107;
        String r108 = RTSJSONObject.a.e(r101, r100, "biz_message");
        if (r108 != null) goto L23;
        r108 = this.bizMessage;
    L23:
        this.bizMessage = r108;
    }

    public final void setBizData(String r100) {
        this.bizData = r100;
    }

    public final void setBizMessage(String r100) {
        this.bizMessage = r100;
    }

    public final void setBizSchemaUrl(String r100) {
        this.bizSchemaUrl = r100;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSchemaType(Integer r100) {
        this.schemaType = r100;
    }

    public final void setSchemaUrl(String r100) {
        this.schemaUrl = r100;
    }

    public AnchorStatusTab(RTSJSONObject r100, String r101) {
        super(r100, r101);
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        doInit(false);
        return;
    L7:
        doInit(true);
    }

    public /* synthetic */ AnchorStatusTab(RTSJSONObject r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
