package com.bytedance.android.live.livepkaudience.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements dl0.a<dl0.c.AbstractC5684c, WaitingListUser> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dl0.c.AbstractC5684c.a f82087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<WaitingListUser> f82088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f82089c = null;

    public c() {
    }

    static {
        f82089c = new c();
        f82087a = dl0.c.AbstractC5684c.a.f469058a;
    }

    @Override // dl0.a
    public final dl0.c b() {
        return f82087a;
    }

    @Override // dl0.a
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        WeakReference<WaitingListUser> r101 = f82088b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        WaitingListUser r102 = r101.get();
        if (r102 != null) goto L8;
        return;
    L8:
        MicPosTagInfo r103 = r102.getMicPosTag();
        if (r103 != null) goto L11;
        return;
    L11:
        TextView r104 = (TextView) r100.findViewById(R.id.tv_host);
        if (r104 == null) goto L14;
        r104.setText(r103.getPositionTagName());
    L14:
        el0.j.a(r104);
        if (r104 == null) goto L17;
        Integer r105 = Integer.valueOf(r104.getVisibility());
    L19:
        if (r105.intValue() == 0) goto L22;
        if (r104 == null) goto L22;
        r104.setVisibility(0);
    L22:
        if (r104 == null) goto L25;
        r104.setOnClickListener(new b());
        return;
    L25:
        return;
    L17:
        r105 = null;
        goto L19
    }

    @Override // dl0.a
    public final View a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        return LayoutInflater.from(r100).inflate(R.layout.ttlive_badge_pk_host_layout, r101, false);
    }
}
