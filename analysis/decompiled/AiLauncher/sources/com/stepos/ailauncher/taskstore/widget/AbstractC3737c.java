package com.stepos.ailauncher.taskstore.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010'\u001a\u0004\u0018\u00010\f8\u0005@\u0005X\u0084\u000e¢\u0006\u0018\n\u0004\b'\u0010(\u0012\u0004\b,\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010 R\u0014\u00101\u001a\u00020.8$X¤\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u00020.8$X¤\u0004¢\u0006\u0006\u001a\u0004\b2\u00100R\u0014\u00107\u001a\u0002048$X¤\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/c;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "Lcom/stepos/ailauncher/taskstore/widget/k;", "listener", "LY8/t;", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Lcom/stepos/ailauncher/taskstore/widget/k;)V", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "color", "e", "(Ljava/lang/CharSequence;I)V", "res", "setIcon", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "setActionListener", "(Lcom/stepos/ailauncher/taskstore/widget/k;)V", "boundCard", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "getBoundCard", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "setBoundCard", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "actionListener", "Lcom/stepos/ailauncher/taskstore/widget/k;", "getActionListenerField", "()Lcom/stepos/ailauncher/taskstore/widget/k;", "setActionListenerField", "getActionListenerField$annotations", "()V", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "getSubtitleView", "subtitleView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.widget.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3737c extends FrameLayout {
    private InterfaceC3745k actionListener;
    private TaskInfoCard boundCard;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC3737c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC3737c.b(this.f29357a, view);
            }
        });
    }

    public static final void b(AbstractC3737c abstractC3737c, View view) {
        InterfaceC3745k interfaceC3745k = abstractC3737c.actionListener;
        if (interfaceC3745k != null) {
            interfaceC3745k.a(abstractC3737c.boundCard);
        }
    }

    public static /* synthetic */ void d(AbstractC3737c abstractC3737c, TaskInfoCard taskInfoCard, InterfaceC3745k interfaceC3745k, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindData");
        }
        if ((i10 & 2) != 0) {
            interfaceC3745k = null;
        }
        abstractC3737c.c(taskInfoCard, interfaceC3745k);
    }

    public static /* synthetic */ void getActionListenerField$annotations() {
    }

    public void c(TaskInfoCard card, InterfaceC3745k listener) {
        kotlin.jvm.internal.p.i(card, "card");
        this.boundCard = card;
        if (listener != null) {
            this.actionListener = listener;
        }
        C3752s c3752s = C3752s.INSTANCE;
        setTitle(c3752s.e(card));
        e(c3752s.c(card), androidx.core.content.a.c(getContext(), c3752s.d(card)));
    }

    public final void e(CharSequence text, int color) {
        getSubtitleView().setText(text);
        getSubtitleView().setTextColor(color);
    }

    /* renamed from: getActionListenerField, reason: from getter */
    public final InterfaceC3745k getActionListener() {
        return this.actionListener;
    }

    public final TaskInfoCard getBoundCard() {
        return this.boundCard;
    }

    public abstract ImageView getIconView();

    public abstract TextView getSubtitleView();

    public abstract TextView getTitleView();

    public final void setActionListener(InterfaceC3745k listener) {
        this.actionListener = listener;
    }

    public final void setActionListenerField(InterfaceC3745k interfaceC3745k) {
        this.actionListener = interfaceC3745k;
    }

    public final void setBoundCard(TaskInfoCard taskInfoCard) {
        this.boundCard = taskInfoCard;
    }

    public final void setIcon(int res) {
        getIconView().setImageResource(res);
    }

    public final void setSubtitle(CharSequence text) {
        getSubtitleView().setText(text);
    }

    public final void setTitle(CharSequence text) {
        getTitleView().setText(text);
    }

    public final void setIcon(Drawable drawable) {
        getIconView().setImageDrawable(drawable);
    }
}
