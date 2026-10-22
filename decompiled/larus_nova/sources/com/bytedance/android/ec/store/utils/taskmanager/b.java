package com.bytedance.android.ec.store.utils.taskmanager;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, List<Function0<Unit>>> f48694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TaskPriority f48695b;

    public final void a() {
        TaskPriority r100 = this.f48695b;
        Iterator r101 = ((LinkedHashMap) this.f48694a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (((Number) r102.getKey()).intValue() > r100.getValue()) goto L4;
        Iterator r103 = ((Iterable) r102.getValue()).iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        ((Function0) r103.next()).invoke();
        goto L9
    L11:
        ((List) r102.getValue()).clear();
        goto L4
    }

    public b() {
        this.f48694a = new LinkedHashMap();
        this.f48695b = TaskPriority.RIGHT_NOW;
    }
}
