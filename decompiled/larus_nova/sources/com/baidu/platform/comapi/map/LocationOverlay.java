package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class LocationOverlay extends InnerOverlay {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppBaseMap f33010d;

    public LocationOverlay() {
        super(7);
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean getDefaultShowStatus() {
        return true;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getLayerTag() {
        return "location";
    }

    public void beginLocationLayerAnimation() {
        this.f33010d.BeginLocationLayerAnimation();
    }

    public LocationOverlay(AppBaseMap r100) {
        super(7, r100);
        this.f33010d = r100;
    }

    public void clearLocationLayerData(Bundle r100) {
        if (r100 != null) goto L4;
        r100 = new Bundle();
    L4:
        r100.putLong("locationaddr", this.mLayerID);
        this.f33010d.ClearLocationLayerData(r100);
    }

    public void setLocationLayerData(List<OverlayLocationData> r110) {
        List<OverlayLocationData> r100 = r110;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r110.size() > 0) goto L7;
        return;
    L7:
        if (this.mLayerID == 0) goto L53;
        Bundle r101 = new Bundle();
        r101.putLong("locationaddr", this.mLayerID);
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L11:
        if (r103 >= r110.size()) goto L33;
        OverlayLocationData r104 = (OverlayLocationData) ListProtector.get(r100, r103);
        if (r104.getImgType() != "arrowicon") goto L19;
        if (r104.getImage() == null) goto L17;
        ParcelItem r105 = new ParcelItem();
        Bitmap r106 = r104.getImage();
        Bundle r107 = new Bundle();
        ByteBuffer r108 = ByteBuffer.allocate((r106.getWidth() * r106.getHeight()) * 4);
        r106.copyPixelsToBuffer(r108);
        r107.putByteArray("imgbin", r108.array());
        r107.putInt("w", r104.getImgWidth());
        r107.putInt("h", r104.getImgHeight());
        r107.putInt("len", (r106.getWidth() * r106.getHeight()) * 4);
        r107.putInt("rotation", 1);
        r107.putString("imgtype", r104.getImgType());
        r107.putString("name", r104.getImgName());
        r107.putFloat("arrowsize", r104.getArrowSize());
        r105.setBundle(r107);
        r102.add(r105);
    L17:
        Bundle r111 = r101;
    L32:
        r103 = r103 + 1;
        r100 = r110;
        r101 = r111;
        goto L11
    L19:
        if (r104.getImgType() == "icon") goto L21;
        r111 = r101;
        if (r104.getImgType() != "gificon") goto L29;
        if (r104.getGIFImgPath() == null) goto L32;
        ParcelItem r109 = new ParcelItem();
        Bundle r112 = new Bundle();
        r112.putInt("rotation", r104.isRotation());
        r112.putInt(GXTemplateKey.GAIAX_ANIMATION, r104.isAnimation());
        r112.putString("gifpath", r104.getGIFImgPath());
        r112.putString("imgtype", r104.getImgType());
        r112.putString("name", r104.getImgName());
        r112.putFloat("markersize", r104.getMarkerSize());
        r109.setBundle(r112);
        r102.add(r109);
        goto L32
    L29:
        if (r104.getImage() == null) goto L30;
        ParcelItem r113 = new ParcelItem();
        Bitmap r114 = r104.getImage();
        Bundle r115 = new Bundle();
        ByteBuffer r116 = ByteBuffer.allocate((r114.getWidth() * r114.getHeight()) * 4);
        r114.copyPixelsToBuffer(r116);
        byte[] r117 = r116.array();
        r115.putByteArray("imgbin", r117);
        r115.putInt("w", r104.getImgWidth());
        r115.putInt("h", r104.getImgHeight());
        r115.putInt("rotation", r104.isRotation());
        r115.putString("name", r104.getImgName() + "_" + Arrays.hashCode(r117));
        r113.setBundle(r115);
        r102.add(r113);
        goto L32
    L30:
        return;
    L21:
        if (r104.getImage() == null) goto L17;
        ParcelItem r118 = new ParcelItem();
        Bitmap r119 = r104.getImage();
        Bundle r120 = new Bundle();
        r111 = r101;
        ByteBuffer r121 = ByteBuffer.allocate((r119.getWidth() * r119.getHeight()) * 4);
        r119.copyPixelsToBuffer(r121);
        r120.putByteArray("imgbin", r121.array());
        r120.putInt("w", r104.getImgWidth());
        r120.putInt("h", r104.getImgHeight());
        r120.putInt("len", (r119.getWidth() * r119.getHeight()) * 4);
        r120.putInt("rotation", r104.isRotation());
        r120.putInt(GXTemplateKey.GAIAX_ANIMATION, r104.isAnimation());
        r120.putString("imgtype", r104.getImgType());
        r120.putString("name", r104.getImgName());
        r120.putFloat("markersize", r104.getMarkerSize());
        r118.setBundle(r120);
        r102.add(r118);
        goto L32
    L33:
        Bundle r122 = r101;
        if (r102.size() <= 0) goto L40;
        ParcelItem[] r123 = new ParcelItem[r102.size()];
        int r124 = 0;
    L37:
        if (r124 >= r102.size()) goto L39;
        r123[r124] = (ParcelItem) ListProtector.get(r102, r124);
        r124 = r124 + 1;
        goto L37
    L39:
        Bundle r125 = r122;
        r125.putParcelableArray("imagedata", r123);
    L41:
        this.f33010d.SetLocationLayerData(r125);
        return;
    L40:
        r125 = r122;
        goto L41
    }
}
