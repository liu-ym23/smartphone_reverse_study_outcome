package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface i<T extends h> {

    public static class a<T extends h> implements b<T> {
        public a() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void a(String r100, String r101) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void b(String r100, String r101, boolean r102) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void d(List<T> r100, List<T> r101) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void e(List<LinkmicPositionItem> r100) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void g(String r100, long r101, String r102, l r103) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void k() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void l(List<T> r100) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void n(List<T> r100, long r101, n0 r102) {
        }
    }

    public interface b<T extends h> {
        void a(String r100, String r101);

        void b(String r100, String r101, boolean r102);

        void d(List<T> r100, List<T> r101);

        void e(List<LinkmicPositionItem> r100);

        void g(String r100, long r101, String r102, l r103);

        void k();

        void l(List<T> r100);

        void n(List<T> r100, long r101, n0 r102);

        void onOnlineListChanged(List<T> r100);
    }

    public interface c {
        void a(n0 r100);
    }

    public static class d implements b<ILinkPlayerInfoBridge> {
        public d() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void a(String r100, String r101) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void b(String r100, String r101, boolean r102) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void d(List<ILinkPlayerInfoBridge> r100, List<ILinkPlayerInfoBridge> r101) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void e(List<LinkmicPositionItem> r100) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void g(String r100, long r101, String r102, l r103) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void k() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void l(List<ILinkPlayerInfoBridge> r100) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void n(List<ILinkPlayerInfoBridge> r100, long r101, n0 r102) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void onOnlineListChanged(List<ILinkPlayerInfoBridge> r100) {
        }
    }

    String N4(String r100);

    int O4(String r100);

    int P4(int r100);

    void Q4(b<T> r100);

    void R4(boolean r100);

    void S4(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100, ClientUIInfo r101, long r102, String r103);

    void T4(b<T> r100);

    IBaseUser U4(String r100);

    List<T> V4();

    void W4();

    void X4();

    void Y4(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100, ClientUIInfo r101, long r102, String r103, Map<Long, ? extends g2> r104);

    Boolean Z4();

    List<T> a();

    T a5(String r100, String r101);

    int b();

    boolean b5(String r100);

    List<T> c();

    IBaseUser c5(String r100);

    List<LinkmicPositionItem> d();

    T getGuestInfo(String r100, String r101);

    long getLastVersion();

    List<T> getOnlineUserList();

    void r0();

    void v();
}
