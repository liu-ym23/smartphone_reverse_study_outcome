package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.RTSJSONObject;
import com.bytedance.rts.foundation.RTSSerializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010)\u001a\u00020*2\n\u0010+\u001a\u00060,j\u0002`-H\u0016J\b\u0010.\u001a\u00020*H\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R:\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusRealtimeSuggest;", "Lcom/bytedance/rts/foundation/RTSSerializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "duration", "", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "icon", "Lcom/bytedance/android/live/broadcast/rts/AnchorStatusImageModel;", "getIcon", "()Lcom/bytedance/android/live/broadcast/rts/AnchorStatusImageModel;", "setIcon", "(Lcom/bytedance/android/live/broadcast/rts/AnchorStatusImageModel;)V", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "panelIcon", "getPanelIcon", "setPanelIcon", "params", "", "Lcom/bytedance/rts/foundation/RTSMap;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "text", "getText", "setText", "mapping", "", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "unmapping", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorStatusRealtimeSuggest extends RTSSerializable {
    private Long duration;
    private AnchorStatusImageModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f59179id;
    private AnchorStatusImageModel panelIcon;
    private Map<String, String> params;
    private String schemaUrl;
    private String text;

    @Override // com.bytedance.rts.foundation.RTSSerializable
    public void unmapping() {
        super.unmapping();
        String r100 = this.f59179id;
        if (r100 == null) goto L5;
        getEncodeData().put("id", r100);
    L5:
        String r101 = this.text;
        if (r101 == null) goto L8;
        getEncodeData().put("text", r101);
    L8:
        String r102 = this.schemaUrl;
        if (r102 == null) goto L11;
        getEncodeData().put(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL, r102);
    L11:
        Long r103 = this.duration;
        if (r103 == null) goto L14;
        long r104 = r103.longValue();
        getEncodeData().put("duration", Long.valueOf(r104));
    L14:
        AnchorStatusImageModel r105 = this.icon;
        if (r105 == null) goto L17;
        getEncodeData().put("icon", r105);
    L17:
        AnchorStatusImageModel r106 = this.panelIcon;
        if (r106 == null) goto L20;
        getEncodeData().put("panel_icon", r106);
    L20:
        Map<String, String> r107 = this.params;
        if (r107 == null) goto L24;
        getEncodeData().put("params", r107);
        return;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final AnchorStatusImageModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f59179id;
    }

    public final AnchorStatusImageModel getPanelIcon() {
        return this.panelIcon;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.rts.foundation.RTSSerializable
    public void mapping(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        super.mapping(r100);
        RTSJSONObject.a r101 = RTSJSONObject.Companion;
        String r102 = RTSJSONObject.a.e(r101, r100, "id");
        if (r102 != null) goto L5;
        r102 = this.f59179id;
    L5:
        this.f59179id = r102;
        String r103 = RTSJSONObject.a.e(r101, r100, "text");
        if (r103 != null) goto L8;
        r103 = this.text;
    L8:
        this.text = r103;
        String r104 = RTSJSONObject.a.e(r101, r100, com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL);
        if (r104 != null) goto L11;
        r104 = this.schemaUrl;
    L11:
        this.schemaUrl = r104;
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter("duration", "key");
        Object r105 = null;
        Object[] r106 = 0;
        Object[] r107 = 0;
        Object[] r108 = 0;
        Object[] r109 = 0;
        Long r110 = RTSJSONObject.a.d(r100, "duration", null);
        if (r110 != null) goto L14;
        r110 = this.duration;
    L14:
        this.duration = r110;
        int r111 = 2;
        if (r100.has("icon") == false) goto L17;
        AnchorStatusImageModel r112 = new AnchorStatusImageModel(new RTSJSONObject(r100.optJSONObject("icon")), r109 == true ? 1 : 0, r111, r108 == true ? 1 : 0);
    L18:
        this.icon = r112;
        if (r100.has("panel_icon") == false) goto L21;
        AnchorStatusImageModel r113 = new AnchorStatusImageModel(new RTSJSONObject(r100.optJSONObject("panel_icon")), r107 == true ? 1 : 0, r111, r106 == true ? 1 : 0);
    L22:
        this.panelIcon = r113;
        Object r114 = optMapList(1, r100.opt("params"), AnonymousClass1.INSTANCE);
        if (TypeIntrinsics.isMutableMap(r114) == false) goto L26;
        r105 = r114;
    L26:
        Map<String, String> r115 = (Map) r105;
        if (r115 != null) goto L29;
        r115 = this.params;
    L29:
        this.params = r115;
        return;
    L21:
        r113 = this.panelIcon;
        goto L22
    L17:
        r112 = this.icon;
        goto L18
    }

    public final void setDuration(Long r100) {
        this.duration = r100;
    }

    public final void setIcon(AnchorStatusImageModel r100) {
        this.icon = r100;
    }

    public final void setId(String r100) {
        this.f59179id = r100;
    }

    public final void setPanelIcon(AnchorStatusImageModel r100) {
        this.panelIcon = r100;
    }

    public final void setParams(Map<String, String> r100) {
        this.params = r100;
    }

    public final void setSchemaUrl(String r100) {
        this.schemaUrl = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public AnchorStatusRealtimeSuggest(RTSJSONObject r100, String r101) {
        super(r100, r101);
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        doInit(false);
        return;
    L7:
        doInit(true);
    }

    public /* synthetic */ AnchorStatusRealtimeSuggest(RTSJSONObject r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
