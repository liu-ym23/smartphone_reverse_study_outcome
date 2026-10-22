package d5;

import Y8.t;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$color;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jw\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020 *\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Ld5/d;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "", "isToggling", "Lkotlin/Function1;", "Landroid/view/View;", "LY8/t;", "onConnect", "onReview", UxipConstants.f30642F, "onToggle", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Lcom/stepos/ailauncher/agent/skill/SkillStatus;ZLp9/l;Lp9/l;Lp9/l;Lp9/l;)Landroid/view/View;", "", UxipConstants.f30680s, "onClick", "Landroid/widget/FrameLayout;", "e", "(Ljava/lang/String;Landroid/content/Context;Lp9/l;)Landroid/widget/FrameLayout;", "onCancel", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Lp9/l;)Landroid/widget/FrameLayout;", Const.INTENT_KEY_BACKGROUND_COMMAND, "child", "l", "(Landroid/view/View;)Landroid/widget/FrameLayout;", "", "k", "(ILandroid/content/Context;)I", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    public static final d INSTANCE = new d();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SkillStatus.values().length];
            try {
                iArr[SkillStatus.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkillStatus.REVIEWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SkillStatus.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SkillStatus.CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SkillStatus.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SkillStatus.TOGGLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SkillStatus.UNINSTALLING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SkillStatus.INSTALLING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void f(InterfaceC5074l interfaceC5074l, View view) {
        interfaceC5074l.invoke(view);
    }

    public static final void h(InterfaceC5074l interfaceC5074l, View view) {
        interfaceC5074l.invoke(view);
    }

    public static final void j(InterfaceC5074l interfaceC5074l, View view) {
        interfaceC5074l.invoke(view);
    }

    public final View d(Context context, SkillStatus status, boolean isToggling, InterfaceC5074l<? super View, t> onConnect, InterfaceC5074l<? super View, t> onReview, InterfaceC5074l<? super View, t> onReconnect, InterfaceC5074l<? super Boolean, t> onToggle) {
        p.i(context, "context");
        p.i(status, "status");
        p.i(onConnect, "onConnect");
        p.i(onReview, "onReview");
        p.i(onReconnect, "onReconnect");
        p.i(onToggle, "onToggle");
        switch (a.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
                return e(null, context, onConnect);
            case 2:
                return i(context, onReview);
            case 3:
                return g(context, onReview);
            case 4:
                return l.INSTANCE.s(context, true, true, !isToggling, onToggle);
            case 5:
                return l.INSTANCE.s(context, false, true, !isToggling, onToggle);
            case 6:
            case 7:
            case 8:
                return l.INSTANCE.s(context, false, true, false, onToggle);
            default:
                return e(null, context, onConnect);
        }
    }

    public final FrameLayout e(String value, Context context, final InterfaceC5074l<? super View, t> onClick) {
        TextView textView = new TextView(context);
        if (value == null) {
            value = context.getString(R$string.cli_state_connect_agent);
            p.h(value, "getString(...)");
        }
        textView.setText(value);
        textView.setTextColor(b5.m.INSTANCE.c(textView));
        textView.setBackgroundResource(R$drawable.bg_skill_btn_install);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setClickable(true);
        textView.setFocusable(true);
        d dVar = INSTANCE;
        textView.setPadding(dVar.k(16, context), dVar.k(0, context), dVar.k(16, context), dVar.k(0, context));
        textView.setMinHeight(dVar.k(25, context));
        textView.setOnClickListener(new View.OnClickListener() { // from class: d5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.f(onClick, view);
            }
        });
        return l(textView);
    }

    public final FrameLayout g(Context context, final InterfaceC5074l<? super View, t> onClick) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R$string.cli_state_connecting_agent));
        textView.setTextColor(androidx.core.content.a.c(context, R$color.feishu_brand));
        textView.setBackgroundResource(R$drawable.bg_skill_btn_install);
        textView.setTextSize(12.0f);
        textView.setTypeface(Typeface.create(textView.getTypeface(), 500, false));
        textView.setGravity(17);
        textView.setClickable(true);
        textView.setFocusable(true);
        d dVar = INSTANCE;
        textView.setPadding(dVar.k(8, context), dVar.k(0, context), dVar.k(8, context), dVar.k(0, context));
        textView.setMinHeight(dVar.k(25, context));
        textView.setOnClickListener(new View.OnClickListener() { // from class: d5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.h(onClick, view);
            }
        });
        return l(textView);
    }

    public final FrameLayout i(Context context, final InterfaceC5074l<? super View, t> onCancel) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R$string.cli_state_reviewing_agent));
        textView.setTextColor(androidx.core.content.a.c(context, R$color.cli_reviewing_orange));
        textView.setBackgroundResource(R$drawable.bg_skill_btn_install);
        textView.setTextSize(12.0f);
        textView.setTypeface(Typeface.create(textView.getTypeface(), 500, false));
        textView.setGravity(17);
        textView.setClickable(true);
        textView.setFocusable(true);
        d dVar = INSTANCE;
        textView.setPadding(dVar.k(8, context), dVar.k(0, context), dVar.k(8, context), dVar.k(0, context));
        textView.setMinHeight(dVar.k(25, context));
        textView.setOnClickListener(new View.OnClickListener() { // from class: d5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.j(onCancel, view);
            }
        });
        return l(textView);
    }

    public final int k(int i10, Context context) {
        return (int) (i10 * context.getResources().getDisplayMetrics().density);
    }

    public final FrameLayout l(View child) {
        FrameLayout frameLayout = new FrameLayout(child.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388629;
        t tVar = t.f7040a;
        frameLayout.addView(child, layoutParams);
        return frameLayout;
    }
}
