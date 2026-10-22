package com.bytedance.android.gamecp.business;

import android.text.TextUtils;
import com.bytedance.android.gamecp.business.download.e1;
import com.bytedance.android.gamecp.business.download.y0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c0 implements wr.b<String> {

    public static final class a implements e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f51768a;

        @Override // com.bytedance.android.gamecp.business.download.e1
        public final void a(JSONObject r100) {
        }

        public a(String r100) {
            this.f51768a = r100;
        }

        @Override // com.bytedance.android.gamecp.business.download.e1
        public final void b(List<com.bytedance.android.gamecp.business.download.p> r100) {
            Intrinsics.checkNotNullParameter(r100, "downloadList");
            Iterator<com.bytedance.android.gamecp.business.download.p> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L23;
            com.bytedance.android.gamecp.business.download.p r102 = r101.next();
            if (Intrinsics.areEqual(this.f51768a, r102.f52855k) == false) goto L4;
            if (com.bytedance.android.gamecp.business.gamedetail.k.b(r102.f52860m0) == true) goto L4;
            mw.a r103 = (mw.a) xr.s.a(mw.a.class);
            if (r103 == null) goto L22;
            String r104 = this.f51768a;
            if (r104 != null) goto L14;
            r104 = "";
        L14:
            r103.showInstallIntroCard("", r104, false);
            return;
        L22:
            return;
        }
    }

    public c0() {
    }

    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        y0 r101 = y0.f52963a;
        y0.d(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext(), "download_finished", new a(r100));
        return;
    }

    @Override // wr.b
    public final /* bridge */ /* synthetic */ void onResult(String r100) {
        a(r100);
    }
}
