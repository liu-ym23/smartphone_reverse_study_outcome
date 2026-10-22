package com.bytedance.android.live.openplatform.impl.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformSwitchButton;", "Landroid/widget/RelativeLayout;", "", "isChecked", "", "setChecked", "Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformSwitchButton$a;", "listener", "setOnCheckedChangeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformSwitchButton extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f84087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f84088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f84089c;

    public interface a {
        void a(OpenPlatformSwitchButton r100, boolean r101, ap0.b.a r102);

        void b();
    }

    public interface b {
        void a(boolean r100);
    }

    public OpenPlatformSwitchButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final View a(int r100) {
        if (this.f84087a != null) goto L5;
        this.f84087a = new LinkedHashMap();
    L5:
        View r101 = this.f84087a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f84087a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setChecked(boolean r100) {
        ((LiveSwitchButton) a(R.id.switch_button)).setChecked(r100);
    }

    public final void setOnCheckedChangeListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f84088b = r100;
    }

    public OpenPlatformSwitchButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public OpenPlatformSwitchButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f84087a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_open_platform_switch_button, this);
        RotatingDrawable r103 = new RotatingDrawable(s1.m(R.drawable.ttlive_open_platform_rotating_icon));
        DrawableCompat.setTint(r103, ColorProtector.parseColor("#4D161823"));
        ((ImageView) a(R.id.loading_img)).setImageDrawable(r103);
        ((LiveSwitchButton) a(R.id.switch_button)).setEnableDrag(false);
        ((LiveSwitchButton) a(R.id.switch_button)).setToggleEventInterceptor(new ap0.b(this));
    }
}
