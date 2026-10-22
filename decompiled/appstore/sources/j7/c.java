package j7;

import androidx.fragment.app.Fragment;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f20944i;

    public c(Map r10, Fragment r11) {
        q.g(r10, "tabFragmentsCreators");
        q.g(r11, "fragment");
        super(r11);
        this.f20944i = r10;
    }

    @Override // j7.a
    public Fragment c(int r10) {
        Function0 r11 = (Function0) this.f20944i.get(Integer.valueOf(r10));
        if (r11 == null) goto L8;
        Fragment r12 = (Fragment) r11.invoke();
        if (r12 == null) goto L8;
        return r12;
    L8:
        throw new IndexOutOfBoundsException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f20944i.size();
    }
}
