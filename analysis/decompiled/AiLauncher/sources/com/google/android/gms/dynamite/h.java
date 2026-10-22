package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes2.dex */
public final class h implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0228a interfaceC0228a) throws DynamiteModule.LoadingException {
        int iA;
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int iB = interfaceC0228a.b(context, str);
        bVar.f19905a = iB;
        int i10 = 1;
        int i11 = 0;
        if (iB != 0) {
            iA = interfaceC0228a.a(context, str, false);
            bVar.f19906b = iA;
        } else {
            iA = interfaceC0228a.a(context, str, true);
            bVar.f19906b = iA;
        }
        int i12 = bVar.f19905a;
        if (i12 == 0) {
            if (iA == 0) {
                i10 = 0;
            }
            bVar.f19907c = i10;
            return bVar;
        }
        i11 = i12;
        if (iA < i11) {
            i10 = -1;
        }
        bVar.f19907c = i10;
        return bVar;
    }
}
