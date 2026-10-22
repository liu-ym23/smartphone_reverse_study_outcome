package com.stepos.widget.dialog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/stepos/widget/dialog/StepOSDialogCenterItemAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "resource", "", "textViewResourceId", "entries", "", "itemColor", "Landroid/content/res/ColorStateList;", "itemColors", "<init>", "(Landroid/content/Context;II[Ljava/lang/CharSequence;Landroid/content/res/ColorStateList;[Landroid/content/res/ColorStateList;)V", "[Ljava/lang/CharSequence;", "[Landroid/content/res/ColorStateList;", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "Landroid/view/LayoutInflater;", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "hasStableIds", "", "getItemId", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSDialogCenterItemAdapter extends ArrayAdapter<CharSequence> {
    private final CharSequence[] entries;
    private final LayoutInflater inflater;
    private final ColorStateList itemColor;
    private final ColorStateList[] itemColors;
    private final int resource;
    private final int textViewResourceId;

    public /* synthetic */ StepOSDialogCenterItemAdapter(Context context, int i10, int i11, CharSequence[] charSequenceArr, ColorStateList colorStateList, ColorStateList[] colorStateListArr, int i12, kotlin.jvm.internal.i iVar) {
        this(context, i10, i11, charSequenceArr, (i12 & 16) != 0 ? null : colorStateList, (i12 & 32) != 0 ? null : colorStateListArr);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        kotlin.jvm.internal.p.i(parent, "parent");
        if (convertView == null) {
            convertView = this.inflater.inflate(this.resource, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(this.textViewResourceId);
        textView.setText(this.entries[position]);
        ColorStateList[] colorStateListArr = this.itemColors;
        if (colorStateListArr != null) {
            textView.setTextColor(colorStateListArr[position]);
        } else {
            ColorStateList colorStateList = this.itemColor;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
        kotlin.jvm.internal.p.f(convertView);
        return convertView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSDialogCenterItemAdapter(Context context, int i10, int i11, CharSequence[] entries, ColorStateList colorStateList, ColorStateList[] colorStateListArr) {
        super(context, i10, i11, entries);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(entries, "entries");
        this.resource = i10;
        this.textViewResourceId = i11;
        this.entries = entries;
        this.itemColor = colorStateList;
        this.itemColors = colorStateListArr;
        this.inflater = LayoutInflater.from(context);
    }
}
