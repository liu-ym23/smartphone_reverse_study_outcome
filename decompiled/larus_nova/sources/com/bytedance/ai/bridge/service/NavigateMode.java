package com.bytedance.ai.bridge.service;

import com.bytedance.ai.api.navi.AppletNaviType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/service/NavigateMode;", "", "mode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMode", "()Ljava/lang/String;", "DRIVING", "TRANSIT", "WALKING", "RIDING", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NavigateMode extends Enum<NavigateMode> {
    public static final a Companion = null;
    public static final NavigateMode DRIVING = null;
    public static final NavigateMode RIDING = null;
    public static final NavigateMode TRANSIT = null;
    public static final NavigateMode WALKING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, NavigateMode> f36102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ NavigateMode[] f36103b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36104c = null;
    private final String mode;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<NavigateMode> getEntries() {
        return f36104c;
    }

    static {
        int r100 = 0;
        NavigateMode r101 = new NavigateMode("DRIVING", 0, AppletNaviType.DRIVING);
        DRIVING = r101;
        NavigateMode r102 = new NavigateMode("TRANSIT", 1, AppletNaviType.TRANSIT);
        TRANSIT = r102;
        NavigateMode r103 = new NavigateMode("WALKING", 2, AppletNaviType.WALKING);
        WALKING = r103;
        NavigateMode r104 = new NavigateMode("RIDING", 3, AppletNaviType.RIDING);
        RIDING = r104;
        NavigateMode[] r105 = {r101, r102, r103, r104};
        f36103b = r105;
        f36104c = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
        NavigateMode[] r106 = values();
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r106.length), 16));
        int r108 = r106.length;
    L3:
        if (r100 >= r108) goto L5;
        NavigateMode r109 = r106[r100];
        r107.put(r109.mode, r109);
        r100 = r100 + 1;
        goto L3
    L5:
        f36102a = r107;
    }

    public static NavigateMode[] values() {
        return (NavigateMode[]) f36103b.clone();
    }

    public static final /* synthetic */ Map access$getModeMap$cp() {
        return f36102a;
    }

    public final String getMode() {
        return this.mode;
    }

    public static NavigateMode valueOf(String r100) {
        return (NavigateMode) r27.a.a(NavigateMode.class, r100);
    }

    public NavigateMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
