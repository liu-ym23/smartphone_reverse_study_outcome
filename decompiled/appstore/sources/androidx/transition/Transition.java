package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
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
    private static ThreadLocal<ArrayMap> sRunningAnimators;
    private ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration;
    private t mEndValues;
    private ArrayList<s> mEndValuesList;
    private boolean mEnded;
    private f mEpicenterCallback;
    private TimeInterpolator mInterpolator;
    private ArrayList<TransitionListener> mListeners;
    private int[] mMatchOrder;
    private String mName;
    private ArrayMap mNameOverrides;
    private int mNumInstances;
    TransitionSet mParent;
    private PathMotion mPathMotion;
    private boolean mPaused;
    q mPropagation;
    private long mStartDelay;
    private t mStartValues;
    private ArrayList<s> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes;
    private ArrayList<View> mTargetExcludes;
    private ArrayList<Integer> mTargetIdChildExcludes;
    private ArrayList<Integer> mTargetIdExcludes;
    ArrayList<Integer> mTargetIds;
    private ArrayList<String> mTargetNameExcludes;
    private ArrayList<String> mTargetNames;
    private ArrayList<Class<?>> mTargetTypeChildExcludes;
    private ArrayList<Class<?>> mTargetTypeExcludes;
    private ArrayList<Class<?>> mTargetTypes;
    ArrayList<View> mTargets;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition r10);

        void onTransitionEnd(@NonNull Transition r10);

        void onTransitionPause(@NonNull Transition r10);

        void onTransitionResume(@NonNull Transition r10);

        void onTransitionStart(@NonNull Transition r10);
    }

    public class a extends PathMotion {
        public a() {
        }

        @Override // androidx.transition.PathMotion
        public Path getPath(float r10, float r11, float r12, float r13) {
            Path r14 = new Path();
            r14.moveTo(r10, r11);
            r14.lineTo(r12, r13);
            return r14;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayMap f5005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Transition f5006b;

        public b(Transition r10, ArrayMap r11) {
            this.f5006b = r10;
            this.f5005a = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f5005a.remove(r10);
            this.f5006b.mCurrentAnimators.remove(r10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f5006b.mCurrentAnimators.add(r10);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Transition f5007a;

        public c(Transition r10) {
            this.f5007a = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f5007a.end();
            r10.removeListener(this);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f5008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f5010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public WindowIdImpl f5011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Transition f5012e;

        public d(View r10, String r11, Transition r12, WindowIdImpl r13, s r14) {
            this.f5008a = r10;
            this.f5009b = r11;
            this.f5010c = r14;
            this.f5011d = r13;
            this.f5012e = r12;
        }
    }

    public static class e {
        public static ArrayList a(ArrayList r10, Object r11) {
            if (r10 != null) goto L5;
            r10 = new ArrayList();
        L5:
            if (r10.contains(r11) == true) goto L7;
            r10.add(r11);
        L7:
            return r10;
        }

        public static ArrayList b(ArrayList r10, Object r11) {
            if (r10 == null) goto L7;
            r10.remove(r11);
            if (r10.isEmpty() == false) goto L8;
            return null;
        L8:
            return r10;
        L7:
            return r10;
        }
    }

    public static abstract class f {
        public f() {
        }

        public abstract Rect a(Transition r10);
    }

    static {
        DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
        STRAIGHT_PATH_MOTION = new a();
        sRunningAnimators = new ThreadLocal();
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
        this.mStartValues = new t();
        this.mEndValues = new t();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    public static void b(t r10, View r11, s r12) {
        r10.f5088a.put(r11, r12);
        int r13 = r11.getId();
        if (r13 >= 0) goto L5;
    L8:
        String r14 = ViewCompat.J(r11);
        if (r14 == null) goto L15;
        if (r10.f5091d.containsKey(r14) == false) goto L13;
        r10.f5091d.put(r14, null);
        goto L15
    L13:
        r10.f5091d.put(r14, r11);
    L15:
        if ((r11.getParent() instanceof ListView) == false) goto L25;
        ListView r15 = (ListView) r11.getParent();
        if (r15.getAdapter().hasStableIds() == false) goto L26;
        long r16 = r15.getItemIdAtPosition(r15.getPositionForView(r11));
        if (r10.f5090c.g(r16) < 0) goto L23;
        View r17 = (View) r10.f5090c.e(r16);
        if (r17 == null) goto L27;
        ViewCompat.z0(r17, false);
        r10.f5090c.j(r16, null);
        return;
    L27:
        return;
    L23:
        ViewCompat.z0(r11, true);
        r10.f5090c.j(r16, r11);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r10.f5089b.indexOfKey(r13) < 0) goto L7;
        r10.f5089b.put(r13, null);
        goto L8
    L7:
        r10.f5089b.put(r13, r11);
        goto L8
    }

    public static boolean c(int[] r10, int r11) {
        int r12 = r10[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L9;
        if (r10[r13] == r12) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static ArrayList f(ArrayList r10, Object r11, boolean r12) {
        if (r11 == null) goto L7;
        if (r12 == false) goto L6;
        return e.a(r10, r11);
    L6:
        return e.b(r10, r11);
    L7:
        return r10;
    }

    public static ArrayMap i() {
        ArrayMap r10 = sRunningAnimators.get();
        if (r10 != null) goto L6;
        ArrayMap r11 = new ArrayMap();
        sRunningAnimators.set(r11);
        return r11;
    L6:
        return r10;
    }

    public static boolean j(int r10) {
        if (r10 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 4) goto L7;
        return true;
    }

    public static boolean k(s r10, s r11, String r12) {
        Object r13 = r10.f5085a.get(r12);
        Object r14 = r11.f5085a.get(r12);
        if (r13 != null) goto L7;
        if (r14 != null) goto L7;
        return false;
    L7:
        if (r13 == null) goto L12;
        if (r14 == null) goto L12;
        return !r13.equals(r14);
    L12:
        return true;
    }

    public static int[] q(String r10) {
        StringTokenizer r11 = new StringTokenizer(r10, ",");
        int[] r12 = new int[r11.countTokens()];
        int r13 = 0;
    L4:
        if (r11.hasMoreTokens() == false) goto L23;
        String r14 = r11.nextToken().trim();
        if ("id".equalsIgnoreCase(r14) == false) goto L9;
        r12[r13] = 3;
    L20:
        r13 = r13 + 1;
        goto L4
    L9:
        if (MATCH_INSTANCE_STR.equalsIgnoreCase(r14) == false) goto L12;
        r12[r13] = 1;
        goto L20
    L12:
        if ("name".equalsIgnoreCase(r14) == false) goto L15;
        r12[r13] = 2;
        goto L20
    L15:
        if (MATCH_ITEM_ID_STR.equalsIgnoreCase(r14) == false) goto L18;
        r12[r13] = 4;
        goto L20
    L18:
        if (r14.isEmpty() == false) goto L22;
        int[] r15 = new int[r12.length - 1];
        System.arraycopy(r12, 0, r15, 0, r13);
        r13 = r13 - 1;
        r12 = r15;
        goto L20
    L22:
        throw new InflateException("Unknown match type in matchOrder: '" + r14 + "'");
    L23:
        return r12;
    }

    public final void a(ArrayMap r10, ArrayMap r11) {
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r10.size()) goto L10;
        s r14 = (s) r10.valueAt(r13);
        if (isValidTarget(r14.f5086b) == false) goto L8;
        this.mStartValuesList.add(r14);
        this.mEndValuesList.add(null);
    L8:
        r13 = r13 + 1;
    L10:
        if (r12 >= r11.size()) goto L15;
        s r15 = (s) r11.valueAt(r12);
        if (isValidTarget(r15.f5086b) == false) goto L14;
        this.mEndValuesList.add(r15);
        this.mStartValuesList.add(null);
    L14:
        r12 = r12 + 1;
        goto L10
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener r10) {
        if (this.mListeners != null) goto L5;
        this.mListeners = new ArrayList();
    L5:
        this.mListeners.add(r10);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View r10) {
        this.mTargets.add(r10);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void animate(Animator r10) {
        if (r10 != null) goto L5;
        end();
        return;
    L5:
        if (getDuration() < 0) goto L8;
        r10.setDuration(getDuration());
    L8:
        if (getStartDelay() < 0) goto L11;
        r10.setStartDelay(getStartDelay() + r10.getStartDelay());
    L11:
        if (getInterpolator() == null) goto L13;
        r10.setInterpolator(getInterpolator());
    L13:
        r10.addListener(new c(this));
        r10.start();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        int r10 = this.mCurrentAnimators.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        this.mCurrentAnimators.get(r10).cancel();
        r10 = r10 - 1;
        goto L3
    L5:
        ArrayList<TransitionListener> r11 = this.mListeners;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.size() <= 0) goto L15;
        ArrayList r12 = (ArrayList) this.mListeners.clone();
        int r13 = r12.size();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L16;
        ((TransitionListener) r12.get(r14)).onTransitionCancel(this);
        r14 = r14 + 1;
        goto L10
    L16:
        return;
    }

    public abstract void captureEndValues(s r10);

    public void capturePropagationValues(s r10) {
        if (this.mPropagation != null) goto L5;
        return;
    L5:
        if (r10.f5085a.isEmpty() == true) goto L19;
        String[] r11 = this.mPropagation.b();
        if (r11 != null) goto L9;
        return;
    L9:
        int r12 = 0;
    L11:
        if (r12 >= r11.length) goto L21;
        if (r10.f5085a.containsKey(r11[r12]) == false) goto L14;
        r12 = r12 + 1;
        goto L11
    L14:
        this.mPropagation.a(r10);
        return;
    L21:
        return;
    }

    public abstract void captureStartValues(s r10);

    public void captureValues(ViewGroup r10, boolean r11) {
        clearValues(r11);
        int r12 = 0;
        if (this.mTargetIds.size() <= 0) goto L5;
    L6:
        ArrayList<String> r13 = this.mTargetNames;
        if (r13 != null) goto L9;
    L10:
        ArrayList<Class<?>> r14 = this.mTargetTypes;
        if (r14 != null) goto L13;
    L16:
        int r15 = 0;
    L18:
        if (r15 >= this.mTargetIds.size()) goto L30;
        View r16 = r10.findViewById(this.mTargetIds.get(r15).intValue());
        if (r16 == null) goto L29;
        s r17 = new s(r16);
        if (r11 == false) goto L24;
        captureStartValues(r17);
    L25:
        r17.f5087c.add(this);
        capturePropagationValues(r17);
        if (r11 == false) goto L28;
        b(this.mStartValues, r16, r17);
        goto L29
    L28:
        b(this.mEndValues, r16, r17);
        goto L29
    L24:
        captureEndValues(r17);
    L29:
        r15 = r15 + 1;
        goto L18
    L30:
        int r18 = 0;
    L32:
        if (r18 >= this.mTargets.size()) goto L42;
        View r19 = this.mTargets.get(r18);
        s r20 = new s(r19);
        if (r11 == false) goto L36;
        captureStartValues(r20);
    L37:
        r20.f5087c.add(this);
        capturePropagationValues(r20);
        if (r11 == false) goto L40;
        b(this.mStartValues, r19, r20);
    L41:
        r18 = r18 + 1;
        goto L32
    L40:
        b(this.mEndValues, r19, r20);
        goto L41
    L36:
        captureEndValues(r20);
    L42:
        if (r11 == true) goto L53;
        ArrayMap r21 = this.mNameOverrides;
        if (r21 == null) goto L65;
        int r22 = r21.size();
        ArrayList r23 = new ArrayList(r22);
        int r24 = 0;
    L46:
        if (r24 >= r22) goto L48;
        r23.add(this.mStartValues.f5091d.remove((String) this.mNameOverrides.keyAt(r24)));
        r24 = r24 + 1;
    L48:
        if (r12 >= r22) goto L66;
        View r25 = (View) r23.get(r12);
        if (r25 == null) goto L52;
        this.mStartValues.f5091d.put((String) this.mNameOverrides.valueAt(r12), r25);
    L52:
        r12 = r12 + 1;
        goto L48
    L66:
        return;
    L65:
        return;
    L53:
        return;
    L13:
        if (r14.isEmpty() == true) goto L16;
    L15:
        d(r10, r11);
        goto L42
    L9:
        if (r13.isEmpty() == false) goto L15;
    L5:
        if (this.mTargets.size() <= 0) goto L15;
        goto L6
    }

    public void clearValues(boolean r10) {
        if (r10 == false) goto L4;
        this.mStartValues.f5088a.clear();
        this.mStartValues.f5089b.clear();
        this.mStartValues.f5090c.a();
        return;
    L4:
        this.mEndValues.f5088a.clear();
        this.mEndValues.f5089b.clear();
        this.mEndValues.f5090c.a();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo3clone() throws CloneNotSupportedException {
        return clone();
    }

    public Animator createAnimator(ViewGroup r10, s r11, s r12) {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup r20, t r21, t r22, ArrayList<s> r23, ArrayList<s> r24) {
        ArrayMap r10 = i();
        SparseIntArray r11 = new SparseIntArray();
        int r12 = r23.size();
        long r13 = Long.MAX_VALUE;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L56;
        s r15 = r23.get(r14);
        s r16 = r24.get(r14);
        if (r15 != null) goto L7;
    L9:
        if (r16 != null) goto L11;
    L13:
        if (r15 != null) goto L16;
        if (r16 != null) goto L16;
    L15:
        int r17 = r12;
    L54:
        r14 = r14 + 1;
        r12 = r17;
    L16:
        if (r15 == null) goto L20;
        if (r16 == null) goto L20;
        if (isTransitionRequired(r15, r16) == false) goto L15;
    L20:
        Animator r18 = createAnimator(r20, r15, r16);
        if (r18 == null) goto L15;
        if (r16 == null) goto L48;
        View r19 = r16.f5086b;
        String[] r25 = getTransitionProperties();
        if (r25 != null) goto L26;
    L46:
        r17 = r12;
        Animator r26 = r18;
        s r110 = null;
    L47:
        Animator r111 = r26;
        s r27 = r110;
    L49:
        if (r111 == null) goto L54;
        q r28 = this.mPropagation;
        if (r28 == null) goto L53;
        long r29 = r28.c(r20, this, r15, r16);
        r11.put(this.mAnimators.size(), (int) r29);
        r13 = Math.min(r29, r13);
    L53:
        long r112 = r13;
        View r30 = r19;
        r10.put(r111, new d(r30, getName(), this, y.d(r20), r27));
        this.mAnimators.add(r111);
        r13 = r112;
        goto L54
    L26:
        if (r25.length <= 0) goto L46;
        r110 = new s(r19);
        r17 = r12;
        s r31 = (s) r22.f5088a.get(r19);
        if (r31 == null) goto L33;
        int r113 = 0;
    L31:
        if (r113 >= r25.length) goto L33;
        Map r114 = r110.f5085a;
        String r115 = r25[r113];
        String[] r116 = r25;
        r114.put(r115, r31.f5085a.get(r115));
        r113 = r113 + 1;
        r25 = r116;
    L33:
        int r32 = r10.size();
        int r33 = 0;
    L34:
        if (r33 >= r32) goto L45;
        d r117 = (d) r10.get((Animator) r10.keyAt(r33));
        if (r117.f5010c == null) goto L44;
        if (r117.f5008a != r19) goto L44;
        if (r117.f5009b.equals(getName()) == false) goto L44;
        if (r117.f5010c.equals(r110) == false) goto L44;
        r26 = null;
    L44:
        r33 = r33 + 1;
        goto L34
    L45:
        r26 = r18;
        goto L47
    L48:
        r17 = r12;
        r19 = r15.f5086b;
        r111 = r18;
        r27 = null;
        goto L49
    L11:
        if (r16.f5087c.contains(this) == true) goto L13;
        r16 = null;
        goto L13
    L7:
        if (r15.f5087c.contains(this) == true) goto L9;
        r15 = null;
        goto L9
    L56:
        if (r11.size() == 0) goto L61;
        int r118 = 0;
    L59:
        if (r118 >= r11.size()) goto L74;
        int r34 = r11.keyAt(r118);
        Animator r35 = this.mAnimators.get(r34);
        r35.setStartDelay((((long) r11.valueAt(r118)) - r13) + r35.getStartDelay());
        r118 = r118 + 1;
        goto L59
    L74:
        return;
    }

    public final void d(View r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = r10.getId();
        ArrayList<Integer> r13 = this.mTargetIdExcludes;
        if (r13 != null) goto L7;
    L9:
        ArrayList<View> r14 = this.mTargetExcludes;
        if (r14 != null) goto L12;
    L14:
        ArrayList<Class<?>> r15 = this.mTargetTypeExcludes;
        int r16 = 0;
        if (r15 == null) goto L23;
        int r17 = r15.size();
        int r18 = 0;
    L17:
        if (r18 >= r17) goto L23;
        if (this.mTargetTypeExcludes.get(r18).isInstance(r10) == true) goto L20;
        r18 = r18 + 1;
        goto L17
    L20:
        return;
    L23:
        if ((r10.getParent() instanceof ViewGroup) == false) goto L33;
        s r19 = new s(r10);
        if (r11 == false) goto L27;
        captureStartValues(r19);
    L28:
        r19.f5087c.add(this);
        capturePropagationValues(r19);
        if (r11 == false) goto L31;
        b(this.mStartValues, r10, r19);
        goto L33
    L31:
        b(this.mEndValues, r10, r19);
        goto L33
    L27:
        captureEndValues(r19);
    L33:
        if ((r10 instanceof ViewGroup) == false) goto L56;
        ArrayList<Integer> r20 = this.mTargetIdChildExcludes;
        if (r20 != null) goto L37;
    L39:
        ArrayList<View> r21 = this.mTargetChildExcludes;
        if (r21 != null) goto L42;
    L44:
        ArrayList<Class<?>> r22 = this.mTargetTypeChildExcludes;
        if (r22 == null) goto L52;
        int r23 = r22.size();
        int r24 = 0;
    L47:
        if (r24 >= r23) goto L52;
        if (this.mTargetTypeChildExcludes.get(r24).isInstance(r10) == true) goto L50;
        r24 = r24 + 1;
        goto L47
    L50:
        return;
    L52:
        ViewGroup r25 = (ViewGroup) r10;
    L54:
        if (r16 >= r25.getChildCount()) goto L62;
        d(r25.getChildAt(r16), r11);
        r16 = r16 + 1;
        goto L54
    L62:
        return;
    L42:
        if (r21.contains(r10) == false) goto L44;
        return;
    L37:
        if (r20.contains(Integer.valueOf(r12)) == false) goto L39;
        return;
    L56:
        return;
    L12:
        if (r14.contains(r10) == false) goto L14;
        return;
    L7:
        if (r13.contains(Integer.valueOf(r12)) == false) goto L9;
    }

    public final ArrayList e(ArrayList r10, int r11, boolean r12) {
        if (r11 <= 0) goto L7;
        if (r12 == false) goto L6;
        return e.a(r10, Integer.valueOf(r11));
    L6:
        return e.b(r10, Integer.valueOf(r11));
    L7:
        return r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void end() {
        int r10 = this.mNumInstances - 1;
        this.mNumInstances = r10;
        if (r10 != 0) goto L34;
        ArrayList<TransitionListener> r11 = this.mListeners;
        if (r11 != null) goto L7;
    L11:
        int r12 = 0;
    L13:
        if (r12 >= this.mStartValues.f5090c.m()) goto L18;
        View r13 = (View) this.mStartValues.f5090c.n(r12);
        if (r13 == null) goto L17;
        ViewCompat.z0(r13, false);
    L17:
        r12 = r12 + 1;
        goto L13
    L18:
        int r14 = 0;
    L20:
        if (r14 >= this.mEndValues.f5090c.m()) goto L25;
        View r15 = (View) this.mEndValues.f5090c.n(r14);
        if (r15 == null) goto L24;
        ViewCompat.z0(r15, false);
    L24:
        r14 = r14 + 1;
        goto L20
    L25:
        this.mEnded = true;
        return;
    L7:
        if (r11.size() <= 0) goto L11;
        ArrayList r16 = (ArrayList) this.mListeners.clone();
        int r17 = r16.size();
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L11;
        ((TransitionListener) r16.get(r18)).onTransitionEnd(this);
        r18 = r18 + 1;
        goto L9
    }

    @NonNull
    public Transition excludeChildren(@NonNull View r10, boolean r11) {
        this.mTargetChildExcludes = h(this.mTargetChildExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View r10, boolean r11) {
        this.mTargetExcludes = h(this.mTargetExcludes, r10, r11);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup r10) {
        ArrayMap r11 = i();
        int r12 = r11.size();
        if (r10 == null) goto L15;
        if (r12 == 0) goto L21;
        WindowIdImpl r13 = y.d(r10);
        ArrayMap r14 = new ArrayMap(r11);
        r11.clear();
        int r15 = r12 - 1;
    L7:
        if (r15 < 0) goto L22;
        d r16 = (d) r14.valueAt(r15);
        if (r16.f5008a == null) goto L14;
        if (r13 == null) goto L14;
        if (r13.equals(r16.f5011d) == false) goto L14;
        ((Animator) r14.keyAt(r15)).end();
    L14:
        r15 = r15 - 1;
        goto L7
    L22:
        return;
    L21:
        return;
    }

    public final ArrayList g(ArrayList r10, Class r11, boolean r12) {
        if (r11 == null) goto L7;
        if (r12 == false) goto L6;
        return e.a(r10, r11);
    L6:
        return e.b(r10, r11);
    L7:
        return r10;
    }

    public long getDuration() {
        return this.mDuration;
    }

    @Nullable
    public Rect getEpicenter() {
        f r10 = this.mEpicenterCallback;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.a(this);
    }

    @Nullable
    public f getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public s getMatchedTransitionValues(View r10, boolean r11) {
        TransitionSet r12 = this.mParent;
        if (r12 != null) goto L5;
        if (r11 == false) goto L8;
        ArrayList<s> r13 = this.mStartValuesList;
    L10:
        if (r13 != null) goto L12;
        return null;
    L12:
        int r14 = r13.size();
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L21;
        s r16 = r13.get(r15);
        if (r16 == null) goto L16;
        if (r16.f5086b == r10) goto L22;
        r15 = r15 + 1;
    L22:
        if (r15 < 0) goto L31;
        if (r11 == false) goto L25;
        ArrayList<s> r17 = this.mEndValuesList;
    L27:
        return r17.get(r15);
    L25:
        r17 = this.mStartValuesList;
        goto L27
    L31:
        return null;
    L16:
        return null;
    L21:
        r15 = -1;
        goto L22
    L8:
        r13 = this.mEndValuesList;
        goto L10
    L5:
        return r12.getMatchedTransitionValues(r10, r11);
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    @Nullable
    public q getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    @NonNull
    public List<View> getTargets() {
        return this.mTargets;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public s getTransitionValues(@NonNull View r10, boolean r11) {
        TransitionSet r12 = this.mParent;
        if (r12 != null) goto L5;
        if (r11 == false) goto L8;
        t r13 = this.mStartValues;
    L10:
        return (s) r13.f5088a.get(r10);
    L8:
        r13 = this.mEndValues;
        goto L10
    L5:
        return r12.getTransitionValues(r10, r11);
    }

    public final ArrayList h(ArrayList r10, View r11, boolean r12) {
        if (r11 == null) goto L7;
        if (r12 == false) goto L6;
        return e.a(r10, r11);
    L6:
        return e.b(r10, r11);
    L7:
        return r10;
    }

    public boolean isTransitionRequired(@Nullable s r10, @Nullable s r11) {
        if (r10 == null) goto L25;
        if (r11 == null) goto L26;
        String[] r12 = getTransitionProperties();
        if (r12 == null) goto L13;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L27;
        if (k(r10, r11, r12[r14]) == true) goto L19;
        r14 = r14 + 1;
    L19:
        return true;
    L27:
        return false;
    L13:
        Iterator r15 = r10.f5085a.keySet().iterator();
    L15:
        if (r15.hasNext() == false) goto L28;
        if (k(r10, r11, (String) r15.next()) == false) goto L15;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    public boolean isValidTarget(View r10) {
        int r11 = r10.getId();
        ArrayList<Integer> r12 = this.mTargetIdExcludes;
        if (r12 != null) goto L5;
    L7:
        ArrayList<View> r13 = this.mTargetExcludes;
        if (r13 != null) goto L10;
    L12:
        ArrayList<Class<?>> r14 = this.mTargetTypeExcludes;
        if (r14 == null) goto L21;
        int r15 = r14.size();
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L21;
        if (this.mTargetTypeExcludes.get(r16).isInstance(r10) == true) goto L18;
        r16 = r16 + 1;
        goto L15
    L18:
        return false;
    L21:
        if (this.mTargetNameExcludes == null) goto L28;
        if (ViewCompat.J(r10) == null) goto L28;
        if (this.mTargetNameExcludes.contains(ViewCompat.J(r10)) == false) goto L28;
        return false;
    L28:
        if (this.mTargetIds.size() != 0) goto L41;
        if (this.mTargets.size() != 0) goto L41;
        ArrayList<Class<?>> r17 = this.mTargetTypes;
        if (r17 != null) goto L34;
    L35:
        ArrayList<String> r18 = this.mTargetNames;
        if (r18 != null) goto L38;
    L39:
        return true;
    L38:
        if (r18.isEmpty() == false) goto L41;
    L34:
        if (r17.isEmpty() == true) goto L35;
    L41:
        if (this.mTargetIds.contains(Integer.valueOf(r11)) == false) goto L43;
    L60:
        return true;
    L43:
        if (this.mTargets.contains(r10) == true) goto L60;
        ArrayList<String> r19 = this.mTargetNames;
        if (r19 == null) goto L51;
        if (r19.contains(ViewCompat.J(r10)) == false) goto L51;
        return true;
    L51:
        if (this.mTargetTypes == null) goto L59;
        int r20 = 0;
    L54:
        if (r20 >= this.mTargetTypes.size()) goto L59;
        if (this.mTargetTypes.get(r20).isInstance(r10) == true) goto L57;
        r20 = r20 + 1;
        goto L54
    L57:
        return true;
    L59:
        return false;
    L10:
        if (r13.contains(r10) == false) goto L12;
        return false;
    L5:
        if (r12.contains(Integer.valueOf(r11)) == false) goto L7;
        return false;
    }

    public final void l(ArrayMap r10, ArrayMap r11, SparseArray r12, SparseArray r13) {
        int r14 = r12.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L17;
        View r16 = (View) r12.valueAt(r15);
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        View r17 = (View) r13.get(r12.keyAt(r15));
        if (r17 == null) goto L16;
        if (isValidTarget(r17) == false) goto L16;
        s r18 = (s) r10.get(r16);
        s r19 = (s) r11.get(r17);
        if (r18 == null) goto L16;
        if (r19 == null) goto L16;
        this.mStartValuesList.add(r18);
        this.mEndValuesList.add(r19);
        r10.remove(r16);
        r11.remove(r17);
    L16:
        r15 = r15 + 1;
        goto L3
    }

    public final void m(ArrayMap r10, ArrayMap r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L14;
        View r13 = (View) r10.keyAt(r12);
        if (r13 == null) goto L13;
        if (isValidTarget(r13) == false) goto L13;
        s r14 = (s) r11.remove(r13);
        if (r14 == null) goto L13;
        if (isValidTarget(r14.f5086b) == false) goto L13;
        this.mStartValuesList.add((s) r10.removeAt(r12));
        this.mEndValuesList.add(r14);
    L13:
        r12 = r12 - 1;
        goto L3
    }

    public final void n(ArrayMap r10, ArrayMap r11, androidx.collection.c r12, androidx.collection.c r13) {
        int r14 = r12.m();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L17;
        View r16 = (View) r12.n(r15);
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        View r17 = (View) r13.e(r12.i(r15));
        if (r17 == null) goto L16;
        if (isValidTarget(r17) == false) goto L16;
        s r18 = (s) r10.get(r16);
        s r19 = (s) r11.get(r17);
        if (r18 == null) goto L16;
        if (r19 == null) goto L16;
        this.mStartValuesList.add(r18);
        this.mEndValuesList.add(r19);
        r10.remove(r16);
        r11.remove(r17);
    L16:
        r15 = r15 + 1;
        goto L3
    }

    public final void o(ArrayMap r10, ArrayMap r11, ArrayMap r12, ArrayMap r13) {
        int r14 = r12.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L17;
        View r16 = (View) r12.valueAt(r15);
        if (r16 == null) goto L16;
        if (isValidTarget(r16) == false) goto L16;
        View r17 = (View) r13.get(r12.keyAt(r15));
        if (r17 == null) goto L16;
        if (isValidTarget(r17) == false) goto L16;
        s r18 = (s) r10.get(r16);
        s r19 = (s) r11.get(r17);
        if (r18 == null) goto L16;
        if (r19 == null) goto L16;
        this.mStartValuesList.add(r18);
        this.mEndValuesList.add(r19);
        r10.remove(r16);
        r11.remove(r17);
    L16:
        r15 = r15 + 1;
        goto L3
    }

    public final void p(t r10, t r11) {
        ArrayMap r12 = new ArrayMap(r10.f5088a);
        ArrayMap r13 = new ArrayMap(r11.f5088a);
        int r14 = 0;
    L3:
        int[] r15 = this.mMatchOrder;
        if (r14 >= r15.length) goto L19;
        int r16 = r15[r14];
        if (r16 != 1) goto L8;
        m(r12, r13);
    L18:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r16 != 2) goto L10;
        o(r12, r13, r10.f5091d, r11.f5091d);
        goto L18
    L10:
        if (r16 != 3) goto L12;
        l(r12, r13, r10.f5089b, r11.f5089b);
        goto L18
    L12:
        if (r16 != 4) goto L18;
        n(r12, r13, r10.f5090c, r11.f5090c);
        goto L18
    L19:
        a(r12, r13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View r10) {
        if (this.mEnded == true) goto L18;
        int r11 = this.mCurrentAnimators.size() - 1;
    L5:
        if (r11 < 0) goto L7;
        AnimatorUtils.b(this.mCurrentAnimators.get(r11));
        r11 = r11 - 1;
        goto L5
    L7:
        ArrayList<TransitionListener> r12 = this.mListeners;
        if (r12 != null) goto L10;
    L14:
        this.mPaused = true;
        return;
    L10:
        if (r12.size() <= 0) goto L14;
        ArrayList r13 = (ArrayList) this.mListeners.clone();
        int r14 = r13.size();
        int r15 = 0;
    L12:
        if (r15 >= r14) goto L14;
        ((TransitionListener) r13.get(r15)).onTransitionPause(this);
        r15 = r15 + 1;
        goto L12
    }

    public void playTransition(ViewGroup r11) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        p(this.mStartValues, this.mEndValues);
        ArrayMap r10 = i();
        int r12 = r10.size();
        WindowIdImpl r13 = y.d(r11);
        int r14 = r12 - 1;
    L3:
        if (r14 < 0) goto L28;
        Animator r15 = (Animator) r10.keyAt(r14);
        if (r15 == null) goto L27;
        d r16 = (d) r10.get(r15);
        if (r16 == null) goto L27;
        if (r16.f5008a == null) goto L27;
        if (r13.equals(r16.f5011d) == false) goto L27;
        s r17 = r16.f5010c;
        View r18 = r16.f5008a;
        s r19 = getTransitionValues(r18, true);
        s r20 = getMatchedTransitionValues(r18, true);
        if (r19 != null) goto L16;
        if (r20 != null) goto L16;
        r20 = (s) this.mEndValues.f5088a.get(r18);
    L16:
        if (r19 != null) goto L19;
        if (r20 == null) goto L27;
    L19:
        if (r16.f5012e.isTransitionRequired(r17, r20) == false) goto L27;
        if (r15.isRunning() == false) goto L23;
    L26:
        r15.cancel();
        goto L27
    L23:
        if (r15.isStarted() == true) goto L26;
        r10.remove(r15);
    L27:
        r14 = r14 - 1;
        goto L3
    L28:
        createAnimators(r11, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public final void r(Animator r10, ArrayMap r11) {
        if (r10 == null) goto L5;
        r10.addListener(new b(this, r11));
        animate(r10);
        return;
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener r10) {
        ArrayList<TransitionListener> r11 = this.mListeners;
        if (r11 != null) goto L5;
        return this;
    L5:
        r11.remove(r10);
        if (this.mListeners.size() != 0) goto L8;
        this.mListeners = null;
    L8:
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View r10) {
        this.mTargets.remove(r10);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View r10) {
        if (this.mPaused == true) goto L5;
        return;
    L5:
        if (this.mEnded == true) goto L16;
        int r11 = this.mCurrentAnimators.size() - 1;
    L7:
        if (r11 < 0) goto L9;
        AnimatorUtils.c(this.mCurrentAnimators.get(r11));
        r11 = r11 - 1;
        goto L7
    L9:
        ArrayList<TransitionListener> r12 = this.mListeners;
        if (r12 == null) goto L16;
        if (r12.size() <= 0) goto L16;
        ArrayList r13 = (ArrayList) this.mListeners.clone();
        int r14 = r13.size();
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L16;
        ((TransitionListener) r13.get(r15)).onTransitionResume(this);
        r15 = r15 + 1;
    L16:
        this.mPaused = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        start();
        ArrayMap r10 = i();
        Iterator<Animator> r11 = this.mAnimators.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Animator r12 = r11.next();
        if (r10.containsKey(r12) == false) goto L4;
        start();
        r(r12, r10);
        goto L4
    L8:
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean r10) {
        this.mCanRemoveViews = r10;
    }

    @NonNull
    public Transition setDuration(long r10) {
        this.mDuration = r10;
        return this;
    }

    public void setEpicenterCallback(@Nullable f r10) {
        this.mEpicenterCallback = r10;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator r10) {
        this.mInterpolator = r10;
        return this;
    }

    public void setMatchOrder(int... r10) {
        if (r10 != null) goto L4;
    L19:
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        return;
    L4:
        if (r10.length == 0) goto L19;
        int r11 = 0;
    L8:
        if (r11 >= r10.length) goto L18;
        if (j(r10[r11]) == false) goto L17;
        if (c(r10, r11) == true) goto L15;
        r11 = r11 + 1;
        goto L8
    L15:
        throw new IllegalArgumentException("matches contains a duplicate value");
    L17:
        throw new IllegalArgumentException("matches contains invalid value");
    L18:
        this.mMatchOrder = (int[]) r10.clone();
    }

    public void setPathMotion(@Nullable PathMotion r10) {
        if (r10 != null) goto L4;
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        return;
    L4:
        this.mPathMotion = r10;
    }

    public void setPropagation(@Nullable q r10) {
        this.mPropagation = r10;
    }

    @NonNull
    public Transition setStartDelay(long r10) {
        this.mStartDelay = r10;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void start() {
        if (this.mNumInstances != 0) goto L12;
        ArrayList<TransitionListener> r10 = this.mListeners;
        if (r10 != null) goto L7;
    L11:
        this.mEnded = false;
        goto L12
    L7:
        if (r10.size() <= 0) goto L11;
        ArrayList r11 = (ArrayList) this.mListeners.clone();
        int r12 = r11.size();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        ((TransitionListener) r11.get(r13)).onTransitionStart(this);
        r13 = r13 + 1;
    L12:
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    @NonNull
    public Transition addTarget(@IdRes int r10) {
        if (r10 == 0) goto L4;
        this.mTargetIds.add(Integer.valueOf(r10));
    L4:
        return this;
    }

    public Transition clone() {
        Transition r10 = (Transition) super.clone();     // Catch: CloneNotSupportedException -> L5
        r10.mAnimators = new ArrayList();     // Catch: CloneNotSupportedException -> L5
        r10.mStartValues = new t();     // Catch: CloneNotSupportedException -> L5
        r10.mEndValues = new t();     // Catch: CloneNotSupportedException -> L5
        r10.mStartValuesList = null;     // Catch: CloneNotSupportedException -> L5
        r10.mEndValuesList = null;     // Catch: CloneNotSupportedException -> L5
        return r10;
    L5:
        return null;
    }

    @NonNull
    public Transition excludeChildren(@IdRes int r10, boolean r11) {
        this.mTargetIdChildExcludes = e(this.mTargetIdChildExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int r10, boolean r11) {
        this.mTargetIdExcludes = e(this.mTargetIdExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int r10) {
        if (r10 == 0) goto L4;
        this.mTargetIds.remove(Integer.valueOf(r10));
    L4:
        return this;
    }

    public String toString(String r10) {
        String r11 = r10 + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration == (-1)) goto L6;
        r11 = r11 + "dur(" + this.mDuration + ") ";
    L6:
        if (this.mStartDelay == (-1)) goto L9;
        r11 = r11 + "dly(" + this.mStartDelay + ") ";
    L9:
        if (this.mInterpolator == null) goto L12;
        r11 = r11 + "interp(" + this.mInterpolator + ") ";
    L12:
        if (this.mTargetIds.size() <= 0) goto L14;
    L15:
        String r12 = r11 + "tgts(";
        int r13 = 0;
        if (this.mTargetIds.size() <= 0) goto L24;
        int r14 = 0;
    L19:
        if (r14 >= this.mTargetIds.size()) goto L24;
        if (r14 <= 0) goto L22;
        r12 = r12 + ", ";
    L22:
        r12 = r12 + this.mTargetIds.get(r14);
        r14 = r14 + 1;
    L24:
        if (this.mTargets.size() <= 0) goto L31;
    L26:
        if (r13 >= this.mTargets.size()) goto L31;
        if (r13 <= 0) goto L29;
        r12 = r12 + ", ";
    L29:
        r12 = r12 + this.mTargets.get(r13);
        r13 = r13 + 1;
    L31:
        return r12 + ")";
    L14:
        if (this.mTargets.size() > 0) goto L15;
        return r11;
    }

    @NonNull
    public Transition addTarget(@NonNull String r10) {
        if (this.mTargetNames != null) goto L5;
        this.mTargetNames = new ArrayList();
    L5:
        this.mTargetNames.add(r10);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> r10, boolean r11) {
        this.mTargetTypeChildExcludes = g(this.mTargetTypeChildExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String r10, boolean r11) {
        this.mTargetNameExcludes = f(this.mTargetNameExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String r10) {
        ArrayList<String> r11 = this.mTargetNames;
        if (r11 == null) goto L5;
        r11.remove(r10);
    L5:
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> r10, boolean r11) {
        this.mTargetTypeExcludes = g(this.mTargetTypeExcludes, r10, r11);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> r10) {
        ArrayList<Class<?>> r11 = this.mTargetTypes;
        if (r11 == null) goto L5;
        r11.remove(r10);
    L5:
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> r10) {
        if (this.mTargetTypes != null) goto L5;
        this.mTargetTypes = new ArrayList();
    L5:
        this.mTargetTypes.add(r10);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(@NonNull Context r10, @NonNull AttributeSet r11) {
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
        this.mStartValues = new t();
        this.mEndValues = new t();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f4996c);
        XmlResourceParser r13 = (XmlResourceParser) r11;
        long r14 = n.g.c(r12, r13, "duration", 1, -1);
        if (r14 < 0) goto L5;
        setDuration(r14);
    L5:
        long r15 = n.g.c(r12, r13, "startDelay", 2, -1);
        if (r15 <= 0) goto L8;
        setStartDelay(r15);
    L8:
        int r16 = n.g.d(r12, r13, "interpolator", 0, 0);
        if (r16 <= 0) goto L11;
        setInterpolator(AnimationUtils.loadInterpolator(r10, r16));
    L11:
        String r17 = n.g.e(r12, r13, "matchOrder", 3);
        if (r17 == null) goto L14;
        setMatchOrder(q(r17));
    L14:
        r12.recycle();
    }
}
