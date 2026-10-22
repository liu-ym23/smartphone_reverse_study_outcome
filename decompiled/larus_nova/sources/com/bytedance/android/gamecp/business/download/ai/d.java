package com.bytedance.android.gamecp.business.download.ai;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f52480a;

    public d(c r100) {
        this.f52480a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.android.gamecp.host_api.model.j r104 = z.b((com.bytedance.android.gamecp.host_api.model.toolbar.a) r103.next());
        if (this.f52480a.d(r104) == false) goto L4;
        LocalTestManager.a(new Class[]{uv.a.class});
        r102.add(r104);
        goto L4
    L9:
        LocalTestManager.a(new Class[]{uv.a.class});
        return r102;
    }
}
