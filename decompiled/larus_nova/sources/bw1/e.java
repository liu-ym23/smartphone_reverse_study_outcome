package bw1;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f21003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<FeedItem> f21004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FeedExtra f21005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.feed.feed.e f21008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TabListModel f21009g;

    public abstract String a(int r100);

    public abstract String b();

    public abstract void c();

    public abstract String d();

    public abstract String e(String r100);

    public abstract String f();

    public abstract long g();

    public e(com.bytedance.android.livesdk.feed.feed.e r100, TabListModel r101) {
        Intrinsics.checkNotNullParameter(r100, "itemTab");
        Intrinsics.checkNotNullParameter(r101, "tabListModel");
        this.f21008f = r100;
        this.f21009g = r101;
        this.f21003a = Arrays.asList(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
        this.f21004b = new LinkedList();
        FeedExtra r102 = new FeedExtra();
        r102.hasMore = true;
        Unit r103 = Unit.INSTANCE;
        this.f21005c = r102;
    }
}
