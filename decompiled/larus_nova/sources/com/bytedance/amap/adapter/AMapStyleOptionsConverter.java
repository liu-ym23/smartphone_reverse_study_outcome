package com.bytedance.amap.adapter;

import com.amap.api.maps.model.CustomMapStyleOptions;
import com.bytedance.map.api.model.BDMapStyleOptions;

/* JADX INFO: loaded from: classes43.dex */
public final class AMapStyleOptionsConverter {
    private AMapStyleOptionsConverter() {
    }

    public static CustomMapStyleOptions from(BDMapStyleOptions r100) {
        CustomMapStyleOptions r101 = new CustomMapStyleOptions();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.setEnable(r100.isEnable());
        if (isEmpty(r100.getStyleId()) == true) goto L9;
        r101.setStyleId(r100.getStyleId());
    L9:
        if (r100.getStyleData() == null) goto L12;
        r101.setStyleData(r100.getStyleData());
    L15:
        if (r100.getStyleExtraData() == null) goto L18;
        r101.setStyleExtraData(r100.getStyleExtraData());
    L21:
        if (r100.getStyleTextureData() == null) goto L24;
        r101.setStyleTextureData(r100.getStyleTextureData());
    L27:
        if (r100.getStyleResData() == null) goto L30;
        r101.setStyleResData(r100.getStyleResData());
    L33:
        if (r100.getStyleDataOversea() == null) goto L36;
        r101.setStyleDataOversea(r100.getStyleDataOversea());
    L38:
        return r101;
    L36:
        if (isEmpty(r100.getStyleDataOverseaPath()) == true) goto L38;
        r101.setStyleDataOverseaPath(r100.getStyleDataOverseaPath());
        goto L38
    L30:
        if (isEmpty(r100.getStyleResDataPath()) == true) goto L33;
        r101.setStyleResDataPath(r100.getStyleResDataPath());
        goto L33
    L24:
        if (isEmpty(r100.getStyleTexturePath()) == true) goto L27;
        r101.setStyleTexturePath(r100.getStyleTexturePath());
        goto L27
    L18:
        if (isEmpty(r100.getStyleExtraPath()) == true) goto L21;
        r101.setStyleExtraPath(r100.getStyleExtraPath());
        goto L21
    L12:
        if (isEmpty(r100.getStyleDataPath()) == true) goto L15;
        r101.setStyleDataPath(r100.getStyleDataPath());
        goto L15
    }

    private static boolean isEmpty(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }
}
