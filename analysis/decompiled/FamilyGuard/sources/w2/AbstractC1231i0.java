package w2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;

/* renamed from: w2.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1231i0 extends AbstractViewOnTouchListenerC0600i {

    /* renamed from: U, reason: collision with root package name */
    private final long f23622U;

    public AbstractC1231i0(Context context, long j5) {
        super(context);
        this.f23622U = j5;
        y0(context, j5);
    }

    private void y0(Context context, long j5) {
        this.f15074b = new D2.n(new D2.w(), j5);
        this.f15075c = new D2.p(new D2.y());
        this.f15074b.f(this);
        this.f15075c.f(this);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected int B() {
        return D(E(2));
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected HistogramView a0(Context context, ViewGroup viewGroup) {
        return null;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected RecyclerView.ViewHolder b0(View view) {
        return null;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected HistogramView c0(Context context, ViewGroup viewGroup) {
        return null;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected RecyclerView.ViewHolder d0(View view) {
        return null;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    public void j0(PackageNotificationTimesStats[] packageNotificationTimesStatsArr) {
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    public void v0(NotificationTimesStats[] notificationTimesStatsArr) {
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    public void w0(PickupTimesStats[] pickupTimesStatsArr) {
    }
}
