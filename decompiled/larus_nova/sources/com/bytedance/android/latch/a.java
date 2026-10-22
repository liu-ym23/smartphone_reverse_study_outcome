package com.bytedance.android.latch;

import com.lynx.jsbridge.LynxModule;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0925a f58211a = null;

    /* JADX INFO: renamed from: com.bytedance.android.latch.a$a, reason: collision with other inner class name */
    public static final class C0925a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0925a f58212a = null;

        static {
            f58212a = new C0925a();
        }

        public C0925a() {
        }
    }

    public interface b {
        Object a(String r100);

        Map<String, Object> getGlobalProps();
    }

    public interface c {
        Class<? extends LynxModule> a();

        String getName();

        Object getParams();
    }

    public interface d extends Disposable {
        List<c> a();
    }

    static {
        f58211a = C0925a.f58212a;
    }
}
