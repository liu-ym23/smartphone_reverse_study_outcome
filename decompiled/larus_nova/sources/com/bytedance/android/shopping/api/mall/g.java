package com.bytedance.android.shopping.api.mall;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface g extends d {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g r100, Map r101, boolean r102, boolean r110, Function1 r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            r101 = new LinkedHashMap();
        L5:
            Map r103 = r101;
            if ((r112 & 2) == 0) goto L8;
            boolean r104 = true;
        L10:
            if ((r112 & 16) == 0) goto L12;
            boolean r105 = false;
        L14:
            if ((r112 & 32) == 0) goto L16;
            r111 = null;
        L16:
            r100.TK(r103, r104, false, false, r105, r111);
            return;
        L12:
            r105 = r110;
            goto L14
        L8:
            r104 = r102;
            goto L10
        }
    }

    void TK(Map<String, ? extends Object> r100, boolean r101, boolean r102, boolean r103, boolean r104, Function1<? super Boolean, Unit> r105);
}
