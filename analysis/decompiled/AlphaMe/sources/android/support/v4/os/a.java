package android.support.v4.os;

import C.b;
import X.h;
import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.OverScroller;
import androidx.activity.result.e;
import androidx.core.app.InterfaceC0243d;
import androidx.fragment.app.P;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d.C0527a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.n0;
import v0.j;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2368a;

    /* renamed from: b, reason: collision with root package name */
    public int f2369b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2370c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2371d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(h hVar, int i4) {
        this(Arrays.asList(hVar), i4, (Throwable) null);
        this.f2368a = 5;
        com.airbnb.lottie.h.h(hVar, "initCallback cannot be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        androidx.activity.result.a aVar;
        int i4 = this.f2368a;
        int i5 = 0;
        Object obj = this.f2371d;
        switch (i4) {
            case 0:
                ((ResultReceiver) obj).c(this.f2369b, (Bundle) this.f2370c);
                break;
            case 1:
                androidx.activity.h hVar = (androidx.activity.h) obj;
                int i6 = this.f2369b;
                Object obj2 = ((C0527a) this.f2370c).f12410b;
                String str = (String) hVar.f2428a.get(Integer.valueOf(i6));
                if (str != null) {
                    e eVar = (e) hVar.f2432e.get(str);
                    if (eVar != null && (aVar = eVar.f2424a) != null) {
                        if (hVar.f2431d.remove(str)) {
                            ((P) aVar).b(obj2);
                            break;
                        }
                    } else {
                        hVar.f2434g.remove(str);
                        hVar.f2433f.put(str, obj2);
                        break;
                    }
                }
                break;
            case 2:
                ((androidx.activity.h) obj).a(this.f2369b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f2370c));
                break;
            case 3:
                int[] iArr = new int[((String[]) this.f2370c).length];
                Activity activity = (Activity) obj;
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = ((String[]) this.f2370c).length;
                while (i5 < length) {
                    iArr[i5] = packageManager.checkPermission(((String[]) this.f2370c)[i5], packageName);
                    i5++;
                }
                ((InterfaceC0243d) activity).onRequestPermissionsResult(this.f2369b, (String[]) this.f2370c, iArr);
                break;
            case 4:
                C0527a c0527a = (C0527a) this.f2370c;
                int i7 = this.f2369b;
                b bVar = (b) c0527a.f12410b;
                if (bVar != null) {
                    bVar.g(i7);
                    break;
                }
                break;
            case 5:
                int size = ((List) this.f2370c).size();
                if (this.f2369b == 1) {
                    while (i5 < size) {
                        ((h) ((List) this.f2370c).get(i5)).b();
                        i5++;
                    }
                    break;
                } else {
                    while (i5 < size) {
                        ((h) ((List) this.f2370c).get(i5)).a();
                        i5++;
                    }
                    break;
                }
            case 6:
                ((j) this.f2370c).a(this.f2369b, (Intent) obj);
                break;
            case 7:
                ((SystemForegroundService) obj).f4344e.notify(this.f2369b, (Notification) this.f2370c);
                break;
            case 8:
                ((BottomSheetBehavior) obj).p((View) this.f2370c, this.f2369b, false);
                break;
            default:
                OverScroller overScroller = (OverScroller) this.f2370c;
                if (!overScroller.isFinished()) {
                    overScroller.computeScrollOffset();
                    int currY = overScroller.getCurrY();
                    int currY2 = overScroller.getCurrY() - this.f2369b;
                    this.f2369b = currY;
                    if (currY2 != 0) {
                        StepOSRecyclerView.d((StepOSRecyclerView) obj, -currY2, true);
                    }
                    StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) obj;
                    stepOSRecyclerView.invalidate();
                    stepOSRecyclerView.postOnAnimation(this);
                    break;
                } else {
                    StepOSRecyclerView stepOSRecyclerView2 = (StepOSRecyclerView) obj;
                    stepOSRecyclerView2.f14936a = -1;
                    stepOSRecyclerView2.removeCallbacks(this);
                    n0.b(stepOSRecyclerView2);
                    ((OverScroller) this.f2370c).abortAnimation();
                    break;
                }
        }
    }

    public /* synthetic */ a(Object obj, int i4, Object obj2, int i5) {
        this.f2368a = i5;
        this.f2371d = obj;
        this.f2369b = i4;
        this.f2370c = obj2;
    }

    public /* synthetic */ a(Object obj, Intent intent, int i4) {
        this.f2368a = 6;
        this.f2370c = obj;
        this.f2371d = intent;
        this.f2369b = i4;
    }

    public /* synthetic */ a(Object obj, Object obj2, int i4, int i5) {
        this.f2368a = i5;
        this.f2371d = obj;
        this.f2370c = obj2;
        this.f2369b = i4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(ArrayList arrayList, int i4) {
        this(arrayList, i4, (Throwable) null);
        this.f2368a = 5;
    }

    public a(List list, int i4, Throwable th) {
        this.f2368a = 5;
        com.airbnb.lottie.h.h(list, "initCallbacks cannot be null");
        this.f2370c = new ArrayList(list);
        this.f2369b = i4;
        this.f2371d = th;
    }

    public a(StepOSRecyclerView stepOSRecyclerView) {
        this.f2368a = 9;
        this.f2371d = stepOSRecyclerView;
        this.f2369b = 0;
        this.f2370c = new OverScroller(stepOSRecyclerView.getContext());
    }
}
