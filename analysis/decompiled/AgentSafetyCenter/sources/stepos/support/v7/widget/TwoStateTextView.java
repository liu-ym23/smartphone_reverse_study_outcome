package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class TwoStateTextView extends TextView {

    /* renamed from: c, reason: collision with root package name */
    public int f12704c;

    /* renamed from: f, reason: collision with root package name */
    public final String f12705f;

    /* renamed from: g, reason: collision with root package name */
    public final String f12706g;

    /* renamed from: h, reason: collision with root package name */
    public int f12707h;
    public boolean i;

    public TwoStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12704c = 0;
        this.i = false;
        this.f12705f = getContext().getResources().getString(R.string.stepos_action_bar_multi_choice_select_all);
        this.f12706g = getContext().getResources().getString(R.string.stepos_action_bar_multi_choice_select_all_cancel);
        new r9.l().b(5, this);
    }

    public void setSelectedCount(int i) {
        if (this.i) {
            this.i = false;
            if (i >= this.f12704c) {
                this.f12707h = 1;
                setText(this.f12706g);
                return;
            } else {
                this.f12707h = 2;
                setText(this.f12705f);
                return;
            }
        }
        int i3 = this.f12707h;
        if (i3 == 2 && i >= this.f12704c) {
            setText(this.f12706g);
            this.f12707h = 1;
        } else {
            if (i3 != 1 || i >= this.f12704c) {
                return;
            }
            setText(this.f12705f);
            this.f12707h = 2;
        }
    }

    public void setTotalCount(int i) {
        this.f12704c = i;
        this.i = true;
    }

    public TwoStateTextView(Context context) {
        this(context, null);
    }
}
