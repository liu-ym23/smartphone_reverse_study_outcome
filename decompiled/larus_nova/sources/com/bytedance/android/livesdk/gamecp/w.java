package com.bytedance.android.livesdk.gamecp;

import android.app.Activity;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class w implements ov.b {

    public static final class a implements qb4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qv.a f125483a;

        public a(qv.a r100) {
            this.f125483a = r100;
        }

        @Override // qb4.f
        public final void onFail(int r100, JSONObject r101) {
            qv.a r102 = this.f125483a;
            if (r102 == null) goto L6;
            r102.onFailure(r100);
            return;
        }

        @Override // qb4.f
        public final void onSuccess(int r100, JSONObject r101) {
            qv.a r102 = this.f125483a;
            if (r102 == null) goto L6;
            r102.onSuccess();
            return;
        }
    }

    public w() {
    }

    @Override // ov.b
    public final void Z1(Activity r100, String r101, qv.a r102) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L17;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        jc4.m r104 = new jc4.m(r101);     // Catch: Throwable -> L11
        qb4.b r105 = qb4.b.c.f532315a;     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        r105.i(r100, r104, new a(r102));     // Catch: Throwable -> L11
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
        return;
    L8:
        r106 = null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L17:
        return;
    }
}
