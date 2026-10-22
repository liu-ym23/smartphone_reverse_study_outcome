package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.view.View;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements OnPageSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentMediaView f164711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f164712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f164713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f164714d;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener
    public final void onPageSelected(int r100) {
        this.f164711a.f164651f.add(Integer.valueOf(r100));
    }

    public h(CommentMediaView r100, List r101, List r102, View r103) {
        this.f164711a = r100;
        this.f164712b = r101;
        this.f164713c = r102;
        this.f164714d = r103;
    }
}
