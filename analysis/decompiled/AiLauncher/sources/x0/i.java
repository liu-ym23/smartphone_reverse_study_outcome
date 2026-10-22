package x0;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f43468a;

    public i(Object obj) {
        this.f43468a = (LocaleList) obj;
    }

    @Override // x0.h
    public String a() {
        return this.f43468a.toLanguageTags();
    }

    @Override // x0.h
    public Object b() {
        return this.f43468a;
    }

    public boolean equals(Object obj) {
        return this.f43468a.equals(((h) obj).b());
    }

    @Override // x0.h
    public Locale get(int i10) {
        return this.f43468a.get(i10);
    }

    public int hashCode() {
        return this.f43468a.hashCode();
    }

    @Override // x0.h
    public boolean isEmpty() {
        return this.f43468a.isEmpty();
    }

    @Override // x0.h
    public int size() {
        return this.f43468a.size();
    }

    public String toString() {
        return this.f43468a.toString();
    }
}
