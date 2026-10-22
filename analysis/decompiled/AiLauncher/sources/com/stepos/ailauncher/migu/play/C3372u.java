package com.stepos.ailauncher.migu.play;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.migu.R$drawable;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/migu/play/u;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "LY8/t;", "onLoginClick", "Landroid/view/View;", "e", "(Landroid/content/Context;Lp9/a;)Landroid/view/View;", "Landroid/widget/FrameLayout$LayoutParams;", "c", "()Landroid/widget/FrameLayout$LayoutParams;", "", "COLOR_CARD_BG", "I", "COLOR_SUBTITLE", "COLOR_BTN_TEXT", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3372u {
    public static final C3372u INSTANCE = new C3372u();
    private static final int COLOR_CARD_BG = Color.parseColor("#2C2C2E");
    private static final int COLOR_SUBTITLE = Color.argb(128, 255, 255, 255);
    private static final int COLOR_BTN_TEXT = Color.argb(230, 0, 0, 0);

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/migu/play/u$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.migu.play.u$a */
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ Context $context;

        public a(Context context) {
            this.$context = context;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), C3372u.f(this.$context, 10.0f));
        }
    }

    public static final int f(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final void g(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        view.invalidateOutline();
    }

    public static final void h(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public final FrameLayout.LayoutParams c() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public final View e(Context context, final InterfaceC5063a<Y8.t> onLoginClick) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onLoginClick, "onLoginClick");
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R$drawable.ic_migu_login_app);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(f(context, 56.0f), f(context, 56.0f)));
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(new a(context));
        imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.migu.play.s
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                C3372u.g(view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(f(context, 8.0f));
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setText("登录咪咕音乐");
        textView.setTextColor(-1);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setMaxLines(1);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setText("需登录咪咕音乐，登录后即可播放。");
        textView2.setTextColor(COLOR_SUBTITLE);
        textView2.setTextSize(2, 12.0f);
        textView2.setMaxLines(2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = f(context, 2.0f);
        textView2.setLayoutParams(layoutParams2);
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(context);
        textView3.setText("去登录");
        textView3.setGravity(17);
        textView3.setTextColor(COLOR_BTN_TEXT);
        textView3.setTextSize(2, 15.0f);
        textView3.setTypeface(textView3.getTypeface(), 1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f(context, 1000.0f));
        gradientDrawable.setColor(-1);
        textView3.setBackground(gradientDrawable);
        textView3.setMinWidth(f(context, 85.0f));
        textView3.setPadding(f(context, 16.0f), 0, f(context, 16.0f), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, f(context, 38.0f));
        layoutParams3.setMarginStart(f(context, 12.0f));
        textView3.setLayoutParams(layoutParams3);
        textView3.setClickable(true);
        textView3.setFocusable(true);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.migu.play.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C3372u.h(onLoginClick, view);
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(f(context, 20.0f));
        gradientDrawable2.setColor(COLOR_CARD_BG);
        linearLayout2.setBackground(gradientDrawable2);
        linearLayout2.setPadding(f(context, 16.0f), f(context, 16.0f), f(context, 16.0f), f(context, 16.0f));
        linearLayout2.setMinimumHeight(f(context, 88.0f));
        linearLayout2.setLayoutParams(INSTANCE.c());
        linearLayout2.addView(imageView);
        linearLayout2.addView(linearLayout);
        linearLayout2.addView(textView3);
        return linearLayout2;
    }
}
