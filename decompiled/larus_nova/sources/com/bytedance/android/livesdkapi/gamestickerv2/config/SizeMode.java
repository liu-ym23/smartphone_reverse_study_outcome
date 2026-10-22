package com.bytedance.android.livesdkapi.gamestickerv2.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/config/SizeMode;", "", "mode", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMode", "()Ljava/lang/String;", "UNKNOWN", "FIXED", "AUTO", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SizeMode extends Enum<SizeMode> {
    private static final /* synthetic */ SizeMode[] $VALUES = null;
    public static final SizeMode AUTO = null;
    public static final Companion Companion = null;
    public static final SizeMode FIXED = null;
    public static final SizeMode UNKNOWN = null;
    private final String mode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/config/SizeMode$Companion;", "", "()V", "strToSizeMode", "Lcom/bytedance/android/livesdkapi/gamestickerv2/config/SizeMode;", "mode", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final SizeMode strToSizeMode(String r100) {
            SizeMode[] r101 = SizeMode.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            SizeMode r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getMode(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return SizeMode.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
        SizeMode r100 = new SizeMode("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        SizeMode r101 = new SizeMode("FIXED", 1, "fixed");
        FIXED = r101;
        SizeMode r102 = new SizeMode("AUTO", 2, "auto");
        AUTO = r102;
        $VALUES = new SizeMode[]{r100, r101, r102};
        Companion = new Companion(null);
    }

    public static SizeMode valueOf(String r100) {
        return (SizeMode) a.a(SizeMode.class, r100);
    }

    public static SizeMode[] values() {
        return (SizeMode[]) $VALUES.clone();
    }

    public final String getMode() {
        return this.mode;
    }

    private SizeMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
