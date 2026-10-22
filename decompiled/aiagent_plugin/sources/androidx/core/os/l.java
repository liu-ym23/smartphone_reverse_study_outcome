package androidx.core.os;

import android.os.LocaleList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: LocaleListPlatformWrapper.java */
/* JADX INFO: loaded from: classes.dex */
final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocaleList f1277a;

    l(Object r3) {
        this.f1277a = (LocaleList) ZeusTransformUtils.preCheckCast(r3, LocaleList.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.core.os.k
    public Object a() {
        return this.f1277a;
    }

    @Override // androidx.core.os.k
    public Locale a(int r1) {
        return this.f1277a.get(r1);
    }

    @Override // androidx.core.os.k
    public boolean b() {
        return this.f1277a.isEmpty();
    }

    @Override // androidx.core.os.k
    public int c() {
        return this.f1277a.size();
    }

    public boolean equals(Object r3) {
        return this.f1277a.equals(((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin")).a());
    }

    public int hashCode() {
        return this.f1277a.hashCode();
    }

    public String toString() {
        return this.f1277a.toString();
    }

    @Override // androidx.core.os.k
    public String d() {
        return this.f1277a.toLanguageTags();
    }
}
