package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class e implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GeneratedAdapter[] f3519a;

    public e(GeneratedAdapter[] r10) {
        kotlin.jvm.internal.q.g(r10, "generatedAdapters");
        this.f3519a = r10;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        kotlin.jvm.internal.q.g(r10, "source");
        kotlin.jvm.internal.q.g(r11, "event");
        v r12 = new v();
        GeneratedAdapter[] r13 = this.f3519a;
        int r14 = r13.length;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r16 >= r14) goto L5;
        r13[r16].callMethods(r10, r11, false, r12);
        r16 = r16 + 1;
        goto L3
    L5:
        GeneratedAdapter[] r17 = this.f3519a;
        int r18 = r17.length;
    L6:
        if (r15 >= r18) goto L8;
        r17[r15].callMethods(r10, r11, true, r12);
        r15 = r15 + 1;
        goto L6
    }
}
