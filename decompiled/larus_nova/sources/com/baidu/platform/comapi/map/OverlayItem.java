package com.baidu.platform.comapi.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class OverlayItem {
    public static final int ALIGN_BOTTON = 2;
    public static final int ALIGN_TOP = 3;
    public static final int ALING_CENTER = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f33121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f33122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected GeoPoint f33124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f33125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f33126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f33127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f33128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CoordType f33129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f33130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f33131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList<Bundle> f33132l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bundle f33133m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Bundle f33134n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f33135o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private byte[] f33136p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f33137q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f33138r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f33139s;

    public static final enum AnimEffect extends Enum<AnimEffect> {
        private static final /* synthetic */ AnimEffect[] $VALUES = null;
        public static final AnimEffect ALPHA = null;
        public static final AnimEffect ANCHOR_GROUTH = null;
        public static final AnimEffect FADE_IN = null;
        public static final AnimEffect FADE_OUT = null;
        public static final AnimEffect GROWTH = null;
        public static final AnimEffect GROWTH_FADE_IN = null;
        public static final AnimEffect GROWTH_REBOUND = null;
        public static final AnimEffect NONE = null;
        public static final AnimEffect ROTATE = null;
        public static final AnimEffect SHRINK = null;
        public static final AnimEffect SHRINK_FADE_OUT = null;
        public static final AnimEffect WAVE = null;

        static {
            AnimEffect r100 = new AnimEffect(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            AnimEffect r101 = new AnimEffect("GROWTH", 1);
            GROWTH = r101;
            AnimEffect r102 = new AnimEffect("WAVE", 2);
            WAVE = r102;
            AnimEffect r103 = new AnimEffect("SHRINK", 3);
            SHRINK = r103;
            AnimEffect r104 = new AnimEffect("FADE_OUT", 4);
            FADE_OUT = r104;
            AnimEffect r105 = new AnimEffect("FADE_IN", 5);
            FADE_IN = r105;
            AnimEffect r110 = new AnimEffect("GROWTH_FADE_IN", 6);
            GROWTH_FADE_IN = r110;
            AnimEffect r111 = new AnimEffect("SHRINK_FADE_OUT", 7);
            SHRINK_FADE_OUT = r111;
            AnimEffect r112 = new AnimEffect("GROWTH_REBOUND", 8);
            GROWTH_REBOUND = r112;
            AnimEffect r113 = new AnimEffect("ALPHA", 9);
            ALPHA = r113;
            AnimEffect r114 = new AnimEffect("ANCHOR_GROUTH", 10);
            ANCHOR_GROUTH = r114;
            AnimEffect r115 = new AnimEffect("ROTATE", 11);
            ROTATE = r115;
            $VALUES = new AnimEffect[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        }

        public static AnimEffect[] values() {
            return (AnimEffect[]) $VALUES.clone();
        }

        public static AnimEffect valueOf(String r100) {
            return (AnimEffect) r27.a.a(AnimEffect.class, r100);
        }

        private AnimEffect(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum AnimationSubType extends Enum<AnimationSubType> {
        private static final /* synthetic */ AnimationSubType[] $VALUES = null;
        public static final AnimationSubType NONE = null;
        public static final AnimationSubType RADAR = null;

        static {
            AnimationSubType r100 = new AnimationSubType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            AnimationSubType r101 = new AnimationSubType("RADAR", 1);
            RADAR = r101;
            $VALUES = new AnimationSubType[]{r100, r101};
        }

        public static AnimationSubType[] values() {
            return (AnimationSubType[]) $VALUES.clone();
        }

        public static AnimationSubType valueOf(String r100) {
            return (AnimationSubType) r27.a.a(AnimationSubType.class, r100);
        }

        private AnimationSubType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CoordType extends Enum<CoordType> {
        private static final /* synthetic */ CoordType[] $VALUES = null;
        public static final CoordType CoordType_BD09 = null;
        public static final CoordType CoordType_BD09LL = null;

        static {
            CoordType r100 = new CoordType("CoordType_BD09LL", 0);
            CoordType_BD09LL = r100;
            CoordType r101 = new CoordType("CoordType_BD09", 1);
            CoordType_BD09 = r101;
            $VALUES = new CoordType[]{r100, r101};
        }

        public static CoordType[] values() {
            return (CoordType[]) $VALUES.clone();
        }

        public static CoordType valueOf(String r100) {
            return (CoordType) r27.a.a(CoordType.class, r100);
        }

        private CoordType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33140a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f33141b = null;

        static {
            int[] r100 = new int[AnimationSubType.values().length];
            f33141b = r100;
            r100[AnimationSubType.RADAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L46:
            f33141b[AnimationSubType.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L6:
            int[] r101 = new int[AnimEffect.values().length];
            f33140a = r101;
            r101[AnimEffect.GROWTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L50:
            f33140a[AnimEffect.WAVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L60:
            f33140a[AnimEffect.SHRINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L34:
            f33140a[AnimEffect.FADE_OUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L52:
            f33140a[AnimEffect.FADE_IN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L56:
            f33140a[AnimEffect.GROWTH_FADE_IN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L38:
            f33140a[AnimEffect.SHRINK_FADE_OUT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L54:
            f33140a[AnimEffect.GROWTH_REBOUND.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L58:
            f33140a[AnimEffect.ALPHA.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L44:
            f33140a[AnimEffect.ANCHOR_GROUTH.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L48:
            f33140a[AnimEffect.ROTATE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L40:
            f33140a[AnimEffect.NONE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public float getMultiplyDpi() {
        return this.f33138r;
    }

    public int getResId() {
        if (getMarker() != null) goto L7;
        return -1;
    L7:
        return getMarker().hashCode();
    }

    public float getAnchorX() {
        return this.f33130j;
    }

    public float getAnchorY() {
        return this.f33131k;
    }

    public Bundle getAnimate() {
        return this.f33133m;
    }

    public int getBound() {
        return this.f33121a;
    }

    public ArrayList<Bundle> getClickRect() {
        return this.f33132l;
    }

    public CoordType getCoordType() {
        return this.f33129i;
    }

    public Bundle getDelay() {
        return this.f33134n;
    }

    public float getGeoZ() {
        return this.f33135o;
    }

    public byte[] getGifData() {
        return this.f33136p;
    }

    public String getId() {
        return this.f33128h;
    }

    public int getIndoorPoi() {
        return this.f33139s;
    }

    public int getLevel() {
        return this.f33122b;
    }

    public final Drawable getMarker() {
        return this.f33127g;
    }

    public int getMask() {
        return this.f33123c;
    }

    public GeoPoint getPoint() {
        return this.f33124d;
    }

    public float getScale() {
        return this.f33137q;
    }

    public String getSnippet() {
        return this.f33126f;
    }

    public String getTitle() {
        return this.f33125e;
    }

    public void addClickRect(Bundle r100) {
        if (this.f33132l != null) goto L5;
        this.f33132l = new ArrayList();
    L5:
        this.f33132l.add(r100);
    }

    public void setAnchor(int r100) {
        if (r100 != 1) goto L5;
        setAnchor(0.5f, 0.5f);
        return;
    L5:
        if (r100 != 2) goto L7;
        setAnchor(0.5f, 1.0f);
        return;
    L7:
        if (r100 != 3) goto L15;
        setAnchor(0.5f, 0.0f);
        return;
    }

    public void setAnimate(Bundle r100) {
        this.f33133m = r100;
    }

    public void setAnimateDuration(int r100) {
        if (this.f33133m != null) goto L5;
        this.f33133m = new Bundle();
    L5:
        this.f33133m.putInt("dur", r100);
    }

    public void setAnimateEffect(AnimEffect r100) {
        if (this.f33133m != null) goto L6;
        this.f33133m = new Bundle();
    L6:
        switch(a.f33140a[r100.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L7:
        this.f33133m.putInt("type", 0);
        return;
    L8:
        this.f33133m.putInt("type", 11);
        return;
    L9:
        this.f33133m.putInt("type", 10);
        return;
    L10:
        this.f33133m.putInt("type", 9);
        return;
    L11:
        this.f33133m.putInt("type", 8);
        return;
    L12:
        this.f33133m.putInt("type", 7);
        return;
    L13:
        this.f33133m.putInt("type", 6);
        return;
    L14:
        this.f33133m.putInt("type", 5);
        return;
    L15:
        this.f33133m.putInt("type", 4);
        return;
    L16:
        this.f33133m.putInt("type", 3);
        return;
    L17:
        this.f33133m.putInt("type", 2);
        return;
    L18:
        this.f33133m.putInt("type", 1);
    }

    public void setBound(int r100) {
        this.f33121a = r100;
    }

    public void setClickRect(ArrayList<Bundle> r100) {
        this.f33132l = r100;
    }

    public void setCoordType(CoordType r100) {
        this.f33129i = r100;
    }

    public void setDelay(Bundle r100) {
        this.f33134n = r100;
    }

    public void setGeoPoint(GeoPoint r100) {
        this.f33124d = r100;
    }

    public void setGeoZ(float r100) {
        this.f33135o = r100;
    }

    public void setGifData(byte[] r100) {
        this.f33136p = r100;
    }

    public void setId(String r100) {
        this.f33128h = r100;
    }

    public void setIndoorPoi(int r100) {
        this.f33139s = r100;
    }

    public void setLevel(int r100) {
        this.f33122b = r100;
    }

    public void setMarker(Drawable r100) {
        this.f33127g = r100;
    }

    public void setMask(int r100) {
        this.f33123c = r100;
    }

    public void setMultiplyDpi(int r100) {
        this.f33138r = r100;
    }

    public void setScale(float r100) {
        this.f33137q = r100;
    }

    public void setSnippet(String r100) {
        this.f33126f = r100;
    }

    public void setSubAnimateEffect(AnimationSubType r100) {
        if (this.f33133m != null) goto L6;
        this.f33133m = new Bundle();
    L6:
        if (a.f33141b[r100.ordinal()] == 1) goto L8;
        this.f33133m.putInt("sub_type", 0);
        return;
    L8:
        this.f33133m.putInt("sub_type", 1);
    }

    public void setTitle(String r100) {
        this.f33125e = r100;
    }

    public void setAnchor(float r100, float r101) {
        this.f33130j = r100;
        this.f33131k = r101;
    }

    public void setAnimateEndSize(int r100, int r101) {
        if (this.f33133m != null) goto L5;
        this.f33133m = new Bundle();
    L5:
        this.f33133m.putInt("en_w", r100);
        this.f33133m.putInt("en_h", r101);
    }

    public void setAnimateStartSize(int r100, int r101) {
        if (this.f33133m != null) goto L5;
        this.f33133m = new Bundle();
    L5:
        this.f33133m.putInt("st_w", r100);
        this.f33133m.putInt("st_h", r101);
    }

    public OverlayItem(GeoPoint r100, String r101, String r102) {
        this.f33129i = CoordType.CoordType_BD09;
        this.f33124d = r100;
        this.f33125e = r101;
        this.f33126f = r102;
        this.f33127g = null;
        this.f33138r = 0;
        this.f33121a = 2;
        this.f33128h = "";
        this.f33130j = 0.5f;
        this.f33131k = 1.0f;
        this.f33132l = new ArrayList();
    }
}
