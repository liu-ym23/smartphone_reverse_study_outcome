package com.bytedance.android.live.base.model.user;

import android.os.Bundle;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public interface o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f58946a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0940a f58947a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f58948b = null;

        /* JADX INFO: renamed from: com.bytedance.android.live.base.model.user.o0$a$a, reason: collision with other inner class name */
        public static final class C0940a implements o0 {
            @Override // com.bytedance.android.live.base.model.user.o0
            public final long getAwemeUserId() {
                return 0;
            }

            @Override // com.bytedance.android.live.base.model.user.o0
            public final String getOpenUserId() {
                return "0";
            }

            @Override // com.bytedance.android.live.base.model.user.o0
            public final String getUserId() {
                return "0";
            }

            @Override // com.bytedance.android.live.base.model.user.o0
            public final boolean a() {
                return b.a(this);
            }

            public C0940a() {
            }
        }

        public a() {
        }

        static {
            f58948b = new a();
            f58947a = new C0940a();
        }

        @JvmStatic
        public static boolean b(String r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            return q0.a(r100);
        }

        @JvmStatic
        public static Object f(String r100) {
            if (q0.a(r100) == false) goto L8;
            if (r100 == null) goto L7;
            return r100;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        L8:
            return "0";
        }

        @JvmStatic
        public static List h(List r100) {
            if (r100 == null) goto L4;
            return r100;
        L4:
            return CollectionsKt.emptyList();
        }

        @JvmStatic
        public static String i(String r100) {
            Intrinsics.checkNotNullParameter("0", "defVal");
            if (r100 == null) goto L8;
            if (q0.a(r100) != true) goto L8;
            return r100;
        L8:
            return "0";
        }

        @JvmStatic
        public static boolean a(String r100, String r101) {
            if (r100 != null) goto L5;
        L10:
            if (r100 != null) goto L12;
        L13:
            if (r101 != null) goto L15;
            return true;
        L15:
            if (q0.a(r101) != true) goto L21;
        L17:
            return false;
        L21:
            return true;
        L12:
            if (q0.a(r100) == true) goto L17;
        L5:
            if (q0.a(r100) != true) goto L10;
            if (r101 == null) goto L10;
            if (q0.a(r101) != true) goto L10;
            return Intrinsics.areEqual(r100, r101);
        }

        @JvmStatic
        public static String g(Long r100, String r101) {
            if (r100 == null) goto L4;
            String.valueOf(r100.longValue());
        L4:
            if (r101 != null) goto L7;
            return "0";
        L7:
            return r101;
        }

        @JvmStatic
        public static String c(Bundle r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "defaultVal");
            if (r100 != null) goto L6;
            return r102;
        L6:
            if (r100.containsKey(r101) == true) goto L8;
            return r102;
        L8:
            String r103 = r100.getString(r101);
            if (r103 != null) goto L12;
            return r102;
        L12:
            return r103;
        }

        public static /* synthetic */ String d(a r100, Bundle r101, String r102) {
            r100.getClass();
            return c(r101, r102, "0");
        }

        public static String e(a r100, JSONObject r101, String r102) {
            r100.getClass();
            Intrinsics.checkNotNullParameter(r102, "key");
            Intrinsics.checkNotNullParameter("0", "defaultVal");
            if (r101 != null) goto L6;
            return "0";
        L6:
            if (r101.has(r102) == true) goto L9;
            return "0";
        L9:
            return r101.optString(r102, "0");
        }
    }

    public static final class b {
        public static boolean a(o0 r100) {
            o0.f58946a.getClass();
            if (Intrinsics.areEqual(r100, a.f58947a) == false) goto L5;
            return false;
        L5:
            String r101 = r100.getOpenUserId();
            if (r101 != null) goto L8;
            return false;
        L8:
            if (q0.a(r101) != true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static {
        f58946a = a.f58948b;
    }

    boolean a();

    long getAwemeUserId();

    String getOpenUserId();

    String getUserId();
}
