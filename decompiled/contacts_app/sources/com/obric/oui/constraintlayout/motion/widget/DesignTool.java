package com.obric.oui.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.obric.oui.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DesignTool {
    private static final boolean DEBUG = false;
    private static final boolean DO_NOT_USE = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> sAllAttributes = null;
    static final HashMap<String, String> sAllMargins = null;
    private String mLastEndState;
    private int mLastEndStateId;
    private String mLastStartState;
    private int mLastStartStateId;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    static {
        HashMap<Pair<Integer, Integer>, String> r0 = new HashMap();
        sAllAttributes = r0;
        HashMap<String, String> r1 = new HashMap();
        sAllMargins = r1;
        r0.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r0.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r0.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r0.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r0.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r0.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r0.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r0.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r0.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r0.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r0.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r0.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r0.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r1.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r1.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r1.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r1.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r1.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r1.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r1.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r1.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r1.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r1.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r1.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r1.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout r2) {
        this.mLastStartState = null;
        this.mLastEndState = null;
        this.mLastStartStateId = -1;
        this.mLastEndStateId = -1;
        this.mMotionLayout = r2;
    }

    private static int getPxFromDp(int r3, String r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = r4.indexOf(100);
        if (r1 != (-1)) goto L9;
        return 0;
    L9:
        return (int) ((Integer.valueOf(r4.substring(0, r1)).intValue() * r3) / 160.0f);
    }

    private static void connect(int r8, ConstraintSet r9, View r10, HashMap<String, String> r11, int r12, int r13) {
        String r0 = sAllAttributes.get(Pair.create(Integer.valueOf(r12), Integer.valueOf(r13)));
        String r1 = r11.get(r0);
        if (r1 == null) goto L10;
        String r2 = sAllMargins.get(r0);
        if (r2 == null) goto L7;
        int r14 = getPxFromDp(r8, r11.get(r2));
    L8:
        int r5 = Integer.parseInt(r1);
        int r3 = r10.getId();
        r9.connect(r3, r12, r5, r13, r14);
        return;
    L7:
        r14 = 0;
        goto L8
    }

    private static void setBias(ConstraintSet r2, View r3, HashMap<String, String> r4, int r5) {
        if (r5 != 1) goto L5;
        String r1 = "layout_constraintVertical_bias";
    L6:
        String r6 = r4.get(r1);
        if (r6 == null) goto L13;
        if (r5 != 0) goto L10;
        r2.setHorizontalBias(r3.getId(), Float.parseFloat(r6));
        return;
    L10:
        if (r5 != 1) goto L15;
        r2.setVerticalBias(r3.getId(), Float.parseFloat(r6));
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r1 = "layout_constraintHorizontal_bias";
        goto L6
    }

    private static void setDimensions(int r1, ConstraintSet r2, View r3, HashMap<String, String> r4, int r5) {
        if (r5 != 1) goto L5;
        String r0 = "layout_height";
    L6:
        String r6 = r4.get(r0);
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.equalsIgnoreCase("wrap_content") == true) goto L11;
        int r7 = getPxFromDp(r1, r6);
    L12:
        if (r5 != 0) goto L14;
        r2.constrainWidth(r3.getId(), r7);
        return;
    L14:
        r2.constrainHeight(r3.getId(), r7);
        return;
    L11:
        r7 = -2;
        goto L12
    L5:
        r0 = "layout_width";
        goto L6
    }

    private static void setAbsolutePositions(int r2, ConstraintSet r3, View r4, HashMap<String, String> r5) {
        String r0 = r5.get("layout_editor_absoluteX");
        if (r0 == null) goto L5;
        r3.setEditorAbsoluteX(r4.getId(), getPxFromDp(r2, r0));
    L5:
        String r6 = r5.get("layout_editor_absoluteY");
        if (r6 == null) goto L9;
        r3.setEditorAbsoluteY(r4.getId(), getPxFromDp(r2, r6));
        return;
    }

    public int getAnimationPath(Object r2, float[] r3, int r4) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return -1;
    L6:
        MotionController r1 = this.mMotionLayout.mFrameArrayList.get(r2);
        if (r1 != null) goto L10;
        return 0;
    L10:
        r1.buildPath(r3, r4);
        return r4;
    }

    public void getAnimationRectangles(Object r2, float[] r3) {
        if (this.mMotionLayout.mScene != null) goto L5;
        return;
    L5:
        int r0 = this.mMotionLayout.mScene.getDuration() / 16;
        MotionController r1 = this.mMotionLayout.mFrameArrayList.get(r2);
        if (r1 != null) goto L8;
        return;
    L8:
        r1.buildRectangles(r3, r0);
    }

    public int getAnimationKeyFrames(Object r2, float[] r3) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return -1;
    L6:
        int r0 = this.mMotionLayout.mScene.getDuration() / 16;
        MotionController r1 = this.mMotionLayout.mFrameArrayList.get(r2);
        if (r1 != null) goto L10;
        return 0;
    L10:
        r1.buildKeyFrames(r3, null);
        return r0;
    }

    public void setToolPosition(float r3) {
        if (this.mMotionLayout.mScene != null) goto L5;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L5:
        this.mMotionLayout.setProgress(r3);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public String getStartState() {
        int r0 = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == r0) goto L5;
        String r1 = this.mMotionLayout.getConstraintSetNames(r0);
        if (r1 == null) goto L10;
        this.mLastStartState = r1;
        this.mLastStartStateId = r0;
    L10:
        return this.mMotionLayout.getConstraintSetNames(r0);
    L5:
        return this.mLastStartState;
    }

    public String getEndState() {
        int r0 = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == r0) goto L5;
        String r1 = this.mMotionLayout.getConstraintSetNames(r0);
        if (r1 == null) goto L9;
        this.mLastEndState = r1;
        this.mLastEndStateId = r0;
    L9:
        return r1;
    L5:
        return this.mLastEndState;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getState() {
        if (this.mLastStartState == null) goto L15;
        if (this.mLastEndState == null) goto L15;
        float r0 = getProgress();
        if (r0 > 0.01f) goto L11;
        return this.mLastStartState;
    L11:
        if (r0 < 0.99f) goto L15;
        return this.mLastEndState;
    L15:
        return this.mLastStartState;
    }

    public void setState(String r3) {
        if (r3 != null) goto L5;
        r3 = "motion_base";
    L5:
        if (Objects.equals(this.mLastStartState, r3) == false) goto L7;
        return;
    L7:
        this.mLastStartState = r3;
        this.mLastEndState = null;
        if (this.mMotionLayout.mScene != null) goto L10;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L10:
        int r4 = this.mMotionLayout.lookUpConstraintId(r3);
        this.mLastStartStateId = r4;
        if (r4 != 0) goto L13;
    L19:
        this.mMotionLayout.requestLayout();
        return;
    L13:
        if (r4 != this.mMotionLayout.getStartState()) goto L16;
        this.mMotionLayout.setProgress(0.0f);
        goto L19
    L16:
        if (r4 != this.mMotionLayout.getEndState()) goto L18;
        this.mMotionLayout.setProgress(1.0f);
        goto L19
    L18:
        this.mMotionLayout.transitionToState(r4);
        this.mMotionLayout.setProgress(1.0f);
        goto L19
    }

    public boolean isInTransition() {
        if (this.mLastStartState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastEndState == null) goto L7;
        return true;
    }

    public void setTransition(String r4, String r5) {
        if (this.mMotionLayout.mScene != null) goto L5;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L5:
        int r1 = this.mMotionLayout.lookUpConstraintId(r4);
        int r2 = this.mMotionLayout.lookUpConstraintId(r5);
        this.mMotionLayout.setTransition(r1, r2);
        this.mLastStartStateId = r1;
        this.mLastEndStateId = r2;
        this.mLastStartState = r4;
        this.mLastEndState = r5;
    }

    public void disableAutoTransition(boolean r1) {
        this.mMotionLayout.disableAutoTransition(r1);
    }

    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public int getKeyFramePositions(Object r1, int[] r2, float[] r3) {
        MotionController r0 = this.mMotionLayout.mFrameArrayList.get((View) r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getKeyFramePositions(r2, r3);
    }

    public int getKeyFrameInfo(Object r1, int r2, int[] r3) {
        MotionController r0 = this.mMotionLayout.mFrameArrayList.get((View) r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getKeyFrameInfo(r2, r3);
    }

    public float getKeyFramePosition(Object r3, int r4, float r5, float r6) {
        if ((r3 instanceof View) == true) goto L5;
        return 0.0f;
    L5:
        MotionController r2 = this.mMotionLayout.mFrameArrayList.get((View) r3);
        if (r2 != null) goto L9;
        return 0.0f;
    L9:
        return r2.getKeyFrameParameter(r4, r5, r6);
    }

    public void setKeyFrame(Object r2, int r3, String r4, Object r5) {
        if (this.mMotionLayout.mScene == null) goto L6;
        this.mMotionLayout.mScene.setKeyframe((View) r2, r3, r4, r5);
        this.mMotionLayout.mTransitionGoalPosition = r3 / 100.0f;
        this.mMotionLayout.mTransitionLastPosition = 0.0f;
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        return;
    }

    public boolean setKeyFramePosition(Object r3, int r4, int r5, float r6, float r7) {
        if ((r3 instanceof View) == true) goto L6;
        return false;
    L6:
        if (this.mMotionLayout.mScene == null) goto L13;
        MotionController r8 = this.mMotionLayout.mFrameArrayList.get(r3);
        int r0 = (int) (this.mMotionLayout.mTransitionPosition * 100.0f);
        if (r8 == null) goto L13;
        View r9 = (View) r3;
        if (this.mMotionLayout.mScene.hasKeyFramePosition(r9, r0) == false) goto L13;
        float r10 = r8.getKeyFrameParameter(2, r6, r7);
        float r11 = r8.getKeyFrameParameter(5, r6, r7);
        this.mMotionLayout.mScene.setKeyframe(r9, r0, "motion:percentX", Float.valueOf(r10));
        this.mMotionLayout.mScene.setKeyframe(r9, r0, "motion:percentY", Float.valueOf(r11));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    L13:
        return false;
    }

    public void setViewDebug(Object r2, int r3) {
        if ((r2 instanceof View) == true) goto L5;
        return;
    L5:
        MotionController r4 = this.mMotionLayout.mFrameArrayList.get(r2);
        if (r4 == null) goto L9;
        r4.setDrawPath(r3);
        this.mMotionLayout.invalidate();
        return;
    }

    public int designAccess(int r2, String r3, Object r4, float[] r5, int r6, float[] r7, int r8) {
        View r9 = (View) r4;
        if (r2 != 0) goto L5;
        MotionController r10 = null;
    L13:
        if (r2 == 0) goto L26;
        if (r2 != 1) goto L16;
        int r1 = this.mMotionLayout.mScene.getDuration() / 16;
        r10.buildPath(r7, r1);
        return r1;
    L16:
        if (r2 != 2) goto L18;
        int r11 = this.mMotionLayout.mScene.getDuration() / 16;
        r10.buildKeyFrames(r7, null);
        return r11;
    L18:
        if (r2 == 3) goto L20;
        return -1;
    L20:
        int r12 = this.mMotionLayout.mScene.getDuration() / 16;
        return r10.getAttributeValues(r3, r7, r8);
    L26:
        return 1;
    L5:
        if (this.mMotionLayout.mScene != null) goto L7;
        return -1;
    L7:
        if (r9 == null) goto L10;
        r10 = this.mMotionLayout.mFrameArrayList.get(r9);
        if (r10 != null) goto L13;
    L10:
        return -1;
    }

    public Object getKeyframe(int r2, int r3, int r4) {
        if (this.mMotionLayout.mScene != null) goto L7;
        return null;
    L7:
        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), r2, r3, r4);
    }

    public Object getKeyframeAtLocation(Object r2, float r3, float r4) {
        View r5 = (View) r2;
        if (this.mMotionLayout.mScene != null) goto L7;
        return -1;
    L7:
        if (r5 == null) goto L13;
        MotionController r1 = this.mMotionLayout.mFrameArrayList.get(r5);
        if (r1 != null) goto L11;
        return null;
    L11:
        ViewGroup r6 = (ViewGroup) r5.getParent();
        return r1.getPositionKeyframe(r6.getWidth(), r6.getHeight(), r3, r4);
    L13:
        return null;
    }

    public Boolean getPositionKeyframe(Object r9, Object r10, float r11, float r12, String[] r13, float[] r14) {
        if ((r9 instanceof KeyPositionBase) == false) goto L7;
        KeyPositionBase r3 = (KeyPositionBase) r9;
        View r2 = (View) r10;
        this.mMotionLayout.mFrameArrayList.get(r2).positionKeyframe(r2, r3, r11, r12, r13, r14);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return true;
    L7:
        return false;
    }

    public Object getKeyframe(Object r2, int r3, int r4) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return null;
    L6:
        int r5 = ((View) r2).getId();
        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), r3, r5, r4);
    }

    public void setKeyframe(Object r2, String r3, Object r4) {
        if ((r2 instanceof Key) == false) goto L6;
        ((Key) r2).setValue(r3, r4);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return;
    }

    public void setAttributes(int r10, String r11, Object r12, Object r13) {
        View r14 = (View) r12;
        if ((r13 instanceof HashMap) == false) goto L5;
        HashMap r15 = (HashMap) r13;
    L6:
        int r16 = this.mMotionLayout.lookUpConstraintId(r11);
        ConstraintSet r6 = this.mMotionLayout.mScene.getConstraintSet(r16);
        if (r6 != null) goto L9;
        return;
    L9:
        r6.clear(r14.getId());
        setDimensions(r10, r6, r14, r15, 0);
        setDimensions(r10, r6, r14, r15, 1);
        HashMap r3 = r15;
        connect(r10, r6, r14, r3, 6, 6);
        connect(r10, r6, r14, r3, 6, 7);
        connect(r10, r6, r14, r3, 7, 7);
        connect(r10, r6, r14, r3, 7, 6);
        connect(r10, r6, r14, r3, 1, 1);
        connect(r10, r6, r14, r3, 1, 2);
        connect(r10, r6, r14, r3, 2, 2);
        connect(r10, r6, r14, r3, 2, 1);
        connect(r10, r6, r14, r3, 3, 3);
        connect(r10, r6, r14, r3, 3, 4);
        connect(r10, r6, r14, r3, 4, 3);
        connect(r10, r6, r14, r3, 4, 4);
        connect(r10, r6, r14, r3, 5, 5);
        setBias(r6, r14, r15, 0);
        setBias(r6, r14, r15, 1);
        setAbsolutePositions(r10, r6, r14, r15);
        this.mMotionLayout.updateState(r16, r6);
        this.mMotionLayout.requestLayout();
        return;
    L5:
        r15 = new HashMap();
        goto L6
    }

    public void dumpConstraintSet(String r6) {
        if (this.mMotionLayout.mScene != null) goto L5;
        this.mMotionLayout.mScene = this.mSceneCache;
    L5:
        int r0 = this.mMotionLayout.lookUpConstraintId(r6);
        System.out.println(" dumping  " + r6 + " (" + r0 + ")");
        this.mMotionLayout.mScene.getConstraintSet(r0).dump(this.mMotionLayout.mScene, new int[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error while dumping: " + r6 + " (" + r0 + ")", e);
    }
}
