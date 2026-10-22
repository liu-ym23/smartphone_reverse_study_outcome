package com.bytedance.android.shopping.commentv3.audio;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface f {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(f r100, String r101, StopReason r102, y r103, Function1 r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = new y(false, 7);
        L9:
            if ((r105 & 8) == 0) goto L11;
            r104 = null;
        L11:
            r100.b(r101, r102, r103, r104);
        }
    }

    void a(b r100, Function1<? super d, Unit> r101);

    void b(String r100, StopReason r101, y r102, Function1<? super d, Unit> r103);

    void c(StopReason r100);
}
