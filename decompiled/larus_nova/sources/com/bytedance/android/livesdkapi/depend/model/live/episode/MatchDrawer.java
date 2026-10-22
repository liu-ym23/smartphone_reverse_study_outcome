package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MatchDrawer;", "", "", "entranceName", "Ljava/lang/String;", "getEntranceName", "()Ljava/lang/String;", "setEntranceName", "(Ljava/lang/String;)V", "Lpy/k;", "entranceIcon", "Lpy/k;", "getEntranceIcon", "()Lpy/k;", "setEntranceIcon", "(Lpy/k;)V", "drawerTitle", "getDrawerTitle", "setDrawerTitle", "drawerBackground", "getDrawerBackground", "setDrawerBackground", "returnEntryText", "getReturnEntryText", "setReturnEntryText", "", "displayMode", "Ljava/lang/Integer;", "getDisplayMode", "()Ljava/lang/Integer;", "setDisplayMode", "(Ljava/lang/Integer;)V", "<init>", "()V", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchDrawer implements h {
    public static final Companion Companion = null;
    public static final int modeBoth = 3;
    public static final int modeNone = 0;
    public static final int modeOnlyLandscape = 2;
    public static final int modeOnlyPortrait = 1;

    @SerializedName("display_mode")
    protected Integer displayMode;

    @SerializedName("drawer_background")
    protected k drawerBackground;

    @SerializedName("drawer_title")
    protected String drawerTitle;

    @SerializedName("entry_icon")
    protected k entranceIcon;

    @SerializedName("entry_name")
    protected String entranceName;

    @SerializedName("return_btn_text")
    protected String returnEntryText;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MatchDrawer$Companion;", "", "()V", "modeBoth", "", "modeNone", "modeOnlyLandscape", "modeOnlyPortrait", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public MatchDrawer() {
        this.displayMode = 0;
    }

    public final Integer getDisplayMode() {
        return this.displayMode;
    }

    public final k getDrawerBackground() {
        return this.drawerBackground;
    }

    public final String getDrawerTitle() {
        return this.drawerTitle;
    }

    public final k getEntranceIcon() {
        return this.entranceIcon;
    }

    public final String getEntranceName() {
        return this.entranceName;
    }

    public final String getReturnEntryText() {
        return this.returnEntryText;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public MatchDrawer(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.displayMode = Integer.valueOf(r100.i());
        goto L3
    L8:
        this.returnEntryText = am3.h.c(r100);
        goto L3
    L9:
        this.drawerBackground = f.a(r100, k.class);
        goto L3
    L10:
        this.drawerTitle = am3.h.c(r100);
        goto L3
    L11:
        this.entranceIcon = f.a(r100, k.class);
        goto L3
    L12:
        this.entranceName = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.displayMode != null) goto L33;
        this.displayMode = 0;
        return;
    }

    public final void setDisplayMode(Integer r100) {
        this.displayMode = r100;
    }

    public final void setDrawerBackground(k r100) {
        this.drawerBackground = r100;
    }

    public final void setDrawerTitle(String r100) {
        this.drawerTitle = r100;
    }

    public final void setEntranceIcon(k r100) {
        this.entranceIcon = r100;
    }

    public final void setEntranceName(String r100) {
        this.entranceName = r100;
    }

    public final void setReturnEntryText(String r100) {
        this.returnEntryText = r100;
    }
}
