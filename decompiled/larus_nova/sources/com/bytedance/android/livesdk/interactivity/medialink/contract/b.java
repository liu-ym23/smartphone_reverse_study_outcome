package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: classes9.dex */
public interface b {
    public static final a R0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f137984a = null;

        public a() {
        }

        static {
            f137984a = new a();
        }

        public static b a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(MediaLinkContext.class);
            if ((r100 instanceof MediaLinkContext) == true) goto L5;
            r100 = null;
        L5:
            MediaLinkContext r101 = (MediaLinkContext) r100;
            if (r101 == null) goto L11;
            j<b> r102 = r101.getLinkService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        R0 = a.f137984a;
    }

    hy.e Np();

    void jg(int r100, String r101, boolean r102);
}
