package reactor.core.publisher;

import reactor.util.Logger;

/* loaded from: classes5.dex */
class StateLogger {
    final Logger logger;

    public StateLogger(Logger logger) {
        this.logger = logger;
    }

    public static String formatState(long j10, int i10) {
        String binaryString = Long.toBinaryString(j10);
        StringBuilder sb2 = new StringBuilder();
        int length = i10 - binaryString.length();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 != 0 && i11 % 4 == 0) {
                sb2.append("_");
            }
            if (i11 < length) {
                sb2.append("0");
            } else {
                sb2.append(binaryString.charAt(i11 - length));
            }
        }
        sb2.insert(0, "0b");
        return sb2.toString();
    }

    public void log(String str, String str2, long j10, long j11) {
        log(str, str2, j10, j11, false);
    }

    public void log(String str, String str2, long j10, long j11, boolean z10) {
        if (z10) {
            this.logger.trace(String.format("[%s][%s][%s][%s-%s]", str, str2, str2, Long.valueOf(Thread.currentThread().getId()), formatState(j10, 64), formatState(j11, 64)), new RuntimeException());
        } else {
            this.logger.trace(String.format("[%s][%s][%s][\n\t%s\n\t%s]", str, str2, Long.valueOf(Thread.currentThread().getId()), formatState(j10, 64), formatState(j11, 64)));
        }
    }

    public void log(String str, String str2, int i10, int i11) {
        log(str, str2, i10, i11, false);
    }

    public void log(String str, String str2, int i10, int i11, boolean z10) {
        if (z10) {
            this.logger.trace(String.format("[%s][%s][%s][%s-%s]", str, str2, str2, Long.valueOf(Thread.currentThread().getId()), formatState(i10, 32), formatState(i11, 32)), new RuntimeException());
        } else {
            this.logger.trace(String.format("[%s][%s][%s][%s-%s]", str, str2, Long.valueOf(Thread.currentThread().getId()), formatState(i10, 32), formatState(i11, 32)));
        }
    }
}
