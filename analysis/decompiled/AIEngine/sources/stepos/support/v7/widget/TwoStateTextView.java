package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.stepos.aiengine.R;
import com.stepos.core.common.notification.LiveNotification;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TwoStateTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public int f12678a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12679b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12680c;

    /* renamed from: d, reason: collision with root package name */
    public State f12681d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12682e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f12683a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f12684b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ State[] f12685c;

        static {
            State state = new State("COMPLETED", 0);
            f12683a = state;
            State state2 = new State(LiveNotification.EVENT_PROGRESS, 1);
            f12684b = state2;
            f12685c = new State[]{state, state2};
        }

        public State() {
            throw null;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f12685c.clone();
        }
    }

    public TwoStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12678a = 0;
        this.f12682e = false;
        this.f12679b = getContext().getResources().getString(R.string.stepos_action_bar_multi_choice_select_all);
        this.f12680c = getContext().getResources().getString(R.string.stepos_action_bar_multi_choice_select_all_cancel);
        new com.stepos.common.animator.g().b(this, 5, false);
    }

    public void setSelectedCount(int i10) {
        boolean z = this.f12682e;
        State state = State.f12684b;
        State state2 = State.f12683a;
        if (z) {
            this.f12682e = false;
            if (i10 >= this.f12678a) {
                this.f12681d = state2;
                setText(this.f12680c);
                return;
            } else {
                this.f12681d = state;
                setText(this.f12679b);
                return;
            }
        }
        State state3 = this.f12681d;
        if (state3 == state && i10 >= this.f12678a) {
            setText(this.f12680c);
            this.f12681d = state2;
        } else {
            if (state3 != state2 || i10 >= this.f12678a) {
                return;
            }
            setText(this.f12679b);
            this.f12681d = state;
        }
    }

    public void setTotalCount(int i10) {
        this.f12678a = i10;
        this.f12682e = true;
    }
}
