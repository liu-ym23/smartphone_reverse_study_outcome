package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

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

    public void apply() {
    }

    public ConstraintProperties scaleY(float r100) {
        return this;
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams r100 = this.mParams;
        int r101 = r100.leftToRight;
        int r102 = r100.rightToLeft;
        if (r101 != (-1)) goto L22;
        if (r102 != (-1)) goto L22;
        int r103 = r100.startToEnd;
        int r104 = r100.endToStart;
        if (r103 != (-1)) goto L9;
        if (r104 != (-1)) goto L9;
    L21:
        removeConstraints(6);
        removeConstraints(7);
    L35:
        return this;
    L9:
        ConstraintProperties r105 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r103));
        ConstraintProperties r106 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r104));
        ConstraintLayout.LayoutParams r107 = this.mParams;
        if (r103 == (-1)) goto L13;
        if (r104 == (-1)) goto L13;
        r105.connect(7, r104, 6, 0);
        r106.connect(6, r101, 7, 0);
    L13:
        if (r101 != (-1)) goto L15;
        if (r104 == (-1)) goto L21;
    L15:
        int r108 = r107.rightToRight;
        if (r108 == (-1)) goto L18;
        r105.connect(7, r108, 7, 0);
        goto L21
    L18:
        int r109 = r107.leftToLeft;
        if (r109 == (-1)) goto L21;
        r106.connect(6, r109, 6, 0);
    L22:
        ConstraintProperties r110 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r101));
        ConstraintProperties r111 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r102));
        ConstraintLayout.LayoutParams r112 = this.mParams;
        if (r101 == (-1)) goto L26;
        if (r102 == (-1)) goto L26;
        r110.connect(2, r102, 1, 0);
        r111.connect(1, r101, 2, 0);
    L34:
        removeConstraints(1);
        removeConstraints(2);
    L26:
        if (r101 != (-1)) goto L28;
        if (r102 == (-1)) goto L34;
    L28:
        int r113 = r112.rightToRight;
        if (r113 == (-1)) goto L31;
        r110.connect(2, r113, 2, 0);
        goto L34
    L31:
        int r114 = r112.leftToLeft;
        if (r114 == (-1)) goto L34;
        r111.connect(1, r114, 1, 0);
        goto L34
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams r100 = this.mParams;
        int r101 = r100.topToBottom;
        int r102 = r100.bottomToTop;
        if (r101 != (-1)) goto L5;
        if (r102 != (-1)) goto L5;
    L17:
        removeConstraints(3);
        removeConstraints(4);
        return this;
    L5:
        ConstraintProperties r103 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r101));
        ConstraintProperties r104 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r102));
        ConstraintLayout.LayoutParams r105 = this.mParams;
        if (r101 == (-1)) goto L9;
        if (r102 == (-1)) goto L9;
        r103.connect(4, r102, 3, 0);
        r104.connect(3, r101, 4, 0);
    L9:
        if (r101 != (-1)) goto L11;
        if (r102 == (-1)) goto L17;
    L11:
        int r106 = r105.bottomToBottom;
        if (r106 == (-1)) goto L14;
        r103.connect(4, r106, 4, 0);
        goto L17
    L14:
        int r107 = r105.topToTop;
        if (r107 == (-1)) goto L17;
        r104.connect(3, r107, 3, 0);
        goto L17
    }

    public ConstraintProperties(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        this.mParams = (ConstraintLayout.LayoutParams) r101;
        this.mView = r100;
        return;
    L7:
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    public ConstraintProperties alpha(float r100) {
        this.mView.setAlpha(r100);
        return this;
    }

    public ConstraintProperties centerHorizontally(int r100) {
        if (r100 != 0) goto L4;
        center(0, 1, 0, 0, 2, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r100, 2, 0, r100, 1, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties centerHorizontallyRtl(int r100) {
        if (r100 != 0) goto L4;
        center(0, 6, 0, 0, 7, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r100, 7, 0, r100, 6, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties centerVertically(int r100) {
        if (r100 != 0) goto L4;
        center(0, 3, 0, 0, 4, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r100, 4, 0, r100, 3, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties constrainDefaultHeight(int r100) {
        this.mParams.matchConstraintDefaultHeight = r100;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int r100) {
        this.mParams.matchConstraintDefaultWidth = r100;
        return this;
    }

    public ConstraintProperties constrainHeight(int r100) {
        ((ViewGroup.MarginLayoutParams) this.mParams).height = r100;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int r100) {
        this.mParams.matchConstraintMaxHeight = r100;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int r100) {
        this.mParams.matchConstraintMaxWidth = r100;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int r100) {
        this.mParams.matchConstraintMinHeight = r100;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int r100) {
        this.mParams.matchConstraintMinWidth = r100;
        return this;
    }

    public ConstraintProperties constrainWidth(int r100) {
        ((ViewGroup.MarginLayoutParams) this.mParams).width = r100;
        return this;
    }

    public ConstraintProperties dimensionRatio(String r100) {
        this.mParams.dimensionRatio = r100;
        return this;
    }

    public ConstraintProperties elevation(float r100) {
        this.mView.setElevation(r100);
        return this;
    }

    public ConstraintProperties horizontalBias(float r100) {
        this.mParams.horizontalBias = r100;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int r100) {
        this.mParams.horizontalChainStyle = r100;
        return this;
    }

    public ConstraintProperties horizontalWeight(float r100) {
        this.mParams.horizontalWeight = r100;
        return this;
    }

    public ConstraintProperties removeConstraints(int r100) {
        switch(r100) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        ConstraintLayout.LayoutParams r101 = this.mParams;
        r101.endToStart = -1;
        r101.endToEnd = -1;
        r101.setMarginEnd(-1);
        this.mParams.goneEndMargin = -1;
    L13:
        return this;
    L7:
        ConstraintLayout.LayoutParams r102 = this.mParams;
        r102.startToEnd = -1;
        r102.startToStart = -1;
        r102.setMarginStart(-1);
        this.mParams.goneStartMargin = -1;
        goto L13
    L8:
        this.mParams.baselineToBaseline = -1;
        goto L13
    L9:
        ConstraintLayout.LayoutParams r103 = this.mParams;
        r103.bottomToTop = -1;
        r103.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = -1;
        r103.goneBottomMargin = -1;
        goto L13
    L10:
        ConstraintLayout.LayoutParams r104 = this.mParams;
        r104.topToBottom = -1;
        r104.topToTop = -1;
        ((ViewGroup.MarginLayoutParams) r104).topMargin = -1;
        r104.goneTopMargin = -1;
        goto L13
    L11:
        ConstraintLayout.LayoutParams r105 = this.mParams;
        r105.rightToRight = -1;
        r105.rightToLeft = -1;
        ((ViewGroup.MarginLayoutParams) r105).rightMargin = -1;
        r105.goneRightMargin = -1;
        goto L13
    L12:
        ConstraintLayout.LayoutParams r106 = this.mParams;
        r106.leftToRight = -1;
        r106.leftToLeft = -1;
        ((ViewGroup.MarginLayoutParams) r106).leftMargin = -1;
        r106.goneLeftMargin = -1;
        goto L13
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public ConstraintProperties rotation(float r100) {
        this.mView.setRotation(r100);
        return this;
    }

    public ConstraintProperties rotationX(float r100) {
        this.mView.setRotationX(r100);
        return this;
    }

    public ConstraintProperties rotationY(float r100) {
        this.mView.setRotationY(r100);
        return this;
    }

    public ConstraintProperties scaleX(float r100) {
        this.mView.setScaleY(r100);
        return this;
    }

    public ConstraintProperties transformPivotX(float r100) {
        this.mView.setPivotX(r100);
        return this;
    }

    public ConstraintProperties transformPivotY(float r100) {
        this.mView.setPivotY(r100);
        return this;
    }

    public ConstraintProperties translationX(float r100) {
        this.mView.setTranslationX(r100);
        return this;
    }

    public ConstraintProperties translationY(float r100) {
        this.mView.setTranslationY(r100);
        return this;
    }

    public ConstraintProperties translationZ(float r100) {
        this.mView.setTranslationZ(r100);
        return this;
    }

    public ConstraintProperties verticalBias(float r100) {
        this.mParams.verticalBias = r100;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int r100) {
        this.mParams.verticalChainStyle = r100;
        return this;
    }

    public ConstraintProperties verticalWeight(float r100) {
        this.mParams.verticalWeight = r100;
        return this;
    }

    public ConstraintProperties visibility(int r100) {
        this.mView.setVisibility(r100);
        return this;
    }

    public ConstraintProperties addToHorizontalChain(int r100, int r101) {
        if (r100 != 0) goto L5;
        int r102 = 1;
    L6:
        connect(1, r100, r102, 0);
        if (r101 != 0) goto L9;
        int r103 = 2;
    L10:
        connect(2, r101, r103, 0);
        if (r100 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r100)).connect(2, this.mView.getId(), 1, 0);
    L13:
        if (r101 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r101)).connect(1, this.mView.getId(), 2, 0);
    L15:
        return this;
    L9:
        r103 = 1;
        goto L10
    L5:
        r102 = 2;
        goto L6
    }

    public ConstraintProperties addToHorizontalChainRTL(int r100, int r101) {
        if (r100 != 0) goto L5;
        int r102 = 6;
    L6:
        connect(6, r100, r102, 0);
        if (r101 != 0) goto L9;
        int r103 = 7;
    L10:
        connect(7, r101, r103, 0);
        if (r100 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r100)).connect(7, this.mView.getId(), 6, 0);
    L13:
        if (r101 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r101)).connect(6, this.mView.getId(), 7, 0);
    L15:
        return this;
    L9:
        r103 = 6;
        goto L10
    L5:
        r102 = 7;
        goto L6
    }

    public ConstraintProperties addToVerticalChain(int r100, int r101) {
        if (r100 != 0) goto L5;
        int r102 = 3;
    L6:
        connect(3, r100, r102, 0);
        if (r101 != 0) goto L9;
        int r103 = 4;
    L10:
        connect(4, r101, r103, 0);
        if (r100 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r100)).connect(4, this.mView.getId(), 3, 0);
    L13:
        if (r101 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r101)).connect(3, this.mView.getId(), 4, 0);
    L15:
        return this;
    L9:
        r103 = 3;
        goto L10
    L5:
        r102 = 4;
        goto L6
    }

    public ConstraintProperties goneMargin(int r100, int r101) {
        switch(r100) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        this.mParams.goneEndMargin = r101;
    L13:
        return this;
    L6:
        this.mParams.goneStartMargin = r101;
        goto L13
    L9:
        this.mParams.goneBottomMargin = r101;
        goto L13
    L10:
        this.mParams.goneTopMargin = r101;
        goto L13
    L11:
        this.mParams.goneRightMargin = r101;
        goto L13
    L12:
        this.mParams.goneLeftMargin = r101;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties margin(int r100, int r101) {
        switch(r100) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        this.mParams.setMarginEnd(r101);
    L13:
        return this;
    L6:
        this.mParams.setMarginStart(r101);
        goto L13
    L9:
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r101;
        goto L13
    L10:
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r101;
        goto L13
    L11:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r101;
        goto L13
    L12:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r101;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties transformPivot(float r100, float r101) {
        this.mView.setPivotX(r100);
        this.mView.setPivotY(r101);
        return this;
    }

    public ConstraintProperties translation(float r100, float r101) {
        this.mView.setTranslationX(r100);
        this.mView.setTranslationY(r101);
        return this;
    }

    public ConstraintProperties connect(int r110, int r111, int r112, int r113) {
        switch(r110) {
            case 1: goto L46;
            case 2: goto L39;
            case 3: goto L32;
            case 4: goto L25;
            case 5: goto L21;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        if (r112 != 7) goto L8;
        ConstraintLayout.LayoutParams r114 = this.mParams;
        r114.endToEnd = r111;
        r114.endToStart = -1;
    L10:
        this.mParams.setMarginEnd(r113);
    L51:
        return this;
    L8:
        if (r112 != 6) goto L12;
        ConstraintLayout.LayoutParams r115 = this.mParams;
        r115.endToStart = r111;
        r115.endToEnd = -1;
        goto L10
    L12:
        throw new IllegalArgumentException("right to " + sideToString(r112) + " undefined");
    L13:
        if (r112 != 6) goto L15;
        ConstraintLayout.LayoutParams r116 = this.mParams;
        r116.startToStart = r111;
        r116.startToEnd = -1;
    L17:
        this.mParams.setMarginStart(r113);
        goto L51
    L15:
        if (r112 != 7) goto L19;
        ConstraintLayout.LayoutParams r117 = this.mParams;
        r117.startToEnd = r111;
        r117.startToStart = -1;
        goto L17
    L19:
        throw new IllegalArgumentException("right to " + sideToString(r112) + " undefined");
    L25:
        if (r112 != 4) goto L27;
        ConstraintLayout.LayoutParams r118 = this.mParams;
        r118.bottomToBottom = r111;
        r118.bottomToTop = -1;
        r118.baselineToBaseline = -1;
    L29:
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r113;
        goto L51
    L27:
        if (r112 != 3) goto L31;
        ConstraintLayout.LayoutParams r119 = this.mParams;
        r119.bottomToTop = r111;
        r119.bottomToBottom = -1;
        r119.baselineToBaseline = -1;
        goto L29
    L31:
        throw new IllegalArgumentException("right to " + sideToString(r112) + " undefined");
    L32:
        if (r112 != 3) goto L34;
        ConstraintLayout.LayoutParams r120 = this.mParams;
        r120.topToTop = r111;
        r120.topToBottom = -1;
        r120.baselineToBaseline = -1;
    L36:
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r113;
        goto L51
    L34:
        if (r112 != 4) goto L38;
        ConstraintLayout.LayoutParams r121 = this.mParams;
        r121.topToBottom = r111;
        r121.topToTop = -1;
        r121.baselineToBaseline = -1;
        goto L36
    L38:
        throw new IllegalArgumentException("right to " + sideToString(r112) + " undefined");
    L39:
        if (r112 != 1) goto L41;
        ConstraintLayout.LayoutParams r122 = this.mParams;
        r122.rightToLeft = r111;
        r122.rightToRight = -1;
    L43:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r113;
        goto L51
    L41:
        if (r112 != 2) goto L45;
        ConstraintLayout.LayoutParams r123 = this.mParams;
        r123.rightToRight = r111;
        r123.rightToLeft = -1;
        goto L43
    L45:
        throw new IllegalArgumentException("right to " + sideToString(r112) + " undefined");
    L46:
        if (r112 != 1) goto L48;
        ConstraintLayout.LayoutParams r124 = this.mParams;
        r124.leftToLeft = r111;
        r124.leftToRight = -1;
    L50:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r113;
        goto L51
    L48:
        if (r112 != 2) goto L53;
        ConstraintLayout.LayoutParams r125 = this.mParams;
        r125.leftToRight = r111;
        r125.leftToLeft = -1;
        goto L50
    L53:
        throw new IllegalArgumentException("Left to " + sideToString(r112) + " undefined");
    L5:
        throw new IllegalArgumentException(sideToString(r110) + " to " + sideToString(r112) + " unknown");
    L21:
        if (r112 != 5) goto L24;
        ConstraintLayout.LayoutParams r126 = this.mParams;
        r126.baselineToBaseline = r111;
        r126.bottomToBottom = -1;
        r126.bottomToTop = -1;
        r126.topToTop = -1;
        r126.topToBottom = -1;
        goto L51
    L24:
        throw new IllegalArgumentException("right to " + sideToString(r112) + " undefined");
    }

    public ConstraintProperties center(int r100, int r101, int r102, int r103, int r104, int r105, float r106) {
        if (r102 < 0) goto L26;
        if (r105 < 0) goto L24;
        if (r106 <= 0.0f) goto L22;
        if (r106 > 1.0f) goto L22;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L19;
        if (r101 == 6) goto L18;
        if (r101 == 7) goto L18;
        connect(3, r100, r101, r102);
        connect(4, r103, r104, r105);
        this.mParams.verticalBias = r106;
    L20:
        return this;
    L18:
        connect(6, r100, r101, r102);
        connect(7, r103, r104, r105);
        this.mParams.horizontalBias = r106;
    L19:
        connect(1, r100, r101, r102);
        connect(2, r103, r104, r105);
        this.mParams.horizontalBias = r106;
    L22:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L24:
        throw new IllegalArgumentException("margin must be > 0");
    L26:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int r100, int r101, int r102, int r103, int r104, int r105, float r106) {
        connect(1, r100, r101, r102);
        connect(2, r103, r104, r105);
        this.mParams.horizontalBias = r106;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int r100, int r101, int r102, int r103, int r104, int r105, float r106) {
        connect(6, r100, r101, r102);
        connect(7, r103, r104, r105);
        this.mParams.horizontalBias = r106;
        return this;
    }

    public ConstraintProperties centerVertically(int r100, int r101, int r102, int r103, int r104, int r105, float r106) {
        connect(3, r100, r101, r102);
        connect(4, r103, r104, r105);
        this.mParams.verticalBias = r106;
        return this;
    }
}
