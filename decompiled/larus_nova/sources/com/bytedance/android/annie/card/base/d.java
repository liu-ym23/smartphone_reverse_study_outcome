package com.bytedance.android.annie.card.base;

import android.os.AsyncTask;
import com.bytedance.android.annie.service.resource.h;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public interface d {

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.annie.card.base.d$a$a, reason: collision with other inner class name */
        public static final class RunnableC0732a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f39135a;

            public RunnableC0732a(d r100) {
                this.f39135a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator<T> r100 = this.f39135a.a().values().iterator();     // Catch: Throwable -> L7
            L4:
                if (r100.hasNext() == false) goto L16;
                ((h) r100.next()).a();     // Catch: Throwable -> L7
                goto L4
            L16:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public static void a(d r100) {
            if (AnnieConfigSettingKeys.CANCEL_CDN_PENDING_REQUEST.a().booleanValue() == false) goto L5;
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new RunnableC0732a(r100));
        L5:
            r100.a().clear();
        }
    }

    ConcurrentHashMap<String, h> a();
}
