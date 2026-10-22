package c62;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements vlc.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.h f22553b;

    public c(long r100, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f22552a = r100;
        this.f22553b = r101;
    }

    @Override // vlc.h
    public final void onFirstMessage(List<tlc.d> r100, boolean r110) {
        if (r100 == null) goto L12;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (o.b((tlc.d) r103) != this.f22552a) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L5;
        r101.add(r103);
        goto L5
    L9:
        r104 = false;
    L13:
        if (r100 == null) goto L21;
        this.f22553b.onFirstMessage(r101, r110);
        return;
    L21:
        return;
    L12:
        r101 = null;
        goto L13
    }
}
