package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.livesdk.link.model.r;

/* JADX INFO: loaded from: classes47.dex */
public interface h {

    public interface a {
        void a();
    }

    public interface b {
        void a();

        void b(long r100, long r101, ExtraResponse<r, Extra> r102, boolean r103);
    }

    public interface c {
        void a();

        void b(long r100, long r101, ExtraResponse<r, Extra> r102, boolean r103);
    }

    boolean a(long r100, long r101, long r102, boolean r103);

    void d();

    void e(PkDoubleAudienceDataContext.C99401 r100);

    void f(b r100);

    void g();
}
