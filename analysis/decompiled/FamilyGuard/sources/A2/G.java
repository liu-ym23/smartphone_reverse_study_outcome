package A2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.TimeDisplayView;
import f2.C0711p;
import f2.C0712q;

/* loaded from: classes.dex */
public class G extends AbstractC0268g<z2.n> {

    /* renamed from: b, reason: collision with root package name */
    private TimeDisplayView f89b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f90c;

    @Override // A2.AbstractC0268g
    protected View d(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.us_using_time_info_container_legacy, (ViewGroup) null, false);
        this.f89b = (TimeDisplayView) viewInflate.findViewById(R.id.us_digit_container);
        this.f90c = (TextView) viewInflate.findViewById(R.id.description);
        T1.g.e(1.18f, (ViewGroup) viewInflate);
        return viewInflate;
    }

    @Override // A2.AbstractC0268g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(z2.n nVar) throws Resources.NotFoundException {
        UsingTimeStats[] usingTimeStatsArr = (UsingTimeStats[]) nVar.f();
        Context context = this.f89b.getContext();
        this.f89b.setTime(C0711p.l(C0712q.b(usingTimeStatsArr)));
        if (usingTimeStatsArr.length == 7) {
            this.f90c.setText(context.getString(R.string.us_longest_used, C0711p.m(context, C0712q.a(usingTimeStatsArr))));
        } else if (usingTimeStatsArr.length == 24) {
            this.f90c.setText(context.getString(R.string.us_longest_used_in_single_day, C0711p.m(context, C0712q.a(usingTimeStatsArr))));
        }
    }
}
