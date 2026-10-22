package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: classes46.dex */
public interface e {

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final a f82254y0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f82255a = null;

        public a() {
        }

        static {
            f82255a = new a();
        }

        public static e a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(PkAudienceInternalServiceContext.TAG);
            if ((r100 instanceof PkAudienceInternalServiceContext) == true) goto L5;
            r100 = null;
        L5:
            PkAudienceInternalServiceContext r101 = (PkAudienceInternalServiceContext) r100;
            if (r101 == null) goto L11;
            j<e> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        f82254y0 = a.f82255a;
    }

    String Wc();

    boolean getSelfHasAudienceBeforePk();

    boolean handleInteractClick();

    void hideInteractDialog();

    g ml();

    void tryLoadPkAudienceWidget();

    void tryUnLoadPkAudienceWidget();

    void unLoadOtherWidget(int r100);
}
