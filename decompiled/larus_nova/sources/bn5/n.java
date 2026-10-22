package bn5;

import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaPickerFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class n extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormulaPickerFragment f19760a;

    public n(FormulaPickerFragment r100) {
        this.f19760a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        if (r101 != 1) goto L10;
        EditText r102 = this.f19760a.f237999p;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.hasFocus() == false) goto L12;
        this.f19760a.X90();
        return;
    L12:
        return;
    }
}
