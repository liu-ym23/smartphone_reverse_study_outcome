package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c63.d;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import f83.a;
import f83.l;
import f83.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4DownTabIndicator;", "Landroid/widget/FrameLayout;", "Lf83/l;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameElement", "", "e", "Ljava/lang/Integer;", "getInitDownTabVisibility", "()Ljava/lang/Integer;", "setInitDownTabVisibility", "(Ljava/lang/Integer;)V", "initDownTabVisibility", "Lf83/p;", ce.f26391f, "Lf83/p;", "getTabLogicInterceptor", "()Lf83/p;", "tabLogicInterceptor", "Lc63/d;", "h", "Lc63/d;", "getLogAction", "()Lc63/d;", "logAction", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DownTabIndicator extends FrameLayout implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f168721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f168722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorV4FindSameIndicator f168723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f168724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f168725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AnchorV4TabIndicator f168726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f168727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f168728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CommonFindSameElement f168729i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f168730j;

    public AnchorV4DownTabIndicator(Context r110) {
        this(r110, null, 0, null, null, null, null, null, 254);
    }

    public AnchorV4DownTabIndicator(Context r110, AttributeSet r111) {
        this(r110, r111, 0, null, null, null, null, null, 252);
    }

    public AnchorV4DownTabIndicator(Context r110, AttributeSet r111, int r112) {
        this(r110, r111, r112, null, null, null, null, null, 248);
    }

    @Override // f83.l
    public CommonFindSameElement getFindSameElement() {
        return this.f168729i;
    }

    public final Integer getInitDownTabVisibility() {
        return this.f168725e;
    }

    public final d getLogAction() {
        return this.f168728h;
    }

    public final p getTabLogicInterceptor() {
        return this.f168727g;
    }

    @Override // f83.l
    public final void a(boolean r100) {
        AnchorV4FindSameIndicator r101 = this.f168723c;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // f83.l
    public final void h(boolean r100) {
        AnchorV4TabIndicator r101 = this.f168726f;
        if (r100 == true) goto L5;
    L7:
        int r102 = 8;
    L8:
        r101.setVisibility(r102);
        return;
    L5:
        if (this.f168721a == false) goto L7;
        r102 = 0;
        goto L8
    }

    public final void setInitDownTabVisibility(Integer r100) {
        this.f168725e = r100;
    }

    @Override // f83.l
    public final void c(List<String> r100, List<b> r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "titleTags");
        Intrinsics.checkNotNullParameter(r101, "originTags");
        Intrinsics.checkNotNullParameter(r102, "tabTypes");
        this.f168726f.b(CollectionsKt.filterNotNull(r100), CollectionsKt.filterNotNull(r102));
        AnchorV4TabIndicator r103 = this.f168726f;
        ArrayList r104 = (ArrayList) r100;
        boolean r105 = false;
        if (r104.size() <= 1) goto L5;
        int r106 = 0;
    L6:
        r103.setVisibility(r106);
        if (r104.size() <= 1) goto L9;
        r105 = true;
    L9:
        this.f168721a = r105;
        return;
    L5:
        r106 = 8;
        goto L6
    }

    @Override // f83.l
    public final void b(Integer r100, int r101, String r102, boolean r103) {
        if (r100 == null) goto L5;
        this.f168726f.a(r100.intValue(), r102, r103);
        return;
    }

    public AnchorV4DownTabIndicator(Context r100, AttributeSet r101, int r102, p r103, d r104, CommonFindSameElement r105, String r106, FrameLayout r107, int r110) {
        Integer r108 = null;
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r110 & 128) == 0) goto L20;
        r107 = null;
    L20:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168727g = r103;
        this.f168728h = r104;
        this.f168729i = r105;
        this.f168730j = r107;
        this.f168721a = true;
        if (r107 == null) goto L23;
        r108 = Integer.valueOf(r107.getVisibility());
    L23:
        this.f168725e = r108;
        AnchorV4TabIndicator r109 = new AnchorV4TabIndicator(r100, null, 0, new a(this), 6);
        this.f168726f = r109;
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20));
        r111.gravity = 17;
        Unit r112 = Unit.INSTANCE;
        addView(r109, r111);
    }
}
