package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkbase.SupportUpdatePlayMode;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import com.bytedance.android.live.ui.ClipFrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes46.dex */
public interface l extends xg0.a {

    public static final class a {
        public static /* synthetic */ Pair a(l r100) {
            return r100.Yl(1, null);
        }

        public static /* synthetic */ void b(l r110, IRoom r111, DataCenter r112, m r113, BaseEqualGridItemDecoration r114, vg0.a r210, SeatAnimEngineWrapper r211, int r212, int r213, int r214, se0.c r215, com.bytedance.android.live.liveinteract.plantform.datamerge.d r216, int r217) {
            if ((r217 & 32) == 0) goto L5;
            SeatAnimEngineWrapper r100 = null;
        L7:
            if ((r217 & 256) == 0) goto L9;
            int r115 = 0;
        L11:
            if ((r217 & 512) == 0) goto L13;
            se0.c r116 = null;
        L15:
            if ((r217 & 1024) == 0) goto L17;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r117 = null;
        L18:
            r110.Sm(r111, r112, r113, r114, r210, r100, r212, r213, r115, r116, r117);
            return;
        L17:
            r117 = r216;
            goto L18
        L13:
            r116 = r215;
            goto L15
        L9:
            r115 = r214;
            goto L11
        L5:
            r100 = r211;
            goto L7
        }
    }

    boolean Gi();

    void Ha(m r100, boolean r101);

    void K1(String r100);

    void Ma();

    void O7(List<? extends tf0.e> r100);

    void Pj(String r100, View r101, boolean r102);

    int S0(String r100);

    void Sm(IRoom r100, DataCenter r101, m r102, BaseEqualGridItemDecoration r103, vg0.a r104, SeatAnimEngineWrapper r105, int r106, int r107, int r108, se0.c r110, com.bytedance.android.live.liveinteract.plantform.datamerge.d r111);

    void Sp(m r100, int r101, int r102);

    void T8();

    void U3(m r100, int r101, int r102);

    void Xl(com.bytedance.android.live.liveinteract.plantform.datamerge.a r100);

    void Yd(m r100, int r101, int r102);

    void Ye(View r100);

    Pair<Integer, Integer> Yl(int r100, pn0.f r101);

    void a6(tf0.o.a r100);

    void b7(@SupportUpdatePlayMode int r100);

    ConstraintLayout.LayoutParams getCurRvLayoutParams();

    m getCurrentLayoutConfig();

    List<tf0.e> getDataList();

    Long getEnterRoomTime();

    ClipFrameLayout getFirstSeatVHShadowContainer();

    ClipFrameLayout getFirstSeatVHShadowFloatContainer();

    BaseLinkSeatWindowView getLinkSeatWindowView();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    RecyclerView getMicSeatRecyclerView();

    fg0.a getMultiAdapterWrapper();

    LinkMicRecyclerView getRecyclerView();

    ug0.a getRvLayoutManager();

    ConstraintLayout getSingleSurfaceViewContainer();

    boolean gg();

    void hi(String r100, boolean r101, boolean r102, boolean r103);

    void jf();

    void le(SurfaceView r100);

    void m3(MultiLinkGuestViewBinder.a r100, boolean r101);

    void pd(View r100);

    void release();

    void setMFirstVHShadowViewChange(CommonLinkSeatWindowView.a r100);

    void setUIViewValid(boolean r100);

    ViewGroup td();

    View vb();

    Pair<Integer, Integer> vn(int r100, pn0.f r101);

    void x8();

    void zk(String r100, View r101, boolean r102);
}
