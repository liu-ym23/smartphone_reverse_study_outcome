package androidx.room;

import com.bytedanceos.common.model.AppInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f4518d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f4519e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4522c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final b a(List r10) {
            kotlin.jvm.internal.q.g(r10, "matches");
            Iterator r11 = r10.iterator();
            int r12 = 0;
            int r13 = 0;
        L4:
            if (r11.hasNext() == false) goto L6;
            androidx.room.a r14 = (androidx.room.a) r11.next();
            r13 = r13 + (((r14.b().b() - r14.b().a()) + 1) - r14.a().size());
            goto L4
        L6:
            Iterator r15 = r10.iterator();
            if (r15.hasNext() == false) goto L46;
            int r16 = ((androidx.room.a) r15.next()).b().a();
        L10:
            if (r15.hasNext() == false) goto L14;
            int r17 = ((androidx.room.a) r15.next()).b().a();
            if (r16 <= r17) goto L10;
            r16 = r17;
            goto L10
        L14:
            Iterator r18 = r10.iterator();
            if (r18.hasNext() == false) goto L44;
            int r19 = ((androidx.room.a) r18.next()).b().b();
        L18:
            if (r18.hasNext() == false) goto L22;
            int r20 = ((androidx.room.a) r18.next()).b().b();
            if (r19 >= r20) goto L18;
            r19 = r20;
            goto L18
        L22:
            Iterable r21 = new bg.c(r16, r19);
            if ((r21 instanceof Collection) == true) goto L25;
        L27:
            Iterator r22 = r21.iterator();
            int r23 = 0;
        L29:
            if (r22.hasNext() == false) goto L40;
            int r24 = ((kotlin.collections.g0) r22).nextInt();
            Iterator r25 = r10.iterator();
            int r26 = 0;
        L32:
            if (r25.hasNext() == false) goto L29;
            if (((androidx.room.a) r25.next()).b().f(r24) == false) goto L36;
            r26 = r26 + 1;
        L36:
            if (r26 <= 1) goto L32;
            r23 = r23 + 1;
            if (r23 >= 0) goto L29;
            kotlin.collections.t.p();
            goto L29
        L40:
            r12 = r23;
        L42:
            return new b(r10, r13, r12);
        L25:
            if (((Collection) r21).isEmpty() == false) goto L27;
        L44:
            throw new NoSuchElementException();
        L46:
            throw new NoSuchElementException();
        }

        public a() {
        }
    }

    static {
        f4518d = new a(null);
        f4519e = new b(kotlin.collections.t.i(), Channel.UNLIMITED, Channel.UNLIMITED);
    }

    public b(List r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "matches");
        this.f4520a = r10;
        this.f4521b = r11;
        this.f4522c = r12;
    }

    public int a(b r10) {
        kotlin.jvm.internal.q.g(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        int r11 = kotlin.jvm.internal.q.i(this.f4522c, r10.f4522c);
        if (r11 == 0) goto L6;
        return r11;
    L6:
        return kotlin.jvm.internal.q.i(this.f4521b, r10.f4521b);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return a((b) r10);
    }
}
