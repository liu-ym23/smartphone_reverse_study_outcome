package com.stepos.ailauncher.chat.util;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.util.n;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0014BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u000f\u0010\u000eR#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/util/n;", "", "", "justNow", "yesterday", "Lkotlin/Function1;", "", "minutesAgo", "hoursAgo", "daysAgo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lp9/l;Lp9/l;Lp9/l;)V", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "e", "Lp9/l;", Const.INTENT_KEY_UMID, "()Lp9/l;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final InterfaceC5074l<Integer, String> daysAgo;
    private final InterfaceC5074l<Integer, String> hoursAgo;
    private final String justNow;
    private final InterfaceC5074l<Integer, String> minutesAgo;
    private final String yesterday;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/util/n$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/chat/util/n;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)Lcom/stepos/ailauncher/chat/util/n;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.util.n$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final String e(Context context, int i10) {
            String string = context.getString(R$string.relative_time_minutes_ago, Integer.valueOf(i10));
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }

        public static final String f(Context context, int i10) {
            String string = context.getString(R$string.relative_time_hours_ago, Integer.valueOf(i10));
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }

        public static final String g(Context context, int i10) {
            String string = context.getString(R$string.relative_time_days_ago, Integer.valueOf(i10));
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }

        public final n d(final Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            String string = context.getString(R$string.relative_time_just_now);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            String string2 = context.getString(R$string.relative_time_yesterday);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return new n(string, string2, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.util.k
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return n.Companion.e(context, ((Integer) obj).intValue());
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.util.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return n.Companion.f(context, ((Integer) obj).intValue());
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.util.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return n.Companion.g(context, ((Integer) obj).intValue());
                }
            });
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(String justNow, String yesterday, InterfaceC5074l<? super Integer, String> minutesAgo, InterfaceC5074l<? super Integer, String> hoursAgo, InterfaceC5074l<? super Integer, String> daysAgo) {
        kotlin.jvm.internal.p.i(justNow, "justNow");
        kotlin.jvm.internal.p.i(yesterday, "yesterday");
        kotlin.jvm.internal.p.i(minutesAgo, "minutesAgo");
        kotlin.jvm.internal.p.i(hoursAgo, "hoursAgo");
        kotlin.jvm.internal.p.i(daysAgo, "daysAgo");
        this.justNow = justNow;
        this.yesterday = yesterday;
        this.minutesAgo = minutesAgo;
        this.hoursAgo = hoursAgo;
        this.daysAgo = daysAgo;
    }

    public final InterfaceC5074l<Integer, String> a() {
        return this.daysAgo;
    }

    public final InterfaceC5074l<Integer, String> b() {
        return this.hoursAgo;
    }

    /* renamed from: c, reason: from getter */
    public final String getJustNow() {
        return this.justNow;
    }

    public final InterfaceC5074l<Integer, String> d() {
        return this.minutesAgo;
    }

    /* renamed from: e, reason: from getter */
    public final String getYesterday() {
        return this.yesterday;
    }
}
