package com.stepos.widget.dialog;

import android.content.Context;
import android.widget.ArrayAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/dialog/StepOSDialogCheckedItemAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "resource", "", "textViewResourceId", "objects", "", "<init>", "(Landroid/content/Context;II[Ljava/lang/CharSequence;)V", "hasStableIds", "", "getItemId", "", "position", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSDialogCheckedItemAdapter extends ArrayAdapter<CharSequence> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSDialogCheckedItemAdapter(Context context, int i10, int i11, CharSequence[] objects) {
        super(context, i10, i11, objects);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(objects, "objects");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
