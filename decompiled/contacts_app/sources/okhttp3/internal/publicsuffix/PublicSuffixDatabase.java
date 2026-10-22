package okhttp3.internal.publicsuffix;

import com.android.contacts.ContactsUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: loaded from: classes5.dex */
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

    public PublicSuffixDatabase() {
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    static {
        WILDCARD_LABEL = new byte[]{42};
        EMPTY_RULE = new String[0];
        PREVAILING_RULE = new String[]{ContactsUtils.CHAR_STAR};
        instance = new PublicSuffixDatabase();
    }

    public static PublicSuffixDatabase get() {
        return instance;
    }

    public String getEffectiveTldPlusOne(String r7) {
        if (r7 == null) goto L20;
        String[] r0 = IDN.toUnicode(r7).split("\\.");
        String[] r6 = findMatchingRule(r0);
        if (r0.length != r6.length) goto L10;
        if (r6[0].charAt(0) == '!') goto L10;
        return null;
    L10:
        if (r6[0].charAt(0) != '!') goto L12;
        int r1 = r0.length;
        int r8 = r6.length;
    L13:
        int r2 = r1 - r8;
        StringBuilder r9 = new StringBuilder();
        String[] r10 = r7.split("\\.");
    L15:
        if (r2 >= r10.length) goto L17;
        r9.append(r10[r2]).append('.');
        r2 = r2 + 1;
        goto L15
    L17:
        r9.deleteCharAt(r9.length() - 1);
        return r9.toString();
    L12:
        r1 = r0.length;
        r8 = r6.length + 1;
        goto L13
    L20:
        throw new NullPointerException("domain == null");
    }

    private String[] findMatchingRule(String[] r9) {
        int r1 = 0;
        if (this.listRead.get() == false) goto L5;
    L66:
        this.readCompleteLatch.await();     // Catch: InterruptedException -> L9
    L10:
        monitor-enter(this);
    L62:
        th = move-exception;
        throw th;
    L12:
        if (this.publicSuffixListBytes == null) goto L61;
        monitor-exit(this);     // Catch: Throwable -> L62
        int r0 = r9.length;
        byte[][] r3 = new byte[r0][];
        int r4 = 0;
    L16:
        if (r4 >= r9.length) goto L18;
        r3[r4] = r9[r4].getBytes(Util.UTF_8);
        r4 = r4 + 1;
        goto L16
    L18:
        int r10 = 0;
    L19:
        String r5 = null;
        if (r10 >= r0) goto L25;
        String r6 = binarySearchBytes(this.publicSuffixListBytes, r3, r10);
        if (r6 != null) goto L26;
        r10 = r10 + 1;
    L26:
        if (r0 <= 1) goto L34;
        byte[][] r11 = (byte[][]) r3.clone();
        int r7 = 0;
    L29:
        if (r7 >= (r11.length - 1)) goto L34;
        r11[r7] = WILDCARD_LABEL;
        String r8 = binarySearchBytes(this.publicSuffixListBytes, r11, r7);
        if (r8 != null) goto L35;
        r7 = r7 + 1;
    L35:
        if (r8 != null) goto L37;
    L42:
        if (r5 != null) goto L44;
        if (r6 != null) goto L49;
        if (r8 != null) goto L49;
        return PREVAILING_RULE;
    L49:
        if (r6 == null) goto L51;
        String[] r12 = r6.split("\\.");
    L52:
        if (r8 == null) goto L54;
        String[] r13 = r8.split("\\.");
    L56:
        if (r12.length <= r13.length) goto L59;
        return r12;
    L59:
        return r13;
    L54:
        r13 = EMPTY_RULE;
        goto L56
    L51:
        r12 = EMPTY_RULE;
        goto L52
    L44:
        return ("!" + r5).split("\\.");
    L37:
        if (r1 >= (r0 - 1)) goto L42;
        String r14 = binarySearchBytes(this.publicSuffixExceptionListBytes, r3, r1);
        if (r14 != null) goto L40;
        r1 = r1 + 1;
        goto L37
    L40:
        r5 = r14;
    L34:
        r8 = null;
        goto L35
    L25:
        r6 = null;
        goto L26
    L61:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");     // Catch: Throwable -> L62
    L9:
        Thread.currentThread().interrupt();
        goto L10
    L5:
        if (this.listRead.compareAndSet(false, true) == false) goto L66;
        readTheListUninterruptibly();
        goto L10
    }

    private static String binarySearchBytes(byte[] r17, byte[][] r18, int r19) {
        int r2 = r17.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L43;
        int r5 = (r4 + r2) / 2;
    L6:
        if (r5 <= (-1)) goto L10;
        if (r17[r5] == 10) goto L10;
        r5 = r5 - 1;
    L10:
        int r6 = r5 + 1;
        int r9 = 1;
    L11:
        int r10 = r6 + r9;
        if (r17[r10] == 10) goto L14;
        r9 = r9 + 1;
        goto L11
    L14:
        int r7 = r10 - r6;
        int r11 = r19;
        boolean r12 = false;
        int r13 = 0;
        int r14 = 0;
    L15:
        if (r12 == false) goto L17;
        int r15 = 46;
        boolean r16 = false;
    L18:
        int r20 = r15 - (r17[r6 + r14] & 255);
        if (r20 != 0) goto L28;
        r14 = r14 + 1;
        r13 = r13 + 1;
        if (r14 == r7) goto L28;
        if (r18[r11].length == r13) goto L27;
        r12 = r16;
        goto L15
    L27:
        if (r11 == (r18.length - 1)) goto L28;
        r11 = r11 + 1;
        r13 = -1;
        r12 = true;
    L28:
        if (r20 < 0) goto L29;
        if (r20 > 0) goto L31;
        int r8 = r7 - r14;
        int r21 = r18[r11].length - r13;
    L33:
        r11 = r11 + 1;
        if (r11 >= r18.length) goto L36;
        r21 = r21 + r18[r11].length;
        goto L33
    L36:
        if (r21 < r8) goto L29;
        if (r21 > r8) goto L31;
        return new String(r17, r6, r7, Util.UTF_8);
    L31:
        r4 = r10 + 1;
    L29:
        r2 = r6 - 1;
        goto L3
    L17:
        r16 = r12;
        r15 = r18[r11][r13] & 255;
        goto L18
    L43:
        return null;
    }

    private void readTheListUninterruptibly() {
        boolean r0 = false;
    L19:
        readTheList();     // Catch: Throwable -> L7 IOException -> L9 InterruptedIOException -> L14
    L4:
        if (r0 == false) goto L23;
        Thread.currentThread().interrupt();
        return;
    L23:
        return;
    L7:
        th = move-exception;
        if (r0 == false) goto L18;
        Thread.currentThread().interrupt();
    L18:
        throw th;
    L14:
        Thread.interrupted();     // Catch: Throwable -> L7
        r0 = true;
    L9:
        e = move-exception;
        Platform.get().log(5, "Failed to read public suffix list", e);     // Catch: Throwable -> L7
        if (r0 == false) goto L24;
        Thread.currentThread().interrupt();
        return;
    }

    private void readTheList() throws IOException {
        InputStream r0 = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (r0 != null) goto L5;
        return;
    L5:
        BufferedSource r1 = Okio.buffer(new GzipSource(Okio.source(r0)));
        byte[] r2 = new byte[r1.readInt()];     // Catch: Throwable -> L16
        r1.readFully(r2);     // Catch: Throwable -> L16
        byte[] r3 = new byte[r1.readInt()];     // Catch: Throwable -> L16
        r1.readFully(r3);     // Catch: Throwable -> L16
        Util.closeQuietly(r1);
        monitor-enter(this);
        this.publicSuffixListBytes = r2;     // Catch: Throwable -> L13
        this.publicSuffixExceptionListBytes = r3;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        this.readCompleteLatch.countDown();
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        Util.closeQuietly(r1);
        throw th;
    }

    void setListBytes(byte[] r1, byte[] r2) {
        this.publicSuffixListBytes = r1;
        this.publicSuffixExceptionListBytes = r2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
