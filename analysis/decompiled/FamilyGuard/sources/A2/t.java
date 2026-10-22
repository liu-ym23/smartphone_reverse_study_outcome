package A2;

import android.content.Context;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public class t extends B<z2.h> {
    @Override // A2.AbstractC0268g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(z2.h hVar) {
        Context context = this.f76b.getContext();
        this.f76b.setText(String.valueOf((int) hVar.l()));
        this.f77c.setText(R.string.us_widget_notification_label);
        if (hVar.j() == 7) {
            this.f78d.setText(context.getString(R.string.us_notification_day_average, Integer.valueOf((int) hVar.d())));
        } else if (hVar.j() == 24) {
            this.f78d.setText(context.getString(R.string.us_notification_hour_average, Integer.valueOf((int) hVar.d())));
        }
    }
}
