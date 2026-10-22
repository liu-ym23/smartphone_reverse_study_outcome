package bh9;

import com.larus.im.bean.bot.IconItem;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<String>> f19068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IconItem> f19069b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f19068a, r101.f19068a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19069b, r101.f19069b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Map<String, List<String>> r100 = this.f19068a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<IconItem> r104 = this.f19069b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceMaterialPlatformData(audioVoiceTalkList=" + this.f19068a + ", audioIconList=" + this.f19069b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Map<String, ? extends List<String>> r100, List<IconItem> r101) {
        this.f19068a = r100;
        this.f19069b = r101;
    }
}
