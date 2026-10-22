package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\tJ\u001f\u0010\u0018\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple;", "Landroid/graphics/drawable/RippleDrawable;", "bounded", "", "<init>", "(Z)V", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "rippleRadius", "", "Ljava/lang/Integer;", "setColor", "", "color", "alpha", "", "setColor-DxMtmZc", "(JF)V", "projected", "isProjected", "getDirtyBounds", "Landroid/graphics/Rect;", "trySetRadius", "radius", "calculateRippleColor", "calculateRippleColor-5vOe2sY", "(JF)J", "MRadiusHelper", "Companion", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class UnprojectedRipple extends RippleDrawable {
    public static final Companion Companion = null;
    private static boolean setMaxRadiusFetched;
    private static Method setMaxRadiusMethod;
    private final boolean bounded;
    private boolean projected;
    private Color rippleColor;
    private Integer rippleRadius;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple$Companion;", "", "<init>", "()V", "setMaxRadiusMethod", "Ljava/lang/reflect/Method;", "setMaxRadiusFetched", "", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple$MRadiusHelper;", "", "<init>", "()V", "setRadius", "", "ripple", "Landroid/graphics/drawable/RippleDrawable;", "radius", "", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MRadiusHelper {
        public static final MRadiusHelper INSTANCE = null;

        static {
            INSTANCE = new MRadiusHelper();
        }

        private MRadiusHelper() {
        }

        public final void setRadius(RippleDrawable r100, int r101) {
            r100.setRadius(r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        if (this.bounded == true) goto L5;
        this.projected = true;
    L5:
        Rect r100 = super.getDirtyBounds();
        this.projected = false;
        return r100;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return this.projected;
    }

    public UnprojectedRipple(boolean r100) {
        ColorStateList r101 = ColorStateList.valueOf(-16777216);
        if (r100 == false) goto L5;
        ColorDrawable r102 = new ColorDrawable(-1);
    L6:
        super(r101, null, r102);
        this.bounded = r100;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void trySetRadius(int r100) {
        Integer r101 = this.rippleRadius;
        if (r101 != null) goto L6;
    L7:
        this.rippleRadius = Integer.valueOf(r100);
        if (Build.VERSION.SDK_INT < 23) goto L19;
        MRadiusHelper.INSTANCE.setRadius(this, r100);
        return;
    L19:
    L16:
        Unit r102 = Unit.INSTANCE;
        return;
    L10:
        if (setMaxRadiusFetched == true) goto L12;
        setMaxRadiusFetched = true;     // Catch: Exception -> L16
        setMaxRadiusMethod = RippleDrawable.class.getDeclaredMethod("setMaxRadius", new Class[]{Integer.TYPE});     // Catch: Exception -> L16
    L12:
        Method r103 = setMaxRadiusMethod;     // Catch: Exception -> L16
        if (r103 == null) goto L22;
        r103.invoke(this, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L16
        return;
    L22:
        return;
    L6:
        if (r101.intValue() != r100) goto L7;
    }

    /* JADX INFO: renamed from: calculateRippleColor-5vOe2sY, reason: not valid java name */
    private final long m1835calculateRippleColor5vOe2sY(long r110, float r111) {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        r111 = r111 * 2;
    L6:
        return Color.m4826copywmQWz5c$default(r110, RangesKt.coerceAtMost(r111, 1.0f), 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: renamed from: setColor-DxMtmZc, reason: not valid java name */
    public final void m1836setColorDxMtmZc(long r100, float r101) {
        long r102 = m1835calculateRippleColor5vOe2sY(r100, r101);
        Color r103 = this.rippleColor;
        if (r103 != null) goto L5;
        boolean r104 = false;
    L6:
        if (r104 == true) goto L9;
        this.rippleColor = Color.m4817boximpl(r102);
        setColor(ColorStateList.valueOf(ColorKt.m4881toArgb8_81llA(r102)));
        return;
    L9:
        return;
    L5:
        r104 = Color.m4828equalsimpl0(r103.m4837unboximpl(), r102);
        goto L6
    }
}
