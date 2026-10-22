package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.livesdk.log.filter.v;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<a> f123234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f123235b = null;

    public interface a {
        void a(String r100, Map<String, Object> r101);
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f123236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f123237b;

        public b(String r100, Map r101) {
            this.f123236a = r100;
            this.f123237b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = ((ArrayList) f.f123234a).iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((a) r100.next()).a(this.f123236a, this.f123237b);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public f() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f123235b = new f();
        f123234a = new ArrayList();
    }

    public static void a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventKey");
        Intrinsics.checkNotNullParameter(r101, "eventParams");
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("event_info.name", r100)});
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getValue();
        if (r105 == null) goto L4;
        r102.put(r104.getKey(), r105);
        goto L4
    L8:
        AndroidSchedulers.mainThread().scheduleDirect(new b(r100, r102));
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        a(r100, r101);
    }
}
