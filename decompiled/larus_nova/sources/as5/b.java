package as5;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f16129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, tr5.a> f16130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pxb.a f16131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ur5.a f16132d;

    public b(ur5.a r100) {
        this.f16129a = new ArrayList();
        this.f16130b = new HashMap();
        this.f16132d = r100;
        this.f16131c = r100.f551380b;
    }

    public final void a(AbstractNativeComponent r100) {
        String r101 = r100.getViewId();
        Log.d("NativeComponentManager", "add nativeBaseComponent, viewId = " + r101);
        if (this.f16130b.containsKey(r101) == false) goto L8;
        Log.e("NativeComponentManager", "viewId already added, viewId = " + r101);
        Iterator<a> r102 = this.f16129a.iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        r102.next().c(r100);
    L12:
        b(this.f16131c, r100.getViewId(), r100.getContainer());
        return;
    L8:
        this.f16130b.put(r101, r100);
        Iterator<a> r103 = this.f16129a.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        r103.next().c(r100);
        goto L10
    }

    public void update(tr5.a r100) {
        Iterator<a> r101 = this.f16129a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().b(r100);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(pxb.a r100, String r101, View r102) {
        Log.i("NativeComponentManager", "registerPlatformView, viewId = " + r101);
        if (r100 != null) goto L6;
        Log.e("NativeComponentManager", "registerPlatformView err, webView is null");
        return;
    L6:
        if (r102 != 0) goto L8;
    L22:
        Log.e("NativeComponentManager", "registerPlatformView err, view or viewId is null");
        return;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        if ((r102 instanceof cs5.a) == true) goto L14;
        Log.e("NativeComponentManager", "registerPlatformView err, invalid view");
        return;
    L14:
        xr5.a r103 = new xr5.a(r101, (cs5.a) r102);
        txb.b r104 = r100.getServiceManager();
        if (r104 == null) goto L17;
        txb.a r105 = (txb.a) r104.getService(txb.a.class);
    L18:
        if (r105 == null) goto L20;
        r105.j(r103);
        return;
    L20:
        Log.e("NativeComponentManager", "registerPlatformView err, renderInWebViewService is null");
        return;
    L17:
        r105 = null;
        goto L18
    }
}
