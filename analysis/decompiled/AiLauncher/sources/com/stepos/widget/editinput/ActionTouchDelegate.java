package com.stepos.widget.editinput;

import Z8.C1172u;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010j\b\u0012\u0004\u0012\u00020\u0001`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/widget/editinput/ActionTouchDelegate;", "Landroid/view/TouchDelegate;", "Landroid/view/View;", "owner", "<init>", "(Landroid/view/View;)V", "", "list", "LY8/t;", "setDelegates", "(Ljava/util/List;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "delegates", "Ljava/util/ArrayList;", "captured", "Landroid/view/TouchDelegate;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ActionTouchDelegate extends TouchDelegate {
    private TouchDelegate captured;
    private final ArrayList<TouchDelegate> delegates;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionTouchDelegate(View owner) {
        super(new Rect(), owner);
        p.i(owner, "owner");
        this.delegates = new ArrayList<>(2);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent event) {
        List listE;
        p.i(event, "event");
        float x10 = event.getX();
        float y10 = event.getY();
        TouchDelegate touchDelegate = this.captured;
        if (touchDelegate == null || (listE = C1172u.e(touchDelegate)) == null) {
            listE = this.delegates;
        }
        Iterator it = listE.iterator();
        boolean z10 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TouchDelegate touchDelegate2 = (TouchDelegate) it.next();
            event.setLocation(x10, y10);
            boolean zOnTouchEvent = touchDelegate2.onTouchEvent(event);
            if (zOnTouchEvent) {
                this.captured = touchDelegate2;
                z10 = zOnTouchEvent;
                break;
            }
            z10 = zOnTouchEvent;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            return z10;
        }
        this.captured = null;
        return z10;
    }

    public final void setDelegates(List<? extends TouchDelegate> list) {
        p.i(list, "list");
        this.delegates.clear();
        this.delegates.addAll(list);
        this.captured = null;
    }
}
