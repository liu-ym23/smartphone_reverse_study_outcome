package com.bytedance.android.livesdk.livecommerce.oldflash;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/InputArgs;", "Ljava/io/Serializable;", "", "hint", "Ljava/lang/String;", "getHint", "()Ljava/lang/String;", "content", "getContent", "autoGenTitle", "getAutoGenTitle", "", RemoteMessageConst.INPUT_TYPE, "I", "getInputType", "()I", "setInputType", "(I)V", "label", "getLabel", "inputLimitHigher", "getInputLimitHigher", "setInputLimitHigher", "inputLimitLower", "getInputLimitLower", "setInputLimitLower", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/n;", "inputToastHigher", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/n;", "getInputToastHigher", "()Lcom/bytedance/android/livesdk/livecommerce/oldflash/n;", "inputToastLower", "getInputToastLower", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILcom/bytedance/android/livesdk/livecommerce/oldflash/n;Lcom/bytedance/android/livesdk/livecommerce/oldflash/n;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputArgs implements Serializable {
    private final String autoGenTitle;
    private final String content;
    private final String hint;
    private int inputLimitHigher;
    private int inputLimitLower;
    private final n inputToastHigher;
    private final n inputToastLower;
    private int inputType;
    private final String label;

    public InputArgs() {
        this(null, null, null, 0, null, 0, 0, null, null, 511, null);
    }

    public final String getAutoGenTitle() {
        return this.autoGenTitle;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getInputLimitHigher() {
        return this.inputLimitHigher;
    }

    public final int getInputLimitLower() {
        return this.inputLimitLower;
    }

    public final n getInputToastHigher() {
        return this.inputToastHigher;
    }

    public final n getInputToastLower() {
        return this.inputToastLower;
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setInputLimitHigher(int r100) {
        this.inputLimitHigher = r100;
    }

    public final void setInputLimitLower(int r100) {
        this.inputLimitLower = r100;
    }

    public final void setInputType(int r100) {
        this.inputType = r100;
    }

    public InputArgs(String r100, String r101, String r102, int r103, String r104, int r105, int r106, n r107, n r108) {
        this.hint = r100;
        this.content = r101;
        this.autoGenTitle = r102;
        this.inputType = r103;
        this.label = r104;
        this.inputLimitHigher = r105;
        this.inputLimitLower = r106;
        this.inputToastHigher = r107;
        this.inputToastLower = r108;
        if (r105 > 0) goto L5;
        this.inputLimitHigher = 20;
    L5:
        if (r106 >= 0) goto L13;
        int r109 = 1;
        if (r103 == 0) goto L11;
        if (r103 == 1) goto L11;
        r109 = 0;
    L11:
        this.inputLimitLower = r109;
        return;
    }

    public /* synthetic */ InputArgs(String r110, String r111, String r112, int r113, String r114, int r115, int r116, n r117, n r118, int r210, DefaultConstructorMarker r211) {
        n r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r104 = 2;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r106 = 20;
    L27:
        if ((r210 & 64) == 0) goto L29;
        int r107 = Integer.MIN_VALUE;
    L31:
        if ((r210 & 128) == 0) goto L33;
        n r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
