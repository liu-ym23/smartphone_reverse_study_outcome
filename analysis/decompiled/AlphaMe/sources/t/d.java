package t;

import S.C0108n;
import S.q;
import X.B;
import X.y;
import Z2.F;
import a3.C0166k;
import a3.C0167l;
import a3.InterfaceC0164i;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import l1.C0756a;
import q.l;
import t0.J;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static d f15272e;

    /* renamed from: a, reason: collision with root package name */
    public Object f15273a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15274b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15275c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15276d;

    public d(int i4) {
        if (i4 == 1) {
            this.f15273a = new f(10, 1);
            this.f15274b = new l(0);
            this.f15275c = new ArrayList();
            this.f15276d = new HashSet();
            return;
        }
        if (i4 == 5) {
            this.f15273a = new q.f(0);
            this.f15274b = new SparseArray();
            this.f15275c = new q.i();
            this.f15276d = new q.f(0);
            return;
        }
        if (i4 == 7) {
            this.f15273a = new Object();
            this.f15274b = new Handler(Looper.getMainLooper(), new A1.e(this));
        } else {
            this.f15273a = new f(256, 0);
            this.f15274b = new f(256, 0);
            this.f15275c = new f(256, 0);
            this.f15276d = new i[32];
        }
    }

    public final int a(String str) throws NumberFormatException {
        String string = ((S2.a) this.f15275c).f1791a.getString("event_filters", "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split(",")) {
                String str3 = str2.split(AwarenessDataItem.USERID_SPLITTER)[0];
                int i4 = Integer.parseInt(str2.split(AwarenessDataItem.USERID_SPLITTER)[1]);
                if (str3.equals(str)) {
                    return i4;
                }
            }
        }
        return 1;
    }

    public final void b(String str, long j4, long j5, long j6) {
        if (((S2.a) this.f15275c).f1791a.getBoolean("active", true) && a(str) != -1) {
            RpkEvent rpkEvent = new RpkEvent();
            rpkEvent.f12344a = PersonalContract.KEY_PAGE;
            rpkEvent.f12345b = str;
            rpkEvent.f12346c = str;
            HashMap map = new HashMap();
            map.put("start", String.valueOf(j4));
            map.put("end", String.valueOf(j5));
            map.put("duration2", String.valueOf(j6));
            rpkEvent.f12347d = map;
            rpkEvent.f12348e = ((com.stepos.statsrpk.d) this.f15276d).f12366b.a();
            ((android.support.v4.media.session.c) this.f15273a).b(rpkEvent, (RpkInfo) this.f15274b);
        }
    }

    public final void c(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((l) this.f15274b).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                c(arrayList2.get(i4), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public final void d(q qVar) throws Throwable {
        Object objL = ((InterfaceC0164i) this.f15275c).l(qVar);
        boolean z4 = objL instanceof C0166k;
        if (z4) {
            C0166k c0166k = z4 ? (C0166k) objL : null;
            Throwable th = c0166k != null ? c0166k.f2313a : null;
            if (th != null) {
                throw th;
            }
            throw new C0756a("Channel was closed normally");
        }
        if (!(!(objL instanceof C0167l))) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (((AtomicInteger) this.f15276d).getAndIncrement() == 0) {
            J.y((F) this.f15273a, null, new C0108n(this, null), 3);
        }
    }

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f15273a = obj;
        this.f15274b = obj2;
        this.f15275c = obj3;
        this.f15276d = obj4;
    }

    public d(Typeface typeface, Y.b bVar) {
        int i4;
        int i5;
        this.f15276d = typeface;
        this.f15273a = bVar;
        this.f15275c = new y(1024);
        Y.b bVar2 = (Y.b) this.f15273a;
        int iA = bVar2.a(6);
        if (iA != 0) {
            int i6 = iA + bVar2.f2111a;
            i4 = ((ByteBuffer) bVar2.f2114d).getInt(((ByteBuffer) bVar2.f2114d).getInt(i6) + i6);
        } else {
            i4 = 0;
        }
        this.f15274b = new char[i4 * 2];
        Y.b bVar3 = (Y.b) this.f15273a;
        int iA2 = bVar3.a(6);
        if (iA2 != 0) {
            int i7 = iA2 + bVar3.f2111a;
            i5 = ((ByteBuffer) bVar3.f2114d).getInt(((ByteBuffer) bVar3.f2114d).getInt(i7) + i7);
        } else {
            i5 = 0;
        }
        for (int i8 = 0; i8 < i5; i8++) {
            B b4 = new B(this, i8);
            Y.a aVarC = b4.c();
            int iA3 = aVarC.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) aVarC.f2114d).getInt(iA3 + aVarC.f2111a) : 0, (char[]) this.f15274b, i8 * 2);
            com.airbnb.lottie.h.f("invalid metadata codepoint length", b4.b() > 0);
            ((y) this.f15275c).a(b4, 0, b4.b() - 1);
        }
    }
}
