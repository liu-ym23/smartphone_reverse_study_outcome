package ms.bd.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class x0 extends RuntimeException {
    public x0(String r3, String[] r4, String[] r5) {
        super("Could not find '" + r3 + "'. Looked for: " + Arrays.toString(r4) + ", but only found: " + Arrays.toString(r5) + ".");
    }
}
