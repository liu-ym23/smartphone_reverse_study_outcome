package com.bytedance.android.anniex.scene.next;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
final /* synthetic */ class Evaluator$evaluateSceneRepeatOutcome$1 extends FunctionReferenceImpl implements Function2<Boolean, Map<String, ? extends h>, Unit> {
    public Evaluator$evaluateSceneRepeatOutcome$1(Object r100) {
        super(2, r100, e.class, "evaluate", "evaluate(ZLjava/util/Map;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(boolean r100, Map<String, h> r101) {
        Intrinsics.checkNotNullParameter(r101, "p1");
        e r102 = (e) this.receiver;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "predictionsMap");
        Iterator<Map.Entry<String, h>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L36;
        Map.Entry<String, h> r104 = r103.next();
        String r105 = r104.getKey();
        h r106 = r104.getValue();
        if (r106.f41287a != PredictElementType.SceneRepeat) goto L4;
        List<xa.b<?>> r107 = r106.f41288b;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L9:
        if (r109.hasNext() == false) goto L16;
        T r110 = ((xa.b) r109.next()).f563022b;
        if ((r110 instanceof Boolean) == false) goto L13;
        Boolean r111 = (Boolean) r110;
    L14:
        if (r111 == null) goto L9;
        r108.add(r111);
        goto L9
    L13:
        r111 = null;
        goto L14
    L16:
        ConcurrentHashMap r112 = (ConcurrentHashMap) r102.f41268a;
        Object r113 = r112.get(r105);
        if (r113 != null) goto L22;
        r113 = new e.a(0);
        Object r114 = r112.putIfAbsent(r105, r113);
        if (r114 == null) goto L22;
        r113 = r114;
    L22:
        e.a r115 = (e.a) r113;
        r115.f41269a++;
        if (r100 == false) goto L26;
        r115.f41270b++;
    L26:
        if ((!r108.isEmpty()) == false) goto L4;
        if (((Boolean) CollectionsKt.first(r108)).booleanValue() == false) goto L31;
        r115.f41272d++;
    L31:
        if (r108.contains(Boolean.valueOf(r100)) == false) goto L4;
        if (r100 == false) goto L34;
        r115.f41274f++;
    L35:
        r115.f41273e++;
        goto L4
    L34:
        r115.f41275g++;
        goto L35
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Map<String, ? extends h> r101) {
        invoke(r100.booleanValue(), r101);
        return Unit.INSTANCE;
    }
}
