package ca9;

import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes29.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void b(c r100, String r101, String r102, List r103) {
            r100.c(r101, r102, r103, MapsKt.emptyMap());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c r100, String r101, String r102, List r103, Map r104, int r105) {
            if ((r105 & 4) == 0) goto L6;
            r103 = null;
        L6:
            if ((r105 & 8) == 0) goto L8;
            r104 = MapsKt.emptyMap();
        L8:
            r100.a(r101, r102, r103, r104);
        }
    }

    void a(String r100, String r101, List<String> r102, Map<String, ? extends Object> r103);

    void b(String r100, String r101, List<String> r102, Map<String, ? extends Object> r103);

    void c(String r100, String r101, List<String> r102, Map<String, ? extends Object> r103);
}
