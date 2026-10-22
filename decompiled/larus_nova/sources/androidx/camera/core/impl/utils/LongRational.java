package androidx.camera.core.impl.utils;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;

/* JADX INFO: loaded from: classes2.dex */
final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    public String toString() {
        return this.mNumerator + HTTP.URL_DEFAULT + this.mDenominator;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public LongRational(double r100) {
        this((long) (r100 * 10000.0d), 10000);
    }

    public LongRational(long r100, long r101) {
        this.mNumerator = r100;
        this.mDenominator = r101;
    }
}
