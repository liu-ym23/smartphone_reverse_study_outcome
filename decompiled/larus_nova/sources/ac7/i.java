package ac7;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2755c;

    @Override // ac7.g
    public final boolean a(JSONObject r100) {
        return !Intrinsics.areEqual(String.valueOf(r100.opt(this.f2754b)), this.f2755c);
    }

    public i(String r100, String r101) {
        this.f2754b = r100;
        this.f2755c = r101;
    }
}
