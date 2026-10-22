package com.bytedance.android.ec.core.gallery2;

import android.content.Context;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/GalleryViewer;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoViewerDialog;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GalleryViewer extends PhotoViewerDialog implements TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IndexIndicator f44053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TitleIndicator f44054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GalleryAdapter f44055c;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog
    public final void onPageSelected(int r100) {
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

    public GalleryViewer(Context r100) {
        GalleryAdapter r101 = new GalleryAdapter();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "galleyAdapter");
        super(r100, r101);
        this.f44055c = r101;
        r101.addTransitionListener(this);
        IndexIndicator r102 = new IndexIndicator(r100, null, 6, 0);
        this.f44053a = r102;
        TitleIndicator r103 = new TitleIndicator(r100, null, 6, 0);
        this.f44054b = r103;
        addIndicatorView(r102);
        addIndicatorView(r103);
    }

    public final void a(List<? extends l> r100) {
        Intrinsics.checkNotNullParameter(r100, "medias");
        this.f44055c.f44052a = r100;
        this.f44053a.setCount(((ArrayList) r100).size());
    }
}
