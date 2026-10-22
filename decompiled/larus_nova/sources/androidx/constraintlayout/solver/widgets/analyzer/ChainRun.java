package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    private ConstraintWidget getFirstVisibleWidget() {
        int r100 = 0;
    L4:
        if (r100 >= this.widgets.size()) goto L10;
        WidgetRun r101 = (WidgetRun) ListProtector.get(this.widgets, r100);
        if (r101.widget.getVisibility() != 8) goto L8;
        r100 = r100 + 1;
        goto L4
    L8:
        return r101.widget;
    L10:
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int r100 = 0;
    L4:
        if (r100 >= this.widgets.size()) goto L6;
        ((WidgetRun) ListProtector.get(this.widgets, r100)).applyToWidget();
        r100 = r100 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> r100 = this.widgets.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().clear();
        goto L4
    }

    private void build() {
        ConstraintWidget r100 = this.widget;
        ConstraintWidget r101 = r100.getPreviousChainMember(this.orientation);
    L3:
        ConstraintWidget r102 = r101;
        ConstraintWidget r103 = r100;
        r100 = r102;
        if (r100 == null) goto L6;
        r101 = r100.getPreviousChainMember(this.orientation);
        goto L3
    L6:
        this.widget = r103;
        this.widgets.add(r103.getRun(this.orientation));
        ConstraintWidget r104 = r103.getNextChainMember(this.orientation);
    L7:
        if (r104 == null) goto L9;
        this.widgets.add(r104.getRun(this.orientation));
        r104 = r104.getNextChainMember(this.orientation);
        goto L7
    L9:
        Iterator<WidgetRun> r105 = this.widgets.iterator();
    L11:
        if (r105.hasNext() == false) goto L18;
        WidgetRun r106 = r105.next();
        int r107 = this.orientation;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L11;
        r106.widget.verticalChainRun = this;
        goto L11
    L14:
        r106.widget.horizontalChainRun = this;
        goto L11
    L18:
        if (this.orientation == 0) goto L20;
    L22:
        boolean r108 = false;
    L23:
        if (r108 == false) goto L28;
        if (this.widgets.size() <= 1) goto L28;
        ArrayList<WidgetRun> r109 = this.widgets;
        this.widget = ((WidgetRun) ListProtector.get(r109, r109.size() - 1)).widget;
    L28:
        if (this.orientation != 0) goto L30;
        int r110 = this.widget.getHorizontalChainStyle();
    L31:
        this.chainStyle = r110;
        return;
    L30:
        r110 = this.widget.getVerticalChainStyle();
        goto L31
    L20:
        if (((ConstraintWidgetContainer) this.widget.getParent()).isRtl() == false) goto L22;
        r108 = true;
        goto L23
    }

    private ConstraintWidget getLastVisibleWidget() {
        int r100 = this.widgets.size() - 1;
    L3:
        if (r100 < 0) goto L9;
        WidgetRun r101 = (WidgetRun) ListProtector.get(this.widgets, r100);
        if (r101.widget.getVisibility() != 8) goto L7;
        r100 = r100 - 1;
        goto L3
    L7:
        return r101.widget;
    L9:
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        Iterator<WidgetRun> r100 = this.widgets.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().apply();
        goto L4
    L6:
        int r101 = this.widgets.size();
        if (r101 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r102 = ((WidgetRun) ListProtector.get(this.widgets, 0)).widget;
        ConstraintWidget r103 = ((WidgetRun) ListProtector.get(this.widgets, r101 - 1)).widget;
        if (this.orientation != 0) goto L21;
        ConstraintAnchor r104 = r102.mLeft;
        ConstraintAnchor r105 = r103.mRight;
        DependencyNode r106 = getTarget(r104, 0);
        int r107 = r104.getMargin();
        ConstraintWidget r108 = getFirstVisibleWidget();
        if (r108 == null) goto L14;
        r107 = r108.mLeft.getMargin();
    L14:
        if (r106 == null) goto L16;
        addTarget(this.start, r106, r107);
    L16:
        DependencyNode r109 = getTarget(r105, 0);
        int r110 = r105.getMargin();
        ConstraintWidget r111 = getLastVisibleWidget();
        if (r111 == null) goto L19;
        r110 = r111.mRight.getMargin();
    L19:
        if (r109 == null) goto L31;
        addTarget(this.end, r109, -r110);
    L31:
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        return;
    L21:
        ConstraintAnchor r112 = r102.mTop;
        ConstraintAnchor r113 = r103.mBottom;
        DependencyNode r114 = getTarget(r112, 1);
        int r115 = r112.getMargin();
        ConstraintWidget r116 = getFirstVisibleWidget();
        if (r116 == null) goto L24;
        r115 = r116.mTop.getMargin();
    L24:
        if (r114 == null) goto L26;
        addTarget(this.start, r114, r115);
    L26:
        DependencyNode r117 = getTarget(r113, 1);
        int r118 = r113.getMargin();
        ConstraintWidget r119 = getLastVisibleWidget();
        if (r119 == null) goto L29;
        r118 = r119.mBottom.getMargin();
    L29:
        if (r117 == null) goto L31;
        addTarget(this.end, r117, -r118);
        goto L31
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int r100 = this.widgets.size();
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        WidgetRun r103 = (WidgetRun) ListProtector.get(this.widgets, r102);
        r101 = ((r101 + ((long) r103.start.margin)) + r103.getWrapDimension()) + ((long) r103.end.margin);
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int r100 = this.widgets.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        if (((WidgetRun) ListProtector.get(this.widgets, r101)).supportsWrapComputation() == false) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public String toString() {
        if (this.orientation != 0) goto L5;
        String r100 = "horizontal : ";
    L6:
        String r101 = "ChainRun ".concat(r100);
        Iterator<WidgetRun> r102 = this.widgets.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        String r103 = r101 + "<";
        r101 = (r103 + r102.next()) + "> ";
        goto L8
    L10:
        return r101;
    L5:
        r100 = "vertical : ";
        goto L6
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r210) {
        if (this.start.resolved == true) goto L5;
        return;
    L5:
        if (this.end.resolved == false) goto L333;
        ConstraintWidget r100 = this.widget.getParent();
        if (r100 != null) goto L10;
    L12:
        boolean r101 = false;
    L13:
        int r102 = this.end.value - this.start.value;
        int r103 = this.widgets.size();
        int r104 = 0;
    L14:
        int r105 = -1;
        int r106 = 8;
        if (r104 >= r103) goto L19;
        if (((WidgetRun) ListProtector.get(this.widgets, r104)).widget.getVisibility() != 8) goto L20;
        r104 = r104 + 1;
    L20:
        int r107 = r103 - 1;
        int r108 = r107;
    L21:
        if (r108 < 0) goto L26;
        if (((WidgetRun) ListProtector.get(this.widgets, r108)).widget.getVisibility() != 8) goto L25;
        r108 = r108 - 1;
        goto L21
    L25:
        r105 = r108;
    L26:
        int r109 = 0;
    L28:
        if (r109 >= 2) goto L77;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        float r114 = 0.0f;
    L30:
        if (r110 >= r103) goto L72;
        WidgetRun r115 = (WidgetRun) ListProtector.get(this.widgets, r110);
        if (r115.widget.getVisibility() == r106) goto L71;
        r113 = r113 + 1;
        if (r110 <= 0) goto L38;
        if (r110 < r104) goto L38;
        r111 = r111 + r115.start.margin;
    L38:
        DimensionDependency r116 = r115.dimension;
        int r117 = r116.value;
        if (r115.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L41;
        boolean r118 = true;
    L42:
        if (r118 == false) goto L54;
        int r119 = this.orientation;
        if (r119 != 0) goto L49;
        if (r115.widget.horizontalRun.dimension.resolved == true) goto L49;
        return;
    L49:
        if (r119 == 1) goto L51;
    L53:
        int r120 = r117;
    L62:
        int r121 = r120;
    L63:
        if (r118 == true) goto L67;
        r112 = r112 + 1;
        float r122 = r115.widget.mWeight[this.orientation];
        if (r122 < 0.0f) goto L68;
        r114 = r114 + r122;
    L68:
        if (r110 >= r107) goto L71;
        if (r110 >= r105) goto L71;
        r111 = r111 + (-r115.end.margin);
        goto L71
    L67:
        r111 = r111 + r121;
        goto L68
    L51:
        if (r115.widget.verticalRun.dimension.resolved == true) goto L53;
        return;
    L54:
        r120 = r117;
        if (r115.matchConstraintsType != 1) goto L59;
        if (r109 != 0) goto L59;
        r121 = r116.wrapValue;
        r112 = r112 + 1;
    L61:
        r118 = true;
    L59:
        if (r116.resolved == false) goto L62;
        r121 = r120;
        goto L61
    L41:
        r118 = false;
    L71:
        r110 = r110 + 1;
        r106 = 8;
        goto L30
    L72:
        if (r111 < r102) goto L76;
        if (r112 == 0) goto L76;
        r109 = r109 + 1;
        r106 = 8;
    L76:
        int r123 = r113;
    L78:
        int r124 = this.start.value;
        if (r101 == false) goto L82;
        r124 = this.end.value;
    L82:
        if (r111 > r102) goto L84;
    L87:
        if (r112 <= 0) goto L146;
        float r125 = r102 - r111;
        int r126 = (int) ((r125 / r112) + 0.5f);
        int r127 = 0;
        int r128 = 0;
    L89:
        if (r127 >= r103) goto L124;
        WidgetRun r129 = (WidgetRun) ListProtector.get(this.widgets, r127);
        int r130 = r126;
        int r211 = r111;
        if (r129.widget.getVisibility() != 8) goto L94;
    L122:
        boolean r212 = r101;
        int r213 = r123;
        r124 = r124;
        float r214 = r125;
    L123:
        r127 = r127 + 1;
        r126 = r130;
        r111 = r211;
        r124 = r124;
        r125 = r214;
        r101 = r212;
        r123 = r213;
        goto L89
    L94:
        if (r129.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L122;
        DimensionDependency r131 = r129.dimension;
        if (r131.resolved == true) goto L122;
        if (r114 <= 0.0f) goto L100;
        int r132 = (int) (((r129.widget.mWeight[this.orientation] * r125) / r114) + 0.5f);
    L102:
        if (this.orientation != 0) goto L112;
        ConstraintWidget r133 = r129.widget;
        r214 = r125;
        int r134 = r133.mMatchConstraintMaxWidth;
        int r135 = r133.mMatchConstraintMinWidth;
        r212 = r101;
        r213 = r123;
        if (r129.matchConstraintsType != 1) goto L106;
        int r136 = Math.min(r132, r131.wrapValue);
    L107:
        int r137 = Math.max(r135, r136);
        if (r134 <= 0) goto L110;
        r137 = Math.min(r134, r137);
    L110:
        if (r137 != r132) goto L120;
    L121:
        r129.dimension.resolve(r132);
    L120:
        r128 = r128 + 1;
        r132 = r137;
        goto L121
    L106:
        r136 = r132;
        goto L107
    L112:
        r212 = r101;
        r213 = r123;
        r214 = r125;
        ConstraintWidget r138 = r129.widget;
        int r139 = r138.mMatchConstraintMaxHeight;
        int r140 = r138.mMatchConstraintMinHeight;
        if (r129.matchConstraintsType != 1) goto L115;
        int r141 = Math.min(r132, r131.wrapValue);
    L116:
        r137 = Math.max(r140, r141);
        if (r139 <= 0) goto L119;
        r137 = Math.min(r139, r137);
    L119:
        if (r137 == r132) goto L121;
    L115:
        r141 = r132;
        goto L116
    L100:
        r132 = r130;
        goto L102
    L124:
        boolean r215 = r101;
        int r216 = r123;
        int r217 = r124;
        int r218 = r111;
        if (r128 <= 0) goto L140;
        r112 = r112 - r128;
        int r142 = 0;
        int r143 = 0;
    L127:
        if (r142 >= r103) goto L139;
        WidgetRun r144 = (WidgetRun) ListProtector.get(this.widgets, r142);
        if (r144.widget.getVisibility() == 8) goto L138;
        if (r142 <= 0) goto L134;
        if (r142 < r104) goto L134;
        r143 = r143 + r144.start.margin;
    L134:
        r143 = r143 + r144.dimension.value;
        if (r142 >= r107) goto L138;
        if (r142 >= r105) goto L138;
        r143 = r143 + (-r144.end.margin);
    L138:
        r142 = r142 + 1;
        goto L127
    L139:
        r111 = r143;
    L141:
        int r145 = 2;
        if (this.chainStyle != 2) goto L147;
        if (r128 != 0) goto L147;
        this.chainStyle = 0;
    L147:
        if (r111 <= r102) goto L149;
        this.chainStyle = r145;
    L149:
        if (r216 <= 0) goto L153;
        if (r112 != 0) goto L153;
        if (r104 != r105) goto L153;
        this.chainStyle = r145;
    L153:
        int r146 = this.chainStyle;
        if (r146 != 1) goto L201;
        int r147 = r216;
        if (r147 <= 1) goto L158;
        int r148 = (r102 - r111) / (r147 - 1);
    L161:
        if (r112 <= 0) goto L163;
        r148 = 0;
    L163:
        int r149 = r217;
        int r150 = 0;
    L164:
        if (r150 >= r103) goto L334;
        if (r215 == false) goto L167;
        int r151 = r103 - (r150 + 1);
    L168:
        WidgetRun r152 = (WidgetRun) ListProtector.get(this.widgets, r151);
        if (r152.widget.getVisibility() != 8) goto L171;
        r152.start.resolve(r149);
        r152.end.resolve(r149);
    L200:
        r150 = r150 + 1;
        goto L164
    L171:
        if (r150 <= 0) goto L175;
        if (r215 == false) goto L174;
        r149 = r149 - r148;
        goto L175
    L174:
        r149 = r149 + r148;
    L175:
        if (r150 <= 0) goto L180;
        if (r150 < r104) goto L180;
        if (r215 == false) goto L179;
        r149 = r149 - r152.start.margin;
        goto L180
    L179:
        r149 = r149 + r152.start.margin;
    L180:
        if (r215 == false) goto L182;
        r152.end.resolve(r149);
    L183:
        DimensionDependency r153 = r152.dimension;
        int r154 = r153.value;
        if (r152.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L186;
    L188:
        if (r215 == false) goto L190;
        r149 = r149 - r154;
    L191:
        if (r215 == false) goto L193;
        r152.start.resolve(r149);
    L194:
        r152.resolved = true;
        if (r150 >= r107) goto L200;
        if (r150 >= r105) goto L200;
        if (r215 == false) goto L199;
        r149 = r149 - (-r152.end.margin);
        goto L200
    L199:
        r149 = r149 + (-r152.end.margin);
        goto L200
    L193:
        r152.end.resolve(r149);
        goto L194
    L190:
        r149 = r149 + r154;
        goto L191
    L186:
        if (r152.matchConstraintsType != 1) goto L188;
        r154 = r153.wrapValue;
        goto L188
    L182:
        r152.start.resolve(r149);
        goto L183
    L167:
        r151 = r150;
        goto L168
    L334:
        return;
    L158:
        if (r147 != 1) goto L160;
        r148 = (r102 - r111) / 2;
        goto L161
    L160:
        r148 = 0;
        goto L161
    L201:
        int r155 = r216;
        if (r146 != 0) goto L243;
        int r156 = (r102 - r111) / (r155 + 1);
        if (r112 <= 0) goto L206;
        r156 = 0;
    L206:
        int r157 = r217;
        int r158 = 0;
    L207:
        if (r158 >= r103) goto L335;
        if (r215 == false) goto L210;
        int r159 = r103 - (r158 + 1);
    L211:
        WidgetRun r160 = (WidgetRun) ListProtector.get(this.widgets, r159);
        if (r160.widget.getVisibility() != 8) goto L214;
        r160.start.resolve(r157);
        r160.end.resolve(r157);
    L241:
        r158 = r158 + 1;
        goto L207
    L214:
        if (r215 == false) goto L216;
        int r161 = r157 - r156;
    L217:
        if (r158 <= 0) goto L222;
        if (r158 < r104) goto L222;
        if (r215 == false) goto L221;
        r161 = r161 - r160.start.margin;
        goto L222
    L221:
        r161 = r161 + r160.start.margin;
    L222:
        if (r215 == false) goto L224;
        r160.end.resolve(r161);
    L225:
        DimensionDependency r162 = r160.dimension;
        int r163 = r162.value;
        if (r160.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L228;
    L230:
        if (r215 == false) goto L232;
        r157 = r161 - r163;
    L233:
        if (r215 == false) goto L235;
        r160.start.resolve(r157);
    L236:
        if (r158 >= r107) goto L241;
        if (r158 >= r105) goto L241;
        if (r215 == false) goto L240;
        r157 = r157 - (-r160.end.margin);
        goto L241
    L240:
        r157 = r157 + (-r160.end.margin);
        goto L241
    L235:
        r160.end.resolve(r157);
        goto L236
    L232:
        r157 = r161 + r163;
        goto L233
    L228:
        if (r160.matchConstraintsType != 1) goto L230;
        r163 = Math.min(r163, r162.wrapValue);
        goto L230
    L224:
        r160.start.resolve(r161);
        goto L225
    L216:
        r161 = r157 + r156;
        goto L217
    L210:
        r159 = r158;
        goto L211
    L335:
        return;
    L243:
        if (r146 == 2) goto L245;
        return;
    L245:
        if (this.orientation != 0) goto L247;
        float r164 = this.widget.getHorizontalBiasPercent();
    L248:
        if (r215 == false) goto L250;
        r164 = 1.0f - r164;
    L250:
        int r165 = (int) (((r102 - r111) * r164) + 0.5f);
        if (r165 < 0) goto L253;
        if (r112 > 0) goto L253;
    L254:
        if (r215 == false) goto L256;
        int r166 = r217 - r165;
    L257:
        int r167 = 0;
    L258:
        if (r167 >= r103) goto L336;
        if (r215 == false) goto L261;
        int r168 = r103 - (r167 + 1);
    L262:
        WidgetRun r169 = (WidgetRun) ListProtector.get(this.widgets, r168);
        if (r169.widget.getVisibility() != 8) goto L265;
        r169.start.resolve(r166);
        r169.end.resolve(r166);
    L290:
        r167 = r167 + 1;
        goto L258
    L265:
        if (r167 <= 0) goto L270;
        if (r167 < r104) goto L270;
        if (r215 == false) goto L269;
        r166 = r166 - r169.start.margin;
        goto L270
    L269:
        r166 = r166 + r169.start.margin;
    L270:
        if (r215 == false) goto L272;
        r169.end.resolve(r166);
    L273:
        DimensionDependency r170 = r169.dimension;
        int r171 = r170.value;
        if (r169.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L279;
        if (r169.matchConstraintsType != 1) goto L279;
        r171 = r170.wrapValue;
    L279:
        if (r215 == false) goto L281;
        r166 = r166 - r171;
    L282:
        if (r215 == false) goto L284;
        r169.start.resolve(r166);
    L285:
        if (r167 >= r107) goto L290;
        if (r167 >= r105) goto L290;
        if (r215 == false) goto L289;
        r166 = r166 - (-r169.end.margin);
        goto L290
    L289:
        r166 = r166 + (-r169.end.margin);
        goto L290
    L284:
        r169.end.resolve(r166);
        goto L285
    L281:
        r166 = r166 + r171;
        goto L282
    L272:
        r169.start.resolve(r166);
        goto L273
    L261:
        r168 = r167;
        goto L262
    L336:
        return;
    L256:
        r166 = r217 + r165;
    L253:
        r165 = 0;
        goto L254
    L247:
        r164 = this.widget.getVerticalBiasPercent();
        goto L248
    L140:
        r111 = r218;
        goto L141
    L146:
        r215 = r101;
        r216 = r123;
        r217 = r124;
        r145 = 2;
        goto L147
    L84:
        if (r101 == false) goto L86;
        r124 = r124 + ((int) (((r111 - r102) / 2.0f) + 0.5f));
        goto L87
    L86:
        r124 = r124 - ((int) (((r111 - r102) / 2.0f) + 0.5f));
        goto L87
    L77:
        r123 = 0;
        r111 = 0;
        r112 = 0;
        r114 = 0.0f;
        goto L78
    L19:
        r104 = -1;
        goto L20
    L10:
        if ((r100 instanceof ConstraintWidgetContainer) == false) goto L12;
        r101 = ((ConstraintWidgetContainer) r100).isRtl();
        goto L13
    }

    public ChainRun(ConstraintWidget r100, int r101) {
        super(r100);
        this.widgets = new ArrayList();
        this.orientation = r101;
        build();
    }
}
