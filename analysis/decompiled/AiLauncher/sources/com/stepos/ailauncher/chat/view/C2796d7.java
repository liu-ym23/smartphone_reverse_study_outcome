package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.model.ListPage;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u001d\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0016B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\u0004\b\u001d\u0010\u0007R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR0\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R(\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010(\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R(\u0010,\u001a\u0004\u0018\u00010\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R$\u00100\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b0\u0010)\u001a\u0004\b1\u0010+R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010)¨\u00065"}, d2 = {"Lcom/stepos/ailauncher/chat/view/d7;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function1;", "", "keyOf", "<init>", "(Lp9/l;)V", "", "firstKey", "", "preview", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Integer;Ljava/util/List;)V", "Lcom/stepos/ailauncher/chat/view/d7$a;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/chat/view/d7$a;", "request", "Lcom/stepos/ailauncher/contract/model/ListPage;", "page", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/view/d7$a;Lcom/stepos/ailauncher/contract/model/ListPage;)Z", "", "cause", "c", "(Lcom/stepos/ailauncher/chat/view/d7$a;Ljava/lang/Throwable;)Z", "predicate", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lp9/l;", UxipConstants.f30680s, DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "f", "()Ljava/util/List;", "nextKey", "Ljava/lang/Integer;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/Integer;", ChatTracker.PREVIEW_LOADING, "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "error", "Ljava/lang/Throwable;", "e", "()Ljava/lang/Throwable;", "completed", Const.INTENT_KEY_UMID, HomeGestureEligibilityContract.EXTRA_GENERATION, "I", AMapLocationStaticsEntity.FIRST_LOCATE, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.d7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2796d7<T> {
    private boolean completed;
    private Throwable error;
    private boolean first;
    private int generation;
    private List<? extends T> items;
    private final InterfaceC5074l<T, String> keyOf;
    private boolean loading;
    private Integer nextKey;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/view/d7$a;", "", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "key", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.d7$a, reason: from toString */
    public static final /* data */ class Request {
        private final int generation;
        private final int key;

        public Request(int i10, int i11) {
            this.generation = i10;
            this.key = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getGeneration() {
            return this.generation;
        }

        /* renamed from: b, reason: from getter */
        public final int getKey() {
            return this.key;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Request)) {
                return false;
            }
            Request request = (Request) other;
            return this.generation == request.generation && this.key == request.key;
        }

        public int hashCode() {
            return (Integer.hashCode(this.generation) * 31) + Integer.hashCode(this.key);
        }

        public String toString() {
            return "Request(generation=" + this.generation + ", key=" + this.key + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2796d7(InterfaceC5074l<? super T, String> keyOf) {
        kotlin.jvm.internal.p.i(keyOf, "keyOf");
        this.keyOf = keyOf;
        this.items = C1173v.m();
        this.first = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(C2796d7 c2796d7, Integer num, List list, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = C1173v.m();
        }
        c2796d7.j(num, list);
    }

    public final boolean a(Request request, ListPage<T> page) {
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(page, "page");
        if (request.getGeneration() != this.generation) {
            return false;
        }
        Integer nextKey = page.getNextKey();
        if (nextKey != null && nextKey.intValue() <= request.getKey()) {
            throw new IllegalArgumentException("Pagination cursor did not advance");
        }
        List listS0 = Z8.F.S0(this.first ? C1173v.m() : this.items, page.getItems());
        InterfaceC5074l<T, String> interfaceC5074l = this.keyOf;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t10 : listS0) {
            if (hashSet.add(interfaceC5074l.invoke(t10))) {
                arrayList.add(t10);
            }
        }
        this.items = arrayList;
        this.first = false;
        Integer nextKey2 = page.getNextKey();
        this.nextKey = nextKey2;
        this.loading = false;
        this.error = null;
        this.completed = nextKey2 == null;
        return true;
    }

    public final Request b() {
        Integer num = this.nextKey;
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        if (this.loading) {
            return null;
        }
        this.loading = true;
        this.error = null;
        return new Request(this.generation, iIntValue);
    }

    public final boolean c(Request request, Throwable cause) {
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(cause, "cause");
        if (request.getGeneration() != this.generation) {
            return false;
        }
        this.loading = false;
        this.error = cause;
        return true;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getCompleted() {
        return this.completed;
    }

    /* renamed from: e, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    public final List<T> f() {
        return this.items;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getLoading() {
        return this.loading;
    }

    /* renamed from: h, reason: from getter */
    public final Integer getNextKey() {
        return this.nextKey;
    }

    public final void i(InterfaceC5074l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.p.i(predicate, "predicate");
        List<? extends T> list = this.items;
        ArrayList arrayList = new ArrayList();
        for (T t10 : list) {
            if (!predicate.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        this.items = arrayList;
    }

    public final void j(Integer firstKey, List<? extends T> preview) {
        kotlin.jvm.internal.p.i(preview, "preview");
        this.generation++;
        InterfaceC5074l<T, String> interfaceC5074l = this.keyOf;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t10 : preview) {
            if (hashSet.add(interfaceC5074l.invoke(t10))) {
                arrayList.add(t10);
            }
        }
        this.items = arrayList;
        this.nextKey = firstKey;
        this.loading = false;
        this.error = null;
        this.completed = false;
        this.first = true;
    }
}
