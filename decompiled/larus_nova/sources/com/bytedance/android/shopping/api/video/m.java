package com.bytedance.android.shopping.api.video;

import com.bytedance.android.ec.model.video.BitRate;
import com.bytedance.android.ec.model.video.ECBaseVideo;
import com.bytedance.android.ec.model.video.UrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m {
    public m() {
    }

    static {
    }

    public static e b(ECBaseVideo r210, d r211) {
        Intrinsics.checkNotNullParameter(r210, "videoInfo");
        long r100 = r210.getDuration();
        ArrayList r101 = new ArrayList();
        b r102 = a(r210.getH265PlayAddr(), r100, true);
        if (r102 == null) goto L5;
        r101.add(r102);
    L5:
        b r103 = a(r210.getPlayAddr(), r100, false);
        if (r103 == null) goto L8;
        r101.add(r103);
    L8:
        ArrayList r104 = new ArrayList();
        List<BitRate> r105 = r210.getBitRate();
        String r106 = "";
        if (r105 == null) goto L41;
        Iterator<T> r107 = r105.iterator();
    L12:
        if (r107.hasNext() == false) goto L41;
        BitRate r108 = (BitRate) r107.next();
        if (r108 == null) goto L18;
        UrlModel r109 = r108.getPlayAddr();
        if (r109 == null) goto L18;
        String r110 = r109.getUri();
        if (r110 != null) goto L22;
        String r111 = "";
    L23:
        String r112 = r109.getUrlKey();
        if (r112 != null) goto L26;
        String r113 = "";
    L27:
        int r114 = r108.getBitRate();
        if (r108.isH265() != 1) goto L30;
        CodecType r115 = CodecType.CODEC_TYPE_265;
    L31:
        CodecType r212 = r115;
        List<String> r116 = r109.getUrlList();
        if (r116 != null) goto L34;
        r116 = CollectionsKt.emptyList();
    L34:
        List<String> r213 = r116;
        long r214 = r109.getSize();
        int r117 = (int) r100;
        String r118 = r108.getGearName();
        if (r118 != null) goto L37;
        String r215 = "";
    L38:
        b r119 = new b(r111, r113, r114, r212, r213, r214, r117, r215, r108.getQualityType());
    L39:
        if (r119 == null) goto L12;
        r104.add(r119);
        goto L12
    L37:
        r215 = r118;
        goto L38
    L30:
        r115 = CodecType.CODEC_TYPE_264;
        goto L31
    L26:
        r113 = r112;
        goto L27
    L22:
        r111 = r110;
    L18:
        r119 = null;
    L41:
        String r120 = r210.getVideoId();
        if (r120 == null) goto L45;
        r106 = r120;
    L45:
        long r121 = r210.getDuration();
        String r122 = r210.getRatio();
        long r123 = r210.getCdnUrlExpired();
        float r124 = r210.getWidth() / r210.getHeight();
    L50:
        return new e(r106, r121, r122, r101, r104, r211, r123, r124, r210.getVideoThumbs(), r210.getHeight(), r210.getWidth(), null, null);
    L48:
        r124 = 0.0f;
        goto L50
    }

    public static b a(UrlModel r110, long r111, boolean r112) {
        if (r110 != null) goto L5;
        return null;
    L5:
        String r100 = r110.getUri();
        if (r100 != null) goto L8;
        String r101 = "";
    L9:
        String r102 = r110.getUrlKey();
        if (r102 != null) goto L12;
        String r103 = "";
    L13:
        if (r112 == false) goto L15;
        CodecType r113 = CodecType.CODEC_TYPE_265;
    L16:
        CodecType r104 = r113;
        List<String> r114 = r110.getUrlList();
        if (r114 != null) goto L19;
        r114 = CollectionsKt.emptyList();
    L19:
        String r105 = r101;
        String r106 = r103;
        return new b(r105, r106, 0, r104, r114, r110.getSize(), (int) r111, "", 0);
    L15:
        r113 = CodecType.CODEC_TYPE_264;
        goto L16
    L12:
        r103 = r102;
        goto L13
    L8:
        r101 = r100;
        goto L9
    }
}
