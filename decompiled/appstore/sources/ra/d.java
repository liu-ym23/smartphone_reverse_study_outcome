package ra;

import androidx.fragment.app.Fragment;
import com.bytedanceos.common.f;
import com.obric.appstore.buss.myapp.myapp.MyAppFragment;
import com.obric.appstore.buss.myapp.sysapp.SysAppFragment;
import com.obric.appstore.buss.myapp.update.UpdateFragment;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends j0.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f23821i;

    public d(Fragment r10, List r11) {
        q.g(r10, "fragment");
        q.g(r11, "titles");
        super(r10);
        this.f23821i = r11;
    }

    @Override // j0.a
    public Fragment c(int r10) {
        int r11 = ((Number) this.f23821i.get(r10)).intValue();
        f r12 = f.f9823a;
        if (r11 != r12.a()) goto L6;
        return new MyAppFragment();
    L6:
        if (r11 != r12.b()) goto L9;
        return new SysAppFragment();
    L9:
        return new UpdateFragment();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f23821i.size();
    }
}
