package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001c\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/CommonDot;", "", "()V", "appearMode", "", "getAppearMode", "()I", "setAppearMode", "(I)V", "disappearMode", "getDisappearMode", "setDisappearMode", "extra", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "id", "", "getId", "()J", "setId", "(J)V", "priority", "getPriority", "setPriority", "style", "getStyle", "setStyle", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonDot implements h {
    public static final Companion Companion = null;
    public static final int DOT_APPEAR_MODE_SHOW = 0;
    public static final int DOT_APPEAR_MODE_WITH_SUB_PANEL = 1;
    public static final int DOT_DISAPPEAR_MODE_CLICK_OR_SHOW_TWICE = 1;
    public static final int DOT_DISAPPEAR_MODE_DEFAULT = 0;
    public static final int DOT_STYLE_DEFAULT = 0;
    public static final int DOT_STYLE_NEW = 3;
    public static final int DOT_STYLE_RED = 2;
    public static final int DOT_STYLE_YELLOW = 1;

    @SerializedName("appear_mode")
    protected int appearMode;

    @SerializedName("disappear_mode")
    protected int disappearMode;

    @SerializedName("extra")
    protected Map<String, String> extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f162577id;

    @SerializedName("priority")
    protected long priority;

    @SerializedName("style")
    protected long style;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/CommonDot$Companion;", "", "()V", "DOT_APPEAR_MODE_SHOW", "", "DOT_APPEAR_MODE_WITH_SUB_PANEL", "DOT_DISAPPEAR_MODE_CLICK_OR_SHOW_TWICE", "DOT_DISAPPEAR_MODE_DEFAULT", "DOT_STYLE_DEFAULT", "DOT_STYLE_NEW", "DOT_STYLE_RED", "DOT_STYLE_YELLOW", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    public CommonDot() {
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

    public final long getId() {
        return this.f162577id;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final long getStyle() {
        return this.style;
    }

    public CommonDot(g r110) {
        this.extra = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L39;
        if (r101 != 1) goto L8;
        this.f162577id = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.priority = r110.j();
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.style = r110.i();
        goto L3
    L12:
        if (r101 != 4) goto L14;
        this.appearMode = r110.i();
        goto L3
    L14:
        if (r101 != 5) goto L16;
        this.disappearMode = r110.i();
        goto L3
    L16:
        if (r101 != 99) goto L17;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L19:
        int r105 = r110.f();
        if (r105 == (-1)) goto L26;
        if (r105 != 1) goto L22;
        r103 = am3.h.c(r110);
        goto L19
    L22:
        if (r105 != 2) goto L23;
        r104 = am3.h.c(r110);
        goto L19
    L23:
        am3.h.e(r110);
        goto L19
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
    L17:
        am3.h.e(r110);
        goto L3
    L39:
        r110.d(r100);
        if (this.extra != null) goto L75;
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

    public final void setId(long r100) {
        this.f162577id = r100;
    }

    public final void setPriority(long r100) {
        this.priority = r100;
    }

    public final void setStyle(long r100) {
        this.style = r100;
    }
}
