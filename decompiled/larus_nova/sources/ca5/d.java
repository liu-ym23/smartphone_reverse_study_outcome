package ca5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements tk5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f22948a;

    public d(c r100) {
        this.f22948a = r100;
    }

    @Override // tk5.c
    public final void a(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        tt5.a.h("DrivePdfCommentOnboardMission", "confirm");
        sk5.c r101 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.f22948a.getClass();
        r101.c("ccm_mobile_drive_pdf_area_box_comment_intro");
    }

    @Override // tk5.c
    public final void b(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        tt5.a.h("DrivePdfCommentOnboardMission", "dismiss");
        sk5.c r101 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.f22948a.getClass();
        r101.c("ccm_mobile_drive_pdf_area_box_comment_intro");
    }

    @Override // tk5.c
    public final void c(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        tt5.a.h("DrivePdfCommentOnboardMission", "cancel");
        sk5.c r101 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.f22948a.getClass();
        r101.c("ccm_mobile_drive_pdf_area_box_comment_intro");
    }
}
