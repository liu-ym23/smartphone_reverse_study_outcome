package com.bytedance.android.live.profit.player;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f88345a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/player/o$a;", "", "Lcom/bytedance/android/live/profit/player/o$b;", "portrait", "Lcom/bytedance/android/live/profit/player/o$b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/profit/player/o$b;", "landscape", "getLandscape", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("landscape")
        private final b landscape;

        @SerializedName("portrait")
        private final b portrait;

        public a() {
        }

        public final b a() {
            return this.portrait;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/player/o$b;", "", "", "Lcom/bytedance/android/live/profit/player/o$c;", GXTemplateKey.GAIAX_LAYERS, "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName(GXTemplateKey.GAIAX_LAYERS)
        private final List<c> layers;

        public b() {
        }

        public final List<c> a() {
            return this.layers;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0012R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/profit/player/o$c;", "", "", "name", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "rgbArea", "[I", "getRgbArea", "()[I", "setRgbArea", "([I)V", "alphaArea", "getAlphaArea", "setAlphaArea", "", "enableTap", "Z", "getEnableTap", "()Z", "setEnableTap", "(Z)V", "_originSize", "Lcom/bytedance/android/live/profit/player/o$d;", "maskContainer", "Lcom/bytedance/android/live/profit/player/o$d;", "getMaskContainer", "()Lcom/bytedance/android/live/profit/player/o$d;", "setMaskContainer", "(Lcom/bytedance/android/live/profit/player/o$d;)V", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("originSize")
        private int[] _originSize;

        @SerializedName("alphaFrame")
        private int[] alphaArea;

        @SerializedName("enableTap")
        private boolean enableTap;

        @SerializedName("maskContainer")
        private d maskContainer;

        @SerializedName("name")
        private String name;

        @SerializedName("rgbFrame")
        private int[] rgbArea;

        @SerializedName("type")
        private int type;

        public final e b() {
            int[] r100 = this._originSize;
            return new e(r100[0], r100[1]);
        }

        public final boolean c() {
            d r100 = this.maskContainer;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.a() != 2) goto L7;
            return true;
        }

        public c() {
            this.name = "";
            this.rgbArea = new int[0];
            this.alphaArea = new int[0];
            this._originSize = new int[]{0, 0};
        }

        public final String a() {
            return this.name;
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/player/o$d;", "", "", "containerType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setContainerType", "(I)V", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d {

        @SerializedName("type")
        private int containerType;

        public d() {
        }

        public final int a() {
            return this.containerType;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f88346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f88347b;

        public static final class a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L10;
            e r101 = (e) r100;
            if (this.f88346a == r101.f88346a) goto L8;
            return false;
        L8:
            if (this.f88347b == r101.f88347b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f88346a * 31) + this.f88347b;
        }

        public final String toString() {
            return "Size(width=" + this.f88346a + ", height=" + this.f88347b + ")";
        }

        static {
        }

        public e(int r100, int r101) {
            this.f88346a = r100;
            this.f88347b = r101;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f88345a, ((o) r100).f88345a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<c> r100 = this.f88345a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "Mp4ProbeInfo(layers=" + this.f88345a + ")";
    }

    public o(List<c> r100) {
        this.f88345a = r100;
    }

    public final c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "layerName");
        List<c> r101 = this.f88345a;
        Object r102 = null;
        if (r101 == null) goto L15;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((c) r104).a(), r100) == false) goto L6;
        r102 = r104;
    L11:
        return (c) r102;
    L15:
        return null;
    }
}
