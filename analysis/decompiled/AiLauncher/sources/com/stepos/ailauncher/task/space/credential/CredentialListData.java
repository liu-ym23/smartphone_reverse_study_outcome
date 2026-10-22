package com.stepos.ailauncher.task.space.credential;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/g;", "", "", "total", "", "Lcom/stepos/ailauncher/task/space/credential/f;", DidiCardProvider.KEY_ITEMS, "<init>", "(ILjava/util/List;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.credential.g, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class CredentialListData {

    @SerializedName(DidiCardProvider.KEY_ITEMS)
    private final List<CredentialItem> items;

    @SerializedName("total")
    private final int total;

    /* JADX WARN: Multi-variable type inference failed */
    public CredentialListData() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public final List<CredentialItem> a() {
        return this.items;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CredentialListData)) {
            return false;
        }
        CredentialListData credentialListData = (CredentialListData) other;
        return this.total == credentialListData.total && kotlin.jvm.internal.p.d(this.items, credentialListData.items);
    }

    public int hashCode() {
        return (Integer.hashCode(this.total) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "CredentialListData(total=" + this.total + ", items=" + this.items + ")";
    }

    public CredentialListData(int i10, List<CredentialItem> items) {
        kotlin.jvm.internal.p.i(items, "items");
        this.total = i10;
        this.items = items;
    }

    public /* synthetic */ CredentialListData(int i10, List list, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? C1173v.m() : list);
    }
}
