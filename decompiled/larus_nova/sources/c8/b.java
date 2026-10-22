package c8;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.lynx.bridge.AnnieLynxBridgeModule;
import com.bytedance.android.annie.lynx.f;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends com.bytedance.ies.web.jsbridge2.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Scheduler f22692u = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f22693n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentLinkedQueue<f> f22694o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f22695p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.annie.param.a f22696q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function0<String> f22697r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AnnieLynxBridgeModule f22698s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LynxView f22699t;

    public static final class a {
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void j(o r100) {
        Intrinsics.checkNotNullParameter(r100, "environment");
    }

    static {
        f22692u = Schedulers.single();
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final View g() {
        LynxView r100 = this.f22699t;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
        return null;
    L7:
        return r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final String h() {
        return this.f22697r.invoke();
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public Context getContext(o r100) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        return this.f22693n;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void k(String r100) {
        r(new JSONObject(r100));
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void l(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        r(r100);
    }

    public final void r(JSONObject r100) {
        Object r101 = r100.remove("__event_id");
        LynxView r102 = null;
        if ((r101 instanceof String) == false) goto L5;
        String r103 = (String) r101;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        Object r104 = r100.remove("__params");
        if (r104 == null) goto L18;
        JSONObject r105 = new JSONObject();
        r105.put("code", 1);
        r105.put("data", r104);
        WritableMap r106 = c8.a.d(r105);
        if (r106 == null) goto L19;
        LynxView r107 = this.f22699t;
        if (r107 == null) goto L15;
        r102 = r107;
    L16:
        r102.sendGlobalEvent(r103, JavaOnlyArray.of(new Object[]{r106}));
        return;
    L15:
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void m(String r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r101 != null) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject(r100);
        Iterator<T> r103 = this.f22694o.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((f) r103.next()).c(r102, r101);
        goto L7
    L9:
        AnnieLynxBridgeModule r104 = this.f22698s;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
        r104 = null;
    L13:
        r104.invokeCallback$annie_lynx_release(r102, r101);
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void n(JSONObject r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<T> r102 = this.f22694o.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((f) r102.next()).c(r100, r101);
        goto L7
    L9:
        AnnieLynxBridgeModule r103 = this.f22698s;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
        r103 = null;
    L13:
        r103.invokeCallback$annie_lynx_release(r100, r101);
    }

    public b(Context r100, ConcurrentLinkedQueue<f> r101, String r102, com.bytedance.android.annie.param.a r103, Function0<String> r104) {
        Intrinsics.checkNotNullParameter(r100, "androidContext");
        Intrinsics.checkNotNullParameter(r101, "lifecycleCallbacks");
        Intrinsics.checkNotNullParameter(r103, "annieContext");
        Intrinsics.checkNotNullParameter(r104, "url");
        this.f22693n = r100;
        this.f22694o = r101;
        this.f22695p = r102;
        this.f22696q = r103;
        this.f22697r = r104;
    }
}
