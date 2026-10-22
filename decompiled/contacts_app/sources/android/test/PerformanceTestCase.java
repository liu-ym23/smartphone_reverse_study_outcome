package android.test;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface PerformanceTestCase {

    public interface Intermediates {
        void addIntermediate(String r1);

        void addIntermediate(String r1, long r2);

        void finishTiming(boolean r1);

        void setInternalIterations(int r1);

        void startTiming(boolean r1);
    }

    boolean isPerformanceOnly();

    int startPerformance(Intermediates r1);
}
