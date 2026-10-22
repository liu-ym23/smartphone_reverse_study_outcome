package com.bytedance.android.annie.websocket;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.annie.bridge.method.o2;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class SocketManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> f40101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<SocketManager> f40102b = null;

    public static final class a {
        public static SocketManager a() {
            return SocketManager.f40102b.getValue();
        }
    }

    public final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f40103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f40104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f40105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SocketManager f40106d;

        @Override // com.bytedance.android.annie.websocket.j
        public final void onClosed() {
            String r100 = this.f40104b;
            Intrinsics.checkNotNullParameter(PTYSocketStateCallback.CLOSED, "status");
            Intrinsics.checkNotNullParameter(r100, "socketTaskID");
            this.f40105c.a(new e(PTYSocketStateCallback.CLOSED, r100, "unknow error", null, null));
            SocketManager.a(this.f40106d, this.f40103a, this.f40104b);
        }

        @Override // com.bytedance.android.annie.websocket.j
        public final void onConnected() {
            String r100 = this.f40104b;
            Intrinsics.checkNotNullParameter(PTYSocketStateCallback.CONNECTED, "status");
            Intrinsics.checkNotNullParameter(r100, "socketTaskID");
            this.f40105c.a(new e(PTYSocketStateCallback.CONNECTED, r100, "unknow error", null, null));
        }

        @Override // com.bytedance.android.annie.websocket.j
        public final void onFailed(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            String r101 = this.f40104b;
            Intrinsics.checkNotNullParameter("failed", "status");
            Intrinsics.checkNotNullParameter(r101, "socketTaskID");
            d r102 = this.f40105c;
            Intrinsics.checkNotNullParameter(r100, "message");
            r102.a(new e("failed", r101, r100, null, null));
            SocketManager.a(this.f40106d, this.f40103a, this.f40104b);
        }

        @Override // com.bytedance.android.annie.websocket.j
        public final void onMessage(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
            String r101 = this.f40104b;
            Intrinsics.checkNotNullParameter("onMessaged", "status");
            Intrinsics.checkNotNullParameter(r101, "socketTaskID");
            String r102 = Base64.encodeToString(r100, 0);
            d r103 = this.f40105c;
            Intrinsics.checkNotNullParameter(TTVideoEngineInterface.PLAY_API_KEY_BASE64, "dataType");
            r103.a(new e("onMessaged", r101, "unknow error", r102, TTVideoEngineInterface.PLAY_API_KEY_BASE64));
        }

        @Override // com.bytedance.android.annie.websocket.j
        public final void onMessage(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            String r101 = this.f40104b;
            Intrinsics.checkNotNullParameter("onMessaged", "status");
            Intrinsics.checkNotNullParameter(r101, "socketTaskID");
            d r102 = this.f40105c;
            Intrinsics.checkNotNullParameter("string", "dataType");
            r102.a(new e("onMessaged", r101, "unknow error", r100, "string"));
        }

        public b(SocketManager r100, String r101, String r102, o2 r103) {
            Intrinsics.checkNotNullParameter(r101, "containerID");
            Intrinsics.checkNotNullParameter(r102, "socketTaskID");
            Intrinsics.checkNotNullParameter(r103, "callback");
            this.f40106d = r100;
            this.f40103a = r101;
            this.f40104b = r102;
            this.f40105c = r103;
        }
    }

    public SocketManager() {
    }

    static {
        f40101a = new HashMap();
        f40102b = LazyKt.lazy(SocketManager$Companion$instance$2.INSTANCE);
    }

    public static String b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "containerID");
        List r102 = c(r100, r101);
        if (r102 == null) goto L9;
        Iterator r103 = ((ArrayList) r102).iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        ((com.bytedance.android.annie.websocket.b) r103.next()).a();
        goto L6
    L8:
        Unit r104 = Unit.INSTANCE;
    L10:
        if (r104 != null) goto L16;
        if (r101 == null) goto L14;
        return "The socketTaskID doesn't exist";
    L14:
        return "The containerID doesn't exist";
    L16:
        return null;
    L9:
        r104 = null;
        goto L10
    }

    public static List c(String r100, String r101) {
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r102 = f40101a;
        monitor-enter(r102);
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L26
        if (r101 == null) goto L12;
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r104 = r102.get(r100);     // Catch: Throwable -> L26
        if (r104 == null) goto L10;
        com.bytedance.android.annie.websocket.b r105 = r104.get(r101);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.android.annie.websocket.IWebSocketTask");     // Catch: Throwable -> L26
        r103.add(r105);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r102);
        return r103;
    L10:
        monitor-exit(r102);
        return null;
    L12:
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r106 = r102.get(r100);     // Catch: Throwable -> L26
        if (r106 == null) goto L20;
        Iterator<? super com.bytedance.android.annie.websocket.b> r107 = r106.values().iterator();     // Catch: Throwable -> L26
    L16:
        if (r107.hasNext() == false) goto L18;
        com.bytedance.android.annie.websocket.b r108 = r107.next();     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.android.annie.websocket.IWebSocketTask");     // Catch: Throwable -> L26
        r103.add(r108);     // Catch: Throwable -> L26
        goto L16
    L18:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L21:
        if (r109 != null) goto L24;
        monitor-exit(r102);
        return null;
    L20:
        r109 = null;
    L26:
        th = move-exception;
        throw th;
    }

    public static final void a(SocketManager r100, String r101, String r102) {
        r100.getClass();
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r103 = f40101a;
        monitor-enter(r103);
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r104 = r103.get(r101);     // Catch: Throwable -> L18
        if (r104 == null) goto L7;
        r104.remove(r102);     // Catch: Throwable -> L18
    L7:
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r105 = r103.get(r101);     // Catch: Throwable -> L18
        if (r105 == null) goto L12;
        boolean r106 = true;
        if (r105.isEmpty() != true) goto L12;
    L13:
        if (r106 == false) goto L15;
        r103.remove(r101);     // Catch: Throwable -> L18
    L15:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r103);
        return;
    L12:
        r106 = false;
    L18:
        th = move-exception;
        throw th;
    }
}
