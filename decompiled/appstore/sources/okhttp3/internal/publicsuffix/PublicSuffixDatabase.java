package okhttp3.internal.publicsuffix;

import com.google.common.primitives.UnsignedBytes;
import fg.g;
import fg.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
public final class PublicSuffixDatabase {
    private static final String[] EMPTY_RULE = null;
    private static final byte EXCEPTION_MARKER = 33;
    private static final String[] PREVAILING_RULE = null;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = null;
    private static final PublicSuffixDatabase instance = null;
    private final AtomicBoolean listRead;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch;

    static {
        WILDCARD_LABEL = new byte[]{42};
        EMPTY_RULE = new String[0];
        PREVAILING_RULE = new String[]{"*"};
        instance = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    private static String binarySearchBytes(byte[] r18, byte[][] r19, int r20) {
        int r10 = r18.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L43;
        int r12 = (r11 + r10) / 2;
    L6:
        if (r12 <= (-1)) goto L10;
        if (r18[r12] == 10) goto L10;
        r12 = r12 - 1;
    L10:
        int r13 = r12 + 1;
        int r14 = 1;
    L11:
        int r15 = r13 + r14;
        if (r18[r15] == 10) goto L14;
        r14 = r14 + 1;
        goto L11
    L14:
        int r16 = r15 - r13;
        int r17 = r20;
        boolean r110 = false;
        int r111 = 0;
        int r112 = 0;
    L15:
        if (r110 == false) goto L17;
        int r113 = 46;
        boolean r114 = false;
    L18:
        int r115 = r113 - (r18[r13 + r112] & UnsignedBytes.MAX_VALUE);
        if (r115 != 0) goto L28;
        r112 = r112 + 1;
        r111 = r111 + 1;
        if (r112 == r16) goto L28;
        if (r19[r17].length == r111) goto L27;
        r110 = r114;
        goto L15
    L27:
        if (r17 == (r19.length - 1)) goto L28;
        r17 = r17 + 1;
        r111 = -1;
        r110 = true;
    L28:
        if (r115 < 0) goto L29;
        if (r115 > 0) goto L31;
        int r21 = r16 - r112;
        int r22 = r19[r17].length - r111;
    L33:
        r17 = r17 + 1;
        if (r17 >= r19.length) goto L36;
        r22 = r22 + r19[r17].length;
        goto L33
    L36:
        if (r22 < r21) goto L29;
        if (r22 > r21) goto L31;
        return new String(r18, r13, r16, Util.UTF_8);
    L31:
        r11 = r15 + 1;
    L29:
        r10 = r12;
        goto L3
    L17:
        r114 = r110;
        r113 = r19[r17][r111] & UnsignedBytes.MAX_VALUE;
        goto L18
    L43:
        return null;
    }

    private String[] findMatchingRule(String[] r10) {
        int r11 = 0;
        if (this.listRead.get() == false) goto L5;
    L66:
        this.readCompleteLatch.await();     // Catch: InterruptedException -> L64
    L8:
        monitor-enter(this);
    L58:
        th = move-exception;
        throw th;
    L10:
        if (this.publicSuffixListBytes == null) goto L61;
        monitor-exit(this);     // Catch: Throwable -> L58
        int r12 = r10.length;
        byte[][] r13 = new byte[r12][];
        int r14 = 0;
    L14:
        if (r14 >= r10.length) goto L16;
        r13[r14] = r10[r14].getBytes(Util.UTF_8);
        r14 = r14 + 1;
        goto L14
    L16:
        int r15 = 0;
    L17:
        String r16 = null;
        if (r15 >= r12) goto L23;
        String r17 = binarySearchBytes(this.publicSuffixListBytes, r13, r15);
        if (r17 != null) goto L24;
        r15 = r15 + 1;
    L24:
        if (r12 <= 1) goto L32;
        byte[][] r18 = (byte[][]) r13.clone();
        int r19 = 0;
    L27:
        if (r19 >= (r18.length - 1)) goto L32;
        r18[r19] = WILDCARD_LABEL;
        String r20 = binarySearchBytes(this.publicSuffixListBytes, r18, r19);
        if (r20 != null) goto L33;
        r19 = r19 + 1;
    L33:
        if (r20 != null) goto L35;
    L40:
        if (r16 != null) goto L42;
        if (r17 != null) goto L47;
        if (r20 != null) goto L47;
        return PREVAILING_RULE;
    L47:
        if (r17 == null) goto L49;
        String[] r21 = r17.split("\\.");
    L50:
        if (r20 == null) goto L52;
        String[] r22 = r20.split("\\.");
    L54:
        if (r21.length <= r22.length) goto L57;
        return r21;
    L57:
        return r22;
    L52:
        r22 = EMPTY_RULE;
        goto L54
    L49:
        r21 = EMPTY_RULE;
        goto L50
    L42:
        return ("!" + r16).split("\\.");
    L35:
        if (r11 >= (r12 - 1)) goto L40;
        String r23 = binarySearchBytes(this.publicSuffixExceptionListBytes, r13, r11);
        if (r23 != null) goto L38;
        r11 = r11 + 1;
        goto L35
    L38:
        r16 = r23;
    L32:
        r20 = null;
        goto L33
    L23:
        r17 = null;
        goto L24
    L61:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");     // Catch: Throwable -> L58
    L5:
        if (this.listRead.compareAndSet(false, true) == false) goto L66;
        readTheListUninterruptibly();
        goto L8
    }

    public static PublicSuffixDatabase get() {
        return instance;
    }

    private void readTheList() throws IOException {
        InputStream r10 = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (r10 != null) goto L5;
        return;
    L5:
        BufferedSource r11 = j.d(new g(j.l(r10)));
        byte[] r12 = new byte[r11.readInt()];     // Catch: Throwable -> L16
        r11.readFully(r12);     // Catch: Throwable -> L16
        byte[] r13 = new byte[r11.readInt()];     // Catch: Throwable -> L16
        r11.readFully(r13);     // Catch: Throwable -> L16
        Util.closeQuietly(r11);
        monitor-enter(this);
        this.publicSuffixListBytes = r12;     // Catch: Throwable -> L13
        this.publicSuffixExceptionListBytes = r13;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        this.readCompleteLatch.countDown();
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        Util.closeQuietly(r11);
        throw th;
    }

    private void readTheListUninterruptibly() {
        boolean r10 = false;
    L18:
        readTheList();     // Catch: Throwable -> L7 IOException -> L9 InterruptedIOException -> L17
    L4:
        if (r10 == false) goto L22;
        Thread.currentThread().interrupt();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        if (r10 == false) goto L16;
        Thread.currentThread().interrupt();
    L16:
        throw th;
    L17:
        r10 = true;
    L9:
        e = move-exception;
        Platform.get().log(5, "Failed to read public suffix list", e);     // Catch: Throwable -> L7
        if (r10 == false) goto L23;
        Thread.currentThread().interrupt();
        return;
    }

    public String getEffectiveTldPlusOne(String r10) {
        if (r10 == null) goto L21;
        String[] r11 = IDN.toUnicode(r10).split("\\.");
        String[] r12 = findMatchingRule(r11);
        if (r11.length != r12.length) goto L10;
        if (r12[0].charAt(0) == '!') goto L10;
        return null;
    L10:
        if (r12[0].charAt(0) != '!') goto L13;
        int r13 = r11.length;
        int r14 = r12.length;
    L12:
        int r15 = r13 - r14;
        StringBuilder r16 = new StringBuilder();
        String[] r17 = r10.split("\\.");
    L16:
        if (r15 >= r17.length) goto L18;
        r16.append(r17[r15]);
        r16.append('.');
        r15 = r15 + 1;
        goto L16
    L18:
        r16.deleteCharAt(r16.length() - 1);
        return r16.toString();
    L13:
        r13 = r11.length;
        r14 = r12.length + 1;
        goto L12
    L21:
        throw new NullPointerException("domain == null");
    }

    public void setListBytes(byte[] r10, byte[] r11) {
        this.publicSuffixListBytes = r10;
        this.publicSuffixExceptionListBytes = r11;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
