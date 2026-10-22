package c91;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.message.model.j4;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f22835a;

    public c(a r100) {
        this.f22835a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        a r101 = this.f22835a;
        r101.f22830h = null;
        if ((!r101.f22832j.isEmpty()) == false) goto L6;
        a r102 = this.f22835a;
        r102.a((j4) ListProtector.remove(r102.f22832j, 0));
        return;
    }
}
