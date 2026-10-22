package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f84446a = null;

    static {
        f84446a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = qo0.a.f534145a;
        qo0.a.b("ExplainCardTitleEditorDialog", "on title check fail, error: " + ((Throwable) r100), null);
        f2.b(R.string.ttlive_open_platform_network_error, 0);
    }
}
