package com.alibaba.gaiax.data.assets;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/data/assets/GXBinParser;", "", "()V", "FILE_HEAD_NUM_BYTE", "", "FILE_NUM_BYTE", "convertFourUnSignInt", "byteArray", "", "parser", "Lorg/json/JSONObject;", "binFile", "Ljava/io/File;", HTTP.CONTENT_RANGE_BYTES, "parserToBin", "Lcom/alibaba/gaiax/data/assets/GXBinParser$GXBinaryData;", "targetFile", "parserToBinaryData", "GXBinaryData", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXBinParser {
    private static final int FILE_HEAD_NUM_BYTE = 100;
    private static final int FILE_NUM_BYTE = 4;
    public static final GXBinParser INSTANCE = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/alibaba/gaiax/data/assets/GXBinParser$GXBinaryData;", "", GXTemplateKey.GAIAX_LAYER, "", GXTemplateKey.GAIAX_DATABINDING, GXTemplateKey.GAIAX_CSS, GXTemplateKey.GAIAX_JS, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCss", "()Ljava/lang/String;", "setCss", "(Ljava/lang/String;)V", "getDatabinding", "setDatabinding", "getJs", "setJs", "getLayer", "setLayer", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GXBinaryData {
        private String css;
        private String databinding;

        /* JADX INFO: renamed from: js, reason: collision with root package name */
        private String f24948js;
        private String layer;

        public GXBinaryData() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ GXBinaryData copy$default(GXBinaryData r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.layer;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.databinding;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.css;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.f24948js;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.layer;
        }

        public final String component2() {
            return this.databinding;
        }

        public final String component3() {
            return this.css;
        }

        public final String component4() {
            return this.f24948js;
        }

        public final GXBinaryData copy(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
            Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_DATABINDING);
            Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_CSS);
            Intrinsics.checkNotNullParameter(r103, GXTemplateKey.GAIAX_JS);
            return new GXBinaryData(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GXBinaryData) == true) goto L8;
            return false;
        L8:
            GXBinaryData r101 = (GXBinaryData) r100;
            if (Intrinsics.areEqual(this.layer, r101.layer) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.databinding, r101.databinding) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.css, r101.css) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f24948js, r101.f24948js) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.layer.hashCode() * 31) + this.databinding.hashCode()) * 31) + this.css.hashCode()) * 31) + this.f24948js.hashCode();
        }

        public String toString() {
            return "GXBinaryData(layer=" + this.layer + ", databinding=" + this.databinding + ", css=" + this.css + ", js=" + this.f24948js + ')';
        }

        public final String getCss() {
            return this.css;
        }

        public final String getDatabinding() {
            return this.databinding;
        }

        public final String getJs() {
            return this.f24948js;
        }

        public final String getLayer() {
            return this.layer;
        }

        public final void setCss(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.css = r100;
        }

        public final void setDatabinding(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.databinding = r100;
        }

        public final void setJs(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f24948js = r100;
        }

        public final void setLayer(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.layer = r100;
        }

        public GXBinaryData(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
            Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_DATABINDING);
            Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_CSS);
            Intrinsics.checkNotNullParameter(r103, GXTemplateKey.GAIAX_JS);
            this.layer = r100;
            this.databinding = r101;
            this.css = r102;
            this.f24948js = r103;
        }

        public /* synthetic */ GXBinaryData(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = "";
        L14:
            this(r100, r101, r102, r103);
        }
    }

    static {
        INSTANCE = new GXBinParser();
    }

    private GXBinParser() {
    }

    private final int convertFourUnSignInt(byte[] r100) {
        int r101 = ((r100[2] & UByte.MAX_VALUE) << 16) | ((r100[1] & UByte.MAX_VALUE) << 8);
        return (r100[0] & UByte.MAX_VALUE) | r101;
    }

    private final GXBinaryData parserToBin(File r110) {
        GXBinaryData r100 = new GXBinaryData(null, null, null, null, 15, null);
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r110);
        int r111 = (int) r110.length();     // Catch: Throwable -> L33
        if (r101.read(new byte[100], 0, 100) > 0) goto L8;
        CloseableKt.closeFinally(r101, null);
        return null;
    L8:
        int r112 = r111 - 100;
    L9:
        if (r112 <= 0) goto L30;
        byte[] r102 = new byte[4];     // Catch: Throwable -> L33
        int r103 = r101.read(r102, 0, 4);     // Catch: Throwable -> L33
        GXBinParser r104 = INSTANCE;     // Catch: Throwable -> L33
        int r105 = r104.convertFourUnSignInt(r102);     // Catch: Throwable -> L33
        int r113 = r112 - r103;     // Catch: Throwable -> L33
        byte[] r106 = new byte[r105];     // Catch: Throwable -> L33
        int r107 = r101.read(r106, 0, r105);     // Catch: Throwable -> L33
        String r114 = new String(r106, Charset.forName("UTF-8"));     // Catch: Throwable -> L33
        int r115 = r113 - r107;     // Catch: Throwable -> L33
        byte[] r108 = new byte[4];     // Catch: Throwable -> L33
        int r109 = r101.read(r108, 0, 4);     // Catch: Throwable -> L33
        int r116 = r104.convertFourUnSignInt(r108);     // Catch: Throwable -> L33
        int r117 = r115 - r109;     // Catch: Throwable -> L33
        byte[] r118 = new byte[r116];     // Catch: Throwable -> L33
        int r119 = r101.read(r118, 0, r116);     // Catch: Throwable -> L33
        String r120 = new String(r118, Charset.forName("UTF-8"));     // Catch: Throwable -> L33
        r112 = r117 - r119;     // Catch: Throwable -> L33
        switch(r114.hashCode()) {
            case -1510940545: goto L27;
            case -808658201: goto L23;
            case 112461797: goto L19;
            case 701608068: goto L15;
            default: goto L9;
        };     // Catch: Throwable -> L33
    L15:
        if (r114.equals(GXTemplateKey.GAIAX_INDEX_JSON) == false) goto L9;
        r100.setLayer(r120);     // Catch: Throwable -> L33
        goto L9
    L19:
        if (r114.equals(GXTemplateKey.GAIAX_INDEX_JS) == false) goto L9;
        r100.setJs(r120);     // Catch: Throwable -> L33
        goto L9
    L23:
        if (r114.equals(GXTemplateKey.GAIAX_INDEX_CSS) == false) goto L9;
        r100.setCss(r120);     // Catch: Throwable -> L33
        goto L9
    L27:
        if (r114.equals(GXTemplateKey.GAIAX_INDEX_DATABINDING) == false) goto L9;
        r100.setDatabinding(r120);     // Catch: Throwable -> L33
        goto L9
    L30:
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r101, null);
        return r100;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    private final GXBinaryData parserToBinaryData(byte[] r100) {
        GXBinaryData r101 = new GXBinaryData(null, null, null, null, 15, null);
        int r102 = r100.length;
        int r103 = 100;
        if (ArraysKt.copyOfRange(r100, 0, 100).length > 0) goto L6;
        return null;
    L6:
        int r104 = r102 - 100;
    L7:
        if (r104 <= 0) goto L27;
        byte[] r105 = ArraysKt.copyOfRange(r100, r103, r103 + 4);
        int r106 = r105.length;
        int r107 = r103 + r106;
        int r108 = r104 - r106;
        byte[] r109 = ArraysKt.copyOfRange(r100, r107, convertFourUnSignInt(r105) + r107);
        int r110 = r109.length;
        String r111 = new String(r109, Charset.forName("UTF-8"));
        int r112 = r107 + r110;
        int r113 = r108 - r110;
        byte[] r114 = ArraysKt.copyOfRange(r100, r112, r112 + 4);
        int r115 = r114.length;
        int r116 = r112 + r115;
        int r117 = r113 - r115;
        byte[] r118 = ArraysKt.copyOfRange(r100, r116, convertFourUnSignInt(r114) + r116);
        int r119 = r118.length;
        String r120 = new String(r118, Charset.forName("UTF-8"));
        r103 = r116 + r119;
        r104 = r117 - r119;
        switch(r111.hashCode()) {
            case -1510940545: goto L24;
            case -808658201: goto L20;
            case 112461797: goto L16;
            case 701608068: goto L12;
            default: goto L7;
        };
    L12:
        if (r111.equals(GXTemplateKey.GAIAX_INDEX_JSON) == false) goto L7;
        r101.setLayer(r120);
        goto L7
    L16:
        if (r111.equals(GXTemplateKey.GAIAX_INDEX_JS) == false) goto L7;
        r101.setJs(r120);
        goto L7
    L20:
        if (r111.equals(GXTemplateKey.GAIAX_INDEX_CSS) == false) goto L7;
        r101.setCss(r120);
        goto L7
    L24:
        if (r111.equals(GXTemplateKey.GAIAX_INDEX_DATABINDING) == false) goto L7;
        r101.setDatabinding(r120);
        goto L7
    L27:
        return r101;
    }

    public final JSONObject parser(File r100) {
        Intrinsics.checkNotNullParameter(r100, "binFile");
        JSONObject r101 = new JSONObject();
        GXBinaryData r102 = parserToBin(r100);
        if (r102 == null) goto L5;
        r101.put(GXTemplateKey.GAIAX_LAYER, r102.getLayer());
        r101.put(GXTemplateKey.GAIAX_DATABINDING, r102.getDatabinding());
        r101.put(GXTemplateKey.GAIAX_CSS, r102.getCss());
        r101.put(GXTemplateKey.GAIAX_JS, r102.getJs());
    L5:
        return r101;
    }

    public final JSONObject parser(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        JSONObject r101 = new JSONObject();
        GXBinaryData r102 = parserToBinaryData(r100);
        if (r102 == null) goto L5;
        r101.put(GXTemplateKey.GAIAX_LAYER, r102.getLayer());
        r101.put(GXTemplateKey.GAIAX_DATABINDING, r102.getDatabinding());
        r101.put(GXTemplateKey.GAIAX_CSS, r102.getCss());
        r101.put(GXTemplateKey.GAIAX_JS, r102.getJs());
    L5:
        return r101;
    }
}
