package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.C3302q;
import com.stepos.ailauncher.task.space.credential.CredentialApi;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0014¢\u0006\u0004\b \u0010\u001fJ\u001b\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\fH\u0014¢\u0006\u0004\b%\u0010\u001fJ\u0017\u0010&\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b&\u0010\u0015J\u0017\u0010'\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b'\u0010\u0015R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/p;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", "w0", "(Landroid/widget/FrameLayout;)V", "", "x0", "()Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "J0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;)V", "Landroid/widget/TextView;", "F0", "()Landroid/widget/TextView;", "N0", "Landroid/widget/ImageView;", "V0", "()Landroid/widget/ImageView;", "W0", "C0", "()V", "onDetachedFromWindow", "", "", "H0", "()Ljava/util/Map;", "q0", "D0", "E0", "LT5/d;", CredentialApi.BASE_URL_KEY, "LT5/d;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G;", "keyBlock", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3301p extends AppAutherBaseCardView {
    private T5.d credential;
    private G keyBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3301p(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final Y8.t b1() {
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void C0() {
        G g10 = this.keyBlock;
        G g11 = null;
        if (g10 == null) {
            kotlin.jvm.internal.p.A("keyBlock");
            g10 = null;
        }
        g10.n();
        G g12 = this.keyBlock;
        if (g12 == null) {
            kotlin.jvm.internal.p.A("keyBlock");
        } else {
            g11 = g12;
        }
        g11.m();
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void D0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        R5.b.INSTANCE.c("auther.action.click", Y8.j.a("card", CredentialApi.BASE_URL_KEY), Y8.j.a("taskId", model.getCardId()), Y8.j.a("mode", model.getMode()), Y8.j.a("action", "submit"));
        X0(model);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void E0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        R5.b.INSTANCE.c("auther.action.click", Y8.j.a("card", CredentialApi.BASE_URL_KEY), Y8.j.a("taskId", model.getCardId()), Y8.j.a("mode", model.getMode()), Y8.j.a("action", "fetch_key"));
        y0(model, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3301p.b1();
            }
        });
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView F0() {
        T5.d dVar = this.credential;
        if (dVar == null) {
            kotlin.jvm.internal.p.A(CredentialApi.BASE_URL_KEY);
            dVar = null;
        }
        TextView btnAutherPrimary = dVar.btnAutherPrimary;
        kotlin.jvm.internal.p.h(btnAutherPrimary, "btnAutherPrimary");
        return btnAutherPrimary;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public Map<String, String> H0() {
        G g10 = this.keyBlock;
        if (g10 == null) {
            kotlin.jvm.internal.p.A("keyBlock");
            g10 = null;
        }
        return g10.s();
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void J0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        T5.d dVar = this.credential;
        G g10 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A(CredentialApi.BASE_URL_KEY);
            dVar = null;
        }
        ImageView ivAutherIcon = dVar.ivAutherIcon;
        kotlin.jvm.internal.p.h(ivAutherIcon, "ivAutherIcon");
        A0(ivAutherIcon, model.getIconUrl());
        T5.d dVar2 = this.credential;
        if (dVar2 == null) {
            kotlin.jvm.internal.p.A(CredentialApi.BASE_URL_KEY);
            dVar2 = null;
        }
        TextView tvAutherTitle = dVar2.tvAutherTitle;
        kotlin.jvm.internal.p.h(tvAutherTitle, "tvAutherTitle");
        n(tvAutherTitle, model.getTitle());
        T5.d dVar3 = this.credential;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A(CredentialApi.BASE_URL_KEY);
            dVar3 = null;
        }
        TextView tvAutherDesc = dVar3.tvAutherDesc;
        kotlin.jvm.internal.p.h(tvAutherDesc, "tvAutherDesc");
        n(tvAutherDesc, model.getDesc());
        G g11 = this.keyBlock;
        if (g11 == null) {
            kotlin.jvm.internal.p.A("keyBlock");
        } else {
            g10 = g11;
        }
        g10.h(model.g(), getPhase() != 2, C3302q.Key.INSTANCE.a(model));
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView N0() {
        T5.d dVar = this.credential;
        if (dVar == null) {
            kotlin.jvm.internal.p.A(CredentialApi.BASE_URL_KEY);
            dVar = null;
        }
        TextView btnAutherSecondary = dVar.btnAutherSecondary;
        kotlin.jvm.internal.p.h(btnAutherSecondary, "btnAutherSecondary");
        return btnAutherSecondary;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public ImageView V0() {
        return null;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView W0() {
        T5.d dVar = this.credential;
        if (dVar == null) {
            kotlin.jvm.internal.p.A(CredentialApi.BASE_URL_KEY);
            dVar = null;
        }
        TextView tvAutherStatus = dVar.tvAutherStatus;
        kotlin.jvm.internal.p.h(tvAutherStatus, "tvAutherStatus");
        return tvAutherStatus;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView, N5.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        G g10;
        if (w() && (g10 = this.keyBlock) != null) {
            if (g10 == null) {
                kotlin.jvm.internal.p.A("keyBlock");
                g10 = null;
            }
            g10.n();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void q0() {
        G g10 = this.keyBlock;
        if (g10 == null) {
            kotlin.jvm.internal.p.A("keyBlock");
            g10 = null;
        }
        g10.m();
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void w0(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        T5.d dVarB = T5.d.b(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(dVarB, "inflate(...)");
        this.credential = dVarB;
        T5.d dVar = this.credential;
        if (dVar == null) {
            kotlin.jvm.internal.p.A(CredentialApi.BASE_URL_KEY);
            dVar = null;
        }
        LinearLayout llAutherKeyBlock = dVar.llAutherKeyBlock;
        kotlin.jvm.internal.p.h(llAutherKeyBlock, "llAutherKeyBlock");
        this.keyBlock = new G(llAutherKeyBlock);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public boolean x0() {
        return this.credential != null;
    }

    public /* synthetic */ C3301p(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
