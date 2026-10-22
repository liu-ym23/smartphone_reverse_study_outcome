package com.android.contacts.bytedanceosquickcontact;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.CubicInterpolator;
import com.obric.oui.button.OButton;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class QuickContactChildLayout extends RelativeLayout {
    private static final String TAG = "FloatingChild";
    private final int mAnimationDuration;
    private Context mContext;
    private int mFixedTopPosition;
    private int[] mIds;
    private boolean mIsAnimationing;
    private boolean mIsShow;
    private TextView mLeftHandView;
    private View.OnTouchListener mOutsideTouchListener;
    private TextView mPhotoFrontNormal;
    private TextView mPhotoFrontQuickContact;
    private QuickContactListener mQuickContactListener;
    private LinearLayout mQuickContactView;
    private int[] mShadowIds;
    private int mSize;
    private Rect mTargetScreen;
    private OButton[] mUmbShadows;
    private OButton[] mUmbs;

    public class onExitAnimationEndRunnable implements Runnable {
        final /* synthetic */ QuickContactChildLayout this$0;

        public onExitAnimationEndRunnable(QuickContactChildLayout r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            QuickContactChildLayout.access$002(this.this$0, false);
            QuickContactChildLayout.access$100(this.this$0).setVisibility(8);
            QuickContactChildLayout.access$200(this.this$0).setVisibility(8);
            QuickContactChildLayout.access$302(this.this$0, false);
            QuickContactChildLayout.access$400(this.this$0).setIsShowQuickContact(false);
            QuickContactChildLayout.access$400(this.this$0).setQuickContactCacheId(-1);
            QuickContactChildLayout.access$400(this.this$0).setQuickContactHelperCache(null);
            QuickContactChildLayout.access$400(this.this$0).setHasAddedTime(false);
        }
    }

    static /* synthetic */ boolean access$002(QuickContactChildLayout r0, boolean r1) {
        r0.mIsShow = r1;
        return r1;
    }

    static /* synthetic */ TextView access$100(QuickContactChildLayout r0) {
        return r0.mPhotoFrontQuickContact;
    }

    static /* synthetic */ LinearLayout access$200(QuickContactChildLayout r0) {
        return r0.mQuickContactView;
    }

    static /* synthetic */ boolean access$302(QuickContactChildLayout r0, boolean r1) {
        r0.mIsAnimationing = r1;
        return r1;
    }

    static /* synthetic */ QuickContactListener access$400(QuickContactChildLayout r0) {
        return r0.mQuickContactListener;
    }

    public QuickContactChildLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mTargetScreen = new Rect();
        int[] r0 = {R.id.umb_phone, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        this.mIds = r0;
        int r1 = r0.length;
        this.mSize = r1;
        this.mUmbs = new OButton[r1];
        int[] r4 = {R.id.umb_phone_shadow, R.id.umb_message_shadow, R.id.umb_star_shadow, R.id.umb_group_shadow, R.id.umb_avatar_shadow};
        this.mShadowIds = r4;
        this.mUmbShadows = new OButton[r4.length];
        this.mIsAnimationing = false;
        this.mContext = r2;
        Resources r5 = getResources();
        this.mFixedTopPosition = r5.getDimensionPixelOffset(R.dimen.quick_contact_top_position);
        this.mAnimationDuration = r5.getInteger(android.R.integer.config_shortAnimTime);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mQuickContactView = (LinearLayout) findViewById(R.id.quick_contact_view);
        this.mLeftHandView = (TextView) findViewById(R.id.right_hand);
    }

    public void initViews() {
        View r0 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.quickcontact_animator, null);
        this.mQuickContactView.removeAllViewsInLayout();
        this.mQuickContactView.addView(r0);
        this.mPhotoFrontNormal = (TextView) findViewById(R.id.photo_front_normal);
        this.mPhotoFrontQuickContact = (TextView) findViewById(R.id.photo_front_quickcontact);
        int r1 = 0;
    L3:
        OButton[] r2 = this.mUmbs;
        if (r1 >= r2.length) goto L6;
        r2[r1] = (OButton) findViewById(this.mIds[r1]);
        this.mUmbShadows[r1] = (OButton) findViewById(this.mShadowIds[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public TextView getPhotoFrontView() {
        if (this.mPhotoFrontNormal != null) goto L6;
        initViews();
    L6:
        return this.mPhotoFrontNormal;
    }

    public TextView getRightHandView() {
        return this.mLeftHandView;
    }

    public OButton getButtonAt(int r1) {
        return this.mUmbs[r1];
    }

    public int getButtonCount() {
        return this.mUmbs.length;
    }

    public boolean isAnimationing() {
        return this.mIsAnimationing;
    }

    public void setAnimationing(boolean r1) {
        this.mIsAnimationing = r1;
    }

    public void setQuickContactListener(QuickContactListener r1) {
        this.mQuickContactListener = r1;
    }

    public void changeQuickBtnState(boolean r2) {
        if (r2 == false) goto L5;
        getButtonAt(2).setMIcon(this.mContext.getResources().getDrawable(R.drawable.umb_starred));
        return;
    L5:
        getButtonAt(2).setMIcon(this.mContext.getResources().getDrawable(R.drawable.umb_fav));
    }

    public void showChild(Runnable r3) {
        if (this.mIsAnimationing == false) goto L5;
        return;
    L5:
        this.mPhotoFrontNormal.setVisibility(8);
        this.mPhotoFrontQuickContact.setVisibility(0);
        this.mQuickContactView.setVisibility(0);
        this.mQuickContactListener.setQuickContactView(this);
        animateTranslate(false, -1, r3);
    }

    public void showChildWhitOutAnimate() {
        this.mPhotoFrontNormal.setVisibility(8);
        this.mPhotoFrontQuickContact.setVisibility(0);
        this.mQuickContactView.setVisibility(0);
        this.mQuickContactListener.setQuickContactView(this);
        translateWithOutAnimate(false);
    }

    public void hideChild(int r3, Runnable r4) {
        if (this.mIsAnimationing == false) goto L5;
        return;
    L5:
        TextView r0 = this.mLeftHandView;
        if (r0 == null) goto L8;
        r0.setBackgroundResource(R.drawable.selecter_right_hand_btn);
    L8:
        animateTranslate(true, r3, r4);
    }

    public Runnable exitAnimationEndRunnable() {
        return new onExitAnimationEndRunnable(this);
    }

    public void setQuickContactViewExit(boolean r4) {
        this.mIsShow = false;
        this.mPhotoFrontQuickContact.setVisibility(8);
        this.mQuickContactView.setVisibility(8);
        this.mIsAnimationing = false;
        this.mQuickContactListener.setIsShowQuickContact(false);
        if (r4 == false) goto L6;
        this.mQuickContactListener.setQuickContactCacheId(-1);
        return;
    }

    public void translateWithOutAnimate(boolean r9) {
        if (r9 == true) goto L7;
        int r0 = 0;
    L5:
        if (r0 >= this.mSize) goto L10;
        this.mUmbs[r0].setVisibility(0);
        this.mUmbShadows[r0].setVisibility(0);
        this.mUmbs[r0].setX((ContactsUtils.dipTopx(this.mContext, 64.0d) * r0) + ContactsUtils.dipTopx(this.mContext, 60.0d));
        this.mUmbShadows[r0].setX((ContactsUtils.dipTopx(this.mContext, 64.0d) * r0) + ContactsUtils.dipTopx(this.mContext, 60.0d));
        r0 = r0 + 1;
        goto L5
    L10:
        return;
    L7:
        int r10 = this.mSize - 1;
    L8:
        if (r10 < 0) goto L13;
        this.mUmbs[r10].setX(0.0f);
        this.mUmbShadows[r10].setX(0.0f);
        r10 = r10 - 1;
        goto L8
    }

    private void animateTranslate(boolean r19, int r20, final Runnable r21) {
        int r2 = 1;
        this.mIsAnimationing = true;
        AnimatorSet r3 = new AnimatorSet();
        ArrayList r4 = new ArrayList();
        double r5 = 60.0d;
        double r7 = 64.0d;
        String r9 = MaterialConfigFormatNames.X;
        float r11 = 0.0f;
        int r12 = 2;
        int r13 = 0;
        if (r19 == true) goto L9;
        PropertyValuesHolder r10 = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f});
        int r14 = 0;
    L6:
        if (r14 >= this.mSize) goto L8;
        this.mUmbs[r14].setVisibility(r13);
        this.mUmbShadows[r14].setVisibility(r13);
        float[] r15 = new float[r12];
        r15[r13] = r11;
        r15[r2] = (ContactsUtils.dipTopx(this.mContext, r7) * r14) + ContactsUtils.dipTopx(this.mContext, r5);
        PropertyValuesHolder r8 = PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, r15);
        OButton r16 = this.mUmbs[r14];
        PropertyValuesHolder[] r17 = new PropertyValuesHolder[r2];
        r17[r13] = r8;
        ObjectAnimator r18 = ObjectAnimator.ofPropertyValuesHolder(r16, r17);
        r18.setInterpolator(CubicInterpolator.OUT);
        int r110 = r14 + 1;
        long r111 = r110;
        r18.setDuration(((long) (this.mAnimationDuration / this.mSize)) * r111);
        r4.add(r18);
        OButton r6 = this.mUmbs[r14];
        PropertyValuesHolder[] r22 = new PropertyValuesHolder[r2];
        r22[0] = r10;
        ObjectAnimator r23 = ObjectAnimator.ofPropertyValuesHolder(r6, r22);
        r23.setDuration(((long) (this.mAnimationDuration / this.mSize)) * r111);
        r23.setInterpolator(CubicInterpolator.OUT);
        r4.add(r23);
        ObjectAnimator r24 = ObjectAnimator.ofPropertyValuesHolder(this.mUmbShadows[r14], new PropertyValuesHolder[]{r8});
        r24.setInterpolator(CubicInterpolator.OUT);
        r24.setDuration(((long) (this.mAnimationDuration / this.mSize)) * r111);
        r4.add(r24);
        ObjectAnimator r25 = ObjectAnimator.ofPropertyValuesHolder(this.mUmbShadows[r14], new PropertyValuesHolder[]{r10});
        r25.setDuration(((long) (this.mAnimationDuration / this.mSize)) * r111);
        r25.setInterpolator(CubicInterpolator.OUT);
        r4.add(r25);
        r14 = r110;
        r3 = r3;
        r2 = 1;
        r5 = 60.0d;
        r7 = 64.0d;
        r11 = 0.0f;
        r12 = 2;
        r13 = 0;
        goto L6
    L8:
        AnimatorSet r26 = r3;
    L17:
        r26.playTogether(r4);
        if (r21 == null) goto L20;
        r26.addListener(new AnonymousClass1(this, r21));
    L20:
        r26.start();
        return;
    L9:
        int r27 = 2;
        PropertyValuesHolder r28 = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f});
        int r29 = this.mSize - 1;
    L10:
        if (r29 < 0) goto L16;
        if (r29 == r20) goto L14;
        float[] r30 = new float[r27];
        r30[0] = (ContactsUtils.dipTopx(this.mContext, 64.0d) * r29) + ContactsUtils.dipTopx(this.mContext, 60.0d);
        r30[1] = 0.0f;
        PropertyValuesHolder r31 = PropertyValuesHolder.ofFloat(r9, r30);
        int r112 = this.mAnimationDuration;
        int r113 = this.mSize;
        long r32 = ((long) (r112 / r113)) * ((long) (r113 - (r29 + 1)));
        ObjectAnimator r114 = ObjectAnimator.ofPropertyValuesHolder(this.mUmbShadows[r29], new PropertyValuesHolder[]{r31});
        r114.setStartDelay(r32);
        r114.setInterpolator(CubicInterpolator.INOUT);
        r114.setDuration(((long) this.mAnimationDuration) - r32);
        r4.add(r114);
        ObjectAnimator r115 = ObjectAnimator.ofPropertyValuesHolder(this.mUmbShadows[r29], new PropertyValuesHolder[]{r28});
        r115.setStartDelay(r32);
        r115.setInterpolator(CubicInterpolator.INOUT);
        r115.setDuration(((long) this.mAnimationDuration) - r32);
        r4.add(r115);
        ObjectAnimator r33 = ObjectAnimator.ofPropertyValuesHolder(this.mUmbs[r29], new PropertyValuesHolder[]{r31});
        r33.setStartDelay(r32);
        r33.setInterpolator(CubicInterpolator.INOUT);
        r33.setDuration(((long) this.mAnimationDuration) - r32);
        r4.add(r33);
        ObjectAnimator r34 = ObjectAnimator.ofPropertyValuesHolder(this.mUmbs[r29], new PropertyValuesHolder[]{r28});
        r34.setStartDelay(r32);
        r34.setInterpolator(CubicInterpolator.INOUT);
        r34.setDuration(((long) this.mAnimationDuration) - r32);
        r4.add(r34);
    L15:
        r29 = r29 - 1;
        r28 = r28;
        r9 = r9;
        r27 = 2;
        goto L10
    L14:
        this.mUmbs[r29].setX(0.0f);
        this.mUmbShadows[r29].setX(0.0f);
        goto L15
    L16:
        r26 = r3;
        goto L17
    }

    public void setOnOutsideTouchListener(View.OnTouchListener r1) {
        this.mOutsideTouchListener = r1;
    }
}
