package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GradientLineOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private List<LatLng> f6363a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f6364b;

    /* renamed from: c, reason: collision with root package name */
    private List<Integer> f6365c;

    /* renamed from: d, reason: collision with root package name */
    private int f6366d = 5;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6367e = true;

    /* renamed from: f, reason: collision with root package name */
    private LineDirectionCross180 f6368f = LineDirectionCross180.NONE;

    public enum LineDirectionCross180 {
        NONE,
        FROM_EAST_TO_WEST,
        FROM_WEST_TO_EAST
    }

    public List<Integer> getColors() {
        return this.f6365c;
    }

    public List<Integer> getIndexs() {
        return this.f6364b;
    }

    public LineDirectionCross180 getLineDirectionCross180() {
        return this.f6368f;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        GradientLine gradientLine = new GradientLine();
        gradientLine.f6361j = this.f6366d;
        gradientLine.f6721d = this.f6367e;
        gradientLine.f6362k = this.f6368f;
        List<LatLng> list = this.f6363a;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
        }
        gradientLine.f6358g = this.f6363a;
        List<Integer> list2 = this.f6365c;
        if (list2 == null) {
            throw new IllegalStateException("BDMapSDKException: colors list can not be null");
        }
        if (list2.size() == 0) {
            throw new IllegalStateException("BDMapSDKException: colors list size can not be Equal to zero");
        }
        int[] iArr = new int[this.f6365c.size()];
        Iterator<Integer> it = this.f6365c.iterator();
        int i4 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            iArr[i5] = it.next().intValue();
            i5++;
        }
        gradientLine.f6360i = iArr;
        List<Integer> list3 = this.f6364b;
        if (list3 == null) {
            throw new IllegalStateException("BDMapSDKException: Indexs list can not be null");
        }
        if (list3.size() == 0) {
            throw new IllegalStateException("BDMapSDKException: Indexs list size can not be Equal to zero");
        }
        int[] iArr2 = new int[this.f6364b.size()];
        Iterator<Integer> it2 = this.f6364b.iterator();
        while (it2.hasNext()) {
            iArr2[i4] = it2.next().intValue();
            i4++;
        }
        gradientLine.f6359h = iArr2;
        return gradientLine;
    }

    public List<LatLng> getPoints() {
        return this.f6363a;
    }

    public int getWidth() {
        return this.f6366d;
    }

    public boolean isVisible() {
        return this.f6367e;
    }

    public GradientLineOptions setColorIndex(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not contains null");
        }
        if (list.size() == 0) {
            throw new IllegalStateException("BDMapSDKException: indexs list size can not be Equal to zero");
        }
        this.f6364b = list;
        return this;
    }

    public GradientLineOptions setColorsValues(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
        }
        if (list.size() == 0) {
            throw new IllegalStateException("BDMapSDKException: colors list list size can not be Equal to zero");
        }
        this.f6365c = list;
        return this;
    }

    public GradientLineOptions setLineDirectionCross180(LineDirectionCross180 lineDirectionCross180) {
        this.f6368f = lineDirectionCross180;
        return this;
    }

    public GradientLineOptions setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.f6363a = list;
        return this;
    }

    public GradientLineOptions setWidth(int i4) {
        if (i4 > 0) {
            this.f6366d = i4;
        }
        return this;
    }

    public GradientLineOptions visible(boolean z4) {
        this.f6367e = z4;
        return this;
    }
}
