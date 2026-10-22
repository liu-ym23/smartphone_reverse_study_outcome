package F6;

import android.view.View;
import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;
import com.stepos.widget.list.StepOSListItem;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f586a;
    public final /* synthetic */ View b;

    public /* synthetic */ d(int i, View view) {
        this.f586a = i;
        this.b = view;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        int i = this.f586a;
        View view = this.b;
        switch (i) {
            case 0:
                StepOSListItem stepOSListItem = (StepOSListItem) view;
                int[] iArr = StepOSListItem.b0;
                k.f(compoundButton, "<unused var>");
                g gVar = stepOSListItem.g;
                if (gVar != null) {
                    gVar.a(stepOSListItem, z10);
                    break;
                }
                break;
            default:
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = ((Chip) view).e;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
                    break;
                }
                break;
        }
    }
}
