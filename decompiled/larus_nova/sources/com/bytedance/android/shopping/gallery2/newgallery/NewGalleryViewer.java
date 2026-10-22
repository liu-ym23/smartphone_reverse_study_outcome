package com.bytedance.android.shopping.gallery2.newgallery;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.gallery2.IndexIndicator;
import com.bytedance.android.ec.core.gallery2.TitleIndicator;
import com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.CommentPagePhotoViewerDialog;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/newgallery/NewGalleryViewer;", "Lcom/bytedance/android/ec/core/photodraweeview/commentpagespecialuse/CommentPagePhotoViewerDialog;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NewGalleryViewer extends CommentPagePhotoViewerDialog implements TransitionListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f176169p = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IndexIndicator f176170n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NewGalleryAdapter f176171o;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGalleryViewer f176172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f176173b;

        public a(NewGalleryViewer r100, int r101) {
            this.f176172a = r100;
            this.f176173b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewGalleryViewer r100 = this.f176172a;     // Catch: Throwable -> L6
            int r101 = this.f176173b;     // Catch: Throwable -> L6
            int r102 = NewGalleryViewer.f176169p;     // Catch: Throwable -> L6
            TransitionViewHolder r103 = r100.f(r101);     // Catch: Throwable -> L6
            if (r103 == null) goto L9;
            this.f176172a.f176171o.B2(r103);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGalleryViewer f176174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f176175b;

        public b(NewGalleryViewer r100, int r101) {
            this.f176174a = r100;
            this.f176175b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewGalleryViewer r100 = this.f176174a;     // Catch: Throwable -> L6
            int r101 = this.f176175b;     // Catch: Throwable -> L6
            int r102 = NewGalleryViewer.f176169p;     // Catch: Throwable -> L6
            TransitionViewHolder r103 = r100.f(r101);     // Catch: Throwable -> L6
            if (r103 == null) goto L9;
            this.f176174a.f176171o.C2(r103);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
    }

    @Override // com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.CommentPagePhotoViewerDialog
    public void c(int r100) {
        TransitionViewHolder r101 = f(r100);
        if (r101 == null) goto L5;
        this.f176171o.C2(r101);
        return;
    L5:
        this.f45286a.post(new b(this, r100));
    }

    public final TransitionViewHolder f(int r100) {
        RecyclerView.ViewHolder r101 = this.f45286a.findViewHolderForAdapterPosition(r100);
        if ((r101 instanceof TransitionViewHolder) == true) goto L6;
        r101 = null;
    L6:
        return (TransitionViewHolder) r101;
    }

    @Override // com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.CommentPagePhotoViewerDialog
    public void onPageSelected(int r100) {
        TransitionViewHolder r101 = f(r100);
        if (r101 == null) goto L5;
        this.f176171o.B2(r101);
        return;
    L5:
        this.f45286a.post(new a(this, r100));
    }

    public NewGalleryViewer(Context r100, NewGalleryAdapter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "galleyAdapter");
        super(r100, r101);
        this.f176171o = r101;
        r101.addTransitionListener(this);
        IndexIndicator r102 = new IndexIndicator(r100, null, 6, 0);
        this.f176170n = r102;
        IIndicatorView r103 = new TitleIndicator(r100, null, 6, 0);
        b(r102);
        b(r103);
    }
}
