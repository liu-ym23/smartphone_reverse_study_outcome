package com.bytedance.android.livesdk.announce;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Date f103130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<d> f103131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f103132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f103133d;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Integer) r100, (Integer) r101);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.announce.b$b, reason: collision with other inner class name */
    public static final class C1565b<T> implements Comparator<T> {
        public C1565b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Integer) r100, (Integer) r101);
        }
    }

    public b() {
        this(0);
    }

    public final String a() {
        if (this.f103130a != null) goto L5;
        return "";
    L5:
        Calendar r100 = Calendar.getInstance();
        int r101 = r100.get(6);
        r100.setTime(this.f103130a);
        int r102 = r100.get(6) - r101;
        boolean r103 = true;
        if (r102 == 0) goto L13;
        if (r102 != 1) goto L9;
        String r104 = "明天";
    L15:
        if (r104.length() == 0) goto L18;
        r103 = false;
    L18:
        if (r103 == false) goto L21;
        return "";
    L21:
        return r104 + ' ' + new SimpleDateFormat("HH:mm").format(this.f103130a);
    L9:
        if (r102 == 2) goto L11;
        r104 = "";
        goto L15
    L11:
        r104 = "后天";
        goto L15
    L13:
        r104 = "今天";
        goto L15
    }

    public final String b() {
        boolean r100 = false;
        if (this.f103131b.isEmpty() == true) goto L30;
    L20:
        e = move-exception;
        e.printStackTrace();
        if (this.f103132c.length() <= 0) goto L24;
        r100 = true;
    L24:
        if (r100 == true) goto L26;
        return "";
    L26:
        return this.f103132c;
    L15:
        if (this.f103130a == null) goto L17;
        String r101 = new SimpleDateFormat("HH:mm").format(this.f103130a);     // Catch: Exception -> L20
        return c(this) + ' ' + r101;
    L17:
        return c(this);
    L30:
        String r102 = a();     // Catch: Exception -> L11
        if (r102.length() <= 0) goto L7;
        r100 = true;
    L7:
        if (r100 == false) goto L9;
        return r102;
    L9:
        return new SimpleDateFormat("MM月dd日 HH:mm").format(this.f103130a);
    L11:
        e = move-exception;
        e.printStackTrace();
        return "请选择";
    }

    public final boolean d() {
        boolean r100 = this.f103131b.isEmpty();
        Date r101 = this.f103130a;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r100 == false) goto L12;
        if (r102 == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L5:
        if (r101.before(new Date()) != true) goto L7;
        r102 = true;
        goto L8
    }

    public final boolean e() {
        if (this.f103130a == null) goto L5;
        return true;
    L5:
        if ((!this.f103131b.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final int hashCode() {
        Date r100 = this.f103130a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.f103131b.hashCode()) * 31) + this.f103132c.hashCode();
    L5:
        r101 = 0;
        goto L7
    }

    public /* synthetic */ b(int r100) {
        this(null, new ArrayList(), "", null);
    }

    public static String c(b r110) {
        r110.getClass();
        HashMap r100 = new HashMap();
        int r101 = 0;
        r100.put(0, "日");
        r100.put(1, "一");
        r100.put(2, "二");
        r100.put(3, "三");
        r100.put(4, "四");
        r100.put(5, "五");
        r100.put(6, "六");
        List r111 = c.h(r110, false);
        Iterator r102 = r111.iterator();
        int r103 = -1;
        int r104 = -1;
    L4:
        if (r102.hasNext() == false) goto L13;
        int r105 = ((Number) r102.next()).intValue();
        if (r103 != (-1)) goto L8;
        r103 = r105;
    L8:
        if (r104 == (-1)) goto L12;
        if ((r105 - r104) <= 1) goto L12;
        boolean r106 = false;
    L14:
        if (r103 != 0) goto L19;
        if (r104 != 6) goto L19;
        if (r106 == false) goto L19;
        return "每天";
    L19:
        if (r106 == true) goto L21;
    L23:
        StringBuilder r107 = new StringBuilder("每周");
        Iterator r112 = r111.iterator();
    L25:
        if (r112.hasNext() == false) goto L31;
        Object r108 = r112.next();
        int r109 = r101 + 1;
        if (r101 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        r107.append((String) r100.get(Integer.valueOf(((Number) r108).intValue())));
        r101 = r109;
        goto L25
    L31:
        return r107.toString();
    L21:
        if ((r104 - r103) <= 2) goto L23;
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        return String.format("每周%s至周%s", Arrays.copyOf(new Object[]{r100.get(Integer.valueOf(r103)), r100.get(Integer.valueOf(r104))}, 2));
    L12:
        r104 = r105;
        goto L4
    L13:
        r106 = true;
        goto L14
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L34:
        return false;
    L5:
        if ((r100 instanceof b) == false) goto L34;
        b r101 = (b) r100;
        if (this.f103131b.size() == r101.f103131b.size()) goto L10;
        return false;
    L10:
        ArrayList<d> r102 = this.f103131b;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        r103.add(c.f103136c.get(((d) r104.next()).f103139a));
        goto L12
    L14:
        String r105 = CollectionsKt.sortedWith(r103, new a()).toString();
        ArrayList<d> r106 = r101.f103131b;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L16:
        if (r108.hasNext() == false) goto L19;
        r107.add(c.f103136c.get(((d) r108.next()).f103139a));
        goto L16
    L19:
        if ((!Intrinsics.areEqual(r105, CollectionsKt.sortedWith(r107, new C1565b()).toString())) == false) goto L21;
        return false;
    L21:
        Calendar r109 = Calendar.getInstance();
        Date r110 = this.f103130a;
        if (r110 != null) goto L24;
        r110 = new Date();
    L24:
        Date r111 = r101.f103130a;
        if (r111 != null) goto L27;
        r111 = new Date();
    L27:
        r109.setTime(r110);
        int r112 = r109.get(1);
        r109.setTime(r111);
        if (r112 == r109.get(1)) goto L31;
        return false;
    L31:
        if ((!Intrinsics.areEqual(c.b(r110) + '-' + c.c(r110) + '-' + c.d(r110), c.b(r111) + '-' + c.c(r111) + '-' + c.d(r111))) == false) goto L33;
        return false;
    L33:
        return true;
    }

    public b(Date r100, ArrayList<d> r101, String r102, List<Integer> r103) {
        Intrinsics.checkNotNullParameter(r101, "selectWeekdays");
        Intrinsics.checkNotNullParameter(r102, "defaultTimeStr");
        this.f103130a = r100;
        this.f103131b = r101;
        this.f103132c = r102;
        this.f103133d = r103;
    }
}
