package com.stepos.ailauncher.taskstore.provider;

import La.H;
import Y8.j;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import t6.C5517e;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/provider/a;", "", "<init>", "()V", "", "type", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "", "TYPE_TABLE", "Ljava/util/Map;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final Map<String, Boolean> TYPE_TABLE;

    static {
        Locale locale = Locale.ROOT;
        String lowerCase = C5517e.RECORDER_TASK_TYPE.toLowerCase(locale);
        p.h(lowerCase, "toLowerCase(...)");
        Boolean bool = Boolean.TRUE;
        Pair pairA = j.a(lowerCase, bool);
        String lowerCase2 = C5517e.VOICE_SUMMARY_TASK_TYPE.toLowerCase(locale);
        p.h(lowerCase2, "toLowerCase(...)");
        Pair pairA2 = j.a(lowerCase2, bool);
        String lowerCase3 = C5517e.VOICE_ALWAYS_ON_TASK_TYPE.toLowerCase(locale);
        p.h(lowerCase3, "toLowerCase(...)");
        Pair pairA3 = j.a(lowerCase3, bool);
        String lowerCase4 = "daily_report".toLowerCase(locale);
        p.h(lowerCase4, "toLowerCase(...)");
        TYPE_TABLE = kotlin.collections.a.m(pairA, pairA2, pairA3, j.a(lowerCase4, bool));
    }

    public final boolean a(String type) {
        String lowerCase;
        String string;
        if (type == null || (string = H.D1(type).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        if (lowerCase.length() == 0) {
            return false;
        }
        return p.d(TYPE_TABLE.get(lowerCase), Boolean.TRUE);
    }
}
