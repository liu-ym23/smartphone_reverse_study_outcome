package ac7;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2752c;

    @Override // ac7.g
    public final boolean a(JSONObject r100) {
        return Intrinsics.areEqual(String.valueOf(r100.opt(this.f2751b)), this.f2752c);
    }

    public f(String r100, String r101) {
        this.f2751b = r100;
        this.f2752c = r101;
    }
}
