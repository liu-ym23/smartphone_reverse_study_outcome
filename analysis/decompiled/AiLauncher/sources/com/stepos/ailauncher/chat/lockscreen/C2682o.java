package com.stepos.ailauncher.chat.lockscreen;

import android.content.Intent;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatMainActivity;
import com.stepos.ailauncher.chat.wake.WakeDialogImpl;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/o;", "", "<init>", "()V", "Landroid/content/Intent;", "intent", "LY8/t;", "f", "(Landroid/content/Intent;)V", "", "c", "(Landroid/content/Intent;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "", "EXTRA_TOKEN", "Ljava/lang/String;", "Ljava/security/SecureRandom;", "random", "Ljava/security/SecureRandom;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "issued", "Ljava/util/concurrent/ConcurrentHashMap;", "TTL_MS", "J", "", "MAX_ISSUED", "I", "", "PRIVILEGED_EXTRAS", "[Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.lockscreen.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2682o {
    private static final String EXTRA_TOKEN = "chat_lock_handoff_token";
    private static final int MAX_ISSUED = 32;
    private static final long TTL_MS = 30000;
    public static final C2682o INSTANCE = new C2682o();
    private static final SecureRandom random = new SecureRandom();
    private static final ConcurrentHashMap<String, Long> issued = new ConcurrentHashMap<>();
    private static final String[] PRIVILEGED_EXTRAS = {ChatMainActivity.EXTRA_SKIP_KEYGUARD_ROUTE, ChatMainActivity.EXTRA_SEAMLESS_LOCK_HANDOFF, ChatMainActivity.EXTRA_FROM_LOCKSCREEN_WAKE, "chat_restore_lock_chat", WakeDialogImpl.EXTRA_REBIND_SESSION};

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.o$a */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((Long) ((Map.Entry) t10).getValue(), (Long) ((Map.Entry) t11).getValue());
        }
    }

    public static final boolean e(long j10, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return j10 - ((Number) it.getValue()).longValue() > 30000;
    }

    public static final CharSequence g(byte b10) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final boolean c(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(EXTRA_TOKEN)) != null) {
            d();
            Long lRemove = issued.remove(stringExtra);
            if (lRemove != null) {
                long jLongValue = lRemove.longValue();
                intent.removeExtra(EXTRA_TOKEN);
                if (SystemClock.elapsedRealtime() - jLongValue <= 30000) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void d() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ConcurrentHashMap<String, Long> concurrentHashMap = issued;
        Set<Map.Entry<String, Long>> setEntrySet = concurrentHashMap.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
        Z8.A.J(setEntrySet, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.lockscreen.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C2682o.e(jElapsedRealtime, (Map.Entry) obj));
            }
        });
        if (concurrentHashMap.size() > 32) {
            Set<Map.Entry<String, Long>> setEntrySet2 = concurrentHashMap.entrySet();
            kotlin.jvm.internal.p.h(setEntrySet2, "<get-entries>(...)");
            Iterator it = Z8.F.f1(Z8.F.c1(setEntrySet2, new a()), concurrentHashMap.size() - 32).iterator();
            while (it.hasNext()) {
                issued.remove(((Map.Entry) it.next()).getKey());
            }
        }
    }

    public final void f(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        d();
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        String strV0 = Z8.r.v0(bArr, "", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.lockscreen.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C2682o.g(((Byte) obj).byteValue());
            }
        }, 30, null);
        issued.put(strV0, Long.valueOf(SystemClock.elapsedRealtime()));
        intent.putExtra(EXTRA_TOKEN, strV0);
    }

    public final void h(Intent intent) {
        if (intent == null) {
            return;
        }
        for (String str : PRIVILEGED_EXTRAS) {
            intent.removeExtra(str);
        }
    }
}
