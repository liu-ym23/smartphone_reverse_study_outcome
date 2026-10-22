package com.bytedance.android.sdk.bdticketguard.init;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/init/InitTask;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "InitTee", "InitRee", "InitEncryption", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final enum InitTask extends Enum<InitTask> {
    public static final a Companion = null;
    public static final InitTask InitEncryption = null;
    public static final InitTask InitRee = null;
    public static final InitTask InitTee = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InitTask[] f163750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, InitTask> f163751b = null;
    private final String type;

    public static final class a {
        public a() {
        }
    }

    static {
        int r100 = 0;
        InitTask r101 = new InitTask("InitTee", 0, "tee");
        InitTee = r101;
        InitTask r102 = new InitTask("InitRee", 1, "ree");
        InitRee = r102;
        InitTask r103 = new InitTask("InitEncryption", 2, "encryption");
        InitEncryption = r103;
        f163750a = new InitTask[]{r101, r102, r103};
        Companion = new a();
        InitTask[] r104 = values();
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r104.length), 16));
        int r106 = r104.length;
    L3:
        if (r100 >= r106) goto L5;
        InitTask r107 = r104[r100];
        r105.put(r107.type, r107);
        r100 = r100 + 1;
        goto L3
    L5:
        f163751b = r105;
    }

    public static InitTask valueOf(String r100) {
        return (InitTask) r27.a.a(InitTask.class, r100);
    }

    public static InitTask[] values() {
        return (InitTask[]) f163750a.clone();
    }

    public static final /* synthetic */ Map access$getStatusMap$cp() {
        return f163751b;
    }

    public final String getType() {
        return this.type;
    }

    public InitTask(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
