package b36;

import android.webkit.RenderProcessGoneDetail;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RenderProcessGoneDetail f17187a;

    @Override // b36.c
    public final boolean a() {
        return this.f17187a.didCrash();
    }

    public final int b() {
        return this.f17187a.rendererPriorityAtExit();
    }

    public l(RenderProcessGoneDetail r100) {
        this.f17187a = r100;
    }
}
