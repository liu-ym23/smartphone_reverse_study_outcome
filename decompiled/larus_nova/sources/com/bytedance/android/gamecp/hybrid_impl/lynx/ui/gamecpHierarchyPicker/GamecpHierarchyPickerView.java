package com.bytedance.android.gamecp.hybrid_impl.lynx.ui.gamecpHierarchyPicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.dux.picker.DuxPicker;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/lynx/ui/gamecpHierarchyPicker/GamecpHierarchyPickerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/dux/picker/DuxPicker;", "getPickerView", "Landroid/widget/TextView;", "getCancelView", "getTitleView", "getConfirmView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamecpHierarchyPickerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f57700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f57701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f57702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxPicker f57703d;

    public GamecpHierarchyPickerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GamecpHierarchyPickerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final TextView getCancelView() {
        return this.f57700a;
    }

    public final TextView getConfirmView() {
        return this.f57702c;
    }

    public final DuxPicker getPickerView() {
        return this.f57703d;
    }

    public final TextView getTitleView() {
        return this.f57701b;
    }

    public GamecpHierarchyPickerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.gamecp_hierarchy_picker_view_layout, this, false);
        this.f57700a = (TextView) r103.findViewById(R.id.gamecp_picker_view_tv_cancel);
        this.f57701b = (TextView) r103.findViewById(R.id.gamecp_picker_view_tv_title);
        this.f57702c = (TextView) r103.findViewById(R.id.gamecp_picker_view_tv_confirm);
        this.f57703d = (DuxPicker) r103.findViewById(R.id.gamecp_picker_view);
        addView(r103);
    }

    public /* synthetic */ GamecpHierarchyPickerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
