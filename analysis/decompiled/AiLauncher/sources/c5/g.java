package c5;

import Y4.B;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lc5/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LY4/B;", "binding", "Lc5/l;", "callbacks", "<init>", "(LY4/B;Lc5/l;)V", "Lc5/x$a;", "item", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lc5/x$a;)V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "cliItem", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "LY4/B;", "Lc5/l;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g extends RecyclerView.ViewHolder {
    private final B binding;
    private final SkillCardCallbacks callbacks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(B binding, SkillCardCallbacks callbacks) {
        super(binding.b());
        kotlin.jvm.internal.p.i(binding, "binding");
        kotlin.jvm.internal.p.i(callbacks, "callbacks");
        this.binding = binding;
        this.callbacks = callbacks;
    }

    public static final Y8.t i(g gVar, SkillItem skillItem) {
        gVar.callbacks.b().invoke(skillItem);
        return Y8.t.f7040a;
    }

    public static final Y8.t j(InterfaceC5063a interfaceC5063a, View it) {
        kotlin.jvm.internal.p.i(it, "it");
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t k(InterfaceC5063a interfaceC5063a, View it) {
        kotlin.jvm.internal.p.i(it, "it");
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t l(InterfaceC5063a interfaceC5063a, View it) {
        kotlin.jvm.internal.p.i(it, "it");
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t m(g gVar, SkillItem skillItem, boolean z10) {
        gVar.callbacks.f().invoke(skillItem, Boolean.valueOf(z10));
        return Y8.t.f7040a;
    }

    public static final void n(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public final void g(SkillItem cliItem) {
        Context context = this.binding.b().getContext();
        d5.m mVar = d5.m.INSTANCE;
        int iE = mVar.e(cliItem.getIdentifier(), mVar.d());
        int iC = androidx.core.content.a.c(context, mVar.b()[iE]);
        int iC2 = androidx.core.content.a.c(context, mVar.c()[iE]);
        Drawable background = this.binding.iconPlaceholder.getBackground();
        Drawable drawableMutate = background != null ? background.mutate() : null;
        GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(iC);
            this.binding.iconPlaceholder.setBackground(gradientDrawable);
        }
        if (background == null || !(background instanceof GradientDrawable)) {
            this.binding.iconPlaceholder.setBackground(gradientDrawable);
        } else {
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(iC);
        }
        this.binding.tvSkillIconChar.setText(mVar.a(cliItem.getDisplayName()));
        this.binding.tvSkillIconChar.setTextColor(iC2);
    }

    public final void h(x.CliCard item) {
        kotlin.jvm.internal.p.i(item, "item");
        final SkillItem item2 = item.getItem();
        this.binding.tvTitle.setText(item2.getDisplayName());
        this.binding.tvSourceDownload.setText(String.valueOf(b5.j.c(item2.getDownloadCount())));
        this.binding.tvDescription.setText(item2.getSummary());
        this.binding.tvCli.setVisibility(0);
        this.binding.b().setAlpha(item.getIsUninstalling() ? 0.4f : 1.0f);
        g(item2);
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: c5.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.i(this.f15449a, item2);
            }
        };
        this.binding.actionArea.removeAllViews();
        B b10 = this.binding;
        FrameLayout frameLayout = b10.actionArea;
        d5.d dVar = d5.d.INSTANCE;
        Context context = b10.b().getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        SkillStatus status = item2.getStatus();
        if (status == null) {
            status = SkillStatus.UNINSTALLED;
        }
        frameLayout.addView(dVar.d(context, status, item.getIsToggling(), new InterfaceC5074l() { // from class: c5.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g.j(interfaceC5063a, (View) obj);
            }
        }, new InterfaceC5074l() { // from class: c5.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g.k(interfaceC5063a, (View) obj);
            }
        }, new InterfaceC5074l() { // from class: c5.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g.l(interfaceC5063a, (View) obj);
            }
        }, new InterfaceC5074l() { // from class: c5.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g.m(this.f15454a, item2, ((Boolean) obj).booleanValue());
            }
        }));
        this.binding.b().setOnClickListener(new View.OnClickListener() { // from class: c5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.n(interfaceC5063a, view);
            }
        });
    }
}
