package com.baidu.platform.comapi.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class OverlayItem {
    public static final int ALIGN_BOTTON = 2;
    public static final int ALIGN_TOP = 3;
    public static final int ALING_CENTER = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f9017b;

    /* renamed from: c, reason: collision with root package name */
    private int f9018c;

    /* renamed from: d, reason: collision with root package name */
    protected GeoPoint f9019d;

    /* renamed from: e, reason: collision with root package name */
    protected String f9020e;

    /* renamed from: f, reason: collision with root package name */
    protected String f9021f;

    /* renamed from: m, reason: collision with root package name */
    private Bundle f9028m;

    /* renamed from: n, reason: collision with root package name */
    private Bundle f9029n;

    /* renamed from: o, reason: collision with root package name */
    private float f9030o;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f9031p;

    /* renamed from: q, reason: collision with root package name */
    private float f9032q;

    /* renamed from: s, reason: collision with root package name */
    private int f9034s;

    /* renamed from: i, reason: collision with root package name */
    private CoordType f9024i = CoordType.CoordType_BD09;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f9022g = null;

    /* renamed from: r, reason: collision with root package name */
    private int f9033r = 0;

    /* renamed from: a, reason: collision with root package name */
    private int f9016a = 2;

    /* renamed from: h, reason: collision with root package name */
    private String f9023h = "";

    /* renamed from: j, reason: collision with root package name */
    private float f9025j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    private float f9026k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<Bundle> f9027l = new ArrayList<>();

    public enum AnimEffect {
        NONE,
        GROWTH,
        WAVE,
        SHRINK,
        FADE_OUT,
        FADE_IN,
        GROWTH_FADE_IN,
        SHRINK_FADE_OUT,
        GROWTH_REBOUND,
        ALPHA,
        ANCHOR_GROUTH,
        ROTATE
    }

    public enum AnimationSubType {
        NONE,
        RADAR
    }

    public enum CoordType {
        CoordType_BD09LL,
        CoordType_BD09
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9035a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f9036b;

        static {
            int[] iArr = new int[AnimationSubType.values().length];
            f9036b = iArr;
            try {
                iArr[AnimationSubType.RADAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9036b[AnimationSubType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[AnimEffect.values().length];
            f9035a = iArr2;
            try {
                iArr2[AnimEffect.GROWTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9035a[AnimEffect.WAVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9035a[AnimEffect.SHRINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9035a[AnimEffect.FADE_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9035a[AnimEffect.FADE_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9035a[AnimEffect.GROWTH_FADE_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9035a[AnimEffect.SHRINK_FADE_OUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9035a[AnimEffect.GROWTH_REBOUND.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9035a[AnimEffect.ALPHA.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9035a[AnimEffect.ANCHOR_GROUTH.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9035a[AnimEffect.ROTATE.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9035a[AnimEffect.NONE.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public OverlayItem(GeoPoint geoPoint, String str, String str2) {
        this.f9019d = geoPoint;
        this.f9020e = str;
        this.f9021f = str2;
    }

    public void addClickRect(Bundle bundle) {
        if (this.f9027l == null) {
            this.f9027l = new ArrayList<>();
        }
        this.f9027l.add(bundle);
    }

    public float getAnchorX() {
        return this.f9025j;
    }

    public float getAnchorY() {
        return this.f9026k;
    }

    public Bundle getAnimate() {
        return this.f9028m;
    }

    public int getBound() {
        return this.f9016a;
    }

    public ArrayList<Bundle> getClickRect() {
        return this.f9027l;
    }

    public CoordType getCoordType() {
        return this.f9024i;
    }

    public Bundle getDelay() {
        return this.f9029n;
    }

    public float getGeoZ() {
        return this.f9030o;
    }

    public byte[] getGifData() {
        return this.f9031p;
    }

    public String getId() {
        return this.f9023h;
    }

    public int getIndoorPoi() {
        return this.f9034s;
    }

    public int getLevel() {
        return this.f9017b;
    }

    public final Drawable getMarker() {
        return this.f9022g;
    }

    public int getMask() {
        return this.f9018c;
    }

    public float getMultiplyDpi() {
        return this.f9033r;
    }

    public GeoPoint getPoint() {
        return this.f9019d;
    }

    public int getResId() {
        if (getMarker() == null) {
            return -1;
        }
        return getMarker().hashCode();
    }

    public float getScale() {
        return this.f9032q;
    }

    public String getSnippet() {
        return this.f9021f;
    }

    public String getTitle() {
        return this.f9020e;
    }

    public void setAnchor(float f4, float f5) {
        this.f9025j = f4;
        this.f9026k = f5;
    }

    public void setAnimate(Bundle bundle) {
        this.f9028m = bundle;
    }

    public void setAnimateDuration(int i4) {
        if (this.f9028m == null) {
            this.f9028m = new Bundle();
        }
        this.f9028m.putInt("dur", i4);
    }

    public void setAnimateEffect(AnimEffect animEffect) {
        if (this.f9028m == null) {
            this.f9028m = new Bundle();
        }
        switch (a.f9035a[animEffect.ordinal()]) {
            case 1:
                this.f9028m.putInt("type", 1);
                break;
            case 2:
                this.f9028m.putInt("type", 2);
                break;
            case 3:
                this.f9028m.putInt("type", 3);
                break;
            case 4:
                this.f9028m.putInt("type", 4);
                break;
            case 5:
                this.f9028m.putInt("type", 5);
                break;
            case 6:
                this.f9028m.putInt("type", 6);
                break;
            case 7:
                this.f9028m.putInt("type", 7);
                break;
            case 8:
                this.f9028m.putInt("type", 8);
                break;
            case 9:
                this.f9028m.putInt("type", 9);
                break;
            case 10:
                this.f9028m.putInt("type", 10);
                break;
            case 11:
                this.f9028m.putInt("type", 11);
                break;
            default:
                this.f9028m.putInt("type", 0);
                break;
        }
    }

    public void setAnimateEndSize(int i4, int i5) {
        if (this.f9028m == null) {
            this.f9028m = new Bundle();
        }
        this.f9028m.putInt("en_w", i4);
        this.f9028m.putInt("en_h", i5);
    }

    public void setAnimateStartSize(int i4, int i5) {
        if (this.f9028m == null) {
            this.f9028m = new Bundle();
        }
        this.f9028m.putInt("st_w", i4);
        this.f9028m.putInt("st_h", i5);
    }

    public void setBound(int i4) {
        this.f9016a = i4;
    }

    public void setClickRect(ArrayList<Bundle> arrayList) {
        this.f9027l = arrayList;
    }

    public void setCoordType(CoordType coordType) {
        this.f9024i = coordType;
    }

    public void setDelay(Bundle bundle) {
        this.f9029n = bundle;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.f9019d = geoPoint;
    }

    public void setGeoZ(float f4) {
        this.f9030o = f4;
    }

    public void setGifData(byte[] bArr) {
        this.f9031p = bArr;
    }

    public void setId(String str) {
        this.f9023h = str;
    }

    public void setIndoorPoi(int i4) {
        this.f9034s = i4;
    }

    public void setLevel(int i4) {
        this.f9017b = i4;
    }

    public void setMarker(Drawable drawable) {
        this.f9022g = drawable;
    }

    public void setMask(int i4) {
        this.f9018c = i4;
    }

    public void setMultiplyDpi(int i4) {
        this.f9033r = i4;
    }

    public void setScale(float f4) {
        this.f9032q = f4;
    }

    public void setSnippet(String str) {
        this.f9021f = str;
    }

    public void setSubAnimateEffect(AnimationSubType animationSubType) {
        if (this.f9028m == null) {
            this.f9028m = new Bundle();
        }
        if (a.f9036b[animationSubType.ordinal()] != 1) {
            this.f9028m.putInt("sub_type", 0);
        } else {
            this.f9028m.putInt("sub_type", 1);
        }
    }

    public void setTitle(String str) {
        this.f9020e = str;
    }

    public void setAnchor(int i4) {
        if (i4 == 1) {
            setAnchor(0.5f, 0.5f);
        } else if (i4 == 2) {
            setAnchor(0.5f, 1.0f);
        } else {
            if (i4 != 3) {
                return;
            }
            setAnchor(0.5f, Property.DEFAULT_FLOAT_VALUE);
        }
    }
}
