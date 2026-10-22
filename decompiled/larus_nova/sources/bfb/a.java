package bfb;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f18847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Long, Integer> f18848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18849c;

    /* JADX INFO: renamed from: bfb.a$a, reason: collision with other inner class name */
    public static final class C0298a {
    }

    static {
    }

    public a(FeedRecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "inboxRecyclerView");
        this.f18847a = r100;
        new HashMap();
        FeedFolderCompat r101 = FeedFolderCompat.INSTANCE;
        r101.getUNKNOWN();
        r101.getUNKNOWN();
        this.f18848b = new HashMap();
    }

    public final void a(UpdateRecord r100) {
        RecyclerView.LayoutManager r101 = this.f18847a.getLayoutManager();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int r102 = ((LinearLayoutManager) r101).findFirstCompletelyVisibleItemPosition();
        Log.d("FeedScrollStateRecorder", "first visible position = " + r102);
        this.f18848b.put(Long.valueOf(r100.f421127a), Integer.valueOf(r102));
    }
}
