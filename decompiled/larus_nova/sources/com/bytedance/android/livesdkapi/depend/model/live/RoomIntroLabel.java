package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.r;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b/\u00100J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\"\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R$\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/r;", "", "getLabelIconForMessageShow", "getLabelIconForAnchorSettingDialog", "getLabelIconForAnchorPickerDialog", "toString", "", "type", "I", "getType", "()I", "setType", "(I)V", "labelName", "Ljava/lang/String;", "getLabelName", "()Ljava/lang/String;", "setLabelName", "(Ljava/lang/String;)V", "typeName", "getTypeName", "setTypeName", "labelText", "getLabelText", "setLabelText", "labelIcon", "getLabelIcon", "setLabelIcon", "showText", "getShowText", "setShowText", "", "selected", "Z", "getSelected", "()Z", "setSelected", "(Z)V", "", "showOrder", "J", "getShowOrder", "()J", "setShowOrder", "(J)V", "<init>", "()V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomIntroLabel extends FlexModelBase<r> implements r, h {
    public static final Companion Companion = null;
    public static final String ICON_URL_SUFFIX_ANCHOR_PICKER = "_black.png";
    public static final String ICON_URL_SUFFIX_ANCHOR_SETTING = "_gray.png";
    public static final String ICON_URL_SUFFIX_DEFAULT = ".png";
    public static final String ICON_URL_SUFFIX_MESSAGE_SHOW = "_white.png";

    @SerializedName("label_icon")
    protected String labelIcon;

    @SerializedName(a.KEY_LABEL_NAME)
    protected String labelName;

    @SerializedName("label_text")
    protected String labelText;

    @SerializedName("selected")
    protected boolean selected;

    @SerializedName("show_order")
    protected long showOrder;

    @SerializedName("show_text")
    protected String showText;

    @SerializedName("label_tag")
    protected int type;

    @SerializedName("type_name")
    protected String typeName;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel$Companion;", "", "()V", "ICON_URL_SUFFIX_ANCHOR_PICKER", "", "ICON_URL_SUFFIX_ANCHOR_SETTING", "ICON_URL_SUFFIX_DEFAULT", "ICON_URL_SUFFIX_MESSAGE_SHOW", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RoomIntroLabel() {
        super(r.class);
    }

    public final String getLabelIconForAnchorPickerDialog() {
        String r100 = this.labelIcon;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (StringsKt.endsWith$default(r100, ICON_URL_SUFFIX_DEFAULT, false, 2, null) == false) goto L9;
        String r101 = this.labelIcon;
        Intrinsics.checkNotNull(r101);
        return StringsKt.replace$default(r101, ICON_URL_SUFFIX_DEFAULT, ICON_URL_SUFFIX_ANCHOR_PICKER, false, 4, null);
    L9:
        return this.labelIcon;
    }

    public final String getLabelIconForAnchorSettingDialog() {
        String r100 = this.labelIcon;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (StringsKt.endsWith$default(r100, ICON_URL_SUFFIX_DEFAULT, false, 2, null) == false) goto L9;
        String r101 = this.labelIcon;
        Intrinsics.checkNotNull(r101);
        return StringsKt.replace$default(r101, ICON_URL_SUFFIX_DEFAULT, ICON_URL_SUFFIX_ANCHOR_SETTING, false, 4, null);
    L9:
        return this.labelIcon;
    }

    @Override // py.r
    public String getLabelIconForMessageShow() {
        String r100 = this.labelIcon;
        if (r100 == null) goto L9;
        if (StringsKt.endsWith$default(r100, ICON_URL_SUFFIX_DEFAULT, false, 2, null) == false) goto L9;
        return StringsKt.replace$default(r100, ICON_URL_SUFFIX_DEFAULT, ICON_URL_SUFFIX_MESSAGE_SHOW, false, 4, null);
    L9:
        return this.labelIcon;
    }

    public String toString() {
        return "RoomIntroLabel(label_tag=" + getType() + ", label_name=" + this.labelName + ", type_name=" + this.typeName + ", label_text=" + getLabelText() + ")";
    }

    public final String getLabelIcon() {
        return this.labelIcon;
    }

    public final String getLabelName() {
        return this.labelName;
    }

    @Override // py.r
    public String getLabelText() {
        return this.labelText;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final long getShowOrder() {
        return this.showOrder;
    }

    @Override // py.r
    public String getShowText() {
        return this.showText;
    }

    @Override // py.r
    public int getType() {
        return this.type;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public RoomIntroLabel(g r100) {
        super(r.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this.showOrder = r100.j();
        goto L3
    L9:
        this.selected = am3.h.a(r100);
        goto L3
    L10:
        this.showText = am3.h.c(r100);
        goto L3
    L11:
        this.typeName = am3.h.c(r100);
        goto L3
    L12:
        this.labelIcon = am3.h.c(r100);
        goto L3
    L13:
        this.labelText = am3.h.c(r100);
        goto L3
    L14:
        this.labelName = am3.h.c(r100);
        goto L3
    L15:
        this.type = r100.i();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L16:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setLabelIcon(String r100) {
        this.labelIcon = r100;
    }

    public final void setLabelName(String r100) {
        this.labelName = r100;
    }

    public void setLabelText(String r100) {
        this.labelText = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }

    public final void setShowOrder(long r100) {
        this.showOrder = r100;
    }

    public void setShowText(String r100) {
        this.showText = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public final void setTypeName(String r100) {
        this.typeName = r100;
    }
}
