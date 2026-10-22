package reactor.core.publisher;

import reactor.util.Logger;

/* loaded from: classes4.dex */
class StateLogger {
    final Logger logger;

    public StateLogger(Logger logger) {
        this.logger = logger;
    }

    public static String formatState(long j5, int i) {
        String binaryString = Long.toBinaryString(j5);
        StringBuilder sb = new StringBuilder();
        int length = i - binaryString.length();
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 != 0 && i6 % 4 == 0) {
                sb.append("_");
            }
            if (i6 < length) {
                sb.append("0");
            } else {
                sb.append(binaryString.charAt(i6 - length));
            }
        }
        sb.insert(0, "0b");
        return sb.toString();
    }

    public void log(String str, String str2, long j5, long j6) {
        log(str, str2, j5, j6, false);
    }

    public void log(String str, String str2, long j5, long j6, boolean z10) {
        if (z10) {
            Logger logger = this.logger;
            long id = Thread.currentThread().getId();
            String state = formatState(j5, 64);
            formatState(j6, 64);
            StringBuilder sbW = B7.a.w("[", str, "][", str2, "][");
            B7.a.y(id, str2, "][", sbW);
            logger.trace(androidx.constraintlayout.core.dsl.a.j(sbW, "-", state, "]"), new RuntimeException());
            return;
        }
        Logger logger2 = this.logger;
        long id2 = Thread.currentThread().getId();
        String state2 = formatState(j5, 64);
        String state3 = formatState(j6, 64);
        StringBuilder sbW2 = B7.a.w("[", str, "][", str2, "][");
        sbW2.append(id2);
        sbW2.append("][\n\t");
        sbW2.append(state2);
        sbW2.append("\n\t");
        sbW2.append(state3);
        sbW2.append("]");
        logger2.trace(sbW2.toString());
    }

    public void log(String str, String str2, int i, int i6) {
        log(str, str2, i, i6, false);
    }

    public void log(String str, String str2, int i, int i6, boolean z10) {
        if (z10) {
            Logger logger = this.logger;
            long id = Thread.currentThread().getId();
            String state = formatState(i, 32);
            formatState(i6, 32);
            StringBuilder sbW = B7.a.w("[", str, "][", str2, "][");
            B7.a.y(id, str2, "][", sbW);
            logger.trace(androidx.constraintlayout.core.dsl.a.j(sbW, "-", state, "]"), new RuntimeException());
            return;
        }
        Logger logger2 = this.logger;
        long id2 = Thread.currentThread().getId();
        String state2 = formatState(i, 32);
        String state3 = formatState(i6, 32);
        StringBuilder sbW2 = B7.a.w("[", str, "][", str2, "][");
        sbW2.append(id2);
        sbW2.append("][");
        sbW2.append(state2);
        sbW2.append("-");
        sbW2.append(state3);
        sbW2.append("]");
        logger2.trace(sbW2.toString());
    }
}
