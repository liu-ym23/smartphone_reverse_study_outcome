package com.android.contacts;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.android.contacts.calllog.CallTypeIconsView;

/* JADX INFO: loaded from: classes.dex */
public final class PhoneCallDetailsViews {
    public final TextView callTypeAndDate;
    public final CallTypeIconsView callTypeIcons;
    public final View callTypeView;
    public final TextView labelView;
    public final TextView nameView;

    private PhoneCallDetailsViews(TextView r1, View r2, CallTypeIconsView r3, TextView r4, TextView r5) {
        this.nameView = r1;
        this.callTypeView = r2;
        this.callTypeIcons = r3;
        this.callTypeAndDate = r4;
        this.labelView = r5;
    }

    public static PhoneCallDetailsViews fromView(View r7) {
        return new PhoneCallDetailsViews((TextView) r7.findViewById(R.id.name), null, (CallTypeIconsView) r7.findViewById(R.id.call_type_icons), (TextView) r7.findViewById(R.id.call_count_and_date), (TextView) r7.findViewById(R.id.number));
    }

    public static PhoneCallDetailsViews createForTest(Context r7) {
        return new PhoneCallDetailsViews(new TextView(r7), new View(r7), new CallTypeIconsView(r7), new TextView(r7), new TextView(r7));
    }
}
