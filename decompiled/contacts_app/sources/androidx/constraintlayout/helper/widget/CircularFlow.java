package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {
    private static float DEFAULT_ANGLE = 0.0f;
    private static int DEFAULT_RADIUS = 0;
    private static final String TAG = "CircularFlow";
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

    public CircularFlow(Context context) {
        super(context);
    }

    public CircularFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularFlow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.mRadius, this.mCountRadius);
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.mAngles, this.mCountAngle);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet attrs) {
        super.init(attrs);
        if (attrs == null) goto L31;
        TypedArray r6 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
        int r0 = r6.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L22;
        int r3 = r6.getIndex(r2);
        if (r3 != R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) goto L10;
        this.mViewCenter = r6.getResourceId(r3, 0);
    L21:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != R.styleable.ConstraintLayout_Layout_circularflow_angles) goto L13;
        String r4 = r6.getString(r3);
        this.mReferenceAngles = r4;
        setAngles(r4);
        goto L21
    L13:
        if (r3 != R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) goto L16;
        String r5 = r6.getString(r3);
        this.mReferenceRadius = r5;
        setRadius(r5);
        goto L21
    L16:
        if (r3 != R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) goto L19;
        Float r7 = Float.valueOf(r6.getFloat(r3, DEFAULT_ANGLE));
        this.mReferenceDefaultAngle = r7;
        setDefaultAngle(r7.floatValue());
        goto L21
    L19:
        if (r3 != R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) goto L21;
        Integer r8 = Integer.valueOf(r6.getDimensionPixelSize(r3, DEFAULT_RADIUS));
        this.mReferenceDefaultRadius = r8;
        setDefaultRadius(r8.intValue());
        goto L21
    L22:
        r6.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
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
        this.mContainer = (ConstraintLayout) getParent();
        int r0 = 0;
    L4:
        if (r0 >= this.mCount) goto L38;
        View r1 = this.mContainer.getViewById(this.mIds[r0]);
        if (r1 == null) goto L37;
        int r2 = DEFAULT_RADIUS;
        float r3 = DEFAULT_ANGLE;
        int[] r4 = this.mRadius;
        if (r4 != null) goto L11;
    L13:
        Integer r5 = this.mReferenceDefaultRadius;
        if (r5 != null) goto L16;
    L21:
        Log.e(TAG, "Added radius to view with id: " + this.mMap.get(Integer.valueOf(r1.getId())));
    L22:
        float[] r6 = this.mAngles;
        if (r6 != null) goto L25;
    L27:
        Float r7 = this.mReferenceDefaultAngle;
        if (r7 != null) goto L30;
    L35:
        Log.e(TAG, "Added angle to view with id: " + this.mMap.get(Integer.valueOf(r1.getId())));
    L36:
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r1.getLayoutParams();
        r8.circleAngle = r3;
        r8.circleConstraint = this.mViewCenter;
        r8.circleRadius = r2;
        r1.setLayoutParams(r8);
        goto L37
    L30:
        if (r7.floatValue() == (-1.0f)) goto L35;
        this.mCountAngle++;
        if (this.mAngles != null) goto L34;
        this.mAngles = new float[1];
    L34:
        float[] r9 = getAngles();
        this.mAngles = r9;
        r9[this.mCountAngle - 1] = r3;
        goto L36
    L25:
        if (r0 >= r6.length) goto L27;
        r3 = r6[r0];
        goto L36
    L16:
        if (r5.intValue() == (-1)) goto L21;
        this.mCountRadius++;
        if (this.mRadius != null) goto L20;
        this.mRadius = new int[1];
    L20:
        int[] r10 = getRadius();
        this.mRadius = r10;
        r10[this.mCountRadius - 1] = r2;
        goto L22
    L11:
        if (r0 >= r4.length) goto L13;
        r2 = r4[r0];
    L37:
        r0 = r0 + 1;
        goto L4
    L38:
        applyLayoutFeatures();
    }

    public void addViewToCircularFlow(View view, int radius, float angle) {
        if (containsId(view.getId()) == false) goto L5;
        return;
    L5:
        addView(view);
        this.mCountAngle++;
        float[] r2 = getAngles();
        this.mAngles = r2;
        r2[this.mCountAngle - 1] = angle;
        this.mCountRadius++;
        int[] r3 = getRadius();
        this.mRadius = r3;
        r3[this.mCountRadius - 1] = (int) (radius * this.myContext.getResources().getDisplayMetrics().density);
        anchorReferences();
    }

    public void updateRadius(View view, int radius) {
        if (isUpdatable(view) == true) goto L6;
        Log.e(TAG, "It was not possible to update radius to view with id: " + view.getId());
        return;
    L6:
        int r3 = indexFromId(view.getId());
        if (r3 <= this.mRadius.length) goto L9;
        return;
    L9:
        int[] r0 = getRadius();
        this.mRadius = r0;
        r0[r3] = (int) (radius * this.myContext.getResources().getDisplayMetrics().density);
        anchorReferences();
    }

    public void updateAngle(View view, float angle) {
        if (isUpdatable(view) == true) goto L6;
        Log.e(TAG, "It was not possible to update angle to view with id: " + view.getId());
        return;
    L6:
        int r2 = indexFromId(view.getId());
        if (r2 <= this.mAngles.length) goto L9;
        return;
    L9:
        float[] r0 = getAngles();
        this.mAngles = r0;
        r0[r2] = angle;
        anchorReferences();
    }

    public void updateReference(View view, int radius, float angle) {
        if (isUpdatable(view) == true) goto L6;
        Log.e(TAG, "It was not possible to update radius and angle to view with id: " + view.getId());
        return;
    L6:
        int r2 = indexFromId(view.getId());
        if (getAngles().length <= r2) goto L10;
        float[] r0 = getAngles();
        this.mAngles = r0;
        r0[r2] = angle;
    L10:
        if (getRadius().length <= r2) goto L12;
        int[] r4 = getRadius();
        this.mRadius = r4;
        r4[r2] = (int) (radius * this.myContext.getResources().getDisplayMetrics().density);
    L12:
        anchorReferences();
    }

    public void setDefaultAngle(float angle) {
        DEFAULT_ANGLE = angle;
    }

    public void setDefaultRadius(int radius) {
        DEFAULT_RADIUS = radius;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int removeView(View view) {
        int r0 = super.removeView(view);
        if (r0 != (-1)) goto L5;
        return r0;
    L5:
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(this.mContainer);
        r1.clear(view.getId(), 8);
        r1.applyTo(this.mContainer);
        float[] r4 = this.mAngles;
        if (r0 >= r4.length) goto L8;
        this.mAngles = removeAngle(r4, r0);
        this.mCountAngle--;
    L8:
        int[] r5 = this.mRadius;
        if (r0 >= r5.length) goto L11;
        this.mRadius = removeRadius(r5, r0);
        this.mCountRadius--;
    L11:
        anchorReferences();
        return r0;
    }

    private float[] removeAngle(float[] angles, int index) {
        if (angles == null) goto L9;
        if (index < 0) goto L9;
        if (index >= this.mCountAngle) goto L9;
        return removeElementFromArray(angles, index);
    L9:
        return angles;
    }

    private int[] removeRadius(int[] radius, int index) {
        if (radius == null) goto L9;
        if (index < 0) goto L9;
        if (index >= this.mCountRadius) goto L9;
        return removeElementFromArray(radius, index);
    L9:
        return radius;
    }

    private void setAngles(String idList) {
        if (idList != null) goto L4;
        return;
    L4:
        int r0 = 0;
        this.mCountAngle = 0;
    L5:
        int r1 = idList.indexOf(44, r0);
        if (r1 == (-1)) goto L7;
        addAngle(idList.substring(r0, r1).trim());
        r0 = r1 + 1;
        goto L5
    L7:
        addAngle(idList.substring(r0).trim());
    }

    private void setRadius(String idList) {
        if (idList != null) goto L4;
        return;
    L4:
        int r0 = 0;
        this.mCountRadius = 0;
    L5:
        int r1 = idList.indexOf(44, r0);
        if (r1 == (-1)) goto L7;
        addRadius(idList.substring(r0, r1).trim());
        r0 = r1 + 1;
        goto L5
    L7:
        addRadius(idList.substring(r0).trim());
    }

    private void addAngle(String angleString) {
        if (angleString != null) goto L4;
        return;
    L4:
        if (angleString.length() != 0) goto L7;
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
        this.mAngles[this.mCountAngle] = Integer.parseInt(angleString);
        this.mCountAngle++;
    }

    private void addRadius(String radiusString) {
        if (radiusString != null) goto L4;
        return;
    L4:
        if (radiusString.length() != 0) goto L7;
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
        this.mRadius[this.mCountRadius] = (int) (Integer.parseInt(radiusString) * this.myContext.getResources().getDisplayMetrics().density);
        this.mCountRadius++;
    }

    public static int[] removeElementFromArray(int[] array, int index) {
        int[] r0 = new int[array.length - 1];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= array.length) goto L9;
        if (r1 == index) goto L8;
        r0[r2] = array[r1];
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    public static float[] removeElementFromArray(float[] array, int index) {
        float[] r0 = new float[array.length - 1];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= array.length) goto L9;
        if (r1 == index) goto L8;
        r0[r2] = array[r1];
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    public boolean isUpdatable(View view) {
        if (containsId(view.getId()) == true) goto L6;
        return false;
    L6:
        if (indexFromId(view.getId()) == (-1)) goto L9;
        return true;
    L9:
        return false;
    }
}
