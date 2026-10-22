package com.bytedance.android.livesdk.livecommerce.event;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f147739a;

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2294a f147740a = null;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.event.k0$a$a, reason: collision with other inner class name */
        public class C2294a implements a {
            public C2294a() {
            }

            public final String a(String r100) {
                if (TextUtils.isEmpty(r100) == false) goto L5;
                return "";
            L5:
                if ("null".equals(r100) == true) goto L10;
                return r100;
            L10:
                return "";
            }
        }

        static {
            f147740a = new C2294a();
        }
    }

    public k0() {
        this.f147739a = new HashMap();
    }

    public final void d(Map r100) {
        if (r100 == null) goto L5;
        ((HashMap) this.f147739a).putAll(r100);
        return;
    }

    public final String f(String r100) {
        return (String) ((HashMap) this.f147739a).get(r100);
    }

    public final Boolean g(String r100) {
        return Boolean.valueOf(((HashMap) this.f147739a).containsKey(r100));
    }

    public final void a(String r100, int r101) {
        String r102 = String.valueOf(r101);
        a.C2294a r103 = a.f147740a;
        e(r100, r102);
    }

    public final void b(String r100, long r101) {
        String r102 = String.valueOf(r101);
        a.C2294a r103 = a.f147740a;
        e(r100, r102);
    }

    public final void c(String r100, String r101) {
        a.C2294a r102 = a.f147740a;
        e(r100, r101);
    }

    public final void e(String r100, String r101) {
        a.C2294a r102 = a.f147740a;
        if (TextUtils.isEmpty(r101) == true) goto L6;
        Map<String, String> r103 = this.f147739a;
        HashMap r104 = (HashMap) r103;
        r104.put(r100, r102.a(r101));
        return;
    }
}
