package androidx.datastore.preferences.protobuf;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes.dex */
public class l extends IOException {
    public /* synthetic */ l(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }

    public l(File file, File file2, String str) {
        q7.k.e(file, "file");
        StringBuilder sb2 = new StringBuilder(file.toString());
        if (file2 != null) {
            sb2.append(" -> " + file2);
        }
        sb2.append(": ".concat(str));
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        super(string);
    }

    public l(int i2, int i10, int i11, IndexOutOfBoundsException indexOutOfBoundsException) {
        Locale locale = Locale.US;
        StringBuilder sb2 = new StringBuilder("Pos: ");
        sb2.append(i2);
        sb2.append(", limit: ");
        sb2.append(i10);
        sb2.append(", len: ");
        sb2.append(i11);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sb2.toString()), indexOutOfBoundsException);
    }

    public l(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(str), indexOutOfBoundsException);
    }
}
