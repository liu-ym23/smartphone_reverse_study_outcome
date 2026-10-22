package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TooltipPopup.java */
/* JADX INFO: loaded from: classes.dex */
class ab {
    private static final String TAG = "TooltipPopup";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f410e;
    private final int[] f;
    private final int[] g;

    ab(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        this.f409d = r0;
        this.f410e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        Context r9 = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.f406a = r9;
        View r2 = ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.abc_tooltip, "layout", "abc_tooltip"), null, "com.obric.aiagent.plugin");
        this.f407b = r2;
        this.f408c = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.message, DbHelper.COL_ID, "message")), TextView.class, "com.obric.aiagent.plugin");
        r0.setTitle(getClass().getSimpleName());
        r0.packageName = r9.getPackageName();
        r0.type = 1002;
        r0.width = -2;
        r0.height = -2;
        r0.format = -3;
        r0.windowAnimations = ZeusTransformUtils.mapRes(R.style.Animation_AppCompat_Tooltip, "style", "Animation_AppCompat_Tooltip");
        r0.flags = 24;
    }

    void a(View r9, int r10, int r11, boolean r12, CharSequence r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (b() == false) goto L5;
        a();
    L5:
        this.f408c.setText(r14);
        a(r9, r10, r11, r12, this.f409d);
        ((WindowManager) ZeusTransformUtils.preCheckCast(this.f406a.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")).addView(this.f407b, this.f409d);
    }

    void a() {
        if (b() == true) goto L5;
        return;
    L5:
        ((WindowManager) ZeusTransformUtils.preCheckCast(this.f406a.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")).removeView(this.f407b);
    }

    boolean b() {
        if (this.f407b.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void a(View r10, int r11, int r12, boolean r13, WindowManager.LayoutParams r14) {
        r14.token = r10.getApplicationWindowToken();
        int r0 = ZeusTransformUtils.getResources(this.f406a, "com.obric.aiagent.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.tooltip_precise_anchor_threshold, "dimen", "tooltip_precise_anchor_threshold"));
        if (r10.getWidth() >= r0) goto L7;
        r11 = r10.getWidth() / 2;
    L7:
        if (r10.getHeight() < r0) goto L9;
        int r1 = ZeusTransformUtils.getResources(this.f406a, "com.obric.aiagent.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.tooltip_precise_anchor_extra_offset, "dimen", "tooltip_precise_anchor_extra_offset"));
        int r2 = r12 + r1;
        int r15 = r12 - r1;
    L10:
        r14.gravity = 49;
        Resources r3 = ZeusTransformUtils.getResources(this.f406a, "com.obric.aiagent.plugin");
        if (r13 == false) goto L13;
        int r5 = R.dimen.tooltip_y_offset_touch;
        String r6 = "tooltip_y_offset_touch";
    L14:
        int r4 = r3.getDimensionPixelOffset(ZeusTransformUtils.mapRes(r5, "dimen", r6));
        View r7 = a(r10);
        if (r7 != null) goto L18;
        a(TAG, "Cannot find app view");
        return;
    L18:
        r7.getWindowVisibleDisplayFrame(this.f410e);
        if (this.f410e.left < 0) goto L21;
    L27:
        r7.getLocationOnScreen(this.g);
        r10.getLocationOnScreen(this.f);
        int[] r16 = this.f;
        int r8 = r16[0];
        int[] r9 = this.g;
        r16[0] = r8 - r9[0];
        r16[1] = r16[1] - r9[1];
        r14.x = (r16[0] + r11) - (r7.getWidth() / 2);
        int r17 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f407b.measure(r17, r17);
        int r18 = this.f407b.getMeasuredHeight();
        int[] r19 = this.f;
        int r20 = ((r19[1] + r15) - r4) - r18;
        int r110 = (r19[1] + r2) + r4;
        if (r13 == false) goto L33;
        if (r20 < 0) goto L31;
        r14.y = r20;
        return;
    L31:
        r14.y = r110;
        return;
    L33:
        if ((r18 + r110) > this.f410e.height()) goto L35;
        r14.y = r110;
        return;
    L35:
        r14.y = r20;
        return;
    L21:
        if (this.f410e.top >= 0) goto L27;
        Resources r21 = ZeusTransformUtils.getResources(this.f406a, "com.obric.aiagent.plugin");
        int r22 = ZeusTransformUtils.getIdentifier(r21, "status_bar_height", "dimen", "android", "com.obric.aiagent.plugin");
        if (r22 == 0) goto L25;
        int r23 = r21.getDimensionPixelSize(r22);
    L26:
        DisplayMetrics r24 = r21.getDisplayMetrics();
        this.f410e.set(0, r23, r24.widthPixels, r24.heightPixels);
        goto L27
    L25:
        r23 = 0;
        goto L26
    L13:
        r5 = R.dimen.tooltip_y_offset_non_touch;
        r6 = "tooltip_y_offset_non_touch";
        goto L14
    L9:
        r2 = r10.getHeight();
        r15 = 0;
        goto L10
    }

    private static View a(View r4) {
        View r0 = r4.getRootView();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, WindowManager.LayoutParams.class) == true) goto L5;
    L7:
        Object r5 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L8:
        Context r6 = (Context) r5;
        if (ZeusTransformUtils.instanceOf(r6, ContextWrapper.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == true) goto L13;
        r5 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r6, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L8
    L13:
        return ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDecorView();
    L15:
        return r0;
    L5:
        if (((WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r1, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin")).type != 2) goto L7;
        return r0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
