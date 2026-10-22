package com.google.android.material.datepicker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.stepos.stepclaw.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class c<S> extends androidx.fragment.app.e {

    /* renamed from: p, reason: collision with root package name */
    public final LinkedHashSet f1310p;

    /* renamed from: q, reason: collision with root package name */
    public final LinkedHashSet f1311q;

    public c() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.f1310p = new LinkedHashSet();
        this.f1311q = new LinkedHashSet();
    }

    public static boolean f(Context context, int i8) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(z.E(context, R.attr.materialCalendarStyle, a.class.getCanonicalName()).data, new int[]{i8});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    @Override // androidx.fragment.app.e, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f1310p.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.e, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f1311q.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }
}
