package A2;

import android.content.Context;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public class x extends B<z2.j> {
    @Override // A2.AbstractC0268g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(z2.j jVar) {
        Context context = this.f76b.getContext();
        this.f76b.setText(String.valueOf((int) jVar.l()));
        this.f77c.setText(R.string.fg_common_count);
        if (jVar.j() == 7) {
            this.f78d.setText(context.getString(R.string.us_pick_up_day_average, Integer.valueOf((int) jVar.d())));
        } else if (jVar.j() == 24) {
            this.f78d.setText(context.getString(R.string.us_pick_up_hour_average, Integer.valueOf((int) jVar.d())));
        }
    }
}
