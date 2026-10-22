package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public Chain() {
    }

    public static void applyChainConstraints(ConstraintWidgetContainer r100, LinearSystem r101, ArrayList<ConstraintWidget> r102, int r103) {
        int r104 = 0;
        if (r103 != 0) goto L5;
        int r105 = r100.mHorizontalChainsSize;
        ChainHead[] r106 = r100.mHorizontalChainsArray;
        int r107 = 0;
    L6:
        if (r104 >= r105) goto L13;
        ChainHead r108 = r106[r104];
        r108.define();
        if (r102 != null) goto L10;
    L11:
        applyChainConstraints(r100, r101, r103, r107, r108);
    L12:
        r104 = r104 + 1;
        goto L6
    L10:
        if (r102.contains(r108.mFirst) == false) goto L12;
    L13:
        return;
    L5:
        r105 = r100.mVerticalChainsSize;
        r106 = r100.mVerticalChainsArray;
        r107 = 2;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.solver.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    public static void applyChainConstraints(ConstraintWidgetContainer r310, LinearSystem r311, int r312, int r410, ChainHead r411) {
        ConstraintWidget r110 = r411.mFirst;
        ConstraintWidget r111 = r411.mLast;
        ConstraintWidget r112 = r411.mFirstVisibleWidget;
        ConstraintWidget r113 = r411.mLastVisibleWidget;
        ConstraintWidget r100 = r411.mHead;
        float r101 = r411.mTotalWeight;
        if (r310.mListDimensionBehaviors[r312] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
        boolean r102 = true;
    L7:
        if (r312 != 0) goto L17;
        int r103 = r100.mHorizontalChainStyle;
        if (r103 != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r103 != 1) goto L14;
        boolean r114 = true;
    L15:
        if (r103 == 2) goto L25;
    L26:
        boolean r105 = false;
    L27:
        boolean r115 = r114;
        boolean r106 = false;
        boolean r116 = r104;
        ?? r107 = r110;
    L28:
        Object r210 = null;
        if (r106 == true) goto L81;
        ConstraintAnchor r108 = r107.mListAnchors[r410];
        if (r105 == false) goto L33;
        int r117 = 1;
    L34:
        int r211 = r108.getMargin();
        ConstraintWidget.DimensionBehaviour r118 = r107.mListDimensionBehaviors[r312];
        float r212 = r101;
        ConstraintWidget.DimensionBehaviour r109 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r118 == r109) goto L37;
    L39:
        boolean r119 = false;
    L40:
        ConstraintAnchor r120 = r108.mTarget;
        if (r120 == null) goto L44;
        if (r107 == r110) goto L44;
        r211 = r211 + r120.getMargin();
    L44:
        int r121 = r211;
        if (r105 == false) goto L50;
        if (r107 == r110) goto L50;
        if (r107 == r112) goto L50;
        r117 = 8;
    L50:
        ConstraintAnchor r122 = r108.mTarget;
        if (r122 == null) goto L60;
        if (r107 != r112) goto L54;
        r311.addGreaterThan(r108.mSolverVariable, r122.mSolverVariable, r121, 6);
    L55:
        if (r119 == false) goto L58;
        if (r105 == true) goto L58;
        int r123 = 5;
    L59:
        r311.addEquality(r108.mSolverVariable, r108.mTarget.mSolverVariable, r121, r123);
    L61:
        if (r102 == true) goto L63;
    L69:
        ConstraintAnchor r124 = r107.mListAnchors[r410 + 1].mTarget;
        if (r124 == null) goto L77;
        ConstraintWidget r125 = r124.mOwner;
        ConstraintAnchor r126 = r125.mListAnchors[r410].mTarget;
        if (r126 == null) goto L77;
        if (r126.mOwner != r107) goto L77;
        r210 = r125;
    L77:
        if (r210 == null) goto L79;
        r107 = r210;
        r106 = r106;
    L80:
        r116 = r116;
        r101 = r212;
        r100 = r100;
        r110 = r110;
        r107 = r107;
        goto L28
    L79:
        r106 = true;
        goto L80
    L63:
        if (r107.getVisibility() != 8) goto L65;
    L67:
        int r127 = 0;
    L68:
        r311.addGreaterThan(r107.mListAnchors[r410].mSolverVariable, r310.mListAnchors[r410].mSolverVariable, r127, 8);
        goto L69
    L65:
        if (r107.mListDimensionBehaviors[r312] != r109) goto L67;
        ConstraintAnchor[] r128 = r107.mListAnchors;
        r127 = 0;
        r311.addGreaterThan(r128[r410 + 1].mSolverVariable, r128[r410].mSolverVariable, 0, 5);
    L58:
        r123 = r117;
        goto L59
    L54:
        r311.addGreaterThan(r108.mSolverVariable, r122.mSolverVariable, r121, 8);
        goto L55
    L60:
        r100 = r100;
        r110 = r110;
        goto L61
    L37:
        if (r107.mResolvedMatchConstraintDefault[r312] != 0) goto L39;
        r119 = true;
        goto L40
    L33:
        r117 = 4;
        goto L34
    L81:
        ConstraintWidget r213 = r100;
        float r214 = r101;
        ConstraintWidget r215 = r110;
        boolean r216 = r116;
        if (r113 == null) goto L103;
        int r129 = r410 + 1;
        if (r111.mListAnchors[r129].mTarget == null) goto L103;
        ConstraintAnchor r130 = r113.mListAnchors[r129];
        if (r113.mListDimensionBehaviors[r312] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L88;
    L90:
        boolean r131 = false;
    L91:
        if (r131 == false) goto L97;
        if (r105 == true) goto L97;
        ConstraintAnchor r132 = r130.mTarget;
        if (r132.mOwner != r310) goto L97;
        r311.addEquality(r130.mSolverVariable, r132.mSolverVariable, -r130.getMargin(), 5);
    L101:
        r311.addLowerThan(r130.mSolverVariable, r111.mListAnchors[r129].mTarget.mSolverVariable, -r130.getMargin(), 6);
    L97:
        if (r105 == false) goto L101;
        ConstraintAnchor r133 = r130.mTarget;
        if (r133.mOwner != r310) goto L101;
        r311.addEquality(r130.mSolverVariable, r133.mSolverVariable, -r130.getMargin(), 4);
        goto L101
    L88:
        if (r113.mResolvedMatchConstraintDefault[r312] != 0) goto L90;
        r131 = true;
    L103:
        if (r102 == false) goto L105;
        int r134 = r410 + 1;
        SolverVariable r135 = r310.mListAnchors[r134].mSolverVariable;
        ConstraintAnchor r136 = r111.mListAnchors[r134];
        r311.addGreaterThan(r135, r136.mSolverVariable, r136.getMargin(), 8);
    L105:
        ArrayList<ConstraintWidget> r137 = r411.mWeightedMatchConstraintsWidgets;
        if (r137 == null) goto L134;
        int r138 = r137.size();
        if (r138 <= 1) goto L134;
        if (r411.mHasUndefinedWeights == true) goto L112;
    L114:
        float r139 = r214;
    L115:
        float r140 = 0.0f;
        ConstraintWidget r141 = null;
        int r142 = 0;
        float r217 = 0.0f;
    L116:
        if (r142 >= r138) goto L134;
        ConstraintWidget r143 = (ConstraintWidget) ListProtector.get(r137, r142);
        float r144 = r143.mWeight[r312];
        if (r144 >= r140) goto L125;
        if (r411.mHasComplexMatchWeights == false) goto L122;
        ConstraintAnchor[] r145 = r143.mListAnchors;
        r311.addEquality(r145[r410 + 1].mSolverVariable, r145[r410].mSolverVariable, 0, 4);
    L127:
        r137 = r137;
    L133:
        r142 = r142 + 1;
        r137 = r137;
        r140 = 0.0f;
        goto L116
    L122:
        r144 = 1.0f;
    L125:
        if (r144 != r140) goto L129;
        ConstraintAnchor[] r146 = r143.mListAnchors;
        r311.addEquality(r146[r410 + 1].mSolverVariable, r146[r410].mSolverVariable, 0, 8);
        goto L127
    L129:
        if (r141 == null) goto L132;
        ConstraintAnchor[] r147 = r141.mListAnchors;
        SolverVariable r148 = r147[r410].mSolverVariable;
        int r149 = r410 + 1;
        SolverVariable r150 = r147[r149].mSolverVariable;
        ConstraintAnchor[] r151 = r143.mListAnchors;
        SolverVariable r152 = r151[r410].mSolverVariable;
        SolverVariable r153 = r151[r149].mSolverVariable;
        ArrayRow r154 = r311.createRow();
        r154.createRowEqualMatchDimensions(r217, r139, r144, r148, r150, r152, r153);
        r311.addConstraint(r154);
    L132:
        r141 = r143;
        r217 = r144;
        goto L133
    L112:
        if (r411.mHasComplexMatchWeights == true) goto L114;
        r139 = r411.mWidgetsMatchCount;
    L134:
        if (r112 == null) goto L153;
        if (r112 == r113) goto L137;
        if (r105 == false) goto L153;
    L137:
        ConstraintAnchor r155 = r215.mListAnchors[r410];
        int r156 = r410 + 1;
        ConstraintAnchor r157 = r111.mListAnchors[r156];
        ConstraintAnchor r158 = r155.mTarget;
        if (r158 == null) goto L140;
        SolverVariable r159 = r158.mSolverVariable;
    L141:
        ConstraintAnchor r160 = r157.mTarget;
        if (r160 == null) goto L144;
        SolverVariable r161 = r160.mSolverVariable;
    L145:
        ConstraintAnchor r162 = r112.mListAnchors[r410];
        ConstraintAnchor r163 = r113.mListAnchors[r156];
        if (r159 == null) goto L281;
        if (r161 == null) goto L281;
        if (r312 != 0) goto L150;
        float r164 = r213.mHorizontalBiasPercent;
    L151:
        int r165 = r162.getMargin();
        SolverVariable r166 = r159;
        r311.addCentering(r162.mSolverVariable, r166, r165, r164, r161, r163.mSolverVariable, r163.getMargin(), 7);
        goto L281
    L150:
        r164 = r213.mVerticalBiasPercent;
    L281:
        if (r216 == true) goto L283;
        if (r115 == true) goto L283;
        return;
    L283:
        if (r112 == null) goto L321;
        if (r112 == r113) goto L322;
        ConstraintAnchor[] r167 = r112.mListAnchors;
        ConstraintAnchor r168 = r167[r410];
        int r169 = r410 + 1;
        ConstraintAnchor r170 = r113.mListAnchors[r169];
        ConstraintAnchor r171 = r168.mTarget;
        if (r171 == null) goto L288;
        SolverVariable r172 = r171.mSolverVariable;
    L289:
        ConstraintAnchor r173 = r170.mTarget;
        if (r173 == null) goto L292;
        ?? r174 = r173.mSolverVariable;
    L293:
        if (r111 == r113) goto L298;
        ConstraintAnchor r175 = r111.mListAnchors[r169].mTarget;
        if (r175 == null) goto L297;
        r210 = r175.mSolverVariable;
    L297:
        r174 = r210;
    L298:
        if (r112 != r113) goto L300;
        r170 = r167[r169];
    L300:
        if (r172 == null) goto L323;
        if (r174 == 0) goto L324;
        int r176 = r168.getMargin();
        int r177 = r113.mListAnchors[r169].getMargin();
        r311.addCentering(r168.mSolverVariable, r172, r176, 0.5f, r174, r170.mSolverVariable, r177, 5);
        return;
    L324:
        return;
    L323:
        return;
    L292:
        r174 = 0;
        goto L293
    L288:
        r172 = null;
        goto L289
    L322:
        return;
    L321:
        return;
    L144:
        r161 = null;
        goto L145
    L140:
        r159 = null;
    L153:
        if (r216 == false) goto L215;
        if (r112 == null) goto L215;
        int r178 = r411.mWidgetsMatchCount;
        if (r178 > 0) goto L158;
    L160:
        boolean r179 = false;
    L161:
        ConstraintWidget r180 = r112;
        ConstraintWidget r181 = r180;
    L162:
        if (r180 == null) goto L281;
        ConstraintWidget r182 = r180.mNextChainWidget[r312];
    L164:
        if (r182 == null) goto L169;
        if (r182.getVisibility() != 8) goto L169;
        r182 = r182.mNextChainWidget[r312];
    L169:
        if (r182 != null) goto L173;
        if (r180 == r113) goto L173;
    L212:
        if (r180.getVisibility() == 8) goto L214;
        r181 = r180;
    L214:
        r180 = r182;
    L173:
        ConstraintAnchor r183 = r180.mListAnchors[r410];
        SolverVariable r184 = r183.mSolverVariable;
        ConstraintAnchor r185 = r183.mTarget;
        if (r185 == null) goto L176;
        SolverVariable r186 = r185.mSolverVariable;
    L177:
        if (r181 == r180) goto L179;
        r186 = r181.mListAnchors[r410 + 1].mSolverVariable;
    L185:
        int r187 = r183.getMargin();
        int r188 = r410 + 1;
        int r189 = r180.mListAnchors[r188].getMargin();
        if (r182 == null) goto L188;
        ConstraintAnchor r190 = r182.mListAnchors[r410];
        SolverVariable r191 = r190.mSolverVariable;
        SolverVariable r192 = r180.mListAnchors[r188].mSolverVariable;
        SolverVariable r193 = r191;
    L193:
        if (r190 == null) goto L195;
        r189 = r189 + r190.getMargin();
    L195:
        if (r181 == null) goto L197;
        r187 = r187 + r181.mListAnchors[r188].getMargin();
    L197:
        if (r184 == null) goto L212;
        if (r186 == null) goto L212;
        if (r193 == null) goto L212;
        if (r192 == null) goto L212;
        if (r180 != r112) goto L203;
        r187 = r112.mListAnchors[r410].getMargin();
    L203:
        int r194 = r187;
        if (r180 != r113) goto L206;
        int r195 = r113.mListAnchors[r188].getMargin();
    L207:
        if (r179 == false) goto L209;
        int r218 = 8;
    L210:
        r311.addCentering(r184, r186, r194, 0.5f, r193, r192, r195, r218);
        goto L212
    L209:
        r218 = 5;
        goto L210
    L206:
        r195 = r189;
        goto L207
    L188:
        r190 = r111.mListAnchors[r188].mTarget;
        if (r190 == null) goto L191;
        r193 = r190.mSolverVariable;
    L192:
        r192 = r180.mListAnchors[r188].mSolverVariable;
        goto L193
    L191:
        r193 = null;
        goto L192
    L179:
        if (r180 != r112) goto L185;
        if (r181 != r180) goto L185;
        ConstraintAnchor r196 = r215.mListAnchors[r410].mTarget;
        if (r196 == null) goto L184;
        r186 = r196.mSolverVariable;
        goto L185
    L184:
        r186 = null;
        goto L185
    L176:
        r186 = null;
        goto L177
    L158:
        if (r411.mWidgetsCount != r178) goto L160;
        r179 = true;
    L215:
        int r197 = 8;
        if (r115 == false) goto L281;
        if (r112 == null) goto L281;
        int r198 = r411.mWidgetsMatchCount;
        if (r198 > 0) goto L221;
    L223:
        boolean r199 = false;
    L224:
        ConstraintWidget r1100 = r112;
        ConstraintWidget r1101 = r1100;
    L225:
        if (r1100 == null) goto L270;
        ConstraintWidget r200 = r1100.mNextChainWidget[r312];
    L227:
        if (r200 == null) goto L231;
        if (r200.getVisibility() != r197) goto L231;
        r200 = r200.mNextChainWidget[r312];
    L231:
        if (r1100 == r112) goto L264;
        if (r1100 == r113) goto L264;
        if (r200 == null) goto L264;
        if (r200 != r113) goto L236;
        ConstraintWidget r201 = null;
    L237:
        ConstraintAnchor r202 = r1100.mListAnchors[r410];
        SolverVariable r203 = r202.mSolverVariable;
        ConstraintAnchor r204 = r202.mTarget;
        if (r204 == null) goto L240;
        SolverVariable r205 = r204.mSolverVariable;
    L240:
        int r206 = r410 + 1;
        SolverVariable r207 = r1101.mListAnchors[r206].mSolverVariable;
        int r208 = r202.getMargin();
        int r209 = r1100.mListAnchors[r206].getMargin();
        if (r201 == null) goto L246;
        ConstraintAnchor r219 = r201.mListAnchors[r410];
        SolverVariable r220 = r219.mSolverVariable;
        ConstraintAnchor r221 = r219.mTarget;
        if (r221 == null) goto L245;
        SolverVariable r222 = r221.mSolverVariable;
    L251:
        if (r219 == null) goto L253;
        r209 = r209 + r219.getMargin();
    L253:
        int r1102 = r209;
        int r223 = r1101.mListAnchors[r206].getMargin() + r208;
        if (r199 == false) goto L256;
        int r1103 = 8;
    L257:
        if (r203 == null) goto L262;
        if (r207 == null) goto L262;
        if (r220 == null) goto L262;
        if (r222 == null) goto L262;
        int r1104 = 8;
        r311.addCentering(r203, r207, r223, 0.5f, r220, r222, r1102, r1103);
    L263:
        r200 = r201;
    L266:
        if (r1100.getVisibility() != r1104) goto L269;
        r1100 = r1101;
    L269:
        r1101 = r1100;
        r197 = 8;
        r1100 = r200;
    L262:
        r1104 = 8;
        goto L263
    L256:
        r1103 = 4;
        goto L257
    L245:
        r222 = null;
        goto L251
    L246:
        r219 = r113.mListAnchors[r410];
        if (r219 == null) goto L249;
        r220 = r219.mSolverVariable;
    L250:
        r222 = r1100.mListAnchors[r206].mSolverVariable;
        goto L251
    L249:
        r220 = null;
        goto L250
    L236:
        r201 = r200;
    L264:
        r1101 = r1101;
        r1104 = 8;
        goto L266
    L270:
        ConstraintAnchor r224 = r112.mListAnchors[r410];
        ConstraintAnchor r225 = r215.mListAnchors[r410].mTarget;
        int r226 = r410 + 1;
        ConstraintAnchor r1105 = r113.mListAnchors[r226];
        ConstraintAnchor r1106 = r111.mListAnchors[r226].mTarget;
        if (r225 == null) goto L277;
        if (r112 == r113) goto L274;
        int r1107 = 5;
        r311.addEquality(r224.mSolverVariable, r225.mSolverVariable, r224.getMargin(), 5);
    L278:
        if (r1106 == null) goto L281;
        if (r112 == r113) goto L281;
        r311.addEquality(r1105.mSolverVariable, r1106.mSolverVariable, -r1105.getMargin(), r1107);
        goto L281
    L274:
        r1107 = 5;
        if (r1106 == null) goto L278;
        r311.addCentering(r224.mSolverVariable, r225.mSolverVariable, r224.getMargin(), 0.5f, r1105.mSolverVariable, r1106.mSolverVariable, r1105.getMargin(), 5);
        goto L278
    L277:
        r1107 = 5;
        goto L278
    L221:
        if (r411.mWidgetsCount != r198) goto L223;
        r199 = true;
    L25:
        r105 = true;
        goto L27
    L14:
        r114 = false;
        goto L15
    L11:
        r104 = false;
        goto L12
    L17:
        int r227 = r100.mVerticalChainStyle;
        if (r227 != 0) goto L20;
        r104 = true;
    L21:
        if (r227 != 1) goto L23;
        r114 = true;
    L24:
        if (r227 != 2) goto L26;
    L23:
        r114 = false;
        goto L24
    L20:
        r104 = false;
        goto L21
    L5:
        r102 = false;
        goto L7
    }
}
