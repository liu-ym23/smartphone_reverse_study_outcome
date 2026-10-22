package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ boolean a(f r100, AbsPanel r101) {
            return r100.x(r101, SelectedStatus.CLICK, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean b(f r110, AbsPanel r111, int r112, IBaseUser r113, boolean r210, List r211, n r212, com.bytedance.android.livesdk.gift.platform.core.model.k r213, com.bytedance.android.livesdk.gift.platform.core.model.k r214, l1 r215, com.bytedance.android.livesdk.gift.model.n r216, String r217, com.bytedance.android.livesdk.gift.platform.core.model.a r218, int r219) {
            if ((r219 & 16) == 0) goto L5;
            boolean r100 = false;
        L7:
            if ((r219 & 32) == 0) goto L9;
            List r101 = null;
        L11:
            if ((r219 & 128) == 0) goto L13;
            n r102 = new n(null, null, 7);
        L15:
            if ((r219 & 256) == 0) goto L17;
            com.bytedance.android.livesdk.gift.platform.core.model.k r103 = null;
        L19:
            if ((r219 & 512) == 0) goto L21;
            com.bytedance.android.livesdk.gift.platform.core.model.k r114 = null;
        L23:
            if ((r219 & 1024) == 0) goto L25;
            l1 r115 = null;
        L27:
            if ((r219 & 2048) == 0) goto L29;
            com.bytedance.android.livesdk.gift.model.n r116 = null;
        L31:
            if ((r219 & 16384) == 0) goto L33;
            com.bytedance.android.livesdk.gift.platform.core.model.a r117 = null;
        L35:
            return r110.A(r111, r112, 0, r113, r100, r101, false, r102, r103, r114, r115, r116, null, r217, r117);
        L33:
            r117 = r218;
            goto L35
        L29:
            r116 = r216;
            goto L31
        L25:
            r115 = r215;
            goto L27
        L21:
            r114 = r214;
            goto L23
        L17:
            r103 = r213;
            goto L19
        L13:
            r102 = r212;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean c(f r110, AbsPanel r210, int r211, int r212, IBaseUser r213, boolean r214, List r215, n r216, l1 r217, com.bytedance.android.livesdk.gift.model.n r218, String r219, int r310, String r311, com.bytedance.android.livesdk.gift.platform.core.model.a r312, int r313) {
            if ((r313 & 16) == 0) goto L5;
            boolean r100 = false;
        L7:
            if ((r313 & 32) == 0) goto L9;
            List r101 = null;
        L11:
            if ((r313 & 64) == 0) goto L13;
            n r111 = new n(null, null, 7);
        L15:
            if ((r313 & 512) == 0) goto L17;
            l1 r112 = null;
        L19:
            if ((r313 & 1024) == 0) goto L21;
            com.bytedance.android.livesdk.gift.model.n r113 = null;
        L23:
            if ((r313 & 2048) == 0) goto L25;
            String r114 = null;
        L27:
            if ((r313 & 4096) == 0) goto L29;
            int r115 = 0;
        L31:
            if ((r313 & 8192) == 0) goto L33;
            String r116 = null;
        L35:
            if ((r313 & 16384) == 0) goto L37;
            com.bytedance.android.livesdk.gift.platform.core.model.a r117 = null;
        L39:
            return r110.o(r210, r211, r212, r213, r100, r101, r111, null, null, r112, r113, r114, r115, r116, r117);
        L37:
            r117 = r312;
            goto L39
        L33:
            r116 = r311;
            goto L35
        L29:
            r115 = r310;
            goto L31
        L25:
            r114 = r219;
            goto L27
        L21:
            r113 = r218;
            goto L23
        L17:
            r112 = r217;
            goto L19
        L13:
            r111 = r216;
            goto L15
        L9:
            r101 = r215;
            goto L11
        L5:
            r100 = r214;
            goto L7
        }
    }

    boolean A(AbsPanel<?> r100, int r101, int r102, IBaseUser r103, boolean r104, List<? extends IBaseUser> r105, boolean r106, n r107, com.bytedance.android.livesdk.gift.platform.core.model.k r108, com.bytedance.android.livesdk.gift.platform.core.model.k r110, l1 r111, com.bytedance.android.livesdk.gift.model.n r112, String r113, String r114, com.bytedance.android.livesdk.gift.platform.core.model.a r115);

    void c();

    void d(AbsPanel r100);

    void h();

    void i(h1 r100);

    void j(long r100, Integer r101);

    void n();

    boolean o(AbsPanel<?> r100, int r101, int r102, IBaseUser r103, boolean r104, List<? extends IBaseUser> r105, n r106, com.bytedance.android.livesdk.gift.platform.core.model.k r107, com.bytedance.android.livesdk.gift.platform.core.model.k r108, l1 r110, com.bytedance.android.livesdk.gift.model.n r111, String r112, int r113, String r114, com.bytedance.android.livesdk.gift.platform.core.model.a r115);

    void q();

    void s();

    boolean x(AbsPanel<?> r100, SelectedStatus r101, Integer r102);

    void y(p2 r100);
}
