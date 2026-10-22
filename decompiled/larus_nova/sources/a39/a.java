package a39;

import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowHiddenReason;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1682a = null;

    static {
        f1682a = new a();
    }

    public a() {
    }

    public static void a(ContextWindowHiddenReason r100, ContextWindowEnterFrom r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        FLogger.f375446a.i("ContextWindowTracker", "entry hidden reason=" + r100.name() + " enterFrom=" + r101.getWireValue());
    }
}
