package b6b;

import com.ss.android.lark.newemoji.larkemoji.b;
import com.ss.android.lark.newemoji.larkemoji.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.n3;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17895a = 0;

    static {
    }

    public static List a(List r100, s5c.a r101) {
        Intrinsics.checkNotNullParameter(r100, "reactionList");
        Intrinsics.checkNotNullParameter(r101, "tab");
        ArrayList r102 = new ArrayList();
        boolean r103 = Intrinsics.areEqual(r101, n3.f570265d);
        ArrayList r104 = new ArrayList();
        Iterator r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        String r106 = (String) r105.next();
        ReentrantLock r107 = c.f433050a;
        Intrinsics.checkNotNullParameter(r106, "id");
        r104.add(new b(r106, c.a(r106)));
        goto L4
    L6:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r104.iterator();
    L7:
        int r110 = 0;
        if (r109.hasNext() == false) goto L12;
        Object r111 = r109.next();
        if (((com.ss.android.lark.newemoji.larkemoji.a) r111).c(false) == false) goto L7;
        r108.add(r111);
        goto L7
    L12:
        Iterator r112 = r108.iterator();
    L14:
        if (r112.hasNext() == false) goto L19;
        Object r113 = r112.next();
        int r114 = r110 + 1;
        if (r110 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        r102.add(new ssb.b.c((com.ss.android.lark.newemoji.larkemoji.a) r113, r103, r101, Integer.valueOf(r114)));
        r110 = r114;
        goto L14
    L19:
        return r102;
    }
}
