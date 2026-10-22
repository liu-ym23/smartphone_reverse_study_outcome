package com.bytedance.android.gamecp.business.gamedetail.component.bottombar;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a implements com.bytedance.ies.sve_core.a {

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.component.bottombar.a$a, reason: collision with other inner class name */
    public static final class C0882a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f53831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f53832b;

        public C0882a(boolean r100) {
            Intrinsics.checkNotNullParameter("fast_evaluate", "componentClazz");
            this.f53831a = "fast_evaluate";
            this.f53832b = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f53833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f53834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f53835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f53836d;

        public b(boolean r100, String r101, JSONObject r102, boolean r103) {
            this.f53833a = r100;
            this.f53834b = r101;
            this.f53835c = r102;
            this.f53836d = r103;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f53837a;

        public c(int r100) {
            this.f53837a = r100;
        }
    }

    public a() {
    }
}
