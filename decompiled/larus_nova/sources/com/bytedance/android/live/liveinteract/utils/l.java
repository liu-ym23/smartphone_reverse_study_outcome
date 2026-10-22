package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface l {

    public static final class a {
        public static /* synthetic */ void b(l r100, LinkMonitorData r101, long r102, Throwable r110) {
            r100.a(r101, r102, r110, null);
        }

        public static /* synthetic */ void c(l r100, LinkMonitorData r101, long r102, String r110) {
            r100.c(r101, r102, r110, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(l r110, LinkMonitorData r111, String r112, String r113, int r114, Integer r115, String r116, String r210, Integer r211, Map r212, int r213) {
            if ((r213 & 2) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r213 & 4) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r213 & 8) == 0) goto L13;
            int r102 = 0;
        L15:
            if ((r213 & 16) == 0) goto L17;
            Integer r103 = null;
        L19:
            if ((r213 & 32) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r213 & 64) == 0) goto L25;
            String r117 = null;
        L27:
            if ((r213 & 128) == 0) goto L29;
            Integer r118 = null;
        L31:
            if ((r213 & 256) == 0) goto L33;
            Map r119 = null;
        L34:
            r110.b(r111, r100, r101, r102, r103, r104, r117, r118, r119);
            return;
        L33:
            r119 = r212;
            goto L34
        L29:
            r118 = r211;
            goto L31
        L25:
            r117 = r210;
            goto L27
        L21:
            r104 = r116;
            goto L23
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    void a(LinkMonitorData r100, long r101, Throwable r102, Map<String, ? extends Object> r103);

    void b(LinkMonitorData r100, String r101, String r102, int r103, Integer r104, String r105, String r106, Integer r107, Map<String, ? extends Object> r108);

    void c(LinkMonitorData r100, long r101, String r102, Map<String, ? extends Object> r103);
}
