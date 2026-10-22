package a6a;

import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.p.e;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.k;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.cert.manager.constants.EventConstant;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    public static class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f1971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f1972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f1973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f1974d;

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object... r100) {
            LynxEngineProxy r101 = (LynxEngineProxy) this.f1971a.get();
            if (r101 != null) goto L7;
            LLog.i("LynxLepusModule", "triggerLepusBridgeAsync failed, LynxEngine has been released.");
            return;
        L7:
            if (r100.length > 0) goto L9;
            return;
        L9:
            if (this.f1972b == true) goto L13;
            j7a.a r102 = j7a.a.f497652a;
            Object r103 = r100[0];
            r102.getClass();
            ByteBuffer r104 = j7a.a.b(r103);
            UIThreadUtils.runOnUiThreadImmediately(new k(r101, this.f1973c, this.f1974d, r104));
            return;
        }

        public a(WeakReference r100, boolean r101, int r102, String r103) {
            this.f1971a = r100;
            this.f1972b = r101;
            this.f1973c = r102;
            this.f1974d = r103;
        }
    }

    /* JADX INFO: renamed from: a6a.b$b, reason: collision with other inner class name */
    public static class C0020b implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f1975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f1977c;

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object... r100) {
            LynxEngineProxy r101 = (LynxEngineProxy) this.f1975a.get();
            if (r101 != null) goto L7;
            LLog.i("LynxLepusModule", "triggerLepusBridgeAsync failed, LynxEngine has been released.");
            return;
        L7:
            if (r100.length <= 0) goto L10;
            j7a.a r102 = j7a.a.f497652a;
            Object r103 = r100[0];
            r102.getClass();
            ByteBuffer r104 = j7a.a.b(r103);
            UIThreadUtils.runOnUiThreadImmediately(new k(r101, this.f1976b, this.f1977c, r104));
            return;
        }

        public C0020b(WeakReference r100, int r101, String r102) {
            this.f1975a = r100;
            this.f1976b = r101;
            this.f1977c = r102;
        }
    }

    public static void a(LynxModuleWrapper r110, LynxEngineProxy r111, ReadableMap r112, String r113) {
        ReadableMap r100 = r112.getMap("methodDetail", new JavaOnlyMap());
        r100.getString(EventConstant.Key.MODULE, null);
        String r101 = r100.getString(e.f25671s, null);
        boolean r102 = r112.getBoolean("fromPiper", false);
        String r103 = r112.getString("tasmEntryName", null);
        int r104 = r112.getInt("callbackId", -1);
        char r105 = 1;
        if (r113.equals(NotificationCompat.CATEGORY_CALL) == true) goto L9;
        if (r101 != null) goto L6;
    L8:
        boolean r106 = false;
    L31:
        Iterator<MethodDescriptor> r107 = r110.getMethodDescriptors().iterator();     // Catch: Exception -> L28
    L11:
        if (r107.hasNext() == false) goto L36;
        MethodDescriptor r114 = r107.next();     // Catch: Exception -> L28
        String r115 = r114.getName();     // Catch: Exception -> L28
        if (r115 == null) goto L27;
        if (r115.isEmpty() == true) goto L27;
        if (r115.equals(r113) == false) goto L27;
        WeakReference r116 = new WeakReference(r111);     // Catch: Exception -> L28
        if (r106 == false) goto L24;
        Method r117 = r114.getMethod();     // Catch: Exception -> L28
        LynxModule r118 = r110.getModule();     // Catch: Exception -> L28
        Object[] r119 = new Object[3];     // Catch: Exception -> L28
        r119[0] = r101;     // Catch: Exception -> L28
        r119[r105] = r100;     // Catch: Exception -> L28
        r119[2] = new a(r116, r102, r104, r103);     // Catch: Exception -> L28
        r117.invoke(r118, r119);     // Catch: Exception -> L28
        goto L27
    L24:
        if (r102 == false) goto L26;
        r114.getMethod().invoke(r110.getModule(), r100.getArray("param", new JavaOnlyArray()).asArrayList().toArray());     // Catch: Exception -> L28
        goto L27
    L26:
        r114.getMethod().invoke(r110.getModule(), new Object[]{r100, new C0020b(r116, r104, r103)});     // Catch: Exception -> L28
    L27:
        r105 = 1;
        goto L11
    L36:
        return;
    L28:
        e = move-exception;
        LLog.e("LynxLepusModule", "Lepus Module invokeAsync: " + e.toString());
        return;
    L6:
        if (r101.length() == 0) goto L8;
    L9:
        r106 = true;
        goto L31
    }
}
