package com.stepos.policy.sdk.activity;

import android.view.View;
import com.stepos.agentsafetycenter.perfbinder.PerfBinderTestActivity;
import id.c;
import jb.i;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2782c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2783f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2784g;

    public /* synthetic */ b(int i) {
        this.f2782c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object objL;
        switch (this.f2782c) {
            case 0:
                PolicyHtmlViewerActivity.showNotNetWorkView$lambda$8$lambda$7((PolicyHtmlViewerActivity) this.f2783f, (l) this.f2784g, view);
                break;
            default:
                xb.a aVar = (xb.a) this.f2783f;
                PerfBinderTestActivity perfBinderTestActivity = (PerfBinderTestActivity) this.f2784g;
                int i = PerfBinderTestActivity.f2510f;
                try {
                    objL = aVar.invoke();
                } catch (Throwable th) {
                    objL = c.l(th);
                }
                Throwable thB = i.b(objL);
                if (thB != null) {
                    perfBinderTestActivity.c("ERR " + thB.getMessage());
                    break;
                }
                break;
        }
    }
}
