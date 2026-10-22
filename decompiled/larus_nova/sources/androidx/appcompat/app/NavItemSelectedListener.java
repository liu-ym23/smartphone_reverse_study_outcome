package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes2.dex */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r100) {
    }

    public NavItemSelectedListener(ActionBar.OnNavigationListener r100) {
        this.mListener = r100;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r100, View r101, int r102, long r103) {
        ActionBar.OnNavigationListener r104 = this.mListener;
        if (r104 == null) goto L6;
        r104.onNavigationItemSelected(r102, r103);
        return;
    }
}
