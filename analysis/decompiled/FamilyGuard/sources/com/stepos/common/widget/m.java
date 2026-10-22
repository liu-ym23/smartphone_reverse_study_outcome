package com.stepos.common.widget;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.stepos.common.widget.TimePicker;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class m extends AlertDialog implements TimePicker.b {

    /* renamed from: a, reason: collision with root package name */
    private final TimePicker f14441a;

    /* renamed from: b, reason: collision with root package name */
    private final c f14442b;

    /* renamed from: c, reason: collision with root package name */
    int f14443c;

    /* renamed from: d, reason: collision with root package name */
    int f14444d;

    /* renamed from: e, reason: collision with root package name */
    boolean f14445e;

    /* renamed from: f, reason: collision with root package name */
    private TimePicker.b f14446f;

    class a implements View.OnLayoutChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f14447a;

        a(View view) {
            this.f14447a = view;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f14447a.removeOnLayoutChangeListener(this);
            LinearLayout linearLayout = (LinearLayout) m.this.findViewById(R.id.extractArea);
            if (linearLayout != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                linearLayout.setLayoutParams(layoutParams);
            }
        }
    }

    private static class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<m> f14449a;

        /* synthetic */ b(m mVar, a aVar) {
            this(mVar);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i5) {
            m mVar = this.f14449a.get();
            if (mVar == null || mVar.f14442b == null) {
                return;
            }
            mVar.f14441a.clearFocus();
            mVar.f14442b.a(mVar.f14441a, mVar.f14441a.getCurrentHour(), mVar.f14441a.getCurrentMinute().intValue());
        }

        private b(m mVar) {
            this.f14449a = new WeakReference<>(mVar);
        }
    }

    public interface c {
        void a(TimePicker timePicker, int i5, int i6);
    }

    public m(Context context, c cVar, int i5, int i6, boolean z5) {
        this(context, 0, cVar, i5, i6, z5);
    }

    @Override // com.stepos.common.widget.TimePicker.b
    public void a(TimePicker timePicker, int i5, int i6) {
        TimePicker.b bVar = this.f14446f;
        if (bVar != null) {
            bVar.a(timePicker, i5, i6);
        }
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) throws Resources.NotFoundException {
        super.onRestoreInstanceState(bundle);
        int i5 = bundle.getInt("hour");
        int i6 = bundle.getInt("minute");
        this.f14441a.setIs24HourView(Boolean.valueOf(bundle.getBoolean("is24hour")));
        this.f14441a.setCurrentHour(Integer.valueOf(i5));
        this.f14441a.setCurrentMinute(Integer.valueOf(i6));
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt("hour", this.f14441a.getCurrentHour());
        bundleOnSaveInstanceState.putInt("minute", this.f14441a.getCurrentMinute().intValue());
        bundleOnSaveInstanceState.putBoolean("is24hour", this.f14441a.l());
        return bundleOnSaveInstanceState;
    }

    public m(Context context, int i5, c cVar, int i6, int i7, boolean z5) throws Resources.NotFoundException {
        super(context, i5);
        this.f14442b = cVar;
        this.f14443c = i6;
        this.f14444d = i7;
        this.f14445e = z5;
        setButton(-1, context.getText(H1.k.f2342F), new b(this, null));
        setButton(-2, context.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(H1.i.f2318i, (ViewGroup) null);
        setView(viewInflate);
        viewInflate.addOnLayoutChangeListener(new a(viewInflate));
        TimePicker timePicker = (TimePicker) viewInflate.findViewById(H1.h.f2272r0);
        this.f14441a = timePicker;
        timePicker.setIs24HourView(Boolean.valueOf(this.f14445e));
        timePicker.setCurrentHour(Integer.valueOf(this.f14443c));
        timePicker.setCurrentMinute(Integer.valueOf(this.f14444d));
        timePicker.setOnTimeChangedListener(this);
        timePicker.setIsDrawLine(false);
        timePicker.p(context.getResources().getDimensionPixelSize(H1.f.f2120P), context.getResources().getDimensionPixelSize(H1.f.f2121Q));
    }
}
