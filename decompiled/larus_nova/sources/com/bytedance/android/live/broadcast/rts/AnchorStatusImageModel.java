package com.bytedance.android.live.broadcast.rts;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.foundation.RTSJSONObject;
import com.bytedance.rts.foundation.RTSSerializable;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u00102\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u00103\u001a\u0002042\n\u00105\u001a\u000606j\u0002`7H\u0016J\b\u00108\u001a\u000204H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR.\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010)j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017¨\u00069"}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusImageModel;", "Lcom/bytedance/rts/foundation/RTSSerializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "avgColor", "getAvgColor", "()Ljava/lang/String;", "setAvgColor", "(Ljava/lang/String;)V", "content", "Lcom/bytedance/android/live/broadcast/rts/AnchorStatusContent;", "getContent", "()Lcom/bytedance/android/live/broadcast/rts/AnchorStatusContent;", "setContent", "(Lcom/bytedance/android/live/broadcast/rts/AnchorStatusContent;)V", "height", "", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageType", "getImageType", "setImageType", "isAnimated", "", "()Ljava/lang/Boolean;", "setAnimated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "schema", "getSchema", "setSchema", "uri", "getUri", "setUri", "urlList", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "getUrlList", "()Ljava/util/ArrayList;", "setUrlList", "(Ljava/util/ArrayList;)V", "width", "getWidth", "setWidth", "getFirstUrl", "mapping", "", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "unmapping", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorStatusImageModel extends RTSSerializable {
    private String avgColor;
    private AnchorStatusContent content;
    private Integer height;
    private Integer imageType;
    private Boolean isAnimated;
    private String schema;
    private String uri;
    private ArrayList<String> urlList;
    private Integer width;

    public String getFirstUrl() {
        ArrayList<String> r100 = this.urlList;
        if (r100 == null) goto L8;
        Intrinsics.checkNotNull(r100);
        if (com.bytedance.rts.foundation.j.d(r100) <= 0) goto L10;
        ArrayList<String> r101 = this.urlList;
        Intrinsics.checkNotNull(r101);
        return (String) ListProtector.get(r101, 0);
    L10:
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.rts.foundation.RTSSerializable
    public void unmapping() {
        super.unmapping();
        String r100 = this.avgColor;
        if (r100 == null) goto L5;
        getEncodeData().put("avg_color", r100);
    L5:
        String r101 = this.uri;
        if (r101 == null) goto L8;
        getEncodeData().put("uri", r101);
    L8:
        ArrayList<String> r102 = this.urlList;
        if (r102 == null) goto L11;
        getEncodeData().put(ScoreTags.STAR_URL_LIST, r102);
    L11:
        String r103 = this.schema;
        if (r103 == null) goto L14;
        getEncodeData().put("open_web_url", r103);
    L14:
        Integer r104 = this.imageType;
        if (r104 == null) goto L17;
        int r105 = r104.intValue();
        getEncodeData().put("image_type", Integer.valueOf(r105));
    L17:
        AnchorStatusContent r106 = this.content;
        if (r106 == null) goto L20;
        getEncodeData().put("content", r106);
    L20:
        Boolean r107 = this.isAnimated;
        if (r107 == null) goto L23;
        boolean r108 = r107.booleanValue();
        getEncodeData().put("is_animated", Boolean.valueOf(r108));
    L23:
        Integer r109 = this.width;
        if (r109 == null) goto L26;
        int r110 = r109.intValue();
        getEncodeData().put("width", Integer.valueOf(r110));
    L26:
        Integer r111 = this.height;
        if (r111 == null) goto L30;
        int r112 = r111.intValue();
        getEncodeData().put("height", Integer.valueOf(r112));
        return;
    }

    public final String getAvgColor() {
        return this.avgColor;
    }

    public final AnchorStatusContent getContent() {
        return this.content;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getImageType() {
        return this.imageType;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getUri() {
        return this.uri;
    }

    public final ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Boolean isAnimated() {
        return this.isAnimated;
    }

    @Override // com.bytedance.rts.foundation.RTSSerializable
    public void mapping(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        super.mapping(r100);
        RTSJSONObject.a r101 = RTSJSONObject.Companion;
        String r102 = RTSJSONObject.a.e(r101, r100, "avg_color");
        if (r102 != null) goto L5;
        r102 = this.avgColor;
    L5:
        this.avgColor = r102;
        String r103 = RTSJSONObject.a.e(r101, r100, "uri");
        if (r103 != null) goto L8;
        r103 = this.uri;
    L8:
        this.uri = r103;
        Object r104 = optMapList(1, r100.opt(ScoreTags.STAR_URL_LIST), AnonymousClass1.INSTANCE);
        Boolean r105 = null;
        if ((r104 instanceof ArrayList) == true) goto L11;
        r104 = null;
    L11:
        ArrayList<String> r106 = (ArrayList) r104;
        if (r106 != null) goto L14;
        r106 = this.urlList;
    L14:
        this.urlList = r106;
        String r107 = RTSJSONObject.a.e(r101, r100, "open_web_url");
        if (r107 != null) goto L17;
        r107 = this.schema;
    L17:
        this.schema = r107;
        Integer r108 = RTSJSONObject.a.b(r101, r100, "image_type");
        if (r108 != null) goto L20;
        r108 = this.imageType;
    L20:
        this.imageType = r108;
        if (r100.has("content") == false) goto L23;
        AnchorStatusContent r109 = new AnchorStatusContent(new RTSJSONObject(r100.optJSONObject("content")), null, 2, null);
    L24:
        this.content = r109;
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter("is_animated", "key");
        Object r110 = RTSJSONObject.a.a(r100, "is_animated");
        if ((r110 instanceof Boolean) == false) goto L27;
        Boolean r111 = (Boolean) r110;
    L28:
        if (r111 == null) goto L31;
        r105 = r111;
    L31:
        if (r105 != null) goto L33;
        r105 = this.isAnimated;
    L33:
        this.isAnimated = r105;
        Integer r112 = RTSJSONObject.a.b(r101, r100, "width");
        if (r112 != null) goto L36;
        r112 = this.width;
    L36:
        this.width = r112;
        Integer r113 = RTSJSONObject.a.b(r101, r100, "height");
        if (r113 != null) goto L39;
        r113 = this.height;
    L39:
        this.height = r113;
        return;
    L27:
        r111 = null;
        goto L28
    L23:
        r109 = this.content;
        goto L24
    }

    public final void setAnimated(Boolean r100) {
        this.isAnimated = r100;
    }

    public final void setAvgColor(String r100) {
        this.avgColor = r100;
    }

    public final void setContent(AnchorStatusContent r100) {
        this.content = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setImageType(Integer r100) {
        this.imageType = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrlList(ArrayList<String> r100) {
        this.urlList = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }

    public AnchorStatusImageModel(RTSJSONObject r100, String r101) {
        super(r100, r101);
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        doInit(false);
        return;
    L7:
        doInit(true);
    }

    public /* synthetic */ AnchorStatusImageModel(RTSJSONObject r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
