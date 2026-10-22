package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECJumpDestination;", "Ljava/io/Serializable;", "", "blank", "I", "getBlank", "()I", "setBlank", "(I)V", "button", "getButton", "setButton", "", "skipCheck", "Z", "getSkipCheck", "()Z", "setSkipCheck", "(Z)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECJumpDestination implements Serializable {
    public static final a Companion = null;
    public static final int DEST_AUCTION = 3;
    public static final int DEST_DETAIL = 0;
    public static final int DEST_DIRECTLY_JUMP = 6;
    public static final int DEST_DO_NOTHING = 9;
    public static final int DEST_FIND_SIMILAR = 8;
    public static final int DEST_LOTTERY = 4;
    public static final int DEST_ONLY_CHECK = 7;
    public static final int DEST_ORDER = 2;
    public static final int DEST_RESERVATION = 5;
    public static final int DEST_SKU = 1;
    public static final int MATCHING = 10;

    @SerializedName("blank")
    private int blank;

    @SerializedName("button")
    private int button;

    @SerializedName("skip_check")
    private boolean skipCheck;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECJumpDestination() {
    }

    public final int getBlank() {
        return this.blank;
    }

    public final int getButton() {
        return this.button;
    }

    public final boolean getSkipCheck() {
        return this.skipCheck;
    }

    public final void setBlank(int r100) {
        this.blank = r100;
    }

    public final void setButton(int r100) {
        this.button = r100;
    }

    public final void setSkipCheck(boolean r100) {
        this.skipCheck = r100;
    }
}
