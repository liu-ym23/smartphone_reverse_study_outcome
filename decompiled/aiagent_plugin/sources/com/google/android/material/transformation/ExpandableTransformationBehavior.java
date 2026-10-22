package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimatorSet f13688a;

    public abstract AnimatorSet b(View r1, View r2, boolean r3, boolean r4);

    static /* synthetic */ AnimatorSet a(ExpandableTransformationBehavior r0, AnimatorSet r1) {
        r0.f13688a = r1;
        return r1;
    }

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean a(View r4, View r5, boolean r6, boolean r7) {
        AnimatorSet r0 = this.f13688a;
        if (r0 == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r0.cancel();
    L8:
        AnimatorSet r8 = b(r4, r5, r6, r2);
        this.f13688a = r8;
        r8.addListener(new AnonymousClass1(this));
        this.f13688a.start();
        if (r7 == true) goto L11;
        this.f13688a.end();
    L11:
        return true;
    L5:
        r2 = false;
        goto L6
    }
}
