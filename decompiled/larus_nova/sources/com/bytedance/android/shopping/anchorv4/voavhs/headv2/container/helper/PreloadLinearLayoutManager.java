package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.anchorv3.q;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/helper/PreloadLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f169171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f169172b;

    public static final class a extends q {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PreloadLinearLayoutManager f169173e;

        @Override // com.bytedance.android.ec.core.anchorv3.q
        public final void c() {
            this.f169173e.f169172b = true;
        }

        public a(PreloadLinearLayoutManager r100) {
            this.f169173e = r100;
            super(3);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int getExtraLayoutSpace(RecyclerView.State r100) {
        int r101 = super.getExtraLayoutSpace(r100);
        if (r101 == 0) goto L5;
        return r101;
    L5:
        if (this.f169172b == true) goto L7;
        return r101;
    L7:
        return this.f169171a;
    }

    public PreloadLinearLayoutManager(Context r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        super(r100);
        this.f169171a = com.bytedance.android.shopping.extensions.b.a(10);
        if (PdpPerfOpt.e() == false) goto L5;
        r101.rR().Z(new a(this), false);
        return;
    L5:
        this.f169172b = true;
    }
}
