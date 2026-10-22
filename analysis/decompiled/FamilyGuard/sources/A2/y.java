package A2;

import android.content.Context;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public class y extends C<z2.k> {
    @Override // A2.AbstractC0268g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(z2.k kVar) {
        Context context = this.f79b.getContext();
        this.f79b.setText(String.valueOf((int) kVar.l()));
        this.f80c.setText(R.string.fg_common_count);
        if (kVar.j() == 7) {
            this.f81d.setText(context.getString(R.string.us_pick_up_day_average, Integer.valueOf((int) kVar.d())));
        } else if (kVar.j() == 24) {
            this.f81d.setText(context.getString(R.string.us_pick_up_hour_average, Integer.valueOf((int) kVar.d())));
        }
    }
}
