package com.bytedance.android.ec.core.monitor;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class h<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECMonitorService f45155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f45156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f45157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f45158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONObject f45159e;

    public h(ECMonitorService r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104) {
        this.f45155a = r100;
        this.f45156b = r101;
        this.f45157c = r102;
        this.f45158d = r103;
        this.f45159e = r104;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        com.bytedance.android.ec.sdk.helper.g r100 = com.bytedance.android.ec.sdk.helper.g.f48122a;     // Catch: Throwable -> L22
        String r101 = this.f45156b;     // Catch: Throwable -> L22
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L22
        ECMonitorService r103 = this.f45155a;     // Catch: Throwable -> L22
        List r104 = CollectionsKt.listOf(new JSONObject[]{this.f45157c, this.f45158d, this.f45159e});     // Catch: Throwable -> L22
        int r105 = ECMonitorService.f45110b;     // Catch: Throwable -> L22
        r103.getClass();     // Catch: Throwable -> L22
        Iterator r106 = r104.iterator();     // Catch: Throwable -> L22
    L4:
        if (r106.hasNext() == false) goto L20;
        JSONObject r107 = (JSONObject) r106.next();     // Catch: Throwable -> L22
        if (r107 == null) goto L4;
        Iterator<String> r108 = r107.keys();     // Catch: Throwable -> L22
        if (r108 == null) goto L4;
    L10:
        if (r108.hasNext() == false) goto L4;
        String r109 = r108.next();     // Catch: Throwable -> L22
        String r110 = r107.optString(r109);     // Catch: Throwable -> L22
        if (r110.length() <= 0) goto L14;
        boolean r111 = true;
    L15:
        if (r111 == true) goto L18;
        r110 = null;
    L18:
        if (r110 == null) goto L10;
        r102.put(r109, r110);     // Catch: Throwable -> L22
        goto L10
    L14:
        r111 = false;
        goto L15
    L20:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Throwable -> L22
        r102.put("EVENT_FUNCTION_FEATURE", "TEMAI_MONITOR");     // Catch: Throwable -> L22
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r100.logV3(r101, r102);     // Catch: Throwable -> L22
        return Unit.INSTANCE;
    L22:
        th = move-exception;
        return Integer.valueOf(Log.w("ECMonitorService", "post event failed: " + this.f45156b, th));
    }
}
