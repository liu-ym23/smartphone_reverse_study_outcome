package androidx.core.app;

import androidx.preference.InterfaceC0344p;
import androidx.preference.Preference;
import com.stepos.alphame.persona.privacy.OnPolicyCheckListener;
import com.stepos.alphame.persona.privacy.PolicyManager;
import com.stepos.alphame.persona.ui.PersonalMainFragment;
import com.stepos.common.drawble.SurroundShaderDrawable;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.renderfilter.functor.DrawGlInfo;
import com.stepos.renderfilter.functor.Functor;
import h3.InterfaceC0591A;
import java.io.Serializable;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements PolicySdk.PolicySdkCallback, InterfaceC0344p, C2.a, InterfaceC0591A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3281a;

    public /* synthetic */ f(Object obj) {
        this.f3281a = obj;
    }

    @Override // C2.a
    public final void a(Functor functor) {
        functor.f12306b.d((DrawGlInfo) this.f3281a);
    }

    @Override // androidx.preference.InterfaceC0344p
    public final boolean b(Preference preference, Serializable serializable) {
        return PersonalMainFragment.initView$lambda$1((PersonalMainFragment) this.f3281a, preference, serializable);
    }

    public final void c() {
        ((SurroundShaderDrawable) this.f3281a).invalidateSelf();
    }

    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
    public final void getResult(PolicySdkResultBean policySdkResultBean) {
        PolicyManager.checkNewestPolicy$lambda$0((OnPolicyCheckListener) this.f3281a, policySdkResultBean);
    }
}
