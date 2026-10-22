package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020\u0004J\b\u0010/\u001a\u0004\u0018\u00010\u000eR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001e\u0010(\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\u001e\u0010+\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/CommonBubble;", "", "()V", "appearMode", "", "getAppearMode", "()I", "setAppearMode", "(I)V", "disappearMode", "getDisappearMode", "setDisappearMode", "extra", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "icon", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "onClickAction", "Lkotlin/Function0;", "", "getOnClickAction", "()Lkotlin/jvm/functions/Function0;", "setOnClickAction", "(Lkotlin/jvm/functions/Function0;)V", "priority", "getPriority", "setPriority", "schema", "getSchema", "setSchema", "text", "getText", "setText", "getDuration", "getSubItemName", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonBubble implements h {
    public static final int BUBBLE_APPEAR_MODE_DELAY_SHOW = 1;
    public static final int BUBBLE_APPEAR_MODE_IMD = 2;
    public static final int BUBBLE_APPEAR_MODE_SHOE = 0;
    public static final int BUBBLE_DISAPPEAR_MODE = 0;
    public static final Companion Companion = null;

    @SerializedName("appear_mode")
    protected int appearMode;

    @SerializedName("disappear_mode")
    protected int disappearMode;

    @SerializedName("extra")
    protected Map<String, String> extra;

    @SerializedName("icon")
    protected String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f162576id;
    private Function0<Unit> onClickAction;

    @SerializedName("priority")
    protected long priority;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("text")
    protected String text;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/CommonBubble$Companion;", "", "()V", "BUBBLE_APPEAR_MODE_DELAY_SHOW", "", "BUBBLE_APPEAR_MODE_IMD", "BUBBLE_APPEAR_MODE_SHOE", "BUBBLE_DISAPPEAR_MODE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    public final int getDuration() {
        String r100 = this.extra.get("delay_time");
        if (r100 != null) goto L7;
        return 5;
    L7:
        return CastIntegerProtector.parseInt(r100);
    }

    public final String getSubItemName() {
        return this.extra.get("sub_item_name");
    }

    public CommonBubble() {
        this.text = "";
        this.icon = "";
        this.schema = "";
        this.extra = new LinkedHashMap();
    }

    public final int getAppearMode() {
        return this.appearMode;
    }

    public final int getDisappearMode() {
        return this.disappearMode;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.f162576id;
    }

    public final Function0<Unit> getOnClickAction() {
        return this.onClickAction;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getText() {
        return this.text;
    }

    public CommonBubble(g r110) {
        this.extra = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L34;
        if (r101 != 99) goto L7;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L17:
        int r105 = r110.f();
        if (r105 == (-1)) goto L26;
        if (r105 != 1) goto L22;
        r103 = am3.h.c(r110);
        goto L17
    L22:
        if (r105 != 2) goto L23;
        r104 = am3.h.c(r110);
        goto L17
    L23:
        am3.h.e(r110);
        goto L17
    L26:
        r110.d(r102);
        Map<String, String> r106 = this.extra;
        if (r103 == null) goto L33;
        if (r104 == null) goto L31;
        r106.put(r103, r104);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L7:
        switch(r101) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this.disappearMode = r110.i();
        goto L3
    L10:
        this.appearMode = r110.i();
        goto L3
    L11:
        this.schema = am3.h.c(r110);
        goto L3
    L12:
        this.icon = am3.h.c(r110);
        goto L3
    L13:
        this.text = am3.h.c(r110);
        goto L3
    L14:
        this.priority = r110.j();
        goto L3
    L15:
        this.f162576id = r110.j();
        goto L3
    L8:
        am3.h.e(r110);
        goto L3
    L34:
        r110.d(r100);
        if (this.text != null) goto L38;
        this.text = "";
    L38:
        if (this.icon != null) goto L41;
        this.icon = "";
    L41:
        if (this.schema != null) goto L44;
        this.schema = "";
    L44:
        if (this.extra != null) goto L79;
        this.extra = new LinkedHashMap();
        return;
    }

    public final void setAppearMode(int r100) {
        this.appearMode = r100;
    }

    public final void setDisappearMode(int r100) {
        this.disappearMode = r100;
    }

    public final void setExtra(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void setIcon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.icon = r100;
    }

    public final void setId(long r100) {
        this.f162576id = r100;
    }

    public final void setOnClickAction(Function0<Unit> r100) {
        this.onClickAction = r100;
    }

    public final void setPriority(long r100) {
        this.priority = r100;
    }

    public final void setSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schema = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }
}
