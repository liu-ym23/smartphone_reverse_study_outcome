package stepos.support.v7.app;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import stepos.support.v7.permission.TermsStringBuilder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e0 implements TermsStringBuilder.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f12103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g0 f12104b;

    public e0(g0 g0Var, TextView textView) {
        this.f12104b = g0Var;
        this.f12103a = textView;
    }

    @Override // stepos.support.v7.permission.TermsStringBuilder.a
    public final void onPrivacyPolicyClick(Context context) {
        com.stepos.policy.sdk.a aVar = this.f12104b.f12112f;
        if (aVar != null) {
            aVar.onClick(this.f12103a);
        }
    }

    @Override // stepos.support.v7.permission.TermsStringBuilder.a
    public final void onUserAgreementClick(Context context) {
        View.OnClickListener onClickListener = this.f12104b.f12113g;
        if (onClickListener != null) {
            onClickListener.onClick(this.f12103a);
        }
    }
}
