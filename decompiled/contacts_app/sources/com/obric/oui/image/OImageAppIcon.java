package com.obric.oui.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OImageAppIcon.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/image/OImageAppIcon;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "styleConfig", "Lcom/obric/oui/image/OImageStyleConfig;", "resolveStrokeColor", "setClipToMask", "", "enableClipToMask", "", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setImagePackageName", "packageName", "", "setStrokeColor", "strokeColor", "setStrokeColorRes", "strokeColorRes", "syncClipToMask", "syncStrokeColor", "wrapForAppIconStroke", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OImageAppIcon extends AppCompatImageView {
    public static final Companion Companion = null;
    private static final String TAG = "OImageAppIcon";
    private OImageStyleConfig styleConfig;

    /* JADX INFO: compiled from: OImageAppIcon.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/image/OImageAppIcon$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OImageAppIcon(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OImageAppIcon(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OImageAppIcon(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OImageAppIcon(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        OImageStyleConfig r12 = OImageStyleConfig.Companion.fromAttributes$default(OImageStyleConfig.Companion, r9, r10, r11, 0, 8, null);
        this.styleConfig = r12;
        syncClipToMask();
        syncStrokeColor();
        if (r12.getShape() == OImageShape.STANDARD) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Ignoring oui_imageShape=" + r12.getShape() + " for OImageAppIcon; adaptive icon mask is always used");
        return;
    }

    public final void setClipToMask(boolean r2) {
        OImageStyleConfig r0 = this.styleConfig;
        if (r0 == null) goto L6;
        r0.setClipToMask(r2);
    L6:
        syncClipToMask();
    }

    public final void setStrokeColor(int r2) {
        OImageStyleConfig r0 = this.styleConfig;
        if (r0 == null) goto L6;
        r0.setStrokeColor(Integer.valueOf(r2));
    L6:
        syncStrokeColor();
    }

    public final void setStrokeColorRes(int r2) {
        setStrokeColor(ContextCompat.getColor(getContext(), r2));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(wrapForAppIconStroke(r1));
    }

    public final void setImagePackageName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        if (StringsKt.isBlank(r5) == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Skip loading app icon because packageName is blank");
        return;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        OImageAppIcon r1 = this;     // Catch: Throwable -> L8
        Object r2 = Result.m803constructorimpl(getContext().getPackageManager().getApplicationIcon(r5));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.m806exceptionOrNullimpl(r2);
        if (r3 == null) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, Intrinsics.stringPlus("Failed to load application icon for packageName=", r5), r3);
    L14:
        if (Result.m810isSuccessimpl(r2) == false) goto L19;
        setImageDrawable((Drawable) r2);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final Drawable wrapForAppIconStroke(Drawable r11) {
        if (r11 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Skip wrapping because drawable is null");
        return null;
    L7:
        if (Build.VERSION.SDK_INT >= 33) goto L27;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Skip AppIconDrawable wrapping on API " + Build.VERSION.SDK_INT + "; requires API 33");
        return r11;
    L27:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        OImageAppIcon r2 = this;     // Catch: Throwable -> L17
        Context r3 = getContext();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r3, "context");     // Catch: Throwable -> L17
        int r5 = resolveStrokeColor();     // Catch: Throwable -> L17
        OImageStyleConfig r10 = this.styleConfig;     // Catch: Throwable -> L17
        if (r10 != null) goto L14;
        boolean r12 = false;
    L15:
        Object r13 = Result.m803constructorimpl(new AppIconDrawable(r3, r11, r5, 0.0f, r12, 8, null));     // Catch: Throwable -> L17
    L19:
        Throwable r4 = Result.m806exceptionOrNullimpl(r13);
        if (r4 == null) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to wrap drawable with AppIconDrawable; using original drawable", r4);
    L22:
        Object r14 = r11;
        if (Result.m806exceptionOrNullimpl(r13) != null) goto L26;
        r14 = r13;
    L26:
        return (Drawable) r14;
    L14:
        r12 = r10.getClipToMask();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r13 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    private final void syncClipToMask() {
        if (getDrawable() == null) goto L16;
        Drawable r0 = getDrawable();
        if ((r0 instanceof AppIconDrawable) == false) goto L7;
        AppIconDrawable r1 = (AppIconDrawable) r0;
    L8:
        if (r1 == null) goto L17;
        OImageStyleConfig r2 = this.styleConfig;
        if (r2 != null) goto L13;
        boolean r3 = false;
    L14:
        r1.setClipToMask(r3);
        return;
    L13:
        r3 = r2.getClipToMask();
        goto L14
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void syncStrokeColor() {
        if (getDrawable() == null) goto L12;
        Drawable r0 = getDrawable();
        if ((r0 instanceof AppIconDrawable) == false) goto L7;
        AppIconDrawable r1 = (AppIconDrawable) r0;
    L8:
        if (r1 == null) goto L13;
        r1.setStrokeColor(resolveStrokeColor());
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final int resolveStrokeColor() {
        OImageStyleConfig r0 = this.styleConfig;
        if (r0 != null) goto L5;
        Integer r1 = null;
    L6:
        if (r1 != null) goto L9;
        return ContextCompat.getColor(getContext(), R.color.oui_line_1);
    L9:
        return r1.intValue();
    L5:
        r1 = r0.getStrokeColor();
        goto L6
    }
}
