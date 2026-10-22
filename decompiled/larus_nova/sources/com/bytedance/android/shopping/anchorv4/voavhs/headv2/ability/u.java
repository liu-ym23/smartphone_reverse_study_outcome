package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.graphics.Bitmap;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.facebook.common.references.CloseableReference;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface u {
    r P();

    int R();

    boolean S();

    void T(com.bytedance.android.shopping.anchorv4.vm.h r100);

    String U();

    x V();

    void W(com.bytedance.android.shopping.anchorv4.vm.c r100);

    int W4();

    void X(HeadRecyclerView r100);

    void Y(int r100);

    void Z(com.bytedance.android.ec.core.anchorv3.q r100, boolean r101);

    void a();

    void a0(Boolean r100);

    boolean b();

    boolean b0();

    AnchorV4Param c();

    void c0(boolean r100);

    boolean d();

    com.bytedance.android.shopping.anchorv4.perf.monitor.c d0();

    com.bytedance.android.shopping.anchorv4.video.f e();

    vg3.c e0();

    void f();

    void f0(int r100, Bitmap r101);

    void g0(String r100, Map<String, ? extends Object> r101, String r102, View r103, boolean r104, boolean r105, String r106);

    Map<String, Object> getEventParams();

    LifecycleOwner getLifecycleOwner();

    String getSessionId();

    LinkedTreeMap<String, Object> getTrackMeta();

    CloseableReference<Bitmap> h0();

    Boolean i0();

    boolean isExpanded();

    w j0();

    com.bytedance.android.shopping.anchorv4.containers.g k0();

    boolean l();

    void l0(Integer r100, int r101);

    AnchorV4HeadV2VO m0();

    boolean n();

    boolean n0();

    void o0(String r100, Map<String, Object> r101, boolean r102);

    boolean oa();

    void p0(z r100);

    void q0(int r100, Bitmap r101);

    CommonMeta r0();

    boolean r9();
}
