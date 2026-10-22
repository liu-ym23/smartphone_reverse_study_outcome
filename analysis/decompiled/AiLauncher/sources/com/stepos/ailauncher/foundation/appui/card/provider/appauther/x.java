package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherCardModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u001c\u0010\u0018J\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\"\u0010\u0015R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/x;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", "w0", "(Landroid/widget/FrameLayout;)V", "", "x0", "()Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "J0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;)V", "Landroid/widget/TextView;", "F0", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "V0", "()Landroid/widget/ImageView;", "W0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "action", "", "z0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;)Ljava/lang/String;", "D0", "LT5/f;", "oauth", "LT5/f;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x extends AppAutherBaseCardView {
    private T5.f oauth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void D0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        R5.b.INSTANCE.c("auther.action.click", Y8.j.a("card", "oauth"), Y8.j.a("taskId", model.getCardId()), Y8.j.a("actionType", model.getActionType()));
        Q0(model);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView F0() {
        T5.f fVar = this.oauth;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("oauth");
            fVar = null;
        }
        TextView btnAutherPrimary = fVar.btnAutherPrimary;
        kotlin.jvm.internal.p.h(btnAutherPrimary, "btnAutherPrimary");
        return btnAutherPrimary;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void J0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        T5.f fVar = this.oauth;
        T5.f fVar2 = null;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("oauth");
            fVar = null;
        }
        ImageView ivAutherIcon = fVar.ivAutherIcon;
        kotlin.jvm.internal.p.h(ivAutherIcon, "ivAutherIcon");
        A0(ivAutherIcon, model.getIconUrl());
        T5.f fVar3 = this.oauth;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("oauth");
            fVar3 = null;
        }
        TextView tvAutherTitle = fVar3.tvAutherTitle;
        kotlin.jvm.internal.p.h(tvAutherTitle, "tvAutherTitle");
        n(tvAutherTitle, model.getTitle());
        T5.f fVar4 = this.oauth;
        if (fVar4 == null) {
            kotlin.jvm.internal.p.A("oauth");
        } else {
            fVar2 = fVar4;
        }
        TextView tvAutherDesc = fVar2.tvAutherDesc;
        kotlin.jvm.internal.p.h(tvAutherDesc, "tvAutherDesc");
        n(tvAutherDesc, model.getDesc());
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public ImageView V0() {
        return null;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView W0() {
        T5.f fVar = this.oauth;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("oauth");
            fVar = null;
        }
        TextView tvAutherStatus = fVar.tvAutherStatus;
        kotlin.jvm.internal.p.h(tvAutherStatus, "tvAutherStatus");
        return tvAutherStatus;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void w0(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        T5.f fVarB = T5.f.b(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(fVarB, "inflate(...)");
        this.oauth = fVarB;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public boolean x0() {
        return this.oauth != null;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public String z0(AppAutherCardModel model, AppAutherCardModel.ActionItem action) {
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(action, "action");
        return getAttemptedAuth() ? AbstractC3297l.LABEL_REAUTHORIZE : action.getLabel();
    }

    public /* synthetic */ x(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
