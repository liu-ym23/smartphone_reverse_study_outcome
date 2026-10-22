package com.obric.oui.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OImageAppIcon.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OImageAppIcon extends AppCompatImageView {
    public static final a Companion = null;
    private static final String TAG = "OImageAppIcon";
    private b styleConfig;

    /* JADX INFO: compiled from: OImageAppIcon.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OImageAppIcon(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OImageAppIcon(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public /* synthetic */ OImageAppIcon(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OImageAppIcon(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        super(r3, r4, r12);
        b r13 = b.a.a(b.f35293a, r3, r4, r12, 0, 8, null);
        this.styleConfig = r13;
        syncClipToMask();
        syncImageBackgroundColor();
        syncStrokeColor();
        if (r13.a() == com.obric.oui.image.a.f35289b) goto L6;
        INVOKESTATIC_com_obric_oui_image_OImageAppIcon_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Ignoring oui_imageShape=" + r13.a() + " for OImageAppIcon; adaptive icon mask is always used");
        return;
    }

    public final void setClipToMask(boolean r2) {
        b r0 = this.styleConfig;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        syncClipToMask();
    }

    public final void setImageBackgroundColor(int r1) {
        updateImageBackgroundColor(Integer.valueOf(r1));
    }

    public final void setImageBackgroundColorRes(int r4) {
        setImageBackgroundColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public final void clearImageBackgroundColor() {
        updateImageBackgroundColor(null);
    }

    public final void setStrokeColor(int r2) {
        b r0 = this.styleConfig;
        if (r0 == null) goto L6;
        r0.b(Integer.valueOf(r2));
    L6:
        syncStrokeColor();
    }

    public final void setStrokeColorRes(int r4) {
        setStrokeColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(wrapForAppIconStroke(r1));
    }

    public final void setImagePackageName(String r6) {
        o.e(r6, "packageName");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L17;
        INVOKESTATIC_com_obric_oui_image_OImageAppIcon_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Skip loading app icon because packageName is blank");
        return;
    L17:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L8
        Object r1 = n.f(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((OImageAppIcon) ZeusTransformUtils.preCheckCast(this, OImageAppIcon.class, "com.obric.aiagent.plugin")).getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationIcon(r6));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = n.c(r1);
        if (r3 == null) goto L14;
        INVOKESTATIC_com_obric_oui_image_OImageAppIcon_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, o.a("Failed to load application icon for packageName=", r6), r3);
    L14:
        if (n.a(r1) == false) goto L19;
        setImageDrawable((Drawable) ZeusTransformUtils.preCheckCast(r1, Drawable.class, "com.obric.aiagent.plugin"));
        return;
    L19:
        return;
    L8:
        th = move-exception;
        n.a r4 = n.f38560a;
        r1 = n.f(d.o.a(th));
        goto L10
    }

    private final Drawable wrapForAppIconStroke(Drawable r14) {
        Integer r1 = null;
        if (r14 != null) goto L7;
        INVOKESTATIC_com_obric_oui_image_OImageAppIcon_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Skip wrapping because drawable is null");
        return null;
    L7:
        if (Build.VERSION.SDK_INT >= 33) goto L31;
        INVOKESTATIC_com_obric_oui_image_OImageAppIcon_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Skip AppIconDrawable wrapping on API " + Build.VERSION.SDK_INT + "; requires API 33");
        return r14;
    L31:
        n.a r3 = n.f38560a;     // Catch: Throwable -> L21
        OImageAppIcon r13 = (OImageAppIcon) ZeusTransformUtils.preCheckCast(this, OImageAppIcon.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        o.c(r4, "context");     // Catch: Throwable -> L21
        b r5 = r13.styleConfig;     // Catch: Throwable -> L21
        if (r5 == null) goto L14;
        r1 = r5.c();     // Catch: Throwable -> L21
    L14:
        Integer r6 = r1;
        int r7 = r13.resolveStrokeColor();     // Catch: Throwable -> L21
        b r15 = r13.styleConfig;     // Catch: Throwable -> L21
        if (r15 != null) goto L18;
        boolean r16 = false;
    L19:
        Object r17 = n.f(new AppIconDrawable(r4, r14, r6, r7, 0.0f, r16, 16, null));     // Catch: Throwable -> L21
    L23:
        Throwable r2 = n.c(r17);
        if (r2 == null) goto L26;
        INVOKESTATIC_com_obric_oui_image_OImageAppIcon_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to wrap drawable with AppIconDrawable; using original drawable", r2);
    L26:
        Object r18 = r14;
        if (n.c(r17) != null) goto L30;
        r18 = r17;
    L30:
        return (Drawable) ZeusTransformUtils.preCheckCast(r18, Drawable.class, "com.obric.aiagent.plugin");
    L18:
        r16 = r15.e();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        n.a r8 = n.f38560a;
        r17 = n.f(d.o.a(th));
        goto L23
    }

    private final void syncClipToMask() {
        if (getDrawable() == null) goto L16;
        Drawable r0 = getDrawable();
        if (ZeusTransformUtils.instanceOf(r0, AppIconDrawable.class) == false) goto L7;
        AppIconDrawable r1 = (AppIconDrawable) ZeusTransformUtils.preCheckCast(r0, AppIconDrawable.class, "com.obric.aiagent.plugin");
    L8:
        if (r1 == null) goto L17;
        b r3 = this.styleConfig;
        if (r3 != null) goto L13;
        boolean r4 = false;
    L14:
        r1.setClipToMask(r4);
        return;
    L13:
        r4 = r3.e();
        goto L14
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void syncImageBackgroundColor() {
        if (getDrawable() == null) goto L16;
        Drawable r0 = getDrawable();
        Integer r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, AppIconDrawable.class) == false) goto L7;
        AppIconDrawable r1 = (AppIconDrawable) ZeusTransformUtils.preCheckCast(r0, AppIconDrawable.class, "com.obric.aiagent.plugin");
    L8:
        if (r1 == null) goto L17;
        b r4 = this.styleConfig;
        if (r4 == null) goto L14;
        r2 = r4.c();
    L14:
        r1.setIconBackgroundColor(r2);
        return;
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void updateImageBackgroundColor(Integer r2) {
        b r0 = this.styleConfig;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        syncImageBackgroundColor();
    }

    private final void syncStrokeColor() {
        if (getDrawable() == null) goto L12;
        Drawable r0 = getDrawable();
        if (ZeusTransformUtils.instanceOf(r0, AppIconDrawable.class) == false) goto L7;
        AppIconDrawable r1 = (AppIconDrawable) ZeusTransformUtils.preCheckCast(r0, AppIconDrawable.class, "com.obric.aiagent.plugin");
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
        b r0 = this.styleConfig;
        if (r0 != null) goto L5;
        Integer r1 = null;
    L6:
        if (r1 != null) goto L9;
        return androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_line_1, "color", "oui_line_1"));
    L9:
        return r1.intValue();
    L5:
        r1 = r0.d();
        goto L6
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_image_OImageAppIcon_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_image_OImageAppIcon_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
