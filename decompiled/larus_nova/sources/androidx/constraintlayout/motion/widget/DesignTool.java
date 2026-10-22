package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes17.dex */
public class DesignTool implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> allAttributes = null;
    static final HashMap<String, String> allMargins = null;
    private String mLastEndState;
    private int mLastEndStateId;
    private String mLastStartState;
    private int mLastStartStateId;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    static {
        HashMap<Pair<Integer, Integer>, String> r100 = new HashMap();
        allAttributes = r100;
        HashMap<String, String> r101 = new HashMap();
        allMargins = r101;
        r100.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r100.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r100.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r100.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r100.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r100.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r100.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r100.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r100.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r100.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r100.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r100.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r100.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r101.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r101.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r101.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r101.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r101.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r101.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r101.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r101.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r101.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r101.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r101.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r101.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public String getEndState() {
        int r100 = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == r100) goto L5;
        String r101 = this.mMotionLayout.getConstraintSetNames(r100);
        if (r101 == null) goto L9;
        this.mLastEndState = r101;
        this.mLastEndStateId = r100;
    L9:
        return r101;
    L5:
        return this.mLastEndState;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int r100 = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == r100) goto L5;
        String r101 = this.mMotionLayout.getConstraintSetNames(r100);
        if (r101 == null) goto L10;
        this.mLastStartState = r101;
        this.mLastStartStateId = r100;
    L10:
        return this.mMotionLayout.getConstraintSetNames(r100);
    L5:
        return this.mLastStartState;
    }

    public String getState() {
        if (this.mLastStartState == null) goto L15;
        if (this.mLastEndState == null) goto L15;
        float r100 = getProgress();
        if (r100 > 0.01f) goto L11;
        return this.mLastStartState;
    L11:
        if (r100 < 0.99f) goto L15;
        return this.mLastEndState;
    L15:
        return this.mLastStartState;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        if (this.mLastStartState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastEndState == null) goto L7;
        return true;
    }

    public DesignTool(MotionLayout r100) {
        this.mLastStartState = null;
        this.mLastEndState = null;
        this.mLastStartStateId = -1;
        this.mLastEndStateId = -1;
        this.mMotionLayout = r100;
    }

    public void disableAutoTransition(boolean r100) {
        this.mMotionLayout.disableAutoTransition(r100);
    }

    public void dumpConstraintSet(String r100) {
        MotionLayout r101 = this.mMotionLayout;
        if (r101.mScene != null) goto L5;
        r101.mScene = this.mSceneCache;
    L5:
        int r102 = r101.lookUpConstraintId(r100);
        System.out.println(" dumping  " + r100 + " (" + r102 + ")");
        this.mMotionLayout.mScene.getConstraintSet(r102).dump(this.mMotionLayout.mScene, new int[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public void setState(String r100) {
        if (r100 != null) goto L5;
        r100 = "motion_base";
    L5:
        if (this.mLastStartState != r100) goto L7;
        return;
    L7:
        this.mLastStartState = r100;
        this.mLastEndState = null;
        MotionLayout r101 = this.mMotionLayout;
        if (r101.mScene != null) goto L10;
        r101.mScene = this.mSceneCache;
    L10:
        int r102 = r101.lookUpConstraintId(r100);
        this.mLastStartStateId = r102;
        if (r102 != 0) goto L13;
    L19:
        this.mMotionLayout.requestLayout();
        return;
    L13:
        if (r102 != this.mMotionLayout.getStartState()) goto L16;
        this.mMotionLayout.setProgress(0.0f);
        goto L19
    L16:
        if (r102 != this.mMotionLayout.getEndState()) goto L18;
        this.mMotionLayout.setProgress(1.0f);
        goto L19
    L18:
        this.mMotionLayout.transitionToState(r102);
        this.mMotionLayout.setProgress(1.0f);
        goto L19
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float r100) {
        MotionLayout r101 = this.mMotionLayout;
        if (r101.mScene != null) goto L5;
        r101.mScene = this.mSceneCache;
    L5:
        r101.setProgress(r100);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    private static int GetPxFromDp(int r100, String r101) {
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = r101.indexOf(100);
        if (r102 != (-1)) goto L9;
        return 0;
    L9:
        return (int) ((CastIntegerProtector.valueOf(r101.substring(0, r102)).intValue() * r100) / 160.0f);
    }

    public int getAnimationKeyFrames(Object r100, float[] r101) {
        MotionScene r102 = this.mMotionLayout.mScene;
        if (r102 != null) goto L6;
        return -1;
    L6:
        int r103 = r102.getDuration() / 16;
        MotionController r104 = this.mMotionLayout.mFrameArrayList.get(r100);
        if (r104 != null) goto L10;
        return 0;
    L10:
        r104.buildKeyFrames(r101, null);
        return r103;
    }

    public void getAnimationRectangles(Object r100, float[] r101) {
        MotionScene r102 = this.mMotionLayout.mScene;
        if (r102 != null) goto L5;
        return;
    L5:
        int r103 = r102.getDuration() / 16;
        MotionController r104 = this.mMotionLayout.mFrameArrayList.get(r100);
        if (r104 != null) goto L8;
        return;
    L8:
        r104.buildRectangles(r101, r103);
    }

    public void setTransition(String r100, String r101) {
        MotionLayout r102 = this.mMotionLayout;
        if (r102.mScene != null) goto L5;
        r102.mScene = this.mSceneCache;
    L5:
        int r103 = r102.lookUpConstraintId(r100);
        int r104 = this.mMotionLayout.lookUpConstraintId(r101);
        this.mMotionLayout.setTransition(r103, r104);
        this.mLastStartStateId = r103;
        this.mLastEndStateId = r104;
        this.mLastStartState = r100;
        this.mLastEndState = r101;
    }

    public void setViewDebug(Object r100, int r101) {
        MotionController r102 = this.mMotionLayout.mFrameArrayList.get(r100);
        if (r102 == null) goto L6;
        r102.setDrawPath(r101);
        this.mMotionLayout.invalidate();
        return;
    }

    public int getAnimationPath(Object r100, float[] r101, int r102) {
        MotionLayout r103 = this.mMotionLayout;
        if (r103.mScene != null) goto L6;
        return -1;
    L6:
        MotionController r104 = r103.mFrameArrayList.get(r100);
        if (r104 != null) goto L10;
        return 0;
    L10:
        r104.buildPath(r101, r102);
        return r102;
    }

    public int getKeyFrameInfo(Object r100, int r101, int[] r102) {
        MotionController r103 = this.mMotionLayout.mFrameArrayList.get((View) r100);
        if (r103 != null) goto L7;
        return 0;
    L7:
        return r103.getKeyFrameInfo(r101, r102);
    }

    public int getKeyFramePositions(Object r100, int[] r101, float[] r102) {
        MotionController r103 = this.mMotionLayout.mFrameArrayList.get((View) r100);
        if (r103 != null) goto L7;
        return 0;
    L7:
        return r103.getkeyFramePositions(r101, r102);
    }

    public Object getKeyframe(Object r100, int r101, int r102) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return null;
    L6:
        int r103 = ((View) r100).getId();
        MotionLayout r104 = this.mMotionLayout;
        return r104.mScene.getKeyFrame(r104.getContext(), r101, r103, r102);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object r100, float r101, float r102) {
        View r103 = (View) r100;
        MotionLayout r104 = this.mMotionLayout;
        if (r104.mScene != null) goto L7;
        return -1;
    L7:
        if (r103 == null) goto L13;
        MotionController r105 = r104.mFrameArrayList.get(r103);
        if (r105 != null) goto L11;
        return null;
    L11:
        ViewGroup r106 = (ViewGroup) r103.getParent();
        return r105.getPositionKeyframe(r106.getWidth(), r106.getHeight(), r101, r102);
    L13:
        return null;
    }

    public void setKeyframe(Object r100, String r101, Object r102) {
        if ((r100 instanceof Key) == false) goto L6;
        ((Key) r100).setValue(r101, r102);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return;
    }

    public Object getKeyframe(int r100, int r101, int r102) {
        MotionLayout r103 = this.mMotionLayout;
        MotionScene r104 = r103.mScene;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.getKeyFrame(r103.getContext(), r100, r101, r102);
    }

    private static void SetAbsolutePositions(int r100, ConstraintSet r101, View r102, HashMap<String, String> r103) {
        String r104 = r103.get("layout_editor_absoluteX");
        if (r104 == null) goto L5;
        r101.setEditorAbsoluteX(r102.getId(), GetPxFromDp(r100, r104));
    L5:
        String r105 = r103.get("layout_editor_absoluteY");
        if (r105 == null) goto L9;
        r101.setEditorAbsoluteY(r102.getId(), GetPxFromDp(r100, r105));
        return;
    }

    private static void SetBias(ConstraintSet r100, View r101, HashMap<String, String> r102, int r103) {
        if (r103 != 1) goto L5;
        String r104 = "layout_constraintVertical_bias";
    L6:
        String r105 = r102.get(r104);
        if (r105 == null) goto L13;
        if (r103 != 0) goto L10;
        r100.setHorizontalBias(r101.getId(), CastFloatProtector.parseFloat(r105));
        return;
    L10:
        if (r103 != 1) goto L15;
        r100.setVerticalBias(r101.getId(), CastFloatProtector.parseFloat(r105));
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r104 = "layout_constraintHorizontal_bias";
        goto L6
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object r100, int r101, float r102, float r103) {
        return this.mMotionLayout.mFrameArrayList.get((View) r100).getKeyFrameParameter(r101, r102, r103);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int r110, String r111, Object r112, Object r113) {
        View r114 = (View) r112;
        HashMap r115 = (HashMap) r113;
        int r116 = this.mMotionLayout.lookUpConstraintId(r111);
        ConstraintSet r100 = this.mMotionLayout.mScene.getConstraintSet(r116);
        if (r100 != null) goto L5;
        return;
    L5:
        r100.clear(r114.getId());
        SetDimensions(r110, r100, r114, r115, 0);
        SetDimensions(r110, r100, r114, r115, 1);
        Connect(r110, r100, r114, r115, 6, 6);
        Connect(r110, r100, r114, r115, 6, 7);
        Connect(r110, r100, r114, r115, 7, 7);
        Connect(r110, r100, r114, r115, 7, 6);
        Connect(r110, r100, r114, r115, 1, 1);
        Connect(r110, r100, r114, r115, 1, 2);
        Connect(r110, r100, r114, r115, 2, 2);
        Connect(r110, r100, r114, r115, 2, 1);
        Connect(r110, r100, r114, r115, 3, 3);
        Connect(r110, r100, r114, r115, 3, 4);
        Connect(r110, r100, r114, r115, 4, 3);
        Connect(r110, r100, r114, r115, 4, 4);
        Connect(r110, r100, r114, r115, 5, 5);
        SetBias(r100, r114, r115, 0);
        SetBias(r100, r114, r115, 1);
        SetAbsolutePositions(r110, r100, r114, r115);
        this.mMotionLayout.updateState(r116, r100);
        this.mMotionLayout.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object r100, int r101, String r102, Object r103) {
        MotionScene r104 = this.mMotionLayout.mScene;
        if (r104 == null) goto L6;
        r104.setKeyframe((View) r100, r101, r102, r103);
        MotionLayout r105 = this.mMotionLayout;
        r105.mTransitionGoalPosition = r101 / 100.0f;
        r105.mTransitionLastPosition = 0.0f;
        r105.rebuildScene();
        this.mMotionLayout.evaluate(true);
        return;
    }

    private static void SetDimensions(int r100, ConstraintSet r101, View r102, HashMap<String, String> r103, int r104) {
        if (r104 != 1) goto L5;
        String r105 = "layout_height";
    L6:
        String r106 = r103.get(r105);
        if (r106 != null) goto L9;
        return;
    L9:
        if (r106.equalsIgnoreCase("wrap_content") == true) goto L11;
        int r107 = GetPxFromDp(r100, r106);
    L12:
        if (r104 != 0) goto L14;
        r101.constrainWidth(r102.getId(), r107);
        return;
    L14:
        r101.constrainHeight(r102.getId(), r107);
        return;
    L11:
        r107 = -2;
        goto L12
    L5:
        r105 = "layout_width";
        goto L6
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object r100, int r101, int r102, float r103, float r104) {
        MotionLayout r105 = this.mMotionLayout;
        if (r105.mScene == null) goto L10;
        MotionController r106 = r105.mFrameArrayList.get(r100);
        MotionLayout r107 = this.mMotionLayout;
        int r108 = (int) (r107.mTransitionPosition * 100.0f);
        if (r106 == null) goto L12;
        View r109 = (View) r100;
        if (r107.mScene.hasKeyFramePosition(r109, r108) == false) goto L13;
        float r110 = r106.getKeyFrameParameter(2, r103, r104);
        float r111 = r106.getKeyFrameParameter(5, r103, r104);
        this.mMotionLayout.mScene.setKeyframe(r109, r108, "motion:percentX", Float.valueOf(r110));
        this.mMotionLayout.mScene.setKeyframe(r109, r108, "motion:percentY", Float.valueOf(r111));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    private static void Connect(int r100, ConstraintSet r101, View r110, HashMap<String, String> r111, int r112, int r113) {
        String r102 = allAttributes.get(Pair.create(Integer.valueOf(r112), Integer.valueOf(r113)));
        String r103 = r111.get(r102);
        if (r103 == null) goto L10;
        String r104 = allMargins.get(r102);
        if (r104 == null) goto L7;
        int r105 = GetPxFromDp(r100, r111.get(r104));
    L8:
        int r106 = CastIntegerProtector.parseInt(r103);
        r101.connect(r110.getId(), r112, r106, r113, r105);
        return;
    L7:
        r105 = 0;
        goto L8
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object r100, Object r110, float r111, float r112, String[] r113, float[] r114) {
        if ((r100 instanceof KeyPositionBase) == false) goto L7;
        KeyPositionBase r101 = (KeyPositionBase) r100;
        View r102 = (View) r110;
        this.mMotionLayout.mFrameArrayList.get(r102).positionKeyframe(r102, r101, r111, r112, r113, r114);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return Boolean.TRUE;
    L7:
        return Boolean.FALSE;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int r100, String r101, Object r102, float[] r103, int r104, float[] r105, int r106) {
        View r107 = (View) r102;
        if (r100 == 0) goto L11;
        MotionLayout r108 = this.mMotionLayout;
        if (r108.mScene != null) goto L7;
        return -1;
    L7:
        if (r107 == null) goto L10;
        MotionController r109 = r108.mFrameArrayList.get(r107);
        if (r109 == null) goto L10;
    L13:
        if (r100 == 0) goto L26;
        if (r100 != 1) goto L16;
        int r110 = this.mMotionLayout.mScene.getDuration() / 16;
        r109.buildPath(r105, r110);
        return r110;
    L16:
        if (r100 != 2) goto L18;
        int r111 = this.mMotionLayout.mScene.getDuration() / 16;
        r109.buildKeyFrames(r105, null);
        return r111;
    L18:
        if (r100 == 3) goto L20;
        return -1;
    L20:
        int r112 = this.mMotionLayout.mScene.getDuration() / 16;
        return r109.getAttributeValues(r101, r105, r106);
    L26:
        return 1;
    L10:
        return -1;
    L11:
        r109 = null;
        goto L13
    }
}
