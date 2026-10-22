package c65;

import com.bytedance.ee.bear.drive.biz.preview.error.password.DriveFileEncryptedView;
import com.larus.nova.R;
import h95.b;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveFileEncryptedView f22593a;

    @Override // h95.b
    public final void a() {
        this.f22593a.f223345a.setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
        this.f22593a.f223345a.getImageView().requestLayout();
        this.f22593a.f223345a.setTitleTextAppearance(R.style.UDText_Headline);
        DriveFileEncryptedView r100 = this.f22593a;
        r100.f223345a.showPrimaryAction(r100.f223346b);
    }

    @Override // h95.b
    public final void b() {
        this.f22593a.f223345a.setImageSizeResource(R.dimen.ccm_emptystate_image_size_small);
        this.f22593a.f223345a.getImageView().requestLayout();
        this.f22593a.f223345a.setTitleTextAppearance(R.style.UDText_Body1);
        this.f22593a.f223345a.showPrimaryAction(false);
    }

    public a(DriveFileEncryptedView r100) {
        this.f22593a = r100;
    }
}
