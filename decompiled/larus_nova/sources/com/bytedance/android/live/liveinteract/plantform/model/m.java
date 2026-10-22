package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: classes46.dex */
public interface m {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final a f77236q0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f77237a = null;

        public a() {
        }

        static {
            f77237a = new a();
        }

        public static String a(String r100) {
            if (r100 != null) goto L4;
            return "";
        L4:
            if (r100.length() > 6) goto L9;
            return r100;
        L9:
            return r100.subSequence(0, 5).toString() + "...";
        }
    }

    static {
        f77236q0 = a.f77237a;
    }
}
