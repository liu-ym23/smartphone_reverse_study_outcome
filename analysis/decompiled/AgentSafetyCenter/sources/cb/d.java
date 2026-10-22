package cb;

import android.view.View;
import com.stepos.common.widget.Switch;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2245c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2246f;

    public /* synthetic */ d(int i) {
        this.f2245c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2245c;
        Object obj = this.f2246f;
        switch (i) {
            case 0:
                g gVar = ((i) obj).B;
                if (gVar != null) {
                    ((xb.a) ((b.b) gVar).f1685f).invoke();
                    break;
                }
                break;
            case 1:
                ((Switch) obj).toggle();
                break;
            default:
                ((xb.a) ((c1) obj).getValue()).invoke();
                break;
        }
    }
}
