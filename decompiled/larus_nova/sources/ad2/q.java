package ad2;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f2988a = null;

    static {
        f2988a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        List r102 = CollectionsKt.sortedWith(r101, new p());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add((com.bytedance.android.livesdk.jsbridge.methods.upload.models.a) ((Pair) r104.next()).getSecond());
        goto L4
    L6:
        return r103;
    }
}
