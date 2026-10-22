package A2;

import android.content.Context;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public class u extends C<z2.i> {
    @Override // A2.AbstractC0268g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(z2.i iVar) {
        Context context = this.f79b.getContext();
        this.f79b.setText(String.valueOf((int) iVar.l()));
        this.f80c.setText(R.string.us_widget_notification_label);
        if (iVar.j() == 7) {
            this.f81d.setText(context.getString(R.string.us_notification_day_average, Integer.valueOf((int) iVar.d())));
        } else if (iVar.j() == 24) {
            this.f81d.setText(context.getString(R.string.us_notification_hour_average, Integer.valueOf((int) iVar.d())));
        }
    }
}
