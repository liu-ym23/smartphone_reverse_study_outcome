package bw4;

import android.webkit.ValueCallback;
import com.bytedance.ee.bear.clip.ClipExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClipExecutor f21145a;

    public a(ClipExecutor r100) {
        this.f21145a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        tt5.a.h("DocsClip#ClipExecutor", "checkJsReady ret = " + r101);
        if (Intrinsics.areEqual(r101, "true") == true) goto L6;
        this.f21145a.b();
        return;
    }
}
