package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DividerItemDecoration.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends RecyclerView.g {
    private static final String TAG = "DividerItem";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f2544a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f2545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f2547d;

    static {
        f2544a = new int[]{R.attr.listDivider};
    }

    public k(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f2547d = new Rect();
        TypedArray r6 = r5.obtainStyledAttributes(f2544a);
        Drawable r0 = r6.getDrawable(0);
        this.f2545b = r0;
        if (r0 != null) goto L5;
        a(TAG, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
    L5:
        r6.recycle();
        a(r4);
    }

    public void a(int r2) {
        if (r2 != 0) goto L4;
    L8:
        this.f2546c = r2;
        return;
    L4:
        if (r2 == 1) goto L8;
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(Canvas r2, RecyclerView r3, RecyclerView.r r4) {
        if (r3.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.f2545b != null) goto L8;
        return;
    L8:
        if (this.f2546c != 1) goto L10;
        c(r2, r3);
        return;
    L10:
        d(r2, r3);
    }

    private void c(Canvas r8, RecyclerView r9) {
        r8.save();
        int r1 = 0;
        if (r9.getClipToPadding() == false) goto L5;
        int r0 = r9.getPaddingLeft();
        int r2 = r9.getWidth() - r9.getPaddingRight();
        r8.clipRect(r0, r9.getPaddingTop(), r2, r9.getHeight() - r9.getPaddingBottom());
    L6:
        int r3 = r9.getChildCount();
    L7:
        if (r1 >= r3) goto L9;
        View r4 = r9.getChildAt(r1);
        r9.getDecoratedBoundsWithMargins(r4, this.f2547d);
        int r5 = this.f2547d.bottom + Math.round(r4.getTranslationY());
        this.f2545b.setBounds(r0, r5 - this.f2545b.getIntrinsicHeight(), r2, r5);
        this.f2545b.draw(r8);
        r1 = r1 + 1;
        goto L7
    L9:
        r8.restore();
        return;
    L5:
        r2 = r9.getWidth();
        r0 = 0;
        goto L6
    }

    private void d(Canvas r8, RecyclerView r9) {
        r8.save();
        int r1 = 0;
        if (r9.getClipToPadding() == false) goto L5;
        int r0 = r9.getPaddingTop();
        int r2 = r9.getHeight() - r9.getPaddingBottom();
        r8.clipRect(r9.getPaddingLeft(), r0, r9.getWidth() - r9.getPaddingRight(), r2);
    L6:
        int r3 = r9.getChildCount();
    L7:
        if (r1 >= r3) goto L9;
        View r4 = r9.getChildAt(r1);
        r9.getLayoutManager().a(r4, this.f2547d);
        int r5 = this.f2547d.right + Math.round(r4.getTranslationX());
        this.f2545b.setBounds(r5 - this.f2545b.getIntrinsicWidth(), r0, r5, r2);
        this.f2545b.draw(r8);
        r1 = r1 + 1;
        goto L7
    L9:
        r8.restore();
        return;
    L5:
        r2 = r9.getHeight();
        r0 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(Rect r1, View r2, RecyclerView r3, RecyclerView.r r4) {
        Drawable r5 = this.f2545b;
        if (r5 != null) goto L7;
        r1.set(0, 0, 0, 0);
        return;
    L7:
        if (this.f2546c != 1) goto L9;
        r1.set(0, 0, 0, r5.getIntrinsicHeight());
        return;
    L9:
        r1.set(0, 0, r5.getIntrinsicWidth(), 0);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
