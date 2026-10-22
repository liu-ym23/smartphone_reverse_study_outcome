package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen;

import com.bytedance.android.livesdk.config.cw;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jg1.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/chatroom/clearscreen/ClearScreenManagerAbility;", "", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/chatroom/clearscreen/IClearScreenManagerFactory;", "factory", "", "setFactory", "", "uniqueId", "Ljg1/b;", "getInstance", "removeInstance", "DEFAULT_CLEAR_SCREEN_UNIQUE_ID", "Ljava/lang/String;", "", "INSTANCE_MAP", "Ljava/util/Map;", "mFactory", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/chatroom/clearscreen/IClearScreenManagerFactory;", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClearScreenManagerAbility {
    public static final String DEFAULT_CLEAR_SCREEN_UNIQUE_ID = "ClearScreenManagerAbility_SSS_111";
    public static final ClearScreenManagerAbility INSTANCE = null;
    private static final Map<String, b> INSTANCE_MAP = null;
    private static IClearScreenManagerFactory mFactory;

    private ClearScreenManagerAbility() {
    }

    static {
        INSTANCE = new ClearScreenManagerAbility();
        INSTANCE_MAP = new ConcurrentHashMap();
    }

    public final b getInstance(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        String r102 = DEFAULT_CLEAR_SCREEN_UNIQUE_ID;
    L11:
        Map<String, b> r103 = INSTANCE_MAP;
        b r104 = r103.get(r102);
        if (r104 == null) goto L14;
        return r104;
    L14:
        monitor-enter(b.class);
        b r105 = r103.get(r102);     // Catch: Throwable -> L26
        if (r105 != null) goto L22;
        IClearScreenManagerFactory r106 = mFactory;     // Catch: Throwable -> L26
        if (r106 == null) goto L20;
        b r107 = r106.create(r100);     // Catch: Throwable -> L26
    L21:
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L26
        r103.put(r102, r107);     // Catch: Throwable -> L26
    L23:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(b.class);
        return r107;
    L20:
        r107 = null;
        goto L21
    L22:
        r107 = r105;
    L26:
        th = move-exception;
        throw th;
    L10:
        r102 = r100;
        goto L11
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void removeInstance(String r100) {
        if (cw.f119983a.getValue().booleanValue() == true) goto L5;
    L7:
        Map<String, b> r101 = INSTANCE_MAP;
        if (r101 == null) goto L12;
        TypeIntrinsics.asMutableMap(r101).remove(r100);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L5:
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L7;
        r100 = DEFAULT_CLEAR_SCREEN_UNIQUE_ID;
        goto L7
    }

    public final void setFactory(IClearScreenManagerFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        if (mFactory != null) goto L6;
        mFactory = r100;
        return;
    }
}
