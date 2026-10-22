package com.bytedance.android.btm.api.inner;

import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: loaded from: classes43.dex */
    public static final class a {
        public static /* synthetic */ void c(String r100, Object r101, Function1 r102) {
            BtmMonitor.f42161c.i(r100, "", r101, null, false, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g r100, int r101, String r102, Object r110, Function1 r111, int r112) {
            if ((r112 & 2) == 0) goto L5;
            r102 = "";
        L5:
            String r103 = r102;
            if ((r112 & 4) == 0) goto L8;
            r110 = null;
        L8:
            Object r104 = r110;
            if ((r112 & 32) == 0) goto L11;
            r111 = IMonitor$monitor$1.INSTANCE;
        L11:
            r100.c(r101, r103, r104, null, false, r111);
        }

        public static /* synthetic */ void b(g r100, int r101, String r102, Throwable r103, boolean r110, int r111) {
            if ((r111 & 2) == 0) goto L5;
            r102 = "";
        L5:
            String r104 = r102;
            if ((r111 & 8) == 0) goto L8;
            r103 = null;
        L8:
            Throwable r105 = r103;
            if ((r111 & 16) == 0) goto L11;
            boolean r106 = false;
        L12:
            r100.a(r101, r104, null, r105, r106);
            return;
        L11:
            r106 = r110;
            goto L12
        }
    }

    void a(int r100, String r101, Object r102, Throwable r103, boolean r104);

    void b(boolean r100, Function0<? extends Object> r101);

    void c(int r100, String r101, Object r102, Throwable r103, boolean r104, Function1<? super JSONObject, Unit> r105);
}
