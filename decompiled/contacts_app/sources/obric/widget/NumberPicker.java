package obric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import obric.InvokeApi;

/* JADX INFO: loaded from: classes5.dex */
public class NumberPicker extends LinearLayout {
    private static final boolean DBG = false;
    private static final int DEFAULT_TEXT_SIZE = 45;
    private static final int DEFAUlT_TEXT_COLOR = 0;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 2;
    private static final int SELECTOR_WHEEL_ITEM_COUNT = 5;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 300;
    private static final String TAG = "BytedanceNumberPicker";
    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.0f;
    private static final String UNSET_STRING = "--";
    public static final int UNSET_YEAR = 4;
    private static final float VOLUME = 0.0945f;
    private static SoundPool sPool;
    private static int sSoundId;
    private static final TwoDigitFormatter sTwoDigitFormatter = null;
    private AccessibilityNodeProviderImpl mAccessibilityNodeProvider;
    private final Scroller mAdjustScroller;
    private int mBottomSelectionDividerBottom;
    private final boolean mComputeMaxWidth;
    private int mCurrentScrollOffset;
    private String[] mDisplayedValues;
    private final Scroller mFlingScroller;
    private Formatter mFormatter;
    private final boolean mHasSelectorWheel;
    private boolean mHasUnsetValue;
    private int mHighlightColor;
    private int mHighlightSize;
    private boolean mIngonreMoveEvents;
    private int mInitialScrollOffset;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private int mLastHoveredChildVirtualViewId;
    private final int mMaxHeight;
    private int mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private int mMiddleScrollOffset;
    private final int mMinHeight;
    private int mMinValue;
    private final int mMinWidth;
    private int mMinimumFlingVelocity;
    private int mNormalColor;
    private int mNormalSize;
    private int mOldTime;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private int mPreviousScrollerY;
    private int mScrollState;
    private int mSelectorElementHeight;
    private final SparseArray<String> mSelectorIndexToStringCache;
    private final int[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private final Paint mSelectorWheelPaint;
    private boolean mShowSoftInputOnTap;
    private boolean mSoundEnable;
    private Runnable mSoundRunnable;
    private int mTopSelectionDividerTop;
    private int mTouchSlop;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private Vibrator mVibrator;
    private boolean mWrapSelectorWheel;
    private Context mcContext;

    private class AccessibilityNodeProviderImpl extends AccessibilityNodeProvider {
        private static final int UNDEFINED = Integer.MIN_VALUE;
        private static final int VIRTUAL_VIEW_ID_CURRENT_VALUE = 3;
        private static final int VIRTUAL_VIEW_ID_DECREMENT = 2;
        private static final int VIRTUAL_VIEW_ID_DECREMENT_SECOND = 1;
        private static final int VIRTUAL_VIEW_ID_INCREMENT = 4;
        private static final int VIRTUAL_VIEW_ID_INCREMENT_SECOND = 5;
        private int mAccessibilityFocusedView;
        private final int[] mTempArray;
        private final Rect mTempRect;
        final /* synthetic */ NumberPicker this$0;

        private AccessibilityNodeProviderImpl(final NumberPicker this$0) {
            this.this$0 = this$0;
            this.mTempRect = new Rect();
            this.mTempArray = new int[2];
            this.mAccessibilityFocusedView = Integer.MIN_VALUE;
        }

        /* synthetic */ AccessibilityNodeProviderImpl(NumberPicker r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$400(AccessibilityNodeProviderImpl r0, int r1, int r2) {
            r0.sendAccessibilityEventForVirtualView(r1, r2);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            if (virtualViewId == (-1)) goto L27;
            if (virtualViewId == 1) goto L25;
            if (virtualViewId == 2) goto L23;
            if (virtualViewId == 3) goto L21;
            if (virtualViewId == 4) goto L19;
            if (virtualViewId == 5) goto L17;
            return super.createAccessibilityNodeInfo(virtualViewId);
        L17:
            return createAccessibilityNodeInfoForVirtualButton(5, getSecondVirtualIncrementButtonText(), this.this$0.getScrollX(), NumberPicker.access$700(this.this$0) + NumberPicker.access$600(this.this$0), this.this$0.getScrollX() + (this.this$0.getRight() - this.this$0.getLeft()), this.this$0.getScrollY() + (this.this$0.getBottom() - this.this$0.getTop()));
        L19:
            return createAccessibilityNodeInfoForVirtualButton(4, getVirtualIncrementButtonText(), this.this$0.getScrollX(), NumberPicker.access$700(this.this$0), this.this$0.getScrollX() + (this.this$0.getRight() - this.this$0.getLeft()), (this.this$0.getScrollY() + (this.this$0.getBottom() - this.this$0.getTop())) - NumberPicker.access$600(this.this$0));
        L21:
            return createAccessibilityNodeInfoForVirtualButton(3, getCurrentValueVirtualButtonText(), this.this$0.getScrollX(), NumberPicker.access$500(this.this$0), this.this$0.getScrollX() + (this.this$0.getRight() - this.this$0.getLeft()), NumberPicker.access$700(this.this$0));
        L23:
            return createAccessibilityNodeInfoForVirtualButton(2, getVirtualDecrementButtonText(), this.this$0.getScrollX(), this.this$0.getScrollY() + NumberPicker.access$600(this.this$0), this.this$0.getScrollX() + (this.this$0.getRight() - this.this$0.getLeft()), NumberPicker.access$500(this.this$0));
        L25:
            return createAccessibilityNodeInfoForVirtualButton(1, getSecondVirtualDecrementButtonText(), this.this$0.getScrollX(), this.this$0.getScrollY(), this.this$0.getScrollX() + (this.this$0.getRight() - this.this$0.getLeft()), NumberPicker.access$500(this.this$0) - NumberPicker.access$600(this.this$0));
        L27:
            return createAccessibilityNodeInfoForNumberPicker(this.this$0.getScrollX(), this.this$0.getScrollY(), this.this$0.getScrollX() + (this.this$0.getRight() - this.this$0.getLeft()), this.this$0.getScrollY() + (this.this$0.getBottom() - this.this$0.getTop()));
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String searched, int virtualViewId) {
            if (TextUtils.isEmpty(searched) == true) goto L5;
            String r0 = searched.toLowerCase();
            ArrayList r1 = new ArrayList();
            if (virtualViewId == (-1)) goto L17;
            if (virtualViewId == 1) goto L15;
            if (virtualViewId == 2) goto L15;
            if (virtualViewId == 3) goto L15;
            if (virtualViewId == 4) goto L15;
            if (virtualViewId == 5) goto L15;
            return super.findAccessibilityNodeInfosByText(searched, virtualViewId);
        L15:
            findAccessibilityNodeInfosByTextInChild(r0, virtualViewId, r1);
            return r1;
        L17:
            findAccessibilityNodeInfosByTextInChild(r0, 1, r1);
            findAccessibilityNodeInfosByTextInChild(r0, 2, r1);
            findAccessibilityNodeInfosByTextInChild(r0, 3, r1);
            findAccessibilityNodeInfosByTextInChild(r0, 4, r1);
            findAccessibilityNodeInfosByTextInChild(r0, 5, r1);
            return r1;
        L5:
            return Collections.emptyList();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            if (virtualViewId != (-1)) goto L5;
            if (action == 64) goto L104;
            if (action == 128) goto L99;
            if (action == 4096) goto L90;
            if (action == 8192) goto L81;
        L79:
            return super.performAction(virtualViewId, action, arguments);
        L81:
            if (this.this$0.isEnabled() == true) goto L83;
        L88:
            return false;
        L83:
            if (this.this$0.getWrapSelectorWheel() == false) goto L85;
        L86:
            NumberPicker.access$800(this.this$0, false);
            return true;
        L85:
            if (this.this$0.getValue() <= this.this$0.getMinValue()) goto L88;
        L90:
            if (this.this$0.isEnabled() == true) goto L92;
        L97:
            return false;
        L92:
            if (this.this$0.getWrapSelectorWheel() == false) goto L94;
        L95:
            NumberPicker.access$800(this.this$0, true);
            return true;
        L94:
            if (this.this$0.getValue() >= this.this$0.getMaxValue()) goto L97;
        L99:
            if (this.mAccessibilityFocusedView != virtualViewId) goto L102;
            this.mAccessibilityFocusedView = Integer.MIN_VALUE;
            InvokeApi.xView.clearAccessibilityFocus(this.this$0);
            return true;
        L102:
            return false;
        L104:
            if (this.mAccessibilityFocusedView == virtualViewId) goto L107;
            this.mAccessibilityFocusedView = virtualViewId;
            InvokeApi.xView.requestAccessibilityFocus(this.this$0);
            return true;
        L107:
            return false;
        L5:
            if (virtualViewId != 1) goto L7;
        L53:
            if (action == 16) goto L68;
            if (action == 64) goto L63;
            if (action == 128) goto L58;
            return false;
        L58:
            if (this.mAccessibilityFocusedView != virtualViewId) goto L61;
            this.mAccessibilityFocusedView = Integer.MIN_VALUE;
            sendAccessibilityEventForVirtualView(virtualViewId, 65536);
            NumberPicker r10 = this.this$0;
            r10.invalidate(0, 0, r10.getRight(), NumberPicker.access$500(this.this$0));
            return true;
        L61:
            return false;
        L63:
            if (this.mAccessibilityFocusedView == virtualViewId) goto L66;
            this.mAccessibilityFocusedView = virtualViewId;
            sendAccessibilityEventForVirtualView(virtualViewId, 32768);
            NumberPicker r11 = this.this$0;
            r11.invalidate(0, 0, r11.getRight(), NumberPicker.access$500(this.this$0));
            return true;
        L66:
            return false;
        L68:
            if (this.this$0.isEnabled() == false) goto L71;
            NumberPicker.access$800(this.this$0, false);
            sendAccessibilityEventForVirtualView(virtualViewId, 1);
            return true;
        L71:
            return false;
        L7:
            if (virtualViewId == 2) goto L53;
            if (virtualViewId != 3) goto L11;
            if (action == 16) goto L49;
            if (action == 64) goto L44;
            if (action == 128) goto L39;
            return false;
        L39:
            if (this.mAccessibilityFocusedView != virtualViewId) goto L42;
            this.mAccessibilityFocusedView = Integer.MIN_VALUE;
            sendAccessibilityEventForVirtualView(virtualViewId, 65536);
            NumberPicker r12 = this.this$0;
            r12.invalidate(0, NumberPicker.access$500(r12), this.this$0.getRight(), NumberPicker.access$700(this.this$0));
            return true;
        L42:
            return false;
        L44:
            if (this.mAccessibilityFocusedView == virtualViewId) goto L47;
            this.mAccessibilityFocusedView = virtualViewId;
            sendAccessibilityEventForVirtualView(virtualViewId, 32768);
            NumberPicker r13 = this.this$0;
            r13.invalidate(0, NumberPicker.access$500(r13), this.this$0.getRight(), NumberPicker.access$700(this.this$0));
            return true;
        L47:
            return false;
        L49:
            if (this.this$0.isEnabled() == false) goto L52;
            sendAccessibilityEventForVirtualView(virtualViewId, 1);
            return true;
        L52:
            return false;
        L11:
            if (virtualViewId != 4) goto L13;
        L15:
            if (action == 16) goto L30;
            if (action == 64) goto L25;
            if (action == 128) goto L20;
            return false;
        L20:
            if (this.mAccessibilityFocusedView != virtualViewId) goto L23;
            this.mAccessibilityFocusedView = Integer.MIN_VALUE;
            sendAccessibilityEventForVirtualView(virtualViewId, 65536);
            NumberPicker r14 = this.this$0;
            r14.invalidate(0, NumberPicker.access$700(r14), this.this$0.getRight(), this.this$0.getBottom());
            return true;
        L23:
            return false;
        L25:
            if (this.mAccessibilityFocusedView == virtualViewId) goto L28;
            this.mAccessibilityFocusedView = virtualViewId;
            sendAccessibilityEventForVirtualView(virtualViewId, 32768);
            NumberPicker r15 = this.this$0;
            r15.invalidate(0, NumberPicker.access$700(r15), this.this$0.getRight(), this.this$0.getBottom());
            return true;
        L28:
            return false;
        L30:
            if (this.this$0.isEnabled() == false) goto L33;
            NumberPicker.access$800(this.this$0, true);
            sendAccessibilityEventForVirtualView(virtualViewId, 1);
            return true;
        L33:
            return false;
        L13:
            if (virtualViewId == 5) goto L15;
            goto L15
        }

        private void sendAccessibilityEventForVirtualView(int virtualViewId, int eventType) {
            if (virtualViewId == 1) goto L24;
            if (virtualViewId == 2) goto L21;
            if (virtualViewId != 3) goto L9;
            sendAccessibilityEventForVirtualButton(virtualViewId, eventType, getCurrentValueVirtualButtonText());
            return;
        L9:
            if (virtualViewId == 4) goto L17;
            if (virtualViewId == 5) goto L14;
            return;
        L14:
            if (hasSecondVirtualIncrementButton() == false) goto L27;
            sendAccessibilityEventForVirtualButton(virtualViewId, eventType, getSecondVirtualIncrementButtonText());
            return;
        L27:
            return;
        L17:
            if (hasVirtualIncrementButton() == false) goto L29;
            sendAccessibilityEventForVirtualButton(virtualViewId, eventType, getVirtualIncrementButtonText());
            return;
        L29:
            return;
        L21:
            if (hasVirtualDecrementButton() == false) goto L32;
            sendAccessibilityEventForVirtualButton(virtualViewId, eventType, getVirtualDecrementButtonText());
            return;
        L32:
            return;
        L24:
            if (hasSecondVirtualDecrementButton() == false) goto L34;
            sendAccessibilityEventForVirtualButton(virtualViewId, eventType, getSecondVirtualDecrementButtonText());
            return;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void sendAccessibilityEventForVirtualButton(int virtualViewId, int eventType, String text) {
            if (InvokeApi.xAccessibilityManager.getInstance(this.this$0.getContext()).isEnabled() == false) goto L6;
            AccessibilityEvent r3 = AccessibilityEvent.obtain(eventType);
            r3.setClassName(android.widget.Button.class.getName());
            r3.setPackageName(this.this$0.getContext().getPackageName());
            r3.getText().add(text);
            r3.setEnabled(this.this$0.isEnabled());
            r3.setSource(this.this$0, virtualViewId);
            NumberPicker r1 = this.this$0;
            r1.requestSendAccessibilityEvent(r1, r3);
            return;
        }

        private void findAccessibilityNodeInfosByTextInChild(String searchedLowerCase, int virtualViewId, List<AccessibilityNodeInfo> outResult) {
            if (virtualViewId != 1) goto L5;
            String r0 = getSecondVirtualDecrementButtonText();
        L19:
            if (TextUtils.isEmpty(r0) == false) goto L21;
            return;
        L21:
            if (r0.toLowerCase().contains(searchedLowerCase) == false) goto L25;
            outResult.add(createAccessibilityNodeInfo(virtualViewId));
            return;
        L25:
            return;
        L5:
            if (virtualViewId != 2) goto L7;
            r0 = getVirtualDecrementButtonText();
            goto L19
        L7:
            if (virtualViewId != 3) goto L9;
            r0 = getCurrentValueVirtualButtonText();
            goto L19
        L9:
            if (virtualViewId != 4) goto L11;
            r0 = getVirtualIncrementButtonText();
            goto L19
        L11:
            if (virtualViewId == 5) goto L13;
            return;
        L13:
            r0 = getSecondVirtualIncrementButtonText();
            goto L19
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForVirtualButton(int virtualViewId, String text, int left, int top, int right, int bottom) {
            if (virtualViewId == 3) goto L5;
            boolean r0 = true;
        L6:
            AccessibilityNodeInfo r3 = AccessibilityNodeInfo.obtain();
            if (r0 == false) goto L9;
            Class r4 = android.widget.Button.class;
        L10:
            r3.setClassName(r4.getName());
            r3.setPackageName(this.this$0.getContext().getPackageName());
            r3.setSource(this.this$0, virtualViewId);
            r3.setParent(this.this$0);
            r3.setText(text);
            r3.setClickable(r0);
            r3.setLongClickable(r0);
            r3.setEnabled(this.this$0.isEnabled());
            Rect r7 = this.mTempRect;
            r7.set(left, top, right, bottom);
            r3.setVisibleToUser(InvokeApi.xView.isVisibleToUser(this.this$0, r7));
            r3.setBoundsInParent(r7);
            int[] r8 = this.mTempArray;
            this.this$0.getLocationOnScreen(r8);
            r7.offset(r8[0], r8[1]);
            r3.setBoundsInScreen(r7);
            if (this.mAccessibilityFocusedView == virtualViewId) goto L14;
            r3.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_ACCESSIBILITY_FOCUS);
        L14:
            if (this.mAccessibilityFocusedView != virtualViewId) goto L17;
            r3.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        L17:
            if (this.this$0.isEnabled() == false) goto L19;
            r3.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
        L19:
            return r3;
        L9:
            r4 = TextView.class;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForNumberPicker(int left, int top, int right, int bottom) {
            AccessibilityNodeInfo r0 = AccessibilityNodeInfo.obtain();
            r0.setClassName(NumberPicker.class.getName());
            r0.setPackageName(this.this$0.getContext().getPackageName());
            r0.setSource(this.this$0);
            if (hasSecondVirtualDecrementButton() == false) goto L6;
            r0.addChild(this.this$0, 1);
        L6:
            if (hasVirtualDecrementButton() == false) goto L8;
            r0.addChild(this.this$0, 2);
        L8:
            r0.addChild(this.this$0, 3);
            if (hasVirtualIncrementButton() == false) goto L12;
            r0.addChild(this.this$0, 4);
        L12:
            if (hasSecondVirtualIncrementButton() == false) goto L14;
            r0.addChild(this.this$0, 5);
        L14:
            r0.setParent((View) this.this$0.getParentForAccessibility());
            r0.setEnabled(this.this$0.isEnabled());
            r0.setScrollable(true);
            float r1 = InvokeApi.xCompatibilityInfo.getApplicationScale(this.this$0.getContext());
            Rect r3 = this.mTempRect;
            r3.set(left, top, right, bottom);
            InvokeApi.xRect.scale(r3, r1);
            r0.setBoundsInParent(r3);
            r0.setVisibleToUser(InvokeApi.xView.isVisibleToUser(this.this$0));
            int[] r5 = this.mTempArray;
            this.this$0.getLocationOnScreen(r5);
            r3.offset(r5[0], r5[1]);
            InvokeApi.xRect.scale(r3, r1);
            r0.setBoundsInScreen(r3);
            if (this.mAccessibilityFocusedView == (-1)) goto L18;
            r0.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_ACCESSIBILITY_FOCUS);
        L18:
            if (this.mAccessibilityFocusedView != (-1)) goto L21;
            r0.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        L21:
            if (this.this$0.isEnabled() == true) goto L23;
        L32:
            return r0;
        L23:
            if (this.this$0.getWrapSelectorWheel() == false) goto L25;
        L26:
            r0.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        L28:
            if (this.this$0.getWrapSelectorWheel() == false) goto L30;
        L31:
            r0.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            goto L32
        L30:
            if (this.this$0.getValue() <= this.this$0.getMinValue()) goto L32;
        L25:
            if (this.this$0.getValue() >= this.this$0.getMaxValue()) goto L28;
            goto L26
        }

        private boolean hasVirtualDecrementButton() {
            if (this.this$0.getWrapSelectorWheel() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.this$0.getValue() > this.this$0.getMinValue()) goto L8;
            return false;
        }

        private boolean hasVirtualIncrementButton() {
            if (this.this$0.getWrapSelectorWheel() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.this$0.getValue() < this.this$0.getMaxValue()) goto L8;
            return false;
        }

        private boolean hasSecondVirtualIncrementButton() {
            if (this.this$0.getWrapSelectorWheel() == false) goto L5;
            return true;
        L5:
            if ((this.this$0.getValue() + 1) < this.this$0.getMaxValue()) goto L10;
            return false;
        L10:
            return true;
        }

        private boolean hasSecondVirtualDecrementButton() {
            if (this.this$0.getWrapSelectorWheel() == false) goto L5;
            return true;
        L5:
            if ((this.this$0.getValue() - 1) > this.this$0.getMinValue()) goto L10;
            return false;
        L10:
            return true;
        }

        private String getVirtualDecrementButtonText() {
            return getVirtualButtonTextAt(NumberPicker.access$900(this.this$0) - 1);
        }

        private String getVirtualIncrementButtonText() {
            return getVirtualButtonTextAt(NumberPicker.access$900(this.this$0) + 1);
        }

        private String getSecondVirtualDecrementButtonText() {
            return getVirtualButtonTextAt(NumberPicker.access$900(this.this$0) - 2);
        }

        private String getSecondVirtualIncrementButtonText() {
            return getVirtualButtonTextAt(NumberPicker.access$900(this.this$0) + 2);
        }

        private String getCurrentValueVirtualButtonText() {
            return getVirtualButtonTextAt(NumberPicker.access$900(this.this$0));
        }

        private String getVirtualButtonTextAt(int value) {
            if (NumberPicker.access$1000(this.this$0) == false) goto L6;
            value = NumberPicker.access$1100(this.this$0, value);
        L6:
            if (value <= NumberPicker.access$1200(this.this$0)) goto L8;
            return null;
        L8:
            if (value >= NumberPicker.access$1300(this.this$0)) goto L10;
            return null;
        L10:
            if (NumberPicker.access$1400(this.this$0) != null) goto L13;
            return NumberPicker.access$1500(this.this$0, value);
        L13:
            return NumberPicker.access$1400(this.this$0)[value - NumberPicker.access$1300(this.this$0)];
        }
    }

    public interface Formatter {
        String format(int value);
    }

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(NumberPicker view, int scrollState);
    }

    public interface OnValueChangeListener {
        void onValueChange(NumberPicker picker, int oldVal, int newVal);
    }

    private static class TwoDigitFormatter implements Formatter {
        final Object[] mArgs;
        final StringBuilder mBuilder;
        java.util.Formatter mFmt;
        char mZeroDigit;

        private static char getZeroDigit(Locale locale) {
            return '0';
        }

        TwoDigitFormatter() {
            this.mBuilder = new StringBuilder();
            this.mArgs = new Object[1];
            init(Locale.getDefault());
        }

        private void init(Locale locale) {
            this.mFmt = createFormatter(locale);
            this.mZeroDigit = getZeroDigit(locale);
        }

        @Override // obric.widget.NumberPicker.Formatter
        public String format(int value) {
            Locale r0 = Locale.getDefault();
            if (this.mZeroDigit == getZeroDigit(r0)) goto L5;
            init(r0);
        L5:
            this.mArgs[0] = Integer.valueOf(value);
            StringBuilder r4 = this.mBuilder;
            r4.delete(0, r4.length());
            this.mFmt.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, this.mArgs);
            return this.mFmt.toString();
        }

        private java.util.Formatter createFormatter(Locale locale) {
            return new java.util.Formatter(this.mBuilder, locale);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    static /* synthetic */ SoundPool access$000() {
        return sPool;
    }

    static /* synthetic */ boolean access$100(NumberPicker r0) {
        return r0.mSoundEnable;
    }

    static /* synthetic */ boolean access$1000(NumberPicker r0) {
        return r0.mWrapSelectorWheel;
    }

    static /* synthetic */ int access$1100(NumberPicker r0, int r1) {
        return r0.getWrappedSelectorIndex(r1);
    }

    static /* synthetic */ int access$1200(NumberPicker r0) {
        return r0.mMaxValue;
    }

    static /* synthetic */ int access$1300(NumberPicker r0) {
        return r0.mMinValue;
    }

    static /* synthetic */ String[] access$1400(NumberPicker r0) {
        return r0.mDisplayedValues;
    }

    static /* synthetic */ String access$1500(NumberPicker r0, int r1) {
        return r0.formatNumber(r1);
    }

    static /* synthetic */ int access$200() {
        return sSoundId;
    }

    static /* synthetic */ int access$500(NumberPicker r0) {
        return r0.mTopSelectionDividerTop;
    }

    static /* synthetic */ int access$600(NumberPicker r0) {
        return r0.mSelectorElementHeight;
    }

    static /* synthetic */ int access$700(NumberPicker r0) {
        return r0.mBottomSelectionDividerBottom;
    }

    static /* synthetic */ void access$800(NumberPicker r0, boolean r1) {
        r0.changeValueByOne(r1);
    }

    static /* synthetic */ int access$900(NumberPicker r0) {
        return r0.mValue;
    }

    static {
        DEFAUlT_TEXT_COLOR = Color.parseColor("#545454");
        sTwoDigitFormatter = new TwoDigitFormatter();
    }

    public static final Formatter getTwoDigitFormatter() {
        return sTwoDigitFormatter;
    }

    public void setSoundEnable(boolean enabled) {
        this.mSoundEnable = enabled;
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mSelectorIndexToStringCache = new SparseArray();
        this.mSelectorIndices = new int[5];
        this.mNormalSize = 45;
        this.mHighlightSize = 45;
        int r4 = DEFAUlT_TEXT_COLOR;
        this.mNormalColor = r4;
        this.mHighlightColor = r4;
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mScrollState = 0;
        this.mHasUnsetValue = false;
        this.mSoundEnable = true;
        this.mOldTime = -1;
        this.mSoundRunnable = new AnonymousClass1(this);
        this.mcContext = context;
        this.mHasSelectorWheel = true;
        this.mMinHeight = -1;
        this.mMaxHeight = -1;
        this.mMinWidth = -1;
        this.mMaxWidth = -1;
        this.mComputeMaxWidth = true;
        setWillNotDraw(!true);
        ViewConfiguration r3 = ViewConfiguration.get(context.getApplicationContext());
        this.mTouchSlop = r3.getScaledTouchSlop();
        this.mMinimumFlingVelocity = r3.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = r3.getScaledMaximumFlingVelocity() / 8;
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        r5.setTextAlign(Paint.Align.CENTER);
        r5.setTextSize(this.mNormalSize);
        r5.setColor(this.mNormalColor);
        this.mSelectorWheelPaint = r5;
        this.mFlingScroller = new Scroller(getContext(), null, true);
        this.mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        if (getImportantForAccessibility() != 0) goto L5;
        setImportantForAccessibility(1);
    L5:
        this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onLayout(changed, left, top, right, bottom);
        return;
    L6:
        if (changed == false) goto L9;
        initializeSelectorWheel();
        initializeFadingEdges();
        int r2 = getHeight();
        int r3 = this.mSelectorElementHeight;
        int r4 = (r2 - r3) / 2;
        this.mTopSelectionDividerTop = r4;
        this.mBottomSelectionDividerBottom = r4 + r3;
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        return;
    L6:
        super.onMeasure(makeMeasureSpec(widthMeasureSpec, this.mMaxWidth), makeMeasureSpec(heightMeasureSpec, this.mMaxHeight));
        setMeasuredDimension(resolveSizeAndStateRespectingMinSize(this.mMinWidth, getMeasuredWidth(), widthMeasureSpec), resolveSizeAndStateRespectingMinSize(this.mMinHeight, getMeasuredHeight(), heightMeasureSpec));
    }

    private boolean moveToFinalScrollerPosition(Scroller scroller) {
        scroller.forceFinished(true);
        int r1 = scroller.getFinalY() - scroller.getCurrY();
        int r7 = (this.mCurrentScrollOffset + r1) % this.mSelectorElementHeight;
        int r2 = this.mInitialScrollOffset - r7;
        if (r2 == 0) goto L16;
        int r3 = Math.abs(r2);
        int r4 = this.mSelectorElementHeight;
        if (r3 <= (r4 / 2)) goto L9;
        if (r2 <= 0) goto L8;
        r2 = r2 - r4;
        goto L9
    L8:
        r2 = r2 + r4;
    L9:
        int r5 = r1 + r2;
        int r6 = r4 * 5;
        if (Math.abs(r5) <= r6) goto L14;
        if (r5 <= 0) goto L13;
        r5 = r6;
        goto L14
    L13:
        r5 = -r6;
    L14:
        scrollBy(0, r5);
        return true;
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.mHasSelectorWheel == true) goto L5;
    L24:
        return false;
    L5:
        if (isEnabled() == false) goto L24;
        if (event.getActionMasked() == 0) goto L10;
        return false;
    L10:
        float r0 = event.getY();
        this.mLastDownEventY = r0;
        this.mLastDownOrMoveEventY = r0;
        this.mLastDownEventTime = event.getEventTime();
        this.mIngonreMoveEvents = false;
        this.mShowSoftInputOnTap = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.mFlingScroller.isFinished() == true) goto L14;
        this.mFlingScroller.forceFinished(true);
        this.mAdjustScroller.forceFinished(true);
        onScrollStateChange(0);
    L23:
        return true;
    L14:
        if (this.mAdjustScroller.isFinished() == true) goto L16;
        this.mFlingScroller.forceFinished(true);
        this.mAdjustScroller.forceFinished(true);
        goto L23
    L16:
        float r5 = this.mLastDownEventY;
        if (r5 < this.mTopSelectionDividerTop) goto L23;
        if (r5 > this.mBottomSelectionDividerBottom) goto L23;
        this.mShowSoftInputOnTap = true;
        goto L23
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled() == true) goto L5;
    L43:
        return false;
    L5:
        if (this.mHasSelectorWheel == false) goto L43;
        if (this.mVelocityTracker != null) goto L10;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        this.mVelocityTracker.addMovement(event);
        int r0 = event.getActionMasked();
        if (r0 == 1) goto L24;
        if (r0 == 2) goto L15;
    L42:
        return true;
    L15:
        if (this.mIngonreMoveEvents == true) goto L42;
        float r10 = event.getY();
        if (this.mScrollState != 1) goto L20;
        scrollBy(0, (int) (r10 - this.mLastDownOrMoveEventY));
        invalidate();
    L23:
        this.mLastDownOrMoveEventY = r10;
        goto L42
    L20:
        if (((int) Math.abs(r10 - this.mLastDownEventY)) <= this.mTouchSlop) goto L23;
        onScrollStateChange(1);
        goto L23
    L24:
        VelocityTracker r1 = this.mVelocityTracker;
        r1.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        int r2 = (int) r1.getYVelocity();
        if (Math.abs(r2) <= this.mMinimumFlingVelocity) goto L27;
        fling(r2);
        onScrollStateChange(2);
    L41:
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        goto L42
    L27:
        int r3 = (int) event.getY();
        int r4 = (int) Math.abs(r3 - this.mLastDownEventY);
        long r5 = event.getEventTime() - this.mLastDownEventTime;
        if (r4 <= this.mTouchSlop) goto L30;
    L39:
        ensureScrollWheelAdjusted();
    L40:
        onScrollStateChange(0);
        goto L41
    L30:
        if (r5 >= ViewConfiguration.getTapTimeout()) goto L39;
        if (this.mShowSoftInputOnTap == false) goto L34;
        this.mShowSoftInputOnTap = false;
        goto L40
    L34:
        int r6 = (r3 / this.mSelectorElementHeight) - 2;
        if (r6 <= 0) goto L37;
        changeValueByOne(true);
        goto L40
    L37:
        if (r6 >= 0) goto L40;
        changeValueByOne(false);
        goto L40
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller r0 = this.mFlingScroller;
        if (r0.isFinished() == false) goto L7;
        r0 = this.mAdjustScroller;
        if (r0.isFinished() == false) goto L7;
        return;
    L7:
        r0.computeScrollOffset();
        int r1 = r0.getCurrY();
        if (this.mPreviousScrollerY != 0) goto L10;
        this.mPreviousScrollerY = r0.getStartY();
    L10:
        scrollBy(0, r1 - this.mPreviousScrollerY);
        this.mPreviousScrollerY = r1;
        if (r0.isFinished() == false) goto L13;
        onScrollerFinished(r0);
        return;
    L13:
        invalidate();
    }

    @Override // android.view.View
    public void scrollBy(int x, int y) {
        int[] r5 = this.mSelectorIndices;
        boolean r0 = this.mWrapSelectorWheel;
        if (r0 == true) goto L9;
        if (y <= 0) goto L9;
        if (r5[2] > this.mMinValue) goto L9;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
    L9:
        if (r0 == true) goto L15;
        if (y >= 0) goto L15;
        if (r5[2] < maxValue()) goto L15;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
    L15:
        this.mCurrentScrollOffset += y;
    L16:
        int r6 = this.mCurrentScrollOffset;
        if ((r6 - this.mInitialScrollOffset) <= this.mSelectorTextGapHeight) goto L23;
        this.mCurrentScrollOffset = r6 - this.mSelectorElementHeight;
        decrementSelectorIndices(r5);
        setValueInternal(r5[2], true);
        if (this.mWrapSelectorWheel == true) goto L16;
        if (r5[2] > this.mMinValue) goto L16;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
    L23:
        int r7 = this.mCurrentScrollOffset;
        if ((r7 - this.mInitialScrollOffset) >= (-this.mSelectorTextGapHeight)) goto L30;
        this.mCurrentScrollOffset = r7 + this.mSelectorElementHeight;
        incrementSelectorIndices(r5);
        setValueInternal(r5[2], true);
        if (this.mWrapSelectorWheel == true) goto L23;
        if (r5[2] < maxValue()) goto L23;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        goto L23
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangedListener) {
        this.mOnValueChangeListener = onValueChangedListener;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setFormatter(Formatter formatter) {
        if (formatter != this.mFormatter) goto L5;
        return;
    L5:
        this.mFormatter = formatter;
        initializeSelectorWheelIndices();
    }

    public void setValue(int value) {
        setValueInternal(value, false);
    }

    private void tryComputeMaxWidth() {
        if (this.mComputeMaxWidth == true) goto L5;
        return;
    L5:
        String[] r0 = this.mDisplayedValues;
        int r1 = 0;
        if (r0 != null) goto L17;
        float r2 = 0.0f;
    L9:
        if (r1 > 9) goto L14;
        float r3 = this.mSelectorWheelPaint.measureText(formatNumberWithLocale(r1));
        if (r3 <= r2) goto L13;
        r2 = r3;
    L13:
        r1 = r1 + 1;
        goto L9
    L14:
        int r5 = this.mMaxValue;
    L15:
        if (r5 <= 0) goto L23;
        r5 = r5 / 10;
        goto L15
    L23:
        return;
    L17:
        int r4 = r0.length;
        int r6 = 0;
    L18:
        if (r1 >= r4) goto L31;
        float r7 = this.mSelectorWheelPaint.measureText(this.mDisplayedValues[r1]);
        if (r7 <= r6) goto L22;
        r6 = (int) r7;
    L22:
        r1 = r1 + 1;
        goto L18
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    public void setWrapSelectorWheel(boolean wrapSelectorWheel) {
        if ((maxValue() - this.mMinValue) < this.mSelectorIndices.length) goto L5;
        boolean r0 = true;
    L6:
        if (wrapSelectorWheel == false) goto L9;
        if (r0 == true) goto L9;
        return;
    L9:
        if (wrapSelectorWheel == this.mWrapSelectorWheel) goto L13;
        this.mWrapSelectorWheel = wrapSelectorWheel;
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int getValue() {
        return this.mValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public void setMinValue(int minValue) {
        if (this.mMinValue != minValue) goto L5;
        return;
    L5:
        if (minValue < 0) goto L16;
        this.mMinValue = minValue;
        if (minValue <= this.mValue) goto L10;
        this.mValue = minValue;
    L10:
        if ((maxValue() - this.mMinValue) <= this.mSelectorIndices.length) goto L12;
        boolean r2 = true;
    L13:
        setWrapSelectorWheel(r2);
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        invalidate();
        return;
    L12:
        r2 = false;
        goto L13
    L16:
        throw new IllegalArgumentException("minValue must be >= 0");
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(int maxValue, boolean unsetValue) {
        if (this.mMaxValue != maxValue) goto L5;
        return;
    L5:
        if (maxValue < 0) goto L16;
        this.mMaxValue = maxValue;
        if (maxValue >= this.mValue) goto L9;
        this.mValue = maxValue;
    L9:
        this.mHasUnsetValue = unsetValue;
        if ((maxValue() - this.mMinValue) <= this.mSelectorIndices.length) goto L12;
        boolean r2 = true;
    L13:
        setWrapSelectorWheel(r2);
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        invalidate();
        return;
    L12:
        r2 = false;
        goto L13
    L16:
        throw new IllegalArgumentException("maxValue must be >= 0");
    }

    public void setMaxValue(int maxValue) {
        setMaxValue(maxValue, false);
    }

    private boolean hasUnset() {
        return this.mHasUnsetValue;
    }

    public void setTextSize(int normalSize, int highlightSize) {
        if (normalSize < 0) goto L7;
        if (highlightSize < 0) goto L7;
        this.mNormalSize = normalSize;
        this.mHighlightSize = highlightSize;
        return;
    L7:
        throw new IllegalArgumentException("the text size mus be >= 0 ");
    }

    private float getTextSizeByOffset(int offset) {
        int r0 = this.mMiddleScrollOffset;
        int r1 = this.mSelectorElementHeight;
        if (offset <= (r0 - r1)) goto L17;
        if (offset >= (r0 + r1)) goto L17;
        if (offset >= r0) goto L11;
        int r4 = this.mNormalSize;
        return (float) (((double) r4) + (((((double) (offset - (r0 - r1))) * 1.0d) / ((double) r1)) * ((double) (this.mHighlightSize - r4))));
    L11:
        if (offset < r0) goto L15;
        int r5 = this.mNormalSize;
        return (float) (((double) r5) + (((((double) ((r0 + r1) - offset)) * 1.0d) / ((double) r1)) * ((double) (this.mHighlightSize - r5))));
    L15:
        return this.mNormalSize;
    L17:
        return this.mNormalSize;
    }

    public void setTextColor(int normalColor, int highlightColor) {
        this.mNormalColor = normalColor;
        this.mHighlightColor = highlightColor;
    }

    private int getTextColorByOffset(int offset) {
        int r0 = this.mMiddleScrollOffset;
        int r1 = this.mSelectorElementHeight;
        if (offset <= (r0 - r1)) goto L19;
        if (offset >= (r0 + r1)) goto L19;
        if (offset != r0) goto L11;
        return this.mHighlightColor;
    L11:
        if (offset >= r0) goto L13;
        float r3 = ((offset - (r0 - r1)) * 1.0f) / r1;
    L14:
        if (offset < r0) goto L16;
        r3 = (((r0 + r1) - offset) * 1.0f) / r1;
    L16:
        int r8 = this.mNormalColor;
        int r2 = r8 & 16777215;
        int r7 = this.mHighlightColor;
        int r4 = 16777215 & r7;
        int r5 = r2 & 255;
        int r6 = (r2 >> 8) & 255;
        int r9 = (r2 >> 16) & 255;
        int r10 = r8 >> 24;
        return (((int) (r10 + (((r7 >> 24) - r10) * r3))) << 24) | ((((int) (r9 + ((((r4 >> 16) & 255) - r9) * r3))) << 16) | ((((int) (r5 + (((r4 & 255) - r5) * r3))) | 0) | (((int) (r6 + ((((r4 >> 8) & 255) - r6) * r3))) << 8)));
    L13:
        r3 = 1.0f;
    L19:
        return this.mNormalColor;
    }

    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public void setDisplayedValues(String[] displayedValues) {
        if (this.mDisplayedValues != displayedValues) goto L5;
        return;
    L5:
        this.mDisplayedValues = displayedValues;
        initializeSelectorWheelIndices();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onDraw(canvas);
        return;
    L6:
        int r0 = this.mCurrentScrollOffset;
        int r1 = (getRight() - getLeft()) / 2;
        int[] r3 = this.mSelectorIndices;
        int r4 = 0;
    L8:
        if (r4 >= r3.length) goto L15;
        int r5 = r3[r4];
        if (looksUnset(r5) == false) goto L12;
        String r6 = UNSET_STRING;
    L13:
        this.mSelectorWheelPaint.setTextSize(getTextSizeByOffset(r0));
        this.mSelectorWheelPaint.setColor(getTextColorByOffset(r0));
        canvas.drawText(r6, r1, r0, this.mSelectorWheelPaint);
        r0 = r0 + this.mSelectorElementHeight;
        r4 = r4 + 1;
        goto L8
    L12:
        r6 = this.mSelectorIndexToStringCache.get(r5);
        goto L13
    L15:
        if (isTimeChanged(r3[2]) == false) goto L20;
        if (Math.abs(this.mFlingScroller.getFinalY() - this.mFlingScroller.getCurrY()) <= 50) goto L20;
        this.mOldTime = r3[2];
        postDelayed(this.mSoundRunnable, 10);
        return;
    L20:
        if (isTimeChanged(r3[2]) == true) goto L22;
        return;
    L22:
        if (this.mFlingScroller.getFinalY() > this.mFlingScroller.getCurrY()) goto L30;
        this.mOldTime = r3[2];
        postDelayed(this.mSoundRunnable, 30);
        return;
    }

    private boolean isTimeChanged(int newTime) {
        if (this.mOldTime != (-1)) goto L6;
        this.mOldTime = newTime;
    L6:
        if (this.mOldTime != newTime) goto L9;
        return false;
    L9:
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(NumberPicker.class.getName());
        event.setScrollable(true);
        event.setScrollY((this.mMinValue + this.mValue) * this.mSelectorElementHeight);
    }

    private int makeMeasureSpec(int measureSpec, int maxSize) {
        if (maxSize != (-1)) goto L5;
        return measureSpec;
    L5:
        int r3 = View.MeasureSpec.getSize(measureSpec);
        int r0 = View.MeasureSpec.getMode(measureSpec);
        if (r0 == Integer.MIN_VALUE) goto L15;
        if (r0 == 0) goto L13;
        if (r0 != 1073741824) goto L11;
        return measureSpec;
    L11:
        throw new IllegalArgumentException("Unknown measure mode: " + r0);
    L13:
        return View.MeasureSpec.makeMeasureSpec(maxSize, 1073741824);
    L15:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r3, maxSize), 1073741824);
    }

    private int resolveSizeAndStateRespectingMinSize(int minSize, int measuredSize, int measureSpec) {
        if (minSize != (-1)) goto L5;
        return measuredSize;
    L5:
        return resolveSizeAndState(Math.max(minSize, measuredSize), measureSpec, 0);
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        int[] r0 = this.mSelectorIndices;
        int r1 = getValue();
        int r3 = 0;
        if (looksUnset(r1) == false) goto L6;
        int r2 = this.mMaxValue - 1;
        r0[0] = r2;
        ensureCachedScrollSelectorValue(r2);
        int r4 = this.mMaxValue;
        r0[1] = r4;
        ensureCachedScrollSelectorValue(r4);
        r0[2] = 4;
        ensureCachedScrollSelectorValue(4);
        int r5 = this.mMinValue;
        r0[3] = r5;
        ensureCachedScrollSelectorValue(r5);
        int r6 = this.mMinValue + 1;
        r0[4] = r6;
        ensureCachedScrollSelectorValue(r6);
        return;
    L6:
        if (r3 >= this.mSelectorIndices.length) goto L15;
        int r7 = (r3 - 2) + r1;
        if (this.mWrapSelectorWheel == false) goto L10;
        r7 = getWrappedSelectorIndex(r7);
    L10:
        r0[r3] = r7;
        ensureCachedScrollSelectorValue(r7);
        r3 = r3 + 1;
        goto L6
    }

    private void setValueInternal(int current, boolean notifyChange) {
        if (this.mValue != current) goto L5;
        return;
    L5:
        int r1 = 4;
        if (looksUnset(current) == false) goto L11;
        if (this.mValue != 4) goto L11;
        return;
    L11:
        if (this.mWrapSelectorWheel == false) goto L17;
        if (looksUnset(current) == true) goto L20;
        r1 = getWrappedSelectorIndex(current);
    L20:
        int r3 = this.mValue;
        this.mValue = r1;
        if (notifyChange == false) goto L23;
        notifyChange(r3, r1);
        startVibrate();
    L23:
        initializeSelectorWheelIndices();
        invalidate();
        return;
    L17:
        if (looksUnset(current) == true) goto L20;
        r1 = Math.min(Math.max(current, this.mMinValue), this.mMaxValue);
        goto L20
    }

    private void startVibrate() {
        VibrationEffect r0 = VibrationEffect.get(0);
        this.mVibrator.vibrate(r0);
    }

    private boolean looksUnset(int current) {
        if (current > this.mMaxValue) goto L7;
        if (current < this.mMinValue) goto L7;
    L9:
        return false;
    L7:
        if (hasUnset() == false) goto L9;
        return true;
    }

    private void changeValueByOne(boolean increment) {
        if (this.mHasSelectorWheel == false) goto L13;
        if (moveToFinalScrollerPosition(this.mFlingScroller) == true) goto L7;
        moveToFinalScrollerPosition(this.mAdjustScroller);
    L7:
        this.mPreviousScrollerY = 0;
        if (increment == false) goto L10;
        this.mFlingScroller.startScroll(0, 0, 0, -this.mSelectorElementHeight, 300);
    L11:
        invalidate();
        return;
    L10:
        this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight, 300);
        goto L11
    L13:
        if (increment == false) goto L15;
        setValueInternal(this.mValue + 1, true);
        return;
    L15:
        setValueInternal(this.mValue - 1, true);
    }

    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] r0 = this.mSelectorIndices;
        int r1 = (int) ((((getBottom() - getTop()) - (r0.length * this.mNormalSize)) / r0.length) + 0.5f);
        this.mSelectorTextGapHeight = r1;
        this.mSelectorElementHeight = this.mNormalSize + r1;
        int r2 = (getHeight() + this.mNormalSize) / 2;
        int r3 = this.mSelectorElementHeight;
        int r4 = r2 - (r3 * 2);
        this.mInitialScrollOffset = r4;
        this.mMiddleScrollOffset = (r3 * 2) + r4;
        this.mCurrentScrollOffset = r4;
    }

    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.mNormalSize) / 2);
    }

    private void onScrollerFinished(Scroller scroller) {
        if (scroller != this.mFlingScroller) goto L6;
        ensureScrollWheelAdjusted();
        onScrollStateChange(0);
        return;
    }

    private void onScrollStateChange(int scrollState) {
        if (this.mScrollState != scrollState) goto L5;
        return;
    L5:
        this.mScrollState = scrollState;
        OnScrollListener r0 = this.mOnScrollListener;
        if (r0 == null) goto L9;
        r0.onScrollStateChange(this, scrollState);
        return;
    }

    private void fling(int velocityY) {
        this.mPreviousScrollerY = 0;
        if (velocityY <= 0) goto L5;
        this.mFlingScroller.fling(0, 0, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
    L6:
        invalidate();
        return;
    L5:
        this.mFlingScroller.fling(0, Integer.MAX_VALUE, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        goto L6
    }

    private int getWrappedSelectorIndex(int selectorIndex) {
        if (selectorIndex <= maxValue()) goto L7;
        return (this.mMinValue + ((selectorIndex - maxValue()) % maxValue())) - 1;
    L7:
        if (selectorIndex < this.mMinValue) goto L9;
        return selectorIndex;
    L9:
        return (maxValue() - ((this.mMinValue - selectorIndex) % (maxValue() - this.mMinValue))) + 1;
    }

    private int maxValue() {
        return this.mMaxValue + (hasUnset() ? 1 : 0);
    }

    private void incrementSelectorIndices(int[] selectorIndices) {
        int r0 = 0;
    L4:
        if (r0 >= (selectorIndices.length - 1)) goto L6;
        int r1 = r0 + 1;
        selectorIndices[r0] = selectorIndices[r1];
        r0 = r1;
        goto L4
    L6:
        int r2 = selectorIndices[selectorIndices.length - 2] + 1;
        if (this.mWrapSelectorWheel == true) goto L9;
    L11:
        selectorIndices[selectorIndices.length - 1] = r2;
        ensureCachedScrollSelectorValue(r2);
        return;
    L9:
        if (r2 <= maxValue()) goto L11;
        r2 = this.mMinValue;
        goto L11
    }

    private void decrementSelectorIndices(int[] selectorIndices) {
        int r0 = selectorIndices.length - 1;
    L3:
        if (r0 <= 0) goto L5;
        selectorIndices[r0] = selectorIndices[r0 - 1];
        r0 = r0 - 1;
        goto L3
    L5:
        int r1 = selectorIndices[1] - 1;
        if (this.mWrapSelectorWheel == true) goto L8;
    L10:
        selectorIndices[0] = r1;
        ensureCachedScrollSelectorValue(r1);
        return;
    L8:
        if (r1 >= this.mMinValue) goto L10;
        r1 = maxValue();
        goto L10
    }

    private void ensureCachedScrollSelectorValue(int selectorIndex) {
        SparseArray<String> r0 = this.mSelectorIndexToStringCache;
        if (r0.get(selectorIndex) == null) goto L5;
        return;
    L5:
        int r1 = this.mMinValue;
        if (selectorIndex < r1) goto L15;
        if (selectorIndex > this.mMaxValue) goto L15;
        String[] r2 = this.mDisplayedValues;
        if (r2 == null) goto L13;
        String r3 = r2[selectorIndex - r1];
    L18:
        r0.put(selectorIndex, r3);
        return;
    L13:
        r3 = formatNumber(selectorIndex);
    L15:
        if (hasUnset() == false) goto L17;
        return;
    L17:
        r3 = "";
        goto L18
    }

    private String formatNumber(int value) {
        Formatter r0 = this.mFormatter;
        if (r0 == null) goto L6;
        return r0.format(value);
    L6:
        return formatNumberWithLocale(value);
    }

    private void notifyChange(int previous, int current) {
        OnValueChangeListener r3 = this.mOnValueChangeListener;
        if (r3 == null) goto L6;
        r3.onValueChange(this, previous, this.mValue);
        return;
    }

    private boolean ensureScrollWheelAdjusted() {
        int r0 = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        if (r0 == 0) goto L11;
        this.mPreviousScrollerY = 0;
        int r1 = Math.abs(r0);
        int r2 = this.mSelectorElementHeight;
        if (r1 <= (r2 / 2)) goto L9;
        if (r0 <= 0) goto L8;
        r2 = -r2;
    L8:
        r0 = r0 + r2;
    L9:
        Scroller r3 = this.mAdjustScroller;
        r3.startScroll(0, 0, 0, r0, 800);
        invalidate();
        return true;
    L11:
        return false;
    }

    private static String formatNumberWithLocale(int value) {
        return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(value)});
    }

    private static void log(String msg) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, msg);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (sPool != null) goto L6;
        SoundPool r0 = new SoundPool(6, 1, 0);
        sPool = r0;
        sSoundId = r0.load(getContext().getApplicationContext(), R.raw.time_picker, 1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SoundPool r0 = sPool;
        if (r0 == null) goto L6;
        r0.release();
        sPool = null;
        return;
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.mHasSelectorWheel == true) goto L7;
        return super.getAccessibilityNodeProvider();
    L7:
        if (this.mAccessibilityNodeProvider != null) goto L10;
        this.mAccessibilityNodeProvider = new AccessibilityNodeProviderImpl(this, null);
    L10:
        return this.mAccessibilityNodeProvider;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent event) {
        if (this.mHasSelectorWheel == true) goto L7;
        return super.dispatchHoverEvent(event);
    L7:
        if (InvokeApi.xAccessibilityManager.getInstance(getContext()).isEnabled() == false) goto L34;
        int r0 = (int) event.getY();
        int r1 = this.mTopSelectionDividerTop;
        int r2 = this.mSelectorElementHeight;
        if (r0 >= (r1 - r2)) goto L11;
        int r3 = 1;
    L19:
        int r9 = event.getActionMasked();
        AccessibilityNodeProviderImpl r4 = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider();
        if (r9 != 7) goto L22;
        int r10 = this.mLastHoveredChildVirtualViewId;
        if (r10 == r3) goto L37;
        if (r10 == (-1)) goto L38;
        AccessibilityNodeProviderImpl.access$400(r4, r10, 256);
        AccessibilityNodeProviderImpl.access$400(r4, r3, 128);
        this.mLastHoveredChildVirtualViewId = r3;
        r4.performAction(r3, 64, null);
        return false;
    L38:
        return false;
    L37:
        return false;
    L22:
        if (r9 != 9) goto L24;
        AccessibilityNodeProviderImpl.access$400(r4, r3, 128);
        this.mLastHoveredChildVirtualViewId = r3;
        r4.performAction(r3, 64, null);
        return false;
    L24:
        if (r9 != 10) goto L39;
        AccessibilityNodeProviderImpl.access$400(r4, r3, 256);
        this.mLastHoveredChildVirtualViewId = -1;
        return false;
    L39:
        return false;
    L11:
        if (r0 >= r1) goto L13;
        r3 = 2;
        goto L19
    L13:
        int r5 = this.mBottomSelectionDividerBottom;
        if (r0 <= (r2 + r5)) goto L16;
        r3 = 5;
        goto L19
    L16:
        if (r0 <= r5) goto L18;
        r3 = 4;
        goto L19
    L18:
        r3 = 3;
        goto L19
    L34:
        return false;
    }
}
