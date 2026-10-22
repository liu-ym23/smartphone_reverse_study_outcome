package com.bytedance.android.gamecp.business.gamedetail.base.track;

import bw.p;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f53497a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.base.track.a$a, reason: collision with other inner class name */
    public static final class C0880a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f53498a = 0;

        static {
        }
    }

    public static String a() {
        String r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getEventLiveType();
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return r100;
    L8:
        return com.bytedance.android.gamecp.host_api.a.b().getLiveService().getPreviewEventLiveType();
    L5:
        r101 = false;
        goto L6
    }

    public static String b() {
        p r100 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r100 == null) goto L7;
        hw.b r101 = r100.user();
        if (r101 == null) goto L7;
        String r102 = r101.getCurrentUserId();
    L9:
        return r102.toString();
    L7:
        r102 = null;
        goto L9
    }

    static {
    }
}
