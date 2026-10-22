package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.AudienceEntranceInfo")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0007R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0007R$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0007R\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0007R\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/e0;", "", "", "interactType", "J", "", "elementId", "Ljava/lang/String;", "startId", "status", "name", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "checkEntranceVisible", "Z", "schemaUrl", "source", "", "punishStatus", "I", "joinEnable", "soreEnable", "imExtra", "logExtra", "entranceExtra", "", "startPageQuery", "Ljava/util/Map;", "visibleType", "entranceSchemaUrl", "extra", "appId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 implements vh7.h {

    @IgnoreProtoFieldCheck
    @SerializedName("app_id")
    @IgnoreProtoDecode
    public String appId;

    @SerializedName("check_entrance_visitable")
    public boolean checkEntranceVisible;

    @SerializedName("elem_id")
    public String elementId;

    @SerializedName("entrance_extra")
    public String entranceExtra;

    @SerializedName("entrance_schema_url")
    public String entranceSchemaUrl;

    @IgnoreProtoFieldCheck
    @SerializedName("extra")
    @IgnoreProtoDecode
    public String extra;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("im_extra")
    public String imExtra;

    @SerializedName("interact_type")
    public long interactType;

    @SerializedName("audience_join_enable")
    public boolean joinEnable;

    @SerializedName("log_extra")
    public String logExtra;

    @SerializedName("name")
    public String name;

    @SerializedName("punish_status")
    public int punishStatus;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    public String schemaUrl;

    @SerializedName("score_enable")
    public boolean soreEnable;

    @SerializedName("source")
    public long source;

    @SerializedName("start_id")
    public long startId;

    @SerializedName("start_page_query")
    public Map<String, String> startPageQuery;

    @SerializedName("status")
    public long status;

    @SerializedName("visible_type")
    public int visibleType;

    public e0() {
        this.name = "";
        this.schemaUrl = "";
        int r100 = hn.f153654a;
        this.visibleType = 2;
    }

    public e0(am3.g r110) {
        this.startPageQuery = new HashMap();
        long r100 = r110.c();
        boolean r101 = false;
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L42;
        switch(r102) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            default: goto L6;
        };
    L35:
        this.checkEntranceVisible = am3.h.a(r110);
        goto L3
    L36:
        this.icon = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L37:
        this.name = am3.h.c(r110);
        goto L3
    L38:
        this.status = r110.j();
        goto L3
    L39:
        this.startId = r110.j();
        goto L3
    L40:
        this.elementId = am3.h.c(r110);
        goto L3
    L41:
        this.interactType = r110.j();
        goto L3
    L6:
        switch(r102) {
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            default: goto L7;
        };
    L30:
        this.soreEnable = am3.h.a(r110);
        goto L3
    L31:
        this.joinEnable = am3.h.a(r110);
        goto L3
    L32:
        this.punishStatus = r110.i();
        goto L3
    L33:
        this.source = r110.i();
        goto L3
    L34:
        this.schemaUrl = am3.h.c(r110);
        goto L3
    L7:
        switch(r102) {
            case 97: goto L29;
            case 98: goto L28;
            case 99: goto L27;
            case 100: goto L11;
            case 101: goto L10;
            case 102: goto L9;
            default: goto L8;
        };
    L9:
        this.entranceSchemaUrl = am3.h.c(r110);
        goto L3
    L10:
        this.visibleType = r110.i();
        r101 = r101 | true;
        goto L3
    L11:
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L12:
        int r111 = r110.f();
        if (r111 == (-1)) goto L19;
        if (r111 != 1) goto L15;
        r104 = am3.h.c(r110);
        goto L12
    L15:
        if (r111 != 2) goto L16;
        r105 = am3.h.c(r110);
        goto L12
    L16:
        am3.h.e(r110);
        goto L12
    L19:
        r110.d(r103);
        Map<String, String> r106 = this.startPageQuery;
        if (r104 == null) goto L26;
        if (r105 == null) goto L24;
        r106.put(r104, r105);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L27:
        this.entranceExtra = am3.h.c(r110);
        goto L3
    L28:
        this.logExtra = am3.h.c(r110);
        goto L3
    L29:
        this.imExtra = am3.h.c(r110);
        goto L3
    L8:
        am3.h.e(r110);
        goto L3
    L42:
        r110.d(r100);
        if (this.name != null) goto L46;
        this.name = "";
    L46:
        if (this.schemaUrl != null) goto L49;
        this.schemaUrl = "";
    L49:
        if ((r101 & true) == true) goto L105;
        int r112 = hn.f153654a;
        this.visibleType = 2;
        return;
    }
}
