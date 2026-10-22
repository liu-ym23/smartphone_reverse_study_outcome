package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.u4;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\n\u0019B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006R*\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/PublicScreenConfigSliderView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/PublicScreenConfigSliderView$a;", "callback", "", "setCallback", "Lla2/a;", "setDisableSettingCallback", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getDisable", "()Z", "setDisable", "(Z)V", "disable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenConfigSliderView extends FrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f140181l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f140182m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f140183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f140184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f140185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f140186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public la2.a f140187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f140188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f140189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f140190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f140191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f140192j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f140193k;

    public interface a {
        void a(int r100);

        void b(float r100);
    }

    public static final class b {
    }

    public PublicScreenConfigSliderView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PublicScreenConfigSliderView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        int r100 = UtilityKotlinExtentionsKt.i(28);
        f140181l = UtilityKotlinExtentionsKt.i(153);
        f140182m = r100;
    }

    public final int a() {
        int r100 = 0;
        float r101 = Math.abs(this.f140184b.getY() - this.f140189g[0]);
        int r102 = 1;
    L4:
        if (r102 > 2) goto L9;
        float r103 = Math.abs(this.f140184b.getY() - this.f140189g[r102]);
        if (r103 >= r101) goto L8;
        r100 = r102;
        r101 = r103;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        return r100;
    }

    public final boolean getDisable() {
        return this.f140183a;
    }

    public final void setCallback(a r100) {
        this.f140186d = r100;
    }

    public final void setDisable(boolean r100) {
        this.f140183a = r100;
        if (r100 == false) goto L5;
        float r101 = 0.5f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 1.0f;
        goto L6
    }

    public final void setDisableSettingCallback(la2.a r100) {
        this.f140187e = r100;
    }

    public final void b(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (2 < r100) goto L13;
        float r102 = this.f140189g[r100];
        if (r101 == false) goto L9;
        u4.c(new PublicScreenConfigSliderView$setPos$1(this, r100, r102)).c();
        return;
    L9:
        this.f140188f = r100;
        this.f140185c.setText(this.f140190h[r100]);
        this.f140184b.setY(r102);
        return;
    }

    public PublicScreenConfigSliderView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f140188f = -1;
        this.f140189g = new float[3];
        String[] r100 = new String[3];
        int r101 = 0;
    L3:
        String r102 = "";
        if (r101 >= 3) goto L6;
        r100[r101] = "";
        r101 = r101 + 1;
        goto L3
    L6:
        this.f140190h = r100;
        LayoutInflater.from(r110).inflate(R.layout.ttlive_public_screen_config_slider_view, this, true);
        setClipChildren(false);
        ViewGroup r103 = (ViewGroup) findViewById(R.id.shade_view);
        this.f140184b = r103;
        this.f140185c = (TextView) findViewById(R.id.shade_view_text);
        TextView r104 = (TextView) findViewById(R.id.tv_top);
        TextView r105 = (TextView) findViewById(R.id.tv_middle);
        TextView r106 = (TextView) findViewById(R.id.tv_bottom);
        float[] r107 = this.f140189g;
        r107[2] = 0.0f;
        float r113 = f140181l - f140182m;
        r107[1] = r113 / 2;
        r107[0] = r113;
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{R.attr.bottom_text, R.attr.middle_text, R.attr.top_text});
        String r115 = r114.getString(0);
        if (r115 != null) goto L9;
        r115 = "";
    L9:
        r100[0] = r115;
        String r116 = r114.getString(1);
        if (r116 != null) goto L12;
        r116 = "";
    L12:
        r100[1] = r116;
        String r117 = r114.getString(2);
        if (r117 == null) goto L16;
        r102 = r117;
    L16:
        r100[2] = r102;
        r106.setText(r100[0]);
        r105.setText(r100[1]);
        r104.setText(r100[2]);
        r104.setOnClickListener(new m(this));
        r105.setOnClickListener(new n(this));
        r106.setOnClickListener(new o(this));
        r103.setOnTouchListener(new p(this));
    }

    public /* synthetic */ PublicScreenConfigSliderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
