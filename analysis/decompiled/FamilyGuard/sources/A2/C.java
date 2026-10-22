package A2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public abstract class C<Data> extends AbstractC0268g<Data> {

    /* renamed from: b, reason: collision with root package name */
    protected TextView f79b;

    /* renamed from: c, reason: collision with root package name */
    protected TextView f80c;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f81d;

    @Override // A2.AbstractC0268g
    protected View d(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.us_chart_times_info_container_legacy, (ViewGroup) null, false);
        this.f79b = (TextView) viewInflate.findViewById(R.id.times);
        this.f80c = (TextView) viewInflate.findViewById(R.id.times_label);
        TextView textView = (TextView) viewInflate.findViewById(R.id.average_label);
        this.f81d = textView;
        T1.g.c(1.18f, textView);
        T1.g.c(1.18f, this.f80c);
        T1.g.c(1.18f, this.f79b);
        return viewInflate;
    }
}
