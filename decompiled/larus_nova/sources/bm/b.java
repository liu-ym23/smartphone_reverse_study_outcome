package bm;

import com.bytedance.android.ec.opt.session.model.StageType;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StageType f19540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f19541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f19543d;

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        int r102 = cm.a.f24151a;     // Catch: Throwable -> L8
        cm.b.a(r100, cm.a.b(this.f19541b));     // Catch: Throwable -> L8
        r100.putOpt("stage", this.f19542c);     // Catch: Throwable -> L8
        String r103 = this.f19540a.name();     // Catch: Throwable -> L8
        Locale r104 = Locale.getDefault();     // Catch: Throwable -> L8
        if (r103 == null) goto L7;
        r100.putOpt("stage_type", r103.toLowerCase(r104));     // Catch: Throwable -> L8
        Result.m9449constructorimpl(r100.putOpt("timestamp", this.f19543d));     // Catch: Throwable -> L8
    L10:
        return r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final Map<String, Object> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(this.f19541b);
        r100.put("stage", this.f19542c);
        String r101 = this.f19540a.name();
        Locale r102 = Locale.getDefault();
        if (r101 == null) goto L7;
        r100.put("stage_type", r101.toLowerCase(r102));
        r100.put("timestamp", this.f19543d);
        return r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final StageType getType() {
        return this.f19540a;
    }

    public final b update(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f19541b.putAll(r100);
        return this;
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "timestamp");
        this.f19542c = r100;
        this.f19543d = r101;
        this.f19540a = StageType.NORMAL;
        this.f19541b = new LinkedHashMap();
    }
}
