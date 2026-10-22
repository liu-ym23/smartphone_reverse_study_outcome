package com.bytedance.android.live.ktv.common.commonui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kb0.a;
import kb0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/commonui/CustomViewTab;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkb0/a;", "", "tabName", "", "setTabName", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomViewTab extends ConstraintLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, View> f69477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f69478b;

    public CustomViewTab(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f69477a = new LinkedHashMap();
        c r101 = new c(r100);
        this.f69478b = r101;
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        R5(r101, "TabTextView");
    }

    @Override // kb0.a
    public final void G5(int r100) {
        Intrinsics.checkNotNullParameter("YellowDotView", "customViewName");
        View r101 = getChildAt(indexOfChild((View) ((LinkedHashMap) this.f69477a).get("YellowDotView")));
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    @Override // kb0.a
    public final void c4(boolean r100) {
        this.f69478b.a(false);
        if (r100 == false) goto L6;
        setBackgroundResource(R.drawable.ktv_song_list_tab_unselected_light);
        return;
    }

    @Override // kb0.a
    public final void onSelected(boolean r100) {
        this.f69478b.a(true);
        if (r100 == false) goto L6;
        setBackgroundResource(R.drawable.ktv_song_list_tab_selected_light);
        return;
    }

    @Override // kb0.a
    public void setTabName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        c r101 = this.f69478b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "tabName");
        r101.setText(r100);
    }

    public final void R5(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "customView");
        Intrinsics.checkNotNullParameter(r101, "customViewName");
        removeView(r100);
        addView(r100);
        this.f69477a.put(r101, r100);
    }
}
