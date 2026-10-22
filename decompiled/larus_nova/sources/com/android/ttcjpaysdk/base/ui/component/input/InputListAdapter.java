package com.android.ttcjpaysdk.base.ui.component.input;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\rH\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/input/InputListAdapter;", "Landroid/widget/BaseAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "items", "", "Lcom/android/ttcjpaysdk/base/ui/component/input/CJInputListItem;", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "layoutInflater", "Landroid/view/LayoutInflater;", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InputListAdapter extends BaseAdapter {
    private final Context context;
    private final List<CJInputListItem> items;
    private final LayoutInflater layoutInflater;

    @Override // android.widget.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r100) {
        return ListProtector.get(this.items, r100);
    }

    public InputListAdapter(Context r100, List<CJInputListItem> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "items");
        this.context = r100;
        this.items = r101;
        this.layoutInflater = LayoutInflater.from(r100);
    }

    @Override // android.widget.Adapter
    public View getView(int r100, View r101, ViewGroup r102) {
        if (r101 != null) goto L5;
        r101 = this.layoutInflater.inflate(R.layout.cj_pay_layout_input_spinner_dialog_item, r102, false);
    L5:
        TextView r103 = (TextView) r101.findViewById(R.id.cj_pay_layout_input_spinner_dialog_item_title);
        r103.setText(((CJInputListItem) ListProtector.get(this.items, r100)).getTitle());
        r103.setTextColor(CJPayThemeUtils.getColor(this.context, R.attr.cj_std_ui_component_textview_color));
        TextView r104 = (TextView) r101.findViewById(R.id.cj_pay_layout_input_spinner_dialog_item_subtitle);
        if (TextUtils.isEmpty(((CJInputListItem) ListProtector.get(this.items, r100)).getSubTitle()) == true) goto L8;
        r104.setText(((CJInputListItem) ListProtector.get(this.items, r100)).getSubTitle());
        r104.setVisibility(0);
    L9:
        r104.setTextColor(CJPayThemeUtils.getColor(this.context, R.attr.cj_std_ui_component_textview_color_60));
        return r101;
    L8:
        r104.setVisibility(8);
        goto L9
    }
}
