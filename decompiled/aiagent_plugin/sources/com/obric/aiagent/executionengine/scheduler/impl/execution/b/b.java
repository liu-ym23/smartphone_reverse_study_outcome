package com.obric.aiagent.executionengine.scheduler.impl.execution.b;

import android.net.Uri;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.execution.urishare.IUriSharable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: UriSharingRecordExtractor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "USRExtractor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18402a = null;

    static {
        f18402a = new b();
    }

    private b() {
    }

    public final void a(Object r2, String r3) {
        o.e(r2, "intentParams");
        o.e(r3, "targetPackage");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r2, r3), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        c.f18403a.a(r4);
        goto L4
    }

    private final List<a> b(Object r11, String r12) {
        if (ZeusTransformUtils.instanceOf(r11, IUriSharableParams.class) == true) goto L52;
        ILogDepend.Companion.d(TAG, "not an IUriSharableParams: " + r11.getClass().getSimpleName());
        return p.b();
    L52:
        List<IUriSharerEntity> r10 = a((IUriSharableParams) ZeusTransformUtils.preCheckCast(r11, IUriSharableParams.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L22:
        if (r10.isEmpty() == false) goto L25;
        ILogDepend.Companion.d(TAG, "no appEntity shared URI within this type: " + r11.getClass().getSimpleName());
        return p.b();
    L25:
        List<a> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<IUriSharerEntity> r14 = r10.iterator();
    L27:
        if (r14.hasNext() == false) goto L51;
        IUriSharerEntity r3 = (IUriSharerEntity) ZeusTransformUtils.preCheckCast(r14.next(), IUriSharerEntity.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AppEntity.class) == false) goto L27;
        String r5 = ((AppEntity) ZeusTransformUtils.preCheckCast(r3, AppEntity.class, "com.obric.aiagent.plugin")).getPackageName();     // Catch: Throwable -> L42
        List<Uri> r6 = r3.getSharedUris();     // Catch: Throwable -> L42
        if (r6.isEmpty() == true) goto L34;
        Iterator<Uri> r4 = r6.iterator();
    L37:
        if (r4.hasNext() == false) goto L27;
        Uri r7 = (Uri) ZeusTransformUtils.preCheckCast(r4.next(), Uri.class, "com.obric.aiagent.plugin");
        if (o.a(r5, r12) == true) goto L37;
        a r8 = new a(r5, r7, r12);
        ILogDepend.Companion.d(TAG, "adding sharedUri: " + r8);
        r13.add(r8);
        goto L37
    L34:
        ILogDepend.Companion.d(TAG, "no sharedUris within this entity: " + r3.getClass().getSimpleName());
    L42:
        th = move-exception;
        n.a r9 = n.f38560a;     // Catch: Throwable -> L45
        Object r15 = n.f(((AppEntity) ZeusTransformUtils.preCheckCast(r3, AppEntity.class, "com.obric.aiagent.plugin")).toString());     // Catch: Throwable -> L45
    L48:
        if (n.b(r15) == false) goto L50;
        r15 = "[error while dumping entity]";
    L50:
        ILogDepend.Companion.e(TAG, "exception (" + th.getClass().getName() + ") while accessing entity/" + ((AppEntity) ZeusTransformUtils.preCheckCast(r3, AppEntity.class, "com.obric.aiagent.plugin")).hashCode() + '=' + ((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin")), th);
        ILogDepend.Companion.e(TAG, "ignoring URI-extracting for entity/" + ((AppEntity) ZeusTransformUtils.preCheckCast(r3, AppEntity.class, "com.obric.aiagent.plugin")).hashCode() + "; later URI-access to this entity may be restricted.");
    L45:
        th = move-exception;
        n.a r16 = n.f38560a;
        r15 = n.f(d.o.a(th));
        goto L48
    L51:
        return r13;
    L8:
        th = move-exception;
        n.a r17 = n.f38560a;     // Catch: Throwable -> L11
        Object r18 = n.f(r11.toString());     // Catch: Throwable -> L11
    L14:
        if (n.b(r18) == false) goto L16;
        r18 = "[error while dumping entity]";
    L16:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "exception (" + th.getClass().getName() + ") while accessing intentParams", th);
        ILogDepend.Companion.e(TAG, "intentParams:");
        Iterator<String> r110 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"), 1000).iterator();
    L18:
        if (r110.hasNext() == false) goto L20;
        ILogDepend.Companion.e(TAG, (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.aiagent.plugin"));
        goto L18
    L20:
        ILogDepend.Companion.e(TAG, "ignoring URI-extracting for intent-params; later URI-access to this entity may be restricted.");
        r10 = p.b();
    L11:
        th = move-exception;
        n.a r20 = n.f38560a;
        r18 = n.f(d.o.a(th));
        goto L14
    }

    private final List<IUriSharerEntity> a(IUriSharableParams r6) {
        List<Object> r7 = ((IUriSharableParams) ZeusTransformUtils.wrapperContextForParams(r6, IUriSharableParams.class, "com.obric.aiagent.plugin")).getUriSharableParams();
        if (r7.isEmpty() == true) goto L5;
        List<IUriSharerEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<Object> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L21;
        Object r2 = r8.next();
        if (r2 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r2, IUriSharable.class) == true) goto L14;
        if ((r2 instanceof Object[]) == false) goto L8;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(a((Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L19:
        if (r3.hasNext() == false) goto L8;
        IUriSharable r4 = (IUriSharable) ZeusTransformUtils.preCheckCast(r3.next(), IUriSharable.class, "com.obric.aiagent.plugin");
        f18402a.a(r4, r0);
        goto L19
    L14:
        a((IUriSharable) ZeusTransformUtils.preCheckCast(r2, IUriSharable.class, "com.obric.aiagent.plugin"), r0);
        goto L8
    L21:
        return r0;
    L5:
        return p.b();
    }

    private final void a(IUriSharable r6, List<IUriSharerEntity> r7) {
        IUriSharable r5 = (IUriSharable) ZeusTransformUtils.wrapperContextForParams(r6, IUriSharable.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, IUriSharerEntity.class) == false) goto L6;
        ILogDepend.Companion.d(TAG, "fetchUriSharers; UriSharer: " + ((IUriSharerEntity) ZeusTransformUtils.preCheckCast(r5, IUriSharerEntity.class, "com.obric.aiagent.plugin")).getSharedUris());
        r8.add(r5);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IUriSharerEntityCollection.class) == false) goto L19;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(((IUriSharerEntityCollection) ZeusTransformUtils.preCheckCast(r5, IUriSharerEntityCollection.class, "com.obric.aiagent.plugin")).getUriSharersEntities(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r9.hasNext() == false) goto L20;
        IUriSharerEntity r10 = (IUriSharerEntity) ZeusTransformUtils.preCheckCast(r9.next(), IUriSharerEntity.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L9;
        ILogDepend.Companion.d(TAG, "fetchUriSharers; (contained) UriSharer: " + r10.getSharedUris());
        r8.add(r10);
        goto L9
    L20:
        return;
    }

    private final List<IUriSharable> a(Object[] r6) {
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        Object r3 = r6[r2];
        if (ZeusTransformUtils.instanceOf(r3, IUriSharable.class) == false) goto L7;
        r5.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
    }
}
