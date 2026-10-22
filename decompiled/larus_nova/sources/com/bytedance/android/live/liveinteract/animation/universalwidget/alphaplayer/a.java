package com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public class a {

    @SerializedName("landscape")
    public C1151a landscape;

    @SerializedName("portrait")
    public C1151a portrait;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a$a, reason: collision with other inner class name */
    public static class C1151a {

        @SerializedName("h")
        public int actualHeight;

        @SerializedName("w")
        public int actualWidth;

        @SerializedName("align")
        public int align;

        @SerializedName("aFrame")
        public int[] alphaFrame;

        @SerializedName(GXTemplateKey.GAIAX_LAYERS)
        private List<b> layersModel;

        @SerializedName("masks")
        public Map<String, Map<String, DataSource.Element>> masks;

        @SerializedName("path")
        public String path;

        @SerializedName("rgbFrame")
        public int[] rgbFrame;

        @SerializedName("f")
        public int totalFrame;

        @SerializedName(BaseSwitches.V)
        public int version;

        @SerializedName("videoH")
        public int videoHeight;

        @SerializedName("videoW")
        public int videoWidth;

        public C1151a() {
        }

        public final List<DataSource.Layer> a() {
            if (this.layersModel != null) goto L5;
            return null;
        L5:
            ArrayList r100 = new ArrayList();
            Iterator<b> r101 = this.layersModel.iterator();
        L7:
            if (r101.hasNext() == false) goto L41;
            b r102 = r101.next();
            r102.getClass();
            DataSource.Layer r103 = new DataSource.Layer();
            r103.f451147a = r102.name;
            int r104 = r102.type;
            r103.f451148b = r104;
            if (r104 == 0) goto L14;
            if (r104 == 1) goto L14;
            if (r104 != 2) goto L15;
            r103.f451150d = new DataSource.Area(r102.alphaArea);
            r103.f451149c = new DataSource.Area(r102.rgbArea);
        L15:
            c r105 = r102.maskContainer;
            if (r105 == null) goto L40;
            if (r105.alphaArea != null) goto L20;
        L38:
            DataSource.MaskContainer r106 = null;
        L39:
            r103.f451152f = r106;
            goto L40
        L20:
            if (r105.rgbArea == null) goto L38;
            r106 = new DataSource.MaskContainer();
            new DataSource.Area(r105.alphaArea);
            new DataSource.Area(r105.rgbArea);
            int[] r107 = r105.contentPadding;
            if (r107 != null) goto L25;
        L28:
            int[] r108 = r105.flexPadding;
            if (r108 == null) goto L37;
            int[] r110 = r105.anchorPoint;
            if (r110 == null) goto L37;
            if (r108.length != 4) goto L36;
            int r111 = r108[1];
            int r109 = r108[3];
            int r112 = r108[0];
            int r113 = r108[2];
        L36:
            int r114 = r110[0];
            int r115 = r110[1];
        L37:
            r106.f451153a = r105.fallbackLayer;
            goto L39
        L25:
            if (r107.length != 4) goto L28;
            int r116 = r107[1];
            int r117 = r107[3];
            int r118 = r107[0];
            int r119 = r107[2];
        L40:
            r100.add(r103);
        L14:
            r103.f451151e = r102.enableTap;
            goto L15
        L41:
            return r100;
        }
    }

    public static class b {

        @SerializedName("alphaFrame")
        public int[] alphaArea;

        @SerializedName("enableTap")
        public boolean enableTap;

        @SerializedName("maskContainer")
        public c maskContainer;

        @SerializedName("name")
        public String name;

        @SerializedName("originSize")
        public int[] originSize;

        @SerializedName("rgbFrame")
        public int[] rgbArea;

        @SerializedName("type")
        public int type;

        public b() {
        }
    }

    public static class c {

        @SerializedName("alignType")
        public int alignType;

        @SerializedName("alphaFrame")
        public int[] alphaArea;

        @SerializedName("anchorPoint")
        public int[] anchorPoint;

        @SerializedName("type")
        public int containerType;

        @SerializedName("contentPadding")
        public int[] contentPadding;

        @SerializedName("disableFlexX")
        public boolean disableFlexX;

        @SerializedName("disableFlexY")
        public boolean disableFlexY;

        @SerializedName("fallbackLayer")
        public String fallbackLayer;

        @SerializedName("flexPadding")
        public int[] flexPadding;

        @SerializedName("rgbFrame")
        public int[] rgbArea;

        public c() {
            this.disableFlexX = false;
            this.disableFlexY = false;
        }
    }

    public a() {
    }
}
