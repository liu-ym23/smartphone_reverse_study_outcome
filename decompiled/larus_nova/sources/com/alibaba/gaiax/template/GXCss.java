package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/alibaba/gaiax/template/GXCss;", "", "style", "Lcom/alibaba/gaiax/template/GXStyle;", "flexBox", "Lcom/alibaba/gaiax/template/GXFlexBox;", "(Lcom/alibaba/gaiax/template/GXStyle;Lcom/alibaba/gaiax/template/GXFlexBox;)V", "getFlexBox", "()Lcom/alibaba/gaiax/template/GXFlexBox;", "getStyle", "()Lcom/alibaba/gaiax/template/GXStyle;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXCss {
    public static final Companion Companion = null;
    private final GXFlexBox flexBox;
    private final GXStyle style;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/template/GXCss$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXCss;", "lowPriorityCss", "highPriorityCss", "data", "Lorg/json/JSONObject;", "createByExtend", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXCss create(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            return new GXCss(GXStyle.Companion.create(r100), GXFlexBox.Companion.create(r100));
        }

        public final GXCss createByExtend(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            return new GXCss(GXStyle.Companion.createByExtend(r100), GXFlexBox.Companion.createByExtend(r100));
        }

        public final GXCss create(GXCss r100, GXCss r101) {
            Intrinsics.checkNotNullParameter(r100, "lowPriorityCss");
            if (r101 != null) goto L6;
            return r100;
        L6:
            return new GXCss(GXStyle.Companion.create(r100.getStyle(), r101.getStyle()), GXFlexBox.Companion.create(r100.getFlexBox(), r101.getFlexBox()));
        }

        public static /* synthetic */ GXCss create$default(Companion r100, JSONObject r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = new JSONObject();
        L6:
            return r100.create(r101);
        }

        public static /* synthetic */ GXCss createByExtend$default(Companion r100, JSONObject r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = new JSONObject();
        L6:
            return r100.createByExtend(r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ GXCss copy$default(GXCss r100, GXStyle r101, GXFlexBox r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.style;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.flexBox;
    L9:
        return r100.copy(r101, r102);
    }

    public final GXStyle component1() {
        return this.style;
    }

    public final GXFlexBox component2() {
        return this.flexBox;
    }

    public final GXCss copy(GXStyle r100, GXFlexBox r101) {
        Intrinsics.checkNotNullParameter(r100, "style");
        Intrinsics.checkNotNullParameter(r101, "flexBox");
        return new GXCss(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXCss) == true) goto L8;
        return false;
    L8:
        GXCss r101 = (GXCss) r100;
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.flexBox, r101.flexBox) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.style.hashCode() * 31) + this.flexBox.hashCode();
    }

    public String toString() {
        return "GXCss(style=" + this.style + ", flexBox=" + this.flexBox + ')';
    }

    public final GXFlexBox getFlexBox() {
        return this.flexBox;
    }

    public final GXStyle getStyle() {
        return this.style;
    }

    public GXCss(GXStyle r100, GXFlexBox r101) {
        Intrinsics.checkNotNullParameter(r100, "style");
        Intrinsics.checkNotNullParameter(r101, "flexBox");
        this.style = r100;
        this.flexBox = r101;
    }
}
