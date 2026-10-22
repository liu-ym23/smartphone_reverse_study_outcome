package com.bytedanceos.appstore.buss.cms.beta;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.appstore.buss.cms.beta.entity.BetaTemplateEntity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import k7.a;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/CmsDataWrap;", "", "", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaTemplateEntity;", ServerElements.LIST, "Lk7/a;", WsConstants.KEY_EXTRA, "<init>", "(Ljava/util/List;Lk7/a;)V", "component1", "()Ljava/util/List;", "component2", "()Lk7/a;", "copy", "(Ljava/util/List;Lk7/a;)Lcom/bytedanceos/appstore/buss/cms/beta/CmsDataWrap;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", AppInfo.SEARCH_SOURCE_EXTENAL, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getList", "Lk7/a;", "getExtra", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CmsDataWrap {

    @Nullable
    private final a extra;

    @Nullable
    private final List<BetaTemplateEntity> list;

    public CmsDataWrap(@Nullable List<BetaTemplateEntity> r10, @Nullable a r11) {
        this.list = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CmsDataWrap copy$default(CmsDataWrap r10, List r11, a r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.list;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10.getClass();
        r12 = null;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final List<BetaTemplateEntity> component1() {
        return this.list;
    }

    @Nullable
    public final a component2() {
        return null;
    }

    @NotNull
    public final CmsDataWrap copy(@Nullable List<BetaTemplateEntity> r10, @Nullable a r11) {
        return new CmsDataWrap(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CmsDataWrap) == true) goto L9;
        return false;
    L9:
        if (q.b(this.list, ((CmsDataWrap) r10).list) == true) goto L12;
        return false;
    L12:
        if (q.b(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final a getExtra() {
        return null;
    }

    @Nullable
    public final List<BetaTemplateEntity> getList() {
        return this.list;
    }

    public int hashCode() {
        List<BetaTemplateEntity> r10 = this.list;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r11 * 31;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    @NotNull
    public String toString() {
        return "CmsDataWrap(list=" + this.list + ", extra=null)";
    }
}
