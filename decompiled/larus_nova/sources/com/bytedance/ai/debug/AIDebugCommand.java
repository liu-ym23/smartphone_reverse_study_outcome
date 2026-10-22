package com.bytedance.ai.debug;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AIDebugCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Source f36181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f36182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f36183c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/debug/AIDebugCommand$Source;", "", "<init>", "(Ljava/lang/String;I)V", "DEVTOOL_ADB_BROADCAST", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source DEVTOOL_ADB_BROADCAST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f36184a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f36185b = null;

        public static EnumEntries<Source> getEntries() {
            return f36185b;
        }

        static {
            Source r100 = new Source();
            DEVTOOL_ADB_BROADCAST = r100;
            Source[] r101 = {r100};
            f36184a = r101;
            f36185b = EnumEntriesKt.enumEntries(r101);
        }

        public Source() {
            super("DEVTOOL_ADB_BROADCAST", 0);
        }

        public static Source[] values() {
            return (Source[]) f36184a.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIDebugCommand) == true) goto L8;
        return false;
    L8:
        AIDebugCommand r101 = (AIDebugCommand) r100;
        if (this.f36181a == r101.f36181a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f36182b, r101.f36182b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f36183c, r101.f36183c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f36181a.hashCode() * 31) + this.f36182b.hashCode()) * 31) + this.f36183c.hashCode();
    }

    public final String toString() {
        return "AIDebugCommand(source=" + this.f36181a + ", action=" + this.f36182b + ", params=" + this.f36183c + ')';
    }

    public AIDebugCommand(Source r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter("com.bytedance.applet.SET_APPLET_DEBUG_HOST", "action");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f36181a = r100;
        this.f36182b = "com.bytedance.applet.SET_APPLET_DEBUG_HOST";
        this.f36183c = r101;
    }
}
