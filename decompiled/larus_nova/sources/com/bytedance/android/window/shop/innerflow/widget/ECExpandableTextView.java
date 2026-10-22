package com.bytedance.android.window.shop.innerflow.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECExpandableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "", "setTextInner", "Landroid/graphics/Bitmap;", "getBitmapFixedHeight", "f", "Landroid/graphics/Bitmap;", "getBitmapCache", "()Landroid/graphics/Bitmap;", "setBitmapCache", "(Landroid/graphics/Bitmap;)V", "bitmapCache", "Lkotlin/Function0;", ce.f26391f, "Lkotlin/jvm/functions/Function0;", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECExpandableTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f189206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f189207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f189208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f189209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f189210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f189211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f189212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f189213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f189214i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECExpandableTextView f189215a;

        public a(ECExpandableTextView r100) {
            this.f189215a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = rp.a.f538829a;
            if (rp.a.a(r100.getId()) == false) goto L5;
            return;
        L5:
            ECExpandableTextView r102 = this.f189215a;
            if (r102.f189207b == false) goto L9;
            r102.y();
            return;
        }
    }

    public static final class b {
    }

    public static final class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECExpandableTextView f189216a;

        public c(ECExpandableTextView r100) {
            this.f189216a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            ECExpandableTextView r101 = this.f189216a;
            r101.f189207b = false;
            ECExpandableTextView.x(r101, r101.f189210e);
            Function0<Unit> r102 = this.f189216a.getClickCallback();
            if (r102 == null) goto L6;
            Unit r103 = r102.invoke();
            return;
        }
    }

    public static final class d extends ImageSpan {
        public d(Context r100, Bitmap r101) {
            super(r100, r101, 0);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            int r105 = super.getSize(r100, r101, r102, r103, r104);
            if (r104 == null) goto L5;
            r104.top = 0;
            r104.bottom = 0;
            r104.ascent = 0;
            r104.descent = 0;
        L5:
            return r105;
        }
    }

    static {
    }

    public final void y() {
        this.f189207b = false;
        setTextInner(this.f189210e);
    }

    public final Bitmap getBitmapFixedHeight() {
        int r100 = com.bytedance.android.shopping.extensions.b.b(32);
        int r101 = com.bytedance.android.shopping.extensions.b.b(20);
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap r103 = BitmapFactory.decodeResource(getResources(), R.drawable.ec_shop_ic_inner_flow_text_expand, r102);
        float r104 = r103.getHeight() / r101;
        if (r104 >= 0.9f) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L10;
        return r103;
    L10:
        return Bitmap.createScaledBitmap(r103, r100, r101, false);
    L5:
        if (r104 > 1.1f) goto L7;
        r105 = true;
        goto L8
    }

    public final Bitmap getBitmapCache() {
        return this.f189211f;
    }

    public final Function0<Unit> getClickCallback() {
        return this.f189212g;
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
        if (getLayout().getLineCount() <= this.f189206a) goto L9;
        boolean r102 = true;
    L10:
        if (r101 == true) goto L14;
        if (r102 == true) goto L14;
        boolean r103 = false;
    L16:
        if (this.f189207b == false) goto L31;
        if (r103 == false) goto L32;
        CharSequence r104 = getLayout().getText();
        int r105 = getLayout().getLineEnd(this.f189206a - 1);
        CharSequence r106 = r104.subSequence(getLayout().getLineStart(this.f189206a - 1), r105);
        float r107 = getPaint().measureText(r106, 0, r106.length()) - (getPaint().measureText(this.f189208c + this.f189209d) + getLayout().getSpacingAdd());
        if (r107 > 0) goto L21;
        CharSequence r108 = r104.subSequence(0, r105);
    L27:
        SpannableStringBuilder r109 = new SpannableStringBuilder().append(StringsKt.trimEnd(r108)).append(this.f189208c).append(this.f189209d);
        r109.setSpan(this.f189214i, r109.length() - this.f189209d.length(), r109.length(), 33);
        r109.setSpan(this.f189213h, r109.length() - this.f189209d.length(), r109.length(), 33);
        setMovementMethod(LinkMovementMethod.getInstance());
        setTextInner(r109);
        return;
    L21:
        int r110 = r106.length() - 1;
        int r111 = 1;
    L22:
        if (r110 <= 0) goto L26;
        if (getPaint().measureText(r106, 0, r110) < r107) goto L26;
        r111 = r111 + 1;
        r110 = r106.length() - r111;
    L26:
        r108 = r104.subSequence(0, (r105 - r111) - 1);
        goto L27
    L32:
        return;
    L31:
        return;
    L14:
        r103 = true;
        goto L16
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public final void setBitmapCache(Bitmap r100) {
        this.f189211f = r100;
    }

    public final void setClickCallback(Function0<Unit> r100) {
        this.f189212g = r100;
    }

    public ECExpandableTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f189206a = 2;
        this.f189207b = true;
        this.f189208c = "... ";
        this.f189209d = tb2.c.DEFAULT_TEXT;
        this.f189213h = new c(this);
        this.f189214i = new d(r100, getBitmapFixedHeight());
        if (Build.VERSION.SDK_INT < 23) goto L5;
        setBreakStrategy(0);
    L5:
        setOnClickListener(new a(this));
    }

    public static final /* synthetic */ void x(ECExpandableTextView r100, CharSequence r101) {
        r100.setTextInner(r101);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        this.f189210e = r100;
        super.setText(r100, r101);
    }
}
