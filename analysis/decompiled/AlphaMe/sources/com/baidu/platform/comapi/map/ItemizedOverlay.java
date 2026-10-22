package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.OverlayItem;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ItemizedOverlay<Item extends OverlayItem> extends Overlay implements Comparator<Integer> {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<OverlayItem> f8861a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Integer> f8862b;

    /* renamed from: c, reason: collision with root package name */
    protected Drawable f8863c;

    /* renamed from: d, reason: collision with root package name */
    protected MapSurfaceView f8864d;

    /* renamed from: e, reason: collision with root package name */
    protected MapTextureView f8865e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f8866f;

    /* renamed from: g, reason: collision with root package name */
    protected Drawable f8867g;

    /* renamed from: h, reason: collision with root package name */
    protected OverlayItem f8868h;

    /* renamed from: i, reason: collision with root package name */
    protected int f8869i = 0;

    /* renamed from: j, reason: collision with root package name */
    protected int f8870j;

    public ItemizedOverlay(Drawable drawable, MapSurfaceView mapSurfaceView) {
        this.mType = 27;
        this.f8863c = drawable;
        this.f8861a = new ArrayList<>();
        this.f8862b = new ArrayList<>();
        this.f8864d = mapSurfaceView;
        this.mLayerID = 0L;
    }

    private void a(List<OverlayItem> list, boolean z4) throws JSONException {
        a(list, z4, false);
    }

    public void addItem(OverlayItem overlayItem) throws JSONException {
        if (overlayItem != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(overlayItem);
            addItem(arrayList);
        }
    }

    public void addItemsByReplace(List<OverlayItem> list) throws JSONException {
        a(list, false, true);
    }

    public synchronized void b(boolean z4) {
        this.f8866f = z4;
    }

    public void c() throws JSONException {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f8861a);
        }
        removeAll();
        addItem(arrayList);
    }

    public ArrayList<OverlayItem> getAllItem() {
        return this.f8861a;
    }

    public GeoPoint getCenter() {
        int iA = a(0);
        if (iA == -1) {
            return null;
        }
        return getItem(iA).getPoint();
    }

    public final OverlayItem getItem(int i4) {
        ArrayList arrayList;
        if (this.f8861a == null) {
            return null;
        }
        synchronized (this) {
            arrayList = new ArrayList(this.f8861a);
        }
        if (arrayList.size() <= i4 || i4 < 0) {
            return null;
        }
        return (OverlayItem) arrayList.get(i4);
    }

    public int getLatSpanE6() {
        return a(true);
    }

    public int getLonSpanE6() {
        return a(false);
    }

    public int getUpdateType() {
        return this.f8869i;
    }

    public void initLayer() {
        long jAddLayer = this.f8864d.getController().getBaseMap().AddLayer(0, 0, MapController.ITEM_LAYER_TAG);
        this.mLayerID = jAddLayer;
        if (jAddLayer == 0) {
            throw new RuntimeException("can not add new layer");
        }
    }

    public boolean onTap(int i4) {
        return false;
    }

    public boolean removeAll() {
        synchronized (this) {
            try {
                if (this.f8861a.isEmpty()) {
                    return false;
                }
                if (this.f8864d.getController() != null && this.f8864d.getController().getBaseMap() != null) {
                    this.f8864d.getController().getBaseMap().ClearLayer(this.mLayerID);
                }
                synchronized (this) {
                    this.f8861a.clear();
                    this.f8866f = true;
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean removeItem(OverlayItem overlayItem) {
        if (this.mLayerID == 0) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("itemaddr", this.mLayerID);
        if (overlayItem.getId().equals("")) {
            return false;
        }
        bundle.putString("id", overlayItem.getId());
        if (!this.f8864d.getController().getBaseMap().RemoveItemData(bundle)) {
            return false;
        }
        synchronized (this) {
            this.f8861a.remove(overlayItem);
            this.f8866f = true;
        }
        return true;
    }

    public boolean removeOneItem(Iterator<OverlayItem> it, OverlayItem overlayItem) {
        if (this.mLayerID == 0) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("itemaddr", this.mLayerID);
        if (overlayItem.getId().equals("")) {
            return false;
        }
        bundle.putString("id", overlayItem.getId());
        if (!this.f8864d.getController().getBaseMap().RemoveItemData(bundle)) {
            return false;
        }
        it.remove();
        synchronized (this) {
            this.f8866f = true;
        }
        return true;
    }

    public void setFocus(int i4, boolean z4) throws JSONException {
        OverlayItem item;
        ArrayList arrayList;
        if (this.f8868h == null || (item = getItem(i4)) == null) {
            return;
        }
        if (z4) {
            this.f8868h.setGeoPoint(new GeoPoint(item.getPoint().getLatitude(), item.getPoint().getLongitude()));
            synchronized (this) {
                arrayList = new ArrayList(this.f8861a);
            }
            if (arrayList.contains(this.f8868h)) {
                updateItem(this.f8868h);
            } else {
                addItem(this.f8868h);
            }
        } else {
            removeItem(this.f8868h);
        }
        MapSurfaceView mapSurfaceView = this.f8864d;
        if (mapSurfaceView != null) {
            mapSurfaceView.refresh(this);
        }
    }

    public void setFocusMarker(Drawable drawable) {
        this.f8867g = drawable;
        if (this.f8868h == null) {
            this.f8868h = new OverlayItem(null, "", "");
        }
        this.f8868h.setMarker(this.f8867g);
    }

    public void setUpdateType(int i4) {
        this.f8869i = i4;
    }

    public void setmMarker(Drawable drawable) {
        this.f8863c = drawable;
    }

    public synchronized int size() {
        ArrayList<OverlayItem> arrayList;
        arrayList = this.f8861a;
        return arrayList == null ? 0 : arrayList.size();
    }

    public boolean updateItem(OverlayItem overlayItem) throws JSONException {
        ArrayList arrayList;
        if (overlayItem == null || overlayItem.getId().equals("")) {
            return false;
        }
        synchronized (this) {
            arrayList = new ArrayList(this.f8861a);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (overlayItem.getId().equals(((OverlayItem) it.next()).getId())) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(overlayItem);
                a(arrayList2, true);
                return true;
            }
        }
        return false;
    }

    private void a(List<OverlayItem> list, boolean z4, boolean z5) throws JSONException {
        if (z5) {
            synchronized (this) {
                try {
                    ArrayList<OverlayItem> arrayList = this.f8861a;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                } finally {
                }
            }
        }
        if (this.mLayerID == 0) {
            if (z4) {
                return;
            }
            synchronized (this) {
                try {
                    ArrayList<OverlayItem> arrayList2 = this.f8861a;
                    if (arrayList2 != null && list != null) {
                        arrayList2.addAll(list);
                    }
                } finally {
                }
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.clear();
        ArrayList arrayList3 = new ArrayList();
        bundle.putLong("itemaddr", this.mLayerID);
        bundle.putInt("bshow", 1);
        if (z4) {
            bundle.putString("extparam", "update");
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            OverlayItem overlayItem = list.get(i4);
            if (overlayItem.getMarker() == null) {
                overlayItem.setMarker(this.f8863c);
            }
            if (TextUtils.isEmpty(overlayItem.getId())) {
                overlayItem.setId(o.a());
            }
            ParcelItem parcelItem = new ParcelItem();
            Drawable marker = overlayItem.getMarker();
            byte[] gifData = overlayItem.getGifData();
            if (marker != null || gifData != null) {
                Bundle bundle2 = new Bundle();
                GeoPoint geoPointA = overlayItem.getCoordType() == OverlayItem.CoordType.CoordType_BD09LL ? l.a(overlayItem.getPoint()) : overlayItem.getPoint();
                bundle2.putDouble("x", geoPointA.getLongitude());
                bundle2.putDouble("y", geoPointA.getLatitude());
                bundle2.putFloat(MapBundleKey.MapObjKey.OBJ_GEO_Z, overlayItem.getGeoZ());
                bundle2.putInt(MapBundleKey.MapObjKey.OBJ_INDOOR_POI, overlayItem.getIndoorPoi());
                bundle2.putInt("showLR", 1);
                bundle2.putInt("iconwidth", 0);
                bundle2.putInt("iconlayer", 1);
                bundle2.putFloat("ax", overlayItem.getAnchorX());
                bundle2.putFloat("ay", overlayItem.getAnchorY());
                bundle2.putInt("bound", overlayItem.getBound());
                bundle2.putInt("level", overlayItem.getLevel());
                bundle2.putInt("mask", overlayItem.getMask());
                bundle2.putString("popname", "" + overlayItem.getId());
                if (gifData != null) {
                    bundle2.putFloat("gifscale", overlayItem.getScale());
                    bundle2.putInt("gifsize", gifData.length);
                    bundle2.putByteArray("imgdata", gifData);
                    bundle2.putInt("imgindex", a());
                } else {
                    Bitmap bitmapA = com.baidu.platform.comapi.util.c.a(marker);
                    if (bitmapA != null) {
                        bundle2.putInt("imgindex", overlayItem.getResId());
                        bundle2.putInt("imgW", bitmapA.getWidth());
                        bundle2.putInt("imgH", bitmapA.getHeight());
                        if (z4 || !a(overlayItem)) {
                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmapA.getHeight() * bitmapA.getWidth() * 4);
                            bitmapA.copyPixelsToBuffer(byteBufferAllocate);
                            bundle2.putByteArray("imgdata", byteBufferAllocate.array());
                        } else {
                            bundle2.putByteArray("imgdata", null);
                        }
                    }
                }
                String[] strArrA = a(overlayItem.getClickRect());
                if (strArrA != null && strArrA.length > 0) {
                    bundle2.putStringArray("clickrect", strArrA);
                }
                bundle2.putBundle("animate", overlayItem.getAnimate());
                bundle2.putBundle("delay", overlayItem.getDelay());
                parcelItem.setBundle(bundle2);
                arrayList3.add(parcelItem);
                if (!z4) {
                    this.f8861a.add(overlayItem);
                }
            }
        }
        if (arrayList3.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList3.size()];
            for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                parcelItemArr[i5] = (ParcelItem) arrayList3.get(i5);
            }
            bundle.putParcelableArray("itemdatas", parcelItemArr);
            this.f8864d.getController().getBaseMap().AddItemData(bundle, z5);
        }
        synchronized (this) {
            this.f8866f = true;
        }
    }

    public boolean b() {
        return this.f8866f;
    }

    @Override // java.util.Comparator
    public int compare(Integer num, Integer num2) {
        GeoPoint point;
        GeoPoint point2;
        synchronized (this) {
            point = this.f8861a.get(num.intValue()).getPoint();
            point2 = this.f8861a.get(num2.intValue()).getPoint();
        }
        if (point.getLatitude() > point2.getLatitude()) {
            return -1;
        }
        if (point.getLatitude() < point2.getLatitude()) {
            return 1;
        }
        if (point.getLongitude() < point2.getLongitude()) {
            return -1;
        }
        return point.getLongitude() == point2.getLongitude() ? 0 : 1;
    }

    public boolean onTap(int i4, int i5, GeoPoint geoPoint) {
        return false;
    }

    public boolean onTap(GeoPoint geoPoint, MapSurfaceView mapSurfaceView) {
        return false;
    }

    public void addItem(List<OverlayItem> list) throws JSONException {
        a(list, false, false);
    }

    public void setFocusMarker(Drawable drawable, float f4, float f5) {
        this.f8867g = drawable;
        if (this.f8868h == null) {
            OverlayItem overlayItem = new OverlayItem(null, "", "");
            this.f8868h = overlayItem;
            overlayItem.setAnchor(f4, f5);
        }
        this.f8868h.setMarker(this.f8867g);
    }

    public ItemizedOverlay(Drawable drawable, MapTextureView mapTextureView) {
        this.mType = 27;
        this.f8863c = drawable;
        this.f8861a = new ArrayList<>();
        this.f8862b = new ArrayList<>();
        this.f8865e = mapTextureView;
        this.mLayerID = 0L;
    }

    public boolean updateItem(List<OverlayItem> list) throws JSONException {
        if (list == null) {
            return false;
        }
        a(list, true);
        return true;
    }

    public String[] a(ArrayList<Bundle> arrayList) throws JSONException {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i4 = 0; i4 < size; i4++) {
            JSONObject jSONObject = new JSONObject();
            Bundle bundle = arrayList.get(i4);
            for (String str : bundle.keySet()) {
                try {
                    jSONObject.put(str, bundle.get(str));
                } catch (JSONException unused) {
                }
            }
            strArr[i4] = jSONObject.toString();
        }
        return strArr;
    }

    private int a(boolean z4) {
        ArrayList arrayList;
        if (this.f8861a == null) {
            return 0;
        }
        synchronized (this) {
            try {
                if (this.f8861a.size() == 0) {
                    return 0;
                }
                synchronized (this) {
                    arrayList = new ArrayList(this.f8861a);
                }
                Iterator it = arrayList.iterator();
                int i4 = Integer.MIN_VALUE;
                int i5 = Integer.MAX_VALUE;
                while (it.hasNext()) {
                    GeoPoint point = ((OverlayItem) it.next()).getPoint();
                    int latitude = (int) (z4 ? point.getLatitude() : point.getLongitude());
                    if (latitude > i4) {
                        i4 = latitude;
                    }
                    if (latitude < i5) {
                        i5 = latitude;
                    }
                }
                return i4 - i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(int i4) {
        synchronized (this) {
            try {
                ArrayList<OverlayItem> arrayList = this.f8861a;
                if (arrayList != null && arrayList.size() != 0) {
                    return i4;
                }
                return -1;
            } finally {
            }
        }
    }

    public boolean a(OverlayItem overlayItem) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f8861a);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            OverlayItem overlayItem2 = (OverlayItem) it.next();
            if (overlayItem.getResId() == -1) {
                return false;
            }
            if (overlayItem2.getResId() != -1 && overlayItem.getResId() == overlayItem2.getResId()) {
                return true;
            }
        }
        return false;
    }

    private int a() {
        int i4 = this.f8870j;
        if (i4 >= Integer.MAX_VALUE) {
            return 0;
        }
        int i5 = i4 + 1;
        this.f8870j = i5;
        return i5;
    }
}
