package com.bytedance.android.shopping.store.moments.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/widget/ECShortVideoExpandableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "", "setTextInner", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShortVideoExpandableTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f185697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f185698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f185699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f185700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f185701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f185702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f185703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f185704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f185705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f185706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f185707k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f185708l;

    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShortVideoExpandableTextView f185709a;

        public a(ECShortVideoExpandableTextView r100) {
            this.f185709a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            ECShortVideoExpandableTextView r101 = this.f185709a;
            boolean r102 = !r101.f185700d;
            r101.f185700d = r102;
            if (r102 == false) goto L5;
            r101.f185703g = r101.f185702f;
            r101.f185697a = r101.f185699c;
            r101.f185707k = true;
        L6:
            ECShortVideoExpandableTextView.x(r101, r101.f185706j);
            this.f185709a.invalidate();
            return;
        L5:
            r101.f185703g = r101.f185701e;
            r101.f185697a = r101.f185698b;
            goto L6
        }
    }

    private final void setTextInner(CharSequence r100) {
        super.setText(r100, TextView.BufferType.NORMAL);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (getLayout().getEllipsisCount(getLayout().getLineCount() - 1) <= 0) goto L5;
        boolean r101 = true;
    L7:
        if (getLayout().getLineCount() <= this.f185697a) goto L9;
        boolean r102 = true;
    L10:
        if (r101 == true) goto L14;
        if (r102 == true) goto L14;
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
    L18:
        CharSequence r104 = getLayout().getText();
        if (r103 == false) goto L25;
        int r105 = getLayout().getLineEnd(this.f185697a - 1);
        CharSequence r106 = r104.subSequence(getLayout().getLineStart(this.f185697a - 1), r105);
        int r107 = 1;
    L22:
        if (getPaint().measureText(r106, 0, r106.length() - r107) <= (getPaint().measureText(r106, 0, r106.length()) - (getPaint().measureText(this.f185704h + this.f185703g) + getLayout().getSpacingAdd()))) goto L24;
        r107 = r107 + 1;
        goto L22
    L24:
        r104 = r104.subSequence(0, (r105 - r107) - 1);
    L25:
        SpannableStringBuilder r108 = new SpannableStringBuilder().append(r104).append(this.f185704h).append(this.f185703g);
        TextPaint r109 = new TextPaint();
        r109.linkColor = this.f185705i;
        this.f185708l.updateDrawState(r109);
        r108.setSpan(this.f185708l, r108.length() - this.f185703g.length(), r108.length(), 33);
        setMovementMethod(LinkMovementMethod.getInstance());
        if (this.f185707k == false) goto L28;
        this.f185707k = false;
    L28:
        setTextInner(r108);
        return;
    L17:
        if (this.f185707k == true) goto L18;
        return;
    L14:
        r103 = true;
        goto L15
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public ECShortVideoExpandableTextView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110);
        this.f185697a = 2;
        this.f185698b = 2;
        this.f185699c = 3;
        String r101 = "收起";
        this.f185701e = "收起";
        String r102 = "展开";
        this.f185702f = "展开";
        this.f185703g = "展开";
        this.f185704h = "... ";
        this.f185705i = -1;
        this.f185706j = "";
        this.f185708l = new a(this);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        setBreakStrategy(0);
    L5:
        if (r110 == null) goto L16;
        TypedArray r103 = r100.obtainStyledAttributes(r110, new int[]{R.attr.ec_closeMaxLineCount, R.attr.ec_ellipsisText, R.attr.ec_expandMaxLineCount, R.attr.ec_expandPlaceHolder, R.attr.ec_placeHolderColor});
        int r111 = r103.getInt(0, 2);
        this.f185698b = r111;
        this.f185697a = r111;
        this.f185699c = r103.getInt(2, 3);
        String r112 = r103.getString(3);
        if (r112 == null) goto L10;
        r102 = r112;
    L10:
        this.f185702f = r102;
        String r113 = r103.getString(1);
        if (r113 == null) goto L14;
        r101 = r113;
    L14:
        this.f185701e = r101;
        this.f185703g = r101;
        this.f185705i = r103.getColor(4, -1);
        return;
    }

    public static final /* synthetic */ void x(ECShortVideoExpandableTextView r100, CharSequence r101) {
        r100.setTextInner(r101);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        this.f185706j = r100;
        super.setText(r100, r101);
    }
}
