package Q4;

import C7.r;
import com.stepos.aiengine.adapter.ChineseClipAbilityAdapter;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1111a;
    public final /* synthetic */ CountDownLatch b;

    public /* synthetic */ h(CountDownLatch countDownLatch, int i) {
        this.f1111a = i;
        this.b = countDownLatch;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f1111a;
        r rVar = r.f317a;
        CountDownLatch countDownLatch = this.b;
        String it = (String) obj;
        switch (i) {
            case 0:
                ChineseClipAbilityAdapter.Companion companion = ChineseClipAbilityAdapter.Companion;
                kotlin.jvm.internal.k.f(it, "it");
                countDownLatch.countDown();
                break;
            case 1:
                kotlin.jvm.internal.k.f(it, "<unused var>");
                countDownLatch.countDown();
                break;
            case 2:
                kotlin.jvm.internal.k.f(it, "it");
                countDownLatch.countDown();
                break;
            case 3:
                kotlin.jvm.internal.k.f(it, "it");
                countDownLatch.countDown();
                break;
            case 4:
                kotlin.jvm.internal.k.f(it, "it");
                countDownLatch.countDown();
                break;
            case 5:
                kotlin.jvm.internal.k.f(it, "it");
                countDownLatch.countDown();
                break;
            case 6:
                kotlin.jvm.internal.k.f(it, "it");
                countDownLatch.countDown();
                break;
            default:
                kotlin.jvm.internal.k.f(it, "<unused var>");
                countDownLatch.countDown();
                break;
        }
        return rVar;
    }
}
