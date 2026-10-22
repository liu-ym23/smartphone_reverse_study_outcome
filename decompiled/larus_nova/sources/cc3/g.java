package cc3;

import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.android.shopping.commentgallery.view.CommentGalleryVideoVHNew;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentGalleryVideoVHNew f23234a;

    public g(CommentGalleryVideoVHNew r100) {
        this.f23234a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        CommentGalleryVideoVHNew r101 = this.f23234a;
        int r102 = CommentGalleryVideoVHNew.f172532p;
        r101.getClass();
        if (this.f23234a.f172535c.d() == false) goto L5;
        this.f23234a.play();
    L5:
        this.f23234a.f172536d.setVisibility(0);
        this.f23234a.f172537e.setVisibility(0);
        CommentGalleryVideoVHNew r103 = this.f23234a;
        if (r103.f172547o == false) goto L10;
        TextView r104 = r103.f172538f;
        if (r104 == null) goto L10;
        r104.setVisibility(0);
    L10:
        n r105 = this.f23234a.f172545m;
        if (r105 == null) goto L14;
        r105.a();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        if (r100 != null) goto L20;
    L7:
        TextView r101 = this.f23234a.f172536d;
        if (r100 == null) goto L10;
        String r102 = com.bytedance.android.shopping.utils.g.b(r100.getProgress() / 1000);
    L11:
        r101.setText(r102);
        this.f23234a.getClass();
        this.f23234a.f172536d.setVisibility(4);
        this.f23234a.f172537e.setVisibility(4);
        CommentGalleryVideoVHNew r103 = this.f23234a;
        if (r103.f172547o == false) goto L16;
        TextView r104 = r103.f172538f;
        if (r104 == null) goto L16;
        r104.setVisibility(4);
    L16:
        n r105 = this.f23234a.f172545m;
        if (r105 == null) goto L22;
        r105.b();
        return;
    L22:
        return;
    L10:
        r102 = null;
        goto L11
    L20:
        this.f23234a.f172535c.v((r100.getProgress() * 100) / r100.getMax());     // Catch: Exception -> L5
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L7
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        this.f23234a.f172539g.setProgress(r101);
        TextView r103 = this.f23234a.f172536d;
        int r104 = com.bytedance.android.shopping.utils.g.f187081a;
        r103.setText(com.bytedance.android.shopping.utils.g.b(r101 / 1000));
        return;
    }
}
