package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Typeface;
import android.view.View;
import android.widget.OverScroller;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.n1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f676c;

    /* renamed from: f, reason: collision with root package name */
    public int f677f;

    /* renamed from: g, reason: collision with root package name */
    public Object f678g;

    /* renamed from: h, reason: collision with root package name */
    public Object f679h;

    public h(int i, Intent intent, j5.h hVar) {
        this.f676c = 2;
        this.f679h = hVar;
        this.f678g = intent;
        this.f677f = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.b bVar;
        switch (this.f676c) {
            case 0:
                i iVar = (i) this.f678g;
                int i = this.f677f;
                Object obj = ((e.a) this.f679h).f3331a;
                String str = (String) iVar.f2935a.get(Integer.valueOf(i));
                if (str != null) {
                    d.f fVar = (d.f) iVar.f2939e.get(str);
                    if (fVar != null && (bVar = fVar.f2931a) != null) {
                        if (iVar.f2938d.remove(str)) {
                            bVar.a(obj);
                            break;
                        }
                    } else {
                        iVar.f2941g.remove(str);
                        iVar.f2940f.put(str, obj);
                        break;
                    }
                }
                break;
            case 1:
                ((i) this.f678g).a(this.f677f, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f679h));
                break;
            case 2:
                ((j5.h) this.f679h).a((Intent) this.f678g, this.f677f);
                break;
            case 3:
                ((TextView) this.f679h).setTypeface((Typeface) this.f678g, this.f677f);
                break;
            case 4:
                StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) this.f678g;
                OverScroller overScroller = (OverScroller) this.f679h;
                if (!overScroller.isFinished()) {
                    overScroller.computeScrollOffset();
                    int currY = overScroller.getCurrY();
                    int currY2 = overScroller.getCurrY() - this.f677f;
                    this.f677f = currY;
                    if (currY2 != 0) {
                        StepOSRecyclerView.d(stepOSRecyclerView, -currY2, true);
                    }
                    stepOSRecyclerView.invalidate();
                    stepOSRecyclerView.postOnAnimation(this);
                    break;
                } else {
                    stepOSRecyclerView.f12640c = -1;
                    stepOSRecyclerView.removeCallbacks(this);
                    n1.b(stepOSRecyclerView);
                    overScroller.abortAnimation();
                    break;
                }
            default:
                ((BottomSheetBehavior) this.f678g).p((View) this.f679h, this.f677f, false);
                break;
        }
    }

    public /* synthetic */ h(int i) {
        this.f676c = i;
    }
}
