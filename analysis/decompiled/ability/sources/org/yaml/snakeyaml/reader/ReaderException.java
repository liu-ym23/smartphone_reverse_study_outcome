package org.yaml.snakeyaml.reader;

import B7.a;
import org.yaml.snakeyaml.error.YAMLException;

/* loaded from: classes4.dex */
public class ReaderException extends YAMLException {

    /* renamed from: a, reason: collision with root package name */
    public final String f5527a;
    public final int b;
    public final int c;

    public ReaderException(int i, int i6, String str) {
        super(str);
        this.f5527a = "'reader'";
        this.b = i6;
        this.c = i;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        int i = this.b;
        StringBuilder sbV = a.v("unacceptable code point '", new String(Character.toChars(i)), "' (0x");
        sbV.append(Integer.toHexString(i).toUpperCase());
        sbV.append(") ");
        sbV.append(getMessage());
        sbV.append("\nin \"");
        sbV.append(this.f5527a);
        sbV.append("\", position ");
        sbV.append(this.c);
        return sbV.toString();
    }
}
