package androidx.appcompat.app;

import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c1;
import com.stepos.alphame.R;
import k.C0663q;
import stepos.support.v7.app.AbstractC0880z;
import stepos.support.v7.app.InterfaceC0867l;
import stepos.support.v7.app.Z;
import stepos.support.v7.widget.p0;
import stepos.support.v7.widget.r0;

/* renamed from: androidx.appcompat.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0177c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2584a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2585b;

    public /* synthetic */ ViewOnClickListenerC0177c(int i4, Object obj) {
        this.f2584a = i4;
        this.f2585b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        Message message4;
        Message message5;
        Message message6;
        int i4 = this.f2584a;
        Message messageObtain = null;
        messageObtain = null;
        Message messageObtain2 = null;
        messageObtain = null;
        Object obj = this.f2585b;
        switch (i4) {
            case 0:
                C0185k c0185k = (C0185k) obj;
                if (view == c0185k.f2643k && (message3 = c0185k.f2645m) != null) {
                    messageObtain = Message.obtain(message3);
                } else if (view == c0185k.f2647o && (message2 = c0185k.f2649q) != null) {
                    messageObtain = Message.obtain(message2);
                } else if (view == c0185k.f2651s && (message = c0185k.f2653u) != null) {
                    messageObtain = Message.obtain(message);
                }
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                c0185k.f2631L.obtainMessage(1, c0185k.f2634b).sendToTarget();
                break;
            case 1:
                c1 c1Var = ((Toolbar) obj).f2978L;
                C0663q c0663q = c1Var != null ? c1Var.f3072b : null;
                if (c0663q != null) {
                    c0663q.collapseActionView();
                    break;
                }
                break;
            case 2:
                com.google.android.material.datepicker.s sVar = (com.google.android.material.datepicker.s) obj;
                int i5 = sVar.f10710g;
                if (i5 != 2) {
                    if (i5 == 1) {
                        sVar.i(2);
                        sVar.f10712i.announceForAccessibility(sVar.getString(R.string.mtrl_picker_toggled_to_year_selection));
                        break;
                    }
                } else {
                    sVar.i(1);
                    sVar.f10713j.announceForAccessibility(sVar.getString(R.string.mtrl_picker_toggled_to_day_selection));
                    break;
                }
                break;
            case 3:
            case 6:
            default:
                r0 r0Var = ((stepos.support.v7.widget.Toolbar) obj).f15003M;
                L3.l lVar = r0Var != null ? r0Var.f15144b : null;
                if (lVar != null) {
                    lVar.collapseActionView();
                    break;
                }
                break;
            case 4:
                AbstractC0880z abstractC0880z = (AbstractC0880z) obj;
                InterfaceC0867l interfaceC0867l = abstractC0880z.f14513e;
                if (interfaceC0867l != null && !abstractC0880z.f14523o) {
                    interfaceC0867l.onBackTopTouch();
                    break;
                }
                break;
            case 5:
                Z z4 = (Z) obj;
                if (view == z4.f14425r && (message6 = z4.f14427t) != null) {
                    messageObtain2 = Message.obtain(message6);
                } else if (view == z4.f14429v && (message5 = z4.f14431x) != null) {
                    messageObtain2 = Message.obtain(message5);
                } else if (view == z4.f14433z && (message4 = z4.f14374B) != null) {
                    messageObtain2 = Message.obtain(message4);
                }
                if (messageObtain2 != null) {
                    messageObtain2.sendToTarget();
                }
                z4.f14392U.obtainMessage(1, z4.f14403e).sendToTarget();
                break;
            case 7:
                ((p0) obj).getClass();
                break;
        }
    }
}
