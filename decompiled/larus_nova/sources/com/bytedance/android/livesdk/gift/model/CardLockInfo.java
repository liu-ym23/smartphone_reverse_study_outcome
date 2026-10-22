package com.bytedance.android.livesdk.gift.model;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u001a\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u001f\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "Lvh7/c;", "", "getLockStatus", "()I", "setLockStatus", "(I)V", "getLockStatus$annotations", "()V", "lockStatus", "", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "getToast$annotations", "toast", "getReason", "setReason", "getReason$annotations", "reason", "getSchema", "getSchema$annotations", "schema", "getCellText", "getCellText$annotations", "cellText", "", "getUseCustomButtonColor", "()Z", "getUseCustomButtonColor$annotations", "useCustomButtonColor", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface CardLockInfo extends vh7.c<CardLockInfo> {
    public static final Companion Companion = null;
    public static final String sLOCKED = "locked";
    public static final String sNOT_UPLOADED = "not_uploaded";
    public static final String sREVIEWING = "reviewing";
    public static final String sREVIEW_FAILED = "review_failure";
    public static final String sUNKNOWN = "unknown";
    public static final String sUNLOCKED = "review_success";

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f126359a = null;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/CardLockInfo$Companion$LockStatus;", "", "", BaseSwitches.V, "I", "getV", "()I", "", "pbName", "Ljava/lang/String;", "getPbName", "()Ljava/lang/String;", "UNKNOWN", "LOCKED", "NOT_UPLOADED", ErrorCode.REVIEWING, "REVIEW_FAILED", "UNLOCKED", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final enum LockStatus extends Enum<LockStatus> {
            public static final LockStatus LOCKED = null;
            public static final LockStatus NOT_UPLOADED = null;
            public static final LockStatus REVIEWING = null;
            public static final LockStatus REVIEW_FAILED = null;
            public static final LockStatus UNKNOWN = null;
            public static final LockStatus UNLOCKED = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ LockStatus[] f126360a = null;
            private final String pbName;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            private final int f126361v;

            static {
                LockStatus r100 = new LockStatus("UNKNOWN", 0, 0, "unknown");
                UNKNOWN = r100;
                LockStatus r101 = new LockStatus("LOCKED", 1, 1, "locked");
                LOCKED = r101;
                LockStatus r102 = new LockStatus("NOT_UPLOADED", 2, 2, CardLockInfo.sNOT_UPLOADED);
                NOT_UPLOADED = r102;
                LockStatus r103 = new LockStatus(ErrorCode.REVIEWING, 3, 3, CardLockInfo.sREVIEWING);
                REVIEWING = r103;
                LockStatus r104 = new LockStatus("REVIEW_FAILED", 4, 4, CardLockInfo.sREVIEW_FAILED);
                REVIEW_FAILED = r104;
                LockStatus r105 = new LockStatus("UNLOCKED", 5, 5, CardLockInfo.sUNLOCKED);
                UNLOCKED = r105;
                f126360a = new LockStatus[]{r100, r101, r102, r103, r104, r105};
            }

            public static LockStatus valueOf(String r100) {
                return (LockStatus) r27.a.a(LockStatus.class, r100);
            }

            public static LockStatus[] values() {
                return (LockStatus[]) f126360a.clone();
            }

            public final String getPbName() {
                return this.pbName;
            }

            public final int getV() {
                return this.f126361v;
            }

            public LockStatus(String r100, int r101, int r102, String r103) {
                super(r100, r101);
                this.f126361v = r102;
                this.pbName = r103;
            }
        }

        public Companion() {
        }

        static {
            f126359a = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    static {
        Companion = Companion.f126359a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "cell_text")
    String getCellText();

    @FieldName(name = "lock_status")
    int getLockStatus();

    @FieldName(name = "reason")
    String getReason();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "custom_button_color")
    boolean getUseCustomButtonColor();

    @FieldName(name = "lock_status#setter")
    void setLockStatus(int r100);

    @FieldName(name = "reason#setter")
    void setReason(String r100);

    @FieldName(name = "toast#setter")
    void setToast(String r100);
}
