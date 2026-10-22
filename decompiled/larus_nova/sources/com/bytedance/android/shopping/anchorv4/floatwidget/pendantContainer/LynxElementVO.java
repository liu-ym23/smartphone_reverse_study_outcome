package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.State;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.n0;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001d\u0012\u0018\b\u0002\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010%\u001a\u00020\u001d\u0012\b\b\u0002\u0010&\u001a\u00020\u001d\u0012\b\b\u0002\u0010'\u001a\u00020\u001d\u0012\b\b\u0002\u0010(\u001a\u00020\u001d\u0012\b\b\u0002\u0010)\u001a\u00020\u0015¢\u0006\u0004\bT\u0010UJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0019\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0015HÆ\u0003Jú\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001d2\u0018\b\u0002\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010%\u001a\u00020\u001d2\b\b\u0002\u0010&\u001a\u00020\u001d2\b\b\u0002\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\u001d2\b\b\u0002\u0010)\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b*\u0010+J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\t\u0010-\u001a\u00020\u001dHÖ\u0001J\u0013\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b2\u00103R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b4\u00103R'\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\b6\u00107R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b;\u0010:R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b<\u00103R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010=R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010=R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010=R\u0016\u0010!\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010=R'\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b>\u00107R\u0019\u0010#\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b#\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010$\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010%\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010ER\u0016\u0010&\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010ER\u0016\u0010'\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010ER\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010ER\"\u0010)\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0011\u0010M\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0011\u0010O\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\bN\u0010LR\u0011\u0010Q\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\bP\u0010LR\u0011\u0010S\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\bR\u0010L¨\u0006V"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/LynxElementVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/n0;", SVGRenderEngine.RECT, "", "updateReactMargin", "", "component1", "component2", "", "", "component3", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/a;", "component4", "component5", "component6", "component11", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantGravity;", "component12", "Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;", "component18", "schema", "megaData", "queryData", "width", "height", "lynxId", "", "bottomMargin", "leftMargin", "rightMarin", "topMargin", "location", GXTemplateKey.GAIAX_LAYER_GRAVITY, "config", "reactBottomMargin", "reactLeftMargin", "reactRightMargin", "reactTopMargin", "state", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/a;Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/a;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantGravity;Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;IIIILcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;)Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/LynxElementVO;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "getMegaData", "Ljava/util/Map;", "getQueryData", "()Ljava/util/Map;", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/a;", "getWidth", "()Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/a;", "getHeight", "getLynxId", "Ljava/lang/Integer;", "getLocation", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantGravity;", "getGravity", "()Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantGravity;", "Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "I", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;", "getState", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;", "setState", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;)V", "getUseLeftMargin", "()I", "useLeftMargin", "getUseRightMargin", "useRightMargin", "getUseTopMargin", "useTopMargin", "getUseBottomMargin", "useBottomMargin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/a;Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/a;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantGravity;Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;IIIILcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxElementVO implements Serializable {
    private final Integer bottomMargin;
    private final ConfigModel config;
    private final PendantGravity gravity;
    private final a height;
    private final Integer leftMargin;
    private final Map<String, Object> location;
    private final String lynxId;
    private final String megaData;
    private final Map<String, Object> queryData;
    private int reactBottomMargin;
    private int reactLeftMargin;
    private int reactRightMargin;
    private int reactTopMargin;
    private final Integer rightMarin;
    private final String schema;
    private State state;
    private final Integer topMargin;
    private final a width;

    public LynxElementVO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxElementVO copy$default(LynxElementVO r110, String r111, String r112, Map r210, a r211, a r212, String r213, Integer r214, Integer r215, Integer r216, Integer r217, Map r218, PendantGravity r219, ConfigModel r310, int r311, int r312, int r313, int r314, State r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = r110.schema;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.megaData;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Map r102 = r110.queryData;
    L15:
        if ((r316 & 8) == 0) goto L17;
        a r103 = r110.width;
    L19:
        if ((r316 & 16) == 0) goto L21;
        a r104 = r110.height;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = r110.lynxId;
    L27:
        if ((r316 & 64) == 0) goto L29;
        Integer r106 = r110.bottomMargin;
    L31:
        if ((r316 & 128) == 0) goto L33;
        Integer r107 = r110.leftMargin;
    L35:
        if ((r316 & 256) == 0) goto L37;
        Integer r113 = r110.rightMarin;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Integer r114 = r110.topMargin;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Map r115 = r110.location;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        PendantGravity r116 = r110.gravity;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        ConfigModel r117 = r110.config;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        int r118 = r110.reactBottomMargin;
    L58:
        int r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        int r119 = r110.reactLeftMargin;
    L62:
        int r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        int r120 = r110.reactRightMargin;
    L66:
        int r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        int r121 = r110.reactTopMargin;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        State r108 = r110.state;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.schema;
    }

    public final Map<String, Object> component11() {
        return this.location;
    }

    public final PendantGravity component12() {
        return this.gravity;
    }

    public final ConfigModel component13() {
        return this.config;
    }

    public final State component18() {
        return this.state;
    }

    public final String component2() {
        return this.megaData;
    }

    public final Map<String, Object> component3() {
        return this.queryData;
    }

    public final a component4() {
        return this.width;
    }

    public final a component5() {
        return this.height;
    }

    public final String component6() {
        return this.lynxId;
    }

    public final LynxElementVO copy(String r210, String r211, Map<String, ? extends Object> r212, a r213, a r214, String r215, Integer r216, Integer r217, Integer r218, Integer r310, Map<String, ? extends Object> r311, PendantGravity r312, ConfigModel r313, int r314, int r315, int r316, int r317, State r318) {
        Intrinsics.checkNotNullParameter(r318, "state");
        return new LynxElementVO(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LynxElementVO) == false) goto L42;
        LynxElementVO r101 = (LynxElementVO) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.megaData, r101.megaData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.queryData, r101.queryData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.lynxId, r101.lynxId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bottomMargin, r101.bottomMargin) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.leftMargin, r101.leftMargin) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.rightMarin, r101.rightMarin) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.topMargin, r101.topMargin) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.location, r101.location) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.gravity, r101.gravity) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L32;
        return false;
    L32:
        if (this.reactBottomMargin == r101.reactBottomMargin) goto L34;
        return false;
    L34:
        if (this.reactLeftMargin == r101.reactLeftMargin) goto L36;
        return false;
    L36:
        if (this.reactRightMargin == r101.reactRightMargin) goto L38;
        return false;
    L38:
        if (this.reactTopMargin == r101.reactTopMargin) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.state, r101.state) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.megaData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.queryData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.width;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        a r113 = this.height;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.lynxId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.bottomMargin;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.leftMargin;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.rightMarin;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.topMargin;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, Object> r131 = this.location;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        PendantGravity r134 = this.gravity;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        ConfigModel r137 = this.config;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (((((((((r136 + r138) * 31) + this.reactBottomMargin) * 31) + this.reactLeftMargin) * 31) + this.reactRightMargin) * 31) + this.reactTopMargin) * 31;
        State r140 = this.state;
        if (r140 == null) goto L58;
        r101 = r140.hashCode();
    L58:
        return r139 + r101;
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LynxElementVO(schema=" + this.schema + ", megaData=" + this.megaData + ", queryData=" + this.queryData + ", width=" + this.width + ", height=" + this.height + ", lynxId=" + this.lynxId + ", bottomMargin=" + this.bottomMargin + ", leftMargin=" + this.leftMargin + ", rightMarin=" + this.rightMarin + ", topMargin=" + this.topMargin + ", location=" + this.location + ", gravity=" + this.gravity + ", config=" + this.config + ", reactBottomMargin=" + this.reactBottomMargin + ", reactLeftMargin=" + this.reactLeftMargin + ", reactRightMargin=" + this.reactRightMargin + ", reactTopMargin=" + this.reactTopMargin + ", state=" + this.state + ")";
    }

    public final int getUseBottomMargin() {
        Integer r100 = this.bottomMargin;
        if (r100 == null) goto L5;
        int r101 = com.bytedance.android.shopping.extensions.b.b(r100);
    L7:
        return r101 + this.reactBottomMargin;
    L5:
        r101 = 0;
        goto L7
    }

    public final int getUseLeftMargin() {
        Integer r100 = this.leftMargin;
        if (r100 == null) goto L5;
        int r101 = com.bytedance.android.shopping.extensions.b.b(r100);
    L7:
        return r101 + this.reactLeftMargin;
    L5:
        r101 = 0;
        goto L7
    }

    public final int getUseRightMargin() {
        Integer r100 = this.rightMarin;
        if (r100 == null) goto L5;
        int r101 = com.bytedance.android.shopping.extensions.b.b(r100);
    L7:
        return r101 + this.reactRightMargin;
    L5:
        r101 = 0;
        goto L7
    }

    public final int getUseTopMargin() {
        Integer r100 = this.topMargin;
        if (r100 == null) goto L5;
        int r101 = com.bytedance.android.shopping.extensions.b.b(r100);
    L7:
        return r101 + this.reactTopMargin;
    L5:
        r101 = 0;
        goto L7
    }

    public final ConfigModel getConfig() {
        return this.config;
    }

    public final PendantGravity getGravity() {
        return this.gravity;
    }

    public final a getHeight() {
        return this.height;
    }

    public final Map<String, Object> getLocation() {
        return this.location;
    }

    public final String getLynxId() {
        return this.lynxId;
    }

    public final String getMegaData() {
        return this.megaData;
    }

    public final Map<String, Object> getQueryData() {
        return this.queryData;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final State getState() {
        return this.state;
    }

    public final a getWidth() {
        return this.width;
    }

    public final void setState(State r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.state = r100;
    }

    public final void updateReactMargin(n0 r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        PendantGravity r101 = this.gravity;
        if (r101 == null) goto L22;
        int r102 = d.f166772a[r101.ordinal()];
        if (r102 != 1) goto L8;
        this.reactBottomMargin = (int) r100.f169349b;
        this.reactLeftMargin = (int) r100.f169350c;
        return;
    L8:
        if (r102 != 2) goto L10;
        this.reactTopMargin = (int) r100.f169348a;
        this.reactRightMargin = (int) r100.f169351d;
        return;
    L10:
        if (r102 != 3) goto L12;
        this.reactBottomMargin = (int) r100.f169349b;
        this.reactRightMargin = (int) r100.f169351d;
        return;
    L12:
        if (r102 != 4) goto L23;
        this.reactTopMargin = (int) r100.f169348a;
        this.reactLeftMargin = (int) r100.f169350c;
        return;
    L23:
        return;
    }

    public LynxElementVO(String r100, String r101, Map<String, ? extends Object> r102, a r103, a r104, String r105, Integer r110, Integer r111, Integer r112, Integer r113, Map<String, ? extends Object> r114, PendantGravity r115, ConfigModel r116, int r117, int r118, int r119, int r210, State r211) {
        Intrinsics.checkNotNullParameter(r211, "state");
        this.schema = r100;
        this.megaData = r101;
        this.queryData = r102;
        this.width = r103;
        this.height = r104;
        this.lynxId = r105;
        this.bottomMargin = r110;
        this.leftMargin = r111;
        this.rightMarin = r112;
        this.topMargin = r113;
        this.location = r114;
        this.gravity = r115;
        this.config = r116;
        this.reactBottomMargin = r117;
        this.reactLeftMargin = r118;
        this.reactRightMargin = r119;
        this.reactTopMargin = r210;
        this.state = r211;
    }

    public /* synthetic */ LynxElementVO(String r210, String r211, Map r212, a r213, a r214, String r215, Integer r216, Integer r217, Integer r218, Integer r219, Map r310, PendantGravity r311, ConfigModel r312, int r313, int r314, int r315, int r316, State r317, int r318, DefaultConstructorMarker r319) {
        ConfigModel r100 = null;
        if ((r318 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        Map r103 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        a r104 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        a r105 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        Map r112 = null;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        PendantGravity r113 = null;
    L51:
        if ((r318 & 4096) != 0) goto L55;
        r100 = r312;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        int r114 = 0;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        int r115 = 0;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        int r116 = 0;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        int r117 = 0;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        State r109 = State.NORMAL;
    L74:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r100, r114, r115, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r115 = r314;
        goto L63
    L57:
        r114 = r313;
        goto L59
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r108 = r217;
        goto L35
    L29:
        r107 = r216;
        goto L31
    L25:
        r106 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
