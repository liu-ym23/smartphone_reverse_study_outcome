package com.stepos.agentframework.chatui.view;

import Z8.C1173v;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.adapter.agentbus.bff.r;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatui/view/q0;", "", "<init>", "()V", "Landroid/view/View;", "host", "LY8/t;", "c", "(Landroid/view/View;)V", "Landroid/content/Context;", "ctx", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)V", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()I", "", "f", "(Landroid/content/Context;)Z", "", "TAG_BAR", "Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class q0 {
    public static final q0 INSTANCE = new q0();
    private static final String TAG_BAR = "terminal_frame_debug_bar";

    public static final void d(View view) {
        q0 q0Var = INSTANCE;
        Context context = view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        q0Var.h(context);
    }

    public static final int e(float f10, int i10) {
        return (int) (i10 * f10);
    }

    public static final void i(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final int j(float f10, int i10) {
        return (int) (i10 * f10);
    }

    @SuppressLint({"SetTextI18n"})
    public final void c(View host) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        kotlin.jvm.internal.p.i(host, "host");
        if (com.stepos.agentframework.adapter.agentbus.bff.r.enabled) {
            View viewFindViewById = host.findViewById(R$id.btn_to_bottom);
            ViewParent parent = viewFindViewById != null ? viewFindViewById.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null && viewGroup.findViewWithTag(TAG_BAR) == null) {
                float f10 = viewGroup.getResources().getDisplayMetrics().density;
                TextView textView = new TextView(viewGroup.getContext());
                textView.setTag(TAG_BAR);
                textView.setText(Parameters.DEBUG);
                textView.setTextColor(-1);
                textView.setTextSize(11.0f);
                textView.setPadding(e(f10, 12), e(f10, 6), e(f10, 12), e(f10, 6));
                textView.setBackgroundColor(-219584210);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.o0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        q0.d(view);
                    }
                });
                if (viewGroup instanceof ConstraintLayout) {
                    ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
                    bVar.f12664t = 0;
                    bVar.f12648l = 0;
                    bVar.setMarginStart(e(f10, 6));
                    ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = e(f10, com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME);
                    marginLayoutParams = bVar;
                } else {
                    marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    viewGroup.addView(textView, marginLayoutParams);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
    }

    public final boolean f(Context ctx) {
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                return true;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
        }
        return false;
    }

    public final int g() {
        return 2038;
    }

    @SuppressLint({"SetTextI18n"})
    public final void h(Context ctx) {
        float f10 = ctx.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(ctx);
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        textView.setTextIsSelectable(true);
        textView.setPadding(j(f10, 16), j(f10, 48), j(f10, 16), j(f10, 24));
        textView.setTypeface(Typeface.MONOSPACE);
        ScrollView scrollView = new ScrollView(ctx);
        scrollView.setBackgroundColor(-233828332);
        scrollView.addView(textView);
        List<r.Entry> listE = com.stepos.agentframework.adapter.agentbus.bff.r.INSTANCE.e();
        if (listE.isEmpty()) {
            textView.setText("(暂无记录。产生一轮回复或点开文件后再看)");
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i10 = 0;
            for (Object obj : listE) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                r.Entry entry = (r.Entry) obj;
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) entry.getText());
                if (entry.getTerminal()) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-24763), length, spannableStringBuilder.length(), 33);
                } else if (entry.getHasAttachment()) {
                    int iT0 = La.H.t0(entry.getText(), '\n', 0, false, 6, null);
                    if (iT0 < 0) {
                        iT0 = entry.getText().length();
                    }
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-11702), length, iT0 + length, 33);
                }
                if (i10 != C1173v.o(listE)) {
                    spannableStringBuilder.append((CharSequence) "\n\n═══════════════════════\n\n");
                }
                i10 = i11;
            }
            textView.setText(spannableStringBuilder);
        }
        final Dialog dialog = new Dialog(ctx, R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        TextView textView2 = new TextView(ctx);
        textView2.setText("×");
        textView2.setTextColor(-1);
        textView2.setTextSize(22.0f);
        textView2.setGravity(17);
        textView2.setPadding(j(f10, 14), j(f10, 6), j(f10, 14), j(f10, 8));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(j(f10, 20));
        gradientDrawable.setColor(-869651922);
        textView2.setBackground(gradientDrawable);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q0.i(dialog, view);
            }
        });
        int identifier = ctx.getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        int dimensionPixelSize = identifier > 0 ? ctx.getResources().getDimensionPixelSize(identifier) : j(f10, 28);
        FrameLayout frameLayout = new FrameLayout(ctx);
        frameLayout.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.topMargin = dimensionPixelSize + j(f10, 8);
        layoutParams.setMarginEnd(j(f10, 12));
        Y8.t tVar = Y8.t.f7040a;
        frameLayout.addView(textView2, layoutParams);
        dialog.setContentView(frameLayout);
        Window window = dialog.getWindow();
        if (window != null) {
            q0 q0Var = INSTANCE;
            if (!q0Var.f(ctx)) {
                window.setType(q0Var.g());
            }
            window.setLayout(-1, -1);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            dialog.show();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }
}
