package com.android.contacts.widget.dslv;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.android.contacts.forcetouch.ForceTouchController;

/* JADX INFO: loaded from: classes2.dex */
public class ForceTouchAdapterController extends ForceTouchController {
    private DragSortController mController;

    public ForceTouchAdapterController(ListView r1, Context r2, DragSortController r3) {
        super(r1, r2);
        this.mController = r3;
    }

    @Override // com.android.contacts.forcetouch.ForceTouchController, android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        super.onTouch(r1, r2);
        return this.mController.onTouch(r1, r2);
    }
}
