package bytedance.io.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public class IllegalPathException extends IOException {
    public IllegalPathException() {
    }

    public IllegalPathException(String r100) {
        super(r100);
    }

    public IllegalPathException(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        r102.append(r103);
        super(r102.toString());
        return;
    L5:
        r103 = " (" + r101 + ")";
        goto L6
    }
}
