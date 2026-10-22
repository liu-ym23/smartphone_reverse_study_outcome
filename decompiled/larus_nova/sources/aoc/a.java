package aoc;

import android.view.View;
import android.view.ViewTreeObserver;
import com.ss.android.lark.log.Log;
import com.suite.lark.emm.autofocus.AutoFocusEditText;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoFocusEditText f15821a;

    public a(AutoFocusEditText r100) {
        this.f15821a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View r100, View r101) {
        boolean r102 = r101 instanceof AutoFocusEditText;
        if (r102 == false) goto L6;
        this.f15821a.f460424d = false;
    L6:
        if (this.f15821a.f460424d == false) goto L8;
        return;
    L8:
        StringBuilder r103 = new StringBuilder("focus changed");
        if (r100 == null) goto L11;
        r103.append(" (from: " + r100.getClass().getName() + ')');
    L11:
        if (r101 == null) goto L13;
        r103.append(" (to: " + r101.getClass().getName() + ')');
    L13:
        Log.i("AutoFocusEditText", r103.toString());
        this.f15821a.getClass();
        boolean r104 = AutoFocusEditText.b(r100);
        if (r102 == false) goto L16;
        return;
    L16:
        if ((r100 instanceof AutoFocusEditText) == false) goto L21;
        if (r104 == false) goto L22;
        Log.i("AutoFocusEditText", "AutoFocusEditText do requestFocus");
        this.f15821a.f460424d = true;
        ((AutoFocusEditText) r100).requestFocus();
        return;
    L22:
        return;
    }
}
