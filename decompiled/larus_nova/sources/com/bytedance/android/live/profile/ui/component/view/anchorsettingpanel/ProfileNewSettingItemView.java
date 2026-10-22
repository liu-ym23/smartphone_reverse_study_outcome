package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/anchorsettingpanel/ProfileNewSettingItemView;", "Landroid/widget/FrameLayout;", "", "isChecked", "", "setCheckState", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileNewSettingItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f86847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f86848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f86849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f86850d;

    public static final class a {
    }

    static {
    }

    public ProfileNewSettingItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProfileNewSettingItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setCheckState(boolean r100) {
        this.f86847a = r100;
        if (r100 == false) goto L13;
        ImageView r101 = this.f86849c;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        ImageView r102 = this.f86848b;
        if (r102 == null) goto L10;
        r102.setVisibility(8);
    L10:
        TextView r103 = this.f86850d;
        if (r103 == null) goto L23;
        r103.setTextColor(ColorProtector.parseColor("#161823"));
        return;
    L23:
        return;
    L13:
        ImageView r104 = this.f86849c;
        if (r104 == null) goto L16;
        r104.setVisibility(8);
    L16:
        ImageView r105 = this.f86848b;
        if (r105 == null) goto L19;
        r105.setVisibility(0);
    L19:
        TextView r106 = this.f86850d;
        if (r106 == null) goto L25;
        r106.setTextColor(ColorProtector.parseColor("#80161823"));
        return;
    }

    public ProfileNewSettingItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_profile_anchor_setting_panel_item, this, true);
        this.f86848b = (ImageView) findViewById(R.id.unchecked_icon);
        this.f86849c = (ImageView) findViewById(R.id.checked_icon);
        this.f86850d = (TextView) findViewById(R.id.item_text);
    }

    public /* synthetic */ ProfileNewSettingItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
