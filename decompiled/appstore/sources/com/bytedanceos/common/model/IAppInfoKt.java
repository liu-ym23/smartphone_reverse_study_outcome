package com.bytedanceos.common.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0004"}, d2 = {"filter", "", "Lcom/bytedanceos/common/model/AppInfo;", "existList", "appstorecommon_sysapp_updateRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIAppInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IAppInfo.kt\ncom/bytedanceos/common/model/IAppInfoKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n766#2:24\n857#2:25\n858#2:27\n1#3:26\n*S KotlinDebug\n*F\n+ 1 IAppInfo.kt\ncom/bytedanceos/common/model/IAppInfoKt\n*L\n17#1:24\n17#1:25\n17#1:27\n*E\n"})
public final class IAppInfoKt {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final List<AppInfo> filter(@NotNull List<? extends AppInfo> r10, @NotNull List<? extends AppInfo> r11) {
        q.g(r10, "<this>");
        q.g(r11, "existList");
        if (r10.isEmpty() == false) goto L6;
        return r10;
    L6:
        if (r11.isEmpty() == false) goto L8;
        return r10;
    L8:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L10:
        if (r13.hasNext() == false) goto L21;
        Object r14 = r13.next();
        AppInfo r15 = (AppInfo) r14;
        Iterator<T> r16 = r11.iterator();
    L13:
        if (r16.hasNext() == false) goto L17;
        Object r17 = r16.next();
        if (q.b(((AppInfo) r17).appPackageName, r15.appPackageName) == false) goto L13;
    L18:
        if (r17 != null) goto L10;
        r12.add(r14);
        goto L10
    L17:
        r17 = null;
        goto L18
    L21:
        if (r12.size() != r10.size()) goto L23;
        return r10;
    L23:
        return r12;
    }
}
