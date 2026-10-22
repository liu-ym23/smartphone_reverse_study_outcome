package ak;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.bytedance.android.ec.hybrid.data.entity.ECPreloadConfigItemV3;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.common.utility.Logger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0075a f3975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ECPreloadConfigItemV3, Integer> f3976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECHybridListAdapter f3977e;

    /* JADX INFO: renamed from: ak.a$a, reason: collision with other inner class name */
    public static final class C0075a implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a> f3978a;

        /* JADX INFO: renamed from: ak.a$a$a, reason: collision with other inner class name */
        public static final class C0076a {
        }

        static {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            a r100 = this.f3978a.get();
            if (r100 == null) goto L17;
            Iterator r101 = ((LinkedHashMap) r100.f3976d).entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L17;
            Map.Entry r102 = (Map.Entry) r101.next();
            if (((ECPreloadConfigItemV3) r102.getKey()).getItemType() == null) goto L6;
            Integer r103 = ((ECPreloadConfigItemV3) r102.getKey()).getPreloadNum();
            if (r103 == null) goto L13;
            int r104 = r103.intValue();
        L15:
            if (RangesKt.coerceAtMost(r104, 4) <= ((Number) r102.getValue()).intValue()) goto L6;
            ECPreloadConfigItemV3 r105 = (ECPreloadConfigItemV3) r102.getKey();
        L19:
            if (r105 != null) goto L31;
            a r106 = this.f3978a.get();
            if (r106 == null) goto L27;
            if (Logger.debug() == false) goto L25;
            Logger.d("CardPreload_ECHLIdleHandler", "stop ");
        L25:
            Looper.myQueue().removeIdleHandler(r106.f3975c);
            r106.f3974b = false;
        L27:
            if (Logger.debug() == false) goto L29;
            Logger.d("CardPreload_ECHLIdleHandler", "queueIdle ecPreloadConfig is null stop");
        L29:
            return true;
        L31:
            if (Logger.debug() == false) goto L33;
            Logger.d("CardPreload_ECHLIdleHandler", "idle consume task: config = [" + r105.toString() + "][itemType = " + r105.getItemType() + "] }");
        L33:
            long r107 = SystemClock.uptimeMillis();
            a r108 = this.f3978a.get();
            if (r108 == null) goto L41;
            if (r108.f3977e.F2(r105.getSchema(), r105.getItemType(), r105, r108.a()) != true) goto L41;
            a r109 = this.f3978a.get();
            if (r109 == null) goto L41;
            Integer r110 = r105.getItemType();
            Intrinsics.checkNotNull(r110);
            r109.b(r110.intValue());
        L41:
            if (Logger.debug() == false) goto L43;
            StringBuilder r111 = new StringBuilder("idle consume task: [itemType = ");
            Integer r112 = r105.getItemType();
            Intrinsics.checkNotNull(r112);
            r111.append(r112.intValue());
            r111.append("] with time:");
            r111.append(SystemClock.uptimeMillis() - r107);
            Logger.d("CardPreload_ECHLIdleHandler", r111.toString());
        L43:
            return true;
        L13:
            r104 = 0;
        L17:
            r105 = null;
            goto L19
        }

        public C0075a(a r100) {
            Intrinsics.checkNotNullParameter(r100, "preloadManager");
            this.f3978a = new WeakReference(r100);
        }
    }

    public abstract ECHybridRecyclerView a();

    public a(ECHybridListAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "ecHybridAdapter");
        this.f3977e = r100;
        this.f3973a = "CardPreload_CardPreloadManager";
        this.f3975c = new C0075a(this);
        this.f3976d = new LinkedHashMap();
    }

    public final void b(int r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d(this.f3973a, "onItemLoad itemType = " + r100);
    L5:
        Iterator r101 = ((LinkedHashMap) this.f3976d).keySet().iterator();
    L6:
        int r102 = 0;
        if (r101.hasNext() == false) goto L17;
        Object r103 = r101.next();
        Integer r104 = ((ECPreloadConfigItemV3) r103).getItemType();
        if (r104 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L6;
    L18:
        ECPreloadConfigItemV3 r106 = (ECPreloadConfigItemV3) r103;
        if (r106 == null) goto L30;
        Map<ECPreloadConfigItemV3, Integer> r107 = this.f3976d;
        Integer r108 = (Integer) ((LinkedHashMap) r107).get(r106);
        if (r108 == null) goto L23;
        r102 = r108.intValue();
    L23:
        r107.put(r106, Integer.valueOf(r102 + 1));
        return;
    L30:
        return;
    L12:
        if (r104.intValue() != r100) goto L14;
        r105 = true;
        goto L15
    L17:
        r103 = null;
        goto L18
    }
}
