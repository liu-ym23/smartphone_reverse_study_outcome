package com.bytedance.android.gamecp.business.gallery.transfer;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.gamecp.business.gallery.view.image.TransferImage;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends g {

    public class a implements vs.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ys.a f53240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f53241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TransferImage f53242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f53243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f53244e;

        public final void a(int r100) {
            if (r100 != 0) goto L4;
            this.f53242c.setImageDrawable(this.f53243d.b());
            return;
        L4:
            if (r100 != 1) goto L16;
            ys.a r101 = this.f53240a;
            int r102 = this.f53241b;
            View r103 = r101.f568984a.get(r102);
            if (r103 == null) goto L12;
            r103.setVisibility(8);
            ViewGroup r104 = (ViewGroup) r103.getParent();
            if (r104 == null) goto L12;
            r104.removeView(r103);
        L12:
            TransferImage r105 = this.f53242c;
            r105.f53311r = true;
            e r106 = this.f53244e.f53286a;
            int r107 = this.f53241b;
            r106.getClass();
            r105.setOnClickListener(new f(r106, r107));
            return;
        }

        public a(c r100, ys.a r101, int r102, TransferImage r103, d r104) {
            this.f53244e = r100;
            this.f53240a = r101;
            this.f53241b = r102;
            this.f53242c = r103;
            this.f53243d = r104;
        }
    }

    public c(e r100) {
        super(r100);
    }

    public final void c(Drawable r110, int r111, TransferImage r112, ys.a r113) {
        d r100 = this.f53286a.getTransConfig();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.a() != null) goto L7;
        return;
    L7:
        if (r100.f53252h == null) goto L12;
        vs.e r101 = r100.a();
        String r102 = (String) ListProtector.get(r100.f53252h, r111);
        a r114 = new a(this, r113, r111, r112, r100);
        vs.d r115 = (vs.d) r101;
        r115.getClass();
        ImagePipeline r103 = Fresco.getImagePipeline();
        ImageRequest r104 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r102)).build();
        DataSource<CloseableReference<CloseableImage>> r116 = r103.fetchDecodedImage(r104, null);
        r112.setController(Fresco.newDraweeControllerBuilder().setImageRequest(r104).setOldController(r112.getController()).setControllerListener(new vs.b(r115, r114, r116, r112, r110)).build());
        return;
    }
}
