package androidx.camera.core;

import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class FocusMeteringAction {
    static final long DEFAULT_AUTOCANCEL_DURATION = 5000;
    static final int DEFAULT_METERING_MODE = 7;
    public static final int FLAG_AE = 2;
    public static final int FLAG_AF = 1;
    public static final int FLAG_AWB = 4;
    private final long mAutoCancelDurationInMillis;
    private final List<MeteringPoint> mMeteringPointsAe;
    private final List<MeteringPoint> mMeteringPointsAf;
    private final List<MeteringPoint> mMeteringPointsAwb;

    public static class Builder {
        long mAutoCancelDurationInMillis;
        final List<MeteringPoint> mMeteringPointsAe;
        final List<MeteringPoint> mMeteringPointsAf;
        final List<MeteringPoint> mMeteringPointsAwb;

        public FocusMeteringAction build() {
            return new FocusMeteringAction(this);
        }

        public Builder disableAutoCancel() {
            this.mAutoCancelDurationInMillis = 0;
            return this;
        }

        public Builder(FocusMeteringAction r100) {
            ArrayList r101 = new ArrayList();
            this.mMeteringPointsAf = r101;
            ArrayList r102 = new ArrayList();
            this.mMeteringPointsAe = r102;
            ArrayList r103 = new ArrayList();
            this.mMeteringPointsAwb = r103;
            this.mAutoCancelDurationInMillis = 5000;
            r101.addAll(r100.getMeteringPointsAf());
            r102.addAll(r100.getMeteringPointsAe());
            r103.addAll(r100.getMeteringPointsAwb());
            this.mAutoCancelDurationInMillis = r100.getAutoCancelDurationInMillis();
        }

        public Builder addPoint(MeteringPoint r100) {
            return addPoint(r100, 7);
        }

        public Builder removePoints(int r100) {
            if ((r100 & 1) == 0) goto L6;
            this.mMeteringPointsAf.clear();
        L6:
            if ((r100 & 2) == 0) goto L9;
            this.mMeteringPointsAe.clear();
        L9:
            if ((r100 & 4) == 0) goto L11;
            this.mMeteringPointsAwb.clear();
        L11:
            return this;
        }

        public Builder(MeteringPoint r100) {
            this(r100, 7);
        }

        public Builder(MeteringPoint r100, int r101) {
            this.mMeteringPointsAf = new ArrayList();
            this.mMeteringPointsAe = new ArrayList();
            this.mMeteringPointsAwb = new ArrayList();
            this.mAutoCancelDurationInMillis = 5000;
            addPoint(r100, r101);
        }

        public Builder addPoint(MeteringPoint r100, int r101) {
            boolean r102 = false;
            if (r100 == null) goto L5;
            boolean r103 = true;
        L6:
            Preconditions.checkArgument(r103, "Point cannot be null.");
            if (r101 >= 1) goto L9;
        L11:
            Preconditions.checkArgument(r102, "Invalid metering mode " + r101);
            if ((r101 & 1) == 0) goto L15;
            this.mMeteringPointsAf.add(r100);
        L15:
            if ((r101 & 2) == 0) goto L18;
            this.mMeteringPointsAe.add(r100);
        L18:
            if ((r101 & 4) == 0) goto L20;
            this.mMeteringPointsAwb.add(r100);
        L20:
            return this;
        L9:
            if (r101 > 7) goto L11;
            r102 = true;
            goto L11
        L5:
            r103 = false;
            goto L6
        }

        public Builder setAutoCancelDuration(long r100, TimeUnit r101) {
            if (r100 < 1) goto L5;
            boolean r102 = true;
        L6:
            Preconditions.checkArgument(r102, "autoCancelDuration must be at least 1");
            this.mAutoCancelDurationInMillis = r101.toMillis(r100);
            return this;
        L5:
            r102 = false;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MeteringMode {
    }

    public boolean isAutoCancelEnabled() {
        if (this.mAutoCancelDurationInMillis <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getAutoCancelDurationInMillis() {
        return this.mAutoCancelDurationInMillis;
    }

    public List<MeteringPoint> getMeteringPointsAe() {
        return this.mMeteringPointsAe;
    }

    public List<MeteringPoint> getMeteringPointsAf() {
        return this.mMeteringPointsAf;
    }

    public List<MeteringPoint> getMeteringPointsAwb() {
        return this.mMeteringPointsAwb;
    }

    public FocusMeteringAction(Builder r100) {
        this.mMeteringPointsAf = Collections.unmodifiableList(r100.mMeteringPointsAf);
        this.mMeteringPointsAe = Collections.unmodifiableList(r100.mMeteringPointsAe);
        this.mMeteringPointsAwb = Collections.unmodifiableList(r100.mMeteringPointsAwb);
        this.mAutoCancelDurationInMillis = r100.mAutoCancelDurationInMillis;
    }
}
