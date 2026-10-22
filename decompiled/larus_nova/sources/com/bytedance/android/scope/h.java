package com.bytedance.android.scope;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f163439a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<Long> f163440a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b<String> f163441b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b<j> f163442c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b<e33.l> f163443d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a f163444e = null;

        public a() {
        }

        static {
            f163444e = new a();
            f163440a = new b(CrashHianalyticsData.THREAD_ID);
            f163441b = new b("thread_name");
            f163442c = new b("scope");
            f163443d = new b("service_desc");
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f163445a;

        public final String toString() {
            return this.f163445a;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f163445a = r100;
        }
    }

    static {
        f163439a = a.f163444e;
    }
}
