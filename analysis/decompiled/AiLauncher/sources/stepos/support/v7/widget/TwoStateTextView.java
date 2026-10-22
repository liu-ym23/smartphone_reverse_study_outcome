package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import stepos.support.v7.appcompat.R$string;

/* loaded from: classes5.dex */
public class TwoStateTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public int f41509a;

    /* renamed from: b, reason: collision with root package name */
    public int f41510b;

    /* renamed from: c, reason: collision with root package name */
    public String f41511c;

    /* renamed from: d, reason: collision with root package name */
    public String f41512d;

    /* renamed from: e, reason: collision with root package name */
    public State f41513e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f41514f;

    /* renamed from: g, reason: collision with root package name */
    public com.stepos.common.animator.f f41515g;

    public enum State {
        COMPLETED,
        PROGRESS
    }

    public TwoStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41509a = 0;
        this.f41510b = Integer.MAX_VALUE;
        this.f41514f = false;
        a();
        com.stepos.common.animator.f fVar = new com.stepos.common.animator.f();
        this.f41515g = fVar;
        fVar.f(this, false, com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_SCALE | com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_ALPHA);
    }

    public final void a() {
        this.f41511c = getContext().getResources().getString(R$string.stepos_action_bar_multi_choice_select_all);
        this.f41512d = getContext().getResources().getString(R$string.stepos_action_bar_multi_choice_select_all_cancel);
    }

    public final void b() {
        if (this.f41514f) {
            this.f41514f = false;
            if (this.f41510b >= this.f41509a) {
                this.f41513e = State.COMPLETED;
                setText(this.f41512d);
                return;
            } else {
                this.f41513e = State.PROGRESS;
                setText(this.f41511c);
                return;
            }
        }
        State state = this.f41513e;
        State state2 = State.PROGRESS;
        if (state == state2 && this.f41510b >= this.f41509a) {
            setText(this.f41512d);
            this.f41513e = State.COMPLETED;
        } else {
            if (state != State.COMPLETED || this.f41510b >= this.f41509a) {
                return;
            }
            setText(this.f41511c);
            this.f41513e = state2;
        }
    }

    public void setSelectedCount(int i10) {
        this.f41510b = i10;
        b();
    }

    public void setTotalCount(int i10) {
        this.f41509a = i10;
        this.f41514f = true;
    }
}
