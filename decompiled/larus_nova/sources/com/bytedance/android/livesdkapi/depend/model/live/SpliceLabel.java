package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.SpliceLabel")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003Ju\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\n8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\n8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\f\u001a\u00020\n8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\n8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0016\u0010\r\u001a\u00020\n8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/SpliceLabel;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ISpliceLabel;", "text", "", "textColor", "background", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "iconWidth", "", "iconHeight", "iconRadius", "textSize", CommodityText.BOLD, "italic", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/live/base/model/ImageModel;JJJJJJ)V", "getBackground", "()Lcom/bytedance/android/live/base/model/ImageModel;", "backgroundColor", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getBold", "()J", "getIcon", "getIconHeight", "getIconRadius", "getIconWidth", "getItalic", "getText", "getTextColor", "getTextSize", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpliceLabel extends FlexModelBase<ISpliceLabel> implements ISpliceLabel, h {

    @SerializedName("background_image")
    protected ImageModel background;

    @SerializedName("background_color")
    protected String backgroundColor;

    @SerializedName("text_front_bold")
    protected long bold;

    @SerializedName("icon_image")
    protected ImageModel icon;

    @SerializedName("icon_height")
    protected long iconHeight;

    @SerializedName("icon_raduis")
    protected long iconRadius;

    @SerializedName("icon_width")
    protected long iconWidth;

    @SerializedName("text_front_italic")
    protected long italic;

    @SerializedName("text")
    protected String text;

    @SerializedName("text_color")
    protected String textColor;

    @SerializedName("text_front_size")
    protected long textSize;

    public SpliceLabel(String r100, String r101, ImageModel r102, ImageModel r103, long r104, long r110, long r111, long r112, long r113, long r114) {
        super(ISpliceLabel.class);
        this.text = r100;
        this.textColor = r101;
        this.background = r102;
        this.icon = r103;
        this.iconWidth = r104;
        this.iconHeight = r110;
        this.iconRadius = r111;
        this.textSize = r112;
        this.bold = r113;
        this.italic = r114;
    }

    public static /* synthetic */ SpliceLabel copy$default(SpliceLabel r110, String r111, String r112, ImageModel r210, ImageModel r211, long r212, long r213, long r214, long r215, long r310, long r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.getText();
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.getTextColor();
    L11:
        if ((r312 & 4) == 0) goto L13;
        ImageModel r102 = r110.getBackground();
    L15:
        if ((r312 & 8) == 0) goto L17;
        ImageModel r103 = r110.getIcon();
    L19:
        if ((r312 & 16) == 0) goto L21;
        long r104 = r110.getIconWidth();
    L23:
        if ((r312 & 32) == 0) goto L25;
        long r105 = r110.getIconHeight();
    L27:
        if ((r312 & 64) == 0) goto L29;
        long r106 = r110.getIconRadius();
    L31:
        if ((r312 & 128) == 0) goto L33;
        long r113 = r110.getTextSize();
    L35:
        if ((r312 & 256) == 0) goto L37;
        long r114 = r110.getBold();
    L39:
        if ((r312 & 512) == 0) goto L41;
        long r115 = r110.getItalic();
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115);
    L41:
        r115 = r311;
        goto L43
    L37:
        r114 = r310;
        goto L39
    L33:
        r113 = r215;
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
        return getText();
    }

    public final long component10() {
        return getItalic();
    }

    public final String component2() {
        return getTextColor();
    }

    public final ImageModel component3() {
        return getBackground();
    }

    public final ImageModel component4() {
        return getIcon();
    }

    public final long component5() {
        return getIconWidth();
    }

    public final long component6() {
        return getIconHeight();
    }

    public final long component7() {
        return getIconRadius();
    }

    public final long component8() {
        return getTextSize();
    }

    public final long component9() {
        return getBold();
    }

    public final SpliceLabel copy(String r110, String r210, ImageModel r211, ImageModel r212, long r213, long r214, long r215, long r216, long r310, long r311) {
        return new SpliceLabel(r110, r210, r211, r212, r213, r214, r215, r216, r310, r311);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SpliceLabel) == false) goto L26;
        SpliceLabel r101 = (SpliceLabel) r100;
        if (Intrinsics.areEqual(getText(), r101.getText()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getTextColor(), r101.getTextColor()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getBackground(), r101.getBackground()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getIcon(), r101.getIcon()) == true) goto L14;
        return false;
    L14:
        if (getIconWidth() == r101.getIconWidth()) goto L16;
        return false;
    L16:
        if (getIconHeight() == r101.getIconHeight()) goto L18;
        return false;
    L18:
        if (getIconRadius() == r101.getIconRadius()) goto L20;
        return false;
    L20:
        if (getTextSize() == r101.getTextSize()) goto L22;
        return false;
    L22:
        if (getBold() == r101.getBold()) goto L24;
        return false;
    L24:
        if (getItalic() == r101.getItalic()) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r100 = getText();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = getTextColor();
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageModel r107 = getBackground();
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ImageModel r110 = getIcon();
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        long r112 = getIconWidth();
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = getIconHeight();
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = getIconRadius();
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = getTextSize();
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = getBold();
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = getItalic();
        return r121 + ((int) (r122 ^ (r122 >>> 32)));
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
        return "SpliceLabel(text=" + getText() + ", textColor=" + getTextColor() + ", background=" + getBackground() + ", icon=" + getIcon() + ", iconWidth=" + getIconWidth() + ", iconHeight=" + getIconHeight() + ", iconRadius=" + getIconRadius() + ", textSize=" + getTextSize() + ", bold=" + getBold() + ", italic=" + getItalic() + ")";
    }

    public SpliceLabel() {
        super(ISpliceLabel.class);
        this.text = "";
        this.textColor = "";
        this.background = null;
        this.icon = null;
        this.iconWidth = 0;
        this.iconHeight = 0;
        this.iconRadius = 0;
        this.textSize = 0;
        this.bold = 0;
        this.italic = 0;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public /* bridge */ /* synthetic */ k getBackground() {
        return getBackground();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public /* bridge */ /* synthetic */ k getIcon() {
        return getIcon();
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public long getBold() {
        return this.bold;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public long getIconHeight() {
        return this.iconHeight;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public long getIconRadius() {
        return this.iconRadius;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public long getIconWidth() {
        return this.iconWidth;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public long getItalic() {
        return this.italic;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public String getText() {
        return this.text;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public String getTextColor() {
        return this.textColor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public long getTextSize() {
        return this.textSize;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public ImageModel getBackground() {
        return this.background;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ISpliceLabel
    public ImageModel getIcon() {
        return this.icon;
    }

    public SpliceLabel(g r100) {
        super(ISpliceLabel.class);
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L19;
        g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this.italic = r100.j();
        r101 = r101 | 32;
        goto L3
    L9:
        this.bold = r100.j();
        r101 = r101 | 16;
        goto L3
    L10:
        this.textSize = r100.j();
        r101 = r101 | 8;
        goto L3
    L11:
        this.iconRadius = r100.j();
        r101 = r101 | 4;
        goto L3
    L12:
        this.iconHeight = r100.j();
        r101 = r101 | 2;
        goto L3
    L13:
        this.iconWidth = r100.j();
        r101 = r101 | 1;
        goto L3
    L14:
        this.backgroundColor = am3.h.c(r100);
        goto L3
    L15:
        this.icon = x.a(r100);
        goto L3
    L16:
        this.background = x.a(r100);
        goto L3
    L17:
        this.textColor = am3.h.c(r100);
        goto L3
    L18:
        this.text = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L19:
        r100.d(r102);
        setThreadSafe(true);
        if (this.text != null) goto L23;
        this.text = "";
    L23:
        if (this.textColor != null) goto L26;
        this.textColor = "";
    L26:
        if (this.background != null) goto L29;
        this.background = null;
    L29:
        if (this.icon != null) goto L32;
        this.icon = null;
    L32:
        if ((r101 & 1) != 0) goto L35;
        this.iconWidth = 0;
    L35:
        if ((r101 & 2) != 0) goto L38;
        this.iconHeight = 0;
    L38:
        if ((r101 & 4) != 0) goto L41;
        this.iconRadius = 0;
    L41:
        if ((r101 & 8) != 0) goto L44;
        this.textSize = 0;
    L44:
        if ((r101 & 16) != 0) goto L47;
        this.bold = 0;
    L47:
        if ((r101 & 32) != 0) goto L76;
        this.italic = 0;
        return;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public /* synthetic */ SpliceLabel(String r110, String r210, ImageModel r211, ImageModel r212, long r213, long r214, long r215, long r216, long r310, long r311, int r312, DefaultConstructorMarker r313) {
        String r100 = "";
        if ((r312 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r312 & 2) != 0) goto L10;
        r100 = r210;
    L10:
        ImageModel r102 = null;
        if ((r312 & 4) == 0) goto L13;
        ImageModel r103 = null;
    L15:
        if ((r312 & 8) != 0) goto L18;
        r102 = r212;
    L18:
        long r104 = 0;
        if ((r312 & 16) == 0) goto L21;
        long r105 = 0;
    L23:
        if ((r312 & 32) == 0) goto L25;
        long r111 = 0;
    L27:
        if ((r312 & 64) == 0) goto L29;
        long r112 = 0;
    L31:
        if ((r312 & 128) == 0) goto L33;
        long r113 = 0;
    L35:
        if ((r312 & 256) == 0) goto L37;
        long r114 = 0;
    L39:
        if ((r312 & 512) != 0) goto L42;
        r104 = r311;
    L42:
        this(r101, r100, r103, r102, r105, r111, r112, r113, r114, r104);
        return;
    L37:
        r114 = r310;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r111 = r214;
        goto L27
    L21:
        r105 = r213;
        goto L23
    L13:
        r103 = r211;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
