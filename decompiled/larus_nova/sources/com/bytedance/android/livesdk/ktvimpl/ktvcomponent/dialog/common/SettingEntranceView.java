package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.a;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/SettingEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SettingEntranceView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f144095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f144096b;

    public SettingEntranceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SettingEntranceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public SettingEntranceView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ViewGroup.inflate(r100, R.layout.ttlive_setting_entrance_layout, this);
        ImageView r103 = (ImageView) findViewById(R.id.setting_iv);
        View r104 = findViewById(R.id.setting_red_dot);
        this.f144095a = r104;
        MultiChorusContext.Companion.getClass();
        if (MultiChorusContext.a.d() == false) goto L14;
        MutableLiveData<d> r105 = KtvComponentContext.Companion.a();
        if (r105 == null) goto L14;
        d r106 = r105.getValue();
        if (r106 == null) goto L14;
        if (r106.f144116a != true) goto L14;
        if (c.f158291o0.getValue().booleanValue() == false) goto L14;
        if (r104 == null) goto L16;
        r104.setVisibility(0);
    L16:
        setOnClickListener(x0.a(new AnonymousClass1(this, r100)));
        if (a.a().isVirtualLive() == false) goto L19;
    L23:
        setVisibility(8);
        return;
    L19:
        if (j.i() == false) goto L21;
    L22:
        setVisibility(0);
        return;
    L21:
        if (KtvUtilsKt.j() == false) goto L23;
    L14:
        if (r104 == null) goto L16;
        r104.setVisibility(8);
        goto L16
    }

    public /* synthetic */ SettingEntranceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
