package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f8219a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8220b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8221c = true;

    /* renamed from: d, reason: collision with root package name */
    private final List<d> f8222d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private d f8223e = null;

    private e() {
    }

    public static e b() {
        if (f8219a == null) {
            synchronized (e.class) {
                try {
                    if (f8219a == null) {
                        f8219a = new e();
                    }
                } finally {
                }
            }
        }
        return f8219a;
    }

    public d a() {
        return this.f8223e;
    }

    public d a(Context context) {
        String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        for (d dVar : this.f8222d) {
            if (dVar.c().equals(string)) {
                return dVar;
            }
        }
        return null;
    }

    public boolean a(Context context, d dVar) {
        String strC = dVar.c();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("map_pref", 0).edit();
        editorEdit.putString("PREFFERED_SD_CARD", strC);
        return editorEdit.commit();
    }

    public void b(Context context) {
        if (this.f8220b || context == null) {
            return;
        }
        this.f8220b = true;
        try {
            this.f8221c = false;
            this.f8223e = new d(context);
            this.f8222d.clear();
            this.f8222d.add(this.f8223e);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            if (this.f8222d.size() > 0) {
                d dVar = null;
                int i4 = 0;
                for (d dVar2 : this.f8222d) {
                    if (new File(dVar2.a()).exists()) {
                        i4++;
                        dVar = dVar2;
                    }
                }
                if (i4 == 0) {
                    d dVarA = a(context);
                    this.f8223e = dVarA;
                    if (dVarA == null) {
                        Iterator<d> it = this.f8222d.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d next = it.next();
                            if (a(context, next)) {
                                this.f8223e = next;
                                break;
                            }
                        }
                    }
                } else if (i4 == 1) {
                    if (a(context, dVar)) {
                        this.f8223e = dVar;
                    }
                } else {
                    this.f8223e = a(context);
                }
                if (this.f8223e == null) {
                    this.f8223e = this.f8222d.get(0);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            if (this.f8223e == null) {
                this.f8221c = false;
                this.f8223e = new d(context);
                this.f8222d.clear();
                this.f8222d.add(this.f8223e);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
