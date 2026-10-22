package com.android.ttcjpaysdk.thirdparty.voiceprint.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintOperation;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OPEN", "VERIFY", "UPDATE", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum VoicePrintOperation extends Enum<VoicePrintOperation> {
    private static final /* synthetic */ VoicePrintOperation[] $VALUES = null;
    public static final Companion Companion = null;
    public static final VoicePrintOperation OPEN = null;
    public static final VoicePrintOperation UPDATE = null;
    public static final VoicePrintOperation VERIFY = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintOperation$Companion;", "", "()V", "fromValue", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintOperation;", "value", "", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final VoicePrintOperation fromValue(String r100) {
            int r101 = 0;
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L10:
            if (r102 == false) goto L12;
            return null;
        L12:
            VoicePrintOperation[] r103 = VoicePrintOperation.values();
            int r104 = r103.length;
        L13:
            if (r101 >= r104) goto L21;
            VoicePrintOperation r105 = r103[r101];
            if (Intrinsics.areEqual(r105.getValue(), r100) == true) goto L18;
            r101 = r101 + 1;
            goto L13
        L18:
            return r105;
        L21:
            return null;
        L5:
            if (StringsKt.isBlank(r100) == true) goto L8;
            r102 = false;
            goto L10
        }
    }

    private static final /* synthetic */ VoicePrintOperation[] $values() {
        return new VoicePrintOperation[]{OPEN, VERIFY, UPDATE};
    }

    public static VoicePrintOperation valueOf(String r100) {
        return (VoicePrintOperation) a.a(VoicePrintOperation.class, r100);
    }

    public static VoicePrintOperation[] values() {
        return (VoicePrintOperation[]) $VALUES.clone();
    }

    static {
        OPEN = new VoicePrintOperation("OPEN", 0, "open");
        VERIFY = new VoicePrintOperation("VERIFY", 1, "verify");
        UPDATE = new VoicePrintOperation("UPDATE", 2, "update");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getValue() {
        return this.value;
    }

    private VoicePrintOperation(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
