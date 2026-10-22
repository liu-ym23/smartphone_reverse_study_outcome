package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class LocationOverlay extends InnerOverlay {

    /* renamed from: d, reason: collision with root package name */
    private AppBaseMap f8871d;

    public LocationOverlay() {
        super(7);
    }

    public void beginLocationLayerAnimation() {
        this.f8871d.BeginLocationLayerAnimation();
    }

    public void clearLocationLayerData(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putLong("locationaddr", this.mLayerID);
        this.f8871d.ClearLocationLayerData(bundle);
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean getDefaultShowStatus() {
        return true;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getLayerTag() {
        return MapController.LOCATION_LAYER_TAG;
    }

    public void setLocationLayerData(List<OverlayLocationData> list) {
        Bundle bundle;
        Bundle bundle2;
        List<OverlayLocationData> list2 = list;
        if (list2 == null || list.size() <= 0 || this.mLayerID == 0) {
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putLong("locationaddr", this.mLayerID);
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < list.size()) {
            OverlayLocationData overlayLocationData = list2.get(i4);
            if (overlayLocationData.getImgType() != "arrowicon") {
                if (overlayLocationData.getImgType() != "icon") {
                    bundle2 = bundle3;
                    if (overlayLocationData.getImgType() != "gificon") {
                        if (overlayLocationData.getImage() == null) {
                            return;
                        }
                        ParcelItem parcelItem = new ParcelItem();
                        Bitmap image = overlayLocationData.getImage();
                        Bundle bundle4 = new Bundle();
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(image.getHeight() * image.getWidth() * 4);
                        image.copyPixelsToBuffer(byteBufferAllocate);
                        byte[] bArrArray = byteBufferAllocate.array();
                        bundle4.putByteArray("imgbin", bArrArray);
                        bundle4.putInt("w", overlayLocationData.getImgWidth());
                        bundle4.putInt("h", overlayLocationData.getImgHeight());
                        bundle4.putInt("rotation", overlayLocationData.isRotation());
                        bundle4.putString("name", overlayLocationData.getImgName() + "_" + Arrays.hashCode(bArrArray));
                        parcelItem.setBundle(bundle4);
                        arrayList.add(parcelItem);
                    } else if (overlayLocationData.getGIFImgPath() != null) {
                        ParcelItem parcelItem2 = new ParcelItem();
                        Bundle bundle5 = new Bundle();
                        bundle5.putInt("rotation", overlayLocationData.isRotation());
                        bundle5.putInt("animation", overlayLocationData.isAnimation());
                        bundle5.putString("gifpath", overlayLocationData.getGIFImgPath());
                        bundle5.putString("imgtype", overlayLocationData.getImgType());
                        bundle5.putString("name", overlayLocationData.getImgName());
                        bundle5.putFloat("markersize", overlayLocationData.getMarkerSize());
                        parcelItem2.setBundle(bundle5);
                        arrayList.add(parcelItem2);
                    }
                } else if (overlayLocationData.getImage() != null) {
                    ParcelItem parcelItem3 = new ParcelItem();
                    Bitmap image2 = overlayLocationData.getImage();
                    Bundle bundle6 = new Bundle();
                    bundle2 = bundle3;
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(image2.getHeight() * image2.getWidth() * 4);
                    image2.copyPixelsToBuffer(byteBufferAllocate2);
                    bundle6.putByteArray("imgbin", byteBufferAllocate2.array());
                    bundle6.putInt("w", overlayLocationData.getImgWidth());
                    bundle6.putInt("h", overlayLocationData.getImgHeight());
                    bundle6.putInt("len", image2.getHeight() * image2.getWidth() * 4);
                    bundle6.putInt("rotation", overlayLocationData.isRotation());
                    bundle6.putInt("animation", overlayLocationData.isAnimation());
                    bundle6.putString("imgtype", overlayLocationData.getImgType());
                    bundle6.putString("name", overlayLocationData.getImgName());
                    bundle6.putFloat("markersize", overlayLocationData.getMarkerSize());
                    parcelItem3.setBundle(bundle6);
                    arrayList.add(parcelItem3);
                }
                i4++;
                list2 = list;
                bundle3 = bundle2;
            } else if (overlayLocationData.getImage() != null) {
                ParcelItem parcelItem4 = new ParcelItem();
                Bitmap image3 = overlayLocationData.getImage();
                Bundle bundle7 = new Bundle();
                ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(image3.getHeight() * image3.getWidth() * 4);
                image3.copyPixelsToBuffer(byteBufferAllocate3);
                bundle7.putByteArray("imgbin", byteBufferAllocate3.array());
                bundle7.putInt("w", overlayLocationData.getImgWidth());
                bundle7.putInt("h", overlayLocationData.getImgHeight());
                bundle7.putInt("len", image3.getHeight() * image3.getWidth() * 4);
                bundle7.putInt("rotation", 1);
                bundle7.putString("imgtype", overlayLocationData.getImgType());
                bundle7.putString("name", overlayLocationData.getImgName());
                bundle7.putFloat("arrowsize", overlayLocationData.getArrowSize());
                parcelItem4.setBundle(bundle7);
                arrayList.add(parcelItem4);
            }
            bundle2 = bundle3;
            i4++;
            list2 = list;
            bundle3 = bundle2;
        }
        Bundle bundle8 = bundle3;
        if (arrayList.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                parcelItemArr[i5] = (ParcelItem) arrayList.get(i5);
            }
            bundle = bundle8;
            bundle.putParcelableArray("imagedata", parcelItemArr);
        } else {
            bundle = bundle8;
        }
        this.f8871d.SetLocationLayerData(bundle);
    }

    public LocationOverlay(AppBaseMap appBaseMap) {
        super(7, appBaseMap);
        this.f8871d = appBaseMap;
    }
}
