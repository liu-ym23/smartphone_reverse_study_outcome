package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.stepos.ability.R;

/* loaded from: classes4.dex */
public class TwoStateTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public int f6594a;
    public final String b;
    public final String c;
    public State d;
    public boolean e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f6595a;
        public static final State b;
        public static final /* synthetic */ State[] c;

        static {
            State state = new State("COMPLETED", 0);
            f6595a = state;
            State state2 = new State("PROGRESS", 1);
            b = state2;
            c = new State[]{state, state2};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) c.clone();
        }
    }

    public TwoStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6594a = 0;
        this.e = false;
        this.b = getContext().getResources().getString(R.string.stepos_action_bar_multi_choice_select_all);
        this.c = getContext().getResources().getString(R.string.stepos_action_bar_multi_choice_select_all_cancel);
        new com.stepos.common.animator.m().b(this, 5, false);
    }

    public void setSelectedCount(int i) {
        boolean z10 = this.e;
        State state = State.b;
        State state2 = State.f6595a;
        if (z10) {
            this.e = false;
            if (i >= this.f6594a) {
                this.d = state2;
                setText(this.c);
                return;
            } else {
                this.d = state;
                setText(this.b);
                return;
            }
        }
        State state3 = this.d;
        if (state3 == state && i >= this.f6594a) {
            setText(this.c);
            this.d = state2;
        } else {
            if (state3 != state2 || i >= this.f6594a) {
                return;
            }
            setText(this.b);
            this.d = state;
        }
    }

    public void setTotalCount(int i) {
        this.f6594a = i;
        this.e = true;
    }
}
