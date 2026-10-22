package cm7;

import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTimerStatus;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import wm7.g;
import xm7.k;
import zm7.i;
import zm7.j;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements i, zm7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<String> f24178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<String> f24179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f24180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f24181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f24182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f24183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bm7.a f24184g;

    /* JADX INFO: renamed from: cm7.a$a, reason: collision with other inner class name */
    public static final class C0459a {
    }

    static {
    }

    public final void d() {
        if (this.f24178a.isEmpty() == false) goto L6;
        d.d("LuckyCounterTimerHelper", "updateAndCheck: mRunningActions is empty and stop LuckyCountDownTimer");
        this.f24184g.c(LuckyCounterTimerStatus.TIMER_STOP);
        return;
    L6:
        Iterator<String> r100 = this.f24178a.iterator();
        if (r100.hasNext() == false) goto L33;
        String r101 = r100.next();
        xm7.a r102 = this.f24183f.c();
        if (r102 == null) goto L13;
        Map<String, List<String>> r103 = r102.c();
        if (r103 == null) goto L13;
        List<String> r104 = r103.get(r101);
    L15:
        if (r104 == null) goto L17;
        Iterator<String> r105 = r104.iterator();
    L23:
        if (r105.hasNext() == false) goto L29;
        if (this.f24179b.contains(r105.next()) == true) goto L23;
        this.f24184g.c(LuckyCounterTimerStatus.TIMER_STOP);
        return;
    L29:
        if (this.f24182e == true) goto L31;
        this.f24182e = true;
    L31:
        d.d("LuckyCounterTimerHelper", "updateAndCheck: rule is all match, and action = " + r101 + ", start LuckyCountDownTimer");
        this.f24184g.c(LuckyCounterTimerStatus.TIMER_START);
        return;
    L17:
        if (this.f24182e == true) goto L19;
        this.f24182e = true;
    L19:
        d.d("LuckyCounterTimerHelper", "updateAndCheck: rule is null, and action = " + r101 + ", start LuckyCountDownTimer");
        this.f24184g.c(LuckyCounterTimerStatus.TIMER_START);
        return;
    L13:
        r104 = null;
        goto L15
    L33:
        this.f24184g.c(LuckyCounterTimerStatus.TIMER_STOP);
    }

    @Override // zm7.a
    public final void a(String r100) {
        d.d("LuckyCounterTimerHelper", "startTiming: action: " + r100 + ", mRunningActions: " + this.f24178a + ", actions: " + this.f24180c);
        List<String> r101 = this.f24180c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == true) goto L7;
        return;
    L7:
        if (this.f24178a.contains(r100) == true) goto L12;
        this.f24178a.add(r100);
        d.d("LuckyCounterTimerHelper", "updateAndCheck, startTiming: action: " + r100 + ", mRunningActions: " + this.f24178a + ", actions: " + this.f24180c);
        d();
        return;
    }

    @Override // zm7.i
    public final void b(String r100) {
        d.d("LuckyCounterTimerHelper", "matchRule: rule: " + r100 + ", mMatchRules: " + this.f24179b + ", rules: " + this.f24181d);
        List<String> r101 = this.f24181d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == true) goto L7;
        return;
    L7:
        if (this.f24179b.contains(r100) == true) goto L12;
        this.f24179b.add(r100);
        d.d("LuckyCounterTimerHelper", "updateAndCheck, matchRule: rule: " + r100 + ", mMatchRules: " + this.f24179b + ", rules: " + this.f24181d);
        d();
        return;
    }

    @Override // zm7.a
    public final void c(String r100) {
        d.d("LuckyCounterTimerHelper", "stopTiming: action: " + r100 + ", mRunningActions: " + this.f24178a + ", actions: " + this.f24180c);
        this.f24178a.remove(r100);
        d();
    }

    @Override // zm7.i
    public final void e(String r100) {
        d.d("LuckyCounterTimerHelper", "disMatchRule: rule: " + r100 + ", mMatchRules: " + this.f24179b + ", rules: " + this.f24181d);
        this.f24179b.remove(r100);
        d();
    }

    public a(k r100, bm7.a r101) {
        this.f24183f = r100;
        this.f24184g = r101;
        this.f24178a = new ConcurrentLinkedQueue();
        this.f24179b = new ConcurrentLinkedQueue();
        xm7.a r102 = r100.c();
        Map<String, List<String>> r103 = null;
        if (r102 == null) goto L5;
        List<String> r104 = r102.a();
    L6:
        this.f24180c = r104;
        if (r104 == null) goto L14;
        Iterator<String> r105 = ((zm7.d) g.a(zm7.d.class)).d(this, r104).iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        String r106 = r105.next();
        if (this.f24178a.contains(r106) == true) goto L10;
        this.f24178a.add(r106);
    L14:
        xm7.a r107 = this.f24183f.c();
        if (r107 == null) goto L17;
        r103 = r107.c();
    L17:
        HashSet r108 = new HashSet();
        if (r103 == null) goto L27;
        Iterator<Map.Entry<String, List<String>>> r109 = r103.entrySet().iterator();
    L21:
        if (r109.hasNext() == false) goto L27;
        List<String> r110 = r109.next().getValue();
        if (r110 == null) goto L26;
        r108.addAll(r110);
        goto L21
    L26:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<kotlin.String>");
    L27:
        List<String> r111 = CollectionsKt.toList(r108);
        this.f24181d = r111;
        if (r111 == null) goto L30;
        int r112 = r111.size();
    L31:
        if (r112 <= 0) goto L33;
        this.f24179b.addAll(((j) g.a(j.class)).b(this, r111));
    L33:
        d.d("LuckyCounterTimerHelper", "init and updateAndCheck");
        d();
        return;
    L30:
        r112 = 0;
        goto L31
    L5:
        r104 = null;
        goto L6
    }
}
