package bb1;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.soloktv.karaokestation.util.CommonListAdapter;
import com.bytedance.android.live.soloktv.karaokestation.view.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonListAdapter<T> f18526a;

    public b(RecyclerView r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "vhProvider");
        CommonListAdapter<T> r102 = new CommonListAdapter(r101);
        this.f18526a = r102;
        r100.setAdapter(r102);
        r100.setLayoutManager(new LinearLayoutManager(r100.getContext()));
    }
}
