package androidx.appcompat.app;

/* JADX INFO: loaded from: classes2.dex */
class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    public TwilightCalculator() {
    }

    public static TwilightCalculator getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new TwilightCalculator();
    L6:
        return sInstance;
    }

    public void calculateTwilight(long r110, double r111, double r210) {
        float r100 = (r110 - UTC_2000) / 8.64E7f;
        float r101 = (0.01720197f * r100) + 6.24006f;
        double r102 = r101;
        double r103 = (((((Math.sin(r102) * 0.03341960161924362d) + r102) + (Math.sin(2.0f * r101) * 3.4906598739326E-4d)) + (Math.sin(r101 * 3.0f) * 5.236000106378924E-6d)) + 1.796593063d) + 3.141592653589793d;
        double r104 = (-r210) / 360.0d;
        double r105 = ((((double) (Math.round(((double) (r100 - J0)) - r104) + J0)) + r104) + (Math.sin(r102) * 0.0053d)) + (Math.sin(2.0d * r103) * (-0.0069d));
        double r106 = Math.asin(Math.sin(r103) * Math.sin(0.4092797040939331d));
        double r107 = 0.01745329238474369d * r111;
        double r108 = (Math.sin(-0.10471975803375244d) - (Math.sin(r107) * Math.sin(r106))) / (Math.cos(r107) * Math.cos(r106));
        if (r108 < 1.0d) goto L7;
        this.state = 1;
        this.sunset = -1;
        this.sunrise = -1;
        return;
    L7:
        if (r108 > (-1.0d)) goto L10;
        this.state = 0;
        this.sunset = -1;
        this.sunrise = -1;
        return;
    L10:
        double r109 = (float) (Math.acos(r108) / 6.283185307179586d);
        this.sunset = Math.round((r105 + r109) * 8.64E7d) + UTC_2000;
        long r112 = Math.round((r105 - r109) * 8.64E7d) + UTC_2000;
        this.sunrise = r112;
        if (r112 < r110) goto L13;
    L15:
        this.state = 1;
        return;
    L13:
        if (this.sunset <= r110) goto L15;
        this.state = 0;
    }
}
