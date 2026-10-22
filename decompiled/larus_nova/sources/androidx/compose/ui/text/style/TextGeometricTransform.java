package androidx.compose.ui.text.style;

import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/style/TextGeometricTransform;", "", LiveDegradeFpsAnimator.SCALE_X, "", "skewX", "<init>", "(FF)V", "getScaleX", "()F", "getSkewX", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextGeometricTransform {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final TextGeometricTransform None = null;
    private final float scaleX;
    private final float skewX;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "getNone$ui_text$annotations", "getNone$ui_text", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getNone$ui_text$annotations() {
        }

        public final TextGeometricTransform getNone$ui_text() {
            return TextGeometricTransform.access$getNone$cp();
        }
    }

    public TextGeometricTransform() {
        float r100 = 0.0f;
        this(r100, r100, 3, null);
    }

    static {
        Companion = new Companion(null);
        None = new TextGeometricTransform(1.0f, 0.0f);
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.scaleX) * 31) + Float.floatToIntBits(this.skewX);
    }

    public String toString() {
        return "TextGeometricTransform(scaleX=" + this.scaleX + ", skewX=" + this.skewX + ')';
    }

    public static final /* synthetic */ TextGeometricTransform access$getNone$cp() {
        return None;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getSkewX() {
        return this.skewX;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextGeometricTransform) == true) goto L8;
        return false;
    L8:
        TextGeometricTransform r101 = (TextGeometricTransform) r100;
        if (this.scaleX != r101.scaleX) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        return false;
    L15:
        if (this.skewX != r101.skewX) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == true) goto L20;
        return false;
    L20:
        return true;
    L17:
        r103 = false;
        goto L18
    L11:
        r102 = false;
        goto L12
    }

    public TextGeometricTransform(float r100, float r101) {
        this.scaleX = r100;
        this.skewX = r101;
    }

    public final TextGeometricTransform copy(float r100, float r101) {
        return new TextGeometricTransform(r100, r101);
    }

    public /* synthetic */ TextGeometricTransform(float r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 1.0f;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.0f;
    L8:
        this(r100, r101);
    }

    public static /* synthetic */ TextGeometricTransform copy$default(TextGeometricTransform r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.scaleX;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.skewX;
    L9:
        return r100.copy(r101, r102);
    }
}
