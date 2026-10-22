package ac7;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class l extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2759b;

    public l(String r100) {
        this.f2759b = r100;
    }

    @Override // ac7.g
    public final boolean a(JSONObject r100) {
        Object r101 = r100.opt(this.f2759b);
        if (r101 == null) goto L17;
        boolean r102 = false;
        if ((r101 instanceof Boolean) == false) goto L11;
        if (((Boolean) r101).booleanValue() == false) goto L17;
    L19:
        return !r102;
    L11:
        if ((r101 instanceof Number) == false) goto L14;
        r102 = Intrinsics.areEqual(r101, 0);
        goto L19
    L14:
        if ((r101 instanceof String) == false) goto L19;
        if (((CharSequence) r101).length() != 0) goto L19;
    L17:
        r102 = true;
        goto L19
    }
}
