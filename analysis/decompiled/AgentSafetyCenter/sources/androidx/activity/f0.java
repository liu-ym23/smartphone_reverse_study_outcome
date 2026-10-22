package androidx.activity;

import com.stepos.agentsafetycenter.auth.LaunchAuthActivity;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends u {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f673d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f674e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(androidx.fragment.app.v vVar) {
        super(false);
        this.f673d = 1;
        this.f674e = vVar;
    }

    /* JADX WARN: Type inference failed for: r6v7, types: [xb.a, yb.i] */
    @Override // androidx.activity.u
    public final void a() {
        switch (this.f673d) {
            case 0:
                ((s2.a) this.f674e).invoke(this);
                return;
            case 1:
                androidx.fragment.app.v vVar = (androidx.fragment.app.v) this.f674e;
                vVar.e(true);
                if (!vVar.f1311g.f699a) {
                    vVar.f1310f.b();
                    return;
                }
                vVar.e(false);
                vVar.d(true);
                ArrayList arrayList = vVar.B;
                ArrayList arrayList2 = vVar.C;
                ArrayList arrayList3 = vVar.f1308d;
                int size = (arrayList3 == null || arrayList3.isEmpty()) ? -1 : vVar.f1308d.size() - 1;
                if (size >= 0) {
                    for (int size2 = vVar.f1308d.size() - 1; size2 >= size; size2--) {
                        arrayList.add((androidx.fragment.app.a) vVar.f1308d.remove(size2));
                        arrayList2.add(Boolean.TRUE);
                    }
                    vVar.f1306b = true;
                    try {
                        vVar.j(vVar.B, vVar.C);
                    } finally {
                        vVar.a();
                    }
                }
                vVar.k();
                vVar.f1307c.f1249b.values().removeAll(Collections.singleton(null));
                return;
            default:
                LaunchAuthActivity launchAuthActivity = (LaunchAuthActivity) this.f674e;
                boolean z10 = launchAuthActivity.f2497f;
                o8.i iVar = (o8.i) launchAuthActivity.f2498g.getValue();
                iVar.getClass();
                if (z10 || !((iVar instanceof o8.h) || (iVar instanceof o8.f))) {
                    this.f699a = false;
                    ?? r62 = this.f701c;
                    if (r62 != 0) {
                        r62.invoke();
                    }
                    launchAuthActivity.finish();
                    return;
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(Object obj, int i) {
        super(true);
        this.f673d = i;
        this.f674e = obj;
    }
}
