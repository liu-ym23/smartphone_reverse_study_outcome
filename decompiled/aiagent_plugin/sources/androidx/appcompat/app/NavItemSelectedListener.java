package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.b mListener;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    public NavItemSelectedListener(ActionBar.b r3) {
        this.mListener = (ActionBar.b) ZeusTransformUtils.wrapperContextForParams(r3, ActionBar.b.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        ActionBar.b r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.a(r3, r4);
        return;
    }
}
