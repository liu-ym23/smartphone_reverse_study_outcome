package com.android.contacts.bytedanceosquickcontact;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.CubicInterpolator;
import com.obric.oui.button.OButton;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class QuickContactClickedView extends RelativeLayout {
    private int mAnimationDuration;
    private int[] mIds;
    private int mIndex;
    private LayoutInflater mInflater;
    private RelativeLayout mParentView;
    private int[] mShadowIds;
    private int mShadowsIndex;
    private int mSize;
    private OButton[] mUmbShadows;
    private OButton[] mUmbs;

    static /* synthetic */ OButton[] access$000(QuickContactClickedView r0) {
        return r0.mUmbs;
    }

    static /* synthetic */ int access$100(QuickContactClickedView r0) {
        return r0.mIndex;
    }

    static /* synthetic */ OButton[] access$200(QuickContactClickedView r0) {
        return r0.mUmbShadows;
    }

    static /* synthetic */ int access$300(QuickContactClickedView r0) {
        return r0.mShadowsIndex;
    }

    public QuickContactClickedView(Context r1, AttributeSet r2) {
        super(r1, r2);
        int[] r3 = {R.id.umb_phone, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        this.mIds = r3;
        int r4 = r3.length;
        this.mSize = r4;
        this.mUmbs = new OButton[r4];
        int[] r5 = {R.id.umb_phone_shadow, R.id.umb_normal_bg};
        this.mShadowIds = r5;
        this.mUmbShadows = new OButton[r5.length];
        this.mIndex = -1;
        this.mShadowsIndex = -1;
        this.mAnimationDuration = 200;
        LayoutInflater r6 = LayoutInflater.from(r1);
        this.mInflater = r6;
        this.mParentView = (RelativeLayout) r6.inflate(R.layout.quick_contact_clicked_view, this);
        initViews();
    }

    private void initViews() {
        int r0 = 0;
    L3:
        OButton[] r1 = this.mUmbs;
        if (r0 >= r1.length) goto L9;
        r1[r0] = (OButton) this.mParentView.findViewById(this.mIds[r0]);
        OButton[] r2 = this.mUmbShadows;
        if (r0 >= r2.length) goto L8;
        r2[r0] = (OButton) this.mParentView.findViewById(this.mShadowIds[r0]);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    public void setClicked(int r5, float r6, float r7) {
        this.mIndex = r5;
        this.mShadowsIndex = r5;
        if (r5 <= 1) goto L5;
        this.mShadowsIndex = 1;
    L5:
        this.mUmbs[r5].setX(r6);
        this.mUmbs[r5].setY(r7 - ContactsUtils.dipTopx(getContext(), 26.0d));
        this.mUmbShadows[this.mShadowsIndex].setX(r6);
        this.mUmbShadows[this.mShadowsIndex].setY(r7 - ContactsUtils.dipTopx(getContext(), 26.0d));
        this.mUmbs[r5].setVisibility(0);
        this.mUmbShadows[this.mShadowsIndex].setVisibility(0);
        scaleAnimator(this.mUmbs[r5], this.mUmbShadows[this.mShadowsIndex]);
    }

    public void scaleAnimator(View r12, View r13) {
        AnimatorSet r0 = new AnimatorSet();
        ArrayList r1 = new ArrayList();
        PropertyValuesHolder r3 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 4.0f});
        PropertyValuesHolder r4 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 4.0f});
        PropertyValuesHolder r2 = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r6 = ObjectAnimator.ofPropertyValuesHolder(r13, new PropertyValuesHolder[]{r4});
        r6.setDuration(this.mAnimationDuration);
        ObjectAnimator r8 = ObjectAnimator.ofPropertyValuesHolder(r13, new PropertyValuesHolder[]{r3});
        r8.setDuration(this.mAnimationDuration);
        ObjectAnimator r14 = ObjectAnimator.ofPropertyValuesHolder(r13, new PropertyValuesHolder[]{r2});
        r14.setDuration(this.mAnimationDuration);
        r1.add(r8);
        r1.add(r6);
        r1.add(r14);
        ObjectAnimator r15 = ObjectAnimator.ofPropertyValuesHolder(r12, new PropertyValuesHolder[]{r4});
        r15.setDuration(this.mAnimationDuration);
        ObjectAnimator r5 = ObjectAnimator.ofPropertyValuesHolder(r12, new PropertyValuesHolder[]{r3});
        r5.setDuration(this.mAnimationDuration);
        ObjectAnimator r16 = ObjectAnimator.ofPropertyValuesHolder(r12, new PropertyValuesHolder[]{r2});
        r16.setDuration(this.mAnimationDuration);
        r1.add(r5);
        r1.add(r15);
        r1.add(r16);
        r0.setInterpolator(CubicInterpolator.INOUT);
        r0.playTogether(r1);
        r0.addListener(new AnonymousClass1(this));
        r0.start();
    }
}
