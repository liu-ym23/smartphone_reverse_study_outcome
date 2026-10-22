package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.revlink.impl.pk.vm.linkout.p;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j8;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.match.a$a, reason: collision with other inner class name */
    public static final class C1459a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a r100, af2.a r101, int r102, boolean r110, int r111, Function1 r112, int r113) {
            if ((r113 & 2) == 0) goto L5;
            int r103 = 4;
        L7:
            if ((r113 & 4) == 0) goto L9;
            boolean r104 = false;
        L11:
            if ((r113 & 8) == 0) goto L13;
            int r105 = 0;
        L15:
            if ((r113 & 16) == 0) goto L17;
            String r106 = "";
        L19:
            if ((r113 & 32) == 0) goto L21;
            Function1 r107 = null;
        L22:
            r100.Ib(r101, r103, r104, r105, r106, r107);
            return;
        L21:
            r107 = r112;
            goto L22
        L17:
            r106 = null;
            goto L19
        L13:
            r105 = r111;
            goto L15
        L9:
            r104 = r110;
            goto L11
        L5:
            r103 = r102;
            goto L7
        }
    }

    void Bd();

    long Bj();

    b0 Dl();

    void Ib(af2.a r100, int r101, boolean r102, int r103, String r104, Function1<? super p, Unit> r105);

    void Jo(j8 r100);

    boolean Qd();

    void Wd();

    boolean Yj();

    Map<String, String> bb();

    void fl(int r100, i6 r101);

    ArrayList<g.b> getListeners();

    long hj();

    boolean isMatching();

    void ni(int r100, String r101);

    boolean po();

    void y8(String r100);
}
