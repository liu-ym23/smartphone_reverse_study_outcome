package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorTabLabel;", "", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "Lpy/k;", "label", "Lpy/k;", "getLabel", "()Lpy/k;", "setLabel", "(Lpy/k;)V", "icon", "getIcon", "setIcon", "", "style", "I", "getStyle", "()I", "setStyle", "(I)V", "type", "getType", "setType", "key", "getKey", "setKey", "accessibleContent", "getAccessibleContent", "setAccessibleContent", "", "trackParams", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "dslLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "getDslLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "setDslLabel", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;)V", "<init>", "()V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorTabLabel implements h {
    public static final Companion Companion = null;
    private static int IMAGE_AND_TEXT_STYLE;
    private static int IMAGE_STYLE;
    private static int TEXT_STYLE;

    @SerializedName("accessible_content")
    protected String accessibleContent;

    @SerializedName("content")
    protected String content;

    @SerializedName("dsl_label")
    protected LiveDSLModel dslLabel;

    @SerializedName("icon")
    protected k icon;

    @SerializedName("key")
    protected String key;

    @SerializedName("label")
    protected k label;

    @SerializedName("style")
    protected int style;

    @SerializedName("track_params")
    protected Map<String, String> trackParams;

    @SerializedName("type")
    protected int type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorTabLabel$Companion;", "", "()V", "IMAGE_AND_TEXT_STYLE", "", "getIMAGE_AND_TEXT_STYLE", "()I", "setIMAGE_AND_TEXT_STYLE", "(I)V", "IMAGE_STYLE", "getIMAGE_STYLE", "setIMAGE_STYLE", "TEXT_STYLE", "getTEXT_STYLE", "setTEXT_STYLE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final int getIMAGE_AND_TEXT_STYLE() {
            return AnchorTabLabel.access$getIMAGE_AND_TEXT_STYLE$cp();
        }

        public final int getIMAGE_STYLE() {
            return AnchorTabLabel.access$getIMAGE_STYLE$cp();
        }

        public final int getTEXT_STYLE() {
            return AnchorTabLabel.access$getTEXT_STYLE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setIMAGE_AND_TEXT_STYLE(int r100) {
            AnchorTabLabel.access$setIMAGE_AND_TEXT_STYLE$cp(r100);
        }

        public final void setIMAGE_STYLE(int r100) {
            AnchorTabLabel.access$setIMAGE_STYLE$cp(r100);
        }

        public final void setTEXT_STYLE(int r100) {
            AnchorTabLabel.access$setTEXT_STYLE$cp(r100);
        }
    }

    public AnchorTabLabel() {
    }

    static {
        Companion = new Companion(null);
        IMAGE_STYLE = 1;
        TEXT_STYLE = 2;
        IMAGE_AND_TEXT_STYLE = 3;
    }

    public static final /* synthetic */ int access$getIMAGE_AND_TEXT_STYLE$cp() {
        return IMAGE_AND_TEXT_STYLE;
    }

    public static final /* synthetic */ int access$getIMAGE_STYLE$cp() {
        return IMAGE_STYLE;
    }

    public static final /* synthetic */ int access$getTEXT_STYLE$cp() {
        return TEXT_STYLE;
    }

    public final String getAccessibleContent() {
        return this.accessibleContent;
    }

    public final String getContent() {
        return this.content;
    }

    public final LiveDSLModel getDslLabel() {
        return this.dslLabel;
    }

    public final k getIcon() {
        return this.icon;
    }

    public final String getKey() {
        return this.key;
    }

    public final k getLabel() {
        return this.label;
    }

    public final int getStyle() {
        return this.style;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public AnchorTabLabel(g r110) {
        this.trackParams = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        switch(r101) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.dslLabel = new LiveDSLModel(r110);
        goto L3
    L8:
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L9:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L9
    L14:
        if (r105 != 2) goto L15;
        r104 = am3.h.c(r110);
        goto L9
    L15:
        am3.h.e(r110);
        goto L9
    L18:
        r110.d(r102);
        Map<String, String> r106 = this.trackParams;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L26:
        this.accessibleContent = am3.h.c(r110);
        goto L3
    L27:
        this.key = am3.h.c(r110);
        goto L3
    L28:
        this.type = r110.i();
        goto L3
    L29:
        this.style = r110.i();
        goto L3
    L30:
        this.icon = f.a(r110, k.class);
        goto L3
    L31:
        this.label = f.a(r110, k.class);
        goto L3
    L32:
        this.content = am3.h.c(r110);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
    }

    public static final /* synthetic */ void access$setIMAGE_AND_TEXT_STYLE$cp(int r100) {
        IMAGE_AND_TEXT_STYLE = r100;
    }

    public static final /* synthetic */ void access$setIMAGE_STYLE$cp(int r100) {
        IMAGE_STYLE = r100;
    }

    public static final /* synthetic */ void access$setTEXT_STYLE$cp(int r100) {
        TEXT_STYLE = r100;
    }

    public final void setAccessibleContent(String r100) {
        this.accessibleContent = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setDslLabel(LiveDSLModel r100) {
        this.dslLabel = r100;
    }

    public final void setIcon(k r100) {
        this.icon = r100;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setLabel(k r100) {
        this.label = r100;
    }

    public final void setStyle(int r100) {
        this.style = r100;
    }

    public final void setTrackParams(Map<String, String> r100) {
        this.trackParams = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}
