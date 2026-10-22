package com.bytedance.android.ec.base.api.ai.conversation;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.WeakHashMap;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ConversationContextStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, ArrayDeque<a>> f42796a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConversationContextStore f42797b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f42798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f42799b;

        public final Activity getActivity() {
            return this.f42798a.get();
        }

        public a(FragmentActivity r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            this.f42799b = r101;
            this.f42798a = new WeakReference(r100);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f42800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f42801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f42802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f42803d;

        public b(String r100, String r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            this.f42800a = r100;
            this.f42801b = r101;
            this.f42802c = r102;
            this.f42803d = r103;
        }
    }

    public ConversationContextStore() {
    }

    static {
        f42797b = new ConversationContextStore();
        f42796a = new HashMap();
    }

    public static a b(Activity r100) {
        ArrayDeque<a> r101 = f42796a.get(Integer.valueOf(r100.getTaskId()));
        a r102 = null;
        if (r101 == null) goto L20;
        ListIterator<a> r103 = r101.listIterator(r101.size());
    L6:
        if (r103.hasPrevious() == false) goto L14;
        a r104 = r103.previous();
        if (r104.getActivity() != r100) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        r102 = r104;
        goto L14
    L10:
        r105 = false;
    L14:
        return r102;
    L20:
        return null;
    }

    @JvmStatic
    public static final synchronized ConversationContext getContext(Activity r100) {
        monitor-enter(ConversationContextStore.class);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L12
        a r101 = b(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L9;
        monitor-exit(ConversationContextStore.class);
        return null;
    L9:
        b r102 = r101.f42799b;     // Catch: Throwable -> L12
        ConversationContext r103 = new ConversationContext(r102.f42800a, r102.f42801b, r102.f42802c, r102.f42803d);     // Catch: Throwable -> L12
        monitor-exit(ConversationContextStore.class);
        return r103;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized Boolean c(Activity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L10
        a r101 = b(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.f42799b.f42803d);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r102;
    L7:
        r102 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized String d(Activity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L10
        a r101 = b(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        String r102 = r101.f42799b.f42802c;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r102;
    L7:
        r102 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized String e(Activity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L10
        a r101 = b(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        String r102 = r101.f42799b.f42801b;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r102;
    L7:
        r102 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized ConversationContext f(FragmentActivity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L25
        ArrayDeque<a> r101 = f42796a.get(Integer.valueOf(r100.getTaskId()));     // Catch: Throwable -> L25
        if (r101 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if ((!r101.isEmpty()) == false) goto L13;
        if (r101.last().getActivity() != null) goto L13;
        r101.removeLast();     // Catch: Throwable -> L25
    L13:
        a r102 = r101.lastOrNull();     // Catch: Throwable -> L25
        if (r102 != null) goto L18;
        monitor-exit(this);
        return null;
    L18:
        if (r102.getActivity() != r100) goto L22;
        b r103 = r102.f42799b;     // Catch: Throwable -> L25
        ConversationContext r104 = new ConversationContext(r103.f42800a, r103.f42801b, r103.f42802c, r103.f42803d);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r104;
    L22:
        a r105 = new a(r100, r102.f42799b);     // Catch: Throwable -> L25
        r101.addLast(r105);     // Catch: Throwable -> L25
        b r106 = r105.f42799b;     // Catch: Throwable -> L25
        ConversationContext r107 = new ConversationContext(r106.f42800a, r106.f42801b, r106.f42802c, r106.f42803d);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r107;
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(final Activity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L12
        HashMap<Integer, ArrayDeque<a>> r101 = f42796a;     // Catch: Throwable -> L12
        ArrayDeque<a> r102 = r101.get(Integer.valueOf(r100.getTaskId()));     // Catch: Throwable -> L12
        if (r102 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        CollectionsKt.removeAll(r102, new ConversationContextStore$remove$1(r100));     // Catch: Throwable -> L12
        if (r102.isEmpty() == false) goto L10;
        r101.remove(Integer.valueOf(r100.getTaskId()));     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized ConversationContext h(FragmentActivity r110, AIChatSchemaParams r111) {
        monitor-enter(ConversationContextStore.class);
        Intrinsics.checkNotNullParameter(r110, "activity");     // Catch: Throwable -> L54
        WeakHashMap<Activity, Bundle> r100 = xe.a.f563310a;     // Catch: Throwable -> L54
        Bundle r101 = xe.a.a(r110);     // Catch: Throwable -> L54
        String r102 = null;
        if (r101 != null) goto L7;
    L12:
        boolean r103 = true;
    L13:
        if (r111 == null) goto L15;
        String r104 = r111.getConversationId();     // Catch: Throwable -> L54
    L16:
        boolean r105 = false;
        if (r104 != null) goto L19;
    L22:
        boolean r106 = true;
    L23:
        if (r106 == true) goto L27;
        f42797b.a(r110, r104, r111.getOriginMessageId(), r111.getOriginBcmId(), r103);     // Catch: Throwable -> L54
        ConversationContext r112 = new ConversationContext(r104, r111.getOriginMessageId(), r111.getOriginBcmId(), r103);     // Catch: Throwable -> L54
        monitor-exit(ConversationContextStore.class);
        return r112;
    L27:
        if (r101 == null) goto L29;
        String r107 = r101.getString(ConversationConstants.KEY_CONVERSATION_CID);     // Catch: Throwable -> L54
    L30:
        if (r107 != null) goto L32;
    L33:
        r105 = true;
    L34:
        if (r105 == true) goto L38;
        String r113 = r101.getString(ConversationConstants.KEY_CONVERSATION_ORIGIN_MSG_ID);     // Catch: Throwable -> L54
        String r108 = r101.getString(ConversationConstants.KEY_CONVERSATION_ORIGIN_BCM_ID);     // Catch: Throwable -> L54
        f42797b.a(r110, r107, r113, r108, r103);     // Catch: Throwable -> L54
        ConversationContext r114 = new ConversationContext(r107, r113, r108, r103);     // Catch: Throwable -> L54
        monitor-exit(ConversationContextStore.class);
        return r114;
    L38:
        ArrayDeque<a> r109 = f42796a.get(Integer.valueOf(r110.getTaskId()));     // Catch: Throwable -> L54
        if (r109 != null) goto L41;
    L46:
        if (r111 == null) goto L48;
        String r115 = r111.getOriginMessageId();     // Catch: Throwable -> L54
    L49:
        if (r111 == null) goto L51;
        r102 = r111.getOriginBcmId();     // Catch: Throwable -> L54
    L51:
        String r116 = r102;
        f42797b.a(r110, "", r115, r116, r103);     // Catch: Throwable -> L54
        ConversationContext r117 = new ConversationContext("", r115, r116, r103);     // Catch: Throwable -> L54
        monitor-exit(ConversationContextStore.class);
        return r117;
    L48:
        r115 = null;
        goto L49
    L41:
        if ((!r109.isEmpty()) != true) goto L46;
        ConversationContext r118 = f42797b.f(r110);     // Catch: Throwable -> L54
        if (r118 == null) goto L46;
        monitor-exit(ConversationContextStore.class);
        return r118;
    L32:
        if (StringsKt.isBlank(r107) == false) goto L34;
    L29:
        r107 = null;
        goto L30
    L19:
        if (StringsKt.isBlank(r104) == true) goto L22;
        r106 = false;
        goto L23
    L15:
        r104 = null;
        goto L16
    L7:
        if (r101.containsKey(ConversationConstants.KEY_FIRST_MSG) == false) goto L9;
        Bundle r119 = r101;
    L10:
        if (r119 == null) goto L12;
        r103 = r119.getBoolean(ConversationConstants.KEY_FIRST_MSG);     // Catch: Throwable -> L54
        goto L13
    L9:
        r119 = null;
    L54:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(FragmentActivity r100, String r101, String r102, String r103, boolean r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r101, "cid");     // Catch: Throwable -> L29
        HashMap<Integer, ArrayDeque<a>> r104 = f42796a;     // Catch: Throwable -> L29
        Integer r105 = Integer.valueOf(r100.getTaskId());     // Catch: Throwable -> L29
        ArrayDeque<a> r106 = r104.get(r105);     // Catch: Throwable -> L29
        if (r106 != null) goto L6;
        r106 = new ArrayDeque();     // Catch: Throwable -> L29
        r104.put(r105, r106);     // Catch: Throwable -> L29
    L6:
        ArrayDeque<a> r107 = r106;     // Catch: Throwable -> L29
        Activity r108 = null;
        if ((!StringsKt.isBlank(r101)) == false) goto L18;
        ListIterator<a> r109 = r107.listIterator(r107.size());     // Catch: Throwable -> L29
    L10:
        if (r109.hasPrevious() == false) goto L14;
        a r111 = r109.previous();     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r111.f42799b.f42800a, r101) == false) goto L10;
    L15:
        a r112 = r111;     // Catch: Throwable -> L29
        if (r112 == null) goto L18;
        b r113 = r112.f42799b;     // Catch: Throwable -> L29
    L19:
        a r114 = r107.lastOrNull();     // Catch: Throwable -> L29
        if (r114 == null) goto L22;
        r108 = r114.getActivity();     // Catch: Throwable -> L29
    L22:
        if (r108 != r100) goto L24;
        r107.removeLast();     // Catch: Throwable -> L29
    L24:
        if (r113 != null) goto L26;
        r113 = new b(r101, r102, r103, r110);     // Catch: Throwable -> L29
    L26:
        r107.addLast(new a(r100, r113));     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L14:
        r111 = null;
    L18:
        r113 = null;
    L29:
        th = move-exception;
        throw th;
    }
}
