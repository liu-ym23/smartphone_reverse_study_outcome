package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.tangram.Bind;
import com.bytedanceos.common.tangram.style.BannerStyle;
import com.bytedanceos.common.ui.widget.BaseBannerView;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class TangramBannerView extends BaseBannerView implements Bind<Topic> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Topic f9964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseCell f9965b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCell f9966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TangramBannerView f9967b;

        public a(TangramBannerView r10, BaseCell r11) {
            this.f9967b = r10;
            this.f9966a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9967b.getLeft() >= 0) goto L6;
            return;
        L6:
            if (this.f9967b.getLeft() != 0) goto L8;
        L9:
            AdsReportManager.h().m(this.f9966a);
            return;
        L8:
            if (this.f9967b.getLeft() < this.f9967b.getResources().getDisplayMetrics().widthPixels) goto L9;
        }
    }

    static {
        z8.a.a(3, new int[]{210});
    }

    public TangramBannerView(Context r10) {
        this(r10, null);
    }

    public void a(Topic r10, BaseCell r11) {
        this.f9964a = r10;
        this.f9965b = r11;
        bindData(r10);
        r11.setOnClickListener(this.mImageView, 210);
        b(r11);
    }

    public void b(BaseCell r10) {
        Card r11 = r10.parent;
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = r11.type;
        if (r12 != 10002) goto L8;
        post(new a(this, r10));
        return;
    L8:
        BaseCell r13 = this.f9965b;
        int r14 = r13.parent.type;
        if (r14 != 1) goto L11;
    L21:
        d9.a r15 = d9.a.e();
        Topic r16 = this.f9964a;
        r15.l(r16, r16.getLocation());
        return;
    L11:
        if (r14 == 2) goto L21;
        if (r14 != 10001) goto L19;
        if (r13.pos != 0) goto L24;
        d9.a r17 = d9.a.e();
        Topic r18 = this.f9964a;
        r17.l(r18, r18.getLocation());
        return;
    L24:
        return;
    L19:
        if (r12 == 10) goto L26;
        AdsReportManager.h().m(r10);
        return;
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(Topic r10, BaseCell r11) {
        a(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.widget.RelativeLayout, com.bytedanceos.common.tangram.view.TangramBannerView, com.bytedanceos.common.ui.widget.BaseBannerView] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [int] */
    @Override // com.bytedanceos.common.tangram.Bind
    public void bindStyle(Style r10, BaseCell r11) {
        setPadding(0, 0, 0, 0);
        Card r12 = r11.parent;
        int r13 = r12.type;
        if (r13 != 2) goto L6;
        ?? r14 = 5;
    L14:
        setStyleType(r14);
        if (r14 != 5) goto L32;
        int r15 = r11.parent.getCells().size();
        int r16 = r11.parent.getCells().indexOf(r11);
        if (r15 > 2) goto L19;
        setPadding(0, f.i(12), 0, f.i(12));
    L28:
        ViewGroup.LayoutParams r17 = getLayoutParams();
        if (r17 == null) goto L33;
        r17.width = (r17.width + getPaddingStart()) + getPaddingEnd();
        r17.height = (r17.height + getPaddingTop()) + getPaddingBottom();
        return;
    L33:
        return;
    L19:
        if (r16 == 0) goto L27;
        if (r16 == 1) goto L27;
        if (r16 != (r15 - 1)) goto L25;
    L26:
        setPadding(0, 0, 0, f.i(12));
        goto L28
    L25:
        if (r16 != (r15 - 2)) goto L28;
    L27:
        setPadding(0, f.i(12), 0, 0);
        goto L28
    L32:
        return;
    L6:
        if (r13 == 10001) goto L8;
        if (r13 != 1) goto L13;
        r14 = 2;
        goto L14
    L13:
        r14 = ((BannerStyle) r10).f9929h;
        goto L14
    L8:
        if (r12.getCells().indexOf(r11) != 0) goto L10;
        r14 = 3;
        goto L14
    L10:
        r14 = 4;
        goto L14
    }

    public BaseCell getCell() {
        return this.f9965b;
    }

    public Topic getTopic() {
        return this.f9964a;
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void unBind() {
        NetworkImageView r10 = this.mImageView;
        if (r10 == null) goto L6;
        this.mCardView.removeView(r10);
        this.mImageView = null;
        return;
    }

    public TangramBannerView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public TangramBannerView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
