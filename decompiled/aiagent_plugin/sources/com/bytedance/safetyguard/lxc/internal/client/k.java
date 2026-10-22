package com.bytedance.safetyguard.lxc.internal.client;

import android.os.ParcelFileDescriptor;
import com.bytedance.apm.battery.dao.DBHelper;
import java.io.IOException;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public interface k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10004a = null;

    /* JADX INFO: compiled from: ProxyServiceConnector.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f10005a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final k f10006b = null;

        public static /* synthetic */ ParcelFileDescriptor lambda$nw46EiUjhjbmn9y4pzLNXlErZpE(ParcelFileDescriptor r0) {
            return a(r0);
        }

        private a() {
        }

        static {
            f10005a = new a();
            f10006b = $$Lambda$k$a$nw46EiUjhjbmn9y4pzLNXlErZpE.INSTANCE;
        }

        public final k a() {
            return f10006b;
        }

        private static final ParcelFileDescriptor a(ParcelFileDescriptor r1) {
            d.h.b.o.e(r1, DBHelper.BATTERY_COL_SOURCE);
            if (r1.getFileDescriptor().valid() == false) goto L7;
            ParcelFileDescriptor r2 = ParcelFileDescriptor.dup(r1.getFileDescriptor());
            d.h.b.o.c(r2, "dup(...)");
            return r2;
        L7:
            throw new IOException("proxy file descriptor is closed");
        }
    }

    static {
        f10004a = a.f10005a;
    }

    ParcelFileDescriptor dup(ParcelFileDescriptor r1);
}
