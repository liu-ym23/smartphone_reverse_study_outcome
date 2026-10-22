package H2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.stepos.common.widget.StepOSEditInputView;
import com.stepos.familyguard.R;
import j2.C0789f;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public abstract class O0 extends com.stepos.familyguard.ui.base.f<String, Long> {

    /* renamed from: f, reason: collision with root package name */
    protected C0789f f2748f;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) {
        getOnBackPressedDispatcher().k();
    }

    @Override // com.stepos.familyguard.ui.base.f
    protected StepOSEditInputView p0() {
        return this.f2748f.f17705b;
    }

    @Override // com.stepos.familyguard.ui.base.f
    protected TextView q0() {
        return (TextView) this.f2748f.f17706c.findViewById(R.id.stepos_get_verify_code);
    }

    @Override // com.stepos.familyguard.ui.base.f
    protected TextView r0() {
        return this.f2748f.f17710g;
    }

    @Override // com.stepos.familyguard.ui.base.f
    protected StepOSEditInputView s0() {
        return this.f2748f.f17706c;
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        this.f2748f = C0789f.c(getLayoutInflater());
        if (TextUtils.equals("CN", getResources().getConfiguration().locale.getCountry())) {
            T1.g.e(1.18f, this.f2748f.b());
        } else {
            T1.g.e(1.06f, this.f2748f.b());
        }
        return this.f2748f.b();
    }

    @Override // com.stepos.familyguard.ui.base.f, i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) {
        super.y(view, bundle);
        x2.g.h(this.f2748f.f17709f, BuildConfig.FLAVOR, new View.OnClickListener() { // from class: H2.N0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2746a.R0(view2);
            }
        });
        T1.g.c(1.44f, (TextView) this.f2748f.f17706c.findViewById(R.id.stepos_get_verify_code));
        T1.g.c(1.44f, this.f2748f.f17706c.getEditText());
        T1.g.c(1.44f, this.f2748f.f17705b.getEditText());
        T1.g.c(1.44f, this.f2748f.f17705b.getTitleView());
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        x2.g.d(this);
    }
}
