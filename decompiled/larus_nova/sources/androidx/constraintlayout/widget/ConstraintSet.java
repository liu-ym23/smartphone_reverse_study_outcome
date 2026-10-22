package androidx.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS = null;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant;
    private HashMap<Integer, Constraint> mConstraints;
    private boolean mForceId;
    private HashMap<String, ConstraintAttribute> mSavedAttributes;
    private boolean mValidate;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Constraint {
        public final Layout layout;
        public HashMap<String, ConstraintAttribute> mCustomConstraints;
        int mViewId;
        public final Motion motion;
        public final PropertySet propertySet;
        public final Transform transform;

        public Constraint clone() {
            Constraint r100 = new Constraint();
            r100.layout.copyFrom(this.layout);
            r100.motion.copyFrom(this.motion);
            r100.propertySet.copyFrom(this.propertySet);
            r100.transform.copyFrom(this.transform);
            r100.mViewId = this.mViewId;
            return r100;
        }

        public Constraint() {
            this.propertySet = new PropertySet();
            this.motion = new Motion();
            this.layout = new Layout();
            this.transform = new Transform();
            this.mCustomConstraints = new HashMap();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m7805clone() throws CloneNotSupportedException {
            return clone();
        }

        public void applyTo(ConstraintLayout.LayoutParams r100) {
            Layout r101 = this.layout;
            r100.leftToLeft = r101.leftToLeft;
            r100.leftToRight = r101.leftToRight;
            r100.rightToLeft = r101.rightToLeft;
            r100.rightToRight = r101.rightToRight;
            r100.topToTop = r101.topToTop;
            r100.topToBottom = r101.topToBottom;
            r100.bottomToTop = r101.bottomToTop;
            r100.bottomToBottom = r101.bottomToBottom;
            r100.baselineToBaseline = r101.baselineToBaseline;
            r100.startToEnd = r101.startToEnd;
            r100.startToStart = r101.startToStart;
            r100.endToStart = r101.endToStart;
            r100.endToEnd = r101.endToEnd;
            ((ViewGroup.MarginLayoutParams) r100).leftMargin = r101.leftMargin;
            ((ViewGroup.MarginLayoutParams) r100).rightMargin = r101.rightMargin;
            ((ViewGroup.MarginLayoutParams) r100).topMargin = r101.topMargin;
            ((ViewGroup.MarginLayoutParams) r100).bottomMargin = r101.bottomMargin;
            r100.goneStartMargin = r101.goneStartMargin;
            r100.goneEndMargin = r101.goneEndMargin;
            r100.goneTopMargin = r101.goneTopMargin;
            r100.goneBottomMargin = r101.goneBottomMargin;
            r100.horizontalBias = r101.horizontalBias;
            r100.verticalBias = r101.verticalBias;
            r100.circleConstraint = r101.circleConstraint;
            r100.circleRadius = r101.circleRadius;
            r100.circleAngle = r101.circleAngle;
            r100.dimensionRatio = r101.dimensionRatio;
            r100.editorAbsoluteX = r101.editorAbsoluteX;
            r100.editorAbsoluteY = r101.editorAbsoluteY;
            r100.verticalWeight = r101.verticalWeight;
            r100.horizontalWeight = r101.horizontalWeight;
            r100.verticalChainStyle = r101.verticalChainStyle;
            r100.horizontalChainStyle = r101.horizontalChainStyle;
            r100.constrainedWidth = r101.constrainedWidth;
            r100.constrainedHeight = r101.constrainedHeight;
            r100.matchConstraintDefaultWidth = r101.widthDefault;
            r100.matchConstraintDefaultHeight = r101.heightDefault;
            r100.matchConstraintMaxWidth = r101.widthMax;
            r100.matchConstraintMaxHeight = r101.heightMax;
            r100.matchConstraintMinWidth = r101.widthMin;
            r100.matchConstraintMinHeight = r101.heightMin;
            r100.matchConstraintPercentWidth = r101.widthPercent;
            r100.matchConstraintPercentHeight = r101.heightPercent;
            r100.orientation = r101.orientation;
            r100.guidePercent = r101.guidePercent;
            r100.guideBegin = r101.guideBegin;
            r100.guideEnd = r101.guideEnd;
            ((ViewGroup.MarginLayoutParams) r100).width = r101.mWidth;
            ((ViewGroup.MarginLayoutParams) r100).height = r101.mHeight;
            String r102 = r101.mConstraintTag;
            if (r102 == null) goto L5;
            r100.constraintTag = r102;
        L5:
            r100.setMarginStart(r101.startMargin);
            r100.setMarginEnd(this.layout.endMargin);
            r100.validate();
        }

        private void fillFrom(int r100, ConstraintLayout.LayoutParams r101) {
            this.mViewId = r100;
            Layout r102 = this.layout;
            r102.leftToLeft = r101.leftToLeft;
            r102.leftToRight = r101.leftToRight;
            r102.rightToLeft = r101.rightToLeft;
            r102.rightToRight = r101.rightToRight;
            r102.topToTop = r101.topToTop;
            r102.topToBottom = r101.topToBottom;
            r102.bottomToTop = r101.bottomToTop;
            r102.bottomToBottom = r101.bottomToBottom;
            r102.baselineToBaseline = r101.baselineToBaseline;
            r102.startToEnd = r101.startToEnd;
            r102.startToStart = r101.startToStart;
            r102.endToStart = r101.endToStart;
            r102.endToEnd = r101.endToEnd;
            r102.horizontalBias = r101.horizontalBias;
            r102.verticalBias = r101.verticalBias;
            r102.dimensionRatio = r101.dimensionRatio;
            r102.circleConstraint = r101.circleConstraint;
            r102.circleRadius = r101.circleRadius;
            r102.circleAngle = r101.circleAngle;
            r102.editorAbsoluteX = r101.editorAbsoluteX;
            r102.editorAbsoluteY = r101.editorAbsoluteY;
            r102.orientation = r101.orientation;
            r102.guidePercent = r101.guidePercent;
            r102.guideBegin = r101.guideBegin;
            r102.guideEnd = r101.guideEnd;
            r102.mWidth = ((ViewGroup.MarginLayoutParams) r101).width;
            r102.mHeight = ((ViewGroup.MarginLayoutParams) r101).height;
            r102.leftMargin = ((ViewGroup.MarginLayoutParams) r101).leftMargin;
            r102.rightMargin = ((ViewGroup.MarginLayoutParams) r101).rightMargin;
            r102.topMargin = ((ViewGroup.MarginLayoutParams) r101).topMargin;
            r102.bottomMargin = ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
            r102.verticalWeight = r101.verticalWeight;
            r102.horizontalWeight = r101.horizontalWeight;
            r102.verticalChainStyle = r101.verticalChainStyle;
            r102.horizontalChainStyle = r101.horizontalChainStyle;
            r102.constrainedWidth = r101.constrainedWidth;
            r102.constrainedHeight = r101.constrainedHeight;
            r102.widthDefault = r101.matchConstraintDefaultWidth;
            r102.heightDefault = r101.matchConstraintDefaultHeight;
            r102.widthMax = r101.matchConstraintMaxWidth;
            r102.heightMax = r101.matchConstraintMaxHeight;
            r102.widthMin = r101.matchConstraintMinWidth;
            r102.heightMin = r101.matchConstraintMinHeight;
            r102.widthPercent = r101.matchConstraintPercentWidth;
            r102.heightPercent = r101.matchConstraintPercentHeight;
            r102.mConstraintTag = r101.constraintTag;
            r102.goneTopMargin = r101.goneTopMargin;
            r102.goneBottomMargin = r101.goneBottomMargin;
            r102.goneLeftMargin = r101.goneLeftMargin;
            r102.goneRightMargin = r101.goneRightMargin;
            r102.goneStartMargin = r101.goneStartMargin;
            r102.goneEndMargin = r101.goneEndMargin;
            r102.endMargin = r101.getMarginEnd();
            Layout r103 = this.layout;
            r103.startMargin = r101.getMarginStart();
        }

        private void fillFromConstraints(int r100, Constraints.LayoutParams r101) {
            fillFrom(r100, r101);
            PropertySet r102 = this.propertySet;
            r102.alpha = r101.alpha;
            Transform r103 = this.transform;
            r103.rotation = r101.rotation;
            r103.rotationX = r101.rotationX;
            r103.rotationY = r101.rotationY;
            r103.scaleX = r101.scaleX;
            r103.scaleY = r101.scaleY;
            r103.transformPivotX = r101.transformPivotX;
            r103.transformPivotY = r101.transformPivotY;
            r103.translationX = r101.translationX;
            r103.translationY = r101.translationY;
            r103.translationZ = r101.translationZ;
            r103.elevation = r101.elevation;
            r103.applyElevation = r101.applyElevation;
        }

        private ConstraintAttribute get(String r100, ConstraintAttribute.AttributeType r101) {
            if (this.mCustomConstraints.containsKey(r100) == false) goto L9;
            ConstraintAttribute r102 = this.mCustomConstraints.get(r100);
            if (r102.getType() != r101) goto L8;
            return r102;
        L8:
            throw new IllegalArgumentException("ConstraintAttribute is already a " + r102.getType().name());
        L9:
            ConstraintAttribute r103 = new ConstraintAttribute(r100, r101);
            this.mCustomConstraints.put(r100, r103);
            return r103;
        }

        private void setColorValue(String r100, int r101) {
            get(r100, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(r101);
        }

        private void setFloatValue(String r100, float r101) {
            get(r100, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(r101);
        }

        private void setIntValue(String r100, int r101) {
            get(r100, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(r101);
        }

        private void setStringValue(String r100, String r101) {
            get(r100, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(r101);
        }

        public static /* synthetic */ void access$000(Constraint r100, int r101, ConstraintLayout.LayoutParams r102) {
            r100.fillFrom(r101, r102);
        }

        public static /* synthetic */ void access$400(Constraint r100, int r101, Constraints.LayoutParams r102) {
            r100.fillFromConstraints(r101, r102);
        }

        public static /* synthetic */ void access$500(Constraint r100, String r101, int r102) {
            r100.setIntValue(r101, r102);
        }

        public static /* synthetic */ void access$600(Constraint r100, String r101, int r102) {
            r100.setColorValue(r101, r102);
        }

        public static /* synthetic */ void access$700(Constraint r100, String r101, float r102) {
            r100.setFloatValue(r101, r102);
        }

        public static /* synthetic */ void access$800(Constraint r100, String r101, String r102) {
            r100.setStringValue(r101, r102);
        }

        private void fillFromConstraints(ConstraintHelper r100, int r101, Constraints.LayoutParams r102) {
            fillFromConstraints(r101, r102);
            if ((r100 instanceof Barrier) == false) goto L6;
            Layout r103 = this.layout;
            r103.mHelperType = 1;
            Barrier r104 = (Barrier) r100;
            r103.mBarrierDirection = r104.getType();
            Layout r105 = this.layout;
            r105.mReferenceIds = r104.getReferencedIds();
            Layout r106 = this.layout;
            r106.mBarrierMargin = r104.getMargin();
            return;
        }

        public static /* synthetic */ void access$300(Constraint r100, ConstraintHelper r101, int r102, Constraints.LayoutParams r103) {
            r100.fillFromConstraints(r101, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        private static final int UNUSED = 76;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public int baselineToBaseline;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endMargin;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mApply;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mBarrierMargin;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType;
        public boolean mIsGuideline;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        static {
            SparseIntArray r100 = new SparseIntArray();
            mapToConstant = r100;
            r100.append(43, 24);
            mapToConstant.append(44, 25);
            mapToConstant.append(46, 28);
            mapToConstant.append(47, 29);
            mapToConstant.append(52, 35);
            mapToConstant.append(51, 34);
            mapToConstant.append(24, 4);
            mapToConstant.append(23, 3);
            mapToConstant.append(19, 1);
            mapToConstant.append(61, 6);
            mapToConstant.append(62, 7);
            mapToConstant.append(31, 17);
            mapToConstant.append(32, 18);
            mapToConstant.append(33, 19);
            mapToConstant.append(0, 26);
            mapToConstant.append(48, 31);
            mapToConstant.append(49, 32);
            mapToConstant.append(30, 10);
            mapToConstant.append(29, 9);
            mapToConstant.append(66, 13);
            mapToConstant.append(69, 16);
            mapToConstant.append(67, 14);
            mapToConstant.append(64, 11);
            mapToConstant.append(68, 15);
            mapToConstant.append(65, 12);
            mapToConstant.append(55, 38);
            mapToConstant.append(41, 37);
            mapToConstant.append(40, 39);
            mapToConstant.append(54, 40);
            mapToConstant.append(39, 20);
            mapToConstant.append(53, 36);
            mapToConstant.append(28, 5);
            mapToConstant.append(42, 76);
            mapToConstant.append(50, 76);
            mapToConstant.append(45, 76);
            mapToConstant.append(22, 76);
            mapToConstant.append(18, 76);
            mapToConstant.append(3, 23);
            mapToConstant.append(5, 27);
            mapToConstant.append(7, 30);
            mapToConstant.append(8, 8);
            mapToConstant.append(4, 33);
            mapToConstant.append(6, 2);
            mapToConstant.append(1, 22);
            mapToConstant.append(2, 21);
            mapToConstant.append(25, 61);
            mapToConstant.append(27, 62);
            mapToConstant.append(26, 63);
            mapToConstant.append(60, 69);
            mapToConstant.append(38, 70);
            mapToConstant.append(12, 71);
            mapToConstant.append(10, 72);
            mapToConstant.append(11, 73);
            mapToConstant.append(13, 74);
            mapToConstant.append(9, 75);
        }

        public Layout() {
            this.mIsGuideline = false;
            this.mApply = false;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.endMargin = -1;
            this.startMargin = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneEndMargin = -1;
            this.goneStartMargin = -1;
            this.verticalWeight = -1.0f;
            this.horizontalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.widthDefault = 0;
            this.heightDefault = 0;
            this.widthMax = -1;
            this.heightMax = -1;
            this.widthMin = -1;
            this.heightMin = -1;
            this.widthPercent = 1.0f;
            this.heightPercent = 1.0f;
            this.mBarrierDirection = -1;
            this.mBarrierMargin = 0;
            this.mHelperType = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.mBarrierAllowsGoneWidgets = true;
        }

        public void copyFrom(Layout r100) {
            this.mIsGuideline = r100.mIsGuideline;
            this.mWidth = r100.mWidth;
            this.mApply = r100.mApply;
            this.mHeight = r100.mHeight;
            this.guideBegin = r100.guideBegin;
            this.guideEnd = r100.guideEnd;
            this.guidePercent = r100.guidePercent;
            this.leftToLeft = r100.leftToLeft;
            this.leftToRight = r100.leftToRight;
            this.rightToLeft = r100.rightToLeft;
            this.rightToRight = r100.rightToRight;
            this.topToTop = r100.topToTop;
            this.topToBottom = r100.topToBottom;
            this.bottomToTop = r100.bottomToTop;
            this.bottomToBottom = r100.bottomToBottom;
            this.baselineToBaseline = r100.baselineToBaseline;
            this.startToEnd = r100.startToEnd;
            this.startToStart = r100.startToStart;
            this.endToStart = r100.endToStart;
            this.endToEnd = r100.endToEnd;
            this.horizontalBias = r100.horizontalBias;
            this.verticalBias = r100.verticalBias;
            this.dimensionRatio = r100.dimensionRatio;
            this.circleConstraint = r100.circleConstraint;
            this.circleRadius = r100.circleRadius;
            this.circleAngle = r100.circleAngle;
            this.editorAbsoluteX = r100.editorAbsoluteX;
            this.editorAbsoluteY = r100.editorAbsoluteY;
            this.orientation = r100.orientation;
            this.leftMargin = r100.leftMargin;
            this.rightMargin = r100.rightMargin;
            this.topMargin = r100.topMargin;
            this.bottomMargin = r100.bottomMargin;
            this.endMargin = r100.endMargin;
            this.startMargin = r100.startMargin;
            this.goneLeftMargin = r100.goneLeftMargin;
            this.goneTopMargin = r100.goneTopMargin;
            this.goneRightMargin = r100.goneRightMargin;
            this.goneBottomMargin = r100.goneBottomMargin;
            this.goneEndMargin = r100.goneEndMargin;
            this.goneStartMargin = r100.goneStartMargin;
            this.verticalWeight = r100.verticalWeight;
            this.horizontalWeight = r100.horizontalWeight;
            this.horizontalChainStyle = r100.horizontalChainStyle;
            this.verticalChainStyle = r100.verticalChainStyle;
            this.widthDefault = r100.widthDefault;
            this.heightDefault = r100.heightDefault;
            this.widthMax = r100.widthMax;
            this.heightMax = r100.heightMax;
            this.widthMin = r100.widthMin;
            this.heightMin = r100.heightMin;
            this.widthPercent = r100.widthPercent;
            this.heightPercent = r100.heightPercent;
            this.mBarrierDirection = r100.mBarrierDirection;
            this.mBarrierMargin = r100.mBarrierMargin;
            this.mHelperType = r100.mHelperType;
            this.mConstraintTag = r100.mConstraintTag;
            int[] r101 = r100.mReferenceIds;
            if (r101 == null) goto L5;
            this.mReferenceIds = Arrays.copyOf(r101, r101.length);
        L6:
            this.mReferenceIdString = r100.mReferenceIdString;
            this.constrainedWidth = r100.constrainedWidth;
            this.constrainedHeight = r100.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = r100.mBarrierAllowsGoneWidgets;
            return;
        L5:
            this.mReferenceIds = null;
            goto L6
        }

        public void dump(MotionScene r110, StringBuilder r111) {
            Field[] r100 = getClass().getDeclaredFields();
            r111.append("\n");
            int r101 = 0;
        L4:
            if (r101 >= r100.length) goto L27;
            Field r102 = r100[r101];
            String r103 = r102.getName();
            if (Modifier.isStatic(r102.getModifiers()) == true) goto L26;
            Object r104 = r102.get(this);     // Catch: IllegalAccessException -> L24
            Class<?> r105 = r102.getType();     // Catch: IllegalAccessException -> L24
            if (r105 != Integer.TYPE) goto L19;
            Integer r106 = (Integer) r104;     // Catch: IllegalAccessException -> L24
            if (r106.intValue() == (-1)) goto L26;
            Object r107 = r110.lookUpConstraintName(r106.intValue());     // Catch: IllegalAccessException -> L24
            r111.append(LineContent.FOUR_SPACE);     // Catch: IllegalAccessException -> L24
            r111.append(r103);     // Catch: IllegalAccessException -> L24
            r111.append(" = \"");     // Catch: IllegalAccessException -> L24
            if (r107 != null) goto L16;
            Object r108 = r106;
        L17:
            r111.append(r108);     // Catch: IllegalAccessException -> L24
            r111.append("\"\n");     // Catch: IllegalAccessException -> L24
            goto L26
        L16:
            r108 = r107;
            goto L17
        L19:
            if (r105 != Float.TYPE) goto L26;
            Float r109 = (Float) r104;     // Catch: IllegalAccessException -> L24
            if (r109.floatValue() == (-1.0f)) goto L26;
            r111.append(LineContent.FOUR_SPACE);     // Catch: IllegalAccessException -> L24
            r111.append(r103);     // Catch: IllegalAccessException -> L24
            r111.append(" = \"");     // Catch: IllegalAccessException -> L24
            r111.append(r109);     // Catch: IllegalAccessException -> L24
            r111.append("\"\n");     // Catch: IllegalAccessException -> L24
        L24:
            e = move-exception;
            e.printStackTrace();
        L26:
            r101 = r101 + 1;
            goto L4
        }

        public void fillFromAttributeList(Context r100, AttributeSet r101) {
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.orientation, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.layout_marginStart, R.attr.layout_marginEnd, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_wrapBehaviorInParent, com.larus.nova.R.attr.maxHeight, com.larus.nova.R.attr.maxWidth, com.larus.nova.R.attr.minHeight, com.larus.nova.R.attr.minWidth});
            this.mApply = true;
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L74;
            int r105 = r102.getIndex(r104);
            int r106 = mapToConstant.get(r105);
            if (r106 != 80) goto L7;
            this.constrainedWidth = r102.getBoolean(r105, this.constrainedWidth);
        L73:
            r104 = r104 + 1;
            goto L3
        L7:
            if (r106 == 81) goto L71;
            switch(r106) {
                case 1: goto L70;
                case 2: goto L69;
                case 3: goto L68;
                case 4: goto L67;
                case 5: goto L66;
                case 6: goto L65;
                case 7: goto L64;
                case 8: goto L63;
                case 9: goto L62;
                case 10: goto L61;
                case 11: goto L60;
                case 12: goto L59;
                case 13: goto L58;
                case 14: goto L57;
                case 15: goto L56;
                case 16: goto L55;
                case 17: goto L54;
                case 18: goto L53;
                case 19: goto L52;
                case 20: goto L51;
                case 21: goto L50;
                case 22: goto L49;
                case 23: goto L48;
                case 24: goto L47;
                case 25: goto L46;
                case 26: goto L45;
                case 27: goto L44;
                case 28: goto L43;
                case 29: goto L42;
                case 30: goto L41;
                case 31: goto L40;
                case 32: goto L39;
                case 33: goto L38;
                case 34: goto L37;
                case 35: goto L36;
                case 36: goto L35;
                case 37: goto L34;
                case 38: goto L33;
                case 39: goto L32;
                case 40: goto L31;
                default: goto L9;
            };
        L9:
            switch(r106) {
                case 54: goto L30;
                case 55: goto L29;
                case 56: goto L28;
                case 57: goto L27;
                case 58: goto L26;
                case 59: goto L25;
                default: goto L10;
            };
        L10:
            switch(r106) {
                case 61: goto L24;
                case 62: goto L23;
                case 63: goto L22;
                default: goto L12;
            };
        L22:
            this.circleAngle = r102.getFloat(r105, this.circleAngle);
            goto L73
        L23:
            this.circleRadius = r102.getDimensionPixelSize(r105, this.circleRadius);
            goto L73
        L24:
            this.circleConstraint = ConstraintSet.access$100(r102, r105, this.circleConstraint);
            goto L73
        L12:
            switch(r106) {
                case 69: goto L21;
                case 70: goto L20;
                case 71: goto L73;
                case 72: goto L19;
                case 73: goto L18;
                case 74: goto L17;
                case 75: goto L16;
                case 76: goto L15;
                case 77: goto L14;
                default: goto L13;
            };
        L13:
            Integer.toHexString(r105);
            mapToConstant.get(r105);
            goto L73
        L14:
            this.mConstraintTag = r102.getString(r105);
            goto L73
        L15:
            Integer.toHexString(r105);
            mapToConstant.get(r105);
            goto L73
        L16:
            this.mBarrierAllowsGoneWidgets = r102.getBoolean(r105, this.mBarrierAllowsGoneWidgets);
            goto L73
        L17:
            this.mReferenceIdString = r102.getString(r105);
            goto L73
        L18:
            this.mBarrierMargin = r102.getDimensionPixelSize(r105, this.mBarrierMargin);
            goto L73
        L19:
            this.mBarrierDirection = r102.getInt(r105, this.mBarrierDirection);
            goto L73
        L20:
            this.heightPercent = r102.getFloat(r105, 1.0f);
            goto L73
        L21:
            this.widthPercent = r102.getFloat(r105, 1.0f);
            goto L73
        L25:
            this.heightMin = r102.getDimensionPixelSize(r105, this.heightMin);
            goto L73
        L26:
            this.widthMin = r102.getDimensionPixelSize(r105, this.widthMin);
            goto L73
        L27:
            this.heightMax = r102.getDimensionPixelSize(r105, this.heightMax);
            goto L73
        L28:
            this.widthMax = r102.getDimensionPixelSize(r105, this.widthMax);
            goto L73
        L29:
            this.heightDefault = r102.getInt(r105, this.heightDefault);
            goto L73
        L30:
            this.widthDefault = r102.getInt(r105, this.widthDefault);
            goto L73
        L31:
            this.verticalChainStyle = r102.getInt(r105, this.verticalChainStyle);
            goto L73
        L32:
            this.horizontalChainStyle = r102.getInt(r105, this.horizontalChainStyle);
            goto L73
        L33:
            this.verticalWeight = r102.getFloat(r105, this.verticalWeight);
            goto L73
        L34:
            this.horizontalWeight = r102.getFloat(r105, this.horizontalWeight);
            goto L73
        L35:
            this.verticalBias = r102.getFloat(r105, this.verticalBias);
            goto L73
        L36:
            this.topToTop = ConstraintSet.access$100(r102, r105, this.topToTop);
            goto L73
        L37:
            this.topToBottom = ConstraintSet.access$100(r102, r105, this.topToBottom);
            goto L73
        L38:
            this.topMargin = r102.getDimensionPixelSize(r105, this.topMargin);
            goto L73
        L39:
            this.startToStart = ConstraintSet.access$100(r102, r105, this.startToStart);
            goto L73
        L40:
            this.startToEnd = ConstraintSet.access$100(r102, r105, this.startToEnd);
            goto L73
        L41:
            this.startMargin = r102.getDimensionPixelSize(r105, this.startMargin);
            goto L73
        L42:
            this.rightToRight = ConstraintSet.access$100(r102, r105, this.rightToRight);
            goto L73
        L43:
            this.rightToLeft = ConstraintSet.access$100(r102, r105, this.rightToLeft);
            goto L73
        L44:
            this.rightMargin = r102.getDimensionPixelSize(r105, this.rightMargin);
            goto L73
        L45:
            this.orientation = r102.getInt(r105, this.orientation);
            goto L73
        L46:
            this.leftToRight = ConstraintSet.access$100(r102, r105, this.leftToRight);
            goto L73
        L47:
            this.leftToLeft = ConstraintSet.access$100(r102, r105, this.leftToLeft);
            goto L73
        L48:
            this.leftMargin = r102.getDimensionPixelSize(r105, this.leftMargin);
            goto L73
        L49:
            this.mWidth = r102.getLayoutDimension(r105, this.mWidth);
            goto L73
        L50:
            this.mHeight = r102.getLayoutDimension(r105, this.mHeight);
            goto L73
        L51:
            this.horizontalBias = r102.getFloat(r105, this.horizontalBias);
            goto L73
        L52:
            this.guidePercent = r102.getFloat(r105, this.guidePercent);
            goto L73
        L53:
            this.guideEnd = r102.getDimensionPixelOffset(r105, this.guideEnd);
            goto L73
        L54:
            this.guideBegin = r102.getDimensionPixelOffset(r105, this.guideBegin);
            goto L73
        L55:
            this.goneTopMargin = r102.getDimensionPixelSize(r105, this.goneTopMargin);
            goto L73
        L56:
            this.goneStartMargin = r102.getDimensionPixelSize(r105, this.goneStartMargin);
            goto L73
        L57:
            this.goneRightMargin = r102.getDimensionPixelSize(r105, this.goneRightMargin);
            goto L73
        L58:
            this.goneLeftMargin = r102.getDimensionPixelSize(r105, this.goneLeftMargin);
            goto L73
        L59:
            this.goneEndMargin = r102.getDimensionPixelSize(r105, this.goneEndMargin);
            goto L73
        L60:
            this.goneBottomMargin = r102.getDimensionPixelSize(r105, this.goneBottomMargin);
            goto L73
        L61:
            this.endToStart = ConstraintSet.access$100(r102, r105, this.endToStart);
            goto L73
        L62:
            this.endToEnd = ConstraintSet.access$100(r102, r105, this.endToEnd);
            goto L73
        L63:
            this.endMargin = r102.getDimensionPixelSize(r105, this.endMargin);
            goto L73
        L64:
            this.editorAbsoluteY = r102.getDimensionPixelOffset(r105, this.editorAbsoluteY);
            goto L73
        L65:
            this.editorAbsoluteX = r102.getDimensionPixelOffset(r105, this.editorAbsoluteX);
            goto L73
        L66:
            this.dimensionRatio = r102.getString(r105);
            goto L73
        L67:
            this.bottomToTop = ConstraintSet.access$100(r102, r105, this.bottomToTop);
            goto L73
        L68:
            this.bottomToBottom = ConstraintSet.access$100(r102, r105, this.bottomToBottom);
            goto L73
        L69:
            this.bottomMargin = r102.getDimensionPixelSize(r105, this.bottomMargin);
            goto L73
        L70:
            this.baselineToBaseline = ConstraintSet.access$100(r102, r105, this.baselineToBaseline);
            goto L73
        L71:
            this.constrainedHeight = r102.getBoolean(r105, this.constrainedHeight);
            goto L73
        L74:
            r102.recycle();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Motion {
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 6;
        private static final int PATH_MOTION_ARC = 2;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public int mAnimateRelativeTo;
        public boolean mApply;
        public int mDrawPath;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;
        public String mTransitionEasing;

        static {
            SparseIntArray r100 = new SparseIntArray();
            mapToConstant = r100;
            r100.append(4, 1);
            mapToConstant.append(6, 2);
            mapToConstant.append(10, 3);
            mapToConstant.append(3, 4);
            mapToConstant.append(2, 5);
            mapToConstant.append(5, 6);
        }

        public Motion() {
            this.mApply = false;
            this.mAnimateRelativeTo = -1;
            this.mTransitionEasing = null;
            this.mPathMotionArc = -1;
            this.mDrawPath = 0;
            this.mMotionStagger = Float.NaN;
            this.mPathRotate = Float.NaN;
        }

        public void copyFrom(Motion r100) {
            this.mApply = r100.mApply;
            this.mAnimateRelativeTo = r100.mAnimateRelativeTo;
            this.mTransitionEasing = r100.mTransitionEasing;
            this.mPathMotionArc = r100.mPathMotionArc;
            this.mDrawPath = r100.mDrawPath;
            this.mPathRotate = r100.mPathRotate;
            this.mMotionStagger = r100.mMotionStagger;
        }

        public void fillFromAttributeList(Context r100, AttributeSet r101) {
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.animateCircleAngleTo, com.larus.nova.R.attr.animateRelativeTo, com.larus.nova.R.attr.animate_relativeTo, com.larus.nova.R.attr.drawPath, com.larus.nova.R.attr.motionPathRotate, com.larus.nova.R.attr.motionStagger, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.quantizeMotionInterpolator, com.larus.nova.R.attr.quantizeMotionPhase, com.larus.nova.R.attr.quantizeMotionSteps, com.larus.nova.R.attr.transitionEasing});
            this.mApply = true;
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L17;
            int r105 = r102.getIndex(r104);
            switch(mapToConstant.get(r105)) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L11;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L16;
            };
        L7:
            this.mMotionStagger = r102.getFloat(r105, this.mMotionStagger);
            goto L16
        L8:
            this.mAnimateRelativeTo = ConstraintSet.access$100(r102, r105, this.mAnimateRelativeTo);
            goto L16
        L9:
            this.mDrawPath = r102.getInt(r105, 0);
            goto L16
        L14:
            this.mPathMotionArc = r102.getInt(r105, this.mPathMotionArc);
            goto L16
        L15:
            this.mPathRotate = r102.getFloat(r105, this.mPathRotate);
            goto L16
        L11:
            if (r102.peekValue(r105).type != 3) goto L13;
            this.mTransitionEasing = r102.getString(r105);
            goto L16
        L13:
            this.mTransitionEasing = Easing.NAMED_EASING[r102.getInteger(r105, 0)];
        L16:
            r104 = r104 + 1;
            goto L3
        L17:
            r102.recycle();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class PropertySet {
        public float alpha;
        public boolean mApply;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public PropertySet() {
            this.mApply = false;
            this.visibility = 0;
            this.mVisibilityMode = 0;
            this.alpha = 1.0f;
            this.mProgress = Float.NaN;
        }

        public void copyFrom(PropertySet r100) {
            this.mApply = r100.mApply;
            this.visibility = r100.visibility;
            this.alpha = r100.alpha;
            this.mProgress = r100.mProgress;
            this.mVisibilityMode = r100.mVisibilityMode;
        }

        public void fillFromAttributeList(Context r100, AttributeSet r101) {
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.visibility, R.attr.alpha, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.visibilityMode});
            this.mApply = true;
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L16;
            int r105 = r102.getIndex(r104);
            if (r105 != 1) goto L7;
            this.alpha = r102.getFloat(r105, this.alpha);
        L15:
            r104 = r104 + 1;
            goto L3
        L7:
            if (r105 != 0) goto L10;
            this.visibility = r102.getInt(r105, this.visibility);
            this.visibility = ConstraintSet.access$200()[this.visibility];
            goto L15
        L10:
            if (r105 != 4) goto L13;
            this.mVisibilityMode = r102.getInt(r105, this.mVisibilityMode);
            goto L15
        L13:
            if (r105 != 3) goto L15;
            this.mProgress = r102.getFloat(r105, this.mProgress);
            goto L15
        L16:
            r102.recycle();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean applyElevation;
        public float elevation;
        public boolean mApply;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        static {
            SparseIntArray r100 = new SparseIntArray();
            mapToConstant = r100;
            r100.append(6, 1);
            mapToConstant.append(7, 2);
            mapToConstant.append(8, 3);
            mapToConstant.append(4, 4);
            mapToConstant.append(5, 5);
            mapToConstant.append(0, 6);
            mapToConstant.append(1, 7);
            mapToConstant.append(2, 8);
            mapToConstant.append(3, 9);
            mapToConstant.append(9, 10);
            mapToConstant.append(10, 11);
        }

        public Transform() {
            this.mApply = false;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = Float.NaN;
            this.transformPivotY = Float.NaN;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
        }

        public void copyFrom(Transform r100) {
            this.mApply = r100.mApply;
            this.rotation = r100.rotation;
            this.rotationX = r100.rotationX;
            this.rotationY = r100.rotationY;
            this.scaleX = r100.scaleX;
            this.scaleY = r100.scaleY;
            this.transformPivotX = r100.transformPivotX;
            this.transformPivotY = r100.transformPivotY;
            this.translationX = r100.translationX;
            this.translationY = r100.translationY;
            this.translationZ = r100.translationZ;
            this.applyElevation = r100.applyElevation;
            this.elevation = r100.elevation;
        }

        public void fillFromAttributeList(Context r100, AttributeSet r101) {
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.transformPivotTarget});
            this.mApply = true;
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L19;
            int r105 = r102.getIndex(r104);
            switch(mapToConstant.get(r105)) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L18;
            };
        L7:
            this.applyElevation = true;
            this.elevation = r102.getDimension(r105, this.elevation);
            goto L18
        L8:
            this.translationZ = r102.getDimension(r105, this.translationZ);
            goto L18
        L9:
            this.translationY = r102.getDimension(r105, this.translationY);
            goto L18
        L10:
            this.translationX = r102.getDimension(r105, this.translationX);
            goto L18
        L11:
            this.transformPivotY = r102.getDimension(r105, this.transformPivotY);
            goto L18
        L12:
            this.transformPivotX = r102.getDimension(r105, this.transformPivotX);
            goto L18
        L13:
            this.scaleY = r102.getFloat(r105, this.scaleY);
            goto L18
        L14:
            this.scaleX = r102.getFloat(r105, this.scaleX);
            goto L18
        L15:
            this.rotationY = r102.getFloat(r105, this.rotationY);
            goto L18
        L16:
            this.rotationX = r102.getFloat(r105, this.rotationX);
            goto L18
        L17:
            this.rotation = r102.getFloat(r105, this.rotation);
        L18:
            r104 = r104 + 1;
            goto L3
        L19:
            r102.recycle();
        }
    }

    static {
        VISIBILITY_FLAGS = new int[]{0, 4, 8};
        SparseIntArray r100 = new SparseIntArray();
        mapToConstant = r100;
        r100.append(83, 25);
        mapToConstant.append(84, 26);
        mapToConstant.append(86, 29);
        mapToConstant.append(87, 30);
        mapToConstant.append(93, 36);
        mapToConstant.append(92, 35);
        mapToConstant.append(64, 4);
        mapToConstant.append(63, 3);
        mapToConstant.append(59, 1);
        mapToConstant.append(102, 6);
        mapToConstant.append(103, 7);
        mapToConstant.append(71, 17);
        mapToConstant.append(72, 18);
        mapToConstant.append(73, 19);
        mapToConstant.append(0, 27);
        mapToConstant.append(88, 32);
        mapToConstant.append(89, 33);
        mapToConstant.append(70, 10);
        mapToConstant.append(69, 9);
        mapToConstant.append(107, 13);
        mapToConstant.append(110, 16);
        mapToConstant.append(108, 14);
        mapToConstant.append(105, 11);
        mapToConstant.append(109, 15);
        mapToConstant.append(106, 12);
        mapToConstant.append(96, 40);
        mapToConstant.append(81, 39);
        mapToConstant.append(80, 41);
        mapToConstant.append(95, 42);
        mapToConstant.append(79, 20);
        mapToConstant.append(94, 37);
        mapToConstant.append(68, 5);
        mapToConstant.append(82, 82);
        mapToConstant.append(91, 82);
        mapToConstant.append(85, 82);
        mapToConstant.append(62, 82);
        mapToConstant.append(58, 82);
        mapToConstant.append(5, 24);
        mapToConstant.append(7, 28);
        mapToConstant.append(23, 31);
        mapToConstant.append(24, 8);
        mapToConstant.append(6, 34);
        mapToConstant.append(8, 2);
        mapToConstant.append(3, 23);
        mapToConstant.append(4, 21);
        mapToConstant.append(2, 22);
        mapToConstant.append(13, 43);
        mapToConstant.append(26, 44);
        mapToConstant.append(21, 45);
        mapToConstant.append(22, 46);
        mapToConstant.append(20, 60);
        mapToConstant.append(18, 47);
        mapToConstant.append(19, 48);
        mapToConstant.append(14, 49);
        mapToConstant.append(15, 50);
        mapToConstant.append(16, 51);
        mapToConstant.append(17, 52);
        mapToConstant.append(25, 53);
        mapToConstant.append(98, 54);
        mapToConstant.append(75, 55);
        mapToConstant.append(99, 56);
        mapToConstant.append(76, 57);
        mapToConstant.append(100, 58);
        mapToConstant.append(77, 59);
        mapToConstant.append(65, 61);
        mapToConstant.append(67, 62);
        mapToConstant.append(66, 63);
        mapToConstant.append(29, 64);
        mapToConstant.append(122, 65);
        mapToConstant.append(36, 66);
        mapToConstant.append(123, 67);
        mapToConstant.append(114, 79);
        mapToConstant.append(1, 38);
        mapToConstant.append(113, 68);
        mapToConstant.append(101, 69);
        mapToConstant.append(78, 70);
        mapToConstant.append(33, 71);
        mapToConstant.append(31, 72);
        mapToConstant.append(32, 73);
        mapToConstant.append(34, 74);
        mapToConstant.append(30, 75);
        mapToConstant.append(115, 76);
        mapToConstant.append(90, 77);
        mapToConstant.append(124, 78);
        mapToConstant.append(57, 80);
        mapToConstant.append(56, 81);
    }

    private String sideToString(int r100) {
        switch(r100) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return "undefined";
    L5:
        return "end";
    L7:
        return "start";
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return "left";
    }

    public int[] getKnownIds() {
        int r100 = 0;
        Integer[] r101 = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int r102 = r101.length;
        int[] r103 = new int[r102];
    L3:
        if (r100 >= r102) goto L5;
        r103[r100] = r101[r100].intValue();
        r100 = r100 + 1;
        goto L3
    L5:
        return r103;
    }

    public ConstraintSet() {
        this.mSavedAttributes = new HashMap();
        this.mForceId = true;
        this.mConstraints = new HashMap();
    }

    public static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    private Constraint get(int r100) {
        if (this.mConstraints.containsKey(Integer.valueOf(r100)) == true) goto L6;
        this.mConstraints.put(Integer.valueOf(r100), new Constraint());
    L6:
        return this.mConstraints.get(Integer.valueOf(r100));
    }

    private static String[] splitString(String r100) {
        char[] r101 = r100.toCharArray();
        ArrayList r102 = new ArrayList();
        int r103 = 0;
        int r104 = 0;
        boolean r105 = false;
    L4:
        if (r103 >= r101.length) goto L13;
        char r106 = r101[r103];
        if (r106 != ',') goto L10;
        if (r105 == true) goto L10;
        r102.add(new String(r101, r104, r103 - r104));
        r104 = r103 + 1;
    L12:
        r103 = r103 + 1;
    L10:
        if (r106 != '\"') goto L12;
        r105 = !r105;
        goto L12
    L13:
        r102.add(new String(r101, r104, r101.length - r104));
        return (String[]) r102.toArray(new String[r102.size()]);
    }

    public void addColorAttributes(String... r100) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, r100);
    }

    public void addFloatAttributes(String... r100) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, r100);
    }

    public void addIntAttributes(String... r100) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, r100);
    }

    public void addStringAttributes(String... r100) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, r100);
    }

    public void applyCustomAttributes(ConstraintLayout r100) {
        int r101 = r100.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L18;
        View r103 = r100.getChildAt(r102);
        int r104 = r103.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r104)) == true) goto L8;
        Debug.getName(r103);
    L17:
        r102 = r102 + 1;
        goto L3
    L8:
        if (this.mForceId == false) goto L15;
        if (r104 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.mConstraints.containsKey(Integer.valueOf(r104)) == false) goto L17;
        ConstraintAttribute.setAttributes(r103, this.mConstraints.get(Integer.valueOf(r104)).mCustomConstraints);
        goto L17
    }

    public void applyTo(ConstraintLayout r100) {
        applyToInternal(r100, true);
        r100.setConstraintSet(null);
        r100.requestLayout();
    }

    public void applyToWithoutCustom(ConstraintLayout r100) {
        applyToInternal(r100, false);
        r100.setConstraintSet(null);
    }

    public void clear(int r100) {
        this.mConstraints.remove(Integer.valueOf(r100));
    }

    public void clone(ConstraintLayout r110) {
        int r100 = r110.getChildCount();
        this.mConstraints.clear();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L26;
        View r102 = r110.getChildAt(r101);
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102.getLayoutParams();
        int r104 = r102.getId();
        if (this.mForceId == false) goto L12;
        if (r104 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r104)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r104), new Constraint());
    L14:
        Constraint r105 = this.mConstraints.get(Integer.valueOf(r104));
        r105.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, r102);
        Constraint.access$000(r105, r104, r103);
        r105.propertySet.visibility = r102.getVisibility();
        r105.propertySet.alpha = r102.getAlpha();
        r105.transform.rotation = r102.getRotation();
        r105.transform.rotationX = r102.getRotationX();
        r105.transform.rotationY = r102.getRotationY();
        r105.transform.scaleX = r102.getScaleX();
        r105.transform.scaleY = r102.getScaleY();
        float r106 = r102.getPivotX();
        float r107 = r102.getPivotY();
        if (r106 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
    L18:
        Transform r108 = r105.transform;
        r108.transformPivotX = r106;
        r108.transformPivotY = r107;
    L19:
        r105.transform.translationX = r102.getTranslationX();
        r105.transform.translationY = r102.getTranslationY();
        r105.transform.translationZ = r102.getTranslationZ();
        Transform r109 = r105.transform;
        if (r109.applyElevation == false) goto L23;
        r109.elevation = r102.getElevation();
    L23:
        if ((r102 instanceof Barrier) == false) goto L25;
        Barrier r111 = (Barrier) r102;
        r105.layout.mBarrierAllowsGoneWidgets = r111.allowsGoneWidget();
        r105.layout.mReferenceIds = r111.getReferencedIds();
        r105.layout.mBarrierDirection = r111.getType();
        r105.layout.mBarrierMargin = r111.getMargin();
    L25:
        r101 = r101 + 1;
        goto L3
    L17:
        if (r107 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
    }

    public boolean getApplyElevation(int r100) {
        return get(r100).transform.applyElevation;
    }

    public Constraint getConstraint(int r100) {
        if (this.mConstraints.containsKey(Integer.valueOf(r100)) == true) goto L5;
        return null;
    L5:
        return this.mConstraints.get(Integer.valueOf(r100));
    }

    public int getHeight(int r100) {
        return get(r100).layout.mHeight;
    }

    public Constraint getParameters(int r100) {
        return get(r100);
    }

    public int[] getReferencedIds(int r100) {
        int[] r101 = get(r100).layout.mReferenceIds;
        if (r101 != null) goto L7;
        return new int[0];
    L7:
        return Arrays.copyOf(r101, r101.length);
    }

    public int getVisibility(int r100) {
        return get(r100).propertySet.visibility;
    }

    public int getVisibilityMode(int r100) {
        return get(r100).propertySet.mVisibilityMode;
    }

    public int getWidth(int r100) {
        return get(r100).layout.mWidth;
    }

    public void readFallback(ConstraintLayout r110) {
        int r100 = r110.getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L36;
        View r102 = r110.getChildAt(r101);
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102.getLayoutParams();
        int r104 = r102.getId();
        if (this.mForceId == false) goto L12;
        if (r104 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r104)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r104), new Constraint());
    L14:
        Constraint r105 = this.mConstraints.get(Integer.valueOf(r104));
        if (r105.layout.mApply == true) goto L22;
        Constraint.access$000(r105, r104, r103);
        if ((r102 instanceof ConstraintHelper) == false) goto L21;
        r105.layout.mReferenceIds = ((ConstraintHelper) r102).getReferencedIds();
        if ((r102 instanceof Barrier) == false) goto L21;
        Barrier r106 = (Barrier) r102;
        r105.layout.mBarrierAllowsGoneWidgets = r106.allowsGoneWidget();
        r105.layout.mBarrierDirection = r106.getType();
        r105.layout.mBarrierMargin = r106.getMargin();
    L21:
        r105.layout.mApply = true;
    L22:
        PropertySet r107 = r105.propertySet;
        if (r107.mApply == true) goto L25;
        r107.visibility = r102.getVisibility();
        r105.propertySet.alpha = r102.getAlpha();
        r105.propertySet.mApply = true;
    L25:
        Transform r108 = r105.transform;
        if (r108.mApply == true) goto L35;
        r108.mApply = true;
        r108.rotation = r102.getRotation();
        r105.transform.rotationX = r102.getRotationX();
        r105.transform.rotationY = r102.getRotationY();
        r105.transform.scaleX = r102.getScaleX();
        r105.transform.scaleY = r102.getScaleY();
        float r109 = r102.getPivotX();
        float r111 = r102.getPivotY();
        if (r109 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L30;
    L31:
        Transform r112 = r105.transform;
        r112.transformPivotX = r109;
        r112.transformPivotY = r111;
    L32:
        r105.transform.translationX = r102.getTranslationX();
        r105.transform.translationY = r102.getTranslationY();
        r105.transform.translationZ = r102.getTranslationZ();
        Transform r113 = r105.transform;
        if (r113.applyElevation == false) goto L35;
        r113.elevation = r102.getElevation();
        goto L35
    L30:
        if (r111 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
    L35:
        r101 = r101 + 1;
        goto L3
    }

    public void removeAttribute(String r100) {
        this.mSavedAttributes.remove(r100);
    }

    public void removeFromHorizontalChain(int r100) {
        if (this.mConstraints.containsKey(Integer.valueOf(r100)) == false) goto L36;
        Layout r101 = this.mConstraints.get(Integer.valueOf(r100)).layout;
        int r102 = r101.leftToRight;
        int r103 = r101.rightToLeft;
        if (r102 != (-1)) goto L23;
        if (r103 != (-1)) goto L23;
        int r104 = r101.startToEnd;
        int r105 = r101.endToStart;
        if (r104 != (-1)) goto L11;
        if (r105 != (-1)) goto L11;
    L22:
        clear(r100, 6);
        clear(r100, 7);
        return;
    L11:
        if (r104 == (-1)) goto L14;
        if (r105 == (-1)) goto L14;
        connect(r104, 7, r105, 6, 0);
        connect(r105, 6, r102, 7, 0);
    L14:
        if (r102 != (-1)) goto L16;
        if (r105 == (-1)) goto L22;
    L16:
        int r106 = r101.rightToRight;
        if (r106 == (-1)) goto L19;
        connect(r102, 7, r106, 7, 0);
        goto L22
    L19:
        int r107 = r101.leftToLeft;
        if (r107 == (-1)) goto L22;
        connect(r105, 6, r107, 6, 0);
    L23:
        if (r102 == (-1)) goto L26;
        if (r103 == (-1)) goto L26;
        connect(r102, 2, r103, 1, 0);
        connect(r103, 1, r102, 2, 0);
    L34:
        clear(r100, 1);
        clear(r100, 2);
        return;
    L26:
        if (r102 != (-1)) goto L28;
        if (r103 == (-1)) goto L34;
    L28:
        int r108 = r101.rightToRight;
        if (r108 == (-1)) goto L31;
        connect(r102, 2, r108, 2, 0);
        goto L34
    L31:
        int r109 = r101.leftToLeft;
        if (r109 == (-1)) goto L34;
        connect(r103, 1, r109, 1, 0);
        goto L34
    }

    public void removeFromVerticalChain(int r110) {
        if (this.mConstraints.containsKey(Integer.valueOf(r110)) == false) goto L18;
        Layout r100 = this.mConstraints.get(Integer.valueOf(r110)).layout;
        int r101 = r100.topToBottom;
        int r102 = r100.bottomToTop;
        if (r101 != (-1)) goto L7;
        if (r102 == (-1)) goto L18;
    L7:
        if (r101 == (-1)) goto L10;
        if (r102 == (-1)) goto L10;
        connect(r101, 4, r102, 3, 0);
        connect(r102, 3, r101, 4, 0);
    L10:
        if (r101 != (-1)) goto L12;
        if (r102 == (-1)) goto L18;
    L12:
        int r103 = r100.bottomToBottom;
        if (r103 == (-1)) goto L15;
        connect(r101, 4, r103, 4, 0);
        goto L18
    L15:
        int r104 = r100.topToTop;
        if (r104 == (-1)) goto L18;
        connect(r102, 3, r104, 3, 0);
    L18:
        clear(r110, 3);
        clear(r110, 4);
    }

    public void setForceId(boolean r100) {
        this.mForceId = r100;
    }

    public void setValidateOnParse(boolean r100) {
        this.mValidate = r100;
    }

    public void clone(Constraints r100) {
        int r101 = r100.getChildCount();
        this.mConstraints.clear();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L18;
        View r103 = r100.getChildAt(r102);
        Constraints.LayoutParams r104 = (Constraints.LayoutParams) r103.getLayoutParams();
        int r105 = r103.getId();
        if (this.mForceId == false) goto L12;
        if (r105 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r105)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r105), new Constraint());
    L14:
        Constraint r106 = this.mConstraints.get(Integer.valueOf(r105));
        if ((r103 instanceof ConstraintHelper) == false) goto L17;
        Constraint.access$300(r106, (ConstraintHelper) r103, r105, r104);
    L17:
        Constraint.access$400(r106, r105, r104);
        r102 = r102 + 1;
        goto L3
    }

    public void readFallback(ConstraintSet r100) {
        Iterator<Integer> r101 = r100.mConstraints.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L26;
        Integer r102 = r101.next();
        int r103 = r102.intValue();
        Constraint r104 = r100.mConstraints.get(r102);
        if (this.mConstraints.containsKey(Integer.valueOf(r103)) == true) goto L8;
        this.mConstraints.put(Integer.valueOf(r103), new Constraint());
    L8:
        Constraint r105 = this.mConstraints.get(Integer.valueOf(r103));
        Layout r106 = r105.layout;
        if (r106.mApply == true) goto L11;
        r106.copyFrom(r104.layout);
    L11:
        PropertySet r107 = r105.propertySet;
        if (r107.mApply == true) goto L14;
        r107.copyFrom(r104.propertySet);
    L14:
        Transform r108 = r105.transform;
        if (r108.mApply == true) goto L17;
        r108.copyFrom(r104.transform);
    L17:
        Motion r109 = r105.motion;
        if (r109.mApply == true) goto L20;
        r109.copyFrom(r104.motion);
    L20:
        Iterator<String> r110 = r104.mCustomConstraints.keySet().iterator();
    L22:
        if (r110.hasNext() == false) goto L4;
        String r111 = r110.next();
        if (r105.mCustomConstraints.containsKey(r111) == true) goto L22;
        r105.mCustomConstraints.put(r111, r104.mCustomConstraints.get(r111));
        goto L22
    }

    public void clone(ConstraintSet r100) {
        this.mConstraints.clear();
        Iterator<Integer> r101 = r100.mConstraints.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Integer r102 = r101.next();
        this.mConstraints.put(r102, r100.mConstraints.get(r102).clone());
        goto L4
    }

    private void addAttributes(ConstraintAttribute.AttributeType r100, String... r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L14;
        if (this.mSavedAttributes.containsKey(r101[r102]) == false) goto L12;
        ConstraintAttribute r103 = this.mSavedAttributes.get(r101[r102]);
        if (r103.getType() == r100) goto L13;
        throw new IllegalArgumentException("ConstraintAttribute is already a " + r103.getType().name());
    L13:
        r102 = r102 + 1;
        goto L4
    L12:
        this.mSavedAttributes.put(r101[r102], new ConstraintAttribute(r101[r102], r100));
        goto L13
    }

    private int[] convertReferenceString(View r110, String r111) {
        String[] r112 = r111.split(",");
        Context r100 = r110.getContext();
        int[] r101 = new int[r112.length];
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r112.length) goto L23;
        String r104 = r112[r102].trim();
        int r105 = R$id.class.getField(r104).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r105 != 0) goto L11;
        r105 = r100.getResources().getIdentifier(r104, "id", r100.getPackageName());
    L11:
        if (r105 != 0) goto L21;
        if (r110.isInEditMode() == false) goto L21;
        if ((r110.getParent() instanceof ConstraintLayout) == false) goto L21;
        Object r106 = ((ConstraintLayout) r110.getParent()).getDesignInformation(0, r104);
        if (r106 == null) goto L21;
        if ((r106 instanceof Integer) == false) goto L21;
        r105 = ((Integer) r106).intValue();
    L21:
        r101[r103] = r105;
        r102 = r102 + 1;
        r103 = r103 + 1;
    L8:
        r105 = 0;
        goto L9
    L23:
        if (r103 != r112.length) goto L25;
        return r101;
    L25:
        return Arrays.copyOf(r101, r103);
    }

    private Constraint fillFromAttributeList(Context r100, AttributeSet r101) {
        Constraint r102 = new Constraint();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.animateCircleAngleTo, com.larus.nova.R.attr.animateRelativeTo, com.larus.nova.R.attr.animate_relativeTo, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.drawPath, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_wrapBehaviorInParent, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionStagger, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.pivotAnchor, com.larus.nova.R.attr.polarRelativeTo, com.larus.nova.R.attr.quantizeMotionInterpolator, com.larus.nova.R.attr.quantizeMotionPhase, com.larus.nova.R.attr.quantizeMotionSteps, com.larus.nova.R.attr.transformPivotTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate, com.larus.nova.R.attr.visibilityMode});
        populateConstraint(r100, r102, r103);
        r103.recycle();
        return r102;
    }

    public void applyToInternal(ConstraintLayout r110, boolean r111) {
        int r100 = r110.getChildCount();
        HashSet r101 = new HashSet(this.mConstraints.keySet());
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L48;
        View r103 = r110.getChildAt(r102);
        int r104 = r103.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r104)) == true) goto L9;
        Debug.getName(r103);
    L47:
        r102 = r102 + 1;
        goto L4
    L9:
        if (this.mForceId == false) goto L14;
        if (r104 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r104 == (-1)) goto L47;
        if (this.mConstraints.containsKey(Integer.valueOf(r104)) == false) goto L47;
        r101.remove(Integer.valueOf(r104));
        Constraint r105 = this.mConstraints.get(Integer.valueOf(r104));
        if ((r103 instanceof Barrier) == false) goto L21;
        r105.layout.mHelperType = 1;
    L21:
        int r106 = r105.layout.mHelperType;
        if (r106 == (-1)) goto L31;
        if (r106 != 1) goto L31;
        Barrier r107 = (Barrier) r103;
        r107.setId(r104);
        r107.setType(r105.layout.mBarrierDirection);
        r107.setMargin(r105.layout.mBarrierMargin);
        r107.setAllowsGoneWidget(r105.layout.mBarrierAllowsGoneWidgets);
        Layout r108 = r105.layout;
        int[] r109 = r108.mReferenceIds;
        if (r109 == null) goto L28;
        r107.setReferencedIds(r109);
        goto L31
    L28:
        String r112 = r108.mReferenceIdString;
        if (r112 == null) goto L31;
        r108.mReferenceIds = convertReferenceString(r107, r112);
        r107.setReferencedIds(r105.layout.mReferenceIds);
    L31:
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r103.getLayoutParams();
        r113.validate();
        r105.applyTo(r113);
        if (r111 == false) goto L34;
        ConstraintAttribute.setAttributes(r103, r105.mCustomConstraints);
    L34:
        r103.setLayoutParams(r113);
        PropertySet r114 = r105.propertySet;
        if (r114.mVisibilityMode != 0) goto L37;
        r103.setVisibility(r114.visibility);
    L37:
        r103.setAlpha(r105.propertySet.alpha);
        r103.setRotation(r105.transform.rotation);
        r103.setRotationX(r105.transform.rotationX);
        r103.setRotationY(r105.transform.rotationY);
        r103.setScaleX(r105.transform.scaleX);
        r103.setScaleY(r105.transform.scaleY);
        if (Float.isNaN(r105.transform.transformPivotX) == true) goto L41;
        r103.setPivotX(r105.transform.transformPivotX);
    L41:
        if (Float.isNaN(r105.transform.transformPivotY) == true) goto L43;
        r103.setPivotY(r105.transform.transformPivotY);
    L43:
        r103.setTranslationX(r105.transform.translationX);
        r103.setTranslationY(r105.transform.translationY);
        r103.setTranslationZ(r105.transform.translationZ);
        Transform r115 = r105.transform;
        if (r115.applyElevation == false) goto L47;
        r103.setElevation(r115.elevation);
        goto L47
    L48:
        Iterator r116 = r101.iterator();
    L50:
        if (r116.hasNext() == false) goto L65;
        Integer r117 = (Integer) r116.next();
        Constraint r118 = this.mConstraints.get(r117);
        int r119 = r118.layout.mHelperType;
        if (r119 == (-1)) goto L63;
        if (r119 != 1) goto L63;
        Barrier r120 = new Barrier(r110.getContext());
        r120.setId(r117.intValue());
        Layout r121 = r118.layout;
        int[] r122 = r121.mReferenceIds;
        if (r122 == null) goto L58;
        r120.setReferencedIds(r122);
    L61:
        r120.setType(r118.layout.mBarrierDirection);
        r120.setMargin(r118.layout.mBarrierMargin);
        ConstraintLayout.LayoutParams r123 = r110.generateDefaultLayoutParams();
        r120.validateParams();
        r118.applyTo(r123);
        r110.addView(r120, r123);
        goto L63
    L58:
        String r124 = r121.mReferenceIdString;
        if (r124 == null) goto L61;
        r121.mReferenceIds = convertReferenceString(r120, r124);
        r120.setReferencedIds(r118.layout.mReferenceIds);
    L63:
        if (r118.layout.mIsGuideline == false) goto L50;
        View r125 = new Guideline(r110.getContext());
        r125.setId(r117.intValue());
        ConstraintLayout.LayoutParams r126 = r110.generateDefaultLayoutParams();
        r118.applyTo(r126);
        r110.addView(r125, r126);
        goto L50
    }

    public void applyToLayoutParams(int r100, ConstraintLayout.LayoutParams r101) {
        if (this.mConstraints.containsKey(Integer.valueOf(r100)) == false) goto L6;
        this.mConstraints.get(Integer.valueOf(r100)).applyTo(r101);
        return;
    }

    public void centerHorizontally(int r110, int r111) {
        if (r111 != 0) goto L4;
        center(r110, 0, 1, 0, 0, 2, 0, 0.5f);
        return;
    L4:
        center(r110, r111, 2, 0, r111, 1, 0, 0.5f);
    }

    public void centerHorizontallyRtl(int r110, int r111) {
        if (r111 != 0) goto L4;
        center(r110, 0, 6, 0, 0, 7, 0, 0.5f);
        return;
    L4:
        center(r110, r111, 7, 0, r111, 6, 0, 0.5f);
    }

    public void centerVertically(int r110, int r111) {
        if (r111 != 0) goto L4;
        center(r110, 0, 3, 0, 0, 4, 0, 0.5f);
        return;
    L4:
        center(r110, r111, 4, 0, r111, 3, 0, 0.5f);
    }

    public void clear(int r100, int r101) {
        if (this.mConstraints.containsKey(Integer.valueOf(r100)) == false) goto L16;
        Constraint r102 = this.mConstraints.get(Integer.valueOf(r100));
        switch(r101) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        Layout r103 = r102.layout;
        r103.endToStart = -1;
        r103.endToEnd = -1;
        r103.endMargin = -1;
        r103.goneEndMargin = -1;
        return;
    L9:
        Layout r104 = r102.layout;
        r104.startToEnd = -1;
        r104.startToStart = -1;
        r104.startMargin = -1;
        r104.goneStartMargin = -1;
        return;
    L10:
        r102.layout.baselineToBaseline = -1;
        return;
    L11:
        Layout r105 = r102.layout;
        r105.bottomToTop = -1;
        r105.bottomToBottom = -1;
        r105.bottomMargin = -1;
        r105.goneBottomMargin = -1;
        return;
    L12:
        Layout r106 = r102.layout;
        r106.topToBottom = -1;
        r106.topToTop = -1;
        r106.topMargin = -1;
        r106.goneTopMargin = -1;
        return;
    L13:
        Layout r107 = r102.layout;
        r107.rightToRight = -1;
        r107.rightToLeft = -1;
        r107.rightMargin = -1;
        r107.goneRightMargin = -1;
        return;
    L14:
        Layout r108 = r102.layout;
        r108.leftToRight = -1;
        r108.leftToLeft = -1;
        r108.leftMargin = -1;
        r108.goneLeftMargin = -1;
        return;
    L7:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void clone(Context r100, int r101) {
        clone((ConstraintLayout) LayoutInflater.from(r100).inflate(r101, null));
    }

    public void constrainDefaultHeight(int r100, int r101) {
        get(r100).layout.heightDefault = r101;
    }

    public void constrainDefaultWidth(int r100, int r101) {
        get(r100).layout.widthDefault = r101;
    }

    public void constrainHeight(int r100, int r101) {
        get(r100).layout.mHeight = r101;
    }

    public void constrainMaxHeight(int r100, int r101) {
        get(r100).layout.heightMax = r101;
    }

    public void constrainMaxWidth(int r100, int r101) {
        get(r100).layout.widthMax = r101;
    }

    public void constrainMinHeight(int r100, int r101) {
        get(r100).layout.heightMin = r101;
    }

    public void constrainMinWidth(int r100, int r101) {
        get(r100).layout.widthMin = r101;
    }

    public void constrainPercentHeight(int r100, float r101) {
        get(r100).layout.heightPercent = r101;
    }

    public void constrainPercentWidth(int r100, float r101) {
        get(r100).layout.widthPercent = r101;
    }

    public void constrainWidth(int r100, int r101) {
        get(r100).layout.mWidth = r101;
    }

    public void constrainedHeight(int r100, boolean r101) {
        get(r100).layout.constrainedHeight = r101;
    }

    public void constrainedWidth(int r100, boolean r101) {
        get(r100).layout.constrainedWidth = r101;
    }

    public void create(int r100, int r101) {
        Layout r102 = get(r100).layout;
        r102.mIsGuideline = true;
        r102.orientation = r101;
    }

    public void dump(MotionScene r100, int... r101) {
        Set<Integer> r102 = this.mConstraints.keySet();
        int r103 = 0;
        if (r101.length == 0) goto L7;
        HashSet r104 = new HashSet();
        int r105 = r101.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L8;
        r104.add(Integer.valueOf(r101[r106]));
        r106 = r106 + 1;
    L8:
        System.out.println(r104.size() + " constraints");
        StringBuilder r107 = new StringBuilder();
        Integer[] r108 = (Integer[]) r104.toArray(new Integer[0]);
        int r109 = r108.length;
    L9:
        if (r103 >= r109) goto L11;
        Integer r110 = r108[r103];
        Constraint r111 = this.mConstraints.get(r110);
        r107.append("<Constraint id=");
        r107.append(r110);
        r107.append(" \n");
        r111.layout.dump(r100, r107);
        r107.append("/>\n");
        r103 = r103 + 1;
        goto L9
    L11:
        System.out.println(r107.toString());
        return;
    L7:
        r104 = new HashSet(r102);
        goto L8
    }

    public void load(Context r100, XmlPullParser r110) {
        int r101 = r110.getEventType();     // Catch: IOException -> L75 XmlPullParserException -> L77
        Constraint r102 = null;
    L5:
        if (r101 == 1) goto L100;
        if (r101 == 0) goto L72;
        byte r103 = 3;
        if (r101 == 2) goto L17;
        if (r101 != 3) goto L73;
        String r104 = r110.getName();     // Catch: IOException -> L75 XmlPullParserException -> L77
        if (TAG.equals(r104) == true) goto L13;
        if (r104.equalsIgnoreCase("Constraint") == false) goto L73;
        this.mConstraints.put(Integer.valueOf(r102.mViewId), r102);     // Catch: IOException -> L75 XmlPullParserException -> L77
        r102 = null;
        goto L73
    L13:
        return;
    L73:
        r101 = r110.next();     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L5
    L17:
        String r105 = r110.getName();     // Catch: IOException -> L75 XmlPullParserException -> L77
        switch(r105.hashCode()) {
            case -2025855158: goto L42;
            case -1984451626: goto L39;
            case -1269513683: goto L36;
            case -1238332596: goto L33;
            case -71750448: goto L30;
            case 1331510167: goto L27;
            case 1791837707: goto L24;
            case 1803088381: goto L21;
            default: goto L44;
        };     // Catch: IOException -> L75 XmlPullParserException -> L77
    L44:
        r103 = -1;
    L46:
        switch(r103) {
            case 0: goto L70;
            case 1: goto L69;
            case 2: goto L68;
            case 3: goto L64;
            case 4: goto L60;
            case 5: goto L56;
            case 6: goto L52;
            case 7: goto L48;
            default: goto L73;
        };
    L48:
        if (r102 == null) goto L51;
        ConstraintAttribute.parse(r100, r110, r102.mCustomConstraints);     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L73
    L51:
        throw new RuntimeException(ERROR_MESSAGE + r110.getLineNumber());     // Catch: IOException -> L75 XmlPullParserException -> L77
    L52:
        if (r102 == null) goto L55;
        r102.motion.fillFromAttributeList(r100, Xml.asAttributeSet(r110));     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L73
    L55:
        throw new RuntimeException(ERROR_MESSAGE + r110.getLineNumber());     // Catch: IOException -> L75 XmlPullParserException -> L77
    L56:
        if (r102 == null) goto L59;
        r102.layout.fillFromAttributeList(r100, Xml.asAttributeSet(r110));     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L73
    L59:
        throw new RuntimeException(ERROR_MESSAGE + r110.getLineNumber());     // Catch: IOException -> L75 XmlPullParserException -> L77
    L60:
        if (r102 == null) goto L63;
        r102.transform.fillFromAttributeList(r100, Xml.asAttributeSet(r110));     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L73
    L63:
        throw new RuntimeException(ERROR_MESSAGE + r110.getLineNumber());     // Catch: IOException -> L75 XmlPullParserException -> L77
    L64:
        if (r102 == null) goto L67;
        r102.propertySet.fillFromAttributeList(r100, Xml.asAttributeSet(r110));     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L73
    L67:
        throw new RuntimeException(ERROR_MESSAGE + r110.getLineNumber());     // Catch: IOException -> L75 XmlPullParserException -> L77
    L68:
        Constraint r106 = fillFromAttributeList(r100, Xml.asAttributeSet(r110));     // Catch: IOException -> L75 XmlPullParserException -> L77
        r106.layout.mHelperType = 1;     // Catch: IOException -> L75 XmlPullParserException -> L77
    L71:
        r102 = r106;
        goto L73
    L69:
        r106 = fillFromAttributeList(r100, Xml.asAttributeSet(r110));     // Catch: IOException -> L75 XmlPullParserException -> L77
        Layout r107 = r106.layout;     // Catch: IOException -> L75 XmlPullParserException -> L77
        r107.mIsGuideline = true;     // Catch: IOException -> L75 XmlPullParserException -> L77
        r107.mApply = true;     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L71
    L70:
        r106 = fillFromAttributeList(r100, Xml.asAttributeSet(r110));     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L71
    L21:
        if (r105.equals("Constraint") == false) goto L44;
        r103 = 0;
        goto L46
    L24:
        if (r105.equals("CustomAttribute") == false) goto L44;
        r103 = 7;
        goto L46
    L27:
        if (r105.equals("Barrier") == false) goto L44;
        r103 = 2;
        goto L46
    L30:
        if (r105.equals("Guideline") == false) goto L44;
        r103 = 1;
        goto L46
    L33:
        if (r105.equals("Transform") == false) goto L44;
        r103 = 4;
        goto L46
    L36:
        if (r105.equals("PropertySet") == false) goto L44;
    L39:
        if (r105.equals("Motion") == false) goto L44;
        r103 = 6;
        goto L46
    L42:
        if (r105.equals("Layout") == false) goto L44;
        r103 = 5;
        goto L46
    L72:
        r110.getName();     // Catch: IOException -> L75 XmlPullParserException -> L77
        goto L73
    L100:
        return;
    L75:
        e = move-exception;
        e.printStackTrace();
        return;
    L77:
        e = move-exception;
        e.printStackTrace();
    }

    public void parseColorAttributes(Constraint r100, String r101) {
        String[] r102 = r101.split(",");
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L10;
        String[] r104 = r102[r103].split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r104.length == 2) goto L8;
        String r105 = r102[r103];
    L9:
        r103 = r103 + 1;
        goto L4
    L8:
        Constraint.access$600(r100, r104[0], ColorProtector.parseColor(r104[1]));
        goto L9
    }

    public void parseFloatAttributes(Constraint r100, String r101) {
        String[] r102 = r101.split(",");
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L10;
        String[] r104 = r102[r103].split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r104.length == 2) goto L8;
        String r105 = r102[r103];
    L9:
        r103 = r103 + 1;
        goto L4
    L8:
        Constraint.access$700(r100, r104[0], CastFloatProtector.parseFloat(r104[1]));
        goto L9
    }

    public void parseIntAttributes(Constraint r100, String r101) {
        String[] r102 = r101.split(",");
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L10;
        String[] r104 = r102[r103].split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r104.length == 2) goto L8;
        String r105 = r102[r103];
    L9:
        r103 = r103 + 1;
        goto L4
    L8:
        Constraint.access$700(r100, r104[0], Integer.decode(r104[1]).intValue());
        goto L9
    }

    public void parseStringAttributes(Constraint r100, String r101) {
        String[] r102 = splitString(r101);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L6;
        String[] r104 = r102[r103].split(ContainerUtils.KEY_VALUE_DELIMITER);
        String r105 = r102[r103];
        Constraint.access$800(r100, r104[0], r104[1]);
        r103 = r103 + 1;
        goto L4
    }

    public void setAlpha(int r100, float r101) {
        get(r100).propertySet.alpha = r101;
    }

    public void setApplyElevation(int r100, boolean r101) {
        get(r100).transform.applyElevation = r101;
    }

    public void setBarrierType(int r100, int r101) {
        get(r100).layout.mHelperType = r101;
    }

    public void setDimensionRatio(int r100, String r101) {
        get(r100).layout.dimensionRatio = r101;
    }

    public void setEditorAbsoluteX(int r100, int r101) {
        get(r100).layout.editorAbsoluteX = r101;
    }

    public void setEditorAbsoluteY(int r100, int r101) {
        get(r100).layout.editorAbsoluteY = r101;
    }

    public void setElevation(int r100, float r101) {
        get(r100).transform.elevation = r101;
        get(r100).transform.applyElevation = true;
    }

    public void setGuidelineBegin(int r100, int r101) {
        get(r100).layout.guideBegin = r101;
        get(r100).layout.guideEnd = -1;
        get(r100).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int r100, int r101) {
        get(r100).layout.guideEnd = r101;
        get(r100).layout.guideBegin = -1;
        get(r100).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int r100, float r101) {
        get(r100).layout.guidePercent = r101;
        get(r100).layout.guideEnd = -1;
        get(r100).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int r100, float r101) {
        get(r100).layout.horizontalBias = r101;
    }

    public void setHorizontalChainStyle(int r100, int r101) {
        get(r100).layout.horizontalChainStyle = r101;
    }

    public void setHorizontalWeight(int r100, float r101) {
        get(r100).layout.horizontalWeight = r101;
    }

    public void setReferencedIds(int r100, int... r101) {
        get(r100).layout.mReferenceIds = r101;
    }

    public void setRotation(int r100, float r101) {
        get(r100).transform.rotation = r101;
    }

    public void setRotationX(int r100, float r101) {
        get(r100).transform.rotationX = r101;
    }

    public void setRotationY(int r100, float r101) {
        get(r100).transform.rotationY = r101;
    }

    public void setScaleX(int r100, float r101) {
        get(r100).transform.scaleX = r101;
    }

    public void setScaleY(int r100, float r101) {
        get(r100).transform.scaleY = r101;
    }

    public void setTransformPivotX(int r100, float r101) {
        get(r100).transform.transformPivotX = r101;
    }

    public void setTransformPivotY(int r100, float r101) {
        get(r100).transform.transformPivotY = r101;
    }

    public void setTranslationX(int r100, float r101) {
        get(r100).transform.translationX = r101;
    }

    public void setTranslationY(int r100, float r101) {
        get(r100).transform.translationY = r101;
    }

    public void setTranslationZ(int r100, float r101) {
        get(r100).transform.translationZ = r101;
    }

    public void setVerticalBias(int r100, float r101) {
        get(r100).layout.verticalBias = r101;
    }

    public void setVerticalChainStyle(int r100, int r101) {
        get(r100).layout.verticalChainStyle = r101;
    }

    public void setVerticalWeight(int r100, float r101) {
        get(r100).layout.verticalWeight = r101;
    }

    public void setVisibility(int r100, int r101) {
        get(r100).propertySet.visibility = r101;
    }

    public void setVisibilityMode(int r100, int r101) {
        get(r100).propertySet.mVisibilityMode = r101;
    }

    public void load(Context r100, int r101) {
        XmlResourceParser r102 = r100.getResources().getXml(r101);
        int r103 = r102.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L5:
        if (r103 == 1) goto L30;
        if (r103 != 0) goto L8;
        r102.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L15:
        r103 = r102.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L8:
        if (r103 != 2) goto L15;
        String r104 = r102.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        Constraint r105 = fillFromAttributeList(r100, Xml.asAttributeSet(r102));     // Catch: IOException -> L17 XmlPullParserException -> L19
        if (r104.equalsIgnoreCase("Guideline") == false) goto L13;
        r105.layout.mIsGuideline = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
    L13:
        this.mConstraints.put(Integer.valueOf(r105.mViewId), r105);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L15
    L30:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ int access$100(TypedArray r100, int r101, int r102) {
        return lookupID(r100, r101, r102);
    }

    private static int lookupID(TypedArray r100, int r101, int r102) {
        int r103 = r100.getResourceId(r101, r102);
        if (r103 == (-1)) goto L5;
        return r103;
    L5:
        return r100.getInt(r101, -1);
    }

    private void populateConstraint(Context r100, Constraint r101, TypedArray r102) {
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L99;
        int r105 = r102.getIndex(r104);
        if (r105 == 1) goto L12;
        if (23 == r105) goto L12;
        if (24 == r105) goto L12;
        r101.motion.mApply = true;
        r101.layout.mApply = true;
        r101.propertySet.mApply = true;
        r101.transform.mApply = true;
    L12:
        switch(mapToConstant.get(r105)) {
            case 1: goto L97;
            case 2: goto L96;
            case 3: goto L95;
            case 4: goto L94;
            case 5: goto L93;
            case 6: goto L92;
            case 7: goto L91;
            case 8: goto L90;
            case 9: goto L89;
            case 10: goto L88;
            case 11: goto L87;
            case 12: goto L86;
            case 13: goto L85;
            case 14: goto L84;
            case 15: goto L83;
            case 16: goto L82;
            case 17: goto L81;
            case 18: goto L80;
            case 19: goto L79;
            case 20: goto L78;
            case 21: goto L77;
            case 22: goto L76;
            case 23: goto L75;
            case 24: goto L74;
            case 25: goto L73;
            case 26: goto L72;
            case 27: goto L71;
            case 28: goto L70;
            case 29: goto L69;
            case 30: goto L68;
            case 31: goto L67;
            case 32: goto L66;
            case 33: goto L65;
            case 34: goto L64;
            case 35: goto L63;
            case 36: goto L62;
            case 37: goto L61;
            case 38: goto L60;
            case 39: goto L59;
            case 40: goto L58;
            case 41: goto L57;
            case 42: goto L56;
            case 43: goto L55;
            case 44: goto L54;
            case 45: goto L53;
            case 46: goto L52;
            case 47: goto L51;
            case 48: goto L50;
            case 49: goto L49;
            case 50: goto L48;
            case 51: goto L47;
            case 52: goto L46;
            case 53: goto L45;
            case 54: goto L44;
            case 55: goto L43;
            case 56: goto L42;
            case 57: goto L41;
            case 58: goto L40;
            case 59: goto L39;
            case 60: goto L38;
            case 61: goto L37;
            case 62: goto L36;
            case 63: goto L35;
            case 64: goto L34;
            case 65: goto L31;
            case 66: goto L29;
            case 67: goto L28;
            case 68: goto L27;
            case 69: goto L26;
            case 70: goto L25;
            case 71: goto L98;
            case 72: goto L24;
            case 73: goto L23;
            case 74: goto L22;
            case 75: goto L21;
            case 76: goto L20;
            case 77: goto L19;
            case 78: goto L18;
            case 79: goto L17;
            case 80: goto L16;
            case 81: goto L15;
            case 82: goto L14;
            default: goto L13;
        };
    L13:
        Integer.toHexString(r105);
        mapToConstant.get(r105);
        goto L98
    L14:
        Integer.toHexString(r105);
        mapToConstant.get(r105);
        goto L98
    L15:
        Layout r106 = r101.layout;
        r106.constrainedHeight = r102.getBoolean(r105, r106.constrainedHeight);
        goto L98
    L16:
        Layout r107 = r101.layout;
        r107.constrainedWidth = r102.getBoolean(r105, r107.constrainedWidth);
        goto L98
    L17:
        Motion r108 = r101.motion;
        r108.mMotionStagger = r102.getFloat(r105, r108.mMotionStagger);
        goto L98
    L18:
        PropertySet r109 = r101.propertySet;
        r109.mVisibilityMode = r102.getInt(r105, r109.mVisibilityMode);
        goto L98
    L19:
        Layout r110 = r101.layout;
        r110.mConstraintTag = r102.getString(r105);
        goto L98
    L20:
        Motion r111 = r101.motion;
        r111.mPathMotionArc = r102.getInt(r105, r111.mPathMotionArc);
        goto L98
    L21:
        Layout r112 = r101.layout;
        r112.mBarrierAllowsGoneWidgets = r102.getBoolean(r105, r112.mBarrierAllowsGoneWidgets);
        goto L98
    L22:
        Layout r113 = r101.layout;
        r113.mReferenceIdString = r102.getString(r105);
        goto L98
    L23:
        Layout r114 = r101.layout;
        r114.mBarrierMargin = r102.getDimensionPixelSize(r105, r114.mBarrierMargin);
        goto L98
    L24:
        Layout r115 = r101.layout;
        r115.mBarrierDirection = r102.getInt(r105, r115.mBarrierDirection);
        goto L98
    L25:
        Layout r116 = r101.layout;
        r116.heightPercent = r102.getFloat(r105, 1.0f);
        goto L98
    L26:
        Layout r117 = r101.layout;
        r117.widthPercent = r102.getFloat(r105, 1.0f);
        goto L98
    L27:
        PropertySet r118 = r101.propertySet;
        r118.mProgress = r102.getFloat(r105, r118.mProgress);
        goto L98
    L28:
        Motion r119 = r101.motion;
        r119.mPathRotate = r102.getFloat(r105, r119.mPathRotate);
        goto L98
    L29:
        Motion r120 = r101.motion;
        r120.mDrawPath = r102.getInt(r105, 0);
        goto L98
    L34:
        Motion r121 = r101.motion;
        r121.mAnimateRelativeTo = lookupID(r102, r105, r121.mAnimateRelativeTo);
        goto L98
    L35:
        Layout r122 = r101.layout;
        r122.circleAngle = r102.getFloat(r105, r122.circleAngle);
        goto L98
    L36:
        Layout r123 = r101.layout;
        r123.circleRadius = r102.getDimensionPixelSize(r105, r123.circleRadius);
        goto L98
    L37:
        Layout r124 = r101.layout;
        r124.circleConstraint = lookupID(r102, r105, r124.circleConstraint);
        goto L98
    L38:
        Transform r125 = r101.transform;
        r125.rotation = r102.getFloat(r105, r125.rotation);
        goto L98
    L39:
        Layout r126 = r101.layout;
        r126.heightMin = r102.getDimensionPixelSize(r105, r126.heightMin);
        goto L98
    L40:
        Layout r127 = r101.layout;
        r127.widthMin = r102.getDimensionPixelSize(r105, r127.widthMin);
        goto L98
    L41:
        Layout r128 = r101.layout;
        r128.heightMax = r102.getDimensionPixelSize(r105, r128.heightMax);
        goto L98
    L42:
        Layout r129 = r101.layout;
        r129.widthMax = r102.getDimensionPixelSize(r105, r129.widthMax);
        goto L98
    L43:
        Layout r130 = r101.layout;
        r130.heightDefault = r102.getInt(r105, r130.heightDefault);
        goto L98
    L44:
        Layout r131 = r101.layout;
        r131.widthDefault = r102.getInt(r105, r131.widthDefault);
        goto L98
    L45:
        Transform r132 = r101.transform;
        r132.translationZ = r102.getDimension(r105, r132.translationZ);
        goto L98
    L46:
        Transform r133 = r101.transform;
        r133.translationY = r102.getDimension(r105, r133.translationY);
        goto L98
    L47:
        Transform r134 = r101.transform;
        r134.translationX = r102.getDimension(r105, r134.translationX);
        goto L98
    L48:
        Transform r135 = r101.transform;
        r135.transformPivotY = r102.getDimension(r105, r135.transformPivotY);
        goto L98
    L49:
        Transform r136 = r101.transform;
        r136.transformPivotX = r102.getDimension(r105, r136.transformPivotX);
        goto L98
    L50:
        Transform r137 = r101.transform;
        r137.scaleY = r102.getFloat(r105, r137.scaleY);
        goto L98
    L51:
        Transform r138 = r101.transform;
        r138.scaleX = r102.getFloat(r105, r138.scaleX);
        goto L98
    L52:
        Transform r139 = r101.transform;
        r139.rotationY = r102.getFloat(r105, r139.rotationY);
        goto L98
    L53:
        Transform r140 = r101.transform;
        r140.rotationX = r102.getFloat(r105, r140.rotationX);
        goto L98
    L54:
        Transform r141 = r101.transform;
        r141.applyElevation = true;
        r141.elevation = r102.getDimension(r105, r141.elevation);
        goto L98
    L55:
        PropertySet r142 = r101.propertySet;
        r142.alpha = r102.getFloat(r105, r142.alpha);
        goto L98
    L56:
        Layout r143 = r101.layout;
        r143.verticalChainStyle = r102.getInt(r105, r143.verticalChainStyle);
        goto L98
    L57:
        Layout r144 = r101.layout;
        r144.horizontalChainStyle = r102.getInt(r105, r144.horizontalChainStyle);
        goto L98
    L58:
        Layout r145 = r101.layout;
        r145.verticalWeight = r102.getFloat(r105, r145.verticalWeight);
        goto L98
    L59:
        Layout r146 = r101.layout;
        r146.horizontalWeight = r102.getFloat(r105, r146.horizontalWeight);
        goto L98
    L60:
        r101.mViewId = r102.getResourceId(r105, r101.mViewId);
        goto L98
    L61:
        Layout r147 = r101.layout;
        r147.verticalBias = r102.getFloat(r105, r147.verticalBias);
        goto L98
    L62:
        Layout r148 = r101.layout;
        r148.topToTop = lookupID(r102, r105, r148.topToTop);
        goto L98
    L63:
        Layout r149 = r101.layout;
        r149.topToBottom = lookupID(r102, r105, r149.topToBottom);
        goto L98
    L64:
        Layout r150 = r101.layout;
        r150.topMargin = r102.getDimensionPixelSize(r105, r150.topMargin);
        goto L98
    L65:
        Layout r151 = r101.layout;
        r151.startToStart = lookupID(r102, r105, r151.startToStart);
        goto L98
    L66:
        Layout r152 = r101.layout;
        r152.startToEnd = lookupID(r102, r105, r152.startToEnd);
        goto L98
    L67:
        Layout r153 = r101.layout;
        r153.startMargin = r102.getDimensionPixelSize(r105, r153.startMargin);
        goto L98
    L68:
        Layout r154 = r101.layout;
        r154.rightToRight = lookupID(r102, r105, r154.rightToRight);
        goto L98
    L69:
        Layout r155 = r101.layout;
        r155.rightToLeft = lookupID(r102, r105, r155.rightToLeft);
        goto L98
    L70:
        Layout r156 = r101.layout;
        r156.rightMargin = r102.getDimensionPixelSize(r105, r156.rightMargin);
        goto L98
    L71:
        Layout r157 = r101.layout;
        r157.orientation = r102.getInt(r105, r157.orientation);
        goto L98
    L72:
        Layout r158 = r101.layout;
        r158.leftToRight = lookupID(r102, r105, r158.leftToRight);
        goto L98
    L73:
        Layout r159 = r101.layout;
        r159.leftToLeft = lookupID(r102, r105, r159.leftToLeft);
        goto L98
    L74:
        Layout r160 = r101.layout;
        r160.leftMargin = r102.getDimensionPixelSize(r105, r160.leftMargin);
        goto L98
    L75:
        Layout r161 = r101.layout;
        r161.mWidth = r102.getLayoutDimension(r105, r161.mWidth);
        goto L98
    L76:
        PropertySet r162 = r101.propertySet;
        r162.visibility = r102.getInt(r105, r162.visibility);
        PropertySet r163 = r101.propertySet;
        r163.visibility = VISIBILITY_FLAGS[r163.visibility];
        goto L98
    L77:
        Layout r164 = r101.layout;
        r164.mHeight = r102.getLayoutDimension(r105, r164.mHeight);
        goto L98
    L78:
        Layout r165 = r101.layout;
        r165.horizontalBias = r102.getFloat(r105, r165.horizontalBias);
        goto L98
    L79:
        Layout r166 = r101.layout;
        r166.guidePercent = r102.getFloat(r105, r166.guidePercent);
        goto L98
    L80:
        Layout r167 = r101.layout;
        r167.guideEnd = r102.getDimensionPixelOffset(r105, r167.guideEnd);
        goto L98
    L81:
        Layout r168 = r101.layout;
        r168.guideBegin = r102.getDimensionPixelOffset(r105, r168.guideBegin);
        goto L98
    L82:
        Layout r169 = r101.layout;
        r169.goneTopMargin = r102.getDimensionPixelSize(r105, r169.goneTopMargin);
        goto L98
    L83:
        Layout r170 = r101.layout;
        r170.goneStartMargin = r102.getDimensionPixelSize(r105, r170.goneStartMargin);
        goto L98
    L84:
        Layout r171 = r101.layout;
        r171.goneRightMargin = r102.getDimensionPixelSize(r105, r171.goneRightMargin);
        goto L98
    L85:
        Layout r172 = r101.layout;
        r172.goneLeftMargin = r102.getDimensionPixelSize(r105, r172.goneLeftMargin);
        goto L98
    L86:
        Layout r173 = r101.layout;
        r173.goneEndMargin = r102.getDimensionPixelSize(r105, r173.goneEndMargin);
        goto L98
    L87:
        Layout r174 = r101.layout;
        r174.goneBottomMargin = r102.getDimensionPixelSize(r105, r174.goneBottomMargin);
        goto L98
    L88:
        Layout r175 = r101.layout;
        r175.endToStart = lookupID(r102, r105, r175.endToStart);
        goto L98
    L89:
        Layout r176 = r101.layout;
        r176.endToEnd = lookupID(r102, r105, r176.endToEnd);
        goto L98
    L90:
        Layout r177 = r101.layout;
        r177.endMargin = r102.getDimensionPixelSize(r105, r177.endMargin);
        goto L98
    L91:
        Layout r178 = r101.layout;
        r178.editorAbsoluteY = r102.getDimensionPixelOffset(r105, r178.editorAbsoluteY);
        goto L98
    L92:
        Layout r179 = r101.layout;
        r179.editorAbsoluteX = r102.getDimensionPixelOffset(r105, r179.editorAbsoluteX);
        goto L98
    L93:
        Layout r180 = r101.layout;
        r180.dimensionRatio = r102.getString(r105);
        goto L98
    L94:
        Layout r181 = r101.layout;
        r181.bottomToTop = lookupID(r102, r105, r181.bottomToTop);
        goto L98
    L95:
        Layout r182 = r101.layout;
        r182.bottomToBottom = lookupID(r102, r105, r182.bottomToBottom);
        goto L98
    L96:
        Layout r183 = r101.layout;
        r183.bottomMargin = r102.getDimensionPixelSize(r105, r183.bottomMargin);
        goto L98
    L97:
        Layout r184 = r101.layout;
        r184.baselineToBaseline = lookupID(r102, r105, r184.baselineToBaseline);
        goto L98
    L31:
        if (r102.peekValue(r105).type != 3) goto L33;
        Motion r185 = r101.motion;
        r185.mTransitionEasing = r102.getString(r105);
        goto L98
    L33:
        Motion r186 = r101.motion;
        r186.mTransitionEasing = Easing.NAMED_EASING[r102.getInteger(r105, 0)];
    L98:
        r104 = r104 + 1;
        goto L3
    }

    public void addToHorizontalChain(int r100, int r110, int r111) {
        if (r110 != 0) goto L5;
        int r101 = 1;
    L6:
        connect(r100, 1, r110, r101, 0);
        if (r111 != 0) goto L9;
        int r102 = 2;
    L10:
        connect(r100, 2, r111, r102, 0);
        if (r110 == 0) goto L13;
        connect(r110, 2, r100, 1, 0);
    L13:
        if (r111 == 0) goto L16;
        connect(r111, 1, r100, 2, 0);
        return;
    L16:
        return;
    L9:
        r102 = 1;
        goto L10
    L5:
        r101 = 2;
        goto L6
    }

    public void addToHorizontalChainRTL(int r100, int r110, int r111) {
        if (r110 != 0) goto L5;
        int r101 = 6;
    L6:
        connect(r100, 6, r110, r101, 0);
        if (r111 != 0) goto L9;
        int r102 = 7;
    L10:
        connect(r100, 7, r111, r102, 0);
        if (r110 == 0) goto L13;
        connect(r110, 7, r100, 6, 0);
    L13:
        if (r111 == 0) goto L16;
        connect(r111, 6, r100, 7, 0);
        return;
    L16:
        return;
    L9:
        r102 = 6;
        goto L10
    L5:
        r101 = 7;
        goto L6
    }

    public void addToVerticalChain(int r100, int r110, int r111) {
        if (r110 != 0) goto L5;
        int r101 = 3;
    L6:
        connect(r100, 3, r110, r101, 0);
        if (r111 != 0) goto L9;
        int r102 = 4;
    L10:
        connect(r100, 4, r111, r102, 0);
        if (r110 == 0) goto L13;
        connect(r110, 4, r100, 3, 0);
    L13:
        if (r111 == 0) goto L16;
        connect(r111, 3, r100, 4, 0);
        return;
    L16:
        return;
    L9:
        r102 = 3;
        goto L10
    L5:
        r101 = 4;
        goto L6
    }

    public void setColorValue(int r100, String r101, int r102) {
        Constraint.access$600(get(r100), r101, r102);
    }

    public void setFloatValue(int r100, String r101, float r102) {
        Constraint.access$700(get(r100), r101, r102);
    }

    public void setGoneMargin(int r100, int r101, int r102) {
        Constraint r103 = get(r100);
        switch(r101) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r103.layout.goneEndMargin = r102;
        return;
    L7:
        r103.layout.goneStartMargin = r102;
        return;
    L10:
        r103.layout.goneBottomMargin = r102;
        return;
    L11:
        r103.layout.goneTopMargin = r102;
        return;
    L12:
        r103.layout.goneRightMargin = r102;
        return;
    L13:
        r103.layout.goneLeftMargin = r102;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    L9:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public void setIntValue(int r100, String r101, int r102) {
        Constraint.access$500(get(r100), r101, r102);
    }

    public void setMargin(int r100, int r101, int r102) {
        Constraint r103 = get(r100);
        switch(r101) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r103.layout.endMargin = r102;
        return;
    L7:
        r103.layout.startMargin = r102;
        return;
    L10:
        r103.layout.bottomMargin = r102;
        return;
    L11:
        r103.layout.topMargin = r102;
        return;
    L12:
        r103.layout.rightMargin = r102;
        return;
    L13:
        r103.layout.leftMargin = r102;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    L9:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public void setStringValue(int r100, String r101, String r102) {
        Constraint.access$800(get(r100), r101, r102);
    }

    public void setTransformPivot(int r100, float r101, float r102) {
        Transform r103 = get(r100).transform;
        r103.transformPivotY = r102;
        r103.transformPivotX = r101;
    }

    public void setTranslation(int r100, float r101, float r102) {
        Transform r103 = get(r100).transform;
        r103.translationX = r101;
        r103.translationY = r102;
    }

    public void applyToHelper(ConstraintHelper r100, ConstraintWidget r101, ConstraintLayout.LayoutParams r102, SparseArray<ConstraintWidget> r103) {
        int r104 = r100.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r104)) == false) goto L8;
        Constraint r105 = this.mConstraints.get(Integer.valueOf(r104));
        if ((r101 instanceof HelperWidget) == false) goto L9;
        r100.loadParameters(r105, (HelperWidget) r101, r102, r103);
        return;
    L9:
        return;
    }

    public void connect(int r110, int r111, int r112, int r113) {
        if (this.mConstraints.containsKey(Integer.valueOf(r110)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r110), new Constraint());
    L5:
        Constraint r114 = this.mConstraints.get(Integer.valueOf(r110));
        switch(r111) {
            case 1: goto L44;
            case 2: goto L38;
            case 3: goto L32;
            case 4: goto L26;
            case 5: goto L22;
            case 6: goto L15;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        if (r113 != 7) goto L11;
        Layout r115 = r114.layout;
        r115.endToEnd = r112;
        r115.endToStart = -1;
        return;
    L11:
        if (r113 != 6) goto L14;
        Layout r116 = r114.layout;
        r116.endToStart = r112;
        r116.endToEnd = -1;
        return;
    L14:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L15:
        if (r113 != 6) goto L17;
        Layout r117 = r114.layout;
        r117.startToStart = r112;
        r117.startToEnd = -1;
        return;
    L17:
        if (r113 != 7) goto L20;
        Layout r118 = r114.layout;
        r118.startToEnd = r112;
        r118.startToStart = -1;
        return;
    L20:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L26:
        if (r113 != 4) goto L28;
        Layout r119 = r114.layout;
        r119.bottomToBottom = r112;
        r119.bottomToTop = -1;
        r119.baselineToBaseline = -1;
        return;
    L28:
        if (r113 != 3) goto L31;
        Layout r120 = r114.layout;
        r120.bottomToTop = r112;
        r120.bottomToBottom = -1;
        r120.baselineToBaseline = -1;
        return;
    L31:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L32:
        if (r113 != 3) goto L34;
        Layout r121 = r114.layout;
        r121.topToTop = r112;
        r121.topToBottom = -1;
        r121.baselineToBaseline = -1;
        return;
    L34:
        if (r113 != 4) goto L37;
        Layout r122 = r114.layout;
        r122.topToBottom = r112;
        r122.topToTop = -1;
        r122.baselineToBaseline = -1;
        return;
    L37:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L38:
        if (r113 != 1) goto L40;
        Layout r123 = r114.layout;
        r123.rightToLeft = r112;
        r123.rightToRight = -1;
        return;
    L40:
        if (r113 != 2) goto L43;
        Layout r124 = r114.layout;
        r124.rightToRight = r112;
        r124.rightToLeft = -1;
        return;
    L43:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L44:
        if (r113 != 1) goto L46;
        Layout r125 = r114.layout;
        r125.leftToLeft = r112;
        r125.leftToRight = -1;
        return;
    L46:
        if (r113 != 2) goto L50;
        Layout r126 = r114.layout;
        r126.leftToRight = r112;
        r126.leftToLeft = -1;
        return;
    L50:
        throw new IllegalArgumentException("left to " + sideToString(r113) + " undefined");
    L8:
        throw new IllegalArgumentException(sideToString(r111) + " to " + sideToString(r113) + " unknown");
    L22:
        if (r113 != 5) goto L25;
        Layout r127 = r114.layout;
        r127.baselineToBaseline = r112;
        r127.bottomToBottom = -1;
        r127.bottomToTop = -1;
        r127.topToTop = -1;
        r127.topToBottom = -1;
        return;
    L25:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    }

    public void constrainCircle(int r100, int r101, int r102, float r103) {
        Layout r104 = get(r100).layout;
        r104.circleConstraint = r101;
        r104.circleRadius = r102;
        r104.circleAngle = r103;
    }

    public void createBarrier(int r100, int r101, int r102, int... r103) {
        Layout r104 = get(r100).layout;
        r104.mHelperType = 1;
        r104.mBarrierDirection = r101;
        r104.mBarrierMargin = r102;
        r104.mIsGuideline = false;
        r104.mReferenceIds = r103;
    }

    public void connect(int r110, int r111, int r112, int r113, int r114) {
        if (this.mConstraints.containsKey(Integer.valueOf(r110)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r110), new Constraint());
    L5:
        Constraint r115 = this.mConstraints.get(Integer.valueOf(r110));
        switch(r111) {
            case 1: goto L49;
            case 2: goto L42;
            case 3: goto L35;
            case 4: goto L28;
            case 5: goto L24;
            case 6: goto L16;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        if (r113 != 7) goto L11;
        Layout r116 = r115.layout;
        r116.endToEnd = r112;
        r116.endToStart = -1;
    L13:
        r115.layout.endMargin = r114;
        return;
    L11:
        if (r113 != 6) goto L15;
        Layout r117 = r115.layout;
        r117.endToStart = r112;
        r117.endToEnd = -1;
        goto L13
    L15:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L16:
        if (r113 != 6) goto L18;
        Layout r118 = r115.layout;
        r118.startToStart = r112;
        r118.startToEnd = -1;
    L20:
        r115.layout.startMargin = r114;
        return;
    L18:
        if (r113 != 7) goto L22;
        Layout r119 = r115.layout;
        r119.startToEnd = r112;
        r119.startToStart = -1;
        goto L20
    L22:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L28:
        if (r113 != 4) goto L30;
        Layout r120 = r115.layout;
        r120.bottomToBottom = r112;
        r120.bottomToTop = -1;
        r120.baselineToBaseline = -1;
    L32:
        r115.layout.bottomMargin = r114;
        return;
    L30:
        if (r113 != 3) goto L34;
        Layout r121 = r115.layout;
        r121.bottomToTop = r112;
        r121.bottomToBottom = -1;
        r121.baselineToBaseline = -1;
        goto L32
    L34:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L35:
        if (r113 != 3) goto L37;
        Layout r122 = r115.layout;
        r122.topToTop = r112;
        r122.topToBottom = -1;
        r122.baselineToBaseline = -1;
    L39:
        r115.layout.topMargin = r114;
        return;
    L37:
        if (r113 != 4) goto L41;
        Layout r123 = r115.layout;
        r123.topToBottom = r112;
        r123.topToTop = -1;
        r123.baselineToBaseline = -1;
        goto L39
    L41:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L42:
        if (r113 != 1) goto L44;
        Layout r124 = r115.layout;
        r124.rightToLeft = r112;
        r124.rightToRight = -1;
    L46:
        r115.layout.rightMargin = r114;
        return;
    L44:
        if (r113 != 2) goto L48;
        Layout r125 = r115.layout;
        r125.rightToRight = r112;
        r125.rightToLeft = -1;
        goto L46
    L48:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    L49:
        if (r113 != 1) goto L51;
        Layout r126 = r115.layout;
        r126.leftToLeft = r112;
        r126.leftToRight = -1;
    L53:
        r115.layout.leftMargin = r114;
        return;
    L51:
        if (r113 != 2) goto L56;
        Layout r127 = r115.layout;
        r127.leftToRight = r112;
        r127.leftToLeft = -1;
        goto L53
    L56:
        throw new IllegalArgumentException("Left to " + sideToString(r113) + " undefined");
    L8:
        throw new IllegalArgumentException(sideToString(r111) + " to " + sideToString(r113) + " unknown");
    L24:
        if (r113 != 5) goto L27;
        Layout r128 = r115.layout;
        r128.baselineToBaseline = r112;
        r128.bottomToBottom = -1;
        r128.bottomToTop = -1;
        r128.topToTop = -1;
        r128.topToBottom = -1;
        return;
    L27:
        throw new IllegalArgumentException("right to " + sideToString(r113) + " undefined");
    }

    public void createHorizontalChain(int r110, int r111, int r112, int r113, int[] r114, float[] r115, int r116) {
        createHorizontalChain(r110, r111, r112, r113, r114, r115, r116, 1, 2);
    }

    public void createHorizontalChainRtl(int r110, int r111, int r112, int r113, int[] r114, float[] r115, int r116) {
        createHorizontalChain(r110, r111, r112, r113, r114, r115, r116, 6, 7);
    }

    public void createVerticalChain(int r110, int r111, int r112, int r113, int[] r114, float[] r115, int r116) {
        if (r114.length < 2) goto L23;
        if (r115 == null) goto L11;
        if (r115.length == r114.length) goto L11;
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    L11:
        if (r115 == null) goto L13;
        get(r114[0]).layout.verticalWeight = r115[0];
    L13:
        get(r114[0]).layout.verticalChainStyle = r116;
        connect(r114[0], 3, r110, r111, 0);
        int r117 = 1;
    L15:
        if (r117 >= r114.length) goto L20;
        int r118 = r117 - 1;
        connect(r114[r117], 3, r114[r118], 4, 0);
        connect(r114[r118], 4, r114[r117], 3, 0);
        if (r115 == null) goto L19;
        get(r114[r117]).layout.verticalWeight = r115[r117];
    L19:
        r117 = r117 + 1;
        goto L15
    L20:
        connect(r114[r114.length - 1], 4, r112, r113, 0);
        return;
    L23:
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void center(int r100, int r110, int r111, int r112, int r113, int r114, int r115, float r116) {
        if (r112 < 0) goto L28;
        if (r115 < 0) goto L26;
        if (r116 <= 0.0f) goto L24;
        if (r116 > 1.0f) goto L24;
        if (r111 != 1) goto L12;
    L21:
        connect(r100, 1, r110, r111, r112);
        connect(r100, 2, r113, r114, r115);
        this.mConstraints.get(Integer.valueOf(r100)).layout.horizontalBias = r116;
        return;
    L12:
        if (r111 == 2) goto L21;
        if (r111 != 6) goto L17;
    L20:
        connect(r100, 6, r110, r111, r112);
        connect(r100, 7, r113, r114, r115);
        this.mConstraints.get(Integer.valueOf(r100)).layout.horizontalBias = r116;
        return;
    L17:
        if (r111 == 7) goto L20;
        connect(r100, 3, r110, r111, r112);
        connect(r100, 4, r113, r114, r115);
        this.mConstraints.get(Integer.valueOf(r100)).layout.verticalBias = r116;
        return;
    L24:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L26:
        throw new IllegalArgumentException("margin must be > 0");
    L28:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public void centerHorizontally(int r110, int r111, int r112, int r113, int r114, int r115, int r116, float r117) {
        connect(r110, 1, r111, r112, r113);
        connect(r110, 2, r114, r115, r116);
        this.mConstraints.get(Integer.valueOf(r110)).layout.horizontalBias = r117;
    }

    public void centerHorizontallyRtl(int r110, int r111, int r112, int r113, int r114, int r115, int r116, float r117) {
        connect(r110, 6, r111, r112, r113);
        connect(r110, 7, r114, r115, r116);
        this.mConstraints.get(Integer.valueOf(r110)).layout.horizontalBias = r117;
    }

    public void centerVertically(int r110, int r111, int r112, int r113, int r114, int r115, int r116, float r117) {
        connect(r110, 3, r111, r112, r113);
        connect(r110, 4, r114, r115, r116);
        this.mConstraints.get(Integer.valueOf(r110)).layout.verticalBias = r117;
    }

    private void createHorizontalChain(int r110, int r111, int r112, int r113, int[] r114, float[] r115, int r116, int r210, int r211) {
        if (r114.length < 2) goto L23;
        if (r115 == null) goto L11;
        if (r115.length == r114.length) goto L11;
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    L11:
        if (r115 == null) goto L13;
        get(r114[0]).layout.horizontalWeight = r115[0];
    L13:
        get(r114[0]).layout.horizontalChainStyle = r116;
        connect(r114[0], r210, r110, r111, -1);
        int r117 = 1;
    L15:
        if (r117 >= r114.length) goto L20;
        int r118 = r117 - 1;
        connect(r114[r117], r210, r114[r118], r211, -1);
        connect(r114[r118], r211, r114[r117], r210, -1);
        if (r115 == null) goto L19;
        get(r114[r117]).layout.horizontalWeight = r115[r117];
    L19:
        r117 = r117 + 1;
        goto L15
    L20:
        connect(r114[r114.length - 1], r211, r112, r113, -1);
        return;
    L23:
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
}
