package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes2.dex */
public final class b implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0228a interfaceC0228a) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int iA = interfaceC0228a.a(context, str, true);
        bVar.f19906b = iA;
        if (iA != 0) {
            bVar.f19907c = 1;
            return bVar;
        }
        int iB = interfaceC0228a.b(context, str);
        bVar.f19905a = iB;
        if (iB != 0) {
            bVar.f19907c = -1;
        }
        return bVar;
    }
}
