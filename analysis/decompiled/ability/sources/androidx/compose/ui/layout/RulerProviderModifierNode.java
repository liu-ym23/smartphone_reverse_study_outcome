package androidx.compose.ui.layout;

import C7.r;
import S7.k;
import android.graphics.Rect;
import androidx.collection.MutableObjectList;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0010\u001a\u00020\r*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0007R#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010-\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.8F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0017\u00108\u001a\b\u0012\u0004\u0012\u000205048F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010;\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Landroidx/compose/ui/layout/RulerProviderModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/layout/InsetsListener;", "insetsListener", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/layout/InsetsListener;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "", "previousGeneration", "I", "getPreviousGeneration", "()I", "setPreviousGeneration", "(I)V", "value", "Landroidx/compose/ui/layout/InsetsListener;", "getInsetsListener", "()Landroidx/compose/ui/layout/InsetsListener;", "setInsetsListener", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "LC7/r;", "rulerLambda", "LS7/k;", "getRulerLambda", "()LS7/k;", "Landroidx/collection/ScatterMap;", "", "Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "getInsetsValues", "()Landroidx/collection/ScatterMap;", "insetsValues", "Landroidx/compose/runtime/MutableIntState;", "getGeneration", "()Landroidx/compose/runtime/MutableIntState;", "generation", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Rect;", "getCutoutRects", "()Landroidx/collection/MutableObjectList;", "cutoutRects", "", "Landroidx/compose/ui/layout/RectRulers;", "getCutoutRulers", "()Ljava/util/List;", "cutoutRulers", "getTraverseKey", "()Ljava/lang/Object;", "traverseKey", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class RulerProviderModifierNode extends Modifier.Node implements LayoutModifierNode, TraversableNode {
    private InsetsListener insetsListener;
    private int previousGeneration = -1;
    private final k rulerLambda;

    public RulerProviderModifierNode(final InsetsListener insetsListener) {
        this.insetsListener = insetsListener;
        this.rulerLambda = new k() { // from class: androidx.compose.ui.layout.RulerProviderModifierNode$rulerLambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RulerScope) obj);
                return r.f317a;
            }

            public final void invoke(RulerScope rulerScope) {
                RulerProviderModifierNode rulerProviderModifierNode = this.this$0;
                rulerProviderModifierNode.setPreviousGeneration(rulerProviderModifierNode.getGeneration().getIntValue());
                if (this.this$0.getPreviousGeneration() > 0) {
                    long jMo5557getSizeYbymL2g = rulerScope.getCoordinates().mo5557getSizeYbymL2g();
                    ScatterMap<Object, WindowWindowInsetsAnimationValues> insetsValues = insetsListener.getInsetsValues();
                    int i = (int) (jMo5557getSizeYbymL2g >> 32);
                    int i6 = (int) (jMo5557getSizeYbymL2g & 4294967295L);
                    WindowInsetsRulers[] windowInsetsRulersArr = WindowInsetsRulers_androidKt.AnimatableInsetsRulers;
                    int length = windowInsetsRulersArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        WindowInsetsRulers windowInsetsRulers = windowInsetsRulersArr[i10];
                        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = insetsValues.get(windowInsetsRulers);
                        kotlin.jvm.internal.k.c(windowWindowInsetsAnimationValues);
                        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                        RulerScope rulerScope2 = rulerScope;
                        WindowInsetsRulers_androidKt.m5672provideInsetsValuescytEWk0(rulerScope2, windowInsetsRulers.getCurrent(), windowWindowInsetsAnimationValues2.getCurrent(), i, i6);
                        if (windowWindowInsetsAnimationValues2.isAnimating()) {
                            WindowInsetsRulers_androidKt.m5672provideInsetsValuescytEWk0(rulerScope2, windowWindowInsetsAnimationValues2.getSource(), windowWindowInsetsAnimationValues2.getSourceValueInsets(), i, i6);
                            WindowInsetsRulers_androidKt.m5672provideInsetsValuescytEWk0(rulerScope2, windowWindowInsetsAnimationValues2.getTarget(), windowWindowInsetsAnimationValues2.getTargetValueInsets(), i, i6);
                        }
                        WindowInsetsRulers_androidKt.m5672provideInsetsValuescytEWk0(rulerScope2, windowInsetsRulers.getMaximum(), windowWindowInsetsAnimationValues2.getMaximum(), i, i6);
                        i10++;
                        rulerScope = rulerScope2;
                    }
                    RulerScope rulerScope3 = rulerScope;
                    if (this.this$0.getCutoutRects().isNotEmpty()) {
                        MutableObjectList<MutableState<Rect>> cutoutRects = this.this$0.getCutoutRects();
                        RulerProviderModifierNode rulerProviderModifierNode2 = this.this$0;
                        Object[] objArr = cutoutRects.content;
                        int i11 = cutoutRects._size;
                        for (int i12 = 0; i12 < i11; i12++) {
                            MutableState mutableState = (MutableState) objArr[i12];
                            RectRulers rectRulers = rulerProviderModifierNode2.getCutoutRulers().get(i12);
                            Rect rect = (Rect) mutableState.getValue();
                            rulerScope3.provides(rectRulers.getLeft(), rect.left);
                            rulerScope3.provides(rectRulers.getTop(), rect.top);
                            rulerScope3.provides(rectRulers.getRight(), rect.right);
                            rulerScope3.provides(rectRulers.getBottom(), rect.bottom);
                        }
                    }
                }
            }
        };
    }

    public final MutableObjectList<MutableState<Rect>> getCutoutRects() {
        return this.insetsListener.getDisplayCutouts();
    }

    public final List<RectRulers> getCutoutRulers() {
        return this.insetsListener.getDisplayCutoutRulers();
    }

    public final MutableIntState getGeneration() {
        return this.insetsListener.getGeneration();
    }

    public final InsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    public final ScatterMap<Object, WindowWindowInsetsAnimationValues> getInsetsValues() {
        return this.insetsListener.getInsetsValues();
    }

    public final int getPreviousGeneration() {
        return this.previousGeneration;
    }

    public final k getRulerLambda() {
        return this.rulerLambda;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return "androidx.compose.ui.layout.WindowInsetsRulers";
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
        return MeasureScope.layout$default(measureScope, placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight(), null, this.rulerLambda, new k() { // from class: androidx.compose.ui.layout.RulerProviderModifierNode$measure$1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, placeableMo5549measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final void setInsetsListener(InsetsListener insetsListener) {
        if (this.insetsListener != insetsListener) {
            this.insetsListener = insetsListener;
            LayoutModifierNodeKt.requestRemeasure(this);
        }
    }

    public final void setPreviousGeneration(int i) {
        this.previousGeneration = i;
    }
}
