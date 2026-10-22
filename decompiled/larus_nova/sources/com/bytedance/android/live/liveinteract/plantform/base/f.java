package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.live.datacontext.DataContext;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class f {
    static {
        PublishSubject<g> r100 = g.f75491m0;
    }

    public static g a() {
        DataContext r100 = com.bytedance.live.datacontext.d.d("ILinkMultiInternalService");
        if ((r100 instanceof LinkInternalServiceContext) == true) goto L5;
        return null;
    L5:
        return ((LinkInternalServiceContext) r100).getMultiService().getValue();
    }
}
