package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFlashSearchDialogFragment f149697a;

    public f(LiveFlashSearchDialogFragment r100) {
        this.f149697a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        SearchListAdapter r102 = this.f149697a.f149681n;
        if (r102 == null) goto L9;
        ((ArrayList) r102.f149683a).clear();
        if (r101 == null) goto L7;
        ArrayList r103 = (ArrayList) r102.f149683a;
        r103.addAll(r101);
    L7:
        r102.notifyDataSetChanged();
        return;
    }
}
