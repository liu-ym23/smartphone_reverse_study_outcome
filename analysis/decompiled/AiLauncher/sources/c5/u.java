package c5;

import Y4.B;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.chat.view.C2765a9;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0017"}, d2 = {"Lc5/u;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LY4/B;", "binding", "Lc5/l;", "callbacks", "<init>", "(LY4/B;Lc5/l;)V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "skillItem", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "Lc5/x$e;", "item", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lc5/x$e;)V", "", "isToggling", "l", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Z)V", "LY4/B;", "Lc5/l;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u extends RecyclerView.ViewHolder {
    private final B binding;
    private final SkillCardCallbacks callbacks;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SkillStatus.values().length];
            try {
                iArr[SkillStatus.UNINSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkillStatus.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SkillStatus.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SkillStatus.UNINSTALLING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SkillStatus.TOGGLING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SkillStatus.INSTALLED_ENABLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SkillStatus.INSTALLED_DISABLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SkillStatus.INSTALL_FAILED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(B binding, SkillCardCallbacks callbacks) {
        super(binding.b());
        kotlin.jvm.internal.p.i(binding, "binding");
        kotlin.jvm.internal.p.i(callbacks, "callbacks");
        this.binding = binding;
        this.callbacks = callbacks;
    }

    private final void i(SkillItem skillItem) {
        Context context = this.binding.b().getContext();
        d5.m mVar = d5.m.INSTANCE;
        int iE = mVar.e(skillItem.getIdentifier(), mVar.d());
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
        this.binding.tvSkillIconChar.setText(mVar.a(skillItem.getDisplayName()));
        this.binding.tvSkillIconChar.setTextColor(iC2);
        ImageView ivSkillIcon = this.binding.ivSkillIcon;
        kotlin.jvm.internal.p.h(ivSkillIcon, "ivSkillIcon");
        TextView tvSkillIconChar = this.binding.tvSkillIconChar;
        kotlin.jvm.internal.p.h(tvSkillIconChar, "tvSkillIconChar");
        C2765a9.a(ivSkillIcon, tvSkillIconChar, skillItem.getIconUrl());
    }

    public static final void k(u uVar, SkillItem skillItem, View view) {
        uVar.callbacks.b().invoke(skillItem);
    }

    public static final Y8.t m(u uVar, SkillItem skillItem, View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        uVar.callbacks.d().invoke(skillItem);
        return Y8.t.f7040a;
    }

    public static final Y8.t n(u uVar, SkillItem skillItem, View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        uVar.callbacks.e().invoke(skillItem);
        return Y8.t.f7040a;
    }

    public static final Y8.t o(u uVar, SkillItem skillItem, View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        uVar.callbacks.d().invoke(skillItem);
        return Y8.t.f7040a;
    }

    public static final Y8.t p(u uVar, SkillItem skillItem, View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        uVar.callbacks.a().invoke(skillItem);
        return Y8.t.f7040a;
    }

    public static final Y8.t q(View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        return Y8.t.f7040a;
    }

    public static final Y8.t r(u uVar, SkillItem skillItem, boolean z10) {
        uVar.callbacks.f().invoke(skillItem, Boolean.valueOf(z10));
        return Y8.t.f7040a;
    }

    public static final Y8.t s(u uVar, SkillItem skillItem, boolean z10) {
        uVar.callbacks.f().invoke(skillItem, Boolean.valueOf(z10));
        return Y8.t.f7040a;
    }

    @SuppressLint({"SetTextI18n"})
    public final void j(x.SkillCard item) {
        kotlin.jvm.internal.p.i(item, "item");
        final SkillItem item2 = item.getItem();
        this.binding.tvTitle.setText(item2.getDisplayName());
        this.binding.tvSourceDownload.setText(String.valueOf(b5.j.c(item2.getDownloadCount())));
        this.binding.tvDescription.setText(item2.getSummary());
        boolean z10 = item2.getStatus() == SkillStatus.INSTALLED_ENABLED || item2.getStatus() == SkillStatus.INSTALLED_DISABLED || item2.getStatus() == SkillStatus.INSTALLED;
        TextView tvUpdateBadge = this.binding.tvUpdateBadge;
        kotlin.jvm.internal.p.h(tvUpdateBadge, "tvUpdateBadge");
        tvUpdateBadge.setVisibility(b5.j.b(item2) && z10 ? 0 : 8);
        this.binding.b().setAlpha(item2.getStatus() == SkillStatus.INSTALLED_DISABLED ? 0.4f : 1.0f);
        l(item2, item.getIsToggling());
        i(item2);
        this.binding.b().setOnClickListener(new View.OnClickListener() { // from class: c5.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.k(this.f15459a, item2, view);
            }
        });
    }

    public final void l(final SkillItem skillItem, boolean isToggling) {
        this.binding.actionArea.removeAllViews();
        this.binding.actionArea.setClickable(true);
        V3.b.c(V3.b.f6474a, "SkillCard", String.valueOf(skillItem.getStatus()), null, 4, null);
        SkillStatus status = skillItem.getStatus();
        switch (status == null ? -1 : a.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
                d5.l lVar = d5.l.INSTANCE;
                Context context = this.binding.b().getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                this.binding.actionArea.addView(lVar.j(context, new InterfaceC5074l() { // from class: c5.n
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return u.m(this.f15461a, skillItem, (View) obj);
                    }
                }));
                break;
            case 2:
                d5.l lVar2 = d5.l.INSTANCE;
                Context context2 = this.binding.b().getContext();
                kotlin.jvm.internal.p.h(context2, "getContext(...)");
                this.binding.actionArea.addView(lVar2.o(context2, new InterfaceC5074l() { // from class: c5.o
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return u.p(this.f15463a, skillItem, (View) obj);
                    }
                }));
                break;
            case 3:
            case 4:
            case 5:
                d5.l lVar3 = d5.l.INSTANCE;
                Context context3 = this.binding.b().getContext();
                kotlin.jvm.internal.p.h(context3, "getContext(...)");
                this.binding.actionArea.addView(lVar3.l(context3, new InterfaceC5074l() { // from class: c5.p
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return u.q((View) obj);
                    }
                }));
                break;
            case 6:
                d5.l lVar4 = d5.l.INSTANCE;
                Context context4 = this.binding.b().getContext();
                kotlin.jvm.internal.p.h(context4, "getContext(...)");
                this.binding.actionArea.addView(lVar4.s(context4, true, true, !isToggling, new InterfaceC5074l() { // from class: c5.q
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return u.r(this.f15465a, skillItem, ((Boolean) obj).booleanValue());
                    }
                }));
                break;
            case 7:
                d5.l lVar5 = d5.l.INSTANCE;
                Context context5 = this.binding.b().getContext();
                kotlin.jvm.internal.p.h(context5, "getContext(...)");
                this.binding.actionArea.addView(lVar5.s(context5, false, true, !isToggling, new InterfaceC5074l() { // from class: c5.r
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return u.s(this.f15467a, skillItem, ((Boolean) obj).booleanValue());
                    }
                }));
                break;
            case 8:
                d5.l lVar6 = d5.l.INSTANCE;
                Context context6 = this.binding.b().getContext();
                kotlin.jvm.internal.p.h(context6, "getContext(...)");
                this.binding.actionArea.addView(lVar6.q(context6, new InterfaceC5074l() { // from class: c5.s
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return u.n(this.f15469a, skillItem, (View) obj);
                    }
                }));
                break;
            default:
                d5.l lVar7 = d5.l.INSTANCE;
                Context context7 = this.binding.b().getContext();
                kotlin.jvm.internal.p.h(context7, "getContext(...)");
                this.binding.actionArea.addView(lVar7.j(context7, new InterfaceC5074l() { // from class: c5.t
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return u.o(this.f15471a, skillItem, (View) obj);
                    }
                }));
                break;
        }
    }
}
