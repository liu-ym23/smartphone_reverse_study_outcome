package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class h implements com.bytedance.ies.sve_core.i {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f55524a;

        public a(int r100) {
            this.f55524a = r100;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f55525a;

        public b(float r100) {
            this.f55525a = r100;
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p0 f55526a;

        public c(p0 r100) {
            Intrinsics.checkNotNullParameter(r100, "outerRVScrollData");
            this.f55526a = r100;
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f55527a;

        @Override // com.bytedance.android.gamecp.business.gamedetail.page.root.h, com.bytedance.ies.sve_core.i
        public final boolean a() {
            return true;
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tabId");
            this.f55527a = r100;
        }
    }

    public h() {
    }

    @Override // com.bytedance.ies.sve_core.i
    public boolean a() {
        return false;
    }
}
