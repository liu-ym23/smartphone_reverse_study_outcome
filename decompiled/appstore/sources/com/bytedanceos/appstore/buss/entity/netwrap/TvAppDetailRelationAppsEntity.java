package com.bytedanceos.appstore.buss.entity.netwrap;

import androidx.annotation.WorkerThread;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.ErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005H\u0087@¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppsEntity;", "", "name", "", "category", "", "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppWrapEntity;", "(Ljava/lang/String;Ljava/util/List;)V", "getCategory", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "getList", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppDetailWrap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailWrap.kt\ncom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppsEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1855#2,2:87\n*S KotlinDebug\n*F\n+ 1 AppDetailWrap.kt\ncom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailRelationAppsEntity\n*L\n32#1:87,2\n*E\n"})
public final class TvAppDetailRelationAppsEntity {

    @Nullable
    private final List<TvAppDetailRelationAppWrapEntity> category;

    @Nullable
    private final String name;

    public TvAppDetailRelationAppsEntity(@Nullable String r10, @Nullable List<TvAppDetailRelationAppWrapEntity> r11) {
        this.name = r10;
        this.category = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TvAppDetailRelationAppsEntity copy$default(TvAppDetailRelationAppsEntity r10, String r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.name;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.category;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final List<TvAppDetailRelationAppWrapEntity> component2() {
        return this.category;
    }

    @NotNull
    public final TvAppDetailRelationAppsEntity copy(@Nullable String r10, @Nullable List<TvAppDetailRelationAppWrapEntity> r11) {
        return new TvAppDetailRelationAppsEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppDetailRelationAppsEntity) == true) goto L8;
        return false;
    L8:
        TvAppDetailRelationAppsEntity r11 = (TvAppDetailRelationAppsEntity) r10;
        if (q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (q.b(this.category, r11.category) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final List<TvAppDetailRelationAppWrapEntity> getCategory() {
        return this.category;
    }

    @WorkerThread
    @Nullable
    public final Object getList(@NotNull Continuation<? super List<AppEntityWrap>> r20) {
        ArrayList r10 = new ArrayList();
        List<TvAppDetailRelationAppWrapEntity> r11 = this.category;
        if (r11 == null) goto L21;
        Iterator<T> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L21;
        TvAppDetailRelationAppWrapEntity r13 = (TvAppDetailRelationAppWrapEntity) r12.next();
        List<CommonAppEntity> r14 = r13.getApps();
        if (r14 == null) goto L6;
        if (r14.isEmpty() == true) goto L6;
        if (r13.getCategory() != null) goto L14;
        String r15 = r13.getName();
        if (r15 == null) goto L6;
        if (o.r(r15) == true) goto L6;
        r10.add(new AppEntityWrap("安装 \"" + r13.getName() + "\" 的用户还喜欢", null, null, null, r14, null, null, null, null, 0, 0, null, null, 8174, null));
        goto L6
    L14:
        r10.add(new AppEntityWrap(TokenParser.DQUOTE + r13.getCategory().getName() + "\" 其他热门应用", null, null, null, r14, null, null, r13.getCategory().getId(), null, 0, 0, null, null, ErrorCode.EventTask.REPEATTYPE_YEARLY_PARAMS_ERROR, null));
    L21:
        return r10;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String r10 = this.name;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        List<TvAppDetailRelationAppWrapEntity> r14 = this.category;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "TvAppDetailRelationAppsEntity(name=" + this.name + ", category=" + this.category + ')';
    }
}
