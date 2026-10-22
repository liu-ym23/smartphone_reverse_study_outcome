package com.bytedance.android.live.openplatform.impl.base.view.settingdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/settingdialog/SettingItemView;", "Landroid/widget/LinearLayout;", "", "getDescription", "", "getDescriptionColor", "Landroid/view/View;", "getRightView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SettingItemView extends LinearLayout {
    public abstract String getDescription();

    public View getRightView() {
        return null;
    }

    public int getDescriptionColor() {
        return s1.h(R.color.ttlive_uikit_const_tPrimary);
    }

    public SettingItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public SettingItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public SettingItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextView r103 = new TextView(getContext());
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.i(52)));
        setGravity(17);
        setPadding(UtilityKotlinExtentionsKt.i(16), 0, UtilityKotlinExtentionsKt.i(16), 0);
        r103.setText(getDescription());
        r103.setTextSize(14.0f);
        r103.setTextColor(getDescriptionColor());
        Unit r104 = Unit.INSTANCE;
        addView(r103, new LinearLayout.LayoutParams(0, -2, 1.0f));
        View r105 = getRightView();
        if (r105 == null) goto L6;
        addView(r105);
        return;
    }
}
