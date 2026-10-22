package androidx.compose.material3;

import C7.r;
import S7.k;
import androidx.annotation.IntRange;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b;\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*R+\u00102\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u00106\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R0\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b\u0018\u0001078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010?\u001a\u00020>8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR+\u0010F\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010-\u001a\u0004\bD\u0010/\"\u0004\bE\u00101R+\u0010J\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010-\u001a\u0004\bH\u0010/\"\u0004\bI\u00101R+\u0010N\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010-\u001a\u0004\bL\u0010/\"\u0004\bM\u00101R+\u0010T\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00058@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010\"\"\u0004\bR\u0010SR+\u0010X\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010-\u001a\u0004\bV\u0010/\"\u0004\bW\u00101R+\u0010\\\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010-\u001a\u0004\bZ\u0010/\"\u0004\b[\u00101R+\u0010c\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR&\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b078\u0000X\u0080\u0004¢\u0006\f\n\u0004\bd\u00109\u001a\u0004\be\u0010;R+\u0010\u0018\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010-\u001a\u0004\bg\u0010/\"\u0004\bh\u00101R+\u0010\u0017\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bi\u0010-\u001a\u0004\bj\u0010/\"\u0004\bk\u00101R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010l\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bm\u0010/\"\u0004\bn\u00101R$\u0010\u0004\u001a\u00020\u00022\u0006\u0010l\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010/\"\u0004\bp\u00101R\u0014\u0010r\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bq\u0010/R\u0014\u0010t\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bs\u0010/R\u0014\u0010v\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bu\u0010\"R\u0014\u0010x\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bw\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006y"}, d2 = {"Landroidx/compose/material3/RangeSliderState;", "", "", "activeRangeStart", "activeRangeEnd", "", "steps", "Lkotlin/Function0;", "LC7/r;", "onValueChangeFinished", "LY7/b;", "valueRange", AppAgent.CONSTRUCT, "(FFILS7/a;LY7/b;)V", "", "isStart", TypedValues.CycleType.S_WAVE_OFFSET, "onDrag$material3_release", "(ZF)V", "onDrag", "updateMinMaxPx$material3_release", "()V", "updateMinMaxPx", "minPx", "maxPx", "Landroidx/compose/material3/SliderRange;", "scaleToUserValue-owVgs5E", "(FFJ)J", "scaleToUserValue", "userValue", "scaleToOffset", "(FFF)F", "I", "getSteps", "()I", "LS7/a;", "getOnValueChangeFinished", "()LS7/a;", "setOnValueChangeFinished", "(LS7/a;)V", "LY7/b;", "getValueRange", "()LY7/b;", "<set-?>", "activeRangeStartState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getActiveRangeStartState", "()F", "setActiveRangeStartState", "(F)V", "activeRangeStartState", "activeRangeEndState$delegate", "getActiveRangeEndState", "setActiveRangeEndState", "activeRangeEndState", "Lkotlin/Function1;", "onValueChange", "LS7/k;", "getOnValueChange$material3_release", "()LS7/k;", "setOnValueChange$material3_release", "(LS7/k;)V", "", "tickFractions", "[F", "getTickFractions$material3_release", "()[F", "trackHeight$delegate", "getTrackHeight$material3_release", "setTrackHeight$material3_release", "trackHeight", "startThumbWidth$delegate", "getStartThumbWidth$material3_release", "setStartThumbWidth$material3_release", "startThumbWidth", "endThumbWidth$delegate", "getEndThumbWidth$material3_release", "setEndThumbWidth$material3_release", "endThumbWidth", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "getTotalWidth$material3_release", "setTotalWidth$material3_release", "(I)V", "totalWidth", "rawOffsetStart$delegate", "getRawOffsetStart$material3_release", "setRawOffsetStart$material3_release", "rawOffsetStart", "rawOffsetEnd$delegate", "getRawOffsetEnd$material3_release", "setRawOffsetEnd$material3_release", "rawOffsetEnd", "isRtl$delegate", "Landroidx/compose/runtime/MutableState;", "isRtl$material3_release", "()Z", "setRtl$material3_release", "(Z)V", "isRtl", "gestureEndAction", "getGestureEndAction$material3_release", "maxPx$delegate", "getMaxPx", "setMaxPx", "minPx$delegate", "getMinPx", "setMinPx", "newVal", "getActiveRangeStart", "setActiveRangeStart", "getActiveRangeEnd", "setActiveRangeEnd", "getCoercedActiveRangeStartAsFraction$material3_release", "coercedActiveRangeStartAsFraction", "getCoercedActiveRangeEndAsFraction$material3_release", "coercedActiveRangeEndAsFraction", "getStartSteps$material3_release", "startSteps", "getEndSteps$material3_release", "endSteps", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RangeSliderState {
    public static final int $stable = 8;

    /* renamed from: activeRangeEndState$delegate, reason: from kotlin metadata */
    private final MutableFloatState activeRangeEndState;

    /* renamed from: activeRangeStartState$delegate, reason: from kotlin metadata */
    private final MutableFloatState activeRangeStartState;

    /* renamed from: endThumbWidth$delegate, reason: from kotlin metadata */
    private final MutableFloatState endThumbWidth;
    private final k gestureEndAction;

    /* renamed from: isRtl$delegate, reason: from kotlin metadata */
    private final MutableState isRtl;

    /* renamed from: maxPx$delegate, reason: from kotlin metadata */
    private final MutableFloatState maxPx;

    /* renamed from: minPx$delegate, reason: from kotlin metadata */
    private final MutableFloatState minPx;
    private k onValueChange;
    private S7.a onValueChangeFinished;

    /* renamed from: rawOffsetEnd$delegate, reason: from kotlin metadata */
    private final MutableFloatState rawOffsetEnd;

    /* renamed from: rawOffsetStart$delegate, reason: from kotlin metadata */
    private final MutableFloatState rawOffsetStart;

    /* renamed from: startThumbWidth$delegate, reason: from kotlin metadata */
    private final MutableFloatState startThumbWidth;
    private final int steps;
    private final float[] tickFractions;

    /* renamed from: totalWidth$delegate, reason: from kotlin metadata */
    private final MutableIntState totalWidth;

    /* renamed from: trackHeight$delegate, reason: from kotlin metadata */
    private final MutableFloatState trackHeight;
    private final Y7.b valueRange;

    public RangeSliderState() {
        this(0.0f, 0.0f, 0, null, null, 31, null);
    }

    private final float getActiveRangeEndState() {
        return this.activeRangeEndState.getFloatValue();
    }

    private final float getActiveRangeStartState() {
        return this.activeRangeStartState.getFloatValue();
    }

    private final float getMaxPx() {
        return this.maxPx.getFloatValue();
    }

    private final float getMinPx() {
        return this.minPx.getFloatValue();
    }

    private final float scaleToOffset(float minPx, float maxPx, float userValue) {
        return SliderKt.scale(Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue(), userValue, minPx, maxPx);
    }

    /* renamed from: scaleToUserValue-owVgs5E, reason: not valid java name */
    private final long m2160scaleToUserValueowVgs5E(float minPx, float maxPx, long offset) {
        return SliderKt.m2273scaleziovWd0(minPx, maxPx, offset, Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue());
    }

    private final void setActiveRangeEndState(float f) {
        this.activeRangeEndState.setFloatValue(f);
    }

    private final void setActiveRangeStartState(float f) {
        this.activeRangeStartState.setFloatValue(f);
    }

    private final void setMaxPx(float f) {
        this.maxPx.setFloatValue(f);
    }

    private final void setMinPx(float f) {
        this.minPx.setFloatValue(f);
    }

    public final float getActiveRangeEnd() {
        return getActiveRangeEndState();
    }

    public final float getActiveRangeStart() {
        return getActiveRangeStartState();
    }

    public final float getCoercedActiveRangeEndAsFraction$material3_release() {
        return SliderKt.calcFraction(Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue(), getActiveRangeEnd());
    }

    public final float getCoercedActiveRangeStartAsFraction$material3_release() {
        return SliderKt.calcFraction(Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue(), getActiveRangeStart());
    }

    public final int getEndSteps$material3_release() {
        return (int) Math.floor((1.0f - getCoercedActiveRangeStartAsFraction$material3_release()) * this.steps);
    }

    public final float getEndThumbWidth$material3_release() {
        return this.endThumbWidth.getFloatValue();
    }

    /* renamed from: getGestureEndAction$material3_release, reason: from getter */
    public final k getGestureEndAction() {
        return this.gestureEndAction;
    }

    /* renamed from: getOnValueChange$material3_release, reason: from getter */
    public final k getOnValueChange() {
        return this.onValueChange;
    }

    public final S7.a getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    public final float getRawOffsetEnd$material3_release() {
        return this.rawOffsetEnd.getFloatValue();
    }

    public final float getRawOffsetStart$material3_release() {
        return this.rawOffsetStart.getFloatValue();
    }

    public final int getStartSteps$material3_release() {
        return (int) Math.floor(getCoercedActiveRangeEndAsFraction$material3_release() * this.steps);
    }

    public final float getStartThumbWidth$material3_release() {
        return this.startThumbWidth.getFloatValue();
    }

    public final int getSteps() {
        return this.steps;
    }

    /* renamed from: getTickFractions$material3_release, reason: from getter */
    public final float[] getTickFractions() {
        return this.tickFractions;
    }

    public final int getTotalWidth$material3_release() {
        return this.totalWidth.getIntValue();
    }

    public final float getTrackHeight$material3_release() {
        return this.trackHeight.getFloatValue();
    }

    public final Y7.b getValueRange() {
        return this.valueRange;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isRtl$material3_release() {
        return ((Boolean) this.isRtl.getValue()).booleanValue();
    }

    public final void onDrag$material3_release(boolean isStart, float offset) {
        long jSliderRange;
        if (isStart) {
            setRawOffsetStart$material3_release(getRawOffsetStart$material3_release() + offset);
            setRawOffsetEnd$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeEnd()));
            float rawOffsetEnd$material3_release = getRawOffsetEnd$material3_release();
            jSliderRange = SliderKt.SliderRange(SliderKt.snapValueToTick(AbstractC1451a.t(getRawOffsetStart$material3_release(), getMinPx(), rawOffsetEnd$material3_release), this.tickFractions, getMinPx(), getMaxPx()), rawOffsetEnd$material3_release);
        } else {
            setRawOffsetEnd$material3_release(getRawOffsetEnd$material3_release() + offset);
            setRawOffsetStart$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeStart()));
            float rawOffsetStart$material3_release = getRawOffsetStart$material3_release();
            jSliderRange = SliderKt.SliderRange(rawOffsetStart$material3_release, SliderKt.snapValueToTick(AbstractC1451a.t(getRawOffsetEnd$material3_release(), rawOffsetStart$material3_release, getMaxPx()), this.tickFractions, getMinPx(), getMaxPx()));
        }
        long jM2160scaleToUserValueowVgs5E = m2160scaleToUserValueowVgs5E(getMinPx(), getMaxPx(), jSliderRange);
        if (SliderRange.m2283equalsimpl0(jM2160scaleToUserValueowVgs5E, SliderKt.SliderRange(getActiveRangeStart(), getActiveRangeEnd()))) {
            return;
        }
        k kVar = this.onValueChange;
        if (kVar == null) {
            setActiveRangeStart(SliderRange.m2285getStartimpl(jM2160scaleToUserValueowVgs5E));
            setActiveRangeEnd(SliderRange.m2284getEndInclusiveimpl(jM2160scaleToUserValueowVgs5E));
        } else if (kVar != null) {
            kVar.invoke(SliderRange.m2280boximpl(jM2160scaleToUserValueowVgs5E));
        }
    }

    public final void setActiveRangeEnd(float f) {
        setActiveRangeEndState(SliderKt.snapValueToTick(AbstractC1451a.t(f, getActiveRangeStart(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue()), this.tickFractions, Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue()));
    }

    public final void setActiveRangeStart(float f) {
        setActiveRangeStartState(SliderKt.snapValueToTick(AbstractC1451a.t(f, Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), getActiveRangeEnd()), this.tickFractions, Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue()));
    }

    public final void setEndThumbWidth$material3_release(float f) {
        this.endThumbWidth.setFloatValue(f);
    }

    public final void setOnValueChange$material3_release(k kVar) {
        this.onValueChange = kVar;
    }

    public final void setOnValueChangeFinished(S7.a aVar) {
        this.onValueChangeFinished = aVar;
    }

    public final void setRawOffsetEnd$material3_release(float f) {
        this.rawOffsetEnd.setFloatValue(f);
    }

    public final void setRawOffsetStart$material3_release(float f) {
        this.rawOffsetStart.setFloatValue(f);
    }

    public final void setRtl$material3_release(boolean z10) {
        this.isRtl.setValue(Boolean.valueOf(z10));
    }

    public final void setStartThumbWidth$material3_release(float f) {
        this.startThumbWidth.setFloatValue(f);
    }

    public final void setTotalWidth$material3_release(int i) {
        this.totalWidth.setIntValue(i);
    }

    public final void setTrackHeight$material3_release(float f) {
        this.trackHeight.setFloatValue(f);
    }

    public final void updateMinMaxPx$material3_release() {
        float f = 2;
        float fMax = Math.max(getTotalWidth$material3_release() - (getEndThumbWidth$material3_release() / f), 0.0f);
        float fMin = Math.min(getStartThumbWidth$material3_release() / f, fMax);
        if (getMinPx() == fMin && getMaxPx() == fMax) {
            return;
        }
        setMinPx(fMin);
        setMaxPx(fMax);
        setRawOffsetStart$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeStart()));
        setRawOffsetEnd$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeEnd()));
    }

    public RangeSliderState(float f, float f7, int i, S7.a aVar, Y7.b bVar, int i6, e eVar) {
        this((i6 & 1) != 0 ? 0.0f : f, (i6 & 2) != 0 ? 1.0f : f7, (i6 & 4) != 0 ? 0 : i, (i6 & 8) != 0 ? null : aVar, (i6 & 16) != 0 ? new Y7.a(0.0f, 1.0f) : bVar);
    }

    public RangeSliderState(float f, float f7, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i, S7.a aVar, Y7.b bVar) {
        this.steps = i;
        this.onValueChangeFinished = aVar;
        this.valueRange = bVar;
        this.activeRangeStartState = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.activeRangeEndState = PrimitiveSnapshotStateKt.mutableFloatStateOf(f7);
        this.tickFractions = SliderKt.stepsToTickFractions(i);
        this.trackHeight = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.startThumbWidth = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.endThumbWidth = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.totalWidth = SnapshotIntStateKt.mutableIntStateOf(0);
        this.rawOffsetStart = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.rawOffsetEnd = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.isRtl = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.gestureEndAction = new k() { // from class: androidx.compose.material3.RangeSliderState$gestureEndAction$1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return r.f317a;
            }

            public final void invoke(boolean z10) {
                S7.a onValueChangeFinished = this.this$0.getOnValueChangeFinished();
                if (onValueChangeFinished != null) {
                    onValueChangeFinished.invoke();
                }
            }
        };
        this.maxPx = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.minPx = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }
}
