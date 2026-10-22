package com.obric.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OldOPageStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/ui/StatusSpec;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EMPTY", "LOADING", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum StatusSpec extends Enum<StatusSpec> {
    private static final /* synthetic */ StatusSpec[] $VALUES = null;
    public static final Companion Companion = null;
    public static final StatusSpec EMPTY = null;
    public static final StatusSpec LOADING = null;
    private final int value;

    /* JADX INFO: compiled from: OldOPageStatus.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/ui/StatusSpec$Companion;", "", "()V", "fromValue", "Lcom/obric/ui/StatusSpec;", "value", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final StatusSpec fromValue(int r6) {
            StatusSpec[] r5 = StatusSpec.values();
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            StatusSpec r3 = r5[r2];
            if (r3.getValue() != r6) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L12;
            r2 = r2 + 1;
        L12:
            if (r3 == null) goto L14;
            return r3;
        L14:
            return StatusSpec.EMPTY;
        L7:
            r4 = false;
            goto L8
        L11:
            r3 = null;
            goto L12
        }
    }

    private static final /* synthetic */ StatusSpec[] $values() {
        return new StatusSpec[]{EMPTY, LOADING};
    }

    public static StatusSpec valueOf(String r1) {
        return (StatusSpec) Enum.valueOf(StatusSpec.class, r1);
    }

    public static StatusSpec[] values() {
        return (StatusSpec[]) $VALUES.clone();
    }

    private StatusSpec(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        EMPTY = new StatusSpec("EMPTY", 0, 0);
        LOADING = new StatusSpec("LOADING", 1, 1);
        $VALUES = $values();
        Companion = new Companion(null);
    }
}
