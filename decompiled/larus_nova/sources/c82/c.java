package c82;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.depend.im.ILiveIMCusSerMsgProxy;
import com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ILiveIMCusSerMsgProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, WeakReference<b>> f22706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f22707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f22708c = null;

    public c() {
    }

    static {
        f22708c = new c();
        f22706a = new HashMap();
    }

    public static String a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        String r101 = String.valueOf(f22707b);
        ((HashMap) f22706a).put(r101, new WeakReference(r100));
        f22707b++;
        return r101;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.im.ILiveIMCusSerMsgProxy
    public final ILiveIMDynamicView getIMDynamicView(Activity r100, Function2<? super Integer, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new a(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.im.ILiveIMCusSerMsgProxy
    public final void onUnreadCountChanged(long r100, int r101) {
        Iterator r102 = ((HashMap) f22706a).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        b r103 = (b) ((WeakReference) ((Map.Entry) r102.next()).getValue()).get();
        if (r103 == null) goto L4;
        r103.a(r100, r101);
        goto L4
    }
}
