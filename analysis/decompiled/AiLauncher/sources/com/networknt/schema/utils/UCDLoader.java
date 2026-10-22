package com.networknt.schema.utils;

import com.networknt.schema.format.IdnHostnameFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.BitSet;
import java.util.function.Consumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class UCDLoader {
    private static final vc.c logger = vc.e.l(UCDLoader.class);

    public static /* synthetic */ void a(Function function, LineNumberReader lineNumberReader, String str) {
        if (str.isEmpty() || '#' == str.charAt(0)) {
            return;
        }
        String[] strArrSplit = str.split("\\s*[;#]\\s*", 3);
        BitSet bitSet = (BitSet) function.apply(strArrSplit[1]);
        if (bitSet != null) {
            String[] strArrSplit2 = strArrSplit[0].split("\\.\\.");
            int length = strArrSplit2.length;
            if (length == 1) {
                bitSet.set(Integer.parseUnsignedInt(strArrSplit2[0], 16));
            } else {
                if (length == 2) {
                    bitSet.set(Integer.parseUnsignedInt(strArrSplit2[0], 16), Integer.parseUnsignedInt(strArrSplit2[1], 16) + 1);
                    return;
                }
                throw new IllegalStateException("Unable to parse integer range on line " + lineNumberReader.getLineNumber());
            }
        }
    }

    public static void loadMapping(String str, final Function<String, BitSet> function) throws IOException {
        try {
            InputStream resourceAsStream = IdnHostnameFormat.class.getResourceAsStream(str);
            try {
                final LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(resourceAsStream));
                try {
                    lineNumberReader.lines().forEach(new Consumer() { // from class: com.networknt.schema.utils.p
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            UCDLoader.a(function, lineNumberReader, (String) obj);
                        }
                    });
                    lineNumberReader.close();
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } finally {
                }
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException | IllegalStateException e10) {
            logger.q("unable to load Unicode data from file '{}': {}", str, e10.getMessage());
        }
    }
}
