package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseRecorder implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f132060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f132061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, h> f132062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f132063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f132064e;

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public void c() {
    L22:
        e = move-exception;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.f132060a, "flushall err:" + e.getMessage());
        return;
    L4:
        if (this.f132061b == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f132060a, "flushAll size:" + this.f132062c.size());     // Catch: Exception -> L22
    L6:
        Iterator r100 = ((LinkedHashMap) this.f132062c).entrySet().iterator();     // Catch: Exception -> L22
        long r101 = System.currentTimeMillis();     // Catch: Exception -> L22
        int r102 = 0;
    L8:
        if (r100.hasNext() == false) goto L18;
        Map.Entry r103 = (Map.Entry) r100.next();     // Catch: Exception -> L22
        if (j((h) r103.getValue(), r101) == false) goto L13;
        i(r103.getKey(), (h) r103.getValue());     // Catch: Exception -> L22
        r102 = r102 + 1;     // Catch: Exception -> L22
    L15:
        r100.remove();     // Catch: Exception -> L22
        if (r102 < this.f132064e) goto L8;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f132060a, "too many report item,ignore.remain size:" + this.f132062c.size());     // Catch: Exception -> L22
        goto L18
    L13:
        if (this.f132061b == false) goto L15;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.f132060a, "not report because startConsume is " + ((h) r103.getValue()).f132081g + " && beginIgnoreReport is " + ((h) r103.getValue()).f132080f + ": " + ((String) r103.getKey()) + ' ' + ((h) r103.getValue()));     // Catch: Exception -> L22
    L18:
        if (r102 <= 0) goto L20;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f132060a, "report " + r102 + " records");     // Catch: Exception -> L22
    L20:
        this.f132063d = false;     // Catch: Exception -> L22
    }

    public BaseRecorder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f132060a = "ActionRecorder-".concat(r100);
        ReadOnlyProperty r101 = com.bytedance.android.livesdk.gift.platform.core.h.f130687y;
        KProperty<?>[] r102 = com.bytedance.android.livesdk.gift.platform.core.h.f130639a;
        this.f132061b = ((Boolean) r101.getValue(null, r102[23])).booleanValue();
        this.f132062c = new LinkedHashMap();
        this.f132064e = ((Number) com.bytedance.android.livesdk.gift.platform.core.h.f130685x.getValue(null, r102[22])).intValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter("GiftTrayMessageManager", RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r100, "stage");
        d("GiftTrayMessageManager", r100);
        if (this.f132063d == true) goto L8;
        Map<String, h> r101 = this.f132062c;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        i("GiftTrayMessageManager", (h) r102.get("GiftTrayMessageManager".toString()));
        if (this.f132061b == false) goto L7;
        String r103 = this.f132060a;
        Map<String, h> r104 = this.f132062c;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r103, "flushOnce:".concat(String.valueOf(r105.get("GiftTrayMessageManager".toString()))));
    L7:
        this.f132063d = true;
    L8:
        h("GiftTrayMessageManager");
    }

    public final void h(Object r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        this.f132062c.remove(r100.toString());
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void b(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
        d(r100, r101);
        String r102 = this.f132060a;
        StringBuilder r103 = new StringBuilder("flushLog:");
        Map<String, h> r104 = this.f132062c;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        r103.append((h) r105.get(r100.toString()));
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r102, r103.toString());
        h(r100);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void d(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
        g(r100, r101, BaseRecorder$stage$1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void f(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "otherInfo");
        if (this.f132061b == false) goto L5;
        String r102 = this.f132060a;
        StringBuilder r103 = new StringBuilder("flushSilent:");
        r103.append(r101);
        r103.append(',');
        Map<String, h> r104 = this.f132062c;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        r103.append((h) r105.get(r100.toString()));
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r102, r103.toString());
    L5:
        h(r100);
    }

    public final void i(Object r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        if (this.f132061b == false) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f132060a, "report " + r101);
    L5:
        e.a r102 = e.f132070d;
        String r103 = r100.toString();
        if (r101 == null) goto L9;
        String r104 = r101.toString();
        if (r104 == null) goto L9;
    L10:
        d r105 = null;
        if (r101 == null) goto L13;
        String r106 = r101.f132075a;
    L14:
        if (r101 == null) goto L16;
        r105 = r101.f132078d;
    L16:
        r102.getClass();
        e.a.a(r103, r104, r106, r105);
        return;
    L13:
        r106 = null;
    L9:
        r104 = "";
        goto L10
    }

    public boolean j(h r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "record");
        if (r100.f132080f == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.f132081g == 0) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void a(Object r100, String r101, final d r102) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
        g(r100, r101, new BaseRecorder$flushReport$1(r102));
        Map<String, h> r103 = this.f132062c;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        i(r100, (h) r104.get(r100.toString()));
        h(r100);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void g(Object r100, String r110, Function1<? super h, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r110, "stage");
        Intrinsics.checkNotNullParameter(r111, "record");
        h r101 = new h();
        r111.invoke(r101);
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r110, "stage");
        Intrinsics.checkNotNullParameter(r101, "newRecord");
        String r102 = r100.toString();
        if (this.f132062c.containsKey(r102) == false) goto L37;
        h r112 = (h) ((LinkedHashMap) this.f132062c).get(r102);
        if (r112 != null) goto L7;
        return;
    L7:
        if (r112.f132081g != 0) goto L9;
        r112.f132081g = r101.f132081g;
    L9:
        boolean r103 = true;
        if (r110.length() <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        ((ArrayList) r112.f132077c).add(r110);
    L16:
        if (r101.f132079e.length() <= 0) goto L18;
        boolean r113 = true;
    L20:
        if (r113 == false) goto L23;
        String r114 = r101.f132079e;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r112.f132079e = r114;
    L23:
        if (r112.f132080f == true) goto L26;
        r112.f132080f = r101.f132080f;
    L26:
        if (r101.f132082h.length() > 0) goto L29;
        r103 = false;
    L29:
        if (r103 == false) goto L31;
        String r115 = r112.f132082h + ';' + r101.f132082h;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r112.f132082h = r115;
    L31:
        d r116 = r101.f132078d;
        if (r116 == null) goto L35;
        r112.f132078d = r116;
        String r117 = r112.f132082h + String.valueOf(r112.f132078d);
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r112.f132082h = r117;
    L35:
        if (this.f132061b == false) goto L43;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.f132060a, "stage " + r102 + ' ' + r112);
        return;
    L43:
        return;
    L18:
        r113 = false;
        goto L20
    L12:
        r104 = false;
        goto L13
    L37:
        Map<String, h> r118 = this.f132062c;
        ((ArrayList) r101.f132077c).add(r110);
        if (this.f132061b == false) goto L40;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.f132060a, "stage " + r102 + ' ' + r101);
    L40:
        Unit r119 = Unit.INSTANCE;
        r118.put(r102, r101);
    }
}
