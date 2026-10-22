package com.obric.immersive;

import android.view.View;
import kotlin.Metadata;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: Immersive.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/immersive/ImmersiveCallback;", "", "immersive", "Lcom/obric/immersive/Immersive;", "getImmersive", "()Lcom/obric/immersive/Immersive;", "onNavigationBarHeightChanged", "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "onStatusBarHeightChanged", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ImmersiveCallback {

    /* JADX INFO: compiled from: Immersive.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onStatusBarHeightChanged(ImmersiveCallback r3, int r4) {
            View r5 = r3.getImmersive().getRootContent();
            if (r5 == null) goto L6;
            r5.setPadding(r5.getPaddingLeft(), r4, r5.getPaddingRight(), r5.getPaddingBottom());
            return;
        }

        public static void onNavigationBarHeightChanged(ImmersiveCallback r3, int r4) {
            View r5 = r3.getImmersive().getRootContent();
            if (r5 == null) goto L6;
            r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r4);
            return;
        }
    }

    Immersive getImmersive();

    void onNavigationBarHeightChanged(int r1);

    void onStatusBarHeightChanged(int r1);
}
