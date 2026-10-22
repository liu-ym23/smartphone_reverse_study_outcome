package b96;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f18315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f18316b;

    static {
        f18315a = new AtomicInteger(1);
        f18316b = "";
    }

    public static void a(List r100, com.bytedance.iesgurd.j r101) {
        GeckoLogger.d("UpdateQueue add: " + r100.size() + '-' + r101.f250718k.ordinal());
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        PrepareMeta r103 = (PrepareMeta) r102.next();
        if (r103.getTimeAddQueue() != 0) goto L8;
        r103.setTimeAddQueue(System.currentTimeMillis());
    L8:
        int r104 = ((3 - r101.f250718k.ordinal()) * 10000000) + f18315a.getAndIncrement();
        r103.getReqType();
        r103.getAccessKey();
        r103.getGroupName();
        r103.getChannel();
        ((zy5.a) GeckoExecutors.f250870c.getValue()).execute(new h(r103, r104, r101, r104));
        goto L4
    }

    public static boolean b(String r100, String r101) {
        return Intrinsics.areEqual(f18316b, r100 + '_' + r101);
    }
}
