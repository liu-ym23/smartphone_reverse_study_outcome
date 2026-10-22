package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<T> implements i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public Gson f63916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f63917b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.state.a$a, reason: collision with other inner class name */
    public static final class C1050a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f63918a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C1050a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f63918a, ((C1050a) r100).f63918a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f63918a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "NullableData(data=" + this.f63918a + ")";
        }

        public C1050a(T r100) {
            this.f63918a = r100;
        }
    }

    public abstract Object b();

    public abstract i.f<T> d();

    private a() {
        BrowserServiceImpl.Companion.getClass();
        this.f63916a = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).f540216i.get();
        this.f63916a = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a().f540207a.f540216i.get();
        this.f63917b = '.';
    }

    public a<T> g() {
        Object r100 = b();
        if ((r100 instanceof JsonElement) == false) goto L5;
        JsonElement r101 = (JsonElement) r100;
    L10:
        return new e(this, r100, r101);
    L5:
        Gson r102 = this.f63916a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("gson");
    L8:
        r101 = GsonProtectorUtils.toJsonTree(r102, r100);
        goto L10
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.c
    public final String getKey() {
        return d().a();
    }

    public char c() {
        return this.f63917b;
    }

    public /* synthetic */ a(int r100) {
        this();
    }

    public JsonElement e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = b();
        if ((r101 instanceof JsonElement) == false) goto L5;
        JsonElement r102 = (JsonElement) r101;
    L10:
        if (r102.isJsonObject() == true) goto L13;
        return r102;
    L13:
        return f(r100, r102);
    L5:
        Gson r103 = this.f63916a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("gson");
    L8:
        r102 = GsonProtectorUtils.toJsonTree(r103, r101);
        goto L10
    }

    public final JsonElement f(String r100, JsonElement r110) {
        Intrinsics.checkNotNullParameter(r100, "keyParam");
        Intrinsics.checkNotNullParameter(r110, "element");
        int r101 = 0;
        List r102 = CollectionsKt.drop(StringsKt.split$default(r100, new char[]{c()}, false, 0, 6, null), 1);
        if (r102.isEmpty() == false) goto L5;
        return r110;
    L5:
        JsonObject r103 = new JsonObject();
        Iterator<T> r104 = r102.iterator();
        JsonObject r105 = r103;
    L7:
        if (r104.hasNext() == false) goto L20;
        T r106 = r104.next();
        int r107 = r101 + 1;
        if (r101 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        String r108 = (String) r106;
        if (r110.isJsonObject() == false) goto L14;
        r110 = r110.getAsJsonObject().get(r108);
    L16:
        if (r101 != (r102.size() - 1)) goto L18;
        r105.getAsJsonObject().add(r108, r110);
    L19:
        r101 = r107;
        goto L7
    L18:
        JsonObject r109 = new JsonObject();
        r105.getAsJsonObject().add(r108, r109);
        Unit r111 = Unit.INSTANCE;
        r105 = r109;
        goto L19
    L14:
        r110 = JsonNull.INSTANCE;
        goto L16
    L20:
        return r103;
    }
}
