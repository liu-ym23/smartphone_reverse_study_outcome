package com.bytedance.android.live.liveinteract.plantform.performance;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.c60;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, BehaviorSubject<d0>> f77304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f77305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, c0> f77306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f77307d;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.performance.a$a, reason: collision with other inner class name */
    public static final class C1196a {
    }

    static {
    }

    public a() {
        this.f77306c = new LinkedHashMap();
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "abilityKey");
        Map<String, BehaviorSubject<d0>> r101 = this.f77304a;
        if (r101 == null) goto L9;
        BehaviorSubject<d0> r102 = r101.get(r100);
        if (r102 == null) goto L9;
        d0 r103 = r102.getValue();
        if (r103 == null) goto L9;
        return r103.f77316a;
    L9:
        return true;
    }

    public final void d(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f77306c.remove(String.valueOf(r100.hashCode()));
        ALogger.i("MultiLinkAtomicAbility-Manager", "unRegisterPerfAbilityCBForAllAbility  bizSize=" + this.f77306c.size());
    }

    public final String b(String r100, Function1<? super Map<String, d0>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "abilityKey");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (c60.f119925a.getValue().getPerfBalanceEnable() == true) goto L6;
        return "";
    L6:
        String r102 = String.valueOf(r101.hashCode());
        if (this.f77306c.containsKey(r102) == false) goto L13;
        c0 r103 = (c0) ((LinkedHashMap) this.f77306c).get(r102);
        if (r103 == null) goto L14;
        HashSet<String> r104 = r103.f77313a;
        if (r104 == null) goto L14;
        r104.add(r100);
    L14:
        StringBuilder r105 = new StringBuilder("registerPerfAbilityCB abilityKey=");
        r105.append(r100);
        r105.append(" cbId=");
        r105.append(r102);
        r105.append(" currentBizSubSize=");
        c0 r106 = (c0) ((LinkedHashMap) this.f77306c).get(r102);
        if (r106 == null) goto L19;
        HashSet<String> r107 = r106.f77313a;
        if (r107 == null) goto L19;
        Integer r108 = Integer.valueOf(r107.size());
    L20:
        r105.append(r108);
        r105.append(" bizSize=");
        r105.append(this.f77306c.size());
        ALogger.i("MultiLinkAtomicAbility-Manager", r105.toString());
        return r102;
    L19:
        r108 = null;
        goto L20
    L13:
        this.f77306c.put(r102, new c0(SetsKt.hashSetOf(new String[]{r100}), r101));
        goto L14
    }

    public final boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "abilityKey");
        Intrinsics.checkNotNullParameter(r101, "cbId");
        c0 r102 = (c0) ((LinkedHashMap) this.f77306c).get(r101);
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.f77313a.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        if (Intrinsics.areEqual((String) r104, r100) == false) goto L6;
    L12:
        if (((String) r104) == null) goto L23;
        r102.f77313a.remove(r100);
        if (r102.f77313a.isEmpty() == false) goto L16;
        this.f77306c.remove(r101);
    L16:
        ALogger.i("MultiLinkAtomicAbility-Manager", "unRegisterPerfAbilityCBById abilityKey=" + r100 + " cbId=" + r101 + " currentBizSubSize=" + r102.f77313a.size() + " bizSize=" + this.f77306c.size());
        return true;
    L23:
        return false;
    L10:
        r104 = null;
        goto L12
    L18:
        return false;
    }
}
