package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.Switch;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/SwitchFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SwitchFrameLayout extends FrameLayout {
    public SwitchFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SwitchFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r100) {
        super.onPopulateAccessibilityEvent(r100);
        boolean r101 = false;
        View r102 = getChildAt(0);
        if ((r102 instanceof Switch) == true) goto L5;
        r102 = null;
    L5:
        Switch r103 = (Switch) r102;
        if (r103 == null) goto L8;
        r101 = r103.isChecked();
    L8:
        String r104 = s1.B(R.string.ttlive_ktv_component_setting_switch_open);
        String r105 = s1.B(R.string.ttlive_ktv_component_setting_switch_close);
        if (r101 == true) goto L12;
        r104 = r105;
    L12:
        if (r100 == null) goto L17;
        List<CharSequence> r106 = r100.getText();
        if (r106 == null) goto L18;
        r106.add(r104);
        return;
    L18:
        return;
    }

    public SwitchFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SwitchFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
