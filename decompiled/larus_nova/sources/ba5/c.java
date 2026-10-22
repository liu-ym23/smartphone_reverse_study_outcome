package ba5;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.loader.PDFPageModel;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements ModelLoader<PDFPageModel, PagePart> {

    public static class a implements ModelLoaderFactory<PDFPageModel, PagePart> {
        public a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<PDFPageModel, PagePart> build(MultiModelLoaderFactory r100) {
            return new c();
        }
    }

    public c() {
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean handles(PDFPageModel r100) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData<PagePart> buildLoadData(PDFPageModel r100, int r101, int r102, Options r103) {
        PDFPageModel r104 = r100;
        return new ModelLoader.LoadData(r104, new ba5.a(r104));
    }
}
