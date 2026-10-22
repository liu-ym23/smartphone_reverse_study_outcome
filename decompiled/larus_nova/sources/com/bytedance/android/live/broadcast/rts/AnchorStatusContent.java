package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.RTSJSONObject;
import com.bytedance.rts.foundation.RTSSerializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusContent;", "Lcom/bytedance/rts/foundation/RTSSerializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "accessibilityText", "getAccessibilityText", "()Ljava/lang/String;", "setAccessibilityText", "(Ljava/lang/String;)V", "fontColor", "getFontColor", "setFontColor", "level", "", "getLevel", "()Ljava/lang/Long;", "setLevel", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "name", "getName", "setName", "mapping", "", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "unmapping", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorStatusContent extends RTSSerializable {
    private String accessibilityText;
    private String fontColor;
    private Long level;
    private String name;

    @Override // com.bytedance.rts.foundation.RTSSerializable
    public void unmapping() {
        super.unmapping();
        String r100 = this.name;
        if (r100 == null) goto L5;
        getEncodeData().put("name", r100);
    L5:
        String r101 = this.fontColor;
        if (r101 == null) goto L8;
        getEncodeData().put("font_color", r101);
    L8:
        Long r102 = this.level;
        if (r102 == null) goto L11;
        long r103 = r102.longValue();
        getEncodeData().put("level", Long.valueOf(r103));
    L11:
        String r104 = this.accessibilityText;
        if (r104 == null) goto L15;
        getEncodeData().put("alternative_text", r104);
        return;
    }

    public final String getAccessibilityText() {
        return this.accessibilityText;
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final Long getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.bytedance.rts.foundation.RTSSerializable
    public void mapping(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        super.mapping(r100);
        RTSJSONObject.a r101 = RTSJSONObject.Companion;
        String r102 = RTSJSONObject.a.e(r101, r100, "name");
        if (r102 != null) goto L5;
        r102 = this.name;
    L5:
        this.name = r102;
        String r103 = RTSJSONObject.a.e(r101, r100, "font_color");
        if (r103 != null) goto L8;
        r103 = this.fontColor;
    L8:
        this.fontColor = r103;
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter("level", "key");
        Long r104 = RTSJSONObject.a.d(r100, "level", null);
        if (r104 != null) goto L11;
        r104 = this.level;
    L11:
        this.level = r104;
        String r105 = RTSJSONObject.a.e(r101, r100, "alternative_text");
        if (r105 != null) goto L14;
        r105 = this.accessibilityText;
    L14:
        this.accessibilityText = r105;
    }

    public final void setAccessibilityText(String r100) {
        this.accessibilityText = r100;
    }

    public final void setFontColor(String r100) {
        this.fontColor = r100;
    }

    public final void setLevel(Long r100) {
        this.level = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public AnchorStatusContent(RTSJSONObject r100, String r101) {
        super(r100, r101);
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        doInit(false);
        return;
    L7:
        doInit(true);
    }

    public /* synthetic */ AnchorStatusContent(RTSJSONObject r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
