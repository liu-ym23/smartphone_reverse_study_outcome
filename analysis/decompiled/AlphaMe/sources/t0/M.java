package t0;

import com.stepos.alphame.dailyusage.sync.DailyUsageSyncKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class M extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0.I f15349a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0913H f15350b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f15351c = DailyUsageSyncKt.DAILY_USAGE_SYNC;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0929o f15352d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(s0.E e4, C0913H c0913h, C0929o c0929o) {
        super(0);
        this.f15349a = e4;
        this.f15350b = c0913h;
        this.f15352d = c0929o;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        new C0.e(new y(this.f15350b, this.f15351c, 2, CollectionsKt.listOf(this.f15349a)), this.f15352d).run();
        return Unit.INSTANCE;
    }
}
