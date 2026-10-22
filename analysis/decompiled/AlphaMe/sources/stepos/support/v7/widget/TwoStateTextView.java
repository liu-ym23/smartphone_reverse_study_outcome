package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.stepos.alphame.R;

/* loaded from: classes2.dex */
public class TwoStateTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public int f15043a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15044b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15045c;

    /* renamed from: d, reason: collision with root package name */
    public int f15046d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15047e;

    public TwoStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15043a = 0;
        this.f15047e = false;
        this.f15044b = getContext().getResources().getString(R.string.stepos_action_bar_multi_choice_select_all);
        this.f15045c = getContext().getResources().getString(R.string.stepos_action_bar_multi_choice_select_all_cancel);
        new com.stepos.common.animator.m().b(this, 5, false);
    }

    public void setSelectedCount(int i4) {
        if (this.f15047e) {
            this.f15047e = false;
            if (i4 >= this.f15043a) {
                this.f15046d = 1;
                setText(this.f15045c);
                return;
            } else {
                this.f15046d = 2;
                setText(this.f15044b);
                return;
            }
        }
        int i5 = this.f15046d;
        if (i5 == 2 && i4 >= this.f15043a) {
            setText(this.f15045c);
            this.f15046d = 1;
        } else {
            if (i5 != 1 || i4 >= this.f15043a) {
                return;
            }
            setText(this.f15044b);
            this.f15046d = 2;
        }
    }

    public void setTotalCount(int i4) {
        this.f15043a = i4;
        this.f15047e = true;
    }
}
