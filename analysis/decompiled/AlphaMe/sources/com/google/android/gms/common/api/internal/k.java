package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import h.RunnableC0583a;
import java.lang.ref.WeakReference;
import l1.C0758c;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9655a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9656b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9657c;

    /* renamed from: d, reason: collision with root package name */
    public int f9658d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9659e;

    public /* synthetic */ k() {
        this.f9655a = 0;
        this.f9657c = true;
        this.f9658d = 0;
    }

    public final void a(int i4) {
        switch (this.f9655a) {
            case 3:
                WeakReference weakReference = ((BottomSheetBehavior) this.f9656b).f10427W;
                if (weakReference != null && weakReference.get() != null) {
                    this.f9658d = i4;
                    if (!this.f9657c) {
                        ((View) ((BottomSheetBehavior) this.f9656b).f10427W.get()).postOnAnimation((Runnable) this.f9659e);
                        this.f9657c = true;
                        break;
                    }
                }
                break;
            default:
                WeakReference weakReference2 = ((SideSheetBehavior) this.f9656b).f10893p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f9658d = i4;
                    if (!this.f9657c) {
                        ((View) ((SideSheetBehavior) this.f9656b).f10893p.get()).postOnAnimation((Runnable) this.f9659e);
                        this.f9657c = true;
                        break;
                    }
                }
                break;
        }
    }

    public final void b(com.google.android.gms.common.internal.e eVar, C0758c c0758c) throws RemoteException {
        ((zai) ((com.google.android.gms.common.internal.service.c) eVar).l()).zae((TelemetryData) ((p) ((k) this.f9659e).f9659e).f9664b);
        c0758c.a(null);
    }

    public k(k kVar, Feature[] featureArr, boolean z4, int i4) {
        this.f9655a = 1;
        this.f9659e = kVar;
        this.f9656b = featureArr;
        this.f9657c = featureArr != null && z4;
        this.f9658d = i4;
    }

    public k(String str, boolean z4) {
        this.f9655a = 2;
        this.f9656b = "com.google.android.gms";
        this.f9659e = str;
        this.f9658d = 4225;
        this.f9657c = z4;
    }

    public k(SideSheetBehavior sideSheetBehavior) {
        this.f9655a = 4;
        this.f9656b = sideSheetBehavior;
        this.f9659e = new androidx.activity.d(13, this);
    }

    public k(BottomSheetBehavior bottomSheetBehavior) {
        this.f9655a = 3;
        this.f9656b = bottomSheetBehavior;
        this.f9659e = new RunnableC0583a(13, this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(BottomSheetBehavior bottomSheetBehavior, int i4) {
        this(bottomSheetBehavior);
        this.f9655a = 3;
    }
}
