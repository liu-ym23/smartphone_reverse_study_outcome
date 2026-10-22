package androidx.core.app;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final String f13071a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f13072b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence[] f13073c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13074d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13075e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f13076f;

    /* renamed from: g, reason: collision with root package name */
    public final Set<String> f13077g;

    public static class a {
        public static RemoteInput a(r rVar) {
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(rVar.i()).setLabel(rVar.h()).setChoices(rVar.e()).setAllowFreeFormInput(rVar.c()).addExtras(rVar.g());
            Set<String> setD = rVar.d();
            if (setD != null) {
                Iterator<String> it = setD.iterator();
                while (it.hasNext()) {
                    b.a(builderAddExtras, it.next(), true);
                }
            }
            c.a(builderAddExtras, rVar.f());
            return builderAddExtras.build();
        }
    }

    public static class b {
        public static RemoteInput.Builder a(RemoteInput.Builder builder, String str, boolean z10) {
            return builder.setAllowDataType(str, z10);
        }
    }

    public static class c {
        public static RemoteInput.Builder a(RemoteInput.Builder builder, int i10) {
            return builder.setEditChoicesBeforeSending(i10);
        }
    }

    public static RemoteInput a(r rVar) {
        return a.a(rVar);
    }

    public static RemoteInput[] b(r[] rVarArr) {
        if (rVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[rVarArr.length];
        for (int i10 = 0; i10 < rVarArr.length; i10++) {
            remoteInputArr[i10] = a(rVarArr[i10]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f13074d;
    }

    public Set<String> d() {
        return this.f13077g;
    }

    public CharSequence[] e() {
        return this.f13073c;
    }

    public int f() {
        return this.f13075e;
    }

    public Bundle g() {
        return this.f13076f;
    }

    public CharSequence h() {
        return this.f13072b;
    }

    public String i() {
        return this.f13071a;
    }

    public boolean j() {
        if (c()) {
            return false;
        }
        return ((e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
