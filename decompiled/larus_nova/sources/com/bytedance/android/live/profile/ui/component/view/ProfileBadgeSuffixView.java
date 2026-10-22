package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfileBadgeSuffixView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileBadgeSuffixView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f86799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f86800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f86801c;

    public ProfileBadgeSuffixView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProfileBadgeSuffixView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ProfileBadgeSuffixView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_profile_badge_with_suffix_view, this, true);
        this.f86799a = findViewById(R.id.badge_bg);
        this.f86800b = (HSImageView) findViewById(R.id.badge_icon);
        this.f86801c = (TextView) findViewById(R.id.badge_suffix);
    }

    public /* synthetic */ ProfileBadgeSuffixView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
