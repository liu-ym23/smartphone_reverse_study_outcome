package androidx.lifecycle;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.impl.WorkDatabase;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.JsonIOException;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.database.DownloadInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements v0.r, f5.g {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2246g;
    public final Object h;

    public /* synthetic */ b(Object obj, int i10) {
        this.f2246g = i10;
        this.h = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.lang.StringBuilder r5, java.util.ArrayList r6) {
        /*
            int r0 = r5.length()
            if (r0 > 0) goto L7
            return
        L7:
            r1 = 1
            r2 = 0
            if (r1 != r0) goto L14
            java.lang.String r0 = r5.toString()
            r6.add(r0)
            goto L7c
        L14:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r2
        L1a:
            int r3 = r5.length()
            if (r1 >= r3) goto L6c
            char r3 = r5.charAt(r1)
            boolean r4 = java.lang.Character.isDigit(r3)
            if (r4 != 0) goto L66
            boolean r4 = java.lang.Character.isLowerCase(r3)
            if (r4 != 0) goto L66
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 == 0) goto L37
            goto L66
        L37:
            int r4 = w3.a.f13577a
            r4 = 39
            if (r3 == r4) goto L66
            r4 = 65
            if (r3 < r4) goto L45
            r4 = 90
            if (r3 <= r4) goto L66
        L45:
            r4 = 97
            if (r3 < r4) goto L4e
            r4 = 122(0x7a, float:1.71E-43)
            if (r3 > r4) goto L4e
            goto L66
        L4e:
            int r4 = r0.length()
            if (r4 <= 0) goto L5e
            java.lang.String r4 = r0.toString()
            r6.add(r4)
            r0.setLength(r2)
        L5e:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r6.add(r3)
            goto L69
        L66:
            r0.append(r3)
        L69:
            int r1 = r1 + 1
            goto L1a
        L6c:
            int r1 = r0.length()
            if (r1 <= 0) goto L7c
            java.lang.String r1 = r0.toString()
            r6.add(r1)
            r0.setLength(r2)
        L7c:
            r5.setLength(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.b.e(java.lang.StringBuilder, java.util.ArrayList):void");
    }

    public void a(Runnable runnable) {
        ((Handler) this.h).removeCallbacks(runnable);
    }

    public ArrayList b(int i10, Download download) {
        kotlin.jvm.internal.g.f(download, "download");
        List<DownloadInfo> listF = ((za.g) this.h).f(i10);
        kotlin.jvm.internal.g.d(listF, "null cannot be cast to non-null type java.util.ArrayList<com.tonyodev.fetch2.Download>");
        ArrayList arrayList = (ArrayList) listF;
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                i11 = -1;
                break;
            }
            Object obj = arrayList.get(i12);
            i12++;
            if (((Download) obj).getId() == download.getId()) {
                break;
            }
            i11++;
        }
        if (i11 != -1) {
            arrayList.set(i11, download);
        }
        return arrayList;
    }

    @Override // f5.g
    public Object c() {
        switch (this.f2246g) {
            case 4:
                throw new JsonIOException((String) this.h);
            default:
                Type type = (Type) this.h;
                if (!(type instanceof ParameterizedType)) {
                    throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return new EnumMap((Class) type2);
                }
                throw new JsonIOException("Invalid EnumMap type: " + type.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003b A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:15:0x002c, B:23:0x003b, B:24:0x0048, B:26:0x004e, B:29:0x005b, B:30:0x0067, B:31:0x006a), top: B:58:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.lang.StringBuilder r12, java.util.ArrayList r13) {
        /*
            r11 = this;
            int r0 = r12.length()
            if (r0 > 0) goto L7
            return
        L7:
            java.lang.String r0 = r12.toString()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = r2
        L12:
            int r4 = r0.length()
            if (r3 >= r4) goto Lc2
            java.lang.Object r4 = r11.h
            i4.a r4 = (i4.a) r4
            java.util.HashMap r5 = i4.a.f9538a
            r6 = 1
            if (r5 == 0) goto L27
            int r7 = r5.size()
            if (r7 != 0) goto L6b
        L27:
            java.lang.Class<u3.a> r7 = u3.a.class
            monitor-enter(r7)
            if (r5 == 0) goto L38
            int r8 = r5.size()     // Catch: java.lang.Throwable -> L35
            if (r8 != 0) goto L33
            goto L38
        L33:
            r8 = r2
            goto L39
        L35:
            r11 = move-exception
            goto Lc0
        L38:
            r8 = r6
        L39:
            if (r8 == 0) goto L6a
            java.util.HashSet r4 = r4.b()     // Catch: java.lang.Throwable -> L35
            java.util.HashSet r8 = new java.util.HashSet     // Catch: java.lang.Throwable -> L35
            r8.<init>()     // Catch: java.lang.Throwable -> L35
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L35
        L48:
            boolean r9 = r4.hasNext()     // Catch: java.lang.Throwable -> L35
            if (r9 == 0) goto L67
            java.lang.Object r9 = r4.next()     // Catch: java.lang.Throwable -> L35
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L35
            boolean r10 = s3.a.a(r9)     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L5b
            goto L48
        L5b:
            java.lang.String r10 = " "
            java.lang.String[] r9 = r9.split(r10)     // Catch: java.lang.Throwable -> L35
            r9 = r9[r2]     // Catch: java.lang.Throwable -> L35
            r8.add(r9)     // Catch: java.lang.Throwable -> L35
            goto L48
        L67:
            u3.a.a(r8, r5)     // Catch: java.lang.Throwable -> L35
        L6a:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L35
        L6b:
            r7 = r2
            r8 = r7
            r4 = r3
        L6e:
            int r9 = r0.length()
            if (r4 >= r9) goto La3
            char r9 = r0.charAt(r4)
            java.lang.Character r9 = java.lang.Character.valueOf(r9)
            java.lang.Object r5 = r5.get(r9)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L86
            r9 = r6
            goto L87
        L86:
            r9 = r2
        L87:
            if (r9 != 0) goto La3
            int r8 = r8 + r6
            if (r5 != 0) goto L8e
        L8c:
            r9 = r2
            goto L9d
        L8e:
            java.lang.String r9 = "ED"
            java.lang.Object r9 = r5.get(r9)
            if (r9 != 0) goto L97
            goto L8c
        L97:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
        L9d:
            if (r9 == 0) goto La0
            r7 = r8
        La0:
            int r4 = r4 + 1
            goto L6e
        La3:
            if (r7 <= 0) goto Lb2
            int r4 = r3 + r7
            java.lang.String r4 = r0.substring(r3, r4)
            r1.add(r4)
            int r7 = r7 + (-1)
            int r3 = r3 + r7
            goto Lbd
        Lb2:
            char r4 = r0.charAt(r3)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.add(r4)
        Lbd:
            int r3 = r3 + r6
            goto L12
        Lc0:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L35
            throw r11
        Lc2:
            r13.addAll(r1)
            r12.setLength(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.b.d(java.lang.StringBuilder, java.util.ArrayList):void");
    }

    public void f(DeserializationContext deserializationContext, Object obj, q3.p pVar) {
        ArrayList arrayList = (ArrayList) this.h;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            SettableBeanProperty settableBeanProperty = (SettableBeanProperty) arrayList.get(i10);
            p.a aVarT1 = pVar.t1(pVar.f11580b);
            aVarT1.q1();
            settableBeanProperty.i(aVarT1, deserializationContext, obj);
        }
    }

    @Override // v0.r
    public v0.m0 g(View view, v0.m0 m0Var) {
        AppBarLayout appBarLayout = (AppBarLayout) this.h;
        v0.m0 m0Var2 = appBarLayout.getFitsSystemWindows() ? m0Var : null;
        if (!Objects.equals(appBarLayout.f4544j, m0Var2)) {
            appBarLayout.f4544j = m0Var2;
            appBarLayout.setWillNotDraw(!(appBarLayout.A != null && appBarLayout.getTopInset() > 0));
            appBarLayout.requestLayout();
        }
        return m0Var;
    }

    public void h(long j10, Runnable runnable) {
        ((Handler) this.h).postDelayed(runnable, j10);
    }

    public b(int i10) {
        this.f2246g = i10;
        switch (i10) {
            case 3:
                this.h = new ArrayList();
                break;
            case 7:
                this.h = Handler.createAsync(Looper.getMainLooper());
                break;
            default:
                this.h = new AtomicReference(null);
                break;
        }
    }

    public b(WorkDatabase workDatabase) {
        this.f2246g = 8;
        kotlin.jvm.internal.g.f(workDatabase, "workDatabase");
        this.h = workDatabase;
    }

    public b(long[] jArr) {
        p.h hVar;
        this.f2246g = 10;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            hVar = new p.h(jArrCopyOf.length);
            int i10 = hVar.f11373b;
            if (i10 >= 0) {
                if (jArrCopyOf.length != 0) {
                    int length = jArrCopyOf.length + i10;
                    long[] jArr2 = hVar.f11372a;
                    if (jArr2.length < length) {
                        long[] jArrCopyOf2 = Arrays.copyOf(jArr2, Math.max(length, (jArr2.length * 3) / 2));
                        kotlin.jvm.internal.g.e(jArrCopyOf2, "copyOf(...)");
                        hVar.f11372a = jArrCopyOf2;
                    }
                    long[] jArr3 = hVar.f11372a;
                    int i11 = hVar.f11373b;
                    if (i10 != i11) {
                        b1.p(jArr3, jArr3, jArrCopyOf.length + i10, i10, i11);
                    }
                    b1.p(jArrCopyOf, jArr3, i10, 0, jArrCopyOf.length);
                    hVar.f11373b += jArrCopyOf.length;
                }
            } else {
                kotlin.jvm.internal.g.f("", "message");
                throw new IndexOutOfBoundsException("");
            }
        } else {
            hVar = new p.h(16);
        }
        this.h = hVar;
    }
}
