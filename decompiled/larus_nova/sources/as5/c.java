package as5;

import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Class> f16133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f16134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Constructor> f16135c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Class> f16137b;

        public a() {
            this.f16137b = new ConcurrentHashMap();
        }

        public final void a(Class r100) {
            Log.i("NativeComponentTypeProviderImpl", "webView register component:" + r100.getCanonicalName());
            if (this.f16137b != null) goto L6;
            this.f16137b = new ConcurrentHashMap();
        L6:
            if (((ConcurrentHashMap) this.f16137b).containsKey("drive_file_block") == true) goto L8;
            ((ConcurrentHashMap) this.f16137b).put("drive_file_block", r100);
            return;
        L8:
            Log.w("NativeComponentTypeProviderImpl", "component: " + r100.getCanonicalName() + " already register");
        }
    }

    public c() {
        this.f16133a = new ConcurrentHashMap();
        this.f16134b = new CopyOnWriteArrayList();
        this.f16135c = new ConcurrentHashMap();
    }

    public final <T extends AbstractNativeComponent> Class<T> b(pxb.a r100, String r101) {
        int r102 = r100.hashCode();
        Iterator r103 = ((CopyOnWriteArrayList) this.f16134b).iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        a r104 = (a) r103.next();
        if (r104.f16136a != r102) goto L4;
        Map<String, Class> r105 = r104.f16137b;
        if (r105 == null) goto L13;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        if (r106.containsKey(r101) == false) goto L13;
        return (Class) r106.get(r101);
    L13:
        Log.e("NativeComponentTypeProviderImpl", "getComponentClassOnWebView, find viewType without class, viewType = " + r101);
        return null;
    L15:
        Log.e("NativeComponentTypeProviderImpl", "getComponentClassOnWebView, find no viewType = " + r101);
        return null;
    }

    public final <T extends AbstractNativeComponent> T a(ur5.a r110, String r111, String r112) {
        Log.d("NativeComponentTypeProviderImpl", "create native component, id = " + r111 + " viewType = " + r112);
        Iterator r100 = ((CopyOnWriteArrayList) this.f16134b).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Map<String, Class> r101 = ((a) r100.next()).f16137b;
        if (r101 == null) goto L4;
        if (r101.containsKey(r112) == false) goto L4;
        Class r102 = r101.get(r112);
    L11:
        if (r102 == null) goto L13;
    L26:
    L23:
        e = move-exception;
        Log.e("NativeComponentTypeProviderImpl", "create component failed, view Type = " + r112 + " err: ", e);
        return null;
    L18:
        if (((ConcurrentHashMap) this.f16135c).containsKey(r112) == false) goto L20;
        Constructor r103 = (Constructor) ((ConcurrentHashMap) this.f16135c).get(r112);     // Catch: Exception -> L23
    L21:
        return (T) r103.newInstance(new Object[]{r110, r111, r112});
    L20:
        r103 = r102.getDeclaredConstructor(new Class[]{ur5.a.class, String.class, String.class});     // Catch: Exception -> L23
        r103.setAccessible(true);     // Catch: Exception -> L23
        ((ConcurrentHashMap) this.f16135c).put(r112, r103);     // Catch: Exception -> L23
        goto L21
    L13:
        if (((ConcurrentHashMap) this.f16133a).containsKey(r112) == true) goto L16;
        Log.e("NativeComponentTypeProviderImpl", "component has not registered, viewType = " + r112);
        return null;
    L16:
        r102 = (Class) ((ConcurrentHashMap) this.f16133a).get(r112);
        goto L26
    L10:
        r102 = null;
        goto L11
    }
}
