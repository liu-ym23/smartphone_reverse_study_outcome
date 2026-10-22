package com.stepos.ailauncher.contract.model;

import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001$B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J>\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b#\u0010\u0012¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/contract/model/ListPage;", ExifInterface.GPS_DIRECTION_TRUE, "", "", DidiCardProvider.KEY_ITEMS, "", "nextKey", "total", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "R", "Lkotlin/Function1;", "transform", C3081a.FOCUS_MAP_NAME, "(Lp9/l;)Lcom/stepos/ailauncher/contract/model/ListPage;", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/Integer;", "component3", ChatTracker.CLICK_COPY, "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/stepos/ailauncher/contract/model/ListPage;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "Ljava/lang/Integer;", "getNextKey", "getTotal", "Companion", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ListPage<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<T> items;
    private final Integer nextKey;
    private final Integer total;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/contract/model/ListPage$Companion;", "", "<init>", "()V", "numbered", "Lcom/stepos/ailauncher/contract/model/ListPage;", ExifInterface.GPS_DIRECTION_TRUE, DidiCardProvider.KEY_ITEMS, "", "page", "", ContentDisposition.Parameters.Size, "total", "(Ljava/util/List;IILjava/lang/Integer;)Lcom/stepos/ailauncher/contract/model/ListPage;", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final <T> ListPage<T> numbered(List<? extends T> items, int page, int size, Integer total) {
            p.i(items, "items");
            if (page <= 0 || size <= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            boolean z10 = false;
            if (total == null || total.intValue() <= 0 ? items.size() >= size : page * size < total.intValue()) {
                z10 = true;
            }
            if (items.isEmpty() && z10) {
                throw new IllegalStateException("Empty page before total was reached");
            }
            return new ListPage<>(items, z10 ? Integer.valueOf(page + 1) : null, total);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListPage(List<? extends T> items, Integer num, Integer num2) {
        p.i(items, "items");
        this.items = items;
        this.nextKey = num;
        this.total = num2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListPage copy$default(ListPage listPage, List list, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = listPage.items;
        }
        if ((i10 & 2) != 0) {
            num = listPage.nextKey;
        }
        if ((i10 & 4) != 0) {
            num2 = listPage.total;
        }
        return listPage.copy(list, num, num2);
    }

    public final List<T> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getNextKey() {
        return this.nextKey;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getTotal() {
        return this.total;
    }

    public final ListPage<T> copy(List<? extends T> items, Integer nextKey, Integer total) {
        p.i(items, "items");
        return new ListPage<>(items, nextKey, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListPage)) {
            return false;
        }
        ListPage listPage = (ListPage) other;
        return p.d(this.items, listPage.items) && p.d(this.nextKey, listPage.nextKey) && p.d(this.total, listPage.total);
    }

    public final List<T> getItems() {
        return this.items;
    }

    public final Integer getNextKey() {
        return this.nextKey;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        Integer num = this.nextKey;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.total;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final <R> ListPage<R> map(InterfaceC5074l<? super T, ? extends R> transform) {
        p.i(transform, "transform");
        List<T> list = this.items;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return new ListPage<>(arrayList, this.nextKey, this.total);
    }

    public String toString() {
        return "ListPage(items=" + this.items + ", nextKey=" + this.nextKey + ", total=" + this.total + ")";
    }

    public /* synthetic */ ListPage(List list, Integer num, Integer num2, int i10, i iVar) {
        this(list, num, (i10 & 4) != 0 ? null : num2);
    }
}
