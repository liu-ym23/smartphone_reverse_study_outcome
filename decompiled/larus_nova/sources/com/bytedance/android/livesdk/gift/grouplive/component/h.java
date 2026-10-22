package com.bytedance.android.livesdk.gift.grouplive.component;

import com.bytedance.android.scope.o;
import com.bytedance.common.wschannel.WsConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements fa0.c, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject<fa0.b> f126300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f126301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f126302c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // fa0.c
    public final fa0.a o0() {
        i r100 = this.f126301b;
        if (r100 == null) goto L40;
        if (r100.f126306d.isAnchor() == true) goto L7;
    L37:
        fa0.a r101 = r100.f126304b.f64752a;
    L38:
        if (r101 == null) goto L40;
        return r101;
    L7:
        if (r100.f126304b.f64752a.f475994a == true) goto L37;
        com.bytedance.android.livesdk.sharedpref.e<String> r102 = j.f126307a;
        String r103 = r100.f126306d.getRoom().getIdStr();
        Intrinsics.checkNotNullParameter(r103, "roomId");
        HashMap<String, fa0.a> r104 = j.f126308b;
        if (r104.containsKey(r103) == false) goto L11;
        r101 = r104.get(r103);
    L35:
        if (r101 != null) goto L38;
        r101 = r100.f126304b.f64752a;
        goto L38
    L11:
        String r105 = j.f126307a.getValue();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L14
        Object r107 = Result.m9449constructorimpl(new JSONObject(r105));     // Catch: Throwable -> L14
    L16:
        fa0.a r108 = null;
        if (Result.m9455isFailureimpl(r107) == false) goto L19;
        r107 = null;
    L19:
        JSONObject r109 = (JSONObject) r107;
        boolean r110 = true;
        if (r105.length() != 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == true) goto L34;
        if (r109 == null) goto L34;
        if ((!Intrinsics.areEqual(r103, r109.optString("room_id"))) == true) goto L34;
        String r112 = r109.optString(WsConstants.KEY_PAYLOAD);
        int r113 = r109.optInt("type", -1);
        if (r113 != (-1)) goto L33;
        r110 = false;
    L33:
        r108 = new fa0.a(r110, Integer.valueOf(r113), r112);
        j.f126308b.put(r103, r108);
    L34:
        r101 = r108;
        goto L35
    L22:
        r111 = false;
    L14:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L40:
        return new fa0.a(0);
    }

    public h() {
        this.f126300a = PublishSubject.create();
        this.f126302c = new CompositeDisposable();
    }

    @Override // fa0.c
    public final Observable<fa0.b> I4() {
        return this.f126300a;
    }
}
