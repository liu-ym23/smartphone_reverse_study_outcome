package reactor.core.publisher;

import reactor.util.Logger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class StateLogger {
    final Logger logger;

    public StateLogger(Logger logger) {
        this.logger = logger;
    }

    public static String formatState(long j10, int i) {
        String binaryString = Long.toBinaryString(j10);
        StringBuilder sb2 = new StringBuilder();
        int length = i - binaryString.length();
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 != 0 && i3 % 4 == 0) {
                sb2.append("_");
            }
            if (i3 < length) {
                sb2.append("0");
            } else {
                sb2.append(binaryString.charAt(i3 - length));
            }
        }
        sb2.insert(0, "0b");
        return sb2.toString();
    }

    public void log(String str, String str2, long j10, long j11, boolean z10) {
        Logger logger = this.logger;
        if (z10) {
            long id2 = Thread.currentThread().getId();
            String state = formatState(j10, 64);
            formatState(j11, 64);
            StringBuilder sbP = androidx.activity.b.p("[", str, "][", str2, "][");
            sbP.append(str2);
            sbP.append("][");
            sbP.append(id2);
            sbP.append("-");
            sbP.append(state);
            sbP.append("]");
            logger.trace(sbP.toString(), new RuntimeException());
            return;
        }
        long id3 = Thread.currentThread().getId();
        String state2 = formatState(j10, 64);
        String state3 = formatState(j11, 64);
        StringBuilder sbP2 = androidx.activity.b.p("[", str, "][", str2, "][");
        sbP2.append(id3);
        sbP2.append("][\n\t");
        sbP2.append(state2);
        sbP2.append("\n\t");
        sbP2.append(state3);
        sbP2.append("]");
        logger.trace(sbP2.toString());
    }

    public void log(String str, String str2, long j10, long j11) {
        log(str, str2, j10, j11, false);
    }

    public void log(String str, String str2, int i, int i3) {
        log(str, str2, i, i3, false);
    }

    public void log(String str, String str2, int i, int i3, boolean z10) {
        Logger logger = this.logger;
        if (z10) {
            long id2 = Thread.currentThread().getId();
            String state = formatState(i, 32);
            formatState(i3, 32);
            StringBuilder sbP = androidx.activity.b.p("[", str, "][", str2, "][");
            sbP.append(str2);
            sbP.append("][");
            sbP.append(id2);
            sbP.append("-");
            sbP.append(state);
            sbP.append("]");
            logger.trace(sbP.toString(), new RuntimeException());
            return;
        }
        long id3 = Thread.currentThread().getId();
        String state2 = formatState(i, 32);
        String state3 = formatState(i3, 32);
        StringBuilder sbP2 = androidx.activity.b.p("[", str, "][", str2, "][");
        sbP2.append(id3);
        sbP2.append("][");
        sbP2.append(state2);
        sbP2.append("-");
        sbP2.append(state3);
        sbP2.append("]");
        logger.trace(sbP2.toString());
    }
}
