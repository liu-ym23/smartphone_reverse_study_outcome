package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes17.dex */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = null;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = null;
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators;
    private ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration;
    private TransitionValuesMaps mEndValues;
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator;
    private ArrayList<TransitionListener> mListeners;
    private int[] mMatchOrder;
    private String mName;
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances;
    TransitionSet mParent;
    private PathMotion mPathMotion;
    private boolean mPaused;
    TransitionPropagation mPropagation;
    private ViewGroup mSceneRoot;
    private long mStartDelay;
    private TransitionValuesMaps mStartValues;
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes;
    private ArrayList<View> mTargetExcludes;
    private ArrayList<Integer> mTargetIdChildExcludes;
    private ArrayList<Integer> mTargetIdExcludes;
    ArrayList<Integer> mTargetIds;
    private ArrayList<String> mTargetNameExcludes;
    private ArrayList<String> mTargetNames;
    private ArrayList<Class> mTargetTypeChildExcludes;
    private ArrayList<Class> mTargetTypeExcludes;
    private ArrayList<Class> mTargetTypes;
    ArrayList<View> mTargets;

    public static class AnimationInfo {
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowIdImpl mWindowId;

        public AnimationInfo(View r100, String r101, Transition r102, WindowIdImpl r103, TransitionValues r104) {
            this.mView = r100;
            this.mName = r101;
            this.mValues = r104;
            this.mWindowId = r103;
            this.mTransition = r102;
        }
    }

    public static class ArrayListManager {
        private ArrayListManager() {
        }

        public static <T> ArrayList<T> add(ArrayList<T> r100, T r101) {
            if (r100 != null) goto L5;
            r100 = new ArrayList();
        L5:
            if (r100.contains(r101) == true) goto L7;
            r100.add(r101);
        L7:
            return r100;
        }

        public static <T> ArrayList<T> remove(ArrayList<T> r100, T r101) {
            if (r100 == null) goto L7;
            r100.remove(r101);
            if (r100.isEmpty() == false) goto L8;
            return null;
        L8:
            return r100;
        L7:
            return r100;
        }
    }

    public static abstract class EpicenterCallback {
        public EpicenterCallback() {
        }

        public abstract Rect onGetEpicenter(Transition r100);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(Transition r100);

        void onTransitionEnd(Transition r100);

        void onTransitionPause(Transition r100);

        void onTransitionResume(Transition r100);

        void onTransitionStart(Transition r100);
    }

    static {
        DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
        STRAIGHT_PATH_MOTION = new AnonymousClass1();
        sRunningAnimators = new ThreadLocal();
    }

    private static boolean isValidMatch(int r100) {
        if (r100 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 4) goto L7;
        return true;
    }

    public abstract void captureEndValues(TransitionValues r100);

    public abstract void captureStartValues(TransitionValues r100);

    public Transition clone() {
        Transition r100 = (Transition) super.clone();     // Catch: CloneNotSupportedException -> L5
        r100.mAnimators = new ArrayList();     // Catch: CloneNotSupportedException -> L5
        r100.mStartValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L5
        r100.mEndValues = new TransitionValuesMaps();     // Catch: CloneNotSupportedException -> L5
        r100.mStartValuesList = null;     // Catch: CloneNotSupportedException -> L5
        r100.mEndValuesList = null;     // Catch: CloneNotSupportedException -> L5
        return r100;
    L5:
        return null;
    }

    public Animator createAnimator(ViewGroup r100, TransitionValues r101, TransitionValues r102) {
        return null;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> r100 = sRunningAnimators.get();
        if (r100 != null) goto L6;
        ArrayMap<Animator, AnimationInfo> r101 = new ArrayMap();
        sRunningAnimators.set(r101);
        return r101;
    L6:
        return r100;
    }

    public void cancel() {
        int r100 = this.mCurrentAnimators.size() - 1;
    L3:
        if (r100 < 0) goto L5;
        ((Animator) ListProtector.get(this.mCurrentAnimators, r100)).cancel();
        r100 = r100 - 1;
        goto L3
    L5:
        ArrayList<TransitionListener> r101 = this.mListeners;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.size() <= 0) goto L15;
        ArrayList r102 = (ArrayList) this.mListeners.clone();
        int r103 = r102.size();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L16;
        ((TransitionListener) ListProtector.get(r102, r104)).onTransitionCancel(this);
        r104 = r104 + 1;
        goto L10
    L16:
        return;
    }

    public void end() {
        int r100 = this.mNumInstances - 1;
        this.mNumInstances = r100;
        if (r100 != 0) goto L34;
        ArrayList<TransitionListener> r101 = this.mListeners;
        if (r101 != null) goto L7;
    L11:
        int r102 = 0;
    L13:
        if (r102 >= this.mStartValues.mItemIdValues.size()) goto L18;
        View r103 = this.mStartValues.mItemIdValues.valueAt(r102);
        if (r103 == null) goto L17;
        ViewCompat.setHasTransientState(r103, false);
    L17:
        r102 = r102 + 1;
        goto L13
    L18:
        int r104 = 0;
    L20:
        if (r104 >= this.mEndValues.mItemIdValues.size()) goto L25;
        View r105 = this.mEndValues.mItemIdValues.valueAt(r104);
        if (r105 == null) goto L24;
        ViewCompat.setHasTransientState(r105, false);
    L24:
        r104 = r104 + 1;
        goto L20
    L25:
        this.mEnded = true;
        return;
    L7:
        if (r101.size() <= 0) goto L11;
        ArrayList r106 = (ArrayList) this.mListeners.clone();
        int r107 = r106.size();
        int r108 = 0;
    L9:
        if (r108 >= r107) goto L11;
        ((TransitionListener) ListProtector.get(r106, r108)).onTransitionEnd(this);
        r108 = r108 + 1;
        goto L9
    }

    public Rect getEpicenter() {
        EpicenterCallback r100 = this.mEpicenterCallback;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.onGetEpicenter(this);
    }

    public void start() {
        if (this.mNumInstances != 0) goto L12;
        ArrayList<TransitionListener> r100 = this.mListeners;
        if (r100 != null) goto L7;
    L11:
        this.mEnded = false;
        goto L12
    L7:
        if (r100.size() <= 0) goto L11;
        ArrayList r101 = (ArrayList) this.mListeners.clone();
        int r102 = r101.size();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L11;
        ((TransitionListener) ListProtector.get(r101, r103)).onTransitionStart(this);
        r103 = r103 + 1;
    L12:
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public Transition() {
        this.mName = getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mSceneRoot = null;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> r100 = getRunningAnimators();
        Iterator<Animator> r101 = this.mAnimators.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Animator r102 = r101.next();
        if (r100.containsKey(r102) == false) goto L4;
        start();
        runAnimator(r102, r100);
        goto L4
    L8:
        this.mAnimators.clear();
        end();
    }

    public long getDuration() {
        return this.mDuration;
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo7958clone() throws CloneNotSupportedException {
        return clone();
    }

    private static int[] parseMatchOrder(String r100) {
        StringTokenizer r101 = new StringTokenizer(r100, ",");
        int[] r102 = new int[r101.countTokens()];
        int r103 = 0;
    L4:
        if (r101.hasMoreTokens() == false) goto L23;
        String r104 = r101.nextToken().trim();
        if ("id".equalsIgnoreCase(r104) == false) goto L9;
        r102[r103] = 3;
    L20:
        r103 = r103 + 1;
        goto L4
    L9:
        if (MATCH_INSTANCE_STR.equalsIgnoreCase(r104) == false) goto L12;
        r102[r103] = 1;
        goto L20
    L12:
        if ("name".equalsIgnoreCase(r104) == false) goto L15;
        r102[r103] = 2;
        goto L20
    L15:
        if (MATCH_ITEM_ID_STR.equalsIgnoreCase(r104) == false) goto L18;
        r102[r103] = 4;
        goto L20
    L18:
        if (r104.isEmpty() == false) goto L22;
        int[] r105 = new int[r102.length - 1];
        System.arraycopy(r102, 0, r105, 0, r103);
        r103 = r103 - 1;
        r102 = r105;
        goto L20
    L22:
        throw new InflateException("Unknown match type in matchOrder: '" + r104 + "'");
    L23:
        return r102;
    }

    public Transition addListener(TransitionListener r100) {
        if (this.mListeners != null) goto L5;
        this.mListeners = new ArrayList();
    L5:
        this.mListeners.add(r100);
        return this;
    }

    public Transition addTarget(Class r100) {
        if (this.mTargetTypes != null) goto L5;
        this.mTargetTypes = new ArrayList();
    L5:
        this.mTargetTypes.add(r100);
        return this;
    }

    public void animate(Animator r100) {
        if (r100 != null) goto L5;
        end();
        return;
    L5:
        if (getDuration() < 0) goto L8;
        r100.setDuration(getDuration());
    L8:
        if (getStartDelay() < 0) goto L11;
        r100.setStartDelay(getStartDelay());
    L11:
        if (getInterpolator() == null) goto L13;
        r100.setInterpolator(getInterpolator());
    L13:
        r100.addListener(new AnonymousClass3(this));
        r100.start();
    }

    public void capturePropagationValues(TransitionValues r100) {
        if (this.mPropagation != null) goto L5;
        return;
    L5:
        if (r100.values.isEmpty() == true) goto L23;
        String[] r101 = this.mPropagation.getPropagationProperties();
        if (r101 != null) goto L9;
        return;
    L9:
        boolean r102 = false;
        int r103 = 0;
    L11:
        if (r103 >= r101.length) goto L16;
        if (r100.values.containsKey(r101[r103]) == false) goto L17;
        r103 = r103 + 1;
    L17:
        if (r102 == true) goto L24;
        this.mPropagation.captureValues(r100);
        return;
    L24:
        return;
    L16:
        r102 = true;
        goto L17
    }

    public void clearValues(boolean r100) {
        if (r100 == false) goto L4;
        this.mStartValues.mViewValues.clear();
        this.mStartValues.mIdValues.clear();
        this.mStartValues.mItemIdValues.clear();
        return;
    L4:
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        this.mEndValues.mItemIdValues.clear();
    }

    public void forceToEnd(ViewGroup r100) {
        ArrayMap<Animator, AnimationInfo> r101 = getRunningAnimators();
        int r102 = r101.size();
        if (r100 == null) goto L13;
        WindowIdImpl r103 = ViewUtils.getWindowId(r100);
        int r104 = r102 - 1;
    L5:
        if (r104 < 0) goto L19;
        AnimationInfo r105 = r101.valueAt(r104);
        if (r105.mView == null) goto L12;
        if (r103 == null) goto L12;
        if (r103.equals(r105.mWindowId) == false) goto L12;
        r101.keyAt(r104).end();
    L12:
        r104 = r104 - 1;
        goto L5
    L19:
        return;
    }

    public boolean isValidTarget(View r100) {
        int r101 = r100.getId();
        ArrayList<Integer> r102 = this.mTargetIdExcludes;
        if (r102 != null) goto L5;
    L7:
        ArrayList<View> r103 = this.mTargetExcludes;
        if (r103 != null) goto L10;
    L12:
        ArrayList<Class> r104 = this.mTargetTypeExcludes;
        if (r104 == null) goto L21;
        int r105 = r104.size();
        int r106 = 0;
    L15:
        if (r106 >= r105) goto L21;
        if (((Class) ListProtector.get(this.mTargetTypeExcludes, r106)).isInstance(r100) == true) goto L18;
        r106 = r106 + 1;
        goto L15
    L18:
        return false;
    L21:
        if (this.mTargetNameExcludes == null) goto L28;
        if (ViewCompat.getTransitionName(r100) == null) goto L28;
        if (this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(r100)) == false) goto L28;
        return false;
    L28:
        if (this.mTargetIds.size() != 0) goto L41;
        if (this.mTargets.size() != 0) goto L41;
        ArrayList<Class> r107 = this.mTargetTypes;
        if (r107 != null) goto L34;
    L35:
        ArrayList<String> r108 = this.mTargetNames;
        if (r108 != null) goto L38;
    L39:
        return true;
    L38:
        if (r108.isEmpty() == false) goto L41;
    L34:
        if (r107.isEmpty() == true) goto L35;
    L41:
        if (this.mTargetIds.contains(Integer.valueOf(r101)) == false) goto L43;
    L60:
        return true;
    L43:
        if (this.mTargets.contains(r100) == true) goto L60;
        ArrayList<String> r109 = this.mTargetNames;
        if (r109 == null) goto L51;
        if (r109.contains(ViewCompat.getTransitionName(r100)) == false) goto L51;
        return true;
    L51:
        if (this.mTargetTypes == null) goto L59;
        int r110 = 0;
    L54:
        if (r110 >= this.mTargetTypes.size()) goto L59;
        if (((Class) ListProtector.get(this.mTargetTypes, r110)).isInstance(r100) == true) goto L57;
        r110 = r110 + 1;
        goto L54
    L57:
        return true;
    L59:
        return false;
    L10:
        if (r103.contains(r100) == false) goto L12;
        return false;
    L5:
        if (r102.contains(Integer.valueOf(r101)) == false) goto L7;
        return false;
    }

    public void pause(View r100) {
        if (this.mEnded == true) goto L26;
        ArrayMap<Animator, AnimationInfo> r101 = getRunningAnimators();
        int r102 = r101.size();
        WindowIdImpl r103 = ViewUtils.getWindowId(r100);
        int r104 = r102 - 1;
    L5:
        if (r104 < 0) goto L12;
        AnimationInfo r105 = r101.valueAt(r104);
        if (r105.mView == null) goto L11;
        if (r103.equals(r105.mWindowId) == false) goto L11;
        AnimatorUtils.pause(r101.keyAt(r104));
    L11:
        r104 = r104 - 1;
        goto L5
    L12:
        ArrayList<TransitionListener> r106 = this.mListeners;
        if (r106 != null) goto L15;
    L19:
        this.mPaused = true;
        return;
    L15:
        if (r106.size() <= 0) goto L19;
        ArrayList r107 = (ArrayList) this.mListeners.clone();
        int r108 = r107.size();
        int r109 = 0;
    L17:
        if (r109 >= r108) goto L19;
        ((TransitionListener) ListProtector.get(r107, r109)).onTransitionPause(this);
        r109 = r109 + 1;
        goto L17
    }

    public void playTransition(ViewGroup r110) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> r100 = getRunningAnimators();
        int r101 = r100.size();
        WindowIdImpl r102 = ViewUtils.getWindowId(r110);
        int r103 = r101 - 1;
    L3:
        if (r103 < 0) goto L28;
        Animator r104 = r100.keyAt(r103);
        if (r104 == null) goto L27;
        AnimationInfo r105 = r100.get(r104);
        if (r105 == null) goto L27;
        if (r105.mView == null) goto L27;
        if (r102.equals(r105.mWindowId) == false) goto L27;
        TransitionValues r106 = r105.mValues;
        View r107 = r105.mView;
        TransitionValues r108 = getTransitionValues(r107, true);
        TransitionValues r109 = getMatchedTransitionValues(r107, true);
        if (r108 != null) goto L16;
        if (r109 != null) goto L16;
    L18:
        boolean r111 = false;
    L19:
        if (r111 == false) goto L27;
        if (r104.isRunning() == false) goto L23;
    L26:
        r104.cancel();
        goto L27
    L23:
        if (r104.isStarted() == true) goto L26;
        r100.remove(r104);
    L16:
        if (r105.mTransition.isTransitionRequired(r106, r109) == false) goto L18;
        r111 = true;
    L27:
        r103 = r103 - 1;
        goto L3
    L28:
        createAnimators(r110, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public Transition removeListener(TransitionListener r100) {
        ArrayList<TransitionListener> r101 = this.mListeners;
        if (r101 != null) goto L5;
        return this;
    L5:
        r101.remove(r100);
        if (this.mListeners.size() != 0) goto L8;
        this.mListeners = null;
    L8:
        return this;
    }

    public Transition removeTarget(int r100) {
        if (r100 == 0) goto L4;
        this.mTargetIds.remove(Integer.valueOf(r100));
    L4:
        return this;
    }

    public void resume(View r100) {
        if (this.mPaused == true) goto L5;
        return;
    L5:
        if (this.mEnded == true) goto L21;
        ArrayMap<Animator, AnimationInfo> r101 = getRunningAnimators();
        int r102 = r101.size();
        WindowIdImpl r103 = ViewUtils.getWindowId(r100);
        int r104 = r102 - 1;
    L7:
        if (r104 < 0) goto L14;
        AnimationInfo r105 = r101.valueAt(r104);
        if (r105.mView == null) goto L13;
        if (r103.equals(r105.mWindowId) == false) goto L13;
        AnimatorUtils.resume(r101.keyAt(r104));
    L13:
        r104 = r104 - 1;
        goto L7
    L14:
        ArrayList<TransitionListener> r106 = this.mListeners;
        if (r106 == null) goto L21;
        if (r106.size() <= 0) goto L21;
        ArrayList r107 = (ArrayList) this.mListeners.clone();
        int r108 = r107.size();
        int r109 = 0;
    L19:
        if (r109 >= r108) goto L21;
        ((TransitionListener) ListProtector.get(r107, r109)).onTransitionResume(this);
        r109 = r109 + 1;
    L21:
        this.mPaused = false;
    }

    public void setCanRemoveViews(boolean r100) {
        this.mCanRemoveViews = r100;
    }

    public Transition setDuration(long r100) {
        this.mDuration = r100;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback r100) {
        this.mEpicenterCallback = r100;
    }

    public Transition setInterpolator(TimeInterpolator r100) {
        this.mInterpolator = r100;
        return this;
    }

    public void setMatchOrder(int... r100) {
        if (r100 != null) goto L4;
    L19:
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        return;
    L4:
        if (r100.length == 0) goto L19;
        int r101 = 0;
    L8:
        if (r101 >= r100.length) goto L18;
        if (isValidMatch(r100[r101]) == false) goto L17;
        if (alreadyContains(r100, r101) == true) goto L15;
        r101 = r101 + 1;
        goto L8
    L15:
        throw new IllegalArgumentException("matches contains a duplicate value");
    L17:
        throw new IllegalArgumentException("matches contains invalid value");
    L18:
        this.mMatchOrder = (int[]) r100.clone();
    }

    public void setPathMotion(PathMotion r100) {
        if (r100 != null) goto L4;
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        return;
    L4:
        this.mPathMotion = r100;
    }

    public void setPropagation(TransitionPropagation r100) {
        this.mPropagation = r100;
    }

    public Transition setSceneRoot(ViewGroup r100) {
        this.mSceneRoot = r100;
        return this;
    }

    public Transition setStartDelay(long r100) {
        this.mStartDelay = r100;
        return this;
    }

    public String toString(String r100) {
        String r101 = r100 + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration == (-1)) goto L6;
        r101 = r101 + "dur(" + this.mDuration + ") ";
    L6:
        if (this.mStartDelay == (-1)) goto L9;
        r101 = r101 + "dly(" + this.mStartDelay + ") ";
    L9:
        if (this.mInterpolator == null) goto L12;
        r101 = r101 + "interp(" + this.mInterpolator + ") ";
    L12:
        if (this.mTargetIds.size() <= 0) goto L14;
    L15:
        String r102 = r101 + "tgts(";
        int r103 = 0;
        if (this.mTargetIds.size() <= 0) goto L24;
        int r104 = 0;
    L19:
        if (r104 >= this.mTargetIds.size()) goto L24;
        if (r104 <= 0) goto L22;
        r102 = r102 + ", ";
    L22:
        r102 = r102 + ListProtector.get(this.mTargetIds, r104);
        r104 = r104 + 1;
    L24:
        if (this.mTargets.size() <= 0) goto L31;
    L26:
        if (r103 >= this.mTargets.size()) goto L31;
        if (r103 <= 0) goto L29;
        r102 = r102 + ", ";
    L29:
        r102 = r102 + ListProtector.get(this.mTargets, r103);
        r103 = r103 + 1;
    L31:
        return r102 + ")";
    L14:
        if (this.mTargets.size() > 0) goto L15;
        return r101;
    }

    public Transition addTarget(String r100) {
        if (this.mTargetNames != null) goto L5;
        this.mTargetNames = new ArrayList();
    L5:
        this.mTargetNames.add(r100);
        return this;
    }

    public Transition removeTarget(Class r100) {
        ArrayList<Class> r101 = this.mTargetTypes;
        if (r101 == null) goto L5;
        r101.remove(r100);
    L5:
        return this;
    }

    public Transition addTarget(int r100) {
        if (r100 == 0) goto L4;
        this.mTargetIds.add(Integer.valueOf(r100));
    L4:
        return this;
    }

    public Transition removeTarget(String r100) {
        ArrayList<String> r101 = this.mTargetNames;
        if (r101 == null) goto L5;
        r101.remove(r100);
    L5:
        return this;
    }

    public Transition addTarget(View r100) {
        this.mTargets.add(r100);
        return this;
    }

    public Transition removeTarget(View r100) {
        this.mTargets.remove(r100);
        return this;
    }

    public Transition(Context r100, AttributeSet r110) {
        this.mName = getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mSceneRoot = null;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray r101 = r100.obtainStyledAttributes(r110, Styleable.TRANSITION);
        XmlResourceParser r111 = (XmlResourceParser) r110;
        long r102 = TypedArrayUtils.getNamedInt(r101, r111, "duration", 1, -1);
        if (r102 < 0) goto L5;
        setDuration(r102);
    L5:
        long r103 = TypedArrayUtils.getNamedInt(r101, r111, "startDelay", 2, -1);
        if (r103 <= 0) goto L8;
        setStartDelay(r103);
    L8:
        int r104 = TypedArrayUtils.getNamedResourceId(r101, r111, "interpolator", 0, 0);
        if (r104 <= 0) goto L11;
        setInterpolator(AnimationUtils.loadInterpolator(r100, r104));
    L11:
        String r105 = TypedArrayUtils.getNamedString(r101, r111, "matchOrder", 3);
        if (r105 == null) goto L14;
        setMatchOrder(parseMatchOrder(r105));
    L14:
        r101.recycle();
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> r100, ArrayMap<View, TransitionValues> r101) {
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r100.size()) goto L10;
        TransitionValues r104 = r100.valueAt(r103);
        if (isValidTarget(r104.view) == false) goto L8;
        this.mStartValuesList.add(r104);
        this.mEndValuesList.add(null);
    L8:
        r103 = r103 + 1;
    L10:
        if (r102 >= r101.size()) goto L15;
        TransitionValues r105 = r101.valueAt(r102);
        if (isValidTarget(r105.view) == false) goto L14;
        this.mEndValuesList.add(r105);
        this.mStartValuesList.add(null);
    L14:
        r102 = r102 + 1;
        goto L10
    }

    private static boolean alreadyContains(int[] r100, int r101) {
        int r102 = r100[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L9;
        if (r100[r103] == r102) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void captureHierarchy(View r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = r100.getId();
        ArrayList<Integer> r103 = this.mTargetIdExcludes;
        if (r103 != null) goto L7;
    L9:
        ArrayList<View> r104 = this.mTargetExcludes;
        if (r104 != null) goto L12;
    L14:
        ArrayList<Class> r105 = this.mTargetTypeExcludes;
        int r106 = 0;
        if (r105 == null) goto L23;
        int r107 = r105.size();
        int r108 = 0;
    L17:
        if (r108 >= r107) goto L23;
        if (((Class) ListProtector.get(this.mTargetTypeExcludes, r108)).isInstance(r100) == true) goto L20;
        r108 = r108 + 1;
        goto L17
    L20:
        return;
    L23:
        if ((r100.getParent() instanceof ViewGroup) == false) goto L33;
        TransitionValues r109 = new TransitionValues();
        r109.view = r100;
        if (r101 == false) goto L27;
        captureStartValues(r109);
    L28:
        r109.mTargetedTransitions.add(this);
        capturePropagationValues(r109);
        if (r101 == false) goto L31;
        addViewValues(this.mStartValues, r100, r109);
        goto L33
    L31:
        addViewValues(this.mEndValues, r100, r109);
        goto L33
    L27:
        captureEndValues(r109);
    L33:
        if ((r100 instanceof ViewGroup) == false) goto L56;
        ArrayList<Integer> r110 = this.mTargetIdChildExcludes;
        if (r110 != null) goto L37;
    L39:
        ArrayList<View> r111 = this.mTargetChildExcludes;
        if (r111 != null) goto L42;
    L44:
        ArrayList<Class> r112 = this.mTargetTypeChildExcludes;
        if (r112 == null) goto L52;
        int r113 = r112.size();
        int r114 = 0;
    L47:
        if (r114 >= r113) goto L52;
        if (((Class) ListProtector.get(this.mTargetTypeChildExcludes, r114)).isInstance(r100) == true) goto L50;
        r114 = r114 + 1;
        goto L47
    L50:
        return;
    L52:
        ViewGroup r115 = (ViewGroup) r100;
    L54:
        if (r106 >= r115.getChildCount()) goto L62;
        captureHierarchy(r115.getChildAt(r106), r101);
        r106 = r106 + 1;
        goto L54
    L62:
        return;
    L42:
        if (r111.contains(r100) == false) goto L44;
        return;
    L37:
        if (r110.contains(Integer.valueOf(r102)) == false) goto L39;
        return;
    L56:
        return;
    L12:
        if (r104.contains(r100) == false) goto L14;
        return;
    L7:
        if (r103.contains(Integer.valueOf(r102)) == false) goto L9;
    }

    private void matchInstances(ArrayMap<View, TransitionValues> r100, ArrayMap<View, TransitionValues> r101) {
        int r102 = r100.size() - 1;
    L3:
        if (r102 < 0) goto L16;
        View r103 = r100.keyAt(r102);
        if (r103 == null) goto L15;
        if (isValidTarget(r103) == false) goto L15;
        TransitionValues r104 = r101.remove(r103);
        if (r104 == null) goto L15;
        View r105 = r104.view;
        if (r105 == null) goto L15;
        if (isValidTarget(r105) == false) goto L15;
        this.mStartValuesList.add(r100.removeAt(r102));
        this.mEndValuesList.add(r104);
    L15:
        r102 = r102 - 1;
        goto L3
    }

    private void matchStartAndEnd(TransitionValuesMaps r100, TransitionValuesMaps r101) {
        ArrayMap<View, TransitionValues> r102 = new ArrayMap(r100.mViewValues);
        ArrayMap<View, TransitionValues> r103 = new ArrayMap(r101.mViewValues);
        int r104 = 0;
    L3:
        int[] r105 = this.mMatchOrder;
        if (r104 >= r105.length) goto L19;
        int r106 = r105[r104];
        if (r106 != 1) goto L8;
        matchInstances(r102, r103);
    L18:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r106 != 2) goto L10;
        matchNames(r102, r103, r100.mNameValues, r101.mNameValues);
        goto L18
    L10:
        if (r106 != 3) goto L12;
        matchIds(r102, r103, r100.mIdValues, r101.mIdValues);
        goto L18
    L12:
        if (r106 != 4) goto L18;
        matchItemIds(r102, r103, r100.mItemIdValues, r101.mItemIdValues);
        goto L18
    L19:
        addUnmatched(r102, r103);
    }

    private void runAnimator(Animator r100, final ArrayMap<Animator, AnimationInfo> r101) {
        if (r100 == null) goto L5;
        r100.addListener(new AnonymousClass2(this, r101));
        animate(r100);
        return;
    }

    public void captureValues(ViewGroup r100, boolean r101) {
        clearValues(r101);
        int r102 = 0;
        if (this.mTargetIds.size() <= 0) goto L5;
    L6:
        ArrayList<String> r103 = this.mTargetNames;
        if (r103 != null) goto L9;
    L10:
        ArrayList<Class> r104 = this.mTargetTypes;
        if (r104 != null) goto L13;
    L16:
        int r105 = 0;
    L18:
        if (r105 >= this.mTargetIds.size()) goto L30;
        View r106 = r100.findViewById(((Integer) ListProtector.get(this.mTargetIds, r105)).intValue());
        if (r106 == null) goto L29;
        TransitionValues r107 = new TransitionValues();
        r107.view = r106;
        if (r101 == false) goto L24;
        captureStartValues(r107);
    L25:
        r107.mTargetedTransitions.add(this);
        capturePropagationValues(r107);
        if (r101 == false) goto L28;
        addViewValues(this.mStartValues, r106, r107);
        goto L29
    L28:
        addViewValues(this.mEndValues, r106, r107);
        goto L29
    L24:
        captureEndValues(r107);
    L29:
        r105 = r105 + 1;
        goto L18
    L30:
        int r108 = 0;
    L32:
        if (r108 >= this.mTargets.size()) goto L42;
        View r109 = (View) ListProtector.get(this.mTargets, r108);
        TransitionValues r110 = new TransitionValues();
        r110.view = r109;
        if (r101 == false) goto L36;
        captureStartValues(r110);
    L37:
        r110.mTargetedTransitions.add(this);
        capturePropagationValues(r110);
        if (r101 == false) goto L40;
        addViewValues(this.mStartValues, r109, r110);
    L41:
        r108 = r108 + 1;
        goto L32
    L40:
        addViewValues(this.mEndValues, r109, r110);
        goto L41
    L36:
        captureEndValues(r110);
    L42:
        if (r101 == true) goto L53;
        ArrayMap<String, String> r111 = this.mNameOverrides;
        if (r111 == null) goto L65;
        int r112 = r111.size();
        ArrayList r113 = new ArrayList(r112);
        int r114 = 0;
    L46:
        if (r114 >= r112) goto L48;
        String r115 = this.mNameOverrides.keyAt(r114);
        r113.add(this.mStartValues.mNameValues.remove(r115));
        r114 = r114 + 1;
    L48:
        if (r102 >= r112) goto L66;
        View r116 = (View) ListProtector.get(r113, r102);
        if (r116 == null) goto L52;
        String r117 = this.mNameOverrides.valueAt(r102);
        this.mStartValues.mNameValues.put(r117, r116);
    L52:
        r102 = r102 + 1;
        goto L48
    L66:
        return;
    L65:
        return;
    L53:
        return;
    L13:
        if (r104.isEmpty() == true) goto L16;
    L15:
        captureHierarchy(r100, r101);
        goto L42
    L9:
        if (r103.isEmpty() == false) goto L15;
    L5:
        if (this.mTargets.size() <= 0) goto L15;
        goto L6
    }

    public Transition excludeChildren(int r100, boolean r101) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, r100, r101);
        return this;
    }

    public Transition excludeTarget(int r100, boolean r101) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, r100, r101);
        return this;
    }

    public TransitionValues getMatchedTransitionValues(View r100, boolean r101) {
        TransitionSet r102 = this.mParent;
        if (r102 != null) goto L5;
        if (r101 == false) goto L8;
        ArrayList<TransitionValues> r103 = this.mStartValuesList;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        int r104 = r103.size();
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L21;
        TransitionValues r106 = (TransitionValues) ListProtector.get(r103, r105);
        if (r106 == null) goto L16;
        if (r106.view == r100) goto L22;
        r105 = r105 + 1;
    L22:
        if (r105 < 0) goto L31;
        if (r101 == false) goto L25;
        ArrayList<TransitionValues> r107 = this.mEndValuesList;
    L27:
        return (TransitionValues) ListProtector.get(r107, r105);
    L25:
        r107 = this.mStartValuesList;
        goto L27
    L31:
        return null;
    L16:
        return null;
    L21:
        r105 = -1;
        goto L22
    L8:
        r103 = this.mEndValuesList;
        goto L10
    L5:
        return r102.getMatchedTransitionValues(r100, r101);
    }

    public TransitionValues getTransitionValues(View r100, boolean r101) {
        TransitionSet r102 = this.mParent;
        if (r102 != null) goto L5;
        if (r101 == false) goto L8;
        TransitionValuesMaps r103 = this.mStartValues;
    L10:
        return r103.mViewValues.get(r100);
    L8:
        r103 = this.mEndValues;
        goto L10
    L5:
        return r102.getTransitionValues(r100, r101);
    }

    public boolean isTransitionRequired(TransitionValues r100, TransitionValues r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L26;
        String[] r102 = getTransitionProperties();
        if (r102 == null) goto L13;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L27;
        if (isValueChanged(r100, r101, r102[r104]) == true) goto L18;
        r104 = r104 + 1;
    L18:
        return true;
    L27:
        return false;
    L13:
        Iterator<String> r105 = r100.values.keySet().iterator();
    L15:
        if (r105.hasNext() == false) goto L28;
        if (isValueChanged(r100, r101, r105.next()) == false) goto L15;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    public Transition excludeChildren(View r100, boolean r101) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, r100, r101);
        return this;
    }

    public Transition excludeTarget(View r100, boolean r101) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, r100, r101);
        return this;
    }

    public Transition excludeChildren(Class r100, boolean r101) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, r100, r101);
        return this;
    }

    public Transition excludeTarget(Class r100, boolean r101) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, r100, r101);
        return this;
    }

    public Transition excludeTarget(String r100, boolean r101) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, r100, r101);
        return this;
    }

    private static void addViewValues(TransitionValuesMaps r100, View r101, TransitionValues r102) {
        r100.mViewValues.put(r101, r102);
        int r103 = r101.getId();
        if (r103 >= 0) goto L5;
    L8:
        String r104 = ViewCompat.getTransitionName(r101);
        if (r104 == null) goto L15;
        if (r100.mNameValues.containsKey(r104) == false) goto L13;
        r100.mNameValues.put(r104, null);
        goto L15
    L13:
        r100.mNameValues.put(r104, r101);
    L15:
        if ((r101.getParent() instanceof ListView) == false) goto L25;
        ListView r105 = (ListView) r101.getParent();
        if (r105.getAdapter().hasStableIds() == false) goto L26;
        long r106 = r105.getItemIdAtPosition(r105.getPositionForView(r101));
        if (r100.mItemIdValues.indexOfKey(r106) < 0) goto L23;
        View r107 = r100.mItemIdValues.get(r106);
        if (r107 == null) goto L27;
        ViewCompat.setHasTransientState(r107, false);
        r100.mItemIdValues.put(r106, null);
        return;
    L27:
        return;
    L23:
        ViewCompat.setHasTransientState(r101, true);
        r100.mItemIdValues.put(r106, r101);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r100.mIdValues.indexOfKey(r103) < 0) goto L7;
        r100.mIdValues.put(r103, null);
        goto L8
    L7:
        r100.mIdValues.put(r103, r101);
        goto L8
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> r100, int r101, boolean r102) {
        if (r101 <= 0) goto L7;
        if (r102 == false) goto L6;
        return ArrayListManager.add(r100, Integer.valueOf(r101));
    L6:
        return ArrayListManager.remove(r100, Integer.valueOf(r101));
    L7:
        return r100;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> r100, T r101, boolean r102) {
        if (r101 == null) goto L7;
        if (r102 == false) goto L6;
        return ArrayListManager.add(r100, r101);
    L6:
        return ArrayListManager.remove(r100, r101);
    L7:
        return r100;
    }

    private ArrayList<Class> excludeType(ArrayList<Class> r100, Class r101, boolean r102) {
        if (r101 == null) goto L7;
        if (r102 == false) goto L6;
        return ArrayListManager.add(r100, r101);
    L6:
        return ArrayListManager.remove(r100, r101);
    L7:
        return r100;
    }

    private ArrayList<View> excludeView(ArrayList<View> r100, View r101, boolean r102) {
        if (r101 == null) goto L7;
        if (r102 == false) goto L6;
        return ArrayListManager.add(r100, r101);
    L6:
        return ArrayListManager.remove(r100, r101);
    L7:
        return r100;
    }

    private static boolean isValueChanged(TransitionValues r100, TransitionValues r101, String r102) {
        Object r103 = r100.values.get(r102);
        Object r104 = r101.values.get(r102);
        if (r103 != null) goto L7;
        if (r104 != null) goto L7;
        return false;
    L7:
        if (r103 == null) goto L11;
        if (r104 == null) goto L11;
        return !r103.equals(r104);
    L11:
        return true;
    }

    private void matchIds(ArrayMap<View, TransitionValues> r100, ArrayMap<View, TransitionValues> r101, SparseArray<View> r110, SparseArray<View> r111) {
        int r102 = r110.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        View r104 = r110.valueAt(r103);
        if (r104 == null) goto L16;
        if (isValidTarget(r104) == false) goto L16;
        View r105 = r111.get(r110.keyAt(r103));
        if (r105 == null) goto L16;
        if (isValidTarget(r105) == false) goto L16;
        TransitionValues r106 = r100.get(r104);
        TransitionValues r107 = r101.get(r105);
        if (r106 == null) goto L16;
        if (r107 == null) goto L16;
        this.mStartValuesList.add(r106);
        this.mEndValuesList.add(r107);
        r100.remove(r104);
        r101.remove(r105);
    L16:
        r103 = r103 + 1;
        goto L3
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> r100, ArrayMap<View, TransitionValues> r101, LongSparseArray<View> r110, LongSparseArray<View> r111) {
        int r102 = r110.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        View r104 = r110.valueAt(r103);
        if (r104 == null) goto L16;
        if (isValidTarget(r104) == false) goto L16;
        View r105 = r111.get(r110.keyAt(r103));
        if (r105 == null) goto L16;
        if (isValidTarget(r105) == false) goto L16;
        TransitionValues r106 = r100.get(r104);
        TransitionValues r107 = r101.get(r105);
        if (r106 == null) goto L16;
        if (r107 == null) goto L16;
        this.mStartValuesList.add(r106);
        this.mEndValuesList.add(r107);
        r100.remove(r104);
        r101.remove(r105);
    L16:
        r103 = r103 + 1;
        goto L3
    }

    private void matchNames(ArrayMap<View, TransitionValues> r100, ArrayMap<View, TransitionValues> r101, ArrayMap<String, View> r110, ArrayMap<String, View> r111) {
        int r102 = r110.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        View r104 = r110.valueAt(r103);
        if (r104 == null) goto L16;
        if (isValidTarget(r104) == false) goto L16;
        View r105 = r111.get(r110.keyAt(r103));
        if (r105 == null) goto L16;
        if (isValidTarget(r105) == false) goto L16;
        TransitionValues r106 = r100.get(r104);
        TransitionValues r107 = r101.get(r105);
        if (r106 == null) goto L16;
        if (r107 == null) goto L16;
        this.mStartValuesList.add(r106);
        this.mEndValuesList.add(r107);
        r100.remove(r104);
        r101.remove(r105);
    L16:
        r103 = r103 + 1;
        goto L3
    }

    public void createAnimators(ViewGroup r210, TransitionValuesMaps r211, TransitionValuesMaps r212, ArrayList<TransitionValues> r213, ArrayList<TransitionValues> r214) {
        ArrayMap<Animator, AnimationInfo> r100 = getRunningAnimators();
        SparseIntArray r101 = new SparseIntArray();
        int r110 = r213.size();
        long r102 = Long.MAX_VALUE;
        int r111 = 0;
    L3:
        if (r111 >= r110) goto L61;
        TransitionValues r103 = (TransitionValues) ListProtector.get(r213, r111);
        TransitionValues r104 = (TransitionValues) ListProtector.get(r214, r111);
        if (r103 != null) goto L7;
    L9:
        if (r104 != null) goto L11;
    L13:
        if (r103 != null) goto L16;
        if (r104 != null) goto L16;
    L15:
        int r112 = r110;
    L59:
        r111 = r111 + 1;
        r110 = r112;
    L16:
        if (r103 == null) goto L22;
        if (r104 == null) goto L22;
        if (isTransitionRequired(r103, r104) == true) goto L22;
        boolean r105 = false;
    L23:
        if (r105 == false) goto L15;
        Animator r106 = createAnimator(r210, r103, r104);
        if (r106 == null) goto L15;
        if (r104 == null) goto L53;
        View r113 = r104.view;
        String[] r107 = getTransitionProperties();
        if (r113 == null) goto L51;
        if (r107 == null) goto L51;
        if (r107.length <= 0) goto L51;
        TransitionValues r114 = new TransitionValues();
        r114.view = r113;
        r112 = r110;
        TransitionValues r108 = r212.mViewValues.get(r113);
        if (r108 == null) goto L38;
        int r115 = 0;
    L36:
        if (r115 >= r107.length) goto L38;
        Map<String, Object> r116 = r114.values;
        String r117 = r107[r115];
        String[] r118 = r107;
        r116.put(r117, r108.values.get(r117));
        r115 = r115 + 1;
        r107 = r118;
    L38:
        int r109 = r100.size();
        int r119 = 0;
    L39:
        if (r119 >= r109) goto L50;
        AnimationInfo r120 = r100.get(r100.keyAt(r119));
        if (r120.mValues == null) goto L49;
        if (r120.mView != r113) goto L49;
        if (r120.mName.equals(getName()) == false) goto L49;
        if (r120.mValues.equals(r114) == false) goto L49;
        Animator r121 = null;
    L52:
        Animator r122 = r121;
        TransitionValues r123 = r114;
    L54:
        if (r122 == null) goto L59;
        TransitionPropagation r124 = this.mPropagation;
        if (r124 == null) goto L58;
        long r125 = r124.getStartDelay(r210, this, r103, r104);
        r101.put(this.mAnimators.size(), (int) r125);
        r102 = Math.min(r125, r102);
    L58:
        long r126 = r102;
        View r127 = r113;
        r100.put(r122, new AnimationInfo(r127, getName(), this, ViewUtils.getWindowId(r210), r123));
        this.mAnimators.add(r122);
        r102 = r126;
    L49:
        r119 = r119 + 1;
        goto L39
    L50:
        r121 = r106;
    L51:
        r112 = r110;
        r121 = r106;
        r114 = null;
        goto L52
    L53:
        r112 = r110;
        r113 = r103.view;
        r122 = r106;
        r123 = null;
    L22:
        r105 = true;
        goto L23
    L11:
        if (r104.mTargetedTransitions.contains(this) == true) goto L13;
        r104 = null;
        goto L13
    L7:
        if (r103.mTargetedTransitions.contains(this) == true) goto L9;
        r103 = null;
        goto L9
    L61:
        if (r102 == 0) goto L66;
        int r128 = 0;
    L64:
        if (r128 >= r101.size()) goto L79;
        int r129 = r101.keyAt(r128);
        Animator r130 = (Animator) ListProtector.get(this.mAnimators, r129);
        r130.setStartDelay((((long) r101.valueAt(r128)) - r102) + r130.getStartDelay());
        r128 = r128 + 1;
        goto L64
    L79:
        return;
    }
}
