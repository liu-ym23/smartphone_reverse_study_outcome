package z2;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: z2.u8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6284u8 implements InterfaceC6254r8 {

    /* renamed from: a, reason: collision with root package name */
    public final List f45114a;

    public C6284u8(Context context, AbstractC6274t8 abstractC6274t8) {
        ArrayList arrayList = new ArrayList();
        this.f45114a = arrayList;
        if (abstractC6274t8.c()) {
            arrayList.add(new J8(context, abstractC6274t8));
        }
    }

    @Override // z2.InterfaceC6254r8
    public final void a(InterfaceC6244q8 interfaceC6244q8) {
        Iterator it = this.f45114a.iterator();
        while (it.hasNext()) {
            ((InterfaceC6254r8) it.next()).a(interfaceC6244q8);
        }
    }
}
