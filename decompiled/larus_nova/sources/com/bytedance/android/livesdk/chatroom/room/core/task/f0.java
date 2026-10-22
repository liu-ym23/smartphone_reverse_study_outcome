package com.bytedance.android.livesdk.chatroom.room.core.task;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.logsdk.format.Spm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f0 implements is2.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends is2.h>, is2.h> f111042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f111043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kn1.f f111044c;

    @Override // is2.i
    public final boolean isDestroyed() {
        return this.f111043b;
    }

    public f0(kn1.f r100) {
        this.f111044c = r100;
        this.f111042a = new LinkedHashMap();
    }

    @Override // is2.i
    public final void a(Class<? extends is2.h> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (this.f111042a.containsKey(r100) == true) goto L5;
        return;
    L5:
        is2.h r102 = (is2.h) ((LinkedHashMap) this.f111042a).get(r100);
        if (r102 == null) goto L56;
        kn1.f r103 = this.f111044c;
        if (r103 == null) goto L27;
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (kn1.e.f504154a.booleanValue() == false) goto L27;
        if (r102.isIgnored() == true) goto L27;
        String r104 = r102.getSpm();
        if (r104 == null) goto L27;
        if (Intrinsics.areEqual(r104, "") == true) goto L27;
        Spm.Companion.getClass();
        Spm r105 = Spm.a.a(r104);
        if ((!r101.isEmpty()) == false) goto L24;
        HashMap r106 = new HashMap();
        r106.putAll(r101);
        r105.args(r106);
    L24:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L26;
        r105.addArg("name", r102.getClass().getSimpleName());
    L26:
        vw2.a.a(r105.addArg("state", "before").businessId(r103.f504156a), "room_enter");
    L27:
        r102.a(r101);
        kn1.f r107 = this.f111044c;
        if (r107 != null) goto L30;
        return;
    L30:
        if (kn1.e.f504154a.booleanValue() == true) goto L33;
        return;
    L33:
        if (r102.isIgnored() == true) goto L60;
        String r108 = r102.getSpm();
        if (r108 != null) goto L38;
        return;
    L38:
        if (Intrinsics.areEqual(r108, "") == true) goto L61;
        Spm.Companion.getClass();
        Spm r109 = Spm.a.a(r108);
        Map<String, Object> r110 = r102.getPropertyParams();     // Catch: NullPointerException -> L45 IllegalStateException -> L47
        if (r110 == null) goto L50;
        HashMap r111 = new HashMap();     // Catch: NullPointerException -> L45 IllegalStateException -> L47
        r111.putAll(r110);     // Catch: NullPointerException -> L45 IllegalStateException -> L47
        r109.args(r111);     // Catch: NullPointerException -> L45 IllegalStateException -> L47
    L50:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L52;
        r109.addArg("name", r102.getClass().getSimpleName());
    L52:
        vw2.a.a(r109.addArg("state", "after").businessId(r107.f504156a), "room_enter");
        return;
    L47:
        e = move-exception;
        ALogger.w("", e);
    L45:
        e = move-exception;
        ALogger.w("", e);
        goto L50
    L61:
        return;
    L60:
        return;
    }
}
