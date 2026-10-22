package com.obric.oui.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import ed.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0011J\u0019\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010%J\u001b\u0010'\u001a\u00020\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010%R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010+¨\u0006-"}, d2 = {"Lcom/obric/oui/image/OImageAppIcon;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "enableClipToMask", "", "setClipToMask", "(Z)V", "backgroundColor", "setImageBackgroundColor", "(I)V", "backgroundColorRes", "setImageBackgroundColorRes", "strokeColor", "setStrokeColor", "strokeColorRes", "setStrokeColorRes", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "packageName", "setImagePackageName", "(Ljava/lang/String;)V", "a", "()I", "f", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "b", "()V", "c", "e", "(Ljava/lang/Integer;)V", "d", "Led/b;", "Led/b;", "styleConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OImageAppIcon extends AppCompatImageView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14863b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f14864a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f14863b = new a(null);
    }

    @JvmOverloads
    public OImageAppIcon(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final int a() {
        b r10 = this.f14864a;
        if (r10 != null) goto L5;
        Integer r11 = null;
    L6:
        if (r11 != null) goto L9;
        return ContextCompat.b(getContext(), R$color.oui_line_1);
    L9:
        return r11.intValue();
    L5:
        r11 = r10.d();
        goto L6
    }

    public final void b() {
        if (getDrawable() == null) goto L16;
        Drawable r10 = getDrawable();
        if ((r10 instanceof ed.a) == false) goto L7;
        ed.a r11 = (ed.a) r10;
    L8:
        if (r11 == null) goto L17;
        b r12 = this.f14864a;
        if (r12 != null) goto L13;
        boolean r13 = false;
    L14:
        r11.e(r13);
        return;
    L13:
        r13 = r12.b();
        goto L14
    L17:
        return;
    L7:
        r11 = null;
        goto L8
    }

    public final void c() {
        if (getDrawable() == null) goto L16;
        Drawable r10 = getDrawable();
        Integer r11 = null;
        if ((r10 instanceof ed.a) == false) goto L7;
        ed.a r12 = (ed.a) r10;
    L8:
        if (r12 == null) goto L17;
        b r13 = this.f14864a;
        if (r13 == null) goto L14;
        r11 = r13.a();
    L14:
        r12.f(r11);
        return;
    L17:
        return;
    L7:
        r12 = null;
        goto L8
    }

    public final void d() {
        if (getDrawable() == null) goto L12;
        Drawable r10 = getDrawable();
        if ((r10 instanceof ed.a) == false) goto L7;
        ed.a r11 = (ed.a) r10;
    L8:
        if (r11 == null) goto L13;
        r11.g(a());
        return;
    L13:
        return;
    L7:
        r11 = null;
        goto L8
    }

    public final void e(Integer r10) {
        b r11 = this.f14864a;
        if (r11 == null) goto L6;
        r11.f(r10);
    L6:
        c();
    }

    public final Drawable f(Drawable r13) {
        Integer r10 = null;
        if (r13 != null) goto L6;
        Log.w("OImageAppIcon", "Skip wrapping because drawable is null");
        return null;
    L6:
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 33) goto L31;
        Log.w("OImageAppIcon", "Skip AppIconDrawable wrapping on API " + r11 + "; requires API 33");
        return r13;
    L31:
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L21
        Context r14 = getContext();     // Catch: Throwable -> L21
        q.f(r14, "context");     // Catch: Throwable -> L21
        b r15 = this.f14864a;     // Catch: Throwable -> L21
        if (r15 != null) goto L13;
    L12:
        Integer r16 = r10;
        int r17 = a();     // Catch: Throwable -> L21
        b r18 = this.f14864a;     // Catch: Throwable -> L21
        if (r18 != null) goto L18;
        boolean r19 = false;
    L19:
        Object r110 = Result.m35constructorimpl(new ed.a(r14, r13, r16, r17, 0.0f, r19, 16, null));     // Catch: Throwable -> L21
    L23:
        Throwable r20 = Result.m38exceptionOrNullimpl(r110);
        if (r20 == null) goto L26;
        Log.w("OImageAppIcon", "Failed to wrap drawable with AppIconDrawable; using original drawable", r20);
    L26:
        Object r111 = r13;
        if (Result.m38exceptionOrNullimpl(r110) != null) goto L30;
        r111 = r110;
    L30:
        return (Drawable) r111;
    L18:
        r19 = r18.b();     // Catch: Throwable -> L21
        goto L19
    L13:
        r10 = r15.a();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.a r21 = Result.Companion;
        r110 = Result.m35constructorimpl(c.a(th));
        goto L23
    }

    public final void setClipToMask(boolean r10) {
        b r11 = this.f14864a;
        if (r11 == null) goto L6;
        r11.g(r10);
    L6:
        b();
    }

    public final void setImageBackgroundColor(@ColorInt int r10) {
        e(Integer.valueOf(r10));
    }

    public final void setImageBackgroundColorRes(@ColorRes int r10) {
        setImageBackgroundColor(ContextCompat.b(getContext(), r10));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r10) {
        super.setImageDrawable(f(r10));
    }

    public final void setImagePackageName(@NotNull String r10) {
        q.g(r10, "packageName");
        if (o.r(r10) == false) goto L17;
        Log.w("OImageAppIcon", "Skip loading app icon because packageName is blank");
        return;
    L17:
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = Result.m35constructorimpl(getContext().getPackageManager().getApplicationIcon(r10));     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.m38exceptionOrNullimpl(r12);
        if (r13 == null) goto L14;
        Log.w("OImageAppIcon", q.p("Failed to load application icon for packageName=", r10), r13);
    L14:
        if (Result.m42isSuccessimpl(r12) == false) goto L19;
        setImageDrawable((Drawable) r12);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.a r14 = Result.Companion;
        r12 = Result.m35constructorimpl(c.a(th));
        goto L10
    }

    public final void setStrokeColor(@ColorInt int r10) {
        b r11 = this.f14864a;
        if (r11 == null) goto L6;
        r11.h(Integer.valueOf(r10));
    L6:
        d();
    }

    public final void setStrokeColorRes(@ColorRes int r10) {
        setStrokeColor(ContextCompat.b(getContext(), r10));
    }

    @JvmOverloads
    public OImageAppIcon(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OImageAppIcon(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OImageAppIcon(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        b r13 = b.a.b(b.f19405f, r10, r11, r12, 0, 8, null);
        this.f14864a = r13;
        b();
        c();
        d();
        if (r13.c() == OImageShape.STANDARD) goto L6;
        Log.w("OImageAppIcon", "Ignoring oui_imageShape=" + r13.c() + " for OImageAppIcon; adaptive icon mask is always used");
        return;
    }
}
