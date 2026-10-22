package com.bytedance.android.shopping.deepfeed.ui.view;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentItemView f173933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f173934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f173935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f173936d;

    public f(CommentItemView r100, String r101, boolean r102, String r103) {
        this.f173933a = r100;
        this.f173934b = r101;
        this.f173935c = r102;
        this.f173936d = r103;
    }

    public final void a() {
        if ((!Intrinsics.areEqual(this.f173933a.f173881e.getTag(), this.f173934b)) == false) goto L6;
        return;
    L6:
        if (this.f173935c == true) goto L8;
    L10:
        int r100 = 0;
    L12:
        if (StringsKt.isBlank(this.f173936d) == false) goto L15;
        this.f173933a.f173881e.setText("");
        this.f173933a.f173882f.setVisibility(8);
        this.f173933a.b(false, false);
        return;
    L15:
        int r101 = this.f173933a.f173881e.getWidth();
        if (r101 > 0) goto L19;
        this.f173933a.f173881e.setText(this.f173936d);
        this.f173933a.f173882f.setVisibility(8);
        this.f173933a.b(false, true);
        return;
    L19:
        int r102 = r101 - r100;
        if (this.f173933a.f173881e.getPaint().breakText(this.f173936d, true, RangesKt.coerceAtLeast(r102, 0), null) < this.f173936d.length()) goto L23;
        DeepFeedMaskTextView r103 = this.f173933a.f173881e;
        r103.setPadding(r103.getPaddingLeft(), this.f173933a.f173881e.getPaddingTop(), r100, this.f173933a.f173881e.getPaddingBottom());
        this.f173933a.f173881e.setText(this.f173936d);
        this.f173933a.f173882f.setVisibility(8);
        this.f173933a.b(false, true);
        return;
    L23:
        int r104 = this.f173933a.f173881e.getPaint().breakText(this.f173936d, true, r101, null);
        String r105 = StringsKt.take(this.f173936d, r104);
        String r106 = StringsKt.drop(this.f173936d, r104);
        if (r106 == null) goto L38;
        String r107 = StringsKt.trimStart(r106).toString();
        if (r104 != this.f173936d.length()) goto L28;
        r105 = StringsKt.take(this.f173936d, this.f173933a.f173881e.getPaint().breakText(this.f173936d, true, RangesKt.coerceAtLeast(r102, 0), null));
        this.f173933a.f173881e.setMaskLengthDp(r100);
    L28:
        this.f173933a.f173881e.setText(r105);
        CommentItemView r108 = this.f173933a;
        r108.getClass();
        if (StringsKt.isBlank(r107) == false) goto L31;
        r108.f173882f.setVisibility(8);
        r108.b(false, true);
        return;
    L31:
        int r109 = RangesKt.coerceAtLeast(r108.f173884h.getWidth() - r100, 0);
        DeepFeedMaskTextView r110 = r108.f173882f;
        if (r109 > 0) goto L34;
        int r111 = r107.length();
    L35:
        DeepFeedMaskTextView r112 = r108.f173882f;
        r112.setPadding(r112.getPaddingLeft(), r108.f173882f.getPaddingTop(), r100, r108.f173882f.getPaddingBottom());
        r108.f173882f.setVisibility(0);
        r108.f173882f.setText(StringsKt.take(r107, r111));
        r108.b(true, false);
        return;
    L34:
        r111 = r110.getPaint().breakText(r107, true, r109, null);
        goto L35
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L8:
        if (this.f173933a.f173883g.getVisibility() != 0) goto L10;
        r100 = RangesKt.coerceAtLeast(this.f173933a.f173883g.getWidth(), 0);
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
