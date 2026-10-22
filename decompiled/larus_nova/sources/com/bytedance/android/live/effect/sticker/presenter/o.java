package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface o {

    public static final class a {
        public static /* synthetic */ int d(o r100, String r101) {
            return r100.j(r101, "");
        }

        public static /* synthetic */ void b(o r100, String r101, String r110, com.bytedance.android.live.effect.api.k.e r111) {
            r100.e(r101, r110, 0, 0, "0", null, r111);
        }

        public static /* synthetic */ void a(o r100, String r101, com.bytedance.android.live.effect.api.k.i r102, boolean r110, boolean r111, boolean r112, int r113) {
            if ((r113 & 2) == 0) goto L5;
            r102 = null;
        L5:
            com.bytedance.android.live.effect.api.k.i r103 = r102;
            if ((r113 & 4) == 0) goto L8;
            boolean r104 = true;
        L10:
            if ((r113 & 8) == 0) goto L12;
            boolean r105 = true;
        L14:
            if ((r113 & 32) == 0) goto L16;
            boolean r106 = false;
        L17:
            r100.a(r101, r103, r104, r105, false, r106);
            return;
        L16:
            r106 = r112;
            goto L17
        L12:
            r105 = r111;
            goto L14
        L8:
            r104 = r110;
            goto L10
        }

        public static /* synthetic */ void c(o r100, String r110, String r111, int r112, boolean r113, com.bytedance.android.live.effect.api.k.d r114, boolean r115, int r116) {
            if ((r116 & 4) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r116 & 32) == 0) goto L9;
            boolean r102 = false;
        L11:
            if ((r116 & 64) == 0) goto L13;
            com.bytedance.android.live.effect.api.k.d r103 = null;
        L15:
            if ((r116 & 128) == 0) goto L17;
            boolean r104 = false;
        L18:
            r100.n(r110, false, r101, r112, 0, r102, r103, r104);
            return;
        L17:
            r104 = r115;
            goto L18
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }
    }

    public interface b {
        void a(boolean r100);
    }

    public interface c {
        void a(Sticker r100);

        void b();

        void onDownloadStart();
    }

    public interface d {
        void a(PanelInfoModel r100);
    }

    void a(String r100, com.bytedance.android.live.effect.api.k.i r101, boolean r102, boolean r103, boolean r104, boolean r105);

    boolean b(String r100);

    List<Effect> c(String r100);

    void d(String r100, String r101, Sticker r102);

    void e(String r100, String r101, int r102, int r103, String r104, Map r105, com.bytedance.android.live.effect.api.k.e r106);

    void f(String r100, com.bytedance.android.live.effect.api.k.d r101);

    void g(Sticker r100, boolean r101, b r102);

    void h(String r100, Sticker r101, com.bytedance.android.live.effect.sticker.chain.b.C1115b r102);

    EffectCategoryModel i(String r100, PanelInfoModel r101);

    int j(String r100, String r101);

    void k(String r100, String r101, int r102, com.bytedance.android.live.effect.api.k.a r103);

    void l(String r100, List<? extends Effect> r101);

    int m(String r100);

    void n(String r100, boolean r101, String r102, int r103, int r104, boolean r105, com.bytedance.android.live.effect.api.k.d r106, boolean r107);

    void o(String r100, String r101, com.bytedance.android.live.effect.api.k.b r102);

    void p(String r100, String r101, List<Integer> r102, boolean r103, com.bytedance.android.live.effect.api.k.c r104);
}
