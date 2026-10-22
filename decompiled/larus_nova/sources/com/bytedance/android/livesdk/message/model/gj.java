package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RealtimeSuggest")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/gj;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "text", "getText", "setText", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "", "duration", "I", "getDuration", "()I", "setDuration", "(I)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "panelIcon", "getPanelIcon", "setPanelIcon", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class gj implements vh7.h {

    @SerializedName("duration")
    protected int duration;

    @SerializedName("icon")
    protected ImageModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected String f153650id;

    @SerializedName("panel_icon")
    protected ImageModel panelIcon;

    @SerializedName("params")
    protected Map<String, String> params;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    protected String schemaUrl;

    @SerializedName("text")
    protected String text;

    public gj() {
        this.f153650id = "";
        this.text = "";
        this.schemaUrl = "";
    }

    public gj(am3.g r110) {
        this.params = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L31;
        switch(r101) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L8:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = am3.h.c(r110);
        goto L8
    L13:
        if (r105 != 2) goto L14;
        r104 = am3.h.c(r110);
        goto L8
    L14:
        am3.h.e(r110);
        goto L8
    L17:
        r110.d(r102);
        Map<String, String> r106 = this.params;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.panelIcon = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L26:
        this.icon = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L27:
        this.duration = r110.i();
        goto L3
    L28:
        this.schemaUrl = am3.h.c(r110);
        goto L3
    L29:
        this.text = am3.h.c(r110);
        goto L3
    L30:
        this.f153650id = am3.h.c(r110);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L31:
        r110.d(r100);
        if (this.f153650id != null) goto L35;
        this.f153650id = "";
    L35:
        if (this.text != null) goto L38;
        this.text = "";
    L38:
        if (this.schemaUrl != null) goto L70;
        this.schemaUrl = "";
        return;
    }
}
