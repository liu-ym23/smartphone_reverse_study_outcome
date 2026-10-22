package g;

import android.content.Context;
import android.view.View;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends f.n {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f2703l = 1;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ i f2704m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar, Context context, f.j jVar, View view) {
        super(context, jVar, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.f2704m = iVar;
        this.f2502f = 8388613;
        androidx.emoji2.text.m mVar = iVar.f2732w;
        this.f2504h = mVar;
        f.l lVar = this.f2505i;
        if (lVar != null) {
            lVar.d(mVar);
        }
    }

    @Override // f.n
    public final void c() {
        switch (this.f2703l) {
            case 0:
                i iVar = this.f2704m;
                iVar.f2729t = null;
                iVar.getClass();
                super.c();
                break;
            default:
                i iVar2 = this.f2704m;
                f.j jVar = iVar2.f2714c;
                if (jVar != null) {
                    jVar.c(true);
                }
                iVar2.f2728s = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar, Context context, f.t tVar, View view) {
        super(context, tVar, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.f2704m = iVar;
        if ((tVar.f2527w.f2495x & 32) != 32) {
            View view2 = iVar.f2718h;
            this.f2501e = view2 == null ? iVar.f2717g : view2;
        }
        androidx.emoji2.text.m mVar = iVar.f2732w;
        this.f2504h = mVar;
        f.l lVar = this.f2505i;
        if (lVar != null) {
            lVar.d(mVar);
        }
    }
}
