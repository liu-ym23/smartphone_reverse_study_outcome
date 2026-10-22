package com.bytedance.android.livesdk.vscore_api.paidlive;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f159461a;

    public static final class a extends l {
        public a() {
            super("Delivery");
        }
    }

    public static final class b extends l {
        public b() {
            super("Idle");
        }
    }

    public static final class c extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f159462b = null;

        static {
            f159462b = new c();
        }

        public c() {
            super("None");
        }
    }

    public static final class d extends l {
        public d() {
            super("Pause");
        }
    }

    public static final class e extends l {
        public e() {
            super("TempWatchEnd");
        }
    }

    public static final class f extends l {
        public f() {
            super("TempWatching");
        }
    }

    public static final class g extends l {
        public g() {
            super("Undelivery");
        }
    }

    public final boolean a() {
        if ((this instanceof g) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof a) == true) goto L8;
        return false;
    }

    public final String toString() {
        return this.f159461a;
    }

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f159461a = r100;
    }
}
