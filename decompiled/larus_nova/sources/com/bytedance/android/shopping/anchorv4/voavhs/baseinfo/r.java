package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.widget.TextView;
import androidx.collection.LruCache;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import io.reactivex.functions.Action;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class r implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InlineLongTitleComponentView f167976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f167977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IconsWithSpaceElement f167978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f167979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TextElement f167980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TextView f167981f;

    public r(InlineLongTitleComponentView r100, List r101, IconsWithSpaceElement r102, List r103, TextElement r104, InlineLongTitleComponentView r105) {
        this.f167976a = r100;
        this.f167977b = r101;
        this.f167978c = r102;
        this.f167979d = r103;
        this.f167980e = r104;
        this.f167981f = r105;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        InlineLongTitleComponentView r100 = this.f167976a;
        List<h> r101 = this.f167977b;
        IconsWithSpaceElement r102 = this.f167978c;
        if (r102 == null) goto L5;
        int r103 = r102.getSpace();
    L6:
        List<h> r104 = this.f167979d;
        IconsWithSpaceElement r105 = this.f167978c;
        if (r105 == null) goto L9;
        int r106 = r105.getSpace();
    L10:
        TextElement r107 = this.f167980e;
        TextView r108 = this.f167981f;
        LruCache<String, h> r109 = InlineLongTitleComponentView.f167943d;
        r100.z(r101, r103, r104, r106, r107, r108);
        return;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }
}
