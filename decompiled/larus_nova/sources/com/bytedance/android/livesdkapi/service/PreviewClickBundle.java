package com.bytedance.android.livesdkapi.service;

import android.os.Bundle;
import gt1.a;
import gt1.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u001d\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0011\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R\"\u0010\f\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\r\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/service/PreviewClickBundle;", "Lgt1/c;", "Landroid/os/Bundle;", "bundle", "", "clearWhenRead", "", "readFromBundle", "", "component1", "Lgt1/a;", "component2", "clickType", "trackDict", "copy", "", "toString", "hashCode", "", "other", "equals", "I", "getClickType", "()I", "setClickType", "(I)V", "Lgt1/a;", "getTrackDict", "()Lgt1/a;", "setTrackDict", "(Lgt1/a;)V", "<init>", "(ILgt1/a;)V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PreviewClickBundle implements c {
    private static final String BUNDLE_NAME = "preview_click_bundle";
    public static final int CLICK_EVENT_FANS_CLUB = 2;
    public static final int CLICK_EVENT_GIFT = 1;
    public static final int CLICK_EVENT_UNDEFINED = 0;
    private static final String CLICK_TYPE = "click_type";
    public static final Companion Companion = null;
    private static final String FROM_EXPAND_AREA = "from_expand_area";
    private static final String GIFT_SHOW_FROM = "gift_show_from";
    private static final String GIFT_SOURCE = "gift_source";
    private static final String JOIN_ACTION_FROM = "join_action_from";
    private static final String JOIN_FANS_CLUB_TOAST = "join_fansclub_toast";
    private static final String TOAST = "toast";
    private int clickType;
    private a trackDict;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/PreviewClickBundle$Companion;", "", "()V", "BUNDLE_NAME", "", "CLICK_EVENT_FANS_CLUB", "", "CLICK_EVENT_GIFT", "CLICK_EVENT_UNDEFINED", "CLICK_TYPE", "FROM_EXPAND_AREA", "GIFT_SHOW_FROM", "GIFT_SOURCE", "JOIN_ACTION_FROM", "JOIN_FANS_CLUB_TOAST", "TOAST", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewClickBundle() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PreviewClickBundle copy$default(PreviewClickBundle r100, int r101, a r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.getClickType();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.getTrackDict();
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return getClickType();
    }

    public final a component2() {
        return getTrackDict();
    }

    public final PreviewClickBundle copy(int r100, a r101) {
        return new PreviewClickBundle(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PreviewClickBundle) == false) goto L10;
        PreviewClickBundle r101 = (PreviewClickBundle) r100;
        if (getClickType() == r101.getClickType()) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getTrackDict(), r101.getTrackDict()) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = getClickType() * 31;
        a r101 = getTrackDict();
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "PreviewClickBundle(clickType=" + getClickType() + ", trackDict=" + getTrackDict() + ")";
    }

    public int getClickType() {
        return this.clickType;
    }

    public a getTrackDict() {
        return this.trackDict;
    }

    public void setClickType(int r100) {
        this.clickType = r100;
    }

    public void setTrackDict(a r100) {
        this.trackDict = r100;
    }

    public PreviewClickBundle(int r100, a r101) {
        this.clickType = r100;
        this.trackDict = r101;
    }

    public final void readFromBundle(Bundle r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "bundle");
        Bundle r100 = r110.getBundle(BUNDLE_NAME);
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.getInt("click_type", 0);
    L6:
        setClickType(r102);
        if (r100 == null) goto L9;
        String r103 = r100.getString("toast", null);
    L10:
        if (r100 == null) goto L12;
        String r104 = r100.getString(JOIN_FANS_CLUB_TOAST);
    L13:
        if (r100 == null) goto L15;
        r101 = r100.getInt(FROM_EXPAND_AREA);
    L15:
        Integer r105 = Integer.valueOf(r101);
        if (r100 == null) goto L18;
        String r106 = r100.getString(GIFT_SOURCE, null);
    L19:
        if (r100 == null) goto L21;
        String r107 = r100.getString(GIFT_SHOW_FROM, null);
    L22:
        if (r100 == null) goto L24;
        String r112 = r100.getString(JOIN_ACTION_FROM, null);
    L25:
        setTrackDict(new ExtraTrackDict(r103, r104, r105, r106, r107, r112));
        if (r111 == false) goto L29;
        r110.remove(BUNDLE_NAME);
        return;
    L29:
        return;
    L24:
        r112 = null;
        goto L25
    L21:
        r107 = null;
        goto L22
    L18:
        r106 = null;
        goto L19
    L12:
        r104 = null;
        goto L13
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public /* synthetic */ PreviewClickBundle(int r100, a r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }

    public static /* synthetic */ void readFromBundle$default(PreviewClickBundle r100, Bundle r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.readFromBundle(r101, r102);
    }
}
