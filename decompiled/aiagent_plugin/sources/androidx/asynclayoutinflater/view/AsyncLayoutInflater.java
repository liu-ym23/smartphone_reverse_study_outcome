package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.f;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ArrayBlockingQueue;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LayoutInflater f508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Handler f509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b f510c;

    /* JADX INFO: renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$1, reason: invalid class name */
    class AnonymousClass1 implements Handler.Callback {
        final /* synthetic */ AsyncLayoutInflater this$0;

        AnonymousClass1(AsyncLayoutInflater r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r6) {
            a r7 = (a) ZeusTransformUtils.preCheckCast(r6.obj, a.class, "com.obric.aiagent.plugin");
            if (r7.f514d != null) goto L5;
            r7.f514d = ZeusTransformUtils.inflate(this.this$0.f508a, r7.f513c, r7.f512b, false, "com.obric.aiagent.plugin");
        L5:
            r7.f515e.a(r7.f514d, r7.f513c, r7.f512b);
            this.this$0.f510c.a(r7);
            return true;
        }
    }

    private static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = null;

        static {
            sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        BasicInflater(Context r3) {
            super(ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin"));
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context r2) {
            return new BasicInflater((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String r5, AttributeSet r6) {
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
            String[] r0 = sClassPrefixList;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            View r3 = createView(r5, r0[r2], r7);     // Catch: ClassNotFoundException -> L11
            if (r3 == null) goto L8;
            return r3;
        L8:
            r2 = r2 + 1;
            goto L3
        L10:
            return super.onCreateView(r5, r7);
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AsyncLayoutInflater f511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f513c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        View f514d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c f515e;

        a() {
        }
    }

    private static class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f516a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayBlockingQueue<a> f517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f.c<a> f518c;

        private b() {
            this.f517b = new ArrayBlockingQueue(10);
            this.f518c = new f.c(10);
        }

        static {
            b r0 = new b();
            f516a = r0;
            r0.start();
        }

        public void a() {
            a r6 = (a) ZeusTransformUtils.preCheckCast(this.f517b.take(), a.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L11
            r6.f514d = ZeusTransformUtils.inflate(r6.f511a.f508a, r6.f513c, r6.f512b, false, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L7
        L9:
            Message.obtain(r6.f511a.f509b, 0, r6).sendToTarget();
            return;
        L7:
            e = move-exception;
            a(AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e);
        L11:
            e = move-exception;
            a(AsyncLayoutInflater.TAG, e);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            a();
            goto L2
        }

        public void a(a r3) {
            r3.f515e = null;
            r3.f511a = null;
            r3.f512b = null;
            r3.f513c = 0;
            r3.f514d = null;
            this.f518c.a(r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, Throwable r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }
    }

    public interface c {
        void a(View r1, int r2, ViewGroup r3);
    }
}
