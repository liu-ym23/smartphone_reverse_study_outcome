package d5;

import Y8.t;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import e5.C3994a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000e\u0010\fJE\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0016\u0010\fJ)\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0017\u0010\fJ\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b \u0010!J'\u0010$\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0002¢\u0006\u0004\b$\u0010%J+\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u0018H\u0002¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"Ld5/l;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Landroid/view/View;", "LY8/t;", "onClick", "Landroid/widget/FrameLayout;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;Lp9/l;)Landroid/widget/FrameLayout;", "onCancel", "l", "", "checked", "awaitConfirmation", x5.d.EXTRA_ENABLED, "onCheckChange", "s", "(Landroid/content/Context;ZZZLp9/l;)Landroid/widget/FrameLayout;", "q", "o", "", "color", "Lcom/stepos/ailauncher/agent/skill/widget/IndeterminateSpinnerView;", "w", "(Landroid/content/Context;I)Lcom/stepos/ailauncher/agent/skill/widget/IndeterminateSpinnerView;", "n", "(Landroid/content/Context;)Landroid/widget/FrameLayout;", "Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;", "onColor", "offColor", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;", "child", "width", "height", "x", "(Landroid/view/View;II)Landroid/widget/FrameLayout;", "v", "(ILandroid/content/Context;)I", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    public static final l INSTANCE = new l();

    public static final GradientDrawable i(Context context, int i10) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(context.getResources().getDisplayMetrics().density * 11.0f);
        l lVar = INSTANCE;
        gradientDrawable.setSize(lVar.v(40, context), lVar.v(22, context));
        return gradientDrawable;
    }

    public static final void k(InterfaceC5074l interfaceC5074l, View view) {
        interfaceC5074l.invoke(view);
    }

    public static final void m(InterfaceC5074l interfaceC5074l, View view) {
        interfaceC5074l.invoke(view);
    }

    public static final void p(InterfaceC5074l interfaceC5074l, View view) {
        interfaceC5074l.invoke(view);
    }

    public static final void r(InterfaceC5074l interfaceC5074l, View view) {
        interfaceC5074l.invoke(view);
    }

    public static final void t(SwitchCompat switchCompat, InterfaceC5074l interfaceC5074l, View view) throws Resources.NotFoundException {
        boolean zIsChecked = switchCompat.isChecked();
        switchCompat.setChecked(!zIsChecked);
        interfaceC5074l.invoke(Boolean.valueOf(zIsChecked));
    }

    public static final void u(InterfaceC5074l interfaceC5074l, CompoundButton compoundButton, boolean z10) {
        p.i(compoundButton, "<unused var>");
        interfaceC5074l.invoke(Boolean.valueOf(z10));
    }

    public static /* synthetic */ FrameLayout y(l lVar, View view, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = -2;
        }
        if ((i12 & 4) != 0) {
            i11 = -2;
        }
        return lVar.x(view, i10, i11);
    }

    public final Drawable g(Context context, int color) {
        int iV = v(22, context);
        int iV2 = v(14, context);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iV, iV, Bitmap.Config.ARGB_8888);
        p.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(color);
        float f10 = iV / 2.0f;
        canvas.drawCircle(f10, f10, iV2 / 2.0f, paint);
        return new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
    }

    public final Drawable h(Context context, int onColor, int offColor) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, i(context, onColor));
        stateListDrawable.addState(new int[0], i(context, offColor));
        return stateListDrawable;
    }

    public final FrameLayout j(Context context, final InterfaceC5074l<? super View, t> onClick) {
        p.i(context, "context");
        p.i(onClick, "onClick");
        TextView textView = new TextView(context);
        textView.setText(context.getString(R$string.skill_action_install));
        textView.setTextColor(b5.m.INSTANCE.c(textView));
        textView.setBackgroundResource(R$drawable.bg_skill_btn_install);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setClickable(true);
        textView.setFocusable(true);
        l lVar = INSTANCE;
        textView.setPadding(lVar.v(16, context), lVar.v(0, context), lVar.v(16, context), lVar.v(0, context));
        textView.setMinHeight(lVar.v(25, context));
        textView.setOnClickListener(new View.OnClickListener() { // from class: d5.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.k(onClick, view);
            }
        });
        return y(this, textView, 0, 0, 6, null);
    }

    public final FrameLayout l(Context context, final InterfaceC5074l<? super View, t> onCancel) {
        p.i(context, "context");
        p.i(onCancel, "onCancel");
        FrameLayout frameLayoutN = n(context);
        frameLayoutN.setOnClickListener(new View.OnClickListener() { // from class: d5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.m(onCancel, view);
            }
        });
        return frameLayoutN;
    }

    public final FrameLayout n(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        l lVar = INSTANCE;
        frameLayout.setMinimumWidth(lVar.v(48, context));
        frameLayout.setMinimumHeight(lVar.v(32, context));
        frameLayout.setClickable(false);
        IndeterminateSpinnerView indeterminateSpinnerViewW = w(context, b5.m.INSTANCE.i(context));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(v(24, context), v(24, context));
        layoutParams.gravity = 17;
        t tVar = t.f7040a;
        frameLayout.addView(indeterminateSpinnerViewW, layoutParams);
        return y(this, frameLayout, 0, 0, 6, null);
    }

    public final FrameLayout o(Context context, final InterfaceC5074l<? super View, t> onCancel) {
        p.i(context, "context");
        p.i(onCancel, "onCancel");
        TextView textView = new TextView(context);
        textView.setText(context.getString(R$string.skill_action_queued));
        b5.m mVar = b5.m.INSTANCE;
        textView.setTextColor(mVar.c(textView));
        textView.setBackground(new C3994a(mVar.a(context), 0.0f, 2, null));
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setClickable(true);
        textView.setFocusable(true);
        l lVar = INSTANCE;
        textView.setPadding(lVar.v(16, context), lVar.v(8, context), lVar.v(16, context), lVar.v(8, context));
        textView.setMinHeight(lVar.v(32, context));
        textView.setOnClickListener(new View.OnClickListener() { // from class: d5.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.p(onCancel, view);
            }
        });
        return y(this, textView, 0, 0, 6, null);
    }

    public final FrameLayout q(Context context, final InterfaceC5074l<? super View, t> onClick) {
        p.i(context, "context");
        p.i(onClick, "onClick");
        TextView textView = new TextView(context);
        textView.setText(context.getString(R$string.skill_action_retry));
        b5.m mVar = b5.m.INSTANCE;
        textView.setTextColor(mVar.e(textView));
        textView.setBackground(new C3994a(mVar.a(context), 0.0f, 2, null));
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setClickable(true);
        textView.setFocusable(true);
        l lVar = INSTANCE;
        textView.setPadding(lVar.v(16, context), lVar.v(8, context), lVar.v(16, context), lVar.v(8, context));
        textView.setMinHeight(lVar.v(32, context));
        textView.setOnClickListener(new View.OnClickListener() { // from class: d5.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.r(onClick, view);
            }
        });
        return y(this, textView, 0, 0, 6, null);
    }

    public final FrameLayout s(Context context, boolean checked, boolean awaitConfirmation, boolean enabled, final InterfaceC5074l<? super Boolean, t> onCheckChange) throws Resources.NotFoundException {
        p.i(context, "context");
        p.i(onCheckChange, "onCheckChange");
        if (!enabled) {
            return n(context);
        }
        b5.m mVar = b5.m.INSTANCE;
        int defaultColor = mVar.l(context).getDefaultColor();
        int defaultColor2 = mVar.k(context).getDefaultColor();
        int defaultColor3 = mVar.j(context).getDefaultColor();
        final SwitchCompat switchCompat = new SwitchCompat(context);
        switchCompat.setTrackTintList(null);
        switchCompat.setThumbTintList(null);
        l lVar = INSTANCE;
        switchCompat.setTrackDrawable(lVar.h(context, defaultColor, defaultColor2));
        switchCompat.setThumbDrawable(lVar.g(context, defaultColor3));
        switchCompat.setSwitchMinWidth(lVar.v(40, context));
        switchCompat.setChecked(checked);
        if (awaitConfirmation) {
            switchCompat.setOnClickListener(new View.OnClickListener() { // from class: d5.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    l.t(switchCompat, onCheckChange, view);
                }
            });
        } else {
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: d5.h
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    l.u(onCheckChange, compoundButton, z10);
                }
            });
        }
        return y(this, switchCompat, 0, 0, 6, null);
    }

    public final int v(int i10, Context context) {
        return (int) (i10 * context.getResources().getDisplayMetrics().density);
    }

    public final IndeterminateSpinnerView w(Context context, int color) {
        IndeterminateSpinnerView indeterminateSpinnerView = new IndeterminateSpinnerView(context, null, 0, 6, null);
        indeterminateSpinnerView.setColor(color);
        return indeterminateSpinnerView;
    }

    public final FrameLayout x(View child, int width, int height) {
        FrameLayout frameLayout = new FrameLayout(child.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.gravity = 8388629;
        t tVar = t.f7040a;
        frameLayout.addView(child, layoutParams);
        return frameLayout;
    }
}
