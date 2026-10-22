package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECShopCountdownTimerView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/store/view/ECShopCountdownTimerView$a;", "l", "", "setCountdownListener", "", "radiusDp", "setCornerRadius", "", "color", "setTextColor", "setCardBackgroundColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopCountdownTimerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f48732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f48733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CardView f48735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CardView f48736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CardView f48737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f48738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f48739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f48740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f48741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f48742k;

    public interface a {
        void a();

        void b();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopCountdownTimerView f48743a;

        public final void a() {
            long r100 = this.f48743a.f48733b - System.currentTimeMillis();
            if (r100 <= 0) goto L16;
            TimeUnit r101 = TimeUnit.MILLISECONDS;
            long r102 = r101.toHours(r100);
            long r110 = 60;
            long r111 = r101.toMinutes(r100) % r110;
            long r103 = r101.toSeconds(r100) % r110;
            TextView r104 = this.f48743a.f48738g;     // Catch: Throwable -> L29
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("tvHour");     // Catch: Throwable -> L29
        L8:
            StringCompanionObject r105 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L29
            r104.setText(String.format(Locale.getDefault(), "%02d", Arrays.copyOf(new Object[]{Long.valueOf(r102)}, 1)));     // Catch: Throwable -> L29
            TextView r106 = this.f48743a.f48739h;     // Catch: Throwable -> L29
            if (r106 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("tvMinute");     // Catch: Throwable -> L29
        L11:
            r106.setText(String.format(Locale.getDefault(), "%02d", Arrays.copyOf(new Object[]{Long.valueOf(r111)}, 1)));     // Catch: Throwable -> L29
            TextView r107 = this.f48743a.f48740i;     // Catch: Throwable -> L29
            if (r107 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("tvSecond");     // Catch: Throwable -> L29
        L14:
            r107.setText(String.format(Locale.getDefault(), "%02d", Arrays.copyOf(new Object[]{Long.valueOf(r103)}, 1)));     // Catch: Throwable -> L29
        L15:
            this.f48743a.f48732a.postDelayed(this, 1000);
            return;
        L16:
            ECShopCountdownTimerView r108 = this.f48743a;
            r108.f48734c = false;
            r108.f48732a.removeCallbacks(r108.f48742k);
            r108.setVisibility(8);
            TextView r109 = this.f48743a.f48738g;
            if (r109 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("tvHour");
        L19:
            r109.setText(CustomAlbumViewModel.DEFAULT_TAB_ID);
            TextView r112 = this.f48743a.f48739h;
            if (r112 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("tvMinute");
        L22:
            r112.setText(CustomAlbumViewModel.DEFAULT_TAB_ID);
            TextView r113 = this.f48743a.f48740i;
            if (r113 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("tvSecond");
        L25:
            r113.setText(CustomAlbumViewModel.DEFAULT_TAB_ID);
            a r114 = this.f48743a.f48741j;
            if (r114 == null) goto L33;
            r114.b();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ECShopCountdownTimerView r100) {
            this.f48743a = r100;
        }
    }

    public ECShopCountdownTimerView(Context r100) {
        this(r100, null);
    }

    public final void setCardBackgroundColor(int r100) {
        this.f48735d.setCardBackgroundColor(r100);
        this.f48736e.setCardBackgroundColor(r100);
        this.f48737f.setCardBackgroundColor(r100);
    }

    public final void setCornerRadius(float r100) {
        Resources r101 = getContext().getResources();
        float r102 = r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        this.f48735d.setRadius(r102);
        this.f48736e.setRadius(r102);
        this.f48737f.setRadius(r102);
    }

    public final void setCountdownListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.f48741j = r100;
    }

    public final void setTextColor(int r100) {
        TextView r101 = this.f48738g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvHour");
    L5:
        r101.setTextColor(r100);
        TextView r102 = this.f48739h;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tvMinute");
    L8:
        r102.setTextColor(r100);
        TextView r103 = this.f48740i;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tvSecond");
    L11:
        r103.setTextColor(r100);
    }

    public ECShopCountdownTimerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f48732a = new Handler(Looper.getMainLooper());
        this.f48742k = new b(this);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_shop_countdown_timer, this, true);
        this.f48735d = (CardView) findViewById(R.id.cardHour);
        this.f48736e = (CardView) findViewById(R.id.cardMinute);
        this.f48737f = (CardView) findViewById(R.id.cardSecond);
        TextView r102 = (TextView) findViewById(R.id.tvHour);
        this.f48738g = r102;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvHour");
    L5:
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tvHour");
    L7:
        ViewExtensionsKt.e(r102, r102.getPaint(), 500);
        TextView r103 = (TextView) findViewById(R.id.tvMinute);
        this.f48739h = r103;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tvMinute");
    L10:
        ViewExtensionsKt.e(r102, r103.getPaint(), 500);
        TextView r104 = (TextView) findViewById(R.id.tvSecond);
        this.f48740i = r104;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tvSecond");
    L13:
        ViewExtensionsKt.e(r102, r104.getPaint(), 500);
    }
}
