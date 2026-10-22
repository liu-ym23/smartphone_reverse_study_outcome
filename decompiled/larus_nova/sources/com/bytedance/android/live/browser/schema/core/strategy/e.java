package com.bytedance.android.live.browser.schema.core.strategy;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f64222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f64223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f64224d;

    public static final class a implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f64225a;

        public a(q30.a r100) {
            Intrinsics.checkNotNullParameter(r100, "timeProvider");
            this.f64225a = r100;
        }

        @Override // com.bytedance.android.live.browser.schema.core.strategy.c.b
        public final c a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            return new e(r100.optLong(DyPayConstant.KEY_START_TIME, 0), r100.optLong("endTime", Long.MAX_VALUE), this.f64225a);
        }
    }

    public interface b {
        long a();
    }

    @Override // com.bytedance.android.live.browser.schema.core.strategy.c
    public final boolean a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "currentState");
        long r100 = this.f64222b;
        if (r100 == 0) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L25;
        if (r100 >= this.f64223c) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L23;
        long r103 = this.f64224d.a();
        r110.put("current_ts", String.valueOf(r103));
        long r104 = this.f64222b;
        long r105 = this.f64223c;
        if (r104 <= r103) goto L19;
        return false;
    L19:
        if (r105 <= r103) goto L26;
        return true;
    L26:
        return false;
    L23:
        throw new IllegalStateException("startTime must less than endTime, please check config".toString());
    L13:
        r102 = false;
        goto L14
    L25:
        throw new IllegalStateException("startTime and endTime not exists, please check config".toString());
    L5:
        if (this.f64223c != Long.MAX_VALUE) goto L8;
        r101 = false;
        goto L9
    }

    public e(long r100, long r101, b r102) {
        Intrinsics.checkNotNullParameter(r102, "timeProvider");
        super(2);
        this.f64222b = r100;
        this.f64223c = r101;
        this.f64224d = r102;
    }
}
