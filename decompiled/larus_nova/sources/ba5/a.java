package ba5;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.loader.PDFPageModel;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements DataFetcher<PagePart> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PDFPageModel f18416a;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<PagePart> getDataClass() {
        return PagePart.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public a(PDFPageModel r100) {
        this.f18416a = r100;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority r100, DataFetcher.DataCallback<? super PagePart> r110) {
        tt5.a.h("PDFPageDataFetcher", "loadData, page: " + this.f18416a.getPage() + ", thread: " + ThreadMethodProxy.currentThread());     // Catch: Exception -> L5
        r110.onDataReady(this.f18416a.getPdfReader().loadPageSync(this.f18416a.getPage(), ((float) this.f18416a.getWidth()) * 1.0f, ((float) this.f18416a.getHeight()) * 1.0f, this.f18416a.getBounds(), this.f18416a.getBestQuality(), this.f18416a.getAnnotationRendering()));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("PDFPageDataFetcher", "loadPageSync err. ", e, false);
        r110.onLoadFailed(e);
    }
}
