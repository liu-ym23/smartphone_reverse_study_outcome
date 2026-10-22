package androidx.compose.ui.layout;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00198V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010!\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u0014\u0010%\u001a\u00020&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u001c\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001c\u00100\u001a\u00020,X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001c\u00103\u001a\u00020,X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u001c\u00106\u001a\u00020,X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001e¨\u00069"}, d2 = {"Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "Landroidx/compose/ui/layout/PlatformWindowInsetsAnimation;", "name", "", "<init>", "(Ljava/lang/String;)V", "<set-?>", "", "isVisible", "()Z", "setVisible", "(Z)V", "isVisible$delegate", "Landroidx/compose/runtime/MutableState;", "isAnimating", "setAnimating", "isAnimating$delegate", "", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "", "durationMillis", "getDurationMillis", "()J", "setDurationMillis", "(J)V", "durationMillis$delegate", "Landroidx/compose/runtime/MutableLongState;", "alpha", "getAlpha", "setAlpha", "alpha$delegate", "source", "Landroidx/compose/ui/layout/RectRulers;", "getSource", "()Landroidx/compose/ui/layout/RectRulers;", PickerReporterConstants.KEY.TARGET, "getTarget", "current", "Landroidx/compose/ui/layout/ValueInsets;", "getCurrent-hdzbrEE", "setCurrent-Ynlvx88", "J", "maximum", "getMaximum-hdzbrEE", "setMaximum-Ynlvx88", "sourceValueInsets", "getSourceValueInsets-hdzbrEE", "setSourceValueInsets-Ynlvx88", "targetValueInsets", "getTargetValueInsets-hdzbrEE", "setTargetValueInsets-Ynlvx88", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WindowWindowInsetsAnimationValues implements PlatformWindowInsetsAnimation {
    public static final int $stable = 8;
    private final MutableFloatState alpha$delegate;
    private long current;
    private final MutableLongState durationMillis$delegate;
    private final MutableFloatState fraction$delegate;
    private final MutableState isAnimating$delegate;
    private final MutableState isVisible$delegate;
    private long maximum;
    private final RectRulers source;
    private long sourceValueInsets;
    private final RectRulers target;
    private long targetValueInsets;

    @Override // androidx.compose.ui.layout.WindowInsetsAnimation
    public float getAlpha() {
        return this.alpha$delegate.getFloatValue();
    }

    @Override // androidx.compose.ui.layout.WindowInsetsAnimation
    public long getDurationMillis() {
        return this.durationMillis$delegate.getLongValue();
    }

    @Override // androidx.compose.ui.layout.WindowInsetsAnimation
    public float getFraction() {
        return this.fraction$delegate.getFloatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.WindowInsetsAnimation
    public boolean isAnimating() {
        return ((Boolean) this.isAnimating$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.WindowInsetsAnimation
    public boolean isVisible() {
        return ((Boolean) this.isVisible$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getCurrent-hdzbrEE, reason: not valid java name */
    public final long m6384getCurrenthdzbrEE() {
        return this.current;
    }

    /* JADX INFO: renamed from: getMaximum-hdzbrEE, reason: not valid java name */
    public final long m6385getMaximumhdzbrEE() {
        return this.maximum;
    }

    @Override // androidx.compose.ui.layout.WindowInsetsAnimation
    public RectRulers getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: getSourceValueInsets-hdzbrEE, reason: not valid java name */
    public final long m6386getSourceValueInsetshdzbrEE() {
        return this.sourceValueInsets;
    }

    @Override // androidx.compose.ui.layout.WindowInsetsAnimation
    public RectRulers getTarget() {
        return this.target;
    }

    /* JADX INFO: renamed from: getTargetValueInsets-hdzbrEE, reason: not valid java name */
    public final long m6387getTargetValueInsetshdzbrEE() {
        return this.targetValueInsets;
    }

    public WindowWindowInsetsAnimationValues(String r100) {
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.isAnimating$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.fraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.durationMillis$delegate = SnapshotLongStateKt.mutableLongStateOf(0);
        this.alpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
        this.source = RectRulersKt.RectRulers(r100 + " source");
        this.target = RectRulersKt.RectRulers(r100 + " target");
        this.current = ValueInsets_androidKt.getUnsetValueInsets();
        this.maximum = ValueInsets_androidKt.getUnsetValueInsets();
        this.sourceValueInsets = ValueInsets_androidKt.getUnsetValueInsets();
        this.targetValueInsets = ValueInsets_androidKt.getUnsetValueInsets();
    }

    public void setAlpha(float r100) {
        this.alpha$delegate.setFloatValue(r100);
    }

    public void setAnimating(boolean r100) {
        this.isAnimating$delegate.setValue(Boolean.valueOf(r100));
    }

    /* JADX INFO: renamed from: setCurrent-Ynlvx88, reason: not valid java name */
    public final void m6388setCurrentYnlvx88(long r100) {
        this.current = r100;
    }

    public void setDurationMillis(long r100) {
        this.durationMillis$delegate.setLongValue(r100);
    }

    public void setFraction(float r100) {
        this.fraction$delegate.setFloatValue(r100);
    }

    /* JADX INFO: renamed from: setMaximum-Ynlvx88, reason: not valid java name */
    public final void m6389setMaximumYnlvx88(long r100) {
        this.maximum = r100;
    }

    /* JADX INFO: renamed from: setSourceValueInsets-Ynlvx88, reason: not valid java name */
    public final void m6390setSourceValueInsetsYnlvx88(long r100) {
        this.sourceValueInsets = r100;
    }

    /* JADX INFO: renamed from: setTargetValueInsets-Ynlvx88, reason: not valid java name */
    public final void m6391setTargetValueInsetsYnlvx88(long r100) {
        this.targetValueInsets = r100;
    }

    public void setVisible(boolean r100) {
        this.isVisible$delegate.setValue(Boolean.valueOf(r100));
    }
}
