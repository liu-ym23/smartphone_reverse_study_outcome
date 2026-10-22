package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public class HeatMapAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimationType f30954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f30955c;

    public static final enum AnimationType extends Enum<AnimationType> {
        public static final AnimationType CosineCurve = null;
        public static final AnimationType InBack = null;
        public static final AnimationType InBounce = null;
        public static final AnimationType InCirc = null;
        public static final AnimationType InCubic = null;
        public static final AnimationType InCurve = null;
        public static final AnimationType InElastic = null;
        public static final AnimationType InExpo = null;
        public static final AnimationType InOutBack = null;
        public static final AnimationType InOutBounce = null;
        public static final AnimationType InOutCirc = null;
        public static final AnimationType InOutCubic = null;
        public static final AnimationType InOutElastic = null;
        public static final AnimationType InOutExpo = null;
        public static final AnimationType InOutQuad = null;
        public static final AnimationType InOutQuart = null;
        public static final AnimationType InOutQuint = null;
        public static final AnimationType InOutSine = null;
        public static final AnimationType InQuad = null;
        public static final AnimationType InQuart = null;
        public static final AnimationType InQuint = null;
        public static final AnimationType InSine = null;
        public static final AnimationType Linear = null;
        public static final AnimationType OutBack = null;
        public static final AnimationType OutBounce = null;
        public static final AnimationType OutCirc = null;
        public static final AnimationType OutCubic = null;
        public static final AnimationType OutCurve = null;
        public static final AnimationType OutElastic = null;
        public static final AnimationType OutExpo = null;
        public static final AnimationType OutInBack = null;
        public static final AnimationType OutInBounce = null;
        public static final AnimationType OutInCirc = null;
        public static final AnimationType OutInCubic = null;
        public static final AnimationType OutInElastic = null;
        public static final AnimationType OutInExpo = null;
        public static final AnimationType OutInQuad = null;
        public static final AnimationType OutInQuart = null;
        public static final AnimationType OutInQuint = null;
        public static final AnimationType OutInSine = null;
        public static final AnimationType OutQuad = null;
        public static final AnimationType OutQuart = null;
        public static final AnimationType OutQuint = null;
        public static final AnimationType OutSine = null;
        public static final AnimationType SineCurve = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ AnimationType[] f30956a = null;

        static {
            AnimationType r100 = new AnimationType("Linear", 0);
            Linear = r100;
            AnimationType r101 = new AnimationType("InQuad", 1);
            InQuad = r101;
            AnimationType r102 = new AnimationType("OutQuad", 2);
            OutQuad = r102;
            AnimationType r103 = new AnimationType("InOutQuad", 3);
            InOutQuad = r103;
            AnimationType r104 = new AnimationType("OutInQuad", 4);
            OutInQuad = r104;
            AnimationType r105 = new AnimationType("InCubic", 5);
            InCubic = r105;
            AnimationType r110 = new AnimationType("OutCubic", 6);
            OutCubic = r110;
            AnimationType r111 = new AnimationType("InOutCubic", 7);
            InOutCubic = r111;
            AnimationType r112 = new AnimationType("OutInCubic", 8);
            OutInCubic = r112;
            AnimationType r113 = new AnimationType("InQuart", 9);
            InQuart = r113;
            AnimationType r114 = new AnimationType("OutQuart", 10);
            OutQuart = r114;
            AnimationType r115 = new AnimationType("InOutQuart", 11);
            InOutQuart = r115;
            AnimationType r106 = new AnimationType("OutInQuart", 12);
            OutInQuart = r106;
            AnimationType r107 = new AnimationType("InQuint", 13);
            InQuint = r107;
            AnimationType r108 = new AnimationType("OutQuint", 14);
            OutQuint = r108;
            AnimationType r109 = new AnimationType("InOutQuint", 15);
            InOutQuint = r109;
            AnimationType r116 = new AnimationType("OutInQuint", 16);
            OutInQuint = r116;
            AnimationType r117 = new AnimationType("InSine", 17);
            InSine = r117;
            AnimationType r118 = new AnimationType("OutSine", 18);
            OutSine = r118;
            AnimationType r119 = new AnimationType("InOutSine", 19);
            InOutSine = r119;
            AnimationType r120 = new AnimationType("OutInSine", 20);
            OutInSine = r120;
            AnimationType r121 = new AnimationType("InExpo", 21);
            InExpo = r121;
            AnimationType r122 = new AnimationType("OutExpo", 22);
            OutExpo = r122;
            AnimationType r123 = new AnimationType("InOutExpo", 23);
            InOutExpo = r123;
            AnimationType r124 = new AnimationType("OutInExpo", 24);
            OutInExpo = r124;
            AnimationType r125 = new AnimationType("InCirc", 25);
            InCirc = r125;
            AnimationType r126 = new AnimationType("OutCirc", 26);
            OutCirc = r126;
            AnimationType r127 = new AnimationType("InOutCirc", 27);
            InOutCirc = r127;
            AnimationType r128 = new AnimationType("OutInCirc", 28);
            OutInCirc = r128;
            AnimationType r129 = new AnimationType("InElastic", 29);
            InElastic = r129;
            AnimationType r130 = new AnimationType("OutElastic", 30);
            OutElastic = r130;
            AnimationType r131 = new AnimationType("InOutElastic", 31);
            InOutElastic = r131;
            AnimationType r132 = new AnimationType("OutInElastic", 32);
            OutInElastic = r132;
            AnimationType r133 = new AnimationType("InBack", 33);
            InBack = r133;
            AnimationType r134 = new AnimationType("OutBack", 34);
            OutBack = r134;
            AnimationType r135 = new AnimationType("InOutBack", 35);
            InOutBack = r135;
            AnimationType r136 = new AnimationType("OutInBack", 36);
            OutInBack = r136;
            AnimationType r137 = new AnimationType("InBounce", 37);
            InBounce = r137;
            AnimationType r138 = new AnimationType("OutBounce", 38);
            OutBounce = r138;
            AnimationType r139 = new AnimationType("InOutBounce", 39);
            InOutBounce = r139;
            AnimationType r140 = new AnimationType("OutInBounce", 40);
            OutInBounce = r140;
            AnimationType r141 = new AnimationType("InCurve", 41);
            InCurve = r141;
            AnimationType r142 = new AnimationType("OutCurve", 42);
            OutCurve = r142;
            AnimationType r143 = new AnimationType("SineCurve", 43);
            SineCurve = r143;
            AnimationType r144 = new AnimationType("CosineCurve", 44);
            CosineCurve = r144;
            f30956a = new AnimationType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144};
        }

        public static AnimationType[] values() {
            return (AnimationType[]) f30956a.clone();
        }

        public static AnimationType valueOf(String r100) {
            return (AnimationType) r27.a.a(AnimationType.class, r100);
        }

        private AnimationType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int getAnimationType() {
        return this.f30954b.ordinal();
    }

    public int getDuration() {
        return this.f30953a;
    }

    public boolean getIsAnimation() {
        return this.f30955c;
    }

    public void setAnimation(boolean r100) {
        this.f30955c = r100;
    }

    public void setAnimationType(AnimationType r100) {
        this.f30954b = r100;
    }

    public void setDuration(int r100) {
        this.f30953a = r100;
    }

    public HeatMapAnimation(boolean r100, int r101, AnimationType r102) {
        this.f30953a = 100;
        this.f30954b = AnimationType.Linear;
        if (r101 < 0) goto L5;
        this.f30953a = r101;
    L5:
        this.f30954b = r102;
        this.f30955c = r100;
    }
}
