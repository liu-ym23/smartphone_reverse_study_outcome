package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.obric.oui.constraintlayout.widget.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class CircularFlow extends VirtualLayout {
    private static final String TAG = "CircularFlow";
    private static float sDefaultAngle;
    private static int sDefaultRadius;
    private float[] mAngles;
    ConstraintLayout mContainer;
    private int mCountAngle;
    private int mCountRadius;
    private int[] mRadius;
    private String mReferenceAngles;
    private Float mReferenceDefaultAngle;
    private Integer mReferenceDefaultRadius;
    private String mReferenceRadius;
    int mViewCenter;

    static {
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public CircularFlow(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public CircularFlow(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public CircularFlow(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.mRadius, this.mCountRadius);
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.mAngles, this.mCountAngle);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        super.init(r9);
        if (r9 == null) goto L31;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r9, R.styleable.ConstraintLayout_Layout);
        int r0 = r10.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L22;
        int r3 = r10.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_viewCenter, "styleable", "ConstraintLayout_Layout_circularflow_viewCenter")) goto L10;
        this.mViewCenter = r10.getResourceId(r3, 0);
    L21:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_angles, "styleable", "ConstraintLayout_Layout_circularflow_angles")) goto L13;
        String r4 = r10.getString(r3);
        this.mReferenceAngles = r4;
        setAngles(r4);
        goto L21
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP, "styleable", "ConstraintLayout_Layout_circularflow_radiusInDP")) goto L16;
        String r5 = r10.getString(r3);
        this.mReferenceRadius = r5;
        setRadius(r5);
        goto L21
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle, "styleable", "ConstraintLayout_Layout_circularflow_defaultAngle")) goto L19;
        Float r6 = Float.valueOf(r10.getFloat(r3, sDefaultAngle));
        this.mReferenceDefaultAngle = r6;
        setDefaultAngle(r6.floatValue());
        goto L21
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius, "styleable", "ConstraintLayout_Layout_circularflow_defaultRadius")) goto L21;
        Integer r7 = Integer.valueOf(r10.getDimensionPixelSize(r3, sDefaultRadius));
        this.mReferenceDefaultRadius = r7;
        setDefaultRadius(r7.intValue());
        goto L21
    L22:
        r10.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r0 = this.mReferenceAngles;
        if (r0 == null) goto L5;
        this.mAngles = new float[1];
        setAngles(r0);
    L5:
        String r1 = this.mReferenceRadius;
        if (r1 == null) goto L8;
        this.mRadius = new int[1];
        setRadius(r1);
    L8:
        Float r2 = this.mReferenceDefaultAngle;
        if (r2 == null) goto L11;
        setDefaultAngle(r2.floatValue());
    L11:
        Integer r3 = this.mReferenceDefaultRadius;
        if (r3 == null) goto L14;
        setDefaultRadius(r3.intValue());
    L14:
        anchorReferences();
    }

    private void anchorReferences() {
        this.mContainer = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= this.mCount) goto L38;
        View r1 = this.mContainer.getViewById(this.mIds[r0]);
        if (r1 == null) goto L37;
        int r3 = sDefaultRadius;
        float r4 = sDefaultAngle;
        int[] r5 = this.mRadius;
        if (r5 != null) goto L11;
    L13:
        Integer r6 = this.mReferenceDefaultRadius;
        if (r6 != null) goto L16;
    L21:
        INVOKESTATIC_com_obric_oui_constraintlayout_helper_widget_CircularFlow_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Added radius to view with id: " + ((String) ZeusTransformUtils.preCheckCast(this.mMap.get(Integer.valueOf(r1.getId())), String.class, "com.obric.aiagent.plugin")));
    L22:
        float[] r7 = this.mAngles;
        if (r7 != null) goto L25;
    L27:
        Float r8 = this.mReferenceDefaultAngle;
        if (r8 != null) goto L30;
    L35:
        INVOKESTATIC_com_obric_oui_constraintlayout_helper_widget_CircularFlow_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Added angle to view with id: " + ((String) ZeusTransformUtils.preCheckCast(this.mMap.get(Integer.valueOf(r1.getId())), String.class, "com.obric.aiagent.plugin")));
    L36:
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r9.circleAngle = r4;
        r9.circleConstraint = this.mViewCenter;
        r9.circleRadius = r3;
        r1.setLayoutParams(r9);
        goto L37
    L30:
        if (r8.floatValue() == (-1.0f)) goto L35;
        this.mCountAngle++;
        if (this.mAngles != null) goto L34;
        this.mAngles = new float[1];
    L34:
        float[] r10 = getAngles();
        this.mAngles = r10;
        r10[this.mCountAngle - 1] = r4;
        goto L36
    L25:
        if (r0 >= r7.length) goto L27;
        r4 = r7[r0];
        goto L36
    L16:
        if (r6.intValue() == (-1)) goto L21;
        this.mCountRadius++;
        if (this.mRadius != null) goto L20;
        this.mRadius = new int[1];
    L20:
        int[] r11 = getRadius();
        this.mRadius = r11;
        r11[this.mCountRadius - 1] = r3;
        goto L22
    L11:
        if (r0 >= r5.length) goto L13;
        r3 = r5[r0];
    L37:
        r0 = r0 + 1;
        goto L4
    L38:
        applyLayoutFeatures();
    }

    public void addViewToCircularFlow(View r3, int r4, float r5) {
        if (containsId(r3.getId()) == false) goto L5;
        return;
    L5:
        addView(r3);
        this.mCountAngle++;
        float[] r6 = getAngles();
        this.mAngles = r6;
        r6[this.mCountAngle - 1] = r5;
        this.mCountRadius++;
        int[] r7 = getRadius();
        this.mRadius = r7;
        r7[this.mCountRadius - 1] = (int) (r4 * ZeusTransformUtils.getResources(this.myContext, "com.obric.aiagent.plugin").getDisplayMetrics().density);
        anchorReferences();
    }

    public void updateRadius(View r4, int r5) {
        if (isUpdatable(r4) == true) goto L6;
        INVOKESTATIC_com_obric_oui_constraintlayout_helper_widget_CircularFlow_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "It was not possible to update radius to view with id: " + r4.getId());
        return;
    L6:
        int r6 = indexFromId(r4.getId());
        if (r6 <= this.mRadius.length) goto L9;
        return;
    L9:
        int[] r0 = getRadius();
        this.mRadius = r0;
        r0[r6] = (int) (r5 * ZeusTransformUtils.getResources(this.myContext, "com.obric.aiagent.plugin").getDisplayMetrics().density);
        anchorReferences();
    }

    public void updateAngle(View r2, float r3) {
        if (isUpdatable(r2) == true) goto L6;
        INVOKESTATIC_com_obric_oui_constraintlayout_helper_widget_CircularFlow_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "It was not possible to update angle to view with id: " + r2.getId());
        return;
    L6:
        int r4 = indexFromId(r2.getId());
        if (r4 <= this.mAngles.length) goto L9;
        return;
    L9:
        float[] r0 = getAngles();
        this.mAngles = r0;
        r0[r4] = r3;
        anchorReferences();
    }

    public void updateReference(View r3, int r4, float r5) {
        if (isUpdatable(r3) == true) goto L6;
        INVOKESTATIC_com_obric_oui_constraintlayout_helper_widget_CircularFlow_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "It was not possible to update radius and angle to view with id: " + r3.getId());
        return;
    L6:
        int r6 = indexFromId(r3.getId());
        if (getAngles().length <= r6) goto L10;
        float[] r0 = getAngles();
        this.mAngles = r0;
        r0[r6] = r5;
    L10:
        if (getRadius().length <= r6) goto L12;
        int[] r7 = getRadius();
        this.mRadius = r7;
        r7[r6] = (int) (r4 * ZeusTransformUtils.getResources(this.myContext, "com.obric.aiagent.plugin").getDisplayMetrics().density);
    L12:
        anchorReferences();
    }

    public void setDefaultAngle(float r1) {
        sDefaultAngle = r1;
    }

    public void setDefaultRadius(int r1) {
        sDefaultRadius = r1;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public int removeView(View r4) {
        int r0 = super.removeView(r4);
        if (r0 != (-1)) goto L5;
        return r0;
    L5:
        c r1 = new c();
        r1.b(this.mContainer);
        r1.a(r4.getId(), 8);
        r1.c(this.mContainer);
        float[] r5 = this.mAngles;
        if (r0 >= r5.length) goto L8;
        this.mAngles = removeAngle(r5, r0);
        this.mCountAngle--;
    L8:
        int[] r6 = this.mRadius;
        if (r0 >= r6.length) goto L11;
        this.mRadius = removeRadius(r6, r0);
        this.mCountRadius--;
    L11:
        anchorReferences();
        return r0;
    }

    private float[] removeAngle(float[] r1, int r2) {
        if (r1 == null) goto L9;
        if (r2 < 0) goto L9;
        if (r2 >= this.mCountAngle) goto L9;
        return removeElementFromArray(r1, r2);
    L9:
        return r1;
    }

    private int[] removeRadius(int[] r1, int r2) {
        if (r1 == null) goto L9;
        if (r2 < 0) goto L9;
        if (r2 >= this.mCountRadius) goto L9;
        return removeElementFromArray(r1, r2);
    L9:
        return r1;
    }

    private void setAngles(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        this.mCountAngle = 0;
    L5:
        int r1 = r4.indexOf(44, r0);
        if (r1 == (-1)) goto L7;
        addAngle(r4.substring(r0, r1).trim());
        r0 = r1 + 1;
        goto L5
    L7:
        addAngle(r4.substring(r0).trim());
    }

    private void setRadius(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        this.mCountRadius = 0;
    L5:
        int r1 = r4.indexOf(44, r0);
        if (r1 == (-1)) goto L7;
        addRadius(r4.substring(r0, r1).trim());
        r0 = r1 + 1;
        goto L5
    L7:
        addRadius(r4.substring(r0).trim());
    }

    private void addAngle(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        float[] r0 = this.mAngles;
        if (r0 != null) goto L13;
        return;
    L13:
        if ((this.mCountAngle + 1) <= r0.length) goto L15;
        this.mAngles = Arrays.copyOf(r0, r0.length + 1);
    L15:
        this.mAngles[this.mCountAngle] = Integer.parseInt(r4);
        this.mCountAngle++;
    }

    private void addRadius(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        int[] r0 = this.mRadius;
        if (r0 != null) goto L13;
        return;
    L13:
        if ((this.mCountRadius + 1) <= r0.length) goto L15;
        this.mRadius = Arrays.copyOf(r0, r0.length + 1);
    L15:
        this.mRadius[this.mCountRadius] = (int) (Integer.parseInt(r5) * ZeusTransformUtils.getResources(this.myContext, "com.obric.aiagent.plugin").getDisplayMetrics().density);
        this.mCountRadius++;
    }

    private static int[] removeElementFromArray(int[] r5, int r6) {
        int[] r0 = new int[r5.length - 1];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r5.length) goto L9;
        if (r1 == r6) goto L8;
        r0[r2] = r5[r1];
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private static float[] removeElementFromArray(float[] r5, int r6) {
        float[] r0 = new float[r5.length - 1];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r5.length) goto L9;
        if (r1 == r6) goto L8;
        r0[r2] = r5[r1];
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    public boolean isUpdatable(View r3) {
        if (containsId(r3.getId()) == true) goto L6;
        return false;
    L6:
        if (indexFromId(r3.getId()) == (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_constraintlayout_helper_widget_CircularFlow_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
