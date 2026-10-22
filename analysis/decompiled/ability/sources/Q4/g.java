package Q4;

import C7.r;
import S7.o;
import android.os.Bundle;
import com.stepos.aiengine.adapter.ChineseClipAbilityAdapter;
import com.stepos.aiengine.args.result.ErrorBundleKt;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1110a;
    public final /* synthetic */ Ref$ObjectRef b;
    public final /* synthetic */ CountDownLatch c;

    public /* synthetic */ g(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, int i) {
        this.f1110a = i;
        this.b = ref$ObjectRef;
        this.c = countDownLatch;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f1110a;
        r rVar = r.f317a;
        CountDownLatch countDownLatch = this.c;
        Ref$ObjectRef ref$ObjectRef = this.b;
        String str = (String) obj;
        int iIntValue = ((Integer) obj2).intValue();
        String msg = (String) obj3;
        switch (i) {
            case 0:
                ChineseClipAbilityAdapter.Companion companion = ChineseClipAbilityAdapter.Companion;
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                ref$ObjectRef.f4920a = kotlin.b.a(new RuntimeException(androidx.constraintlayout.core.dsl.a.c(iIntValue, "code=", ", ", msg)));
                countDownLatch.countDown();
                break;
            case 1:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                ref$ObjectRef.f4920a = new RuntimeException(androidx.constraintlayout.core.dsl.a.c(iIntValue, "[", "] ", msg));
                countDownLatch.countDown();
                break;
            case 2:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle = new Bundle();
                ErrorBundleKt.writeInferError(bundle, iIntValue, msg);
                ref$ObjectRef.f4920a = bundle;
                countDownLatch.countDown();
                break;
            case 3:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle2 = new Bundle();
                ErrorBundleKt.writeInferError(bundle2, iIntValue, msg);
                ref$ObjectRef.f4920a = bundle2;
                countDownLatch.countDown();
                break;
            case 4:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle3 = new Bundle();
                ErrorBundleKt.writeInferError(bundle3, iIntValue, msg);
                ref$ObjectRef.f4920a = bundle3;
                countDownLatch.countDown();
                break;
            case 5:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle4 = new Bundle();
                ErrorBundleKt.writeInferError(bundle4, iIntValue, msg);
                ref$ObjectRef.f4920a = bundle4;
                countDownLatch.countDown();
                break;
            default:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle5 = new Bundle();
                ErrorBundleKt.writeInferError(bundle5, iIntValue, msg);
                ref$ObjectRef.f4920a = bundle5;
                countDownLatch.countDown();
                break;
        }
        return rVar;
    }
}
