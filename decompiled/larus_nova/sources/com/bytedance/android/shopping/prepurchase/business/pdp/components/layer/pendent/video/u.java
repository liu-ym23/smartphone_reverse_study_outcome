package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public interface u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f181574a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2700a f181575a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f181576b = null;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u$a$a, reason: collision with other inner class name */
        public static final class C2700a implements u {
            public C2700a() {
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void a() {
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void onClose(boolean r100) {
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void onShow() {
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void b(l r100) {
                Intrinsics.checkNotNullParameter(r100, "other");
                Intrinsics.checkNotNullParameter(r100, "other");
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void c(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r100) {
                Intrinsics.checkNotNullParameter(r100, "floatVideo");
                Intrinsics.checkNotNullParameter(r100, "floatVideo");
            }
        }

        public a() {
        }

        static {
            f181576b = new a();
            f181575a = new C2700a();
        }
    }

    static {
        f181574a = a.f181576b;
    }

    void a();

    void b(l r100);

    void c(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r100);

    void onClose(boolean r100);

    void onShow();
}
