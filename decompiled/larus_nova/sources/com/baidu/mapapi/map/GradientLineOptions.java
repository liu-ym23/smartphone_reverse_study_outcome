package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class GradientLineOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LatLng> f30882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Integer> f30883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Integer> f30884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f30885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LineDirectionCross180 f30887f;

    public static final enum LineDirectionCross180 extends Enum<LineDirectionCross180> {
        public static final LineDirectionCross180 FROM_EAST_TO_WEST = null;
        public static final LineDirectionCross180 FROM_WEST_TO_EAST = null;
        public static final LineDirectionCross180 NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ LineDirectionCross180[] f30888a = null;

        static {
            LineDirectionCross180 r100 = new LineDirectionCross180(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            LineDirectionCross180 r101 = new LineDirectionCross180("FROM_EAST_TO_WEST", 1);
            FROM_EAST_TO_WEST = r101;
            LineDirectionCross180 r102 = new LineDirectionCross180("FROM_WEST_TO_EAST", 2);
            FROM_WEST_TO_EAST = r102;
            f30888a = new LineDirectionCross180[]{r100, r101, r102};
        }

        public static LineDirectionCross180[] values() {
            return (LineDirectionCross180[]) f30888a.clone();
        }

        public static LineDirectionCross180 valueOf(String r100) {
            return (LineDirectionCross180) r27.a.a(LineDirectionCross180.class, r100);
        }

        private LineDirectionCross180(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        GradientLine r100 = new GradientLine();
        r100.f30880j = this.f30885d;
        r100.f31205d = this.f30886e;
        r100.f30881k = this.f30887f;
        List<LatLng> r101 = this.f30882a;
        if (r101 == null) goto L33;
        if (r101.size() < 2) goto L33;
        r100.f30877g = this.f30882a;
        List<Integer> r102 = this.f30884c;
        if (r102 == null) goto L31;
        if (r102.size() == 0) goto L29;
        int[] r103 = new int[this.f30884c.size()];
        Iterator<Integer> r104 = this.f30884c.iterator();
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r104.hasNext() == false) goto L14;
        r103[r106] = r104.next().intValue();
        r106 = r106 + 1;
        goto L12
    L14:
        r100.f30879i = r103;
        List<Integer> r107 = this.f30883b;
        if (r107 == null) goto L27;
        if (r107.size() == 0) goto L25;
        int[] r108 = new int[this.f30883b.size()];
        Iterator<Integer> r109 = this.f30883b.iterator();
    L20:
        if (r109.hasNext() == false) goto L22;
        r108[r105] = r109.next().intValue();
        r105 = r105 + 1;
        goto L20
    L22:
        r100.f30878h = r108;
        return r100;
    L25:
        throw new IllegalStateException("BDMapSDKException: Indexs list size can not be Equal to zero");
    L27:
        throw new IllegalStateException("BDMapSDKException: Indexs list can not be null");
    L29:
        throw new IllegalStateException("BDMapSDKException: colors list size can not be Equal to zero");
    L31:
        throw new IllegalStateException("BDMapSDKException: colors list can not be null");
    L33:
        throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
    }

    public GradientLineOptions() {
        this.f30885d = 5;
        this.f30886e = true;
        this.f30887f = LineDirectionCross180.NONE;
    }

    public List<Integer> getColors() {
        return this.f30884c;
    }

    public List<Integer> getIndexs() {
        return this.f30883b;
    }

    public LineDirectionCross180 getLineDirectionCross180() {
        return this.f30887f;
    }

    public List<LatLng> getPoints() {
        return this.f30882a;
    }

    public int getWidth() {
        return this.f30885d;
    }

    public boolean isVisible() {
        return this.f30886e;
    }

    public GradientLineOptions setColorIndex(List<Integer> r100) {
        if (r100 == null) goto L14;
        if (r100.contains(null) == true) goto L12;
        if (r100.size() == 0) goto L10;
        this.f30883b = r100;
        return this;
    L10:
        throw new IllegalStateException("BDMapSDKException: indexs list size can not be Equal to zero");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: indexs list can not contains null");
    L14:
        throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
    }

    public GradientLineOptions setColorsValues(List<Integer> r100) {
        if (r100 == null) goto L14;
        if (r100.contains(null) == true) goto L12;
        if (r100.size() == 0) goto L10;
        this.f30884c = r100;
        return this;
    L10:
        throw new IllegalStateException("BDMapSDKException: colors list list size can not be Equal to zero");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
    L14:
        throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
    }

    public GradientLineOptions setLineDirectionCross180(LineDirectionCross180 r100) {
        this.f30887f = r100;
        return this;
    }

    public GradientLineOptions setPoints(List<LatLng> r100) {
        if (r100 == null) goto L14;
        if (r100.size() < 2) goto L12;
        if (r100.contains(null) == true) goto L10;
        this.f30882a = r100;
        return this;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
    L14:
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public GradientLineOptions setWidth(int r100) {
        if (r100 <= 0) goto L4;
        this.f30885d = r100;
    L4:
        return this;
    }

    public GradientLineOptions visible(boolean r100) {
        this.f30886e = r100;
        return this;
    }
}
