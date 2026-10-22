package com.bytedanceos.appstore.ui;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.view.Window;
import bytedanceos.view.animation.TweenInterpolator;
import com.obric.appstore.base.BaseActivity;
import com.obric.appstore.buss.search.SearchContainerFragment;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/ui/SearchDetailActivity;", "Lcom/obric/appstore/base/BaseActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", FixCard.FixStyle.KEY_X, "Ljava/lang/Class;", "Lcom/obric/appstore/buss/search/SearchContainerFragment;", "e", "Ljava/lang/Class;", "v", "()Ljava/lang/Class;", "mFragmentClass", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchDetailActivity extends BaseActivity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class f9440e;

    public SearchDetailActivity() {
        this.f9440e = SearchContainerFragment.class;
    }

    @Override // com.obric.appstore.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        x();
        postponeEnterTransition();
        super.onCreate(r10);
    }

    @Override // com.obric.appstore.base.BaseActivity
    public Class v() {
        return this.f9440e;
    }

    public final void x() {
        getWindow().requestFeature(12);
        getWindow().requestFeature(13);
        Window r10 = getWindow();
        TransitionSet r11 = new TransitionSet();
        Fade r12 = new Fade();
        r12.setInterpolator(new TweenInterpolator(1));
        Token$Duration r13 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2;
        r12.setDuration(r13.getDuration());
        r11.addTransition(r12);
        r10.setEnterTransition(r11);
        Window r14 = getWindow();
        TransitionSet r15 = new TransitionSet();
        Fade r16 = new Fade();
        r16.setInterpolator(new TweenInterpolator(2));
        r16.setDuration(r13.getDuration());
        r15.addTransition(r16);
        r14.setReturnTransition(r15);
    }
}
