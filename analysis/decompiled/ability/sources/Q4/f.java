package Q4;

import C7.r;
import S7.n;
import android.os.Bundle;
import android.system.ErrnoException;
import com.stepos.aiengine.adapter.ChineseClipAbilityAdapter;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.PrimitiveContent;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1109a;
    public final /* synthetic */ Ref$ObjectRef b;
    public final /* synthetic */ CountDownLatch c;

    public /* synthetic */ f(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, int i) {
        this.f1109a = i;
        this.b = ref$ObjectRef;
        this.c = countDownLatch;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) throws ErrnoException {
        int i = this.f1109a;
        r rVar = r.f317a;
        CountDownLatch countDownLatch = this.c;
        Ref$ObjectRef ref$ObjectRef = this.b;
        String str = (String) obj;
        switch (i) {
            case 0:
                PrimitiveContent r5 = (PrimitiveContent) obj2;
                ChineseClipAbilityAdapter.Companion companion = ChineseClipAbilityAdapter.Companion;
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r5, "r");
                ref$ObjectRef.f4920a = r5.getValue();
                countDownLatch.countDown();
                break;
            case 1:
                PrimitiveContent r6 = (PrimitiveContent) obj2;
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r6, "r");
                ref$ObjectRef.f4920a = r6.getValue();
                countDownLatch.countDown();
                break;
            case 2:
                ImageContent r9 = (ImageContent) obj2;
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r9, "r");
                Bundle bundleK = com.stepos.ability.task.executor.e.K(r9);
                ContentParams params = r9.getParams();
                if (params != null) {
                    int[] intArray = params.getIntArray("mat_region");
                    if (intArray != null) {
                        bundleK.putIntArray("mat_region", intArray);
                    }
                    if (params.containsKey("mat_proportion")) {
                        bundleK.putFloat("mat_proportion", ContentParams.getFloat$default(params, "mat_proportion", 0.0f, 2, null));
                    }
                    if (params.containsKey("mat_sample_size")) {
                        bundleK.putInt("mat_sample_size", ContentParams.getInt$default(params, "mat_sample_size", 0, 2, null));
                    }
                    int[] intArray2 = params.getIntArray("mat_contours");
                    if (intArray2 != null) {
                        bundleK.putIntArray("mat_contours", intArray2);
                    }
                    int[] intArray3 = params.getIntArray("mat_hierarchies");
                    if (intArray3 != null) {
                        bundleK.putIntArray("mat_hierarchies", intArray3);
                    }
                }
                ref$ObjectRef.f4920a = bundleK;
                countDownLatch.countDown();
                break;
            case 3:
                ImageContent r10 = (ImageContent) obj2;
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r10, "r");
                ref$ObjectRef.f4920a = com.stepos.ability.task.executor.e.K(r10);
                countDownLatch.countDown();
                break;
            default:
                PrimitiveContent r11 = (PrimitiveContent) obj2;
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r11, "r");
                ref$ObjectRef.f4920a = r11.getValue();
                countDownLatch.countDown();
                break;
        }
        return rVar;
    }
}
