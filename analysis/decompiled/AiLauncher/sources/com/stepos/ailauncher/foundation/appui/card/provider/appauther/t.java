package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import Z8.C1173v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.C3302q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0014¢\u0006\u0004\b \u0010\u001fJ\u001b\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\fH\u0014¢\u0006\u0004\b%\u0010\u001fJ\u0017\u0010&\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b&\u0010\u0015J#\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b,\u0010\u0015R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\"0'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/t;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", "w0", "(Landroid/widget/FrameLayout;)V", "", "x0", "()Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "J0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;)V", "Landroid/widget/TextView;", "F0", "()Landroid/widget/TextView;", "N0", "Landroid/widget/ImageView;", "V0", "()Landroid/widget/ImageView;", "W0", "C0", "()V", "onDetachedFromWindow", "", "", "H0", "()Ljava/util/Map;", "q0", "D0", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/r;", "fields", "b1", "(Ljava/util/List;)Ljava/util/List;", SdCardDbCreator.FIELD_LASTLOC_ID, "LT5/e;", "guide", "LT5/e;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G;", "keyBlock", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/G;", "boundSteps", "Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class t extends AppAutherBaseCardView {
    private List<String> boundSteps;
    private T5.e guide;
    private G keyBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.boundSteps = C1173v.m();
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
        R5.b.INSTANCE.c("auther.action.click", Y8.j.a("card", "guide"), Y8.j.a("taskId", model.getCardId()), Y8.j.a("mode", model.getMode()), Y8.j.a("action", "submit"));
        X0(model);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView F0() {
        T5.e eVar = this.guide;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("guide");
            eVar = null;
        }
        TextView btnAutherPrimary = eVar.btnAutherPrimary;
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
        T5.e eVar = this.guide;
        G g10 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("guide");
            eVar = null;
        }
        ImageView ivAutherIcon = eVar.ivAutherIcon;
        kotlin.jvm.internal.p.h(ivAutherIcon, "ivAutherIcon");
        A0(ivAutherIcon, model.getIconUrl());
        T5.e eVar2 = this.guide;
        if (eVar2 == null) {
            kotlin.jvm.internal.p.A("guide");
            eVar2 = null;
        }
        TextView tvAutherTitle = eVar2.tvAutherTitle;
        kotlin.jvm.internal.p.h(tvAutherTitle, "tvAutherTitle");
        n(tvAutherTitle, model.getTitle());
        a1(model);
        G g11 = this.keyBlock;
        if (g11 == null) {
            kotlin.jvm.internal.p.A("keyBlock");
        } else {
            g10 = g11;
        }
        g10.h(b1(model.g()), getPhase() != 2, C3302q.Key.INSTANCE.a(model));
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView N0() {
        return null;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public ImageView V0() {
        return null;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView W0() {
        T5.e eVar = this.guide;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("guide");
            eVar = null;
        }
        TextView tvAutherStatus = eVar.tvAutherStatus;
        kotlin.jvm.internal.p.h(tvAutherStatus, "tvAutherStatus");
        return tvAutherStatus;
    }

    public final void a1(AppAutherCardModel model) {
        List<String> listU = model.u();
        boolean zIsEmpty = listU.isEmpty();
        T5.e eVar = this.guide;
        T5.e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("guide");
            eVar = null;
        }
        eVar.llAutherSteps.setVisibility(!zIsEmpty ? 0 : 8);
        T5.e eVar3 = this.guide;
        if (eVar3 == null) {
            kotlin.jvm.internal.p.A("guide");
            eVar3 = null;
        }
        eVar3.tvAutherDesc.setVisibility(zIsEmpty ? 0 : 8);
        if (zIsEmpty) {
            T5.e eVar4 = this.guide;
            if (eVar4 == null) {
                kotlin.jvm.internal.p.A("guide");
                eVar4 = null;
            }
            TextView tvAutherDesc = eVar4.tvAutherDesc;
            kotlin.jvm.internal.p.h(tvAutherDesc, "tvAutherDesc");
            n(tvAutherDesc, model.getDesc());
            this.boundSteps = C1173v.m();
            T5.e eVar5 = this.guide;
            if (eVar5 == null) {
                kotlin.jvm.internal.p.A("guide");
            } else {
                eVar2 = eVar5;
            }
            eVar2.llAutherSteps.removeAllViews();
            return;
        }
        if (kotlin.jvm.internal.p.d(listU, this.boundSteps)) {
            return;
        }
        this.boundSteps = listU;
        T5.e eVar6 = this.guide;
        if (eVar6 == null) {
            kotlin.jvm.internal.p.A("guide");
            eVar6 = null;
        }
        eVar6.llAutherSteps.removeAllViews();
        for (String str : listU) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            T5.e eVar7 = this.guide;
            if (eVar7 == null) {
                kotlin.jvm.internal.p.A("guide");
                eVar7 = null;
            }
            T5.g gVarB = T5.g.b(layoutInflaterFrom, eVar7.llAutherSteps, true);
            kotlin.jvm.internal.p.h(gVarB, "inflate(...)");
            gVarB.tvStepBullet.setText(AbstractC3297l.BULLET);
            gVarB.tvStepText.setText(str);
        }
    }

    public final List<AppAutherField> b1(List<AppAutherField> fields) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : fields) {
            if (((AppAutherField) obj).getSecret()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            AppAutherField appAutherField = (AppAutherField) obj2;
            String name = appAutherField.getName();
            if (name == null) {
                name = "";
            }
            String label = appAutherField.getLabel();
            String str = name + " " + (label != null ? label : "");
            if (La.H.e0(str, "secret", true) || La.H.g0(str, "密钥", false, 2, null) || La.H.g0(str, "密匙", false, 2, null)) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2.isEmpty() ? arrayList : arrayList2;
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
        T5.e eVarB = T5.e.b(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(eVarB, "inflate(...)");
        this.guide = eVarB;
        T5.e eVar = this.guide;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("guide");
            eVar = null;
        }
        LinearLayout llAutherKeyBlock = eVar.llAutherKeyBlock;
        kotlin.jvm.internal.p.h(llAutherKeyBlock, "llAutherKeyBlock");
        this.keyBlock = new G(llAutherKeyBlock);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public boolean x0() {
        return this.guide != null;
    }

    public /* synthetic */ t(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
