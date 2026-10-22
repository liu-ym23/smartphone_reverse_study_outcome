package com.obric.oui.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OImageStyleHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J8\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\""}, d2 = {"Lcom/obric/oui/image/OImageStyleConfig;", "", "shape", "Lcom/obric/oui/image/OImageShape;", "strokeEnabled", "", "strokeColor", "", "clipToMask", "(Lcom/obric/oui/image/OImageShape;ZLjava/lang/Integer;Z)V", "getClipToMask", "()Z", "setClipToMask", "(Z)V", "getShape", "()Lcom/obric/oui/image/OImageShape;", "getStrokeColor", "()Ljava/lang/Integer;", "setStrokeColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStrokeEnabled", "component1", "component2", "component3", "component4", "copy", "(Lcom/obric/oui/image/OImageShape;ZLjava/lang/Integer;Z)Lcom/obric/oui/image/OImageStyleConfig;", "equals", "other", "hashCode", "toString", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OImageStyleConfig {
    public static final Companion Companion = null;
    private static final String TAG = "OImageStyleHelper";
    private boolean clipToMask;
    private final OImageShape shape;
    private Integer strokeColor;
    private final boolean strokeEnabled;

    /* JADX INFO: compiled from: OImageStyleHelper.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/image/OImageStyleConfig$Companion;", "", "()V", "TAG", "", "fromAttributes", "Lcom/obric/oui/image/OImageStyleConfig;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ OImageStyleConfig fromAttributes$default(Companion r1, Context r2, AttributeSet r3, int r4, int r5, int r6, Object r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r6 & 8) == 0) goto L9;
            r5 = 0;
        L9:
            return r1.fromAttributes(r2, r3, r4, r5);
        }

        public final OImageStyleConfig fromAttributes(Context r8, AttributeSet r9, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
            Companion r7 = this;     // Catch: Throwable -> L17
            if (r9 != null) goto L6;
            OImageStyleConfig r12 = new OImageStyleConfig(null, false, null, false, 15, null);     // Catch: Throwable -> L17
        L13:
            Object r13 = Result.m803constructorimpl(r12);     // Catch: Throwable -> L17
        L19:
            Throwable r14 = Result.m806exceptionOrNullimpl(r13);
            if (r14 == null) goto L24;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(OImageStyleConfig.TAG, "Failed to parse OImage attrs, fallback to defaults", r14);
            r13 = new OImageStyleConfig(null, false, null, false, 15, null);
        L24:
            return (OImageStyleConfig) r13;
        L6:
            TypedArray r15 = r8.obtainStyledAttributes(r9, R.styleable.OImage, r10, r11);     // Catch: Throwable -> L17
            int r16 = r15.getInt(R.styleable.OImage_oui_imageShape, OImageShape.STANDARD.getAttrValue());     // Catch: Throwable -> L14
            OImageShape r17 = OImageShape.Companion.fromAttrValue(r16);     // Catch: Throwable -> L14
            boolean r18 = r15.getBoolean(R.styleable.OImage_oui_imageStrokeEnabled, true);     // Catch: Throwable -> L14
            if (r15.hasValue(R.styleable.OImage_oui_imageStrokeColor) == false) goto L10;
            int r19 = r15.getColor(R.styleable.OImage_oui_imageStrokeColor, ContextCompat.getColor(r8, R.color.oui_line_1));     // Catch: Throwable -> L14
        L11:
            OImageStyleConfig r110 = new OImageStyleConfig(r17, r18, Integer.valueOf(r19), r15.getBoolean(R.styleable.OImage_oui_clipToMask, false));     // Catch: Throwable -> L14
            r15.recycle();     // Catch: Throwable -> L17
            r12 = r110;
            goto L13
        L10:
            r19 = ContextCompat.getColor(r8, R.color.oui_line_1);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            r15.recycle();     // Catch: Throwable -> L17
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r13 = Result.m803constructorimpl(ResultKt.createFailure(th));
            goto L19
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OImageStyleConfig() {
        this(null, false, null, false, 15, null);
    }

    public static /* synthetic */ OImageStyleConfig copy$default(OImageStyleConfig r0, OImageShape r1, boolean r2, Integer r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.shape;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.strokeEnabled;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.strokeColor;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.clipToMask;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final OImageShape component1() {
        return this.shape;
    }

    public final boolean component2() {
        return this.strokeEnabled;
    }

    public final Integer component3() {
        return this.strokeColor;
    }

    public final boolean component4() {
        return this.clipToMask;
    }

    public final OImageStyleConfig copy(OImageShape r1, boolean r2, Integer r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "shape");
        return new OImageStyleConfig(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OImageStyleConfig) == true) goto L8;
        return false;
    L8:
        OImageStyleConfig r6 = (OImageStyleConfig) r5;
        if (this.shape == r6.shape) goto L12;
        return false;
    L12:
        if (this.strokeEnabled == r6.strokeEnabled) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.strokeColor, r6.strokeColor) == true) goto L18;
        return false;
    L18:
        if (this.clipToMask == r6.clipToMask) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = this.shape.hashCode() * 31;
        boolean r1 = this.strokeEnabled;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.strokeColor;
        if (r5 != null) goto L8;
        int r6 = 0;
    L9:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.clipToMask;
        if (r8 == true) goto L14;
        r2 = r8;
    L14:
        return r7 + r2;
    L8:
        r6 = r5.hashCode();
        goto L9
    }

    public String toString() {
        return "OImageStyleConfig(shape=" + this.shape + ", strokeEnabled=" + this.strokeEnabled + ", strokeColor=" + this.strokeColor + ", clipToMask=" + this.clipToMask + ')';
    }

    public OImageStyleConfig(OImageShape r2, boolean r3, Integer r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "shape");
        this.shape = r2;
        this.strokeEnabled = r3;
        this.strokeColor = r4;
        this.clipToMask = r5;
    }

    public /* synthetic */ OImageStyleConfig(OImageShape r1, boolean r2, Integer r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = OImageShape.STANDARD;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = true;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = null;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = false;
    L14:
        this(r1, r2, r3, r4);
    }

    public final OImageShape getShape() {
        return this.shape;
    }

    public final boolean getStrokeEnabled() {
        return this.strokeEnabled;
    }

    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    public final void setStrokeColor(Integer r1) {
        this.strokeColor = r1;
    }

    public final boolean getClipToMask() {
        return this.clipToMask;
    }

    public final void setClipToMask(boolean r1) {
        this.clipToMask = r1;
    }
}
