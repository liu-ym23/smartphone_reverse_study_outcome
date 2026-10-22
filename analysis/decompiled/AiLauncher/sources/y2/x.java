package y2;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class x implements t {

    /* renamed from: a, reason: collision with root package name */
    public final List f43839a;

    public x(Context context, w wVar) {
        ArrayList arrayList = new ArrayList();
        this.f43839a = arrayList;
        if (wVar.c()) {
            arrayList.add(new F(context, wVar));
        }
    }
}
