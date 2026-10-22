package com.zyql.ai.selector.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;

/* loaded from: classes4.dex */
public class AlphaInAnimationAdapter extends BaseAnimationAdapter {
    private static final float DEFAULT_ALPHA_FROM = 0.0f;
    private final float mFrom;

    public AlphaInAnimationAdapter(RecyclerView.Adapter adapter) {
        this(adapter, 0.0f);
    }

    @Override // com.zyql.ai.selector.animators.BaseAnimationAdapter
    public Animator[] getAnimators(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, this.mFrom, 1.0f)};
    }

    public AlphaInAnimationAdapter(RecyclerView.Adapter adapter, float f10) {
        super(adapter);
        this.mFrom = f10;
    }
}
