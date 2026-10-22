package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class h0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0.a f116313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0.f f116314b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h0 f116315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f116316b;

        public a(h0 r100, String r101) {
            this.f116315a = r100;
            this.f116316b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h0 r100 = this.f116315a;     // Catch: Throwable -> L4
            r100.f116313a.f116333b = true;     // Catch: Throwable -> L4
            r100.f116314b.onFinish();     // Catch: Throwable -> L4
            i0.f116328e.getClass();     // Catch: Throwable -> L4
            List<String> r101 = i0.f116327d;     // Catch: Throwable -> L4
            ArrayList r102 = (ArrayList) r101;     // Catch: Throwable -> L4
            r102.add(this.f116316b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h0(i0.a r100, i0.g r101) {
        this.f116313a = r100;
        this.f116314b = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "path");
        String r102 = FileUtils.readFromFile(new PolarisFileWrapper(r101));
        i0.a r103 = this.f116313a;     // Catch: Throwable -> L5
        r103.f116334c = new JSONObject(r102);     // Catch: Throwable -> L5
        com.bytedance.android.live.core.utils.i0.c().post(new a(this, r101));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ALogger.e("LiveAnchorMusicEffect", th);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a
    public final void onFail(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f116313a.f116333b = true;
        this.f116314b.onFinish();
    }
}
