package com.bytedance.android.livesdk.chatroom.replay.datacontext;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayDataContextInject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<DataContext, Disposable>> f108287a;

    public ReplayDataContextInject() {
        this.f108287a = new ArrayList();
    }

    public final void a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Pair r101 = d.a(ReplayDataContextInject$create$vsProgressDataContextRef$1.INSTANCE);
        d.c((DataContext) r101.getFirst(), Integer.valueOf(r100.hashCode() + 483071972));
        Pair r102 = d.a(ReplayDataContextInject$create$castScreenDataContextRef$1.INSTANCE);
        DataContext r103 = (DataContext) r102.getFirst();
        int r104 = r100.hashCode();
        r.b().I();
        d.c(r103, Integer.valueOf(r104 - 1897823386));
        ((ArrayList) this.f108287a).add(r101);
        ((ArrayList) this.f108287a).add(r102);
    }
}
